## Por qué elegí HashMap para guardar las palabras del libro?

Elegí guardar las palabras del libro y su contador de cuántas veces aparecen en un Map. De esta manera,
puedo guardar las mismas en un par clave:valor, que me permite guardar la palabra y a su vez su contador.
Por otro lado, decidí usar un HashMap, ya que la búsqueda e inserción de palabras es más cercana
a O(1), a diferencia de otras estructuras que involucran más recorrido. Esto es fundamental a la
hora de buscar e insertar palabras.
Luego, a la hora de imprimirlo, decidí utilizar un array list para ordenarlo, ya que no es posible
ordenar un HashMap por sus valores.