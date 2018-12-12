package test2;

public class Food {
    private String foodName;
    private double price;
    private int count;

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
