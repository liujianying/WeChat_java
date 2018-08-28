package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public enum b {
    ;

    public static String ar(Map<String, List<String>> map) {
        if (map == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(bi.aG((String) entry.getKey(), "null"));
            stringBuilder.append(" : ");
            List<String> list = (List) entry.getValue();
            if (list != null && list.size() > 0) {
                for (String oV : list) {
                    stringBuilder.append(bi.oV(oV)).append("|");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
