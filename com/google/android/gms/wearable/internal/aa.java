package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class aa implements Creator<MessageEventParcelable> {
    static void a(MessageEventParcelable messageEventParcelable, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, messageEventParcelable.mVersionCode);
        b.c(parcel, 2, messageEventParcelable.beF);
        b.a(parcel, 3, messageEventParcelable.ben);
        b.a(parcel, 4, messageEventParcelable.bdf);
        b.a(parcel, 5, messageEventParcelable.aYw);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        String str = null;
        byte[] bArr = null;
        String str2 = null;
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
                    str2 = a.k(parcel, readInt);
                    break;
                case 4:
                    bArr = a.n(parcel, readInt);
                    break;
                case 5:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new MessageEventParcelable(i2, i, str2, bArr, str);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MessageEventParcelable[i];
    }
}
