package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.exdevice.service.j.a;

public abstract class h$a extends Binder implements h {
    public h$a() {
        attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
    }

    public static h J(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
            return new a(iBinder);
        }
        return (h) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        t tVar = null;
        int i3 = 0;
        boolean b;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = b(parcel.readInt(), a.L(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = c(parcel.readInt(), a.L(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                long[] aHt = aHt();
                parcel2.writeNoException();
                parcel2.writeLongArray(aHt);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = a(parcel.readLong(), parcel.readInt(), k$a.M(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = cT(parcel.readLong());
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = cU(parcel.readLong());
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 7:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                long a = a(p.a.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeLong(a);
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = cV(parcel.readLong());
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 9:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = a(i.a.K(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = b(i.a.K(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 11:
                n aVar;
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                    aVar = (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new n$a.a(readStrongBinder) : (n) queryLocalInterface;
                }
                a(aVar);
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                setChannelSessionKey(parcel.readLong(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            case 13:
                q aVar2;
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                String readString = parcel.readString();
                boolean z = parcel.readInt() != 0;
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface = readStrongBinder2.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                    aVar2 = (queryLocalInterface == null || !(queryLocalInterface instanceof q)) ? new q.a.a(readStrongBinder2) : (q) queryLocalInterface;
                }
                b = a(readString, z, aVar2);
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 14:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = d(parcel.readInt(), a.L(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 15:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = e(parcel.readInt(), a.L(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 16:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = b(parcel.readLong(), parcel.readInt(), k$a.M(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 17:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                b = cW(parcel.readLong());
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 18:
                s aVar3;
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                    aVar3 = (queryLocalInterface == null || !(queryLocalInterface instanceof s)) ? new s$a.a(readStrongBinder3) : (s) queryLocalInterface;
                }
                b = a(aVar3);
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 19:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                long readLong = parcel.readLong();
                byte[] createByteArray = parcel.createByteArray();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    queryLocalInterface = readStrongBinder4.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                    tVar = (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new t.a.a(readStrongBinder4) : (t) queryLocalInterface;
                }
                b = b(readLong, createByteArray, tVar);
                parcel2.writeNoException();
                if (b) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
