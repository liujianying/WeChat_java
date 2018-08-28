package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a implements Creator<EmailSignInConfig> {
    static void a(EmailSignInConfig emailSignInConfig, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, emailSignInConfig.versionCode);
        b.a(parcel, 2, emailSignInConfig.aJr, i);
        b.a(parcel, 3, emailSignInConfig.aJs);
        b.a(parcel, 4, emailSignInConfig.aJt, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = com.google.android.gms.common.internal.safeparcel.a.c(parcel);
        int i = 0;
        Uri uri = null;
        String str = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 4:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new EmailSignInConfig(i, uri2, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new EmailSignInConfig[i];
    }
}
