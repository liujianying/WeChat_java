package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface x extends IInterface {

    public static abstract class a extends Binder implements x {

        private static class a implements x {
            private IBinder mRemote;

            public a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final byte[] DH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] DI() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int E(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            byte[] DH;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    DH = DH();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(DH);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    DH = DI();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(DH);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    int E = E(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(E);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    byte[] DH();

    byte[] DI();

    int E(byte[] bArr);
}