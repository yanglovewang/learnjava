import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;
public class HandlePositiveOrNegative implements ActionListener{
    LinkedList<String> list;
    JTextField resultShow,showComputerProcess;          
    HandlePositiveOrNegative(LinkedList<String> list,JTextField t1,JTextField t2){
        this.list=list;
        resultShow=t1;
        showComputerProcess=t2; 
    }
    public void actionPerformed(ActionEvent e){
        if(list.size()==1){
           String number1=list.getFirst();
           try {  double d=Double.parseDouble(number1);
                  d=-1*d;
                  String str=String.valueOf(d);
                  list.set(0,str);
                  resultShow.setText(str);
                  showComputerProcess.setText(""+list.get(0)); 
           }
           catch(Exception ee){}
        } 
        else if(list.size()==3){
           String number2=list.getLast();
           try {  double d=Double.parseDouble(number2);
                  d=-1*d;
                  String str=String.valueOf(d);
                  list.set(2,str);
                  resultShow.setText(str);
                  showComputerProcess.setText(""+list.get(0)+""
                                              +list.get(1)+""+list.get(2));
           }
           catch(Exception ee){}
       } 
    }
}