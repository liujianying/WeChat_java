package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;

final class BannerModel implements Parcelable {
    public static final Creator<BannerModel> CREATOR = new 1();
    private static volatile BannerModel gyp;
    String appId;
    String appName;
    String fmD;
    int fmv;
    String gyo;

    /* synthetic */ BannerModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.fmv);
        parcel.writeString(this.appName);
        parcel.writeString(this.fmD);
        parcel.writeString(this.gyo);
    }

    BannerModel() {
    }

    private BannerModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.fmv = parcel.readInt();
        this.appName = parcel.readString();
        this.fmD = parcel.readString();
        this.gyo = parcel.readString();
    }

    static BannerModel anY() {
        BannerModel anN;
        synchronized (BannerModel.class) {
            anN = ((e) g.l(e.class)).anN();
            gyp = anN;
        }
        return anN;
    }

    static BannerModel anZ() {
        BannerModel bannerModel;
        synchronized (BannerModel.class) {
            bannerModel = gyp;
        }
        return bannerModel;
    }
}
