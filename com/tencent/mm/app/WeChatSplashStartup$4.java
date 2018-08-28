package com.tencent.mm.app;

import com.tencent.mm.blink.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WeChatSplashStartup$4 implements g {
    final /* synthetic */ WeChatSplashStartup bzp;

    WeChatSplashStartup$4(WeChatSplashStartup weChatSplashStartup) {
        this.bzp = weChatSplashStartup;
    }

    public final void vk() {
        com.tencent.mm.kernel.g.Ek().b(this);
        a.vh();
        WeChatSplashStartup.a(this.bzp);
        if (this.bzp.profile.ES()) {
            try {
                ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WeChatSplashStartup", e, "%s", new Object[]{e.getMessage()});
            }
        }
        if (this.bzp.profile.ES()) {
            com.tencent.mm.kernel.a Eg = com.tencent.mm.kernel.g.Eg();
            x.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[]{Boolean.valueOf(Eg.Dx()), Integer.valueOf(Eg.dpu), bi.cjd()});
            if (Eg.Dx() && Eg.dpu != 0) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcBootEnable, Eg.dpu);
                x.i("MMKernel.CoreAccount", "summerhardcoder stopPerformace[%s] stack[%s]", new Object[]{Integer.valueOf(Eg.dpu), bi.cjd()});
                Eg.dpu = 0;
            }
        }
    }

    public final void aF(boolean z) {
    }
}
