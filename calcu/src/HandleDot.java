import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;
public class HandleDot implements ActionListener{
    LinkedList<String> list;
    JTextField resultShow,showComputerProcess;          
    HandleDot(LinkedList<String> list,JTextField t1,JTextField t2){
        this.list=list;
        resultShow=t1;
        showComputerProcess=t2; 
    }
    public void actionPerformed(ActionEvent e){
           String dot=e.getActionCommand(); 
           if(list.size()==1){ 
           String num=list.getFirst();
           String s=null;
           if(num.indexOf(dot)==-1){                     
                s=num.concat(dot); 
                list.set(0,s);                  
           }
           else
                s=num;  
           list.set(0,s);
           resultShow.setText(s);
           showComputerProcess.setText(""+list.get(0));
        }
        else if(list.size()==3){
           String num=list.getLast();
           String s=null;
           if(num.indexOf(dot)==-1){
                s=num.concat(dot); 
                list.set(2,s);
           }
           else
                s=num;
           resultShow.setText(s); 
           showComputerProcess.setText(""+list.get(0)+""+list.get(1)+
                                       ""+list.get(2));
        } 
    }
}