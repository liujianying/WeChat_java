package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface o extends IInterface {

    public static abstract class a extends Binder implements o {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        }

        public static o O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
                return new a(iBinder);
            }
            return (o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int aHz;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    long aHx = aHx();
                    parcel2.writeNoException();
                    parcel2.writeLong(aHx);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    byte[] aHy = aHy();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(aHy);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    aHz = aHz();
                    parcel2.writeNoException();
                    parcel2.writeInt(aHz);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    aHz = aHA();
                    parcel2.writeNoException();
                    parcel2.writeInt(aHz);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    aHz = aHB();
                    parcel2.writeNoException();
                    parcel2.writeInt(aHz);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int aHA();

    int aHB();

    long aHx();

    byte[] aHy();

    int aHz();
}
