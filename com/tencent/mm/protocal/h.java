package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        private static class a implements h {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean a(int i, byte[] bArr, byte[] bArr2) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] Lm() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void hs(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int LH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int LF() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String LG() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void kl(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] DE() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] LI() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] Lo() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int Df() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String LM() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int getCmdId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String LJ() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String LK() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int LL() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
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
            attachInterface(this, "com.tencent.mm.protocal.IMMBaseResp_AIDL");
        }

        public static h ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            byte[] Lm;
            int LH;
            String LG;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    boolean a = a(parcel.readInt(), parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Lm = Lm();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Lm);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    hs(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LH = LH();
                    parcel2.writeNoException();
                    parcel2.writeInt(LH);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LH = LF();
                    parcel2.writeNoException();
                    parcel2.writeInt(LH);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LG = LG();
                    parcel2.writeNoException();
                    parcel2.writeString(LG);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    kl(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Lm = DE();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Lm);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Lm = LI();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Lm);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Lm = Lo();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Lm);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LH = Df();
                    parcel2.writeNoException();
                    parcel2.writeInt(LH);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LG = LM();
                    parcel2.writeNoException();
                    parcel2.writeString(LG);
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LH = getCmdId();
                    parcel2.writeNoException();
                    parcel2.writeInt(LH);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LG = LJ();
                    parcel2.writeNoException();
                    parcel2.writeString(LG);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LG = LK();
                    parcel2.writeNoException();
                    parcel2.writeString(LG);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    LH = LL();
                    parcel2.writeNoException();
                    parcel2.writeInt(LH);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    byte[] DE();

    int Df();

    int LF();

    String LG();

    int LH();

    byte[] LI();

    String LJ();

    String LK();

    int LL();

    String LM();

    byte[] Lm();

    byte[] Lo();

    boolean a(int i, byte[] bArr, byte[] bArr2);

    int getCmdId();

    void hs(int i);

    void kl(String str);
}
