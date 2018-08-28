package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appusage.j$d;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.v;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;

final class a$d extends t implements OnClickListener, OnCreateContextMenuListener, d {
    View eCO;
    ImageView gwj;
    final /* synthetic */ a gyS;
    TextView gzf;
    TextView gzg;
    TextView gzh;
    TextView gzi;
    View gzj;
    a gzk;
    final int gzl = 1;
    final int gzm = 2;

    a$d(a aVar, View view) {
        this.gyS = aVar;
        super(view);
        this.eCO = view.findViewById(g.divider);
        this.gzf = (TextView) view.findViewById(g.primary_text);
        this.gzg = (TextView) view.findViewById(g.secondary_text);
        this.gzh = (TextView) view.findViewById(g.tag_text);
        this.gzi = (TextView) view.findViewById(g.count_text);
        this.gwj = (ImageView) view.findViewById(g.icon);
        this.gzj = view.findViewById(g.star_icon);
        view.setOnClickListener(this);
        this.gzk = new 1(this, this.SU.getContext());
        this.gzk.c(this.SU, this, this);
    }

    private int aoe() {
        return a.g(this.gyS).G(this);
    }

    final k aof() {
        try {
            return (k) a.b(this.gyS).lM(aoe());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e, "getAppInfo", new Object[0]);
            return null;
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        k aof = aof();
        if (aof != null) {
            if (a.l(this.gyS)) {
                contextMenu.add(0, 1, 0, this.SU.getContext().getString(aof.fmd ? j.app_brand_launcher_recents_list_menu_unmark_favorite : j.app_brand_launcher_recents_list_menu_mark_favorite));
            }
            contextMenu.add(0, 2, 0, this.SU.getContext().getString(j.app_brand_launcher_recents_list_menu_delete));
        }
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        k aof = aof();
        if (aof != null && menuItem != null) {
            if (1 == menuItem.getItemId()) {
                if (a.a(this.gyS).aom().size() < a.s(this.gyS) || aof.fmd) {
                    a.u(this.gyS).H(new 2(this, aof));
                    a.f(this.gyS).gAB = true;
                } else if (this.gyS.getActivity() != null) {
                    Toast.makeText(this.gyS.getActivity(), this.gyS.getActivity().getString(j.app_brand_star_list_full_size_tip, new Object[]{Integer.valueOf(a.s(this.gyS))}), 1).show();
                }
            } else if (2 == menuItem.getItemId()) {
                if (aof.fmd) {
                    a.u(this.gyS).H(new 3(this, aof));
                } else if (aoe() < a.a(this.gyS).size()) {
                    com.tencent.mm.plugin.appbrand.report.a.b(aof.appId, aof.fig + 1, 3, 1, a.t(this.gyS));
                }
                a.a(this.gyS).lL(aoe());
                a.f(this.gyS).gAB = true;
                a.e(this.gyS).aod();
                a.b(this.gyS).bn(aoe());
                a.c(this.gyS);
                v.l(aof.bGy, aof.appId, aof.fig);
            }
        }
    }

    public final void onClick(View view) {
        k aof = aof();
        if (aof != null) {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1001;
            switch (this.gyS.fdx) {
                case 10:
                    appBrandStatObject.cbB = 11;
                    break;
                case 11:
                    appBrandStatObject.cbB = 12;
                    break;
                case 13:
                    appBrandStatObject.cbB = 13;
                    break;
            }
            AppBrandLaunchProxyUI.a(this.gyS.getActivity(), aof.bGy, null, aof.fig, -1, appBrandStatObject, null);
            if (this.gyS.getActivity() != null) {
                j$d j_d = ((AppBrandLauncherUI) this.gyS.getActivity()).guF;
                if (j_d != null) {
                    j_d.flZ[7] = "1";
                }
            }
        }
    }
}
