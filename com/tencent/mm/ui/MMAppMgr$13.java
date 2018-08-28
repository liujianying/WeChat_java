package com.tencent.mm.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class MMAppMgr$13 implements OnCheckedChangeListener {
    MMAppMgr$13() {
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        au.HU();
        c.DT().set(61, Boolean.valueOf(z));
    }
}
