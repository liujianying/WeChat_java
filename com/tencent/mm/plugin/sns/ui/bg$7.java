package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class bg$7 implements OnClickListener {
    final /* synthetic */ bg ohJ;

    bg$7(bg bgVar) {
        this.ohJ = bgVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            if (rVar.nMH.sqc.ruz == 26 && !bi.oW(rVar.nMH.sqc.ruC)) {
                fz fzVar = new fz();
                fzVar.bOL.type = 37;
                fzVar.bOL.desc = rVar.nMH.sqc.ruC;
                String str = "";
                if (rVar.nMH.sqc.ruA != null && rVar.nMH.sqc.ruA.size() > 0) {
                    String s = an.s(af.getAccSnsPath(), ((ate) rVar.nMH.sqc.ruA.get(0)).ksA);
                    str = i.e((ate) rVar.nMH.sqc.ruA.get(0));
                    str = FileOp.cn(new StringBuilder().append(s).append(str).toString()) ? s + str : "";
                }
                fzVar.bOL.path = str;
                fzVar.bOL.title = rVar.bKW;
                fzVar.bOL.context = this.ohJ.context;
                a.sFg.m(fzVar);
            }
        }
    }
}
