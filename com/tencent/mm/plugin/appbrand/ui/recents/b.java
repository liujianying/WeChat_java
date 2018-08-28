package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class b {
    View SU;
    ThreeDotsLoadingView gzp = ((ThreeDotsLoadingView) this.SU.findViewById(g.loading_view));
    View gzq = this.SU.findViewById(g.footer_top_divider);
    View gzr = this.SU.findViewById(g.end_tip);

    final void setLoading(boolean z) {
        if (z) {
            if (this.gzp != null) {
                this.gzp.setVisibility(0);
                this.gzp.cAG();
            }
            if (this.gzr != null) {
                this.gzr.setVisibility(8);
                return;
            }
            return;
        }
        if (this.gzp != null) {
            this.gzp.cAH();
            this.gzp.setVisibility(8);
        }
        if (this.gzr != null) {
            this.gzr.setVisibility(0);
        }
    }

    b(Context context, ViewGroup viewGroup) {
        this.SU = LayoutInflater.from(context).inflate(h.app_brand_recents_list_footer, viewGroup, false);
    }
}
