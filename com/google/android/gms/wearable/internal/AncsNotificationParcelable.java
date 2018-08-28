package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AncsNotificationParcelable implements SafeParcelable {
    public static final Creator<AncsNotificationParcelable> CREATOR = new av();
    final String aYu;
    String baG;
    final String bdZ;
    final String bea;
    final String beb;
    final String bec;
    byte bed;
    byte bee;
    byte bef;
    byte beg;
    int mId;
    final int mVersionCode;

    AncsNotificationParcelable(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.mId = i2;
        this.mVersionCode = i;
        this.aYu = str;
        this.bdZ = str2;
        this.bea = str3;
        this.beb = str4;
        this.bec = str5;
        this.baG = str6;
        this.bed = b;
        this.bee = b2;
        this.bef = b3;
        this.beg = b4;
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
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) obj;
        return this.beg != ancsNotificationParcelable.beg ? false : this.bef != ancsNotificationParcelable.bef ? false : this.bee != ancsNotificationParcelable.bee ? false : this.bed != ancsNotificationParcelable.bed ? false : this.mId != ancsNotificationParcelable.mId ? false : this.mVersionCode != ancsNotificationParcelable.mVersionCode ? false : !this.aYu.equals(ancsNotificationParcelable.aYu) ? false : (this.bdZ == null ? ancsNotificationParcelable.bdZ != null : !this.bdZ.equals(ancsNotificationParcelable.bdZ)) ? false : !this.baG.equals(ancsNotificationParcelable.baG) ? false : !this.bea.equals(ancsNotificationParcelable.bea) ? false : !this.bec.equals(ancsNotificationParcelable.bec) ? false : this.beb.equals(ancsNotificationParcelable.beb);
    }

    public int hashCode() {
        return (((((((((((((((((this.bdZ != null ? this.bdZ.hashCode() : 0) + (((((this.mVersionCode * 31) + this.mId) * 31) + this.aYu.hashCode()) * 31)) * 31) + this.bea.hashCode()) * 31) + this.beb.hashCode()) * 31) + this.bec.hashCode()) * 31) + this.baG.hashCode()) * 31) + this.bed) * 31) + this.bee) * 31) + this.bef) * 31) + this.beg;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.aYu + '\'' + ", mDateTime='" + this.bdZ + '\'' + ", mNotificationText='" + this.bea + '\'' + ", mTitle='" + this.beb + '\'' + ", mSubtitle='" + this.bec + '\'' + ", mDisplayName='" + this.baG + '\'' + ", mEventId=" + this.bed + ", mEventFlags=" + this.bee + ", mCategoryId=" + this.bef + ", mCategoryCount=" + this.beg + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        av.a(this, parcel);
    }
}
