package meWhenBored.minecraft;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

    private static final int BLOCK_SIZE = 32; // Size of each block in pixels
    private static final int SCREEN_WIDTH_BLOCKS = 25; // How many blocks wide the screen is
    private static final int SCREEN_HEIGHT_BLOCKS = 20; // How many blocks high

    public static final int SCREEN_WIDTH = SCREEN_WIDTH_BLOCKS * BLOCK_SIZE;
    public static final int SCREEN_HEIGHT = SCREEN_HEIGHT_BLOCKS * BLOCK_SIZE;

    private static final int WORLD_WIDTH_BLOCKS = 100; // Total world width
    private static final int WORLD_HEIGHT_BLOCKS = 50;  // Total world height

    private World world;
    private Player player;
    private Timer timer;

    // Camera/viewport offsets
    private int screenOffsetX = 0;
    private int screenOffsetY = 0;

    // Mouse interaction
    private Point mouseGridPos = new Point(-1, -1); // Grid coordinates of mouse

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        world = new World(WORLD_WIDTH_BLOCKS, WORLD_HEIGHT_BLOCKS);
        // Find a starting spot for the player (first air block above ground)
        int startX = WORLD_WIDTH_BLOCKS / 2;
        int startY = 0;
        for (int y = 0; y < world.getHeight(); y++) {
            if (world.getBlock(startX, y) != null && world.getBlock(startX, y).getType() != BlockType.AIR) {
                startY = y - 1; // Start in the air block just above ground
                break;
            }
        }
        if (startY < 0) startY = world.getHeight() / 2 - 5; // Failsafe

        player = new Player(startX, startY);

        timer = new Timer(100, this); // Update roughly 10 times per second
        timer.start();
    }

    // Game loop action
    @Override
    public void actionPerformed(ActionEvent e) {
        updateGame();
        repaint();
    }

    private void updateGame() {
        // Update camera to follow player
        // Center player X
        screenOffsetX = player.getX() * BLOCK_SIZE - SCREEN_WIDTH / 2 + BLOCK_SIZE / 2;
        // Center player Y
        screenOffsetY = player.getY() * BLOCK_SIZE - SCREEN_HEIGHT / 2 + BLOCK_SIZE / 2;


        // Clamp camera to world boundaries
        screenOffsetX = Math.max(0, Math.min(screenOffsetX, WORLD_WIDTH_BLOCKS * BLOCK_SIZE - SCREEN_WIDTH));
        screenOffsetY = Math.max(0, Math.min(screenOffsetY, WORLD_HEIGHT_BLOCKS * BLOCK_SIZE - SCREEN_HEIGHT));
        
        // Simple gravity
        Block blockBelow = world.getBlock(player.getX(), player.getY() + 1);
        if (blockBelow != null && blockBelow.getType() == BlockType.AIR) {
            player.move(0, 1, world); // Fall one block
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawWorld(g);
        player.draw(g, BLOCK_SIZE, screenOffsetX, screenOffsetY);
        drawMouseSelector(g);
        drawHotbar(g);
    }

    private void drawWorld(Graphics g) {
        // Calculate which blocks are visible on screen
        int startX = screenOffsetX / BLOCK_SIZE;
        int startY = screenOffsetY / BLOCK_SIZE;
        int endX = startX + SCREEN_WIDTH_BLOCKS + 1; // +1 for partial blocks
        int endY = startY + SCREEN_HEIGHT_BLOCKS + 1;

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                Block block = world.getBlock(x, y);
                if (block != null) {
                    g.setColor(block.getType().getColor());
                    g.fillRect((x * BLOCK_SIZE) - screenOffsetX, (y * BLOCK_SIZE) - screenOffsetY, BLOCK_SIZE, BLOCK_SIZE);
                    // Simple border for blocks
                    g.setColor(Color.DARK_GRAY);
                     g.drawRect((x * BLOCK_SIZE) - screenOffsetX, (y * BLOCK_SIZE) - screenOffsetY, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }
    
    private void drawMouseSelector(Graphics g) {
        if (mouseGridPos.x != -1 && mouseGridPos.y != -1) {
            g.setColor(Color.YELLOW);
            g.drawRect(mouseGridPos.x * BLOCK_SIZE - screenOffsetX, 
                       mouseGridPos.y * BLOCK_SIZE - screenOffsetY, 
                       BLOCK_SIZE, BLOCK_SIZE);
        }
    }

    private void drawHotbar(Graphics g) {
        int hotbarX = 10;
        int hotbarY = SCREEN_HEIGHT - BLOCK_SIZE - 10;
        BlockType[] placeable = player.getPlaceableBlocks();

        for (int i = 0; i < placeable.length; i++) {
            g.setColor(placeable[i].getColor());
            g.fillRect(hotbarX + i * (BLOCK_SIZE + 5), hotbarY, BLOCK_SIZE, BLOCK_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(hotbarX + i * (BLOCK_SIZE + 5), hotbarY, BLOCK_SIZE, BLOCK_SIZE);

            if (i == player.getSelectedBlockIndex()) {
                g.setColor(Color.YELLOW);
                g.drawRect(hotbarX + i * (BLOCK_SIZE + 5) - 2, hotbarY - 2, BLOCK_SIZE + 4, BLOCK_SIZE + 4);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Selected: " + player.getSelectedBlockType().name(), hotbarX, hotbarY - 5);
        g.drawString("Controls: Arrow keys (move), Q (cycle block), Left-Click (break), Right-Click (place)", 10, 20);
        g.drawString("Mouse at: " + mouseGridPos.x + "," + mouseGridPos.y, 10, 40);

    }

    // --- Input Handling ---
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int playerX = player.getX();
        int playerY = player.getY();
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player.move(-1, 0, world);
                break;
            case KeyEvent.VK_RIGHT:
                player.move(1, 0, world);
                break;
            case KeyEvent.VK_UP:
                 // Simple jump: if standing on something, move up. Gravity will pull down.
                Block blockBelow = world.getBlock(playerX, playerY + 1);
                Block blockTwoBelow = world.getBlock(playerX, playerY + 2); // For head clearance

                if (blockBelow != null && blockBelow.getType() != BlockType.AIR && 
                    world.getBlock(playerX, playerY-1) != null && world.getBlock(playerX, playerY-1).getType() == BlockType.AIR) { // Check if standing on something and space above
                    player.move(0, -2, world); // Jump two blocks up
                }
                break;
            // case KeyEvent.VK_DOWN: // No down movement, gravity handles it
            //    player.move(0, 1, world);
            //    break;
            case KeyEvent.VK_Q:
                player.cycleSelectedBlock();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
         int gridX = (e.getX() + screenOffsetX) / BLOCK_SIZE;
         int gridY = (e.getY() + screenOffsetY) / BLOCK_SIZE;

        if (gridX >= 0 && gridX < world.getWidth() && gridY >= 0 && gridY < world.getHeight()) {
            if (SwingUtilities.isLeftMouseButton(e)) { // Break block
                if (world.getBlock(gridX, gridY).getType() != BlockType.AIR) { // Don't break air
                    world.setBlock(gridX, gridY, BlockType.AIR);
                }
            } else if (SwingUtilities.isRightMouseButton(e)) { // Place block
                 // Only place if the target block is AIR and it's not where the player is
                if (world.getBlock(gridX, gridY).getType() == BlockType.AIR && 
                    !(gridX == player.getX() && gridY == player.getY())) {
                    world.setBlock(gridX, gridY, player.getSelectedBlockType());
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseGridPos.x = (e.getX() + screenOffsetX) / BLOCK_SIZE;
        mouseGridPos.y = (e.getY() + screenOffsetY) / BLOCK_SIZE;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e); // Treat drag as move for selector update
    }
}