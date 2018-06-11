package developerHomework5.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Table(name = "skills")
@Entity
class Skill implements GenerallyTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
        private long id;

    @Column(name = "skill")
        private String skills;

    @Column(name = "grade")
        private String grade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Developer> developers;

        public long getId() {
            return id;
        }
        public String getSkills() {
            return skills;
        }
        public String getGrade() {
            return grade;
        }
    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
        public String toString() {
            return String.format("id :%d\nTypeSkill: %s\nGrade: %s\n", id, skills, grade);
        }

        public String[] getAll(){
            return new String[]{
                String.valueOf(id),
                    skills,
                grade
            };
        }

    @Override
    public Map<String, String> getCortege(){
        String[] fields = getPrm();
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
                "skill",
                "grade",
        };
    }

    @Override
    public String getTableName() {
        return "skill";
    }

    @Override
    public void fillTable(Map<String, String> map) {
        setId(Long.parseLong(map.get("id")));
        setGrade(map.get("grade"));
        setSkills(map.get("skill"));
    }
}

