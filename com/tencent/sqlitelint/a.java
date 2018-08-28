package com.tencent.sqlitelint;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    static void u(String str, Map<String, List<String>> map) {
        String[] strArr = new String[map.size()];
        String[][] strArr2 = new String[map.size()][];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            strArr[i] = (String) entry.getKey();
            List list = (List) entry.getValue();
            strArr2[i] = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                strArr2[i][i2] = (String) list.get(i2);
            }
            i++;
        }
        SQLiteLintNativeBridge.nativeAddToWhiteList(str, strArr, strArr2);
    }
}
