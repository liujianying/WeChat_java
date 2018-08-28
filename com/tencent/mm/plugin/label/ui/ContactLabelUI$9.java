package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class ContactLabelUI$9 implements OnItemClickListener {
    final /* synthetic */ ContactLabelUI kBX;

    ContactLabelUI$9(ContactLabelUI contactLabelUI) {
        this.kBX = contactLabelUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ContactLabelUI.f(this.kBX) != null) {
            String jl = ContactLabelUI.f(this.kBX).jl(i);
            if (!bi.oW(jl) && ContactLabelUI.b(this.kBX) != null) {
                ContactLabelUI.b(this.kBX).crN();
                ContactLabelUI.b(this.kBX).bu(jl, true);
                ContactLabelUI.c(this.kBX).bv(jl, true);
            }
        }
    }
}
