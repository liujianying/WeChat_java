package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c implements Creator<FieldMappingDictionary> {
    static void a(FieldMappingDictionary fieldMappingDictionary, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, fieldMappingDictionary.mVersionCode);
        List arrayList = new ArrayList();
        for (String str : fieldMappingDictionary.aPf.keySet()) {
            arrayList.add(new Entry(str, (Map) fieldMappingDictionary.aPf.get(str)));
        }
        b.b(parcel, 2, arrayList);
        b.a(parcel, 3, fieldMappingDictionary.aPh);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        int i = 0;
        String str = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    arrayList = a.c(parcel, readInt, Entry.CREATOR);
                    break;
                case 3:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
