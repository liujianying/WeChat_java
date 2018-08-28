package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.d;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.ah.1;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.f;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

final class w extends o {
    private final u aGG;
    private final h aGH;
    private final g aGI;
    private final t aGJ;
    private long aGK = Long.MIN_VALUE;
    private final ae aGL;
    private final ae aGM;
    private final j aGN;
    long aGO;
    private boolean aGP;
    private boolean mg;

    protected w(q qVar, r rVar) {
        super(qVar);
        com.google.android.gms.common.internal.w.ah(rVar);
        this.aGI = new g(qVar);
        this.aGG = new u(qVar);
        this.aGH = new h(qVar);
        this.aGJ = r.d(qVar);
        this.aGN = new j(this.aFn.aFC);
        this.aGL = new ae(qVar) {
            public final void run() {
                w wVar = w.this;
                wVar.b(new ah() {
                    public final void mB() {
                        w.this.nK();
                    }
                });
            }
        };
        this.aGM = new 2(this, qVar);
    }

    private void a(s sVar, ak akVar) {
        com.google.android.gms.common.internal.w.ah(sVar);
        com.google.android.gms.common.internal.w.ah(akVar);
        c cVar = new c(this.aFn);
        String str = sVar.aGm;
        com.google.android.gms.common.internal.w.bg(str);
        Uri ba = d.ba(str);
        ListIterator listIterator = cVar.qn().listIterator();
        while (listIterator.hasNext()) {
            if (ba.equals(((ai) listIterator.next()).ok())) {
                listIterator.remove();
            }
        }
        cVar.qn().add(new d(cVar.aHe, str));
        cVar.aIm = sVar.aGn;
        ae oj = cVar.oj();
        h hVar = (h) oj.e(h.class);
        hVar.aWn = "data";
        hVar.aWs = true;
        oj.b(akVar);
        g gVar = (g) oj.e(g.class);
        aj ajVar = (aj) oj.e(aj.class);
        for (Entry entry : sVar.aFa.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if ("an".equals(str2)) {
                ajVar.aEV = str3;
            } else if ("av".equals(str2)) {
                ajVar.aEW = str3;
            } else if ("aid".equals(str2)) {
                ajVar.aYu = str3;
            } else if ("aiid".equals(str2)) {
                ajVar.aYv = str3;
            } else if ("uid".equals(str2)) {
                hVar.aWo = str3;
            } else {
                gVar.aFa.put(g.br(str2), str3);
            }
        }
        b("Sending installation campaign to", sVar.aGm, akVar);
        oj.aYb = nn().mR();
        ah ahVar = oj.aXY.aYi;
        if (oj.aYf) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (oj.aXZ) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            ae ql = oj.ql();
            ql.aYc = ql.aFC.elapsedRealtime();
            if (ql.aYb != 0) {
                ql.aYa = ql.aYb;
            } else {
                ql.aYa = ql.aFC.currentTimeMillis();
            }
            ql.aXZ = true;
            ahVar.aYo.execute(new 1(ahVar, ql));
        }
    }

    static /* synthetic */ void a(w wVar) {
        try {
            wVar.aGG.nB();
            wVar.nK();
        } catch (SQLiteException e) {
            wVar.f("Failed to delete stale hits", e);
        }
        wVar.aGM.ac(86400000);
    }

    private boolean aW(String str) {
        return this.aFn.mContext.checkCallingOrSelfPermission(str) == 0;
    }

    private long nC() {
        ah.nx();
        np();
        try {
            return this.aGG.nC();
        } catch (SQLiteException e) {
            g("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    private void nI() {
        if (!this.aGP && ac.nU() && !this.aGJ.isConnected()) {
            if (this.aGN.Y(((Long) aj.aIf.get()).longValue())) {
                this.aGN.start();
                aO("Connecting to service");
                if (this.aGJ.connect()) {
                    aO("Connected to service");
                    this.aGN.aFD = 0;
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean nJ() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.c.ah.nx();
        r12.np();
        r0 = "Dispatching a batch of local hits";
        r12.aO(r0);
        r0 = r12.aGJ;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002e;
    L_0x0016:
        r0 = com.google.android.gms.common.internal.f.aNr;
        if (r0 != 0) goto L_0x002e;
    L_0x001a:
        r0 = r1;
    L_0x001b:
        r3 = r12.aGH;
        r3 = r3.mO();
        if (r3 != 0) goto L_0x0030;
    L_0x0023:
        if (r0 == 0) goto L_0x0032;
    L_0x0025:
        if (r1 == 0) goto L_0x0032;
    L_0x0027:
        r0 = "No network or service available. Will retry later";
        r12.aO(r0);
    L_0x002d:
        return r2;
    L_0x002e:
        r0 = r2;
        goto L_0x001b;
    L_0x0030:
        r1 = r2;
        goto L_0x0023;
    L_0x0032:
        r0 = com.google.android.gms.analytics.internal.ac.nY();
        r1 = com.google.android.gms.analytics.internal.ac.nZ();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = 0;
        r4 = r0;
    L_0x0047:
        r0 = r12.aGG;	 Catch:{ all -> 0x01e4 }
        r0.beginTransaction();	 Catch:{ all -> 0x01e4 }
        r3.clear();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x00cb }
        r8 = r0.aa(r6);	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00cb }
        if (r0 == 0) goto L_0x007a;
    L_0x005b:
        r0 = "Store is empty, nothing to dispatch";
        r12.aO(r0);	 Catch:{ SQLiteException -> 0x00cb }
        r12.nM();	 Catch:{ SQLiteException -> 0x00cb }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x006f }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x006f }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x006f }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x006f }
        goto L_0x002d;
    L_0x006f:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
    L_0x007a:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00cb }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00cb }
        r12.d(r0, r1);	 Catch:{ SQLiteException -> 0x00cb }
        r1 = r8.iterator();	 Catch:{ all -> 0x01e4 }
    L_0x008c:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x00ed;
    L_0x0092:
        r0 = r1.next();	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r10 = r0.aFc;	 Catch:{ all -> 0x01e4 }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x008c;
    L_0x009e:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01e4 }
        r3 = r8.size();	 Catch:{ all -> 0x01e4 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01e4 }
        r12.d(r0, r1, r3);	 Catch:{ all -> 0x01e4 }
        r12.nM();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x00bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00bf }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x00bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00bf }
        goto L_0x002d;
    L_0x00bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
    L_0x00cb:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.f(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.nM();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00e1 }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x00e1 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00e1 }
        goto L_0x002d;
    L_0x00e1:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
    L_0x00ed:
        r0 = r12.aGJ;	 Catch:{ all -> 0x01e4 }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x0156;
    L_0x00f5:
        r0 = com.google.android.gms.common.internal.f.aNr;	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x00f9:
        r0 = "Service connected, sending hits to the service";
        r12.aO(r0);	 Catch:{ all -> 0x01e4 }
    L_0x00ff:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r0 != 0) goto L_0x0156;
    L_0x0105:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01e4 }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01e4 }
        r1 = r12.aGJ;	 Catch:{ all -> 0x01e4 }
        r1 = r1.d(r0);	 Catch:{ all -> 0x01e4 }
        if (r1 == 0) goto L_0x0156;
    L_0x0114:
        r10 = r0.aFc;	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01e4 }
        r8.remove(r0);	 Catch:{ all -> 0x01e4 }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.e(r1, r0);	 Catch:{ all -> 0x01e4 }
        r1 = r12.aGG;	 Catch:{ SQLiteException -> 0x0134 }
        r10 = r0.aFc;	 Catch:{ SQLiteException -> 0x0134 }
        r1.ab(r10);	 Catch:{ SQLiteException -> 0x0134 }
        r0 = r0.aFc;	 Catch:{ SQLiteException -> 0x0134 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0134 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0134 }
        goto L_0x00ff;
    L_0x0134:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.g(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.nM();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x014a }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x014a }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x014a }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x014a }
        goto L_0x002d;
    L_0x014a:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
    L_0x0156:
        r0 = r4;
        r4 = r12.aGH;	 Catch:{ all -> 0x01e4 }
        r4 = r4.mO();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x018b;
    L_0x015f:
        r4 = r12.aGH;	 Catch:{ all -> 0x01e4 }
        r9 = r4.s(r8);	 Catch:{ all -> 0x01e4 }
        r10 = r9.iterator();	 Catch:{ all -> 0x01e4 }
        r4 = r0;
    L_0x016a:
        r0 = r10.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r0 == 0) goto L_0x017f;
    L_0x0170:
        r0 = r10.next();	 Catch:{ all -> 0x01e4 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01e4 }
        r0 = r0.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01e4 }
        goto L_0x016a;
    L_0x017f:
        r8.removeAll(r9);	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x01a9 }
        r0.u(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r3.addAll(r9);	 Catch:{ SQLiteException -> 0x01a9 }
        r0 = r4;
    L_0x018b:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r4 == 0) goto L_0x01cb;
    L_0x0191:
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x019d }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x019d }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x019d }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x019d }
        goto L_0x002d;
    L_0x019d:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
    L_0x01a9:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.g(r1, r0);	 Catch:{ all -> 0x01e4 }
        r12.nM();	 Catch:{ all -> 0x01e4 }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x01bf }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01bf }
        r0 = r12.aGG;	 Catch:{ SQLiteException -> 0x01bf }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01bf }
        goto L_0x002d;
    L_0x01bf:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
    L_0x01cb:
        r4 = r12.aGG;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r12.aGG;	 Catch:{ SQLiteException -> 0x01d8 }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01d8 }
        r4 = r0;
        goto L_0x0047;
    L_0x01d8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
    L_0x01e4:
        r0 = move-exception;
        r1 = r12.aGG;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01f0 }
        r1 = r12.aGG;	 Catch:{ SQLiteException -> 0x01f0 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01f0 }
        throw r0;
    L_0x01f0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.g(r1, r0);
        r12.nM();
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.nJ():boolean");
    }

    private void nL() {
        ag nm = nm();
        if (nm.aHo && !nm.aHp) {
            long nC = nC();
            if (nC != 0 && Math.abs(this.aFn.aFC.currentTimeMillis() - nC) <= ((Long) aj.aHE.get()).longValue()) {
                d("Dispatch alarm scheduled (ms)", Long.valueOf(ac.nX()));
                nm.oh();
            }
        }
    }

    private void nM() {
        if (this.aGL.of()) {
            aO("All hits dispatched or no network/service. Going to power save mode");
        }
        this.aGL.cancel();
        ag nm = nm();
        if (nm.aHp) {
            nm.cancel();
        }
    }

    private long nN() {
        if (this.aGK != Long.MIN_VALUE) {
            return this.aGK;
        }
        return this.aFn.nv().ne() ? ((long) this.aFn.nv().nf()) * 1000 : ((Long) aj.aHz.get()).longValue();
    }

    private void nO() {
        np();
        q.nx();
        this.aGP = true;
        this.aGJ.disconnect();
        nK();
    }

    public final void aX(String str) {
        com.google.android.gms.common.internal.w.bg(str);
        q.nx();
        nl();
        ak a = k.a(this.aFn.nr(), str);
        if (a == null) {
            f("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence mV = nn().mV();
        if (str.equals(mV)) {
            aR("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(mV)) {
            nn().aK(str);
            if (nn().mS().Y(ac.oe())) {
                f("Campaign received too late, ignoring", a);
                return;
            }
            e("Received installation campaign", a);
            for (s a2 : this.aGG.nD()) {
                a(a2, a);
            }
        } else {
            d("Ignoring multiple install campaigns. original, new", mV, str);
        }
    }

    public final void b(ah ahVar) {
        long j = this.aGO;
        ah.nx();
        np();
        long j2 = -1;
        long mT = nn().mT();
        if (mT != 0) {
            j2 = Math.abs(this.aFn.aFC.currentTimeMillis() - mT);
        }
        e("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!f.aNr) {
            nI();
        }
        try {
            nJ();
            nn().mU();
            nK();
            if (ahVar != null) {
                ahVar.mB();
            }
            if (this.aGO != j) {
                g gVar = this.aGI;
                if (VERSION.SDK_INT > 10) {
                    Context context = gVar.aFn.mContext;
                    Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                    intent.addCategory(context.getPackageName());
                    intent.putExtra(g.aFm, true);
                    context.sendOrderedBroadcast(intent, null);
                }
            }
        } catch (Throwable th) {
            g("Local dispatch failed", th);
            nn().mU();
            nK();
            if (ahVar != null) {
                ahVar.mB();
            }
        }
    }

    public final void c(c cVar) {
        com.google.android.gms.common.internal.w.ah(cVar);
        ah.nx();
        np();
        if (this.aGP) {
            aP("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            d("Delivering hit", cVar);
        }
        if (TextUtils.isEmpty(cVar.l("_m", ""))) {
            Pair pair;
            i$a i_a = nn().aFz;
            long mX = i_a.mX();
            mX = mX == 0 ? 0 : Math.abs(mX - i_a.aFB.aFn.aFC.currentTimeMillis());
            if (mX < i_a.aFA) {
                pair = null;
            } else if (mX > i_a.aFA * 2) {
                i_a.mW();
                pair = null;
            } else {
                String string = i_a.aFB.aFw.getString(i_a.na(), null);
                long j = i_a.aFB.aFw.getLong(i_a.mZ(), 0);
                i_a.mW();
                pair = (string == null || j <= 0) ? null : new Pair(string, Long.valueOf(j));
            }
            if (pair != null) {
                String str = ((Long) pair.second) + ":" + ((String) pair.first);
                Map hashMap = new HashMap(cVar.aFa);
                hashMap.put("_m", str);
                cVar = new c(this, hashMap, cVar.aFd, cVar.aFf, cVar.aFc, cVar.aFe, cVar.aFb);
            }
        }
        nI();
        if (this.aGJ.d(cVar)) {
            aP("Hit sent to the device AnalyticsService for delivery");
        } else if (f.aNr) {
            this.aFn.nr().a(cVar, "Service unavailable on package side");
        } else {
            try {
                this.aGG.e(cVar);
                nK();
            } catch (SQLiteException e) {
                g("Delivery failed to save hit to a database", e);
                this.aFn.nr().a(cVar, "deliver: failed to insert hit to database");
            }
        }
    }

    protected final void c(s sVar) {
        q.nx();
        e("Sending first hit to property", sVar.aGm);
        if (!nn().mS().Y(ac.oe())) {
            Object mV = nn().mV();
            if (!TextUtils.isEmpty(mV)) {
                ak a = k.a(this.aFn.nr(), mV);
                e("Found relevant installation campaign", a);
                a(sVar, a);
            }
        }
    }

    public final long d(s sVar) {
        com.google.android.gms.common.internal.w.ah(sVar);
        np();
        q.nx();
        try {
            this.aGG.beginTransaction();
            this.aGG.b(sVar.aGk, sVar.aGl);
            long a = this.aGG.a(sVar.aGk, sVar.aGl, sVar.aGm);
            sVar.aGo = 1 + a;
            this.aGG.b(sVar);
            this.aGG.setTransactionSuccessful();
            try {
                this.aGG.endTransaction();
                return a;
            } catch (SQLiteException e) {
                g("Failed to end transaction", e);
                return a;
            }
        } catch (SQLiteException e2) {
            g("Failed to update Analytics property", e2);
            try {
                this.aGG.endTransaction();
            } catch (SQLiteException e22) {
                g("Failed to end transaction", e22);
            }
            return -1;
        } catch (Throwable th) {
            try {
                this.aGG.endTransaction();
            } catch (SQLiteException e3) {
                g("Failed to end transaction", e3);
            }
            throw th;
        }
    }

    protected final void mE() {
        this.aGG.nq();
        this.aGH.nq();
        this.aGJ.nq();
    }

    protected final void nH() {
        np();
        nn().mR();
        if (!aW("android.permission.ACCESS_NETWORK_STATE")) {
            aS("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            nO();
        }
        if (!aW("android.permission.INTERNET")) {
            aS("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            nO();
        }
        if (AnalyticsService.ab(this.aFn.mContext)) {
            aO("AnalyticsService registered in the app manifest and enabled");
        } else if (f.aNr) {
            aS("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            aR("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.aGP || f.aNr || this.aGG.isEmpty())) {
            nI();
        }
        nK();
    }

    public final void nK() {
        long j = 0;
        q.nx();
        np();
        boolean z = !this.aGP && ((!f.aNr || this.aFn.aFV.nT()) && nN() > 0);
        if (!z) {
            this.aGI.unregister();
            nM();
        } else if (this.aGG.isEmpty()) {
            this.aGI.unregister();
            nM();
        } else {
            if (((Boolean) aj.aIa.get()).booleanValue()) {
                z = true;
            } else {
                g gVar = this.aGI;
                gVar.mN();
                if (!gVar.aFo) {
                    Context context = gVar.aFn.mContext;
                    context.registerReceiver(gVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                    intentFilter.addCategory(context.getPackageName());
                    context.registerReceiver(gVar, intentFilter);
                    gVar.aFp = gVar.mO();
                    gVar.aFn.nr().d("Registering connectivity change receiver. Network connected", Boolean.valueOf(gVar.aFp));
                    gVar.aFo = true;
                }
                gVar = this.aGI;
                if (!gVar.aFo) {
                    gVar.aFn.nr().aR("Connectivity unknown. Receiver not registered");
                }
                z = gVar.aFp;
            }
            if (z) {
                nL();
                long nN = nN();
                long mT = nn().mT();
                if (mT != 0) {
                    mT = nN - Math.abs(this.aFn.aFC.currentTimeMillis() - mT);
                    if (mT <= 0) {
                        mT = Math.min(ac.nW(), nN);
                    }
                } else {
                    mT = Math.min(ac.nW(), nN);
                }
                d("Dispatch scheduled (ms)", Long.valueOf(mT));
                if (this.aGL.of()) {
                    ae aeVar = this.aGL;
                    mT = Math.max(1, mT + (aeVar.aHl == 0 ? 0 : Math.abs(aeVar.aFn.aFC.currentTimeMillis() - aeVar.aHl)));
                    aeVar = this.aGL;
                    if (!aeVar.of()) {
                        return;
                    }
                    if (mT < 0) {
                        aeVar.cancel();
                        return;
                    }
                    mT -= Math.abs(aeVar.aFn.aFC.currentTimeMillis() - aeVar.aHl);
                    if (mT >= 0) {
                        j = mT;
                    }
                    aeVar.getHandler().removeCallbacks(aeVar.aHk);
                    if (!aeVar.getHandler().postDelayed(aeVar.aHk, j)) {
                        aeVar.aFn.nr().g("Failed to adjust delayed post. time", Long.valueOf(j));
                        return;
                    }
                    return;
                }
                this.aGL.ac(mT);
                return;
            }
            nM();
            nL();
        }
    }

    public final void nj() {
        ah.nx();
        np();
        aO("Service disconnected");
    }

    protected final void onServiceConnected() {
        q.nx();
        if (!f.aNr) {
            ah.nx();
            np();
            nl();
            if (!ac.nU()) {
                aR("Service client disabled. Can't dispatch local hits to device AnalyticsService");
            }
            if (!this.aGJ.isConnected()) {
                aO("Service not connected");
            } else if (!this.aGG.isEmpty()) {
                aO("Dispatching local hits to device AnalyticsService");
                while (true) {
                    try {
                        List aa = this.aGG.aa((long) ac.nY());
                        if (!aa.isEmpty()) {
                            while (true) {
                                if (!aa.isEmpty()) {
                                    c cVar = (c) aa.get(0);
                                    if (this.aGJ.d(cVar)) {
                                        aa.remove(cVar);
                                        try {
                                            this.aGG.ab(cVar.aFc);
                                        } catch (SQLiteException e) {
                                            g("Failed to remove hit that was send for delivery", e);
                                            nM();
                                            return;
                                        }
                                    }
                                    nK();
                                    return;
                                }
                            }
                            List aa2 = this.aGG.aa((long) ac.nY());
                            if (!aa2.isEmpty()) {
                                nK();
                                return;
                            } else if (!aa2.isEmpty()) {
                                c cVar2 = (c) aa2.get(0);
                                if (this.aGJ.d(cVar2)) {
                                    aa2.remove(cVar2);
                                    try {
                                        this.aGG.ab(cVar2.aFc);
                                    } catch (SQLiteException e2) {
                                        g("Failed to remove hit that was send for delivery", e2);
                                        nM();
                                        return;
                                    }
                                }
                                nK();
                                return;
                            }
                        }
                        nK();
                        return;
                    } catch (SQLiteException e22) {
                        g("Failed to read hits from store", e22);
                        nM();
                        return;
                    }
                }
            }
        }
    }

    final void start() {
        np();
        com.google.android.gms.common.internal.w.d(!this.mg, "Analytics backend already started");
        this.mg = true;
        if (!f.aNr) {
            Context context = this.aFn.mContext;
            if (!AnalyticsReceiver.aa(context)) {
                aR("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!AnalyticsService.ab(context)) {
                aS("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
            }
            if (!CampaignTrackingReceiver.aa(context)) {
                aR("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!CampaignTrackingService.ab(context)) {
                aR("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            }
        }
        this.aFn.ns().d(new Runnable() {
            public final void run() {
                w.this.nH();
            }
        });
    }
}
