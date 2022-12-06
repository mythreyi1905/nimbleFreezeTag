package freezeTag;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class YAMLReader {


    public void readYaml() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(new File("gameSpec.yaml"));
        Map<String, Object> obj = yaml.load(inputStream);
        //System.out.println(obj);
        //lets assign
        Game g = new Game();
        g.initializeObjects(obj);


    }


    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Hey");
        YAMLReader y = new YAMLReader();
        y.readYaml();
    }



}
