package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.g.a.ub;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

public class h {
    private static volatile h kfM = null;

    public static h aVz() {
        if (kfM == null) {
            synchronized (h.class) {
                if (kfM == null) {
                    kfM = new h();
                }
            }
        }
        return kfM;
    }

    public final void aC(final String str, final boolean z) {
        if (bi.oW(str)) {
            j(z, str);
            return;
        }
        AnonymousClass1 anonymousClass1 = new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                if (this.object instanceof String) {
                    h.a(h.this, (String) this.object, z);
                } else {
                    h.j(z, str);
                }
            }
        };
        anonymousClass1.object = str;
        x.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
        if (bi.oW(str)) {
            j(z, str);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[]{str, Boolean.valueOf(z)});
        WepkgVersion Em = g.Em(str);
        if (Em == null) {
            j(z, str);
        } else if (Em.kfX) {
            anonymousClass1.a(null);
        } else {
            g.a(1, Em.kfA, "", Em.downloadUrl, (long) Em.kfV, Em.version, Em.bKg, Em.kfm, new 2(this, anonymousClass1, z, str));
        }
    }

    private void a(String str, List<WepkgPreloadFile> list, boolean z) {
        try {
            if (bi.cX(list)) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
                if (bi.oW(str)) {
                    j(z, str);
                    return;
                }
                if (bi.cX(g.Eo(str))) {
                    WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.nc = 3006;
                    wepkgCrossProcessTask.kff.kfA = str;
                    wepkgCrossProcessTask.kff.kfY = true;
                    if (ad.cic()) {
                        wepkgCrossProcessTask.aai();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask);
                    }
                    WepkgVersion Em = g.Em(str);
                    if (!(Em == null || Em.createTime == 0)) {
                        a.b("downloadCompleteTime", "", Em.kfA, Em.version, -1, System.currentTimeMillis() - (Em.createTime * 1000), null);
                        wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.nc = 3007;
                        wepkgCrossProcessTask.kff.kfA = str;
                        if (ad.cic()) {
                            wepkgCrossProcessTask.aai();
                        } else {
                            WepkgMainProcessService.b(wepkgCrossProcessTask);
                        }
                    }
                    j(z, str);
                    x.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
                    return;
                }
                x.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[]{Integer.valueOf(g.Eo(str).size())});
                j(z, str);
                return;
            }
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) list.remove(0);
            if (wepkgPreloadFile != null) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[]{wepkgPreloadFile.kfA, wepkgPreloadFile.version, wepkgPreloadFile.kfk});
                3 3 = new 3(this, str, list, z);
                3.object = wepkgPreloadFile;
                g.a(2, wepkgPreloadFile.kfA, wepkgPreloadFile.kfk, wepkgPreloadFile.downloadUrl, (long) wepkgPreloadFile.size, wepkgPreloadFile.version, wepkgPreloadFile.bKg, wepkgPreloadFile.kfm, 3);
                return;
            }
            x.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
            a(str, (List) list, z);
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[]{e.getMessage()});
        }
    }

    private static void j(boolean z, String str) {
        if (z) {
            ub ubVar = new ub();
            ubVar.cfW.bIH = 0;
            com.tencent.mm.sdk.b.a.sFg.m(ubVar);
        }
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = TXLiveConstants.PLAY_EVT_PLAY_END;
        wepkgCrossProcessTask.kff.kfA = str;
        if (ad.cic()) {
            wepkgCrossProcessTask.aai();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        f.Ej(str);
    }
}
