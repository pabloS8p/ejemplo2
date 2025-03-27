public class DocumentProxy implements DocumentInterface {  
    private RealDocument realDocument;  
    private String filename;  
    private boolean isDeleted;  

    public DocumentProxy(String filename) {  
        this.filename = filename;  
        this.isDeleted = false;  // Documento inicialmente no está borrado  
    }  

    @Override  
    public void view() {  
        if (isDeleted) {  
            System.out.println("Error: El documento ha sido eliminado y no se puede ver.");  
        } else {  
            if (realDocument == null) {  
                realDocument = new RealDocument(filename);  
            }  
            realDocument.view();  
        }  
    }  

    @Override  
    public void edit(String content) {  
        if (isDeleted) {  
            System.out.println("Error: El documento ha sido eliminado y no se puede editar.");  
        } else {  
            if (realDocument == null) {  
                realDocument = new RealDocument(filename);  
            }  
            realDocument.edit(content);  
        }  
    }  

    @Override  
    public void delete() {  
        isDeleted = true;  // Marcamos el documento como eliminado  
        if (realDocument != null) {  
            realDocument.delete();  
            realDocument = null; // Limpiamos la referencia al documento real  
        }  
    }  

    @Override  
    public void share(String user) {  
        if (isDeleted) {  
            System.out.println("Error: El documento ha sido eliminado y no se puede compartir.");  
        } else {  
            if (realDocument == null) {  
                realDocument = new RealDocument(filename);  
            }  
            realDocument.share(user);  
        }  
    }  

    public boolean isDeleted() {  
        return isDeleted;  
    }  
}