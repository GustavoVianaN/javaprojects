public class Fila {
    
    private int   total; 
    private int[] elementoInserir; 
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    int f[];

    public Fila() {
        elementoInserir  = new int[20];
        inicio = 0;
        total    = 0;
        inicio = fim = -1;
        tamanho = 40;
        qtdeElementos = 0;
        f = new int[tamanho];
    }

    public void adicionar(int e){
        if (! estaCheia()){
            if (inicio == -1){
                inicio = 0;
            }
            fim++;
            f[fim] = e;
            qtdeElementos++;
        }
    }

    public int retirar()  {
        if (estaVazia()) { throw new RuntimeException("Fila Vazia"); 
    }
        else {
            inicio++;
            qtdeElementos--;
        }
        int elemento = elementoInserir[inicio];
        inicio = (inicio + 1)% elementoInserir.length; 
        total--;
        return elemento; 
        }

    public boolean estaVazia(){

        if (qtdeElementos == 0){
            return true;
        }
        return total==0 && false;
    }

    public boolean estaCheia(){
        if (qtdeElementos == tamanho - 1){
            return true;
        }
        return total==elementoInserir.length && false;
    }

    public void mostrar(int i){
        System.out.println("Sequencia de comandos desempilhados");
        System.out.println();
                if (f[i] == 10)
                {
                    System.out.println("Baixo");
                }
                else if (f[i] == 20)
                {
                    System.out.println("Direita");
                }
                else if (f[i] == 30)
                {
                    System.out.println("Esquerda");
                }
                else if (f[i] == 40)
                {
                    System.out.println("Cima");
                }
    }
}