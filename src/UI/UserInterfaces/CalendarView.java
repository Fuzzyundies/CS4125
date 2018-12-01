package UI.UserInterfaces;
/**
 *
 * @author Eric
 */

import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalendarView extends JFrame
{
    private int userDay = 0;
    private int countDays = 0;
    private int maxDays = 7;
    private int maxWeeks = 7;
    private int endOfMonth = 0;
    private int userMonth = 0;
    private int userYear = 0;
    private int daysSkipped = 0;
    private int itemsCreated = 0;
    private boolean daysSkippedCounted = false;
    private String selectedYear;
    private String selectedMonth;
    private Calendar startDate;
    private Calendar endDate;
    private Calendar userDate;
    private String[] months;
    private String[] years;
    private JButton[][] dates;    
    private JPanel panel;
    
    public CalendarView()
    {
        panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        panel.setLayout(new GridLayout(maxWeeks, maxDays));
        displayCalendarView();
        

    }
    
    public void displayCalendarView()
    {
        this.setBounds(50, 50, 400, 400);
        
        startDate = Calendar.getInstance();
        userDate = (Calendar) startDate.clone();
        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        years = new String[]{"" + startDate.get(Calendar.YEAR), "" + (startDate.get(Calendar.YEAR)+1)};	
        dates = new JButton[maxWeeks][maxDays];
        
        selectedYear = (String) JOptionPane.showInputDialog(null,"Choose Year","Date Selector", JOptionPane.QUESTION_MESSAGE, null, years, years[0]);
        selectedMonth = (String) JOptionPane.showInputDialog(null,"Choose Month","Date Selector", JOptionPane.QUESTION_MESSAGE, null, months, months[0]);
        
        userYear = Integer.parseInt(selectedYear);
        switch (selectedMonth)
        {
                case "January": userMonth = 0; endOfMonth = 31; break;
                case "February": userMonth = 1; endOfMonth = leapYear(userYear); break;
                case "March": userMonth = 2; endOfMonth = 31; break;
                case "April": userMonth = 3; endOfMonth = 30; break;
                case "May": userMonth = 4; endOfMonth = 31; break;
                case "June": userMonth = 5; endOfMonth = 30; break;
                case "July": userMonth = 6; endOfMonth = 31; break;
                case "August": userMonth = 7; endOfMonth = 31; break;
                case "September": userMonth = 8; endOfMonth = 30; break;
                case "October": userMonth = 9; endOfMonth = 31; break;
                case "November": userMonth = 10; endOfMonth = 30; break;
                case "December": userMonth = 11; endOfMonth = 31; break;
                default: break;
        }
        
        userDate.set(userYear, userMonth, 1);
        
        for(int i = 0; i < maxWeeks; i++)
        {
            for(int j = 0; j <  maxDays && itemsCreated < maxDays * maxWeeks; j++)
            {
                itemsCreated++;
                System.out.println(itemsCreated);
                if(daysSkipped < userDate.get(Calendar.DAY_OF_WEEK)-1)
                {
                        dates[i][j] = new JButton("");
                        panel.add(dates[i][j]);
                        daysSkipped++;
                }
                else if(countDays < endOfMonth)
                {
                        countDays++;
                        dates[i][j] = new JButton(""+(countDays));
                        panel.add(dates[i][j]);
                        final int tempDay = countDays;
                        dates[i][j].addActionListener(new ActionListener()
                        {
                                public void actionPerformed(ActionEvent e)
                                {
                                        buttonPressed(tempDay);
                                        ((JButton)e.getSource()).setBackground(Color.green);
                                }
                        });
                        panel.add(dates[i][j]);
                }
                else
                {
                        dates[i][j] = new JButton("");
                        panel.add(dates[i][j]);
                }	
            }
        }
        userDate.set(userYear, userMonth, userDay);
        
        this.setVisible(true);
        this.setTitle("Calendar Select");
        System.out.println("User Date: " + userDate.get(Calendar.DATE) + "/" + (userDate.get(Calendar.MONTH)+1) + "/" + userDate.get(Calendar.YEAR));
        //System.out.println("Day of the Week" + startDate.get(Calendar.DAY_OF_WEEK));
        System.out.println("Start Date: " + startDate.get(Calendar.DATE) + "/" + (startDate.get(Calendar.MONTH)+1) + "/" + startDate.get(Calendar.YEAR));
    }
    
    private void buttonPressed(int buttonDate)
    {
        userDay = buttonDate;
    }

    public int leapYear(int userYear)
    {
        if((userYear % 4 == 0 && userYear % 100 != 0) || userYear % 400 == 0)
                return 29;
        else
                return 28;
    }
}
