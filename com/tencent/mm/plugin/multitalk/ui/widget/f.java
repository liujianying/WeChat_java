package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.j.1;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements OnClickListener, c, g {
    com.tencent.mm.ui.widget.a.c fad = null;
    public TextView hrs;
    public FrameLayout lvO;
    public FrameLayout lvP;
    private RelativeLayout lvQ;
    public View lvR;
    private View lvS;
    private View lvT;
    public View lvU;
    public MMCheckBox lvV;
    public MMCheckBox lvW;
    public MMCheckBox lvX;
    private int lvY;
    private int lvZ;
    private MultiTalkMainUI lvs;
    private ImageButton lvy;
    public ArrayList<RelativeLayout> lwa = new ArrayList(9);
    private RelativeLayout lwb;
    private com.tencent.mm.plugin.voip.video.a lwc;
    private j lwd;
    private ObservableTextureView lwe;
    public String lwf;
    private int lwg;
    public long lwh;
    c lwi = new c(this, (byte) 0);

    public static class a {
        View gFD;
        public MultiTalkVideoView lwk;
        public ImageView lwl;
        public ImageView lwm;
        public TextView lwn;
        ImageView lwo;
    }

    private class b implements Runnable {
        a lwp;

        public b(a aVar) {
            this.lwp = aVar;
        }

        public final void run() {
            this.lwp.lwn.setVisibility(8);
        }
    }

    public f(MultiTalkMainUI multiTalkMainUI) {
        int gv;
        RelativeLayout relativeLayout;
        this.lvs = multiTalkMainUI;
        this.lvQ = (RelativeLayout) multiTalkMainUI.findViewById(R.h.talking_main_top);
        if (ak.gw(multiTalkMainUI.mController.tml)) {
            gv = ak.gv(multiTalkMainUI.mController.tml) + 0;
        } else {
            gv = 0;
        }
        this.lvQ.setPadding(0, gv, 0, 0);
        this.hrs = (TextView) multiTalkMainUI.findViewById(R.h.time_tv);
        this.lvR = multiTalkMainUI.findViewById(R.h.talking_layout);
        this.lvy = (ImageButton) multiTalkMainUI.findViewById(R.h.talking_hangup_btn);
        this.lvO = (FrameLayout) multiTalkMainUI.findViewById(R.h.talking_main_avatar_layout);
        this.lvP = (FrameLayout) multiTalkMainUI.findViewById(R.h.talking_big_avatar_layout);
        this.lvS = multiTalkMainUI.findViewById(R.h.multitalk_mini_action);
        this.lvT = multiTalkMainUI.findViewById(R.h.multitalk_addmembers_action);
        this.lvV = (MMCheckBox) multiTalkMainUI.findViewById(R.h.multitalk_video_action);
        this.lvW = (MMCheckBox) multiTalkMainUI.findViewById(R.h.multitalk_mute_action);
        this.lvX = (MMCheckBox) multiTalkMainUI.findViewById(R.h.multitalk_handsfree_action);
        this.lvU = multiTalkMainUI.findViewById(R.h.multitalk_convert_camera_btn);
        this.lvW.setChecked(o.bgN().hEj);
        this.lvX.setChecked(o.bgN().ltn);
        this.lvV.setChecked(o.bgN().bgj());
        this.lvY = com.tencent.mm.bp.a.fk(multiTalkMainUI.mController.tml);
        this.lvZ = b.dU(multiTalkMainUI.mController.tml);
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[]{Integer.valueOf(this.lvZ)});
        this.lvy.setOnClickListener(this);
        this.lvS.setOnClickListener(this);
        this.lvV.setOnClickListener(this);
        this.lvW.setOnClickListener(this);
        this.lvX.setOnClickListener(this);
        this.lvT.setOnClickListener(this);
        this.lvU.setOnClickListener(this);
        q.Kp().a(this);
        for (int i = 8; i >= 0; i--) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.i.main_ui_talking_avatar_cell, this.lvO, false);
            a aVar = new a();
            aVar.lwk = (MultiTalkVideoView) relativeLayout.findViewById(R.h.talking_video_view);
            aVar.lwk.setIndex(i);
            aVar.lwk.setOnClickListener(this);
            aVar.gFD = relativeLayout.findViewById(R.h.mask_view);
            aVar.lwl = (ImageView) relativeLayout.findViewById(R.h.voice_icon_iv);
            aVar.lwm = (ImageView) relativeLayout.findViewById(R.h.multitalk_weaknetwork_iv);
            aVar.lwn = (TextView) relativeLayout.findViewById(R.h.switch_camera_tip_tv);
            aVar.lwo = (ImageView) relativeLayout.findViewById(R.h.loading_iv);
            relativeLayout.setTag(aVar);
            relativeLayout.setVisibility(8);
            this.lwa.add(relativeLayout);
            this.lvO.addView(relativeLayout);
        }
        if (this.lvP != null) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.i.main_ui_talking_avatar_cell, this.lvP, false);
            a aVar2 = new a();
            aVar2.lwk = (MultiTalkVideoView) relativeLayout.findViewById(R.h.talking_video_view);
            aVar2.lwk.setIndex(0);
            aVar2.lwk.setOnClickListener(this);
            aVar2.gFD = relativeLayout.findViewById(R.h.mask_view);
            aVar2.lwl = (ImageView) relativeLayout.findViewById(R.h.voice_icon_iv);
            aVar2.lwm = (ImageView) relativeLayout.findViewById(R.h.multitalk_weaknetwork_iv);
            aVar2.lwn = (TextView) relativeLayout.findViewById(R.h.switch_camera_tip_tv);
            aVar2.lwo = (ImageView) relativeLayout.findViewById(R.h.loading_iv);
            relativeLayout.setTag(aVar2);
            relativeLayout.setVisibility(8);
            this.lwb = relativeLayout;
            this.lvP.addView(relativeLayout);
        }
        this.lvP.setVisibility(8);
        if (o.bgN().bgj()) {
            this.lvU.setVisibility(0);
        } else {
            this.lvU.setVisibility(8);
        }
        this.lwf = "";
        bgW();
    }

    public final void o(MultiTalkGroup multiTalkGroup) {
        this.lvR.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.vgq) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                linkedList.add(multiTalkGroupMember);
            }
        }
        W(linkedList);
        bgW();
    }

    private void W(LinkedList<MultiTalkGroupMember> linkedList) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        this.lwg = linkedList.size();
        LayoutParams layoutParams = this.lvO.getLayoutParams();
        if (this.lwg <= 4) {
            i = this.lvY / 2;
            i2 = this.lvZ / 2 > i ? i : this.lvZ / 2;
            layoutParams.height = i2 * 2;
            i3 = i2;
        } else if (this.lwg <= 9) {
            i = this.lvY / 3;
            i2 = this.lvZ / 3 > i ? i : this.lvZ / 3;
            layoutParams.height = i2 * 3;
            i3 = i2;
        } else {
            x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", new Object[]{Integer.valueOf(this.lwg)});
            return;
        }
        this.lvO.setLayoutParams(layoutParams);
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(this.lwg)});
        HashSet hashSet = new HashSet();
        hashSet.addAll(o.bgN().ltr);
        if (o.bgN().bgj()) {
            hashSet.add(com.tencent.mm.model.q.GF());
        }
        if (this.lwg <= 4) {
            fArr = i.lua[this.lwg];
        } else {
            fArr = i.lua[5];
        }
        if (fArr != null) {
            i2 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= fArr.length) {
                    break;
                }
                MultiTalkGroupMember multiTalkGroupMember;
                if (this.lwg > i4 / 2) {
                    multiTalkGroupMember = (MultiTalkGroupMember) linkedList.get(i4 / 2);
                } else {
                    multiTalkGroupMember = null;
                }
                i2 = (int) (fArr[i4] * ((float) i));
                int i5 = (int) (fArr[i4 + 1] * ((float) i3));
                if (this.lwg == 2 && i2 == 0) {
                    i2 = 1;
                }
                if (this.lwg == 4 && r0 == 0) {
                    i2 = 1;
                }
                int i6 = i2;
                RelativeLayout relativeLayout = (RelativeLayout) this.lwa.get(i4 / 2);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.width = i;
                layoutParams2.height = i3;
                layoutParams2.leftMargin = i6;
                layoutParams2.topMargin = i5;
                relativeLayout.setLayoutParams(layoutParams2);
                a(relativeLayout, multiTalkGroupMember, false, hashSet);
                relativeLayout.setVisibility(0);
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "setIvLayoutParams, width: %s, height: %s, marginLeft: %s, marginTop: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i5)});
                i2 = i4 + 2;
            }
        }
        if (this.lwg <= 4) {
            i2 = this.lwg;
            while (true) {
                i = i2;
                if (i >= 9) {
                    break;
                }
                ((RelativeLayout) this.lwa.get(i)).setVisibility(8);
                i2 = i + 1;
            }
        }
        if (o.bgN().bgm() && this.lvV != null && !this.lvV.isChecked()) {
            o.bgN().ti(1);
        }
    }

    private static void a(RelativeLayout relativeLayout, MultiTalkGroupMember multiTalkGroupMember, boolean z, HashSet<String> hashSet) {
        a aVar = (a) relativeLayout.getTag();
        if (multiTalkGroupMember != null) {
            aVar.lwk.HS(multiTalkGroupMember.vgr);
            aVar.lwk.setPosition(aVar.lwk.getIndex());
            if (multiTalkGroupMember.status != 10) {
                aVar.gFD.setVisibility(0);
                if (aVar.lwo.getBackground() != null) {
                    aVar.lwo.setVisibility(0);
                    ((AnimationDrawable) aVar.lwo.getBackground()).stop();
                    ((AnimationDrawable) aVar.lwo.getBackground()).start();
                }
            } else {
                aVar.gFD.setVisibility(8);
                a(aVar);
            }
            if (!hashSet.contains(multiTalkGroupMember.vgr) || z) {
                aVar.lwk.bgY();
                return;
            } else {
                aVar.lwk.bgZ();
                return;
            }
        }
        aVar.gFD.setVisibility(8);
        a(aVar);
        aVar.lwk.bha();
    }

    public final RelativeLayout HR(String str) {
        Iterator it = this.lwa.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) it.next();
            if (str.equals(((a) relativeLayout.getTag()).lwk.getUsername())) {
                return relativeLayout;
            }
        }
        return null;
    }

    private static int o(boolean z, int i) {
        int i2;
        if (z) {
            i2 = i;
        } else {
            i2 = -1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(i2);
        int appCmd = o.bgM().lta.setAppCmd(22, allocate.array(), 4);
        if (appCmd >= 0) {
            return appCmd;
        }
        x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", new Object[]{Integer.valueOf(appCmd), Integer.valueOf(i2), Integer.valueOf(i)});
        return -1;
    }

    public final void onClick(View view) {
        MultiTalkGroupMember multiTalkGroupMember = null;
        boolean z = true;
        if (view instanceof MultiTalkVideoView) {
            MultiTalkVideoView multiTalkVideoView = (MultiTalkVideoView) view;
            a aVar;
            if (this.lvP.getVisibility() != 8) {
                if (!multiTalkVideoView.getUsername().equals(com.tencent.mm.model.q.GF())) {
                    x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
                    o.bgN().HA("");
                    o(false, -1);
                }
                this.lvP.setVisibility(8);
                this.lvO.setVisibility(0);
                if (this.lwb != null) {
                    aVar = (a) this.lwb.getTag();
                    if (aVar != null) {
                        aVar.lwk.bha();
                    }
                }
                this.lwf = "";
                d.bgi();
            } else if (multiTalkVideoView.bhd()) {
                int i;
                this.lvP.setVisibility(0);
                this.lvO.setVisibility(8);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.width = this.lvY;
                layoutParams.height = this.lvY;
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = 0;
                this.lwb.setLayoutParams(layoutParams);
                String username = multiTalkVideoView.getUsername();
                for (MultiTalkGroupMember multiTalkGroupMember2 : o.bgN().ltt.vgq) {
                    MultiTalkGroupMember multiTalkGroupMember22;
                    if ((multiTalkGroupMember22.status != 10 && multiTalkGroupMember22.status != 1) || !multiTalkGroupMember22.vgr.equals(username)) {
                        multiTalkGroupMember22 = multiTalkGroupMember;
                    }
                    multiTalkGroupMember = multiTalkGroupMember22;
                }
                TalkRoom adg = com.tencent.wecall.talkroom.model.c.cHG().adg(o.bgN().ltt.vgm);
                if (adg != null) {
                    for (av avVar : adg.cHD()) {
                        if (avVar.vez.equals(username)) {
                            i = avVar.kpU;
                            break;
                        }
                    }
                }
                i = 0;
                if (!username.equals(com.tencent.mm.model.q.GF())) {
                    x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", new Object[]{Integer.valueOf(i)});
                    o.bgN().HA(username);
                    o(true, i);
                }
                if (!(ao.is2G(this.lvs) || ao.is3G(this.lvs))) {
                    z = false;
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(o.bgN().ltr);
                if (o.bgN().bgj()) {
                    hashSet.add(com.tencent.mm.model.q.GF());
                }
                aVar = (a) this.lwb.getTag();
                aVar.lwk.HS(username);
                aVar.lwk.bha();
                this.lwb.setTag(aVar);
                a(this.lwb, multiTalkGroupMember, z, hashSet);
                this.lwb.setVisibility(0);
                this.lwf = username;
                d.bgh();
            }
        } else if (view.getId() == R.h.talking_hangup_btn) {
            o.bgN().g(true, false, false);
        } else if (view.getId() == R.h.multitalk_mini_action) {
            d.lth++;
            o.bgN().gJ(true);
            d.bgg();
        } else if (view.getId() == R.h.multitalk_handsfree_action) {
            if (this.lvX.isEnabled()) {
                d.ltj++;
                o.bgN().gK(this.lvX.isChecked());
                bgW();
                if (this.lvX.isChecked()) {
                    d.bgb();
                } else {
                    d.bgc();
                }
            }
        } else if (view.getId() == R.h.multitalk_mute_action) {
            d.lti++;
            e bgN = o.bgN();
            boolean isChecked = this.lvW.isChecked();
            o.bgM().lta.mN(isChecked);
            bgN.gD(isChecked);
            if (this.lvW.isChecked()) {
                d.bfZ();
            } else {
                d.bga();
            }
        } else if (view.getId() == R.h.multitalk_convert_camera_btn) {
            if (this.lwc != null) {
                this.lwc.bLX();
            }
            d.bgf();
        } else if (view.getId() == R.h.multitalk_video_action) {
            d.ltk++;
            if (!com.tencent.mm.compatible.f.b.zV()) {
                com.tencent.mm.ax.e.a(this.lvs, R.l.voip_no_record_video_permission, null);
                this.lvV.setChecked(false);
            } else if (!o.bgN().bgm()) {
                this.lvV.setChecked(false);
            } else if (!ao.isNetworkConnected(this.lvs)) {
                com.tencent.mm.ax.e.a(this.lvs, R.l.voip_net_unavailable, null);
                this.lvV.setChecked(false);
            } else if (i.bgG()) {
                if (this.lvV.isChecked()) {
                    gM(false);
                    d.bgd();
                } else {
                    gN(false);
                    o.bgN().ti(1);
                    d.bge();
                }
                this.lvV.setChecked(o.bgN().bgj());
            } else {
                Toast.makeText(this.lvs, R.l.multitalk_disabled, 1).show();
                this.lvV.setChecked(false);
            }
        } else if (view.getId() == R.h.multitalk_addmembers_action) {
            d.ltl++;
            this.lvs.bgS();
        }
    }

    public final void d(HashSet<String> hashSet) {
        Iterator it = this.lwa.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!com.tencent.mm.model.q.GF().equals(aVar.lwk.getUsername())) {
                if (hashSet.contains(aVar.lwk.getUsername())) {
                    if (!aVar.lwk.bhd()) {
                        aVar.lwk.bgZ();
                    }
                } else if (aVar.lwk.bhd()) {
                    aVar.lwk.bgY();
                    if (this.lwf.equals(aVar.lwk.getUsername()) && this.lvP.getVisibility() == 0) {
                        this.lwf = "";
                        this.lvP.setVisibility(8);
                        this.lvO.setVisibility(0);
                    }
                }
            }
        }
    }

    public final void bgU() {
        Iterator it = this.lwa.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!com.tencent.mm.model.q.GF().equals(aVar.lwk.getUsername()) && aVar.lwk.bhd()) {
                aVar.lwk.bgY();
            }
        }
    }

    public final void gM(boolean z) {
        ViewGroup HR;
        if (!z) {
            this.lwh = System.currentTimeMillis();
        }
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
        if (this.lvP == null || this.lvP.getVisibility() != 0) {
            HR = HR(com.tencent.mm.model.q.GF());
        } else {
            HR = (ViewGroup) this.lvs.findViewById(R.h.rootview);
        }
        if (HR != null) {
            if (this.lwe == null) {
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
                this.lwe = new ObservableTextureView(this.lvs);
                this.lwe.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                HR.addView(this.lwe);
                this.lwe.setVisibility(0);
            }
            if (this.lwc == null) {
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
                this.lwc = new com.tencent.mm.plugin.voip.video.a(320, 240);
                this.lwc.a(this, true);
                this.lwc.a(this.lwe);
                this.lwc.bLY();
                if (!o.bgN().ltq) {
                    this.lwc.bLX();
                }
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(this.lwc.bMb()), Boolean.valueOf(this.lwc.bMc())});
            }
            if (this.lwd == null) {
                this.lwd = new j(this.lvs);
                com.tencent.mm.sdk.f.e.d(new 1(this.lwd), "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
            }
        }
    }

    public final void gN(boolean z) {
        if (!z && this.lwh != 0 && System.currentTimeMillis() - this.lwh > 0 && o.bgN().bgn()) {
            d.o(System.currentTimeMillis() - this.lwh, i.bgC());
            this.lwh = 0;
        }
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
        if (this.lwe != null) {
            ViewParent parent = this.lwe.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.lwe);
            }
            this.lwe = null;
        }
        if (this.lwc != null) {
            this.lwc.bLZ();
            com.tencent.mm.plugin.voip.video.a.bMa();
            this.lwc = null;
        }
        if (this.lwd != null) {
            j jVar = this.lwd;
            jVar.ltC = null;
            jVar.luh.iKs = false;
            jVar.luh.lul = null;
            if (jVar.lug != null) {
                jVar.lug.removeCallbacksAndMessages(null);
                jVar.lug.getLooper().quit();
                jVar.lug = null;
            }
            this.lwd = null;
        }
    }

    public final boolean bfL() {
        return this.lwc != null;
    }

    public final void gO(boolean z) {
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
        this.lwg = 0;
        if (!z) {
            ah.A(new 1(this));
        }
        gN(false);
        Iterator it = this.lwa.iterator();
        while (it.hasNext()) {
            ((a) ((RelativeLayout) it.next()).getTag()).lwk.setSurfaceTextureListener(null);
        }
        q.Kp().b(this);
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        if (o.bgN().bgm()) {
            if (this.lwi.lul == null) {
                this.lwi.w = i;
                this.lwi.h = i2;
                this.lwi.lul = new int[(this.lwi.w * this.lwi.h)];
            }
            if (!o.bgN().bgj()) {
                i.bgE();
                o.bgN().ti(3);
            }
            long currentTimeMillis = System.currentTimeMillis();
            o.bgN().ltq = this.lwc.bMb();
            int i4 = this.lwc.bMb() ? OpenGlRender.oUJ : 0;
            int i5 = this.lwc.bMc() ? OpenGlRender.oUI : OpenGlRender.oUH;
            com.tencent.pb.talkroom.sdk.g a = o.bgM().lta.a(bArr, (int) j, this.lwi.w, this.lwi.h, i3 & 31, this.lwi.lul);
            if (a.ret < 0 || this.lwi.lul == null || a.vgz == 0 || a.vgA == 0) {
                x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[]{Integer.valueOf(a.ret)});
                return;
            }
            int i6;
            long currentTimeMillis2 = System.currentTimeMillis();
            int i7 = i4 == OpenGlRender.oUJ ? 257 : 1;
            if (o.bgN().ltE) {
                i6 = i4 == OpenGlRender.oUJ ? 259 : 3;
            } else {
                i6 = i7;
            }
            i7 = o.bgM().lta.a(bArr, (short) ((int) j), i, i2, i3, i6);
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[]{Integer.valueOf(a.vgz), Integer.valueOf(a.vgA), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            }
            if (i7 <= 0) {
                x.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[]{Integer.valueOf(i7)});
            }
            if (this.lwd != null && this.lwi.lul != null) {
                j jVar = this.lwd;
                int[] iArr = this.lwi.lul;
                i7 = a.vgz;
                int i8 = a.vgA;
                if (iArr == null) {
                    x.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
                    return;
                } else if (jVar.luh.iKs) {
                    x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
                    return;
                } else {
                    if (jVar.luh.lul == null) {
                        jVar.luh.lul = new int[iArr.length];
                    }
                    jVar.luh.w = i7;
                    jVar.luh.h = i8;
                    jVar.luh.luj = i3;
                    jVar.luh.luk = i4;
                    jVar.luh.angle = i5;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    i6 = jVar.luh.h;
                    if (jVar.luh.h > jVar.luh.w) {
                        i6 = jVar.luh.w;
                    }
                    if (jVar.luh.jDx == null) {
                        jVar.luh.jDx = Bitmap.createBitmap(i6, i6, Config.RGB_565);
                    }
                    if (jVar.luh.jDx != null) {
                        jVar.luh.jDx.setPixels(iArr, jVar.luh.w - jVar.luh.h, jVar.luh.w, 0, 0, i6, i6);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis3 > 30) {
                        x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)});
                    }
                    if (jVar.lug != null) {
                        jVar.lug.post(new com.tencent.mm.plugin.multitalk.a.j.b(jVar));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        gN(false);
    }

    public final synchronized void a(String str, int[] iArr, int i, int i2, int i3) {
        if (this.lvP.getVisibility() == 0) {
            a aVar = (a) this.lwb.getTag();
            if (str.equals(aVar.lwk.getUsername())) {
                aVar.lwk.a(iArr, i, i2, i3);
            }
        } else {
            RelativeLayout HR = HR(str);
            if (HR != null) {
                ((a) HR.getTag()).lwk.a(iArr, i, i2, i3);
            }
        }
    }

    public final synchronized void a(String str, Bitmap bitmap, int i, int i2) {
        if (this.lvP.getVisibility() == 0) {
            a aVar = (a) this.lwb.getTag();
            if (str.equals(aVar.lwk.getUsername())) {
                aVar.lwk.c(bitmap, i2, i);
            }
        } else {
            RelativeLayout HR = HR(str);
            if (HR != null) {
                ((a) HR.getTag()).lwk.c(bitmap, i2, i);
            }
        }
    }

    public final void bgV() {
        x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
        if (this.fad == null) {
            this.fad = com.tencent.mm.ax.e.a(this.lvs, R.l.voip_no_record_video_permission, new 2(this));
        }
        if (!this.fad.isShowing()) {
            this.fad.show();
        }
        o.bgN().ti(1);
    }

    public final void jX(String str) {
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[]{str});
        RelativeLayout HR = HR(str);
        if (HR != null) {
            ((a) HR.getTag()).lwk.bgX();
        }
    }

    private static void a(a aVar) {
        if (aVar.lwo.getBackground() != null) {
            ((AnimationDrawable) aVar.lwo.getBackground()).stop();
        }
        aVar.lwo.setVisibility(8);
    }

    public final void bgW() {
        if (this.lvX.isEnabled()) {
            e bgN = o.bgN();
            x.l("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", new Object[]{Boolean.valueOf(this.lvX.isChecked())});
            bgN.lto = r1;
        }
    }
}
