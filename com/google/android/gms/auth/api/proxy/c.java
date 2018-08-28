package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.tencent.smtt.utils.TbsLog;

public final class c implements Creator<ProxyResponse> {
    static void a(ProxyResponse proxyResponse, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, proxyResponse.aJp);
        b.c(parcel, TbsLog.TBSLOG_CODE_SDK_BASE, proxyResponse.versionCode);
        b.a(parcel, 2, proxyResponse.aJq, i);
        b.c(parcel, 3, proxyResponse.statusCode);
        b.a(parcel, 4, proxyResponse.aJo);
        b.a(parcel, 5, proxyResponse.body);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        byte[] bArr = null;
        Bundle bundle = null;
        int i = 0;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) a.a(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 3:
                    i = a.e(parcel, readInt);
                    break;
                case 4:
                    bundle = a.m(parcel, readInt);
                    break;
                case 5:
                    bArr = a.n(parcel, readInt);
                    break;
                case TbsLog.TBSLOG_CODE_SDK_BASE /*1000*/:
                    i3 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
