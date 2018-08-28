package org.b.e;

import java.util.Map.Entry;
import org.b.a.a.b;
import org.b.c.e;
import org.b.d.c;
import org.b.d.g;
import org.b.d.h;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;
import org.b.f.d;

public final class a implements b {
    private static /* synthetic */ int[] vKT;
    private org.b.d.a vKR;
    private b vKS;

    private static /* synthetic */ int[] cKC() {
        int[] iArr = vKT;
        if (iArr == null) {
            iArr = new int[h.values().length];
            try {
                iArr[h.vKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[h.vKF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            vKT = iArr;
        }
        return iArr;
    }

    public a(b bVar, org.b.d.a aVar) {
        this.vKS = bVar;
        this.vKR = aVar;
    }

    public final i cKB() {
        this.vKR.sL("obtaining request token from " + this.vKS.cKq());
        c cVar = new c(j.vKJ, this.vKS.cKq());
        this.vKR.sL("setting oauth_callback to " + this.vKR.vKn);
        cVar.gC("oauth_callback", this.vKR.vKn);
        a(cVar, org.b.d.b.vKt);
        b(cVar);
        this.vKR.sL("sending request...");
        g cKw = cVar.cKw();
        String body = cKw.getBody();
        this.vKR.sL("response status code: " + cKw.code);
        this.vKR.sL("response body: " + body);
        return new org.b.c.g().adT(body);
    }

    private void a(c cVar, i iVar) {
        cVar.gC("oauth_timestamp", new d().cKE());
        cVar.gC("oauth_nonce", new d().getNonce());
        cVar.gC("oauth_consumer_key", this.vKR.vKl);
        cVar.gC("oauth_signature_method", new org.b.f.a().cKD());
        cVar.gC("oauth_version", "1.0");
        if ((this.vKR.scope != null ? 1 : null) != null) {
            cVar.gC("scope", this.vKR.scope);
        }
        this.vKR.sL("generating signature...");
        String a = new org.b.c.c().a(cVar);
        String aw = new org.b.f.a().aw(a, this.vKR.vKm, iVar.rWk);
        this.vKR.sL("base string is: " + a);
        this.vKR.sL("signature is: " + aw);
        cVar.gC("oauth_signature", aw);
        this.vKR.sL("appended additional OAuth parameters: " + org.b.g.b.y(cVar.vKu));
    }

    public final i a(i iVar, k kVar) {
        this.vKR.sL("obtaining access token from " + this.vKS.cKr());
        c cVar = new c(j.vKJ, this.vKS.cKr());
        cVar.gC("oauth_token", iVar.token);
        cVar.gC("oauth_verifier", kVar.value);
        this.vKR.sL("setting token to: " + iVar + " and verifier to: " + kVar);
        a(cVar, iVar);
        b(cVar);
        return new org.b.c.g().adT(cVar.cKw().getBody());
    }

    public final void a(i iVar, c cVar) {
        this.vKR.sL("signing request: " + cVar.cKu());
        Object obj = ("".equals(iVar.token) && "".equals(iVar.rWk)) ? 1 : null;
        if (obj == null) {
            cVar.gC("oauth_token", iVar.token);
        }
        this.vKR.sL("setting token to: " + iVar);
        a(cVar, iVar);
        b(cVar);
    }

    public final String b(i iVar) {
        return this.vKS.b(iVar);
    }

    private void b(c cVar) {
        switch (cKC()[this.vKR.vKp.ordinal()]) {
            case 1:
                this.vKR.sL("using Http Header signature");
                cVar.addHeader("Authorization", new e().a(cVar));
                return;
            case 2:
                this.vKR.sL("using Querystring signature");
                for (Entry entry : cVar.vKu.entrySet()) {
                    cVar.gD((String) entry.getKey(), (String) entry.getValue());
                }
                return;
            default:
                return;
        }
    }
}
