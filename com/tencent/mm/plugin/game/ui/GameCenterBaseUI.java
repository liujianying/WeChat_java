package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class GameCenterBaseUI extends GameCenterActivity {
    protected int jNv = 0;
    protected boolean jVe = false;
    protected s jVf;
    protected s jVg;
    protected s jVh;
    protected boolean jVi = false;
    private boolean jVj = true;

    static /* synthetic */ void a(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.jVe) {
            ((b) g.l(b.class)).aSi();
            gameCenterBaseUI.jVf = v.aTX();
            if (gameCenterBaseUI.jVf != null) {
                gameCenterBaseUI.jVf.aTW();
            }
            ((b) g.l(b.class)).aSi();
            gameCenterBaseUI.jVg = v.aTZ();
            if (gameCenterBaseUI.jVg != null) {
                gameCenterBaseUI.jVg.aTW();
            }
        }
        ((b) g.l(b.class)).aSi();
        gameCenterBaseUI.jVh = v.aUb();
        if (gameCenterBaseUI.jVh != null) {
            gameCenterBaseUI.jVh.aTW();
        }
    }

    static /* synthetic */ void b(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.jVg != null && !gameCenterBaseUI.jVg.field_isHidden && !bi.oW(gameCenterBaseUI.jVg.jMI.url)) {
            gameCenterBaseUI.jVi = true;
            s sVar = gameCenterBaseUI.jVg;
            c.a(gameCenterBaseUI.getBaseContext(), sVar, "game_center_h5_floatlayer");
            int i = sVar.field_msgType;
            if (sVar.field_msgType == 100) {
                i = sVar.jNa;
            }
            an.a(gameCenterBaseUI, 10, 1006, 1, 1, 0, sVar.field_appId, 0, i, sVar.field_gameMsgId, sVar.jNb, null);
            h.mEJ.a(858, 18, 1, false);
            gameCenterBaseUI.jVg.field_isRead = true;
            ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().c(gameCenterBaseUI.jVg, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.Eg().Dx()) {
            this.jNv = getIntent().getIntExtra("game_report_from_scene", 0);
            this.jVe = getIntent().getBooleanExtra("from_find_more_friend", false);
            c.Em().H(new 1(this));
            an.a(this, 10, 1000, 0, 1, 0, null, this.jNv, 0, null, null, null);
            return;
        }
        x.e("MicroMsg.GameCenterBaseUI", "account not ready");
        finish();
    }

    public void onResume() {
        super.onResume();
        if (g.Eg().Dx()) {
            if (!this.jVj && a$a.kdf.kdd) {
                a$a.kdf.kdd = false;
                x.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
                if (!isFinishing()) {
                    finish();
                }
                sendBroadcast(new Intent("com.tencent.mm.ACTION_EXIT"), "com.tencent.mm.permission.MM_MESSAGE");
                Intent intent = new Intent();
                intent.putExtra("game_report_from_scene", 901);
                intent.putExtra("switch_country_no_anim", true);
                d.b(this, "game", ".ui.GameCenterUI", intent);
            }
            this.jVj = false;
            return;
        }
        x.e("MicroMsg.GameCenterBaseUI", "account not ready");
    }

    public final int aUM() {
        return 10;
    }

    public final int aUN() {
        return 1000;
    }

    public final int aUO() {
        return this.jNv;
    }
}
