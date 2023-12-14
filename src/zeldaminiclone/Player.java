package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{
	
	public int spd=4, curAnimation=0, curFrames=0, taregetFrames=15;
	public boolean right, up, down, left;
	
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	public boolean shoot = false;
	public int dir=1;
	
	public Player(int x, int y) {
		super(x,y,32,32);
	}

	public void tick() {
		boolean move = false;
		if(right && Word.isFree(x+spd, y)) {
			x+=spd;
			move = true;
			dir = 1;
		}else if(left && Word.isFree(x-spd, y)) {
			x-=spd;
			move = true;
			dir = -1;
		}
		
		if(up && Word.isFree(x, y-spd)) {
			y-=spd;
			move = true;
		}else if(down && Word.isFree(x, y+spd)) {
			y+=spd;
			move = true;
		}
		
		if(move) {
			curFrames++;
			if(curFrames == taregetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritsheet.player_front.length) {
					curAnimation = 0;
				}
			}
		}
		
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x, y, dir));
		}
		
		for(int i=0; i<bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritsheet.player_front[curAnimation], x, y, 32, 32, null);
		
		for(int i=0; i<bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
}
