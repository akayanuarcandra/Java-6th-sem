package meWhenBored.minecraft;

import java.awt.Color;

public enum BlockType {
    AIR(Color.CYAN.darker()),          // Light blue for sky/air
    GRASS(new Color(34, 139, 34)), // Forest green
    DIRT(new Color(139, 69, 19)),  // SaddleBrown
    STONE(Color.GRAY),
    WOOD(new Color(160, 82, 45)),   // Sienna
    LEAVES(new Color(0,128,0));    // Dark Green

    private final Color color;

    BlockType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}