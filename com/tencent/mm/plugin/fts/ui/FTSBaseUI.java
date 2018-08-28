package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public abstract class FTSBaseUI extends MMActivity implements d$a, e, a, com.tencent.mm.plugin.fts.ui.widget.a.a {
    String bWm;
    private ag jvE = new 3(this);
    ListView jwh;
    private d jwi;
    private TextView jwj;
    private boolean jwk = false;
    com.tencent.mm.plugin.fts.ui.widget.a jwl;
    String jwm = null;

    protected abstract d a(e eVar);

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.mController.tml;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cqi();
        setMMTitle("");
        lF(android.support.v4.content.a.g(this.mController.tml, n.a.normal_actionbar_color));
        cqh();
        aQB();
        this.jwl = new com.tencent.mm.plugin.fts.ui.widget.a(this);
        this.jwl.setSearchViewListener(this);
        this.jwl.getFtsEditText().setHint(getHint());
        this.jwl.getFtsEditText().setFtsEditTextListener(this);
        this.jwl.getFtsEditText().setCanDeleteTag(false);
        getSupportActionBar().setCustomView(this.jwl);
        this.jwh = (ListView) findViewById(d.search_result_lv);
        this.jwi = a((e) this);
        this.jwi.jwg = this;
        this.jwh.setAdapter(this.jwi);
        this.jwh.setOnScrollListener(this.jwi);
        this.jwh.setOnItemClickListener(this.jwi);
        this.jwh.setOnTouchListener(new 1(this));
        this.jwj = (TextView) findViewById(d.no_result_view);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FTSBaseUI.this.finish();
                return true;
            }
        });
    }

    protected void aQB() {
    }

    public String getHint() {
        if (this.jwm != null) {
            return this.jwm;
        }
        return getString(g.app_search);
    }

    public void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
    }

    public void onClickBackBtn(View view) {
        finish();
    }

    public void onClickCancelBtn(View view) {
    }

    public final void aQC() {
    }

    protected final void i(String str, List<b> list) {
        this.bWm = str;
        this.jwl.getFtsEditText().j(str, list);
    }

    public void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.UserInput) {
            String Cw = com.tencent.mm.plugin.fts.a.d.Cw(str);
            if (bi.oW(this.bWm) || !this.bWm.equals(Cw)) {
                CO(Cw);
                return;
            }
            x.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[]{this.bWm, Cw});
        }
    }

    protected void CO(String str) {
        if (bi.oW(str)) {
            stopSearch();
            return;
        }
        this.bWm = str;
        this.jvE.removeMessages(1);
        this.jvE.sendEmptyMessageDelayed(1, 300);
    }

    protected void stopSearch() {
        this.bWm = "";
        this.jvE.removeMessages(1);
        this.jwk = false;
        this.jwi.stopSearch();
        this.jwl.getFtsEditText().setHint(getHint());
        aQG();
    }

    public final void fg(boolean z) {
    }

    public void onClickClearTextBtn(View view) {
        stopSearch();
        this.jwl.getFtsEditText().aQU();
        showVKB();
    }

    public boolean anx() {
        YC();
        this.jwl.getFtsEditText().jzo.clearFocus();
        return false;
    }

    protected void onDestroy() {
        this.jvE.removeMessages(1);
        this.jwi.finish();
        super.onDestroy();
    }

    protected void aQy() {
        this.jwk = true;
        this.jwi.CN(this.bWm);
        aQD();
    }

    protected void aQD() {
        this.jwj.setVisibility(8);
        this.jwh.setVisibility(8);
    }

    protected void aQE() {
        this.jwj.setVisibility(0);
        this.jwj.setText(f.a(getString(g.search_contact_no_result_pre), getString(g.search_contact_no_result_post), com.tencent.mm.plugin.fts.a.a.d.b(this.bWm, this.bWm)).jrO);
        this.jwh.setVisibility(8);
    }

    protected void aQF() {
        this.jwj.setVisibility(8);
        this.jwh.setVisibility(0);
    }

    protected void aQG() {
        this.jwj.setVisibility(8);
        this.jwh.setVisibility(8);
    }

    public final void K(int i, boolean z) {
        x.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            if (i > 0) {
                aQF();
            } else {
                aQE();
            }
        } else if (i > 0) {
            aQF();
        } else {
            aQD();
        }
        if (this.jwk) {
            this.jwk = false;
            this.jwh.setSelection(0);
        }
    }
}
