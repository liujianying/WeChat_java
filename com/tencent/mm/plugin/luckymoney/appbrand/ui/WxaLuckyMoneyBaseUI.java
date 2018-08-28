package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyCompleteUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.c;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.b;
import com.tencent.mm.plugin.luckymoney.ui.j;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public abstract class WxaLuckyMoneyBaseUI extends MMActivity {
    private c kLj = null;
    private int kLk = 4095;
    private final SparseArray<a> kLl = new SparseArray();
    private final Class[][] kLm;

    public WxaLuckyMoneyBaseUI() {
        r0 = new Class[4][];
        r0[0] = new Class[]{b.class, WxaLuckyMoneyReceiveUI.class};
        r0[1] = new Class[]{c.class, WxaLuckyMoneyPrepareUI.class};
        r0[2] = new Class[]{com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, WxaLuckyMoneyDetailUI.class};
        r0[3] = new Class[]{com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.b.class, WxaLuckyMoneyCompleteUI.class};
        this.kLm = r0;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kLj = new c(this);
        this.kLj.kXx = 1;
        c cVar = this.kLj;
        MMActivity mMActivity = cVar.fcq;
        int i = cVar.kXx;
        j.a aVar = new j.a();
        Resources resources = mMActivity.getResources();
        switch (i) {
            case 1:
                aVar.kXz = new ColorDrawable(resources.getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_actionbar_bg_color));
                aVar.gND = resources.getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_actionbar_primary_text_color);
                aVar.kXA = resources.getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_envelop_primary_text_color);
                aVar.kXB = resources.getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_envelop_primary_text_color);
                aVar.kXC = a$e.lucky_money_back_btn;
                aVar.kXD = resources.getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_goldstyle_status_bar_color);
                break;
            default:
                aVar.kXz = resources.getDrawable(a$e.lucky_money_actionbar_bg);
                aVar.gND = -1;
                aVar.kXB = resources.getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_subtitle_color);
                aVar.kXD = resources.getColor(com.tencent.mm.plugin.wxpay.a.c.lucky_money_base_status_bar_color);
                break;
        }
        if (cVar.fcq.getSupportActionBar() != null) {
            if (aVar.kXz != null) {
                cVar.fcq.getSupportActionBar().setBackgroundDrawable(aVar.kXz);
            }
            View customView = cVar.fcq.getSupportActionBar().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(f.divider);
                if (!(findViewById == null || aVar.gND == 0)) {
                    findViewById.setBackgroundColor(aVar.gND);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || aVar.kXA == 0)) {
                    textView.setTextColor(aVar.kXA);
                }
                textView = (TextView) customView.findViewById(16908309);
                if (!(textView == null || aVar.kXB == 0)) {
                    textView.setTextColor(aVar.kXB);
                }
                ImageView imageView = (ImageView) customView.findViewById(f.actionbar_up_indicator_btn);
                if (!(imageView == null || aVar.kXC == 0)) {
                    imageView.setImageResource(aVar.kXC);
                }
            }
            if (aVar.kXD != 0) {
                int i2 = aVar.kXD;
                if (j.bbD()) {
                    Window window = cVar.fcq.getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(i2);
                }
            }
        }
    }

    public final void p(Drawable drawable) {
        this.kLj.p(drawable);
    }

    public void onDestroy() {
        this.kLj = null;
        this.kLl.clear();
        super.onDestroy();
    }

    private Class<? extends MMActivity> D(Class cls) {
        Class<? extends MMActivity> cls2 = null;
        for (Class<? extends MMActivity>[] clsArr : this.kLm) {
            if (clsArr[0] == cls) {
                cls2 = clsArr[1];
            }
        }
        return cls2;
    }

    public final void a(Class cls, Intent intent, a aVar) {
        if (getMainLooper().getThread() != Thread.currentThread()) {
            runOnUiThread(new 1(this, cls, intent, aVar));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        Class D = D(cls);
        if (D == null) {
            throw new IllegalStateException("proceed to ui = [" + cls.getName() + "], but Target is null");
        }
        intent.setClass(this.mController.tml, D);
        if (aVar == null) {
            startActivity(intent);
            return;
        }
        int i = this.kLk;
        this.kLk = i + 1;
        startActivityForResult(intent, i);
        this.kLl.put(i, aVar);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        a aVar = (a) this.kLl.get(i);
        if (aVar != null) {
            x.i("MicroMsg.HjLuckyMoneyBaseUI", "damon warns you, requestCode == [%d], I used it, and skip. check your code if needed!!!!", new Object[]{Integer.valueOf(i)});
            aVar.c(i2, intent);
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void b(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }
}
