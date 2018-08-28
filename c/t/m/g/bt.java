package c.t.m.g;

import android.text.TextUtils;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bt extends bl {
    private static boolean a = false;

    public final void a(bh bhVar) {
        bk bkVar = new bk();
        bj bjVar = new bj();
        bi biVar = new bi();
        try {
            Integer valueOf;
            if (ci.a(bjVar.b) || !a) {
                valueOf = Integer.valueOf(1);
                bhVar.a.put("needUpdateState", valueOf);
                a = true;
            } else {
                valueOf = Integer.valueOf(0);
                bhVar.a.put("needUpdateState", valueOf);
            }
            if (ci.a(bjVar.b)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", bkVar.a);
                jSONObject.put("osVersion", bkVar.b);
                jSONObject.put("imei", bkVar.c);
                jSONObject.put("imsi", bkVar.d);
                jSONObject.put("pseudoId", bkVar.e);
                bhVar.a.put("RegistDeviceInfo", jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", bjVar.a);
            jSONObject2.put("deviceId", bjVar.b);
            jSONObject2.put("sdkVersion", bjVar.c);
            bhVar.a.put("BindDeviceInfo", jSONObject2);
            jSONObject2 = new JSONObject();
            jSONObject2.put("bundle", biVar.a);
            jSONObject2.put("verCode", biVar.b);
            jSONObject2.put("verName", biVar.c);
            jSONObject2.put("appId", biVar.e);
            jSONObject2.put("uuid", biVar.d);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            bhVar.a.put("AppState", jSONArray);
            int g = p.g();
            bhVar.a.put(DownloadInfo.NETTYPE, cd.a(g));
            String a = bf.a(p.j().intValue());
            bhVar.a.put("oper", a);
        } catch (Exception e) {
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            String a;
            Object optString = jSONObject.optString("result");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    if (Integer.parseInt(optString) == 1002) {
                        cd.a("");
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            String optString2 = jSONObject.optString("deviceId");
            if (TextUtils.isEmpty(optString2)) {
                cd.a("");
            } else {
                a = cd.a();
                if (!(TextUtils.isEmpty(optString2) || optString2.equals(a))) {
                    cd.a(optString2);
                }
            }
            a = jSONObject.optString("oper");
            if (!TextUtils.isEmpty(a)) {
                bf a2 = bf.a();
                String b = p.b();
                if (!ci.a(b) && !"unknown".equals(b) && !ci.a(a) && !"unknown".equals(a)) {
                    synchronized (a2.a) {
                        if (!a.equals((String) a2.a.get(b))) {
                            a2.a.put(b, a);
                            cd.a("HalleyOperInfo_" + m.b(), a2.b());
                        }
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    public final String c() {
        return OpenSDKTool4Assistant.EXTRA_STATE;
    }
}
