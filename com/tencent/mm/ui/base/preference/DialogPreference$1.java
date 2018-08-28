package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class DialogPreference$1 implements OnItemClickListener {
    final /* synthetic */ DialogPreference tBO;

    DialogPreference$1(DialogPreference dialogPreference) {
        this.tBO = dialogPreference;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (DialogPreference.a(this.tBO) != null) {
            DialogPreference.a(this.tBO).dismiss();
        }
        this.tBO.setValue((String) DialogPreference.b(this.tBO).tBJ[i]);
        if (DialogPreference.c(this.tBO) != null) {
            DialogPreference.c(this.tBO).csi();
        }
        if (DialogPreference.d(this.tBO) != null) {
            DialogPreference.d(this.tBO).a(this.tBO, this.tBO.getValue());
        }
    }
}
