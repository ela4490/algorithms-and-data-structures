/* Given a date string in the form Day Month Year, where:
Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].

Convert the date string to the format YYYY-MM-DD, where:
YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.

Example 1:
Input: date = "20th Oct 2052"
Output: "2052-10-20"

Example 2:
Input: date = "6th Jun 1933"
Output: "1933-06-06"

Example 3:
Input: date = "26th May 1960"
Output: "1960-05-26"

Constraints:
The given dates are guaranteed to be valid, so no error handling is necessary.
    
Link: https://leetcode.com/problems/reformat-date/ */

class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] parts = date.split(" ");
        StringBuilder d = new StringBuilder();
        String day = "";
        String month = "";
        if(parts[0].length()==4){
            day = date.substring(0,2);
            d.append(day);
        }else{
            day = date.substring(0,1);
            d.append(day);
            d = d.insert(0,"0");
        }
        if(parts[1].equals("Jan")){
            month = "01";
        }else if(parts[1].equals("Feb")){
            month = "02";
        }else if(parts[1].equals("Mar")){
            month = "03";
        }else if(parts[1].equals("Apr")){
            month = "04";
        }else if(parts[1].equals("May")){
            month = "05";
        }else if(parts[1].equals("Jun")){
            month = "06";
        }else if(parts[1].equals("Jul")){
            month = "07";
        }else if(parts[1].equals("Aug")){
            month = "08";
        }else if(parts[1].equals("Sep")){
            month = "09";
        }else if(parts[1].equals("Oct")){
            month = "10";
        }else if(parts[1].equals("Nov")){
            month = "11";
        }else if(parts[1].equals("Dec")){
            month = "12";
        }
        sb.append(parts[2]);
        sb.append("-");
        sb.append(month);
        sb.append("-");
        sb.append(d);
        return sb.toString();
    }
}