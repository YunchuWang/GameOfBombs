package gameItemCollection;

import interfaceCollection.Destroyable;
import interfaceCollection.Immovable;

public class PerishBlock implements Destroyable,Immovable {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public PerishBlock(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public PerishBlock(int width, int height) {
		this.width = width;
		this.height = height;
	}
	

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public boolean isDestroyable() {
		return false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
