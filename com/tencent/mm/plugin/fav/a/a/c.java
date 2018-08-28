package com.tencent.mm.plugin.fav.a.a;

import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c {
    public static void a(Map<String, String> map, wy wyVar) {
        if (map == null || wyVar == null) {
            x.w("MicroMsg.FavTagParser", "maps is null or item is null");
            return;
        }
        String str;
        wyVar.rBX.clear();
        int i = 0;
        while (i < 1024) {
            str = (String) map.get(".favitem.taglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            wyVar.rBX.add(str);
            i++;
        }
        if (!wyVar.rBX.isEmpty()) {
            x.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[]{wyVar.rBX});
        }
        wyVar.rBW.clear();
        i = 0;
        while (i < 1024) {
            str = (String) map.get(".favitem.recommendtaglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            wyVar.rBW.add(str);
            i++;
        }
        if (!wyVar.rBW.isEmpty()) {
            x.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[]{wyVar.rBW});
        }
    }

    public static String a(wy wyVar) {
        int i = 0;
        if (wyVar == null || (wyVar.rBX.isEmpty() && wyVar.rBW.isEmpty())) {
            x.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            return "";
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int size = wyVar.rBX.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bi.WS((String) wyVar.rBX.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        i2 = wyVar.rBW.size();
        stringBuffer.append("<recommendtaglist count='").append(i2).append("'>");
        while (i < i2) {
            stringBuffer.append("<tag>").append(bi.WS((String) wyVar.rBW.get(i))).append("</tag>");
            i++;
        }
        stringBuffer.append("</recommendtaglist>");
        return stringBuffer.toString();
    }
}
