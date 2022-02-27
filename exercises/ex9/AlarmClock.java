public class AlarmClock extends Clock{

    private int alarmHours;
    private int alarmMinutes;

    public AlarmClock(){
        super(0,0,0);
    }

    public AlarmClock(int h, int m){
        super(h,m,0);
    }

    public AlarmClock(int h, int m, int s){
        super(h,m,s);
    }

    public int getAlarmHours(){
        return(alarmHours);
    }

    public int getAlarmMinutes(){
        return(alarmMinutes);
    }

    public void setAlarm(int h, int m){
        alarmHours = h;
        alarmMinutes = m;
    }

    public boolean isRinging(){
        return(false);
    }

    @Override
    public void display(){
        
    }

}