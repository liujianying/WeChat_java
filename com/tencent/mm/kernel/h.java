package com.tencent.mm.kernel;

import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class h<_Profile extends g> {
    private static h drb;
    private c drc = new c();
    private d<_Profile> drd;
    public byte[] dre = new byte[0];
    public volatile boolean drf = false;
    public long drg;
    public a drh = new a();

    /* renamed from: com.tencent.mm.kernel.h$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, Object> {
        final /* synthetic */ g bys;
        final /* synthetic */ com.tencent.mm.kernel.a.a dri;

        public AnonymousClass1(com.tencent.mm.kernel.a.a aVar, g gVar) {
            this.dri = aVar;
            this.bys = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.a aVar = this.dri;
            com.tencent.mm.kernel.a.a.j("boot execute tasks...", new Object[0]);
            aVar.drp.Es();
            return uQG;
        }
    }

    /* renamed from: com.tencent.mm.kernel.h$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, Object> {
        final /* synthetic */ g bys;
        final /* synthetic */ com.tencent.mm.kernel.a.a dri;

        public AnonymousClass2(com.tencent.mm.kernel.a.a aVar, g gVar) {
            this.dri = aVar;
            this.bys = gVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.kernel.a.a aVar = this.dri;
            g gVar = this.bys;
            com.tencent.mm.kernel.a.a.j("boot execute extension... ", new Object[0]);
            aVar.drp.b(gVar);
            return uQG;
        }
    }

    /* renamed from: com.tencent.mm.kernel.h$3 */
    class AnonymousClass3 implements b<Object> {
        final /* synthetic */ long cXh;

        public AnonymousClass3(long j) {
            this.cXh = j;
        }

        public final void aF(Object obj) {
            j.ey("executeBootExtension");
            synchronized (h.this.dre) {
                h.this.drf = true;
            }
            com.tencent.mm.kernel.a.a.j("summerboot mmskeleton boot startup finished in [%s]!", com.tencent.mm.kernel.a.a.aQ(this.cXh));
            h.this.drh.vk();
            j.ey("onStartupDone");
            h.this.drg = System.currentTimeMillis();
        }
    }

    private static class a extends com.tencent.mm.by.a<com.tencent.mm.kernel.api.g> implements com.tencent.mm.kernel.api.g {
        public a() {
            super(d.uRC);
        }

        public final void vk() {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.kernel.api.g>() {
            });
        }

        public final void aF(final boolean z) {
            a(new com.tencent.mm.by.a.a<com.tencent.mm.kernel.api.g>() {
                public final /* synthetic */ void aD(Object obj) {
                    ((com.tencent.mm.kernel.api.g) obj).aF(z);
                }
            });
        }
    }

    private h(_Profile _profile) {
        this.drd = new d(_profile);
    }

    public final c Ee() {
        Assert.assertNotNull("mCorePlugins not initialized!", this.drc);
        return this.drc;
    }

    public final d<_Profile> Ef() {
        Assert.assertNotNull("mCoreProcess not initialized!", this.drd);
        return this.drd;
    }

    public static <_Profile extends g> h<_Profile> Eo() {
        Assert.assertNotNull("Skeleton not initialized!", drb);
        return drb;
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        Object obj = null;
        synchronized (this.dre) {
            if (this.drf) {
                obj = 1;
            }
        }
        if (obj != null) {
            gVar.aD();
        } else {
            this.drh.aI(gVar);
        }
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        this.drh.remove(gVar);
    }

    public static synchronized <_Profile extends g> h<_Profile> c(_Profile _profile) {
        h<_Profile> hVar;
        synchronized (h.class) {
            if (drb != null) {
                j.i("MicroMsg.MMSkeleton", "Kernel not null, has initialized.", new Object[0]);
                hVar = drb;
            } else {
                j.i("MicroMsg.MMSkeleton", "Initialize skeleton, create whole world.", new Object[0]);
                hVar = new h(_profile);
                drb = hVar;
            }
        }
        return hVar;
    }
}
