package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiInstallDownloadTask$InstallDownloadTask extends MainProcessTask {
    public static final Creator<JsApiInstallDownloadTask$InstallDownloadTask> CREATOR = new 1();
    private e fFu;
    private int fFw;
    private long fGL;
    private boolean fGN;
    private String fGO;
    private l fcy;
    private String mAppId;

    public JsApiInstallDownloadTask$InstallDownloadTask(e eVar, l lVar, int i, JSONObject jSONObject) {
        this.fFu = eVar;
        this.fcy = lVar;
        this.fFw = i;
        this.fGL = jSONObject.optLong("downloadId");
        this.mAppId = jSONObject.optString("appId");
        this.fGN = true;
    }

    public JsApiInstallDownloadTask$InstallDownloadTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        boolean z = true;
        x.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[]{Long.valueOf(this.fGL)});
        a cs;
        if (bi.oW(this.mAppId)) {
            cs = c.cs(this.fGL);
            if (cs != null && cs.field_status == 3 && com.tencent.mm.a.e.cn(cs.field_filePath)) {
                if (com.tencent.mm.plugin.downloader.e.a.yW(cs.field_filePath)) {
                    z = false;
                }
                this.fGN = z;
                if (!this.fGN) {
                    com.tencent.mm.plugin.downloader.e.a.a(this.mAppId, cs.field_scene, cs.field_downloadId, cs.field_channelId);
                }
            }
        } else {
            cs = c.yK(this.mAppId);
            if (cs != null && cs.field_status == 3 && com.tencent.mm.a.e.cn(cs.field_filePath)) {
                if (com.tencent.mm.plugin.downloader.e.a.yW(cs.field_filePath)) {
                    z = false;
                }
                this.fGN = z;
                if (!this.fGN) {
                    com.tencent.mm.plugin.downloader.e.a.a(this.mAppId, cs.field_scene, cs.field_downloadId, cs.field_channelId);
                }
            }
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
        boolean z = true;
        this.fGL = parcel.readLong();
        this.mAppId = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fGN = z;
        this.fGO = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.fGL);
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.fGN ? 1 : 0);
        parcel.writeString(this.fGO);
    }
}
