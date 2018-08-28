package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ae implements Creator<OpenChannelResponse> {
    static void a(OpenChannelResponse openChannelResponse, Parcel parcel, int i) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, openChannelResponse.versionCode);
        b.c(parcel, 2, openChannelResponse.statusCode);
        b.a(parcel, 3, openChannelResponse.bej, i);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        ChannelImpl channelImpl = null;
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
                    channelImpl = (ChannelImpl) a.a(parcel, readInt, ChannelImpl.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new OpenChannelResponse(i2, i, channelImpl);
        }
        throw new a.a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new OpenChannelResponse[i];
    }
}
