package interview;

import java.util.*;

public class Project {
    //имя проекта
    private final String name;
    //список пакетов проекта
    private final List<Package> packages = new ArrayList<>();

    private List<Package> order;

    private Map<Package, String> color;

    public Project(String name) {
        this.name = name;
    }

    public void addPackage(Package pack) {
        this.packages.add(pack);
    }

    /**
     * Проверяет наличие циклических зависимостей между пакетами проекта.
     * Когда мы говорим "A зависит от B (или A -> B)", имеется в виду, что пакет B
     * содержится списке зависимостей (dependencies) пакета A.
     * Например, есть проект1, в нем задан список пакетов - packages = [A]
     * при зависимостях A->B->C->A – цикл есть
     * при зависимостях A->B->D, A->C->D – цикла нет
     * <p>
     * Обращаем ваше внимание, что в packages у проекта не обязательно находятся все пакеты.
     * В данном примере там находится только один пакет A.
     */
    public Boolean hasCyclicDependencies() {
        color = new HashMap<>();
        for (Package pack : packages) {
            color.put(pack, "white");
            makeMapWhite(pack);
        }

        order = new ArrayList<>();
        boolean hasCycle = false;//!!!!
        for (Package pack : packages) {
            order.add(pack);
            hasCycle = dfs(pack);
        }
        return hasCycle;
    }

    /**
     * Упорядоченный список пакетов проекта для компиляции с учетом их
     * зависимостей. Скомпилировать пакет мы можем только после успешной компиляции его зависимостей.
     * Например, для проекта A->B->C, D->C
     * порядок компиляции может быть C, B, A, D или C, D, B, A или C, B, D, A
     */
    public List<Package> getCompilationOrder() {
        if (hasCyclicDependencies()) {
            throw new RuntimeException("Impossible to compile due to Cyclic dependency");
        }
        List<Package> reverseOrder = new ArrayList<>();
        for (int i = order.size() - 1; i >= 0; i--) {
            reverseOrder.add(order.get(i));
        }
        return reverseOrder;
    }

    //обход цикла в глубину
    private Boolean dfs(Package p) {
        color.replace(p, "grey");
        for (Package dep : p.getDependencies()) {
            order.remove(dep);///!!!!
            order.add(dep);
            if (color.get(dep).equals("grey")) {
                return true;
            }
            if (color.get(dep).equals("white")) {
                return dfs(dep);
            }
        }
        color.replace(p, "black");//!!!
        return false;
    }

    //помечаем все вершины графа белыми
    private void makeMapWhite(Package p) {
        for (Package dep : p.getDependencies()) {
            if (!color.containsKey(dep)) {
                color.put(dep, "white");
                makeMapWhite(dep);
            }
        }
    }

}
