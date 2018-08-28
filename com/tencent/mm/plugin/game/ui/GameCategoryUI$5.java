package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.sdk.platformtools.ah;

class GameCategoryUI$5 implements Runnable {
    final /* synthetic */ GameCategoryUI jUT;
    final /* synthetic */ a jUU;

    GameCategoryUI$5(GameCategoryUI gameCategoryUI, a aVar) {
        this.jUT = gameCategoryUI;
        this.jUU = aVar;
    }

    public final void run() {
        final ad adVar = new ad(this.jUU, GameCategoryUI.a(this.jUT), GameCategoryUI.h(this.jUT));
        ah.A(new Runnable() {
            public final void run() {
                GameCategoryUI.a(GameCategoryUI$5.this.jUT, adVar, GameCategoryUI.h(GameCategoryUI$5.this.jUT) != 0);
                GameCategoryUI.i(GameCategoryUI$5.this.jUT);
                GameCategoryUI.f(GameCategoryUI$5.this.jUT).setVisibility(8);
                GameCategoryUI.a(GameCategoryUI$5.this.jUT, GameCategoryUI.h(GameCategoryUI$5.this.jUT) + 15);
                if (GameCategoryUI.j(GameCategoryUI$5.this.jUT) != null) {
                    GameCategoryUI.j(GameCategoryUI$5.this.jUT).dismiss();
                }
            }
        });
    }
}
