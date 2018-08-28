package com.tencent.mm.plugin.readerapp.ui;

import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a;
import com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.a.b;
import com.tencent.mm.pluginsdk.ui.applet.e$a;

class ReaderAppUI$a$2 implements e$a {
    final /* synthetic */ a mnZ;
    final /* synthetic */ b moa;

    ReaderAppUI$a$2(a aVar, b bVar) {
        this.mnZ = aVar;
        this.moa = bVar;
    }

    public final void onFinish() {
        if (a.a(this.mnZ) > 1) {
            this.moa.moe.setTextColor(this.mnZ.mnQ.mController.tml.getResources().getColor(com.tencent.mm.plugin.readerapp.a.a.white));
            this.moa.moe.setBackgroundResource(c.biz_item_cover_gradient_bg);
        }
        this.moa.mof.setVisibility(0);
    }
}
