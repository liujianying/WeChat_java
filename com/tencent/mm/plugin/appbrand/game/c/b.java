package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.plugin.appbrand.game.e.g;
import com.tencent.mm.plugin.appbrand.game.m;
import com.tencent.xweb.WebView;
import java.util.LinkedList;

public final class b extends WebView {
    boolean fBd = false;
    public View fBe;
    LinkedList<String> fBf;
    boolean fBg = false;

    public b(Context context) {
        super(context);
        getSettings().setJavaScriptEnabled(true);
        this.fBe = new a(getContext());
        this.fBe.setOnClickListener(new 1(this));
        setWebViewClient(new 2(this));
        loadUrl("wagame://WAGameVConsole.html");
        setTranslationY((float) getDisplayHeight());
    }

    public final View getConsoleButton() {
        return this.fBe;
    }

    private static int getDisplayHeight() {
        Point point = new Point();
        m mVar = m.fAw;
        m.e(point);
        return point.y;
    }

    /* renamed from: sS */
    final void a(String str) {
        String tc = g.tc(str);
        if (VERSION.SDK_INT >= 19) {
            evaluateJavascript("console._log('" + tc + "')", null);
        } else {
            loadUrl("javascript:console._log('" + tc + "')");
        }
    }
}
