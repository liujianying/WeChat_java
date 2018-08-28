package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

final class d implements OnClickListener {
    b gzB;
    int gzC = c.gzN;
    final d gzD = new d((byte) 0);
    private final int gzE;
    private final int gzF = 200;
    private final a gzG;

    public d(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        this.gzG = new a(this, context, (byte) 0);
        View inflate = LayoutInflater.from(context).inflate(h.app_brand_recents_list_header_v2, viewGroup, false);
        this.gzD.SU = inflate;
        this.gzD.gzS = (TextView) inflate.findViewById(g.title);
        this.gzD.gzT = inflate.findViewById(g.nearby_showcase_container);
        this.gzD.gzV = (TextView) inflate.findViewById(g.notice_text);
        this.gzD.gzU = (AppBrandNearbyShowcaseView) inflate.findViewById(g.nearby_icon_showcase);
        this.gzD.gzp = (ThreeDotsLoadingView) inflate.findViewById(g.nearby_loading_view);
        this.gzD.gzW = (ImageView) inflate.findViewById(g.nearby_refresh_view);
        this.gzD.SU.setOnClickListener(this);
        this.gzD.gzS.setText(i);
        AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.gzD.gzU;
        if (appBrandNearbyShowcaseView != null) {
            appBrandNearbyShowcaseView.setIconLayerCount(4);
            appBrandNearbyShowcaseView.setIconSize(this.gzG.gzI + (this.gzG.gzK * 2));
            appBrandNearbyShowcaseView.setIconGap(this.gzG.gzJ);
        }
        this.gzE = a.g(context, com.tencent.mm.plugin.appbrand.s.d.grey_text_color);
    }

    protected final void aoi() {
        x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loading");
        this.gzC = c.gzO;
        bN(this.gzD.gzT);
        bN(this.gzD.gzW);
        bO(this.gzD.gzp);
        this.gzD.gzp.cAG();
    }

    protected final void a(List<String> list, String str, Integer num) {
        x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingSuccess");
        this.gzC = c.gzP;
        this.gzD.gzp.cAH();
        bN(this.gzD.gzp);
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.showLoadingSuccess empty iconUrl list");
            return;
        }
        int i;
        if (list != null) {
            this.gzD.gzU.setIconLayerCount(Math.min(list.size(), 4));
            this.gzD.gzU.aoT();
            a aVar = this.gzG;
            if (aVar.gzM == null) {
                aVar.gzM = new com.tencent.mm.plugin.appbrand.ui.widget.a(aVar.gzI, aVar.gzK);
            }
            com.tencent.mm.plugin.appbrand.ui.widget.a aVar2 = aVar.gzM;
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gzD.gzU.getChildCount()) {
                    break;
                }
                b.Ka().a(this.gzD.gzU.lT(i2), (String) list.get(i2), com.tencent.mm.modelappbrand.b.a.JZ(), aVar2);
                i = i2 + 1;
            }
        } else {
            x.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "prepareIconList without icon urls");
        }
        i = num == null ? this.gzE : num.intValue();
        if (this.gzD.gzV != null) {
            this.gzD.gzV.setText(str);
            this.gzD.gzV.setTextColor(i);
        }
        if (this.gzD.gzT != null) {
            bO(this.gzD.gzT);
            if (this.gzD.gzU != null) {
                this.gzD.gzU.aoU();
            }
            if (this.gzD.gzV != null) {
                this.gzD.gzV.setAlpha(0.0f);
                this.gzD.gzV.animate().alpha(1.0f).setDuration(500).start();
            }
        }
    }

    public final void onClick(View view) {
        if (this.gzB != null) {
            this.gzB.a(this.gzC, view);
        }
    }

    final void bN(View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new 1(this, view)).start();
        }
    }

    static void bO(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
    }
}
