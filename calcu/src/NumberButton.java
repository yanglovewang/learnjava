import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NumberButton extends JButton{
   int number;
   public NumberButton(int number){
       super(""+number);
       this.number=number;
       setForeground(Color.blue);
   }
   public int getNumber(){
       return number;
   }
}

