package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.wepkg.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile implements Parcelable {
    public static final Creator<WepkgPreloadFile> CREATOR = new 1();
    public String aAL;
    public String bKg;
    public long createTime;
    public String downloadUrl;
    public String filePath;
    public String kfA;
    public boolean kfB;
    public String kfk;
    public int kfm;
    public String mimeType;
    public int size;
    public String version;

    public WepkgPreloadFile(Parcel parcel) {
        this.aAL = parcel.readString();
        this.kfA = parcel.readString();
        this.version = parcel.readString();
        this.filePath = parcel.readString();
        this.kfk = parcel.readString();
        this.mimeType = parcel.readString();
        this.bKg = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.size = parcel.readInt();
        this.kfm = parcel.readInt();
        this.kfB = parcel.readByte() != (byte) 0;
        this.createTime = parcel.readLong();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.aAL = aVar.field_key;
            this.kfA = aVar.field_pkgId;
            this.version = aVar.field_version;
            this.filePath = aVar.field_filePath;
            this.kfk = aVar.field_rid;
            this.mimeType = aVar.field_mimeType;
            this.bKg = aVar.field_md5;
            this.downloadUrl = aVar.field_downloadUrl;
            this.size = aVar.field_size;
            this.kfm = aVar.field_downloadNetType;
            this.kfB = aVar.field_completeDownload;
            this.createTime = aVar.field_createTime;
        }
    }

    public final JSONObject aVx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.aAL);
            jSONObject.put("pkgId", this.kfA);
            jSONObject.put("version", this.version);
            jSONObject.put("filePath", this.filePath);
            jSONObject.put("rid", this.kfk);
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("md5", this.bKg);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("size", this.size);
            jSONObject.put("downloadNetType", this.kfm);
            jSONObject.put("completeDownload", this.kfB);
            jSONObject.put("createTime", this.createTime);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aAL);
        parcel.writeString(this.kfA);
        parcel.writeString(this.version);
        parcel.writeString(this.filePath);
        parcel.writeString(this.kfk);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.bKg);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.kfm);
        parcel.writeByte((byte) (this.kfB ? 1 : 0));
        parcel.writeLong(this.createTime);
    }
}
