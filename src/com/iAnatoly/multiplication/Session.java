package com.iAnatoly.multiplication;

import com.iAnatoly.multiplication.Config.*;
import com.iAnatoly.multiplication.Timer.InvalidStateException;
import com.iAnatoly.multiplication.helpers.EmailHelper;

import static com.iAnatoly.multiplication.Config.ConfigFactory.*;

class Session
{
    private final Config config;
    private final Stats stats;

    public Session()
    {

        this.config = getConfig();
        this.stats = new Stats(this.config);
    }

    public void run () throws InvalidStateException {
        Answer answer = new Answer(this.config.multiplicationMode);
        this.config.timer.start();

        for (int i=0; i<this.config.tries; i++)
        {
            answer.askQuestionWithFeedback(i+1);

            if (this.config.isTimeLimitExceeded())
            {
                System.out.println(" Out of time!"+(this.config.trainingMode == TrainingMode.SPARTA?" THIS IS SPARTA!!!":""));
                break;
            }

            this.stats.append(answer);
            if (!answer.isCorrect() && this.config.isPrecisionModeEnabled())
            {
                break;
            }
            answer = new Answer(answer);
        }
        this.config.timer.stop();

        String results = this.stats.getResults();
        System.out.println(results);

        if (this.config.emailNotificationEnabled)
        {
            EmailHelper helper = new EmailHelper(this.config);
            helper.sendEmail(results);
        }
    }
}
