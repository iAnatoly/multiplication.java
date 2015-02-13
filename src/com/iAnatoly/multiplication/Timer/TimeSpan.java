package com.iAnatoly.multiplication.Timer;


/**
 * Created by avi on 10/1/14.
 */
public class TimeSpan implements Comparable<TimeSpan>
{
    private long milliseconds;
    public TimeSpan (long milliseconds)
    {
        this.milliseconds = milliseconds;
    }
    public int getSeconds()
    {
        return (int) (this.milliseconds /1000 % 60);
    }
    public int getTotalMinutes()
    {
        return (int) (this.milliseconds / 60000);
    }
    public int getTotalSeconds()
    {
        return (int) (this.milliseconds /1000);
    }
    @Override
    public String toString()
    {
        return String.format("%dm %ds", this.getTotalMinutes(), this.getSeconds());
    }
    @Override
    public int compareTo(TimeSpan o) {
        return Long.compare(this.milliseconds,o.milliseconds);
    }


}
