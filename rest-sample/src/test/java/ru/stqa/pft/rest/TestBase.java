package ru.stqa.pft.rest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;
import javax.xml.rpc.ServiceException;
import static com.jayway.jsonpath.JsonPath.*;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 11.07.2017.
 */
public class TestBase {

  public boolean isIssueOpen(int issueId) throws IOException {
    String status = getIssueStatusById(5);
      if (status.equals("resolved") || status.equals("closed")) {
          return false;
      } else {
        System.out.println("Issue still open");
          return true;
      }
  }

  public void skipIfNotFixed(int issueId) throws IOException, ServiceException, SkipException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  protected Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json")).returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }
  // http://demo.bugify.com/api/issues/5.json -u LSGjeU4yP1X493ud1hNniA==:
  //$.issues[*].state_name
  protected String getIssueStatusById(int id) throws IOException {
    String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues/"+id+".json")).returnContent().asString();
    List<String> status=  read(json, "$.issues[*].state_name");
    return status.get(0);
  }

  protected Executor getExecutor() {
    return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==","");
  }
}
