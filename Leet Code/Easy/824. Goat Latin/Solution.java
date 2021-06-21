/* A sentence sentence is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only. We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows: If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word. For example, the word 'apple' becomes 'applema'. If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma". For example, the word "goat" becomes "oatgma". Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1. For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on. Return the final sentence representing the conversion from sentence to Goat Latin. 

Example 1:
Input: sentence = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

Example 2:
Input: sentence = "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

Notes:
sentence contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= sentence.length <= 150.

Link: https://leetcode.com/problems/goat-latin/ */

class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        String[] str = sentence.split(" ");
        for(int i=0; i<str.length; i++){
            StringBuilder sb = new StringBuilder();
            if((str[i].charAt(0)=='a') || (str[i].charAt(0)=='e') ||(str[i].charAt(0)=='i') ||(str[i].charAt(0)=='o') ||(str[i].charAt(0)=='u') ||(str[i].charAt(0)=='A') ||(str[i].charAt(0)=='E') ||(str[i].charAt(0)=='I') ||(str[i].charAt(0)=='O') ||(str[i].charAt(0)=='U')){
                sb.append(str[i]);
                sb.append("ma");
            }else{
                sb.append(str[i]);
                sb.deleteCharAt(0);
                sb.append(str[i].charAt(0));
                sb.append("ma");
            }
            int j = 0;
            while(i>=j){
                sb.append("a");
                j++;
            }
            sb.append(" ");
            result.append(sb);
        }
        return result.toString().trim();
    }
}