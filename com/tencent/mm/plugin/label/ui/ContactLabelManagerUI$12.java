package com.tencent.mm.plugin.label.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class ContactLabelManagerUI$12 implements OnItemLongClickListener {
    final /* synthetic */ ContactLabelManagerUI kBk;

    ContactLabelManagerUI$12(ContactLabelManagerUI contactLabelManagerUI) {
        this.kBk = contactLabelManagerUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ContactLabelManagerUI.f(this.kBk).a(view, i, j, this.kBk, this.kBk, ContactLabelManagerUI.d(this.kBk), ContactLabelManagerUI.e(this.kBk));
        return true;
    }
}
