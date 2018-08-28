package com.tencent.mm.plugin.luckymoney.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.f;

public abstract class LuckyMoneyBaseUI extends MMActivity implements f {
    public j kUg = null;

    public abstract boolean d(int i, int i2, String str, l lVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kUg = new j(this, this);
        this.kUg.jr(1554);
        this.kUg.jr(1575);
        this.kUg.jr(1668);
        this.kUg.jr(1581);
        this.kUg.jr(1685);
        this.kUg.jr(1585);
        this.kUg.jr(1514);
        this.kUg.jr(1682);
        this.kUg.jr(1612);
        this.kUg.jr(1643);
        this.kUg.jr(1558);
        lF(getResources().getColor(c.lucky_money_goldstyle_actionbar_bg_color));
        DN(getResources().getColor(c.lucky_money_goldstyle_envelop_primary_text_color));
        getLayoutId();
    }

    public static void bbo() {
    }

    public final void bbp() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            lF(getResources().getColor(c.lucky_money_goldstyle_actionbar_bg_color));
        }
    }

    public final void bbq() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void onDestroy() {
        this.kUg.js(1554);
        this.kUg.js(1575);
        this.kUg.js(1668);
        this.kUg.js(1581);
        this.kUg.js(1685);
        this.kUg.js(1585);
        this.kUg.js(1514);
        this.kUg.js(1682);
        this.kUg.js(1612);
        this.kUg.js(1643);
        this.kUg.js(1558);
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kUg.baU()) {
                this.kUg.baT();
            }
            if (this.mController.contentView.getVisibility() == 8 || this.mController.contentView.getVisibility() == 4) {
                finish();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void b(int i, int i2, String str, l lVar, boolean z) {
        if (!d(i, i2, str, lVar)) {
            if (i != 0 || i2 != 0) {
                h.bA(this, str);
                finish();
            }
        }
    }

    public final void jr(int i) {
        this.kUg.jr(i);
    }

    public final void js(int i) {
        this.kUg.js(i);
    }

    public final void b(l lVar, boolean z) {
        this.kUg.b(lVar, z);
    }

    public final void l(l lVar) {
        this.kUg.b(lVar, true);
    }
}
