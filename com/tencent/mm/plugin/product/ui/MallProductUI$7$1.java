package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.MallProductUI.7;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.e;

class MallProductUI$7$1 implements c {
    final /* synthetic */ 7 lUc;

    MallProductUI$7$1(7 7) {
        this.lUc = 7;
    }

    public final void ju(int i) {
        f e;
        String bmY;
        Intent intent;
        switch (i) {
            case 0:
                e = MallProductUI.e(this.lUc.lUa);
                bmY = e.lSG.bmY();
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", bmY);
                intent.putExtra("Retr_Msg_Type", 2);
                if (!bi.oW(e.lSG.lQL.bnb())) {
                    intent.putExtra("Retr_Msg_thumb_path", e.lSG.bmP());
                }
                intent.putExtra("Retr_go_to_chattingUI", false);
                intent.putExtra("Retr_show_success_tips", true);
                intent.putExtra("Retr_Msg_Type", 2);
                d.e(e.ftd, ".ui.transmit.MsgRetransmitUI", intent);
                if (f.fdx == 4) {
                    h.mEJ.h(10651, new Object[]{Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0)});
                    return;
                }
                return;
            case 1:
                e = MallProductUI.e(this.lUc.lUa);
                m mVar = e.lSG.lQL;
                intent = new Intent();
                intent.putExtra("KContentObjDesc", e.lSG.bmZ());
                intent.putExtra("Ksnsupload_title", mVar.lRp.name);
                intent.putExtra("Ksnsupload_link", e.lSG.bmQ());
                intent.putExtra("Ksnsupload_imgurl", e.lSG.lQL.bnb());
                if (!bi.oW(e.lSG.lQL.bnb())) {
                    intent.putExtra("KsnsUpload_imgPath", e.lSG.bmP());
                }
                intent.putExtra("Ksnsupload_type", 6);
                intent.putExtra("KUploadProduct_UserData", e.lSG.a(mVar));
                intent.putExtra("KUploadProduct_subType", mVar.lRm);
                bmY = u.ic("scan_product");
                u.Hx().v(bmY, true).p("prePublishId", "scan_product");
                intent.putExtra("reportSessionId", bmY);
                d.b(e.ftd, "sns", ".ui.SnsUploadUI", intent);
                if (f.fdx == 4) {
                    h.mEJ.h(10651, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0)});
                    return;
                }
                return;
            case 2:
                MallProductUI.e(this.lUc.lUa).bnf();
                return;
            case 3:
                e = MallProductUI.e(this.lUc.lUa);
                e.ab(e.ftd, e.lSG.bmO());
                return;
            default:
                return;
        }
    }
}
