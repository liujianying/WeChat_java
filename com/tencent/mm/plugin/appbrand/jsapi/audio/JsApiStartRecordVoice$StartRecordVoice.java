package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiStartRecordVoice$StartRecordVoice extends MainProcessTask {
    public static final Creator<JsApiStartRecordVoice$StartRecordVoice> CREATOR = new 2();
    private String appId;
    private int duration;
    private l fFa;
    private int fFd;
    private JsApiStartRecordVoice fJf;
    private boolean fJg = false;
    private String filePath;
    private int result;

    JsApiStartRecordVoice$StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, l lVar, int i, int i2) {
        this.fJf = jsApiStartRecordVoice;
        this.fFa = lVar;
        this.duration = i;
        this.fFd = i2;
        this.appId = lVar.mAppId;
        this.filePath = AppBrandLocalMediaObjectManager.genMediaFilePath(this.appId, u.ov(this.appId));
    }

    JsApiStartRecordVoice$StartRecordVoice(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        c.Em().H(new 1(this));
    }

    public final void aaj() {
        if (this.result == -1) {
            x.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
            this.fFa.E(this.fFd, this.fJf.f("fail:record_error", null));
            return;
        }
        if (this.fJg) {
            AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.fFa.mAppId, this.filePath, "silk", true);
            if (attach != null) {
                Map hashMap = new HashMap(1);
                hashMap.put("tempFilePath", attach.bNH);
                this.fFa.E(this.fFd, this.fJf.f("ok", hashMap));
                x.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.fJg)});
                JsApiStartRecordVoice.a(this.fJf, false);
            }
        }
        this.fFa.E(this.fFd, this.fJf.f("fail", null));
        x.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.fJg)});
        JsApiStartRecordVoice.a(this.fJf, false);
    }

    public final void g(Parcel parcel) {
        this.fFd = parcel.readInt();
        this.appId = parcel.readString();
        this.filePath = parcel.readString();
        this.fJg = parcel.readByte() != (byte) 0;
        this.duration = parcel.readInt();
        this.result = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fFd);
        parcel.writeString(this.appId);
        parcel.writeString(this.filePath);
        parcel.writeByte(this.fJg ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.result);
    }
}
