package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.protocal.c.dh;
import java.util.ArrayList;

public class AppBrandSysConfig implements Parcelable {
    public static final Creator<AppBrandSysConfig> CREATOR = new 1();
    public String appId;
    public String bGy;
    public String bKC;
    public String fqJ;
    public String fqK;
    public boolean fqL;
    public boolean fqM;
    public boolean fqN;
    public boolean fqO;
    public AppRuntimeApiPermissionBundle fqP;
    public boolean fqQ;
    public int fqR;
    public int fqS;
    public int fqT;
    public int fqU;
    public int fqV;
    public int fqW;
    public int fqX;
    public boolean fqY;
    public long fqZ;
    public boolean fqw;
    public int fra;
    public boolean frb;
    public boolean frc;
    public ArrayList<String> frd;
    public ArrayList<String> fre;
    public ArrayList<String> frf;
    public ArrayList<String> frg;
    public boolean frh;
    public int fri;
    public int frj;
    public boolean frk;
    public int frl;
    public final WxaPkgWrappingInfo frm;
    public AppBrandGlobalSystemConfig frn;
    dh fro;
    public adz frp;
    public int uin;

    public final long aeg() {
        return this.fro == null ? 0 : this.fro.rdx;
    }

    public AppBrandSysConfig() {
        this.fqL = false;
        this.fqM = false;
        this.fqN = false;
        this.fqO = false;
        this.fqw = false;
        this.frm = new WxaPkgWrappingInfo();
    }

    public String toString() {
        return "AppBrandSysConfig{uin=" + this.uin + ", brandId='" + this.bGy + '\'' + ", brandName='" + this.bKC + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.fqJ + '\'' + ", debugEnabled=" + this.fqL + ", performancePanelEnabled=" + this.fqM + ", maxWebViewDepth=" + this.fqR + ", maxBackgroundLifeSpan=" + this.fqS + ", maxRequestConcurrent=" + this.fqT + ", maxUploadConcurrent=" + this.fqU + ", maxDownloadConcurrent=" + this.fqV + ", maxWebsocketConnect=" + this.fqW + ", websocketSkipPortCheck=" + this.fqY + ", requestDomains=" + this.frd + ", socketDomains=" + this.fre + ", uploadDomains=" + this.frf + ", downloadDomains=" + this.frg + ", appPkgInfo=" + this.frm + ", systemSettings=" + this.frn + ", runningFlag=" + n.a(this.fro) + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2;
        int i3 = 1;
        parcel.writeInt(this.uin);
        parcel.writeString(this.bGy);
        parcel.writeString(this.bKC);
        parcel.writeString(this.appId);
        parcel.writeString(this.fqJ);
        parcel.writeString(this.fqK);
        parcel.writeByte(this.fqL ? (byte) 1 : (byte) 0);
        if (this.fqM) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.fqN) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeParcelable(this.fqP, i);
        if (this.fqQ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.fqR);
        parcel.writeInt(this.fqS);
        parcel.writeInt(this.fqT);
        parcel.writeInt(this.fqU);
        parcel.writeInt(this.fqV);
        parcel.writeInt(this.fqW);
        parcel.writeInt(this.fqX);
        if (this.fqY) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.fqZ);
        parcel.writeInt(this.fra);
        if (this.frb) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.frc) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeStringList(this.frd);
        parcel.writeStringList(this.fre);
        parcel.writeStringList(this.frf);
        parcel.writeStringList(this.frg);
        parcel.writeParcelable(this.frm, i);
        parcel.writeParcelable(this.frn, i);
        if (this.frh) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeInt(this.fri);
        parcel.writeInt(this.frj);
        parcel.writeInt(this.frl);
        if (!this.frk) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        c.fH(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName()).a(this.frp, parcel);
        c.a(this.fro, parcel);
    }

    protected AppBrandSysConfig(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.fqL = false;
        this.fqM = false;
        this.fqN = false;
        this.fqO = false;
        this.fqw = false;
        this.uin = parcel.readInt();
        this.bGy = parcel.readString();
        this.bKC = parcel.readString();
        this.appId = parcel.readString();
        this.fqJ = parcel.readString();
        this.fqK = parcel.readString();
        this.fqL = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fqM = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fqN = z;
        this.fqP = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fqQ = z;
        this.fqR = parcel.readInt();
        this.fqS = parcel.readInt();
        this.fqT = parcel.readInt();
        this.fqU = parcel.readInt();
        this.fqV = parcel.readInt();
        this.fqW = parcel.readInt();
        this.fqX = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fqY = z;
        this.fqZ = parcel.readLong();
        this.fra = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.frb = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.frc = z;
        this.frd = parcel.createStringArrayList();
        this.fre = parcel.createStringArrayList();
        this.frf = parcel.createStringArrayList();
        this.frg = parcel.createStringArrayList();
        this.frm = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.frn = (AppBrandGlobalSystemConfig) parcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader());
        if (parcel.readByte() > (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.frh = z;
        this.fri = parcel.readInt();
        this.frj = parcel.readInt();
        this.frl = parcel.readInt();
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.frk = z2;
        this.frp = (adz) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
        this.fro = (dh) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
    }
}
