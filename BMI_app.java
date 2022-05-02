import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class BMI_app {

  private JFrame frame;
  private JTextField textField;
  private JTextField textField_1;

  String height="",weight="",result="";


  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          BMI_app window = new BMI_app();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public BMI_app() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 310, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JLabel lblNewLabel = new JLabel("BMI CALCULATOR");
    lblNewLabel.setBounds(86, 12, 142, 33);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel lblHeight = new JLabel("Height in meters");
    lblHeight.setBounds(25, 60, 200, 15);
    frame.getContentPane().add(lblHeight);
    
    textField = new JTextField();
    textField.setBounds(150, 60, 100, 19);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
    JLabel lblWeight = new JLabel("Weight in kg");
    lblWeight.setBounds(25, 96, 100, 15);
    frame.getContentPane().add(lblWeight);
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(150, 94, 100, 19);
    frame.getContentPane().add(textField_1);
    
    
    JButton btnSubmit = new JButton("Compute");
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        calculate_bmi();
      }
    });
    btnSubmit.setBounds(20, 215, 92, 25);
    frame.getContentPane().add(btnSubmit);
    
    JButton btnReset = new JButton("Reset");
    btnReset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        height="";
        weight="";
        result="";

        textField.setText("");
        textField_1.setText("");
      }
    });
      btnReset.setBounds(172, 215, 92, 25);
      frame.getContentPane().add(btnReset);
    }

  public void calculate_bmi() {
    if(textField.getText().isEmpty() || textField_1.getText().isEmpty())
      {error();
      return;
      }
    double h,w,r;
    height = textField.getText();
    weight = textField_1.getText();

    h=Double.parseDouble(height);
    w=Double.parseDouble(weight);
    r=w/Math.pow(h, 2);
    DecimalFormat df = new DecimalFormat("###.##");
    result="BMI:";
    result+=String.valueOf(df.format(r));
    if (r >= 25)
      result+="\n\t BMI RESULT : Overweight";
    else if (r > 18.5)
     result+="\n\t BMI RESULT : Normal ";
    else
      result+="\n\t BMI RESULT :Underweight \n";
    JFrame f =new JFrame();  
      JOptionPane.showMessageDialog(f,result);      
  }
  public void error() {
    JFrame f =new JFrame();  
      JOptionPane.showMessageDialog(f,"Fill all the details","Alert",JOptionPane.WARNING_MESSAGE);  
  }
}
