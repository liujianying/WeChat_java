package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.luckymoney.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class h$2 implements c {
    final /* synthetic */ h kXl;

    h$2(h hVar) {
        this.kXl = hVar;
    }

    public final void ju(int i) {
        String b;
        switch (i) {
            case 0:
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "shareImgToFriend");
                b = h.b(this.kXl);
                Context c = h.c(this.kXl);
                if (bi.oW(b)) {
                    x.w("MicroMsg.LuckyMoneyApplication", "share image to friend fail, imgPath is null");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", b);
                    intent.putExtra("Retr_Compress_Type", 0);
                    intent.putExtra("Retr_Msg_Type", 0);
                    a.ezn.l(intent, c);
                }
                if (h.d(this.kXl) == 1) {
                    h.mEJ.h(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                    return;
                }
                h.mEJ.h(13079, new Object[]{Integer.valueOf(8), Integer.valueOf(2)});
                return;
            case 1:
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "saveImg");
                b = h.b(this.kXl);
                CharSequence string = h.c(this.kXl).getString(i.lucky_money_save_fail);
                Context c2 = h.c(this.kXl);
                if (bi.oW(b)) {
                    x.w("MicroMsg.LuckyMoneyApplication", "save image fail, path is null");
                } else if (!r.a(b, c2, i.wallet_cropimage_saved)) {
                    Toast.makeText(c2, string, 1).show();
                }
                if (h.d(this.kXl) == 1) {
                    h.mEJ.h(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
                    return;
                }
                h.mEJ.h(13079, new Object[]{Integer.valueOf(9), Integer.valueOf(2)});
                return;
            case 2:
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "doFav");
                h.e(this.kXl);
                if (h.d(this.kXl) == 1) {
                    h.mEJ.h(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
                    return;
                }
                h.mEJ.h(13079, new Object[]{Integer.valueOf(10), Integer.valueOf(2)});
                return;
            default:
                return;
        }
    }
}
