package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements e {
    private static a knO = null;
    private boolean dFt = false;
    private long knK = -1;
    private long knL = -1;
    private long knM = -1;
    private long knN = -1;

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
        aVar.knM = System.currentTimeMillis();
        ArrayList aXX = i.aXv().aXX();
        if (aXX != null && aXX.size() > 0) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", new Object[]{Integer.valueOf(aXX.size())});
            long dO = i.aXv().dO(Thread.currentThread().getId());
            Iterator it = aXX.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                String Fl = com.tencent.mm.plugin.ipcall.b.a.Fl(cVar.field_contactId);
                if (cVar.sKx > 0 && !bi.oW(Fl)) {
                    x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", new Object[]{cVar.field_contactId, Fl, cVar.field_wechatUsername});
                    if ((!bi.oW(cVar.field_wechatUsername) && !cVar.field_wechatUsername.equals(Fl)) || bi.oW(cVar.field_wechatUsername)) {
                        cVar.field_wechatUsername = Fl;
                        i.aXv().a(cVar.sKx, cVar);
                    }
                }
            }
            i.aXv().dP(dO);
        }
        aVar.knN = System.currentTimeMillis();
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", new Object[]{Long.valueOf(aVar.knN - aVar.knM)});
        aVar.dFt = false;
        aWG();
    }

    private a() {
    }

    public static a aWF() {
        if (knO == null) {
            knO = new a();
        }
        return knO;
    }

    public final void Vk() {
        if (!com.tencent.mm.plugin.ipcall.b.a.XF()) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.dFt) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        if (Math.abs(currentTimeMillis - ((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sQT, Long.valueOf(0))).longValue()) >= 86400000) {
            this.dFt = true;
            this.knK = -1;
            this.knL = -1;
            this.knM = -1;
            this.knN = -1;
            au.DF().a(32, this);
            com.tencent.mm.sdk.f.e.post(new 1(this), "IPCallAddressBookUpdater_updateUsername");
            return;
        }
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.dFt)});
        if (this.dFt) {
            au.DF().b(32, this);
            this.knL = System.currentTimeMillis();
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[]{Long.valueOf(this.knL - this.knK)});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        a.a(a.this);
                    }
                }, "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
                return;
            }
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
            this.dFt = false;
            aWG();
        }
    }

    private static void aWG() {
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        com.tencent.mm.model.c.DT().a(com.tencent.mm.storage.aa.a.sQT, Long.valueOf(currentTimeMillis));
    }
}
