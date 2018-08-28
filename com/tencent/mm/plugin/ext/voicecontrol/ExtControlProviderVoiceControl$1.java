package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderVoiceControl$1 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ String iLj;
    final /* synthetic */ String iLk;
    final /* synthetic */ String iLl;
    final /* synthetic */ String iLm;
    final /* synthetic */ ExtControlProviderVoiceControl iLn;

    ExtControlProviderVoiceControl$1(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str, String str2, String str3, String str4, String str5) {
        this.iLn = extControlProviderVoiceControl;
        this.iLj = str;
        this.ewx = str2;
        this.iLk = str3;
        this.iLl = str4;
        this.iLm = str5;
    }

    public final void run() {
        int i = bi.getInt(this.iLj, 4);
        if (i == 1) {
            ExtControlProviderVoiceControl.a(this.iLn, this.ewx);
        } else {
            x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
        if (!ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.a(this.iLn), i, bi.getInt(this.iLk, 4), bi.getInt(this.iLl, 16000), bi.getInt(this.iLm, 16), this.ewx)) {
            x.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
            ExtControlProviderVoiceControl.b(this.iLn);
            this.iLn.iLf.countDown();
        }
    }
}
