package pack.gui1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class PackMan extends JFrame implements KeyListener {
	Image image, food;

	int x = 100, y = 100, sel = 1;
	
	public PackMan() {
		super("상하좌우 화살표를 사용하세요");

		// 창 아이콘 이미지 설정
		setIconImage(Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack1.jpg"));

		setLayout(null);
		setResizable(false);
		setBounds(200, 200, 300, 300);
		setBackground(Color.WHITE);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(this); // Frame에 KeyListener 장착
		
		int fx = 180, fy = 180;
		x = (int) getWidth() / 2;
		y = (int) getHeight() / 2;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// System.out.println(key); //아스키코드로 나온다.

		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
			// System.out.println("오르쪽");
			// if(sel == 1) sel = 2; else sel = 1;

			sel = (sel == 1) ? 2 : 1;
			x = (x < getWidth()) ? x += 10 : -image.getWidth(this);
		} else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {
			// System.out.println("왼쪽");
			// if(sel == 1) sel = 2; else sel = 1;

			sel = (sel == 3) ? 4 : 3;
			x = (0 < x) ? x -= 10 : 300 + image.getWidth(this);
		} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD5) {
			// System.out.println("아래쪽");
			// if(sel == 1) sel = 2; else sel = 1;

			sel = (sel == 5) ? 6 : 5;
			y = (y < getHeight()) ? y += 10 : -image.getHeight(this);
		} else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {
			// System.out.println("위쪽");
			// if(sel == 1) sel = 2; else sel = 1;

			sel = (sel == 7) ? 8 : 7;
			y = (0 < y) ? y -= 10 : 300 + image.getHeight(this);
		}
	
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void paint(Graphics g) {
		switch (sel) {
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack1.jpg");
			break;
		case 2:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack2.jpg");
			break;
		case 3:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack3.jpg");
			break;
		case 4:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack4.jpg");
			break;
		case 5:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack5.jpg");
			break;
		case 6:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack6.jpg");
			break;
		case 7:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack7.jpg");
			break;
		case 8:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack8.jpg");
			break;
		}
		food = Toolkit.getDefaultToolkit().getImage("c:/work/food.png");
		
		g.clearRect(0, 0, getWidth(), getHeight());
		// g.drawImage(image, x, y, this);
		g.drawImage(image, x - image.getWidth(this) / 2, y - image.getHeight(this) / 2, this);
		
		g.drawImage(food, 180, 180, this);
	}

	public static void main(String[] args) {
		new PackMan();

	}

}
