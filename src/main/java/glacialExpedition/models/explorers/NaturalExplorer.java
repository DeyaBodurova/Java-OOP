package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

public class NaturalExplorer extends BaseExplorer {
    private static double ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        setEnergy(getEnergy() - 7);
    }
}
