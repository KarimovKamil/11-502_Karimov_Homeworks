package Dao.Models;

public class Car {
    private int id;
    private String mark;
    private String numberplate;
    private String releaseDate;
    private String carOwner;

    public Car() {
    }

    public Car(String mark, String releaseDate) {
        this.mark = mark;
        this.releaseDate = releaseDate;
    }

    public Car(int id, String mark, String numberplate, String releaseDate, String carOwner) {
        this.id = id;
        this.mark = mark;
        this.numberplate = numberplate;
        this.releaseDate = releaseDate;
        this.carOwner = carOwner;
    }

    public int getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", numberplate='" + numberplate + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", carOwner='" + carOwner + '\'' +
                '}';
    }
}
