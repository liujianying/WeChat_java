package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ak.d;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.9;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.61;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class GameWebViewUI$2 implements c {
    final /* synthetic */ GameWebViewUI qgm;

    GameWebViewUI$2(GameWebViewUI gameWebViewUI) {
        this.qgm = gameWebViewUI;
    }

    public final void g(MenuItem menuItem) {
        atl atl = (atl) GameWebViewUI.a(this.qgm).get(Integer.valueOf(menuItem.getItemId()));
        if (atl != null) {
            d bUz;
            switch (9.jKl[a.Bb(atl.rDF).ordinal()]) {
                case 1:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", atl.rDG);
                    com.tencent.mm.bg.d.b(this.qgm.mController.tml, "webview", ".ui.tools.game.GameWebViewUI", intent);
                    return;
                case 2:
                    bUz = GameWebViewUI.c(this.qgm).bUz();
                    bUz.pSr = new Object[]{this.qgm.cbP, Integer.valueOf(32), Integer.valueOf(1)};
                    bUz.c(GameWebViewUI.b(this.qgm));
                    if (!GameWebViewUI.d(this.qgm)) {
                        this.qgm.finish();
                        return;
                    }
                    return;
                case 3:
                    String stringExtra = this.qgm.getIntent().getStringExtra("KPublisherId");
                    String stringExtra2 = this.qgm.getIntent().getStringExtra("KAppId");
                    String stringExtra3 = this.qgm.getIntent().getStringExtra("srcUsername");
                    d bUz2 = GameWebViewUI.f(this.qgm).bUz();
                    bUz2.pSr = new Object[]{this.qgm.cbP, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                    bUz2.c(GameWebViewUI.e(this.qgm));
                    GameWebViewUI.a(this.qgm, GameWebViewUI.g(this.qgm).bVS().cgi());
                    GameWebViewUI.h(this.qgm);
                    return;
                case 4:
                    bUz = GameWebViewUI.j(this.qgm).bUz();
                    bUz.pSr = new Object[]{this.qgm.cbP, Integer.valueOf(3), Integer.valueOf(1)};
                    bUz.c(GameWebViewUI.i(this.qgm));
                    h.mEJ.a(157, 6, 1, false);
                    GameWebViewUI.b(this.qgm, GameWebViewUI.k(this.qgm).bVS().cgi());
                    GameWebViewUI.l(this.qgm);
                    return;
                case 5:
                    bUz = GameWebViewUI.n(this.qgm).bUz();
                    bUz.pSr = new Object[]{this.qgm.cbP, Integer.valueOf(10), Integer.valueOf(1)};
                    bUz.c(GameWebViewUI.m(this.qgm));
                    if (GameWebViewUI.o(this.qgm) != null) {
                        GameWebViewUI.p(this.qgm).reload();
                        return;
                    }
                    return;
                case 6:
                    bUz = GameWebViewUI.r(this.qgm).bUz();
                    bUz.pSr = new Object[]{this.qgm.cbP, Integer.valueOf(31), Integer.valueOf(1)};
                    bUz.c(GameWebViewUI.q(this.qgm));
                    GameWebViewUI.s(this.qgm);
                    return;
                case 7:
                    bUz = GameWebViewUI.u(this.qgm).bUz();
                    bUz.pSr = new Object[]{this.qgm.cbP, Integer.valueOf(11), Integer.valueOf(1)};
                    bUz.c(GameWebViewUI.t(this.qgm));
                    GameWebViewUI.v(this.qgm);
                    return;
                case 8:
                    if (GameWebViewUI.w(this.qgm) != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d x = GameWebViewUI.x(this.qgm);
                        int i = atl.rWO;
                        x.i("MicroMsg.JsApiHandler", com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                        Map hashMap = new HashMap();
                        hashMap.put("itemId", Integer.valueOf(i));
                        ah.A(new 61(x, i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME, hashMap, x.qhs, x.qht)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
