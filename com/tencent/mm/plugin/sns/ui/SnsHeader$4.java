package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.sdk.platformtools.x;

class SnsHeader$4 implements OnClickListener {
    final /* synthetic */ int eKj;
    final /* synthetic */ SnsHeader nWo;
    final /* synthetic */ int nWs;

    SnsHeader$4(SnsHeader snsHeader, int i, int i2) {
        this.nWo = snsHeader;
        this.nWs = i;
        this.eKj = i2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            String str = (String) view.getTag();
            x.i("MicroMsg.SnsHeader", "sns Header localId " + str);
            n Nl = af.byo().Nl(str);
            if (SnsHeader.h(this.nWo) != null && Nl != null) {
                Intent intent = new Intent();
                intent.setClass(SnsHeader.h(this.nWo), SnsCommentDetailUI.class);
                if (Nl == null || Nl.field_userName == null || Nl.field_userName.equals("")) {
                    x.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                    return;
                }
                intent.putExtra("INTENT_TALKER", Nl.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", str);
                intent.putExtra("INTENT_FROMGALLERY", true);
                b io = b.io(726);
                io.ir(this.nWs).ir(this.eKj).ir(Nl.field_createTime);
                io.RD();
                SnsHeader.h(this.nWo).startActivity(intent);
                try {
                    atf atf = (atf) new atf().aG(Nl.field_postBuf);
                    if (atf.rWj == CdnLogic.kAppTypeNearEvent || atf.rWj == 210 || atf.rWj != 211) {
                        atf.rWs = true;
                        Nl.field_postBuf = atf.toByteArray();
                        af.byo().b(Nl.nJc, Nl);
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
