package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class EnterpriseBizContactPlainListUI$1 implements OnItemClickListener {
    final /* synthetic */ EnterpriseBizContactPlainListUI hpF;

    EnterpriseBizContactPlainListUI$1(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI) {
        this.hpF = enterpriseBizContactPlainListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[]{Integer.valueOf(i)});
        EnterpriseBizContactPlainListUI.a(this.hpF, i);
    }
}
