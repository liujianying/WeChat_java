package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.splash.g.a;
import java.io.File;

public class SplashFallbackActivity extends Activity {
    private Handler mHandler;
    private Runnable sMT = new Runnable() {
        private long sMU = -1;

        public final void run() {
            if (this.sMU == -1) {
                this.sMU = System.currentTimeMillis();
            }
            if (SplashFallbackActivity.ckj()) {
                h.b("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(a.splash_no_anim, a.splash_faded_out);
            } else if (System.currentTimeMillis() - this.sMU >= 80000) {
                h.b("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(a.splash_no_anim, a.splash_faded_out);
            } else {
                SplashFallbackActivity.this.mHandler.postDelayed(SplashFallbackActivity.this.sMT, 100);
            }
        }
    };

    static /* synthetic */ boolean ckj() {
        String cjM = a.cjM();
        if (!new File(cjM).exists()) {
            h.b("MicroMsg.FigLeaf", "dex opt dir not exists.", new Object[0]);
        } else if (new File(cjM + "/main-process-blocking").exists()) {
            return false;
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.b("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("splash-activity");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.postDelayed(this.sMT, 100);
    }

    public void onBackPressed() {
        h.b("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
    }
}
