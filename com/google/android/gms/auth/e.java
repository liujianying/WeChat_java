package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class e implements Creator<AccountChangeEvent> {
    static void a(AccountChangeEvent accountChangeEvent, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, accountChangeEvent.aIs);
        b.a(parcel, 2, accountChangeEvent.aIt);
        b.a(parcel, 3, accountChangeEvent.aIu);
        b.c(parcel, 4, accountChangeEvent.aIv);
        b.c(parcel, 5, accountChangeEvent.aIw);
        b.a(parcel, 6, accountChangeEvent.aIx);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        long j = 0;
        String str = null;
        int i = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i3 = a.e(parcel, readInt);
                    break;
                case 2:
                    j = a.f(parcel, readInt);
                    break;
                case 3:
                    str2 = a.k(parcel, readInt);
                    break;
                case 4:
                    i2 = a.e(parcel, readInt);
                    break;
                case 5:
                    i = a.e(parcel, readInt);
                    break;
                case 6:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEvent[i];
    }
}
