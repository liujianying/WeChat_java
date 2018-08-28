package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class d implements Creator<BitmapTeleporter> {
    static void a(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, bitmapTeleporter.mVersionCode);
        b.a(parcel, 2, bitmapTeleporter.aMc, i);
        b.c(parcel, 3, bitmapTeleporter.aMd);
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
                    parcelFileDescriptor = (ParcelFileDescriptor) a.a(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new BitmapTeleporter(i2, parcelFileDescriptor, i);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
