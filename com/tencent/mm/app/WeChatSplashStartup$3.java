package com.tencent.mm.app;

import com.tencent.mm.kernel.api.g;
import com.tencent.mm.splash.h;
import com.tencent.mm.splash.o.a;
import java.io.File;

class WeChatSplashStartup$3 implements g {
    final /* synthetic */ a bzo;
    final /* synthetic */ WeChatSplashStartup bzp;
    final /* synthetic */ boolean bzu;

    WeChatSplashStartup$3(WeChatSplashStartup weChatSplashStartup, boolean z, a aVar) {
        this.bzp = weChatSplashStartup;
        this.bzu = z;
        this.bzo = aVar;
    }

    public final void vk() {
        com.tencent.mm.kernel.g.Ek().b(this);
        if (this.bzu) {
            h.b("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
            String cjM = com.tencent.mm.splash.a.cjM();
            if (new File(cjM).exists()) {
                File file = new File(cjM + "/main-process-blocking");
                if (file.exists()) {
                    boolean delete = file.delete();
                    h.b("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[]{Boolean.valueOf(delete)});
                    return;
                }
                return;
            }
            h.b("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
            return;
        }
        this.bzo.done();
    }

    public final void aF(boolean z) {
    }
}
