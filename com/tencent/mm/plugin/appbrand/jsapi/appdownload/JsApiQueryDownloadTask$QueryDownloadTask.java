package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiQueryDownloadTask$QueryDownloadTask extends MainProcessTask {
    public static final Creator<JsApiQueryDownloadTask$QueryDownloadTask> CREATOR = new 1();
    private e fFu;
    private int fFw;
    private long fGL;
    private boolean fGN;
    private String fGO;
    private JSONArray fHK;
    private JSONArray fHL;
    private JSONArray fHM;
    private String fHN;
    private long fHO;
    private l fcy;

    public JsApiQueryDownloadTask$QueryDownloadTask(e eVar, l lVar, int i, JSONObject jSONObject) {
        ahA();
        this.fFu = eVar;
        this.fcy = lVar;
        this.fFw = i;
        this.fGL = jSONObject.optLong("downloadId");
        this.fHK = jSONObject.optJSONArray("downloadIdArray");
        this.fHL = jSONObject.optJSONArray("appIdArray");
        this.fGN = true;
    }

    public JsApiQueryDownloadTask$QueryDownloadTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[]{Long.valueOf(this.fGL)});
        int i;
        if (this.fHK != null && this.fHK.length() > 0) {
            this.fHM = new JSONArray();
            for (i = 0; i < this.fHK.length(); i++) {
                long optLong = this.fHK.optLong(i);
                this.fHM.put(a(optLong, d.aCU().cm(optLong)));
            }
            this.fGN = false;
        } else if (this.fHL != null && this.fHL.length() > 0) {
            this.fHM = new JSONArray();
            for (i = 0; i < this.fHL.length(); i++) {
                String optString = this.fHL.optString(i);
                this.fHM.put(a(optString, d.aCU().yO(optString)));
            }
            this.fGN = false;
        } else if (this.fGL <= 0) {
            this.fGO = "downloadId invalid";
        } else {
            FileDownloadTaskInfo cm = d.aCU().cm(this.fGL);
            if (!(!cm.ics || cm.status == 1 || cm.status == 3)) {
                this.fHN = "download_wait_wifi";
            }
            switch (cm.status) {
                case -1:
                    this.fGO = "fail_apilevel_too_low";
                    break;
                case 1:
                    this.fHN = "downloading";
                    break;
                case 2:
                    this.fHN = "download_pause";
                    break;
                case 3:
                    if (!com.tencent.mm.a.e.cn(cm.path)) {
                        this.fHN = "default";
                        break;
                    } else {
                        this.fHN = "download_succ";
                        break;
                    }
                case 4:
                    this.fHN = "download_fail";
                    break;
                default:
                    this.fHN = "default";
                    break;
            }
            x.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[]{this.fHN});
            if ((this.fHN == "downloading" || this.fHN == "download_pause") && cm.gTK != 0) {
                this.fHO = (long) ((((float) cm.icq) / ((float) cm.gTK)) * 100.0f);
            }
            if (!(!cm.ics || ao.isWifi(ad.getContext()) || cm.status == 3 || cm.status == 1)) {
                this.fHN = "download_wait_wifi";
            }
            this.fGN = false;
        }
        ahH();
    }

    private JSONObject a(long j, FileDownloadTaskInfo fileDownloadTaskInfo) {
        JSONObject a = a(fileDownloadTaskInfo);
        if (fileDownloadTaskInfo != null) {
            try {
                a.put("downloadId", j);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
        }
        return a;
    }

    private JSONObject a(String str, FileDownloadTaskInfo fileDownloadTaskInfo) {
        JSONObject a = a(fileDownloadTaskInfo);
        if (fileDownloadTaskInfo != null) {
            try {
                a.put("appId", str);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
        }
        return a;
    }

    private JSONObject a(FileDownloadTaskInfo fileDownloadTaskInfo) {
        String str;
        long j = 0;
        JSONObject jSONObject = new JSONObject();
        switch (fileDownloadTaskInfo.status) {
            case -1:
                this.fGO = "fail_apilevel_too_low";
                return jSONObject;
            case 1:
                str = "downloading";
                break;
            case 2:
                str = "download_pause";
                break;
            case 3:
                if (!com.tencent.mm.a.e.cn(fileDownloadTaskInfo.path)) {
                    str = "default";
                    break;
                }
                str = "download_succ";
                break;
            case 4:
                str = "download_fail";
                break;
            default:
                str = "default";
                break;
        }
        x.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[]{str});
        if (!(!fileDownloadTaskInfo.ics || ao.isWifi(ad.getContext()) || fileDownloadTaskInfo.status == 3 || fileDownloadTaskInfo.status == 1)) {
            str = "download_wait_wifi";
        }
        if ((str == "downloading" || str == "download_pause") && fileDownloadTaskInfo.gTK != 0) {
            j = (long) ((((float) fileDownloadTaskInfo.icq) / ((float) fileDownloadTaskInfo.gTK)) * 100.0f);
        }
        try {
            jSONObject.put("appId", fileDownloadTaskInfo.appId);
            jSONObject.put("downloadId", fileDownloadTaskInfo.id);
            jSONObject.put("state", str);
            jSONObject.put("progress", j);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
        }
        return jSONObject;
    }

    public final void aaj() {
        ahB();
        String str = "MicroMsg.JsApiQueryDownloadTask";
        String str2 = "callback, service is null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.fcy == null);
        x.d(str, str2, objArr);
        if (this.fGN) {
            this.fcy.E(this.fFw, this.fFu.f(bi.oW(this.fGO) ? "fail" : String.format("fail:%s", new Object[]{this.fGO}), null));
            return;
        }
        Map hashMap = new HashMap();
        if (this.fHM != null) {
            hashMap.put("result", this.fHM);
        } else {
            hashMap.put("downloadId", Long.valueOf(this.fGL));
            hashMap.put("state", this.fHN);
            hashMap.put("progress", Long.valueOf(this.fHO));
        }
        this.fcy.E(this.fFw, this.fFu.f("ok", hashMap));
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.fGL = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fGN = z;
        this.fGO = parcel.readString();
        this.fHN = parcel.readString();
        this.fHO = parcel.readLong();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        if (readString != null) {
            try {
                this.fHK = new JSONArray(readString);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", e, "", new Object[0]);
                return;
            }
        }
        if (readString2 != null) {
            this.fHL = new JSONArray(readString2);
        }
        if (readString3 != null) {
            this.fHM = new JSONArray(readString3);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        String jSONArray;
        String str = null;
        parcel.writeLong(this.fGL);
        parcel.writeInt(this.fGN ? 1 : 0);
        parcel.writeString(this.fGO);
        parcel.writeString(this.fHN);
        parcel.writeLong(this.fHO);
        if (this.fHK != null) {
            jSONArray = this.fHK.toString();
        } else {
            jSONArray = null;
        }
        parcel.writeString(jSONArray);
        if (this.fHL != null) {
            jSONArray = this.fHL.toString();
        } else {
            jSONArray = null;
        }
        parcel.writeString(jSONArray);
        if (this.fHM != null) {
            str = this.fHM.toString();
        }
        parcel.writeString(str);
    }
}
