package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class c implements Creator<CheckServerAuthResult> {
    static void a(CheckServerAuthResult checkServerAuthResult, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, checkServerAuthResult.mVersionCode);
        b.a(parcel, 2, checkServerAuthResult.baI);
        b.b(parcel, 3, checkServerAuthResult.baJ);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        List list = null;
        boolean z = false;
        int i = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    z = a.c(parcel, readInt);
                    break;
                case 3:
                    list = a.c(parcel, readInt, Scope.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
