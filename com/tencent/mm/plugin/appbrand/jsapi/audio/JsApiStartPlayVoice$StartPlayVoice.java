package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

class JsApiStartPlayVoice$StartPlayVoice extends MainProcessTask {
    public static final Creator<JsApiStartPlayVoice$StartPlayVoice> CREATOR = new 2();
    public String bNH;
    private e fFF;
    private l fFa;
    private int fFd;
    public boolean fHX = false;
    public String filePath;

    public JsApiStartPlayVoice$StartPlayVoice(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiStartPlayVoice$StartPlayVoice(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        ah.A(new Runnable() {
            public final void run() {
                ((d) g.l(d.class)).a(JsApiStartPlayVoice$StartPlayVoice.this.filePath, new 1(this), new 2(this));
            }
        });
    }

    public final void aaj() {
        Map hashMap = new HashMap();
        hashMap.put("localId", this.bNH);
        this.fFa.E(this.fFd, this.fFF.f(this.fHX ? "fail" : "ok", hashMap));
        JsApiStartPlayVoice.fIW = null;
    }

    public final void g(Parcel parcel) {
        this.bNH = parcel.readString();
        this.filePath = parcel.readString();
        this.fHX = parcel.readByte() != (byte) 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bNH);
        parcel.writeString(this.filePath);
        parcel.writeByte(this.fHX ? (byte) 1 : (byte) 0);
    }
}
