package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import org.xwalk.core.XWalkEnvironment;

class a$4 implements OnClickListener {
    final /* synthetic */ a vEm;

    a$4(a aVar) {
        this.vEm = aVar;
    }

    public final void onClick(View view) {
        XWalkEnvironment.clearAllVersion(this.vEm.vAp);
    }
}
