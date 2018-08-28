package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.websearch.a.a;

class WebSearchVoiceUI$1 implements a {
    final /* synthetic */ WebSearchVoiceUI qfC;

    WebSearchVoiceUI$1(WebSearchVoiceUI webSearchVoiceUI) {
        this.qfC = webSearchVoiceUI;
    }

    public final void bXG() {
        this.qfC.setResult(0);
        h.mEJ.h(15178, new Object[]{Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(this.qfC), WebSearchVoiceUI.b(this.qfC), Integer.valueOf(WebSearchVoiceUI.c(this.qfC)), Integer.valueOf(WebSearchVoiceUI.d(this.qfC))});
        this.qfC.finish();
    }

    public final void RA(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 2) {
            str = str.substring(0, str.length() - 1);
        }
        Intent intent = new Intent();
        intent.putExtra("text", str);
        this.qfC.setResult(0, intent);
        h.mEJ.h(15178, new Object[]{Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.a(this.qfC), WebSearchVoiceUI.b(this.qfC), Integer.valueOf(WebSearchVoiceUI.c(this.qfC)), Integer.valueOf(WebSearchVoiceUI.d(this.qfC))});
        this.qfC.finish();
    }

    public final void ki(boolean z) {
        if (z) {
            h.mEJ.h(15178, new Object[]{Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.a(this.qfC), WebSearchVoiceUI.b(this.qfC), Integer.valueOf(WebSearchVoiceUI.c(this.qfC)), Integer.valueOf(WebSearchVoiceUI.d(this.qfC))});
        }
    }
}
