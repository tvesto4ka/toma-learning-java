package interview;

import java.util.*;

public class Project {
    //имя проекта
    private final String name;
    //список пакетов проекта
    private final List<Package> packages = new ArrayList<>();

    private List<Package> packagesOrderForCompilation;

    private Map<Package, String> packageColourMap;

    private static final String WHITE = "WHITE";
    private static final String GREY = "GREY";
    private static final String BLACK = "BLACK";

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
        packageColourMap = new HashMap<>();
        for (Package pack : packages) {
            packageColourMap.put(pack, WHITE);
            makeMapWhite(pack);
        }

        packagesOrderForCompilation = new LinkedList<>();
        boolean hasCycle = false;
        for (Package pack : packages) {
            packagesOrderForCompilation.add(pack);
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

        List<Package> reverseOrder = new LinkedList<>();
        for (int i = packagesOrderForCompilation.size() - 1; i >= 0; i--) {
            reverseOrder.add(packagesOrderForCompilation.get(i));
        }
        return reverseOrder;
    }

    //обход цикла в глубину
    private Boolean dfs(Package p) {
        packageColourMap.replace(p, GREY);
        for (Package dep : p.getDependencies()) {
            //удаляем зависимость из списка, как как встретили ее снова и она должна быть скомпилирована раньше
            packagesOrderForCompilation.remove(dep);
            packagesOrderForCompilation.add(dep);

            //если встретили серую вершину, значит, мы ее не закончили обрабатывать, значит, есть цикл
            if (GREY.equals(packageColourMap.get(dep))) {
                return true;
            }
            if (WHITE.equals(packageColourMap.get(dep))) {
                return dfs(dep);
            }
        }
        packageColourMap.replace(p, BLACK);
        return false;
    }

    //помечаем все вершины графа белыми
    private void makeMapWhite(Package p) {
        for (Package dep : p.getDependencies()) {
            if (!packageColourMap.containsKey(dep)) {
                packageColourMap.put(dep, WHITE);
                makeMapWhite(dep);
            }
        }
    }
}
