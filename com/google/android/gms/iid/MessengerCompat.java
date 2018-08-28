package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.iid.c.a;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new 1();
    Messenger aRf;
    c aRg;

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.aRf = new Messenger(handler);
        } else {
            this.aRg = new a(this, handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.aRf = new Messenger(iBinder);
        } else {
            this.aRg = a.l(iBinder);
        }
    }

    public static int g(Message message) {
        return VERSION.SDK_INT >= 21 ? message.sendingUid : message.arg2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return z;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException e) {
            return z;
        }
    }

    public final IBinder getBinder() {
        return this.aRf != null ? this.aRf.getBinder() : this.aRg.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.aRf != null) {
            parcel.writeStrongBinder(this.aRf.getBinder());
        } else {
            parcel.writeStrongBinder(this.aRg.asBinder());
        }
    }
}
