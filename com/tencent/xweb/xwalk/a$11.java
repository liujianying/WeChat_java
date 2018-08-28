package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;

class a$11 implements OnClickListener {
    final /* synthetic */ a vEm;

    a$11(a aVar) {
        this.vEm = aVar;
    }

    public final void onClick(View view) {
        k.cIn().a("tools", d.vAR);
        k.cIn().a("appbrand", d.vAR);
        k.cIn().a("support", d.vAR);
        this.vEm.adI("已使用system，点任意位置重启进程生效\n");
    }
}
