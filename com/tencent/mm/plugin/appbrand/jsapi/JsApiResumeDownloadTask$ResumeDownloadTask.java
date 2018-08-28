package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiResumeDownloadTask$ResumeDownloadTask extends MainProcessTask {
    public static final Creator<JsApiResumeDownloadTask$ResumeDownloadTask> CREATOR = new 1();
    private e fFu;
    private int fFw;
    private long fGL;
    private boolean fGM;
    private boolean fGN;
    private String fGO;
    private l fcy;

    public JsApiResumeDownloadTask$ResumeDownloadTask(e eVar, l lVar, int i, JSONObject jSONObject) {
        this.fFu = eVar;
        this.fcy = lVar;
        this.fFw = i;
        this.fGL = jSONObject.optLong("downloadId");
        this.fGM = jSONObject.optBoolean("downloadInWifi", false);
        this.fGN = true;
    }

    public JsApiResumeDownloadTask$ResumeDownloadTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        boolean z = true;
        x.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.fGL));
        if (this.fGL <= 0) {
            this.fGO = "downloadId invalid";
        } else {
            a cs = c.cs(this.fGL);
            if (!(cs == null || cs.field_downloadInWifi == this.fGM)) {
                cs.field_downloadInWifi = this.fGM;
                c.e(cs);
            }
            if (d.aCU().co(this.fGL)) {
                z = false;
            }
            this.fGN = z;
        }
        ahH();
    }

    public final void aaj() {
        if (this.fGN) {
            String str;
            if (bi.oW(this.fGO)) {
                str = "fail";
            } else {
                str = String.format("fail:%s", new Object[]{this.fGO});
            }
            this.fcy.E(this.fFw, this.fFu.f(str, null));
            return;
        }
        this.fcy.E(this.fFw, this.fFu.f("ok", null));
    }

    public final void g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.fGL = parcel.readLong();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.fGM = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.fGN = z2;
        this.fGO = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2 = 1;
        parcel.writeLong(this.fGL);
        if (this.fGM) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.fGN) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.fGO);
    }
}
