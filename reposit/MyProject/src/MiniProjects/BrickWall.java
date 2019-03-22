package MiniProjects;

import java.util.ArrayList;

class BrikWall extends Thread
{
	String name;
	static ArrayList<String> wall = new ArrayList<String>();	
	
	public BrikWall() {
		// TODO Auto-generated constructor stub
	}
	public BrikWall(String na) {
		// TODO Auto-generated constructor stub
		name = na;
	}
	public void run(){
		synchronized (wall) {
			wall.add(name);
			//System.out.println(name);
			wall.notify();
			//System.out.println(wall);
		}
	}
	public void displayWall()
	{
		int count = 0;
		for(String str : wall)
		{
			count ++;
			System.out.print(str + " ");
			if(count % 9 == 0)
			{
				System.out.println();
			}
		}
		System.out.println("\n"+count);
		
	}
		
}


public class BrickWall {

	public static void main(String[] args) {
	//TODO Auto-generated method stub
		
		BrikWall red = new BrikWall("RED");
		BrikWall black = new BrikWall("Black");
		red.start();
		black.start();
		for(int i = 0;i<25;i++)
		{
			try
			{
				black.run();
				red.run();				
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Interpted");
			}
			
		}
		new BrikWall().displayWall();
		}
}
