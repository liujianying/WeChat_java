package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiGetInstallState$GetInstallStateTask extends MainProcessTask {
    public static final Creator<JsApiGetInstallState$GetInstallStateTask> CREATOR = new 1();
    private e fFu;
    private int fFw;
    private boolean fGN;
    private String fHH;
    private JSONArray fHI;
    private boolean fHJ;
    private l fcy;
    private String mPackageName;
    private String mVersionName;

    public JsApiGetInstallState$GetInstallStateTask(e eVar, l lVar, int i, JSONObject jSONObject) {
        ahA();
        this.fFu = eVar;
        this.fcy = lVar;
        this.fFw = i;
        this.mPackageName = jSONObject.optString("packageName");
        JSONArray optJSONArray = jSONObject.optJSONArray("packageNameArray");
        if (optJSONArray != null) {
            this.fHH = optJSONArray.toString();
        }
        this.fGN = true;
    }

    public JsApiGetInstallState$GetInstallStateTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        if (bi.oW(this.fHH)) {
            PackageInfo packageInfo = p.getPackageInfo(ad.getContext(), this.mPackageName);
            int i = packageInfo == null ? 0 : packageInfo.versionCode;
            String str = packageInfo == null ? "null" : packageInfo.versionName;
            x.i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + packageInfo + ", version = " + i + ", versionName = " + str);
            if (packageInfo == null) {
                this.fHJ = false;
            } else {
                this.mVersionName = str;
                this.fHJ = true;
            }
            this.fGN = false;
        } else {
            try {
                JSONArray jSONArray = new JSONArray(this.fHH);
                this.fHI = new JSONArray();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    PackageInfo packageInfo2 = p.getPackageInfo(ad.getContext(), optString);
                    int i3 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
                    String str2 = packageInfo2 == null ? "null" : packageInfo2.versionName;
                    x.i("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + optString + ", packageInfo = " + packageInfo2 + ", version = " + i3 + ", versionName = " + str2);
                    boolean z = packageInfo2 != null;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("packageName", optString);
                        jSONObject.put("isInstalled", z);
                        if (z) {
                            jSONObject.put("versionCode", i3);
                            jSONObject.put("versionName", str2);
                        }
                        this.fHI.put(jSONObject);
                    } catch (JSONException e) {
                        x.i("MicroMsg.JsApiGetInstallState", e.getMessage());
                    }
                }
                this.fGN = false;
            } catch (JSONException e2) {
                x.e("MicroMsg.JsApiGetInstallState", e2.getMessage());
                this.fGN = true;
            }
        }
        ahH();
    }

    public final void aaj() {
        boolean z = true;
        String str = "MicroMsg.JsApiGetInstallState";
        String str2 = "callback, service is null: %b";
        Object[] objArr = new Object[1];
        if (this.fcy != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        ahB();
        if (this.fGN) {
            this.fcy.E(this.fFw, this.fFu.f("fail", null));
            return;
        }
        Map hashMap = new HashMap();
        if (this.fHI != null) {
            hashMap.put("result", this.fHI);
        } else {
            hashMap.put("versionName", this.mVersionName);
            hashMap.put("isInstalled", Boolean.valueOf(this.fHJ));
        }
        this.fcy.E(this.fFw, this.fFu.f("ok", hashMap));
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.mPackageName = parcel.readString();
        this.fHH = parcel.readString();
        this.fGN = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fHJ = z;
        this.mVersionName = parcel.readString();
        String readString = parcel.readString();
        if (readString != null) {
            try {
                this.fHI = new JSONArray(readString);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiGetInstallState", "parseFromParcel: " + e.getMessage());
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.fHH);
        if (this.fGN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.fHJ) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.mVersionName);
        parcel.writeString(this.fHI != null ? this.fHI.toString() : null);
    }
}
