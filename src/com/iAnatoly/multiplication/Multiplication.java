package com.iAnatoly.multiplication;

import com.iAnatoly.multiplication.helpers.InputHelper;

public class Multiplication {

    public static void main(String[] args)  {
        try {


            Session session = new Session();
            session.run();
        }
        catch (Exception ex) {
            System.out.println("Fatal error: "+ex.getMessage());
        }
        InputHelper.pause();
    }
}
