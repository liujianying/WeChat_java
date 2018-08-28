package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.j;

public final class g implements a {
    public final boolean aw(Object obj) {
        return obj instanceof f;
    }

    public final void a(Object obj, Parcel parcel) {
        f fVar = (f) obj;
        parcel.writeString(fVar.getClass().getName());
        fVar.f(parcel);
    }

    public final Object e(Parcel parcel) {
        f fVar = (f) j.e(parcel.readString(), f.class);
        if (fVar == null) {
            return null;
        }
        fVar.readFromParcel(parcel);
        return fVar;
    }
}
