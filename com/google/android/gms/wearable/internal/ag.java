package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ag implements Creator<PutDataResponse> {
    static void a(PutDataResponse putDataResponse, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, putDataResponse.versionCode);
        b.c(parcel, 2, putDataResponse.statusCode);
        b.a(parcel, 3, putDataResponse.beC, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        DataItemParcelable dataItemParcelable = null;
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
                    dataItemParcelable = (DataItemParcelable) a.a(parcel, readInt, DataItemParcelable.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new PutDataResponse(i2, i, dataItemParcelable);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PutDataResponse[i];
    }
}
