package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

public class GlacierExplorer extends BaseExplorer {
    private static double ENERGY = 40;

    public GlacierExplorer(String name) {
        super(name, ENERGY);
    }
}
