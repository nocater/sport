package sport.bean;

public class Env {
    private Integer id;
	private Class_ class_;
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	private Item item;

    private String name;

    private String time;

    private String place;

    private String equipment;

    private String mode;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }
    public Class_ getClass_() {
		return class_;
	}

	public void setClass_(Class_ class_) {
		this.class_ = class_;
	}

}