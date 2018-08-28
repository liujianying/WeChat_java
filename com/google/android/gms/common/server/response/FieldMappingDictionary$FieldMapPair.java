package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class FieldMappingDictionary$FieldMapPair implements SafeParcelable {
    public static final b CREATOR = new b();
    final String aAL;
    final Field<?, ?> aPj;
    final int versionCode;

    FieldMappingDictionary$FieldMapPair(int i, String str, Field<?, ?> field) {
        this.versionCode = i;
        this.aAL = str;
        this.aPj = field;
    }

    FieldMappingDictionary$FieldMapPair(String str, Field<?, ?> field) {
        this.versionCode = 1;
        this.aAL = str;
        this.aPj = field;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
