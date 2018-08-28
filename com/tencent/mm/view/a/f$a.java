package com.tencent.mm.view.a;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.n.a.e;
import com.tencent.mm.view.a.f.b;

class f$a extends b {
    View eCO;
    TextView uTZ;
    final /* synthetic */ f uUa;

    public f$a(f fVar, View view, int i) {
        this.uUa = fVar;
        super(fVar, view, i);
        this.eCO = view.findViewById(e.smiley_panel_divider);
        this.uTZ = (TextView) view.findViewById(e.smiley_recent_hint);
    }
}
