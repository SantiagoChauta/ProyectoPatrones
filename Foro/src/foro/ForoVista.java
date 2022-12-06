/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foro;

import com.cableado.IComunidad;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Raul Pachon
 */
public class ForoVista implements IComunidad {

    static Object getTema() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    private int Fseleccionado;
    private ReviewDeProductos review;
    private  Foro foro;
    private  Usuario usuario;
    private String unidad;
    private JFrame frame;
    private JComboBox combo;
    private List<String> myList,myList2;
    private JList lista ,listaforos;
    DefaultListModel modeloforos, modeloforo ;
    public static void main(String[] args) {
        ForoVista f =new ForoVista();
    }

    public ForoVista() {
            myList = new ArrayList<>();
            myList2 = new ArrayList<>();
            lista = new JList();
            review=new ReviewDeProductos();
           
            usuario=new Usuario(review);
            
            listaforos = new JList();
            modeloforo = new DefaultListModel<String>();
            modeloforos = new DefaultListModel<String>();
            this.frame = new JFrame("Foro");
            frame.setSize(1000, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            JPanel panel = new JPanel(); 
            Fseleccionado=0;
            frame.add(panel);
            cargarOpiniones();
            placeComponents(panel);
            frame.setVisible(true);
    }
        
	private void placeComponents(JPanel panel) {
            
       
                JPanel nuevoforo = new JPanel();
                JPanel foros = new JPanel();
		panel.add(nuevoforo);
                panel.add(foros);
                
                nuevoforo.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Tema"));
                foros.setBorder(javax.swing.BorderFactory.createTitledBorder("Foros existentes"));
                nuevoforo.setBounds(1,1 , 1000,100);
                foros.setBounds(1, 100,1000 ,550);
               
                nuevoforo.setLayout(null);
                foros.setLayout(null);
                
                
		panel.setLayout(null);

                
                listaforos.setBounds(30, 50, 300, 500);
                listaforos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setViewportView(listaforos);
                listaforos.setLayoutOrientation(JList.VERTICAL);
                //lista.setCellRenderer(cellRenderer);
                foros.add(listaforos);
                listaforos.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        listaforos = (JList)evt.getSource();
                        if (evt.getClickCount() == 2) {
                        
                            // Double-click detected
                           
                            Fseleccionado = listaforos.locationToIndex(evt.getPoint()); 
                            selecionar(Fseleccionado);
                            
                    }}
                });
                
                
                 
                lista.setBounds(380, 50, 300, 500);
                lista.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                JScrollPane scrollPane1 = new JScrollPane();
                scrollPane1.setViewportView(lista);
                lista.setLayoutOrientation(JList.VERTICAL);
                //lista.setCellRenderer(cellRenderer);
                foros.add(lista);

		JLabel txt1 = new JLabel("ingrese un nuevo tema de discución:");
		txt1.setBounds(30, 50, 260, 25);
                nuevoforo.add(txt1);
               
                JTextField tema = new JTextField();
		tema.setBounds(280,50, 170, 25);
                nuevoforo.add(tema);
                
                JLabel txt2 = new JLabel("ingrese el comentario:");
		txt2.setBounds(735, 100, 260, 25);
                txt2.setEnabled(false);
                foros.add(txt2);
               
                JTextArea teman = new JTextArea();
		teman.setBounds(740,150, 200, 300);
                teman.setOpaque(false);
                teman.setEnabled(false);
                teman.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                foros.add(teman);

                  JButton Publicar = new JButton("Publicar");
		Publicar.setBounds(500, 50, 100, 25);
		nuevoforo.add(Publicar);
                Publicar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                         modeloforos.addElement(tema.getText());
                          listaforos.setModel(modeloforos);
                          JOptionPane.showMessageDialog(null,"se guardo satisfactoriamente el nuevo tema de discucion" );
                    }
                });     
        
                JButton Agregar = new JButton("Agregar Comentario");
		Agregar.setBounds(740, 480, 180, 25);
                Agregar.setEnabled(false);
		foros.add(Agregar);
                Agregar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null,"se guardo satisfactoriamente el comentario" );
                        publicarOpinion(teman.getText());
                        teman.setText("");
                        Agregar.setEnabled(false);
                        teman.setEnabled(false);
                        teman.setOpaque(false);
                        txt2.setEnabled(false);
                        
                    }
                });
                JButton Participar = new JButton("Participar");
		Participar.setBounds(740, 50, 180, 25);
		foros.add(Participar);
                Participar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Agregar.setEnabled(true);
                         teman.setEnabled(true);
                          txt2.setEnabled(true);
                          teman.setOpaque(true);
                    }
                });
                   
        }
        
     
        public void selecionar (int n) {
            modeloforo.removeAllElements();
            lista.setModel(modeloforo); 
            review.setTema(myList.get(n));
            if(n<19){
               for (int index = 0; index < 15; index++) {
               myList2.add(myList.get(n)+": comentario# " + index);
            }
                for (int i=0;i<myList2.size();i++) {
                        modeloforo.addElement(myList2.get(i));
                }  lista.setModel(modeloforo);
            }

            
        }
    @Override
    public void publicarOpinion(String Mensaje) {
        modeloforo.addElement(Mensaje);
        lista.setModel(modeloforo);
        review.setEstado("activo");
        
    }

    @Override
    public void borrarOpinion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarOpinion(int id, String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarOpiniones() {
    
             for (int index = 0; index < 20; index++) {
               myList.add("Tema # " + index);
             }
             modeloforos = new DefaultListModel<>();
                for (int i=0;i<myList.size();i++) {
                        modeloforos.addElement(myList.get(i));
                }
            
            listaforos.setModel(modeloforos);
            
          
            lista.setModel(modeloforo);
            
    }
}
