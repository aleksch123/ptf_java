package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.Model.Issue;
import ru.stqa.pft.mantis.Model.Project;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Алексей on 10.07.2017.
 */
public class SoapTests extends TestBase{
    @Test
    public void testGetProjects() throws IOException, ServiceException {
        skipIfNotFixed(1);
        Set<Project> projects = app.saop().getProjects();
        System.out.println(projects.size());
        for(Project project:projects){
            System.out.println(project.getName());
        }

    }
    @Test
    public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.saop().getProjects();
        Issue issue = new Issue().withSummary("Test issue")
                .withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created = app.saop().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
    }
}
