package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

class IPCallRechargeUI$7 extends ClickableSpan {
    final /* synthetic */ IPCallRechargeUI kxB;

    IPCallRechargeUI$7(IPCallRechargeUI iPCallRechargeUI) {
        this.kxB = iPCallRechargeUI;
    }

    public final void onClick(View view) {
        ((TextView) view).setHighlightColor(this.kxB.getResources().getColor(R.e.transparent));
        Intent intent = new Intent();
        String str = this.kxB.getString(R.l.ip_call_recharge_price_url) + "&usedcc=";
        List aXe = c.aXb().aXe();
        if (aXe.size() > 0) {
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
        } else {
            str = str + a.Fo(com.tencent.mm.plugin.ipcall.b.c.aYB());
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this.kxB, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.kxB.getResources().getColor(R.e.link_color));
        textPaint.setUnderlineText(false);
    }
}
