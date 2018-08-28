package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.g;

public class DataItemAssetParcelable implements SafeParcelable, g {
    public static final Creator<DataItemAssetParcelable> CREATOR = new b();
    final String aEN;
    final String aXv;
    final int mVersionCode;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.mVersionCode = i;
        this.aEN = str;
        this.aXv = str2;
    }

    public DataItemAssetParcelable(g gVar) {
        this.mVersionCode = 1;
        this.aEN = (String) w.ah(gVar.getId());
        this.aXv = (String) w.ah(gVar.rR());
    }

    public int describeContents() {
        return 0;
    }

    public final /* synthetic */ Object freeze() {
        return this;
    }

    public final String getId() {
        return this.aEN;
    }

    public final String rR() {
        return this.aXv;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.aEN == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.aEN);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.aXv);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
