package Utils;

public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public static Time getTime(Time from, Time to){
        int leftMinutes = from.getHours() * 60 + to.minutes;
        int rightMinutes = from.getHours() * 60 + from.minutes;
        int delta = Math.abs(leftMinutes - rightMinutes);

        Time deltaTime = getTime(delta);

        return new Time(deltaTime.getHours() + from.getHours(), deltaTime.getMinutes() + from.getMinutes());
    }

    public static Time getTime(float time){
        int hours = (int)(time / 60f);
        int minutes = (int)time - hours * 60;

        return new Time(hours, minutes);
    }

    @Override
    public String toString() {
        return  "(" + hours + ":" + minutes + ")";
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
