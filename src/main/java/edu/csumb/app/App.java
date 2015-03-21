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
    public ArrayList<ArrayList<String>> createSubgroups() {
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<String> tmpGroup = new ArrayList<>();
        for (String name: this.names) {
            tmpGroup.add(name);
            if (tmpGroup.size() == 3) {
                groups.add(tmpGroup);
                tmpGroup = new ArrayList<String>();
            }
        }
        return groups;
    }

    public ArrayList<String> findGroup(ArrayList<ArrayList<String>> groups, String name) {
        for (ArrayList<String> group : groups) {
            if (group.contains(name)) {
                return group;
            }
        }
	return null;
     }

     public ArrayList<String> createGroup(String name) throws Exception {
        ArrayList<ArrayList<String>> groups = createSubgroups();
        ArrayList<String> group = findGroup(groups, name);
        if (group == null) {
            throw new Exception("target name not found");
        } else {
            return group;
        }
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
