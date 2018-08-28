package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b$c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a;
import com.tencent.mm.protocal.c.atl;
import com.tencent.xweb.x5.sdk.d;

class g$1 implements b$c {
    final /* synthetic */ g jKj;

    g$1(g gVar) {
        this.jKj = gVar;
    }

    public final void g(MenuItem menuItem) {
        atl atl = (atl) g.a(this.jKj).get(Integer.valueOf(menuItem.getItemId()));
        if (atl != null) {
            switch (g$5.jKl[a.Bb(atl.rDF).ordinal()]) {
                case 1:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", atl.rDG);
                    if (d.getTbsVersion(this.jKj.jIJ) >= 43114) {
                        com.tencent.mm.bg.d.b(this.jKj.jIJ, "game", ".gamewebview.ui.GameWebViewUI", intent);
                        return;
                    } else {
                        com.tencent.mm.bg.d.b(this.jKj.jIJ, "webview", ".ui.tools.game.GameWebViewUI", intent);
                        return;
                    }
                case 2:
                    this.jKj.aTh();
                    return;
                case 3:
                    this.jKj.aTi();
                    return;
                case 4:
                    this.jKj.aTp();
                    return;
                case 5:
                    this.jKj.refresh();
                    return;
                case 6:
                    this.jKj.aTo();
                    return;
                case 7:
                    this.jKj.aTr();
                    return;
                case 8:
                    Bundle bundle = new Bundle();
                    bundle.putInt("mm_to_client_notify_type", 1);
                    bundle.putString("js_event_name", "onCustomGameMenuClicked");
                    bundle.putInt("itemId", atl.rWO);
                    com.tencent.mm.plugin.game.gamewebview.ipc.a.z(bundle);
                    return;
                default:
                    return;
            }
        }
    }
}
