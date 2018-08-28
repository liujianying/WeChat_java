package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class EnterpriseBizSearchUI extends MMActivity implements b.a, EnterpriseBizContactListView.b {
    private String hpJ;
    private b hpe;
    private EnterpriseBizContactListView hpj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.hpj != null) {
            EnterpriseBizContactListView.release();
        }
    }

    public final void WY() {
    }

    public final void WZ() {
    }

    protected final void initView() {
        if (bi.oW(this.hpJ)) {
            this.hpJ = getIntent().getStringExtra("enterprise_biz_name");
            if (bi.oW(this.hpJ)) {
                finish();
            }
        }
        this.hpj = (EnterpriseBizContactListView) findViewById(d.sort_and_search_view);
        this.hpj.setFatherBizName(this.hpJ);
        this.hpj.setExcludeBizChat(true);
        this.hpj.refresh();
        this.hpj.setMode(1);
        this.hpj.auX();
        this.hpj.cso();
        this.hpj.lP(false);
        this.hpj.setOnTouchListener(this);
        ((TextView) this.hpj.getNoResultView()).setText(h.enterprise_search_no_result);
        this.hpe = new b();
        this.hpe.mv(true);
        this.hpe.a(this);
        this.hpe.erG = false;
    }

    public final void WX() {
    }

    public final void WW() {
        finish();
    }

    public final void pk(String str) {
        x.i("MicroMsg.EnterpriseBizSearchUI", "search biz, key word : %s", new Object[]{str});
        this.hpj.aac(str);
    }

    public final boolean pj(String str) {
        YC();
        return true;
    }

    public final void Uq() {
        YC();
    }

    public final void Ur() {
    }

    protected void onPause() {
        super.onPause();
        this.hpe.cancel();
        this.hpe.clearFocus();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.hpe.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.hpe.a(this, menu);
        return true;
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
    }

    protected final int getLayoutId() {
        return e.enterprise_biz_search;
    }

    public final boolean auW() {
        YC();
        return false;
    }
}
