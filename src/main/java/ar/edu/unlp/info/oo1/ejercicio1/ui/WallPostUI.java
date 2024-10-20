package ar.edu.unlp.info.oo1.ejercicio1.ui;

import ar.edu.unlp.info.oo1.ejercicio1.WallPost;
import ar.edu.unlp.info.oo1.ejercicio1.impl.WallPostImpl;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class WallPostUI
{

    private final WallPost  wallPost;
    private final JButton   console;
    private final JTextArea textArea;
    private final JLabel    featuredLabelTitle;
    private final JCheckBox featuredCheckbox;
    private final JLabel    likesLabelTitle;
    private final JLabel    likesLabel;
    private final JButton   like;
    private final JButton   dislike;
    private final JFrame    window;

    public WallPostUI()
    {
        this.wallPost           = new WallPostImpl();
        this.console            = new JButton("Print to Console");
        this.textArea           = new JTextArea();
        this.featuredLabelTitle = new JLabel("Featured");
        this.featuredCheckbox   = new JCheckBox();
        this.likesLabelTitle    = new JLabel("Likes");
        this.like               = new JButton("Like");
        this.likesLabel         = new JLabel();
        this.dislike            = new JButton("Dislike");
        this.window             = new JFrame("WallPost");
        this.setUpWindow();
        this.wireComponents();
        this.window.setVisible(true);
    }

    private void setUpWindow()
    {
        JPanel pane = new JPanel();
        this.window.getContentPane().add(pane);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setSize(640, 480);
        pane.setLayout(new GridLayout(5, 1, 1, 10));
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pane.add(this.console);

        JScrollPane scrollPane = new JScrollPane(this.textArea);
        pane.add(scrollPane);
        this.textArea.setEditable(true);
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);

        JPanel featuredPane = new JPanel();
        featuredPane.setLayout(new GridLayout(1, 2));
        featuredPane.add(this.featuredLabelTitle);
        featuredPane.add(this.featuredCheckbox);
        pane.add(featuredPane);

        JPanel likesPane = new JPanel();
        likesPane.setLayout(new GridLayout(1, 2));
        likesPane.add(this.likesLabelTitle);
        likesPane.add(this.likesLabel);
        likesLabel.setText("0");
        pane.add(likesPane);

        JPanel likeButtonsPane = new JPanel();
        likeButtonsPane.setLayout(new GridLayout(1, 2));
        likeButtonsPane.add(this.like);
        likeButtonsPane.add(this.dislike);
        pane.add(likeButtonsPane);

        this.window.pack();
    }

    private void wireComponents()
    {
        this.like.addActionListener(_ -> {
            this.wallPost.like();
            this.likesLabel.setText(String.valueOf(this.wallPost.getLikes()));
        });

        this.dislike.addActionListener(_ -> {
            this.wallPost.dislike();
            this.likesLabel.setText(String.valueOf(this.wallPost.getLikes()));
        });

        this.featuredCheckbox.addActionListener(_ -> this.wallPost.toggleFeatured());

        this.textArea.getDocument().addDocumentListener(new DocumentListener()
        {

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                wallPost.setText(textArea.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e)
            {
                wallPost.setText(textArea.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                wallPost.setText(textArea.getText());
            }
        });

        this.console.addActionListener(_ -> System.out.println(this.wallPost.toString()));

    }
}
