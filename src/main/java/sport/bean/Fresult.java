package sport.bean;

/***
 * 最后成绩
 * @author chenshuai
 *
 */
public class Fresult {
	private Item Item;		//项目
	private String value;		//原始成绩
	private String score;		//得分
	private String add_score;	//加分
	private String level;		//等级
	public Item getItem() {
		return Item;
	}
	public String getValue() {
		return value;
	}
	public String getScore() {
		return score;
	}
	public String getAdd_score() {
		return add_score;
	}
	public String getLevel() {
		return level;
	}
	public void setItem(Item item) {
		Item = item;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public void setAdd_score(String add_score) {
		this.add_score = add_score;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	}
