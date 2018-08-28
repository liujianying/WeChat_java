package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

@a(19)
public final class AppBrand404PageUI extends DrawStatusBarActivity {
    public static void show(int i) {
        ah.A(new 1(ad.getContext().getString(i)));
    }

    protected final int getLayoutId() {
        return h.app_brand_404_page_ui;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, getStatusBarColor(), false);
        setMMTitle(j.app_brand_error);
        setBackBtn(new 2(this));
        TextView textView = (TextView) findViewById(g.app_brand_error_page_reason);
        CharSequence stringExtra = getIntent().getStringExtra("key_wording");
        bi.oW(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
    }

    public final void finish() {
        super.finish();
    }

    protected final void onDestroy() {
        super.onDestroy();
    }
}
