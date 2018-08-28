package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AddAppUI$3 implements OnItemClickListener {
    final /* synthetic */ AddAppUI osB;

    AddAppUI$3(AddAppUI addAppUI) {
        this.osB = addAppUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AddAppUI.f(AddAppUI.a(this.osB).xV(i));
        this.osB.initView();
    }
}
