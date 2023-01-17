package lesson7.Pogoda;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "http://www.pogoda.spb.ru";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
        private static Pattern pattern = Pattern.compile("\\d[2]\\.\\d[2]]");

        private static String getDateFromString(String stringDate) throws Exception{
            Matcher matcher = pattern.matcher(stringDate);
            if (matcher.find()){
                return matcher.group();
            }
            throw new EOFException("Can't extract date from string!");
        }
    private static int printFourValues(Elements values int index){
        int interationCount=4;
        int index = 0;
        if (index == 0) {
            Element valuen = values.get(3);
            boolean isMorning = valueLn.text().contains("Утро");
            if (isMorning) {
                interationCount = 3;
            }
        }
            for (int i = 0; i < interationCount; i++) {
                Element valueLine = values.get(index + i);
                for (Element td : valueLine.select("td")) {
                    System.out.print(td.text() + "   ");
                }
                System.out.println();
            }
        return interationCount;
    }


    public static void main(String[] args) throws IOException{
        Document page = getPage();
        // css query language
        Element tableWth =page.select("table[class=wt]").first();
        Elements names = tableWth.select("tr[class=wth]");
        Elements values = tableWth.select("tr[valing=top]");
int index =0;
        for (Element name : names){
            String dateString = name.select("th[id=dt]").text();
String date = getDateFromString(dateString);
            System.out.println(date + "Явления Температура Давл Влажность Ветер");
int interationCount = printPartValues(values, index);
index=index+interationCount;
        }
    }

    private static byte printPartValues(Elements values, int index) {
    }
}
