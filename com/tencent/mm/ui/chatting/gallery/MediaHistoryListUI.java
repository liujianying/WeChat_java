package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.ui.n$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.d.b.b;
import com.tencent.mm.ui.chatting.g.d;
import com.tencent.mm.ui.chatting.g.f;
import com.tencent.mm.ui.chatting.g.g;
import com.tencent.mm.ui.chatting.g.h;

@a(3)
public class MediaHistoryListUI extends MMActivity implements b {
    private RecyclerView Sa;
    private String gBf;
    private TextView hOU;
    private ProgressDialog kjo;
    private com.tencent.mm.ui.chatting.d.b.a tTv;
    private com.tencent.mm.modelvoiceaddr.ui.b tXI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.h.action_bar_container), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.gBf = getIntent().getStringExtra("kintent_talker");
        com.tencent.mm.ui.chatting.d.b.a aVar = null;
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 2:
                aVar = new d(this);
                break;
            case 3:
                aVar = new h(this);
                break;
            case 4:
                aVar = new f(this);
                break;
            case 5:
                aVar = new g(this);
                break;
        }
        if (aVar == null) {
            x.e("MicroMsg.MediaHistoryListUI", "[onCreate] presenter is null!");
            return;
        }
        aVar.a(this);
        lF(android.support.v4.content.a.g(this.mController.tml, n$a.normal_actionbar_color));
        cqh();
        initView();
        this.tTv.cwG();
        boolean fq = s.fq(this.gBf);
        au.HU();
        u ii = c.Ga().ii(this.gBf);
        if (fq) {
            if (this.tTv.getType() == 6) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ii.Nn().size()), Integer.valueOf(1)});
            } else if (this.tTv.getType() == -1) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(ii.Nn().size()), Integer.valueOf(1)});
            } else if (this.tTv.getType() == 3) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ii.Nn().size()), Integer.valueOf(1)});
            } else if (this.tTv.getType() == 5) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ii.Nn().size()), Integer.valueOf(1), Integer.valueOf(1)});
            }
        } else if (this.tTv.getType() == 6) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (this.tTv.getType() == -1) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (this.tTv.getType() == 3) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (this.tTv.getType() == 5) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(14569, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
        }
    }

    protected final void initView() {
        this.tXI = new com.tencent.mm.modelvoiceaddr.ui.b();
        this.tXI.mv(false);
        this.tXI.a(this.tTv.cwI());
        this.tXI.erG = false;
        this.hOU = (TextView) findViewById(R.h.search_nothing_hint);
        this.Sa = (RecyclerView) findViewById(R.h.history_recycler_view);
        findViewById(R.h.content_history).setBackgroundColor(-1);
        this.Sa.setBackgroundColor(-1);
        this.Sa.setLayoutManager(this.tTv.cwu());
        this.Sa.a(this.tTv.cwF());
        this.Sa.setAdapter(this.tTv.aau(this.gBf));
        this.Sa.setHasFixedSize(true);
        setMMTitle(this.tTv.Wm());
    }

    protected void onDestroy() {
        super.onDestroy();
        this.tTv.onDetach();
    }

    public final void onKeyboardStateChanged() {
        super.onKeyboardStateChanged();
        if (this.mController.tmG == 2) {
            this.tXI.clearFocus();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.tXI.a(this, menu);
        com.tencent.mm.modelvoiceaddr.ui.b bVar = this.tXI;
        String cwJ = this.tTv.cwJ();
        if (!(bVar.uBv == null || bi.oW(cwJ))) {
            bVar.uBv.setSelectedTag(cwJ);
        }
        this.mController.contentView.postDelayed(new 1(this), 200);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.tXI.a(this, menu);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        overridePendingTransition(0, 0);
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0, 0);
    }

    protected final int getLayoutId() {
        return R.i.media_history_ui;
    }

    public final void cwK() {
        dO(true);
    }

    public final void y(boolean z, int i) {
        dO(false);
        x.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (i <= 0) {
            this.hOU.setVisibility(0);
            this.Sa.setVisibility(8);
            this.hOU.setText(getString(R.l.chatting_record_noting_hint));
            return;
        }
        this.hOU.setVisibility(8);
        this.Sa.setVisibility(0);
        this.Sa.getAdapter().RR.notifyChanged();
    }

    public final void onFinish() {
        x.i("MicroMsg.MediaHistoryListUI", "[onRefreshed]");
        finish();
        overridePendingTransition(0, 0);
    }

    public final void bz(String str, boolean z) {
        if (z) {
            CharSequence string = getString(R.l.chatting_record_search_noting_hint, new Object[]{str});
            this.hOU.setVisibility(0);
            this.Sa.setVisibility(8);
            TextView textView = this.hOU;
            this.hOU.getContext();
            textView.setText(com.tencent.mm.plugin.fts.a.f.a(string, str));
            return;
        }
        this.hOU.setVisibility(8);
        this.Sa.setVisibility(0);
    }

    private void dO(boolean z) {
        x.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.kjo = p.b(this, getString(R.l.loading_tips), true, 0, null);
        } else if (this.kjo != null && this.kjo.isShowing()) {
            this.kjo.dismiss();
            this.kjo = null;
        }
    }
}
