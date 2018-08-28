package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.chatroom.ui.SeeAccessVerifyInfoUI.5;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.vending.c.a;

class SeeAccessVerifyInfoUI$5$1 implements a<Void, com.tencent.mm.ab.a.a<dw>> {
    final /* synthetic */ 5 hOA;

    SeeAccessVerifyInfoUI$5$1(5 5) {
        this.hOA = 5;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        if (SeeAccessVerifyInfoUI.g(this.hOA.hOz) != null && SeeAccessVerifyInfoUI.g(this.hOA.hOz).isShowing()) {
            SeeAccessVerifyInfoUI.g(this.hOA.hOz).dismiss();
        }
        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(aVar.Yy);
        if (eV != null) {
            eV.a(this.hOA.hOz, null, null);
        } else if (aVar.errType == 0 && aVar.errCode == 0) {
            if (aVar.bKq.getType() == 774) {
                au.HU();
                bd dW = c.FT().dW(SeeAccessVerifyInfoUI.h(this.hOA.hOz));
                dW.cmB();
                au.HU();
                c.FT().b(dW.field_msgSvrId, dW);
                SeeAccessVerifyInfoUI.i(this.hOA.hOz).setBackgroundResource(R.g.btn_solid_grey);
                SeeAccessVerifyInfoUI.i(this.hOA.hOz).setTextColor(this.hOA.hOz.getResources().getColor(R.e.grey_btn_stroke_color_normal));
                SeeAccessVerifyInfoUI.i(this.hOA.hOz).setText(this.hOA.hOz.getString(R.l.has_approve_info));
                SeeAccessVerifyInfoUI.i(this.hOA.hOz).setEnabled(false);
                h.mEJ.a(219, 23, 1, true);
            }
        } else if (aVar.bKq.getType() == 774) {
            x.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bi.oV(aVar.Yy)});
            com.tencent.mm.ui.base.h.b(this.hOA.hOz.mController.tml, this.hOA.hOz.getString(R.l.access_invite_room_mem_err), this.hOA.hOz.getString(R.l.app_tip), true);
        }
        return uQG;
    }
}
