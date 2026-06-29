package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FormularioEstudiante extends JFrame {

    private JTextField txtNombre;
    private JTextField txtAsignatura;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtPromedio;
    private JTextField txtEstado;

    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    private JTable tabla;
    private DefaultTableModel modelo;

    private int filaSeleccionada = -1;

    public FormularioEstudiante() {

        setTitle("Sistema de Notas");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titulo = new JLabel("SISTEMA DE NOTAS");
        titulo.setFont(new Font("Arial",Font.BOLD,22));
        titulo.setBounds(300,20,300,30);
        panel.add(titulo);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(30,80,100,25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120,80,250,25);
        panel.add(txtNombre);

        JLabel lblAsignatura = new JLabel("Asignatura");
        lblAsignatura.setBounds(30,120,100,25);
        panel.add(lblAsignatura);

        txtAsignatura = new JTextField();
        txtAsignatura.setBounds(120,120,250,25);
        panel.add(txtAsignatura);

        JLabel lblNota1 = new JLabel("Nota 1");
        lblNota1.setBounds(30,160,100,25);
        panel.add(lblNota1);

        txtNota1 = new JTextField();
        txtNota1.setBounds(120,160,80,25);
        panel.add(txtNota1);

        JLabel lblNota2 = new JLabel("Nota 2");
        lblNota2.setBounds(220,160,100,25);
        panel.add(lblNota2);

        txtNota2 = new JTextField();
        txtNota2.setBounds(300,160,80,25);
        panel.add(txtNota2);

        JLabel lblPromedio = new JLabel("Promedio");
        lblPromedio.setBounds(420,80,100,25);
        panel.add(lblPromedio);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(520,80,100,25);
        txtPromedio.setEditable(false);
        panel.add(txtPromedio);

        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setBounds(420,120,100,25);
        panel.add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(520,120,100,25);
        txtEstado.setEditable(false);
        panel.add(txtEstado);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(680,60,150,30);
        panel.add(btnGuardar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(680,100,150,30);
        panel.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(680,140,150,30);
        panel.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(680,180,150,30);
        panel.add(btnLimpiar);

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Asignatura");
        modelo.addColumn("Nota 1");
        modelo.addColumn("Nota 2");
        modelo.addColumn("Promedio");
        modelo.addColumn("Estado");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30,250,820,260);

        panel.add(scroll);

        add(panel);
// Evento para seleccionar una fila de la tabla
        tabla.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {

        filaSeleccionada = tabla.getSelectedRow();

        txtNombre.setText(modelo.getValueAt(filaSeleccionada,0).toString());
        txtAsignatura.setText(modelo.getValueAt(filaSeleccionada,1).toString());
        txtNota1.setText(modelo.getValueAt(filaSeleccionada,2).toString());
        txtNota2.setText(modelo.getValueAt(filaSeleccionada,3).toString());
        txtPromedio.setText(modelo.getValueAt(filaSeleccionada,4).toString());
        txtEstado.setText(modelo.getValueAt(filaSeleccionada,5).toString());

    }
});

        // BOTÓN GUARDAR
        btnGuardar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            String nombre = txtNombre.getText();
            String asignatura = txtAsignatura.getText();

            double nota1 = Double.parseDouble(txtNota1.getText());
            double nota2 = Double.parseDouble(txtNota2.getText());

            double promedio = (nota1 + nota2) / 2;

            String estado;

            if(promedio < 2){
                estado = "Pierde";
            }else if(promedio < 3){
                estado = "Habilita";
            }else{
                estado = "Gana";
            }

            txtPromedio.setText(String.format("%.2f",promedio));
            txtEstado.setText(estado);

            modelo.addRow(new Object[]{
                    nombre,
                    asignatura,
                    nota1,
                    nota2,
                    String.format("%.2f",promedio),
                    estado
            });

            limpiarCampos();

        }catch(Exception ex){

            JOptionPane.showMessageDialog(null,
                    "Ingrese datos válidos");

        }

    }
});

        // BOTÓN LIMPIAR
        btnLimpiar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        limpiarCampos();
    }
});
        // BOTÓN ACTUALIZAR
        btnActualizar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (filaSeleccionada >= 0) {

            try {

                String nombre = txtNombre.getText();
                String asignatura = txtAsignatura.getText();

                double nota1 = Double.parseDouble(txtNota1.getText());
                double nota2 = Double.parseDouble(txtNota2.getText());

                double promedio = (nota1 + nota2) / 2;

                String estado;

                if (promedio < 2) {
                    estado = "Pierde";
                } else if (promedio < 3) {
                    estado = "Habilita";
                } else {
                    estado = "Gana";
                }

                modelo.setValueAt(nombre, filaSeleccionada, 0);
                modelo.setValueAt(asignatura, filaSeleccionada, 1);
                modelo.setValueAt(nota1, filaSeleccionada, 2);
                modelo.setValueAt(nota2, filaSeleccionada, 3);
                modelo.setValueAt(String.format("%.2f", promedio), filaSeleccionada, 4);
                modelo.setValueAt(estado, filaSeleccionada, 5);

                limpiarCampos();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Datos inválidos.");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Seleccione un registro.");

        }

    }
});

        // BOTÓN ELIMINAR
        btnEliminar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (filaSeleccionada >= 0) {

            modelo.removeRow(filaSeleccionada);
            filaSeleccionada = -1;
            limpiarCampos();

        } else {

            JOptionPane.showMessageDialog(null, "Seleccione un registro.");

        }

    }
});

        }

// MÉTODO LIMPIAR
private void limpiarCampos() {

    txtNombre.setText("");
    txtAsignatura.setText("");
    txtNota1.setText("");
    txtNota2.setText("");
    txtPromedio.setText("");
    txtEstado.setText("");

    filaSeleccionada = -1;

}

}