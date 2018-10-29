package br.tuliobar.enums;

public enum Beer {
    PILSNER(-6, -4, "Cerveja Pilsner"),
    IPA(-6, -5,"Cerveja IPA"),
    LAGER(-7, -4, "Cerveja Lager"),
    STOUT(-8, -6, "Cerveja Stout"),
    WHEAT_BEER(-5, -3, "Cerveja Trigo"),
    PALE_ALE(-6, -4, "Cerveja Pale Ale");


    private final int minTemperature;
    private final int maxTemperature;
    private final String name;

    Beer(int minTemperature, int maxTemperature, String name) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.name = name;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public String getName() {
        return name;
    }
}
