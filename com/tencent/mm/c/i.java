package com.tencent.mm.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class i {
    private Map<String, a> bxA = new HashMap();
    public String bxz;
    public int versionCode;

    public i(String str, int i) {
        if (str == null) {
            this.bxz = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.bxz = str;
        }
        this.versionCode = i;
    }

    public final void a(a aVar) {
        this.bxA.put(aVar.bxB, aVar);
    }

    public final a cF(String str) {
        return (a) this.bxA.get(str);
    }

    public final String uv() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[]{this.bxz, Integer.valueOf(this.bxA.size()), Integer.valueOf(this.versionCode)}));
        for (Entry value : this.bxA.entrySet()) {
            a aVar = (a) value.getValue();
            stringBuilder.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[]{aVar.bxB, aVar.bxC, aVar.bxD, aVar.url, Integer.valueOf(aVar.size)}));
        }
        stringBuilder.append("</patchupdate>");
        return stringBuilder.toString();
    }

    public static i cG(String str) {
        Map z = f.z(str, "patchupdate");
        if (z == null) {
            return null;
        }
        i iVar = new i((String) z.get(".patchupdate.$base"), j.cH((String) z.get(".patchupdate.$versioncode")));
        int cH = j.cH((String) z.get(".patchupdate.$count"));
        int i = 0;
        while (i < cH) {
            Object obj;
            String str2 = ".patchupdate.item" + (i > 0 ? Integer.valueOf(i) : "");
            a aVar = new a((String) z.get(new StringBuilder(String.valueOf(str2)).append(".$old").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$new").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$patch").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$url").toString()), j.cH((String) z.get(new StringBuilder(String.valueOf(str2)).append(".$size").toString())));
            if (aVar.bxB == null || aVar.bxC == null || aVar.bxD == null || aVar.url == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                iVar.bxA.put(aVar.bxB, aVar);
            }
            i++;
        }
        return iVar;
    }
}
