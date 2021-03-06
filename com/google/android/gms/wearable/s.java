package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class s implements Creator<Asset> {
    static void a(Asset asset, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, asset.mVersionCode);
        b.a(parcel, 2, asset.bdf);
        b.a(parcel, 3, asset.bdg);
        b.a(parcel, 4, asset.bdh, i);
        b.a(parcel, 5, asset.uri, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        int i = 0;
        Uri uri = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    bArr = a.n(parcel, readInt);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) a.a(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Asset[i];
    }
}
