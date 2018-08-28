package com.tencent.mm.plugin.fts.ui;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.sdk.platformtools.x;

public class FTSDetailUI extends FTSBaseUI {
    private int jsZ;
    private int jtk;
    private i jwI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((n) g.n(n.class)).getFTSImageLoader().aPO();
        String stringExtra = getIntent().getStringExtra("detail_query");
        this.bWm = stringExtra;
        this.jwl.getFtsEditText().j(stringExtra, null);
        x.i("MicroMsg.FTS.FTSDetailUI", "onCreate query=%s, searchType=%d, kvScene=%d", new Object[]{this.bWm, Integer.valueOf(this.jtk), Integer.valueOf(this.jsZ)});
        aQy();
    }

    protected final void aQB() {
        this.jtk = getIntent().getIntExtra("detail_type", 0);
        this.jsZ = getIntent().getIntExtra("Search_Scene", 0);
    }

    protected final d a(e eVar) {
        if (this.jwI == null) {
            this.jwI = new i(eVar, this.jtk, this.jsZ);
        }
        return this.jwI;
    }

    public final void a(a aVar) {
    }

    protected final int getLayoutId() {
        return e.fts_detail_ui;
    }

    protected void onDestroy() {
        this.jwI.finish();
        ((n) g.n(n.class)).getFTSImageLoader().aPL();
        super.onDestroy();
    }

    public final String getHint() {
        String qm = m.qm(this.jtk);
        if (qm == null) {
            return getString(n.g.app_search);
        }
        return qm;
    }
}
