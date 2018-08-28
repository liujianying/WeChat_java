package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class MassSendMsgUI$9 implements a {
    final /* synthetic */ MassSendMsgUI lbm;

    MassSendMsgUI$9(MassSendMsgUI massSendMsgUI) {
        this.lbm = massSendMsgUI;
    }

    public final void bcy() {
        Toast.makeText(this.lbm, this.lbm.getString(R.l.mass_send_voip_not_support), 0).show();
    }

    public final void bcz() {
        Toast.makeText(this.lbm, this.lbm.getString(R.l.mass_send_card_not_support), 0).show();
    }

    public final void bcA() {
        Toast.makeText(this.lbm, this.lbm.getString(R.l.mass_send_talkroom_not_support), 0).show();
    }

    public final void bcB() {
        Toast.makeText(this.lbm, this.lbm.getString(R.l.mass_send_location_not_support), 0).show();
    }

    public final void bcC() {
        Toast.makeText(this.lbm, this.lbm.getString(R.l.mass_send_card_not_support), 0).show();
    }

    public final void st(int i) {
        switch (i) {
            case 0:
                File file = new File(e.dgl);
                if (file.exists() || file.mkdir()) {
                    x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.lbm.mController.tml, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this.lbm.mController.tml});
                    if (com.tencent.mm.pluginsdk.permission.a.a(this.lbm.mController.tml, "android.permission.CAMERA", 16, "", "")) {
                        MassSendMsgUI.c(this.lbm);
                        return;
                    }
                    return;
                }
                Toast.makeText(this.lbm, this.lbm.getString(R.l.chatting_toast_sdk_fail), 1).show();
                return;
            case 1:
                l.a(this.lbm, 1, 1, 0, 3, false, null);
                return;
            default:
                return;
        }
    }

    public final void b(f fVar) {
    }

    public final void bcD() {
        com.tencent.mm.plugin.masssend.a.ezn.bg(this.lbm);
    }

    public final void bcE() {
        Toast.makeText(this.lbm, this.lbm.getString(R.l.mass_send_card_not_support), 0).show();
    }

    public final void bcF() {
    }

    public final void bcG() {
        Intent intent = new Intent();
        intent.putExtra("preceding_scence", 13);
        d.b(this.lbm, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
    }

    public final void su(int i) {
        MassSendMsgUI.d(this.lbm);
    }

    public final void bcH() {
        Toast.makeText(this.lbm, this.lbm.getString(R.l.mass_send_lucky_money_not_support), 0).show();
    }

    public final void bcI() {
    }

    public final void bcJ() {
    }

    public final void bcK() {
    }

    public final void bcL() {
    }
}
