package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTask extends a {
    public static final int CTRL_INDEX = 474;
    public static final String NAME = "addDownloadTask";

    private static class AddDownloadTask extends MainProcessTask {
        public static final Creator<AddDownloadTask> CREATOR = new 1();
        private e fFu;
        private int fFw;
        private long fGL;
        private boolean fGM;
        private boolean fGN;
        private String fGO;
        private String fHA;
        private String fHB;
        private boolean fHC;
        private int fHD;
        private String fHw;
        private String fHx;
        private String fHy;
        private long fHz;
        private l fcy;
        private String mAppId;
        private String mPackageName;

        public AddDownloadTask(e eVar, l lVar, int i, JSONObject jSONObject) {
            ahA();
            this.fFu = eVar;
            this.fcy = lVar;
            this.fFw = i;
            this.fHw = jSONObject.optString("taskName");
            this.fHx = jSONObject.optString("taskUrl");
            this.fHy = jSONObject.optString("fileMd5");
            this.fHz = (long) jSONObject.optInt("taskSize", 0);
            this.fHA = jSONObject.optString("extInfo");
            this.fHB = jSONObject.optString("fileType");
            this.mAppId = jSONObject.optString("appId");
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.fGM = jSONObject.optBoolean("downloadInWifi", false);
            this.fHC = jSONObject.optBoolean("showNotification", false);
            this.fHD = jSONObject.optInt("downloaderType", 0);
            this.fGN = true;
        }

        public AddDownloadTask(Parcel parcel) {
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
                x.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", new Object[]{this.fHx, this.fHy});
                com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                aVar.yQ(this.fHx);
                aVar.cx(this.fHz);
                aVar.yS(this.fHw);
                aVar.yT(this.fHy);
                aVar.setAppId(this.mAppId);
                aVar.cQ(this.mPackageName);
                aVar.ef(true);
                aVar.ox(bi.getInt(this.fHB, 1));
                aVar.setScene(6001);
                aVar.yU(this.fHA);
                aVar.eg(this.fHC);
                aVar.ick.fGM = this.fGM;
                aVar.ef(false);
                aVar.ick.icj = true;
                com.tencent.mm.plugin.downloader.model.e eVar = aVar.ick;
                long b = this.fHD == 1 ? d.aCU().b(eVar) : d.aCU().a(eVar);
                x.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = " + b);
                if (b <= 0) {
                    x.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = " + b);
                    this.fGO = "";
                } else {
                    this.fGN = false;
                    this.fGL = b;
                    if (this.fGM) {
                        gt gtVar = new gt();
                        gtVar.bPU.opType = 10;
                        gtVar.bPU.bGm = b;
                        com.tencent.mm.sdk.b.a.sFg.m(gtVar);
                    }
                }
            }
            ahH();
        }

        public final void aaj() {
            ahB();
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
            boolean z;
            boolean z2 = true;
            this.fHw = parcel.readString();
            this.fHx = parcel.readString();
            this.fHy = parcel.readString();
            this.fHz = parcel.readLong();
            this.fHA = parcel.readString();
            this.fHB = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            this.fGM = parcel.readByte() == (byte) 1;
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            this.fHC = z;
            this.fHD = parcel.readInt();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.fGN = z2;
            this.fGO = parcel.readString();
            this.fGL = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            int i2 = 1;
            parcel.writeString(this.fHw);
            parcel.writeString(this.fHx);
            parcel.writeString(this.fHy);
            parcel.writeLong(this.fHz);
            parcel.writeString(this.fHA);
            parcel.writeString(this.fHB);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeByte(this.fGM ? (byte) 1 : (byte) 0);
            if (this.fHC) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeInt(this.fHD);
            if (!this.fGN) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.fGO);
            parcel.writeLong(this.fGL);
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new AddDownloadTask(this, lVar, i, jSONObject));
        b.f(lVar);
    }
}
