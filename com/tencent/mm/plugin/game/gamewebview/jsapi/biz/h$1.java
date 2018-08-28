package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.ui.MMActivity.a;

class h$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ GameWebViewUI jGR;
    final /* synthetic */ h jGS;

    h$1(h hVar, d dVar, int i, GameWebViewUI gameWebViewUI) {
        this.jGS = hVar;
        this.jGF = dVar;
        this.doP = i;
        this.jGR = gameWebViewUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r9, int r10, android.content.Intent r11) {
        /*
        r8 = this;
        r2 = 0;
        r7 = 1;
        r1 = 0;
        r0 = 14;
        if (r9 != r0) goto L_0x0048;
    L_0x0007:
        if (r11 != 0) goto L_0x0049;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        r3 = "MicroMsg.GameJsApiChooseImage";
        r4 = "request to open file chooser, result code = %d, hasShowMemoryWarning = %b";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = java.lang.Integer.valueOf(r10);
        r5[r1] = r6;
        r6 = java.lang.Boolean.valueOf(r0);
        r5[r7] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = new java.util.HashMap;
        r3.<init>();
        if (r0 == 0) goto L_0x0033;
    L_0x0029:
        r0 = "memoryWarning";
        r4 = java.lang.Boolean.valueOf(r7);
        r3.put(r0, r4);
    L_0x0033:
        switch(r10) {
            case -1: goto L_0x0051;
            case 0: goto L_0x0093;
            default: goto L_0x0036;
        };
    L_0x0036:
        r0 = r8.jGF;
        r1 = r8.doP;
        r4 = "chooseImage:fail";
        r3 = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.h.f(r4, r3);
        r0.E(r1, r3);
    L_0x0044:
        r0 = r8.jGR;
        r0.geJ = r2;
    L_0x0048:
        return;
    L_0x0049:
        r0 = "key_pick_local_media_show_memory_warning";
        r0 = r11.getBooleanExtra(r0, r1);
        goto L_0x000a;
    L_0x0051:
        if (r11 == 0) goto L_0x0091;
    L_0x0053:
        r0 = "key_pick_local_pic_callback_local_ids";
        r0 = r11.getStringExtra(r0);
    L_0x005a:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r4 != 0) goto L_0x0036;
    L_0x0060:
        r4 = "MicroMsg.GameJsApiChooseImage";
        r5 = "localIds = %s";
        r6 = new java.lang.Object[r7];
        r6[r1] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r1 = "localIds";
        r3.put(r1, r0);
        r0 = "key_pick_local_pic_source_type";
        r0 = r11.getStringExtra(r0);
        if (r0 == 0) goto L_0x0082;
    L_0x007c:
        r1 = "sourceType";
        r3.put(r1, r0);
    L_0x0082:
        r0 = r8.jGF;
        r1 = r8.doP;
        r4 = "chooseImage:ok";
        r3 = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.h.f(r4, r3);
        r0.E(r1, r3);
        goto L_0x0044;
    L_0x0091:
        r0 = r2;
        goto L_0x005a;
    L_0x0093:
        r0 = r8.jGF;
        r1 = r8.doP;
        r4 = "chooseImage:cancel";
        r3 = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.h.f(r4, r3);
        r0.E(r1, r3);
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.gamewebview.jsapi.biz.h$1.b(int, int, android.content.Intent):void");
    }
}
