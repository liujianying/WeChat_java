package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.bi;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class h {
    protected static String aBr = "weixin/android";
    protected static int dkb = 0;
    protected static String host = "";
    protected static String mcw = "";

    public static class b {
        d mcA;
        int mcx;
        Map<String, String> mcy;
        Map<String, String> mcz;

        public b(int i, Map<String, String> map, Map<String, String> map2, d dVar) {
            this.mcx = i;
            this.mcy = map;
            this.mcz = map2;
            this.mcA = dVar;
        }

        public final String toString() {
            return "Request method:" + this.mcx + ", params:" + (this.mcy != null ? this.mcy : "") + ", cookie:" + (this.mcz != null ? this.mcz : "");
        }
    }

    public static class d {
        String bPE;
        String filePath;

        public d(String str, String str2) {
            this.bPE = str;
            this.filePath = str2;
        }
    }

    public abstract c a(String str, String str2, b bVar, a aVar);

    public abstract void cancel();

    public static void setHost(String str) {
        x.host = str;
    }

    public static void setUserAgent(String str) {
        x.aBr = str;
    }

    public static void JQ(String str) {
        mcw = str;
    }

    protected static String b(String str, String str2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(str2.startsWith("http://") || str2.startsWith("https://"))) {
            stringBuilder.append(str + host);
        }
        stringBuilder.append(str2);
        if (map == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        Iterator it = map.keySet().iterator();
        while (true) {
            Object obj2 = obj;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            String str3 = (String) it.next();
            stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str3, "utf-8")).append('=').append(URLEncoder.encode(bi.oV((String) map.get(str3)), "utf-8"));
            obj = null;
        }
    }

    protected static String J(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        Iterator it = map.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            String str = (String) it.next();
            stringBuilder.append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode((String) map.get(str), "utf-8"));
            i = i2 + 1;
            if (map.size() > i) {
                stringBuilder.append("; ");
            }
        }
    }

    protected static Map<String, String> JR(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
