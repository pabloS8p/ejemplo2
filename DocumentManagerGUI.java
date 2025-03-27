import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class DocumentManagerGUI {  
    private JFrame frame;  
    private JTextArea outputArea;  
    private DocumentProxy[] documents;  

    public DocumentManagerGUI() {  
        // Crear los documentos de prueba  
        documents = new DocumentProxy[5];  
        documents[0] = new DocumentProxy("documento1.txt");  
        documents[1] = new DocumentProxy("documento2.txt");  
        documents[2] = new DocumentProxy("documento3.txt");  
        documents[3] = new DocumentProxy("documento4.txt");  
        documents[4] = new DocumentProxy("documento5.txt");  

        // Ventana principal  
        frame = new JFrame("Gestor de Documentos");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(600, 400);  
        frame.getContentPane().setBackground(new Color(50, 50, 50));  
        frame.setLayout(new BorderLayout(10, 10));  

        // Área de texto  
        outputArea = new JTextArea();  
        outputArea.setEditable(false);  
        outputArea.setBackground(new Color(30, 30, 30));  
        outputArea.setForeground(Color.WHITE);  
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));  

        JScrollPane scrollPane = new JScrollPane(outputArea);  
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255, 153, 51), 2));  

        // Panel para botones  
        JPanel buttonPanel = new JPanel();  
        buttonPanel.setLayout(new GridLayout(5, 3, 10, 10)); // Cuadrícula de botones  
        buttonPanel.setBackground(new Color(70, 70, 70));  

        // Agregar botones  
        for (int i = 0; i < documents.length; i++) {  
            final int index = i;  

            // Botón para ver documento  
            JButton viewButton = new JButton("Ver Documento " + (i + 1));  
            viewButton.setBackground(new Color(255, 153, 51));  
            viewButton.setForeground(Color.BLACK);  
            viewButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  
            viewButton.addActionListener(new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) {  
                    documents[index].view();  
                    outputArea.append("Accediendo desde el Proxy: Viendo documento " + (index + 1) + "\n");  
                }  
            });  

            // Botón para editar documento  
            JButton editButton = new JButton("Editar Documento " + (i + 1));  
            editButton.setBackground(new Color(255, 204, 51));  
            editButton.setForeground(Color.BLACK);  
            editButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  
            editButton.addActionListener(new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) {  
                    documents[index].edit("Contenido actualizado del documento " + (index + 1));  
                    outputArea.append("Accediendo desde el Proxy: Editando documento " + (index + 1) + "\n");  
                }  
            });  

            // Botón para borrar documento  
            JButton deleteButton = new JButton("Borrar Documento " + (i + 1));  
            deleteButton.setBackground(new Color(255, 102, 102));  
            deleteButton.setForeground(Color.BLACK);  
            deleteButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));  
            deleteButton.addActionListener(new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) {  
                    documents[index].delete();  
                    outputArea.append("Accediendo desde el Proxy: Documento " + (index + 1) + " ha sido eliminado.\n");  
                    // Deshabilitar botones si el documento ha sido eliminado  
                    viewButton.setEnabled(false);  
                    editButton.setEnabled(false);  
                    deleteButton.setEnabled(false);  
                }  
            });  

            // Agregar botones al panel  
            buttonPanel.add(viewButton);  
            buttonPanel.add(editButton);  
            buttonPanel.add(deleteButton);  
        }  

        // Adición de componentes a la ventana principal  
        frame.add(scrollPane, BorderLayout.CENTER);  
        frame.add(buttonPanel, BorderLayout.SOUTH);  
        
        // Hacer visible la ventana  
        frame.setVisible(true);  
    }  

    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> new DocumentManagerGUI());  
    }  
}