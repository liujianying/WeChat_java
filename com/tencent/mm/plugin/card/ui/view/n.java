package com.tencent.mm.plugin.card.ui.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a$a;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.sw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class n extends h {
    public n(g gVar, MMActivity mMActivity) {
        super(gVar, mMActivity);
    }

    public final int getLayoutId() {
        return a$e.card_code_dynamic_qrcode;
    }

    public final boolean i(b bVar) {
        if (bVar.awn().rnr) {
            pr prVar = bVar.awn().rnq;
            if (prVar == null || bi.oW(prVar.title)) {
                return true;
            }
            x.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : unavailable_qrcode_field is not null  !ban card show!");
            return false;
        }
        x.e("MicroMsg.CardDynamicQrCodeController", "isCanGetAndShowCode false : is_commom_card false!ban card show!");
        return false;
    }

    public final void g(ViewGroup viewGroup) {
        viewGroup.findViewById(d.code_qr_disable_layout).setVisibility(8);
        viewGroup.findViewById(d.code_qr_area).setVisibility(0);
    }

    public final void c(ViewGroup viewGroup, b bVar) {
        super.c(viewGroup, bVar);
        d(viewGroup, bVar);
    }

    final void d(ViewGroup viewGroup, b bVar) {
        sw swVar = bVar.awm().rol;
        View findViewById = viewGroup.findViewById(d.code_refresh_layout);
        if (swVar == null || !swVar.rwd) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        if (!bi.oW(swVar.rwe)) {
            ((TextView) viewGroup.findViewById(d.code_refresh_tv)).setText(swVar.rwe);
            ((ImageView) viewGroup.findViewById(d.code_refresh_icon)).setOnClickListener(new 1(this, viewGroup));
        }
    }

    public final boolean azJ() {
        return false;
    }

    public final boolean azK() {
        return true;
    }

    public final void a(ViewGroup viewGroup, b bVar) {
        am.axy().awD();
        viewGroup.findViewById(d.code_qr_disable_layout).setVisibility(0);
        viewGroup.findViewById(d.code_qr_area).setVisibility(8);
        pr prVar = bVar.awn().rnq;
        if (prVar != null) {
            viewGroup.findViewById(d.code_shade_layout).setVisibility(0);
            if (!bi.oW(prVar.title)) {
                Button button = (Button) viewGroup.findViewById(d.code_button);
                button.setText(prVar.title);
                button.setVisibility(0);
                a(button, bVar);
                button.setOnClickListener(new 2(this, prVar, bVar));
                if (!bi.oW(prVar.huX)) {
                    ((TextView) viewGroup.findViewById(d.code_first_title)).setText(prVar.huX);
                }
                TextView textView = (TextView) viewGroup.findViewById(d.code_second_title);
                if (bi.oW(prVar.huY)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setText(prVar.huY);
                textView.setVisibility(0);
            }
        }
    }

    public final void b(ViewGroup viewGroup, b bVar) {
        x.i("MicroMsg.CardDynamicQrCodeController", "onScreenShot! ");
        View findViewById = viewGroup.findViewById(d.code_qr_disable_layout);
        if (findViewById.getVisibility() == 0) {
            x.e("MicroMsg.CardDynamicQrCodeController", "code_qr_disable_layout is visible! do not show hint!");
            return;
        }
        findViewById.setVisibility(0);
        View findViewById2 = viewGroup.findViewById(d.code_refresh_layout);
        if (findViewById2.getVisibility() == 0) {
            findViewById2.setVisibility(8);
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(d.code_qr_area);
        imageView.setVisibility(8);
        View findViewById3 = viewGroup.findViewById(d.code_shade_layout);
        findViewById3.setVisibility(0);
        ((TextView) viewGroup.findViewById(d.code_first_title)).setText(this.gKS.getResources().getString(a$g.card_code_hint));
        Button button = (Button) viewGroup.findViewById(d.code_button);
        button.setVisibility(0);
        a(button, bVar);
        g axy = am.axy();
        if (bVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport do nothing return !cardInfo is null!");
        } else {
            axy.awD();
            k xq = am.axw().xq(bVar.awq());
            if (xq != null) {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport currentCode cardId =%s,codeId=%s", new Object[]{xq.field_card_id, xq.field_code_id});
                if (am.axw().ca(bVar.awq(), xq.field_code_id)) {
                    axy.a(bVar.awq(), xq.field_code_id, c.hIy);
                } else {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport delete failue! do not report! cardId =%s,codeId=%s", new Object[]{xq.field_card_id, xq.field_code_id});
                }
            } else {
                x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doScreenshotReport  failue! currentCode is null!");
            }
        }
        button.setOnClickListener(new 3(this, findViewById, findViewById3, imageView, button, viewGroup, bVar));
    }

    private void a(Button button, b bVar) {
        String str = bVar.awm().dxh;
        if (!bi.oW(str)) {
            int xV = l.xV(str);
            button.setText(this.gKS.getResources().getString(a$g.card_code_hint_agree));
            button.setTextColor(xV);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.gKS.getResources().getColor(a$a.card_code_default_color));
            gradientDrawable.setStroke(2, xV);
            gradientDrawable.setCornerRadius(8.0f);
            button.setBackground(gradientDrawable);
        }
    }
}
