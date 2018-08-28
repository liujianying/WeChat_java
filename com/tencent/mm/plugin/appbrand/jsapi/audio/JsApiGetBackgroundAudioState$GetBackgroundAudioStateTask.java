package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.an.b;
import com.tencent.mm.an.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask extends MainProcessTask {
    public static final Creator<JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask> CREATOR = new Creator<JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask[i];
        }
    };
    public String appId = "";
    public int bGX;
    public int dGB;
    public String dGC;
    public int dGs;
    public int duration = 0;
    public int eiO;
    private e fFF;
    public l fFa;
    public int fFd;
    public String fHW;
    public boolean fHX = false;
    public String fHY;
    public String fHZ;
    public String fIa;
    public String fIb;
    public String protocol;
    public String title;

    public JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        String str = a.ala().ghU;
        if (bi.oW(str) || str.equals(this.appId)) {
            avq Qa = b.Qa();
            if (Qa != null) {
                int i;
                int i2;
                int i3;
                d Qb = b.Qb();
                if (Qb != null) {
                    i = Qb.mDuration;
                    i2 = Qb.mPosition;
                    i3 = i;
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                if (Qb == null || i3 < 0 || i2 < 0) {
                    x.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                    this.fHX = true;
                    this.fHW = "return parameter is invalid";
                    ahH();
                    return;
                }
                i = i3 / 1000;
                i3 = i2 / 1000;
                int i4 = Qb.mStatus;
                i2 = Qb.ebg;
                if (i > 0) {
                    i2 = (i2 * i) / 100;
                } else {
                    i2 = 0;
                }
                this.duration = i;
                this.bGX = i3;
                this.eiO = i4 == 1 ? 0 : 1;
                this.dGC = Qa.rYp;
                this.dGB = i2;
                this.title = Qa.rYl;
                this.fHY = Qa.rYn;
                this.fHZ = Qa.rYm;
                this.fIa = Qa.rYo;
                this.fIb = Qa.rYr;
                this.protocol = Qa.protocol;
                this.dGs = Qa.dGs;
                x.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s", new Object[]{Integer.valueOf(this.duration), Integer.valueOf(this.bGX), Integer.valueOf(this.eiO), Integer.valueOf(this.dGB), this.dGC, Integer.valueOf(this.dGs), this.title, this.fHZ, this.fIb, this.fIa, this.protocol});
            } else {
                x.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
                this.fHX = true;
                this.fHW = "currentWrapper is null";
            }
            ahH();
            return;
        }
        x.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[]{str, this.appId});
        this.fHX = true;
        this.fHW = "appid not match cannot get background audio state";
        ahH();
    }

    public final void aaj() {
        if (this.fFa == null) {
            x.e("MicroMsg.JsApiGetBackgroundAudioState", "service is null");
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("duration", Integer.valueOf(this.duration));
        hashMap.put("currentTime", Integer.valueOf(this.bGX));
        hashMap.put("paused", Boolean.valueOf(this.eiO == 1));
        hashMap.put("buffered", Integer.valueOf(this.dGB));
        hashMap.put("src", this.dGC);
        hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.title);
        hashMap.put("epname", this.fHY);
        hashMap.put("singer", this.fHZ);
        hashMap.put("coverImgUrl", this.fIa);
        hashMap.put("webUrl", this.fIb);
        hashMap.put("protocol", this.protocol == null ? "" : this.protocol);
        hashMap.put("startTime", Integer.valueOf(this.dGs / 1000));
        String str = TextUtils.isEmpty(this.fHW) ? "" : this.fHW;
        if (this.fHX) {
            x.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[]{str});
        } else {
            x.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
        }
        l lVar = this.fFa;
        int i = this.fFd;
        e eVar = this.fFF;
        if (this.fHX) {
            str = "fail:" + str;
        } else {
            str = "ok";
        }
        lVar.E(i, eVar.f(str, hashMap));
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.duration = parcel.readInt();
        this.bGX = parcel.readInt();
        this.eiO = parcel.readInt();
        this.dGB = parcel.readInt();
        this.dGC = parcel.readString();
        this.title = parcel.readString();
        this.fHY = parcel.readString();
        this.fHZ = parcel.readString();
        this.fIa = parcel.readString();
        this.fIb = parcel.readString();
        this.protocol = parcel.readString();
        this.dGs = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.bGX);
        parcel.writeInt(this.eiO);
        parcel.writeInt(this.dGB);
        parcel.writeString(this.dGC);
        parcel.writeString(this.title);
        parcel.writeString(this.fHY);
        parcel.writeString(this.fHZ);
        parcel.writeString(this.fIa);
        parcel.writeString(this.fIb);
        parcel.writeString(this.protocol);
        parcel.writeInt(this.dGs);
    }
}
