import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends JFrame {

    private JSlider slider;
    private Draw drawPanel;

    public Main() {
        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5); // Set initial value to 5
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        drawPanel = new Draw();

        JPanel controlPanel = new JPanel();
        controlPanel.add(slider);

        add(controlPanel, "South");
        add(drawPanel);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                drawPanel.setTreeDepth(value);
                drawPanel.repaint();
            }
        });
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
