package com.iAnatoly.multiplication.Config;

import com.iAnatoly.multiplication.Config.Config;
import com.iAnatoly.multiplication.helpers.InputHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFactory
{
    public static String getFileName()
    {
        return "multiplication.properties";
    }
    public static Config getConfig()
    {
        Config config = new Config();
        readProperties(config);
        askUserParameters(config);
        return config;
    }

    protected static void askUserParameters(Config config)
    {
        if (InputHelper.getBooleanAnswerWithDefault("Use division instead of multiplication? [yes|no] ", false))
        {
            config.multiplicationMode = MultiplicationMode.Division;
        }
        else
        {
            config.multiplicationMode = MultiplicationMode.Multiplication;
        }

        config.tries = InputHelper.getNumberWithDefault("How many tries? [please enter a number] ", config.tries);
        System.out.println("Please select mode:\n1: Training (no time limit, mistakes are allowed);\n2: Precision trial (no time limit, stop after first mistake);\n3: Time trial (time limit, mistakes are allowed);\n4: THIS IS SPARTA (time limit, stop after first error).\n");
        config.trainingMode = TrainingMode.values()[InputHelper.getSelection(4)-1];

        if (config.isTimeLimitEnabled())
        {
            config.timeLimit = InputHelper.getNumberWithDefault("Time limit (seconds)", 180);
        }
    }
    private static void readProperties(Config config)
    {


        try {
            Properties prop = new Properties();
            String filename = System.getProperty("user.dir") + "/Multiplication.properties";
            InputStream stream = new FileInputStream(filename);
            prop.load(stream);

            config.emailNotificationEnabled = Boolean.parseBoolean(prop.getProperty("emailnotificationenabled"));
            config.sender = prop.getProperty("sender");
            config.recipients = prop.getProperty("recipients");
            config.smtpServer = prop.getProperty("smtpserver");
            config.smtpTLS = Boolean.parseBoolean(prop.getProperty("smtptls"));
            config.smtpUser = prop.getProperty("smtpuser");
            config.smtpPassword = prop.getProperty("smtppassword");

        }
        catch (Exception ex)
        {
            System.out.println("Cannot read config file: "+ex.getMessage());
        }
    }

}
