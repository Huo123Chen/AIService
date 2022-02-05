package com.ai.frame;

import com.ai.common.utils.OurRuleUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @author: Administrator
 * @date: 2022/2/5 12:29
 * @description:
 */
public class Chat extends JFrame implements ActionListener {


    private JLabel label1,label2;

    private JTextField jTextField1,jTextField2; //文本框


    private JButton button2,button3;// 按钮 button1,

    private JTextArea textArea;//文本域


    private JPanel southPanel;//面板

    private String name = "商户方";//默认昵称


    private int port = 8127; //端口号

    //日期格式化, 后面接受消息方法 receive会用到
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("a HH:mm:ss");

    private static SimpleDateFormat sdf4 = new SimpleDateFormat("a HH:mm:ss");

    //记录用户已完成步骤 todo需要写如本地文件


    public Chat(){
        //定义窗口宽高常量
        final  int width = 700;
        final  int height = 900;
        //获取屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

//      JFrame myFrame = new JFrame("聊天室");
        this.setName("聊天室");
        this.setSize(width,height);
        this.setLocation(screenSize.width /2 - width /2, screenSize.height / 2 - height /2);

        //网格布局
        this.setLayout(new BorderLayout());

        //todo 开始上文布局
//        label1 = new JLabel("输入昵称",SwingConstants.RIGHT);
//        jTextField1 = new JTextField(12);
//        JPanel innerPanelCenter = new JPanel();
//        JPanel innerPanel = new JPanel();
//
//
//        innerPanel.add(label1);
//        innerPanel.add(jTextField1);
//        innerPanelCenter.add(innerPanel);
//        button1 = new JButton("确认");
//        innerPanelCenter.add(button1);
//
//
//        button1.addActionListener(this);//添加监听


        label2 = new JLabel("AI 商户对接U指导!");
        label2.setForeground(Color.red);
        label2.setBorder(BorderFactory.createTitledBorder("提示"));

        JPanel northPanel = new JPanel(new BorderLayout());
//        northPanel.add(innerPanelCenter,BorderLayout.CENTER);
        northPanel.add(label2,BorderLayout.NORTH);
        this.add(northPanel,BorderLayout.NORTH);
        //todo 结束上文布局


        //todo 中部布局

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("幼圆",Font.PLAIN,16));

        this.add(new JScrollPane(textArea),BorderLayout.CENTER);
        southPanel = new JPanel();
        southPanel.add( new JLabel());



        jTextField2 = new JTextField(30);
        southPanel.add(jTextField2);

        button2 = new JButton("发送");
        southPanel.add(button2);

        button3 = new JButton("退出");
        southPanel.add(button3);

        button2.addActionListener(this);
        button3.addActionListener(this);

        this.add(southPanel,BorderLayout.SOUTH);
        //窗口可见性
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == button1){
//            name = jTextField1.getText();//设置昵称
//            jTextField1.setText("");
//        }
        if (e.getSource() == button2){
            send(); //发送
        }
        if (e.getSource() == button3){
            System.exit(0); //退出
        }
    }

    public void send(){
        try {

            DatagramSocket dSocket = new DatagramSocket();
            String string = jTextField2.getText();
            jTextField2.setText("");//清空输入栏

            byte[] buf = (name +":"+string).getBytes("GBK");

            for (String ip : OurRuleUtils.ipAddree){
                SocketAddress sAddress = new InetSocketAddress(ip,port);
                DatagramPacket dPacket = new DatagramPacket(buf,buf.length,sAddress);

                dSocket.send(dPacket);
            }
        }catch (SocketException e){

            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void receive(){
        try {

            DatagramSocket dSocket = new DatagramSocket(port);
            while (true){
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);

                dSocket.receive(dp);//接受数据报报的方法,该方法是堵塞式

                String str = new String(buf,0,dp.getLength(),"GBK");

                String[] strArray = str.split(":");



                switch(strArray[1])
                {
                    case "1" :
                        textArea.append(str +"\n\n");
                        ;

                        break;
                    case  "2" :
                        textArea.append(str +"\n\n");


                        break;
                    case "3" :
                        textArea.append(str +"\n\n");


                        break;
                    case "4" :
                        textArea.append(str +"\n\n");


                        break;
                    case "5" :
                        textArea.append(str +"\n\n");


                        break;
                    case "6" :
                        textArea.append(str +"\n\n");


                        break;
                    //你可以有任意数量的case语句
                    default :
                        initTextArea();

                }
                textArea.append("\n");
                Thread.sleep(2000);
                initTextArea();
            }
        }catch (SocketException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
    //第一次初始化流程信息
    public void initTextArea(){
        textArea.append("\nAI:"+"\n");
        for (Map.Entry<String,String> entry : OurRuleUtils.hintProcess.entrySet()){
            textArea.append(entry.getKey()+","+entry.getValue()+"\n");
        }
        textArea.append("\n");
    }
}
