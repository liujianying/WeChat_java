package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private int OT;
    private View gmj;
    CustomViewCallback gmk;
    private int gml = 0;
    private Set<x> gmm = Collections.newSetFromMap(new ConcurrentHashMap());
    private Context mContext;

    c(Context context) {
        this.mContext = context;
    }

    final void r(View view, int i) {
        alE();
        this.gmj = view;
        MMActivity mMActivity = (MMActivity) this.mContext;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        this.gml = viewGroup.getSystemUiVisibility();
        viewGroup.addView(view, layoutParams);
        view.setX(0.0f);
        view.setY(0.0f);
        if (d.fS(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4102);
        }
        mMActivity.getWindow().addFlags(1024);
        this.OT = mMActivity.getRequestedOrientation();
        switch (i) {
            case -90:
                mMActivity.setRequestedOrientation(8);
                break;
            case 0:
                mMActivity.setRequestedOrientation(1);
                break;
            case a$k.AppCompatTheme_controlBackground /*90*/:
                mMActivity.setRequestedOrientation(0);
                break;
            default:
                mMActivity.setRequestedOrientation(9);
                break;
        }
        alF();
        m.Bk(1);
    }

    final boolean alE() {
        if (this.gmj == null) {
            return false;
        }
        if (this.gmk != null) {
            this.gmk.onCustomViewHidden();
        }
        MMActivity mMActivity = (MMActivity) this.mContext;
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        viewGroup.setSystemUiVisibility(this.gml);
        viewGroup.removeView(this.gmj);
        mMActivity.getWindow().clearFlags(1024);
        mMActivity.setRequestedOrientation(this.OT);
        this.gmj = null;
        this.gmk = null;
        for (x ajd : this.gmm) {
            ajd.ajd();
        }
        m.Bk(2);
        return true;
    }

    final void a(x xVar) {
        this.gmm.add(xVar);
    }

    private void alF() {
        Iterator it = this.gmm.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
