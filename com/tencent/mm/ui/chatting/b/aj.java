package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.tencent.mm.R;
import com.tencent.mm.ax.f;
import com.tencent.mm.ax.g;
import com.tencent.mm.ay.c;
import com.tencent.mm.ay.d;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.4;
import com.tencent.mm.ui.base.TalkRoomPopupNav.5;
import com.tencent.mm.ui.base.TalkRoomPopupNav.8;
import com.tencent.mm.ui.base.TalkRoomPopupNav.9;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ac;
import com.tencent.mm.ui.chatting.b.b.e;
import com.tencent.mm.ui.chatting.b.b.p;
import com.tencent.mm.ui.widget.a.c$a;
import java.util.List;

@a(cwo = ac.class)
public class aj extends a implements com.tencent.mm.ax.a, c, b, ac {
    private final j.a tOy = new j.a() {
        public final void a(String str, l lVar) {
            x.v("MicroMsg.ChattingUI.TrackRoomComponent", "roommember watcher notify " + str);
            if (!bi.oW(str)) {
                aj.this.lW(false);
            }
        }
    };
    public TalkRoomPopupNav tSG;
    public MultiTalkRoomPopupNav tSH;
    private TalkRoomPopupNav.a tSI = new TalkRoomPopupNav.a() {
        public final void cse() {
            if (com.tencent.mm.p.a.by(aj.this.bAG.tTq.getContext()) || com.tencent.mm.p.a.bw(aj.this.bAG.tTq.getContext())) {
                x.d("MicroMsg.ChattingUI.TrackRoomComponent", "voip is running");
                return;
            }
            List ns = d.elh.ns(aj.this.bAG.oLT.field_username);
            x.i("MicroMsg.ChattingUI.TrackRoomComponent", "Click banner : %d", new Object[]{Integer.valueOf(ns.size())});
            if (d.elh.nt(aj.this.bAG.oLT.field_username)) {
                aj.b(aj.this);
            } else {
                aj.this.lX(true);
            }
        }

        public final void csf() {
            rn rnVar = new rn();
            rnVar.ccn.ccq = true;
            com.tencent.mm.sdk.b.a.sFg.m(rnVar);
            aj.this.aas(aj.this.bAG.getTalkerUserName());
        }
    };

