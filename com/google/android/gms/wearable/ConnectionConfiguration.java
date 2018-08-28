package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new u();
    boolean aFp;
    final int aMd;
    final String bdi;
    final int bdj;
    final boolean bdk;
    String bdl;
    boolean bdm;
    String bdn;
    final String mName;
    final int mVersionCode;

    ConnectionConfiguration(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.mVersionCode = i;
        this.mName = str;
        this.bdi = str2;
        this.aMd = i2;
        this.bdj = i3;
        this.bdk = z;
        this.aFp = z2;
        this.bdl = str3;
        this.bdm = z3;
        this.bdn = str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return v.c(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && v.c(this.mName, connectionConfiguration.mName) && v.c(this.bdi, connectionConfiguration.bdi) && v.c(Integer.valueOf(this.aMd), Integer.valueOf(connectionConfiguration.aMd)) && v.c(Integer.valueOf(this.bdj), Integer.valueOf(connectionConfiguration.bdj)) && v.c(Boolean.valueOf(this.bdk), Boolean.valueOf(connectionConfiguration.bdk)) && v.c(Boolean.valueOf(this.bdm), Boolean.valueOf(connectionConfiguration.bdm));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), this.mName, this.bdi, Integer.valueOf(this.aMd), Integer.valueOf(this.bdj), Boolean.valueOf(this.bdk), Boolean.valueOf(this.bdm)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.bdi);
        stringBuilder.append(", mType=" + this.aMd);
        stringBuilder.append(", mRole=" + this.bdj);
        stringBuilder.append(", mEnabled=" + this.bdk);
        stringBuilder.append(", mIsConnected=" + this.aFp);
        stringBuilder.append(", mPeerNodeId=" + this.bdl);
        stringBuilder.append(", mBtlePriority=" + this.bdm);
        stringBuilder.append(", mNodeId=" + this.bdn);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        u.a(this, parcel);
    }
}
