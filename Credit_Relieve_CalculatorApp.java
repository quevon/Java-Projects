import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.FlowLayout;

public class AA2_Muon_Fallesgon_Maryuel_P {

  private JFrame frame;
  private JTextField txtfldLoanAmount;
  private JTextField txtfldCashPayment;
  private JComboBox cmbMonths;
  private String[] months = {"6", "9", "12", "15", "18"};
  String month;
  String loan_amount="",cash_payment="",length_of_payment="",total="",minimum2="",maximum2="",result1 = "hi";
  Integer minimum = 3000;
  Integer maximum = 45000;
  Integer defaultvalue = 3000;

  Integer cashPaymentmin = 0;
  Integer cashPaymentmax = 0;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
            AA2_Muon_Fallesgon_Maryuel_P window = new AA2_Muon_Fallesgon_Maryuel_P();
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
  public AA2_Muon_Fallesgon_Maryuel_P() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(0,0,400, 650);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    // Title Header 

    JLabel lblTitle = new JLabel("Credit Relieve Calculator");
    lblTitle.setBounds(0, 0, 400, 50);
    lblTitle.setFont(new Font("Verdana", Font.PLAIN, 25));
    lblTitle.setHorizontalAlignment(JLabel.CENTER);
    lblTitle.setOpaque(true);
    lblTitle.setBackground( new Color(225, 189, 255));
    lblTitle.setPreferredSize(new Dimension(250, 100));
    frame.getContentPane().add(lblTitle);
    
    //Loan Amount Section

    JLabel lblLoanAmount = new JLabel("Loan Amount");
    lblLoanAmount.setFont(new Font("Verdana", Font.PLAIN, 18));

    lblLoanAmount.setBounds(25, 60, 200, 22);
    frame.getContentPane().add(lblLoanAmount);

    JSlider sldrLoanAmount = new JSlider(minimum,maximum,defaultvalue);
    sldrLoanAmount.setBounds(25, 95, 330, 19);
    // sldrLoanAmount.setColor( new Color(225, 189, 255));

    
    txtfldLoanAmount = new JTextField();
    txtfldLoanAmount.setColumns(10);
    txtfldLoanAmount.setBounds(25, 130, 330, 40);
    txtfldLoanAmount.setFont(new Font("Verdana", Font.PLAIN, 20));

    sldrLoanAmount.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        int value = sldrLoanAmount.getValue();
        txtfldLoanAmount.setText(String.valueOf(value));
     
