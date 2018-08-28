package com.tencent.mm.plugin.game.ui.tab;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;
import java.util.List;

@a(19)
public class GameRouteUI extends GameCenterActivity {
    private int jNv;

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        initView();
        this.jNv = getIntent().getIntExtra("game_report_from_scene", 0);
        bf aVd = aVd();
        if (aVd == null || bi.cX(aVd.jQF)) {
            aq.a(new 1(this));
            return;
        }
        x.i("MicroMsg.GameRouteUI", "use cache data");
        aq.a(null);
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        getIntent().removeExtra("switch_country_no_anim");
        List list = aVd.jQF;
        if (!booleanExtra) {
            z = true;
        }
        e(list, z);
    }

    protected final int getLayoutId() {
        return f.game_route_layout;
    }

    protected final void initView() {
        setBackBtn(new 2(this));
        setMMTitle(i.game_wechat_game);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        exit();
        return true;
    }

    protected final boolean aUL() {
        return false;
    }

    public final int aUM() {
        return 0;
    }

    public final int aUN() {
        return 0;
    }

    public final int aUO() {
        return 0;
    }

    private void exit() {
        if (!isFinishing() && !isDestroyed()) {
            finish();
            overridePendingTransition(MMFragmentActivity.a.tnE, MMFragmentActivity.a.tnF);
        }
    }

    private void e(List<ak> list, boolean z) {
        if (!isFinishing() && !isDestroyed()) {
            GameTabData bn = GameTabData.bn(list);
            if (bn == null || bi.cX(bn.aUC())) {
                x.e("MicroMsg.GameRouteUI", "game tab data is null");
                exit();
                return;
            }
            List aUC = bn.aUC();
            int i = 0;
            TabItem tabItem = null;
            while (i < aUC.size()) {
                TabItem tabItem2;
                TabItem tabItem3 = (TabItem) aUC.get(i);
                if (tabItem3 != null) {
                    if (tabItem3.jOm) {
                        tabItem2 = tabItem3;
                    } else {
                        tabItem2 = tabItem;
                    }
                    an.a(this, 18, tabItem3.bYq, tabItem3.jOu, null, this.jNv, an.Dx(tabItem3.jLt));
                } else {
                    tabItem2 = tabItem;
                }
                i++;
                tabItem = tabItem2;
            }
            if (tabItem == null) {
                tabItem = (TabItem) aUC.get(0);
            }
            if (tabItem == null) {
                x.e("MicroMsg.GameRouteUI", "game tab entry item is null");
                exit();
                return;
            }
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putParcelable("tab_data", bn);
            getIntent().putExtras(extras);
            GameTabWidget.a(this, tabItem, z, true, true);
        }
    }

    private static bf aVd() {
        byte[] Dw = ((c) g.l(c.class)).aSk().Dw("game_index4_tab_nav");
        if (bi.bC(Dw)) {
            return null;
        }
        try {
            bf bfVar = new bf();
            try {
                bfVar.aG(Dw);
                return bfVar;
            } catch (IOException e) {
                return bfVar;
            }
        } catch (IOException e2) {
            return null;
        }
    }
}
