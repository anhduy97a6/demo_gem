package application.data.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "dbo_solution")
public class Solution {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "solution_id")
    @Id
    private Integer id;

    private String name;

    @Column(name = "role_gem")
    private Integer roleGem;

    private String owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solution")
    private List<AttributesValue> attributesValueList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getRoleGem() {
        return roleGem;
    }

    public void setRoleGem(Integer roleGem) {
        this.roleGem = roleGem;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAttributesValueList(List<AttributesValue> attributesValueList) {
        this.attributesValueList = attributesValueList;
    }
}
