package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.m;

public class NodeParcelable implements SafeParcelable, m {
    public static final Creator<NodeParcelable> CREATOR = new ad();
    final String aEN;
    final String baG;
    final int beG;
    final boolean beH;
    final int mVersionCode;

    NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.mVersionCode = i;
        this.aEN = str;
        this.baG = str2;
        this.beG = i2;
        this.beH = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof NodeParcelable) ? false : ((NodeParcelable) obj).aEN.equals(this.aEN);
    }

    public final String getId() {
        return this.aEN;
    }

    public int hashCode() {
        return this.aEN.hashCode();
    }

    public String toString() {
        return "Node{" + this.baG + ", id=" + this.aEN + ", hops=" + this.beG + ", isNearby=" + this.beH + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.a(this, parcel);
    }
}
