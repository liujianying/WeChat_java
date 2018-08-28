package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.bt.f;
import com.tencent.mm.bt.g;
import com.tencent.mm.bt.h.a;
import com.tencent.mm.bt.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c hbq;

    c$2(c cVar) {
        this.hbq = cVar;
    }

    public final void Ea() {
        if (this.hbq.hbo != null) {
            g gVar = this.hbq.hbo;
            for (Object obj : gVar.tdJ.keySet()) {
                ((i) gVar.tdJ.get(obj)).cob();
            }
        }
    }

    public final void Eb() {
    }

    public final void Ec() {
        if (this.hbq.hbo != null) {
            g gVar = this.hbq.hbo;
            if (gVar.tdK.size() != 0) {
                x.i("MicroMsg.MemoryStorage", "attachTable begin stg:%s size:%d", new Object[]{"stg_null", Integer.valueOf(gVar.tdK.size())});
                if (gVar.tdk == null) {
                    x.e("MicroMsg.MemoryStorage", "attachTable db is null");
                } else if (gVar.tdH.inTransaction()) {
                    x.w("MicroMsg.MemoryStorage", "attachTable is in transcation ,give up attach table size:%d", new Object[]{Integer.valueOf(gVar.tdK.size())});
                } else {
                    while (gVar.tdK.size() > 0) {
                        if (gVar.tdH.inTransaction()) {
                            x.w("MicroMsg.MemoryStorage", "attachTable is in transcation , break attach table size:%d", new Object[]{Integer.valueOf(gVar.tdK.size())});
                            return;
                        }
                        g.a aVar = (g.a) gVar.tdK.peek();
                        if (aVar == null) {
                            gVar.tdK.poll();
                        } else {
                            String tableName = aVar.getTableName();
                            if (bi.oW(tableName)) {
                                x.e("MicroMsg.MemoryStorage", "attachTable Error table Name :%s", new Object[]{tableName});
                                gVar.tdK.poll();
                            } else if (f.a(gVar.tdk, tableName)) {
                                x.e("MicroMsg.MemoryStorage", "attachTable Error Attach table twice :%s", new Object[]{tableName});
                                gVar.tdK.poll();
                            } else {
                                if (gVar.ZK(tableName) != 0) {
                                    try {
                                        if (gVar.qAy) {
                                            gVar.tdk.execSQL("DETACH DATABASE old");
                                            x.i("MicroMsg.MemoryStorage", "DETACH DATABASE ");
                                            gVar.qAy = false;
                                        }
                                        if (bi.oW(gVar.tdH.getKey())) {
                                            gVar.tdk.execSQL("ATTACH DATABASE '" + gVar.tdH.getPath() + "' AS old ");
                                        } else {
                                            gVar.tdk.execSQL("ATTACH DATABASE '" + gVar.tdH.getPath() + "' AS old KEY '" + gVar.tdH.getKey() + "'");
                                        }
                                        x.i("MicroMsg.MemoryStorage", "ATTACH DATABASE ");
                                        gVar.qAy = true;
                                    } catch (Throwable e) {
                                        gVar.qAy = false;
                                        x.e("MicroMsg.MemoryStorage", "ERROR : attach disk db [%s] , will do again !", new Object[]{e.getMessage()});
                                        x.e("MicroMsg.MemoryStorage", "exception:%s", new Object[]{bi.i(e)});
                                    }
                                    if (gVar.ZK(tableName) != 0) {
                                        x.e("MicroMsg.MemoryStorage", "copy table failed :" + tableName);
                                        return;
                                    }
                                }
                                x.i("MicroMsg.MemoryStorage", "attachTable %s succ , waitsize:%d finsize:%d", new Object[]{tableName, Integer.valueOf(gVar.tdK.size()), Integer.valueOf(gVar.tdJ.size())});
                                gVar.tdJ.put(tableName, new i(gVar.tdH, tableName));
                                aVar.a(gVar);
                                gVar.tdK.poll();
                            }
                        }
                    }
                }
            }
        }
    }
}
