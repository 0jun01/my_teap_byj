package ch01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CrazyAcadeFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player1;

	public CrazyAcadeFrame() {
		initData();
		setinitLayout();
		addEventListener();
	}

	public void initData() {
		backgroundMap = new JLabel(new ImageIcon("Img/mapbg2.png"));
		setContentPane(backgroundMap);
		player1 = new Player();
	}

	public void setinitLayout() {
		setLayout(null);
		setSize(600, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(player1);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player1.left();
					break;
				case KeyEvent.VK_RIGHT:
					player1.right();
					break;
				case KeyEvent.VK_UP:
					player1.up();
					break;
				case KeyEvent.VK_DOWN:
					player1.down();
				}
			}
		});
	}

	public static void main(String[] args) {
		new CrazyAcadeFrame();
	}
}
