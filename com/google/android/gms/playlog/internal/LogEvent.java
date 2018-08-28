package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final a CREATOR = new a();
    public final long bat;
    public final long bau;
    public final byte[] bav;
    public final Bundle baw;
    public final String tag;
    public final int versionCode;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.bat = j;
        this.bau = j2;
        this.tag = str;
        this.bav = bArr;
        this.baw = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.tag).append(",");
        stringBuilder.append("eventTime=").append(this.bat).append(",");
        stringBuilder.append("eventUptime=").append(this.bau).append(",");
        if (!(this.baw == null || this.baw.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.baw.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.baw.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
