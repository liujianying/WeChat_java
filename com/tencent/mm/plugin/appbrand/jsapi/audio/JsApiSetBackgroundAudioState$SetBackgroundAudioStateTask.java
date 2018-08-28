package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.an.a.b;
import com.tencent.mm.an.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask extends MainProcessTask {
    public static final Creator<JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask> CREATOR = new 1();
    public String appId;
    private e fFF;
    public l fFa;
    public int fFd;
    public String fHW = "";
    public boolean fHX = false;
    public String fIo;

    public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(a aVar, l lVar, int i) {
        this.fFF = aVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
        try {
            JSONObject jSONObject = new JSONObject(this.fIo);
            String optString = jSONObject.optString("src");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("epname");
            String optString4 = jSONObject.optString("singer");
            String optString5 = jSONObject.optString("coverImgUrl");
            String optString6 = jSONObject.optString("webUrl");
            String optString7 = jSONObject.optString("protocol");
            int optInt = jSONObject.optInt("startTime", 0);
            String optString8 = jSONObject.optString("operationType");
            if (!TextUtils.isEmpty(optString8)) {
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                String str = a.ghW.ghU;
                if (bi.oW(str) || str.equals(this.appId)) {
                    this.fHX = false;
                    if (optString8.equalsIgnoreCase("pause")) {
                        if (c.Qd()) {
                            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
                            return;
                        } else {
                            this.fHX = true;
                            this.fHW = "pause music fail";
                        }
                    } else if (optString8.equalsIgnoreCase("stop")) {
                        if (c.Qe()) {
                            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
                            return;
                        } else {
                            this.fHX = true;
                            this.fHW = "stop music fail";
                        }
                    }
                    ahH();
                    return;
                }
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            } else if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
                this.fHX = true;
                this.fHW = "src is null";
                ahH();
            } else {
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%d", new Object[]{optString, optString2, optString3, optString4, optString5, optString7, optString6, Integer.valueOf(optInt)});
                if (optString5 == null) {
                    optString5 = "";
                }
                String str2 = optString;
                avq a = ((b) g.l(b.class)).a(11, optString5, optString2, optString4, optString6, optString, str2, (this.appId + optString + optString5).hashCode(), com.tencent.mm.compatible.util.e.bnE, com.tencent.mm.plugin.p.c.Gb() + optString5.hashCode(), optString3, "");
                a.dGs = optInt * TbsLog.TBSLOG_CODE_SDK_BASE;
                a.protocol = optString7;
                a.ghW.ghV = a.rsp;
                com.tencent.mm.an.b.b(a);
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.fHX = false;
                ahH();
            }
        } catch (JSONException e) {
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
            this.fHX = true;
            this.fHW = "parser data fail, data is invalid";
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + e.getMessage());
            ahH();
        }
    }

    public final void aaj() {
        if (this.fFa == null) {
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        } else if (this.fHX) {
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[]{this.fHW});
            this.fFa.E(this.fFd, this.fFF.f("fail:" + this.fHW, null));
        } else {
            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
            this.fFa.E(this.fFd, this.fFF.f("ok", null));
        }
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.fIo = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fHX = z;
        this.fHW = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fIo);
        parcel.writeInt(this.fHX ? 1 : 0);
        parcel.writeString(this.fHW);
    }
}
