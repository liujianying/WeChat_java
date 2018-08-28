package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.compatible.a.a.a;

class ExtControlProviderVoiceControl$6 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ ExtControlProviderVoiceControl iLn;

    ExtControlProviderVoiceControl$6(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        this.iLn = extControlProviderVoiceControl;
        this.dhF = str;
    }

    public final void run() {
        ExtControlProviderVoiceControl.c(this.iLn, this.dhF);
    }
}
