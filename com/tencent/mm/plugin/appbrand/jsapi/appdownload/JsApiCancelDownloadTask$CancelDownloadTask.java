package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;

class JsApiCancelDownloadTask$CancelDownloadTask extends MainProcessTask {
    public static Creator<JsApiCancelDownloadTask$CancelDownloadTask> CREATOR = new 1();
    private l fFa;
    private int fFd;
    private JSONArray fHF;
    private a fHG;

    /* synthetic */ JsApiCancelDownloadTask$CancelDownloadTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        if (this.fHF != null && this.fHF.length() > 0) {
            for (int i = 0; i < this.fHF.length(); i++) {
                long optLong = this.fHF.optLong(i);
                com.tencent.mm.plugin.downloader.c.a cs = c.cs(optLong);
                if (cs == null || cs.field_status != 3) {
                    d.aCU().cl(optLong);
                } else {
                    e.deleteFile(cs.field_filePath);
                    c.yL(cs.field_downloadUrl);
                }
            }
        }
        ahH();
    }

    public final void aaj() {
        ahB();
        this.fFa.E(this.fFd, this.fHG.f("ok", null));
    }

    public JsApiCancelDownloadTask$CancelDownloadTask(JSONArray jSONArray, a aVar, l lVar, int i) {
        ahA();
        this.fHF = jSONArray;
        this.fHG = aVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    private JsApiCancelDownloadTask$CancelDownloadTask(Parcel parcel) {
        g(parcel);
    }

    public final void g(Parcel parcel) {
        String readString = parcel.readString();
        if (readString != null) {
            try {
                this.fHF = new JSONArray(readString);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiCancelDownloadTask", "parseFromParcel: " + e.getMessage());
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fHF != null ? this.fHF.toString() : null);
    }
}
