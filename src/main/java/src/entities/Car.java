package src.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car {
    private int carId;
    private String color;
    private String name;

    public Car() {}

    public Car(int carId, String name, String color){
        setCarId(carId);
        setName(name);
        setColor(color);
    }

    private ShowRoom showRoom;
    public ShowRoom getShowRoom() {
        return showRoom;
    }

    public void setShowRoom(ShowRoom carId) {
        this.showRoom = showRoom;
    }

    @Id
    @Column(name = "car_id", nullable = false)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "color", nullable = false, length = 100)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                Objects.equals(color, car.color) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, color, name);
    }
}
