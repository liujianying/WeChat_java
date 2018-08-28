package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;

class GameInfoViewForeign$1 implements OnClickListener {
    final /* synthetic */ GameInfoViewForeign jZb;

    GameInfoViewForeign$1(GameInfoViewForeign gameInfoViewForeign) {
        this.jZb = gameInfoViewForeign;
    }

    public final void onClick(View view) {
        int r;
        if (view.getTag() == null || !(view.getTag() instanceof String)) {
            a aTv = b.aTv();
            if (aTv.bWA == 2) {
                r = c.r(GameInfoViewForeign.a(this.jZb), aTv.url, "game_center_msgcenter");
            } else {
                Intent intent = new Intent(GameInfoViewForeign.a(this.jZb), GameMessageUI.class);
                intent.putExtra("game_report_from_scene", 1001);
                GameInfoViewForeign.a(this.jZb).startActivity(intent);
                r = 6;
            }
        } else {
            r = c.r(GameInfoViewForeign.a(this.jZb), (String) view.getTag(), "game_center_msgcenter");
        }
        an.a(GameInfoViewForeign.a(this.jZb), 10, 1001, GameInfoViewForeign.b(this.jZb), r, 0, null, GameInfoViewForeign.c(this.jZb), 0, null, null, an.da("resource", "5"));
    }
}
