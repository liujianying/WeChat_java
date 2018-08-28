package com.tencent.mm.al;

import android.content.Context;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class b {
    private static Map<String, a> dYu = null;
    private static String dYv = null;

    public static boolean Pz() {
        return !w.fD(ad.getContext()).equals("zh_CN");
    }

    public static boolean PA() {
        return bi.fU(ad.getContext());
    }

    public static boolean PB() {
        if (q.GE() == 0 && bi.fU(ad.getContext())) {
            return false;
        }
        return true;
    }

    public static boolean PC() {
        if (!w.chP().equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() == TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return false;
        }
        return true;
    }

    public static boolean PD() {
        return bi.fU(ad.getContext());
    }

    private static void mi(String str) {
        dYu = new HashMap();
        String[] split = bi.oV(str).trim().split(",");
        for (String trim : split) {
            String[] split2 = trim.trim().split(":");
            if (split2.length < 4) {
                x.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split2);
            } else {
                a aVar;
                if (w.chN()) {
                    aVar = new a(split2[0], split2[1], split2[2], split2[3], a.mh(split2[2]));
                } else {
                    aVar = new a(split2[0], split2[1], split2[2], split2[3], split2[3].charAt(0));
                }
                dYu.put(aVar.dYw, aVar);
            }
        }
    }

    public static a j(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(dYv)) {
                dYu = null;
            }
        } catch (Exception e) {
        }
        if (dYu == null) {
            dYv = str3;
            mi(str2);
        }
        return (a) dYu.get(str.toUpperCase());
    }

    public static List<a> E(Context context, String str) {
        String str2 = null;
        try {
            str2 = context.getResources().getConfiguration().locale.getLanguage();
            if (str2 == null || !str2.equals(dYv)) {
                dYu = null;
            }
        } catch (Exception e) {
        }
        if (dYu == null) {
            dYv = str2;
            mi(str);
        }
        return new ArrayList(dYu.values());
    }

    public static boolean mj(String str) {
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            return false;
        }
        return true;
    }

    public static String mk(String str) {
        if (str.startsWith("+886") || str.startsWith("+86")) {
            return "zh-TW";
        }
        if (str.startsWith("+852") || str.startsWith("+853")) {
            return "zh-HK";
        }
        if (str.startsWith("+81")) {
            return "ja";
        }
        if (str.startsWith("+82")) {
            return "ko";
        }
        if (str.startsWith("+66")) {
            return "th";
        }
        if (str.startsWith("+84")) {
            return "vi";
        }
        if (str.startsWith("+62")) {
            return "id";
        }
        if (str.startsWith("+55")) {
            return "pt";
        }
        if (str.startsWith("+34")) {
            return "es-419";
        }
        return "en";
    }

    public static String k(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(dYv)) {
                dYu = null;
            }
        } catch (Exception e) {
        }
        if (dYu == null) {
            dYv = str3;
            mi(str2);
        }
        for (a aVar : dYu.values()) {
            if (aVar.dYx.equals(str)) {
                return aVar.dYy;
            }
        }
        return "";
    }

    public static String l(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(dYv)) {
                dYu = null;
            }
        } catch (Exception e) {
        }
        if (dYu == null) {
            dYv = str3;
            mi(str2);
        }
        for (a aVar : dYu.values()) {
            if (aVar.dYx.equals(str)) {
                return aVar.dYw;
            }
        }
        return "";
    }

    public static boolean ml(String str) {
        if (bi.oW(str) || !new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(str)) {
            return false;
        }
        return true;
    }

    public static boolean mm(String str) {
        if (bi.oW(str) || !new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(str)) {
            return false;
        }
        return true;
    }
}
