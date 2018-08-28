package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankUI extends MMActivity {
    public static String EXTRA_SESSION_ID = "extra_session_id";
    public static String jWq = "gameDetailRankDataKey";
    private String appId;
    private ListView jWn;
    private GameRankHeadView jWo;
    private i jWp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b ib = u.Hx().ib(getIntent().getStringExtra(EXTRA_SESSION_ID));
        if (ib == null) {
            finish();
            return;
        }
        a aVar = (a) ib.get(jWq);
        this.jWn = (ListView) findViewById(e.game_detail_rank_list);
        if (!(bi.oW(aVar.jWs) || bi.oW(aVar.jWt))) {
            View inflate = ((LayoutInflater) this.mController.tml.getSystemService("layout_inflater")).inflate(f.game_detail_rank_head, this.jWn, false);
            this.jWo = (GameRankHeadView) inflate.findViewById(e.game_rank_head);
            this.jWn.addHeaderView(inflate);
            this.jWo.setData(aVar);
        }
        this.jWp = new i(this);
        this.jWp.Ba = f.game_detail2_rank_item_big;
        this.jWn.setAdapter(this.jWp);
        this.appId = aVar.jWu.field_appId;
        if (bi.oW(this.appId)) {
            finish();
            return;
        }
        initView();
        g.Em().H(new 1(this));
    }

    public void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        m.b(this.jWo.jWz);
    }

    protected final int getLayoutId() {
        return f.game_detail2_rank;
    }

    protected final void initView() {
        setMMTitle(com.tencent.mm.pluginsdk.model.app.g.q(this.mController.tml, this.appId));
        setBackBtn(new 2(this));
    }
}
