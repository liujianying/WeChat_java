package com.tencent.mm.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class MMAppMgr$7 implements OnCheckedChangeListener {
    MMAppMgr$7() {
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            au.HU();
            c.DT().set(4105, Boolean.valueOf(true));
            return;
        }
        au.HU();
        c.DT().set(4105, Boolean.valueOf(false));
    }
}
