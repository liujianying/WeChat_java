package com.tencent.mm.plugin.bottle.a;

import android.database.Cursor;
import com.tencent.mm.aq.f;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az.a;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

public final class i implements ar {
    private static HashMap<Integer, d> cVM;
    private a dBJ = new 2(this);
    private b hke;

    private static i auj() {
        au.HN();
        i iVar = (i) bs.iK("plugin.bottle");
        if (iVar != null) {
            return iVar;
        }
        iVar = new i();
        au.HN().a("plugin.bottle", iVar);
        return iVar;
    }

    public static b auk() {
        g.Eg().Ds();
        if (auj().hke == null) {
            i auj = auj();
            au.HU();
            auj.hke = new b(c.FO());
        }
        return auj().hke;
    }

    public final void onAccountRelease() {
        au.HU();
        c.FW().c(this.dBJ);
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("THROWBOTTLEINFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public static void aul() {
        au.HU();
        Cursor clF = c.FW().clF();
        for (int i = 0; i < clF.getCount(); i++) {
            clF.moveToPosition(i);
            ai aiVar = new ai();
            aiVar.d(clF);
            au.HU();
            bd GD = c.FT().GD(aiVar.field_username);
            au.HU();
            c.FQ().b(new com.tencent.mm.aq.d(aiVar.field_username, GD.field_msgSvrId));
            au.HU();
            c.FQ().b(new f(aiVar.field_username, 0));
            au.HU();
            c.FR().Ym(aiVar.field_username);
        }
        clF.close();
        au.HU();
        c.FT().GL("@bottle");
        au.HU();
        c.FW().clz();
        au.HU();
        c.FW().GL("floatbottle");
        com.tencent.mm.model.bd.Il();
        auk().dCZ.delete("bottleinfo1", null, null);
    }

    public final void bn(boolean z) {
        c.auf();
        au.HU();
        c.FW().b(this.dBJ);
    }

    public final void bo(boolean z) {
    }
}
