package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;
import com.tencent.rtmp.TXLiveConstants;

final class AppBrandStarListUI$a$f extends t implements OnClickListener, OnLongClickListener {
    final /* synthetic */ a gvU;
    k gwi;
    ImageView gwj;
    TextView gwk;
    TextView gwl;
    View gwm;

    AppBrandStarListUI$a$f(a aVar, View view) {
        this.gvU = aVar;
        super(view);
        this.gwj = (ImageView) view.findViewById(g.icon);
        this.gwk = (TextView) view.findViewById(g.name);
        this.gwl = (TextView) view.findViewById(g.tag_text);
        this.gwm = view.findViewById(g.btn_delete);
        this.gwm.setOnClickListener(this);
        this.SU.setOnClickListener(this);
        this.SU.setOnLongClickListener(this);
    }

    public final void onClick(View view) {
        if (this.gwi != null) {
            if (a.e(this.gvU) && view == this.gwm) {
                c.Em().H(new 1(this, this.gwi.bGy, this.gwi.fig, gm()));
            }
            if (!a.e(this.gvU) && view == this.SU) {
                k kVar = this.gwi;
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = TXLiveConstants.PUSH_EVT_OPEN_CAMERA_SUCC;
                AppBrandLaunchProxyUI.a(this.gvU.getActivity(), kVar.bGy, null, kVar.fig, -1, appBrandStatObject, null);
            }
        }
    }

    public final boolean onLongClick(View view) {
        if (a.e(this.gvU)) {
            return false;
        }
        a.g(this.gvU);
        return true;
    }
}
