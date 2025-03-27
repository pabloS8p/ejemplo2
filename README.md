# Explicacion del programa 

Descripción Breve del Programa
El Gestor de Documentos es una aplicación Java que permite a los usuarios gestionar documentos de manera sencilla. Los usuarios pueden ver, editar y eliminar documentos a través de una interfaz gráfica intuitiva. La aplicación utiliza el patrón de diseño Proxy para controlar el acceso a los documentos, asegurando que se gestionen adecuadamente las operaciones permitidas.

# Explicacion del metodo proxy

Patrón Proxy Implementado
El patrón Proxy permite crear una clase que actúa como intermediaria entre el usuario y el objeto real (el documento). Esto tiene las siguientes ventajas:

Control de Acceso: El Proxy puede gestionar el acceso a los métodos del documento real. Por ejemplo, si un documento ha sido eliminado, el Proxy impide que el usuario acceda a él para verlo o editarlo.

Cargar Bajo Demanda: El Proxy puede retrasar la instanciación del documento real hasta que realmente se necesite, lo que mejora el rendimiento en algunos casos.

Deshabilitar Funcionalidades: Cuando un documento es eliminado, el Proxy desactiva los botones correspondientes en la interfaz, informando al usuario que no está disponible.

Este enfoque proporciona una capa adicional de control y seguridad en la gestión de documentos.

Por Pablo Rodriguez Casado, Miguel Angel Varo, Manuel Cañas Perez Angulo
