package com.tencent.mm.plugin.normsg.b;

import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mm.plugin.normsg.b.b.d;
import com.tencent.mm.plugin.normsg.b.b.i;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class b$a extends d {
    final /* synthetic */ b lGB;
    private i lGD = null;
    private WeakReference<Object> lGE = null;

    b$a(b bVar, Object obj, IBinder iBinder) {
        this.lGB = bVar;
        super(bVar, iBinder);
        try {
            this.lGE = new WeakReference(obj);
            this.lGD = new i(bVar, h.findClass(b.ath() + "$Stub"));
        } catch (Throwable th) {
            b.a(bVar, th);
        }
    }

    protected final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 0 || i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        if (this.lGD == null) {
            x.e("MicroMsg.AED", "init failed, give up intercepting.");
            return super.onTransact(i, parcel, parcel2, i2);
        } else if (this.lGE.get() == null) {
            x.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            String str = (String) this.lGD.bjZ().get(i);
            try {
                parcel.enforceInterface(b.ath());
                int i3;
                IBinder readStrongBinder;
                IBinder readStrongBinder2;
                if (b.access$1200().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    if (i3 < 16) {
                        parcel.readInt();
                    } else {
                        parcel.readLong();
                    }
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21) {
                        if (parcel.readInt() != 0) {
                            Region.CREATOR.createFromParcel(parcel);
                        }
                    }
                    parcel.readInt();
                    readStrongBinder = parcel.readStrongBinder();
                    if (i3 >= 16) {
                        parcel.readInt();
                    }
                    b.c(this.lGB).put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                } else if (b.access$1300().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    if (i3 < 16) {
                        parcel.readInt();
                    } else {
                        parcel.readLong();
                    }
                    if (i3 >= 16) {
                        parcel.readInt();
                        if (i3 < 17) {
                            parcel.readInt();
                            parcel.readInt();
                        }
                    }
                    parcel.readInt();
                    readStrongBinder = parcel.readStrongBinder();
                    if (i3 >= 16) {
                        parcel.readInt();
                    }
                    b.c(this.lGB).put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                } else if (b.bjR().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readString();
                    if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    readStrongBinder2 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.lGB).put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                } else if (b.hM().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readString();
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    readStrongBinder2 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.lGB).put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                } else if (b.bjS().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readInt();
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    readStrongBinder2 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.lGB).put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                } else if (b.bjT().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    parcel.readLong();
                    parcel.readInt();
                    if (i3 >= 16 && i3 < 17) {
                        parcel.readInt();
                        parcel.readInt();
                    } else if (i3 >= 21 && parcel.readInt() != 0) {
                        Region.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    readStrongBinder2 = parcel.readStrongBinder();
                    parcel.readInt();
                    b.c(this.lGB).put(readStrongBinder2, Integer.valueOf(parcel.readInt()));
                } else if (b.bjU().equals(str)) {
                    i3 = VERSION.SDK_INT;
                    if (i3 < 16) {
                        parcel.readInt();
                    } else {
                        parcel.readLong();
                    }
                    parcel.readInt();
                    if (i3 >= 16 && parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel.readInt();
                    readStrongBinder = parcel.readStrongBinder();
                    if (i3 >= 16) {
                        parcel.readInt();
                    }
                    b.c(this.lGB).put(readStrongBinder, Integer.valueOf(parcel.readInt()));
                }
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                b.a(this.lGB, th);
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
