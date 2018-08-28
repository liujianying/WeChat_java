package com.tencent.mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b$a extends Binder implements b {
    public b$a() {
        attachInterface(this, "com.tencent.mm.remoteservice.ICommClientCallback");
    }

    public static b asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommClientCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
            return new a(iBinder);
        }
        return (b) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Bundle bundle;
                boolean z;
                parcel.enforceInterface("com.tencent.mm.remoteservice.ICommClientCallback");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                onCallback(readString, bundle, z);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.remoteservice.ICommClientCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
