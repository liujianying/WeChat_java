package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a$a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class bb implements Creator<ChannelImpl> {
    static void a(ChannelImpl channelImpl, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, channelImpl.mVersionCode);
        b.a(parcel, 2, channelImpl.bem);
        b.a(parcel, 3, channelImpl.bdn);
        b.a(parcel, 4, channelImpl.ben);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int c = a.c(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < c) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = a.e(parcel, readInt);
                    break;
                case 2:
                    str3 = a.k(parcel, readInt);
                    break;
                case 3:
                    str2 = a.k(parcel, readInt);
                    break;
                case 4:
                    str = a.k(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new ChannelImpl(i, str3, str2, str);
        }
        throw new a$a("Overread allowed size end=" + c, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ChannelImpl[i];
    }
}
