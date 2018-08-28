package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyResponse implements SafeParcelable {
    public static final Creator<ProxyResponse> CREATOR = new c();
    final Bundle aJo;
    public final int aJp;
    public final PendingIntent aJq;
    public final byte[] body;
    public final int statusCode;
    final int versionCode;

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.versionCode = i;
        this.aJp = i2;
        this.statusCode = i3;
        this.aJo = bundle;
        this.body = bArr;
        this.aJq = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
