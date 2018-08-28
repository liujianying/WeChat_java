package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.wallet_index.c.h.6;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;

class h$1 extends c<gw> {
    final /* synthetic */ h pCY;

    h$1(h hVar) {
        this.pCY = hVar;
        this.sFo = gw.class.getName().hashCode();
    }

    private boolean a(gw gwVar) {
        int i = 0;
        this.pCY.pCT = gwVar;
        String str = this.pCY.pCT.bQd.result;
        if (this.pCY.pCT.bQd.bQf != null) {
            this.pCY.pCS = this.pCY.pCT.bQd.bQf.getInt("pay_channel", 0);
        }
        switch (this.pCY.pCT.bQd.actionCode) {
            case 10:
            case 11:
                a.sFg.b(this.pCY);
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = " + str);
                if (str == null) {
                    return true;
                }
                if (!str.startsWith("weixin://wxpay")) {
                    this.pCY.pCR = 1;
                    h.a(this.pCY, str, this.pCY.pCS);
                } else if (bj.cjh()) {
                    x.i("MicroMsg.WalletGetA8KeyRedirectListener", "go pay test logic");
                    lo loVar = new lo();
                    loVar.bVS.url = str;
                    loVar.bVS.scene = 4;
                    loVar.bVS.bVU = 12;
                    loVar.bVS.bJt = 0;
                    loVar.bVS.bhd = "";
                    loVar.bVS.context = gwVar.bQd.context;
                    h.a(this.pCY, loVar);
                    Toast.makeText(gwVar.bQd.context, "click to do pay test", 1).show();
                } else {
                    this.pCY.pCR = 4;
                    g.Ek();
                    g.Eh().dpP.a(233, this.pCY);
                    h hVar = new h(str, this.pCY.pCT.bQd.username, 4, (int) System.currentTimeMillis(), new byte[0]);
                    g.Ek();
                    g.Eh().dpP.a(hVar, 0);
                    this.pCY.pCV = System.currentTimeMillis();
                }
                return true;
            case 12:
                h hVar2 = this.pCY;
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = " + str);
                String[] split = str.replace("http://p.weixin.qq.com?", "").split("&");
                int length = split.length;
                String str2 = null;
                str = null;
                Object obj = null;
                while (i < length) {
                    String str3 = split[i];
                    if (str3.startsWith("errcode=")) {
                        obj = str3.replace("errcode=", "");
                    } else if (str3.startsWith("errmsg=")) {
                        str = str3.replace("errmsg=", "");
                    } else if (str3.startsWith("importkey=")) {
                        str2 = str3.replace("importkey=", "");
                    }
                    i++;
                }
                if (!"0".equals(obj) || bi.oW(str2)) {
                    if (bi.oW(str)) {
                        str = hVar2.pCT.bQd.context.getString(a$i.wallet_unknown_err);
                    }
                    com.tencent.mm.ui.base.h.a(hVar2.pCT.bQd.context, str, "", new 6(hVar2));
                } else {
                    Context context = hVar2.pCT.bQd.context;
                    Intent intent = new Intent();
                    intent.putExtra("key_import_key", str2);
                    intent.putExtra("key_bind_scene", 2);
                    intent.putExtra("key_custom_bind_tips", null);
                    d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
                    if (hVar2.pCT.bJX != null) {
                        hVar2.pCT.bQe.ret = 1;
                        hVar2.pCT.bJX.run();
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
