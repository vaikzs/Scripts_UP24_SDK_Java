package knoesis.org.export.moves;

/*
 * Author 
 * Vaikunth Sridharan
 * 
 *  
 */

public class Move {
	long time_updated;
	String xid;
	String title;
	String type;
	long time_created;
	long time_completed;
	long active_time;
	long inactive_time;
	long wo_count;
	long wo_longest;
	double bmr;
	double bg_calories;
	double bmr_day;
	long wo_active_time;
	long distance;
	String tz;
	long longest_active;
	long longest_idle;
	double calories;
	double km;
	long steps;
	double wo_calories;
	double wo_time;
	String date_;

	public long getTime_updated() {
		return time_updated;
	}

	public void setTime_updated(long time_updated) {
		this.time_updated = time_updated;
	}

	public Move(long time_updated, String xid, String title, String move,
			long time_created, long time_completed, long active_time,
			long inactive_time, long wo_count, long wo_longest, double bmr,
			double bg_calories, double bmr_day, long wo_active_time,
			long distance, String tz, long longest_active, long longest_idle,
			double calories, double km, long steps, double wo_calories,
			double wo_time, String date_) {
		super();
		this.time_updated = time_updated;
		this.xid = xid;
		this.title = title;
		this.type = move;
		this.time_created = time_created;
		this.time_completed = time_completed;
		this.active_time = active_time;
		this.inactive_time = inactive_time;
		this.wo_count = wo_count;
		this.wo_longest = wo_longest;
		this.bmr = bmr;
		this.bg_calories = bg_calories;
		this.bmr_day = bmr_day;
		this.wo_active_time = wo_active_time;
		this.distance = distance;
		this.tz = tz;
		this.longest_active = longest_active;
		this.longest_idle = longest_idle;
		this.calories = calories;
		this.km = km;
		this.steps = steps;
		this.wo_calories = wo_calories;
		this.wo_time = wo_time;
		this.date_ = date_;
	}

	public long getActive_time() {
		return active_time;
	}

	public void setActive_time(long active_time) {
		this.active_time = active_time;
	}

	public long getInactive_time() {
		return inactive_time;
	}

	public void setInactive_time(long inactive_time) {
		this.inactive_time = inactive_time;
	}

	public long getWo_count() {
		return wo_count;
	}

	public void setWo_count(long wo_count) {
		this.wo_count = wo_count;
	}

	public long getWo_longest() {
		return wo_longest;
	}

	public void setWo_longest(long wo_longest) {
		this.wo_longest = wo_longest;
	}

	public double getBmr() {
		return bmr;
	}

	public void setBmr(double bmr) {
		this.bmr = bmr;
	}

	public double getBg_calories() {
		return bg_calories;
	}

	public void setBg_calories(double bg_calories) {
		this.bg_calories = bg_calories;
	}

	public double getBmr_day() {
		return bmr_day;
	}

	public void setBmr_day(double bmr_day) {
		this.bmr_day = bmr_day;
	}

	public long getWo_active_time() {
		return wo_active_time;
	}

	public void setWo_active_time(long wo_active_time) {
		this.wo_active_time = wo_active_time;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public long getLongest_active() {
		return longest_active;
	}

	public void setLongest_active(long longest_active) {
		this.longest_active = longest_active;
	}

	public long getLongest_idle() {
		return longest_idle;
	}

	public void setLongest_idle(long longest_idle) {
		this.longest_idle = longest_idle;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public long getSteps() {
		return steps;
	}

	public void setSteps(long steps) {
		this.steps = steps;
	}

	public double getWo_calories() {
		return wo_calories;
	}

	public void setWo_calories(double wo_calories) {
		this.wo_calories = wo_calories;
	}

	public double getWo_time() {
		return wo_time;
	}

	public void setWo_time(double wo_time) {
		this.wo_time = wo_time;
	}

	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getTime_created() {
		return time_created;
	}

	public void setTime_created(long time_created) {
		this.time_created = time_created;
	}

	public long getTime_completed() {
		return time_completed;
	}

	public void setTime_completed(long time_completed) {
		this.time_completed = time_completed;
	}

	public String getDate_() {
		return date_;
	}

	public void setDate_(String date_) {
		this.date_ = date_;
	}

}
