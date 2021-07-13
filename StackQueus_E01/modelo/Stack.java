
package modelo;


public class Stack {
    private Node top;
    
    public Stack(){

    }
    
    public boolean isEmpty(){
        return top==null; //Si top es igual a null significa que está vacio
        
    }
    
    public String peek(){
        return top.getData();
    }
    
    // Agrega nodo nuevo con el dato que se le brinda, queda en el tope y el nodo anterior es asignado como el next de este nuevo nodo
    public void push(String data){
        Node node = new Node(data);
        node.setNext(top);
        top = node;
    }
    
    // Devuelve el valor del tope, lo borra y asigna el siguiente nodo.
    public String pop(){
        String data = top.getData();
        top = top.getNext();
        return data;
    }
}
