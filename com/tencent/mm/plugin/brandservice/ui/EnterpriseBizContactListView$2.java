package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ac.f;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a.1;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a.2;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.e;

class EnterpriseBizContactListView$2 implements OnItemLongClickListener {
    final /* synthetic */ EnterpriseBizContactListView hpt;

    EnterpriseBizContactListView$2(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.hpt = enterpriseBizContactListView;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (EnterpriseBizContactListView.a(this.hpt) == null) {
            EnterpriseBizContactListView.a(this.hpt, new EnterpriseBizContactListView$a(this.hpt));
        }
        EnterpriseBizContactListView$a a = EnterpriseBizContactListView.a(this.hpt);
        int b = EnterpriseBizContactListView.b(this.hpt);
        int c = EnterpriseBizContactListView.c(this.hpt);
        if (a.hpv == null) {
            EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) a.hpw.get();
            if (enterpriseBizContactListView == null) {
                return false;
            }
            a.hpv = new e(enterpriseBizContactListView.getContext());
        }
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof c)) {
            return false;
        }
        a.hpu = ((c) tag).username;
        if (bi.oW(a.hpu) || f.eZ(a.hpu)) {
            return false;
        }
        a.hpv.uKV = view;
        a.hpv.a(adapterView, i, j, new 1(a, i), new 2(a), b, c);
        return true;
    }
}
