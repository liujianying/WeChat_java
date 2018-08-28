package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h$a;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class NoteEditorUI$23$2 implements d {
    final /* synthetic */ 23 quz;

    NoteEditorUI$23$2(23 23) {
        this.quz = 23;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        boolean z = false;
        int i2 = 1;
        fz fzVar;
        boolean z2;
        Intent intent;
        h$a h;
        switch (menuItem.getItemId()) {
            case 0:
                if (NoteEditorUI.e(this.quz.qur) != null) {
                    NoteEditorUI.e(this.quz.qur).a(null);
                }
                NoteEditorUI.f(this.quz.qur).cal();
                fzVar = new fz();
                fzVar.bOL.type = 32;
                fzVar.bOL.bJA = NoteEditorUI.g(this.quz.qur);
                a.sFg.m(fzVar);
                z2 = fzVar.bOM.bPd;
                if (fzVar.bOM.path == null) {
                    h.bA(this.quz.qur.mController.tml, this.quz.qur.getString(R.l.favorite_retransmit_tip));
                    return;
                } else if (z2) {
                    h.bA(this.quz.qur.mController.tml, this.quz.qur.getString(R.l.Fav_NotDownload_CannotForward));
                    return;
                } else {
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 1);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("select_fav_local_id", NoteEditorUI.g(this.quz.qur));
                    com.tencent.mm.bg.d.b(this.quz.qur, ".ui.transmit.SelectConversationUI", intent, 4101);
                    com.tencent.mm.plugin.fav.a.h.f(NoteEditorUI.g(this.quz.qur), 1, 0);
                    h = NoteEditorUI.h(this.quz.qur);
                    h.iVN++;
                    return;
                }
            case 1:
                if (NoteEditorUI.e(this.quz.qur) != null) {
                    NoteEditorUI.e(this.quz.qur).a(null);
                }
                NoteEditorUI.f(this.quz.qur).cal();
                intent = new Intent();
                intent.putExtra("key_fav_scene", 2);
                intent.putExtra("key_fav_item_id", NoteEditorUI.g(this.quz.qur));
                b.a(this.quz.qur.mController.tml, ".ui.FavTagEditUI", intent);
                h = NoteEditorUI.i(this.quz.qur);
                h.iVQ++;
                return;
            case 2:
                h.a(this.quz.qur.mController.tml, this.quz.qur.getString(R.l.app_delete_tips), "", new 1(this), null);
                return;
            case 3:
                ch chVar = new ch();
                e.a(chVar, NoteEditorUI.k(this.quz.qur));
                a.sFg.m(chVar);
                c.a(chVar.bJG.ret, this.quz.qur, this.quz.qur.jKu);
                return;
            case 4:
                intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", NoteEditorUI.k(this.quz.qur));
                com.tencent.mm.bg.d.b(this.quz.qur, ".ui.transmit.SelectConversationUI", intent, 4096);
                h = NoteEditorUI.l(this.quz.qur);
                h.iVN++;
                return;
            case 5:
                NoteEditorUI.f(this.quz.qur).cal();
                p pVar = new p();
                pVar.qpf = NoteEditorUI.d(this.quz.qur) == 1;
                pVar.qpk = NoteEditorUI.m(this.quz.qur);
                pVar.qpj = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Sn(this.quz.qur.getString(R.l.wenote_keep_top_default_title));
                pVar.qpl = NoteEditorUI.n(this.quz.qur);
                pVar.qpm = NoteEditorUI.o(this.quz.qur);
                if (NoteEditorUI.d(this.quz.qur) == 1) {
                    pVar.qph = NoteEditorUI.k(this.quz.qur);
                    if (NoteEditorUI.p(this.quz.qur)) {
                        pVar.qpi = true;
                        com.tencent.mm.plugin.report.service.h.mEJ.h(14790, new Object[]{Integer.valueOf(3)});
                    } else {
                        pVar.qpi = false;
                        com.tencent.mm.plugin.report.service.h.mEJ.h(14790, new Object[]{Integer.valueOf(2)});
                    }
                } else {
                    com.tencent.mm.plugin.report.service.h.mEJ.h(14790, new Object[]{Integer.valueOf(1)});
                    pVar.qpg = NoteEditorUI.g(this.quz.qur);
                }
                com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bZX().a(pVar);
                com.tencent.mm.ui.widget.snackbar.b.h(this.quz.qur, this.quz.qur.getString(R.l.wenote_keep_top_done));
                return;
            case 6:
                com.tencent.mm.plugin.wenote.model.nativenote.manager.h.bZX().a(null);
                com.tencent.mm.ui.widget.snackbar.b.h(this.quz.qur, this.quz.qur.getString(R.l.wenote_cancel_top_done));
                return;
            case 7:
                com.tencent.mm.plugin.fav.a.h.f(NoteEditorUI.g(this.quz.qur), 0, 0);
                if (NoteEditorUI.q(this.quz.qur)) {
                    z = true;
                } else if (NoteEditorUI.r(this.quz.qur) && !com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZK().equals(NoteEditorUI.s(this.quz.qur))) {
                    z = true;
                }
                if (z) {
                    NoteEditorUI.f(this.quz.qur).cal();
                    this.quz.qur.caQ();
                    NoteEditorUI.t(this.quz.qur);
                }
                if (NoteEditorUI.q(this.quz.qur)) {
                    NoteEditorUI.u(this.quz.qur);
                    NoteEditorUI.v(this.quz.qur);
                }
                fzVar = new fz();
                fzVar.bOL.type = 30;
                fzVar.bOL.bOS = 1;
                fzVar.bOL.bJA = NoteEditorUI.g(this.quz.qur);
                a.sFg.m(fzVar);
                String str = fzVar.bOM.path;
                NoteEditorUI.a(this.quz.qur, fzVar.bOM.bOX);
                if (bi.oW(str)) {
                    NoteEditorUI.w(this.quz.qur).post(new 2(this));
                    return;
                }
                NoteEditorUI.b(this.quz.qur, str);
                h = NoteEditorUI.x(this.quz.qur);
                h.iVO++;
                return;
            case 8:
                NoteEditorUI.a(this.quz.qur, h.a(this.quz.qur.mController.tml, this.quz.qur.getString(R.l.wv_loading), true, new 3(this)));
                fzVar = new fz();
                fzVar.bOL.type = 32;
                fzVar.bOL.bJA = NoteEditorUI.g(this.quz.qur);
                fzVar.bOL.bJH = com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnO;
                a.sFg.m(fzVar);
                z2 = fzVar.bOM.bPd;
                com.tencent.mm.plugin.report.service.h hVar;
                Object[] objArr;
                if (fzVar.bOM.path == null) {
                    NoteEditorUI.y(this.quz.qur);
                    Toast.makeText(this.quz.qur.mController.tml, this.quz.qur.mController.tml.getString(R.l.note_pic_save_fail), 1).show();
                    hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = Integer.valueOf(0);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(5);
                    if (!NoteEditorUI.z(this.quz.qur)) {
                        i2 = 0;
                    }
                    objArr[4] = Integer.valueOf(i2);
                    hVar.h(14811, objArr);
                    return;
                } else if (z2) {
                    NoteEditorUI.y(this.quz.qur);
                    Toast.makeText(this.quz.qur.mController.tml, this.quz.qur.mController.tml.getString(R.l.note_pic_save_fail), 1).show();
                    hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(0);
                    objArr[1] = Integer.valueOf(0);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(5);
                    if (!NoteEditorUI.z(this.quz.qur)) {
                        i2 = 0;
                    }
                    objArr[4] = Integer.valueOf(i2);
                    hVar.h(14811, objArr);
                    return;
                } else {
                    NoteEditorUI.w(this.quz.qur).post(new 4(this));
                    return;
                }
            case 9:
                fzVar = new fz();
                fzVar.bOL.type = 32;
                fzVar.bOL.bJA = NoteEditorUI.g(this.quz.qur);
                fzVar.bOL.bJH = com.tencent.mm.plugin.wenote.model.c.bZb().qnC.qnO;
                a.sFg.m(fzVar);
                z = fzVar.bOM.bPd;
                if (fzVar.bOM.path == null) {
                    h.bA(this.quz.qur.mController.tml, this.quz.qur.getString(R.l.favorite_retransmit_tip));
                    return;
                } else if (z) {
                    h.bA(this.quz.qur.mController.tml, this.quz.qur.getString(R.l.Note_NotDownload_CannotForward));
                    return;
                } else {
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 1);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("select_fav_local_id", NoteEditorUI.g(this.quz.qur));
                    intent.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.bZb().qnC.bZc());
                    com.tencent.mm.bg.d.b(this.quz.qur, ".ui.transmit.SelectConversationUI", intent, 4355);
                    h = NoteEditorUI.A(this.quz.qur);
                    h.iVN++;
                    return;
                }
            case 10:
                com.tencent.mm.plugin.wenote.model.h.bb(this.quz.qur.mController.tml, NoteEditorUI.B(this.quz.qur));
                return;
            case 12:
                if (bi.oW(NoteEditorUI.C(this.quz.qur))) {
                    NoteEditorUI.w(this.quz.qur).post(new 5(this));
                    return;
                }
                h = NoteEditorUI.D(this.quz.qur);
                h.iVO++;
                NoteEditorUI.b(this.quz.qur, NoteEditorUI.C(this.quz.qur));
                return;
            case 13:
                intent = new Intent();
                intent.putExtra("k_expose_msg_id", NoteEditorUI.B(this.quz.qur));
                if (NoteEditorUI.E(this.quz.qur) != null && NoteEditorUI.E(this.quz.qur).length > 1) {
                    intent.putExtra("k_username", NoteEditorUI.E(this.quz.qur)[1]);
                }
                intent.putExtra("showShare", NoteEditorUI.F(this.quz.qur));
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                com.tencent.mm.bg.d.b(this.quz.qur.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                return;
            default:
                return;
        }
    }
}
