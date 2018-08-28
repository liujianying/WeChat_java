package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.an.b;
import com.tencent.mm.an.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashMap;
import java.util.Map;

class JsApiGetMusicPlayerState$GetMusicPlayerState extends MainProcessTask {
    public static final Creator<JsApiGetMusicPlayerState$GetMusicPlayerState> CREATOR = new 1();
    private e fFF;
    private l fFa;
    private int fFd;
    public String fHW;
    public boolean fHX = false;
    public String fId;
    public int fIe;
    public String fIf;
    public int mDuration;
    public int mPosition;
    public int mStatus;

    public JsApiGetMusicPlayerState$GetMusicPlayerState(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiGetMusicPlayerState$GetMusicPlayerState(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        String str = a.ghW.ghU;
        if (bi.oW(str) || str.equals(this.fId)) {
            avq Qa = b.Qa();
            if (Qa != null) {
                int i;
                int i2;
                d Qb = b.Qb();
                if (Qb != null) {
                    int i3 = Qb.mDuration;
                    i = Qb.mPosition;
                    this.mStatus = Qb.mStatus;
                    this.fIe = Qb.ebg;
                    i2 = i3;
                } else {
                    i = -1;
                    i2 = -1;
                }
                this.mDuration = i2 / TbsLog.TBSLOG_CODE_SDK_BASE;
                this.mPosition = i / TbsLog.TBSLOG_CODE_SDK_BASE;
                this.fIf = Qa.rYp;
                this.fHW = "";
                this.fHX = false;
            } else {
                this.mStatus = 2;
                this.fHW = "";
                this.fHX = false;
            }
            x.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[]{Integer.valueOf(this.mDuration), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.fIe), this.fIf});
            ahH();
            return;
        }
        x.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
        this.fHX = true;
        this.fHW = "appid not match cannot operate";
        ahH();
    }

    public final void aaj() {
        String str;
        Map hashMap = new HashMap();
        hashMap.put("duration", Integer.valueOf(this.mDuration));
        hashMap.put("currentPosition", Integer.valueOf(this.mPosition));
        hashMap.put("status", Integer.valueOf(this.mStatus));
        hashMap.put("downloadPercent", Integer.valueOf(this.fIe));
        hashMap.put("dataUrl", this.fIf);
        l lVar = this.fFa;
        int i = this.fFd;
        e eVar = this.fFF;
        if (this.fHX) {
            str = "fail" + (TextUtils.isEmpty(this.fHW) ? "" : ":" + this.fHW);
        } else {
            str = "ok";
        }
        lVar.E(i, eVar.f(str, hashMap));
    }

    public final void g(Parcel parcel) {
        this.fId = parcel.readString();
        this.fHX = parcel.readByte() != (byte) 0;
        this.mDuration = parcel.readInt();
        this.mPosition = parcel.readInt();
        this.mStatus = parcel.readInt();
        this.fIe = parcel.readInt();
        this.fIf = parcel.readString();
        this.fHW = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fId);
        parcel.writeByte(this.fHX ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.fIe);
        parcel.writeString(this.fIf);
        parcel.writeString(this.fHW);
    }
}
