package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class j implements Creator<GetServiceRequest> {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, getServiceRequest.version);
        b.c(parcel, 2, getServiceRequest.aNc);
        b.c(parcel, 3, getServiceRequest.aNd);
        b.a(parcel, 4, getServiceRequest.aNe);
        b.a(parcel, 5, getServiceRequest.aNf);
        b.a(parcel, 6, getServiceRequest.aNg, i);
        b.a(parcel, 7, getServiceRequest.aNh);
        b.a(parcel, 8, getServiceRequest.aNi, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        Account account = null;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
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
                    i2 = a.e(parcel, readInt);
                    break;
                case 3:
                    i = a.e(parcel, readInt);
                    break;
                case 4:
                    str = a.k(parcel, readInt);
                    break;
                case 5:
                    iBinder = a.l(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) a.b(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = a.m(parcel, readInt);
                    break;
                case 8:
                    account = (Account) a.a(parcel, readInt, Account.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
