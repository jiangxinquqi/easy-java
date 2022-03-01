package com.xiao.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @desc: 功能描述：<一个窗口程序>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/7/11 22:14
 * <p>
 * ================================================
 * ==   工作流名称 ：[            ]                ==
 * ==    任务名称 ：[            ]                 ==
 * ==    调度时间 ：[            ]                 ==
 * ==           执行                              ==
 * ================================================
 * == 日志                                        ==
 * ================================================
 */
public class TaskScheduleClient extends JFrame implements ActionListener {

    // 文本域
    private JTextArea logText;
    // 滚动条
    private JScrollPane jScrollPane;
    // 面板
    private JPanel workFolwNamePanel, taskNamePanel, exeTimePanel, commitButtonPanel;

    private JLabel workFolwNameLabel, taskNameLabel, exeTimeLabel;
    // 工作流名称,任务名称,执行时间
    private JTextField workFolwName, taskName, exeTime;
    // 按钮
    private JButton jButton;

    public TaskScheduleClient() {

        /****************************日志输出框**************************/
        logText = new JTextArea();
        // 不可编辑
        logText.setEditable(false);
        logText.setBackground(Color.LIGHT_GRAY);
        // 将日志输出框添加到滚动条
        jScrollPane = new JScrollPane(logText);

        /****************************参数输入组件**************************/

        JPanel jPanel = new JPanel();

        workFolwNamePanel = new JPanel();
        taskNamePanel = new JPanel();
        exeTimePanel = new JPanel();
        commitButtonPanel = new JPanel();

        workFolwNameLabel = new JLabel("工作流名称");
        taskNameLabel = new JLabel("任务名称");
        exeTimeLabel = new JLabel("执行时间");

        workFolwName = new JTextField(20);
        taskName = new JTextField(20);
        exeTime = new JTextField("YYYY-mm-DD", 20);

        jButton = new JButton("执行任务");

        this.setLayout(new GridLayout(2, 1));

        // 将输入框与按钮添加到面板中
        workFolwNamePanel.add(workFolwNameLabel);
        workFolwNamePanel.add(workFolwName);

        taskNamePanel.add(taskNameLabel);
        taskNamePanel.add(taskName);

        exeTimePanel.add(exeTimeLabel);
        exeTimePanel.add(exeTime);

        commitButtonPanel.add(jButton);

        jPanel.add(workFolwNamePanel);
        jPanel.add(taskNamePanel);
        jPanel.add(exeTimePanel);
        jPanel.add(jButton, BorderLayout.SOUTH);

        /****************************窗体布局*****************************/
        this.add(jPanel);
        this.add(jScrollPane);

        // 绑定监听事件
        jButton.addActionListener(this);

        /****************************窗体属性*****************************/
        // 设置窗体标题，大小，位置，关闭，是否可见
        this.setTitle("任务调度客户端");
        this.setSize(500, 500);
        this.setLocation(300, 300);
        // 窗体关闭，程序退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jButton.setEnabled(false);
        try {
            int result = executeTask(this.workFolwName.getText(), this.taskName.getText(), this.exeTime.getText());
            logText.append((result == 0 ? "调度成功" : "调度失败") + System.lineSeparator());
        } catch (Exception exception) {
            logText.append("程序异常" + System.lineSeparator());
            logText.append(exception.toString() + System.lineSeparator());
        } finally {
            this.jButton.setEnabled(true);
        }
    }

    private int executeTask(String workFolwName, String taskName, String executeTime) {
        if (workFolwName.equals("1")) {
            return 1;
        }
        if (workFolwName.equals("0")) {
            throw new RuntimeException("hahhahahah");
        }
        return 0;
    }

    public static void main(String[] args) {
        new TaskScheduleClient();
    }
}
