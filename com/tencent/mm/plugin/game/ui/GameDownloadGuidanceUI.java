package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.p;
import com.tencent.mm.plugin.game.e.a.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.h;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public class GameDownloadGuidanceUI extends GameCenterBaseUI implements e {
    private Dialog iwc;
    private bh jNL;
    private boolean jXA;
    private String jXB = "";
    private TextView jXx;
    private TextView jXy;
    private TextView jXz;
    private LinearLayout jeZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.DF().a(2586, this);
        initView();
        c.Em().H(new Runnable() {
            public final void run() {
                byte[] Dw = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSk().Dw("pb_download_guidance");
                if (Dw == null) {
                    ah.A(new 1(this));
                } else {
                    ah.A(new 2(this, new ag(Dw)));
                }
                g.DF().a(new aw(w.chP(), f.aTz(), GameDownloadGuidanceUI.this.jVf, GameDownloadGuidanceUI.this.jVg, GameDownloadGuidanceUI.this.jVh, GameDownloadGuidanceUI.this.jVe), 0);
                f.aTE();
                a.aVh().aVf();
            }
        });
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
        super.onDestroy();
        a.aVh().clearCache();
        g.DF().b(2586, this);
        ((b) g.l(b.class)).aSf().clearCache();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(i.game_wechat_game);
        this.jeZ = (LinearLayout) findViewById(com.tencent.mm.plugin.game.f.e.container);
        this.jXx = (TextView) findViewById(com.tencent.mm.plugin.game.f.e.main_content);
        this.jXy = (TextView) findViewById(com.tencent.mm.plugin.game.f.e.secondary_title);
        this.jXz = (TextView) findViewById(com.tencent.mm.plugin.game.f.e.secondary_content);
    }

    public final void a(ag agVar, int i) {
        if (isFinishing()) {
            x.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
        } else if (agVar == null || agVar.aUr() == null) {
            x.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
        } else {
            if (agVar == null || agVar.aUs() == null) {
                this.jXB = "";
            } else {
                this.jXB = agVar.aUs().jOU;
            }
            if (bi.oW(this.jXB)) {
                if (this.jXA) {
                    removeOptionMenu(0);
                    this.jXA = false;
                }
            } else if (!this.jXA) {
                addIconOptionMenu(0, h.actionbar_setting_icon, new 4(this));
                this.jXA = true;
            }
            this.jeZ.setVisibility(0);
            p aUr = agVar.aUr();
            if (bi.oW(aUr.jPP)) {
                this.jXx.setVisibility(8);
            } else {
                this.jXx.setText(aUr.jPP);
                this.jXx.setVisibility(0);
            }
            if (bi.oW(aUr.jPQ)) {
                this.jXy.setVisibility(8);
            } else {
                this.jXy.setText(aUr.jPQ);
                this.jXy.setVisibility(0);
            }
            if (bi.oW(aUr.jPR)) {
                this.jXz.setVisibility(8);
            } else {
                this.jXz.setText(aUr.jPR);
                this.jXz.setVisibility(0);
            }
            if (i == 2) {
                c.Em().H(new 3(this));
            }
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.game.f.f.game_google_play_tips;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 2586:
                    long currentTimeMillis = System.currentTimeMillis();
                    c.Em().H(new 5(this, ((aw) lVar).ivx.dIE.dIL, currentTimeMillis));
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.b.a.ezo.a(this, i, i2, str)) {
            Toast.makeText(this, getString(i.game_list_get_failed, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.iwc != null) {
            this.iwc.cancel();
        }
    }
}
