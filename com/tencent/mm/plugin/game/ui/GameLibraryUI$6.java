package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;

class GameLibraryUI$6 implements OnClickListener {
    final /* synthetic */ GameLibraryUI jZN;

    GameLibraryUI$6(GameLibraryUI gameLibraryUI) {
        this.jZN = gameLibraryUI;
    }

    public final void onClick(View view) {
        int i = 6;
        if (view.getTag() instanceof String) {
            c.a(view, this.jZN);
            i = 7;
        } else {
            Intent intent = new Intent(this.jZN, GameCategoryUI.class);
            intent.putExtra("extra_type", 2);
            intent.putExtra("extra_category_name", this.jZN.getString(i.game_library_more_game));
            intent.putExtra("game_report_from_scene", 1113);
            this.jZN.startActivity(intent);
        }
        an.a(this.jZN, 11, 1113, 1, i, GameLibraryUI.e(this.jZN), null);
    }
}
