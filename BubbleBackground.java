package CrazyArcade;

public class BubbleBackground implements Runnable {

	Bubble bubble;
	PlayerRed playerRed;
	int bubblePosX;
	int bubblePosY;
	int playerRedPosX;
	int playerRedPosY;

	public BubbleBackground(Bubble bubble, PlayerRed playerRed) {
		this.bubble = bubble;
		this.playerRed = playerRed;
		this.bubblePosX = bubble.jLabelPosY * 100;
		this.bubblePosY = bubble.jLabelPosX * 100;
		playerRedPosX = playerRed.getX();
		playerRedPosY = playerRed.getY();

	}

	public BubbleBackground(Bubble bubble, PlayerBlue playerBlue) {
		this.bubble = bubble;
		this.bubblePosX = bubble.jLabelPosX * 100;
		this.bubblePosY = bubble.jLabelPosY * 100;

	}

	@Override
	public void run() {

		boolean flag = true;
		while (flag) {
			System.out.println("1");
			System.out.println(bubblePosX);
			if (playerRed.isLeft()) {
				if (bubblePosX < playerRed.getX() && (playerRed.getX() - bubblePosX <= 80)
						&& bubblePosY < playerRed.getY() + 80 && playerRed.getY() + 80 <= bubblePosY + 80) {
					playerRed.setLeft(false);
				} else {
					playerRed.setLeft(true);
				}
			} else if (playerRed.isRight()) {
				if (bubblePosX > playerRed.getX() && Math.abs(playerRed.getX() - bubblePosX) <= 80
						&& bubblePosY < playerRed.getY() + 80 && playerRed.getY() + 80 <= bubblePosY + 80) {
					playerRed.setRight(false);
				} else {
					playerRed.setRight(true);
				}
			} else if (playerRed.isUp()) {
				if (bubblePosY < playerRed.getY() && Math.abs(playerRed.getY() - bubblePosY) <= 80
						&& bubblePosX < playerRed.getX() + 80 && playerRed.getX() + 80 <= bubblePosX + 80) {
					playerRed.setUp(false);

				}

			} else if (playerRed.isDown()) {
				if (bubblePosY > playerRed.getY() && Math.abs(playerRed.getY() - bubblePosY) <= 100
						&& bubblePosX < playerRed.getX() + 80 && playerRed.getX() + 80 <= bubblePosX + 100) {
					playerRed.setDown(false);

				}

			}

			if (bubble.status == false) {
				playerRed.setLeft(true);
				flag = false;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
