package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.ca;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.d.ch;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f$f;
import com.tencent.mm.plugin.game.f.h;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class GameOverSeaCenterUI extends GameCenterBaseUI implements e {
    private Dialog iwc;
    private bj jNZ;
    k jUE = new k();
    private boolean jVD = true;
    private boolean jXA;
    private String jXB = "";
    private OnClickListener jZL = new OnClickListener() {
        public final void onClick(View view) {
            int r;
            a aTu = b.aTu();
            if (aTu.bWA == 2) {
                r = c.r(GameOverSeaCenterUI.this.mController.tml, aTu.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || bi.oW((String) tag)) {
                    Intent intent = new Intent(GameOverSeaCenterUI.this.mController.tml, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1005);
                    GameOverSeaCenterUI.this.startActivity(intent);
                    r = 6;
                } else {
                    r = c.r(GameOverSeaCenterUI.this.mController.tml, (String) tag, "game_center_library");
                }
            }
            an.a(GameOverSeaCenterUI.this.mController.tml, 10, 1005, 1, r, GameOverSeaCenterUI.this.jNv, null);
        }
    };
    private GameCenterListView kbi;
    private g kbj;
    private GameInfoViewForeign kbk;
    private GameMessageBubbleView kbl;
    private GameInstalledView kbm;
    private View kbn;
    private TextView kbo;

    static /* synthetic */ void a(GameOverSeaCenterUI gameOverSeaCenterUI, ak akVar, int i) {
        if (gameOverSeaCenterUI.isFinishing()) {
            x.w("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI hasFinished");
        } else if (akVar == null) {
            x.e("MicroMsg.GameOverSeaCenterUI", "Null data");
        } else {
            LinkedList linkedList;
            if (akVar == null || akVar.aUy() == null) {
                gameOverSeaCenterUI.jXB = "";
            } else {
                gameOverSeaCenterUI.jXB = akVar.aUy().jOU;
            }
            if (bi.oW(gameOverSeaCenterUI.jXB)) {
                if (gameOverSeaCenterUI.jXA) {
                    gameOverSeaCenterUI.removeOptionMenu(0);
                    gameOverSeaCenterUI.jXA = false;
                }
            } else if (!gameOverSeaCenterUI.jXA) {
                gameOverSeaCenterUI.addIconOptionMenu(0, h.actionbar_setting_icon, new 5(gameOverSeaCenterUI));
                gameOverSeaCenterUI.jXA = true;
            }
            ca caVar = (akVar.jNZ == null || akVar.jNZ.jRW == null) ? null : akVar.jNZ.jRW.jQJ;
            if (caVar != null) {
                gameOverSeaCenterUI.kbk.setSourceScene(gameOverSeaCenterUI.jNv);
                gameOverSeaCenterUI.kbk.setVisibility(0);
            } else {
                gameOverSeaCenterUI.kbk.setVisibility(8);
            }
            gameOverSeaCenterUI.kbm.setSourceScene(gameOverSeaCenterUI.jNv);
            gameOverSeaCenterUI.kbm.setVersionCodes(akVar.jOc);
            GameInstalledView gameInstalledView = gameOverSeaCenterUI.kbm;
            GameInstalledView.a aVar = new GameInstalledView.a();
            if (!(akVar.jNZ.jRY == null || akVar.jNZ.jRY.jSE == null)) {
                aVar.iconUrl = akVar.jNZ.jRY.jSE.jPd;
                aVar.title = akVar.jNZ.jRY.jSE.bHD;
                aVar.fIb = akVar.jNZ.jRY.jSE.jOX;
            }
            gameInstalledView.setMoreGameInfo(aVar);
            GameInstalledView gameInstalledView2 = gameOverSeaCenterUI.kbm;
            LinkedList linkedList2 = new LinkedList();
            if (akVar.jNZ.jRY == null || akVar.jNZ.jRY.jSD == null) {
                linkedList = linkedList2;
            } else {
                Iterator it = akVar.jNZ.jRY.jSD.iterator();
                while (it.hasNext()) {
                    cc ccVar = (cc) it.next();
                    if (ccVar != null) {
                        d a = ak.a(ccVar.jOV);
                        if (a != null) {
                            a.dk(ccVar.jSF);
                            linkedList2.addFirst(a);
                        }
                    }
                }
                linkedList = linkedList2;
            }
            gameInstalledView2.setInstalledGameInfo(linkedList);
            gameOverSeaCenterUI.kbm.ey(true);
            if (gameOverSeaCenterUI.jVe) {
                gameOverSeaCenterUI.kbl.aVb();
            }
            ch chVar = akVar.jNZ != null ? akVar.jNZ.jRZ : null;
            if (chVar == null || bi.oW(chVar.jOS) || bi.oW(chVar.jOU)) {
                gameOverSeaCenterUI.kbn.setVisibility(8);
            } else {
                gameOverSeaCenterUI.kbn.setVisibility(0);
                gameOverSeaCenterUI.kbo.setText(chVar.jOS);
                gameOverSeaCenterUI.kbn.setTag(chVar.jOU);
                gameOverSeaCenterUI.kbn.setOnClickListener(gameOverSeaCenterUI.jZL);
            }
            gameOverSeaCenterUI.kbj.qT(i);
            gameOverSeaCenterUI.kbj.P(akVar.jOb);
            if (i == 2) {
                c.Em().H(new 3(gameOverSeaCenterUI));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
        g.DF().a(2855, this);
        initView();
        c.Em().H(new 2(this));
    }

    protected void onResume() {
        super.onResume();
        if (!this.jVD) {
            if (this.jVe) {
                this.kbl.aVb();
            }
            this.kbk.aUW();
        }
        this.jVD = false;
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.game.e.a.a.aVh().clearCache();
        g.DF().b(2855, this);
        ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSf().clearCache();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        setMMTitle(i.game_wechat_game);
        this.kbi = (GameCenterListView) findViewById(f.e.game_center_uninstalled);
        this.kbi.setOnItemClickListener(this.jUE);
        this.jUE.setSourceScene(this.jNv);
        this.kbj = new g(this);
        this.kbj.setSourceScene(this.jNv);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.tml.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(f$f.game_center_home_info_foreign, this.kbi, false);
        this.kbk = (GameInfoViewForeign) inflate.findViewById(f.e.game_center_info_foreign);
        this.kbi.addHeaderView(inflate);
        inflate = layoutInflater.inflate(f$f.game_center_bubble_layout, this.kbi, false);
        this.kbl = (GameMessageBubbleView) inflate.findViewById(f.e.game_msg_bubble_view);
        this.kbi.addHeaderView(inflate);
        inflate = layoutInflater.inflate(f$f.game_center_home_installed, this.kbi, false);
        this.kbm = (GameInstalledView) inflate.findViewById(f.e.game_installed_header);
        this.kbi.addHeaderView(inflate);
        View inflate2 = layoutInflater.inflate(f$f.game_center_home_footer_more2, this.kbi, false);
        this.kbi.addFooterView(inflate2);
        this.kbn = inflate2.findViewById(f.e.game_home_more_btn);
        this.kbn.setOnClickListener(this.jZL);
        this.kbo = (TextView) inflate2.findViewById(f.e.game_home_more_btn_text);
        this.kbi.setAdapter(this.kbj);
    }

    protected final int getLayoutId() {
        return f$f.game_center_home;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (lVar.getType()) {
                case 2855:
                    long currentTimeMillis = System.currentTimeMillis();
                    c.Em().H(new 6(this, ((ax) lVar).ivx.dIE.dIL, currentTimeMillis));
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
