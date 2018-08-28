package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AmsEntityUpdateParcelable implements SafeParcelable {
    public static final Creator<AmsEntityUpdateParcelable> CREATOR = new at();
    byte bdX;
    final byte bdY;
    final String mValue;
    final int mVersionCode;

    AmsEntityUpdateParcelable(int i, byte b, byte b2, String str) {
        this.bdX = b;
        this.mVersionCode = i;
        this.bdY = b2;
        this.mValue = str;
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
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) obj;
        return this.bdX != amsEntityUpdateParcelable.bdX ? false : this.mVersionCode != amsEntityUpdateParcelable.mVersionCode ? false : this.bdY != amsEntityUpdateParcelable.bdY ? false : this.mValue.equals(amsEntityUpdateParcelable.mValue);
    }

    public int hashCode() {
        return (((((this.mVersionCode * 31) + this.bdX) * 31) + this.bdY) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + this.bdX + ", mAttributeId=" + this.bdY + ", mValue='" + this.mValue + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        at.a(this, parcel);
    }
}
