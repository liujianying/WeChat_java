package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;

public final class JsApiOperateBackgroundAudio$a extends h {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioNext";
    private static final JsApiOperateBackgroundAudio$a fIm = new JsApiOperateBackgroundAudio$a();

    static synchronized void c(c cVar) {
        synchronized (JsApiOperateBackgroundAudio$a.class) {
            x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
            fIm.a(cVar).ahM();
        }
    }
}
