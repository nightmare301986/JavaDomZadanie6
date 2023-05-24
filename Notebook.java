public class Notebook {
    String brand;
    String model;
    int ram;
    String typehardDisk;
    int hardDisk;
    String operSystem;
    String color;

    // Конструктор ноутов
    public Notebook(String brand, String model, int ram, String typehardDisk, int hardDisk, String operSystem, String color){
        this.brand = brand.toUpperCase();
        this.model = model.toUpperCase();
        this.ram = ram;
        this.typehardDisk = typehardDisk.toUpperCase();
        this.hardDisk = hardDisk;
        this.operSystem = operSystem.toUpperCase();
        this.color = color.toLowerCase();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public void setTypeHardDisk(String typehardDisk) {
        this.typehardDisk = typehardDisk;
    }
    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }
    public void setOperSystem(String operSystem) {
        this.operSystem = operSystem;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getRam() {
        return ram;
    }
    public String getTypeHardDisk() {
        return typehardDisk;
    }
    public int getHardDisk() {
        return hardDisk;
    }
    public String getOperSystem() {
        return operSystem;
    }
    public String getColor() {
        return color;
    }
    
      public void showInfo(){
        System.out.println(String.format("Производитель: %s\nМодель: %s\nОЗУ(Гб): %d\nТип жесткого диска: %s\nОбъем жесткого диска(Гб): %d\nОС: %s\nЦвет: %s\n",
        this.brand, this.model, this.ram, this.typehardDisk, this.hardDisk, this.operSystem, this.color));
    }
    
    @Override
    public String toString() {
        return (String.format("Производитель: %s\nМодель: %s\nОЗУ(Гб): %d\nТип жесткого диска: %s\nОбъем жесткого диска(Гб): %d\nОС: %s\nЦвет: %s\n"+"\n",
        this.brand, this.model, this.ram, this.typehardDisk, this.hardDisk, this.operSystem, this.color));
    }
}

