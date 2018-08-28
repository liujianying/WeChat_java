package com.tencent.mm.ab;

import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class v {
    public static b dKi = null;

    public interface a {
        int a(int i, int i2, String str, b bVar, l lVar);
    }

    public interface b {
        o DG();
    }

    private static final class c implements a, com.tencent.mm.vending.e.a {
        private a dKs;

        public c(a aVar) {
            this.dKs = aVar;
        }

        public final void dead() {
            this.dKs = null;
        }

        public final int a(int i, int i2, String str, b bVar, l lVar) {
            if (this.dKs != null) {
                return this.dKs.a(i, i2, str, bVar, lVar);
            }
            return -100000;
        }
    }

    static /* synthetic */ int a(boolean z, a aVar, int i, int i2, String str, b bVar, l lVar) {
        if (aVar != null) {
            final a aVar2;
            final int i3;
            final int i4;
            final String str2;
            final b bVar2;
            final l lVar2;
            if (z) {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                lVar2 = lVar;
                dKi.DG().dJt.H(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, lVar2);
                    }

                    public final String toString() {
                        return super.toString() + "|tryCallback";
                    }
                });
            } else {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                lVar2 = lVar;
                ah.A(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, lVar2);
                    }
                });
            }
        }
        return 0;
    }

    public static boolean LO() {
        if (dKi == null) {
            x.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return false;
        } else if (dKi.DG() != null) {
            return true;
        } else {
            x.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return false;
        }
    }

    public static b a(b bVar) {
        a(bVar, null, false, null);
        return bVar;
    }

    public static b a(b bVar, a aVar) {
        a(bVar, aVar, false, null);
        return bVar;
    }

    public static l a(b bVar, a aVar, boolean z) {
        return a(bVar, aVar, z, null);
    }

    public static l a(final b bVar, a aVar, final boolean z, com.tencent.mm.vending.e.b bVar2) {
        Object obj;
        c cVar = new c(aVar);
        if (aVar == null) {
            obj = null;
        } else {
            c obj2 = cVar;
        }
        if (!(bVar2 == null || obj2 == null)) {
            bVar2.keep(obj2);
        }
        if (dKi == null) {
            x.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
        } else if (dKi.DG() == null) {
            x.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
        } else if (bVar == null) {
            x.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
        } else {
            l anonymousClass1 = new l() {
                private k dIB = new k() {
                    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
                        if (AnonymousClass1.this.dKl != 2) {
                            AnonymousClass1.this.dKm.SO();
                            AnonymousClass1.this.dKl = 1;
                            v.a(z, obj2, i2, i3, str, bVar, AnonymousClass1.this.dKk);
                        } else {
                            x.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.dKk.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bi.VF() - AnonymousClass1.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        AnonymousClass1.this.dKj.a(i2, i3, str, AnonymousClass1.this.dKk);
                        x.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.dKk.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bi.VF() - AnonymousClass1.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    }
                };
                e dKj = null;
                final l dKk = this;
                int dKl = 0;
                al dKm = new al(v.dKi.DG().dJt.lnJ.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                    public final boolean vD() {
                        x.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(AnonymousClass1.this.dKk.aBS), Integer.valueOf(AnonymousClass1.this.dKk.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bi.VF() - AnonymousClass1.this.startTime));
                        if (!(AnonymousClass1.this.dKk.aBS || AnonymousClass1.this.dKl == 1)) {
                            AnonymousClass1.this.dKl = 2;
                            v.a(z, obj2, 3, -1, "", bVar, AnonymousClass1.this.dKk);
                        }
                        return false;
                    }

                    public final String toString() {
                        return super.toString() + "|protectNotCallback";
                    }
                }, false);
                final long startTime = bi.VF();

                public final int getType() {
                    return bVar.dIF;
                }

                public final int a(e eVar, e eVar2) {
                    this.dKj = eVar2;
                    int a = a(eVar, bVar, this.dIB);
                    x.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.dKk.hashCode()), Integer.valueOf(bVar.dIF), Integer.valueOf(a), Long.valueOf(bi.VF() - this.startTime));
                    if (obj2 != null) {
                        if (a < 0) {
                            v.a(z, obj2, 3, -1, "", bVar, this.dKk);
                        } else {
                            this.dKm.J(60000, 60000);
                        }
                    }
                    return a;
                }
            };
            if (dKi.DG().a(anonymousClass1, 0)) {
                return anonymousClass1;
            }
        }
        return null;
    }
}
