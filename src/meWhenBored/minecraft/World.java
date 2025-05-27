package meWhenBored.minecraft;

import java.util.Random;

public class World {
    private final Block[][] blocks;
    private final int width;  // in blocks
    private final int height; // in blocks

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.blocks = new Block[width][height];
        generateWorld();
    }

    private void generateWorld() {
        Random rand = new Random();
        for (int x = 0; x < width; x++) {
            // Basic terrain generation: stone, then dirt, then grass
            int groundLevel = height / 2 + rand.nextInt(3) - 1; // Slightly varying ground level
            for (int y = 0; y < height; y++) {
                if (y < groundLevel - 2) {
                    blocks[x][y] = new Block(BlockType.AIR);
                } else if (y < groundLevel) {
                     blocks[x][y] = new Block(BlockType.STONE);
                } else if (y == groundLevel) {
                    blocks[x][y] = new Block(BlockType.GRASS);
                } else if (y <= groundLevel + 2) {
                     blocks[x][y] = new Block(BlockType.DIRT);
                }
                else {
                    blocks[x][y] = new Block(BlockType.AIR); // Air above ground
                }
            }
        }
        // Add some simple "trees"
        for (int i = 0; i < width / 10; i++) {
            int treeX = rand.nextInt(width - 2) + 1; // ensure space for leaves
            int groundY = findGround(treeX);
            if (groundY > 3) { // Ensure enough space for a tree
                // Trunk
                blocks[treeX][groundY-1] = new Block(BlockType.WOOD);
                blocks[treeX][groundY-2] = new Block(BlockType.WOOD);
                blocks[treeX][groundY-3] = new Block(BlockType.WOOD);
                // Leaves
                blocks[treeX-1][groundY-3] = new Block(BlockType.LEAVES);
                blocks[treeX+1][groundY-3] = new Block(BlockType.LEAVES);
                blocks[treeX-1][groundY-4] = new Block(BlockType.LEAVES);
                blocks[treeX][groundY-4] = new Block(BlockType.LEAVES);
                blocks[treeX+1][groundY-4] = new Block(BlockType.LEAVES);

            }
        }
    }
    
    private int findGround(int x) {
        for (int y = 0; y < height; y++) {
            if (blocks[x][y].getType() != BlockType.AIR) {
                return y;
            }
        }
        return height -1; // Should not happen with proper generation
    }


    public Block getBlock(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return blocks[x][y];
        }
        return null; // Out of bounds
    }

    public void setBlock(int x, int y, BlockType type) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            blocks[x][y].setType(type);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
