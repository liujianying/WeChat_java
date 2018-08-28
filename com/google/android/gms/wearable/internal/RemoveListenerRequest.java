package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.w.a;

public class RemoveListenerRequest implements SafeParcelable {
    public static final Creator<RemoveListenerRequest> CREATOR = new ah();
    public final w bdT;
    final int mVersionCode;

    RemoveListenerRequest(int i, IBinder iBinder) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.bdT = a.s(iBinder);
        } else {
            this.bdT = null;
        }
    }

    public RemoveListenerRequest(w wVar) {
        this.mVersionCode = 1;
        this.bdT = wVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ah.a(this, parcel);
    }
}
