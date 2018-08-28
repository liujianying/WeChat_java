package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$OperateMusicPlayer$6 extends c<jt> {
    final /* synthetic */ OperateMusicPlayer fIB;

    JsApiOperateMusicPlayer$OperateMusicPlayer$6(OperateMusicPlayer operateMusicPlayer) {
        this.fIB = operateMusicPlayer;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        x.i("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", new Object[]{Integer.valueOf(jtVar.bTE.action)});
        avq avq = jtVar.bTE.bTy;
        if (avq != null) {
            String str = avq.rYp;
            Map hashMap = new HashMap();
            hashMap.put("dataUrl", str);
            this.fIB.fIt = new JSONObject(hashMap).toString();
            this.fIB.action = jtVar.bTE.action;
            OperateMusicPlayer.h(this.fIB);
        }
        return false;
    }
}
