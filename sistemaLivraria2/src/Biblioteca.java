import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    ArrayList<Livro> array = new ArrayList<Livro>();
    FileInputStream file;

    public void loadFile() throws Exception {
        int i;
        this.file = new FileInputStream("sistemaLivraria2/src/txtData.txt");
        Scanner textIn = new Scanner(file);
        String line, model;
        String[] splitLine, splitInfo;
        model = "<codigo>,<titulo>,<ano>,<área/gênero>,<editora>,R$<valor>,<qtd em estoque>@";
        line = textIn.nextLine();
        for (i = 0; i < array.size(); i++) {
            line = line + model;
        }
        splitLine = line.split("@");
        System.out.println(splitLine.length);
        for (i = 0; i < splitLine.length; i++) {
            splitInfo = splitLine[i].split(",");
            splitInfo[0] = array.get(i).codigo;
            splitInfo[1] = array.get(i).titulo;
            splitInfo[2] = Integer.toString(array.get(i).ano);
            splitInfo[3] = array.get(i).area;
            splitInfo[4] = array.get(i).editora;
            splitInfo[5] = Double.toString(array.get(i).valor);
            splitInfo[6] = Integer.toString(array.get(i).estoque);
            splitLine[i] = splitInfo[0] + ",";
            for (int u = 1; u < 7; u++) {
                splitLine[i] += splitInfo[u] + ",";
            }
        }
        line = splitLine[0];
        for (i = 0; i < splitLine.length; i++) {
            line += splitLine[i];
        }
        // System.out.println(line);

    }
    // <codigo>,<titulo>,<ano>,<área/gênero>,<editora>,R$<valor>,<qtd em estoque>

    public void addLib(Livro book) {
        array.add(book);
    }
}
