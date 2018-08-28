package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.selectcontact.a.d;

class MultiSelectContactView$3 implements OnFocusChangeListener {
    final /* synthetic */ MultiSelectContactView qGe;

    MultiSelectContactView$3(MultiSelectContactView multiSelectContactView) {
        this.qGe = multiSelectContactView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            MultiSelectContactView.e(this.qGe).setBackgroundResource(d.input_bar_bg_active);
            MultiSelectContactView.e(this.qGe).setPadding(MultiSelectContactView.f(this.qGe), MultiSelectContactView.f(this.qGe), MultiSelectContactView.f(this.qGe), MultiSelectContactView.f(this.qGe));
        } else {
            MultiSelectContactView.e(this.qGe).setBackgroundResource(d.input_bar_bg_normal);
            MultiSelectContactView.e(this.qGe).setPadding(MultiSelectContactView.f(this.qGe), MultiSelectContactView.f(this.qGe), MultiSelectContactView.f(this.qGe), MultiSelectContactView.f(this.qGe));
        }
        if (MultiSelectContactView.g(this.qGe) != null) {
            MultiSelectContactView.g(this.qGe).cdq();
        }
    }
}
