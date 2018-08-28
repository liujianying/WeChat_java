package com.tencent.mm.pluginsdk.ui;

class VoiceInputLayoutImpl$7 implements Runnable {
    final /* synthetic */ VoiceInputLayoutImpl qHI;
    final /* synthetic */ int qHK;

    VoiceInputLayoutImpl$7(VoiceInputLayoutImpl voiceInputLayoutImpl, int i) {
        this.qHI = voiceInputLayoutImpl;
        this.qHK = i;
    }

    public final void run() {
        VoiceInputLayoutImpl.a(this.qHI).BU(this.qHK);
    }
}
