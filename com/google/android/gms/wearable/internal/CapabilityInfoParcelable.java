package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.m;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable {
    public static final Creator<CapabilityInfoParcelable> CREATOR = new ay();
    private final Object aNW = new Object();
    final List<NodeParcelable> beh;
    private Set<m> bei;
    final String mName;
    final int mVersionCode;

    CapabilityInfoParcelable(int i, String str, List<NodeParcelable> list) {
        this.mVersionCode = i;
        this.mName = str;
        this.beh = list;
        this.bei = null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) obj;
        if (this.mVersionCode != capabilityInfoParcelable.mVersionCode) {
            return false;
        }
        if (this.mName == null ? capabilityInfoParcelable.mName != null : !this.mName.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        if (this.beh != null) {
            if (this.beh.equals(capabilityInfoParcelable.beh)) {
                return true;
            }
        } else if (capabilityInfoParcelable.beh == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + (this.mVersionCode * 31)) * 31;
        if (this.beh != null) {
            i = this.beh.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.beh + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ay.a(this, parcel);
    }
}
