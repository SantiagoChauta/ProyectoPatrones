package com.formulario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.cableado.ISesion;
import com.cableado.IUsuario;
import com.cliente.Tablas.Cliente;
import com.formulario.componentes.Apellido;
import com.formulario.componentes.Cedula;
import com.formulario.componentes.Componente;
import com.formulario.componentes.Correo;
import com.formulario.componentes.GuardarDatos;
import com.formulario.componentes.IniciarSesion;
import com.formulario.componentes.Nombre;
import com.formulario.componentes.Password;
import com.formulario.componentes.Registrarse;
import com.formulario.componentes.Titulo;
import com.utilidades.Cargador;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Registro implements ISesion,Formulario {
	
	public static void main(String [] args) {
		new Registro();
	}
	
	private Titulo titulo;
	private Nombre nombre;
	private Apellido apellido;
	private Cedula cedula;
	private Correo correo;
	private Password password;
	private Registrarse bregistrarse;
	private IniciarSesion biniciar_sesion;
	private GuardarDatos bguardar_datos;
	private String[] datos;
	
	JFrame ventana = new JFrame("Formulario");
	
	private JLabel lNombre = new JLabel("Nombre:");
	private JLabel lApellido = new JLabel("Apellido:");
	private JLabel lCedula = new JLabel("Cedula");
	private JLabel lCorreo =new JLabel("Correo:");
	private JLabel lPassword = new JLabel("Contraseña:");
	
	public Registro() {
		registrarComponente(new Titulo());
		registrarComponente(new Nombre());
		registrarComponente(new Apellido());
		registrarComponente(new Correo());
		registrarComponente(new Cedula());
		registrarComponente(new Password());
		registrarComponente(new IniciarSesion());
		registrarComponente(new Registrarse());
		registrarComponente(new GuardarDatos());
		createGUI();
	}
	
	@Override
	public void registrarComponente(Componente componente) {
		componente.setMediador(this);
		switch(componente.getname()){
			case "Titulo":
				titulo = (Titulo)componente;
				break;
			case "Nombre":
				nombre = (Nombre)componente;
				break;
			case "Apellido":
				apellido=(Apellido)componente;
				break;
			case "Correo":
				correo =(Correo)componente;
				break;
			case "Cedula":
				cedula=(Cedula)componente;
				break;
			case "Password":
				password=(Password)componente;
				break;
			case "Iniciar Sesion":
				biniciar_sesion = (IniciarSesion)componente;
				break;
			case "Registrarse":
				bregistrarse =(Registrarse)componente;
				break;
			case "Guardar Datos":
				bguardar_datos=(GuardarDatos)componente;
				break;
		}
	}

	@Override
	public void ocultarElementos(boolean flag,String title) {
		ventana.setVisible(false);
		titulo.setText(title);
		if(!flag) {
			ventana.setSize(300,440);
			
			ventana.setLocationRelativeTo(null);
			
			titulo.setBounds(100, 30, 150, 35);;
			lNombre.setVisible(!flag);
			nombre.setVisible(!flag);
			lApellido.setVisible(!flag);
			apellido.setVisible(!flag);
			lCorreo.setVisible(!flag);
			correo.setVisible(!flag);
			lPassword.setBounds(50,270,80,20);
			password.setBounds(50,293,190,20);
			lCedula.setBounds(50,170,80,20);
			cedula.setBounds(50,193,190,20);
			biniciar_sesion.setVisible(flag);
			bregistrarse.setVisible(flag);
			ventana.setVisible(true);
			bguardar_datos.setVisible(!flag);
		}
		else {
			ventana.setSize(300, 300);
			ventana.setLocationRelativeTo(null);
			
			titulo.setBounds(75, 30, 150, 35);
			lNombre.setVisible(!flag);
			nombre.setVisible(!flag);
			lApellido.setVisible(!flag);
			apellido.setVisible(!flag);
			lCorreo.setVisible(!flag);
			correo.setVisible(!flag);
			lCedula.setBounds(50,70,60,20);
			cedula.setBounds(50, 93, 190, 20);
			lPassword.setBounds(50,120,80,20);
			password.setBounds(50,143,190,20);
			biniciar_sesion.setVisible(flag);
			bregistrarse.setVisible(flag);
			bguardar_datos.setVisible(!flag);
			ventana.setVisible(true);
		}
	}


	@Override
	public void ingresar() {
		String ced = cedula.getText();
		String pass = password.getText();
		String[] d = {ced,pass};
		if(ced.isBlank() || pass.isBlank()) {
			JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
		}else {
			datos = d;
		}
	}
	
	@Override
	public void registrar() {
		String name = nombre.getText();
		String last_name = apellido.getText();
		String email = correo.getText();
		String id = cedula.getText();
		String pass = password.getText();
		String[] d = {name,last_name,email,id,pass};
		if(name.isBlank() || last_name.isBlank() || email.isBlank() || id.isBlank() || pass.isBlank()) {
			JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
		}else {
			datos = d;
		}
	}
	
	
	public void createGUI() {
		
		ventana.setSize(300, 300);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(600,600);
		
		Font fuenteLabels = new Font("Times new Roman",1,12);
		
		//componente Titulo
		titulo.setText("Iniciar Sesion");
		titulo.setPreferredSize(new Dimension(150,25));
		titulo.setFont(new Font("Times New Roman",2,25));
		titulo.setBounds(75, 30, 150, 35);
		
		//Componente Nombre
		lNombre.setFont(fuenteLabels);
		lNombre.setBounds(50,70,60,20);
		lNombre.setVisible(false);
		nombre.setBounds(50, 93, 190, 20);
		nombre.setVisible(false);
		
		//Componente Apellido
		lApellido.setFont(fuenteLabels);
		lApellido.setBounds(50,120,80,20);
		lApellido.setVisible(false);
		apellido.setBounds(50,143,190,20);
		apellido.setVisible(false);
		
		//Componente Correo 
		lCorreo.setFont(fuenteLabels);
		lCorreo.setBounds(50,220,80,20);
		correo.setBounds(50,243,190,20);
		lCorreo.setVisible(false);
		correo.setVisible(false);
		
		//Componente Cedula
		lCedula.setFont(fuenteLabels);
		lCedula.setBounds(50,70,60,20);
		cedula.setBounds(50, 93, 190, 20);
		
		//Componente Password
		lPassword.setFont(fuenteLabels);
		lPassword.setBounds(50,120,80,20);
		password.setBounds(50,143,190,20);
		
		//Componente Boton Iniciar Sesion
		biniciar_sesion.setBounds(20, 180, 120, 40);
		
		//Componente Boton Registrarse
		bregistrarse.setBounds(150,180,120,40);
		
		//Componente Boton Guardar Datos
		bguardar_datos.setBounds(90, 330, 120, 40);
		
		panel.add(titulo);
		panel.add(lNombre);
		panel.add(nombre);
		panel.add(lApellido);
		panel.add(apellido);
		panel.add(lCorreo);
		panel.add(correo);
		panel.add(lCedula);
		panel.add(cedula);
		panel.add(lPassword);
		panel.add(password);
		panel.add(biniciar_sesion);
		panel.add(bregistrarse);
		panel.add(bguardar_datos);
		ventana.getContentPane().add(panel);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}

	@Override
	public String[] regresarFormulario() {
		return datos;
	}
	

}
