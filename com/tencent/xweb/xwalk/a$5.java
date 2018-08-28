package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import org.xwalk.core.R;
import org.xwalk.core.XWalkInitializer;

class a$5 implements OnClickListener {
    final /* synthetic */ a vEm;

    a$5(a aVar) {
        this.vEm = aVar;
    }

    public final void onClick(View view) {
        ((TextView) this.vEm.vEj.findViewById(R.id.txtVersion)).setText(this.vEm.vEe.getVersionInfo() + "\n" + XWalkInitializer.getXWalkInitializeLog());
    }
}
