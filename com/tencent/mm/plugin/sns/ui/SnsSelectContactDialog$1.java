package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class SnsSelectContactDialog$1 implements OnItemClickListener {
    final /* synthetic */ SnsSelectContactDialog nZA;

    SnsSelectContactDialog$1(SnsSelectContactDialog snsSelectContactDialog) {
        this.nZA = snsSelectContactDialog;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == SnsSelectContactDialog.a(this.nZA).getCount() - 1) {
            SnsSelectContactDialog.b(this.nZA);
        } else {
            SnsSelectContactDialog.c(this.nZA).remove(i);
        }
        SnsSelectContactDialog.a(this.nZA).refresh();
    }
}
