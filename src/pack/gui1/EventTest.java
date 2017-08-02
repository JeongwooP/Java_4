package pack.gui1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventTest extends Frame implements ActionListener{
	private Button btn1 = new Button("button1");
	private Button btn2 = new Button("button2");
	private Button btn3 = new Button("button3");
	private Button btn4 = new Button("button4");
	private Button btn5 = new Button("button5");

	public EventTest() {
		super("Event Test");
		
		addLayout();	//화면 디자인
		
		setBounds(200, 200, 300, 300);
		setVisible(true);
		
		//윈도우 종료 이벤트 : 내부무명 클래스 사용
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void addLayout(){
		add("East", btn1); 	//Frame은 Borderlayout이 기본
		add("West", btn2);
		add("South", btn3);
		add("North", btn4);
		add("Center", btn5);
		btn1.addActionListener(this);	//리스너를 구현한 클래스의 이벤트핸들러 메소드 사용
		btn2.addActionListener(this);	//
		btn3.addActionListener(new MyEvent());	//내부클래스 사용
		btn4.addMouseListener(new YourEvent());
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTitle("내부무명클래스로 이벤트 처리");
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			//System.out.println(e.getActionCommand());	//Label
			//System.out.println(e.getSource());	//객체변수
			if(e.getSource() == btn1){
				setTitle("버튼1 클릭");
			}else if(e.getSource() == btn2){
				setTitle("두번째 버튼 클릭");
			}
	}
	
	//내부 클래스 = button3
	class MyEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			setTitle("세번째 버튼으로 처리");
		}
	}
	
	//내부 클래스 = button4
		class YourEvent extends MouseAdapter{
			@Override
			public void mousePressed(MouseEvent e) {
				EventTest.this.setTitle("네번째 버튼 마우스 이벤트");
			}
		}
	
	public static void main(String[] args) {
		new EventTest();
	}

}
