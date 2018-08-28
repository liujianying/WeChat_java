package com.tencent.mm.splash;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mm.splash.g.a;
import java.util.Iterator;

public class SplashActivity extends Activity {
    private boolean sMR = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.a(this);
        h.b("WxSplash.SplashActivity", "onCreate", new Object[0]);
        if (!h.cjV()) {
            h.b("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
            ckh();
        }
        if (h.sMI != null) {
            h.sMI.e(this);
        }
    }

    protected void onResume() {
        super.onResume();
        h.b("WxSplash.SplashActivity", "onResume", new Object[0]);
    }

    public void onPause() {
        h.b("WxSplash.SplashActivity", "onPause", new Object[0]);
        super.onPause();
    }

    protected void onDestroy() {
        h.b(this);
        h.b("WxSplash.SplashActivity", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (h.sMz != null) {
            h.sMz.a(this, i, strArr, iArr);
        }
    }

    private void ckg() {
        if (h.sMz.b(this, new Runnable() {
            public final void run() {
                SplashActivity.this.ckg();
            }
        })) {
            cki();
        }
    }

    public final void ckh() {
        if (h.sMz == null) {
            h.b("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
            cki();
        } else if (!h.sMz.a(this, new Runnable() {
            public final void run() {
                SplashActivity.this.ckg();
            }
        })) {
            ckg();
        }
    }

    private void cki() {
        if (!this.sMR) {
            this.sMR = true;
            h.sMz = null;
            if (isFinishing()) {
                onBackPressed();
                return;
            }
            setResult(-100);
            int intExtra = getIntent().getIntExtra("hashcode", 0);
            Iterator it = h.sMv.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (intExtra == iVar.hashCode()) {
                    iVar.recreate();
                    h.b("WxSplash.SplashActivity", "do recreate", new Object[0]);
                    break;
                }
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    SplashActivity.this.finish();
                    SplashActivity.this.overridePendingTransition(a.splash_no_anim, a.splash_fast_faded_out);
                }
            }, 50);
        }
    }
}
