package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask$2 extends c<jt> {
    final /* synthetic */ SetBackgroundAudioListenerTask fIV;

    JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask$2(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
        this.fIV = setBackgroundAudioListenerTask;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", new Object[]{Integer.valueOf(jtVar.bTE.action)});
        Map hashMap = new HashMap();
        String str = jtVar.bTE.state;
        if (jtVar.bTE.action == 10) {
            if (jtVar.bTE.appId.equals(this.fIV.appId)) {
                x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
                return false;
            }
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", new Object[]{jtVar.bTE.appId, this.fIV.appId});
            hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, str);
            this.fIV.fIt = new JSONObject(hashMap).toString();
            this.fIV.action = jtVar.bTE.action;
            SetBackgroundAudioListenerTask.b(this.fIV);
            return true;
        }
        avq avq = jtVar.bTE.bTy;
        if (avq == null) {
            x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
            return false;
        } else if (jtVar.bTE.bTG) {
            int i;
            if (jtVar.bTE.action == 2 && jtVar.bTE.bTH) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 != 0) {
                x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
                return false;
            }
            if (this.fIV.appId.equals(a.ala().ghU)) {
                hashMap.put("src", avq.rYp);
                hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, str);
                hashMap.put("errCode", Integer.valueOf(jtVar.bTE.errCode));
                Object obj = "";
                if (!TextUtils.isEmpty(jtVar.bTE.Yy)) {
                    obj = jtVar.bTE.Yy;
                }
                hashMap.put("errMsg", obj);
                this.fIV.fIt = new JSONObject(hashMap).toString();
                this.fIV.action = jtVar.bTE.action;
                SetBackgroundAudioListenerTask.c(this.fIV);
                return true;
            }
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", new Object[]{this.fIV.appId, a.ala().ghU});
            return false;
        } else {
            x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
            return false;
        }
    }
}
