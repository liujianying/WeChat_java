package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.h;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameCenterUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.GameCenterUI", "onCreate");
        if (getIntent().getBooleanExtra("game_check_float", false)) {
            int intExtra = getIntent().getIntExtra("game_sourceScene", 0);
            ((b) g.l(b.class)).aSi();
            s aTZ = v.aTZ();
            if (aTZ != null) {
                aTZ.aTW();
                if (!bi.oW(aTZ.jMI.url)) {
                    c.a(getBaseContext(), aTZ, "game_center_h5_floatlayer");
                }
            }
            o.a(aTZ, intExtra, 1);
            finish();
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        h aTL = h.aTL();
        aj ajVar = null;
        if (aTL.jLN != null) {
            ajVar = aTL.jLN.jRn;
            if (ajVar != null) {
                x.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[]{Integer.valueOf(ajVar.jQq), ajVar.jOU});
            }
        } else {
            aTL.Zy();
        }
        if (ajVar != null) {
            Intent intent;
            Bundle extras;
            switch (ajVar.jQq) {
                case 0:
                    fz(booleanExtra);
                    break;
                case 1:
                    if (!bi.oW(ajVar.jOU)) {
                        DM(ajVar.jOU);
                        break;
                    } else {
                        fz(booleanExtra);
                        break;
                    }
                case 2:
                    intent = new Intent(this, GameOverSeaCenterUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(f.a.in_no_slide, f.a.in_no_slide);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
                    }
                    qU(6);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(848, 5, 1, false);
                    break;
                case 3:
                    intent = new Intent(this, GameDownloadGuidanceUI.class);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        intent.putExtras(extras);
                    }
                    startActivity(intent);
                    if (booleanExtra) {
                        overridePendingTransition(f.a.in_no_slide, f.a.in_no_slide);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
                    }
                    qU(6);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(848, 6, 1, false);
                    break;
            }
        }
        fz(booleanExtra);
        finish();
    }

    private void fz(boolean z) {
        if (e.chv()) {
            x.i("MicroMsg.GameCenterUI", "GP version");
        } else {
            com.tencent.mm.plugin.game.model.b.a qQ = com.tencent.mm.plugin.game.model.b.qQ(getIntent().getIntExtra("game_report_from_scene", 0));
            if (qQ.bWA == 2 && !bi.oW(qQ.url)) {
                DM(qQ.url);
                return;
            }
        }
        Intent intent = new Intent(this, GameRouteUI.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
        if (z) {
            overridePendingTransition(f.a.in_no_slide, f.a.in_no_slide);
        } else {
            overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
        }
        qU(6);
        com.tencent.mm.plugin.report.service.h.mEJ.a(848, 4, 1, false);
    }

    private void DM(String str) {
        qU(7);
        Intent intent = getIntent();
        if (!(this == null || bi.oW(str) || intent == null)) {
            boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
            int intExtra = intent.getIntExtra("game_report_from_scene", 0);
            ((b) g.l(b.class)).aSi();
            s aTZ = v.aTZ();
            String a = o.a(str, aTZ);
            if (booleanExtra) {
                o.a(this, a, "game_center_entrance", true, aTZ, intExtra);
                ((b) g.l(b.class)).aSi();
                v.aTY();
            } else {
                o.a(this, a, "game_center_entrance", false, aTZ, intExtra);
            }
            finish();
        }
        com.tencent.mm.plugin.report.service.h.mEJ.a(848, 3, 1, false);
    }

    private void qU(int i) {
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
            ((b) g.l(b.class)).aSi();
            s aTX = v.aTX();
            if (aTX == null) {
                an.a(this, 9, 901, 1, i, 0, an.da("resource", "0"));
                return;
            }
            aTX.aTW();
            int i2 = aTX.field_msgType;
            if (aTX.field_msgType == 100) {
                i2 = aTX.jNa;
            }
            an.a(this, 9, 901, 1, i, 0, aTX.field_appId, 0, i2, aTX.field_gameMsgId, aTX.jNb, an.da("resource", String.valueOf(aTX.jMt.jNi)));
            ((b) g.l(b.class)).aSi();
            v.aTY();
            com.tencent.mm.plugin.report.service.h.mEJ.a(858, 3, 1, false);
        }
    }
}
