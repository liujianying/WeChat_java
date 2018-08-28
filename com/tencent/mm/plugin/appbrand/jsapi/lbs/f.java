package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.b.a.b;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class f extends d implements a {
    final l fFa;
    final b fRp;
    int fRq = 0;
    final c fRr = new c() {
        public final String getName() {
            return f.this.mName + "$StateNotListening";
        }

        public final boolean j(Message message) {
            if (1 != message.what) {
                return super.j(message);
            }
            f.this.b(f.this.fRs);
            return true;
        }

        public final void enter() {
            super.enter();
            b.aoC().b(f.this.fRp);
            com.tencent.mm.plugin.appbrand.page.a.t(f.this.fFa.fdO).ln(f.this.fRq);
        }
    };
    final c fRs = new c() {
        public final String getName() {
            return f.this.mName + "$StateListening";
        }

        public final void enter() {
            super.enter();
            b.aoC().a(f.this.fRp);
            f.this.fRq = com.tencent.mm.plugin.appbrand.page.a.t(f.this.fFa.fdO).a(com.tencent.mm.plugin.appbrand.page.a.a.glM);
        }

        public final void exit() {
            super.exit();
            b.aoC().b(f.this.fRp);
        }

        public final boolean j(Message message) {
            if (2 == message.what) {
                f.this.b(f.this.fRr);
                return true;
            } else if (3 != message.what) {
                return super.j(message);
            } else {
                f.this.b(f.this.fRt);
                return true;
            }
        }
    };
    final c fRt = new c() {
        public final String getName() {
            return f.this.mName + "$StateListeningButSuspend";
        }

        public final boolean j(Message message) {
            if (2 == message.what) {
                f.this.b(f.this.fRr);
                return true;
            } else if (4 != message.what) {
                return super.j(message);
            } else {
                f.this.b(f.this.fRs);
                return true;
            }
        }
    };

    f(l lVar) {
        super("AppBrand$RuntimeLocationUpdateStateManager[" + lVar.mAppId + "]", Looper.getMainLooper());
        this.fFa = lVar;
        this.fRp = new b(lVar);
        lVar.fdO.fcL.a(this);
        a(this.fRr);
        a(this.fRs);
        a(this.fRt);
        b(this.fRr);
    }

    public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
        if (aVar == com.tencent.mm.plugin.appbrand.b.a.fjh) {
            quit();
        } else if (aVar == com.tencent.mm.plugin.appbrand.b.a.fjg) {
            Dd(3);
        } else if (aVar == com.tencent.mm.plugin.appbrand.b.a.fje) {
            Dd(4);
        }
    }
}
