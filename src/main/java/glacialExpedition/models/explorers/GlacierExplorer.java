package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {
    private static double ENERGY = 40;

    public GlacierExplorer(String name) {
        super(name, ENERGY);
    }
}
