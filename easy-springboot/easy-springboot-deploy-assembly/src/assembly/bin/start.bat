echo off
set APP_NAME=easy-springboot-deploy-assembly.jar
set CONFIG= -Dspring.config.location=../config/application.yml
set LOG_PATH= -Dlogging.path=../logs
set LOG_CONFIG= -Dlogging.config=../config/logback-spring.xml
set DEBUG_OPTS=
if ""%1"" == ""debug"" (
  set DEBUG_OPTS= -Xloggc:../logs/gc.log -verbose:gc -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=../logs
  goto debug
)
set JMX_OPTS=
if ""%1"" == ""jmx"" (
  set JMX_OPTS= -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9888 -Dcom.sun.management.jmxremote.ssl=FALSE -Dcom.sun.management.jmxremote.authenticate=FALSE
  goto jmx
)
echo "Starting the %APP_NAME%"
java -Xms512m -Xmx512m -server %DEBUG_OPTS% %JMX_OPTS% %LOG_PATH% %LOG_CONFIG% %CONFIG% -jar ../%APP_NAME%
goto end
:debug
echo "debug"
java -Xms512m -Xmx512m -server %DEBUG_OPTS% %CONFIG% -jar ../%APP_NAME%
goto end
:jmx
java -Xms512m -Xmx512m -server %JMX_OPTS% %CONFIG% -jar ../%APP_NAME%
goto end
:end
pause