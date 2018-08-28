package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.j.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b$e;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI extends MMActivity implements a {
    String appId;
    int bPh;
    int fii;
    ConsolePanel fxO;
    String id;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(b$e.wxa_widget_console);
        this.fxO = (ConsolePanel) findViewById(b.console_widget);
        if (!afz()) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!afz()) {
            finish();
        }
    }

    private boolean afz() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("id");
        this.appId = intent.getStringExtra("app_id");
        this.bPh = intent.getIntExtra("pkg_type", 0);
        this.fii = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{stringExtra}));
        if (bi.oW(stringExtra)) {
            return false;
        }
        if (stringExtra.equals(this.id)) {
            return true;
        }
        ((e) g.l(e.class)).JN().b(this.id, this);
        ((e) g.l(e.class)).JN().a(stringExtra, this);
        this.id = stringExtra;
        d.a(this.fxO);
        return true;
    }

    public final void hp(int i) {
        String str;
        switch (i) {
            case 1:
                str = "(START)";
                break;
            case 2:
                str = "(RESUME)";
                break;
            case 3:
                str = "(PAUSE)";
                break;
            case 4:
                str = "(STOP)";
                break;
            default:
                str = "";
                break;
        }
        com.tencent.mm.bu.a.ab(new 2(this, str));
    }

    protected void onDestroy() {
        super.onDestroy();
        ((e) g.l(e.class)).JN().b(this.id, this);
        d.b(this.fxO);
    }

    public void finish() {
        if (!isFinishing() && !this.tlP) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    protected final int getLayoutId() {
        return c.widget_console_ui;
    }
}
