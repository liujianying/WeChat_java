package c.t.m.g;

import android.text.TextUtils;
import org.json.JSONObject;

public final class bq extends bl {
    ab a = new ab();

    public bq() {
        Object string = m.a().getSharedPreferences(d(), 0).getString("halley_cloud_param_content", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.a.a(string);
            } catch (Throwable th) {
                m.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", "").commit();
            }
        }
    }

    private static String d() {
        return "Halley_Cloud_Param_Content_" + m.b() + "_for_SettingsHandler";
    }

    public final void a(bh bhVar) {
        String c = this.a.c();
        bhVar.a.put("confVersion", c);
    }

    public final void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("Setting");
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    this.a.a(optString);
                    m.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", this.a.a.toString()).commit();
                }
            }
            m.i().post(new br(this));
        } catch (Throwable th) {
            m.i().post(new br(this));
            throw th;
        }
    }

    public final String c() {
        return "settings";
    }

    public final void b() {
        m.i().post(new br(this));
    }
}
