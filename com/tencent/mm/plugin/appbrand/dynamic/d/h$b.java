package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.f;

public class h$b implements f {
    String cca;
    boolean fwf;
    boolean fwg;
    String id;

    public final void f(Parcel parcel) {
        int i;
        int i2 = 1;
        parcel.writeString(this.id);
        if (this.fwf) {
            i = 1;
        } else {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(this.cca);
        if (!this.fwg) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    public final void readFromParcel(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.id = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.fwf = z;
        this.cca = parcel.readString();
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.fwg = z2;
    }
}
