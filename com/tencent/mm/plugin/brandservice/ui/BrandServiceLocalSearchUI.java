package com.tencent.mm.plugin.brandservice.ui;

import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.ar.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BrandServiceLocalSearchUI extends MMActivity implements b.a, BrandServiceSortView.a {
    private b hpe;
    private BrandServiceSortView hpf;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        lF(android.support.v4.content.a.g(this.mController.tml, com.tencent.mm.plugin.brandservice.b.a.normal_actionbar_color));
        initView();
        g.DF().a(new k(18), 0);
    }

    public final void WY() {
    }

    public final void WZ() {
    }

    protected final void initView() {
        this.hpf = (BrandServiceSortView) findViewById(d.sort_and_search_view);
        this.hpf.setMode(1);
        this.hpf.setReturnResult(getIntent().getBooleanExtra("is_return_result", false));
        this.hpf.cso();
        this.hpf.lP(false);
        this.hpf.setShowFooterView(false);
        this.hpf.setITransferToChildOnTouchListener(this);
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
        x.i("MicroMsg.BrandServiceLocalSearchUI", "search biz, key word : %s", str);
        this.hpf.aac(str);
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

    protected void onDestroy() {
        super.onDestroy();
        this.hpf.release();
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
        return e.brand_service_local_search;
    }

    public final boolean auW() {
        YC();
        return false;
    }
}
