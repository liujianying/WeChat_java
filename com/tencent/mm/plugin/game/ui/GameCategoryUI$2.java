package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GameCategoryUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GameCategoryUI jUT;

    GameCategoryUI$2(GameCategoryUI gameCategoryUI) {
        this.jUT = gameCategoryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.jUT, GameSearchUI.class);
        switch (GameCategoryUI.a(this.jUT)) {
            case 1:
                intent.putExtra("game_report_from_scene", 1602);
                break;
            case 2:
                intent.putExtra("game_report_from_scene", 1502);
                break;
        }
        this.jUT.startActivity(intent);
        return true;
    }
}
