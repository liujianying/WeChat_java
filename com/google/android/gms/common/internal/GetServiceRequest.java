package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new j();
    final int aNc;
    int aNd;
    String aNe;
    IBinder aNf;
    Scope[] aNg;
    Bundle aNh;
    Account aNi;
    final int version;

    public GetServiceRequest(int i) {
        this.version = 2;
        this.aNd = b.aJF;
        this.aNc = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.version = i;
        this.aNc = i2;
        this.aNd = i3;
        this.aNe = str;
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                account2 = a.b(a.g(iBinder));
            }
            this.aNi = account2;
        } else {
            this.aNf = iBinder;
            this.aNi = account;
        }
        this.aNg = scopeArr;
        this.aNh = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel, i);
    }
}
