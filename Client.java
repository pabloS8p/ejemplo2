public class Client {  
    public static void main(String[] args) {  
        DocumentInterface[] documents = new DocumentInterface[5];  

        documents[0] = new DocumentProxy("documento1.txt");  
        documents[1] = new DocumentProxy("documento2.txt");  
        documents[2] = new DocumentProxy("documento3.txt");  
        documents[3] = new DocumentProxy("documento4.txt");  
        documents[4] = new DocumentProxy("documento5.txt");  

        String[] sampleTexts = {  
            "Este es el contenido del documento 1.",  
            "Este es el contenido del documento 2.",  
            "Este es el contenido del documento 3.",  
            "Este es el contenido del documento 4.",  
            "Este es el contenido del documento 5."  
        };  

        for (int i = 0; i < documents.length; i++) {  
            ((DocumentProxy) documents[i]).view();  
            ((DocumentProxy) documents[i]).edit(sampleTexts[i]);  // Editar con contenido de prueba  
        }  
    }  
}