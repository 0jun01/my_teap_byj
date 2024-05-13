package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {
	MainFrame mContext;
	PlayerBlue playerBlue;
	PlayerRed playerRed;

	private boolean shift;

	int bubblePosX;
	int bubblePosY;
	private ImageIcon bubble;
	private ImageIcon bomb;
	private ImageIcon bombdown;
	private ImageIcon bombleft;
	private ImageIcon bombright;
	private ImageIcon bombup;

	public Bubble(MainFrame mContext, PlayerRed playerRed) {
		this.mContext = mContext;
		this.playerRed = playerRed;
		bubblePosX = playerRed.getX();
		bubblePosY = playerRed.getY();
		mContext.panelCenter.add(this);
		initData();
		System.out.println("123123");
	}

	public Bubble(MainFrame mContext) {
		this.mContext = mContext;
		this.playerBlue = mContext.getPlayerBlue();
		bubblePosX = playerBlue.getX();
		bubblePosY = playerBlue.getY();
		initData();
		setInitData();
	}

	public void initData() {
		bubble = new ImageIcon("img/bomb_2.png");
		bomb = new ImageIcon("img/bomb.png");
		bombdown = new ImageIcon("img/bombdown.png");
		bombleft = new ImageIcon("img/bombleft.png");
		bombright = new ImageIcon("img/bombright.png");
		bombup = new ImageIcon("img/bombup.png");

	}

	public void setInitData() {
		setIcon(bubble);
		setSize(100, 100);
		setLocation(bubblePosX, bubblePosY);

		mContext.panelCenter.add(this);
		mContext.repaint();
	}

	public void up() {
		while (true) {
			bubblePosX++;
			setLocation(bubblePosX, bubblePosY);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}