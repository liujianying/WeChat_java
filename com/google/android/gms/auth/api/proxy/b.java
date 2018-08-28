package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class b implements Creator<ProxyRequest> {
    static void a(ProxyRequest proxyRequest, Parcel parcel) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, proxyRequest.url);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, BaseReportManager.MAX_READ_COUNT, proxyRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 2, proxyRequest.aJn);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, proxyRequest.aJd);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, proxyRequest.body);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, proxyRequest.aJo);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        long j = 0;
        Bundle bundle = null;
        byte[] bArr = null;
        int i = 0;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = a.k(parcel, readInt);
                    break;
                case 2:
                    i = a.e(parcel, readInt);
                    break;
                case 3:
                    j = a.f(parcel, readInt);
                    break;
                case 4:
                    bArr = a.n(parcel, readInt);
                    break;
                case 5:
                    bundle = a.m(parcel, readInt);
                    break;
                case BaseReportManager.MAX_READ_COUNT /*1000*/:
                    i2 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new ProxyRequest(i2, str, i, j, bArr, bundle);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
