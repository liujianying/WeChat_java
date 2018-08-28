package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;

class a$10 implements OnClickListener {
    final /* synthetic */ a vEm;

    a$10(a aVar) {
        this.vEm = aVar;
    }

    public final void onClick(View view) {
        k.cIn().a("tools", d.vAQ);
        k.cIn().a("appbrand", d.vAQ);
        k.cIn().a("support", d.vAQ);
        if (WebView.getInstalledTbsCoreVersion(this.vEm.vAp) <= 0) {
            this.vEm.bG("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
        } else {
            this.vEm.adI("已使用x5，点任意位置重启进程生效\n");
        }
    }
}
