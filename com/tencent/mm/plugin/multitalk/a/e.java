package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.k.f;
import com.tencent.mm.k.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.pb.common.b.a.a$aa;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public final class e implements a {
    b epT;
    private Timer gei;
    public boolean hEj;
    private boolean knY;
    public i koX;
    private long ltA = 0;
    private long ltB = 30000;
    public a ltC;
    i.a ltD;
    public boolean ltE;
    MultiTalkGroup ltF = null;
    long ltG = 0;
    al ltH = new al(Looper.getMainLooper(), new 10(this), true);
    ag ltI = new ag(Looper.getMainLooper());
    BroadcastReceiver ltJ = new 2(this);
    c ltK = new 4(this);
    boolean ltm;
    public boolean ltn;
    public boolean lto;
    int ltp;
    public boolean ltq = true;
    public HashSet<String> ltr = new HashSet();
    public com.tencent.mm.plugin.multitalk.ui.widget.e lts = com.tencent.mm.plugin.multitalk.ui.widget.e.lvI;
    public MultiTalkGroup ltt = null;
    private k ltu;
    private long ltv = 0;
    public int ltw = 0;
    private int ltx = 0;
    private int lty = 2;
    private boolean ltz = false;

    public e() {
        com.tencent.mm.sdk.b.a.sFg.b(this.ltK);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ad.getContext().registerReceiver(this.ltJ, intentFilter);
        this.koX = new i(ad.getContext());
        this.epT = new b(ad.getContext());
        this.ltE = false;
    }

    public final boolean bgj() {
        i.bgE();
        return i.tj(this.ltp);
    }

    public final boolean bgk() {
        i.bgE();
        return i.tk(this.ltp);
    }

    public final boolean bgl() {
        boolean z;
        if (this.lts == com.tencent.mm.plugin.multitalk.ui.widget.e.lvI || this.ltt == null) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean bgm() {
        boolean z;
        if (this.lts == com.tencent.mm.plugin.multitalk.ui.widget.e.lvL || this.lts == com.tencent.mm.plugin.multitalk.ui.widget.e.lvM) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final boolean bgn() {
        boolean z;
        if (this.lts == com.tencent.mm.plugin.multitalk.ui.widget.e.lvM) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final long bgo() {
        return System.currentTimeMillis() - this.ltv;
    }

    private boolean a(MultiTalkGroup multiTalkGroup) {
        if (!bgl()) {
            x.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            this.ltt = multiTalkGroup;
            this.ltw = 0;
            this.ltp = 1;
            this.ltr.clear();
            bgp();
            sort();
            return true;
        } else if (i.a(multiTalkGroup, this.ltt)) {
            x.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", new Object[]{i.h(multiTalkGroup)});
            MultiTalkGroup multiTalkGroup2 = this.ltt;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.vgq) {
                hashMap.put(multiTalkGroupMember.vgr, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup2.vgq) {
                if (!q.GF().equals(multiTalkGroupMember2.vgr) && q.GF().equals(multiTalkGroupMember2.vgs) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.vgr) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.vgr)).status == 20) {
                        String str = multiTalkGroupMember2.vgr;
                        Toast.makeText(ad.getContext(), j.a(ad.getContext(), ad.getContext().getString(R.l.multitalk_system_busy_exit_msg, new Object[]{r.gT(str)})), 0).show();
                    }
                }
            }
            this.ltt = multiTalkGroup;
            bgp();
            sort();
            return true;
        } else {
            x.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", new Object[]{i.h(this.ltt), i.h(multiTalkGroup)});
            return false;
        }
    }

    private void sort() {
        x.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", new Object[]{this.ltt.vgq});
        List linkedList = new LinkedList();
        Object obj = null;
        for (MultiTalkGroupMember multiTalkGroupMember : this.ltt.vgq) {
            if (multiTalkGroupMember.vgr.equals(q.GF())) {
                obj = multiTalkGroupMember;
            } else {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Collections.sort(linkedList, new 1(this));
        Collections.sort(linkedList, new 7(this));
        Collections.sort(linkedList, new 8(this));
        if (obj != null) {
            linkedList.add(obj);
        }
        this.ltt.vgq = linkedList;
        x.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", new Object[]{this.ltt.vgq});
    }

    private void bgp() {
        for (MultiTalkGroupMember multiTalkGroupMember : this.ltt.vgq) {
            if (multiTalkGroupMember.status != 10 && this.ltr.remove(multiTalkGroupMember.vgr)) {
                x.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", new Object[]{multiTalkGroupMember.vgr});
            }
        }
    }

    public final void b(Activity activity, String str, String str2) {
        String str3 = "MicroMsg.MT.MultiTalkManager";
        String str4 = "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.hEj);
        objArr[1] = Boolean.valueOf(this.ltn);
        objArr[2] = Boolean.valueOf(this.ltq);
        objArr[3] = this.lts.toString();
        objArr[4] = Boolean.valueOf(this.ltt == null);
        x.i(str3, str4, objArr);
        d.bfX();
        if (bgx()) {
            h.i(activity, R.l.in_phone_tip, R.l.app_tip);
        } else if (d.bLS()) {
            h.i(activity, R.l.in_wechat_out_tip, R.l.app_tip);
        } else if (d.bLT()) {
            h.i(activity, R.l.in_voip_tip, R.l.app_tip);
        } else if (com.tencent.mm.ax.e.SA()) {
            h.i(activity, R.l.in_new_share_location_tip, R.l.app_tip);
        } else if (d.bLU()) {
            h.i(activity, R.l.in_voip_cs_tip, R.l.app_tip);
        } else if (bgl()) {
            com.tencent.mm.ax.e.a(activity, R.l.multitalk_exit_tip, null);
        } else if (!this.ltz || System.currentTimeMillis() - this.ltA >= this.ltB) {
            this.ltz = false;
            List<String> F = bi.F(str.split(","));
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.vgn = o.bgM().lta.cEJ();
            multiTalkGroup.vgo = str2;
            for (String str5 : F) {
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.vgr = str5;
                if (str5.equals(q.GF())) {
                    multiTalkGroupMember.status = 10;
                } else {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroup.vgq.add(multiTalkGroupMember);
            }
            o.bgM().lta.bg(bi.f((Integer) au.HS().get(1)), q.GF());
            if (o.bgM().lta.f(multiTalkGroup.vgn, str2, F)) {
                d.bfV();
            } else {
                d.bfW();
            }
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.lvK);
            c(multiTalkGroup);
        } else {
            com.tencent.mm.ax.e.a(activity, R.l.multitalk_overload_fail_tips, null);
        }
    }

    public final void g(boolean z, boolean z2, boolean z3) {
        int i = 4;
        x.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(false), Boolean.valueOf(z3)});
        o.bgN().stopRing();
        if (bgl()) {
            mz mzVar = new mz();
            mzVar.bYb.type = 2;
            com.tencent.mm.sdk.b.a.sFg.m(mzVar);
            String l = i.l(this.ltt);
            d.Hy(l);
            if (this.lts != com.tencent.mm.plugin.multitalk.ui.widget.e.lvM) {
                boolean k = i.k(this.ltt);
                long bgo = bgo();
                if (!k) {
                    i = z2 ? bgo >= 45 ? 6 : 8 : z ? 7 : z3 ? 10 : 0;
                } else if (!z2) {
                    i = z ? 1 : z3 ? 5 : 2;
                }
                d.a(k, bgo, l, i);
            } else {
                d.tg(this.ltw);
                d.n((long) this.ltw, l);
            }
            com.tencent.mm.plugin.multitalk.ui.widget.e eVar = this.lts;
            if (this.ltC != null) {
                this.ltC.bfI();
            }
            this.lts = com.tencent.mm.plugin.multitalk.ui.widget.e.lvI;
            bgw();
            aWS();
            amy();
            o.bgL().reset();
            o.bgO().bgH();
            if (this.ltt != null) {
                a(this.ltt, eVar, z2);
                String str = this.ltt.vgm;
                if (bi.oW(str)) {
                    str = this.ltt.vgn;
                }
                o.bgM().lta.HI(str);
                this.ltt = null;
            }
            this.ltp = 0;
            this.ltn = true;
            this.hEj = false;
            this.ltq = true;
            this.ltv = 0;
            this.ltw = 0;
            this.ltr.clear();
            this.ltx = 0;
            return;
        }
        bgw();
        aWS();
        amy();
        this.ltt = null;
        this.ltp = 0;
        this.ltv = 0;
        this.ltw = 0;
        this.ltr.clear();
        this.lts = com.tencent.mm.plugin.multitalk.ui.widget.e.lvI;
        this.ltx = 0;
    }

    public final void b(String str, String str2, boolean z, boolean z2) {
        if (!m.gB(str)) {
            x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{str});
            am.a.dBr.a(str, "", new 9(this));
        }
        bd bdVar = new bd();
        bdVar.setType(64);
        bdVar.ay(System.currentTimeMillis());
        bdVar.setStatus(6);
        bdVar.eX(2);
        String gT = r.gT(str2);
        if (!(gT == null || gT.equals(""))) {
            str2 = gT;
        }
        gT = str2 + ad.getContext().getString(R.l.multitalk_system_master_start_multi_msg);
        bdVar.setContent(gT);
        if (m.gC(str)) {
            bdVar.ep(str);
            au.HU();
            com.tencent.mm.model.c.FT().T(bdVar);
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(str);
            if (Yq != null) {
                if (z) {
                    Yq.eV(Yq.field_unReadCount + 1);
                }
                Yq.setContent(gT);
                au.HU();
                if (com.tencent.mm.model.c.FW().a(Yq, str) == -1) {
                    x.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :" + str);
                }
                if (z2) {
                    ((ao) au.getNotification()).a(bdVar);
                    return;
                }
                return;
            }
            Yq = new ai();
            Yq.setUsername(str);
            if (z) {
                Yq.eV(1);
            }
            Yq.setContent(gT);
            au.HU();
            com.tencent.mm.model.c.FW().d(Yq);
            if (z2) {
                ((ao) au.getNotification()).a(bdVar);
            }
        }
    }

    public static void Hz(String str) {
        x.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        bd bdVar = new bd();
        bdVar.setType(64);
        bdVar.ay(System.currentTimeMillis());
        bdVar.setStatus(6);
        bdVar.setContent(ad.getContext().getString(R.l.multitalk_system_slave_misscall_exit_msg));
        if (m.gC(str)) {
            bdVar.ep(str);
            bdVar.setContent(bdVar.field_content);
            au.HU();
            com.tencent.mm.model.c.FT().T(bdVar);
        }
    }

    private static void a(MultiTalkGroup multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e eVar, boolean z) {
        x.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.lvJ && z) {
            bd bdVar = new bd();
            bdVar.setType(64);
            bdVar.ay(System.currentTimeMillis());
            bdVar.setStatus(6);
            bdVar.setContent(ad.getContext().getString(R.l.multitalk_system_slave_misscall_exit_msg));
            if (m.gC(multiTalkGroup.vgo)) {
                bdVar.ep(multiTalkGroup.vgo);
                bdVar.setContent(bdVar.field_content);
                au.HU();
                com.tencent.mm.model.c.FT().T(bdVar);
            }
        }
    }

    public final void h(int i, Object obj) {
        int i2;
        x.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", new Object[]{Integer.valueOf(i)});
        au.HU();
        com.tencent.mm.model.c.DT().a(aa.a.sZI, Integer.valueOf(-1));
        au.HU();
        com.tencent.mm.model.c.DT().a(aa.a.sZJ, Long.valueOf(-1));
        switch (i) {
            case -14256:
                x.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                i2 = R.l.multitalk_error_14256;
                if (!(obj == null || ((a$aa) obj) == null)) {
                    com.tencent.wecall.talkroom.model.a.cHu().mT(false);
                    break;
                }
            case -14255:
                String str = "MicroMsg.MT.MultiTalkManager";
                String str2 = "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.ltt;
                objArr[2] = this.ltt != null ? this.ltt.vgo : "";
                x.i(str, str2, objArr);
                if (obj != null) {
                    a$aa a_aa = (a$aa) obj;
                    if (a_aa != null) {
                        x.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + a_aa.groupId);
                        if (a_aa.vcK != null) {
                            o.bgP().HK(a_aa.vcK.vfd);
                            x.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + a_aa.vcK.vfd);
                        }
                        if (!o.bgM().lta.HI(a_aa.groupId)) {
                            x.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + a_aa.groupId);
                        }
                    }
                }
                i2 = R.l.multitalk_system_master_finish_exit_msg;
                break;
            case -1700:
                x.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", new Object[]{obj});
                Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.multitalk_disabled), 0).show();
                if (obj != null) {
                    i2 = ((Integer) obj).intValue();
                    if (i2 > 0) {
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.sZI, Integer.valueOf(i2));
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.sZJ, Long.valueOf(bi.VG()));
                    }
                }
                i2 = R.l.multitalk_disabled;
                break;
            case -1400:
                i2 = R.l.multitalk_error_1400;
                break;
            case -1300:
                i2 = R.l.multitalk_error_1300;
                this.ltz = true;
                this.ltA = System.currentTimeMillis();
                if (obj != null) {
                    z zVar = (z) obj;
                    if (zVar != null) {
                        x.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + zVar.veg);
                        if (zVar.veg != 0) {
                            this.ltB = (long) (zVar.veg * 1000);
                            break;
                        }
                    }
                }
                break;
            case -1200:
                i2 = R.l.multitalk_error_1200;
                break;
            case -1100:
                i2 = R.l.multitalk_error_1100;
                break;
            case -1000:
                i2 = R.l.multitalk_error_1000;
                break;
            case -900:
                i2 = R.l.multitalk_error_900;
                break;
            case -800:
                i2 = R.l.multitalk_error_800;
                break;
            case -700:
                i2 = R.l.multitalk_error_700;
                break;
            case -600:
                i2 = R.l.multitalk_error_600;
                break;
            case -500:
                i2 = R.l.multitalk_error_500;
                break;
            case -401:
                x.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                i2 = R.l.multitalk_network_failed;
                break;
            case -400:
                i2 = R.l.multitalk_error_400;
                break;
            case -300:
                i2 = R.l.multitalk_error_300;
                break;
            case -200:
                d.gI(false);
                i2 = R.l.multitalk_error_200;
                break;
            case -100:
                d.gH(false);
                i2 = R.l.multitalk_error_100;
                break;
            default:
                i2 = R.l.multitalk_error_600;
                break;
        }
        if (this.ltC != null) {
            this.ltC.onError(i);
        }
        if (i != -800 && i != -500 && i != -1700) {
            Toast.makeText(ad.getContext(), ad.getContext().getString(i2), 0).show();
            g(false, false, true);
        }
    }

    public final void b(final MultiTalkGroup multiTalkGroup) {
        String str = "MicroMsg.MT.MultiTalkManager";
        String str2 = "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.hEj);
        objArr[1] = Boolean.valueOf(this.ltn);
        objArr[2] = Boolean.valueOf(this.ltq);
        objArr[3] = this.lts.toString();
        objArr[4] = Boolean.valueOf(this.ltt == null);
        x.i(str, str2, objArr);
        d.bfY();
        if (f.Ak() || dE(ad.getContext())) {
            int i;
            boolean i2;
            str = i.m(multiTalkGroup);
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(str);
            if (g.AT().getInt("MultitalkBlockReceiver", 0) == 0) {
                i2 = 1;
            } else {
                i2 = false;
            }
            if (i2 == 0 || Yg.BA()) {
                x.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
                ah.i(new 11(this, multiTalkGroup), 1000);
                d.au(3, i.l(multiTalkGroup));
                return;
            }
            if (!(bgl() || d.bLT() || d.bLS() || com.tencent.mm.ax.e.SA())) {
                if (((TelephonyManager) ad.getContext().getSystemService("phone")).getCallState() != 0) {
                    i2 = 1;
                } else {
                    i2 = false;
                }
                if (i2 == 0 && !d.bLU() && com.tencent.mm.l.a.gd(Yg.field_type)) {
                    if (!m.gB(multiTalkGroup.vgo)) {
                        x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.vgo});
                        am.a.dBr.a(multiTalkGroup.vgo, "", null);
                    }
                    x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
                    b(com.tencent.mm.plugin.multitalk.ui.widget.e.lvJ);
                    d.au(1, i.l(multiTalkGroup));
                    if (com.tencent.mm.l.a.gd(Yg.field_type)) {
                        x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", new Object[]{str, q.GF()});
                        c(multiTalkGroup);
                        return;
                    }
                    x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", new Object[]{str, q.GF()});
                    if (a(multiTalkGroup)) {
                        this.ltm = false;
                        bgq();
                        YN();
                        return;
                    }
                    return;
                }
            }
            x.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", new Object[]{i.h(multiTalkGroup)});
            if (!m.gB(multiTalkGroup.vgo)) {
                x.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", new Object[]{multiTalkGroup.vgo});
                am.a.dBr.a(multiTalkGroup.vgo, "", new 12(this));
            }
            ah.i(new Runnable() {
                public final void run() {
                    String str = multiTalkGroup.vgm;
                    if (bi.oW(str)) {
                        str = multiTalkGroup.vgn;
                    }
                    o.bgM().lta.HI(str);
                }
            }, 1000);
            d.au(3, i.l(multiTalkGroup));
            return;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.ltF == null && this.ltH.ciq()) {
            this.ltF = multiTalkGroup;
            this.ltH.J(2000, 2000);
            this.ltG = System.currentTimeMillis();
            com.tencent.mm.plugin.report.service.h.mEJ.a(500, 6, 1, false);
        }
    }

    private void c(MultiTalkGroup multiTalkGroup) {
        x.l("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
        if (a(multiTalkGroup)) {
            this.ltm = false;
            bgq();
            YN();
            com.tencent.mm.bg.d.b(ad.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        }
    }

    private void bgq() {
        e eVar;
        boolean z;
        e eVar2;
        if (this.lts == com.tencent.mm.plugin.multitalk.ui.widget.e.lvK) {
            eVar = this;
        } else if (au.HV().yK() || au.HV().yE()) {
            eVar = this;
        } else {
            z = true;
            eVar2 = this;
            eVar2.ltn = z;
            this.hEj = false;
            this.ltD = i.bgF();
        }
        z = false;
        eVar2 = eVar;
        eVar2.ltn = z;
        this.hEj = false;
        this.ltD = i.bgF();
    }

    public final void d(MultiTalkGroup multiTalkGroup) {
        d.au(2, i.l(multiTalkGroup));
        a(multiTalkGroup, com.tencent.mm.plugin.multitalk.ui.widget.e.lvJ, true);
    }

    public final void e(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        d.gH(true);
        if (a(multiTalkGroup)) {
            bgr();
        }
    }

    public final void f(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", new Object[]{i.h(multiTalkGroup)});
        mz mzVar = new mz();
        mzVar.bYb.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(mzVar);
        d.gI(true);
        if (this.lts != com.tencent.mm.plugin.multitalk.ui.widget.e.lvJ) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.lvL);
            c(multiTalkGroup);
        }
        if (bgl() && a(multiTalkGroup)) {
            bgr();
        }
    }

    private void bgr() {
        if (i.i(this.ltt)) {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.lvM);
        } else {
            b(com.tencent.mm.plugin.multitalk.ui.widget.e.lvL);
        }
        if (this.ltC != null) {
            this.ltC.bcI();
            i.a bgF = i.bgF();
            if (bgF != this.ltD) {
                this.ltD = bgF;
                return;
            }
            return;
        }
        com.tencent.mm.bg.d.b(ad.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        x.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", new Object[]{i.h(multiTalkGroup)});
        if (!bgl() || !a(multiTalkGroup)) {
            return;
        }
        if (i.j(this.ltt)) {
            if (this.lts != com.tencent.mm.plugin.multitalk.ui.widget.e.lvM && i.i(multiTalkGroup)) {
                b(com.tencent.mm.plugin.multitalk.ui.widget.e.lvM);
            }
            if (this.ltC != null && i.c(this.lts)) {
                this.ltC.bfJ();
            }
        } else if (this.lts == com.tencent.mm.plugin.multitalk.ui.widget.e.lvJ) {
            g(false, true, false);
        } else {
            g(false, false, false);
        }
    }

    public final void bgs() {
        x.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
    }

    public final void gD(boolean z) {
        this.hEj = z;
        if (this.ltC != null) {
            this.ltC.gD(this.hEj);
        }
    }

    public final void bgt() {
        x.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", new Object[]{Integer.valueOf(this.ltp)});
    }

    public final void bgu() {
        x.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
    }

    public final void th(int i) {
        x.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: " + i);
        if (i > 0) {
            this.ltE = true;
        } else {
            this.ltE = false;
        }
    }

    public final void bB(List<com.tencent.pb.common.b.a.a.am> list) {
        if (bgl()) {
            this.ltr.clear();
            x.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", new Object[]{list});
            for (com.tencent.pb.common.b.a.a.am amVar : list) {
                if (amVar.veA == 2 || amVar.veA == 3) {
                    this.ltr.add(amVar.vez);
                }
            }
            this.ltr.remove(q.GF());
            x.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", new Object[]{this.ltr});
            if (this.ltu != null) {
                this.ltu.tl(this.ltr.size());
            }
            if (this.ltC != null) {
                this.ltC.bfK();
            }
        }
    }

    public final void gJ(boolean z) {
        if (bgl() && !this.knY) {
            this.knY = true;
            d.f(i.bgC(), o.bgN().bgj(), z);
            Toast.makeText(ad.getContext(), R.l.multitalk_mini_toast, 0).show();
            CharSequence string = ad.getContext().getString(R.l.multitalk);
            CharSequence string2 = ad.getContext().getString(R.l.multitalk_recover);
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(ad.getContext(), 43, intent, 134217728);
            int i = R.g.notification_icon_gray;
            if (com.tencent.mm.compatible.util.d.fS(19)) {
                i = R.g.notification_icon;
            }
            Notification a = d.a(new Builder(ad.getContext()).setTicker(string2).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(string2).setContentIntent(activity));
            a.icon = i;
            a.flags |= 32;
            au.getNotification().a(43, a, false);
            if (this.ltC != null) {
                this.ltC.aWY();
            }
            ah.A(new 14(this));
        }
    }

    public final void aWS() {
        this.knY = false;
        com.tencent.mm.plugin.voip.model.i.bJJ().dismiss();
        ((NotificationManager) ad.getContext().getSystemService("notification")).cancel(43);
    }

    public final void bgv() {
        x.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
        if (this.ltC == null) {
            x.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
        } else if (this.ltr.size() == 0) {
            x.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
        } else {
            if (this.ltu == null) {
                x.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", new Object[]{Integer.valueOf(this.ltr.size())});
                this.ltu = new k(this.ltC);
                this.ltu.tl(this.ltr.size());
            }
            if (!this.ltu.bFi) {
                this.ltu.start();
            }
        }
    }

    public final void bgw() {
        x.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
        if (this.ltu != null) {
            this.ltu.stop();
            this.ltu = null;
        }
    }

    public final void gK(boolean z) {
        o.bgM().lta.gK(z);
        x.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", new Object[]{Boolean.valueOf(z)});
        this.ltn = z;
        if (this.ltC != null) {
            this.ltC.gE(this.ltn);
        }
    }

    public final boolean ti(int i) {
        if (!bgm()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + i);
        boolean ti = o.bgM().lta.ti(i);
        x.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", new Object[]{Boolean.valueOf(ti)});
        int i2 = this.ltp;
        this.ltp = i;
        if (bgk()) {
            bgv();
        } else {
            bgw();
        }
        if (this.ltC == null || i2 == this.ltp) {
            return ti;
        }
        this.ltC.cT(i2, this.ltp);
        return ti;
    }

    public final boolean HA(String str) {
        if (!bgm()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : " + str);
        boolean HA = o.bgM().lta.HA(str);
        x.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: " + HA);
        return HA;
    }

    private void b(com.tencent.mm.plugin.multitalk.ui.widget.e eVar) {
        boolean z = true;
        com.tencent.mm.plugin.multitalk.ui.widget.e eVar2 = this.lts;
        this.lts = eVar;
        if (eVar2 != eVar) {
            if (eVar == com.tencent.mm.plugin.multitalk.ui.widget.e.lvM) {
                mz mzVar = new mz();
                mzVar.bYb.type = 1;
                com.tencent.mm.sdk.b.a.sFg.m(mzVar);
                d.a(i.k(this.ltt), bgo(), i.l(this.ltt));
                o.bgN().stopRing();
                if (au.HV().yK() || au.HV().yE()) {
                    z = false;
                }
                gK(z);
            }
            if (this.ltC != null) {
                this.ltC.a(eVar);
            }
        }
    }

    private void YN() {
        x.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
        if (this.gei != null) {
            this.gei.cancel();
            return;
        }
        this.ltv = System.currentTimeMillis();
        this.ltw = 0;
        this.gei = new Timer();
        this.gei.schedule(new 3(this), 1000, 1000);
    }

    private void amy() {
        if (this.gei != null) {
            this.gei.cancel();
            this.gei = null;
        }
    }

    public final void gL(boolean z) {
        if (!this.ltm) {
            this.koX.n(R.k.phonering, 0, z);
            this.epT.requestFocus();
            this.ltm = true;
        }
    }

    public final void stopRing() {
        com.tencent.mm.sdk.f.e.post(new 5(this), "MultiTalkManager_stop_ring");
    }

    private static boolean bgx() {
        Exception e;
        boolean z;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            switch (telephonyManager.getCallState()) {
                case 0:
                    z = false;
                    break;
                case 1:
                case 2:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            try {
                x.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            x.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }

    static boolean dE(Context context) {
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            x.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                x.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
                return false;
            }
        }
        if (((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
        return true;
    }

    public final void gF(boolean z) {
        if (o.bgN().bgm() && this.ltC != null) {
            x.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", new Object[]{Boolean.valueOf(z)});
            this.ltC.gF(z);
        }
    }
}
