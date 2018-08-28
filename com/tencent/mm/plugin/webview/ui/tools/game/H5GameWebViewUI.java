package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(19)
public class H5GameWebViewUI extends GameWebViewUI {
    private int lfm;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.H5GameWebViewUI", "onCreate");
        this.jJB = false;
        this.lfm = this.screenOrientation;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
        super.onNewIntent(intent);
        boolean booleanExtra = getIntent().getBooleanExtra("show_full_screen", false);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("rawUrl");
        x.d("MicroMsg.H5GameWebViewUI", "url = " + stringExtra);
        if (!this.pXP.equals(stringExtra)) {
            if (stringExtra.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
                this.pXP = stringExtra;
            }
            if (this.cbP.equals(stringExtra)) {
                this.screenOrientation = this.lfm;
                getIntent().putExtra("show_full_screen", booleanExtra);
                bWe();
                return;
            }
            this.cbP = stringExtra;
            this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
            this.pYo.jIf = this.cbP;
            if (this.gcP == null) {
                this.gcP = new e(this, this.mhH);
            } else {
                this.gcP.b(stringExtra, null, null);
            }
            this.mhH.loadUrl("about:blank");
            super.j(this.cbP, false, -1);
        }
    }

    public void onResume() {
        ahy();
        super.onResume();
    }

    protected final boolean bVZ() {
        return false;
    }

    protected final boolean bVQ() {
        return false;
    }
}
