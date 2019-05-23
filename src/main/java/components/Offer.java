package components;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private User owner;
    @ManyToOne
    private User sign;

    private String note;

    private Long timeStart;

    private Long timeEnd;

    public Offer() {
    }

    public Offer(User owner, String note, Long timeStart, Long timeEnd) {
        this.owner = owner;
        this.note = note;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getSign() {
        return sign;
    }

    public void setSign(User sign) {
        this.sign = sign;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
