package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a$a;

public final class b implements Creator<PlayLoggerContext> {
    static void a(PlayLoggerContext playLoggerContext, Parcel parcel) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, playLoggerContext.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, playLoggerContext.packageName);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 3, playLoggerContext.bax);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, playLoggerContext.bay);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, playLoggerContext.baz);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, playLoggerContext.baA);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, playLoggerContext.baB);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, playLoggerContext.baC);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, playLoggerContext.baD);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 10, playLoggerContext.baE);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        boolean z = true;
        int i = 0;
        boolean z2 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i4 = a.e(parcel, readInt);
                    break;
                case 2:
                    str4 = a.k(parcel, readInt);
                    break;
                case 3:
                    i3 = a.e(parcel, readInt);
                    break;
                case 4:
                    i2 = a.e(parcel, readInt);
                    break;
                case 5:
                    str3 = a.k(parcel, readInt);
                    break;
                case 6:
                    str2 = a.k(parcel, readInt);
                    break;
                case 7:
                    z = a.c(parcel, readInt);
                    break;
                case 8:
                    str = a.k(parcel, readInt);
                    break;
                case 9:
                    z2 = a.c(parcel, readInt);
                    break;
                case 10:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
