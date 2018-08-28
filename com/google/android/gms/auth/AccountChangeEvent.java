package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new e();
    final int aIs;
    final long aIt;
    final String aIu;
    final int aIv;
    final int aIw;
    final String aIx;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.aIs = i;
        this.aIt = j;
        this.aIu = (String) w.ah(str);
        this.aIv = i2;
        this.aIw = i3;
        this.aIx = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.aIs == accountChangeEvent.aIs && this.aIt == accountChangeEvent.aIt && v.c(this.aIu, accountChangeEvent.aIu) && this.aIv == accountChangeEvent.aIv && this.aIw == accountChangeEvent.aIw && v.c(this.aIx, accountChangeEvent.aIx);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.aIs), Long.valueOf(this.aIt), this.aIu, Integer.valueOf(this.aIv), Integer.valueOf(this.aIw), this.aIx});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.aIv) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.aIu + ", changeType = " + str + ", changeData = " + this.aIx + ", eventIndex = " + this.aIw + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
