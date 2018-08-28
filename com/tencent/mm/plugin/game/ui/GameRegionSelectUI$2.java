package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.ui.base.h;

class GameRegionSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GameRegionSelectUI kbC;

    GameRegionSelectUI$2(GameRegionSelectUI gameRegionSelectUI) {
        this.kbC = gameRegionSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (f.dA(this.kbC)) {
            h.a(this.kbC, true, this.kbC.getString(i.game_region_dlg_info), "", this.kbC.getString(i.game_region_dlg_switch), this.kbC.getString(i.game_region_dlg_cancel), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    f.dB(GameRegionSelectUI$2.this.kbC);
                    GameRegionSelectUI.a(GameRegionSelectUI$2.this.kbC);
                    Intent intent = new Intent();
                    a dr = f.dr(GameRegionSelectUI$2.this.kbC);
                    if (dr != null) {
                        intent.putExtra("gameRegionName", f.a(dr));
                        GameRegionSelectUI$2.this.kbC.setResult(-1, intent);
                    } else {
                        GameRegionSelectUI$2.this.kbC.setResult(1);
                    }
                    GameRegionSelectUI$2.this.kbC.finish();
                }
            }, new 2(this));
        } else {
            GameRegionSelectUI.a(this.kbC);
            Intent intent = new Intent();
            a dr = f.dr(this.kbC);
            if (dr != null) {
                intent.putExtra("gameRegionName", f.a(dr));
                this.kbC.setResult(-1, intent);
            } else {
                this.kbC.setResult(1);
            }
            this.kbC.finish();
        }
        return true;
    }
}
