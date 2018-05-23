package sport.bean;

public class Result_ {
    private Integer id;
    
    public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	private Item item;
    

    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private Student student;

    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }
}