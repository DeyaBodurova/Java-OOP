package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.*;

import static glacialExpedition.common.ConstantMessages.*;

public class ExplorerRepository implements Repository<Explorer> {
    private Map<String, Explorer> explorers;

    public ExplorerRepository() {
        explorers = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        explorers.values().forEach(e -> sb.append(String.format(FINAL_EXPLORER_NAME,e.getName()))
                .append(System.lineSeparator())
                .append(String.format(FINAL_EXPLORER_ENERGY,e.getEnergy()))
                .append(System.lineSeparator())
                .append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, (Object) (e.getSuitcase().getExhibits()
                        .stream().toString().split(", "))))
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(explorers.values());
    }

    @Override
    public void add(Explorer entity) {
        explorers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return explorers.remove(entity.getName()) != null;
    }

    @Override
    public Explorer byName(String name) {
        return explorers.get(name);
    }
}
