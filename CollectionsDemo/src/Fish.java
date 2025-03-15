public class Fish implements Comparable<Fish> {
    String name;
    double weight;
    int price;

    public Fish(String name, double weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        int code = 17;
        code += name.hashCode();
        code += ((Double)weight).hashCode();
        code += ((Integer)price).hashCode();
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        Fish fish = (Fish) obj;
        return name.equals(fish.name) &&
                weight == fish.weight &&
                price == fish.price;
    }

    @Override
    public int compareTo(Fish o) {
        return this.price - o.price;
    }

//    @Override
//    public int compareTo(Object o) {
//        return this.price - ((Fish)o).price;
//    }
}
