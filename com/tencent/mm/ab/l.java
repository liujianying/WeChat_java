package com.tencent.mm.ab;

import com.tencent.mm.model.bh;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public abstract class l {
    public boolean aBS = false;
    public e dIX;
    public long dIY = bi.VG();
    public int dIZ = -1;
    private r dJa;
    e dJb;
    public boolean dJc;
    public q dJd;
    private int limit = -99;
    int priority = 0;

    /* renamed from: com.tencent.mm.ab.l$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] dJh = new int[b.Lc().length];

        static {
            try {
                dJh[b.dJl - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dJh[b.dJn - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dJh[b.dJm - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected enum a {
        EStatusCheckFailed,
        EReachMaxLimit
    }

    protected enum b {
        ;

        public static int[] Lc() {
            return (int[]) dJo.clone();
        }

        static {
            dJl = 1;
            dJm = 2;
            dJn = 3;
            dJo = new int[]{dJl, dJm, dJn};
        }
    }

    public abstract int a(e eVar, e eVar2);

    public abstract int getType();

    public final void reset() {
        this.dIY = bi.VG();
        this.dIZ = -1;
        this.limit = -99;
    }

    public void a(a aVar) {
    }

    public int a(q qVar) {
        return b.dJl;
    }

    public boolean KX() {
        return false;
    }

    public int Cc() {
        return 1;
    }

    public boolean KY() {
        return this.limit <= 0;
    }

    public boolean KZ() {
        return false;
    }

    public final void c(e eVar) {
        this.dIY = bi.VG();
        this.dIX = eVar;
    }

    public boolean La() {
        return Cc() == 1;
    }

    public int a(e eVar, final q qVar, k kVar) {
        c(eVar);
        this.dJd = qVar;
        final k a = bh.a(kVar);
        if (this.limit == -99) {
            this.limit = Cc();
            x.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.limit);
        }
        if (Cc() > 1) {
            switch (AnonymousClass2.dJh[a(qVar) - 1]) {
                case 1:
                    Assert.assertTrue("scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri() + ", CHECK NOW", false);
                    break;
                case 2:
                    x.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri());
                    this.limit--;
                    a(a.EStatusCheckFailed);
                    this.dIZ = -1;
                    return this.dIZ;
                case 3:
                    break;
                default:
                    Assert.assertTrue("invalid security verification status", false);
                    break;
            }
        }
        if (KY()) {
            x.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + Cc());
            a(a.EReachMaxLimit);
            this.dIZ = -1;
            return this.dIZ;
        }
        this.limit--;
        r tVar = new t(qVar);
        if (!(this.dJa == null || KZ())) {
            this.dJa.cancel();
        }
        this.dJa = new r(qVar, a, this, this.dJb, eVar);
        this.dIZ = eVar.a(tVar, this.dJa);
        x.i("MicroMsg.NetSceneBase", "dispatcher send, %s", Integer.valueOf(this.dIZ));
        if (this.dIZ < 0) {
            x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.dIZ), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
            new ag().post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(l.this.dIZ), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                    a.a(-1, 3, -1, "send to network failed", qVar, null);
                    x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(l.this.dIZ), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                }
            });
            return 99999999;
        }
        r rVar = this.dJa;
        rVar.handler.postDelayed(rVar.dJQ, 330000);
        return this.dIZ;
    }

    public final int Lb() {
        return this.dJd == null ? 0 : this.dJd.hashCode();
    }

    public void cancel() {
        x.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", Integer.valueOf(this.dIZ), Integer.valueOf(hashCode()), Integer.valueOf(getType()));
        this.aBS = true;
        if (this.dJa != null) {
            this.dJa.cancel();
        }
        if (this.dIZ != -1 && this.dIX != null) {
            int i = this.dIZ;
            this.dIZ = -1;
            this.dIX.cancel(i);
        }
    }

    public boolean a(l lVar) {
        return false;
    }

    public boolean b(l lVar) {
        return false;
    }

    public String getInfo() {
        return "";
    }
}
