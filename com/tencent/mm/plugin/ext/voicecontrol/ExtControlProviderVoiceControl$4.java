package com.tencent.mm.plugin.ext.voicecontrol;

class ExtControlProviderVoiceControl$4 implements Runnable {
    final /* synthetic */ ExtControlProviderVoiceControl iLn;
    final /* synthetic */ a iLo;

    ExtControlProviderVoiceControl$4(ExtControlProviderVoiceControl extControlProviderVoiceControl, a aVar) {
        this.iLn = extControlProviderVoiceControl;
        this.iLo = aVar;
    }

    public final void run() {
        this.iLn.a(this.iLo.iLq, this.iLo.appId, this.iLo.iLr);
    }
}
