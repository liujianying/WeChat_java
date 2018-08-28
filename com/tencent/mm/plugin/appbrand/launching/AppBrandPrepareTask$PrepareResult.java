package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;

final class AppBrandPrepareTask$PrepareResult implements Parcelable {
    public static final Creator<AppBrandPrepareTask$PrepareResult> CREATOR = new 1();
    private AppBrandSysConfig fcu;
    private int gfl;
    private AppBrandLaunchErrorAction gfm;
    private int gfn;
    private a gfo;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.gfl);
        parcel.writeParcelable(this.gfm, i);
        parcel.writeParcelable(this.fcu, i);
        parcel.writeInt(this.gfn);
        if (this.gfl == 5) {
            parcel.writeString(this.gfo.toString());
        }
    }

    AppBrandPrepareTask$PrepareResult() {
    }

    AppBrandPrepareTask$PrepareResult(Parcel parcel) {
        this.gfl = parcel.readInt();
        this.gfm = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
        this.fcu = (AppBrandSysConfig) parcel.readParcelable(AppBrandSysConfig.class.getClassLoader());
        this.gfn = parcel.readInt();
        if (this.gfl == 5) {
            this.gfo = a.uc(parcel.readString());
        }
    }
}
