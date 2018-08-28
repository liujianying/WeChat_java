package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.i;
import com.tencent.mm.sdk.platformtools.x;

class a$b implements Runnable {
    volatile boolean lhj;
    final /* synthetic */ a nGD;
    c nGE;

    private a$b(a aVar) {
        this.nGD = aVar;
        this.lhj = false;
    }

    /* synthetic */ a$b(a aVar, byte b) {
        this(aVar);
    }

    public final void run() {
        if (!(a.q(this.nGD) == null || a.q(this.nGD).bvP() == null || a.q(this.nGD).bvP().getVisibility() != 0)) {
            a.g(this.nGD).post(new Runnable() {
                public final void run() {
                    a.q(a$b.this.nGD).bvP().setVisibility(8);
                }
            });
        }
        if (a.e(this.nGD) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode()), a.a(this.nGD)});
        } else if (this.lhj) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode())});
        } else {
            float f;
            double bvR;
            if (a.r(this.nGD) == 0) {
                if (a.s(this.nGD) != null) {
                    a.s(this.nGD).type = 1;
                    a.s(this.nGD).run();
                }
                a.a(this.nGD, System.currentTimeMillis());
            }
            Object obj = null;
            if (a.t(this.nGD) != -1.0d) {
                if (this.nGD.ncG) {
                    if (a.s(this.nGD) != null) {
                        a.s(this.nGD).type = 4;
                        a.s(this.nGD).ncM = a.t(this.nGD);
                        a.s(this.nGD).run();
                        a.g(this.nGD).postDelayed(new 2(this), 100);
                    } else if (SightVideoJNI.seekStream(a.t(this.nGD), a.e(this.nGD)) > 0) {
                        if (a.s(this.nGD) == null) {
                            a.a(this.nGD, new i(this.nGD, (byte) 0));
                        }
                        a.s(this.nGD).type = 4;
                        a.s(this.nGD).ncM = a.t(this.nGD);
                        a.s(this.nGD).run();
                        obj = 1;
                    }
                } else if (SightVideoJNI.seekStream(a.t(this.nGD), a.e(this.nGD)) > 0) {
                    if (a.s(this.nGD) == null) {
                        a.a(this.nGD, new i(this.nGD, (byte) 0));
                    }
                    a.s(this.nGD).type = 4;
                    a.s(this.nGD).ncM = a.t(this.nGD);
                    a.s(this.nGD).run();
                    obj = 1;
                }
            }
            float currentTimeMillis = (float) (System.currentTimeMillis() - a.r(this.nGD));
            if (obj != null) {
                f = 0.0f;
            } else {
                f = (currentTimeMillis / ((float) this.nGD.ncn)) + 0.5f;
            }
            if (this.nGD.ncG && a.u(this.nGD)) {
                a.a(this.nGD, false);
                if (a.s(this.nGD) != null) {
                    bvR = a.s(this.nGD).bvR() / 1000.0d;
                    if (SightVideoJNI.seekStream(bvR, a.e(this.nGD)) > 0) {
                        f = 0.0f;
                        x.i("MicroMsg.SightPlayController", "seek to " + bvR + " modify time : 0.0");
                    }
                }
            }
            float f2 = f;
            if (a.v(this.nGD)) {
                x.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(a.e(this.nGD)), Float.valueOf(currentTimeMillis), Float.valueOf(f2)});
            }
            a.a(this.nGD, System.currentTimeMillis());
            if (f2 >= 2.0f) {
                a.w(this.nGD);
            } else {
                a.c(this.nGD, Math.max(0, a.x(this.nGD) - 1));
            }
            if (a.c(this.nGD)) {
                x.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[]{Integer.valueOf(a.x(this.nGD))});
                this.nGD.clear();
                return;
            }
            int i;
            Object obj2 = null;
            int i2 = 0;
            if (1 == a.d(this.nGD)) {
                Object obj3;
                if (a.m(this.nGD) == null || a.m(this.nGD).isValid()) {
                    i2 = SightVideoJNI.drawSurfaceFrame(a.e(this.nGD), a.m(this.nGD), (int) f2, a.o(this.nGD), a.y(this.nGD));
                    if (a.z(this.nGD) != null) {
                        bvR = SightVideoJNI.getVideoPlayTime(a.e(this.nGD));
                        i = (int) bvR;
                        if (i != ((int) this.nGD.ncJ)) {
                            a.z(this.nGD).eY((long) i);
                        }
                        this.nGD.ncJ = bvR;
                    }
                    if (i2 == 0) {
                        a.a(this.nGD, -1.0d);
                        obj3 = null;
                    } else if (1 == i2) {
                        a.a(this.nGD, -1.0d);
                        obj3 = 1;
                        a.a(this.nGD, 0);
                        a.A(this.nGD);
                    } else if (-7 == i2) {
                        x.w("MicroMsg.SightPlayController", "surface is null, continue");
                        obj3 = null;
                    } else {
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                        this.lhj = true;
                        if (this.nGE != null) {
                            this.nGE.lhj = true;
                        }
                        this.nGD.bAm();
                        if (a.b(this.nGD) != null) {
                            a.b(this.nGD).wS(-1);
                        }
                        obj3 = null;
                    }
                } else {
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode())});
                    this.lhj = true;
                    if (this.nGE != null) {
                        this.nGE.lhj = true;
                        obj3 = null;
                    }
                    obj3 = null;
                }
                if (a.s(this.nGD) != null) {
                    x.d("MicroMsg.SightPlayController", "voice time is" + (a.s(this.nGD).bvR() / 1000.0d));
                    obj2 = obj3;
                } else {
                    obj2 = obj3;
                }
            } else {
                i2 = SightVideoJNI.drawFrame(a.e(this.nGD), a.B(this.nGD), (int) f2, null, false, a.y(this.nGD));
                if (a.z(this.nGD) != null) {
                    bvR = SightVideoJNI.getVideoPlayTime(a.e(this.nGD));
                    i = (int) bvR;
                    if (i != ((int) this.nGD.ncJ)) {
                        a.z(this.nGD).eY((long) i);
                    }
                    this.nGD.ncJ = bvR;
                    if (a.v(this.nGD)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bvR)});
                    }
                } else if (a.v(this.nGD)) {
                    bvR = SightVideoJNI.getVideoPlayTime(a.e(this.nGD));
                    if (a.v(this.nGD)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bvR)});
                    }
                } else if (a.v(this.nGD)) {
                    x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                }
                if (i2 == 0) {
                    a.a(this.nGD, -1.0d);
                } else if (1 == i2) {
                    a.a(this.nGD, -1.0d);
                    obj2 = 1;
                    a.a(this.nGD, 0);
                    a.A(this.nGD);
                } else {
                    a.a(this.nGD, -1.0d);
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                    this.lhj = true;
                    if (this.nGE != null) {
                        this.nGE.lhj = true;
                    }
                    a.g(this.nGD).post(new Runnable() {
                        public final void run() {
                            a$b.this.nGD.E(null);
                        }
                    });
                    if (a.b(this.nGD) != null) {
                        a.b(this.nGD).wS(-1);
                    }
                }
            }
            if (1 == i2) {
                a.g(this.nGD).post(new 4(this));
            }
            if (this.lhj) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode())});
                if (a.s(this.nGD) != null) {
                    a.s(this.nGD).type = 0;
                    a.s(this.nGD).run();
                    return;
                }
                return;
            }
            if (1 == a.d(this.nGD)) {
                long currentTimeMillis2 = ((long) this.nGD.ncn) - (System.currentTimeMillis() - a.r(this.nGD));
                if (a.r(this.nGD) == 0) {
                    o.d(this, (long) (this.nGD.ncn * 5));
                } else if (currentTimeMillis2 > 0) {
                    o.d(this, currentTimeMillis2);
                } else {
                    o.d(this, 0);
                }
            } else if (obj2 == null || a.q(this.nGD) == null) {
                this.nGE.nda = i2;
                a.g(this.nGD).post(this.nGE);
            } else {
                i = a.q(this.nGD).bvO();
                a.g(this.nGD).post(new 5(this));
                this.nGE.nda = i2;
                a.g(this.nGD).postDelayed(this.nGE, (long) i);
            }
            if (a.s(this.nGD) != null) {
                x.d("MicroMsg.SightPlayController", "voice time is" + (a.s(this.nGD).bvR() / 1000.0d));
            }
        }
    }
}
