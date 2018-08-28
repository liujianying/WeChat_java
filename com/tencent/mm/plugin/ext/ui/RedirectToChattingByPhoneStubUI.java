package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class RedirectToChattingByPhoneStubUI extends Activity implements e {
    private p iKZ = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getString(R.l.app_waiting);
        this.iKZ = h.a(this, "", false, null);
        ah.i(new 1(this), 500);
        au.DF().a(s$l.AppCompatTheme_ratingBarStyle, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(s$l.AppCompatTheme_ratingBarStyle, this);
        if (this.iKZ != null) {
            this.iKZ.dismiss();
            this.iKZ = null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        finish();
    }

    public final boolean hideVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", new Object[]{e});
            hideSoftInputFromWindow = false;
        }
        x.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", new Object[]{Boolean.valueOf(hideSoftInputFromWindow)});
        return hideSoftInputFromWindow;
    }
}
