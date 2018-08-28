package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.g;

class WxaBindBizInfoUI$b extends t {
    TextView eBO;
    View eCO;
    ImageView gxd;

    public WxaBindBizInfoUI$b(View view) {
        super(view);
        this.gxd = (ImageView) view.findViewById(g.icon);
        this.eBO = (TextView) view.findViewById(g.primary_text);
        this.eCO = view.findViewById(g.divider);
    }
}
