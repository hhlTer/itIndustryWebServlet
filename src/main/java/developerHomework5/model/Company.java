package developerHomework5.model;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "companies")
public class Company implements GenerallyTable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "adress")
    private String adress;

    public void setId(long id) {
        this.id = id;
    }
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getId() {
        return id;
    }
    public String getCompany_name() {
        return company_name;
    }
    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return String.format("Company :%s\naddress: %s\n", company_name, adress);
    }

    public static String[] getParam(){
        return new String[]{
                "id",
                "company_name",
                "adress"
        };
    }

    public String[] getAll(){
        return new String[]{
                String.valueOf(id),
                company_name,
                adress
        };
    }

    @Override
    public Map<String, String> getCortege() {
        return null;
    }

    @Override
    public String[] getPrm() {
        return new String[]{
                "id",
                "company_name",
                "adress"
        };
    }

    @Override
    public String getTableName() {
        return "companies";
    }

    @Override
    public void fillTable(Map<String, String> map) {

    }
}
