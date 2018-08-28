package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class g extends i<com.tencent.mm.g.c.g> {
    public static final String[] diD = new String[]{i.a(com.tencent.mm.g.c.g.wI(), "AddContactAntispamTicket")};
    private h dCZ;
    SparseArray<String> sNR = new SparseArray();

    public g(e eVar) {
        super(eVar, com.tencent.mm.g.c.g.wI(), "AddContactAntispamTicket", null);
        this.dCZ = (h) eVar;
    }

    public final void x(String str, int i, String str2) {
        if (!bi.oW(str)) {
            a aVar = new a();
            aVar.field_userName = str;
            aVar.field_scene = i;
            aVar.field_ticket = str2;
            a(aVar);
            fX(str, str2);
        }
    }

    public final void cZ(List<com.tencent.mm.g.c.g> list) {
        if (list.size() != 0) {
            long dO = this.dCZ.dO(Thread.currentThread().getId());
            for (com.tencent.mm.g.c.g a : list) {
                a(a);
            }
            this.dCZ.gp(dO);
        }
    }

    public final void fX(String str, String str2) {
        if (!bi.oW(str)) {
            this.sNR.put(str.hashCode(), str2);
        }
    }

    public final String XH(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2 = (String) this.sNR.get(str.hashCode());
        if (!bi.oW(str2)) {
            return str2;
        }
        a aVar = new a();
        aVar.field_userName = str;
        if (!b(aVar, new String[]{"userName"})) {
            return null;
        }
        String str3 = aVar.field_userName;
        int i = aVar.field_scene;
        fX(str3, aVar.field_ticket);
        return aVar.field_ticket;
    }
}
