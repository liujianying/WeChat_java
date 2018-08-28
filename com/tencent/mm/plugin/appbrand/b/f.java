package com.tencent.mm.plugin.appbrand.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.b;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.x;

abstract class f extends g {
    final g fdO;
    int fjG = 0;
    private final b fjH = new 1(this);
    private final com.tencent.mm.plugin.appbrand.ui.banner.f fjI = new 2(this);

    abstract void acx();

    f(h hVar, g gVar) {
        super(hVar);
        this.fdO = gVar;
    }

    public void enter() {
        super.enter();
        this.fjG = 0;
        String str = this.fdO.mAppId;
        int i = this.fdO.fct.fig;
        if (this.fdO.fcu == null || !this.fdO.fcu.frh) {
            i = 0;
        } else {
            i = 1;
        }
        AppBrandMusicClientService appBrandMusicClientService;
        if (i == 0) {
            appBrandMusicClientService = AppBrandMusicClientService.ghS;
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase(appBrandMusicClientService.ghT)) {
                    StopBackgroundMusicTask stopBackgroundMusicTask = new StopBackgroundMusicTask();
                    stopBackgroundMusicTask.appId = str;
                    AppBrandMainProcessService.a(stopBackgroundMusicTask);
                } else {
                    x.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
                }
            }
        } else if (AppBrandMusicClientService.ut(str)) {
            cf(1);
            appBrandMusicClientService = AppBrandMusicClientService.ghS;
            b bVar = this.fjH;
            if (!(TextUtils.isEmpty(str) || bVar == null)) {
                if (appBrandMusicClientService.ghR.containsKey(str)) {
                    appBrandMusicClientService.ghR.remove(str);
                    appBrandMusicClientService.ghR.put(str, bVar);
                } else {
                    appBrandMusicClientService.ghR.put(str, bVar);
                }
            }
        }
        if (e.qn(str) != c.fci) {
            a.anT();
        } else {
            cf(2);
            a.d(this.fjI);
        }
        switch (3.fjK[e.qn(str).ordinal()]) {
            case 1:
                cf(16);
                break;
            case 2:
                cf(4);
                break;
            case 3:
                cf(8);
                break;
        }
        this.fjG = this.fjG;
        jH(0);
    }

    public void exit() {
        super.exit();
        this.fjG = 0;
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ghS;
        CharSequence charSequence = this.fdO.mAppId;
        if (!TextUtils.isEmpty(charSequence) && appBrandMusicClientService.ghR.containsKey(charSequence)) {
            appBrandMusicClientService.ghR.remove(charSequence);
        }
        a.c(this.fjI);
    }

    private void cf(int i) {
        this.fjG |= i;
    }

    final void jH(int i) {
        this.fjG &= i ^ -1;
        if (this.fjG == 0) {
            acx();
        }
    }
}
