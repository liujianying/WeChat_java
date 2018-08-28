package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.w.a;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new ab();
    public final w bdT;
    public final IntentFilter[] bdU;
    public final String bdV;
    public final String bdW;
    final int mVersionCode;

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.bdT = a.s(iBinder);
        } else {
            this.bdT = null;
        }
        this.bdU = intentFilterArr;
        this.bdV = str;
        this.bdW = str2;
    }

    public AddListenerRequest(ap apVar) {
        this.mVersionCode = 1;
        this.bdT = apVar;
        this.bdU = apVar.bfp;
        this.bdV = apVar.bfq;
        this.bdW = apVar.bfr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ab.a(this, parcel, i);
    }
}
