import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, topPnl, centerPnl, bottomPnl;
    JButton fortuneBtn, quitBtn;
    TextArea fortuneTA;
    JScrollPane pane;
    JLabel iconLbl;
    ImageIcon fortuneIcon;

    String[] fortunes = {"Your creativity knows no bounds. Embrace it!",
            "Adventure awaits around the next corner. Be ready!",
            "Today is a perfect day to learn something new.",
            "Smile, and the world will smile back at you.",
            "Your kindness will be repaid in unexpected ways.",
            "Believe in yourself, and others will too.",
            "The best way to predict the future is to create it.",
            "Seize the day! Carpe Diem!",
            "In every problem, there's an opportunity waiting to be discovered.",
            "Your positive actions will lead to positive outcomes.",
            "The journey of a thousand miles begins with a single step.",
            "Wisdom is the greatest treasure; acquire it with every experience."};
    int curFortuneDex = -1;
    int newFortuneDex;

    public FortuneTellerFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeigh = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth * 3/4,650);
        setLocation(screenWidth / 8, (screenHeigh - 650) / 2 );

        createGUI();
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createGUI()
    {
        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createCenterPnl();
        createBottomPnl();
    }

    private void createCenterPnl()
    {
        fortuneTA = new TextArea(15, 60);
        pane = new JScrollPane(fortuneTA);
        centerPnl.add(pane);
    }

    private void createTopPnl() {
        String imagePath = "C:\\Users\\pranish\\Downloads\\FortuneTeller\\src\\image.jpg";
        ImageIcon originalIcon = new ImageIcon(imagePath);

        // Scale the image to a smaller size
        Image scaledImage = originalIcon.getImage().getScaledInstance(800, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        iconLbl = new JLabel("Read your fortune if you dare!", scaledIcon, JLabel.CENTER);
        iconLbl.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 25));
        iconLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconLbl.setVerticalTextPosition(JLabel.BOTTOM);

        topPnl.add(iconLbl);
    }

    private void createBottomPnl()
    {

        fortuneBtn = new JButton("Read My Fortune");
        fortuneBtn.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));
        fortuneBtn.addActionListener((ActionEvent ae) -> {
            do {
                Random rand = new Random();
                newFortuneDex = rand.nextInt(fortunes.length);
            }
            while (newFortuneDex == curFortuneDex);
            fortuneTA.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
            curFortuneDex = newFortuneDex;
            fortuneTA.append(fortunes[curFortuneDex] + "\n");});


        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));



        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.setLayout(new GridLayout(1,2));
        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);
    }

}