    static /* synthetic */ void b(aj ajVar) {
        boolean z = ((e) ajVar.bAG.O(e.class)).cuI() || ((com.tencent.mm.ui.chatting.b.b.c) ajVar.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cux();
        if (!ajVar.bAG.getTalkerUserName().toLowerCase().endsWith("@chatroom") || z) {
            rn rnVar = new rn();
            rnVar.ccn.ccp = true;
            com.tencent.mm.sdk.b.a.sFg.m(rnVar);
            if (bi.oW(rnVar.cco.ccr) || ajVar.bAG.getTalkerUserName().equals(rnVar.cco.ccr)) {
                ajVar.bAG.getTalkerUserName();
                ajVar.by("fromBanner", false);
                return;
            }
            rnVar = new rn();
            rnVar.ccn.ccq = true;
            com.tencent.mm.sdk.b.a.sFg.m(rnVar);
            ajVar.bAG.getTalkerUserName();
            ajVar.by("fromBanner", false);
            return;
        }
        h.b(ajVar.bAG.tTq.getContext(), ajVar.bAG.tTq.getMMResources().getString(R.l.track_room_kicked_tip), null, true);
    }

    public final boolean cwb() {
        if (this.tSG != null && this.tSG.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final boolean cwc() {
        if (this.tSH != null && this.tSH.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final int cwd() {
        if (this.tSG == null) {
            return 0;
        }
        return this.tSG.getHeight();
    }

    public final void ad(final Runnable runnable) {
        if (d.elh == null || !d.elh.az(this.bAG.oLT.field_username, this.bAG.cwp())) {
            runnable.run();
        } else {
            h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.track_leave_chattingui), this.bAG.tTq.getMMResources().getString(R.l.app_tip), true, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    runnable.run();
                    er erVar = new er();
                    erVar.bMv.username = aj.this.bAG.getTalkerUserName();
                    com.tencent.mm.sdk.b.a.sFg.m(erVar);
                }
            }, new 6(this));
        }
    }

    public final void p(String str, String str2, String str3) {
        if (this.bAG != null && str.equals(this.bAG.getTalkerUserName())) {
            lW(false);
        }
    }

    public final void nu(String str) {
        if (this.bAG != null && str.equals(this.bAG.getTalkerUserName())) {
            lW(false);
        }
    }

    public final void SF(String str) {
        if (this.bAG != null && str.equals(this.bAG.getTalkerUserName())) {
            lW(false);
        }
    }

    private void a(TalkRoomPopupNav.a aVar) {
        if (this.tSG == null) {
            i.a(this.bAG.tTq, R.h.viewstub_talkroom_popup_nav);
            this.tSG = (TalkRoomPopupNav) this.bAG.findViewById(R.h.talk_room_popup_nav);
            if (this.tSG == null) {
                return;
            }
        }
        if (this.tSG != null) {
            this.tSG.setOnClickListener(aVar);
        }
    }

    private void lW(boolean z) {
        if (this.bAG == null) {
            x.w("MicroMsg.ChattingUI.TrackRoomComponent", "[checkTalkroomBanner] isResume:%s mChattingContext == null! maybe chattingui has Exited! this event come from post msg", new Object[]{Boolean.valueOf(z)});
            return;
        }
        boolean z2 = ((e) this.bAG.O(e.class)).cuI() || ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cux();
        if (!s.fq(this.bAG.getTalkerUserName()) || z2) {
            cwe();
            String str;
            if (d.elh != null && d.elh.nt(this.bAG.oLT.field_username)) {
                a(this.tSI);
                if (this.tSG != null) {
                    List ns = d.elh.ns(this.bAG.oLT.field_username);
                    str = "";
                    if (ns == null || !ns.contains(this.bAG.cwp())) {
                        this.tSG.setIconAnim(-1);
                        this.tSG.stop();
                        this.tSG.setBgViewResource(R.g.tipsbar_grey_bg);
                        if (ns != null && ns.size() == 1) {
                            str = this.bAG.tTq.getMMResources().getString(R.l.track_room_one_sharing, new Object[]{r.gT((String) ns.get(0))});
                        } else if (ns != null) {
                            str = this.bAG.tTq.getMMResources().getString(R.l.track_room_some_people_in, new Object[]{Integer.valueOf(ns.size())});
                        }
                        this.tSG.setIconRes(R.k.tipsbar_icon_location);
                    } else {
                        this.tSG.setBgViewResource(R.g.tipsbar_green_bg);
                        str = this.bAG.tTq.getMMResources().getString(R.l.track_room_sharing);
                        this.tSG.setIconRes(R.k.tipsbar_icon_location_lightgreen);
                        this.tSG.setIconAnim(R.k.tipsbar_icon_location_shining);
                        TalkRoomPopupNav talkRoomPopupNav = this.tSG;
                        if (talkRoomPopupNav.tBj == null || talkRoomPopupNav.tBk == null) {
                            talkRoomPopupNav.tBj = new AlphaAnimation(0.0f, 1.0f);
                            talkRoomPopupNav.tBj.setDuration(1000);
                            talkRoomPopupNav.tBj.setStartOffset(0);
                            talkRoomPopupNav.tBk = new AlphaAnimation(1.0f, 0.0f);
                            talkRoomPopupNav.tBk.setDuration(1000);
                            talkRoomPopupNav.tBk.setStartOffset(0);
                            talkRoomPopupNav.tBj.setAnimationListener(new 8(talkRoomPopupNav));
                            talkRoomPopupNav.tBk.setAnimationListener(new 9(talkRoomPopupNav));
                            talkRoomPopupNav.tBc.startAnimation(talkRoomPopupNav.tBj);
                        }
                    }
                    this.tSG.setVisibility(0);
                    this.tSG.setNavContent(str);
                    ((p) this.bAG.O(p.class)).Fb(1);
                    return;
                }
                return;
            } else if (g.elf != null && g.elf.nq(this.bAG.getTalkerUserName())) {
                a(this.tSI);
                rn rnVar = new rn();
                rnVar.ccn.ccp = true;
                com.tencent.mm.sdk.b.a.sFg.m(rnVar);
                if (this.bAG.getTalkerUserName().equals(rnVar.cco.ccr)) {
                    this.tSG.setBgViewResource(R.g.tipsbar_green_bg);
                } else {
                    this.tSG.setBgViewResource(R.g.tipsbar_grey_bg);
                }
                str = this.bAG.tTq.getMMResources().getString(R.l.talk_room_some_people_in, new Object[]{Integer.valueOf(g.elf.np(this.bAG.getTalkerUserName()).size())});
                this.tSG.setIconRes(R.g.talk_room_mic_in_chat);
                this.tSG.setIconAnim(-1);
                this.tSG.stop();
                this.tSG.setVisibility(0);
                this.tSG.setNavContent(str);
                ((p) this.bAG.O(p.class)).Fb(1);
                return;
            } else if (!s.fq(this.bAG.getTalkerUserName()) || o.a.qyi == null) {
                cwe();
                return;
            } else {
                f HO = o.a.qyi.HO(this.bAG.getTalkerUserName());
                if (HO != null && HO.field_wxGroupId != null && HO.field_wxGroupId.equals(this.bAG.getTalkerUserName())) {
                    if (this.tSH == null) {
                        i.a(this.bAG.tTq, R.h.viewstub_multitalk_popup_nav);
                        this.tSH = (MultiTalkRoomPopupNav) this.bAG.findViewById(R.h.multitalk_talk_room_popup_nav);
                    }
                    if (this.tSH != null) {
                        x.i("MicroMsg.ChattingUI.TrackRoomComponent", "show multiTalkBanner! ");
                        this.tSH.setGroupUserName(this.bAG.getTalkerUserName());
                        this.tSH.setCurrentSenderUserName(this.bAG.cwp());
                        this.tSH.setInChatRoom(z2);
                        MultiTalkRoomPopupNav multiTalkRoomPopupNav = this.tSH;
                        multiTalkRoomPopupNav.toW = false;
                        if (multiTalkRoomPopupNav.toP == null || multiTalkRoomPopupNav.toQ == null) {
                            x.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.toP + ",currentSenderUserName:" + multiTalkRoomPopupNav.toQ);
                        } else {
                            String str2 = multiTalkRoomPopupNav.toP;
                            if (o.a.qyi == null || !o.a.qyi.HC(str2)) {
                                multiTalkRoomPopupNav.cqM();
                            } else {
                                List HE = o.a.qyi.HE(str2);
                                if (HE.size() == 0) {
                                    o.a.qyi.jy(str2);
                                    multiTalkRoomPopupNav.cqM();
                                } else {
                                    int dN = o.a.qyi.dN(str2, multiTalkRoomPopupNav.toQ);
                                    if (dN == 1) {
                                        multiTalkRoomPopupNav.setUserTalkingStatus$b292420(MultiTalkRoomPopupNav$b.tpa);
                                        if (o.a.qyi.HF(str2)) {
                                            multiTalkRoomPopupNav.cqM();
                                        } else {
                                            multiTalkRoomPopupNav.setInvitingBannerStyle(o.a.qyi.gT(o.a.qyi.dM(str2, multiTalkRoomPopupNav.toQ)));
                                        }
                                    } else if (dN == 10) {
                                        multiTalkRoomPopupNav.setUserTalkingStatus$b292420(MultiTalkRoomPopupNav$b.tpb);
                                        if (o.a.qyi.HF(str2)) {
                                            multiTalkRoomPopupNav.cqM();
                                        } else if (o.a.qyi.bgl()) {
                                            multiTalkRoomPopupNav.cqM();
                                        } else {
                                            multiTalkRoomPopupNav.setUserTalkingStatus$b292420(MultiTalkRoomPopupNav$b.tpc);
                                            multiTalkRoomPopupNav.setDefaultBannerStyle(ad.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[]{Integer.valueOf(HE.size())}));
                                        }
                                    } else {
                                        multiTalkRoomPopupNav.setUserTalkingStatus$b292420(MultiTalkRoomPopupNav$b.tpc);
                                        multiTalkRoomPopupNav.setDefaultBannerStyle(ad.getContext().getString(R.l.multitalk_somepepole_in_tip, new Object[]{Integer.valueOf(HE.size())}));
                                    }
                                    multiTalkRoomPopupNav.setVisibility(0);
                                    multiTalkRoomPopupNav.toK.setVisibility(0);
                                    multiTalkRoomPopupNav.toL.setVisibility(0);
                                    if (multiTalkRoomPopupNav.toT != null && (z || multiTalkRoomPopupNav.toV == null || multiTalkRoomPopupNav.toV.getVisibility() != 0)) {
                                        multiTalkRoomPopupNav.toT.toZ.setVisibility(8);
                                    }
                                    multiTalkRoomPopupNav.dw(MultiTalkRoomPopupNav.k(HE, ""));
                                }
                            }
                        }
                        this.tSH.setMultiTalkInfo(HO);
                        ((p) this.bAG.O(p.class)).Fb(1);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (this.tSG != null) {
            this.tSG.setVisibility(8);
            ((p) this.bAG.O(p.class)).Fb(-1);
        }
        if (this.tSH != null) {
            this.tSH.setInChatRoom(false);
            this.tSH.setVisibility(8);
        }
    }

    private void cwe() {
        if (this.tSG != null) {
            this.tSG.setVisibility(8);
            this.tSG.setIconAnim(-1);
            this.tSG.stop();
            ((p) this.bAG.O(p.class)).Fb(-1);
        }
        if (this.tSH != null) {
            if (!o.a.qyi.HC(this.bAG.getTalkerUserName())) {
                this.tSH.cqM();
            }
            this.tSH.setVisibility(8);
            ((p) this.bAG.O(p.class)).Fb(-1);
        }
    }

    public final void lX(boolean z) {
        int i = (((e) this.bAG.O(e.class)).cuI() || ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cux()) ? true : 0;
        if (this.bAG.getTalkerUserName().toLowerCase().endsWith("@chatroom") && i == 0) {
            h.b(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.talk_room_kicked_tip), null, true);
            return;
        }
        rn rnVar = new rn();
        rnVar.ccn.ccp = true;
        com.tencent.mm.sdk.b.a.sFg.m(rnVar);
        if (z) {
            if (bi.oW(rnVar.cco.ccr) || this.bAG.getTalkerUserName().equals(rnVar.cco.ccr)) {
                aas(this.bAG.getTalkerUserName());
            } else if (this.tSG == null || this.tSG.getVisibility() != 0) {
                h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.talk_room_change_room_tip), null, new 12(this), new 2(this));
            } else {
                this.tSG.setDialogContent(this.bAG.tTq.getMMResources().getString(R.l.talk_room_change_room_tip));
                TalkRoomPopupNav talkRoomPopupNav = this.tSG;
                if (talkRoomPopupNav.tBd == null) {
                    talkRoomPopupNav.tBd = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.tBf) * 1.0f) / ((float) talkRoomPopupNav.tBg), 1.0f);
                    talkRoomPopupNav.tBd.setDuration(300);
                    talkRoomPopupNav.tBd.setAnimationListener(new 4(talkRoomPopupNav));
                }
                if (talkRoomPopupNav.tBe == null) {
                    talkRoomPopupNav.tBe = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.fast_faded_out);
                    talkRoomPopupNav.tBe.setFillAfter(true);
                    talkRoomPopupNav.tBe.setAnimationListener(new 5(talkRoomPopupNav));
                }
                LayoutParams layoutParams = talkRoomPopupNav.iZk.getLayoutParams();
                layoutParams.height = talkRoomPopupNav.tBg;
                talkRoomPopupNav.iZk.setLayoutParams(layoutParams);
                talkRoomPopupNav.iZk.startAnimation(talkRoomPopupNav.tBd);
                talkRoomPopupNav.toK.startAnimation(talkRoomPopupNav.tBe);
                talkRoomPopupNav.tAZ.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.fast_faded_in));
                talkRoomPopupNav.tAZ.setVisibility(0);
            }
        } else if (d.elh != null && d.elh.nt(this.bAG.oLT.field_username)) {
            String string;
            List ns = d.elh.ns(this.bAG.oLT.field_username);
            if (ns == null || !ns.contains(this.bAG.cwp())) {
                string = this.bAG.tTq.getMMResources().getString(R.l.talk_room_err_other_sharing_location);
                i = R.l.join_sharing_location;
            } else {
                string = this.bAG.tTq.getMMResources().getString(R.l.talk_room_err_myself_sharing_location);
                i = R.l.enter_sharing_location;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(10997, new Object[]{Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            c$a c_a = new c$a(this.bAG.tTq.getContext());
            c_a.abu(string);
            c_a.Gt(R.l.app_cancel).a(new 8(this));
            c_a.Gu(i).b(new 9(this, z));
            c_a.anj().show();
        } else if (bi.oW(rnVar.cco.ccr) || this.bAG.getTalkerUserName().equals(rnVar.cco.ccr)) {
            aas(this.bAG.getTalkerUserName());
        } else {
            h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.talk_room_change_room_tip), null, new 10(this), new 11(this));
        }
    }

    public final void by(String str, boolean z) {
        if ((d.elh != null && d.elh.nt(this.bAG.oLT.field_username)) || z) {
            List ns = d.elh.ns(this.bAG.oLT.field_username);
            if (ns == null || !ns.contains(this.bAG.cwp())) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(10997, new Object[]{Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.enter_track_tips), null, new 3(this, str), new 4(this));
                return;
            }
        }
        aar(str);
    }

    public final void aar(String str) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 6);
        intent.putExtra("map_sender_name", this.bAG.cwp());
        intent.putExtra("map_talker_name", this.bAG.getTalkerUserName());
        intent.putExtra("fromWhereShare", str);
        com.tencent.mm.bg.d.b(this.bAG.tTq.getContext(), "location", ".ui.RedirectUI", intent);
    }

    private void aas(String str) {
        Intent intent = new Intent();
        intent.putExtra("enter_room_username", str);
        intent.setFlags(268435456);
        com.tencent.mm.bg.d.b(this.bAG.tTq.getContext(), "talkroom", ".ui.TalkRoomUI", intent);
    }

    public final void cun() {
        super.cun();
        if (this.tSG != null) {
            this.tSG.stop();
        }
    }

    public final void cpI() {
        x.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingResume]");
        if (g.elf != null) {
            g.elf.a(this);
        }
        if (d.elh != null) {
            d.elh.a(this);
        }
        if (o.a.qyi != null) {
            o.a.qyi.a(this);
        }
        lW(true);
    }

    public final void cpJ() {
        x.i("MicroMsg.ChattingUI.TrackRoomComponent", "[onChattingPause]");
        if (g.elf != null) {
            g.elf.b(this);
        }
        if (d.elh != null) {
            d.elh.b(this);
        }
        if (o.a.qyi != null) {
            o.a.qyi.b(this);
        }
    }

    public final void cpK() {
    }
}
