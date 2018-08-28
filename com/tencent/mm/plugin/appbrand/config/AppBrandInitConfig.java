package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandInitConfig implements Parcelable {
    public static final Creator<AppBrandInitConfig> CREATOR = new Creator<AppBrandInitConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandInitConfig(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfig[i];
        }
    };
    public String appId;
    public int bGM;
    public String bKC;
    public String dFy;
    public String dzR;
    public String extInfo;
    public String fdE;
    public int fig;
    public final AppBrandLaunchReferrer fqA;
    public boolean fqr;
    public boolean fqs;
    public String fqt;
    public String fqu;
    private Boolean fqv;
    public boolean fqw;
    public String fqx;
    public boolean fqy;
    public boolean fqz;
    public String iconUrl;
    public long startTime;
    public String username;

    /* synthetic */ AppBrandInitConfig(Parcel parcel, byte b) {
        this(parcel);
    }

    AppBrandInitConfig() {
        this.fqA = new AppBrandLaunchReferrer();
    }

    public final void aea() {
        this.fdE = "SessionId@" + hashCode() + "#" + bi.VF();
    }

    public final boolean aaq() {
        return 4 == this.bGM;
    }

    public final boolean aeb() {
        if (this.fqv != null) {
            return this.fqv.booleanValue();
        }
        if (bi.oW(this.fqu)) {
            this.fqv = Boolean.valueOf(false);
            return this.fqv.booleanValue();
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.fqu).optJSONArray("call_plugin_info");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                this.fqv = Boolean.valueOf(false);
                return this.fqv.booleanValue();
            }
            this.fqv = Boolean.valueOf(true);
            return this.fqv.booleanValue();
        } catch (Exception e) {
            this.fqv = Boolean.valueOf(false);
        }
    }

    private AppBrandInitConfig(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.fqA = new AppBrandLaunchReferrer();
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.bKC = parcel.readString();
        this.iconUrl = parcel.readString();
        this.fig = parcel.readInt();
        this.bGM = parcel.readInt();
        this.fqr = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fqs = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fqw = z;
        this.fqt = parcel.readString();
        this.fqu = parcel.readString();
        this.extInfo = parcel.readString();
        this.fqx = parcel.readString();
        this.dFy = parcel.readString();
        this.dzR = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fqy = z;
        this.startTime = parcel.readLong();
        this.fqA.h(parcel);
        this.fdE = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.fqz = z2;
    }

    public final String toString() {
        return "AppBrandInitConfig{visitingSessionId='" + this.fdE + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.bKC + '\'' + ", debugType=" + this.fig + ", isPluginApp=" + this.fqr + ", preferRunInTools=" + this.fqs + ", orientation='" + this.fqt + '\'' + ", enterPath='" + this.fqx + '\'' + ", shareName='" + this.dFy + '\'' + ", shareKey='" + this.dzR + '\'' + ", isStick=" + this.fqy + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.fqz + ", referrer=" + this.fqA + ", extInfo=" + this.extInfo + '}';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2 = 1;
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeString(this.bKC);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.fig);
        parcel.writeInt(this.bGM);
        parcel.writeByte(this.fqr ? (byte) 1 : (byte) 0);
        if (this.fqs) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.fqw) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.fqt);
        parcel.writeString(this.fqu);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.fqx);
        parcel.writeString(this.dFy);
        parcel.writeString(this.dzR);
        if (this.fqy) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.startTime);
        this.fqA.writeToParcel(parcel, i);
        parcel.writeString(this.fdE);
        if (!this.fqz) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final JSONObject aec() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareKey", this.dzR);
            jSONObject.put("shareName", this.dFy);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public final JSONObject aed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("nickname", this.bKC);
            jSONObject.put("icon", this.iconUrl);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
