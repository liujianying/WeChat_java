package com.tencent.mm.bh;

import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private static final Map<Integer, Integer> qVk = new HashMap();

    public static void run() {
        au.HU();
        if ((bi.bG(bi.a((Long) c.DT().get(66819, null), 0)) * 1000 > 1800000 ? 1 : null) != null) {
            Ut("");
        }
    }

    public static void Cy(int i) {
        qVk.put(Integer.valueOf(i), Integer.valueOf(bi.f((Integer) qVk.get(Integer.valueOf(i))) + 1));
    }

    public static String cfI() {
        String str = "[a=" + (au.HU() == null ? "0" : "1") + " ";
        if (au.HU() == null) {
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        au.HU();
        return append.append(c.DT() == null ? "0" : "1").append(" ").toString() + "u=" + (au.HX() ? "1" : "0") + "]";
    }

    public static void Ut(String str) {
        String str2 = str + cfI();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : qVk.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null || ((Integer) entry.getValue()).intValue() == 0)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(entry.getValue());
                stringBuilder.append(',');
            }
        }
        qVk.clear();
        if (stringBuilder.length() > 0) {
            x.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            br.r(10, stringBuilder.toString());
        }
        x.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :" + (str2 + cfI()));
        try {
            au.HU();
            c.DT().set(66819, Long.valueOf(bi.VE()));
        } catch (Exception e) {
            x.e("MicroMsg.PostTaskFMessageCardStat", "e:" + e.getMessage());
        }
    }
}
