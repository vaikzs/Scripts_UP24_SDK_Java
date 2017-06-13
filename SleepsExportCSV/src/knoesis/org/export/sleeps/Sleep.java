package knoesis.org.export.sleeps;
public class Sleep {
	long time_updated;
	String xid;
	String title;
	long time_created;
	long time_completed;
	long body;
	long sound;
	String tz;
	long awakenings;
	long light;
	long mind;
	long asleep_time;
	long awake;
	long rem;
	long duration;
	long smart_alarm_fire;
	long quality;
	long awake_time;
	String date_;

	public Sleep(long time_updated, String xid, String title,
			long time_created, long time_completed, long body, long sound,
			String tz, long awakenings, long light, long mind,
			long asleep_time, long awake, long rem, long duration,
			long smart_alarm_fire, long quality, long awake_time, String date_,
			long sunrise, long sunset) {
		super();
		this.time_updated = time_updated;
		this.xid = xid;
		this.title = title;
		this.time_created = time_created;
		this.time_completed = time_completed;
		this.body = body;
		this.sound = sound;
		this.tz = tz;
		this.awakenings = awakenings;
		this.light = light;
		this.mind = mind;
		this.asleep_time = asleep_time;
		this.awake = awake;
		this.rem = rem;
		this.duration = duration;
		this.smart_alarm_fire = smart_alarm_fire;
		this.quality = quality;
		this.awake_time = awake_time;
		this.date_ = date_;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}

	public String getDate_() {
		return date_;
	}

	public void setDate_(String date_) {
		this.date_ = date_;
	}

	public long getTime_updated() {
		return time_updated;
	}

	public void setTime_updated(long time_updated) {
		this.time_updated = time_updated;
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

	public long getBody() {
		return body;
	}

	public void setBody(long body) {
		this.body = body;
	}

	public long getSound() {
		return sound;
	}

	public void setSound(long sound) {
		this.sound = sound;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public long getAwakenings() {
		return awakenings;
	}

	public void setAwakenings(long awakenings) {
		this.awakenings = awakenings;
	}

	public long getLight() {
		return light;
	}

	public void setLight(long light) {
		this.light = light;
	}

	public long getMind() {
		return mind;
	}

	public void setMind(long mind) {
		this.mind = mind;
	}

	public long getAsleep_time() {
		return asleep_time;
	}

	public void setAsleep_time(long asleep_time) {
		this.asleep_time = asleep_time;
	}

	public long getAwake() {
		return awake;
	}

	public void setAwake(long awake) {
		this.awake = awake;
	}

	public long getRem() {
		return rem;
	}

	public void setRem(long rem) {
		this.rem = rem;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getSmart_alarm_fire() {
		return smart_alarm_fire;
	}

	public void setSmart_alarm_fire(long smart_alarm_fire) {
		this.smart_alarm_fire = smart_alarm_fire;
	}

	public long getQuality() {
		return quality;
	}

	public void setQuality(long quality) {
		this.quality = quality;
	}

	public long getAwake_time() {
		return awake_time;
	}

	public void setAwake_time(long awake_time) {
		this.awake_time = awake_time;
	}

	public long getSunrise() {
		return sunrise;
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public long getSunset() {
		return sunset;
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

	long sunrise;
	long sunset;
}
