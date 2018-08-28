package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import org.json.JSONObject;

public final class j extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 292;
    public static final String NAME = "setAudioState";
    private a fIg;

    public static class a extends a {
        public int action;
        public String appId = "";
        private e fFF;
        public l fFa;
        public int fFd;
        private c fIQ = new 1(this);
        public String fIt;

        public a(e eVar, l lVar, int i) {
            this.fFF = eVar;
            this.fFa = lVar;
            this.fFd = i;
        }

        public final void ahW() {
            x.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
            com.tencent.mm.plugin.appbrand.media.a.a.us(this.appId);
            com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.fIQ);
        }

        public final void En() {
            if (this.fFa == null) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                return;
            }
            x.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", new Object[]{Integer.valueOf(this.action), this.fIt});
            if (bi.oW(this.fIt)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
                return;
            }
            h a = new b().a(this.fFa);
            a.mData = this.fIt;
            a.ahM();
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        if (!d.fHU) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
            lVar.E(i, f("fail:App is paused or background", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
            lVar.E(i, f("fail:data is null", null));
        } else {
            x.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[]{jSONObject.toString()});
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("startTime", 0);
            String optString2 = jSONObject.optString("src");
            if (bi.oW(optString2)) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
                optString2 = "";
            } else if (!optString2.startsWith("wxfile://")) {
                x.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[]{optString2});
            } else if (lVar.fdO == null) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime() is null");
                optString2 = "";
            } else if (lVar.fdO.fcw == null) {
                x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
                optString2 = "";
            } else {
                File rb = lVar.fdO.fcw.rb(optString2);
                if (rb == null || !rb.exists()) {
                    x.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
                    optString2 = "";
                } else {
                    optString2 = rb.getAbsolutePath();
                    if (!(optString2 == null || optString2.startsWith("wxfile://"))) {
                        optString2 = "wxfile://" + optString2;
                    }
                    x.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", new Object[]{optString2});
                }
            }
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
                lVar.E(i, f("fail:audioId is empty", null));
            } else if (TextUtils.isEmpty(optString2)) {
                x.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
                lVar.E(i, f("fail:src is empty", null));
            } else {
                String str;
                if (this.fIg == null) {
                    this.fIg = new a(this, lVar, i);
                }
                this.fIg.appId = lVar.mAppId;
                this.fIg.ahT();
                c cVar = new c(this, lVar, i);
                cVar.appId = lVar.mAppId;
                cVar.bGW = optString;
                cVar.dGC = optString2;
                cVar.dGs = optInt;
                cVar.dGu = optBoolean;
                cVar.dGv = optBoolean2;
                if (lVar.fdO == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime() is null");
                    str = "";
                } else if (lVar.fdO.fcu == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig() is null");
                    str = "";
                } else if (lVar.fdO.fcu.frm == null) {
                    x.e("MicroMsg.WxaAudioUtils", "service.getRuntime().getSysConfig().appPkgInfo is null");
                    str = "";
                } else {
                    x.d("MicroMsg.WxaAudioUtils", "getPkgPath:%s", new Object[]{lVar.fdO.fcu.frm.ffK});
                    str = lVar.fdO.fcu.frm.ffK;
                }
                cVar.ffK = str;
                cVar.dGx = optDouble;
                cVar.processName = ad.getProcessName();
                cVar.ahT();
                com.tencent.mm.plugin.appbrand.media.a.c cVar2 = new com.tencent.mm.plugin.appbrand.media.a.c();
                cVar2.ffK = cVar.ffK;
                cVar2.fIi = jSONObject.toString();
                cVar2.dGC = optString2;
                com.tencent.mm.plugin.appbrand.media.a.a.a(optString, cVar2);
            }
        }
    }
}
