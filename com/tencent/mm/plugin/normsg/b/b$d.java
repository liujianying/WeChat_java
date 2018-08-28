package com.tencent.mm.plugin.normsg.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;

class b$d extends Binder {
    final /* synthetic */ b lGB;
    protected final IBinder lGL;

    b$d(b bVar, IBinder iBinder) {
        this.lGB = bVar;
        this.lGL = iBinder;
    }

    public String getInterfaceDescriptor() {
        try {
            return this.lGL.getInterfaceDescriptor();
        } catch (RemoteException e) {
            return "<failure>";
        }
    }

    public boolean pingBinder() {
        return this.lGL.pingBinder();
    }

    public boolean isBinderAlive() {
        return this.lGL.isBinderAlive();
    }

    public IInterface queryLocalInterface(String str) {
        return null;
    }

    public void dump(FileDescriptor fileDescriptor, String[] strArr) {
        try {
            this.lGL.dump(fileDescriptor, strArr);
        } catch (RemoteException e) {
        }
    }

    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
        try {
            this.lGL.dumpAsync(fileDescriptor, strArr);
        } catch (RemoteException e) {
        }
    }

    protected boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        try {
            if (this.lGL.isBinderAlive()) {
                return this.lGL.transact(i, parcel, parcel2, i2);
            }
            return false;
        } catch (RemoteException e) {
            throw e;
        } catch (Throwable th) {
            b.a(this.lGB, th);
            return false;
        }
    }

    public void linkToDeath(DeathRecipient deathRecipient, int i) {
        try {
            this.lGL.linkToDeath(deathRecipient, i);
        } catch (RemoteException e) {
            deathRecipient.binderDied();
        }
    }

    public boolean unlinkToDeath(DeathRecipient deathRecipient, int i) {
        return this.lGL.unlinkToDeath(deathRecipient, i);
    }
}
