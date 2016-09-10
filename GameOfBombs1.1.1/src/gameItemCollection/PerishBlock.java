package gameItemCollection;

import interfaceCollection.Destroyable;
import interfaceCollection.Immovable;

public class PerishBlock implements Destroyable,Immovable {
	
	protected int col;
	protected int row;
	protected int width;
	protected int height;
	
	public PerishBlock(int col, int row, int width, int height) {
		this.row = row;
		this.col = col;
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

	

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
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
