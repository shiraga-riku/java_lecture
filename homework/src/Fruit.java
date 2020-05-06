class Fruit
{

  private String name;
  private int price;

  public Fruit(String line) {
    String[] elems = line.split(",");
    this.name = elems[0];
    this.price = Integer.parseInt(elems[1]);
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}
