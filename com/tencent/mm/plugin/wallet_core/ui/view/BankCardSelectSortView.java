package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.d;

public class BankCardSelectSortView extends BaseSortView {
    private ListView hqn;

    public static class a {
        public String bWP;
        public String lNT;
        public String mcD;
        public String pzm;
    }

    public BankCardSelectSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View inflate() {
        return View.inflate(getContext(), a$g.bank_remit_sort_view, this);
    }

    public VerticalScrollBar getScrollBar() {
        return (VerticalScrollBar) findViewById(a$f.sidrbar);
    }

    public ListView getListView() {
        this.hqn = (ListView) findViewById(a$f.listview);
        return this.hqn;
    }

    public View getNoResultView() {
        return findViewById(a$f.bankcard_no_result_tv);
    }

    public final boolean a(String str, d dVar) {
        return ((a) dVar.data).lNT.toUpperCase().contains(str.toUpperCase());
    }

    public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator() {
        return new 1(this);
    }
}
