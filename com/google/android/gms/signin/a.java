package com.google.android.gms.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a implements Creator<GoogleSignInAccount> {
    static void a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, googleSignInAccount.versionCode);
        b.a(parcel, 2, googleSignInAccount.aEN);
        b.a(parcel, 3, googleSignInAccount.aIR);
        b.a(parcel, 4, googleSignInAccount.baF);
        b.a(parcel, 5, googleSignInAccount.baG);
        b.a(parcel, 6, googleSignInAccount.baH, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = com.google.android.gms.common.internal.safeparcel.a.c(parcel);
        int i = 0;
        Uri uri = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new GoogleSignInAccount(i, str4, str3, str2, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
