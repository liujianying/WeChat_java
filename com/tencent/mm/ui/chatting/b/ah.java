package com.tencent.mm.ui.chatting.b;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.b;
import com.tencent.mm.modelmulti.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.b.p;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.b.b.z;

@a(cwo = z.class)
public class ah extends a implements c, az.a, z {
    public static int tSa = 350;
    private boolean tOB = false;
    public boolean tSb = false;
    public boolean tSc = false;
    public int tSd = -1;
    public int tSe = -1;
    public boolean tSf = true;
    public boolean tSg = false;
    private com.tencent.mm.sdk.b.c tSh = new 1(this);
    private boolean tSi = false;

    public final boolean cvU() {
        return this.tSf;
    }

    public final void cvV() {
        this.tSf = false;
    }

    private void csI() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.bAG.oLT.field_username;
        au.HU();
        ai Yq = com.tencent.mm.model.c.FW().Yq(str);
        if (Yq != null) {
            long j = Yq.field_lastSeq;
            int i = Yq.field_UnDeliverCount;
            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onResume filterSeq[%d], lastSeq[%d], undeliverCount[%d], chatRoomId[%s]", new Object[]{Long.valueOf(Yq.field_firstUnDeliverSeq), Long.valueOf(j), Integer.valueOf(i), str});
            if (j > 0) {
                au.HU();
                bd J = com.tencent.mm.model.c.FT().J(str, j);
                if (J.field_msgId == 0 && J.field_msgSeq != j) {
                    x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onResume need getChatRoomMsg up msg == null[%b] svrid[%d], msgseq[%d], take[%d]ms", new Object[]{Boolean.valueOf(false), Long.valueOf(J.field_msgSvrId), Long.valueOf(J.field_msgSeq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    com.tencent.mm.sdk.platformtools.ah.A(new 5(this, str, r6, j, i));
                }
            }
        }
    }

    public final String PE() {
        if (this.bAG.cwr()) {
            return this.bAG.oLT.field_username;
        }
        return "";
    }

    public final void ia(int i) {
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onGetFinish retcode[%d] thread[%d], dealHistoryGetMsg[%b], needCheckHistoryTips[%b]", new Object[]{Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()), Boolean.valueOf(this.tSb), Boolean.valueOf(this.tSc)});
        if (i == 0 && this.tSb) {
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(this.bAG.oLT.field_username);
            if (Yq != null) {
                int i2 = Yq.field_unReadCount;
                int i3 = Yq.field_UnDeliverCount;
                au.HU();
                int GT = (com.tencent.mm.model.c.FT().GT(this.bAG.oLT.field_username) - this.tSd) - i2;
                if (!(this.tSe == -1 || this.tSe - this.tSd == GT)) {
                    GT = this.tSe;
                }
                x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onGetFinish unReadCount[%d] unDeliverCount[%d] beforemsgCount[%d], msgCount[%d] pos[%d] lastMessageCount[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.tSd), Integer.valueOf(r3), Integer.valueOf(GT), Integer.valueOf(this.tSe)});
                this.tSe = -1;
                com.tencent.mm.sdk.platformtools.ah.A(new 7(this, GT));
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.ah.A(new 6(this));
    }

    public final boolean PF() {
        return this.tSb;
    }

    public final void a(ai aiVar, az azVar) {
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", new Object[]{aiVar.field_username, Long.valueOf(Thread.currentThread().getId())});
        if (!this.bAG.eaR) {
            x.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
        } else if (this.bAG.cwr() && this.bAG.oLT.field_username.equals(aiVar.field_username)) {
            final g gVar = (g) this.bAG.O(g.class);
            int i = aiVar.field_msgCount;
            int ctI = gVar.ctI();
            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(ctI), Boolean.valueOf(this.tSb), Integer.valueOf(aiVar.field_UnDeliverCount)});
            if (i > ctI) {
                bd bdVar = aiVar.tay;
                if (bdVar != null && bdVar.field_msgId != 0) {
                    if (i - ctI > 1) {
                        this.tSi = true;
                    }
                    int i2 = bdVar.field_flag;
                    x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", new Object[]{Long.valueOf(bdVar.field_msgSvrId), Long.valueOf(bdVar.field_msgSeq), Integer.valueOf(i2), bi.cjd()});
                    if ((i2 & 2) == 0) {
                        return;
                    }
                    if (this.bAG.getListView() == null || gVar == null || this.bAG.tTs == null) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", new Object[]{this.bAG.getListView(), gVar, this.bAG.tTs});
                    } else if ((i2 & 4) == 0) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", new Object[]{Boolean.valueOf(this.tSb)});
                        if (this.tSb) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                            return;
                        }
                        i2 = this.bAG.getFirstVisiblePosition();
                        int count = gVar.getCount();
                        gVar.ctD();
                        int i3 = i - ctI;
                        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", new Object[]{this.bAG.oLT.field_username, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(ctI), Integer.valueOf(i3), Integer.valueOf(gVar.getCount()), Integer.valueOf(count), Integer.valueOf(gVar.getCount() - count), Integer.valueOf(gVar.ctH()), Boolean.valueOf(this.tSc)});
                        if (gVar.getCount() - count > 1) {
                            ViewGroup listView = this.bAG.getListView();
                            ctI = listView.getFirstVisiblePosition();
                            View view = (i2 < ctI || i2 > (listView.getChildCount() + ctI) - 1) ? listView.getAdapter().getView(i2, null, listView) : listView.getChildAt(i2 - ctI);
                            count = (view == null ? 0 : view.getTop()) - this.bAG.tTs.getBottomHeight();
                            this.bAG.getListView().setAdapter(this.bAG.getListView().getAdapter());
                            this.bAG.eX(i2, count);
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", new Object[]{Integer.valueOf(i2), view, Integer.valueOf(i), Integer.valueOf(count)});
                            this.bAG.getListView().post(new Runnable() {
                                public final void run() {
                                    ah.this.bAG.eX(i2, count);
                                    x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", new Object[]{Integer.valueOf(ah.this.bAG.getFirstVisiblePosition()), Integer.valueOf(ah.this.bAG.getLastVisiblePosition()), Integer.valueOf(gVar.getCount())});
                                }
                            });
                            this.bAG.getListView().postDelayed(new 9(this, i2, count, gVar), 200);
                        }
                    } else {
                        int firstVisiblePosition = this.bAG.getFirstVisiblePosition();
                        i2 = this.bAG.getLastVisiblePosition();
                        bd ES = gVar.ES(firstVisiblePosition);
                        bd ES2 = gVar.ES(i2);
                        int count2 = gVar.getCount();
                        gVar.ctD();
                        int i4 = i - ctI;
                        int count3 = gVar.getCount() - count2;
                        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", new Object[]{this.bAG.oLT.field_username, Integer.valueOf(i), Integer.valueOf(ctI), Integer.valueOf(i4), Integer.valueOf(gVar.getCount()), Integer.valueOf(count2), Integer.valueOf(count3), Integer.valueOf(gVar.ctH()), Boolean.valueOf(this.tSc)});
                        if (ES2 != null && ES2.field_msgId != 0 && ES2.field_createTime < bdVar.field_createTime) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
                        } else if (count3 <= 0 || gVar.ctH() < 0) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", new Object[]{Integer.valueOf(i4), Integer.valueOf(count3), Integer.valueOf(gVar.ctH())});
                        } else {
                            long j;
                            gVar.EQ(count3);
                            String str = "MicroMsg.ChattingUI.SilenceMsgComponent";
                            String str2 = "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]";
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(firstVisiblePosition);
                            objArr[1] = Integer.valueOf(i2);
                            if (ES == null) {
                                j = -1;
                            } else {
                                j = ES.field_createTime;
                            }
                            objArr[2] = Long.valueOf(j);
                            if (ES2 == null) {
                                j = -1;
                            } else {
                                j = ES2.field_createTime;
                            }
                            objArr[3] = Long.valueOf(j);
                            objArr[4] = Long.valueOf(bdVar.field_createTime);
                            x.i(str, str2, objArr);
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", new Object[]{Integer.valueOf(count3), Integer.valueOf(count3 + 1), Integer.valueOf(firstVisiblePosition)});
                            gVar.lS(true);
                            this.bAG.eX(count3 + 1, ((o) this.bAG.O(o.class)).cvy() + this.bAG.tTs.getTopHeight());
                            com.tencent.mm.sdk.platformtools.ah.A(new 10(this, count3, gVar));
                        }
                        this.bAG.tTs.cub();
                        gVar.ctE();
                        if (aiVar.field_UnDeliverCount <= 0) {
                            ((p) this.bAG.O(p.class)).cvz();
                        }
                        if (this.tSc) {
                            this.tSc = false;
                            this.bAG.tTs.setIsBottomShowAll(gVar.ctK());
                            this.bAG.tTs.setBottomViewVisible(((w) this.bAG.O(w.class)).cvQ());
                            this.bAG.tTs.lK(false);
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", new Object[]{Boolean.valueOf(this.tSc)});
                            com.tencent.mm.ui.chatting.c.a.cwt().postDelayed(new 11(this, aiVar), 500);
                        }
                    }
                }
            }
        }
    }

    public final void bb(bd bdVar) {
        if (bdVar != null && bdVar.field_msgId != 0) {
            long j;
            long j2 = bdVar.field_msgSeq;
            boolean z = (bdVar.field_flag & 4) != 0;
            int i = 18;
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(this.bAG.oLT.field_username);
            if (Yq != null) {
                j = z ? Yq.field_firstUnDeliverSeq : Yq.field_lastSeq;
                if (z && j == 0) {
                    i = Yq.field_UnDeliverCount;
                }
                if (z && j > j2) {
                    bd W = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().W(this.bAG.oLT.field_username, j2);
                    if (W != null && W.field_msgSeq < j2) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", new Object[]{Long.valueOf(j), Long.valueOf(W.field_msgSeq)});
                        j = W.field_msgSeq;
                    }
                }
            } else {
                j = 0;
            }
            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(bdVar.field_flag), Boolean.valueOf(z)});
            this.tSb = false;
            com.tencent.mm.modelmulti.o.PN().a(new b.a(this.bAG.oLT.field_username, (int) j, (int) j2, i, z ? 1 : 0), this);
        }
    }

    public final boolean cvW() {
        if (this.bAG.cwr()) {
            bd ES = ((g) this.bAG.O(g.class)).ES(0);
            if (ES == null || ES.field_msgId == 0) {
                x.d("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onTopLoadData firstMsgInfo is null");
            } else {
                x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onTopLoadData check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(ES.field_flag), Integer.valueOf(ES.field_isSend), Long.valueOf(ES.field_msgId), Long.valueOf(ES.field_msgSvrId), Long.valueOf(ES.field_msgSeq), Long.valueOf(ES.field_createTime), Integer.valueOf(ES.getType()), ES.field_talker});
                au.HU();
                if ((com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_flag & 1) == 0) {
                    x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onTopLoadData check fault found in cache but db is not[%d, %d, %d, %d, %d, %d, %d, %s] notify", new Object[]{Integer.valueOf(com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_flag), Integer.valueOf(com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_isSend), Long.valueOf(com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_msgId), Long.valueOf(com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_msgSvrId), Long.valueOf(com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_msgSeq), Long.valueOf(com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_createTime), Integer.valueOf(com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).getType()), com.tencent.mm.model.c.FT().J(ES.field_talker, ES.field_msgSeq).field_talker});
                    ((g) this.bAG.O(g.class)).ctD();
                    return false;
                } else if (!((ES.field_flag & 1) == 0 || (ES.field_flag & 4) == 0)) {
                    x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onTopLoadData check fault found");
                    ((g) this.bAG.O(g.class)).lS(true);
                    au.Em().H(new 12(this, ES));
                    return true;
                }
            }
        }
        return false;
    }

    public final void Ff(int i) {
        this.tSd = i;
    }

    public final void Fg(int i) {
        this.tSe = i;
    }

    public final void eY(int i, int i2) {
        if (this.tSb && i - i2 == (this.tSd << 1)) {
            this.tSb = false;
            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr set dealHistoryGetMsg %b firstVisibleItem: %d, totalItemCount:%d mUnreadMessageBeforeCheckHistory:%d", new Object[]{Boolean.valueOf(this.tSb), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.tSd)});
        }
    }

    public final void b(ai aiVar, int i, int i2) {
        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr mGoBackToHistryMsgLayout Unread[%d] UnDeliver[%d] pos[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(aiVar.field_UnDeliverCount), Integer.valueOf(i2)});
        if (aiVar.field_UnDeliverCount <= 0) {
            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] less then one scene do normal", new Object[]{Integer.valueOf(r0)});
        } else {
            int i3 = (int) aiVar.field_firstUnDeliverSeq;
            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] need get firstSeq[%d]", new Object[]{Integer.valueOf(r0), Integer.valueOf(i3)});
            if (i3 > 0) {
                au.Em().H(new 3(this, i3, aiVar));
                return;
            }
        }
        ((p) this.bAG.O(p.class)).an(i2, false);
    }

    public final boolean cvX() {
        if (!this.tSc || tSa <= 0) {
            return false;
        }
        this.bAG.getListView().getViewTreeObserver().addOnGlobalLayoutListener(new 4(this, System.currentTimeMillis()));
        return true;
    }

    public final boolean cvY() {
        return this.tSg;
    }

    public final void cvZ() {
        this.tSg = false;
    }

    public final boolean cwa() {
        return this.tSc;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 0) {
            try {
                View childAt = this.bAG.getChildAt(this.bAG.getFirstVisiblePosition());
                bd ES;
                if (childAt != null && childAt.getTop() == 0) {
                    x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
                    if (this.bAG.cwr()) {
                        ES = ((g) this.bAG.O(g.class)).ES(0);
                        if (ES != null && ES.field_msgId != 0) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(ES.field_flag), Integer.valueOf(ES.field_isSend), Long.valueOf(ES.field_msgId), Long.valueOf(ES.field_msgSvrId), Long.valueOf(ES.field_msgSeq), Long.valueOf(ES.field_createTime), Integer.valueOf(ES.getType()), ES.field_talker});
                            if ((ES.field_flag & 1) != 0 && (ES.field_flag & 4) != 0) {
                                this.bAG.tTs.cua();
                            }
                        }
                    }
                } else if (this.bAG.cwr() && this.bAG.getChildAt(this.bAG.getListView().getChildCount() - 1) != null) {
                    g gVar = (g) this.bAG.O(g.class);
                    if (this.bAG.getLastVisiblePosition() == this.bAG.getListView().getAdapter().getCount() - 1) {
                        cm cmVar;
                        bd bdVar = null;
                        for (int i2 = 1; i2 < 5; i2++) {
                            bdVar = ((g) this.bAG.O(g.class)).ES(gVar.getCount() - i2);
                            if (bdVar != null && bdVar.field_msgId != 0 && (bdVar.field_flag & 1) != 0) {
                                x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", new Object[]{Integer.valueOf(i2)});
                                cmVar = bdVar;
                                break;
                            }
                        }
                        cmVar = bdVar;
                        if (cmVar == null || cmVar.field_msgId == 0) {
                            if ((((cmVar.field_flag & 2) != 0 ? 1 : 0) & (cmVar != null ? 1 : 0)) != 0) {
                                au.HU();
                                ES = com.tencent.mm.model.c.FT().GE(cmVar.field_talker);
                                if (ES != null && ES.field_msgId != 0 && ES.field_createTime > cmVar.field_createTime) {
                                    x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", new Object[]{Integer.valueOf(ES.field_flag), Integer.valueOf(ES.field_isSend), Long.valueOf(ES.field_msgId), Long.valueOf(ES.field_msgSvrId), Long.valueOf(ES.field_msgSeq), Long.valueOf(ES.field_createTime), Integer.valueOf(ES.getType()), ES.field_talker});
                                    ((g) this.bAG.O(g.class)).ctD();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ES = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().J(cmVar.field_talker, cmVar.field_msgSeq);
                        if (ES.field_msgId != 0 && ES.field_msgId == cmVar.field_msgId && (ES.field_flag & 1) == 0) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", new Object[]{Long.valueOf(ES.field_msgId), Integer.valueOf(ES.field_flag)});
                            ((g) this.bAG.O(g.class)).ctD();
                            return;
                        }
                        x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(cmVar.field_flag), Integer.valueOf(cmVar.field_isSend), Long.valueOf(cmVar.field_msgId), Long.valueOf(cmVar.field_msgSvrId), Long.valueOf(cmVar.field_msgSeq), Long.valueOf(cmVar.field_createTime), Integer.valueOf(cmVar.getType()), cmVar.field_talker});
                        if ((cmVar.field_flag & 1) != 0 && (cmVar.field_flag & 4) == 0) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
                            this.bAG.tTs.setIsBottomShowAll(false);
                            this.bAG.tTs.setBottomViewVisible(true);
                            this.bAG.tTs.lK(true);
                            x.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
                            ((g) this.bAG.O(g.class)).lS(true);
                            au.Em().H(new 2(this, cmVar));
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", e, "silenceMsgImp handleIdelScrollChange", new Object[0]);
            }
        }
    }

    public final void cpF() {
        this.tSb = false;
        this.tSf = this.bAG.cwr();
        this.tSb = false;
        this.tSc = false;
    }

    public final void cpG() {
        csI();
        this.tOB = true;
    }

    public final void cpH() {
        au.HU();
        com.tencent.mm.model.c.FW().a(this, Looper.getMainLooper());
        com.tencent.mm.sdk.b.a.sFg.b(this.tSh);
    }

    public final void cpI() {
        if (!this.tOB && this.bAG.cwr()) {
            csI();
        }
        this.tOB = false;
    }

    public final void cpJ() {
    }

    public final void cpK() {
        com.tencent.mm.sdk.b.a.sFg.c(this.tSh);
        au.HU();
        com.tencent.mm.model.c.FW().a(this);
    }
}
