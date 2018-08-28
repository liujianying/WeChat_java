package com.tencent.mm.plugin.shake.b;

import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.plugin.shake.c.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c extends l$b implements e {
    float cXm = -85.0f;
    float cXn = -1000.0f;
    private a$a cXs = new a$a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            com.tencent.mm.modelstat.e.RW().a(2002, i != 0, c.this.dMm == null ? false : c.this.dMm.dSc, f, f2, (int) d2);
            x.i("MicroMsg.ShakeFriendService", "getlocaion lat %f lng %f hasGetLbsInfo " + c.this.mLB, new Object[]{Float.valueOf(f2), Float.valueOf(f)});
            if (!z) {
                return true;
            }
            if (c.this.mWC && c.this.cXm == -85.0f && c.this.cXn == -1000.0f) {
                c.this.mWC = false;
                c.this.cXm = f2;
                c.this.cXn = f;
                c.this.mLy = (int) d2;
                c.this.mLx = i;
                c.this.mLB = true;
            }
            return false;
        }
    };
    private Context context;
    com.tencent.mm.modelgeo.c dMm;
    boolean mLB = false;
    int mLx = 1;
    int mLy = -1000;
    boolean mWC = true;
    b mWD;
    a mWE;
    private int mWF = 0;
    ag mWG = new ag();
    Runnable mWH = new 1(this);

    public c(Context context, l$a l_a) {
        super(l_a);
        this.context = context;
    }

    public final void init() {
        au.DF().a(161, this);
        au.DF().a(162, this);
        au.DF().a(1251, this);
        buo();
    }

    public final void start() {
        reset();
        init();
        this.mWD = new b(this.cXn, this.cXm, this.mLy, this.mLx, "", "");
        au.DF().a(this.mWD, 0);
        if (!this.mLB) {
            if (this.dMm == null) {
                buo();
            }
            this.dMm.b(this.cXs, true);
        }
        if (this.mWF <= 0) {
            this.mWF++;
        } else if (this.mWF <= 0 || this.mWF > 10) {
            this.mWF = 0;
        } else {
            this.mWF++;
            return;
        }
        x.i("MicroMsg.ShakeFriendService", "do doGetLbsCard");
        au.DF().a(new b(this.cXn, this.cXm), 0);
    }

    private void buo() {
        this.dMm = com.tencent.mm.modelgeo.c.OB();
        this.mWC = true;
        this.dMm.a(this.cXs, true);
    }

    public final void reset() {
        if (this.mWD != null) {
            au.DF().c(this.mWD);
        }
        if (this.mWE != null) {
            au.DF().c(this.mWE);
        }
        if (this.mWG != null && this.mWH != null) {
            this.mWG.removeCallbacks(this.mWH);
        }
    }

    public final void pause() {
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
    }

    public final void resume() {
        if (this.dMm != null) {
            this.dMm.a(this.cXs, true);
        }
    }

    public final void bup() {
        super.bup();
        au.DF().b(161, this);
        au.DF().b(162, this);
        au.DF().b(1251, this);
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        switch (lVar.getType()) {
            case 161:
                b bVar = (b) lVar;
                if (bVar.bun() == 3 || bVar.bun() == 4) {
                    x.v("MicroMsg.ShakeFriendService", "onSceneEnd ignore location report response");
                    return;
                } else if (i2 == 0 && i == 0 && bVar.ret == 0) {
                    this.mWG.postDelayed(this.mWH, 3000);
                    return;
                } else {
                    x.e("MicroMsg.ShakeFriendService", "onSceneEnd reprot failed");
                    this.mWQ.d(null, 3);
                    return;
                }
            case 162:
                a aVar = (a) lVar;
                if (i2 == 0 && i == 0 && aVar.ret == 0) {
                    List list = aVar.mWA;
                    if (list.size() == 0) {
                        x.i("MicroMsg.ShakeFriendService", "empty shake get list");
                        this.mWQ.d(null, 3);
                        return;
                    }
                    this.mWQ.d(list, 1);
                    return;
                }
                this.mWQ.d(null, 3);
                return;
            case 1251:
                b bVar2 = (b) lVar;
                if (i2 == 0 && i == 0) {
                    if (this.mWQ != null) {
                        this.mWQ.a(1251, bVar2.mXj, 1);
                        return;
                    }
                    return;
                } else if (this.mWQ != null) {
                    this.mWQ.a(1251, null, 2);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
