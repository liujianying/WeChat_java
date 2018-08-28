package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.a.a;
import com.tencent.mm.plugin.appbrand.r.a.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z extends n {
    public static final int CTRL_INDEX = 425;
    public static final String NAME = "getBatteryInfo";

    public final String a(l lVar, JSONObject jSONObject) {
        c aoB = a.gCg.aoB();
        Map hashMap = new HashMap();
        hashMap.put("level", Integer.valueOf(aoB.gCq));
        hashMap.put("isCharging", Boolean.valueOf(aoB.gCp));
        return f("ok", hashMap);
    }
}
