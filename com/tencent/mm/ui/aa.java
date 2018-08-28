package com.tencent.mm.ui;

import com.tencent.mm.ao.d$a;
import com.tencent.mm.g.a.os;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.s.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bh;

public final class aa implements b {
    MMFragmentActivity tiY;
    c<os> tiy = new 6(this);
    c tiz = new 5(this);
    b toA = new 2(this);
    c toB = new 3(this);
    LauncherUI.c tov;
    c tow;
    boolean tox;
    Runnable toy = new 1(this);
    a toz = new 12(this);

    static /* synthetic */ void b(aa aaVar) {
        if (au.HX()) {
            Object obj;
            int parseInt;
            g.l(com.tencent.mm.plugin.card.c.b.class);
            boolean aT = com.tencent.mm.s.c.Cp().aT(262156, 266241);
            boolean aU = com.tencent.mm.s.c.Cp().aU(262156, 266241);
            x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "hasMallNew: %s, hasMallDot: %s", new Object[]{Boolean.valueOf(aT), Boolean.valueOf(aU)});
            if (aT || aU) {
                au.HU();
                long longValue = ((Long) com.tencent.mm.model.c.DT().get(com.tencent.mm.storage.aa.a.sXJ, Long.valueOf(-1))).longValue();
                long oX = ai.oX(com.tencent.mm.k.g.AT().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * oX;
                x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[]{Long.valueOf(longValue), Long.valueOf(oX), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d)});
                if (longValue > 0 && oX > 0 && r14 >= ((double) oX)) {
                    aT = false;
                    com.tencent.mm.s.c.Cp().u(262156, false);
                    aU = false;
                }
            }
            x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "after check, hasMallNew: %s, hasMallDot: %s", new Object[]{Boolean.valueOf(aT), Boolean.valueOf(aU)});
            boolean aT2 = com.tencent.mm.s.c.Cp().aT(262145, 266241);
            boolean aU2 = com.tencent.mm.s.c.Cp().aU(266260, 266241);
            boolean aT3 = com.tencent.mm.s.c.Cp().aT(262147, 266241);
            boolean aT4 = com.tencent.mm.s.c.Cp().aT(262149, 266241);
            boolean aU3 = com.tencent.mm.s.c.Cp().aU(262152, 266256);
            boolean aT5 = com.tencent.mm.s.c.Cp().aT(262152, 266256);
            boolean a = com.tencent.mm.s.c.Cp().a(com.tencent.mm.storage.aa.a.sZC, 266241);
            com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) g.l(com.tencent.mm.plugin.welab.a.a.c.class);
            Object obj2 = null;
            if (cVar != null) {
                obj = (cVar.bYN() || cVar.bYO()) ? 1 : null;
                obj2 = obj;
            }
            com.tencent.mm.s.a Cp = com.tencent.mm.s.c.Cp();
            if (Cp.initialized) {
                com.tencent.mm.s.b.a x = Cp.dls.x(262152, 266256, 4);
                parseInt = x == null ? 0 : com.tencent.mm.s.a.parseInt(x.value);
            } else {
                x.w("MicroMsg.NewBadge", "hasUnreadNum NewBadge has not initialized");
                parseInt = 0;
            }
            com.tencent.mm.plugin.card.c.b bVar = (com.tencent.mm.plugin.card.c.b) g.l(com.tencent.mm.plugin.card.c.b.class);
            obj = (bVar == null || !(bVar.axz() || bVar.axA())) ? null : 1;
            Object obj3 = (obj == null || !(aU3 || aT5 || parseInt > 0)) ? null : 1;
            g.Ek();
            boolean booleanValue = ((Boolean) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sZt, Boolean.valueOf(true))).booleanValue();
            if (aU || aT || aT2 || obj3 != null || aT3 || aT4 || aU2 || obj2 != null || a || booleanValue) {
                aaVar.tow.lt(true);
            } else {
                aaVar.tow.lt(false);
            }
            h hVar = h.mEJ;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(6);
            objArr[1] = Integer.valueOf(aU ? 1 : 0);
            objArr[2] = "";
            objArr[3] = "";
            objArr[4] = Integer.valueOf(1);
            hVar.h(14872, objArr);
            bh Do = com.tencent.mm.plugin.ab.a.bjj().Do(com.tencent.mm.ao.b.ebm);
            if (Do == null || Do.field_isExit) {
                com.tencent.mm.plugin.ab.a.bjk();
                if (com.tencent.mm.ao.c.ig(com.tencent.mm.ao.b.ebm)) {
                    aaVar.tow.lt(true);
                    return;
                }
                return;
            }
            com.tencent.mm.plugin.ab.a.bji().ebC = new d$a() {
                public final void e(bh bhVar) {
                    if (bhVar.field_tipId == com.tencent.mm.ao.b.ebm) {
                        com.tencent.mm.plugin.ab.a.bjk();
                        if (com.tencent.mm.ao.c.ig(com.tencent.mm.ao.b.ebm)) {
                            aa.this.tow.lt(true);
                        }
                    }
                }
            };
            return;
        }
        x.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "want update more menu new tips, but mmcore not ready");
    }

    protected final void cqF() {
        com.tencent.mm.blink.b.xi().g(new 8(this));
    }

    protected final void cqD() {
        com.tencent.mm.blink.b.xi().g(new 9(this));
    }

    protected final void cqB() {
        com.tencent.mm.blink.b.xi().g(new 10(this));
    }

    protected final void cqC() {
        if (this.tox) {
            x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "start  setAppTagUnreadNow");
            cqF();
        }
    }

    public final void DX(int i) {
        if (this.tow != null) {
            this.tow.DD(i);
            this.tov.cpB();
        }
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        au.HU();
        if (mVar == com.tencent.mm.model.c.FW()) {
            x.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "Launcherui onNotifyChange event type %d, username %s", new Object[]{Integer.valueOf(i), obj});
            if (ab.gY((String) obj)) {
                cqD();
            }
        }
    }

    public final void DY(int i) {
        if (this.tow != null) {
            this.tow.setTo(i);
        }
    }
}
