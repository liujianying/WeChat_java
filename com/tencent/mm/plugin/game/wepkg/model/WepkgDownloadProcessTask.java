package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bi;

public class WepkgDownloadProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgDownloadProcessTask> CREATOR = new 2();
    public String bKg;
    public String cfX;
    public String downloadUrl;
    public Runnable fFC;
    public String ffK;
    public int fileType;
    public String kfk;
    public long kfl;
    public int kfm;
    public RetCode kfn;
    public String version;

    /* synthetic */ WepkgDownloadProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    private WepkgDownloadProcessTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        ahA();
        WePkgDownloader.aVu().a(this.fileType, bi.oV(this.cfX), bi.oV(this.kfk), bi.oV(this.downloadUrl), this.kfl, bi.oV(this.version), bi.oV(this.bKg), this.kfm, new 1(this));
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void k(Parcel parcel) {
        this.fileType = parcel.readInt();
        this.cfX = parcel.readString();
        this.kfk = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.kfl = parcel.readLong();
        this.version = parcel.readString();
        this.bKg = parcel.readString();
        this.kfm = parcel.readInt();
        this.ffK = parcel.readString();
        this.kfn = (RetCode) parcel.readParcelable(RetCode.class.getClassLoader());
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeInt(this.fileType);
        parcel.writeString(this.cfX);
        parcel.writeString(this.kfk);
        parcel.writeString(this.downloadUrl);
        parcel.writeLong(this.kfl);
        parcel.writeString(this.version);
        parcel.writeString(this.bKg);
        parcel.writeInt(this.kfm);
        parcel.writeString(this.ffK);
        parcel.writeParcelable(this.kfn, i);
    }
}
