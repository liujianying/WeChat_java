package com.tencent.mm.plugin.fav.a;

import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.protocal.c.wt;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;

class aj$a {
    LinkedList<pm> iWX;
    ag iWY = new ag(g.Em().lnJ.getLooper()) {
        public final void handleMessage(Message message) {
            if (aj$a.this.iWX == null || aj$a.this.iWX.isEmpty()) {
                aj ajVar = aj$a.this.iWZ;
                ws wsVar = (ws) ajVar.diG.dID.dIL;
                wt wtVar = (wt) ajVar.diG.dIE.dIL;
                byte[] g = z.g(wsVar.rny.siK.toByteArray(), wtVar.rny.siK.toByteArray());
                if (g != null && g.length > 0) {
                    ((ae) g.n(ae.class)).getFavConfigStorage().aw(g);
                }
                wsVar.rny = ab.O(g);
                if ((wsVar.rnx & wtVar.rlm) == 0) {
                    x.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[]{Long.valueOf(ajVar.iWV)});
                    g.Ei().DT().set(8217, Integer.valueOf(1));
                    if (ajVar.iWV > 0) {
                        LinkedList t = ((ae) g.n(ae.class)).getFavItemInfoStorage().t(ajVar.iWV, -1);
                        if (t.size() > 0) {
                            if (t.size() > 40) {
                                Collection subList = t.subList(0, 40);
                                t = new LinkedList();
                                t.addAll(subList);
                            }
                            ajVar.iWW = true;
                            x.i("MicroMsg.Fav.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[]{Integer.valueOf(t.size())});
                            if (!g.DF().a(new ah(t), 0)) {
                                x.w("MicroMsg.Fav.NetSceneFavSync", "do scene BatchGetFav fail");
                                ah.aLM();
                            }
                        }
                    }
                    ajVar.diJ.a(0, 0, "", ajVar);
                    return;
                }
                x.i("MicroMsg.Fav.NetSceneFavSync", "continue flag:%d", new Object[]{Integer.valueOf(wtVar.rlm)});
                ajVar.a(ajVar.dIX, ajVar.diJ);
                return;
            }
            pm pmVar = (pm) aj$a.this.iWX.getFirst();
            x.d("MicroMsg.Fav.NetSceneFavSync", "cmdId = " + pmVar.rtM);
            aj$a.this.iWX.removeFirst();
            switch (pmVar.rtM) {
                case 200:
                    byte[] a = ab.a(pmVar.rtN);
                    if (a == null) {
                        x.e("MicroMsg.Fav.NetSceneFavSync", "docmd: no protobuf found.");
                        sendEmptyMessage(0);
                        return;
                    }
                    aj ajVar2 = aj$a.this.iWZ;
                    try {
                        int length;
                        String str = "MicroMsg.Fav.NetSceneFavSync";
                        String str2 = "processAddItem bufSize=%d";
                        Object[] objArr = new Object[1];
                        if (a != null) {
                            length = a.length;
                        } else {
                            length = 0;
                        }
                        objArr[0] = Integer.valueOf(length);
                        x.i(str, str2, objArr);
                        bt btVar = (bt) new bt().aG(a);
                        if (btVar == null) {
                            x.e("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem favitem null");
                        } else {
                            x.i("MicroMsg.Fav.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[]{Integer.valueOf(btVar.rbY), Integer.valueOf(btVar.rbZ), Integer.valueOf(btVar.rcb), Integer.valueOf(btVar.rca)});
                            if ((btVar.rbZ & 1) != 0) {
                                b.a(((ae) g.n(ae.class)).getFavItemInfoStorage().dz((long) btVar.rbY), false, null);
                            } else {
                                boolean z;
                                if (ajVar2.iWV < 0 || ((long) btVar.rca) < ajVar2.iWV) {
                                    ajVar2.iWV = (long) btVar.rca;
                                }
                                g dz = ((ae) g.n(ae.class)).getFavItemInfoStorage().dz((long) btVar.rbY);
                                if (dz == null) {
                                    dz = new g();
                                    dz.field_updateTime = ((long) btVar.rca) * 1000;
                                    z = true;
                                } else {
                                    z = false;
                                }
                                dz.field_id = btVar.rbY;
                                dz.field_updateSeq = btVar.rcb;
                                if (dz.field_localSeq == btVar.rcb) {
                                    dz.field_updateTime = ((long) btVar.rca) * 1000;
                                }
                                dz.field_flag = btVar.rbZ;
                                dz.field_type = btVar.hcE;
                                if (z) {
                                    dz.field_localId = System.currentTimeMillis();
                                    ((ae) g.n(ae.class)).getFavItemInfoStorage().y(dz);
                                } else {
                                    ((ae) g.n(ae.class)).getFavItemInfoStorage().a(dz, new String[]{"localId"});
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Fav.NetSceneFavSync", e, "", new Object[0]);
                    }
                    sendEmptyMessage(0);
                    return;
                default:
                    return;
            }
        }
    };
    final /* synthetic */ aj iWZ;

    aj$a(aj ajVar) {
        this.iWZ = ajVar;
    }
}
