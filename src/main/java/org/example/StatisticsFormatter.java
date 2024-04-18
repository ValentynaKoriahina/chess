package org.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * StatisticsFormatter class is intended for formatting statistics and outputting it to an XML file.
 */
public class StatisticsFormatter {
    String fileName;
    Map<String, Integer> attributes;

    /**
     * StatisticsFormatter class constructor.
     *
     * @param fileName The name of the file to save statistics.
     * @param attributes Attributes to generate statistics.
     */
    StatisticsFormatter(String fileName, Map<String, Integer> attributes ) {
        this.fileName = fileName;
        this.attributes = attributes;
    }

    /**
     * Method processes statistics and formats it into XML-format.
     */
    public void process() {
        List<StatisticsItem> sortedSkillCount = sortByValueDescending(attributes);
        outputResult(sortedSkillCount);
    }

    /**
     * The method sorts attributes by descending value and converts them into a list of statistical elements.
     *
     * @param map Attributes to sort and convert.
     * @return List of statistical elements sorted by descending value.
     */
    List<StatisticsItem> sortByValueDescending(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<StatisticsItem> sortedItems = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedItems.add(new StatisticsItem(entry.getKey(), entry.getValue()));
        }
        return sortedItems;
    }

    /**
     * The method outputs the result of statistics formatting to an XML file.
     *
     * @param data Data to output.
     */
    private void outputResult(List<StatisticsItem> data) {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("statistics", List.class);
        xstream.alias("item", StatisticsItem.class);

        // Правильное создание элементов XML для полей
        xstream.aliasField("value", StatisticsItem.class, "value");
        xstream.aliasField("count", StatisticsItem.class, "count");

        String xml = xstream.toXML(data);
        try (FileWriter writer = new FileWriter("statistics_by_" + fileName + ".xml")) {
            writer.write(xml);
            System.out.println("The XML file has been successfully created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
