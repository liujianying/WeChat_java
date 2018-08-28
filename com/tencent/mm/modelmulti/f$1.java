package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import junit.framework.Assert;

class f$1 implements a {
    final /* synthetic */ f dZn;

    f$1(f fVar) {
        this.dZn = fVar;
    }

    public final boolean vD() {
        float f = 1.0f;
        if (!g.Eg().Dx() || com.tencent.mm.kernel.a.Dr()) {
            x.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
            return false;
        } else if (this.dZn.dZm) {
            x.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[]{Integer.valueOf(this.dZn.hashCode())});
            return false;
        } else if (this.dZn.dSN.isEmpty()) {
            x.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
            return false;
        } else {
            boolean z;
            x.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[]{Integer.valueOf(this.dZn.hashCode()), Long.valueOf(this.dZn.dYW.Ad()), Integer.valueOf(this.dZn.dSN.size()), Integer.valueOf(this.dZn.dZi), Boolean.valueOf(this.dZn.dZj), Integer.valueOf(this.dZn.dZl), Integer.valueOf(this.dZn.dZk)});
            g.Ek();
            long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
            c cVar = new c();
            cVar.bD("NetSceneInit");
            int i = this.dZn.dZj ? 40 : 10;
            int i2 = 0;
            while (i2 < i) {
                f.a aVar = (f.a) this.dZn.dSN.peek();
                if (aVar.dZr != Integer.MAX_VALUE) {
                    LinkedList linkedList = aVar.dZq.rYU;
                    if (linkedList != null && linkedList.size() > aVar.dTa) {
                        linkedList.size();
                        if (cVar.a((pm) linkedList.get(aVar.dTa), true)) {
                            aVar.dTa++;
                            f fVar = this.dZn;
                            fVar.dZl++;
                            i2++;
                        }
                    }
                    this.dZn.dSN.poll();
                    g.Ek();
                    g.Ei().DT().set(8197, bi.bE(ab.a(aVar.dZq.rYQ)));
                    g.Ek();
                    g.Ei().DT().set(8198, bi.bE(ab.a(aVar.dZq.rYR)));
                    g.Ek();
                    g.Ei().DT().set(16, Integer.valueOf(0));
                    g.Ek();
                    g.Ei().DT().set(8196, Long.valueOf((long) aVar.dZq.rYS));
                    g.Ek();
                    g.Ei().DT().lm(true);
                    z = true;
                    break;
                }
                boolean z2;
                String str = "in Queue tail , resp should be null";
                if (aVar.dZq == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assert.assertTrue(str, z2);
                g.Ek();
                String str2 = (String) g.Ei().DT().get(8198, null);
                g.Ek();
                g.Ei().DT().set(8195, str2);
                ad.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", str2).commit();
                g.Ek();
                g.Ei().DT().set(8197, "");
                g.Ek();
                g.Ei().DT().set(8198, "");
                g.Ek();
                g.Ei().DT().set(15, Integer.valueOf(1));
                g.Ek();
                g.Ei().DT().lm(true);
                x.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[]{Integer.valueOf(this.dZn.hashCode()), Long.valueOf(this.dZn.dYW.Ad()), Integer.valueOf(this.dZn.dZi), Integer.valueOf(this.dZn.dZk), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
                g.Em().H(new 1(this, aVar));
                z = false;
            }
            z = true;
            cVar.bE("NetSceneInit");
            g.Ek();
            g.Ei().dqq.gp(dO);
            f fVar2 = this.dZn;
            if (fVar2.dVg == null) {
                x.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
            } else {
                int i3 = fVar2.dZi > 50 ? 50 : fVar2.dZi;
                if (fVar2.dZj) {
                    float f2 = ((float) fVar2.dZl) / ((float) fVar2.dZk);
                    if (f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                    i2 = (int) ((((float) (100 - i3)) * f2) + ((float) i3));
                    f = f2;
                } else {
                    i2 = i3;
                }
                x.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[]{Integer.valueOf(fVar2.dZl), Integer.valueOf(fVar2.dZk), Float.valueOf(f), Integer.valueOf(i3)});
                fVar2.dVg.a(i2, 100, fVar2);
            }
            return z;
        }
    }
}
