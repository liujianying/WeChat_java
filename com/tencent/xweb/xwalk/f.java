package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.e;
import com.tencent.xweb.xwalk.e.a;
import com.tencent.xweb.xwalk.e.c;
import com.tencent.xweb.xwalk.e.d;
import org.xwalk.core.XWalkView;

public final class f implements com.tencent.xweb.c.f {
    j vEQ;
    k vER;
    XWalkView vES;

    public f(XWalkView xWalkView) {
        this.vES = xWalkView;
        this.vEQ = new j(xWalkView);
        this.vER = new k(xWalkView);
    }

    public final void w(String str, Bitmap bitmap) {
        this.vEQ.a(this.vES, str);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (customViewCallback instanceof a) {
            this.vEQ.a(view, ((a) customViewCallback).vEM);
        }
    }

    public final void onHideCustomView() {
        this.vEQ.cJi();
    }

    public final boolean a(String str, String str2, com.tencent.xweb.f fVar) {
        if (fVar instanceof c) {
            return this.vEQ.b(this.vES, str, str2, ((c) fVar).vEO);
        }
        return false;
    }

    public final boolean b(String str, String str2, com.tencent.xweb.f fVar) {
        if (fVar instanceof c) {
            return this.vEQ.a(this.vES, str, str2, ((c) fVar).vEO);
        }
        return false;
    }

    public final boolean a(String str, String str2, String str3, e eVar) {
        if (!(eVar instanceof d)) {
            return false;
        }
        return this.vEQ.a(this.vES, str, str2, str3, ((d) eVar).vEO);
    }
}
