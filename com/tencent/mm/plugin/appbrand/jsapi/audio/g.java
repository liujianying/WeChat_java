package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 469;
    public static final String NAME = "getAvailableAudioSources";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String str = "MicroMsg.JsApiGetAvailableAudioSources";
        String str2 = "getAvailableAudioSources data:%s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject != null ? jSONObject.toString() : "";
        x.i(str, str2, objArr);
        List<String> arrayList = new ArrayList();
        arrayList.add(b.gib.toString().toLowerCase());
        arrayList.add(b.gic.toString().toLowerCase());
        arrayList.add(b.gid.toString().toLowerCase());
        arrayList.add(b.gie.toString().toLowerCase());
        arrayList.add(b.gif.toString().toLowerCase());
        if (d.fR(24)) {
            arrayList.add(b.gig.toString().toLowerCase());
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : arrayList) {
            jSONArray.put(put);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("audioSources", jSONArray);
        x.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", new Object[]{hashMap.toString()});
        lVar.E(i, f("ok", hashMap));
    }
}
