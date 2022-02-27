public class AlaramClock extends Clock{

    private int alarmHours;
    private int alarmMinutes;

    public AlarmClock(){
        super.Clock(0,0,0);
    }

    public AlarmClock(int h, int m){
        super.Clock(h,m,0);
    }

    public AlarmClock(int h, int m, int s){
        super.Clock(h,m,s);
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