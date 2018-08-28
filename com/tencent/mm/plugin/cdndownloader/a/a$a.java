package com.tencent.mm.plugin.cdndownloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;

public abstract class a$a extends Binder implements a {
    public a$a() {
        attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
    }

    public static a H(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
            return new a(iBinder);
        }
        return (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        CDNTaskInfo cDNTaskInfo = null;
        int i3 = 0;
        int a;
        boolean yj;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                if (parcel.readInt() != 0) {
                    cDNTaskInfo = (CDNTaskInfo) CDNTaskInfo.CREATOR.createFromParcel(parcel);
                }
                a = a(cDNTaskInfo);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                if (parcel.readInt() != 0) {
                    cDNTaskInfo = (CDNTaskInfo) CDNTaskInfo.CREATOR.createFromParcel(parcel);
                }
                a = b(cDNTaskInfo);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                yj = yj(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(yj ? 1 : 0);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                yj = yk(parcel.readString());
                parcel2.writeNoException();
                if (yj) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                CDNTaskState yl = yl(parcel.readString());
                parcel2.writeNoException();
                if (yl != null) {
                    parcel2.writeInt(1);
                    yl.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                a(b$a.I(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                b(b$a.I(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                od(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                aAg();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                aAh();
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                aAi();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
