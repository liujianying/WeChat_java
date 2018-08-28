package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.a.b;
import com.tencent.mm.plugin.webview.modelcache.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class q$5 implements Runnable {
    final /* synthetic */ q pTs;
    final /* synthetic */ List pTy;

    public q$5(q qVar, List list) {
        this.pTs = qVar;
        this.pTy = list;
    }

    public final void run() {
        for (String str : this.pTy) {
            x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate requestURL = %s", str);
            if (!bi.oW(str)) {
                int bUG;
                if (str.startsWith("http://")) {
                    bUG = a.bUG();
                } else if (str.startsWith("https://")) {
                    bUG = a.An(a.bUG());
                } else {
                    x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, unsupported scheme, url = %s", str);
                }
                String QE = p.QE(str);
                k bUI = k.bUI();
                List n = !bUI.fAQ ? null : bi.oW(QE) ? null : bUI.n(String.format("select * from %s where %s=? and %s=?", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", "protocol"}), new String[]{String.valueOf(ac.ce(QE).hashCode()), String.valueOf(bUG)});
                if (bi.cX(n)) {
                    x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, not cached requestURL = %s, parsed mainURL = %s, protocol = %s", str, QE, a.toString(bUG));
                } else {
                    String QE2 = p.QE(str);
                    if (!bi.oW(QE2)) {
                        Object obj;
                        long VE = bi.VE();
                        for (f fVar : n) {
                            if (VE - fVar.field_createTime > 60 && QE2.equals(fVar.field_version)) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, createTime not exceed 1min, no need to update this mainDocument, url = %s", str);
                        } else {
                            byte[] QG = p.QG(str);
                            if (bi.bC(QG)) {
                                x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, get empty bytes from requestURL = %s", str);
                            } else {
                                k bUI2 = k.bUI();
                                List n2 = !bUI2.fAQ ? null : bi.oW(QE) ? null : bUI2.n(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", k.Ap(bUG)}), new String[]{String.valueOf(ac.ce(QE).hashCode())});
                                if (bi.cX(n2)) {
                                    x.e("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, get empty list ");
                                } else {
                                    String t = ac.t(QG);
                                    for (f fVar2 : n2) {
                                        x.d("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cacheRes = %s", fVar2);
                                        if (!bi.oW(fVar2.field_localPath)) {
                                            if (t.equals(fVar2.field_contentMd5)) {
                                                x.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cache not updated");
                                            } else {
                                                a Qz = a.Qz(fVar2.field_appId);
                                                if (Qz != null) {
                                                    String str2 = fVar2.field_localPath;
                                                    if (!(bi.oW(str2) || bi.bC(QG))) {
                                                        if ((FileOp.l(str2, QG) == 0 ? 1 : null) != null && str2.startsWith(Qz.path)) {
                                                            b.a(Qz.pSM, Qz.appId, (long) QG.length);
                                                        }
                                                    }
                                                    fVar2.field_contentMd5 = t;
                                                    k.bUI().b(fVar2);
                                                    x.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, updated cacheRes = %s", fVar2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
