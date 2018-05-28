package sport.bean;

public class Addscore {
    private Integer id;

    private Integer itemId;

    private String gradeNum;

    private String add;

    private String standrad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(String gradeNum) {
        this.gradeNum = gradeNum == null ? null : gradeNum.trim();
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add == null ? null : add.trim();
    }

    public String getStandrad() {
        return standrad;
    }

    public void setStandrad(String standrad) {
        this.standrad = standrad == null ? null : standrad.trim();
    }
}