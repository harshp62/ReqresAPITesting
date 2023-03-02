package utilities;

import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReusableMethods {
    JsonPath js;

    public String getPayload(String filename) throws IOException {
        String path = "src\\main\\java\\payloads\\"+filename+".txt";
        return new String(Files.readAllBytes(Paths.get(path)));

    }

    public Object parseJsonRes(String resposeString, String node) {
        js = new JsonPath(resposeString);
        return js.get(node);

    }
}
