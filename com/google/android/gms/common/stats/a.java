package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a implements Creator<ConnectionEvent> {
    static void a(ConnectionEvent connectionEvent, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, connectionEvent.mVersionCode);
        b.a(parcel, 2, connectionEvent.aPo);
        b.a(parcel, 4, connectionEvent.aPq);
        b.a(parcel, 5, connectionEvent.aPr);
        b.a(parcel, 6, connectionEvent.aPs);
        b.a(parcel, 7, connectionEvent.aPt);
        b.a(parcel, 8, connectionEvent.aPu);
        b.a(parcel, 10, connectionEvent.aPw);
        b.a(parcel, 11, connectionEvent.aPx);
        b.c(parcel, 12, connectionEvent.aPp);
        b.a(parcel, 13, connectionEvent.aPv);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = com.google.android.gms.common.internal.safeparcel.a.c(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
