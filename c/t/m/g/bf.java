package c.t.m.g;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class bf {
    private static bf b = new bf();
    public Map<String, String> a = new bg();

    private bf() {
        a(cd.b("HalleyOperInfo_" + m.b(), ""), false);
    }

    public static bf a() {
        return b;
    }

    public static String a(int i) {
        return i == 1 ? "cm" : i == 3 ? "ct" : i == 2 ? "uni" : "";
    }

    public final String a(String str) {
        if (ci.a(str) || "unknown".equals(str)) {
            return "";
        }
        synchronized (this.a) {
            String str2 = (String) this.a.get(str);
            if (ci.a(str2)) {
                return "";
            }
            return str2;
        }
    }

    public final void a(String str, boolean z) {
        try {
            if (!ci.a(str)) {
                synchronized (this.a) {
                    this.a.clear();
                    String[] split = str.split("h;l");
                    if (split != null) {
                        for (String split2 : split) {
                            String[] split3 = split2.split("h,l");
                            if (split3.length == 2) {
                                this.a.put(split3[0], split3[1]);
                            }
                        }
                    }
                }
                if (z) {
                    cd.a("HalleyOperInfo_" + m.b(), str);
                }
            }
        } catch (Exception e) {
        }
    }

    public final String b() {
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this.a) {
            List arrayList = new ArrayList(this.a.keySet());
            List arrayList2 = new ArrayList(this.a.values());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    String str = (String) arrayList2.get(i2);
                    stringBuilder.append((String) arrayList.get(i2)).append("h,l").append(str).append("h;l");
                    i = i2 + 1;
                }
            }
        }
        return stringBuilder.toString();
    }
}
