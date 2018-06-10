package developerHomework5.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Table(name = "developers")
@Entity
public class Developer implements GenerallyTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "salary")
    private BigDecimal salary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Project> projects;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Skill> skills;

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
    public void setId(long id) {
        this.id = (int)id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean isSex() {
        return sex;
    }
    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
                "Developer :%s\nAge %d\nsex: %s\nsalary: %d", name, age
                , sex? "male" : "female", salary.longValue());
    }

    public String[] getAll(){
        return new String[]{
            String.valueOf(id),
            name,
            String.valueOf(age),
            String.valueOf(sex),
            String.valueOf(salary)
        };
    }

    public Map<String, String> getCortege(){
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < getAll().length; i++) {
            result.put(getParam()[i], getAll()[i]);
        }
        return result;
    }

    public static String[] getParam() {
        return new String[]{
                "id",
                "first_name",
                "age",
                "sex",
                "salary"
        };
    }
    public String[] getPrm() {
        return new String[]{
                "id",
                "first_name",
                "age",
                "sex",
                "salary"
        };
    }

    @Override
    public String getTableName() {
        return "developers";
    }

    public void fillTable(Map<String, String> map){
        if (null != map.get("id")) {
            setId(Long.parseLong(map.get("id")));
        }
        setName(map.get("first_name"));
        setAge(Integer.parseInt(map.get("age")));
        setSex(Boolean.parseBoolean(map.get("sex")));
        Long l = Long.parseLong(map.get("salary"));
        System.out.println(l);
        BigDecimal bd = new BigDecimal(l);
        setSalary(bd);
    }
}