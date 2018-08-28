package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.TimerTask;
import org.json.JSONObject;

class cm$a extends TimerTask {
    private final JSONObject a;
    private cn b;
    private co c;
    private String d;
    private /* synthetic */ cm e;

    public cm$a(cm cmVar) {
        this.e = cmVar;
        this.a = new JSONObject();
        this.b = null;
        this.c = null;
        this.d = "";
        this.b = cn.a();
        this.c = co.a();
    }

    public final void run() {
        boolean a;
        try {
            if (Math.abs(System.currentTimeMillis() - this.b.c("last_pull_time")) >= cm.d()) {
                a = cm.a(this.e);
                if (a) {
                    this.c.c();
                }
                Thread.currentThread().setPriority(1);
                JSONObject a2 = a();
                if (a2 != this.a) {
                    int parseInt = Integer.parseInt(a2.optString("status", "-5"));
                    cj.a("CC_Task", "status:" + parseInt);
                    switch (parseInt) {
                        case 0:
                            if (a2.has("version")) {
                                a(a2);
                                break;
                            }
                            break;
                    }
                    String str = "last_pull_time";
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    SharedPreferences b = this.c.b();
                    if (b != null) {
                        Editor edit = b.edit();
                        edit.putString(str, valueOf);
                        edit.apply();
                    }
                    Thread.sleep(2000);
                    cj.a("CC_Task", "---> finish update xml");
                }
                this.b.b();
                if (a) {
                    this.c.d();
                }
            } else {
                cj.a("CC_Task", "skip pull");
            }
        } catch (Throwable th) {
            cj.a("CC_Task", th.getMessage(), th);
            return;
        }
        if (cm.a(this.e)) {
            cm.b(this.e);
        }
    }

    private void a(JSONObject jSONObject) {
        SharedPreferences b = this.c.b();
        if (b != null) {
            int parseInt;
            int b2 = this.b.b("cc_version");
            try {
                parseInt = Integer.parseInt(jSONObject.optString("version", this.b.e("cc_version")));
            } catch (Throwable th) {
                parseInt = b2;
            }
            if (parseInt == b2) {
                cj.a("CC_Task", "local version == server version");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONObject jSONObject2 = optJSONObject == null ? this.a : optJSONObject;
            Editor edit = b.edit();
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    String e = this.b.e(str);
                    if (!(e == null || e.length() == 0)) {
                        edit.putString(str, jSONObject2.optString(str, e));
                    }
                } catch (Exception e2) {
                    cj.b("CC_Task", e2.getMessage());
                }
            }
            edit.putString("cc_version", String.valueOf(parseInt));
            try {
                long parseLong = Long.parseLong(jSONObject2.optString("cc_req_interval", this.b.e("cc_req_interval")));
                if (parseLong < 3600000) {
                    parseLong = 3600000;
                } else if (parseLong > 86400000) {
                    parseLong = 86400000;
                }
                edit.putString("cc_req_interval", String.valueOf(parseLong));
            } catch (Throwable th2) {
            }
            edit.apply();
        }
    }

    private JSONObject a() {
        if (cm.c(this.e) == null) {
            return this.a;
        }
        String str = "https://cc.map.qq.com/?get_c3";
        cj.a("CC_Task", "cc_url:" + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc_version", this.b.e("cc_version"));
            jSONObject.put("m_module", cn.a);
            jSONObject.put("m_channel", cn.b);
            jSONObject.put("m_version", cn.c);
            jSONObject.put("imei", b());
            String a = ck.a(jSONObject.toString(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
            cj.a("CC_Task", "req:" + a);
            a = cm.c(this.e).a(str, a.getBytes());
            if (TextUtils.isEmpty(a)) {
                cj.a("CC_Task", "net work error! res = " + a);
                return this.a;
            }
            Object obj;
            cj.a("CC_Task", "res:" + a);
            str = this.a.toString();
            if (str.equals(a)) {
                cj.a("CC_Task", "network or server error,response empty json");
                obj = str;
            } else {
                cj.a("CC_Task", "start dec");
                str = ck.b(a, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
                cj.a("CC_Task", "end dec");
                a = str;
            }
            if (TextUtils.isEmpty(obj)) {
                return this.a;
            }
            return new JSONObject(obj);
        } catch (Throwable th) {
            cj.a("CC_Task", th.getMessage(), th);
            return this.a;
        }
    }

    @SuppressLint({"MissingPermission"})
    private String b() {
        String str = "0123456789ABCDEF";
        if (TextUtils.isEmpty(this.d) || str.equals(this.d)) {
            String deviceId;
            String str2 = "";
            try {
                deviceId = ((TelephonyManager) cm.e().getSystemService("phone")).getDeviceId();
            } catch (Throwable th) {
                deviceId = str2;
            }
            if (TextUtils.isEmpty(deviceId)) {
                deviceId = str;
            }
            this.d = deviceId;
        }
        return this.d;
    }
}
