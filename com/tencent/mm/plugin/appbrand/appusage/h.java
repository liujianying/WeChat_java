package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class h extends j implements u {
    private final Set<a> flw = new HashSet();

    private static final class c implements i<AppIdentity, IPCBoolean> {
        private c() {
        }

        private static IPCBoolean a(AppIdentity appIdentity) {
            try {
                return new IPCBoolean(((g) e.x(g.class)).ap(appIdentity.username, appIdentity.fmv));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", e, "ipc removeUsage", new Object[0]);
                return new IPCBoolean(false);
            }
        }
    }

    public final boolean ap(String str, int i) {
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new AppIdentity(str, i), c.class);
        return iPCBoolean == null ? false : iPCBoolean.value;
    }

    public final List<LocalUsageInfo> jL(int i) {
        Parcel parcel = (Parcel) XIPCInvoker.a("com.tencent.mm", new IPCInteger(i), a.class);
        if (parcel == null) {
            return null;
        }
        List<LocalUsageInfo> arrayList = new ArrayList(i);
        parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
        return arrayList;
    }

    public final void c(a aVar) {
        a(aVar, Looper.getMainLooper());
    }

    public final void a(a aVar, Looper looper) {
        Object obj = 1;
        if (aVar != null && looper != null) {
            super.a(aVar, looper);
            synchronized (this.flw) {
                this.flw.add(aVar);
                if (this.flw.size() != 1) {
                    obj = null;
                }
            }
            if (obj != null) {
                XIPCInvoker.a("com.tencent.mm", IPCVoid.dnk, b.class, new com.tencent.mm.ipcinvoker.c<Parcel>() {
                    public final /* synthetic */ void at(Object obj) {
                        Parcel parcel = (Parcel) obj;
                        h.this.b(parcel.readString(), parcel.readInt(), parcel.readString());
                    }
                });
            }
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            super.d(aVar);
            synchronized (this.flw) {
                this.flw.remove(aVar);
            }
        }
    }
}
