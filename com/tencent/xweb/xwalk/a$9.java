package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView$d;
import com.tencent.xweb.k;
import org.xwalk.core.XWalkEnvironment;

class a$9 implements OnClickListener {
    final /* synthetic */ a vEm;

    a$9(a aVar) {
        this.vEm = aVar;
    }

    public final void onClick(View view) {
        XWalkEnvironment.setGrayValueForTest(1);
        if (XWalkEnvironment.hasAvailableVersion()) {
            k.cIn().a("tools", WebView$d.WV_KIND_CW);
            k.cIn().a("appbrand", WebView$d.WV_KIND_CW);
            k.cIn().a("support", WebView$d.WV_KIND_CW);
            this.vEm.adI("已使用XWeb，点任意位置重启进程生效\n");
            return;
        }
        this.vEm.adD("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
    }
}
