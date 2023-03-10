import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MUÑECO extends JFrame implements ActionListener, ChangeListener {

    private final Timer timer;
    private int velocidad = 100; 
    private final JSlider slider;
    private final JLabel imagenLabel;
    private final ImageIcon[] imagenes;

    public MUÑECO() {
        super("MUÑECO");
        this.imagenes = new ImageIcon[]{new ImageIcon("D:\\Users\\user\\Desktop\\3er semestre\\Programacion/figura1.png"), new ImageIcon("D:\\Users\\user\\Desktop\\3er semestre\\Programacion/figura2.png"), new ImageIcon("D:\\Users\\user\\Desktop\\3er semestre\\Programacion/figura3.png"), new ImageIcon("D:\\Users\\user\\Desktop\\3er semestre\\Programacion/figura4.png")};

        timer = new Timer(velocidad, this);
        timer.setInitialDelay(0);
        
        slider = new JSlider(JSlider.HORIZONTAL, 50, 500, velocidad);
        slider.addChangeListener(this);

        imagenLabel = new JLabel(imagenes[0]);
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);
        imagenLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(imagenLabel, BorderLayout.CENTER);
        contentPane.add(slider, BorderLayout.SOUTH);
        setContentPane(contentPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imagenLabel.setIcon(imagenes[(imagenes.length + 1 + Arrays.asList(imagenes).indexOf(imagenLabel.getIcon())) % imagenes.length]);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        velocidad = slider.getValue();
        timer.setDelay(velocidad);
    }

    public static void main(String[] args) {
        MUÑECO MUÑECO = new MUÑECO();
    }
}
