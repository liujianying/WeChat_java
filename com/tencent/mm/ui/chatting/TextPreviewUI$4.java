package com.tencent.mm.ui.chatting;

import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.chatting.view.b;
import com.tencent.mm.ui.chatting.view.b.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

class TextPreviewUI$4 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ TextPreviewUI tNo;
    final /* synthetic */ b tNp;

    TextPreviewUI$4(TextPreviewUI textPreviewUI, b bVar, bd bdVar) {
        this.tNo = textPreviewUI;
        this.tNp = bVar;
        this.dAs = bdVar;
    }

    public final void gx(long j) {
        this.tNp.hide();
        h.mEJ.a(795, 1, 1, false);
        if (NetUtil.isConnected(this.tNo.mController.tml)) {
            bge bge = new bge();
            bge.ixe = (int) (j / 1000);
            bge.hcE = 1;
            bge.sdX = 1;
            try {
                String str;
                avm avm = new avm();
                avm.hbL = this.dAs.field_talker;
                avm.rcq = this.dAs.field_msgSvrId;
                TextPreviewUI textPreviewUI = this.tNo;
                bd bdVar = this.dAs;
                if (bdVar.isText() || bdVar.cmn()) {
                    str = bdVar.field_content;
                    int iA = com.tencent.mm.model.bd.iA(str);
                    if (iA != -1) {
                        str = str.substring(iA + 1).trim();
                    }
                } else {
                    ActionBarActivity actionBarActivity = textPreviewUI.mController.tml;
                    int type = bdVar.getType();
                    String str2 = bdVar.field_content;
                    String str3 = bdVar.field_talker;
                    str = AllRemindMsgUI.a(actionBarActivity, type, str2, bdVar.field_isSend);
                    x.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[]{Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.getType()), str});
                }
                avm.bHD = str;
                bge.rvr = new com.tencent.mm.bk.b(avm.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[]{e.toString()});
            }
            au.DF().a(new com.tencent.mm.modelsimple.x(1, bge), 0);
            return;
        }
        com.tencent.mm.ui.base.h.b(this.tNo.mController.tml, this.tNo.getString(R.l.net_warn_no_network), this.tNo.getString(R.l.remind_err_title), true);
    }

    public final void onCancel() {
        this.tNp.hide();
    }
}
