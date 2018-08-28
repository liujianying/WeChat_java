package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements d {
    final /* synthetic */ AppBrandLivePlayerView fRH;
    final /* synthetic */ b fRI;

    b$3(b bVar, AppBrandLivePlayerView appBrandLivePlayerView) {
        this.fRI = bVar;
        this.fRH = appBrandLivePlayerView;
    }

    public final void agK() {
        j tC;
        l lVar = this.fRH.fRA;
        lVar.fSb = lVar.fRX.isPlaying();
        if (lVar.fSb && lVar.fSh) {
            if (lVar.fRE && lVar.fRY != null) {
                lVar.fRY.onPlayEvent(6000, new Bundle());
            }
            tC = lVar.tC("pause");
        } else {
            tC = new j();
        }
        x.i("MicroMsg.AppBrandLivePlayerView", "onBackground code:%d info:%s", new Object[]{Integer.valueOf(tC.errorCode), tC.fRT});
    }
}
