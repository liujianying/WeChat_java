package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class t implements Creator<GetLocalNodeResponse> {
    static void a(GetLocalNodeResponse getLocalNodeResponse, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, getLocalNodeResponse.versionCode);
        b.c(parcel, 2, getLocalNodeResponse.statusCode);
        b.a(parcel, 3, getLocalNodeResponse.beE, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        NodeParcelable nodeParcelable = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    i = a.e(parcel, readInt);
                    break;
                case 3:
                    nodeParcelable = (NodeParcelable) a.a(parcel, readInt, NodeParcelable.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new GetLocalNodeResponse(i2, i, nodeParcelable);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetLocalNodeResponse[i];
    }
}
