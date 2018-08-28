package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.bk.b;
import com.tencent.mm.protocal.c.ob;

public final class AppRuntimeApiPermissionBundle implements Parcelable {
    public static final Creator<AppRuntimeApiPermissionBundle> CREATOR = new 1();
    final byte[] gqf;
    final byte[] gqg;
    final byte[] gqh;

    /* synthetic */ AppRuntimeApiPermissionBundle(Parcel parcel, byte b) {
        this(parcel);
    }

    public AppRuntimeApiPermissionBundle(ob obVar) {
        this.gqf = obVar.rsl.toByteArray();
        this.gqg = ((b) obVar.rsm.get(0)).toByteArray();
        this.gqh = ((b) obVar.rsm.get(1)).toByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.gqf);
        parcel.writeByteArray(this.gqg);
        parcel.writeByteArray(this.gqh);
    }

    private AppRuntimeApiPermissionBundle(Parcel parcel) {
        this.gqf = parcel.createByteArray();
        this.gqg = parcel.createByteArray();
        this.gqh = parcel.createByteArray();
    }
}
