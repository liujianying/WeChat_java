package com.tencent.mm.plugin.appbrand.game.cgipkg;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.by.f;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends com.tencent.mm.ab.a<adz> {
    private static final Map<String, adz> fAz = new ConcurrentHashMap();
    private final b fmB;

    protected final /* synthetic */ void a(int i, int i2, String str, bhp bhp, l lVar) {
        adz adz = (adz) bhp;
        x.i("MicroMsg.AppBrand.CgiGetGameMenu", "onCgiBack, req [appid %s]resp [errType %s, errCode %s, errMsg %s, resp %s]", new Object[]{getAppId(), Integer.valueOf(i), Integer.valueOf(i2), str, adz});
        if (i == 0 && i2 == 0 && adz != null) {
            GameMenuParcel gameMenuParcel = new GameMenuParcel();
            gameMenuParcel.appId = getAppId();
            gameMenuParcel.fAA = adz;
            d.c(gameMenuParcel);
            fAz.put(getAppId(), adz);
        }
    }

    private String getAppId() {
        return ((ady) this.fmB.dID.dIL).bPS;
    }

    public final synchronized f<com.tencent.mm.ab.a.a<adz>> KM() {
        fAz.remove(getAppId());
        return super.KM();
    }

    public static adz sN(String str) {
        return bi.oW(str) ? null : (adz) fAz.get(str);
    }
}
