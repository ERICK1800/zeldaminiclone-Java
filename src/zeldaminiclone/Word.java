package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Word {

	public static List<Blokcs> blocos = new ArrayList<Blokcs>();
	
	public Word() {
		for(int xx=0; xx<15*2; xx++) {
			blocos.add(new Blokcs(xx*32,0));
		}
		
		for(int xx=0; xx<15*2; xx++) {
			blocos.add(new Blokcs(xx*32,480-32));
		}
		
		for(int yy=0; yy<15*2; yy++) {
			blocos.add(new Blokcs(0,yy*32));
		}
		
		for(int yy=0; yy<15*2; yy++) {
			blocos.add(new Blokcs(640-32,yy*32));
		}
		
		blocos.add(new Blokcs(128,128));
		blocos.add(new Blokcs(480,128));
		blocos.add(new Blokcs(128,320));
		blocos.add(new Blokcs(480,320));
	}
	
	public static boolean isFree(int x, int y) {
		for(int i=0; i<blocos.size(); i++) {
			Blokcs blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}
		return true;
	}
	
	public void render(Graphics g) {
		for(int i=0; i<blocos.size(); i++) {
			blocos.get(i).render(g);
		}
	}	
}
