package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class ay implements Creator<CapabilityInfoParcelable> {
    static void a(CapabilityInfoParcelable capabilityInfoParcelable, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, capabilityInfoParcelable.mVersionCode);
        b.a(parcel, 2, capabilityInfoParcelable.mName);
        b.b(parcel, 3, capabilityInfoParcelable.beh);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        int i = 0;
        List list = null;
        String str = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    break;
                case 3:
                    list = a.c(parcel, readInt, NodeParcelable.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new CapabilityInfoParcelable(i, str, list);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CapabilityInfoParcelable[i];
    }
}
