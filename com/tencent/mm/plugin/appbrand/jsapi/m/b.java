package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";
    SensorManager bgR;
    private Handler mHandler = new Handler(c.Em().lnJ.getLooper());

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            int optInt = jSONObject.optInt("interval", 200);
            if (this.bgR == null) {
                this.bgR = (SensorManager) lVar.getContext().getSystemService("sensor");
            }
            if (this.bgR == null) {
                x.i("MicroMsg.JsApiEnableCompass", "getSystemService(SENSOR_SERVICE) failed.");
                lVar.E(i, f("fail", null));
                return;
            }
            Sensor defaultSensor = this.bgR.getDefaultSensor(2);
            Sensor defaultSensor2 = this.bgR.getDefaultSensor(1);
            if (defaultSensor == null || defaultSensor2 == null) {
                x.i("MicroMsg.JsApiEnableCompass", "get compass or accelerometer sensor failed.");
                lVar.E(i, f("fail", null));
                return;
            }
            boolean z2;
            String f;
            String str = "JsApi#SensorMagneticField" + lVar.hashCode();
            com.tencent.mm.model.u.b v;
            if (z) {
                com.tencent.mm.model.u.b ia = u.Hx().ia(str);
                if (ia == null) {
                    v = u.Hx().v(str, true);
                } else {
                    v = ia;
                }
                if (((b) v.get("sensor_event_listener", null)) != null) {
                    x.w("MicroMsg.JsApiEnableCompass", "register failed, sensorEventListener has already registered.");
                    lVar.E(i, f("fail, has enable, should stop pre operation", null));
                    return;
                }
                1 1 = new 1(this, lVar, lVar);
                e.a(lVar.mAppId, 1);
                v.p("sensor_event_listener", 1);
                z2 = this.bgR.registerListener(1, defaultSensor, f.kR(optInt), this.mHandler) && this.bgR.registerListener(1, defaultSensor2, f.kR(optInt), this.mHandler);
                if (!z2) {
                    this.bgR.unregisterListener(1);
                    1.fYf = true;
                    e.b(lVar.mAppId, 1);
                    v.recycle();
                    u.Hx().ib(str);
                }
                x.i("MicroMsg.JsApiEnableCompass", "register compass sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z2)});
            } else {
                v = u.Hx().ib(str);
                if (v == null) {
                    x.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, keyValueSet do not exist.");
                    lVar.E(i, f("fail", null));
                    return;
                }
                b bVar = (b) v.get("sensor_event_listener", null);
                if (bVar == null) {
                    x.i("MicroMsg.JsApiEnableCompass", "unregister sensor event listener failed, listener do not exist.");
                    lVar.E(i, f("fail", null));
                    return;
                }
                this.bgR.unregisterListener(bVar);
                e.b(lVar.mAppId, bVar);
                bVar.fYf = true;
                v.recycle();
                z2 = true;
                x.i("MicroMsg.JsApiEnableCompass", "unregister compass sensor finished(%s).", new Object[]{str});
            }
            if (z2) {
                f = f("ok", null);
            } else {
                f = f("fail", null);
            }
            lVar.E(i, f);
        } catch (JSONException e) {
            x.i("MicroMsg.JsApiEnableCompass", "json data do not contains parameter enable.");
            lVar.E(i, f("fail", null));
        }
    }
}
