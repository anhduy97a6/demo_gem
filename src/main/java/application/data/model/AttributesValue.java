package application.data.model;

import javax.persistence.*;

@Entity(name = "attributes_value")
public class AttributesValue {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attributes_value_id")
    @Id
    private Integer id;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "attributes_id")
    private Attributes attributes;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "solution_id")
    private Solution solution;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
