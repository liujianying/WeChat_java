package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer implements Parcelable {
    public static final Creator<AppBrandLaunchReferrer> CREATOR = new 1();
    public String appId;
    public int bJt;
    public int fqE;
    public String fqF;
    public String fqG;
    public String fqH;
    public String url;

    /* synthetic */ AppBrandLaunchReferrer(Parcel parcel, byte b) {
        this(parcel);
    }

    public final String toString() {
        return "AppBrandLaunchReferrer{launchScene=" + this.fqE + ", appId='" + this.appId + '\'' + ", extraData='" + this.fqF + '\'' + ", url='" + this.url + '\'' + ", agentId='" + this.fqH + '\'' + ", sourceType='" + this.bJt + '\'' + '}';
    }

    final void h(Parcel parcel) {
        this.fqE = parcel.readInt();
        this.appId = parcel.readString();
        this.fqF = parcel.readString();
        this.fqG = parcel.readString();
        this.url = parcel.readString();
        this.fqH = parcel.readString();
        this.bJt = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fqE);
        parcel.writeString(this.appId);
        parcel.writeString(this.fqF);
        parcel.writeString(this.fqG);
        parcel.writeString(this.url);
        parcel.writeString(this.fqH);
        parcel.writeInt(this.bJt);
    }

    public final void a(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer != null) {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            appBrandLaunchReferrer.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            h(obtain);
            obtain.recycle();
        }
    }

    public final JSONObject aef() {
        Object jSONObject;
        try {
            jSONObject = new JSONObject(this.fqF);
        } catch (Exception e) {
            jSONObject = this.fqF;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appId", this.appId);
            jSONObject2.put("extraData", jSONObject);
            if ((this.fqE == 1 || this.fqE == 3) && !bi.oW(this.fqG)) {
                jSONObject2.put("privateExtraData", new JSONObject(this.fqG));
            }
        } catch (Exception e2) {
        }
        if (jSONObject2.length() == 0) {
            return null;
        }
        return jSONObject2;
    }

    public final int describeContents() {
        return 0;
    }

    private AppBrandLaunchReferrer(Parcel parcel) {
        h(parcel);
    }
}
