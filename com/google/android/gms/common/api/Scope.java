package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR = new s();
    final String aKo;
    final int mVersionCode;

    Scope(int i, String str) {
        w.i(str, "scopeUri must not be null or empty");
        this.mVersionCode = i;
        this.aKo = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.aKo.equals(((Scope) obj).aKo);
    }

    public final int hashCode() {
        return this.aKo.hashCode();
    }

    public final String toString() {
        return this.aKo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        s.a(this, parcel);
    }
}
