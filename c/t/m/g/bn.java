package c.t.m.g;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bn extends bl {
    bm a = new bm("HttpSchedulerHandler");

    public final void a() {
        m.i().post(new bo(this, null, null));
    }

    public final void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("AccessScheduleRsp");
            if (optJSONObject != null) {
                String jSONObject2 = optJSONObject.toString();
                if (!ci.a(jSONObject2)) {
                    byte[] bytes = jSONObject2.getBytes();
                    if (!ci.a(bytes)) {
                        String b = p.b();
                        this.a.a(b, bytes);
                        m.i().post(new bo(this, b, bytes));
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public final String c() {
        return "accessscheduler";
    }

    public final void a(bh bhVar) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            bm bmVar = this.a;
            p.e();
            byte[] a = bmVar.a(p.b());
            if (ci.a(a)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(new String(a));
            }
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("resultMap");
                if (optJSONObject != null) {
                    Iterator keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        JSONArray optJSONArray = optJSONObject.optJSONArray(str);
                        if (optJSONArray != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject jSONObject4 = optJSONArray.getJSONObject(i);
                                jSONObject3.put(jSONObject4.optString("unit"), jSONObject4.optString("schedulecode"));
                            }
                            jSONObject2.put(str, jSONObject3);
                        }
                    }
                } else {
                    jSONObject2.put(m.b(), new JSONObject());
                }
            } else {
                jSONObject2.put(m.b(), new JSONObject());
            }
            bhVar.a.put("directScheduleCodes", jSONObject2);
        } catch (Exception e) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put(m.b(), new JSONObject());
                bhVar.a.put("directScheduleCodes", jSONObject);
            } catch (Exception e2) {
            }
        }
    }
}
