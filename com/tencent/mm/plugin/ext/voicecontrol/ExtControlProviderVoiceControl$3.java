package com.tencent.mm.plugin.ext.voicecontrol;

class ExtControlProviderVoiceControl$3 implements Runnable {
    final /* synthetic */ ExtControlProviderVoiceControl iLn;
    final /* synthetic */ a iLo;

    ExtControlProviderVoiceControl$3(ExtControlProviderVoiceControl extControlProviderVoiceControl, a aVar) {
        this.iLn = extControlProviderVoiceControl;
        this.iLo = aVar;
    }

    public final void run() {
        this.iLn.a(this.iLo.iLq, this.iLo.appId, this.iLo.iLr);
    }
}
