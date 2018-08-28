package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a$a;

public final class b implements Creator<DataItemAssetParcelable> {
    static void a(DataItemAssetParcelable dataItemAssetParcelable, Parcel parcel) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, dataItemAssetParcelable.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, dataItemAssetParcelable.aEN);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, dataItemAssetParcelable.aXv);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    str2 = a.k(parcel, readInt);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new DataItemAssetParcelable(i, str2, str);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataItemAssetParcelable[i];
    }
}
