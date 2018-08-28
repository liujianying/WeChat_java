package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.aa.a.c.b;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.g;

public class AAQueryListUI extends BaseAAPresenterActivity {
    private b eBU = ((b) t(b.class));
    private ListView eBV;
    private b eBW;
    private Dialog eBX;
    private boolean eBY = false;
    private boolean eBZ = false;
    private View eCa;
    private AAQueryListH5UrlFooterView eCb;
    private String eCc;
    private int mode = 1;

    static /* synthetic */ void k(AAQueryListUI aAQueryListUI) {
        if (bi.oW(aAQueryListUI.eCc)) {
            x.i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.eCb.setVisibility(8);
            return;
        }
        TextView bottomLinkTv = aAQueryListUI.eCb.getBottomLinkTv();
        bottomLinkTv.setClickable(true);
        bottomLinkTv.setOnTouchListener(new m(aAQueryListUI));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(i.aa_list_record_bottom_link_text));
        spannableStringBuilder.setSpan(new a(new 7(aAQueryListUI)), 0, spannableStringBuilder.length(), 18);
        bottomLinkTv.setText(spannableStringBuilder);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(i.aa_record_list_launch_title);
        addIconOptionMenu(0, e.mm_title_btn_menu, new 4(this));
        this.eBV = (ListView) findViewById(f.aa_query_listview);
        this.eBV.setOnScrollListener(new 2(this));
        this.eBV.setOnItemClickListener(new 3(this));
        this.eCa = new AAQueryListLoadingMoreView(this);
        this.eCb = new AAQueryListH5UrlFooterView(this);
        this.eBX = g.a(this, false, null);
        this.eBW = new b(this, this.mode);
        this.eBV.setAdapter(this.eBW);
        this.eBV.setVisibility(4);
        d(false, this.mode);
    }

    private void d(boolean z, int i) {
        if (this.eBY) {
            x.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            return;
        }
        if (z) {
            this.eBZ = false;
            this.eBV.removeFooterView(this.eCb);
        }
        this.eBY = true;
        com.tencent.mm.vending.g.g.v(Boolean.valueOf(z), Integer.valueOf(i)).c(this.eBU.eBm).f(new 6(this, z)).a(new 5(this));
    }

    protected final int getLayoutId() {
        return a.g.aa_query_list_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.eBV.setSelectionFromTop(intExtra, intExtra2);
                d(true, this.mode);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
