package com.tencent.mm.ipcinvoker.extension;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.ipcinvoker.j;

public final class b implements a {
    public final boolean aw(Object obj) {
        return obj instanceof a;
    }

    public final void a(Object obj, Parcel parcel) {
        a aVar = (a) obj;
        parcel.writeString(aVar.getClass().getName());
        parcel.writeBundle(aVar.toBundle());
    }

    public final Object e(Parcel parcel) {
        String readString = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        a aVar = (a) j.e(readString, a.class);
        if (aVar == null) {
            return null;
        }
        aVar.fromBundle(readBundle);
        return aVar;
    }
}
