package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.p;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class d implements e, ar {
    ConcurrentHashMap<Integer, t> kYg = new ConcurrentHashMap();
    private boolean kYh = false;
    private a kYi = new 1(this);
    private a kYj = new 2(this);
    private ag mHandler = new ag(Looper.getMainLooper());

    public static d bbJ() {
        return (d) p.v(d.class);
    }

    public final t sq(int i) {
        Object obj = null;
        if (!this.kYg.contains(Integer.valueOf(i))) {
            com.tencent.mm.plugin.wallet_core.d.e bPb = o.bPb();
            String str = "select * from WalletFunciontList where wallet_region = " + i;
            Cursor b = bPb.diF.b(str, null, 2);
            x.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo " + str);
            if (b != null) {
                if (b.moveToNext()) {
                    obj = new t();
                    obj.d(b);
                }
                b.close();
            }
            if (obj != null) {
                this.kYg.put(Integer.valueOf(i), obj);
            }
        }
        t tVar = (t) this.kYg.get(Integer.valueOf(i));
        if (tVar == null) {
            return new t();
        }
        return tVar;
    }

    public final ArrayList<MallFunction> sr(int i) {
        return sq(i).kXY;
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("mallactivity", this.kYi, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a("paymsg", this.kYj, true);
        c.bPK().Wj();
        com.tencent.mm.plugin.wallet_core.model.mall.d.bPO().Wj();
        if (q.GS() && q.GO()) {
            b.zn(b.prZ);
        } else {
            b.zn(b.prY);
        }
        g.Ek();
        g.Eh().dpP.a(302, this);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("mallactivity", this.kYi, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b("paymsg", this.kYj, true);
        g.Ek();
        g.Eh().dpP.b(302, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i2 == 0 && i == 0 && !this.kYh && q.GS()) {
            this.kYh = true;
            b.zn(b.prZ);
        }
    }
}
