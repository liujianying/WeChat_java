package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class qs implements Parcelable {
    public static final Creator<qs> CREATOR = new 1();
    private final qw a;
    private float b = -1.0f;

    public qs(qw qwVar, float f) {
        this.a = qwVar;
        this.b = f;
    }

    public static a a() {
        return new a();
    }

    public final qw b() {
        return this.a;
    }

    public final float c() {
        return this.b;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qs)) {
            return false;
        }
        qs qsVar = (qs) obj;
        return b().equals(qsVar.b()) && Float.floatToIntBits(c()) == Float.floatToIntBits(qsVar.c());
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return sz.a(new String[]{sz.a("target", b()), sz.a("zoom", Float.valueOf(c()))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat((float) b().b());
        parcel.writeFloat((float) b().c());
        parcel.writeFloat(c());
    }
}
