package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.appbrand.appcache.ah.c;
import com.tencent.mm.plugin.appbrand.appcache.base.a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class ah$a {
    private ah$a() {
    }

    /* synthetic */ ah$a(byte b) {
        this();
    }

    public final m a(c cVar) {
        String cco = cVar.cco();
        x.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", new Object[]{cVar.fhq});
        try {
            al alVar;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            h hVar = new h();
            a abZ = cVar.abZ();
            String str = abZ.qBy;
            s.a aVar = cVar.fhr;
            if (cVar.abZ().fin) {
                alVar = new al(com.tencent.mm.bu.a.coq().getLooper(), new 1(this, str, aVar, abZ, hVar, countDownLatch), false);
            } else {
                alVar = null;
            }
            final h hVar2 = hVar;
            final CountDownLatch countDownLatch2 = countDownLatch;
            AnonymousClass2 anonymousClass2 = new a(cVar) {
                final void b(m mVar) {
                    if (alVar != null) {
                        alVar.SO();
                    }
                    hVar2.value = mVar;
                    countDownLatch2.countDown();
                }
            };
            i iVar = new i();
            iVar.field_mediaId = str;
            iVar.field_fullpath = abZ.getFilePath();
            iVar.dPW = abZ.url;
            iVar.ceW = false;
            iVar.dPV = anonymousClass2;
            iVar.dPX = (int) TimeUnit.MILLISECONDS.toSeconds((long) abZ.getConnectTimeout());
            iVar.dPY = (int) TimeUnit.MILLISECONDS.toSeconds((long) abZ.getReadTimeout());
            iVar.field_fileType = b.dOw;
            if (abZ instanceof f) {
                iVar.dQa = false;
            }
            String host = Uri.parse(iVar.dPW).getHost();
            if (!bi.oW(host)) {
                ArrayList arrayList = new ArrayList();
                try {
                    g.Eh().dpP.dJs.getHostByName(host, arrayList);
                    iVar.dPZ = new String[arrayList.size()];
                    arrayList.toArray(iVar.dPZ);
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", new Object[]{e});
                }
            }
            com.tencent.mm.modelcdntran.g.ND().b(iVar, -1);
            if (alVar != null) {
                long readTimeout = (long) abZ.getReadTimeout();
                alVar.J(readTimeout, readTimeout);
            }
            try {
                countDownLatch.await();
                return (m) hVar.value;
            } catch (Exception e2) {
                x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[]{cco, e2});
                return null;
            }
        } catch (Exception e22) {
            x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[]{cco, e22});
            return null;
        }
    }
}
