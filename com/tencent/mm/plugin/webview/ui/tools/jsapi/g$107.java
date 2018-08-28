package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import java.io.File;

class g$107 implements Runnable {
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjV;
    final /* synthetic */ File qjW;

    g$107(g gVar, File file, String str) {
        this.qiK = gVar;
        this.qjW = file;
        this.qjV = str;
    }

    public final void run() {
        String m = g.m(this.qjW);
        au.HU();
        String L = EmojiLogic.L(c.Gg(), "", m);
        if (!FileOp.cn(L)) {
            FileOp.y(this.qjW.getAbsolutePath(), L);
        }
        g.a(this.qiK, m, this.qjV);
    }
}
