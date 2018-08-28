package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import java.util.Locale;

final class AppBrandPrepareTask$PrepareParams implements Parcelable {
    public static final Creator<AppBrandPrepareTask$PrepareParams> CREATOR = new 1();
    private int eEZ;
    private boolean geV;
    private int gfe;
    private String gff;
    private int gfg;
    private AppBrandLaunchReferrer gfh;
    private String gfi;
    private int gfj;
    private boolean gfk;
    private String mAppId;

    public final String toShortString() {
        return String.format(Locale.US, "[%s|%d]", new Object[]{this.mAppId, Integer.valueOf(this.gfg)});
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.gfe);
        parcel.writeInt(this.eEZ);
        parcel.writeString(this.gff);
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.gfg);
        parcel.writeParcelable(this.gfh, i);
        parcel.writeString(this.gfi);
        parcel.writeInt(this.gfj);
        if (this.geV) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.gfk) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    AppBrandPrepareTask$PrepareParams() {
    }

    AppBrandPrepareTask$PrepareParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.gfe = parcel.readInt();
        this.eEZ = parcel.readInt();
        this.gff = parcel.readString();
        this.mAppId = parcel.readString();
        this.gfg = parcel.readInt();
        this.gfh = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
        this.gfi = parcel.readString();
        this.gfj = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.geV = z;
        if (parcel.readInt() <= 0) {
            z2 = false;
        }
        this.gfk = z2;
    }
}
