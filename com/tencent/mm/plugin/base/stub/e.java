package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;

public final class e {
    static /* synthetic */ void n(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        intent.putExtra("showShare", false);
        ad.getContext().startActivity(intent);
        if (activity != null) {
            activity.finish();
        }
    }
}
