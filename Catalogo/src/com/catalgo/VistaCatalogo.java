package com.catalgo;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class VistaCatalogo extends JFrame {
    
    private JLabel titulo;
    private JLabel Logo;
    private PanelCatalogo catalogo;
    private JScrollPane scrollPane;
    private PanelBotones bPanelBotones;

    public VistaCatalogo() {
        this.setLayout(null);
        initcomponentesPanel();
        this.setTitle("CATALOGO");
        this.setBounds(0, 0, 1000, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initcomponentesPanel() {
        
        //Encabezado
        this.titulo = new JLabel("BIENVENIDO A TGMECHANICAL");
        this.titulo.setBounds(340, 20, 300, 40);
        this.titulo.setAlignmentX(CENTER_ALIGNMENT);
        this.titulo.setFont(new Font("Comic Sans MS", 3, 18));
        this.titulo.setForeground(Color.WHITE);
        this.add(titulo);
        // Logo
        this.Logo = new JLabel();
        Image imageLogo = new ImageIcon(getClass().getResource("/images/pngwing.com.png")).getImage();
        this.Logo.setIcon(new ImageIcon(imageLogo.getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
        this.Logo.setBounds(385, 70, 350, 100);
        this.add(Logo);
        
        // Catalago 
        this.scrollPane = new JScrollPane();
        this.scrollPane.setBounds(0, 190, 1000, 400);
        this.catalogo = new PanelCatalogo();
        this.scrollPane.setViewportView(this.catalogo);
        this.add(scrollPane);

        // footer
        this.bPanelBotones = new PanelBotones();
        this.bPanelBotones.setBounds(13, 600,960 , 150);
        this.bPanelBotones.hacerVisible(true);
        this.add(bPanelBotones);
        ////////////////////////////////////
        this.getContentPane().setBackground(new Color(5, 51, 77));
    }
    
    public void CambiarVisibilidad(boolean visible) {
        this.setVisible(visible);
    } 

}
