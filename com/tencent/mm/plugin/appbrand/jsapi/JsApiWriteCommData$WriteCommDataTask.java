package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiWriteCommData$WriteCommDataTask extends MainProcessTask {
    public static final Creator<JsApiWriteCommData$WriteCommDataTask> CREATOR = new 1();
    private e fFu;
    private int fFw;
    private boolean fGN;
    private String fGO;
    private l fcy;
    private String mData;
    private String mPackageName;

    public JsApiWriteCommData$WriteCommDataTask(e eVar, l lVar, int i, JSONObject jSONObject) {
        this.fFu = eVar;
        this.fcy = lVar;
        this.fFw = i;
        this.mPackageName = jSONObject.optString("packageName");
        this.mData = jSONObject.optString("data");
        this.fGN = true;
    }

    public JsApiWriteCommData$WriteCommDataTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        boolean z = false;
        if (bi.oW(this.mPackageName)) {
            x.e("MicroMsg.JsApiWriteCommData", "packageName nil");
        } else {
            if (!ad.getContext().getSharedPreferences(ad.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
                z = true;
            }
            this.fGN = z;
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
        this.mPackageName = parcel.readString();
        this.mData = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fGN = z;
        this.fGO = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mData);
        parcel.writeInt(this.fGN ? 1 : 0);
        parcel.writeString(this.fGO);
    }
}
