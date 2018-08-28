package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;

class u$a$a implements u {
    private IBinder aFh;

    u$a$a(IBinder iBinder) {
        this.aFh = iBinder;
    }

    public final void aD(int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.aFh.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.aFh;
    }
}
