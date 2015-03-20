package edu.csumb.app;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;

public class App
{
    List<String> names;

    public App(List<String> names){
        this.names = names;
    }

    public ArrayList<String> createGroup(String targetName) throws Exception {
        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmpGroup = new ArrayList<String>();
        for (String name: this.names) {
            tmpGroup.add(name);
            if (tmpGroup.size() == 3) {
                groups.add(tmpGroup);
                tmpGroup = new ArrayList<String>();
            }
        }

        for (ArrayList<String> group : groups) {
            if (group.contains(targetName)) {
                return group;
            }
        }

        throw new Exception("target name not found");
    }

    public static void main( String[] args ) throws Exception {
        String targetName = args[0];
        long assignmentNumber = Long.valueOf(args[1]);

        List<String> names = new ArrayList<String>();
        names.add("arlopez@csumb.edu");
        names.add("agopar@csumb.edu");
        names.add("gazapata@csumb.edu");
        names.add("sbharat@csumb.edu");
        names.add("aruval@csumb.edu");
        names.add("mcockman@csumb.edu");

        Collections.shuffle(names, new Random(assignmentNumber));

        App app = new App(names);

        System.out.println(app.createGroup(targetName));
    }
}
