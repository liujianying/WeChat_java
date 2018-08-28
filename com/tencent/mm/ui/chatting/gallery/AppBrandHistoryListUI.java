package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.d.b.a;
import com.tencent.mm.ui.chatting.d.b.b;
import com.tencent.mm.ui.chatting.g.c;

public class AppBrandHistoryListUI extends MMActivity implements b {
    private RecyclerView Sa;
    private String gBf;
    private TextView hOU;
    private ProgressDialog kjo;
    private a tTv;

    public final /* bridge */ /* synthetic */ void a(c cVar) {
        this.tTv = (a) cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gBf = getIntent().getStringExtra("Chat_User");
        new com.tencent.mm.ui.chatting.g.a(this).a(this);
        initView();
        this.tTv.cwG();
        if (s.fq(this.gBf)) {
            h.mEJ.h(14562, new Object[]{this.gBf, Integer.valueOf(0)});
            return;
        }
        h.mEJ.h(14562, new Object[]{this.gBf, Integer.valueOf(1)});
    }

    protected final void initView() {
        setMMTitle(getString(R.l.chat_app_brand));
        this.hOU = (TextView) findViewById(R.h.search_nothing_hint);
        this.Sa = (RecyclerView) findViewById(R.h.history_recycler_view);
        this.Sa.setBackgroundColor(-1);
        this.Sa.setLayoutManager(this.tTv.cwu());
        this.Sa.setAdapter(this.tTv.aau(this.gBf));
        this.Sa.setHasFixedSize(true);
        setBackBtn(new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.tTv.onDetach();
    }

    protected final int getLayoutId() {
        return R.i.appbrand_history_ui;
    }

    public final void cwK() {
        dO(true);
    }

    public final void y(boolean z, int i) {
        dO(false);
        x.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
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
        x.i("MicroMsg.AppBrandHistoryListUI", "[onRefreshed]");
        finish();
    }

    public final void bz(String str, boolean z) {
    }

    private void dO(boolean z) {
        x.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.kjo = p.b(this, getString(R.l.loading_tips), true, 0, null);
        } else if (this.kjo != null && this.kjo.isShowing()) {
            this.kjo.dismiss();
            this.kjo = null;
        }
    }
}
