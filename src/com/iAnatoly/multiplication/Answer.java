package com.iAnatoly.multiplication;

import com.iAnatoly.multiplication.Config.MultiplicationMode;
import com.iAnatoly.multiplication.Timer.*;
import com.iAnatoly.multiplication.helpers.InputHelper;

import java.util.Random;

class Answer
{
    private int num1;
    private int num2;
    private MultiplicationMode mode;
    private int answer = -1;
    private Random random = new Random();
    private Stopwatch elapsed = new Stopwatch();

    public Answer(MultiplicationMode mode)
    {
        this(0,0,mode);
    }

    public Answer(Answer previousAnswer)
    {
        this(previousAnswer.num1, previousAnswer.num2, previousAnswer.mode);
    }

    public Answer(int prev1, int prev2, MultiplicationMode mode)
    {
        this.mode = mode;
        this.num1 = prev1;
        this.num2 = prev2;

        while (this.isRepeating(prev1, prev2))
        {
            this.num1 = random.nextInt(13)+1;
            this.num2 = random.nextInt(12)+1;
        }
    }

    public String getQuestion()
    {
        if (this.mode == MultiplicationMode.Multiplication)
        {
            return String.format("%d X %d = ", this.num1, this.num2);
        }
        else
        {
            return String.format("%d / %d = ", this.num1*this.num2, this.num1);
        }
    }

    public boolean isCorrect()
    {
        if (this.mode==MultiplicationMode.Multiplication)
        {
            return this.num1*this.num2==this.answer;
        }

        return this.num2 == this.answer;
    }

    private boolean isRepeating(int prev1, int prev2)
    {
        return (this.num1==prev1 || this.num2==prev2 || this.num1==prev2 || this.num2==prev1);
    }

    public String getQuestionAnswer()
    {
        return String.format("%s%s",this.getQuestion(),this.answer);
    }

    public String getQuestionAnswerTiming()
    {
        return String.format("%s; time taken: %ds",this.getQuestionAnswer(),this.getElapsed().getTotalSeconds());
    }
    public String getQuestionAnswerTimingCorrectness()
    {
        return String.format("%s (%s)",this.getQuestionAnswerTiming(),this.getCorrectnessMessage());
    }



    public String getCorrectnessMessage()
    {
        return this.isCorrect()?"Correct":"Incorrect";
    }


    public void askQuestionWithFeedback(int i) throws InvalidStateException {
        this.askQuestion(i);
        System.out.println("\t"+this.getCorrectnessMessage());
    }

    public void askQuestion(int i) throws InvalidStateException {

        this.elapsed.start();
        this.answer = InputHelper.getNumber(String.format("Try #%d: %s", i, this.getQuestion()));
        this.elapsed.stop();

    }

    public TimeSpan getElapsed() {
        return this.elapsed.getElapsed();
    }
}
