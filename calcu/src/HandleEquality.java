import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;
public class HandleEquality implements ActionListener{
    LinkedList<String> list;
    JTextField resultShow,showComputerProcess;          
    JTextArea saveComputerProcess; 
    HandleEquality(LinkedList<String> list,JTextField t1,JTextField t2,
                    JTextArea t3){
        this.list=list;
        resultShow=t1;
        showComputerProcess=t2; 
        saveComputerProcess=t3;
    }
    public void actionPerformed(ActionEvent e){
        if(list.size()==1){   
           String num=list.getFirst();
           resultShow.setText(""+num);
           showComputerProcess.setText(list.get(0));
        }
        if(list.size()==2){   
           String num=list.getFirst();
           String ÔËËã·ûºÅ=list.get(1);
           try{  double n1=Double.parseDouble(num);
                 double n2=Double.parseDouble(num);
                 double result=0;
                 if(ÔËËã·ûºÅ.equals("+"))
                      result=n1+n2;
                 else if(ÔËËã·ûºÅ.equals("-"))
                      result=n1-n2;
                 else if(ÔËËã·ûºÅ.equals("*"))
                      result=n1*n2;
                 else if(ÔËËã·ûºÅ.equals("/"))
                      result=n1/n2;
                 resultShow.setText(""+result);
                 String proccess=num+""+ÔËËã·ûºÅ+""+num+"="+result;
                 showComputerProcess.setText(proccess);
                 saveComputerProcess.append(" "+proccess+"\n");
                 list.set(0,""+result);
           }
           catch(Exception ee){}
        }
        else if(list.size()==3){
           String numOne=list.getFirst();
           String ÔËËã·ûºÅ=list.get(1);
           String numTwo=list.getLast();
           try{  double n1=Double.parseDouble(numOne);
                 double n2=Double.parseDouble(numTwo);
                 double result=0;
                 if(ÔËËã·ûºÅ.equals("+"))
                      result=n1+n2;
                 else if(ÔËËã·ûºÅ.equals("-"))
                      result=n1-n2;
                 else if(ÔËËã·ûºÅ.equals("*"))
                      result=n1*n2;
                 else if(ÔËËã·ûºÅ.equals("/"))
                      result=n1/n2;
                 resultShow.setText(""+result);
                 String proccess=numOne+""+ÔËËã·ûºÅ+""+numTwo+"="+result;
                 showComputerProcess.setText(proccess);
                 saveComputerProcess.append(" "+proccess+"\n");
                 list.set(0,""+result);
                 list.removeLast();  //ÒÆµôµÚ2¸öÔËËãÊı 
                 list.removeLast();  //ÒÆµôÔËËã·ûºÅ
           }
           catch(Exception ee){}
       }
    }
}