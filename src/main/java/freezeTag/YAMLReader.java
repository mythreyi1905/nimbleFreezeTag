package freezeTag;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class YAMLReader {


    public void readYaml() throws FileNotFoundException {
        //Reads the YAML file and calls the function to initialize objects and play the game
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(new File("gameSpec.yaml"));
        Map<String, Object> obj = yaml.load(inputStream);
        Game g = new Game();
        g.initializeObjects(obj);


    }


    public static void main(String[] args) throws FileNotFoundException {
        YAMLReader y = new YAMLReader();
        y.readYaml();
    }



}
