package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class d implements Creator<ValidateAccountRequest> {
    static void a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, validateAccountRequest.mVersionCode);
        b.c(parcel, 2, validateAccountRequest.aNl);
        b.a(parcel, 3, validateAccountRequest.aMV);
        b.a(parcel, 4, validateAccountRequest.aMW, i);
        b.a(parcel, 5, validateAccountRequest.aNm);
        b.a(parcel, 6, validateAccountRequest.aNn);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        String str = null;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = a.l(parcel, readInt);
                    break;
                case 4:
                    scopeArr = (Scope[]) a.b(parcel, readInt, Scope.CREATOR);
                    break;
                case 5:
                    bundle = a.m(parcel, readInt);
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
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
