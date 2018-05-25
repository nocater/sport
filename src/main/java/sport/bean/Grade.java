package sport.bean;

import java.util.List;

public class Grade {
    private Integer id;


	private List<Item> items;

	private School school;

    private Integer num;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

    public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}