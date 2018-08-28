package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI.a;
import org.xwalk.core.XWalkEnvironment;

class GameDetailUI2$17 implements OnClickListener {
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$17(GameDetailUI2 gameDetailUI2) {
        this.jXr = gameDetailUI2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            c.a(view, this.jXr);
            an.a(this.jXr.mController.tml, 12, 1203, XWalkEnvironment.LOCAL_TEST_VERSION, 7, GameDetailUI2.f(this.jXr), GameDetailUI2.g(this.jXr), null);
            return;
        }
        a aVar = new a();
        aVar.jWs = GameDetailUI2.n(this.jXr);
        aVar.jWt = GameDetailUI2.o(this.jXr);
        aVar.jWu = GameDetailUI2.l(this.jXr);
        String ic = u.ic("rankData");
        u.Hx().v(ic, true).p(GameDetailRankUI.jWq, aVar);
        Intent intent = new Intent(this.jXr.mController.tml, GameDetailRankUI.class);
        intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, ic);
        this.jXr.startActivity(intent);
        an.a(this.jXr.mController.tml, 12, 1203, XWalkEnvironment.LOCAL_TEST_VERSION, 6, GameDetailUI2.f(this.jXr), GameDetailUI2.g(this.jXr), null);
    }
}
