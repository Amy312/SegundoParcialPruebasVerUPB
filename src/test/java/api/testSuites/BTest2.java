package api.testSuites;

import api.config.Configuration;
import api.factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class BTest2 extends TestBase{
    @Test
    public void create4ItemsAndDeleteThem(){
        JSONObject body = new JSONObject();
        body.put("Content","Item1");

        this.createItem(Configuration.host + "/api/items.json", body, post);
        int idItem1 = response.then().extract().path("Id");

        JSONObject body2 = new JSONObject();
        body2.put("Content","Item2");
        this.createItem(Configuration.host + "/api/items.json", body, post);
        int idItem2 = response.then().extract().path("Id");

        JSONObject body3 = new JSONObject();
        body2.put("Content","Item3");
        this.createItem(Configuration.host + "/api/items.json", body, post);
        int idItem3 = response.then().extract().path("Id");

        JSONObject body4 = new JSONObject();
        body2.put("Content","Item4");
        this.createItem(Configuration.host + "/api/items.json", body, post);
        int idItem4 = response.then().extract().path("Id");

        //this.readProject(idProject, get, body);

        body.put("Content","My Project Updated");
       // this.updateProject(Configuration.host + "/api/projects/" + idProject + ".json", body, put);
       // this.deleteProject(idProject, delete, body);
    }
    private void createItem(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).sendWithToken(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }
    private void readItem(int idItem, String get, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/items/" + idItem + ".json");
        response = FactoryRequest.make(get).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }
}
