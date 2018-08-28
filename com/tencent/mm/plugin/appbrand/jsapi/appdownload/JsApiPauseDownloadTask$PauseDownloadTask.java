package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiPauseDownloadTask$PauseDownloadTask extends MainProcessTask {
    public static final Creator<JsApiPauseDownloadTask$PauseDownloadTask> CREATOR = new 1();
    private e fFu;
    private int fFw;
    private long fGL;
    private boolean fGN;
    private String fGO;
    private l fcy;

    public JsApiPauseDownloadTask$PauseDownloadTask(e eVar, l lVar, int i, JSONObject jSONObject) {
        this.fFu = eVar;
        this.fcy = lVar;
        this.fFw = i;
        this.fGL = jSONObject.optLong("downloadId");
        this.fGN = true;
    }

    public JsApiPauseDownloadTask$PauseDownloadTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        boolean z = true;
        x.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", new Object[]{Long.valueOf(this.fGL)});
        if (this.fGL <= 0) {
            this.fGO = "downloadId invalid";
        } else {
            a cs = c.cs(this.fGL);
            if (cs == null) {
                this.fGO = "downloadId invalid";
            } else {
                if (cs.field_downloadInWifi) {
                    cs.field_downloadInWifi = false;
                    c.e(cs);
                }
                if (d.aCU().cn(this.fGL)) {
                    z = false;
                }
                this.fGN = z;
            }
        }
        e();
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
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fGN = z;
        this.fGO = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.fGL);
        parcel.writeInt(this.fGN ? 1 : 0);
        parcel.writeString(this.fGO);
    }
}
