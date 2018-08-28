package com.tencent.mm.app;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.splash.SplashActivity;
import com.tencent.mm.ui.MMActivity;

public class WeChatSplashActivity extends SplashActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MMActivity.initLanguage(getBaseContext());
        setContentView(2130905065);
    }

    public Resources getResources() {
        if (getAssets() == null || ad.getResources() == null) {
            return super.getResources();
        }
        return ad.getResources();
    }

    protected void onPause() {
        r.cbl();
        super.onPause();
    }
}
