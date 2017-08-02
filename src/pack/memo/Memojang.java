package pack.memo;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Memojang extends JFrame implements ActionListener {
	JButton btnCopy = new JButton("복사");
	JButton btnPaste = new JButton("붙여넣기");
	JButton btnCut = new JButton("잘라내기");
	JButton btnDel = new JButton("삭제");
	JPanel pn = new JPanel();
	JTextArea txtMemo = new JTextArea("", 10, 30);
	String copyText;

	// 메뉴
	JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
	JMenuItem mnuCopy, mnuPaste, mnuCut, mnuDel;
	JMenuItem mnuAbout, mnuEtc1, mnuEtc2;

	//팝업 메뉴
	JPopupMenu popup;
	JMenuItem m_white, m_blue, m_yellow;
	
	public Memojang() {
		super("제목없음 - 메모장");

		initLayout();
		menuLayout();

		setBounds(200, 200, 400, 350);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int re = JOptionPane.showConfirmDialog(Memojang.this, "정말 종료할까요?", "종료", JOptionPane.YES_NO_OPTION);
				if (re == JOptionPane.YES_OPTION)
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				else
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

			}
		});
	}

	private void initLayout() {
		pn.add(btnCopy);
		pn.add(btnPaste);
		pn.add(btnCut);
		pn.add(btnDel);
		add("South", pn);
		JScrollPane scrollPane = new JScrollPane(txtMemo);
		// add("Center", txtMemo);
		add("Center", scrollPane);

		btnCopy.addActionListener(this);
		btnPaste.addActionListener(this);
		btnCut.addActionListener(this);
		btnDel.addActionListener(this);
	}

	private void menuLayout() {
		JMenuBar menuBar = new JMenuBar(); // 메뉴바

		JMenu mnuFile = new JMenu("파일");
		mnuNew = new JMenuItem("새문서");
		mnuOpen = new JMenuItem("열기...");
		mnuSave = new JMenuItem("저장...");
		mnuExit = new JMenuItem("종료");
		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator(); // 구분선
		mnuFile.add(mnuExit);
		menuBar.add(mnuFile);

		JMenu mnuEdit = new JMenu("편집");
		mnuCopy = new JMenuItem("복사");
		mnuPaste = new JMenuItem("붙여넣기");
		mnuCut = new JMenuItem("잘라내기");
		mnuDel = new JMenuItem("삭제");
		mnuEdit.add(mnuCopy);
		mnuEdit.add(mnuPaste);
		mnuEdit.add(mnuCut);
		mnuEdit.add(mnuDel);
		menuBar.add(mnuEdit);

		JMenu mnuHelp = new JMenu("도움말");
		mnuAbout = new JMenuItem("메모장이란...");
		JMenu mnuEtc = new JMenu("기타");
		mnuEtc1 = new JMenuItem("계산기");
		mnuEtc2 = new JMenuItem("프리셀");
		mnuEtc.add(mnuEtc1);
		mnuEtc.add(mnuEtc2);
		mnuHelp.add(mnuAbout);
		mnuHelp.add(mnuEtc);
		menuBar.add(mnuHelp);

		setJMenuBar(menuBar); // Frame에 메뉴바 장착

		mnuNew.addActionListener(this);
		mnuSave.addActionListener(this);
		mnuOpen.addActionListener(this);
		mnuExit.addActionListener(this);
		mnuCopy.addActionListener(this);
		mnuPaste.addActionListener(this);
		mnuCut.addActionListener(this);
		mnuDel.addActionListener(this);
		mnuAbout.addActionListener(this);
		mnuEtc1.addActionListener(this);
		mnuEtc2.addActionListener(this);
		
		//팝업 메뉴
		popup = new JPopupMenu();
		JMenu m_col = new JMenu("색상선택");
		m_white = new JMenuItem("하양");
		m_blue = new JMenuItem("파랑");
		m_yellow = new JMenuItem("노랑");
		m_col.add(m_white);
		m_col.add(m_blue);
		m_col.add(m_yellow);
		m_white.addActionListener(this);
		m_blue.addActionListener(this);
		m_yellow.addActionListener(this);
		popup.add(m_col);	//메뉴를 팝업메뉴에 등록
		txtMemo.add(popup);	//txtMemo에 팝업메뉴 등록
		
		txtMemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//마우스 오른쪽 버튼을 클릭 시...
				if(e.getModifiers() == MouseEvent.BUTTON3_MASK){
					popup.show(txtMemo, e.getX(), e.getY());
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCopy || e.getSource() == mnuCopy) { // 복사
			// System.out.println(txtMemo.getSelectedText());
			copyText = txtMemo.getSelectedText();
		} else if (e.getSource() == btnPaste || e.getSource() == mnuPaste) { // 붙여넣기
			// txtMemo.setText(copyText);
			int position = txtMemo.getCaretPosition();
			txtMemo.insert(copyText, position);
		} else if (e.getSource() == btnCut || e.getSource() == mnuCut) { // 잘라내기
			copyText = txtMemo.getSelectedText();
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
		} else if (e.getSource() == btnDel || e.getSource() == mnuDel) { // 삭제
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
		} else if (e.getSource() == mnuNew) { // 새문서
			// 기존 자료 유무에 따른 처리

			txtMemo.setText("");
			this.setTitle("제목 없음 - 메모장");
		} else if (e.getSource() == mnuOpen) { // 문서 열기
			FileDialog dialog = new FileDialog(this, "열기", FileDialog.LOAD);
			dialog.setDirectory(".");
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;
			String dfName = dialog.getDirectory() + dialog.getFile();

			// 열기-----------------------------------------------
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dfName));
				txtMemo.setText("");
				String line;
				while ((line = reader.readLine()) != null) {
					txtMemo.append(line + "\n");
				}
				reader.close();

				setTitle(dialog.getFile() + " - 메모장");
			} catch (Exception e2) {
				System.out.println("open err : " + e2);
			}
		} else if (e.getSource() == mnuSave) { // 문서 저장
			// 파일 저장을 위한 경로명 및 파일명 얻기
			FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
			dialog.setDirectory(".");
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;

			// String dfName = "c:/work/nice.txt";
			String dfName = dialog.getDirectory() + dialog.getFile();
			System.out.println(dfName);

			// 저장----------------------------------------------------------------
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
				writer.write(txtMemo.getText());
				writer.close();

				setTitle(dialog.getFile() + " - 메모장");
			} catch (Exception e2) {
				System.out.println("save err : " + e2);
			}

		} else if (e.getSource() == mnuExit) { // 종료
			System.exit(0);
		} else if (e.getSource() == mnuAbout) { // 메모장이란
			new MemoAbout(this);	//직접 제작한 대화상자 호출
			//System.out.println("계속");
		} else if (e.getSource() == mnuEtc1) { // 기타1
			try {
				Runtime runtime = Runtime.getRuntime();
				runtime.exec("calc.exe");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (e.getSource() == mnuEtc2) { // 기타2
			try {
				Runtime.getRuntime().exec("C:/Program Files/Microsoft Games/FreeCell/FreeCell.exe");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		txtMemo.requestFocus();
	}

	public static void main(String[] args) {
		new Memojang();

	}

}
