package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR = new a();
    final String aEN;
    final String aID;
    final String aIE;
    final Uri aIF;
    final List<IdToken> aIG;
    final String aIH;
    final String aII;
    final String aIJ;
    final String aIK;
    final String mName;
    final int mVersionCode;

    Credential(int i, String str, String str2, String str3, String str4, Uri uri, List<IdToken> list, String str5, String str6, String str7, String str8) {
        this.mVersionCode = i;
        this.aID = str;
        this.aIE = str2;
        this.aEN = (String) w.ah(str3);
        this.mName = str4;
        this.aIF = uri;
        this.aIG = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.aIH = str5;
        this.aII = str6;
        this.aIJ = str7;
        this.aIK = str8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.aEN, credential.aEN) && TextUtils.equals(this.mName, credential.mName) && v.c(this.aIF, credential.aIF) && TextUtils.equals(this.aIH, credential.aIH) && TextUtils.equals(this.aII, credential.aII) && TextUtils.equals(this.aIJ, credential.aIJ);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.aEN, this.mName, this.aIF, this.aIH, this.aII, this.aIJ});
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
