package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.view.View;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet_core.e.a.b;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bi;

class a$4 implements Runnable {
    final /* synthetic */ a pAV;
    final /* synthetic */ b pAW;
    final /* synthetic */ e pAY;
    final /* synthetic */ View pAZ;

    a$4(a aVar, View view, e eVar, b bVar) {
        this.pAV = aVar;
        this.pAZ = view;
        this.pAY = eVar;
        this.pAW = bVar;
    }

    public final void run() {
        this.pAZ.invalidate();
        String str = this.pAY.pmn;
        int i = "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(str) ? a.e.wallet_bankcard_bule_bg : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(str) ? a.e.wallet_bankcard_green_bg : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(str) ? a.e.wallet_bankcard_hbule_bg : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(str) ? a.e.wallet_bankcard_purple_bg : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(str) ? a.e.wallet_bankcard_red_bg : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(str) ? a.e.wallet_bankcard_yellow_bg : -1;
        if (i != -1) {
            this.pAZ.setBackgroundResource(i);
        } else if (!bi.oW(this.pAY.pmn)) {
            w cVar = new c(this.pAY.pmn);
            Bitmap a = y.a(cVar);
            y.a(this.pAW);
            if (a != null) {
                try {
                    byte[] ninePatchChunk = a.getNinePatchChunk();
                    if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        FileOp.deleteFile(cVar.Vv());
                    }
                } catch (Exception e) {
                }
            }
            if (a != null) {
                this.pAZ.setBackgroundDrawable(com.tencent.mm.plugin.wallet_core.ui.view.b.c(this.pAZ.getContext(), a));
            }
        } else if (this.pAY.pmr > 0) {
            this.pAZ.setBackgroundResource(this.pAY.pmr);
        }
    }
}
