package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AddAppUI$4 implements OnItemClickListener {
    final /* synthetic */ AddAppUI osB;

    AddAppUI$4(AddAppUI addAppUI) {
        this.osB = addAppUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AddAppUI.a(this.osB, AddAppUI.b(this.osB).xV(i).field_appId);
    }
}
