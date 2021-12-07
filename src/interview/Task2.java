package interview;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Package packA = new Package("A");
        Package packB = new Package("B");
        Package packC = new Package("C");
        Package packD = new Package("D");
        Project project = new Project("project1");
        project.addPackage(packA);
        project.addPackage(packD);
        packA.addDependency(packB);
        packB.addDependency(packC);
        packD.addDependency(packC);
        //packC.addDependency(packA);
        System.out.println(project.hasCyclicDependencies());
        List<Package> order = project.getCompilationOrder();
        for (Package p : order) {
            System.out.println(p.getName());
        }
    }
}

