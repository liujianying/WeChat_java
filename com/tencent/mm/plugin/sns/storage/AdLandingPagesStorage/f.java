package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mm.k.g;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class f {
    private static f nIy = new f();
    ConcurrentLinkedQueue<String> nIx = new ConcurrentLinkedQueue();

    public static f bAB() {
        return nIy;
    }

    private f() {
    }

    private boolean Ng(String str) {
        return this.nIx.contains(str);
    }

    private void a(String str, s sVar) {
        p pVar;
        if (sVar.nAX == s$l.AppCompatTheme_buttonStyleSmall) {
            Iterator it = ((n) sVar).nAH.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((m) it.next()).nAH.iterator();
                while (it2.hasNext()) {
                    a(str, (s) it2.next());
                }
            }
        } else if (sVar.nAX == 41) {
            pVar = (p) sVar;
            if (!Ng(pVar.nAL)) {
                this.nIx.add(pVar.nAL);
                d.b(str, pVar.nAL, true, sVar.nAX, new 1(this, pVar));
            }
        } else if (sVar.nAX == 44) {
            o oVar = (o) sVar;
            if (!Ng(oVar.nAL)) {
                this.nIx.add(oVar.nAL);
                d.b(str, oVar.nAL, true, sVar.nAX, new 3(this, oVar));
            }
        } else if (sVar.nAX == 45) {
            pVar = (p) sVar;
            if (!Ng(pVar.nAL)) {
                this.nIx.add(pVar.nAL);
                d.b(str, pVar.nAL, true, sVar.nAX, new 4(this, pVar));
            }
        } else if (sVar.nAX == 61) {
            q qVar = (q) sVar;
            if (!Ng(qVar.nAN)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                c.NM();
                if (c.a(pInt, pInt2)) {
                    this.nIx.add(qVar.nAN);
                    d.c(str, qVar.nAN, true, 61, new 5(this, qVar));
                }
            }
            if (!Ng(qVar.nAO)) {
                this.nIx.add(qVar.nAO);
                d.b(str, qVar.nAO, true, 1000000001, new 6(this, qVar));
            }
        } else if (sVar.nAX == 62) {
            boolean z = g.AT().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
            x.i("AdLandingPagesPreDownloadResHelper", "pre down video value: " + z);
            w wVar = (w) sVar;
            if (z && !Ng(wVar.nAP)) {
                this.nIx.add(wVar.nAP);
                d.a(str, wVar.nAP, true, sVar.nAX, new 7(this, wVar));
            }
            if (!Ng(wVar.nBz)) {
                this.nIx.add(wVar.nBz);
                d.b("adId", wVar.nBz, true, sVar.nAX, new 8(this, wVar));
            }
        }
    }

    private void Nh(String str) {
        if (!TextUtils.isEmpty(str) && !Ng(str)) {
            this.nIx.add(str);
            d.b("adId", str, true, 0, new 9(this, str));
        }
    }

    public final void e(final String str, String str2, String str3, int i) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        LinkedList p = e.p(str2, str3, "", "");
        int i2;
        int i3;
        Iterator it;
        int i4;
        c cVar;
        Iterator it2;
        if (i == 0) {
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
                i2 = g.AT().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
                i3 = g.AT().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
                if (p.size() > 0) {
                    it = p.iterator();
                    while (true) {
                        i4 = i2;
                        if (it.hasNext()) {
                            cVar = (c) it.next();
                            Nh(cVar.nIg);
                            if (i3 > 0 && i4 > 0) {
                                it2 = cVar.nIi.iterator();
                                while (it2.hasNext()) {
                                    final s sVar = (s) it2.next();
                                    ah.A(new Runnable() {
                                        public final void run() {
                                            f.this.a(str, sVar);
                                        }
                                    });
                                    i2 = i3 - 1;
                                    if (i2 <= 0) {
                                        break;
                                    }
                                    i3 = i2;
                                }
                                i2 = i3;
                                i4--;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
                return;
            }
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
            Iterator it3 = p.iterator();
            while (it3.hasNext()) {
                c cVar2 = (c) it3.next();
                it = cVar2.nIi.iterator();
                while (it.hasNext()) {
                    a(str, (s) it.next());
                }
                Nh(cVar2.nIg);
            }
        } else if (i == 1) {
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
                Iterator it4 = p.iterator();
                while (it4.hasNext()) {
                    Nh(((c) it4.next()).nIg);
                }
                return;
            }
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
            i2 = g.AT().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
            i3 = g.AT().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
            if (p.size() > 0) {
                it = p.iterator();
                while (true) {
                    i4 = i2;
                    if (it.hasNext()) {
                        cVar = (c) it.next();
                        Nh(cVar.nIg);
                        if (i3 > 0 && i4 > 0) {
                            it2 = cVar.nIi.iterator();
                            while (it2.hasNext()) {
                                ah.A(new 2(this, str, (s) it2.next()));
                                i2 = i3 - 1;
                                if (i2 <= 0) {
                                    break;
                                }
                                i3 = i2;
                            }
                            i2 = i3;
                            i4--;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        } else {
            x.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
        }
    }
}
