package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import org.xwalk.core.XWalkEnvironment;

class a$13 implements OnClickListener {
    final /* synthetic */ a vEm;

    a$13(a aVar) {
        this.vEm = aVar;
    }

    public final void onClick(View view) {
        XWalkEnvironment.setGrayValueForTest(0);
        XWalkEnvironment.setTestDownLoadUrl(this.vEm.vAp, "");
        k.cIn().a("tools", d.vAO);
        k.cIn().a("appbrand", d.vAO);
        k.cIn().a("support", d.vAO);
        this.vEm.adI("已使用AUTO，点任意位置重启进程生效\n");
    }
}
