import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.LinkedList;
import java.io.*;
public class CalculatorWindow extends JFrame implements ActionListener{
    NumberButton numberButton[];                  
    OperationButton operationButton[];             
    JButton 小数点操作,正负号操作,退格操作,等号操作,清零操作,sin;
    JTextField resultShow;          //显示计算结果
    JTextField showComputerProcess; //显示当前计算过程
    JTextArea  saveComputerProcess; //显示计算步骤
    JButton saveButton,copyButton,clearButton;
    LinkedList<String> list;   //链表用来存放第一个运算数、运算符号和第二个运算数
    HandleDigit handleDigit;  //负责处理ActionEvent事件
    HandleOperation handleOperation ;
    HandleBack handleBack;
    HandleClear handleClear;
    HandleEquality handleEquality;
    HandleDot handleDot;
    HandlePOrN handlePOrN;
    HandleSin handleSin;
    public CalculatorWindow(){
        setTitle("计算器");
        JPanel panelLeft,panelRight; 
        list=new LinkedList<String>();
        resultShow=new JTextField(10);
        resultShow.setHorizontalAlignment(JTextField.RIGHT);
        resultShow.setForeground(Color.blue);
        resultShow.setFont(new Font("TimesRoman",Font.BOLD,16));
        resultShow.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
        resultShow.setEditable(false);
        resultShow.setBackground(Color.white);
        showComputerProcess=new JTextField();
        showComputerProcess.setHorizontalAlignment(JTextField.CENTER);
        showComputerProcess.setFont(new Font("Arial",Font.BOLD,16));
        showComputerProcess.setBackground(Color.cyan);
        showComputerProcess.setEditable(false);
        saveComputerProcess=new JTextArea();
        saveComputerProcess.setEditable(false);
        saveComputerProcess.setFont(new Font("宋体",Font.PLAIN,16));
        numberButton=new NumberButton[10];
        handleDigit=new HandleDigit(list,resultShow,showComputerProcess);
        for(int i=0;i<=9;i++){
            numberButton[i]=new NumberButton(i);
            numberButton[i].setFont(new Font("Arial",Font.BOLD,20));
            numberButton[i].addActionListener(handleDigit);
        }
        operationButton=new OperationButton[4];
        handleOperation=new HandleOperation(list,resultShow,
                         showComputerProcess,saveComputerProcess);
        String 运算符号[]={"+","-","*","/"}; 
        for(int i=0;i<4;i++){
           operationButton[i]=new OperationButton(运算符号[i]);
           operationButton[i].setFont(new Font("Arial",Font.BOLD,20));
           operationButton[i].addActionListener(handleOperation);
        }
       小数点操作=new JButton(".");
       handleDot=new HandleDot(list,resultShow,showComputerProcess);
       小数点操作.addActionListener(handleDot);
       正负号操作=new JButton("+/-"); 
       handlePOrN=new HandlePOrN(list,resultShow,showComputerProcess);
       正负号操作.addActionListener(handlePOrN);
       等号操作=new JButton("=");
       handleEquality=new HandleEquality(list,resultShow,
                                         showComputerProcess,saveComputerProcess);
       等号操作.addActionListener(handleEquality); 
       sin=new JButton("sin");
       handleSin=new HandleSin(list,resultShow,
                               showComputerProcess,saveComputerProcess);
       sin.addActionListener(handleSin);
       退格操作=new JButton("退格");
       handleBack=new HandleBack(list,resultShow,showComputerProcess);
       退格操作.addActionListener(handleBack);
       清零操作=new JButton("C");
       handleClear=new HandleClear(list,resultShow,showComputerProcess);
       清零操作.addActionListener(handleClear); 
       清零操作.setForeground(Color.red);
       退格操作.setForeground(Color.red);
       等号操作.setForeground(Color.red);
       sin.setForeground(Color.blue);
       正负号操作.setForeground(Color.blue);
       小数点操作.setForeground(Color.blue);
       panelLeft=new JPanel(); 
       panelRight=new JPanel();
       panelLeft.setLayout(new BorderLayout()); 
       JPanel centerInLeft=new JPanel();
       panelLeft.add(resultShow,BorderLayout.NORTH);
       panelLeft.add(centerInLeft,BorderLayout.CENTER);
       centerInLeft.setLayout(new GridLayout(4,5)); 
       centerInLeft.add(numberButton[1]);
       centerInLeft.add(numberButton[2]);
       centerInLeft.add(numberButton[3]);
       centerInLeft.add(operationButton[0]);
       centerInLeft.add(清零操作);
       centerInLeft.add(numberButton[4]);
       centerInLeft.add(numberButton[5]);
       centerInLeft.add(numberButton[6]);
       centerInLeft.add(operationButton[1]);
       centerInLeft.add(退格操作);
       centerInLeft.add(numberButton[7]);
       centerInLeft.add(numberButton[8]);
       centerInLeft.add(numberButton[9]);
       centerInLeft.add(operationButton[2]);
       centerInLeft.add(sin);
       centerInLeft.add(numberButton[0]);
       centerInLeft.add(正负号操作);
       centerInLeft.add(小数点操作);
       centerInLeft.add(operationButton[3]);
       centerInLeft.add(等号操作);
       panelRight.setLayout(new BorderLayout());
       panelRight.add(showComputerProcess,BorderLayout.NORTH);
       saveButton=new JButton("保存");
       copyButton=new JButton("复制");
       clearButton=new JButton("清除");
       saveButton.setToolTipText("保存计算过程到文件");
       copyButton.setToolTipText("复制选中的计算过程");
       clearButton.setToolTipText("清除计算过程");
       saveButton.addActionListener(this);
       copyButton.addActionListener(this);
       clearButton.addActionListener(this); 
       panelRight.add(new JScrollPane(saveComputerProcess),BorderLayout.CENTER);
       JPanel southInPanelRight=new JPanel();
       southInPanelRight.add(saveButton);
       southInPanelRight.add(copyButton);
       southInPanelRight.add(clearButton);
       panelRight.add(southInPanelRight,BorderLayout.SOUTH);
       JSplitPane split=new JSplitPane
                (JSplitPane.HORIZONTAL_SPLIT,panelLeft,panelRight);
       add(split,BorderLayout.CENTER);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       setBounds(100,50,528,258);
       validate();
   }
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==copyButton)
          saveComputerProcess.copy();
       if(e.getSource()==clearButton)
          saveComputerProcess.setText(null);
       if(e.getSource()==saveButton){
           JFileChooser chooser=new JFileChooser();
           int state=chooser.showSaveDialog(null);
           File file=chooser.getSelectedFile();
           if(file!=null&&state==JFileChooser.APPROVE_OPTION){
             try{  String content=saveComputerProcess.getText();
                   StringReader read=new StringReader(content);
                   BufferedReader in= new BufferedReader(read);
                   FileWriter outOne=new FileWriter(file);
                   BufferedWriter out= new BufferedWriter(outOne);
                   String str=null;
                   while((str=in.readLine())!=null){
                      out.write(str);
                      out.newLine();
                   }
                  in.close();
                  out.close();
             } 
             catch(IOException e1){}
           }
       }
   }
   public static void main(String args[]){
       new CalculatorWindow();
   }  
}
