package com.certus.sistemaventas;

import com.certus.sistemaventas.ui.*;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class SistemaVentas {

    public static void main(String[] args) {
        // Flatlaf configuraciones globales UI
        FlatLightLaf.setup();
        UIManager.put( "TextComponent.arc", 10 );
        UIManager.put( "Component.arc", 10 );
        UIManager.put( "Component.arrowType", "triangle" );
        
        new Login().setVisible(true);
    }
}
