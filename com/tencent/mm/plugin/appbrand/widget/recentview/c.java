package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import java.util.List;

public class c extends BaseAppBrandRecentView {
    private a gPu;
    private boolean gPv = false;

    public c(Context context) {
        super(context);
    }

    public final void a(b bVar, a aVar) {
        super.a(bVar, aVar);
        if (aVar.type == 0) {
            bVar.eBO.setVisibility(4);
            bVar.gmn.setImageResource(d.multitask_bar_more_btn);
        }
    }

    protected int getLoadCount() {
        return 11;
    }

    protected String getType() {
        return c.class.getSimpleName();
    }

    public final void as(List<a> list) {
        list.add(new a());
    }

    public void setOnItemClickListener(a aVar) {
        this.gPu = aVar;
    }

    protected final void init(Context context) {
        super.init(context);
        super.setOnItemClickListener(new 1(this));
    }

    protected final boolean aqB() {
        boolean z = this.gPv;
        this.gPv = false;
        return z;
    }
}
