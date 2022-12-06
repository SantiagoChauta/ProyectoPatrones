package com.catalgo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {

    private JButton botoninciciar;

    public PanelBotones() {
        this.setLayout(null);
        initcompontes();
    }

    public void initcompontes() {
        this.botoninciciar = new JButton("Iniciar Sesion");
        this.botoninciciar.setBounds(310, 40, 300, 40);
        this.botoninciciar.setAlignmentX(CENTER_ALIGNMENT);
        this.botoninciciar.setFont(new Font("Comic Sans Ms", 3, 18));
        this.add(botoninciciar);
        this.setBackground(new Color(5, 51, 77));

    }
    
    public void hacerVisible(boolean visible) {
        this.setVisible(visible);
    }

}
