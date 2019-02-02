package com.study.basic.thread;
//: Counter1.java
// A non-responsive user interface
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/1 17:36
 */
public class Counter1 extends Applet {
    private int count = 0;
    private Button
            onOff = new Button("Toggle"),
            start = new Button("Start");
    private TextField t = new TextField(10);
    private boolean runFlag = true;
    @Override
    public void init() {
        add(t);
        start.addActionListener(new StartL());
        add(start);
        onOff.addActionListener(new OnOffL());
        add(onOff);
    }
    public void go() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){}
            if(runFlag) {
                t.setText(Integer.toString(count++));
            }
        }
    }
    class StartL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            go();
        }
    }
    class OnOffL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            runFlag = !runFlag;
        }
    }
    public static void main(String[] args) {
        Counter1 applet = new Counter1();

        Frame aFrame = new Frame("Counter1");
        aFrame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        aFrame.add(applet, BorderLayout.CENTER);
        aFrame.setSize(300,200);
        applet.init();
        applet.start();
        aFrame.setVisible(true);
    }
} ///: