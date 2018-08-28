package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;

class bg$14 implements OnClickListener {
    final /* synthetic */ bg ohJ;

    bg$14(bg bgVar) {
        this.ohJ = bgVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            bsu bsu = rVar.nMH;
            if (bsu.sqc.ruA.size() > 0) {
                n Nl = af.byo().Nl(rVar.bKW);
                if (this.ohJ.nMm != null) {
                    this.ohJ.nMm.bxT().v(Nl);
                }
                String str = ((ate) bsu.sqc.ruA.get(0)).nME;
                Intent intent = new Intent();
                intent.putExtra("sns_object_data", str);
                intent.putExtra("extra_scence", 13);
                d.b(view.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
            }
        }
    }
}
