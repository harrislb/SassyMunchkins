import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class BottomCardPanel extends JPanel implements MouseListener{
	//private BufferedImage munchkinLogo;
	private BufferedImage cardImage1;
	private BufferedImage cardImage2;
	private BufferedImage cardImage3;
	private BufferedImage cardImage4;
	private BufferedImage cardImage5;
	private BufferedImage cardImage6;
	private BufferedImage cardImage7;
	private BufferedImage cardImage8;
	private BufferedImage MunchBanner;
	public ArrayList<BufferedImage> cardImages= new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> cardsInPlayImages = new ArrayList<BufferedImage>();
	public NewGameButton ngb;
	public EndTurnButton etb;
	public LetOtherPlayerPlayCardButton loppcb;
	public BufferedImage largeCard;
	public int largeCardPos;
	public PlayCardButton pcb;
	public DidIWinButton diwb;
	public Player turnPlayer;
	public Game myGame;
	public MFrame myFrame;
	public ArrayList<String> myArrayOfLines;

	
	

	//public MapPanel (ButtonPanel bPanel){
	 public BottomCardPanel(Game game,MFrame frame,ArrayList<String> arrayOfLines){
		super();
		this.myGame=game;
		this.myFrame=frame;
		this.myArrayOfLines=arrayOfLines;
	
		if(game.turnPlayer==1){
			this.turnPlayer=game.p1;
			
		}
		else{
			this.turnPlayer=game.p2;
		}
		this.addMouseListener(this);
        //SpringLayout layout = new SpringLayout();
        //this.setLayout(null);
        NewGameButton newGameButton= new NewGameButton(frame,arrayOfLines,game);
        this.ngb=newGameButton;
 
        //ngb.setBounds(0,0,50,50);
		ngb.setPreferredSize(new Dimension(100,30));
		ngb.setLocation(-100,-100);
		this.add(ngb);
		
		this.pcb= new PlayCardButton(frame,arrayOfLines,game);
		pcb.setPreferredSize(new Dimension (100,30));
		this.add(pcb);
		
		this.diwb = new DidIWinButton(frame, arrayOfLines,game);
		diwb.setPreferredSize(new Dimension (100,30));
		this.add(diwb);
		
		
		this.etb=new EndTurnButton(frame,arrayOfLines,game);
		etb.setPreferredSize(new Dimension(90,30));
		this.add(etb);
		
        
    	
		try {
			MunchBanner = ImageIO.read(new File ("src\\munchkin-cthulhu.jpg"));
			for(int i =0; i<this.turnPlayer.pHand.size();i++){
				BufferedImage cardImage = ImageIO.read(new File ("src\\m"+this.turnPlayer.pHand.get(i)+".PNG"));
				cardImages.add(cardImage);
			
			}
			
			for(int i =0; i<this.turnPlayer.pPlay.size();i++){
				BufferedImage playImage = ImageIO.read(new File("src\\m"+this.turnPlayer.pPlay.get(i)+".PNG"));
				cardsInPlayImages.add(playImage);
			}
			
			
		
		
		} catch (IOException ex) {
			System.out.println("Error reading card file in BottomCardPanel");
			// handle exception...
		}
		//this.setPreferredSize(new Dimension(2000, 1000));
		this.setMinimumSize(new Dimension(2000,500));
		this.setVisible(true);
		this.repaint();
		
		
		
	 }
	 
	 
	 public void paintComponent(Graphics go) {
			
			super.paintComponents(go);
			
			//go.drawImage(this.munchkinLogo,0,0,null);
			//go.drawImage(this.cardImage,0,400, 180, 180, null);
			
			//go.drawImage(this.cardImage1,50,0,180,200,null);
			//go.drawImage(this.cardImage2, 60+180,0,180,200,null);
			//go.drawImage(this.cardImage3, 2*(60+180), 0, 180, 200, null);
	//		go.drawImage(MunchBanner,550,0,null);
			
			for(int i =0; i<cardImages.size();i++){
				go.drawImage(cardImages.get(i),50+180*i+10*i,750,180,225,null);
			}
//			go.drawImage(cardImages.get(1),50+180*8+10*8,200,360,610,null);
		//
			for(int i =0; i<cardsInPlayImages.size();i++){
				go.drawImage(cardsInPlayImages.get(i),50+100*i,515,180,225,null);
			}
			
			go.drawImage(largeCard,50+180*8+10*8,400,360,570,null);


		}

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println(MouseInfo.getPointerInfo().getLocation());
		int x = MouseInfo.getPointerInfo().getLocation().x;
		int y = MouseInfo.getPointerInfo().getLocation().y;
		if(y>780 && y<1006){
			if(x>10 && x<185){
				largeCard=cardImages.get(0);
				largeCardPos=0;
			}
			else if(x>200 && x<374){
				if(cardImages.size()>1){
					largeCard=cardImages.get(1);
					largeCardPos=1;
				
				}
				
			}
			
			else if(x>393 && x<564){
				if(cardImages.size()>2){
					largeCard=cardImages.get(2);
					largeCardPos=2;
				}
				
			}
			else if(x>582 && x<753){
				if(cardImages.size()>3){
					largeCard=cardImages.get(3);
					largeCardPos=3;
				}
				
			}
			else if(x>773 && x<946){
				if(cardImages.size()>4){
					largeCard=cardImages.get(4);
					largeCardPos=4;
				}
				
			}
			else if(x>960 && x<1137){
				if(cardImages.size()>5){
					largeCard=cardImages.get(5);
					largeCardPos=5;
				}
				
			}
			else if(x>1151 && x<1324){
				if(cardImages.size()>6){
					largeCard=cardImages.get(6);
					largeCardPos=6;
				}
				
			}
			else if(x>1340 && x<1517){
				if(cardImages.size()>7){
					largeCard=cardImages.get(7);
					largeCardPos=7;
				}
				
			}
		
			else{
				
			}
			
			this.repaint();
		}
		
		if(y>545 && y<770){
			for(int i =0; i<turnPlayer.pPlay.size();i++){
				if(x>50+100*i && x<50+100*i+100){
					largeCard=cardsInPlayImages.get(i);
					largeCardPos=i;
					
				}
			}
			this.repaint();
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
