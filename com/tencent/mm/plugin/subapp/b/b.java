package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements d, e {
    private Queue<a> ora = null;
    private boolean orb = false;

    public final com.tencent.mm.ab.d.b b(a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (this.ora == null) {
            this.ora = new LinkedList();
        }
        a aVar2 = new a(a);
        if (aVar2.eEj != null) {
            this.ora.offer(aVar2);
            bGr();
        }
        return null;
    }

    private void bGr() {
        if (!this.orb && this.ora.size() != 0) {
            a aVar = (a) this.ora.peek();
            if (aVar.orc.size() == 0) {
                this.ora.poll();
                au.HU();
                c.DT().set(8193, aVar.eEj);
                au.HU();
                c.DT().set(8449, Long.valueOf(bi.VE()));
                return;
            }
            String str = (String) aVar.orc.peek();
            if (str != null && str.length() > 0) {
                this.orb = true;
                a aVar2 = new a(str);
                au.DF().a(141, this);
                au.DF().a(aVar2, 0);
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() != 141) {
            this.orb = false;
            return;
        }
        au.DF().b(141, this);
        String str2 = ((a) lVar).url;
        a aVar = (a) this.ora.peek();
        if (aVar == null || aVar.orc.size() == 0) {
            x.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
            this.ora = new LinkedList();
            this.orb = false;
        } else if (aVar.orc.size() == 0) {
            x.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
            this.ora.poll();
            this.orb = false;
        } else if (!((String) aVar.orc.peek()).equals(str2)) {
            x.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
            this.ora.poll();
            this.orb = false;
        } else if (i == 0 && i2 == 0) {
            aVar.orc.poll();
            this.orb = false;
            bGr();
        } else {
            x.e("MicroMsg.PushMessageExtension", "down failed [" + i + "," + i2 + "] ignore this message : img:[" + str2 + "] ");
            this.ora.poll();
            this.orb = false;
        }
    }

    public final void h(bd bdVar) {
    }
}
