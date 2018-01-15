import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OperationButton extends JButton{
   String operateSign;
   public OperationButton(String s){
      super(s);
      operateSign=s;
      setForeground(Color.red);
   }
   public String getOperateSign(){
      return operateSign;
   }
}
