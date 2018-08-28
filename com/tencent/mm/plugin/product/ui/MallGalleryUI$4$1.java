package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.product.ui.MallGalleryUI.4;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class MallGalleryUI$4$1 implements c {
    final /* synthetic */ 4 lSu;

    MallGalleryUI$4$1(4 4) {
        this.lSu = 4;
    }

    public final void ju(int i) {
        MallGalleryUI mallGalleryUI;
        switch (i) {
            case 0:
                mallGalleryUI = this.lSu.lSt;
                Intent intent = new Intent();
                intent.putExtra("Retr_Msg_content", "");
                intent.putExtra("Retr_Msg_Type", 0);
                if (bi.oW(mallGalleryUI.bnc())) {
                    x.e("MicroMsg.MallGalleryUI", "url is null or nil");
                    return;
                }
                intent.putExtra("Retr_File_Name", mallGalleryUI.bnc());
                intent.putExtra("Retr_go_to_chattingUI", false);
                intent.putExtra("Retr_show_success_tips", true);
                d.e(mallGalleryUI, ".ui.transmit.MsgRetransmitUI", intent);
                return;
            case 1:
                mallGalleryUI = this.lSu.lSt;
                String bnc = mallGalleryUI.bnc();
                if (bi.oW(bnc)) {
                    x.w("MicroMsg.MallGalleryUI", "save error.");
                    return;
                }
                x.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[]{bnc});
                l.i(bnc, mallGalleryUI);
                return;
            case 2:
                MallGalleryUI mallGalleryUI2 = this.lSu.lSt;
                String bnc2 = mallGalleryUI2.bnc();
                if (bi.oW(bnc2)) {
                    x.w("MicroMsg.MallGalleryUI", "file path invalid");
                    return;
                }
                x.d("MicroMsg.MallGalleryUI", "file path valid");
                ch chVar = new ch();
                if (bi.oW(bnc2)) {
                    x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    chVar.bJF.bJL = i.favorite_fail_argument_error;
                } else {
                    x.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[]{bnc2, Integer.valueOf(9)});
                    wl wlVar = new wl();
                    wr wrVar = new wr();
                    vx vxVar = new vx();
                    vxVar.CF(2);
                    vxVar.UP(bnc2);
                    vxVar.UO(g.u((vxVar.toString() + 2 + System.currentTimeMillis()).getBytes()));
                    fz fzVar = new fz();
                    fzVar.bOL.type = 27;
                    fzVar.bOL.bON = vxVar;
                    a.sFg.m(fzVar);
                    String str = fzVar.bOM.bOX;
                    com.tencent.mm.sdk.platformtools.c.c(bnc2, 150, 150, CompressFormat.JPEG, 90, str);
                    vxVar.UQ(str);
                    wrVar.Vw(q.GF());
                    wrVar.Vx(q.GF());
                    wrVar.CO(9);
                    wrVar.fU(bi.VF());
                    wlVar.a(wrVar);
                    wlVar.rBI.add(vxVar);
                    chVar.bJF.title = vxVar.title;
                    chVar.bJF.bJH = wlVar;
                    chVar.bJF.type = 2;
                }
                chVar.bJF.bJM = 4;
                chVar.bJF.activity = mallGalleryUI2;
                a.sFg.m(chVar);
                return;
            default:
                return;
        }
    }
}
