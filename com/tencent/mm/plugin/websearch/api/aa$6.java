package com.tencent.mm.plugin.websearch.api;

import android.webkit.ValueCallback;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

class aa$6 implements ValueCallback<String> {
    final /* synthetic */ aa pMf;
    final /* synthetic */ MMWebView pMh;

    aa$6(aa aaVar, MMWebView mMWebView) {
        this.pMf = aaVar;
        this.pMh = mMWebView;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        int i = 1;
        String str = (String) obj;
        x.i(this.pMf.TAG, "loadJS, sys:attach_runOn3rd_apis callback %s,view %s", new Object[]{str, this.pMh.toString()});
        this.pMf.pMc = true;
        long currentTimeMillis = System.currentTimeMillis() - this.pMf.pMe;
        h hVar = h.mEJ;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.pMf.pMb);
        objArr[1] = Integer.valueOf(2);
        objArr[2] = Long.valueOf(currentTimeMillis);
        if (!af.bTr().bTs()) {
            i = 2;
        }
        objArr[3] = Integer.valueOf(i);
        hVar.h(15005, objArr);
    }
}
