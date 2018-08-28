package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.c.a.a;
import b.c.b.i;
import b.c.b.j;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.a$c;
import com.tencent.mm.plugin.radar.a$f;
import com.tencent.mm.plugin.radar.b.c$m;
import com.tencent.mm.plugin.radar.b.c.c;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public final class RadarViewController extends RelativeLayout implements c, com.tencent.mm.plugin.radar.b.e.d {
    private static final String TAG = TAG;
    static final /* synthetic */ b.e.d[] mkL = new b.e.d[]{(b.e.d) j.a(new i(j.X(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), (b.e.d) j.a(new i(j.X(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), (b.e.d) j.a(new i(j.X(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), (b.e.d) j.a(new i(j.X(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), (b.e.d) j.a(new i(j.X(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), (b.e.d) j.a(new i(j.X(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), (b.e.d) j.a(new i(j.X(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), (b.e.d) j.a(new i(j.X(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;"))};
    public static final b mmJ = new b();
    com.tencent.mm.plugin.radar.b.e mmA;
    com.tencent.mm.plugin.radar.b.c mmB;
    c mmC;
    private com.tencent.mm.plugin.radar.b.e.e mmD = com.tencent.mm.plugin.radar.b.e.e.mkr;
    private final boolean mmE;
    final OnClickListener mmF = ((OnClickListener) new f(this));
    private final int mmG = 33554432;
    private final int mmH = (this.mmG + 1);
    private final int mmI = (this.mmG + 2);
    private final b.b mms = b.c.b((a) new h(this));
    private final b.b mmt = i.D(this, a$c.radar_member_detail_panel);
    private final b.b mmu = i.D(this, a$c.radar_search_result_grid);
    private final b.b mmv = i.D(this, a$c.radar_tips);
    private final b.b mmw = i.D(this, a$c.radar_new_tip);
    private final b.b mmx = i.D(this, a$c.radar_new_tip_loading);
    private final b.b mmy = i.D(this, a$c.radar_quit_btn);
    private final b.b mmz = i.D(this, a$c.radar_bg_mask);

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public final class d {
        private beq mkp;
        final /* synthetic */ RadarViewController mmN;

        public d(RadarViewController radarViewController, beq beq) {
            b.c.b.e.i(beq, "member");
            this.mmN = radarViewController;
            this.mkp = beq;
        }
    }

    public static final class e implements com.tencent.mm.plugin.radar.ui.RadarMemberView.b {
        final /* synthetic */ RadarViewController mmN;

        e(RadarViewController radarViewController) {
            this.mmN = radarViewController;
        }

        public final void a(beq beq, com.tencent.mm.plugin.radar.b.c.e eVar) {
            b.c.b.e.i(beq, "member");
            g gVar = g.mmr;
            String b = g.b(beq);
            if (eVar != null) {
                switch (h.mkC[eVar.ordinal()]) {
                    case 1:
                        RadarViewController.c(this.mmN).mkd.put(Long.valueOf(this.mmN.mmB.Kh(b)), new com.tencent.mm.plugin.radar.b.e.c(beq, eVar));
                        this.mmN.d(b, com.tencent.mm.plugin.radar.b.c.e.mjA);
                        return;
                    case 2:
                        byte b2;
                        String str;
                        String username;
                        byte b3;
                        long j;
                        com.tencent.mm.plugin.radar.b.c e = this.mmN.mmB;
                        b.c.b.e.i(b, "username");
                        com.tencent.mm.kernel.c.a l = g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class);
                        b.c.b.e.h(l, "service(IMessengerStorage::class.java)");
                        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) l).FR().Yg(b);
                        b.c.b.e.h(Yg, "contact");
                        CharSequence username2 = Yg.getUsername();
                        if (username2 == null || b.f.a.U(username2)) {
                            b2 = (byte) 1;
                        } else {
                            b2 = (byte) 0;
                        }
                        if (b2 != (byte) 0) {
                            str = b;
                        } else {
                            username = Yg.getUsername();
                            b.c.b.e.h(username, "contact.username");
                            str = username;
                        }
                        username = (String) e.mjq.get(str);
                        CharSequence charSequence = username;
                        if (charSequence == null || b.f.a.U(charSequence)) {
                            b3 = (byte) 1;
                        } else {
                            b3 = (byte) 0;
                        }
                        if (b3 != (byte) 0) {
                            com.tencent.mm.plugin.radar.b.c.b bVar = com.tencent.mm.plugin.radar.b.c.mju;
                            x.e(com.tencent.mm.plugin.radar.b.c.access$getTAG$cp(), "Verify Contact username(%s) error, verifyTicket is null", new Object[]{str});
                            e.Kh(str);
                            j = -1;
                        } else {
                            com.tencent.mm.storage.bd.d YY = com.tencent.mm.storage.bd.d.YY(username);
                            long currentTimeMillis = System.currentTimeMillis();
                            com.tencent.mm.plugin.radar.b.c.a aVar = new com.tencent.mm.plugin.radar.b.c.a(e, (com.tencent.mm.plugin.radar.b.c.d) new c$m(e, username, currentTimeMillis));
                            String cmL = YY.cmL();
                            b.c.b.e.h(cmL, "verify.verifyTicket");
                            b.c.b.e.i(cmL, "verifyTicket");
                            String str2 = "username is null";
                            boolean z = str != null && str.length() > 0;
                            Assert.assertTrue(str2, z);
                            aVar.onStart();
                            g.DF().d((l) new m(str, cmL, 48, (byte) 0));
                            j = currentTimeMillis;
                        }
                        RadarViewController.c(this.mmN).mkd.put(Long.valueOf(j), new com.tencent.mm.plugin.radar.b.e.c(beq, eVar));
                        this.mmN.d(b, com.tencent.mm.plugin.radar.b.c.e.mjA);
                        return;
                    default:
                        return;
                }
            }
        }

        public final void b(beq beq, com.tencent.mm.plugin.radar.b.c.e eVar) {
            Object b;
            if (beq != null) {
                g gVar = g.mmr;
                b = g.b(beq);
            } else {
                b = null;
            }
            View view = (View) RadarViewController.d(this.mmN).mmU.get(b);
            if (view != null) {
                Object tag = view.getTag();
                if (tag == null) {
                    throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                }
                a aVar = (a) tag;
                if (eVar != com.tencent.mm.plugin.radar.b.c.e.mjz) {
                    aVar.mmY.bpF();
                }
            }
            this.mmN.f().bpO();
        }
    }

    private final TextView getNewRadarTip() {
        return (TextView) this.mmw.getValue();
    }

    private final ProgressBar getNewRadarTipLoading() {
        return (ProgressBar) this.mmx.getValue();
    }

    private final View getRadarBgMask() {
        return (View) this.mmz.getValue();
    }

    final RadarSpecialGridView getGrid() {
        return (RadarSpecialGridView) this.mmu.getValue();
    }

    /* renamed from: getMemberDetailView */
    final RadarMemberView g() {
        return (RadarMemberView) this.mmt.getValue();
    }

    final Button getQuitBtn() {
        return (Button) this.mmy.getValue();
    }

    final RadarTipsView getRadarTips() {
        return (RadarTipsView) this.mmv.getValue();
    }

    /* renamed from: getWaveView */
    final RadarWaveView f() {
        return (RadarWaveView) this.mms.getValue();
    }

    public RadarViewController(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "mContext");
        super(context, attributeSet);
        com.tencent.mm.plugin.radar.b.e.d dVar = (com.tencent.mm.plugin.radar.b.e.d) this;
        Context applicationContext = context.getApplicationContext();
        b.c.b.e.h(applicationContext, "mContext.getApplicationContext()");
        this.mmA = new com.tencent.mm.plugin.radar.b.e(dVar, applicationContext);
        this.mmB = new com.tencent.mm.plugin.radar.b.c((c) this, context);
    }

    public static final /* synthetic */ void bpM() {
    }

    public static final /* synthetic */ com.tencent.mm.plugin.radar.b.e c(RadarViewController radarViewController) {
        com.tencent.mm.plugin.radar.b.e eVar = radarViewController.mmA;
        if (eVar == null) {
            b.c.b.e.adK("radarManager");
        }
        return eVar;
    }

    public static final /* synthetic */ c d(RadarViewController radarViewController) {
        c cVar = radarViewController.mmC;
        if (cVar == null) {
            b.c.b.e.adK("adapter");
        }
        return cVar;
    }

    private final void setRadarStatus(com.tencent.mm.plugin.radar.b.e.e eVar) {
        this.mmD = eVar;
    }

    public final com.tencent.mm.plugin.radar.b.e.e getRadarStatus() {
        return this.mmD;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b.c.b.e.i(keyEvent, "event");
        if (i != 4 || !g().isShowing()) {
            return false;
        }
        g().dismiss();
        return true;
    }

    private final void d(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        com.tencent.mm.plugin.radar.b.e eVar2 = this.mmA;
        if (eVar2 == null) {
            b.c.b.e.adK("radarManager");
        }
        if (str == null) {
            b.c.b.e.cJM();
        }
        com.tencent.mm.plugin.radar.b.c.e Kj = eVar2.Kj(str);
        if (Kj != null && Kj != eVar) {
            eVar2 = this.mmA;
            if (eVar2 == null) {
                b.c.b.e.adK("radarManager");
            }
            eVar2.b(str, eVar);
            c cVar = this.mmC;
            if (cVar == null) {
                b.c.b.e.adK("adapter");
            }
            cVar.bpx();
        }
    }

    public final void a(boolean z, boolean z2, String str, String str2, long j) {
        com.tencent.mm.plugin.radar.b.e eVar;
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.mjB);
        } else if (z2) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.mjA);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.Kk(str);
            eVar = this.mmA;
            if (eVar == null) {
                b.c.b.e.adK("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.mkd.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.mmr;
                d(g.b(cVar.mkp), cVar.mkq);
                gVar = g.mmr;
                d(g.c(cVar.mkp), cVar.mkq);
            }
        }
        eVar = this.mmA;
        if (eVar == null) {
            b.c.b.e.adK("radarManager");
        }
        eVar.mkd.remove(Long.valueOf(j));
    }

    public final void a(boolean z, String str, String str2, long j) {
        com.tencent.mm.plugin.radar.b.e eVar;
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.mjB);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.Kk(str);
            eVar = this.mmA;
            if (eVar == null) {
                b.c.b.e.adK("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.mkd.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.mmr;
                d(g.b(cVar.mkp), cVar.mkq);
            }
        }
        eVar = this.mmA;
        if (eVar == null) {
            b.c.b.e.adK("radarManager");
        }
        eVar.mkd.remove(Long.valueOf(j));
    }

    public final void L(ab abVar) {
        b.c.b.e.i(abVar, "contact");
        com.tencent.mm.plugin.radar.b.e eVar = this.mmA;
        if (eVar == null) {
            b.c.b.e.adK("radarManager");
        }
        String username = abVar.getUsername();
        b.c.b.e.h(username, "contact.username");
        if (eVar.Kj(username) == null) {
            eVar = this.mmA;
            if (eVar == null) {
                b.c.b.e.adK("radarManager");
            }
            username = abVar.wR();
            b.c.b.e.h(username, "contact.encryptUsername");
            if (eVar.Kj(username) == null) {
                LinkedList linkedList = new LinkedList();
                username = abVar.getUsername();
                b.c.b.e.h(username, "contact.username");
                String wR = abVar.wR();
                b.c.b.e.h(wR, "contact.encryptUsername");
                String wO = abVar.wO();
                b.c.b.e.h(wO, "contact.nickname");
                beq beq = new beq();
                beq.sdg = 100;
                beq.hbL = username;
                beq.hcS = wO;
                beq.rwN = "";
                beq.ryZ = wR;
                linkedList.add(beq);
                Y(linkedList);
            }
        }
        if (g().isShowing()) {
            RadarMemberView memberDetailView = g();
            username = abVar.wR();
            b.c.b.e.h(username, "contact.encryptUsername");
            memberDetailView.c(username, com.tencent.mm.plugin.radar.b.c.e.mjC);
        }
        d(abVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.mjC);
        d(abVar.wR(), com.tencent.mm.plugin.radar.b.c.e.mjC);
    }

    public final void K(ab abVar) {
        b.c.b.e.i(abVar, "contact");
        if (g().isShowing()) {
            RadarMemberView memberDetailView = g();
            String wR = abVar.wR();
            b.c.b.e.h(wR, "contact.encryptUsername");
            memberDetailView.c(wR, com.tencent.mm.plugin.radar.b.c.e.mjB);
        }
        d(abVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.mjB);
        d(abVar.wR(), com.tencent.mm.plugin.radar.b.c.e.mjB);
    }

    public final void a(int i, int i2, LinkedList<beq> linkedList) {
        if (i == 0 && i2 == 0) {
            Y(linkedList);
            return;
        }
        x.e(TAG, "radar member return error : %s, type : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        RadarTipsView radarTips;
        String string;
        if (2 == i) {
            radarTips = getRadarTips();
            string = getContext().getString(a$f.net_warn_no_network);
            b.c.b.e.h(string, "context.getString(R.string.net_warn_no_network)");
            radarTips.Kk(string);
            return;
        }
        radarTips = getRadarTips();
        string = getContext().getString(a$f.radar_tips_network_err);
        b.c.b.e.h(string, "context.getString(R.string.radar_tips_network_err)");
        radarTips.Kk(string);
    }

    public final void b(int i, int i2, LinkedList<ben> linkedList) {
        int i3 = 0;
        if (i == 0 && i2 == 0 && linkedList != null) {
            a(com.tencent.mm.plugin.radar.b.e.e.mku);
            c cVar = this.mmC;
            if (cVar == null) {
                b.c.b.e.adK("adapter");
            }
            c(cVar.mmN).mke.clear();
            c(cVar.mmN).mka.clear();
            cVar.mmQ.clear();
            cVar.mmR.clear();
            LinkedList linkedList2 = null;
            if (linkedList != null && linkedList.size() > 0) {
                int i4;
                LinkedList linkedList3 = new LinkedList();
                int size = linkedList.size();
                for (i4 = 0; i4 < size; i4++) {
                    ben ben = (ben) linkedList.get(i4);
                    beo beo = new beo();
                    beo.sgf = ben.hbL;
                    linkedList3.add(beo);
                    Map map = c(cVar.mmN).mka;
                    String str = ben.ryZ;
                    b.c.b.e.h(str, "radarchatroomMember.EncodeUserName");
                    String str2 = ben.hbL;
                    b.c.b.e.h(str2, "radarchatroomMember.UserName");
                    map.put(str, str2);
                    HashMap hashMap = cVar.mmR;
                    g gVar = g.mmr;
                    hashMap.put(g.a(ben), Integer.valueOf(0));
                }
                i4 = ((Object[]) cVar.mmP).length;
                while (i3 < i4) {
                    beq beq = cVar.mmP[i3];
                    Map map2 = c(cVar.mmN).mka;
                    g gVar2 = g.mmr;
                    if (!bi.oW((String) map2.get(g.c(beq)))) {
                        d(cVar.mmN).d(beq);
                        c(cVar.mmN).a(beq);
                    }
                    i3++;
                }
                linkedList2 = linkedList3;
            }
            c(cVar.mmN).mjZ = linkedList2;
            c cVar2 = this.mmC;
            if (cVar2 == null) {
                b.c.b.e.adK("adapter");
            }
            cVar2.bpx();
            return;
        }
        a(com.tencent.mm.plugin.radar.b.e.e.mkr);
        RadarTipsView radarTips = getRadarTips();
        String string = getContext().getString(a$f.radar_tips_network_err);
        b.c.b.e.h(string, "context.getString(R.string.radar_tips_network_err)");
        radarTips.Kk(string);
    }

    private final void Y(LinkedList<beq> linkedList) {
        c cVar;
        if (linkedList == null) {
            b.c.b.e.cJM();
        }
        if (linkedList.size() == 0) {
            c cVar2 = this.mmC;
            if (cVar2 == null) {
                b.c.b.e.adK("adapter");
            }
            if (cVar2.getCount() == 0) {
                getRadarTips().setNoMember(true);
                x.d(TAG, "members got, size : " + linkedList.size());
                x.d(TAG, "has friend:%s", new Object[]{String.valueOf(Z(linkedList))});
                cVar = this.mmC;
                if (cVar == null) {
                    b.c.b.e.adK("adapter");
                }
                cVar.aa(linkedList);
                if (this.mmE && r0) {
                    a(com.tencent.mm.plugin.radar.b.e.e.mks);
                    return;
                }
            }
        }
        getRadarTips().setNoMember(false);
        x.d(TAG, "members got, size : " + linkedList.size());
        x.d(TAG, "has friend:%s", new Object[]{String.valueOf(Z(linkedList))});
        cVar = this.mmC;
        if (cVar == null) {
            b.c.b.e.adK("adapter");
        }
        cVar.aa(linkedList);
        if (this.mmE) {
        }
    }

    private final boolean Z(LinkedList<beq> linkedList) {
        boolean z = false;
        if (linkedList == null) {
            b.c.b.e.cJM();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.radar.b.c.e Ki;
            boolean z2;
            beq beq = (beq) it.next();
            com.tencent.mm.plugin.radar.b.e eVar = this.mmA;
            if (eVar == null) {
                b.c.b.e.adK("radarManager");
            }
            b.c.b.e.h(beq, "member");
            com.tencent.mm.plugin.radar.b.c.e a = com.tencent.mm.plugin.radar.b.e.a(eVar, beq);
            if (a == null) {
                g gVar = g.mmr;
                String b = g.b(beq);
                Ki = this.mmB.Ki(b);
                com.tencent.mm.plugin.radar.b.e eVar2 = this.mmA;
                if (eVar2 == null) {
                    b.c.b.e.adK("radarManager");
                }
                eVar2.b(b, Ki);
            } else {
                Ki = a;
            }
            if (Ki == com.tencent.mm.plugin.radar.b.c.e.mjB) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    private final void a(com.tencent.mm.plugin.radar.b.e.e eVar) {
        this.mmD = eVar;
        com.tencent.mm.plugin.radar.b.e eVar2;
        switch (h.mnc[eVar.ordinal()]) {
            case 1:
                getRadarBgMask().setVisibility(8);
                getQuitBtn().setText(a$f.radar_quit);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                f().bpO();
                f().setVisibility(0);
                eVar2 = this.mmA;
                if (eVar2 == null) {
                    b.c.b.e.adK("radarManager");
                }
                eVar2.bps();
                return;
            case 2:
                getRadarBgMask().setVisibility(8);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                return;
            case 3:
                if (getRadarBgMask().getVisibility() != 0) {
                    getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.radar.a.a.radar_button_fade_in));
                    getRadarBgMask().setVisibility(0);
                }
                getQuitBtn().setText(a$f.app_cancel);
                eVar2 = this.mmA;
                if (eVar2 == null) {
                    b.c.b.e.adK("radarManager");
                }
                eVar2.bpt();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(a$f.radar_searching_for_chat);
                f().bpP();
                f().setVisibility(4);
                getGrid().setVisibility(4);
                c cVar = this.mmC;
                if (cVar == null) {
                    b.c.b.e.adK("adapter");
                }
                cVar.mmR.clear();
                cVar.mmU.clear();
                for (String str : cVar.mmU.keySet()) {
                    View view = (View) cVar.mmU.get(str);
                    if (view != null) {
                        a aVar = cVar.mmS;
                        b.c.b.e.h(view, "it");
                        b.c.b.e.i(view, "view");
                        int ct = aVar.ct(view);
                        if (ct > 0) {
                            aVar.mmM.removeMessages(ct);
                        }
                        view.clearAnimation();
                    }
                }
                cVar.bpx();
                return;
            case 4:
                getRadarBgMask().setVisibility(0);
                eVar2 = this.mmA;
                if (eVar2 == null) {
                    b.c.b.e.adK("radarManager");
                }
                eVar2.bpt();
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText(a$f.radar_create_chat_tip);
                getGrid().setVisibility(0);
                return;
            case 5:
                getRadarBgMask().setVisibility(8);
                eVar2 = this.mmA;
                if (eVar2 == null) {
                    b.c.b.e.adK("radarManager");
                }
                eVar2.bpt();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(a$f.radar_create_chating);
                return;
            default:
                return;
        }
    }
}
