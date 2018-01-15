import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;
public class HandleDigit implements ActionListener{
    LinkedList<String> list;
    JTextField resultShow;          
    JTextField showComputerProcess;
    HandleDigit(LinkedList<String> list,JTextField t1,JTextField t2) {
        this.list=list;
        resultShow=t1;
        showComputerProcess=t2; 
    }
    public void actionPerformed(ActionEvent e){
        NumberButton b=(NumberButton)e.getSource();
        if(list.size()==0) {
           int number=b.getNumber();
           list.add(""+number); 
           resultShow.setText(""+number);
           showComputerProcess.setText(""+list.get(0));
        }
        else if(list.size()==1){
           int number=b.getNumber();
           String num=list.getFirst();
           String s=num.concat(""+number);     
           list.set(0,s);
           resultShow.setText(s);
           showComputerProcess.setText(""+list.get(0));
        }
        else if(list.size()==2){                
           int number=b.getNumber();
           list.add(""+number);
           resultShow.setText(""+number); 
           showComputerProcess.setText(""+list.get(0)+""+list.get(1)+
                                       ""+list.get(2));             
        }
        else if(list.size()==3) {               
           int number=b.getNumber();
           String num=list.getLast();
           String s=num.concat(""+number);     
           list.set(2,s);
           resultShow.setText(s);
           showComputerProcess.setText(""+list.get(0)+""+list.get(1)+
                                       ""+list.get(2));
        }
    }
}