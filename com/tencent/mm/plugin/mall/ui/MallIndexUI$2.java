package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.model.w.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

class MallIndexUI$2 implements d {
    final /* synthetic */ MallIndexUI lab;
    final /* synthetic */ w lac;

    MallIndexUI$2(MallIndexUI mallIndexUI, w wVar) {
        this.lab = mallIndexUI;
        this.lac = wVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2;
        int i3;
        int i4;
        if (o.bOW().bPs()) {
            i2 = 2;
        } else if (o.bOW().bPp()) {
            i2 = 1;
        } else {
            i2 = 3;
        }
        if (o.bOW().bPw().bPm()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        Intent intent;
        switch (menuItem.getItemId()) {
            case 0:
                MallIndexUI.u(this.lab.mController.tml);
                i4 = 1;
                break;
            case 1:
                MallIndexUI mallIndexUI = this.lab;
                if (q.GS()) {
                    com.tencent.mm.bg.d.A(mallIndexUI, "wallet_payu", ".pwd.ui.WalletPayUPasswordSettingUI");
                } else {
                    com.tencent.mm.bg.d.A(mallIndexUI, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                }
                e.He(21);
                i4 = 2;
                break;
            case 2:
                MallIndexUI.l(this.lab);
                e.He(22);
                i4 = 3;
                break;
            case 3:
                MallIndexUI mallIndexUI2 = this.lab;
                intent = new Intent();
                intent.putExtra("rawUrl", q.GS() ? "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/readtemplate?t=payu_faq_tmpl" : "https://kf.qq.com/touch/scene_product.html?scene_id=kf1");
                com.tencent.mm.bg.d.b(mallIndexUI2.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                e.He(23);
                i4 = 4;
                break;
            case 4:
                this.lab.bcb();
                i4 = 5;
                break;
            default:
                i4 = menuItem.getItemId();
                int size = this.lac.list.size();
                if (i4 >= 100) {
                    i4 -= 100;
                    if (i4 >= 0 && i4 < size) {
                        a aVar = (a) this.lac.list.get(i4);
                        h.mEJ.h(14409, new Object[]{Integer.valueOf(2), Integer.valueOf(aVar.pqX), aVar.pqY, aVar.prb, aVar.pqZ});
                        if (aVar.pqX == 1) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", aVar.pqY);
                            x.d("MicorMsg.MallIndexUI", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
                            com.tencent.mm.bg.d.b(this.lab, "webview", ".ui.tools.WebViewUI", intent);
                            i4 = 6;
                            break;
                        } else if (aVar.pqX == 2) {
                            qu quVar = new qu();
                            quVar.cbq.cbu = 0;
                            quVar.cbq.userName = aVar.prb;
                            quVar.cbq.cbs = aVar.pqZ;
                            com.tencent.mm.sdk.b.a.sFg.m(quVar);
                        }
                    }
                }
                i4 = 6;
                break;
        }
        h.mEJ.h(14423, new Object[]{this.lab.fMk, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
