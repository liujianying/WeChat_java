package com.tencent.mm.plugin.fav.b.d;

import android.os.SystemClock;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.u;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class c implements e, u {
    public Map<String, a> iXL = new HashMap();

    static /* synthetic */ void a(a aVar, boolean z) {
        aVar.retryCount--;
        if (aVar.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - aVar.time < 7200000) {
                x.i("MicroMsg.Fav.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", new Object[]{Integer.valueOf(aVar.iXb), Long.valueOf(aVar.iXc.field_localId), Integer.valueOf(aVar.iXc.field_type)});
                return;
            }
            aVar.time = SystemClock.elapsedRealtime();
            aVar.retryCount = 3;
        }
        if (aVar.iXb <= 0) {
            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(aVar.iXc.field_localId);
            if (dy == null || dy.field_id <= 0) {
                x.w("MicroMsg.Fav.FavEditService", "want to start mod item, but favid is invalid, local id %d", new Object[]{Long.valueOf(aVar.iXc.field_localId)});
                return;
            }
            aVar.iXb = dy.field_id;
            x.i("MicroMsg.Fav.FavEditService", "want mod item, find id %d by local id %d", new Object[]{Integer.valueOf(aVar.iXb), Long.valueOf(aVar.iXc.field_localId)});
        } else if (!z) {
            x.w("MicroMsg.Fav.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", new Object[]{Integer.valueOf(aVar.iXb)});
            return;
        }
        x.i("MicroMsg.Fav.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(aVar.iXb), Integer.valueOf(aVar.iXc.field_type)});
        com.tencent.mm.kernel.g.DF().a(new al(aVar.iXb, aVar.iXc), 0);
    }

    public c() {
        com.tencent.mm.kernel.g.DF().a(426, this);
        com.tencent.mm.kernel.g.DF().a(401, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar != null) {
            x.i("MicroMsg.Fav.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(lVar.getType())});
            if (lVar.getType() == 401) {
                x.i("MicroMsg.Fav.FavEditService", "on add fav item scene end, try mod item");
                run();
                return;
            }
            al alVar = (al) lVar;
            if (alVar.type == 0) {
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.Fav.FavEditService", "clear job, key %s", new Object[]{v(alVar.aLO(), alVar.aLP())});
                this.iXL.remove(r0);
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavEditInfoStorage().q(alVar.aLO(), alVar.aLP());
                g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(alVar.aLO());
                if (dy != null) {
                    h.g((long) dy.field_id, dy.field_tagProto.rBX.size(), alVar.iXc == null ? 1 : alVar.iXc.field_scene);
                    return;
                }
                return;
            }
            x.i("MicroMsg.Fav.FavEditService", "retry job, key %s", new Object[]{v(alVar.aLO(), alVar.aLP())});
            a aVar = (a) this.iXL.get(r0);
            if (aVar == null) {
                x.w("MicroMsg.Fav.FavEditService", "want to retry mod item, localid %d, type %d", new Object[]{Long.valueOf(r2), Integer.valueOf(r4)});
            } else {
                com.tencent.mm.kernel.g.Em().h(new 2(this, aVar), 3000);
            }
        }
    }

    public final void run() {
        com.tencent.mm.kernel.g.Em().H(new 1(this));
    }

    public static String v(long j, int i) {
        return j + "&&" + i;
    }

    public final void a(long j, LinkedList<auj> linkedList, LinkedList<aum> linkedList2, int i) {
        f fVar;
        int i2;
        x.i("MicroMsg.Fav.FavEditService", "addTag %d", new Object[]{Long.valueOf(j)});
        f dx = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavEditInfoStorage().dx(j);
        if (dx == null) {
            fVar = new f();
            i2 = 1;
        } else {
            fVar = dx;
            i2 = 0;
        }
        fVar.field_localId = j;
        wb wbVar = new wb();
        wbVar.iXe = linkedList;
        wbVar.rBr = linkedList2;
        fVar.field_modItem = wbVar;
        fVar.field_time = bi.VF();
        fVar.field_type = 0;
        fVar.field_scene = i;
        if (i2 != 0) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavEditInfoStorage().a(fVar);
        } else {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavEditInfoStorage().a(fVar, new String[]{"localId"});
        }
        run();
    }
}
