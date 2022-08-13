package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.Arrays;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        suitcase = new Carton();
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

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder exhibitsPerExplorer = new StringBuilder((Arrays.toString(suitcase.getExhibits().stream().toString().split(", "))));
//        return sb.append(String.format(FINAL_EXPLORER_NAME, name))
//                .append(System.lineSeparator())
//                .append(String.format(FINAL_EXPLORER_ENERGY, energy))
//                .append(System.lineSeparator())
//                .append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibitsPerExplorer)).toString();
//    }

    public void setSuitcase(Suitcase suitcase) {
        this.suitcase = suitcase;
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
