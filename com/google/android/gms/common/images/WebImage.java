package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new b();
    final Uri aMO;
    final int aMP;
    final int aMQ;
    final int mVersionCode;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.aMO = uri;
        this.aMP = i2;
        this.aMQ = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return v.c(this.aMO, webImage.aMO) && this.aMP == webImage.aMP && this.aMQ == webImage.aMQ;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.aMO, Integer.valueOf(this.aMP), Integer.valueOf(this.aMQ)});
    }

    public final String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.aMP), Integer.valueOf(this.aMQ), this.aMO.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
