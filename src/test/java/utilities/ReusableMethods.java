package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReusableMethods {
    JsonPath js;
    PrintStream log;

    public String getPayload(String filename) throws IOException {
        String path = "src\\main\\java\\payloads\\"+filename+".txt";
        return new String(Files.readAllBytes(Paths.get(path)));

    }

    public Object parseJsonRes(String resposeString, String node) {
        js = new JsonPath(resposeString);
        return js.get(node);

    }

    public PrintStream getFile () throws FileNotFoundException {

        return log = new PrintStream(new FileOutputStream("Logging.txt"));
    }




}
