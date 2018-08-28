package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.tencent.smtt.utils.TbsLog;
import java.util.List;

public final class a implements Creator<Credential> {
    static void a(Credential credential, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.a(parcel, 1001, credential.aID);
        b.a(parcel, 1, credential.aEN);
        b.c(parcel, TbsLog.TBSLOG_CODE_SDK_BASE, credential.mVersionCode);
        b.a(parcel, 2, credential.mName);
        b.a(parcel, 3, credential.aIF, i);
        b.a(parcel, 1002, credential.aIE);
        b.b(parcel, 4, credential.aIG);
        b.a(parcel, 5, credential.aIH);
        b.a(parcel, 6, credential.aII);
        b.a(parcel, 7, credential.aIJ);
        b.a(parcel, 8, credential.aIK);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = com.google.android.gms.common.internal.safeparcel.a.c(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 3:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    list = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt, IdToken.CREATOR);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case TbsLog.TBSLOG_CODE_SDK_BASE /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 1001:
                    str8 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 1002:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new Credential(i, str8, str7, str6, str5, uri, list, str4, str3, str2, str);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Credential[i];
    }
}
