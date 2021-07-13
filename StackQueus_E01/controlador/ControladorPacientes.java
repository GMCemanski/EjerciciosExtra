package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.QueueTwoStack;
import vista.IngresoPacientes;
import vista.VisorPacientes;


public class ControladorPacientes implements ActionListener{
    private QueueTwoStack pacientes;
    private IngresoPacientes ventana;
    private VisorPacientes visor;

    public ControladorPacientes(QueueTwoStack pacientes, IngresoPacientes ventana, VisorPacientes visor) {
        this.pacientes = pacientes;
        this.ventana = ventana;
        this.visor = visor;
        ventana.botonSalir.addActionListener(this);
        ventana.botonIngresoPac.addActionListener(this);
        ventana.botonSiguientePac.addActionListener(this);
        iniciar();
    }
    
    
    
    public void iniciar(){
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        visor.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Botón salir
        if(e.getSource()== ventana.botonSalir){ 
           ventana.dispose();
        }
        //Botón Ingreso
        if(e.getSource()== ventana.botonIngresoPac){ 
           pacientes.enqueue(ventana.cajaNombre.getText());
           clear();
           JOptionPane.showMessageDialog(null, "Paciente agregado con éxito");
           
        }
        //Botón Siguiente
        if(e.getSource()== ventana.botonSiguientePac){ 
            
            
            try{
                visor.labelPaciente.setText(pacientes.dequeue());
            }catch(NullPointerException ea){
                    visor.labelPaciente.setText("**NADIE PENDIENTE**");
                 };
        }
        
    }
    
    public void clear(){
        ventana.cajaNombre.setText("");
    }

}

