package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.an.b;
import com.tencent.mm.an.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiOperateBackgroundAudio$OperateBackgroundAudioTask extends MainProcessTask {
    public static final Creator<JsApiOperateBackgroundAudio$OperateBackgroundAudioTask> CREATOR = new 1();
    public String appId;
    private e fFF;
    public l fFa;
    public int fFd;
    public String fHW = "";
    public boolean fHX = false;
    public String fIo;

    public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(a aVar, l lVar, int i) {
        this.fFF = aVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
        String str = com.tencent.mm.plugin.appbrand.media.music.a.a.ala().ghU;
        if (bi.oW(str) || str.equals(this.appId)) {
            try {
                JSONObject jSONObject = new JSONObject(this.fIo);
                String optString = jSONObject.optString("operationType");
                int optInt = jSONObject.optInt("currentTime", -1);
                if (TextUtils.isEmpty(optString)) {
                    x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
                    this.fHX = true;
                    this.fHW = "operationType is null";
                    e();
                    return;
                }
                x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%d", new Object[]{optString, Integer.valueOf(optInt)});
                this.fHX = false;
                if (optString.equalsIgnoreCase("play")) {
                    avq Qa = b.Qa();
                    if (Qa != null) {
                        com.tencent.mm.plugin.appbrand.media.music.a.a.ala().ghV = Qa.rsp;
                    }
                    if (c.Qc()) {
                        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
                    } else if (b.PY()) {
                        this.fHX = true;
                        this.fHW = "music is playing, don't play again";
                    } else {
                        this.fHX = true;
                        this.fHW = "play music fail";
                    }
                } else if (optString.equalsIgnoreCase("pause")) {
                    if (c.Qd()) {
                        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
                    } else {
                        this.fHX = true;
                        this.fHW = "pause music fail";
                    }
                } else if (optString.equalsIgnoreCase("seek")) {
                    if (optInt < 0) {
                        x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
                        this.fHX = true;
                        this.fHW = "currentTime is invalid";
                    } else if (b.if(optInt * BaseReportManager.MAX_READ_COUNT)) {
                        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
                    } else {
                        this.fHX = true;
                        this.fHW = "seek music fail";
                    }
                } else if (!optString.equalsIgnoreCase("stop")) {
                    x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
                    this.fHX = true;
                    this.fHW = "operationType is invalid";
                } else if (c.Qe()) {
                    x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
                } else {
                    this.fHX = true;
                    this.fHW = "stop music fail";
                }
                if (this.fHX) {
                    x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.fHW);
                }
                e();
                return;
            } catch (JSONException e) {
                x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[]{this.fIo});
                this.fHX = true;
                this.fHW = "parser data fail, data is invalid";
                x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + e.getMessage());
                e();
                return;
            }
        }
        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str, this.appId});
        this.fHX = true;
        this.fHW = "appid not match cannot operate";
        e();
    }

    public final void aaj() {
        if (this.fFa == null) {
            x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        } else if (this.fHX) {
            x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[]{this.fHW});
            this.fFa.E(this.fFd, this.fFF.f("fail:" + this.fHW, null));
        } else {
            x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
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
