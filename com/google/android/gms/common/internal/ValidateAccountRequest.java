package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new d();
    final IBinder aMV;
    final Scope[] aMW;
    final int aNl;
    final Bundle aNm;
    final String aNn;
    final int mVersionCode;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.aNl = i2;
        this.aMV = iBinder;
        this.aMW = scopeArr;
        this.aNm = bundle;
        this.aNn = str;
    }

    public ValidateAccountRequest(p pVar, Scope[] scopeArr, String str) {
        this(1, b.aJF, pVar == null ? null : pVar.asBinder(), scopeArr, null, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
