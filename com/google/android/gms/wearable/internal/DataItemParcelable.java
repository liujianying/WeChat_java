package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import java.util.HashMap;
import java.util.Map;

public class DataItemParcelable implements SafeParcelable, f {
    public static final Creator<DataItemParcelable> CREATOR = new e();
    final Uri aMJ;
    byte[] bdf;
    final Map<String, g> ber;
    final int mVersionCode;

    DataItemParcelable(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.mVersionCode = i;
        this.aMJ = uri;
        Map hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.ber = hashMap;
        this.bdf = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public final /* synthetic */ Object freeze() {
        return this;
    }

    public final byte[] getData() {
        return this.bdf;
    }

    public final Uri getUri() {
        return this.aMJ;
    }

    public final Map<String, g> rQ() {
        return this.ber;
    }

    public String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(",dataSz=" + (this.bdf == null ? "null" : Integer.valueOf(this.bdf.length)));
        stringBuilder.append(", numAssets=" + this.ber.size());
        stringBuilder.append(", uri=" + this.aMJ);
        if (isLoggable) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.ber.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.ber.get(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
