package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.c.v;

public class CollectHKMainUI extends CollectMainUI {
    private boolean hXJ = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hYE.setVisibility(8);
        findViewById(f.collect_main_hk_tips).setVisibility(0);
        findViewById(f.collect_menu_more_btn_layout).setVisibility(8);
        cDP().jr(1335);
        addIconOptionMenu(0, e.wallet_qanda_icon, new 1(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        cDP().js(1335);
    }

    protected final void aCk() {
        g.Ek();
        this.hYg = (String) g.Ei().DT().get(a.sXo, "");
        m mVar = new m(q.GM());
        if (bi.oW(this.hYg)) {
            x.i("MicroMsg.CollectHKMainUI", "force load payurl");
            this.hXJ = true;
            cDP().a(mVar, true, 1);
            return;
        }
        cDP().a(mVar, false, 1);
    }

    protected final String aCl() {
        return this.hYh;
    }

    protected final String aCm() {
        if (bi.oW(this.hYi)) {
            this.hYi = v.cDm();
        }
        return this.hYi;
    }

    public final boolean h(int i, int i2, String str, l lVar) {
        if (lVar instanceof m) {
            m mVar = (m) lVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[]{lVar});
            } else if (mVar.hUm == 0) {
                this.hYg = mVar.hUo;
                this.hYh = mVar.hUA;
                this.hYi = mVar.hUx;
                aoV();
                if (bi.oW(mVar.hUu)) {
                    this.hYE.setVisibility(8);
                } else {
                    this.hYB.setText(mVar.hUu);
                    this.hYE.setOnClickListener(new 2(this, mVar));
                    this.hYE.setVisibility(0);
                }
                if (bi.oW(mVar.hUy)) {
                    this.hYd.setVisibility(8);
                } else {
                    this.hYd.setText(mVar.hUy);
                    this.hYd.setOnClickListener(new 3(this, mVar));
                    this.hYd.setVisibility(0);
                }
                return true;
            }
            if (!this.hXJ) {
                return true;
            }
        }
        return false;
    }

    protected final void aCn() {
        ImageView imageView = (ImageView) this.hVW.findViewById(f.collect_main_save_top_logo_iv);
        ImageView imageView2 = (ImageView) this.hVW.findViewById(f.collect_main_save_bottom_logo_iv);
        LayoutParams layoutParams = (LayoutParams) imageView2.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.addRule(13);
        imageView2.setLayoutParams(layoutParams);
        if (w.chP().equals("zh_HK")) {
            imageView.setImageResource(h.collect_top_logo_hk_traditional);
            imageView2.setImageResource(h.collect_bottom_logo_hk_traditional);
            return;
        }
        imageView.setImageResource(h.collect_top_logo_hk);
        imageView2.setImageResource(h.collect_bottom_logo_hk);
    }

    protected final void aCo() {
        super.aCo();
        if (this.hYo) {
            findViewById(f.collect_main_hk_tips).setVisibility(8);
        } else {
            findViewById(f.collect_main_hk_tips).setVisibility(0);
        }
    }
}
