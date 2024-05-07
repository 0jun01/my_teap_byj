package ch01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private ImageIcon playerL;
	private ImageIcon playerR;
	private ImageIcon playerU;
	private ImageIcon playerD;

	private int x;
	private int y;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private final int SPEED = 10;

	public Player() {
		initData();
		setinitLayout();
	}

	public void initData() {
		playerL = new ImageIcon("img/bazziL.png");
		playerR = new ImageIcon("img/bazzi_rR.png");
		playerU = new ImageIcon("img/bazzi_back.png");
		playerD = new ImageIcon("img/bazzi_front.png");

		x = 300;
		y = 300;

		left = false;
		right = false;
		up = false;
		down = false;

	}

	public void setinitLayout() {
		setIcon(playerD);
		setSize(44, 56);
		setLocation(x, y);
	}

	@Override
	public void left() {
		left = true;
		setIcon(playerL);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// while (true) {
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// }
		}).start();
	}

	@Override
	public void right() {
		right = true;
		setIcon(playerR);
		new Thread(new Runnable() {

			@Override
			public void run() {
				x = x + SPEED;
				setLocation(x, y);
			}
		}).start();

	}

	@Override
	public void up() {
		up = true;
		setIcon(playerU);
		new Thread(new Runnable() {

			@Override
			public void run() {
				y = y - SPEED;
				setLocation(x, y);
			}
		}).start();
	}

	@Override
	public void down() {
		down = true;
		setIcon(playerD);
		new Thread(new Runnable() {

			@Override
			public void run() {
				y = y + SPEED;
				setLocation(x, y);
			}
		}).start();

	}

	// 이동
}
