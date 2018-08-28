package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class g implements Creator<DataHolder> {
    static void a(DataHolder dataHolder, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.a(parcel, 1, dataHolder.aMh);
        b.c(parcel, BaseReportManager.MAX_READ_COUNT, dataHolder.mVersionCode);
        b.a(parcel, 2, dataHolder.aMj, i);
        b.c(parcel, 3, dataHolder.aJC);
        b.a(parcel, 4, dataHolder.aMk);
        b.u(parcel, t);
    }

    public static DataHolder b(Parcel parcel) {
        int c = a.c(parcel);
        Bundle bundle = null;
        int i = 0;
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    strArr = a.p(parcel, readInt);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) a.b(parcel, readInt, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = a.e(parcel, readInt);
                    break;
                case 4:
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
        if (parcel.dataPosition() != c) {
            throw new a.a("Overread allowed size end=" + c, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.oW();
        return dataHolder;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
