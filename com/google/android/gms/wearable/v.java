package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class v implements Creator<PutDataRequest> {
    static void a(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, putDataRequest.mVersionCode);
        b.a(parcel, 2, putDataRequest.aMJ, i);
        b.a(parcel, 4, putDataRequest.bds);
        b.a(parcel, 5, putDataRequest.bdf);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        int i = 0;
        byte[] bArr = null;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    bundle = a.m(parcel, readInt);
                    break;
                case 5:
                    bArr = a.n(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new PutDataRequest(i, uri, bundle, bArr);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PutDataRequest[i];
    }
}
