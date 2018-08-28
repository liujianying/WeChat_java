package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Creator<WebImage> {
    static void a(WebImage webImage, Parcel parcel, int i) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, webImage.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, webImage.aMO, i);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, webImage.aMP);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, webImage.aMQ);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        Uri uri = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = a.e(parcel, readInt);
                    break;
                case 2:
                    uri = (Uri) a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 3:
                    i2 = a.e(parcel, readInt);
                    break;
                case 4:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WebImage[i];
    }
}
