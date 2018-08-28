package com.tencent.mm.bh;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class d$a {
    public int ecL = 0;
    public int hitCount = 0;

    public static String at(Map<String, d$a> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (map != null) {
            try {
                if (map.size() > 0) {
                    stringBuilder.append("<voiptenmin>");
                    for (Entry entry : map.entrySet()) {
                        Object key = entry.getKey();
                        d$a d_a = (d$a) entry.getValue();
                        stringBuilder.append("<" + key);
                        stringBuilder.append(" hitcount = \"");
                        stringBuilder.append(d_a.hitCount);
                        stringBuilder.append("\"");
                        stringBuilder.append(" sendcount = \"");
                        stringBuilder.append(d_a.ecL);
                        stringBuilder.append("\"");
                        stringBuilder.append("/>");
                    }
                    stringBuilder.append("</voiptenmin>");
                }
            } catch (Throwable e) {
                x.e("PostTaskTenMinutesLogicState", "exception:%s", new Object[]{bi.i(e)});
                return null;
            }
        }
        x.d("PostTaskTenMinutesLogicState", "mapToXml " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static Map<String, d$a> Uv(String str) {
        Throwable e;
        Map<String, d$a> map = null;
        x.d("PostTaskTenMinutesLogicState", "xml " + str);
        if (str == null) {
            return null;
        }
        try {
            Map z = bl.z(str, "voiptenmin");
            if (z == null || z.size() <= 0) {
                return null;
            }
            Map<String, d$a> hashMap = new HashMap();
            try {
                for (Entry entry : z.entrySet()) {
                    String str2 = (String) entry.getKey();
                    if (str2 == null) {
                        break;
                    }
                    String[] split = str2.split("\\.");
                    x.d("PostTaskTenMinutesLogicState", "key is " + str2);
                    x.d("PostTaskTenMinutesLogicState", "array is " + split.length);
                    if (str2 != null && split.length >= 4) {
                        d$a d_a;
                        x.d("PostTaskTenMinutesLogicState", "getValue is " + ((String) entry.getValue()) + "array[1] " + split[2]);
                        if (hashMap.containsKey(split[2])) {
                            d_a = (d$a) hashMap.get(split[2]);
                        } else {
                            d_a = new d$a();
                        }
                        if (str2.contains("hitcount")) {
                            d_a.hitCount = bi.getInt((String) entry.getValue(), 0);
                        } else if (str2.contains("sendcount")) {
                            d_a.ecL = bi.getInt((String) entry.getValue(), 0);
                        }
                        x.d("PostTaskTenMinutesLogicState", "hitCount " + d_a.hitCount + "sendCount " + d_a.ecL);
                        hashMap.put(split[2], d_a);
                    }
                }
                return hashMap;
            } catch (Exception e2) {
                e = e2;
                map = hashMap;
                x.e("PostTaskTenMinutesLogicState", "exception:%s", new Object[]{bi.i(e)});
                return map;
            }
        } catch (Exception e3) {
            e = e3;
            x.e("PostTaskTenMinutesLogicState", "exception:%s", new Object[]{bi.i(e)});
            return map;
        }
    }
}
