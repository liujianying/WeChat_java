package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public final class a implements Creator<Field> {
    static void a(Field field, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, field.mVersionCode);
        b.c(parcel, 2, field.pu());
        b.a(parcel, 3, field.pv());
        b.c(parcel, 4, field.pw());
        b.a(parcel, 5, field.px());
        b.a(parcel, 6, field.py());
        b.c(parcel, 7, field.pz());
        b.a(parcel, 8, field.pB());
        b.a(parcel, 9, field.aPe == null ? null : ConverterWrapper.a(field.aPe), i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = com.google.android.gms.common.internal.safeparcel.a.c(parcel);
        ConverterWrapper converterWrapper = null;
        String str = null;
        int i = 0;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, ConverterWrapper.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Field[i];
    }
}
