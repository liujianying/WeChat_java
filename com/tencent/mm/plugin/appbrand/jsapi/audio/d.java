package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public final class d extends n {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstance";
    private static Vector<String> fHT = new Vector();
    public static boolean fHU = true;

    public d() {
        fHU = true;
    }

    public final String a(l lVar, JSONObject jSONObject) {
        String str = lVar.mAppId;
        String Km = b.Km();
        Map hashMap = new HashMap();
        hashMap.put("audioId", Km);
        x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[]{str, Km});
        a aVar = new a();
        aVar.bGW = Km;
        aVar.bWA = 0;
        aVar.appId = str;
        aVar.ahT();
        1 1 = new 1(this, str);
        if (!fHT.contains(str)) {
            e.a(str, 1);
            fHT.add(str);
        }
        return f("ok", hashMap);
    }
}
