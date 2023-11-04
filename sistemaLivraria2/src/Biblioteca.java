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
        String [] splitLine, splitInfo;
        model = "<codigo>,<titulo>,<ano>,<área/gênero>,<editora>,R$<valor>,<qtd em estoque>@";
        line = textIn.nextLine(); 
        for(i = 1; i < array.size(); i++){
            line = line + model;
            System.out.println(line);
        }
        splitLine = line.split("@");
        System.out.println(splitLine[1]);
        // for (i = 0; i < array.size(); i++){
        //      splitInfo = splitLine[i].split(",");
        //      splitInfo[0] = array.get(i).codigo;
        //      splitInfo[1] = array.get(i).titulo;
        //      splitInfo[2] = Integer.toString(array.get(i).ano);
        //      splitInfo[3] = array.get(i).area;
        //      splitInfo[4] = array.get(i).editora;
        //      splitInfo[5] = Double.toString(array.get(i).valor);
        //      splitInfo[6] = Integer.toString(array.get(i).estoque);
        // }

    }
    //<codigo>,<titulo>,<ano>,<área/gênero>,<editora>,R$<valor>,<qtd em estoque>

    public void addLib(Livro book){
        array.add(book);
    }
}
