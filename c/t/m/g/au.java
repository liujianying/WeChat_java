package c.t.m.g;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public final class au extends al {
    private static au d = new au();

    private au() {
    }

    public static String a(String str, boolean z, Map<String, String> map) {
        String d = p.d();
        map.put("A23", m.d);
        aw awVar = new aw();
        awVar.a(str);
        awVar.a = System.currentTimeMillis();
        awVar.b = at.a;
        awVar.c = d;
        map.put("A1", m.c);
        map.put("A2", ci.a());
        map.put("A4", ci.b());
        map.put("A6", ci.c());
        map.put("A7", ci.e());
        map.put("A23", m.d);
        map.put("A33", p.f());
        map.put("A10", at.d);
        map.put("A9", at.c);
        map.put("A19", d);
        awVar.a(map);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ci.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
        stringBuilder.append("INFO|");
        stringBuilder.append(w.a + "|");
        stringBuilder.append(at.b + "|");
        stringBuilder.append("beacon|");
        stringBuilder.append("1.8.1|");
        d = awVar.b;
        try {
            d = URLEncoder.encode(awVar.b, "utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        stringBuilder.append(d + "|");
        stringBuilder.append("|");
        stringBuilder.append("upload_ip|");
        stringBuilder.append("|");
        stringBuilder.append(awVar.c + "|");
        stringBuilder.append(awVar.a() + "|");
        stringBuilder.append(z + "|");
        stringBuilder.append("0|");
        stringBuilder.append("0|");
        stringBuilder.append(a(awVar.b()) + "|");
        stringBuilder.append(ci.a(awVar.a, "yyyy-MM-dd HH:mm:ss") + "|");
        stringBuilder.append("upload_time");
        return stringBuilder.toString();
    }

    private static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : keySet) {
            stringBuilder.append("&");
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append((String) map.get(str));
        }
        String str2 = stringBuilder.substring(1);
        stringBuilder.setLength(0);
        return str2;
    }

    public static au f() {
        return d;
    }

    public final String a() {
        return "halley-cloud-HalleyAction";
    }

    public final int b() {
        return w.a("report_insert_new_record_num_limit", 5, 100, 100);
    }

    public final String c() {
        return "beacon";
    }
}
