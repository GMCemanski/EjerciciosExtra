package modelo;


public  class QueueTwoStack {
    private Stack stackNewestOnTop = new Stack();
    private Stack stackOldestOnTop = new Stack();


    public QueueTwoStack(){
    }
    
    
    public void enqueue(String value){ // Agregar valor nuevo
        stackNewestOnTop.push(value);
        
    }
    
    public String peek(){ //Obtener el más viejo
        shiftsStacks();
        return stackOldestOnTop.peek();
    }
    
    public String dequeue(){ // Obtener el item más viejo y además borrarlo
        shiftsStacks();
        
        return stackOldestOnTop.pop();
    }
    
    public void shiftsStacks(){
        if (stackOldestOnTop.isEmpty()){
            while(!stackNewestOnTop.isEmpty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }
}
