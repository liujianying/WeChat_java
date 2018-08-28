package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.webview.stub.c.a.a;

public abstract class e$a extends Binder implements e {
    public e$a() {
        attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
    }

    public static e Z(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
            return new a(iBinder);
        }
        return (e) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        boolean z = false;
        boolean As;
        int readInt;
        boolean c;
        int i3;
        String bVl;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                As = As(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(As ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                c = c(readInt, bundle);
                parcel2.writeNoException();
                if (c) {
                    readInt = 1;
                } else {
                    readInt = 0;
                }
                parcel2.writeInt(readInt);
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 3:
                c aVar;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    aVar = (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(readStrongBinder) : (c) queryLocalInterface;
                }
                As = a(aVar);
                parcel2.writeNoException();
                if (As) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                if (parcel.readInt() != 0) {
                    c = true;
                } else {
                    c = false;
                }
                As = a(readString, readString2, bundle, c);
                parcel2.writeNoException();
                if (As) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bVl = bVl();
                parcel2.writeNoException();
                parcel2.writeString(bVl);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bVl = getCurrentUrl();
                parcel2.writeNoException();
                parcel2.writeString(bVl);
                return true;
            case 7:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bVl = bVm();
                parcel2.writeNoException();
                parcel2.writeString(bVl);
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                jV(z);
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                jW(z);
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                i3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                q(i3, bundle);
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bVn();
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                P(bundle);
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                QM(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                fo(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bVo();
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                e(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                bundle = g(readInt, bundle);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 18:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                Q(bundle);
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                jX(z);
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                fp(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
