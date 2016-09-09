package gameItemCollection;

public class Bomb extends PerishBlock {
	private long creationTime;
	private double timeDuration;
	boolean explode;
	public Bomb(int x, int y, int width, int height, boolean explode) {
		super(x, y, width, height);
		this.creationTime = System.nanoTime();
		this.timeDuration = 3.0;
		this.explode = false;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isExplode() {
		return ((System.nanoTime() - this.creationTime) / 1000000000.0 > this.timeDuration);
	}
	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	

}
