import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
    ArrayList<Livro> array = new ArrayList<Livro>();
    FileInputStream file;
    
    public void loadFile() throws Exception{
        int i;
        this.file = new FileInputStream("sistemaLivraria2/src/txtData.txt");
        Scanner textIn = new Scanner(file);
        String line, model;
        String [] sl;
        model = "<codigo>,<titulo>,<ano>,<área/gênero>,<editora>,R$<valor>,<qtd em estoque>@";
        line = textIn.nextLine(); 
        for(i = 1; i < array.size(); i++){
            line = line + model;
        }

    }
    //<codigo>,<titulo>,<ano>,<área/gênero>,<editora>,R$<valor>,<qtd em estoque>

    public void addLib(Livro book){
        array.add(book);
    }
}
