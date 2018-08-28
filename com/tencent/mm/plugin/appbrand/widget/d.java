package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.g.a.if;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements com.tencent.mm.plugin.appbrand.widget.recentview.d {
    public final AppBrandRecentView z(Context context, int i) {
        return a(context, i, null);
    }

    public final AppBrandRecentView a(Context context, int i, a aVar) {
        LayoutParams layoutParams;
        if (i == b.gPA) {
            c cVar = new c(context);
            cVar.setSceneFactory(aVar);
            layoutParams = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(k.a.app_brand_recent_view_height));
            cVar.setPadding(0, (int) context.getResources().getDimension(k.a.app_brand_recent_view_padding_top), 0, 0);
            cVar.setLayoutParams(layoutParams);
            return cVar;
        } else if (i != b.gPz) {
            return null;
        } else {
            AppBrandRecentView menuAppBrandRecentView = new MenuAppBrandRecentView(context);
            menuAppBrandRecentView.setSceneFactory(aVar);
            layoutParams = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(k.a.app_brand_recent_view_height));
            menuAppBrandRecentView.setPadding(0, (int) context.getResources().getDimension(k.a.app_brand_recent_view_padding_top), 0, 0);
            menuAppBrandRecentView.setLayoutParams(layoutParams);
            return menuAppBrandRecentView;
        }
    }

    public final void cN(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
        intent.putExtra("isShowHeaderWithAnim", true);
        intent.putExtra("isShowHeader", true);
        intent.putExtra("isScrollFirst", true);
        context.startActivity(intent);
    }

    public final void aoX() {
        x.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", new Object[]{Integer.valueOf(300), Integer.valueOf(8)});
        if (((h) g.Ef().DM()).ES()) {
            if ifVar = new if();
            ifVar.bRG.delay = 300;
            ifVar.bRG.type = 8;
            com.tencent.mm.sdk.b.a.sFg.m(ifVar);
        }
    }

    public final com.tencent.mm.plugin.appbrand.widget.recentview.b aoY() {
        return new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    }
}
