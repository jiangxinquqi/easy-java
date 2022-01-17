#!/bin/bash
# 功能简介：springboot脚本文件
# 参数简介：
#    $1:操作名称
#     sh boot.sh start : 启动应用
#     sh boot.sh status: 查看状态
#     sh boot.sh stop  : 停止应用
#     sh boot.sh stop  : 重启应用

BIN_DIR=`dirname $0`
DEPLOY_DIR=`cd "$BIN_DIR"/..; pwd`

LOGGING_PATH=$DEPLOY_DIR/logs
CATALINA_OUT=$LOGGING_PATH/catalina.out

SPRING_CONFIG_LOCATION=$DEPLOY_DIR/config
LOGGING_CONFIG=$DEPLOY_DIR/config/logback-spring.xml

# SERVER_NAME 应用名称
# SERVER_PORT 应用端口
SERVER_NAME='easy-springboot-deploy-assembly.jar'
SERVER_PORT=8080

# -Xverify:none 禁用字节码验证
# -XX:+DisableExplicitGC 禁止手动调用gc，System.gc()
# -Djava.awt.headless=true 模拟外设，键盘，鼠标
JAVA_OPTS="-server -Xms512m -Xmx512m -Xmn256m -Xverify:none -XX:+DisableExplicitGC -Djava.awt.headless=true"
REMOTE_DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9000"
JVM_HEAP_DUMP_CONFIG="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$DEPLOY_DIR/dump"

# -Dlogging.config 日志文件配置
# -Dlogging.path 日志文件的位置
# -Dspring.config.location 指定spring配置文件
# -Dspring.config.additional-location 额外的spring配置文件
APP_ENV="-Dlogging.path=$LOGGING_PATH -Dlogging.config=$LOGGING_CONFIG -Dspring.config.location=$SPRING_CONFIG_LOCATION"

if [ "$1" = "" ];
then
    echo -e "\033[0;31m 请输入操作名 \033[0m  \033[0;34m {start|stop|restart|status} \033[0m"
    exit 1
fi

if [ ! -d $LOGGING_PATH ]; then
  mkdir $LOGGING_PATH
fi
if [ ! -f $CATALINA_OUT ]; then
  touch $CATALINA_OUT
fi

function start()
{

    # 检测应用是否已经启动
    PIDS=`ps -ef | grep java | grep "$SERVER_NAME" |awk '{print $2}'`
    if [ -n "$PIDS" ]; then
      echo -e "\033[31m ERROR: The $SERVER_NAME already started! \033[0m"
      echo -e "\033[31m PID: $PIDS \033[0m"
      exit 1
    fi

    # 检测端口号是否被占用
    if [ -n "$SERVER_PORT" ]; then
      SERVER_PORT_COUNT=`netstat -tln | grep $SERVER_PORT | wc -l`
      if [ $SERVER_PORT_COUNT -gt 0 ]; then
        echo -e "\033[31m ERROR: The $SERVER_NAME port $SERVER_PORT already used! \033[0m"
        exit 1
      fi
    fi

    echo -e "Starting the $SERVER_NAME ..."
    echo -e "\033[33m CATALINA_OUT: $CATALINA_OUT \033[0m"
    nohup java $REMOTE_DEBUG $JAVA_OPTS $JVM_HEAP_DUMP_CONFIG $APP_ENV -jar $DEPLOY_DIR/$SERVER_NAME > $CATALINA_OUT 2>&1 &
    COUNT=0
    while [ $COUNT -lt 1 ]; do
      echo -e ".\c"
      sleep 1
      if [ -n "$SERVER_PORT" ]; then
        COUNT=`netstat -an | grep $SERVER_PORT | wc -l`
      else
        COUNT=`ps -ef | grep java | grep "$SERVER_NAME" | awk '{print $2}' | wc -l`
      fi
      if [ $COUNT -gt 0 ]; then
        break
      fi
    done
    echo -e "\033[32m OK! \033[0m"
    PIDS=`ps -f | grep java | grep "$SERVER_NAME" | awk '{print $2}'`
    echo -e "\033[32m PID: $PIDS \033[0m"
    exit 0
}

function stop()
{

    PIDS=`ps -ef | grep java | grep "$SERVER_NAME" |awk '{print $2}'`
    if [ -z "$PIDS" ]; then
      echo "\033[31m ERROR: The $SERVER_NAME does not started! \033[0m"
      exit 1
    fi

    echo -e "Stopping the $SERVER_NAME ...\c"
    for PID in $PIDS ; do
      kill $PID > $CATALINA_OUT 2>&1
    done
    COUNT=0
    while [ $COUNT -lt 1 ]; do
      echo -e ".\c"
      sleep 1
      COUNT=1
      for PID in $PIDS ; do
        PID_EXIST=`ps -f -p $PID | grep java`
        if [ -n "$PID_EXIST" ]; then
          COUNT=0
          break
        fi
      done
    done
    echo "OK!"
    echo "PID: $PIDS"
}

function restart()
{
	stop
	sleep 2
	start
}

function status()
{
    PIDS=`ps -ef | grep java | grep "$SERVER_NAME" | awk '{print $2}'`
    if [ -n "$PIDS" ]; then
	    echo -e "\033[32m The $SERVER_NAME is running...! \033[0m"
	    echo -e "\033[32m PID: $PIDS \033[0m"
            exit 0
        else
	    echo -e "\033[33m $SERVER_NAME is not running... \033[0m"
	    exit 0
    fi
}

case $1 in
	start)
	start;;
	stop)
	stop;;
	restart)
	restart;;
	status)
	status;;
	*)

	echo -e "\033[0;31m Usage: \033[0m  \033[0;34m sh  $0  {start|stop|restart|status} \033[0m"
    	echo -e "\033[0;31m Example: \033[0m \033[0;33m sh  $0  start \033[0m"
esac
