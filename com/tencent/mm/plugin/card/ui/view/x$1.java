package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.r;
import java.util.ArrayList;

class x$1 implements OnClickListener {
    final /* synthetic */ x hIn;

    x$1(x xVar) {
        this.hIn = xVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof r) {
            b ayu = this.hIn.hHF.ayu();
            this.hIn.hHF.ayw();
            r rVar = (r) view.getTag();
            if (rVar != null && rVar.hyH != null && !rVar.hyH.isEmpty()) {
                if (rVar.hyG != null && rVar.hyG.equals(ayu.aws())) {
                    this.hIn.hIk.setVisibility(8);
                    this.hIn.hHF.axM();
                } else if (TextUtils.isEmpty(rVar.hyG) && TextUtils.isEmpty(ayu.aws())) {
                    this.hIn.hIk.setVisibility(8);
                    this.hIn.hHF.axM();
                } else {
                    boolean z;
                    ArrayList xv = com.tencent.mm.plugin.card.sharecard.a.b.xv(rVar.huU);
                    if (xv == null || xv.size() <= 0) {
                        z = false;
                    } else {
                        z = false;
                        for (int i = 0; i < xv.size(); i++) {
                            r rVar2 = (r) xv.get(i);
                            if ((rVar2.hyG == null || !rVar2.hyG.equals(rVar.hyG)) && !(TextUtils.isEmpty(rVar2.hyG) && TextUtils.isEmpty(rVar.hyG))) {
                                rVar2.hyI = false;
                                xv.set(i, rVar2);
                            } else {
                                rVar2.hyI = true;
                                if (!rVar2.hyJ) {
                                    rVar2.hyJ = true;
                                    z = true;
                                }
                                xv.set(i, rVar2);
                            }
                        }
                    }
                    ShareCardInfo xC = am.axq().xC((String) rVar.hyH.get(0));
                    if (xC != null) {
                        this.hIn.hHF.d(xC);
                    }
                    if (z && this.hIn.hHF.ayA() != null) {
                        this.hIn.hHF.ayA().ayn();
                    }
                    this.hIn.hIk.setVisibility(8);
                }
            }
        }
    }
}
