package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.m;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MultiTalkMainUI extends MMActivity implements com.tencent.mm.plugin.multitalk.a.a {
    protected ag ioW;
    private c luQ;
    private f luR;
    private boolean luS;
    private boolean luT = true;
    private boolean luU = false;
    private Runnable luV = new Runnable() {
        public final void run() {
            o.bgN().bgv();
        }
    };
    private boolean luW;
    private BroadcastReceiver luX = new 3(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(R.a.pop_in, R.a.anim_not_change);
        } else {
            overridePendingTransition(R.a.slide_top_in, R.a.slide_top_out);
        }
        getWindow().addFlags(6946944);
        o.bgN().aWS();
        if (o.bgN().bgl()) {
            this.luQ = new c(this);
            this.luR = new f(this);
            o.bgN().gK(o.bgN().ltn);
            o.bgN().ltC = this;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.luX, intentFilter);
            this.luU = true;
            this.ioW = new ag();
            au.HV().yB();
            if (!com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
                x.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
                return;
            }
            return;
        }
        finish();
        if (intExtra == 2) {
            getIntent().getStringExtra("enterMainUiWxGroupId");
        }
    }

    protected final int getLayoutId() {
        return R.i.multitalk_main_ui;
    }

    protected void onResume() {
        super.onResume();
        switch (6.luZ[o.bgN().lts.ordinal()]) {
            case 1:
                this.luR.lvR.setVisibility(8);
                this.luQ.n(o.bgN().ltt);
                if (ao.is4G(this)) {
                    o.bgL().w(this);
                } else if (ao.is2G(this) || ao.is3G(this)) {
                    o.bgL().v(this);
                }
                if (this.luT) {
                    o.bgN().gL(false);
                    break;
                }
                break;
            case 2:
            case 3:
                this.luQ.bgT();
                this.luR.o(o.bgN().ltt);
                if (ao.is4G(this)) {
                    o.bgL().w(this);
                } else if (ao.is2G(this) || ao.is3G(this)) {
                    o.bgL().v(this);
                }
                o.bgN().gL(true);
                break;
            case 4:
                this.luQ.bgT();
                this.luR.o(o.bgN().ltt);
                break;
        }
        if (o.bgN().bgm()) {
            if (o.bgN().bgj()) {
                this.luR.gM(true);
            }
            this.ioW.postDelayed(this.luV, 2000);
        }
    }

    protected void onPause() {
        PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.luS = z;
        x.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", new Object[]{Boolean.valueOf(this.luS)});
        if (o.bgN().bgm()) {
            o.bgN().bgw();
            this.luR.gN(true);
        }
        super.onPause();
    }

    protected void onDestroy() {
        if (this.luW) {
            o.bgN().gJ(false);
        }
        if (this.luU) {
            unregisterReceiver(this.luX);
        }
        super.onDestroy();
    }

    protected void onStop() {
        if (!this.luW && this.luS) {
            o.bgN().gJ(false);
        }
        super.onStop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            h.a(this, R.l.multitalk_exit_tip, R.l.multitalk, R.l.app_alert_exit, R.l.app_cancel, new 2(this), null);
            return true;
        }
        if (o.bgN().lts == e.lvJ) {
            if (i == 25 || i == 24) {
                o.bgN().stopRing();
                this.luT = false;
                return true;
            }
        } else if (i == 25) {
            au.HV().fE(aXI());
            return true;
        } else if (i == 24) {
            au.HV().fD(aXI());
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static int aXI() {
        if (au.HV().yE()) {
            return au.HV().yQ();
        }
        if (o.bgN().koX.alf()) {
            return 0;
        }
        return 3;
    }

    public final void bgS() {
        this.luW = true;
        Intent intent = new Intent(this, MultiTalkAddMembersUI.class);
        List arrayList = new ArrayList();
        for (MultiTalkGroupMember multiTalkGroupMember : o.bgN().ltt.vgq) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                arrayList.add(multiTalkGroupMember.vgr);
            }
        }
        intent.putExtra("titile", getString(R.l.multitalk_add_contact));
        intent.putExtra("chatroomName", o.bgN().ltt.vgo);
        intent.putExtra("always_select_contact", bi.c(arrayList, ","));
        intent.putExtra("key_need_gallery", false);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i + " resultCode " + i2);
        super.onActivityResult(i, i2, intent);
        this.luW = false;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            x.i("MicroMsg.MT.MultiTalkMainUI", "add member " + stringExtra);
            List F = bi.F(stringExtra.split(","));
            if (F != null) {
                com.tencent.mm.plugin.multitalk.a.e bgN = o.bgN();
                if (bgN.bgl()) {
                    stringExtra = bgN.ltt.vgm;
                    if (bi.oW(stringExtra)) {
                        stringExtra = bgN.ltt.vgn;
                    }
                    o.bgM().lta.u(stringExtra, F);
                }
            }
        }
    }

    public final void bfJ() {
        switch (6.luZ[o.bgN().lts.ordinal()]) {
            case 1:
                this.luQ.n(o.bgN().ltt);
                return;
            case 2:
            case 3:
            case 4:
                this.luR.o(o.bgN().ltt);
                return;
            default:
                return;
        }
    }

    public final void bcI() {
        this.luQ.bgT();
        this.luR.o(o.bgN().ltt);
    }

    public final void aWY() {
        jr jrVar = new jr();
        jrVar.bTt.action = 0;
        com.tencent.mm.sdk.b.a.sFg.m(jrVar);
        this.luR.gO(true);
        o.bgN().ltC = null;
        o.bgN().stopRing();
        finish();
    }

    public final void bfI() {
        au.HV().yC();
        com.tencent.mm.sdk.f.e.post(new e$6(o.bgN()), "MultiTalkManager_play_end_sound");
        jr jrVar = new jr();
        jrVar.bTt.action = 0;
        com.tencent.mm.sdk.b.a.sFg.m(jrVar);
        this.luR.gO(false);
        o.bgN().ltC = null;
        o.bgN().stopRing();
        finish();
    }

    public final void onError(int i) {
        if (i == -1700) {
            f fVar = this.luR;
            x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
            fVar.gN(false);
            o.bgN().ti(1);
            fVar.lvV.setChecked(false);
        }
    }

    public final void bfK() {
        x.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + o.bgN().ltr.size());
        if (o.bgN().bgm()) {
            if (o.bgN().ltr.size() > 0) {
                i.bgE();
                o.bgN().bgv();
            } else {
                o.bgN().bgw();
            }
            f fVar = this.luR;
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.bgN().ltr);
            if (o.bgN().bgk()) {
                fVar.d(hashSet);
            }
        }
    }

    public final void gD(boolean z) {
        if (o.bgN().bgm()) {
            this.luR.lvW.setChecked(z);
        }
    }

    public final void gE(boolean z) {
        if (o.bgN().bgm()) {
            f fVar = this.luR;
            fVar.lvX.setChecked(z);
            fVar.bgW();
        }
    }

    public final void cT(int i, int i2) {
        if (o.bgN().bgm()) {
            f fVar = this.luR;
            f.a aVar = (f.a) fVar.HR(q.GF()).getTag();
            if (!i.tj(i2)) {
                if (i.tj(i)) {
                    fVar.lvV.setChecked(false);
                    aVar.lwk.bgY();
                    fVar.lvU.setVisibility(8);
                    if (fVar.lwf.equals(q.GF()) && fVar.lvP.getVisibility() == 0) {
                        fVar.lwf = "";
                        fVar.lvO.setVisibility(0);
                        fVar.lvP.setVisibility(8);
                    }
                }
                fVar.gN(false);
            } else if (i.tj(i2) && !i.tj(i)) {
                fVar.lvV.setChecked(true);
                aVar.lwk.bgZ();
                aVar.lwn.setVisibility(8);
                ah.i(new b(aVar), 1500);
                fVar.lvU.setVisibility(0);
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.bgN().ltr);
            if (i.tk(i2)) {
                if (i.tk(i2) && !i.tk(i)) {
                    fVar.d(hashSet);
                }
            } else if (i.tk(i)) {
                fVar.bgU();
            }
        }
    }

    public final void gF(boolean z) {
        if (o.bgN().bgm()) {
            f fVar = this.luR;
            if (fVar.lvX != null) {
                fVar.lvX.setEnabled(z);
            }
        }
    }

    public final void a(String str, int[] iArr, int i, int i2, int i3) {
        if (o.bgN().bgm()) {
            this.luR.a(str, iArr, i, i2, i3);
        }
    }

    public final void a(String str, Bitmap bitmap, int i, int i2) {
        this.luR.a(str, bitmap, i, i2);
    }

    public final int Hx(String str) {
        RelativeLayout HR = this.luR.HR(str);
        return HR == null ? -1 : ((f.a) HR.getTag()).lwk.getPosition();
    }

    public final void a(e eVar) {
        if (eVar == e.lvM) {
            f fVar = this.luR;
            if (fVar.lwh > 0) {
                fVar.lwh = System.currentTimeMillis();
            }
        }
    }

    public final void a(i.a aVar) {
        if (aVar == i.a.luc) {
            o.bgL().w(this);
        } else if (aVar == i.a.lud) {
            o.bgL().v(this);
        } else if (aVar == i.a.lue) {
            com.tencent.mm.ax.e.a(this, R.l.voip_net_unavailable, null);
        }
    }

    public final void aWZ() {
        Iterator it;
        f.a aVar;
        f fVar = this.luR;
        long j = (long) o.bgN().ltw;
        fVar.hrs.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        com.tencent.mm.plugin.multitalk.a.e bgN = o.bgN();
        String str = bgN.ltt.vgm;
        if (bi.oW(str)) {
            str = bgN.ltt.vgn;
        }
        List acj = o.bgM().lta.acj(str);
        HashSet hashSet = o.bgN().ltr;
        if (acj != null) {
            it = fVar.lwa.iterator();
            while (it.hasNext()) {
                aVar = (f.a) ((RelativeLayout) it.next()).getTag();
                String username = aVar.lwk.getUsername();
                if ((q.GF().equals(username) && fVar.bfL()) || !acj.contains(username) || hashSet.contains(username)) {
                    aVar.lwl.setVisibility(8);
                    x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s hide", new Object[]{username});
                } else {
                    aVar.lwl.setVisibility(0);
                    x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "displayVoiceTalkingIcon, %s show", new Object[]{username});
                }
            }
        }
        bgN = o.bgN();
        str = bgN.ltt.vgm;
        if (bi.oW(str)) {
            str = bgN.ltt.vgn;
        }
        if (m.luE == null) {
            m.luE = new m();
        }
        m mVar = m.luE;
        List arrayList = new ArrayList();
        mVar.luF = com.tencent.wecall.talkroom.model.c.cHG().adg(str);
        if (mVar.luF != null) {
            for (av avVar : mVar.luF.cHD()) {
                int i = avVar.kpU;
                if (i >= 0) {
                    byte[] bArr = new byte[4];
                    if (o.bgM().lta.setAppCmd(10, bArr, i) < 0) {
                        x.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", new Object[]{Integer.valueOf(i)});
                        i = -1;
                    } else {
                        i = bi.aH(bArr);
                        x.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", new Object[]{Integer.valueOf(i)});
                    }
                    Object obj = (i == -1 || i >= 5) ? null : 1;
                    if (obj != null) {
                        arrayList.add(avVar.vez);
                    }
                }
            }
        }
        Iterator it2 = fVar.lwa.iterator();
        while (it2.hasNext()) {
            aVar = (f.a) ((RelativeLayout) it2.next()).getTag();
            if (arrayList.contains(aVar.lwk.getUsername())) {
                aVar.lwm.setVisibility(0);
            } else {
                aVar.lwm.setVisibility(8);
            }
        }
    }

    public final boolean bfL() {
        if (this.luR != null) {
            return this.luR.bfL();
        }
        return false;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            x.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        x.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 82:
                if (iArr[0] == 0) {
                    x.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
                    return;
                } else {
                    h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 4(this), new 5(this));
                    return;
                }
            default:
                return;
        }
    }
}
