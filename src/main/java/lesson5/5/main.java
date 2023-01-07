package lesson5;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("c:");
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
            String path = file.getAbsolutePath();
        }

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        LinkedList<String[]> rows = new LinkedList<>();
        String dataRow;

        int i = 0;
        while ((dataRow = bufferedReader.readLine()) != null) {
            rows.addLast(dataRow.split(";"));
            i++;
        }

        String[][] csvMatrix = rows.toArray(new String[rows.size()][]);
        System.out.println(csvMatrix[2][0]);

        for (int j = 0; j < csvMatrix.length; j++) {
            String temp = csvMatrix[j][0];
            String temp1 = csvMatrix[j][1];

            csvMatrix[j][0] = temp1;
            csvMatrix[j][1] = temp;
        }

        FileWriter fileWriter = new FileWriter(file);
        for (int j = 0; j < csvMatrix.length; j++) {
            for (int k = 0; k < csvMatrix[j].length; k++) {
                fileWriter.write(csvMatrix[j][k]+";");
            }
            fileWriter.write("\n");
            fileWriter.flush();
        }
        fileWriter.close();

    }
}