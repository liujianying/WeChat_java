package com.tencent.mm.plugin.webview.fts.b.a;

import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class a$1 implements Runnable {
    final /* synthetic */ String fFV;
    final /* synthetic */ View pPN;
    final /* synthetic */ a pPO;

    public a$1(a aVar, String str, View view) {
        this.pPO = aVar;
        this.fFV = str;
        this.pPN = view;
    }

    public final void run() {
        try {
            c.a(c.dk(this.pPN), 100, CompressFormat.PNG, this.pPO.Qh(this.fFV).pPU + File.separator + "pic.png", true);
            x.i("SearchWidgetTestUiMgr", "saved widget image to %s", new Object[]{r0});
        } catch (Throwable e) {
            x.printErrStackTrace("SearchWidgetTestUiMgr", e, "", new Object[0]);
        }
    }
}
