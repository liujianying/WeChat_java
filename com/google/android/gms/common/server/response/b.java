package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;

public final class b implements Creator<FieldMapPair> {
    static void a(FieldMapPair fieldMapPair, Parcel parcel, int i) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, fieldMapPair.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, fieldMapPair.aAL);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, fieldMapPair.aPj, i);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        int i = 0;
        Field field = null;
        String str = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    str = a.k(parcel, readInt);
                    break;
                case 3:
                    field = (Field) a.a(parcel, readInt, Field.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new FieldMapPair(i, str, field);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FieldMapPair[i];
    }
}
