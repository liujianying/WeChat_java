package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ac;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.p;
import com.tencent.mm.ui.chatting.b.b.z;

@a(cwo = p.class)
public class t extends a implements p {
    private View tQD;
    private TextView tQE;
    private int tQF;
    private int tQG = 0;

    static /* synthetic */ boolean c(t tVar) {
        if (!s.hO(tVar.bAG.getTalkerUserName()) && s.fq(tVar.bAG.getTalkerUserName())) {
            au.HU();
            ai Yq = c.FW().Yq(tVar.bAG.getTalkerUserName());
            if (Yq == null || (Yq.field_showTips & 1) > 0) {
                return false;
            }
            au.HU();
            if (c.FR().Yg(tVar.bAG.getTalkerUserName()).csI == 1 && ((com.tencent.mm.ui.chatting.b.b.s) tVar.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).AQ() >= 40) {
                return true;
            }
        }
        return false;
    }

    public final void a(ai aiVar, boolean z) {
        x.i("MicroMsg.HistoryMsgTongueComponent", "[update] get:%s", new Object[]{Boolean.valueOf(z)});
        this.tQD = this.bAG.findViewById(R.h.chatting_goback_history_layout);
        if (this.tQD == null) {
            x.e("MicroMsg.HistoryMsgTongueComponent", "[update] is mGoBackToHistoryMsgLayout null");
            this.tQG = 0;
            return;
        }
        ((z) this.bAG.O(z.class)).Fg(-1);
        com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
        com.tencent.mm.ac.a.a aVar = null;
        if (cVar.cur()) {
            aVar = com.tencent.mm.ac.z.Nb().bd(cVar.cuC());
        }
        if (!(aiVar == null && aVar == null) && (!(this.bAG.cwq() || s.hM(this.bAG.getTalkerUserName()) || s.hf(this.bAG.getTalkerUserName()) || s.hH(this.bAG.getTalkerUserName()) || s.hi(this.bAG.getTalkerUserName())) || s.fq(this.bAG.getTalkerUserName()) || cVar.cur() || cvC())) {
            int i;
            if (cVar.cur() && aVar != null) {
                this.tQF = aVar.field_unReadCount;
                x.i("MicroMsg.HistoryMsgTongueComponent", "[update] bizChatCon mUnreadMessageCount:%s", new Object[]{Integer.valueOf(this.tQF)});
            } else if (aiVar != null) {
                this.tQF = aiVar.field_unReadCount;
                x.i("MicroMsg.HistoryMsgTongueComponent", "[update] mUnreadMessageCount:%s", new Object[]{Integer.valueOf(this.tQF)});
            } else {
                x.w("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout GONE");
                this.tQD.setVisibility(8);
                this.tQG = 0;
                return;
            }
            int i2 = this.tQF;
            if (!z || aiVar == null || aiVar.field_UnDeliverCount <= 0) {
                i = i2;
            } else {
                i = aiVar.field_UnDeliverCount + i2;
                x.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr updateGoBackToHistoryMessage mUnreadMessageCount fixUnreadMessage[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.tQF)});
                ((z) this.bAG.O(z.class)).Ff(this.tQF);
            }
            x.i("MicroMsg.HistoryMsgTongueComponent", "[update] threshold:%s fixUnreadMessage:%s", new Object[]{Integer.valueOf(cvC() ? 5 : 10), Integer.valueOf(i)});
            if (i >= (cvC() ? 5 : 10)) {
                int au;
                x.i("MicroMsg.HistoryMsgTongueComponent", "[update] mGoBackToHistoryMsgLayout VISIBLE");
                this.tQE = (TextView) this.bAG.findViewById(R.h.chatting_goback_history_tv);
                com.tencent.mm.booter.z zVar = com.tencent.mm.booter.z.cXH;
                if (zVar.cXL == null) {
                    zVar.cXM = 1;
                } else {
                    zVar.cXL.cYd = 1;
                }
                if (i > 999) {
                    this.tQE.setText(String.format(this.bAG.tTq.getMMResources().getString(R.l.chatting_history_go_back_tip), new Object[]{Integer.valueOf(999)}));
                } else {
                    this.tQE.setText(String.format(this.bAG.tTq.getMMResources().getString(R.l.chatting_history_go_back_tip), new Object[]{Integer.valueOf(i)}));
                }
                if (cVar.cur()) {
                    au.HU();
                    au = c.FU().au(this.bAG.getTalkerUserName(), cVar.cuC()) - this.tQF;
                } else {
                    au.HU();
                    i2 = c.FT().GT(this.bAG.getTalkerUserName()) - this.tQF;
                    z zVar2 = (z) this.bAG.O(z.class);
                    au.HU();
                    zVar2.Fg(c.FT().GT(this.bAG.getTalkerUserName()));
                    au = i2;
                }
                this.tQD.setOnClickListener(new 1(this, aiVar, au));
                this.tQD.postDelayed(new 2(this), 300);
                return;
            }
        }
        this.tQD.setVisibility(8);
        this.tQG = 0;
    }

    public final void an(int i, boolean z) {
        int i2;
        g gVar = (g) this.bAG.O(g.class);
        int count = gVar.getCount();
        int ctI = gVar.ctI() - i;
        if (ctI <= 18) {
            i2 = count - ctI;
        } else if (count > ctI) {
            i2 = count - ctI;
        } else {
            gVar.EP(ctI - count);
            i2 = 0;
            gVar.ctG();
        }
        if (z) {
            x.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr goBackToHistoryMsg dzmonster get pos=%d, preCount=%d, totalCount=%d, msgCount =%d, select=%d, newTotalCount=%d, newCount=%d, stack[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(count), Integer.valueOf(r3), Integer.valueOf(ctI), Integer.valueOf(i2), Integer.valueOf(gVar.ctI()), Integer.valueOf(gVar.getCount()), bi.cjd()});
            i2 = gVar.getCount() - count;
        }
        x.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr goBackToHistoryMsg dzmonster pos=%d, preCount=%d, totalCount=%d, msgCount =%d, fSelect=%d, newTotalCount=%d, newCount=%d, stack[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(count), Integer.valueOf(r3), Integer.valueOf(ctI), Integer.valueOf(i2), Integer.valueOf(gVar.ctI()), Integer.valueOf(gVar.getCount()), bi.cjd()});
        gVar.ER(i2);
        cvz();
        com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
        x.i("MicroMsg.ChattingContext", "[scrollToLast] position:%b", new Object[]{Integer.valueOf(i2)});
        aVar.tTr.bg(i2);
    }

    public final void cvz() {
        if (this.tQD != null) {
            this.tQF = -1;
            if (this.tQD.getVisibility() == 0) {
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.tQD.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(300);
                translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.bAG.tTq.getContext(), 17432581));
                this.tQD.startAnimation(translateAnimation);
            }
            this.tQD.setVisibility(8);
        }
    }

    public final void eY(int i, int i2) {
        if (this.tQF > 0 && i - (i2 + 1) >= this.tQF && this.tQD != null && this.tQD.getVisibility() == 0) {
            x.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr jacks onScroll dismissGoBackToHistory mUnreadMessage[%d] [%d,%d]", new Object[]{Integer.valueOf(this.tQF), Integer.valueOf(i), Integer.valueOf(i2)});
            cvz();
        }
    }

    public final void cvA() {
        this.tQG = 0;
    }

    public final int cvB() {
        return this.tQG;
    }

    public final void Fb(int i) {
        if (this.tQF >= (cvC() ? 5 : 10) && this.tQD != null) {
            LayoutParams layoutParams = (LayoutParams) this.tQD.getLayoutParams();
            switch (i) {
                case -2:
                    if (!((ac) this.bAG.O(ac.class)).cwb()) {
                        layoutParams.setMargins(0, this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
                        return;
                    }
                    return;
                case 0:
                    layoutParams.setMargins(0, this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.LargePadding), 0, 0);
                    return;
                case 1:
                    int cwd;
                    int dimensionPixelSize;
                    ac acVar = (ac) this.bAG.O(ac.class);
                    if (acVar.cwb()) {
                        cwd = acVar.cwd();
                    } else {
                        cwd = 0;
                    }
                    if (acVar.cwc()) {
                        dimensionPixelSize = this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.NormalButtonHeight);
                    } else {
                        dimensionPixelSize = 0;
                    }
                    if (dimensionPixelSize > cwd) {
                        cwd = dimensionPixelSize;
                    }
                    layoutParams.setMargins(0, this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.LargePadding) + cwd, 0, 0);
                    return;
                case 3:
                    layoutParams.setMargins(0, this.bAG.tTq.getMMResources().getDimensionPixelSize(R.f.LargePadding) * 3, 0, 0);
                    return;
                default:
                    return;
            }
        }
    }

    private boolean cvC() {
        com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
        if (s.hJ(this.bAG.getTalkerUserName())) {
            return true;
        }
        if (this.bAG.oLT.ckW() && cVar.cuo() != null && (cVar.cuo().LW() || cVar.cuo().LV())) {
            return true;
        }
        return false;
    }

    public final void cpG() {
        au.HU();
        ai Yq = c.FW().Yq(this.bAG.getTalkerUserName());
        if (Yq != null) {
            x.i("MicroMsg.HistoryMsgTongueComponent", "[onChattingEnterAnimStart] getUnDeliverCount:%s", new Object[]{Integer.valueOf(Yq.field_UnDeliverCount)});
        }
        if (Yq == null || Yq.field_UnDeliverCount == 0) {
            a(Yq, false);
        } else if (this.tQD != null) {
            this.tQD.setVisibility(8);
            x.i("MicroMsg.HistoryMsgTongueComponent", "summerbadcr not updateGoBackToHistoryMessage initList UnDeliver:%d, UnRead:%d", new Object[]{Integer.valueOf(Yq.field_UnDeliverCount), Integer.valueOf(Yq.field_unReadCount)});
        }
    }
}
