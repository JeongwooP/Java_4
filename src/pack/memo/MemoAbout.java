package pack.memo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MemoAbout extends JDialog implements ActionListener{
	public MemoAbout(JFrame frame){
		//super(frame, "메모장이란", true);
		super(frame);
		setTitle("메모장이란");
		setModal(true);	//true - Modal, false - Modeless
		
		JLabel lbl = new JLabel("미니 메모장 ver 0.9");
		JButton btn = new JButton("확인");
		btn.addActionListener(this);
		add("Center", lbl);
		add("South", btn);
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(350, 350, 150, 150);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); //Dialog 닫기
		
	}
}
