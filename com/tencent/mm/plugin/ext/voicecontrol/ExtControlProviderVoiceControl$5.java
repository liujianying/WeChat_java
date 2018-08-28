package com.tencent.mm.plugin.ext.voicecontrol;

import com.qq.wx.voice.embed.recognizer.a;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderVoiceControl$5 implements c {
    final /* synthetic */ ExtControlProviderVoiceControl iLn;

    ExtControlProviderVoiceControl$5(ExtControlProviderVoiceControl extControlProviderVoiceControl) {
        this.iLn = extControlProviderVoiceControl;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
            return;
        }
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.c(this.iLn)), aVar.text, aVar.name});
        if (!bi.oW(aVar.name)) {
            ExtControlProviderVoiceControl.d(this.iLn);
            ExtControlProviderVoiceControl.b(this.iLn, aVar.name);
        }
    }

    public final void ej(int i) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[]{Integer.valueOf(i)});
    }
}
