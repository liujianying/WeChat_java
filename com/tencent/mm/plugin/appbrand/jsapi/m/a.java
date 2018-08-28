package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 92;
    public static final String NAME = "enableAccelerometer";
    private Handler mHandler = new Handler(c.Em().lnJ.getLooper());

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        try {
            boolean z = jSONObject.getBoolean("enable");
            int optInt = jSONObject.optInt("interval", 200);
            SensorManager sensorManager = (SensorManager) lVar.getContext().getSystemService("sensor");
            if (sensorManager == null) {
                x.i("MicroMsg.JsApiEnableAccelerometer", "getSystemService(SENSOR_SERVICE) failed.");
                lVar.E(i, f("fail", null));
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                x.i("MicroMsg.JsApiEnableAccelerometer", "get Accelerometer sensor failed.");
                lVar.E(i, f("fail", null));
                return;
            }
            boolean z2;
            String f;
            String str = "JsApi#SensorAccelerometer" + lVar.hashCode();
            b v;
            if (z) {
                b ia = u.Hx().ia(str);
                if (ia == null) {
                    v = u.Hx().v(str, true);
                } else {
                    v = ia;
                }
                if (((b) v.get("sensor_event_listener", null)) != null) {
                    x.w("MicroMsg.JsApiEnableAccelerometer", "register failed, sensorEventListener has already registered.");
                    lVar.E(i, f("fail, has enable, should stop pre operation", null));
                    return;
                }
                1 1 = new 1(this, lVar, lVar, sensorManager);
                e.a(lVar.mAppId, 1);
                v.p("sensor_event_listener", 1);
                z = sensorManager.registerListener(1, defaultSensor, f.kR(optInt), this.mHandler);
                if (!z) {
                    sensorManager.unregisterListener(1);
                    e.b(lVar.mAppId, 1);
                    v.recycle();
                    u.Hx().ib(str);
                }
                x.i("MicroMsg.JsApiEnableAccelerometer", "register accelerometer sensor finished(s : %s, r : %s).", new Object[]{str, Boolean.valueOf(z)});
                z2 = z;
            } else {
                v = u.Hx().ib(str);
                if (v == null) {
                    x.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, keyValueSet do not exist.");
                    lVar.E(i, f("fail", null));
                    return;
                }
                b bVar = (b) v.get("sensor_event_listener", null);
                if (bVar == null) {
                    x.i("MicroMsg.JsApiEnableAccelerometer", "unregister sensor event listener failed, listener do not exist.");
                    lVar.E(i, f("fail", null));
                    return;
                }
                sensorManager.unregisterListener(bVar);
                e.b(lVar.mAppId, bVar);
                v.recycle();
                x.i("MicroMsg.JsApiEnableAccelerometer", "unregister accelerometer sensor finished(s : %s).", new Object[]{str});
                z2 = true;
            }
            if (z2) {
                f = f("ok", null);
            } else {
                f = f("fail", null);
            }
            lVar.E(i, f);
        } catch (JSONException e) {
            x.i("MicroMsg.JsApiEnableAccelerometer", "json data do not contains parameter enable.");
            lVar.E(i, f("fail", null));
        }
    }
}
