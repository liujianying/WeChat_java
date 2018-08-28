package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask extends MainProcessTask {
    public static final Creator<JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask> CREATOR = new 1();
    private e fFu;
    private int fFw;
    private long fGL;
    private boolean fGN;
    private String fGO;
    private String fHA;
    private String fHB;
    private String fHE;
    private String fHw;
    private String fHx;
    private String fHy;
    private long fHz;
    private l fcy;
    private String mAppId;
    private String mPackageName;

    public JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask(e eVar, l lVar, int i, JSONObject jSONObject) {
        this.fFu = eVar;
        this.fcy = lVar;
        this.fFw = i;
        this.fHw = jSONObject.optString("taskName");
        this.fHx = jSONObject.optString("taskUrl");
        this.fHy = jSONObject.optString("fileMd5");
        this.fHE = jSONObject.optString("alternativeUrl");
        this.fHz = (long) jSONObject.optInt("taskSize", 0);
        this.fHA = jSONObject.optString("extInfo");
        this.fHB = jSONObject.optString("fileType");
        this.mAppId = lVar.mAppId;
        this.mPackageName = jSONObject.optString("packageName");
        this.fGN = true;
    }

    public JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        g.Ek();
        if (!g.Ei().isSDCardAvailable()) {
            this.fGO = "fail_sdcard_not_ready";
        } else if (this.fHz > 0 && !f.aM(this.fHz)) {
            this.fGO = "fail_sdcard_has_not_enough_space";
        } else if (bi.oW(this.fHx)) {
            this.fGO = "fail_invalid_url";
        } else {
            x.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", this.fHx, this.fHy);
            a aVar = new a();
            aVar.yQ(this.fHx);
            aVar.yR(this.fHE);
            aVar.cx(this.fHz);
            aVar.yS(this.fHw);
            aVar.yT(this.fHy);
            aVar.setAppId(this.mAppId);
            aVar.cQ(this.mPackageName);
            aVar.ef(true);
            aVar.ox(bi.getInt(this.fHB, 1));
            aVar.setScene(6001);
            aVar.yU(this.fHA);
            long a = d.aCU().a(aVar.ick);
            x.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = " + a);
            if (a <= 0) {
                x.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = " + a);
                this.fGO = "";
            } else {
                this.fGN = false;
                this.fGL = a;
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
        Map hashMap = new HashMap();
        hashMap.put("downloadId", Long.valueOf(this.fGL));
        this.fcy.E(this.fFw, this.fFu.f("ok", hashMap));
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.fHw = parcel.readString();
        this.fHx = parcel.readString();
        this.fHy = parcel.readString();
        this.fHE = parcel.readString();
        this.fHz = parcel.readLong();
        this.fHA = parcel.readString();
        this.fHB = parcel.readString();
        this.mAppId = parcel.readString();
        this.mPackageName = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fGN = z;
        this.fGO = parcel.readString();
        this.fGL = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fHw);
        parcel.writeString(this.fHx);
        parcel.writeString(this.fHy);
        parcel.writeString(this.fHE);
        parcel.writeLong(this.fHz);
        parcel.writeString(this.fHA);
        parcel.writeString(this.fHB);
        parcel.writeString(this.mAppId);
        parcel.writeString(this.mPackageName);
        parcel.writeInt(this.fGN ? 1 : 0);
        parcel.writeString(this.fGO);
        parcel.writeLong(this.fGL);
    }
}
