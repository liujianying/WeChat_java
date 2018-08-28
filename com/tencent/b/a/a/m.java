package com.tencent.b.a.a;

import android.content.Context;
import com.tencent.b.a.a.b.a;
import org.json.JSONArray;
import org.json.JSONObject;

final class m {
    private int bvI = 0;
    private JSONObject bvJ = null;
    protected Context context = null;

    m(Context context, JSONObject jSONObject) {
        this.context = context;
        this.bvI = (int) (System.currentTimeMillis() / 1000);
        this.bvJ = jSONObject;
    }

    final JSONObject tR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ky", "AVF4T76RVR81");
            jSONObject.put("et", 2);
            jSONObject.put("ts", this.bvI);
            jSONObject.put("si", this.bvI);
            s.a(jSONObject, "ui", s.aJ(this.context));
            s.a(jSONObject, "mc", s.aK(this.context));
            String tP = i.aF(this.context).tP();
            if (s.cj(tP)) {
                jSONObject.put("mid", tP);
            } else {
                jSONObject.put("mid", "0");
            }
            b bVar = new b(this.context);
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (b.bvh != null) {
                    a aVar = b.bvh;
                    jSONObject2.put("sr", new StringBuilder(String.valueOf(aVar.bvm.widthPixels)).append("*").append(aVar.bvm.heightPixels).toString());
                    s.a(jSONObject2, "av", aVar.bvk);
                    s.a(jSONObject2, "ch", aVar.bvp);
                    s.a(jSONObject2, "mf", aVar.bvo);
                    s.a(jSONObject2, "sv", aVar.bvl);
                    s.a(jSONObject2, "ov", Integer.toString(aVar.bvn));
                    jSONObject2.put("os", 1);
                    s.a(jSONObject2, "op", aVar.bvq);
                    s.a(jSONObject2, "lg", aVar.aem);
                    s.a(jSONObject2, "md", aVar.model);
                    s.a(jSONObject2, "tz", aVar.timezone);
                    if (aVar.bvs != 0) {
                        jSONObject2.put("jb", aVar.bvs);
                    }
                    s.a(jSONObject2, "sd", aVar.bvr);
                    s.a(jSONObject2, "apn", aVar.packageName);
                    if (s.aI(aVar.ctx)) {
                        JSONObject jSONObject3 = new JSONObject();
                        s.a(jSONObject3, "bs", s.aL(aVar.ctx));
                        s.a(jSONObject3, "ss", s.aM(aVar.ctx));
                        if (jSONObject3.length() > 0) {
                            s.a(jSONObject2, "wf", jSONObject3.toString());
                        }
                    }
                    JSONArray aN = s.aN(aVar.ctx);
                    if (aN != null && aN.length() > 0) {
                        s.a(jSONObject2, "wflist", aN.toString());
                    }
                    s.a(jSONObject2, "ram", aVar.bvt);
                    s.a(jSONObject2, "rom", aVar.bvu);
                    s.a(jSONObject2, "im", aVar.imsi);
                }
                s.a(jSONObject2, "cn", bVar.bvj);
                if (bVar.bvi != null) {
                    jSONObject2.put("tn", bVar.bvi);
                }
                jSONObject.put("ev", jSONObject2);
            } catch (Throwable th) {
            }
            if (this.bvJ != null) {
                jSONObject.put("ext", this.bvJ);
            }
        } catch (Throwable th2) {
        }
        return jSONObject;
    }
}
