package com.iAnatoly.multiplication.Config;

import com.iAnatoly.multiplication.Timer.Stopwatch;
import com.iAnatoly.multiplication.helpers.InputHelper;

public class Config
{
    public boolean emailNotificationEnabled = false;
    public String sender;
    public String recipients;
    public String smtpServer = "smtp.gmail.com:587";
    public boolean smtpTLS = true;
    public String smtpUser;
    public String smtpPassword;
    public int tries;
    public TrainingMode trainingMode;
    public MultiplicationMode multiplicationMode;
    public int timeLimit;
    public Stopwatch timer = new Stopwatch();

    public boolean isTimeLimitEnabled()
    {
        return this.trainingMode == TrainingMode.TimeTrial || this.trainingMode == TrainingMode.SPARTA;
    }
    public boolean isTimeLimitExceeded()
    {
        if (!this.isTimeLimitEnabled())
            return false;
        return this.timer.exceeds(this.timeLimit);
    }

    public boolean isPrecisionModeEnabled()
    {
        return this.trainingMode == TrainingMode.Precision || this.trainingMode == TrainingMode.SPARTA;
    }


}