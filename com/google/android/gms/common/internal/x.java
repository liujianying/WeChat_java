package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class x implements Creator<ResolveAccountRequest> {
    static void a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, resolveAccountRequest.mVersionCode);
        b.a(parcel, 2, resolveAccountRequest.aIy, i);
        b.c(parcel, 3, resolveAccountRequest.aNj);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        Account account = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    account = (Account) a.a(parcel, readInt, Account.CREATOR);
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
            return new ResolveAccountRequest(i2, account, i);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
