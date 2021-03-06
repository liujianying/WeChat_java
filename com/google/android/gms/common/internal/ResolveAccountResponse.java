package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new y();
    public boolean aKV;
    public ConnectionResult aLZ;
    public IBinder aMV;
    public boolean aNk;
    final int mVersionCode;

    public ResolveAccountResponse() {
        this(new ConnectionResult(8, null));
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.aMV = iBinder;
        this.aLZ = connectionResult;
        this.aKV = z;
        this.aNk = z2;
    }

    private ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.aLZ.equals(resolveAccountResponse.aLZ) && a.g(this.aMV).equals(a.g(resolveAccountResponse.aMV));
    }

    public void writeToParcel(Parcel parcel, int i) {
        y.a(this, parcel, i);
    }
}
