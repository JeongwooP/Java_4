package pack.gui1;

import java.awt.Frame;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MiniCalc extends JFrame implements ActionListener {

	JTextField num1, num2;
	JRadioButton plus, minus, multiply, divide;
	ButtonGroup bg = new ButtonGroup();
	JLabel lbl;
	JButton a, b, c;

	public MiniCalc() {
		super("미니 계산기");

		layInit();

		setBounds(200, 200, 300, 300);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void layInit() {
		setLayout(new GridLayout(5, 1));

		num1 = new JTextField("", 20);
		JPanel pn1 = new JPanel();
		pn1.add(new Label("num1"));
		pn1.add(num1);
		add(pn1);

		num2 = new JTextField("", 20);
		JPanel pn2 = new JPanel();
		pn2.add(new Label("num2"));
		pn2.add(num2);
		add(pn2);

		plus = new JRadioButton("+", true);
		minus = new JRadioButton("-", false);
		multiply = new JRadioButton("*", false);
		divide = new JRadioButton("/", false);
		bg.add(plus);
		bg.add(minus);
		bg.add(multiply);
		bg.add(divide);
		JPanel pn3 = new JPanel();
		pn3.add(plus);
		pn3.add(minus);
		pn3.add(multiply);
		pn3.add(divide);
		add(pn3);

		lbl = new JLabel("결과 :");
		add(lbl);

		a = new JButton("계산");
		b = new JButton("초기화");
		c = new JButton("종료");
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		JPanel pn4 = new JPanel();
		pn4.add(a);
		pn4.add(b);
		pn4.add(c);
		add(pn4);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == c) {
			System.exit(0);
		}

		if (num1.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "숫자를 입력하세요.");
			num1.requestFocus();
			return;
		}
		if (num2.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "숫자를 입력하세요.");
			num2.requestFocus();
			return;
		}
		double su1 = Integer.parseInt(num1.getText());
		double su2 = Integer.parseInt(num2.getText());
		double sum = 0;
		String op = "";
		String str = "";
		if (plus.isSelected()) {
			op = "+";
			str = "결과: " + num1.getText() + " " + op + " " + num2.getText() + " = "
					+ (su1 + su2);
		} else if (minus.isSelected()) {
			op = "-";
			str = "결과: " + num1.getText() + " " + op + " " + num2.getText() + " = "
					+ (su1 - su2);
		} else if (multiply.isSelected()) {
			op = "*";
			str = "결과: " + num1.getText() + " " + op + " " + num2.getText() + " = "
					+ (su1 * su2);
		} else {
			op = "/";
			str = "결과: " + num1.getText() + " " + op + " " + num2.getText() + " = "
					+ (su1 / su2);
		}
		if (e.getSource() == a) {
			lbl.setText(str);
		} else if (e.getSource() == b) {
			num1.setText(null);
			num2.setText(null);
			lbl.setText(null);
		}

	}

	public static void main(String[] args) {
		new MiniCalc();

	}

}
