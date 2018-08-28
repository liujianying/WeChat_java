package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class j extends b {
    LinearLayout usm = null;

    public j(Context context) {
        super(context);
        this.usm = new LinearLayout(context);
        this.usm.setVisibility(8);
        bc.Ig().dBY = new 1(this, context);
        bc.Ig().dBY.Ij();
    }

    public final boolean anR() {
        return this.usm != null && this.usm.getVisibility() == 0;
    }

    public final View getView() {
        return this.usm;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
        bc.Ig().dBY = null;
    }
}
