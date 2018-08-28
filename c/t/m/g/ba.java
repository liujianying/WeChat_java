package c.t.m.g;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

final class ba implements Runnable {
    private /* synthetic */ az a;

    ba(az azVar) {
        this.a = azVar;
    }

    public final void run() {
        Object b = p.b();
        az azVar = this.a;
        byte[] a = this.a.a.a(b);
        try {
            if (!TextUtils.isEmpty(b) && !ci.a(a)) {
                JSONObject jSONObject = new JSONObject(new String(a));
                q qVar = new q(b);
                jSONObject.getString("ipInfo");
                jSONObject = jSONObject.optJSONObject("resultMap");
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        JSONArray optJSONArray = jSONObject.optJSONArray((String) keys.next());
                        if (optJSONArray != null) {
                            az.a(qVar, optJSONArray);
                        }
                    }
                }
                azVar.b = qVar;
            }
        } catch (Throwable th) {
        }
    }
}
