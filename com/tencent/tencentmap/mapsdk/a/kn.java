package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.util.StringUtil;
import e.a;
import e.b;
import e.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kn implements jg {
    private static kn a;
    private boolean b = false;

    public static synchronized kn a() {
        kn knVar;
        synchronized (kn.class) {
            if (a == null) {
                a = new kn();
            }
            knVar = a;
        }
        return knVar;
    }

    public byte[] a(String str) {
        try {
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            a b = b(str);
            if (b == null) {
                return null;
            }
            ek a = a(b);
            if (a != null) {
                return a(a(b(), a.a()));
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private a b(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.setTag(c(jSONObject, "tag"));
            aVar.vHu = (short) a(jSONObject, "level");
            aVar.vHv = (short) a(jSONObject, "zip");
            aVar.vHt = new ArrayList();
            JSONArray b = b(jSONObject, "boundArray");
            int length = b.length();
            for (int i = 0; i < length; i++) {
                aVar.vHt.add(Integer.valueOf(b.getInt(i)));
            }
        } catch (Exception e) {
            aVar = null;
        }
        return aVar;
    }

    private ek a(a aVar) {
        c cVar = new c();
        cVar.vHw = 0;
        cVar.vHB = kh.b();
        if (!StringUtil.isEmpty(kh.a)) {
            cVar.vHA = kh.a;
        }
        cVar.imei = kh.a();
        cVar.vHy = "ANDROID";
        cVar.version = "4.0.8".replaceAll("\\.", "");
        cVar.bvp = "";
        ek ekVar = new ek();
        ekVar.a("UTF-8");
        ekVar.a(9001);
        if (this.b) {
            ekVar.c("rtthisserver");
        } else {
            ekVar.c("rttserver");
        }
        ekVar.d("getLinks");
        ekVar.a("info", cVar);
        ekVar.a("req", aVar);
        return ekVar;
    }

    private b a(String str, byte[] bArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return null;
            }
            try {
                po a = pn.a().a(str, "sosomap navsns", bArr);
                if (!(a == null || a.a == null)) {
                    ek ekVar = new ek();
                    ekVar.a("UTF-8");
                    ekVar.a(a.a);
                    return (b) ekVar.b("res");
                }
            } catch (Exception e) {
            }
            i = i2 + 1;
        }
    }

    private byte[] a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.atn;
    }

    public String b() {
        return "http://tafrtt.map.qq.com/index.wup";
    }

    private static int a(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException e) {
            }
        }
        return 0;
    }

    private static JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    private static String c(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
            }
        }
        return "";
    }
}
