package src.entities;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "show_room", schema = "sys", catalog = "")
public class ShowRoom {
    private int showRoomId;
    private String location;
    private String manager;

//    @OneToMany
//    @JoinColumn(name = "show_room_id")
//    @Cascade(CascadeType.ALL)
    //private List<Car> cars = null;


    @OneToMany
    @JoinTable
    (name = "car",
     joinColumns = @JoinColumn(name = "show_room_id")
    )
    @Cascade(CascadeType.ALL)
    private Set<Car> cars = null;

    public ShowRoom() {}

//    public List<Car> getCars() {
//        return cars;
//    }
//
//    public void setCars(List<Car> cars) {
//        this.cars = cars;
//    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Id
    @Column(name = "show_room_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getShowRoomId() {
        return showRoomId;
    }

    public void setShowRoomId(int showRoomId) {
        this.showRoomId = showRoomId;
    }

    @Basic
    @Column(name = "location", nullable = false, length = 100)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "manager", nullable = false, length = 100)
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowRoom showRoom = (ShowRoom) o;
        return showRoomId == showRoom.showRoomId &&
                Objects.equals(location, showRoom.location) &&
                Objects.equals(manager, showRoom.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showRoomId, location, manager);
    }
}
