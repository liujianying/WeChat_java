package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.ah.a;
import com.tencent.mm.ui.chatting.viewitems.ah.b;
import com.tencent.mm.ui.chatting.viewitems.an.f;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import com.tencent.mm.ui.chatting.viewitems.c.e;
import com.tencent.mm.ui.chatting.viewitems.p.j;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.List;

public final class av {
    private static final List<b> ufG;

    public static b bE(bd bdVar) {
        for (b bVar : ufG) {
            if (bVar.aq(bdVar.getType(), bdVar.field_isSend == 1)) {
                try {
                    return (b) bVar.getClass().newInstance();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Chatting.ItemFactory", e, "", new Object[0]);
                }
            }
        }
        return new a();
    }

    public static int cxT() {
        return ufG.size() + 2;
    }

    public static int bF(bd bdVar) {
        if (bdVar.getType() == 49) {
            int d = l.d(g.a.gp(bdVar.field_content));
            x.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", new Object[]{Integer.valueOf(d)});
            if (d != 49) {
                bdVar.setType(d);
                au.HU();
                c.FT().a(bdVar.field_msgId, bdVar);
            }
        }
        for (int i = 0; i < ufG.size(); i++) {
            if (((b) ufG.get(i)).aq(bdVar.getType(), bdVar.field_isSend == 1)) {
                return i;
            }
        }
        return 0;
    }

    static {
        List arrayList = new ArrayList();
        ufG = arrayList;
        arrayList.add(new b());
        ufG.add(new a());
        ufG.add(new e());
        ufG.add(new d());
        ufG.add(new j.c());
        ufG.add(new j.b());
        ufG.add(new m$c());
        ufG.add(new m.b());
        ufG.add(new i.d());
        ufG.add(new i.c());
        ufG.add(new ae());
        ufG.add(new z.b());
        ufG.add(new u.b());
        ufG.add(new u.a());
        ufG.add(new aj$a());
        ufG.add(new aj.b());
        ufG.add(new ab$a());
        ufG.add(new q.c());
        ufG.add(new q.b());
        ufG.add(new v.a());
        ufG.add(new ai$b());
        ufG.add(new ai.a());
        ufG.add(new aa$b());
        ufG.add(new aa$a());
        ufG.add(new f());
        ufG.add(new an.c());
        ufG.add(new an.g());
        ufG.add(new j());
        ufG.add(new an.d());
        ufG.add(new an.e());
        ufG.add(new am());
        ufG.add(new ak());
        ufG.add(new al());
        ufG.add(new ad.a());
        ufG.add(new ad.b());
        ufG.add(new ao.c());
        ufG.add(new ao.b());
        ufG.add(new s());
        ufG.add(new k$b());
        ufG.add(new k$c());
        ufG.add(new w());
        ufG.add(new x());
        ufG.add(new y());
        ufG.add(new l.c());
        ufG.add(new l$b());
        ufG.add(new d$c());
        ufG.add(new d$b());
        ufG.add(new h.c());
        ufG.add(new h.b());
        ufG.add(new f$c());
        ufG.add(new f$b());
        ufG.add(new g.c());
        ufG.add(new g.b());
        ufG.add(new n.b());
        ufG.add(new n.a());
        ufG.add(new o.b());
        ufG.add(new o.a());
        ufG.add(new z.a());
        ufG.add(new e.c());
        ufG.add(new e$b());
        ufG.add(new 1());
        ufG.add(new 2());
    }
}
