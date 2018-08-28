package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Creator<CredentialPickerConfig> {
    static void a(CredentialPickerConfig credentialPickerConfig, Parcel parcel) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, credentialPickerConfig.aIL);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, credentialPickerConfig.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, credentialPickerConfig.aIM);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z2 = a.c(parcel, readInt);
                    break;
                case 2:
                    z = a.c(parcel, readInt);
                    break;
                case 1000:
                    i = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new CredentialPickerConfig(i, z2, z);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
