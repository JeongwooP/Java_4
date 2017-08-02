package pack.gui1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SwingTest2 extends JPanel implements ActionListener {
	JButton btnR, btnG, btnB;
	JMenuBar mBar;
	JMenuItem mnuMes, mnuOk, mnuInput;
	JTextArea jTextArea = new JTextArea("", 10, 50);

	public SwingTest2() {
		setLayout(new BorderLayout()); // FlowLayout -> BorderLayout
		btnR = new JButton("빨강");
		btnG = new JButton("초록");
		btnB = new JButton("파랑");
		btnR.addActionListener(this);
		btnG.addActionListener(this);
		btnB.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(btnR);
		panel.add(btnG);
		panel.add(btnB);

		add("South", panel);
		add("Center", jTextArea);

		menuProcess(); // 메뉴 작업
	}

	private void menuProcess() {
		mBar = new JMenuBar();

		JMenu menu = new JMenu("대화상자");
		mnuMes = new JMenuItem("메세지");
		mnuOk = new JMenuItem("확인");
		mnuInput = new JMenuItem("입력");
		mnuMes.addActionListener(this);
		mnuOk.addActionListener(this);
		mnuInput.addActionListener(this);
		menu.add(mnuMes); // 메뉴에 메뉴아템을 등록
		menu.add(mnuOk);
		menu.add(mnuInput);

		mBar.add(menu); // 메뉴를 메뉴바에 등록

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("빨강")) {
			jTextArea.setBackground(Color.RED);
		} else if (e.getActionCommand().equals("초록")) {
			jTextArea.setBackground(Color.GREEN);
		} else if (e.getActionCommand().equals("파랑")) {
			jTextArea.setBackground(Color.BLUE);
		} else if (e.getSource() == mnuMes) {
			JOptionPane.showMessageDialog(this, "메세지", "알림", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("다음 진행");
		} else if (e.getSource() == mnuOk) {
			int re = JOptionPane.showConfirmDialog(this, "버튼 골라", "골라", JOptionPane.YES_NO_CANCEL_OPTION);
			//System.out.println("re :" + re);
			switch (re) {
			case JOptionPane.YES_OPTION:
				jTextArea.append("예 선택\n");
				break;
			case JOptionPane.NO_OPTION:
				jTextArea.append("아니오 선택\n");
				break;
			case JOptionPane.CANCEL_OPTION:
				jTextArea.append("취소 선택\n");
				break;
			}
		} else if (e.getSource() == mnuInput) {
			String str = JOptionPane.showInputDialog(this, ""); 
			jTextArea.append(str + "\n");
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("메뉴 연습");
		SwingTest2 test2 = new SwingTest2();
		// SwingTest3 test3 = new SwingTest3(); ...

		frame.getContentPane().add(test2, "Center");
		// frame.getContentPane().add(test3, "South");
		frame.setJMenuBar(test2.mBar); // Frame에 메뉴바를 등록
		frame.setBounds(200, 200, 300, 300);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
