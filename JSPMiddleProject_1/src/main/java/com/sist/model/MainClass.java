package com.sist.model;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainClass {
   public static void main(String[] args) {
      String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); 
      StringTokenizer st = new StringTokenizer(today,"-");
      String strYear = /*null;*/ "2025";
      String strMonth = /*null;*/ "10";
      String strDay = null;
      
      if(strYear == null) {
         strYear = st.nextToken();
         System.out.println(strYear);
      }
      if(strMonth == null) {
         strMonth = st.nextToken();
         System.out.println(strMonth);
      }
      strDay = st.nextToken();
      System.out.println(strDay);
      /*
      if(strDay == null) {
         strDay = st.nextToken();
         System.out.println(strDay);
      }
      */
      
      int year = Integer.parseInt(strYear);
      int month = Integer.parseInt(strMonth);
      int day = Integer.parseInt(strDay);
      
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, year);
      cal.set(Calendar.MONTH, month-1);
      cal.set(Calendar.DATE, 1);
      
      String[] strWeek = {"일", "월", "화", "수", "목", "금", "토"};
      int week = cal.get(Calendar.DAY_OF_WEEK);
      week = week-1;
      int lastday = cal.getActualMaximum(Calendar.DATE);
      System.out.println("요일 : " + strWeek[week]);
      System.out.println("마지막일 : " + lastday);
      
      
   }
}
