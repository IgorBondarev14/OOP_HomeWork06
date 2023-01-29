package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ActionFile implements Action {
    private String fileName;
    public ActionFile(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<String> readAllStrings() {
        List<String> strings = new ArrayList<>();
        try{
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String string = reader.readLine();
            if (string != null) {
                strings.add(string);
            }
            while (string != null) {
                string = reader.readLine();
                if (string != null) {
                    strings.add(string);
                }
            }
            fr.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public void saveAllStrings(List<String> strings) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String string : strings) {
                writer.write(string);
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
