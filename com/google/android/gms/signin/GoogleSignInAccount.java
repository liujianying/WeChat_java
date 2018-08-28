package com.google.android.gms.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new a();
    String aEN;
    String aIR;
    String baF;
    String baG;
    Uri baH;
    final int versionCode;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri) {
        this.versionCode = i;
        this.aEN = w.bg(str);
        this.aIR = str2;
        this.baF = str3;
        this.baG = str4;
        this.baH = uri;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
