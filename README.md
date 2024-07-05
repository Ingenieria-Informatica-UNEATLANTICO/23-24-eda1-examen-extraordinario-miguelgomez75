En este Archivo se documenta como se planea afrontar este problema:

- El código actual de la hamburguesa al estar construido por medio de arrays impide algunas de las funciones de un crud, es decir al haber tamaño fijo no se puede añadir, si se puede editar algo ya existente pero tampoco se permite eliminar algo ya existente.

Mi idea para el problema es transformar el procesado de la hamburguesa para que se trate con una lista enlazada, la cual elimina todas las restricciones ya mencionadas debido a que no posee limitaciones de tamaño, haciendo posible añadir y eliminar y añadir elementos en medio de su contenido.

En el resultado se trata todo lo referente a la lista en la clase ListaHamburguesa que usa la clase Nodo para referir los ingredientes, la clase Hamburguesa crea una lista en la que inicialmente se añaden unos ingredientes determinados (panes y carne de res), una vez hecha la hamburguesa predefinida se te ofrece un crud donde modificar ya sea agregando, eliminando o intercambiando elementos, una vez acabado introduces 4 y acabas dichos cambios 