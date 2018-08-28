package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog gvJ;
    private ListView jWi;
    private a jWj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (bi.oW(stringExtra)) {
            finish();
            return;
        }
        a aVar = new a();
        aVar.dIG = new bo();
        aVar.dIH = new bp();
        aVar.uri = "/cgi-bin/mmgame-bin/getuplist";
        aVar.dIF = 1331;
        b KT = aVar.KT();
        ((bo) KT.dID.dIL).jPc = stringExtra;
        v.a(KT, new 2(this));
    }

    protected final int getLayoutId() {
        return f.game_detail2_rank_liked;
    }

    protected final void initView() {
        setMMTitle(i.game_detail_rank_liked);
        setBackBtn(new 1(this));
        this.jWi = (ListView) findViewById(e.game_detail_rank_liked_list);
        this.jWj = new a(this);
        this.jWi.setAdapter(this.jWj);
        this.gvJ = c.dD(this.mController.tml);
        this.gvJ.show();
    }
}
