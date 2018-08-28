package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.sdk.platformtools.ah;

class GameInstalledView$1 implements g {
    final /* synthetic */ GameInstalledView jZq;
    final /* synthetic */ View val$view;

    GameInstalledView$1(GameInstalledView gameInstalledView, View view) {
        this.jZq = gameInstalledView;
        this.val$view = view;
    }

    public final void me(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (bVar.status == 0) {
            ah.A(new 1(this));
        }
    }
}
