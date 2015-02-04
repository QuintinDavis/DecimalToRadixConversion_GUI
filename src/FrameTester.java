import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class FrameTester
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		frame.setLocation(400,200);

		JButton convert = new JButton("Convert");
		JButton convert2 = new JButton("Convert");


		final JTextField base = new JTextField(6);
		base.setText("Enter Base");
		final JTextField decNumber = new JTextField(12);
		decNumber.setText("Enter Decimal Number");
		
		final JTextField base2 = new JTextField(6);
		base2.setText("Enter Base");
		final JTextField decNumber2 = new JTextField(12);
		decNumber2.setText("Enter Radix Number");

		frame.setLayout(new FlowLayout());

		panel1.add(base);
		panel1.add(decNumber);
		panel1.add(convert);
		
		panel2.add(base2);
		panel2.add(decNumber2);
		panel2.add(convert2);
		
		Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        panel1.setBorder(loweredetched);
        panel2.setBorder(loweredetched);
        
        
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						final DecimalToRadixConverter baseRConverter = new DecimalToRadixConverter (Integer.parseInt(base.getText()));
						String baseRResult = baseRConverter.convertDecimalNumber(Integer.parseInt(decNumber.getText()));
						JOptionPane.showMessageDialog(
					            null,
					            "Result of converting "+Integer.parseInt(decNumber.getText())+" to base " +Integer.parseInt(base.getText())+" = "+baseRResult,
					            null,
					            JOptionPane.INFORMATION_MESSAGE,
					            null);
					      System.exit(0);
					}
				}).start();
			}	  
		});
		
		frame.add(panel1);
		frame.add(panel2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}