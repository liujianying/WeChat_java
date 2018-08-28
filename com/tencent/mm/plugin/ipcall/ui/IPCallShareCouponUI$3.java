package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

class IPCallShareCouponUI$3 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$3(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        String str = this.kyP.getString(R.l.ip_call_recharge_price_url) + "&usedcc=";
        List aXe = c.aXb().aXe();
        if (aXe == null || aXe.size() <= 0) {
            str = str + a.Fo(com.tencent.mm.plugin.ipcall.b.c.aYB());
        } else {
            int size = aXe.size();
            if (size > 5) {
                size = 5;
            }
            int i = 0;
            while (i < size) {
                String Fo = a.Fo(((Integer) aXe.get(i)).toString());
                if (bi.oW(Fo)) {
                    Fo = str;
                } else {
                    Fo = str + Fo + "|";
                }
                i++;
                str = Fo;
            }
            if (str.endsWith("|")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this.kyP, "webview", ".ui.tools.WebViewUI", intent);
    }
}
