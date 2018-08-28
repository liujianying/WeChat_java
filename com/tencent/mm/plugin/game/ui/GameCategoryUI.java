package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.h;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.az;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.ui.m.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI extends MMActivity implements e {
    private View gPU;
    private Dialog gvJ;
    private int jNB = 0;
    private int jNv = 0;
    private k jUE = new k();
    private ListView jUL;
    private l jUM;
    private boolean jUN = false;
    private boolean jUO = false;
    private int jUP;
    private String jUQ;
    private a jUR = new 3(this);
    private OnScrollListener jUS = new 4(this);
    private int mType;

    static /* synthetic */ void a(GameCategoryUI gameCategoryUI, ad adVar, boolean z) {
        gameCategoryUI.jUO = adVar.jNz.jSg;
        if (z) {
            gameCategoryUI.jUM.O(adVar.jNA);
        } else {
            gameCategoryUI.jUM.P(adVar.jNA);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("extra_type", 0);
        this.jUP = getIntent().getIntExtra("extra_category_id", 0);
        this.jUQ = getIntent().getStringExtra("extra_category_name");
        this.jNv = getIntent().getIntExtra("game_report_from_scene", 0);
        g.DF().a(1220, this);
        setMMTitle(this.jUQ);
        setBackBtn(new 1(this));
        if (!bi.oW(f.aTK())) {
            addIconOptionMenu(0, i.top_item_desc_search, h.actionbar_icon_dark_search, new 2(this));
        }
        this.jUL = (ListView) findViewById(com.tencent.mm.plugin.game.f.e.game_category_list);
        this.jUL.setOnItemClickListener(this.jUE);
        this.jUE.setSourceScene(this.jNv);
        this.jUL.setOnScrollListener(this.jUS);
        this.jUM = new l(this);
        this.jUM.setSourceScene(this.jNv);
        this.jUM.a(this.jUR);
        this.gPU = ((LayoutInflater) this.mController.tml.getSystemService("layout_inflater")).inflate(com.tencent.mm.plugin.game.f.f.game_list_footer_loading, this.jUL, false);
        this.gPU.setVisibility(8);
        this.jUL.addFooterView(this.gPU);
        this.jUL.setAdapter(this.jUM);
        this.gvJ = c.dD(this);
        this.gvJ.show();
        aUP();
    }

    public void onDestroy() {
        super.onDestroy();
        g.DF().b(1220, this);
        this.jUM.clear();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.game.f.f.game_category;
    }

    private void aUP() {
        g.DF().a(new az(this.jNB, this.mType, this.jUP), 0);
        this.jUN = true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            g.Em().H(new 5(this, ((az) lVar).ivx.dIE.dIL));
            return;
        }
        x.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            x.e("MicroMsg.GameCategoryUI", "error request code");
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getStringExtra("game_app_id");
        }
        switch (i2) {
            case 2:
                if (!bi.oW(str)) {
                    this.jUM.DJ(str);
                    this.jUM.DL(str);
                    return;
                }
                return;
            case 3:
                if (!bi.oW(str)) {
                    this.jUM.DK(str);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
