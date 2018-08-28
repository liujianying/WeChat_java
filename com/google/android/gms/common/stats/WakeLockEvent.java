package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR = new g();
    final int aPA;
    final List<String> aPB;
    final String aPC;
    int aPD;
    final String aPE;
    final String aPF;
    final float aPG;
    final long aPo;
    int aPp;
    final long aPw;
    private long aPy;
    final String aPz;
    final int mVersionCode;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f) {
        this.mVersionCode = i;
        this.aPo = j;
        this.aPp = i2;
        this.aPz = str;
        this.aPE = str3;
        this.aPA = i3;
        this.aPy = -1;
        this.aPB = list;
        this.aPC = str2;
        this.aPw = j2;
        this.aPD = i4;
        this.aPF = str4;
        this.aPG = f;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
