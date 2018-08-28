package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.s;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Queue;

class p$e extends l implements c, k {
    private q dJM;
    e eaJ;
    boolean eaK;
    private boolean eaL = false;
    final /* synthetic */ p eay;
    int scene;
    int selector;

    public final boolean c(Queue<c> queue) {
        String str;
        String str2 = "MicroMsg.SyncService";
        String str3 = "%s begin run scene:%s selector:%s isContinue:%s List:%s";
        Object[] objArr = new Object[5];
        objArr[0] = this;
        objArr[1] = Integer.valueOf(this.scene);
        objArr[2] = Integer.valueOf(this.selector);
        objArr[3] = Boolean.valueOf(this.eaK);
        if (queue == null) {
            str = "null";
        } else {
            str = Integer.valueOf(queue.size());
        }
        objArr[4] = str;
        x.i(str2, str3, objArr);
        if (queue != null) {
            p.b(queue);
            boolean z = false;
            boolean z2 = false;
            while (!queue.isEmpty()) {
                p$e p_e = (p$e) queue.poll();
                this.selector |= p_e.selector;
                if (p_e.scene == 3) {
                    z = true;
                } else if (p_e.eaK) {
                    z2 = true;
                }
                x.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", new Object[]{this, Integer.valueOf(queue.size()), p_e, Integer.valueOf(p_e.scene), Integer.valueOf(p_e.selector), Boolean.valueOf(p_e.eaK), Boolean.valueOf(z2), Boolean.valueOf(z)});
            }
            if (z) {
                this.scene = 3;
            } else if (z2) {
                this.scene = 6;
            }
        }
        if (g.Eg().Dx() && !a.Dr()) {
            g.Ek();
            if (g.Ei() != null) {
                g.Ek();
                if (g.Ei().DT() != null) {
                    g.Ek();
                    long a = bi.a((Long) g.Ei().DT().get(8196, null), 0);
                    if (a != 0) {
                        g.Ek();
                        g.Ei().DT().set(8196, Long.valueOf(0));
                        this.selector = (int) (((long) this.selector) | a);
                        this.selector &= 95;
                    }
                    int i = this.scene == 3 ? 1 : 0;
                    if (this.scene == 1010) {
                        this.selector |= 16;
                        this.scene = 7;
                    } else if (this.scene == 1011) {
                        this.selector |= 64;
                        this.scene = 7;
                    } else if (this.scene == 3) {
                        this.selector |= 262144;
                        this.scene = 3;
                    }
                    if (this.eaK) {
                        this.scene = 6;
                    }
                    this.dJM = new k.a();
                    awd awd = ((s.a) this.dJM.KV()).qWW;
                    awd.rZw = i;
                    awd.rnx = this.selector;
                    awd.otY = this.scene;
                    g.Ek();
                    awd.rny = ab.O(bi.WP(bi.oV((String) g.Ei().DT().get(8195, new byte[0]))));
                    awd.rZv = new pn();
                    awd.reT = d.DEVICE_TYPE;
                    x.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", new Object[]{this, Long.valueOf(a), Integer.valueOf(awd.rZw), Integer.valueOf(awd.rnx), Integer.valueOf(this.scene), awd.reT});
                    x.i("MicroMsg.SyncService", "%s Req synckey %s", new Object[]{this, z.bp(bi.WP(str))});
                    p.a(this);
                    g.Ek();
                    if (g.Eh().dpP.a(this, 0)) {
                        return true;
                    }
                    f.mDy.h(11098, new Object[]{Integer.valueOf(3500), this.scene + ";" + b.foreground + ";" + p.PQ()});
                    x.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", new Object[]{this});
                    f.mDy.a(99, 41, 1, false);
                    return false;
                }
            }
        }
        Object[] objArr2 = new Object[4];
        objArr2[0] = this;
        objArr2[1] = Boolean.valueOf(g.Eg().Dx());
        objArr2[2] = Boolean.valueOf(a.Dr());
        g.Ek();
        objArr2[3] = g.Ei();
        x.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", objArr2);
        return false;
    }

    public final String toString() {
        return "NetSync[" + hashCode() + "]";
    }

    public p$e(p pVar, int i, int i2, boolean z) {
        this.eay = pVar;
        this.scene = i;
        this.selector = i2;
        this.eaK = z;
    }

    public final int getType() {
        return 138;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.eaJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final boolean La() {
        return false;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            f.mDy.a(99, 44, 1, false);
            String str2 = "MicroMsg.SyncService";
            String str3 = "%s onGYNetEnd error type:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this;
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[1] = Integer.valueOf(i4);
            x.e(str2, str3, objArr);
        } else if (this.eaL) {
            x.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", new Object[]{this});
        } else {
            boolean z;
            int cij;
            this.eaL = true;
            p.F("Check rr failed.", qVar == this.dJM);
            if (i2 == 0 && i3 == 0) {
                z = true;
            } else {
                x.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), str, qVar});
                if (i2 == 4 && i3 == -2006) {
                    x.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", new Object[]{this});
                    f.mDy.a(99, 42, 1, false);
                    z = false;
                } else {
                    f.mDy.h(11098, new Object[]{Integer.valueOf(3501), this.scene + ";" + i2 + ";" + i3 + ";" + b.foreground + ";" + p.PQ()});
                    f.mDy.a(99, 43, 1, false);
                    this.eaJ.a(i2, i3, str, this);
                    p.a(this.eay, this);
                    return;
                }
            }
            awe awe = ((s.b) qVar.Id()).qWX;
            boolean z2 = HardCoderJNI.hcReceiveMsgEnable;
            int i5 = HardCoderJNI.hcReceiveMsgDelay;
            int i6 = HardCoderJNI.hcReceiveMsgCPU;
            int i7 = HardCoderJNI.hcReceiveMsgIO;
            if (HardCoderJNI.hcReceiveMsgThr) {
                cij = g.Em().cij();
            } else {
                cij = 0;
            }
            i5 = HardCoderJNI.startPerformance(z2, i5, i6, i7, cij, HardCoderJNI.hcReceiveMsgTimeout, av.CTRL_INDEX, HardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
            final awe awe2 = awe;
            p.a aVar = new p.a(this.eay, this, z, awe, new p.b() {
                public final boolean ie(int i) {
                    g.Ek();
                    g.Ei().DT().set(8196, Long.valueOf((long) awe2.rlm));
                    boolean z = (awe2.rlm & p$e.this.selector) != 0;
                    x.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s", new Object[]{p$e.this, Integer.valueOf(awe2.rlm), Boolean.valueOf(z), Integer.valueOf(awe2.rlm & 256)});
                    if (!(z || (awe2.rlm & 256) == 0)) {
                        com.tencent.mm.sdk.b.a.sFg.m(new ql());
                    }
                    if (!(z || (awe2.rlm & 2097152) == 0)) {
                        com.tencent.mm.sdk.b.a.sFg.m(new li());
                    }
                    if (z) {
                        if (i == 0 && p$e.this.eaK) {
                            x.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", new Object[]{p$e.this});
                        } else {
                            p.a(p$e.this.eay, p$e.this.scene, p$e.this.selector);
                        }
                    }
                    p$e.this.eaJ.a(0, 0, "", p$e.this);
                    p.a(p$e.this.eay, p$e.this);
                    HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, i5);
                    return true;
                }
            }, (byte) 0);
        }
    }
}
