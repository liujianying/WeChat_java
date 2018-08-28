package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

final class a extends c {
    volatile a fWU;
    volatile Long fWV = null;
    volatile Long fWW = null;
    volatile int fWX = -1;
    volatile int fWY = -1;
    volatile int fWZ = -1;

    a() {
    }

    final void u(JSONObject jSONObject) {
        Date parse;
        Date parse2;
        Calendar instance;
        this.fWU = a.tX(jSONObject.optString("fields"));
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            parse = this.fWU.parse(optJSONObject.optString("start", ""));
            parse2 = this.fWU.parse(optJSONObject.optString("end", ""));
            if (parse != null) {
                this.fWV = Long.valueOf(parse.getTime());
            }
            if (parse2 != null) {
                this.fWW = Long.valueOf(parse2.getTime());
            }
        }
        if (this.fWV == null) {
            instance = Calendar.getInstance(w.sGk);
            instance.set(1900, 0, 1);
            this.fWV = Long.valueOf(instance.getTimeInMillis());
        }
        if (this.fWW == null) {
            instance = Calendar.getInstance(w.sGk);
            instance.set(2100, 11, 31);
            this.fWW = Long.valueOf(instance.getTimeInMillis());
        }
        parse2 = this.fWU.parse(jSONObject.optString("current", ""));
        if (parse2 == null) {
            Date date = new Date(System.currentTimeMillis());
            parse2 = new Date(this.fWW.longValue());
            parse = new Date(this.fWV.longValue());
            if (!date.after(parse2)) {
                if (date.before(parse)) {
                    parse2 = parse;
                } else {
                    parse2 = date;
                }
            }
        }
        this.fWX = parse2.getYear() + 1900;
        this.fWY = parse2.getMonth() + 1;
        this.fWZ = parse2.getDate();
        c.runOnUiThread(new 1(this));
    }
}
