package com.tencent.mm.pluginsdk.ui.websearch;

class WebSearchVoiceInputLayoutImpl$7 implements Runnable {
    final /* synthetic */ int qHK;
    final /* synthetic */ WebSearchVoiceInputLayoutImpl qUF;

    WebSearchVoiceInputLayoutImpl$7(WebSearchVoiceInputLayoutImpl webSearchVoiceInputLayoutImpl, int i) {
        this.qUF = webSearchVoiceInputLayoutImpl;
        this.qHK = i;
    }

    public final void run() {
        WebSearchVoiceInputLayoutImpl.b(this.qUF).BU(this.qHK);
    }
}
