package developerHomework5.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Table(name = "projects")
@Entity
public class Project implements GenerallyTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "project_name")
    private String project_name;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Developer> developers;

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }
    public long getId() {
        return id;
    }
    public String getProject_name() {
        return project_name;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("Project :%s\ndescription: %s\ncost: %f", project_name, description, cost.doubleValue());
    }

    public static String[] getParam(){
        return new String[]{
                "id",
                "project_name",
                "description",
                "cost"
        };
    }

    public String[] getAll(){
        return new String[]{
            "" + id,
            project_name,
            description,
            String.valueOf(cost)
        };
    }

    @Override
    public Map<String, String> getCortege() {
        String[] fields = getParam();
        String[] data = getAll();
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            result.put(fields[i], data[i]);
        }
        return result;
    }

    @Override
    public String[] getPrm() {
        return new String[]{
                "id",
                "project_name",
                "description",
                "cost"
        };
    }

    @Override
    public String getTableName() {
        return "projects";
    }

    @Override
    public void fillTable(Map<String, String> map) {
        if (null != map.get("id")) {
            setId(Long.parseLong(map.get("id")));
        }
        setProject_name(map.get("project_name"));
        setDescription(map.get("description"));
        Long l = Long.parseLong(map.get("cost"));
        System.out.println(l);
        BigDecimal bd = new BigDecimal(l);
        setCost(bd);
    }
}
