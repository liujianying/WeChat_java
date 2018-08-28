package c.t.m.g;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class dr {
    public static int a = 0;
    public final dt b;
    public final dq c;
    private final dp d;
    private final List<do> e;

    public dr(dt dtVar, dp dpVar, dq dqVar, List<do> list) {
        this.b = dtVar;
        this.d = dpVar;
        this.c = dqVar;
        this.e = list;
    }

    public final boolean a() {
        return this.c != null;
    }

    private String b(int i, String str, ct ctVar, boolean z, boolean z2, boolean z3) {
        if (ctVar == null) {
            return null;
        }
        try {
            boolean z4;
            String str2;
            String str3;
            int abs;
            StringBuilder stringBuilder;
            if (this.d == null) {
                z4 = true;
            } else {
                boolean z5 = a != this.d.e;
                a = this.d.e;
                z4 = z5;
            }
            String a = ei.a(this.b);
            String a2 = ei.a(this.d, z4);
            String a3 = ei.a(this.c);
            String a4 = do.a(this.e);
            if (z2) {
                str2 = "{}";
            } else {
                str2 = a3;
            }
            cu cuVar = ctVar.b;
            Map hashMap = new HashMap();
            hashMap.put("imei", cuVar.a());
            hashMap.put("imsi", cuVar.b());
            hashMap.put("phonenum", j.b(cuVar.d));
            hashMap.put("qq", j.b(cuVar.f));
            hashMap.put("mac", cuVar.c().toLowerCase(Locale.ENGLISH));
            String jSONObject = new JSONObject(hashMap).toString();
            String f = cuVar.f();
            eg.a();
            int a5 = eg.a(ctVar.a);
            String c = ej.c(ctVar);
            try {
                if (a.equals("[]") && !c.equals("{}")) {
                    JSONObject jSONObject2 = new JSONObject(c);
                    jSONObject2.remove("ssid");
                    a = "[" + jSONObject2.toString() + "]";
                }
                str3 = a;
            } catch (Throwable th) {
                th.toString();
                str3 = a;
            }
            a = cuVar.i;
            if (a != null) {
                a = a.replace("\"", "");
            }
            if (a != null) {
                a = a.replace("|", "");
            }
            String str4 = a + "_" + cuVar.h;
            if (z3) {
                a3 = cuVar.a();
                if (a3 != null) {
                    abs = (Math.abs(a3.hashCode()) % 1000) + 1001;
                    stringBuilder = new StringBuilder("{\"version\":\"");
                    if (cuVar.q != null) {
                        a = "None";
                    } else {
                        a = cuVar.q;
                    }
                    a = (stringBuilder.append(a).append("\",\"address\":").append(i).toString() + ",\"source\":" + abs + ",\"access_token\":\"" + f + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str4 + "\",\"bearing\":1") + ",\"control\":0";
                    if (z) {
                        a = a + ",\"detectgps\":0";
                    } else {
                        a = a + ",\"detectgps\":1";
                    }
                    return ((a + ",\"pstat\":" + a5) + ",\"wlan\":" + c) + ",\"attribute\":" + jSONObject + ",\"location\":" + str2 + ",\"cells\":" + a2 + ",\"wifis\":" + str3 + ",\"bles\":" + a4 + "}";
                }
            }
            abs = 203;
            stringBuilder = new StringBuilder("{\"version\":\"");
            if (cuVar.q != null) {
                a = cuVar.q;
            } else {
                a = "None";
            }
            a = (stringBuilder.append(a).append("\",\"address\":").append(i).toString() + ",\"source\":" + abs + ",\"access_token\":\"" + f + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str4 + "\",\"bearing\":1") + ",\"control\":0";
            if (z) {
                a = a + ",\"detectgps\":0";
            } else {
                a = a + ",\"detectgps\":1";
            }
            return ((a + ",\"pstat\":" + a5) + ",\"wlan\":" + c) + ",\"attribute\":" + jSONObject + ",\"location\":" + str2 + ",\"cells\":" + a2 + ",\"wifis\":" + str3 + ",\"bles\":" + a4 + "}";
        } catch (Exception e) {
            return null;
        }
    }

    public final String a(int i, String str, ct ctVar, boolean z, boolean z2, boolean z3) {
        return b(i, str, ctVar, z, z2, z3);
    }
}
