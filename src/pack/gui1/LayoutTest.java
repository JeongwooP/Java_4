package pack.gui1;

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
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//화면 디자인 연습 : LayoutManager
public class LayoutTest extends Frame implements ActionListener{
	//Frame: Borderlayout이 기본
	
	private Panel pn1 = new Panel();//FlowLayout이 기본
	private Panel pn2 = new Panel();
	private Panel pn3 = new Panel();
	private Panel pn4 = new Panel();
	private Panel pn5 = new Panel();
	private Panel pn6 = new Panel();
	private Button btnGo;
	private TextField txtBun, txtIrum;
	private CardLayout card = new CardLayout();
	
	public LayoutTest() {
		setLayout(new GridLayout(2, 1));	//Frame의 레이아웃 변경
		
		//1행
		Label lbl1 = new Label("bunho");	//메세지 출력용 컴포넌트
		txtBun = new TextField("good", 20);	//키보드로 자료입력용
		pn1.add(lbl1);
		pn1.add(txtBun);
		pn1.setBackground(Color.YELLOW);
		//add(pn1);	//Frame에 Panel을 추가
		
		Label lbl2 = new Label("irum");	//메세지 출력용 컴포넌트
		txtIrum = new TextField("", 20);	//키보드로 자료입력용
		pn2.add(lbl2);
		pn2.add(txtIrum);
		pn2.setBackground(Color.CYAN);
		//add(pn2);
		
		
		pn3.setLayout(card);	//CardLayout으로 설정
		pn3.add("kbs", pn1);
		pn3.add("mbc", pn2);
		//add(pn3);
		
		pn4.add(pn3);
		btnGo = new Button("OK");
		btnGo.addActionListener(this);
		pn4.add(btnGo);
		add(pn4);
		
		
		//2행-------------------------------
		pn5.setBackground(Color.RED);
		pn5.setLayout(new BorderLayout());
		pn5.add("Center", new Label("Center", Label.CENTER));
		pn5.add("East", new Label("a", Label.CENTER));
		pn5.add("West", new Label("b" , Label.CENTER));
		pn5.add("South", new Label("c" , Label.CENTER));
		pn5.add("North", new Label("d" , Label.CENTER));
		
		add(pn5);
		
		setTitle("Layout Test");
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 클릭해서 pn1과 pn2를 교대로 출력
		//System.out.println(e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("ok")){
			btnGo.setLabel("Click");
			card.show(pn3, "mbc");
		}else{
			btnGo.setLabel("OK");
			card.show(pn3, "kbs");
		}
	}
	
	public static void main(String[] args) {
		new LayoutTest();
	}
}
