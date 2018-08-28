package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class PlayLoggerContext implements SafeParcelable {
    public static final b CREATOR = new b();
    public final String baA;
    public final boolean baB;
    public final String baC;
    public final boolean baD;
    public final int baE;
    public final int bax;
    public final int bay;
    public final String baz;
    public final String packageName;
    public final int versionCode;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.bax = i2;
        this.bay = i3;
        this.baz = str2;
        this.baA = str3;
        this.baB = z;
        this.baC = str4;
        this.baD = z2;
        this.baE = i4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.bax == playLoggerContext.bax && this.bay == playLoggerContext.bay && v.c(this.baC, playLoggerContext.baC) && v.c(this.baz, playLoggerContext.baz) && v.c(this.baA, playLoggerContext.baA) && this.baB == playLoggerContext.baB && this.baD == playLoggerContext.baD && this.baE == playLoggerContext.baE;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.bax), Integer.valueOf(this.bay), this.baC, this.baz, this.baA, Boolean.valueOf(this.baB), Boolean.valueOf(this.baD), Integer.valueOf(this.baE)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.bax).append(',');
        stringBuilder.append("logSource=").append(this.bay).append(',');
        stringBuilder.append("logSourceName=").append(this.baC).append(',');
        stringBuilder.append("uploadAccount=").append(this.baz).append(',');
        stringBuilder.append("loggingId=").append(this.baA).append(',');
        stringBuilder.append("logAndroidId=").append(this.baB).append(',');
        stringBuilder.append("isAnonymous=").append(this.baD).append(',');
        stringBuilder.append("qosTier=").append(this.baE);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
