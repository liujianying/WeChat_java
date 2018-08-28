package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public abstract class FTSBaseVoiceSearchUI extends MMActivity implements b.a, d.a, e {
    String bWm;
    private VoiceSearchLayout erK;
    private b hpe;
    private ag jvE = new 3(this);
    ListView jwh;
    private d jwi;
    TextView jwj;
    private boolean jwk = false;
    private RelativeLayout jwo;

    protected abstract d a(e eVar);

    protected abstract boolean aQH();

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.tml;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqi();
        setMMTitle("");
        lF(this.mController.tml.getResources().getColor(n.a.normal_actionbar_color));
        aQB();
        this.hpe = new b();
        this.hpe.mv(true);
        this.hpe.a(this);
        this.hpe.erG = aQH();
        this.jwh = (ListView) findViewById(d.search_result_lv);
        if (ayg() != null) {
            x.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "searchResultLV addFooterView");
            this.jwh.addFooterView(ayg());
        }
        this.jwi = a((e) this);
        this.jwi.jwg = this;
        this.jwh.setAdapter(this.jwi);
        this.jwh.setOnScrollListener(this.jwi);
        this.jwh.setOnItemClickListener(this.jwi);
        this.jwh.setOnTouchListener(new 1(this));
        if (aQH()) {
            this.erK = new VoiceSearchLayout(this);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14);
            this.erK.setLayoutParams(layoutParams);
            this.erK.setTopMargin(BackwardSupportUtil.b.b(this, 100.0f));
            this.erK.setBackgroundColor(getResources().getColor(n.a.BW_95));
            this.erK.setVisibility(8);
            this.hpe.o(this.erK);
            this.jwo = (RelativeLayout) findViewById(d.voice_search_view);
            this.jwo.addView(this.erK);
        }
        this.jwj = (TextView) findViewById(d.no_result_view);
        setBackBtn(new 2(this));
    }

    protected void aQB() {
    }

    protected View ayg() {
        return null;
    }

    public final void Uq() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onVoiceSearchStart");
        aQI();
    }

    public final void Ur() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onVoiceSearchCancel");
        aQJ();
        e.qf(3);
    }

    public void a(boolean z, String[] strArr, long j, int i) {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onVoiceReturn");
        aQJ();
    }

    public final void WX() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnterSearch");
    }

    public final void WW() {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onQuitSearch");
        finish();
    }

    public final void pk(String str) {
        x.v("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchChange %s", new Object[]{str});
        if (bi.oW(str)) {
            if (!this.hpe.czu()) {
                this.hpe.czv();
                showVKB();
            }
            aQG();
        }
        String Cw = com.tencent.mm.plugin.fts.a.d.Cw(str);
        if (bi.oW(this.bWm) || !this.bWm.equals(Cw)) {
            this.bWm = Cw;
            if (bi.oW(this.bWm)) {
                this.jvE.removeMessages(1);
                this.jwk = false;
                this.jwi.stopSearch();
                aQG();
                return;
            }
            this.jvE.removeMessages(1);
            this.jvE.sendEmptyMessageDelayed(1, 300);
            return;
        }
        x.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "Same query %s %s", new Object[]{this.bWm, Cw});
    }

    public final void WY() {
    }

    public boolean pj(String str) {
        x.d("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onSearchKeyDown %s", new Object[]{str});
        YC();
        if (this.hpe != null) {
            this.hpe.clearFocus();
        }
        return false;
    }

    protected void aQy() {
        this.jwk = true;
        this.jwi.CN(this.bWm);
        aQD();
    }

    protected void aQI() {
        this.jwj.setVisibility(8);
        if (this.jwo != null) {
            this.jwo.setVisibility(0);
        }
        this.jwh.setVisibility(8);
    }

    protected void aQJ() {
        this.jwj.setVisibility(8);
        if (this.jwo != null) {
            this.jwo.setVisibility(8);
        }
        this.jwh.setVisibility(8);
    }

    protected void aQD() {
        this.jwj.setVisibility(8);
        if (this.jwo != null) {
            this.jwo.setVisibility(8);
        }
        this.jwh.setVisibility(8);
    }

    protected void aQE() {
        this.jwj.setVisibility(0);
        this.jwj.setText(f.a(getString(n$g.search_contact_no_result_pre), getString(n$g.search_contact_no_result_post), com.tencent.mm.plugin.fts.a.a.d.b(this.bWm, this.bWm)).jrO);
        if (this.jwo != null) {
            this.jwo.setVisibility(8);
        }
        this.jwh.setVisibility(8);
    }

    protected void aQF() {
        this.jwj.setVisibility(8);
        if (this.jwo != null) {
            this.jwo.setVisibility(8);
        }
        this.jwh.setVisibility(0);
    }

    protected void aQG() {
        this.jwj.setVisibility(8);
        if (this.jwo != null) {
            this.jwo.setVisibility(8);
        }
        this.jwh.setVisibility(8);
    }

    protected void onPause() {
        super.onPause();
        this.hpe.cancel();
        this.hpe.clearFocus();
    }

    protected void onDestroy() {
        this.jvE.removeMessages(1);
        this.jwi.finish();
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.hpe.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.hpe.a(this, menu);
        return true;
    }

    public void K(int i, boolean z) {
        x.i("MicroMsg.FTS.FTSBaseVoiceSearchUI", "onEnd resultCount=%d | isFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            aQL();
            if (i > 0) {
                aQF();
            } else {
                aQE();
            }
        } else if (i > 0) {
            aQF();
            aQK();
        } else {
            aQD();
            aQL();
        }
        if (this.jwk) {
            this.jwk = false;
            this.jwh.setSelection(0);
        }
    }

    protected void aQK() {
    }

    protected void aQL() {
    }

    public final void WZ() {
    }
}
