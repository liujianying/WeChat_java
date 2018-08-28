package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class f implements Creator<AccountChangeEventsRequest> {
    static void a(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, accountChangeEventsRequest.aIs);
        b.c(parcel, 2, accountChangeEventsRequest.aIw);
        b.a(parcel, 3, accountChangeEventsRequest.aIu);
        b.a(parcel, 4, accountChangeEventsRequest.aIy, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        Account account = null;
        String str = null;
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
                    str = a.k(parcel, readInt);
                    break;
                case 4:
                    account = (Account) a.a(parcel, readInt, Account.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new AccountChangeEventsRequest(i2, i, str, account);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
