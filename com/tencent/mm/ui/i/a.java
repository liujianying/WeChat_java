package com.tencent.mm.ui.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.b.d.i;
import org.b.d.k;
import org.b.e.b;
import org.b.g.d;

@SuppressLint({"HandlerLeak"})
public final class a implements com.tencent.mm.ui.i.b.a {
    Context context = null;
    ag nLo = new 1(this);
    b uFb = null;
    public i uFc = null;
    i uFd = null;
    private boolean uFe = false;
    boolean uFf = false;
    public b uFg = null;
    public a uFh = null;

    public a() {
        i iVar;
        org.b.a.a aVar = new org.b.a.a();
        aVar.vKo = org.b.a.a.Y(org.b.a.a.c.a.class);
        String str = "XMr2y8FEVEqZBcZ1TU3gLA";
        d.gE(str, "Invalid Api key");
        aVar.vKl = str;
        str = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        d.gE(str, "Invalid Api secret");
        aVar.vKm = str;
        str = "wechatapp://sign-in-twitter.wechatapp.com/";
        d.j(str, "Callback can't be null");
        aVar.vKn = str;
        d.j(aVar.vKo, "You must specify a valid api through the provider() method");
        d.gE(aVar.vKl, "You must provide an api key");
        d.gE(aVar.vKm, "You must provide an api secret");
        this.uFb = aVar.vKo.a(new org.b.d.a(aVar.vKl, aVar.vKm, aVar.vKn, aVar.vKp, aVar.scope, aVar.vKq));
        if (g.Eg().Dx()) {
            str = (String) g.Ei().DT().get(69377, null);
            String str2 = (String) g.Ei().DT().get(69378, null);
            iVar = (bi.oW(str) || bi.oW(str2)) ? null : new i(str, str2);
        } else {
            x.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            iVar = null;
        }
        this.uFc = iVar;
    }

    public final void a(b bVar, Context context) {
        if (!this.uFe) {
            h.mEJ.a(583, 0, 1, false);
            this.uFg = bVar;
            this.context = context;
            this.uFe = true;
            e.post(new 2(this), "Twitter_doOAuth");
        }
    }

    public final boolean cAo() {
        return this.uFc != null;
    }

    public final void a(a aVar) {
        if (!this.uFf) {
            this.uFh = aVar;
            this.uFf = true;
            e.post(new 3(this), "Twitter_validationAccessToken");
        }
    }

    static void a(i iVar) {
        ad.getContext().getSharedPreferences(ad.chY(), 0);
        if (iVar == null) {
            g.Ei().DT().set(69377, "");
            g.Ei().DT().set(69378, "");
            return;
        }
        g.Ei().DT().set(69377, iVar.token);
        g.Ei().DT().set(69378, iVar.rWk);
    }

    final void c(c cVar) {
        this.uFe = false;
        this.uFd = null;
        if (this.uFg != null) {
            this.uFg.a(cVar);
        }
    }

    public final void m(final Bundle bundle) {
        g.Em().H(new Runnable() {
            public final void run() {
                i iVar = null;
                if (a.this.uFd != null) {
                    a.my(true);
                    String string = bundle.getString("oauth_verifier");
                    if (string != null) {
                        try {
                            iVar = a.this.uFb.a(a.this.uFd, new k(string));
                        } catch (org.b.b.a e) {
                        }
                    }
                    if (iVar != null) {
                        a.this.uFc = iVar;
                        a.a(a.this.uFc);
                        new ag(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                a.this.c(c.uFl);
                                h.mEJ.a(583, 1, 1, false);
                            }
                        });
                        return;
                    }
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            a.this.c(c.uFm);
                            h.mEJ.a(583, 4, 1, false);
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|onComplete";
            }
        });
    }

    public final void cAp() {
        my(false);
        c(c.uFm);
        h.mEJ.a(583, 2, 1, false);
    }

    public final void onCancel() {
        my(false);
        c(c.uFn);
        h.mEJ.a(583, 3, 1, false);
    }

    static void my(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.aq.h.a(10251, z ? "1" : "2"));
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new com.tencent.mm.aq.h(arrayList));
    }
}
