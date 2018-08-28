package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.32;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$32$1 implements OnClickListener {
    final /* synthetic */ 32 nVb;

    SnsCommentDetailUI$32$1(32 32) {
        this.nVb = 32;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.j(this.nVb.nUO));
        n Nl = h.Nl(SnsCommentDetailUI.j(this.nVb.nUO));
        if (Nl == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[]{SnsCommentDetailUI.j(this.nVb.nUO)});
        } else if (!Nl.xb(32)) {
            if (Nl.field_snsId == 0) {
                af.byo().xe(Nl.nJc);
            } else {
                af.byn().eS(Nl.field_snsId);
                g.Ek();
                g.Eh().dpP.a(new r(Nl.field_snsId, 1), 0);
                af.byo().delete(Nl.field_snsId);
                af.byt().fd(Nl.field_snsId);
                i.fc(Nl.field_snsId);
            }
            Intent intent = new Intent();
            intent.putExtra("sns_gallery_op_id", v.NF(SnsCommentDetailUI.j(this.nVb.nUO)));
            this.nVb.nUO.setResult(-1, intent);
            if (SnsCommentDetailUI.r(this.nVb.nUO) && !Nl.isValid()) {
                intent.putExtra("sns_gallery_force_finish", true);
            }
            bsu bAJ = Nl.bAJ();
            if (bAJ != null) {
                String str = bAJ.sqb == null ? null : bAJ.sqb.ksA;
                if (!bi.oW(str) && a.ezo.cU(str)) {
                    String cS = a.ezo.cS(str);
                    ni niVar = new ni();
                    niVar.bYn.appId = str;
                    niVar.bYn.bYo = bAJ.hbL;
                    niVar.bYn.byT = cS;
                    com.tencent.mm.sdk.b.a.sFg.m(niVar);
                }
            }
            this.nVb.nUO.finish();
        }
    }
}
