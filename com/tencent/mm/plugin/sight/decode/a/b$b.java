package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.sdk.platformtools.x;

class b$b implements Runnable {
    volatile boolean lhj;
    final /* synthetic */ b ncT;
    b$c ncY;

    private b$b(b bVar) {
        this.ncT = bVar;
        this.lhj = false;
    }

    /* synthetic */ b$b(b bVar, byte b) {
        this(bVar);
    }

    public final void run() {
        if (!(b.q(this.ncT) == null || b.q(this.ncT).bvP() == null || b.q(this.ncT).bvP().getVisibility() != 0)) {
            b.g(this.ncT).post(new 1(this));
        }
        if (b.e(this.ncT) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode()), b.a(this.ncT)});
        } else if (this.lhj) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode())});
        } else {
            float f;
            double bvR;
            if (b.r(this.ncT) == 0) {
                if (b.s(this.ncT) != null) {
                    b.s(this.ncT).type = 1;
                    b.s(this.ncT).run();
                }
                b.a(this.ncT, System.currentTimeMillis());
            }
            Object obj = null;
            if (b.t(this.ncT) != -1.0d) {
                if (this.ncT.ncG) {
                    if (b.s(this.ncT) != null) {
                        b.s(this.ncT).type = 4;
                        b.s(this.ncT).ncM = b.t(this.ncT);
                        b.s(this.ncT).run();
                        b.g(this.ncT).postDelayed(new 2(this), 100);
                    } else if (SightVideoJNI.seekStream(b.t(this.ncT), b.e(this.ncT)) > 0) {
                        if (b.s(this.ncT) == null) {
                            b.a(this.ncT, new i(this.ncT, (byte) 0));
                        }
                        b.s(this.ncT).type = 4;
                        b.s(this.ncT).ncM = b.t(this.ncT);
                        b.s(this.ncT).run();
                        obj = 1;
                    }
                } else if (SightVideoJNI.seekStream(b.t(this.ncT), b.e(this.ncT)) > 0) {
                    if (b.s(this.ncT) == null) {
                        b.a(this.ncT, new i(this.ncT, (byte) 0));
                    }
                    b.s(this.ncT).type = 4;
                    b.s(this.ncT).ncM = b.t(this.ncT);
                    b.s(this.ncT).run();
                    obj = 1;
                }
            }
            float currentTimeMillis = (float) (System.currentTimeMillis() - b.r(this.ncT));
            if (obj != null) {
                f = 0.0f;
            } else {
                f = (currentTimeMillis / ((float) this.ncT.ncn)) + 0.5f;
            }
            if (this.ncT.ncG && b.u(this.ncT)) {
                b.a(this.ncT, false);
                if (b.s(this.ncT) != null) {
                    bvR = b.s(this.ncT).bvR() / 1000.0d;
                    if (SightVideoJNI.seekStream(bvR, b.e(this.ncT)) > 0) {
                        f = 0.0f;
                        x.i("MicroMsg.SightPlayController", "seek to " + bvR + " modify time : 0.0");
                    }
                }
            }
            float f2 = f;
            if (b.v(this.ncT)) {
                x.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(b.e(this.ncT)), Float.valueOf(currentTimeMillis), Float.valueOf(f2)});
            }
            b.a(this.ncT, System.currentTimeMillis());
            if (f2 >= 2.0f) {
                b.w(this.ncT);
            } else {
                b.c(this.ncT, Math.max(0, b.x(this.ncT) - 1));
            }
            if (b.c(this.ncT)) {
                x.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[]{Integer.valueOf(b.x(this.ncT))});
                this.ncT.clear();
                return;
            }
            int i;
            Object obj2 = null;
            int i2 = 0;
            if (1 == b.d(this.ncT)) {
                Object obj3;
                if (b.m(this.ncT) == null || b.m(this.ncT).isValid()) {
                    i2 = SightVideoJNI.drawSurfaceFrame(b.e(this.ncT), b.m(this.ncT), (int) f2, b.o(this.ncT), b.y(this.ncT));
                    if (b.z(this.ncT) != null) {
                        bvR = SightVideoJNI.getVideoPlayTime(b.e(this.ncT));
                        i = (int) bvR;
                        if (i != ((int) this.ncT.ncJ)) {
                            b.z(this.ncT).b(this.ncT, (long) i);
                        }
                        this.ncT.ncJ = bvR;
                    }
                    if (i2 == 0) {
                        b.a(this.ncT, -1.0d);
                        obj3 = null;
                    } else if (1 == i2) {
                        b.a(this.ncT, -1.0d);
                        obj3 = 1;
                        b.a(this.ncT, 0);
                        b.A(this.ncT);
                    } else if (-7 == i2) {
                        x.w("MicroMsg.SightPlayController", "surface is null, continue");
                        obj3 = null;
                    } else {
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                        this.lhj = true;
                        if (this.ncY != null) {
                            this.ncY.lhj = true;
                        }
                        this.ncT.D(null);
                        if (b.b(this.ncT) != null) {
                            b.b(this.ncT).d(this.ncT, -1);
                        }
                        obj3 = null;
                    }
                } else {
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode())});
                    this.lhj = true;
                    if (this.ncY != null) {
                        this.ncY.lhj = true;
                        obj3 = null;
                    }
                    obj3 = null;
                }
                if (b.s(this.ncT) != null) {
                    x.d("MicroMsg.SightPlayController", "voice time is" + (b.s(this.ncT).bvR() / 1000.0d));
                    obj2 = obj3;
                } else {
                    obj2 = obj3;
                }
            } else {
                i2 = SightVideoJNI.drawFrame(b.e(this.ncT), b.B(this.ncT), (int) f2, null, false, b.y(this.ncT));
                if (b.z(this.ncT) != null) {
                    bvR = SightVideoJNI.getVideoPlayTime(b.e(this.ncT));
                    i = (int) bvR;
                    if (i != ((int) this.ncT.ncJ)) {
                        b.z(this.ncT).b(this.ncT, (long) i);
                    }
                    this.ncT.ncJ = bvR;
                    if (b.v(this.ncT)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bvR)});
                    }
                } else if (b.v(this.ncT)) {
                    bvR = SightVideoJNI.getVideoPlayTime(b.e(this.ncT));
                    if (b.v(this.ncT)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bvR)});
                    }
                } else if (b.v(this.ncT)) {
                    x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                }
                if (i2 == 0) {
                    b.a(this.ncT, -1.0d);
                } else if (1 == i2) {
                    b.a(this.ncT, -1.0d);
                    obj2 = 1;
                    b.a(this.ncT, 0);
                    b.A(this.ncT);
                } else {
                    b.a(this.ncT, -1.0d);
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                    this.lhj = true;
                    if (this.ncY != null) {
                        this.ncY.lhj = true;
                    }
                    b.g(this.ncT).post(new Runnable() {
                        public final void run() {
                            b$b.this.ncT.E(null);
                        }
                    });
                    if (b.b(this.ncT) != null) {
                        b.b(this.ncT).d(this.ncT, -1);
                    }
                }
            }
            if (1 == i2) {
                b.g(this.ncT).post(new 4(this));
            }
            if (this.lhj) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode())});
                if (b.s(this.ncT) != null) {
                    b.s(this.ncT).type = 0;
                    b.s(this.ncT).run();
                    return;
                }
                return;
            }
            if (1 == b.d(this.ncT)) {
                long currentTimeMillis2 = ((long) this.ncT.ncn) - (System.currentTimeMillis() - b.r(this.ncT));
                if (b.r(this.ncT) == 0) {
                    o.d(this, (long) (this.ncT.ncn * 5));
                } else if (currentTimeMillis2 > 0) {
                    o.d(this, currentTimeMillis2);
                } else {
                    o.d(this, 0);
                }
            } else if (obj2 == null || b.q(this.ncT) == null) {
                this.ncY.nda = i2;
                b.g(this.ncT).post(this.ncY);
            } else {
                i = b.q(this.ncT).bvO();
                b.g(this.ncT).post(new 5(this));
                this.ncY.nda = i2;
                b.g(this.ncT).postDelayed(this.ncY, (long) i);
            }
            if (b.s(this.ncT) != null) {
                x.d("MicroMsg.SightPlayController", "voice time is" + (b.s(this.ncT).bvR() / 1000.0d));
            }
        }
    }
}
