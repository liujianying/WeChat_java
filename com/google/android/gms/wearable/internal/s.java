package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class s implements Creator<GetFdForAssetResponse> {
    static void a(GetFdForAssetResponse getFdForAssetResponse, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, getFdForAssetResponse.versionCode);
        b.c(parcel, 2, getFdForAssetResponse.statusCode);
        b.a(parcel, 3, getFdForAssetResponse.beD, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    i = a.e(parcel, readInt);
                    break;
                case 3:
                    parcelFileDescriptor = (ParcelFileDescriptor) a.a(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new GetFdForAssetResponse(i2, i, parcelFileDescriptor);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetFdForAssetResponse[i];
    }
}
