package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static c kog = new 1();

    static /* synthetic */ void vg() {
        try {
            if (au.HX()) {
                x.d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.ipcall.a.g.b bVar = new com.tencent.mm.plugin.ipcall.a.g.b();
                ArrayList aXX = i.aXv().aXX();
                if (aXX != null && aXX.size() > 0) {
                    HashMap aXW = com.tencent.mm.plugin.ipcall.a.g.b.aXW();
                    if (aXW != null && aXW.size() >= 0) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar;
                        long dO = i.aXv().dO(Thread.currentThread().getId());
                        x.d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                        x.d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", new Object[]{Integer.valueOf(aXX.size())});
                        Iterator it = aXX.iterator();
                        while (it.hasNext()) {
                            cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                            if (!aXW.containsKey(cVar.field_contactId)) {
                                long j = cVar.sKx;
                                i.aXv().delete(j);
                                x.d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", new Object[]{Long.valueOf(j)});
                                Cursor dQ = i.aXw().dQ(j);
                                if (dQ != null) {
                                    try {
                                        if (dQ.moveToFirst()) {
                                            while (!dQ.isAfterLast()) {
                                                k kVar = new k();
                                                kVar.d(dQ);
                                                kVar.field_addressId = -1;
                                                kVar.field_phoneType = -1;
                                                i.aXw().a(kVar);
                                                dQ.moveToNext();
                                            }
                                        }
                                    } catch (Exception e) {
                                        x.e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", new Object[]{e.getMessage()});
                                        if (dQ != null) {
                                            dQ.close();
                                        } else {
                                            continue;
                                        }
                                    } catch (Throwable th) {
                                        if (dQ != null) {
                                            dQ.close();
                                        }
                                    }
                                }
                                if (dQ != null) {
                                    dQ.close();
                                }
                            }
                        }
                        x.d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                        for (com.tencent.mm.plugin.ipcall.a.g.c cVar2 : aXW.values()) {
                            com.tencent.mm.plugin.ipcall.a.g.c EP = i.aXv().EP(cVar2.field_contactId);
                            if (EP == null || EP.sKx == -1) {
                                i.aXv().b(cVar2);
                            } else {
                                Object obj = (cVar2 != null && com.tencent.mm.plugin.ipcall.a.g.c.dq(EP.field_contactId, cVar2.field_contactId) && com.tencent.mm.plugin.ipcall.a.g.c.dq(EP.field_systemAddressBookUsername, cVar2.field_systemAddressBookUsername) && com.tencent.mm.plugin.ipcall.a.g.c.dq(EP.field_wechatUsername, cVar2.field_wechatUsername)) ? 1 : null;
                                if (obj == null) {
                                    i.aXv().a(EP.sKx, cVar2);
                                }
                            }
                        }
                        i.aXv().dP(dO);
                        x.d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return;
                    }
                    return;
                }
                return;
            }
            x.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
        } catch (Exception e2) {
            x.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e2.getMessage());
        }
    }

    public static void init() {
        a.sFg.b(kog);
    }

    public static void release() {
        a.sFg.c(kog);
    }
}
