package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Looper;
import android.os.Vibrator;
import android.widget.Toast;
import com.eclipsesource.v8.BuildConfig;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.ab.i.a;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.su;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.aa;
import com.tencent.mm.ui.chatting.b.b.ac;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.x;
import com.tencent.mm.ui.chatting.b.b.y;
import com.tencent.mm.ui.tools.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p implements b {
    public static boolean tJa = true;
    private final al erD = new al(new 8(this), true);
    private ab guS;
    private final a hnC = new 1(this);
    private ToneGenerator hnf;
    private Vibrator hni;
    private final al hnz = new al(new 9(this), true);
    private ChatFooter laA;
    private final i.b laF = new 4(this);
    private AppPanel.a lbl = new 10(this);
    private Object lock = new Object();
    private boolean tGg;
    private i tJb;
    private String tJc;
    private String tJd;
    private boolean tJe;
    private boolean tJf;
    public boolean tJg;
    com.tencent.mm.ui.chatting.c.a tJh;
    private volatile boolean tJi = false;
    private volatile boolean tJj = false;
    private boolean tJk = false;

    static /* synthetic */ void a(p pVar, com.tencent.mm.ui.chatting.c.a aVar, int i, Intent intent) {
        if (i == -1 && intent != null) {
            String str;
            ((x) aVar.O(x.class)).f(217, i, intent);
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            int gK = aVar.cwr() ? m.gK(pVar.tJc) : 0;
            Iterator it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                WXFileObject wXFileObject = new WXFileObject();
                wXFileObject.setFilePath(str2);
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXFileObject;
                File file = new File(str2);
                wXMediaMessage.title = file.getName();
                wXMediaMessage.description = bi.bF(file.length());
                l.a(wXMediaMessage, "", "", pVar.tJc, 4, null);
                int lastIndexOf = file.getName().lastIndexOf(".");
                str = "";
                if (lastIndexOf >= 0 && lastIndexOf < file.getName().length() - 1) {
                    str = file.getName().substring(lastIndexOf + 1);
                }
                h hVar = h.mEJ;
                Object[] objArr = new Object[5];
                objArr[0] = Long.valueOf(file.length());
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(aVar.cwr() ? 1 : 0);
                objArr[3] = Integer.valueOf(gK);
                objArr[4] = str;
                hVar.h(14986, objArr);
            }
            str = intent.getStringExtra("with_text_content");
            if (!bi.oW(str)) {
                g.bcT().dF(str, pVar.tJc);
            }
        }
    }

    static /* synthetic */ void i(p pVar) {
        pVar.tJh.tTq.enableOptionMenu(false);
        pVar.tJh.tTq.enableBackMenu(false);
        if (pVar.tJb != null) {
            af.Wp("keep_app_silent");
            pVar.laA.setRecordNormalWording(pVar.tJh.tTq.getMMResources().getString(R.l.chatfooter_cancel_rcd));
            pVar.tJb.dd(pVar.getTalkerUserName());
            pVar.tJd = pVar.tJb.getFileName();
            pVar.tJb.a(pVar.laF);
            pVar.hni.vibrate(50);
            pVar.tJh.avj();
            pVar.ctl();
            pVar.tJb.a(pVar.hnC);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
    }

    public p(com.tencent.mm.ui.chatting.c.a aVar, ChatFooter chatFooter, String str) {
        this.tJh = aVar;
        this.laA = chatFooter;
        this.tJc = str;
        au.HU();
        this.guS = c.FR().Yg(str);
        this.tJe = this.tJh.getTalkerUserName().endsWith("@chatroom");
        this.tJf = s.ha(this.tJh.getTalkerUserName());
        boolean z = this.tJe || this.tJf;
        this.tGg = z;
        this.hni = (Vibrator) this.tJh.tTq.getContext().getSystemService("vibrator");
        if (s.hB(this.tJc)) {
            this.tJb = new com.tencent.mm.plugin.subapp.c.i();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
        } else {
            String str2 = this.tJc;
            if (s.hM(str2)) {
                z = true;
            } else {
                ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(str2);
                if (Yg != null && Yg.ckW()) {
                    d kH = f.kH(Yg.field_username);
                    if (kH != null) {
                        d.b bG = kH.bG(false);
                        if (bG != null) {
                            if (bG.dKT != null) {
                                bG.dKX = "1".equals(bG.dKT.optString("CanReceiveSpeexVoice"));
                            }
                            if (bG.dKX) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + Yg.field_username + " canReceiveSpeexVoice");
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (z) {
                this.tJb = new com.tencent.mm.e.b.h(this.tJh.tTq.getContext(), true);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
            } else {
                this.tJb = new com.tencent.mm.e.b.h(this.tJh.tTq.getContext(), false);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
            }
        }
        this.tJb.a(this.laF);
        this.tJb.a(this.hnC);
        chatFooter.setAppPanelListener(this.lbl);
    }

    public final boolean bcq() {
        synchronized (this.lock) {
            this.tJi = true;
        }
        if (this.tJj) {
            this.tJj = false;
            releaseWakeLock();
            if (ctm()) {
                this.laA.aMo();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
            } else {
                this.laA.cen();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
            }
            ((ag) this.tJh.O(ag.class)).cwl().csM();
            ((y) this.tJh.O(y.class)).Fe(4);
            ((y) this.tJh.O(y.class)).stopSignalling();
            EM(1);
            ((ag) this.tJh.O(ag.class)).a(this.tJh.tTq, false);
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean bcs() {
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
        synchronized (this.lock) {
            this.tJi = true;
        }
        if (this.tJj) {
            this.tJj = false;
            releaseWakeLock();
            this.tJh.tTq.enableOptionMenu(true);
            this.tJh.tTq.enableBackMenu(true);
            if (this.tJb != null) {
                this.tJb.cancel();
                this.erD.SO();
                this.hnz.SO();
            }
            this.laA.aMo();
            ((ag) this.tJh.O(ag.class)).cwl().csM();
            ((y) this.tJh.O(y.class)).Fe(4);
            ((y) this.tJh.O(y.class)).stopSignalling();
            EM(1);
            ((ag) this.tJh.O(ag.class)).a(this.tJh.tTq, false);
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean bct() {
        if (com.tencent.mm.p.a.by(this.tJh.tTq.getContext()) || com.tencent.mm.p.a.bw(this.tJh.tTq.getContext())) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingFooterEventImpl", "voip is running, cann't record voice");
            return false;
        }
        au.HU();
        if (c.isSDCardAvailable()) {
            if (!com.tencent.mm.compatible.f.b.zT()) {
                com.tencent.mm.ui.base.h.a(this.tJh.tTq.getContext(), this.tJh.tTq.getMMResources().getString(R.l.app_special_no_record_audio_permission), this.tJh.tTq.getMMResources().getString(R.l.app_need_audio_title), this.tJh.tTq.getMMResources().getString(R.l.app_need_show_settings_button), true, new 5(this));
            }
            if (this.tJb != null) {
                if (this.hnf == null) {
                    try {
                        this.hnf = new ToneGenerator(3, (int) ((((float) this.tJh.tTq.getStreamMaxVolume(3)) / ((float) this.tJh.tTq.getStreamVolume(3))) * 100.0f));
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "init tone");
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "init tone failed");
                    }
                }
                if (this.hnf != null) {
                    this.hnf.startTone(24);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "start tone");
                }
                this.tJh.getListView().postDelayed(new 7(this), 200);
            }
            synchronized (this.lock) {
                this.tJi = false;
            }
            new com.tencent.mm.sdk.platformtools.ag(Looper.myLooper()).postDelayed(new 6(this), 200);
            return true;
        }
        com.tencent.mm.ui.base.s.gH(this.tJh.tTq.getContext());
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        return false;
    }

    public final boolean Gk(String str) {
        ctl();
        ctk();
        return ((aa) this.tJh.O(aa.class)).aaq(str);
    }

    public final void bcu() {
        ctl();
        ctk();
    }

    public final void bcv() {
        ctl();
        ctk();
    }

    public final void bcw() {
        ctl();
        ctk();
    }

    private void ctk() {
        com.tencent.mm.ui.chatting.c.a aVar = this.tJh;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
        aVar.tTr.ctY();
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    private void ctl() {
        com.tencent.mm.ui.chatting.c.a aVar = this.tJh;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", new Object[]{Boolean.valueOf(true)});
        aVar.tTr.Y(true, true);
    }

    private void releaseWakeLock() {
        this.tJh.setKeepScreenOn(false);
    }

    private boolean ctm() {
        this.tJh.tTq.enableOptionMenu(true);
        this.tJh.tTq.enableBackMenu(true);
        if (this.tJb != null) {
            boolean z;
            boolean wk;
            if (this.tJb.isRecording()) {
                z = this.guS.field_username.equals("medianote") && (q.GJ() & 16384) == 0;
                if (z) {
                    z = true;
                    wk = this.tJb.wk();
                    this.erD.SO();
                    this.hnz.SO();
                    if (z) {
                        bd bdVar = new bd();
                        bdVar.ep("medianote");
                        bdVar.setType(34);
                        bdVar.eX(1);
                        bdVar.eq(this.tJd);
                        bdVar.setStatus(2);
                        bdVar.setContent(n.b(q.GF(), (long) this.tJb.wt(), false));
                        bdVar.ay(com.tencent.mm.model.bd.iD("medianote"));
                        if (this.tJb.ww() == 2) {
                            bdVar.dt("SOURCE_SILK_FILE");
                        }
                        au.HU();
                        long T = c.FT().T(bdVar);
                        if (T <= 0) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                        } else {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + T);
                        }
                    }
                    af.Wq("keep_app_silent");
                    return wk;
                }
            }
            z = false;
            wk = this.tJb.wk();
            this.erD.SO();
            this.hnz.SO();
            if (z) {
                bd bdVar2 = new bd();
                bdVar2.ep("medianote");
                bdVar2.setType(34);
                bdVar2.eX(1);
                bdVar2.eq(this.tJd);
                bdVar2.setStatus(2);
                bdVar2.setContent(n.b(q.GF(), (long) this.tJb.wt(), false));
                bdVar2.ay(com.tencent.mm.model.bd.iD("medianote"));
                if (this.tJb.ww() == 2) {
                    bdVar2.dt("SOURCE_SILK_FILE");
                }
                au.HU();
                long T2 = c.FT().T(bdVar2);
                if (T2 <= 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + T2);
                }
            }
            af.Wq("keep_app_silent");
            return wk;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
        return false;
    }

    public final String getTalkerUserName() {
        if (this.guS == null || !ab.gY(this.guS.field_username)) {
            return this.guS == null ? null : this.guS.field_username;
        } else {
            return this.tJc;
        }
    }

    public final void release() {
        if (this.hnf != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", BuildConfig.BUILD_TYPE);
            this.hnf.release();
            this.hnf = null;
        }
    }

    public final void onPause() {
        if (this.hnf != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", BuildConfig.BUILD_TYPE);
            this.hnf.release();
            this.hnf = null;
        }
        ctm();
        this.erD.SO();
        this.hnz.SO();
    }

    public final void gq(boolean z) {
        if (z) {
            ((y) this.tJh.O(y.class)).keepSignalling();
        } else {
            ((y) this.tJh.O(y.class)).stopSignalling();
        }
    }

    private static void EM(int i) {
        mx mxVar = new mx();
        mxVar.bXZ.state = i;
        com.tencent.mm.sdk.b.a.sFg.m(mxVar);
    }

    public final void ctn() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 22, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 22, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 22, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
            if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 22, "", "")) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
                Intent intent = new Intent();
                if (com.tencent.mm.ay.d.elh.nt(getTalkerUserName())) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
                    Toast.makeText(ad.getContext(), R.l.in_share_location_tip, 0).show();
                    return;
                }
                if (getTalkerUserName() != null) {
                    boolean z;
                    List<String> HE = o.a.qyi.HE(getTalkerUserName());
                    au.HU();
                    String str = (String) c.DT().get(2, null);
                    boolean HC = o.a.qyi.HC(getTalkerUserName());
                    for (String str2 : HE) {
                        if (str != null && str.equals(str2)) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (HE.size() < 9 || z) {
                        if (z) {
                            if (o.a.qyi.bgl()) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
                                Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.multitalk_exit_tip), 0).show();
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
                        }
                        if (o.a.qyi.bgA()) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
                            Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.multitalk_exit_tip), 0).show();
                            return;
                        } else if (HC) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
                            com.tencent.mm.ui.base.h.a(this.tJh.tTq.getContext(), this.tJh.tTq.getMMResources().getString(R.l.multitalk_talking_chose_enter), "", this.tJh.tTq.getMMResources().getString(R.l.multitalk_enter), this.tJh.tTq.getMMResources().getString(R.l.multitalk_cancel), new 11(this), null);
                            return;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
                    Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.multitalk_members_reach_max_limit, new Object[]{Integer.valueOf(9)}), 0).show();
                    return;
                }
                intent.putExtra("chatroomName", getTalkerUserName());
                intent.putExtra("key_need_gallery", true);
                intent.putExtra("titile", this.tJh.tTq.getMMResources().getString(R.l.multitalk_select_contact));
                com.tencent.mm.bg.d.b(this.tJh.tTq.getContext(), "multitalk", ".ui.MultiTalkSelectContactUI", intent);
            }
        }
    }

    public final void EN(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 18, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 18, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 18, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
            if (!com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 18, "", "")) {
                return;
            }
            if (com.tencent.mm.sdk.a.b.chp() || com.tencent.mm.platformtools.af.eyf) {
                k kVar = new k(this.tJh.tTq.getContext());
                kVar.ofp = new 2(this);
                kVar.ofq = new 3(this, i);
                kVar.bEo();
            } else if (!com.tencent.mm.platformtools.af.eyg) {
                h.mEJ.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                com.tencent.mm.pluginsdk.ui.tools.l.a(this.tJh.tTq, new Intent(), getTalkerUserName(), i);
            }
        }
    }

    public final void cto() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 83, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 83, "", "")) {
            if (this.laA.ceI()) {
                this.laA.setBottomPanelVisibility(8);
            }
            su suVar = new su();
            suVar.cdE.bOh = 5;
            suVar.cdE.talker = getTalkerUserName();
            suVar.cdE.context = this.tJh.tTq.getContext();
            suVar.cdE.cdz = 3;
            com.tencent.mm.sdk.b.a.sFg.m(suVar);
            h.mEJ.h(11033, new Object[]{Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0)});
        }
    }

    public final void ctp() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 21, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 21, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 21, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
            if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 21, "", "")) {
                if (this.laA.ceI()) {
                    this.laA.setBottomPanelVisibility(8);
                }
                su suVar = new su();
                suVar.cdE.bOh = 5;
                suVar.cdE.talker = getTalkerUserName();
                suVar.cdE.context = this.tJh.tTq.getContext();
                suVar.cdE.cdz = 2;
                com.tencent.mm.sdk.b.a.sFg.m(suVar);
            }
        }
    }

    public final void bny() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 82, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 82, "", "")) {
            su suVar = new su();
            suVar.cdE.bOh = 5;
            suVar.cdE.talker = getTalkerUserName();
            suVar.cdE.context = this.tJh.tTq.getContext();
            suVar.cdE.cdz = 4;
            if (this.laA.ceI()) {
                this.laA.setBottomPanelVisibility(8);
            }
            com.tencent.mm.sdk.b.a.sFg.m(suVar);
        }
    }

    public final void bnz() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 19, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.CAMERA", 19, "", "")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 19, "", "")), bi.cjd(), this.tJh.tTq.getContext()});
            if (com.tencent.mm.pluginsdk.permission.a.a(this.tJh.tTq.getContext(), "android.permission.RECORD_AUDIO", 19, "", "")) {
                su suVar = new su();
                suVar.cdE.bOh = 5;
                suVar.cdE.talker = getTalkerUserName();
                suVar.cdE.context = this.tJh.tTq.getContext();
                suVar.cdE.cdz = 2;
                if (this.laA.ceI()) {
                    this.laA.setBottomPanelVisibility(8);
                }
                com.tencent.mm.sdk.b.a.sFg.m(suVar);
            }
        }
    }

    public final void ctq() {
        ((ac) this.tJh.O(ac.class)).lX(false);
        this.laA.setBottomPanelVisibility(8);
    }

    public final void ctr() {
        if (!com.tencent.mm.pluginsdk.ui.tools.l.a(this.tJh.tTq, e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText(this.tJh.tTq.getContext(), this.tJh.tTq.getMMResources().getString(R.l.selectcameraapp_none), 1).show();
        }
    }
}
