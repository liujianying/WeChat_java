package com.tencent.mm.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

final class i extends Activity {
    public String sMW;

    i() {
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.b("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
        setVisible(false);
        Intent intent = new Intent(this, h.ckc());
        intent.putExtra("hashcode", hashCode());
        startActivityForResult(intent, 100);
    }

    protected final void onNewIntent(Intent intent) {
        h.b("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
        if (h.sMz != null && h.sMz.k(intent)) {
            finish();
        }
    }

    protected final void onResume() {
        super.onResume();
        h.b("WxSplash.SplashHackActivity", "onResume", new Object[0]);
    }

    protected final void onPause() {
        h.b("WxSplash.SplashHackActivity", "onPause", new Object[0]);
        super.onPause();
    }

    protected final void onDestroy() {
        h.b("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
        h.sMv.remove(this);
        setVisible(true);
        h.sMv.remove(this);
        super.onDestroy();
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        if (i != 100) {
            finish();
            h.b("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
        } else if (i2 != -100) {
            onBackPressed();
        }
    }
}
