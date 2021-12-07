package interview;

import java.util.ArrayList;
import java.util.List;

public class Package {
    //уникальное имя пакета
    private final String name;
    //список пакетов, от которых зависит данный
    private final List<Package> dependencies = new ArrayList<>();

    public Package(String name) {
        this.name = name;
    }

    public List<Package> getDependencies() {
        return dependencies;
    }

    public String getName() {
        return name;
    }

    public void addDependency(Package packages) {
        this.dependencies.add(packages);
    }
}
