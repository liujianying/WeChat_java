package com.tencent.xweb.xwalk;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.xweb.k;

class a$20 implements OnCheckedChangeListener {
    final /* synthetic */ a vEm;

    a$20(a aVar) {
        this.vEm = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        k cIn = k.cIn();
        if (z != cIn.vAs) {
            cIn.vAs = z;
            cIn.vAp.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", cIn.vAs).commit();
        }
        if (z) {
            this.vEm.cJk();
            this.vEm.vEh.setVisibility(0);
        } else if (this.vEm.vEh != null) {
            this.vEm.vEh.setVisibility(8);
        }
    }
}
