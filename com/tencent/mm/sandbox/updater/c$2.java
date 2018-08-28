package com.tencent.mm.sandbox.updater;

import android.os.Message;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$2 implements Runnable {
    final /* synthetic */ c sDP;
    final /* synthetic */ bhp sDQ;

    c$2(c cVar, bhp bhp) {
        this.sDP = cVar;
        this.sDQ = bhp;
    }

    public final void run() {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = this.sDQ;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        int h = i.h(ad.getContext(), this.sDP.beJ(), this.sDP.cgL(), c.c(this.sDP));
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
        if (h == 0) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
            obtain.arg1 = 0;
            c.d(this.sDP).sendMessage(obtain);
            return;
        }
        x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
        File file = new File(this.sDP.cgL());
        if (file.exists()) {
            file.delete();
        }
        if (h == -1) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
            obtain.arg1 = 3;
            c.d(this.sDP).sendMessage(obtain);
        } else if (h == -2) {
            x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
            obtain.arg1 = 4;
            c.d(this.sDP).sendMessage(obtain);
        }
    }
}
