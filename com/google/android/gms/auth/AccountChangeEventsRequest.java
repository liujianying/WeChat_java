package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new f();
    final int aIs;
    @Deprecated
    String aIu;
    int aIw;
    Account aIy;

    public AccountChangeEventsRequest() {
        this.aIs = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.aIs = i;
        this.aIw = i2;
        this.aIu = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.aIy = account;
        } else {
            this.aIy = new Account(str, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
