package ua.kiev.prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonMessages {
    private final List<Message> list;

    public JsonMessages(List<Message> sourceList, int fromIndex, String to) {
        this.list = new ArrayList<>();
        Message result = null;
        System.out.println(">> Start out msg to " + to);
        for (int i = fromIndex; i < sourceList.size(); i++) {
            result = sourceList.get(i);
            if (result != null) {
                if (result.getTo().equals("All") || (result.getTo().equals(to))) {
                    list.add(result);
                    System.out.println(result);
                } else list.add(null);

            }
        }

        System.out.println(">> End out msg to " + to+ " Size "+ list.size());



    }
}
