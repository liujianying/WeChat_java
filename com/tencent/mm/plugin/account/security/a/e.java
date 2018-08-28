package com.tencent.mm.plugin.account.security.a;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class e extends i<d> {
    public static final String[] diD = new String[]{i.a(d.dhO, "SafeDeviceInfo")};
    h eOp = null;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((d) cVar);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.dhO, "SafeDeviceInfo", null);
        if (eVar instanceof h) {
            this.eOp = (h) eVar;
        }
    }

    public final boolean a(d dVar) {
        return super.b(dVar);
    }

    public final List<d> Yn() {
        List<d> linkedList = new LinkedList();
        if (getCount() > 0) {
            Cursor axc = super.axc();
            while (axc.moveToNext()) {
                d dVar = new d();
                dVar.d(axc);
                linkedList.add(dVar);
            }
            axc.close();
        }
        return linkedList;
    }
}
