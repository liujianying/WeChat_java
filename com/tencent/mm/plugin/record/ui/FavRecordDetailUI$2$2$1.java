package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

class FavRecordDetailUI$2$2$1 implements OnClickListener {
    final /* synthetic */ 2 msJ;

    FavRecordDetailUI$2$2$1(2 2) {
        this.msJ = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        final p a = h.a(this.msJ.msI.msF.mController.tml, this.msJ.msI.msF.getString(R.l.app_delete_tips), false, null);
        fz fzVar = new fz();
        fzVar.bOL.type = 12;
        fzVar.bOL.bJA = this.msJ.msI.msF.msC;
        fzVar.bOL.bOQ = new Runnable() {
            public final void run() {
                a.dismiss();
                x.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[]{Long.valueOf(FavRecordDetailUI$2$2$1.this.msJ.msI.msF.msC)});
                FavRecordDetailUI$2$2$1.this.msJ.msI.msF.finish();
            }
        };
        a.sFg.m(fzVar);
    }
}
