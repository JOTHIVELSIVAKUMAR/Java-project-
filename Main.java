import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockAWT extends Frame implements Runnable {
    private Label clockLabel;
    private Thread clockThread;

    public DigitalClockAWT() {
        // Set up the Frame
        setTitle("Digital Clock");
        setSize(300, 100);
        setLayout(new FlowLayout());
        setResizable(false);

        // Add a Label to display the time
        clockLabel = new Label();
        clockLabel.setFont(new Font("Arial", Font.BOLD, 32));
        add(clockLabel);

        // Handle window close
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        // Start the clock thread
        clockThread = new Thread(this);
        clockThread.start();
    }

    @Override
    public void run() {
        while (true) {
            // Update the time every second
            String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
            clockLabel.setText(currentTime);

            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create and display the clock
        DigitalClockAWT clock = new DigitalClockAWT();
        clock.setVisible(true);
    }
}
