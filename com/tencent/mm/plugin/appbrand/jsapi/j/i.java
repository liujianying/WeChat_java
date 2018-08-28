package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.ui.widget.picker.f;
import org.json.JSONObject;

final class i extends c {
    int fXA = -1;
    int fXv = -1;
    int fXw = -1;
    int fXx = Integer.MAX_VALUE;
    int fXy = Integer.MAX_VALUE;
    int fXz = -1;

    i() {
    }

    final void u(JSONObject jSONObject) {
        int[] abB;
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] abB2 = f.abB(optString);
            if (abB2 != null) {
                this.fXv = abB2[0];
                this.fXw = abB2[1];
            }
            abB = f.abB(optString2);
            if (abB != null) {
                this.fXx = abB[0];
                this.fXy = abB[1];
            }
        }
        this.fXv = Math.max(this.fXv, 0);
        this.fXw = Math.max(this.fXw, 0);
        this.fXx = Math.min(this.fXx, 23);
        this.fXy = Math.min(this.fXy, 59);
        abB = f.abB(jSONObject.optString("current"));
        if (abB != null) {
            this.fXz = abB[0];
            this.fXA = abB[1];
        }
        c.runOnUiThread(new Runnable() {
            public final void run() {
                i iVar = i.this;
                AppBrandTimePicker appBrandTimePicker = (AppBrandTimePicker) iVar.C(AppBrandTimePicker.class);
                if (appBrandTimePicker == null) {
                    iVar.h("fail cant init view", null);
                    return;
                }
                a aVar = iVar.gMI;
                int i = iVar.fXv;
                int i2 = iVar.fXw;
                appBrandTimePicker.fXv = i;
                appBrandTimePicker.fXw = i2;
                if (f.GF(appBrandTimePicker.fXv) && appBrandTimePicker.gNn != null) {
                    appBrandTimePicker.gNn.setMinValue(appBrandTimePicker.fXv);
                }
                i = iVar.fXx;
                i2 = iVar.fXy;
                appBrandTimePicker.fXx = i;
                appBrandTimePicker.fXy = i2;
                if (f.GF(appBrandTimePicker.fXx) && appBrandTimePicker.gNn != null) {
                    appBrandTimePicker.gNn.setMaxValue(appBrandTimePicker.fXx);
                }
                i = iVar.fXz;
                i2 = iVar.fXA;
                if (f.GF(i) && f.GE(i2)) {
                    appBrandTimePicker.setCurrentHour(Integer.valueOf(i));
                    appBrandTimePicker.setCurrentMinute(Integer.valueOf(i2));
                }
                appBrandTimePicker.aqt();
                aVar.setOnResultListener(new 2(iVar));
                aVar.show();
            }
        });
    }
}
