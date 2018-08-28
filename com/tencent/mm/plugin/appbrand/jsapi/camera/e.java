package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends h {
    private static final int CTRL_INDEX = 455;
    public static final String NAME = "onCameraScanCode";
    public static e fOF = new e();

    public static void a(p pVar, int i, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(i));
        hashMap.put("type", str);
        hashMap.put("result", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        h a = fOF.a(pVar);
        a.mData = jSONObject;
        a.ahM();
    }
}
