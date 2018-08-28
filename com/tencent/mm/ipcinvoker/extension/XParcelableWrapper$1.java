package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.j;

class XParcelableWrapper$1 implements Creator<XParcelableWrapper> {
    XParcelableWrapper$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        XParcelableWrapper xParcelableWrapper = new XParcelableWrapper((byte) 0);
        if (parcel.readInt() == 1) {
            String readString = parcel.readString();
            if (xParcelableWrapper.dne == null) {
                xParcelableWrapper.dne = (f) j.e(readString, f.class);
            }
            if (xParcelableWrapper.dne != null) {
                xParcelableWrapper.dne.readFromParcel(parcel);
            }
        }
        return xParcelableWrapper;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new XParcelableWrapper[i];
    }
}
