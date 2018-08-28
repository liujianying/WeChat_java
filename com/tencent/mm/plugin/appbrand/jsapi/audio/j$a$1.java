package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.jsapi.audio.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class j$a$1 extends c<t> {
    final /* synthetic */ a fIR;

    j$a$1(a aVar) {
        this.fIR = aVar;
        this.sFo = t.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        t tVar = (t) bVar;
        if (this.fIR.appId.equals(tVar.bHb.appId)) {
            Map hashMap = new HashMap();
            String str = tVar.bHb.state;
            x.d("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d， audioId:%s, state:%s", new Object[]{Integer.valueOf(tVar.bHb.action), tVar.bHb.bGW, str});
            hashMap.put("state", str);
            hashMap.put("audioId", r4);
            this.fIR.action = tVar.bHb.action;
            if (this.fIR.action == 4) {
                hashMap.put("errMsg", tVar.bHb.Yy);
                hashMap.put("errCode", Integer.valueOf(tVar.bHb.errCode));
            }
            this.fIR.fIt = new JSONObject(hashMap).toString();
            this.fIR.En();
            return true;
        }
        x.i("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", new Object[]{this.fIR.appId, tVar.bHb.appId, Integer.valueOf(tVar.bHb.action)});
        return false;
    }
}
