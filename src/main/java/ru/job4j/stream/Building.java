package ru.job4j.stream;

public class Building {
    private int stores;
    private int windows;
    private int doors;
    private String roofType;
    private String address;
    private String material;

    @Override
    public String toString() {
        return "Building{" + "stores=" + stores + ", windows=" + windows + ", doors=" + doors
                + ", roofType='" + roofType + '\'' + ", address='" + address + '\''
                + ", material='" + material + '\'' + '}';
    }

    static class Builder {
        private int stores;
        private int windows;
        private int doors;
        private String roofType;
        private String address;
        private String material;

        Builder buildStores(int stores) {
            this.stores = stores;
            return this;
        }

        Builder buildWindows(int windows) {
            this.windows = windows;
            return this;
        }

        Builder buildDoors(int doors) {
            this.doors = doors;
            return this;
        }

        Builder buildRoofType(String roofType) {
            this.roofType = roofType;
            return this;
        }

        Builder buildAddress(String address) {
            this.address = address;
            return this;
        }

        Builder buildMaterial(String material) {
            this.material = material;
            return this;
        }

        Building build() {
            Building building = new Building();
            building.stores = stores;
            building.windows = windows;
            building.doors = doors;
            building.roofType = roofType;
            building.address = address;
            building.material = material;
            return  building;
        }
    }

    public static void main(String[] args) {
        Building skyscraper = new Builder().buildStores(100)
                                            .buildWindows(5000)
                                            .buildDoors(2500)
                                            .buildRoofType("Heliport")
                                            .buildAddress("Kutusov ave. 134")
                                            .buildMaterial("steel and glass")
                                            .build();
        System.out.println(skyscraper);
    }
}
