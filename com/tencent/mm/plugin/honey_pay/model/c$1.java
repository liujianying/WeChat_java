package com.tencent.mm.plugin.honey_pay.model;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.e;

class c$1 implements OnMenuItemClickListener {
    final /* synthetic */ MMActivity gdk;
    final /* synthetic */ bhw kjQ;
    final /* synthetic */ String kjR;
    final /* synthetic */ btd kjS;
    final /* synthetic */ int kjT;

    c$1(MMActivity mMActivity, bhw bhw, String str, btd btd, int i) {
        this.gdk = mMActivity;
        this.kjQ = bhw;
        this.kjR = str;
        this.kjS = btd;
        this.kjT = i;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.gdk, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                atn atn = (atn) c$1.this.kjQ.siH.get(i);
                if (!bi.oW(atn.url)) {
                    if (!atn.url.equals("weixin://wcpay/honeypay/unbind") || bi.oW(c$1.this.kjR) || c$1.this.kjS == null) {
                        e.l(c$1.this.gdk, atn.url, false);
                        return;
                    }
                    x.i("MicroMsg.HoneyPayUtil", "go to unbind");
                    Intent intent = new Intent(c$1.this.gdk, HoneyPayCheckPwdUI.class);
                    intent.putExtra("key_scene", 3);
                    intent.putExtra("key_card_no", c$1.this.kjR);
                    try {
                        intent.putExtra("key_toke_mess", c$1.this.kjS.toByteArray());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.HoneyPayUtil", e, "", new Object[0]);
                    }
                    c$1.this.gdk.startActivityForResult(intent, c$1.this.kjT);
                }
            }
        };
        dVar.bXO();
        return false;
    }
}
