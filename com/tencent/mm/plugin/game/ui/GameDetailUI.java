package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameDetailUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("game_app_id");
        b.a bt = b.bt(stringExtra, getIntent().getIntExtra("game_report_from_scene", 0));
        if (bt.bWA != 2 || bi.oW(bt.url)) {
            int aTJ = f.aTJ();
            if (aTJ == 2) {
                c.ap(this, stringExtra);
            } else if (aTJ == 1) {
                c.e(this, getIntent().getExtras());
            } else {
                String fS = bi.fS(this);
                if (bi.oW(fS) || fS.toLowerCase().equals("cn")) {
                    c.ap(this, stringExtra);
                } else {
                    c.e(this, getIntent().getExtras());
                }
            }
        } else {
            c.r(getBaseContext(), bt.url, "game_center_detail");
        }
        finish();
    }
}
