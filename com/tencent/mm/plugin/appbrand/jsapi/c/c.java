package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 221;
    private static final String NAME = "startBeaconDiscovery";
    com.tencent.mm.plugin.appbrand.e.b fQA = null;
    private com.tencent.mm.plugin.appbrand.jsapi.c.a.a.a fQx;

    private static class a extends h {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static class b extends h {
        private static final int CTRL_INDEX = 224;
        private static final String NAME = "onBeaconUpdated";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStartBeaconDiscovery", "startBeaconDiscovery data %s", new Object[]{jSONObject});
        UUID[] r = r(jSONObject);
        if (r == null || r.length <= 0) {
            lVar.E(i, f("fail:invalid data", new HashMap()));
            return;
        }
        int i2;
        String str = lVar.mAppId;
        com.tencent.mm.plugin.appbrand.jsapi.c.a.a tz = a.tz(lVar.mAppId);
        if (tz == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "beaconWorker init");
            tz = new com.tencent.mm.plugin.appbrand.jsapi.c.a.a();
            a.a(str, tz);
        }
        if (this.fQx == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "onBeaconScanCallback init");
            this.fQx = new 1(this, lVar);
        }
        if (this.fQA == null) {
            x.i("MicroMsg.JsApiStartBeaconDiscovery", "listener init");
            this.fQA = new 2(this, lVar);
            e.a(lVar.mAppId, this.fQA);
        }
        tz.fQw = r;
        tz.fQx = this.fQx;
        x.i("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[]{Integer.valueOf(tz.hashCode())});
        if (tz.aiS()) {
            x.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[]{Integer.valueOf(tz.hashCode())});
            i2 = 11003;
        } else if (d.fS(18)) {
            x.e("MicroMsg.BeaconManager", "API version is below 18!");
            i2 = 11000;
        } else if (tz.fQu == null) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            i2 = 11001;
        } else if (!tz.fQu.isEnabled()) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
            i2 = 11001;
        } else if (tz.fQu.isDiscovering()) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
            i2 = 11003;
        } else {
            tz.fQv.clear();
            x.i("MicroMsg.BeaconManager", "startLeScan:%b", new Object[]{Boolean.valueOf(tz.fQu.startLeScan(tz.fQy))});
            if (tz.fQu.startLeScan(tz.fQy)) {
                tz.bTv = true;
                i2 = 0;
            } else {
                i2 = 11005;
            }
        }
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i2));
        lVar.E(i, f(i2 == 0 ? "ok" : "fail", hashMap));
    }

    private static UUID[] r(JSONObject jSONObject) {
        UUID[] uuidArr = null;
        if (jSONObject.has("uuids")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("uuids"));
                uuidArr = new UUID[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    x.d("MicroMsg.JsApiStartBeaconDiscovery", "uuid %s", new Object[]{jSONArray.getString(i)});
                    uuidArr[i] = UUID.fromString(r3);
                }
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiStartBeaconDiscovery", "get uuid error!");
            }
        }
        return uuidArr;
    }
}
