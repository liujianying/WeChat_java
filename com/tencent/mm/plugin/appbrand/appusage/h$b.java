package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;

final class h$b implements a<IPCVoid, Parcel> {
    private h$b() {
    }

    public final /* synthetic */ void a(Object obj, final c cVar) {
        AnonymousClass1 anonymousClass1 = new j.a() {
            public final void a(String str, l lVar) {
                if (cVar != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.writeString(str);
                    obtain.writeInt(lVar.fBN);
                    obtain.writeString(lVar.obj == null ? null : lVar.obj.toString());
                    cVar.at(obtain);
                }
            }
        };
        ((g) e.x(g.class)).a(anonymousClass1, com.tencent.mm.plugin.appbrand.r.c.Em().lnJ.getLooper());
        ((com.tencent.mm.ipcinvoker.e.a) cVar).a(new 2(this, anonymousClass1));
    }
}
