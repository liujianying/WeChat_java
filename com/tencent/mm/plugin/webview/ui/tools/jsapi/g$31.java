package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.pluginsdk.ui.applet.n;

class g$31 implements n {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$31(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void ky(int i) {
        switch (i) {
            case -2:
                g.a(this.qiK, this.qiH, "add_contact:added", null);
                return;
            case -1:
                g.a(this.qiK, this.qiH, "add_contact:fail", null);
                return;
            case 0:
                g.a(this.qiK, this.qiH, "add_contact:cancel", null);
                return;
            case 1:
                g.a(this.qiK, this.qiH, "add_contact:ok", null);
                return;
            default:
                g.a(this.qiK, this.qiH, "add_contact:fail", null);
                return;
        }
    }
}
