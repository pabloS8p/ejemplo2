public class RealDocument implements DocumentInterface {  
    private String filename;  

    public RealDocument(String filename) {  
        this.filename = filename;  
        loadDocument();  
    }  

    private void loadDocument() {  
        System.out.println("Cargando documento: " + filename);  
    }  

    @Override  
    public void view() {  
        System.out.println("Viendo documento: " + filename);  
    }  

    @Override  
    public void edit(String content) {  
        System.out.println("Editando documento: " + filename + " con contenido: " + content);  
    }  

    @Override  
    public void delete() {  
        System.out.println("Documento " + filename + " ha sido eliminado.");  
    }  

    @Override  
    public void share(String user) {  
        System.out.println("Documento " + filename + " compartido con: " + user);  
    }  
}