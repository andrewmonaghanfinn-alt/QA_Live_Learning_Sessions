package Labs.lab14;

public class Customer {

    private String name;
    private String capital;
    private int population;
    private int area;
    private String currency;
    private String[] languages;
    private String region;
    private String subregion;
    private String flag;

    public Customer() {
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String[] getLanguages() { return languages; }
    public void setLanguages(String[] languages) { this.languages = languages; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getSubregion() { return subregion; }
    public void setSubregion(String subregion) { this.subregion = subregion; }

    public String getFlag() { return flag; }
    public void setFlag(String flag) { this.flag = flag; }
}
