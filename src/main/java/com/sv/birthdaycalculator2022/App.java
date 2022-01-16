package com.sv.birthdaycalculator2022;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author: Steven Vallarsa email: stevenvallarsa@gmail.com date: 2022-01-16
 * purpose: A simple program to practice working with DateTime
 */
public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isLooping = true;

        System.out.println("THEY SAY IT'S YOUR BIRTHDAY!");
        System.out.println("*well, maybe not today, but someday... yeah!\n");
        while (isLooping) {
            
            DateFormat df;
            
            System.out.println("Type in your birthday (or any day, really) in either the DD/MM/YYYY or YYYY-MM-DD format");
            String birthday = scanner.nextLine();
            try {
                if (birthday.indexOf("/") != -1) {
                    df = new SimpleDateFormat("M/d/y");
                } else if (birthday.indexOf("-") != -1) {
                    df = new SimpleDateFormat("y-M-d");
                } else {
                    throw new Exception("That wasn't a valid date. Try again.");
                }
                df.setLenient(false); // throws error for nonsensical dates
                
                Date ld = df.parse(birthday);
                Date thisYearBirthday = df.parse(birthday);
                thisYearBirthday.setYear(2020);
                
                Date today = new Date();
                
                DateFormat dayOfWeek = new SimpleDateFormat("EEEE");
                
                System.out.println("You were born on a " + dayOfWeek.format(ld) + ".");
                
                thisYearBirthday.setYear(2022);
                System.out.println("This year your birthday falls on a " + dayOfWeek.format(ld) + ".");
                
                long diff = today.getTime() - ld.getTime();
                System.out.println ("You've been alive " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " days!");
                
                diff = thisYearBirthday.getTime() - ld.getTime();
                if (diff < 0) {
                    System.out.println("Your birthday was " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " days ago.");
                } else if (diff > 0) {
                    System.out.println("Your birthday is going to be in  " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + " days from now.");
                } else {
                    System.out.println("Your birthday is today! Happy Birthday!");
                }
                
                
                
                
                
                
                



                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            
        }

    }

}
