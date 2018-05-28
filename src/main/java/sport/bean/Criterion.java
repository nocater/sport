package sport.bean;

public class Criterion {
    private Integer id;

    private Item item;

    private String gradeNum;

    private String standrad;

    private String levl;

    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(String gradeNum) {
        this.gradeNum = gradeNum == null ? null : gradeNum.trim();
    }

    public String getStandrad() {
        return standrad;
    }

    public void setStandrad(String standrad) {
        this.standrad = standrad == null ? null : standrad.trim();
    }

    public String getLevl() {
        return levl;
    }

    public void setLevl(String levl) {
        this.levl = levl == null ? null : levl.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }
}