package com.iAnatoly.multiplication;

import com.iAnatoly.multiplication.Config.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Stats
{
    private Config config;

    private ArrayList<Answer> stats = new ArrayList<Answer>();

    public Stats(Config config)
    {
        this.config = config;
    }

    public void append(Answer answer)
    {
        this.stats.add(answer);
    }
    public String getResults()
    {
        int total = this.stats.size();

        Collections.sort(this.stats, (a, b) -> b.getElapsed().compareTo(a.getElapsed()));
        List<Answer> slow = this.stats.subList(0,total>5?5:total);
        List<Answer> errors  = this.stats.stream()
                .filter(a -> !a.isCorrect()).collect(Collectors.toList());

        int wrong = errors.size();
        int right = total - wrong;

        StringBuilder result = new StringBuilder();
        result.append(String.format("\nMode: %s", this.config.multiplicationMode.name()));
        result.append(String.format("\nDesired attempts: %d", this.config.tries));
        result.append(String.format("\nActual attempts: %d (%d%%)",total, total*100/ this.config.tries));
        result.append(String.format("\nTime Taken: %s (%.1f seconds avg per try)",
                this.config.timer.getElapsed().toString(),
                this.config.timer.getElapsed().getTotalSeconds()*1.0/total));
        result.append(String.format("\nRight: %d(%d%%)",right, (total>0)?right*100/total:0));
        result.append(String.format("\nWrong: %d(%d%%)",wrong, (total>0)?wrong*100/total:0));
        result.append(String.format("\n\nList of wrong answers:\n\t%s",
                 errors.stream().map(Answer::getQuestionAnswerTiming).collect(Collectors.joining("\n\t"))));
        result.append(String.format("\n\nList of slow answers:\n\t%s",
                slow.stream().map(Answer::getQuestionAnswerTimingCorrectness).collect(Collectors.joining("\n\t"))));
        return result.toString();
    }
}
