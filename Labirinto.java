import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Labirinto {
	public void labirinto() {
		Fila f = new Fila();        
        ArrayList<ArrayList<String>> labirinto = new ArrayList<ArrayList<String>>();
        int cols = 8;
        int rows = 20;
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#")
        ));
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#", "#", " "," ","#","#","#","#","#"," ", " "," "," "," "," "," "," "," "," ", "#")
        )); 
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#", " ", " "," ","#","#","#"," "," "," "," ","#","#","#","#"," "," "," ", "#", "#")
        )); 
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#"," ", " ", " ", " ", " ", " "," "," "," ", " "," "," "," ", "#", "#", "#", "#", " ", "#", "#", "#")
        )); 
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#"," "," "," ","#","#", "#", " ", " "," "," "," "," ", " ", " ", " ", " ", " "," ", "#")
        )); 
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#"," ","#"," ","#"," ","#","#", "#", " ", "#", "#", " ", " "," "," "," ", " ", " ", "#")
        ));
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#"," "," ","#"," ","#","#","#"," "," "," "," "," "," "," "," "," ", " ", " ", "#")
        ));   
        labirinto.add(new ArrayList<String>(
            Arrays.asList("#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#")
        ));

        int x = 1;
        int y = 2;
        int elementoInserido = 0;
        ArrayList<ArrayList<Integer>> fila_2 = new ArrayList<ArrayList<Integer>>();

        while(true)
        {
            Fila fila = new Fila(); 
            if (labirinto.get(x).get(y) != "#") {

                System.out.print("\033[H\033[2J");  
                System.out.flush();              
                System.out.println("Comandos enfileirados " + elementoInserido);
                System.out.println("Comandos disponíveis " + (40 - elementoInserido));                
                printaMatriz(1, 2, rows, cols, labirinto);

            } else {
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("Voce bateu na parede!");
                System.out.println("Comandos enfileirados " + elementoInserido);
                System.out.println("Comandos disponíveis " + (40 - elementoInserido));  

                    for(int i = 0; i < fila_2.size(); i++){
                        System.out.println("Comando: " + i);
                        f.mostrar(i);
                        int x_pos = fila_2.get(i).get(0);
                        int y_pos = fila_2.get(i).get(1);
                        move(x_pos, y_pos, rows, cols, labirinto);
                    }

            }
            System.out.println("Esquerda : A");
            System.out.println("Direita  : D");
            System.out.println("Cima     : W");
            System.out.println("Baixo    : S");
            System.out.println("Reniciar : R");
            System.out.println("S = Ponto de Início");
            System.out.println("E = Ponto final");
            System.out.println("Digite o Comando desejado: ");   
            Scanner entrada = new Scanner(System.in);
            char cmd = entrada.next().charAt(0);
            System.out.println();
            elementoInserido = elementoInserido + 1;

            if (elementoInserido <= 0) {
                System.out.println("GAME OVER");
                break;
            }
            for (int i = 0; i < cols; i++){
                for (int j = 0; j < rows; j++){
                    if(i == x && j == y){                     
                        if (i == 1 && j == 1) {
                            System.out.println("VOCE VENCEU!");

                                for(int it = 0; it < fila_2.size(); it++){
                                    System.out.println("Comando: " + it);
                                    f.mostrar(it);
                                    int x_pos = fila_2.get(it).get(0);
                                    int y_pos = fila_2.get(it).get(1);
                                    move(x_pos, y_pos, rows, cols, labirinto);
                                }
                            System.exit(0);
                            entrada.close();
                            break;
                        }}}}
                      System.out.print("\033[H\033[2J");            
                      System.out.flush();
                                        
                if(cmd == 's' || cmd == 'S'){
                    x++;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    fila_2.add(pos);
                    f.adicionar(10);

                } else if(cmd == 'd' || cmd == 'D'){
                    y++;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    fila_2.add(pos);
                    f.adicionar(20);
                }
                else if(cmd == 'a' || cmd == 'A'){
                    y--;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    fila_2.add(pos);
                    f.adicionar(30);
                }
                else if(cmd == 'w' || cmd == 'W'){
                    x--;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    fila_2.add(pos);
                    f.adicionar(40);
                }
                else if(cmd == 'r' || cmd == 'R'){
                    if (fila.estaVazia() ) { 
                        System.out.print("\033[H\033[2J");    
                        System.out.flush();   
                        System.out.println("Comandos enfileirados " + elementoInserido);
                        System.out.println("Comandos disponíveis " + (40 - elementoInserido));
                        for(int i = 0; i < fila_2.size(); i++){
                            System.out.println("Comando: " + i);
                            f.mostrar(i);
                            int x_pos = fila_2.get(i).get(0);
                            int y_pos = fila_2.get(i).get(1);
                            move(x_pos, y_pos, rows, cols, labirinto);
                        }  
                    }
                    else { 
                        Scanner entradaExibirMatriz = new Scanner(System.in);
                        char comando = entradaExibirMatriz.next().charAt(0);
                        if (comando == 'r' || comando == 'R') {
                            for(int i = 0; i < fila_2.size(); i++){
                                System.out.println("Comando: " + i);
                                f.mostrar(i);
                                int x_pos = fila_2.get(i).get(0);
                                int y_pos = fila_2.get(i).get(1);
                                move(x_pos, y_pos, rows, cols, labirinto);
                            }
                        entradaExibirMatriz.close();
                    }
                    
                    int contagemFila = 20;
                    int contagemFilaLaco = 20;
        
                    while (! fila.estaVazia() && contagemFilaLaco == 20) { 
        
                                contagemFila = contagemFila - 1;
        
                                contagemFila = fila.retirar(); 
                
                                contagemFilaLaco = contagemFilaLaco - 1;}
                            }
                            break;
                }
                else {
                    System.out.println("Comando Inválido - menos uma tentativa.");
                }

            if(cmd == 'c' || cmd == 'C'){
                break;
            }}}      
            
        public static void printaMatriz(int x, int y, int rows, int cols, ArrayList<ArrayList<String>> labirinto){       
            for (int i = 0; i < cols; i++){
                for (int j = 0; j < rows; j++){
                    if(i == x && j == y){
                        labirinto.get(i).set(j, "S");
                        if (i == 1 && j == 1) {
                            break;
                        }
                    }
                    else if(i == 6 && j == 18) {
                        labirinto.get(i).set(j, "E");
                    };
                    System.out.print(labirinto.get(i).get(j));
                }
              System.out.println();        
            }
        }
        public static void move(int x, int y, int rows, int cols, ArrayList<ArrayList<String>> labirinto){
            for (int i = 0; i < cols; i++){
                for (int j = 0; j < rows; j++){
                    if(i == x && j == y){
                        labirinto.get(i).set(j, "S");
                        if (i == 1 && j == 1) {
                            break;
                        }
                    }
                    else if(i == 1 && j == 1) {
                        labirinto.get(i).set(j, "E");};
                            System.out.print(labirinto.get(i).get(j));}
                            System.out.println();} }}
