import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;
public class HandleOperation implements ActionListener{
    LinkedList<String> list;
    JTextField resultShow,showComputerProcess;          
    JTextArea saveComputerProcess;
    HandleOperation(LinkedList<String> list,JTextField t1,JTextField t2,
                    JTextArea t3){
        this.list=list;
        resultShow=t1;
        showComputerProcess=t2; 
        saveComputerProcess=t3;
    }
    public void actionPerformed(ActionEvent e){
        OperationButton b=(OperationButton)e.getSource();
        if(list.size()==1){
           String fuhao=b.getOperateSign();
           list.add(fuhao); 
           showComputerProcess.setText(""+list.get(0)+""+list.get(1));  
        }
        else if(list.size()==2){
           String fuhao=b.getOperateSign();
           list.set(1,fuhao); 
           showComputerProcess.setText(""+list.get(0)+""+list.get(1)); 
        }
        else if(list.size()==3){
           String numOne=list.getFirst();
           String numTwo=list.getLast();
           String ÔËËã·ûºÅ=list.get(1);
           String middleProcess=numOne+""+ÔËËã·ûºÅ+numTwo;
           try{
              double n1=Double.parseDouble(numOne);
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
              String fuhao=b.getOperateSign();
              list.clear(); 
              list.add(""+result);                   
              list.add(fuhao);
              String pro=middleProcess+"="+result+""+list.get(1);
              showComputerProcess.setText(pro);
              saveComputerProcess.append(" "+middleProcess+"="+result+"\n");
              resultShow.setText(""+result);
           }
           catch(Exception ee){}
        }
    }
}