package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public final class Status implements g, SafeParcelable {
    public static final Creator<Status> CREATOR = new t();
    public static final Status aKp = new Status(0);
    public static final Status aKq = new Status(14);
    public static final Status aKr = new Status(8);
    public static final Status aKs = new Status(15);
    public static final Status aKt = new Status(16);
    public final int aJC;
    final PendingIntent aJD;
    public final String aKu;
    final int mVersionCode;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.aJC = i2;
        this.aKu = str;
        this.aJD = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(String str) {
        this(1, 8, str, null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.aJC == status.aJC && v.c(this.aKu, status.aKu) && v.c(this.aJD, status.aJD);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), Integer.valueOf(this.aJC), this.aKu, this.aJD});
    }

    public final boolean isSuccess() {
        return this.aJC <= 0;
    }

    public final Status oF() {
        return this;
    }

    public final String toString() {
        return v.ag(this).h("statusCode", this.aKu != null ? this.aKu : b.dl(this.aJC)).h("resolution", this.aJD).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        t.a(this, parcel, i);
    }
}
