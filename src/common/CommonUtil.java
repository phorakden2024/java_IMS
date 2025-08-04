/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Da Phadenphorakden
 */
public class CommonUtil {
    public boolean isTextEmpty(JTextField[] txts)
    {
        for(JTextField txt:txts)
        {
            if(txt.getText().trim().equalsIgnoreCase(""))
            {
                txt.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "This box cannot empty!");
                txt.setBackground(Color.white);
                txt.requestFocus();
                return true;
            }
        }
        return false;
    }
    public boolean isNotMatch(JTextField txt1,JTextField txt2,String sms)
    {
        if(sms.length()==0)
        {
            sms="Data is not match!";
        }
        if(!txt1.getText().equals(txt2.getText()))
        {
            txt2.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, sms);
            txt2.setBackground(Color.white);
            txt2.requestFocus();
            return true;
        }
        return false;
    }
}



