package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer {
    private static final double SEARCH_ENTITY = 15;

    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        suitcase = new Carton();
    }

    public String getName() {
        return name;
    }

    public double getEnergy() {
        return energy;
    }

    public Suitcase getSuitcase() {
        return suitcase;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_EXPLORER_NAME, getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format(FINAL_EXPLORER_ENERGY, getEnergy()));
        sb.append(System.lineSeparator());
        if (getSuitcase().getExhibits().isEmpty()) {
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
        } else {
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, getSuitcase().getExhibits())));
        }
        return sb.toString();
    }

    public boolean canSearch() {
        return energy > 0;
    }

    public void search() {
        energy = Math.max(0, energy - SEARCH_ENTITY);
    }
}
