package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.wepkg.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion implements Parcelable {
    public static final Creator<WepkgVersion> CREATOR = new 1();
    public String appId;
    public String bKg;
    public String cfx;
    public int cga;
    public String charset;
    public long createTime;
    public String downloadUrl;
    public String ffK;
    public String kfA;
    public boolean kfR;
    public long kfS;
    public long kfT;
    public int kfU;
    public int kfV;
    public long kfW;
    public boolean kfX;
    public boolean kfY;
    public boolean kfZ;
    public int kfm;
    public int kga;
    public String version;

    public WepkgVersion(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.kfA = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.ffK = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.kfR = z;
        this.kfS = parcel.readLong();
        this.kfT = parcel.readLong();
        this.kfU = parcel.readInt();
        this.cfx = parcel.readString();
        this.bKg = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.kfV = parcel.readInt();
        this.kfm = parcel.readInt();
        this.kfW = parcel.readLong();
        this.createTime = parcel.readLong();
        this.charset = parcel.readString();
        this.kfX = parcel.readByte() != (byte) 0;
        this.kfY = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.kfZ = z2;
        this.kga = parcel.readInt();
        this.cga = parcel.readInt();
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.kfA = cVar.field_pkgId;
            this.appId = cVar.field_appId;
            this.version = cVar.field_version;
            this.ffK = cVar.field_pkgPath;
            this.kfR = cVar.field_disableWvCache;
            this.kfS = cVar.field_clearPkgTime;
            this.kfT = cVar.field_checkIntervalTime;
            this.kfU = cVar.field_packMethod;
            this.cfx = cVar.field_domain;
            this.bKg = cVar.field_md5;
            this.downloadUrl = cVar.field_downloadUrl;
            this.kfV = cVar.field_pkgSize;
            this.kfm = cVar.field_downloadNetType;
            this.kfW = cVar.field_nextCheckTime;
            this.createTime = cVar.field_createTime;
            this.charset = cVar.field_charset;
            this.kfX = cVar.field_bigPackageReady;
            this.kfY = cVar.field_preloadFilesReady;
            this.kfZ = cVar.field_preloadFilesAtomic;
            this.kga = cVar.field_totalDownloadCount;
            this.cga = cVar.field_downloadTriggerType;
        }
    }

    public final JSONObject aVx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("pkgPath", this.ffK);
            jSONObject.put("disableWvCache", this.kfR);
            jSONObject.put("clearPkgTime", this.kfS);
            jSONObject.put("checkIntervalTime", this.kfT);
            jSONObject.put("packMethod", this.kfU);
            jSONObject.put("domain", this.cfx);
            jSONObject.put("md5", this.bKg);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("pkgSize", this.kfV);
            jSONObject.put("downloadNetType", this.kfm);
            jSONObject.put("nextCheckTime", this.kfW);
            jSONObject.put("charset", this.charset);
            jSONObject.put("bigPackageReady", this.kfX);
            jSONObject.put("preloadFilesReady", this.kfY);
            jSONObject.put("preloadFilesAtomic", this.kfZ);
            jSONObject.put("totalDownloadCount", this.kga);
            jSONObject.put("downloadTriggerType", this.cga);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.kfA);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeString(this.ffK);
        parcel.writeByte((byte) (this.kfR ? 1 : 0));
        parcel.writeLong(this.kfS);
        parcel.writeLong(this.kfT);
        parcel.writeInt(this.kfU);
        parcel.writeString(this.cfx);
        parcel.writeString(this.bKg);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.kfV);
        parcel.writeInt(this.kfm);
        parcel.writeLong(this.kfW);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.charset);
        parcel.writeByte((byte) (this.kfX ? 1 : 0));
        if (this.kfY) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.kfZ) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.kga);
        parcel.writeInt(this.cga);
    }
}
