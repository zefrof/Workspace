import java.awt.*;
import java.awt.event.*;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;

public class FindIt extends java.applet.Applet implements MouseListener
{

	int secretX = ((int)(Math.random()*17)*75)+10;
	int secretY = ((int)(Math.random()*7)*75)+40;
	int mouseX;
	int mouseY;
	int count=0;

	AudioClip coolsaber;
	AudioClip vader;
	Image luke;
	Image darth;
	Image skywalker;

		public void init()
			{
				coolsaber=getAudioClip(getCodeBase(), "coolsaber.au");
				if(coolsaber==null)
				{
					System.out.println("Failed to load coolsaber");
				}
				else
				{
					System.out.println("Loaded coolsaber");
				}

				vader=getAudioClip(getCodeBase(), "vader.au");
					if(vader==null)
					{
						System.out.println("Failed to load vader");
					}
					else
					{
						System.out.println("Loaded vader");
					}

				luke=getImage(getCodeBase(), "Luke.jpg");
				if(luke ==null)
				{
					System.out.println("Got null to load the luke");
				}
				else
				{
					System.out.println("Image Loaded");
				}

				darth=getImage(getCodeBase(), "darth.jpg");
				if(darth==null)
				{
					System.out.println("Got null to load darth");
				}
				else
				{
					System.out.println("Image Loaded");
				}
				skywalker=getImage(getCodeBase(), "skywalker.jpg");
				if(skywalker==null)
				{
					System.out.println("Got null to load the luke");
				}
				else
				{
					System.out.println("Image Loaded");
				}
			}


	public FindIt()
	{
		addMouseListener(this);
	}

	public void paint(Graphics g)
	{
		for(int mouseX=10; mouseX<1300; mouseX=mouseX+75)
		{
			for(int mouseY=40; mouseY < 550; mouseY=mouseY+75)
			{
				g.drawImage(luke, mouseX,mouseY, this);

			}
		}
		g.drawString("Count ="+ count,10,10);
		g.drawString("You Clicked =" + mouseX + ","+ mouseY,20,20);


		if(mouseX > secretX+50)
		{
			g.drawString("GO LEFT",500,260);
		}
		if(mouseX < secretX && mouseX != 0 && mouseY != 0)
		{
			g.drawString("GO RIGHT", 500,260);

		}
		if(mouseY > secretY+50)
		{
			g.drawString("GO UP",700,260);
		}


		if(mouseY<secretY && mouseX !=0 && mouseY !=0)
		{
			g.drawString("GO DOWN",700,260);
		}

		if(mouseY==secretY)
		{
			g.drawImage(skywalker,0,0,this);

		}

		if(mouseX>=secretX && mouseY >= secretY && mouseY<=(secretY+50) && mouseX<=(secretX+50))
		{
			g.drawImage(skywalker,0,0,this);
			coolsaber.play();
		}

		if(count == 6)
		{
			g.drawImage(darth,0,0, this);
			vader.play();

		}
		if(count ==7)
		{
			g.drawImage(darth,0,0, this);
		}

		if(count == 8)
		{
			g.drawImage(skywalker,0,0,this);
			coolsaber.play();

		}

	}


	public void mouseExited(MouseEvent me)
	{
	}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mousePressed(MouseEvent me)
	{
	}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void mouseClicked(MouseEvent me)
	{

		count=count+1;

		mouseX = me.getX();
		mouseY = me.getY();
		repaint();
	}
}
