package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyRequest implements SafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new b();
    public static final int aJe = 0;
    public static final int aJf = 1;
    public static final int aJg = 2;
    public static final int aJh = 3;
    public static final int aJi = 4;
    public static final int aJj = 5;
    public static final int aJk = 6;
    public static final int aJl = 7;
    public static final int aJm = 7;
    public final long aJd;
    public final int aJn;
    Bundle aJo;
    public final byte[] body;
    public final String url;
    final int versionCode;

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.aJn = i2;
        this.aJd = j;
        this.body = bArr;
        this.aJo = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.aJn + " ]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
