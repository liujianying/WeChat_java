package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.report.a.o;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;

@a(7)
public final class AppBrandGuideUI extends MMActivity implements f {
    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        setTheme(k.MMTheme_NoTitleTranslucent);
        super.onCreate(bundle);
        ak.a(getWindow());
        a aaY = e.aaY();
        if (aaY == null) {
            super.finish();
            return;
        }
        b.d(this);
        c.a aVar = new c.a(this);
        aVar.Gq(j.app_brand_entrance);
        View imageView = new ImageView(this);
        imageView.setImageResource(s.f.app_brand_guide_image);
        View textView = new TextView(this);
        textView.setText(j.app_brand_guide_message);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.argb(Math.round(137.70001f), 0, 0, 0));
        textView.setLineSpacing(0.0f, 1.2f);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, new LayoutParams(-1, -2));
        linearLayout.addView(textView, new LayoutParams(-1, -2));
        ((MarginLayoutParams) textView.getLayoutParams()).topMargin = com.tencent.mm.bp.a.fromDPToPix(this, 16);
        aVar.dR(linearLayout);
        aVar.a(new 1(this));
        aVar.Gu(j.close_btn);
        aVar.b(new 2(this));
        aVar.Gt(j.app_brand_guide_confirm_view_list);
        aVar.a(false, new 3(this));
        aVar.mF(false);
        aVar.mG(true);
        Dialog anj = aVar.anj();
        anj.setOnKeyListener(new 4(this));
        anj.show();
        o.a(o.a.gsw, aaY.gux);
        aaY.guw = false;
        aaY.gux = null;
    }

    protected final void onDestroy() {
        super.onDestroy();
        b.c(this);
    }

    public final void an(String str, int i) {
        finish();
    }
}
