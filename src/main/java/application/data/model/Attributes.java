package application.data.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "attributes")
public class Attributes {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attributes_id")
    @Id
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "attributes")
    private List<AttributesValue> attributesValueList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AttributesValue> getAttributesValueList() {
        return attributesValueList;
    }

    public void setAttributesValueList(List<AttributesValue> attributesValueList) {
        this.attributesValueList = attributesValueList;
    }
}
