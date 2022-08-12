package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

import java.util.ArrayList;

import static glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer {
    private static String name;
    private static double energy;
    private static Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        //suitcase = new Suitcase;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    public static void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        BaseExplorer.name = name;
    }

    public static void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        BaseExplorer.energy = energy;
    }

    public static void setSuitcase(Suitcase suitcase) {
        BaseExplorer.suitcase = suitcase;
    }

    @Override
    public boolean canSearch() {
        return energy > 0;
    }

    @Override
    public void search() {
        if (energy - 15 < 0) {
            energy = 0;
        }
        energy = energy - 15;
    }
}
