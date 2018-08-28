package com.tencent.mm.plugin.label;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c {
    public static String dx(String str, String str2) {
        x.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", new Object[]{str, str2});
        if (bi.oW(str2)) {
            return str;
        }
        if (bi.oW(str)) {
            return str2 + "\u0000";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        if (bi.F(str.split(",")).contains(str2)) {
            return str + "\u0000";
        }
        return str + "," + str2 + "\u0000";
    }

    public static String dy(String str, String str2) {
        x.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", new Object[]{str, str2});
        if (bi.oW(str2)) {
            return str;
        }
        if (bi.oW(str)) {
            return "";
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        List F = bi.F(str.split(","));
        if (!F.contains(str2)) {
            return str;
        }
        F.remove(str2);
        return bq(F);
    }

    public static String bq(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append((String) list.get(i));
                if (i < size - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\u0000");
        }
        return stringBuilder.toString();
    }
}
