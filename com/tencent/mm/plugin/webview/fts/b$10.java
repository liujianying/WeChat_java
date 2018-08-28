package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.webview.fts.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import org.json.JSONObject;

class b$10 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ JSONObject fWx;
    final /* synthetic */ String fwt;
    final /* synthetic */ b pOa;
    final /* synthetic */ ThreeDotsLoadingView pOf;
    final /* synthetic */ String pOh;
    final /* synthetic */ AbsoluteLayout pOj;
    final /* synthetic */ View val$view;

    b$10(b bVar, String str, ThreeDotsLoadingView threeDotsLoadingView, String str2, String str3, View view, AbsoluteLayout absoluteLayout, JSONObject jSONObject) {
        this.pOa = bVar;
        this.bAj = str;
        this.pOf = threeDotsLoadingView;
        this.pOh = str2;
        this.fwt = str3;
        this.val$view = view;
        this.pOj = absoluteLayout;
        this.fWx = jSONObject;
    }

    public final void run() {
        int i;
        Bundle bundle = (Bundle) f.a("com.tencent.mm", new Bundle(), a.class);
        if (bundle != null) {
            i = bundle.getInt("search_wa_widget_init_out_time");
        } else {
            i = 0;
        }
        if (i == 0) {
            i = 8000;
        }
        x.i("FTSSearchWidgetMgr", "widget loading timeout is %d ms", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            ah.i(new 1(this), (long) i);
        }
    }
}
