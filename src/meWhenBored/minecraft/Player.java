package meWhenBored.minecraft;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x; // grid x
    private int y; // grid y
    private BlockType selectedBlockType;
    private final BlockType[] placeableBlocks = {BlockType.DIRT, BlockType.STONE, BlockType.WOOD, BlockType.LEAVES};
    private int selectedBlockIndex = 0;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.selectedBlockType = placeableBlocks[selectedBlockIndex];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int dx, int dy, World world) {
        int newX = x + dx;
        int newY = y + dy;

        // Basic collision: can only move into AIR blocks
        if (world.getBlock(newX, newY) != null && world.getBlock(newX, newY).getType() == BlockType.AIR) {
            this.x = newX;
            this.y = newY;
        }
    }

    public BlockType getSelectedBlockType() {
        return selectedBlockType;
    }

    public void cycleSelectedBlock() {
        selectedBlockIndex = (selectedBlockIndex + 1) % placeableBlocks.length;
        selectedBlockType = placeableBlocks[selectedBlockIndex];
    }
    
    public BlockType[] getPlaceableBlocks() {
        return placeableBlocks;
    }
    
    public int getSelectedBlockIndex() {
        return selectedBlockIndex;
    }

    public void draw(Graphics g, int blockSize, int screenOffsetX, int screenOffsetY) {
        g.setColor(Color.RED); // Player is a red square
        g.fillRect((x * blockSize) - screenOffsetX, (y * blockSize) - screenOffsetY, blockSize, blockSize);
    }
}
