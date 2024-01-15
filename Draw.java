import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Draw extends JPanel {

    private int treeDepth;

    public Draw() {
        super(); // Call to super() to initialize JPanel properly
        treeDepth = 19; // Default depth
    }

    public void setTreeDepth(int depth) {
        this.treeDepth = depth;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2.0f));

        drawTree(g2, getWidth() / 2, getHeight() / 2, 90, treeDepth);
    }

    private void drawTree(Graphics2D g2, double x, double y, double angle, int depth) {
        if (depth == 0) {
            return;
        }

        double length = 50 * (depth / 10.0);

        Line2D.Double line = new Line2D.Double(x, y, x + length * Math.cos(Math.toRadians(angle)),
                y - length * Math.sin(Math.toRadians(angle)));

        g2.draw(line);

        double endX = line.x2;
        double endY = line.y2;

        drawTree(g2, endX, endY, angle - 20, depth - 1);
        drawTree(g2, endX, endY, angle + 20, depth - 1);
    }
}
