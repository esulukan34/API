package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiDatePojo {

    private String employee_name;
    private Integer employee_salary;
    private Integer age;
    private String profile_image;

    public DummyRestApiDatePojo(String employee_name, Integer employee_salary, Integer age, String profile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.age = age;
        this.profile_image = profile_image;
    }

    public DummyRestApiDatePojo() {
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "DummyRestApiDatePojo{" +
                "employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", age=" + age +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }
}
