package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a$a extends h {
    public static final int CTRL_INDEX = 468;
    public static final String NAME = "onLoadSubPackageTaskStateChange";

    static /* synthetic */ void a(l lVar, String str, String str2, String str3, int i, long j, long j2) {
        x.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", new Object[]{str, str2, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)});
        Map hashMap = new HashMap();
        hashMap.put("taskId", str);
        hashMap.put("state", str2);
        hashMap.put("moduleName", str3);
        hashMap.put("progress", Integer.valueOf(i));
        hashMap.put("totalBytesWritten", Long.valueOf(j));
        hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j2));
        String jSONObject = new JSONObject(hashMap).toString();
        h a = new a$a().a(lVar);
        a.mData = jSONObject;
        a.ahM();
    }
}
