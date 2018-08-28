package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class a$21 implements OnClickListener {
    final /* synthetic */ a vEm;
    final /* synthetic */ CheckBox vEs;

    a$21(a aVar, CheckBox checkBox) {
        this.vEm = aVar;
        this.vEs = checkBox;
    }

    public final void onClick(View view) {
        this.vEs.setChecked(!this.vEs.isChecked());
    }
}
