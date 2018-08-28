package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.account.a.j;

class RegSetInfoUI$18 implements OnItemClickListener {
    final /* synthetic */ RegSetInfoUI eWJ;
    final /* synthetic */ String[] eWO;

    RegSetInfoUI$18(RegSetInfoUI regSetInfoUI, String[] strArr) {
        this.eWJ = regSetInfoUI;
        this.eWO = strArr;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (RegSetInfoUI.t(this.eWJ) != null) {
            RegSetInfoUI.t(this.eWJ).dismiss();
            RegSetInfoUI.u(this.eWJ);
        }
        RegSetInfoUI.a(this.eWJ).setText(this.eWO[i]);
        RegSetInfoUI.a(this.eWJ).postDelayed(new 1(this), 50);
        RegSetInfoUI.r(this.eWJ).setText(this.eWJ.getString(j.regsetinfo_tip));
    }
}
