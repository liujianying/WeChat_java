package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

public final class JsApiGetLocation extends a {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";
    private static final HashSet<String> fQY;
    private static final HashSet<a> fQZ = new HashSet();

    static {
        HashSet hashSet = new HashSet();
        fQY = hashSet;
        hashSet.add("gcj02");
        fQY.add("wgs84");
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        h.mEJ.e(840, 0, 1);
        String optString = jSONObject.optString(DownloadSettingTable$Columns.TYPE, "wgs84");
        x.v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s", new Object[]{optString});
        if (bi.oW(optString)) {
            optString = "wgs84";
        }
        if (bi.oW(optString) || fQY.contains(optString)) {
            p d = d(lVar);
            if (d == null) {
                lVar.E(i, f("fail", null));
                return;
            }
            LocationTask locationTask = new LocationTask();
            LocationTask.a(locationTask, lVar);
            LocationTask.a(locationTask, i);
            LocationTask.a(locationTask, this);
            LocationTask.a(locationTask, optString);
            LocationTask.a(locationTask, new WeakReference(d));
            LocationTask.a(locationTask, jSONObject.optBoolean("altitude", false));
            if (i(lVar)) {
                h.mEJ.e(840, 1, 1);
                LocationTask.a(locationTask);
                return;
            }
            h.mEJ.e(840, 2, 1);
            lVar.E(i, f("fail:system permission denied", null));
            return;
        }
        x.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", new Object[]{optString});
        h.mEJ.e(840, 3, 1);
        lVar.E(i, f("fail:unsupported type", null));
    }
}
