package com.iAnatoly.multiplication.Timer;


/**
 * Created by avi on 10/1/14.
 */
public class Stopwatch
{
    private long started;
    private long elapsed;
    private boolean isRunning = false;
    public void start() throws InvalidStateException {
        if (this.isRunning)
        {
            throw new InvalidStateException("Timer is already running");
        }
        this.started = System.currentTimeMillis();
        this.isRunning = true;
    }

    public void stop() throws InvalidStateException {
        if (!this.isRunning)
        {
            throw new InvalidStateException("Timer is already stopped");
        }
        this.updateTimer();
        this.isRunning = false;
    }
    public void restart() throws InvalidStateException {
        this.stop();
        this.start();
    }
    public TimeSpan getElapsed()
    {
        return new TimeSpan(this.elapsed);
    }

    public boolean exceeds(int seconds)
    {
       return this.elapsed>seconds*1000;
    }

    private void updateTimer()
    {
        if (this.isRunning)
        {
            this.elapsed = System.currentTimeMillis()-this.started;
        }
    }



}
