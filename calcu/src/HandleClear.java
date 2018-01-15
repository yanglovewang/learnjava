import java.util.LinkedList;
import javax.swing.*;
import java.awt.event.*;
public class HandleClear implements ActionListener{
    LinkedList<String> list;
    JTextField resultShow,showComputerProcess;          
    HandleClear(LinkedList<String> list,JTextField t1,JTextField t2){
        this.list=list;
        resultShow=t1;
        showComputerProcess=t2;
    }
    public void actionPerformed(ActionEvent e){
        resultShow.setText("0");
        list.clear();
        showComputerProcess.setText(null);   
    }
}