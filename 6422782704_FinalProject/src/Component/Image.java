package Component;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Image {
	
	private BufferedImage [] mole_img = new BufferedImage[6];
	public static JButton mole_bt[] = new JButton[6];
	private BufferedImage [] heart_img = new BufferedImage[5];
	public static JLabel heart_label[] = new JLabel[5];

	public Image(){
		try {
			
		mole_img[0] = ImageIO.read(new File(".//image_source//image_folder//mole_resize.png"));
		mole_img[1] = ImageIO.read(new File(".//image_source//image_folder//mole_resize.png"));
		mole_img[2] = ImageIO.read(new File(".//image_source//image_folder//mole_resize.png"));
		mole_img[3] = ImageIO.read(new File(".//image_source//image_folder//mole_resize.png"));
		mole_img[4] = ImageIO.read(new File(".//image_source//image_folder//mole_resize.png"));
		mole_img[5] = ImageIO.read(new File(".//image_source//image_folder//mole_resize.png"));
		
		heart_img[0] = ImageIO.read(new File(".//image_source//image_folder//heart.png"));
		heart_img[1] = ImageIO.read(new File(".//image_source//image_folder//heart.png"));
		heart_img[2] = ImageIO.read(new File(".//image_source//image_folder//heart.png"));
		heart_img[3] = ImageIO.read(new File(".//image_source//image_folder//heart.png"));
		heart_img[4] = ImageIO.read(new File(".//image_source//image_folder//heart.png"));
		}
		catch(IOException ex) {
			System.out.println("Not Found!");
		}
		mole_bt[0]=new JButton(new ImageIcon(mole_img[0]));//Implicit casting
			mole_bt[0].setContentAreaFilled(false);
			mole_bt[0].setBorderPainted(false);
		
		mole_bt[1]=new JButton(new ImageIcon(mole_img[1]));
			mole_bt[1].setContentAreaFilled(false);
			mole_bt[1].setBorderPainted(false);
		
		mole_bt[2]=new JButton(new ImageIcon(mole_img[2]));
			mole_bt[2].setContentAreaFilled(false);
			mole_bt[2].setBorderPainted(false);
		
		mole_bt[3]=new JButton(new ImageIcon(mole_img[3]));
			mole_bt[3].setContentAreaFilled(false);
			mole_bt[3].setBorderPainted(false);
		
		mole_bt[4]=new JButton(new ImageIcon(mole_img[4]));
			mole_bt[4].setContentAreaFilled(false);
			mole_bt[4].setBorderPainted(false);
		
		mole_bt[5]=new JButton(new ImageIcon(mole_img[5]));
			mole_bt[5].setContentAreaFilled(false);
			mole_bt[5].setBorderPainted(false);
		
		
		heart_label[0]=new JLabel(new ImageIcon(heart_img[0]));
		heart_label[1]=new JLabel(new ImageIcon(heart_img[1]));
		heart_label[2]=new JLabel(new ImageIcon(heart_img[2]));
		heart_label[3]=new JLabel(new ImageIcon(heart_img[3]));
		heart_label[4]=new JLabel(new ImageIcon(heart_img[4]));
		
		
	}	
}	
