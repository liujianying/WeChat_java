package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends b implements e {
    private static int mXk = 0;
    private float cXm = -85.0f;
    private float cXn = -1000.0f;
    private a cXs = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            if (g.this.cXm == -85.0f && g.this.cXn == -1000.0f) {
                g.this.cXm = f2;
                g.this.cXn = f;
                m.buI().cXm = g.this.cXm;
                m.buI().cXn = g.this.cXn;
                if (g.this.mXH) {
                    x.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
                    g.this.buM();
                }
            }
            return false;
        }
    };
    private c dMm;
    public String fHA = "";
    public int hop = 0;
    public int hwF;
    private boolean jOf = false;
    private ag mHandler = new ag();
    private c mXF;
    private e mXG = new e();
    private boolean mXH = false;
    private long mXl = 0;

    public g(l.a aVar) {
        super(aVar);
    }

    public final void init() {
        mXk = m.buI().mXk;
        this.mXl = m.buI().mXl;
        this.cXm = m.buI().cXm;
        this.cXn = m.buI().cXn;
        au.DF().a(1250, this);
        buo();
    }

    public final void reset() {
        if (this.mXF != null) {
            au.DF().c(this.mXF);
        }
    }

    public final void start() {
        init();
        reset();
        if (this.dMm == null) {
            buo();
        }
        this.dMm.b(this.cXs, true);
        d buI = m.buI();
        CharSequence charSequence = "key_shake_card_item";
        Object obj = (TextUtils.isEmpty(charSequence) || !buI.htT.containsKey(charSequence)) ? null : buI.htT.get(charSequence);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - this.mXl;
        if (obj == null || !(obj instanceof e)) {
            boolean z;
            if (this.mXl == 0) {
                z = true;
            } else if (currentTimeMillis >= 0) {
                z = true;
            } else {
                h.mEJ.h(11666, new Object[]{Integer.valueOf(this.hop)});
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        g.this.mXG.hwF = 3;
                        g.this.hwF = g.this.mXG.hwF;
                        g.this.mXG.mXr = m.buI().mXm;
                        if (g.this.mWQ != null) {
                            g.this.mWQ.a(1250, g.this.mXG, 2);
                        }
                    }
                }, 3000);
                x.i("MicroMsg.ShakeCardService", "ShakeCardService do not doNetSceneShakeCard, because time is not expire");
                z = false;
            }
            if (!z) {
                return;
            }
            if (this.jOf) {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService is doing netscene, return");
                return;
            } else if (this.cXm == -85.0f || this.cXn == -1000.0f) {
                this.mXH = true;
                x.i("MicroMsg.ShakeCardService", "ShakeCardService location is not geted, wait 4 second");
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        if (!g.this.jOf) {
                            g.this.buM();
                        }
                    }
                }, 4000);
                return;
            } else {
                buM();
                return;
            }
        }
        this.mWQ.a(1250, (e) obj, 1);
        m.buI().putValue("key_shake_card_item", null);
        x.i("MicroMsg.ShakeCardService", "getlbscard return data is no empty, don't do doNetSceneShakeCard, return ok");
    }

    private void buM() {
        if (this.jOf) {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService is doing doNetSceneShakeCard, return");
            return;
        }
        this.jOf = true;
        this.mXH = false;
        x.i("MicroMsg.ShakeCardService", "ShakeCardService do doNetSceneShakeCard");
        this.mXF = new c(this.cXn, this.cXm, this.hop, this.fHA);
        au.DF().a(this.mXF, 0);
    }

    public final void pause() {
        avL();
    }

    public final void resume() {
        if (this.dMm != null) {
            this.dMm.a(this.cXs, true);
        }
    }

    public final void bup() {
        au.DF().b(1250, this);
        avL();
        super.bup();
    }

    private void buo() {
        this.dMm = c.OB();
        this.dMm.a(this.cXs, true);
    }

    private void avL() {
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar instanceof c) {
            c cVar = (c) lVar;
            e eVar = this.mXG;
            e eVar2 = cVar.mXj;
            eVar.hwF = eVar2.hwF;
            eVar.huU = eVar2.huU;
            eVar.cad = eVar2.cad;
            eVar.title = eVar2.title;
            eVar.huX = eVar2.huX;
            eVar.huY = eVar2.huY;
            eVar.hwh = eVar2.hwh;
            eVar.huW = eVar2.huW;
            eVar.dxh = eVar2.dxh;
            eVar.mXk = eVar2.mXk;
            eVar.mXn = eVar2.mXn;
            eVar.mXo = eVar2.mXo;
            eVar.mXp = eVar2.mXp;
            eVar.mXq = eVar2.mXq;
            eVar.mXr = eVar2.mXr;
            eVar.end_time = eVar2.end_time;
            eVar.mXs = eVar2.mXs;
            eVar.mXt = eVar2.mXt;
            this.hwF = this.mXG.hwF;
            x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd()  action_type:" + this.hwF + "  frequency_level:" + mXk + " control_flag:" + this.mXG.mXn);
            if (i == 0 && i2 == 0) {
                mXk = this.mXG.mXk;
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd is OK ");
                if (this.mWQ != null) {
                    this.mWQ.a(1250, this.mXG, 1);
                }
                buN();
            } else if (!(i == 5 && i2 == -1) && (i != 4 || i2 == 0)) {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.mWQ != null) {
                    this.mWQ.a(1250, this.mXG, 2);
                }
                buN();
            } else {
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd errType is " + i + " errCode is " + i2);
                if (this.mWQ != null) {
                    this.mWQ.a(1250, this.mXG, 2);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long vX = (long) com.tencent.mm.plugin.shake.c.c.a.vX(com.tencent.mm.plugin.shake.c.c.a.bva());
                x.i("MicroMsg.ShakeCardService", "ShakeCardService onSceneEnd wait nextInterval is " + vX);
                this.mXl = currentTimeMillis + vX;
            }
            m.buI().mXk = mXk;
            m.buI().mXl = this.mXl;
            this.jOf = false;
        }
    }

    private void buN() {
        long vW;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (com.tencent.mm.plugin.shake.c.c.a.vV(mXk)) {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is valid");
            vW = (long) com.tencent.mm.plugin.shake.c.c.a.vW(mXk);
        } else {
            x.i("MicroMsg.ShakeCardService", "ShakeCardService frequency_level is not valid");
            vW = (long) com.tencent.mm.plugin.shake.c.c.a.vX(com.tencent.mm.plugin.shake.c.c.a.bva());
        }
        x.i("MicroMsg.ShakeCardService", "ShakeCardService updateWaitingTime wait nextInterval is " + vW);
        this.mXl = vW + currentTimeMillis;
    }
}
