package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.text.ClipboardManager;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public final class j {
    public static List<l> nLT = new LinkedList();
    String cXR;
    private Context context;
    ClipboardManager jdw;
    protected ListView kww;
    public g nLJ;
    public au nLK;
    boolean nLL;
    boolean nLM = false;
    SnsCommentFooter nLN;
    bi nLO;
    ao nLP;
    private boolean nLQ = false;
    private String nLR = "";
    private boolean nLS = false;
    bh nLU;
    c nLV;
    b nLW;
    public com.tencent.mm.plugin.sns.ui.b.b nLX;
    p nLY = null;
    c nLZ = new 2(this);
    OnLongClickListener nMa = new 5(this);
    FrameLayout ntx;
    public av nuc;

    public j(Context context, int i, String str, int i2) {
        this.context = context;
        this.cXR = q.GF();
        this.nLK = new au();
        this.nLK.nrb = new com.tencent.mm.plugin.sns.h.b(i, str, i2);
        this.nLX = new 1(this, (Activity) context, this.nLK);
        this.nLX.aYt();
        a.sFg.b(this.nLZ);
    }

    private void bBP() {
        if (!this.nLQ) {
            this.nLQ = true;
            this.nLN.setAfterEditAction(this.nLO.ohV);
            this.nLN.setOnCommentSendImp(new SnsCommentFooter.c() {
                public final void NJ(String str) {
                    n nVar = (n) j.this.nLN.getTag();
                    x.d("MicroMsg.BaseTimeLine", "onCommentSend click");
                    if (str == null || str.trim().equals("")) {
                        x.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
                        return;
                    }
                    bon commentInfo = j.this.nLN.getCommentInfo();
                    boy n = aj.n(nVar);
                    int i = (commentInfo.smh == 0 && commentInfo.smk == 0) ? 708 : 709;
                    com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(i);
                    if (io.opType == 708) {
                        io.nb(i.g(nVar)).ir(nVar.field_type).bP(nVar.xb(32)).nb(nVar.bBo()).nb(nVar.field_userName).ir(n.smJ).ir(n.smM);
                    } else {
                        String str2;
                        com.tencent.mm.modelsns.b nb = io.nb(i.g(nVar)).ir(nVar.field_type).bP(nVar.xb(32)).nb(nVar.bBo()).nb(commentInfo.rdS);
                        if (commentInfo.smh == 0) {
                            str2 = commentInfo.smk;
                        } else {
                            str2 = commentInfo.smh;
                        }
                        nb.nb(str2).ir(n.smJ).ir(n.smM);
                    }
                    io.RD();
                    if (j.this.nLK != null) {
                        j.this.nLK.nrb.u(nVar);
                    }
                    if (nVar.xb(32) && j.this.nLN.getSendType() == 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    am.a.a(nVar, nVar.xb(32) ? 8 : 2, str, j.this.nLN.getCommentInfo(), i);
                    j.this.nuc.G(j.this.nLO.ohV);
                    j.this.bBQ();
                    if (bi.oW(j.this.nLR)) {
                        for (l lVar : j.nLT) {
                            if (j.this.nLR.equals(lVar.aAL)) {
                                x.d("MicroMsg.BaseTimeLine", "remove ct");
                                j.nLT.remove(lVar);
                                return;
                            }
                        }
                    }
                }
            });
            SnsCommentFooter snsCommentFooter = this.nLN;
            4 4 = new 4(this);
            if (snsCommentFooter.kXF != null) {
                snsCommentFooter.kXF.setBackListener(4);
            }
        }
    }

    final void bBQ() {
        if (this.nLQ) {
            if (this.nLN.getVisibility() != 8) {
                this.nLN.setVisibility(8);
            }
            av avVar = this.nuc;
            if (avVar.obY != null) {
                avVar.obY.setVisibility(8);
            }
            avVar.obY = null;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, n nVar, bon bon) {
        String str = cVar.bSZ + "@";
        this.nLR = str;
        x.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.nLR + " " + cVar.bSZ + " position:" + cVar.position);
        bBP();
        com.tencent.mm.kernel.g.Ek();
        String BL = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(nVar.field_userName).BL();
        this.nLN.setTag(nVar);
        this.nLN.setVisibility(0);
        this.nLN.b(BL, bon);
        this.nLN.h(nLT, str);
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.context, 8);
        if (cVar.ojc != null) {
            fromDPToPix += cVar.oje.getHeight() - cVar.ojc.getBottom();
            x.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.ojc.getBottom());
        } else {
            fromDPToPix = 0;
        }
        this.nLO.position = cVar.position;
        this.nLO.ohP = cVar.jEz.getHeight() - fromDPToPix;
        cVar.ojc = null;
        this.nLO.ohQ = cVar.jEz.getTop();
        this.nLO.nUa = this.kww.getBottom();
        x.e("MicroMsg.BaseTimeLine", "originalTop:" + this.nLO.ohQ);
        bBR();
    }

    private void bBR() {
        if (!(this.context instanceof MMActivity) || ((MMActivity) this.context).mController.tmG == 1) {
            this.nLO.bEF();
        } else {
            this.nLL = true;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, n nVar, String str, bon bon) {
        int i = 0;
        String str2 = cVar.bSZ + str;
        this.nLR = str2;
        x.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.nLR + " " + cVar.bSZ + " position:" + cVar.position);
        bBP();
        this.nLN.setTag(nVar);
        this.nLN.setVisibility(0);
        this.nLN.a(str, bon);
        this.nLN.h(nLT, str2);
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.context, 8);
        if (cVar.ojc != null) {
            i = (cVar.oje.getHeight() - cVar.ojc.getBottom()) + fromDPToPix;
            x.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.ojc.getBottom());
        }
        this.nLO.position = cVar.position;
        this.nLO.ohP = cVar.jEz.getHeight() - i;
        cVar.ojc = null;
        this.nLO.ohQ = cVar.jEz.getTop();
        this.nLO.nUa = this.kww.getBottom();
        x.e("MicroMsg.BaseTimeLine", "originalTop:" + this.nLO.ohQ);
        bBR();
    }
}
