package com.catalgo;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PanelCatalogo extends JPanel {

    public PanelCatalogo() {
        this.setLayout(null);
        this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(2000,2000));
        initcompontes();
    }

    public void initcompontes() {
        

    }

    public void hacerVisible(boolean visible) {
        this.setVisible(visible);
    }
    

}
