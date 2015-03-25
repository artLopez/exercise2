package edu.csumb.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import org.junit.Before;

public class AppTest {
    private List<String> names;
    /*
    @Before
    public void setUp(){
	this.names = new ArrayList<String>();
	names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
    }
	*/
    @Test
    public void thisAlwaysPasses() {
    }

    @Test
    @Ignore
    public void thisIsIgnored() {
    }
    /*
    @Test
    public void groupSize(){
           App generator = new App(this.names);
	   ArrayList<ArrayList<String>> groups = generator.createSubgroups();
           assertEquals(groups.size(),1);
    }
    */

    @Test
    public void groupsHaveThreePeople() throws Exception {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App generator = new App(names);
        List<String> group = generator.createGroup("a");
        assertEquals(group.size(), 3);
    }

    @Test
    public void givenUsernameIsInGroup() throws Exception{
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App generator = new App(names);
        String name = "a";
        List<String> group = generator.createGroup(name);
        assertEquals(group.contains(name), true);
    }

    @Test
    public void groupsHaveConsistentMembership() throws Exception{
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App generator = new App(names);
        List<String> actualA = generator.createGroup("a");
        List<String> actualB = generator.createGroup("b");
        List<String> actualC = generator.createGroup("c");
        List<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        assertEquals(actualA, expected);
        assertEquals(actualB, expected);
        assertEquals(actualC, expected);
    }
    @Test
    public void createSubgroups() {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App  generator = new App(names);
        ArrayList<ArrayList<String>> groups = generator.createSubgroups();
        assertEquals(groups.size(), 2);
        assertEquals(groups.get(0).size(), 3);
    }

    @Test
    public void findGroup() {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App  generator = new App(names);
        ArrayList<ArrayList<String>> groups = generator.createSubgroups();
        String name = "a";
        ArrayList<String> group = generator.findGroup(groups, name);
        assertEquals(group.contains(name), true);
    }
}