        min_max_cashpayment();
  
      }
    });
    frame.getContentPane().add(sldrLoanAmount);

    txtfldLoanAmount.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
         String textFieldValue = txtfldLoanAmount.getText();
        sldrLoanAmount.setValue(Integer.valueOf(textFieldValue));
        min_max_cashpayment();
        String fldLoan = txtfldLoanAmount.getText();

        if(Integer.valueOf(fldLoan) < minimum || Integer.valueOf(fldLoan) > maximum){
          JFrame f =new JFrame();  
          JOptionPane.showMessageDialog(f,"Maximum Loan Amount is " + maximum + " and the Minimum is " + minimum,"Alert",JOptionPane.WARNING_MESSAGE); 
        }
      }
   });
    frame.getContentPane().add(txtfldLoanAmount);
    
    //Cash Payment Section

    JLabel lblCashPayment = new JLabel("Cash Payment");
    lblCashPayment.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblCashPayment.setBounds(25, 175, 330, 25);
    frame.getContentPane().add(lblCashPayment);

    JSlider sldrCashPayment = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
    sldrCashPayment.setBounds(25, 210, 330, 20);
   
    sldrCashPayment.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        int value = sldrCashPayment.getValue();
        txtfldCashPayment.setText(String.valueOf(value));
        sldrCashPayment.setMinimum(cashPaymentmin);
        sldrCashPayment.setMaximum(cashPaymentmax);
      }
    });
    frame.getContentPane().add(sldrCashPayment);

    txtfldCashPayment = new JTextField();
    txtfldCashPayment.setColumns(10);
    txtfldCashPayment.setBounds(25, 245, 330, 40);
    txtfldCashPayment.setFont(new Font("Verdana", Font.PLAIN, 20));

    txtfldCashPayment.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        String textFieldValue = txtfldCashPayment.getText();
        sldrCashPayment.setValue(Integer.valueOf(textFieldValue));
        String cashMax = txtfldCashPayment.getText();
        int max = sldrCashPayment.getMaximum();
        int min = sldrCashPayment.getMinimum();

        if(Integer.valueOf(cashMax) > max || Integer.valueOf(cashMax) < min){
          JFrame f =new JFrame();  
          JOptionPane.showMessageDialog(f,"Maximum cash payment is " + max + " Minimum is " + min,"Alert",JOptionPane.WARNING_MESSAGE); 
        }

      }
   });
    frame.getContentPane().add(txtfldCashPayment);
    
    // Length of Payment Section 

    JLabel lblLengthofPayment = new JLabel("Length of Payment");
    lblLengthofPayment.setFont(new Font("Verdana", Font.PLAIN, 18));
    lblLengthofPayment.setBounds(25, 290, 330, 25);
    frame.getContentPane().add(lblLengthofPayment);

    JLabel lblTotal = new JLabel("Your Monthly Installment");
    lblTotal.setBounds(0, 450, 400, 50);
    lblTotal.setFont(new Font("Verdana", Font.PLAIN, 20));
    lblTotal.setHorizontalAlignment(JLabel.CENTER);
    lblTotal.setPreferredSize(new Dimension(250, 100));
    frame.getContentPane().add(lblTotal);

    JLabel lblmonth = new JLabel("6 Months");
    lblmonth.setBounds(0, 485, 400, 50);
    lblmonth.setFont(new Font("Verdana", Font.PLAIN, 20));
    lblmonth.setHorizontalAlignment(JLabel.CENTER);
    lblmonth.setPreferredSize(new Dimension(250, 100));
    frame.getContentPane().add(lblmonth);

    cmbMonths = new JComboBox(months); 
    cmbMonths.setBounds(25, 325, 330, 40);
    cmbMonths.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    cmbMonths.setFont(new Font("Verdana", Font.PLAIN, 20));
    
    cmbMonths.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String months = cmbMonths.getSelectedItem().toString();
        lblmonth.setText(months + " Months");
      }
      });
    frame.getContentPane().add(cmbMonths);

    JLabel lblTotalPayment = new JLabel();
    lblTotalPayment.setBounds(0,  520, 400, 50);
    lblTotalPayment.setFont(new Font("Verdana", Font.PLAIN, 20));
    lblTotalPayment.setHorizontalAlignment(JLabel.CENTER);
    lblTotalPayment.setPreferredSize(new Dimension(250, 100));
    frame.getContentPane().add(lblTotalPayment);

    //Button Calculate

    JButton btnCalculate = new JButton("Calculate");
    btnCalculate.setFont(new Font("Verdana", Font.PLAIN, 20));
    btnCalculate.setPreferredSize(new Dimension(300, 100));
    btnCalculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        calculate_monthly_payment();
            JFrame f =new JFrame();  
    String fldCash = txtfldCashPayment.getText();
    String fldLoan = txtfldLoanAmount.getText();
    if(Integer.valueOf(fldCash) > cashPaymentmax || Integer.valueOf(fldCash) < cashPaymentmin ){  
          JOptionPane.showMessageDialog(f,"Maximum cash payment is " + cashPaymentmax + "and the Minimum is " + cashPaymentmin,"Alert",JOptionPane.WARNING_MESSAGE);
    }else if(Integer.valueOf(fldLoan) < minimum || Integer.valueOf(fldLoan) > maximum){
      JOptionPane.showMessageDialog(f,"Maximum Loan Amount is " + maximum + " and the Minimum is " + minimum,"Alert",JOptionPane.WARNING_MESSAGE); 
    }else{
      lblTotalPayment.setText(total);
    }
      }
    });

    btnCalculate.setBounds(25, 395, 150, 40);
    btnCalculate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCalculate.setBorder(new LineBorder(Color.BLACK));
    frame.getContentPane().add(btnCalculate);
    
    //Button Reset

    JButton btnReset = new JButton("Reset");
    btnReset.setFont(new Font("Verdana", Font.PLAIN, 20));
    btnReset.setPreferredSize(new Dimension(300, 100));
    btnReset.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        loan_amount="";
        cash_payment="";
        total="";

        txtfldLoanAmount.setText("");
        txtfldCashPayment.setText("");
        lblTotalPayment.setText("");
    }
    });
    btnReset.setBounds(210, 395, 150, 40);
    btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnReset.setBorder(new LineBorder(Color.BLACK));
    frame.getContentPane().add(btnReset);

    // textField.setEditable(false);
}

  //Solution for Getting minimum and maximum of cashpayment
  public void min_max_cashpayment() {
    double loanAmountValue,min_loan,max_loan;
    
    loan_amount = txtfldLoanAmount.getText();

    loanAmountValue = Double.parseDouble(loan_amount);

    min_loan = loanAmountValue * .3;

    int min_loans = (int) min_loan;

    minimum2 = String.valueOf(min_loans);

    max_loan = loanAmountValue * .7;
    int max_loans = (int) max_loan;

    txtfldCashPayment.setText(minimum2);
    cashPaymentmin =  min_loans;
    cashPaymentmax =  max_loans;
  }

  //Solution for calculatating the monthly payment

  public void calculate_monthly_payment() {
    if(txtfldLoanAmount.getText().isEmpty() || txtfldCashPayment.getText().isEmpty())
      {error();
        return;
      }
    double loanAmountValue,cashPaymentValue,result,interest;
    loan_amount = txtfldLoanAmount.getText();
    cash_payment = txtfldCashPayment.getText();
    month = months[cmbMonths.getSelectedIndex()];
    
    loanAmountValue = Double.parseDouble(loan_amount);
    cashPaymentValue = Double.parseDouble(cash_payment);

    interest = loanAmountValue * .1;
    
    result = ((loanAmountValue - cashPaymentValue) + interest) / Double.parseDouble(month);

    DecimalFormat df = new DecimalFormat("###.##");
    result1 = String.valueOf(df.format(result));

    total="PHP " + result1 + "/month";

  }

  //error message if fields is null

  public void error() {
    JFrame f =new JFrame();  
      JOptionPane.showMessageDialog(f,"Fill all the details","Alert",JOptionPane.WARNING_MESSAGE);  
  }
}

