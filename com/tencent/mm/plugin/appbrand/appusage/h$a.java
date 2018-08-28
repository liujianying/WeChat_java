package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.app.e;

final class h$a implements i<IPCInteger, Parcel> {
    private h$a() {
    }

    private static Parcel a(IPCInteger iPCInteger) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeTypedList(((g) e.x(g.class)).B(iPCInteger.value, false));
            return obtain;
        } catch (Exception e) {
            obtain.setDataPosition(0);
            obtain.writeTypedList(null);
            return obtain;
        }
    }
}
