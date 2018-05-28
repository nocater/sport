package sport.bean;

import java.util.List;
import java.util.Map;

public class Student {
    private Integer id;

    private String name;

    private String sex;

    private String birth;

    private String studentnum;

    private String ethnic;

    private String personnum;

    private String adress;
    
    private List<Fresult> Fresults;//经过标准之后

    public Class_ getClass_() {
		return class_;
	}

	public void setClass_(Class_ class_) {
		this.class_ = class_;
	}

	private Class_ class_;

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
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(String studentnum) {
        this.studentnum = studentnum == null ? null : studentnum.trim();
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic == null ? null : ethnic.trim();
    }

    public String getPersonnum() {
        return personnum;
    }

    public void setPersonnum(String personnum) {
        this.personnum = personnum == null ? null : personnum.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

	public List<Fresult> getFresults() {
		return Fresults;
	}

	public void setFresults(List<Fresult> fresults) {
		Fresults = fresults;
	}

}