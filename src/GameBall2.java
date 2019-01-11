import java.awt.*;
import javax.swing.JFrame;

// 需求：桌球在球桌中按照一定路线和角度移动，遇见边框自动弹回。
public class GameBall2 extends JFrame{
	
	// 引入ball.png和desk.png图片
	Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.jpg");
	
	// 小球横坐标
	double x = 100; 
	// 小球纵坐标
	double y = 100;
	// 弧度，此处是60度。
	double degree = 3.14/3; 
	
	// 画窗口的方法 这儿paint方法是重写重写父类【JFrame——Frame——Window】方法
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x = x + 10*Math.cos(degree);
		y = y + 10*Math.sin(degree);
		
		// 碰到上下边界 500窗口高度，40是桌子边框宽度，30是球直径,最后40是标题栏高度。
		if (y > 500 - 40 - 30 || y < 40 +40) {
			degree = -degree;
		}else if (x < 40 || x > 856 - 40 - 30) {
			degree = 3.14 - degree;
		}
		
	}
	
	// 加载窗口
	void startFrame() {
		// 窗口大小
		setSize(856, 500);
		// 窗口位置
		setLocation(50, 50);
		// 是否可见
		setVisible(true);
		
		// 重画窗口
		while (true) {
			repaint();
			try {
				Thread.sleep(40);// 1秒为1000ms(毫秒)，这儿表示1秒钟画25次窗口
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
	}
	
	public static void main(String[] args) {
		System.out.println("桌球游戏");
		GameBall2 gameBall = new GameBall2();
		gameBall.startFrame();
	}
}
