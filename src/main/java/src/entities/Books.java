package src.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books", schema = "sys", catalog = "")
public class Books {
    private int id;
    private String name;
    private String author;
    private Integer price;
    private Integer quantity;
    private String status;

    /**
     * 应提供无参构造函数
     */
    public Books() {
    }

    /**
     * 若提供了带有参数的构造函数，则必须显示提供无参构造函数
     */
    public Books(int id, String name, String author, Integer price, Integer quantity, String status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 20)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books that = (Books) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(author, that.author) &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, price, quantity,status);
    }
}
