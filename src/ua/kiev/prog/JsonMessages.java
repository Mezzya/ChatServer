package ua.kiev.prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonMessages {
    private final List<Message> list;

    public JsonMessages(List<Message> sourceList, int fromIndex, String to, String room) {
        this.list = new ArrayList<>();
        Message result = null;

        for (int i = fromIndex; i < sourceList.size(); i++) {
            result = sourceList.get(i);
            if (result != null) {
                if (result.getTo().equals("All") || (result.getTo().equals(to))) {

                    if (result.getRoom().equals("All")||result.getRoom().equals(room)) {
                        list.add(result);
//                        System.out.println(result);
                    }
                } else list.add(null);

            }
        }





    }
}
