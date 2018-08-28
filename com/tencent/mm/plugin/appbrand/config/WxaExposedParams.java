package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WxaExposedParams implements Parcelable {
    public static final Creator<WxaExposedParams> CREATOR = new 1();
    public String appId;
    public int bJu;
    public String bVs;
    public int fih;
    public int fii;
    public String fso;
    public String fsp;
    public String iconUrl;
    public String nickname;
    public String username;

    private WxaExposedParams(a aVar) {
        this.appId = aVar.appId;
        this.username = aVar.username;
        this.nickname = aVar.nickname;
        this.iconUrl = aVar.iconUrl;
        this.fih = aVar.fih;
        this.fii = aVar.fii;
        this.fso = aVar.fso;
        this.bJu = aVar.bJu;
        this.bVs = aVar.bVs;
        this.fsp = aVar.fsp;
    }

    protected WxaExposedParams(Parcel parcel) {
        this.appId = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        this.iconUrl = parcel.readString();
        this.fih = parcel.readInt();
        this.fii = parcel.readInt();
        this.fso = parcel.readString();
        this.bJu = parcel.readInt();
        this.bVs = parcel.readString();
        this.fsp = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.fih);
        parcel.writeInt(this.fii);
        parcel.writeString(this.fso);
        parcel.writeInt(this.bJu);
        parcel.writeString(this.bVs);
        parcel.writeString(this.fsp);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.fih + ", pkgVersion=" + this.fii + ", pkgMD5='" + this.fso + '\'' + ", from=" + this.bJu + ", pageId='" + this.bVs + '\'' + ", errorUrl='" + this.fsp + '\'' + '}';
    }
}
