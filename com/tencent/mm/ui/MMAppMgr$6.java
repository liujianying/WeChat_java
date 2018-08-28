package com.tencent.mm.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class MMAppMgr$6 implements OnCheckedChangeListener {
    MMAppMgr$6() {
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        au.HU();
        c.DT().set(16385, Boolean.valueOf(!z));
    }
}
