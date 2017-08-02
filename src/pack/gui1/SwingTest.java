package pack.gui1;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingTest extends JFrame implements ActionListener {
	JLabel lblShow;
	int count = 0;

	public SwingTest() {
		setTitle("스윙 연습");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		
		JButton btn = new JButton("클릭(C)");
		btn.setMnemonic(KeyEvent.VK_C);
		btn.addActionListener(this);
		panel.add(btn);
		
		lblShow = new JLabel("출력");
		panel.add(lblShow);
		
		//getContentPane().add(panel, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
		
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		//윈도우 종료 이벤트 : 내부무명 클래스 사용
		/*
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	public static void main(String[] args) {
		new SwingTest();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		lblShow.setText("버튼 클릭 수 : " + count);
		
	}

}
