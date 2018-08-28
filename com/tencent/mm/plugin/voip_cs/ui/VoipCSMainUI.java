package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ax.e;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver$a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.pb.common.c.g;
import java.util.Arrays;

@a(3)
public class VoipCSMainUI extends MMActivity implements com.tencent.mm.plugin.voip_cs.b.a, com.tencent.mm.plugin.voip_cs.b.b.a.a {
    private String appId = "";
    private b bEL;
    public String bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_video);
    public String buF = "";
    private ag dvh;
    public String eTp = "";
    private TelephonyManager knT;
    PhoneStateListener knU = new 5(this);
    private n mHI = new 10(this);
    private HeadsetPlugReceiver oLM = null;
    private HeadsetPlugReceiver$a oMA = new 3(this);
    private BroadcastReceiver oMz = new 4(this);
    public String oXt = "";
    private com.tencent.mm.plugin.voip_cs.b.a.a oXz;
    private com.tencent.mm.plugin.voip_cs.b.a.b oYd;
    private c oYe;
    private boolean oYf = false;
    public String oYg = "";
    public String oYh = "";
    public String oYi = "";
    public boolean oYj = false;
    private al oYk = new al(Looper.getMainLooper(), new 18(this), true);
    f.a oYl = new 2(this);
    public CharSequence tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_video);
    public CharSequence title = ad.getContext().getString(R.l.voip_cs_func_name_appbrand_video);
    public String type = "";

    public void onCreate(Bundle bundle) {
        boolean z;
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onCreate voipcs....");
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.oXt = getIntent().getStringExtra("voipCSBizId");
        this.appId = getIntent().getStringExtra("voipCSAppId");
        this.buF = bi.oV(getIntent().getStringExtra("voipCSScene"));
        this.type = bi.oV(getIntent().getStringExtra("voipCSType"));
        this.oYg = getIntent().getStringExtra("voipCSAllowBackCamera");
        this.oYh = getIntent().getStringExtra("voipCSShowOther");
        this.eTp = getIntent().getStringExtra("voipCSAvatarUrl");
        this.oYi = getIntent().getStringExtra("voipCSContext");
        this.oYj = getIntent().getBooleanExtra("launch_from_appbrand", false);
        getWindow().addFlags(6946944);
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        this.dvh = new ag();
        com.tencent.mm.plugin.voip_cs.b.c bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        x.d("MicroMsg.VoipCSReportHelper", "reset");
        bMx.bjS = 0;
        bMx.oWu = 0;
        bMx.oWv = 0;
        bMx.oWw = 0;
        bMx.videoFps = 0;
        bMx.oWx = 0;
        bMx.oWy = 0;
        bMx.oWz = 0;
        bMx.oWA = 0;
        bMx.oWB = 0;
        bMx.oWC = 0;
        bMx.networkType = 0;
        bMx.oWD = 0;
        bMx.oWE = com.tencent.mm.plugin.voip_cs.b.c.oWr;
        bMx.oWF = 0;
        bMx.oWG = 0;
        bMx.kpp = 0;
        bMx.oWH = "";
        bMx.oOj = 0;
        bMx.oWK = 0;
        bMx.oWL = 0;
        bMx.oWM = 0;
        bMx.oOC = 0;
        bMx.oOB = 0;
        bMx.oWN = 0;
        bMx.oWO = 0;
        bMx.oWP = 0;
        bMx.oWQ = 0;
        bMx.oWR = 0;
        bMx.oWS = 0;
        bMx.oWT = 0;
        bMx.oWU = 0;
        bMx.oWV = 0;
        bMx.oWW = 0;
        bMx.oWX = 0;
        bMx.kqM = 0;
        bMx.oWY = 0;
        bMx.oWZ = 0;
        bMx.channelStrategy = 1;
        bMx.oPR = 0;
        bMx.oOD = 0;
        bMx.oXa = 0;
        bMx.oXb = 0;
        bMx.kqW = "";
        bMx.kqV = "";
        bMx.oXf = 0;
        bMx.oXg = 0;
        bMx.oXh = 0;
        bMx.oXi = 0;
        bMx.oXj = 0;
        this.knT = (TelephonyManager) ad.getContext().getSystemService("phone");
        com.tencent.mm.plugin.voip_cs.b.b.bMw().oXt = this.oXt;
        this.oYd = new com.tencent.mm.plugin.voip_cs.b.a.b(this);
        this.oYe = new c();
        this.bEL = new b(ad.getContext());
        this.oXz = com.tencent.mm.plugin.voip_cs.b.a.a.bMC();
        com.tencent.mm.plugin.voip_cs.b.b.bMv().oYb = this;
        com.tencent.mm.plugin.voip_cs.b.b.bMw().oXl = this;
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs == 0 || com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs == 3) {
            com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs = 0;
        }
        au.vv().xv();
        this.bEL.requestFocus();
        au.HV().yB();
        au.HV().a(this.oYl);
        this.oLM = new HeadsetPlugReceiver();
        this.oLM.a(ad.getContext(), this.oMA);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        ad.getContext().registerReceiver(this.oMz, intentFilter);
        au.a(this.mHI);
        if (this.oYj) {
            if (this.buF.equals("1")) {
                if (this.type.equals("video")) {
                    this.title = ad.getContext().getString(R.l.voip_cs_func_name);
                    this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording);
                    this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording);
                } else {
                    this.title = ad.getContext().getString(R.l.voip_cs_func_name_appbrand_audio);
                    this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording_appbrand_audio);
                    this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording_appbrand_audio);
                }
            } else if (this.type.equals("video")) {
                this.title = ad.getContext().getString(R.l.voip_cs_func_name_appbrand_video);
                this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording_appbrand_video);
                this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording_appbrand_video);
            } else {
                this.title = ad.getContext().getString(R.l.voip_cs_func_name_appbrand_audio);
                this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording_appbrand_audio);
                this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording_appbrand_audio);
            }
        } else if (this.buF.equals("1")) {
            if (this.type.equals("video")) {
                this.title = ad.getContext().getString(R.l.voip_cs_func_name);
                this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording);
                this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording);
            } else {
                this.title = ad.getContext().getString(R.l.voip_cs_func_name_appbrand_audio);
                this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_video);
                this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_video);
            }
        } else if (this.type.equals("video")) {
            this.title = ad.getContext().getString(R.l.voip_cs_func_name_appbrand_video);
            this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_video);
            this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_video);
        } else {
            this.title = ad.getContext().getString(R.l.voip_cs_func_name_appbrand_audio);
            this.tickerText = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_audio);
            this.bSc = ad.getContext().getString(R.l.voip_cs_minimize_wording_mp_audio);
        }
        int callState = this.knT.getCallState();
        if (callState == 2 || callState == 1) {
            x.i("MicroMsg.voipcs.VoipCSMainUI", "check is phone use now ! TelephoneManager.callState is %d", new Object[]{Integer.valueOf(callState)});
            h.a(this, R.l.voip_cs_phone_in_use, R.l.app_tip, new 1(this));
            z = true;
        } else {
            z = false;
        }
        if (z) {
            x.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in telephone talking!");
            return;
        }
        this.knT.listen(this.knU, 32);
        if (!ao.isNetworkConnected(this)) {
            x.e("MicroMsg.voipcs.VoipCSMainUI", "isNetworkAvailable false, not connected!cannot start voip cs!");
            h.a(this, R.l.voip_cs_net_unavailable, R.l.voip_not_wifi_warnning_title, new 15(this));
            z = false;
        } else if (ao.isWifi(this) || q.bKO()) {
            z = true;
        } else {
            x.i("MicroMsg.voipcs.VoipCSMainUI", "check is not wifi network!");
            h.a(this, R.l.voip_cs_not_wifi_warnning_message, R.l.voip_not_wifi_warnning_title, new 16(this), new 17(this));
            z = false;
        }
        if (z) {
            if (d.bLT()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check  is voip talking now!");
                h.a(this, R.l.in_voip_tip, R.l.app_tip, new 11(this));
                callState = 1;
            } else if (d.bLS()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check is ipCall talking now!");
                h.a(this, R.l.in_wechat_out_tip, R.l.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.yZ(0);
                    }
                });
                callState = 1;
            } else if (com.tencent.mm.p.a.BQ()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check is multiTalking  now!");
                h.a(this, R.l.in_multitalk_tip, R.l.app_tip, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        VoipCSMainUI.this.yZ(0);
                    }
                });
                callState = 1;
            } else if (e.SA()) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "check is in talktRoom  now!");
                h.a(this, R.l.in_new_share_location_tip, R.l.app_tip, new 14(this));
                callState = 1;
            } else {
                z = false;
            }
            if (callState != 0) {
                x.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in other voip talking!");
                return;
            } else if (bMN()) {
                bMM();
                return;
            } else {
                return;
            }
        }
        x.i("MicroMsg.voipcs.VoipCSMainUI", "can not start voip cs  by in  voip talking!");
    }

    private void bMM() {
        int init;
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs <= 0) {
            long j;
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.oYd;
            if (bVar.oXR.ciq()) {
                j = (long) bVar.oXM;
                bVar.oXR.J(j, j);
            }
            bVar = this.oYd;
            if (bVar.oXS.ciq()) {
                j = (long) bVar.oXN;
                bVar.oXS.J(j, j);
            }
            com.tencent.mm.plugin.voip_cs.b.b.a bMv = com.tencent.mm.plugin.voip_cs.b.b.bMv();
            bMv.kqA = false;
            bMv.kqz = false;
            if (bMv.kqx.lkO) {
                x.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
                bMv.kqx.iT(false);
                bMv.kqx.reset();
            }
            bMv.kqx.oOk = 1;
            long currentTimeMillis = System.currentTimeMillis();
            v2protocal v2protocal = bMv.kqx;
            v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
            v2protocal.oOj = v2protocal.netType;
            com.tencent.mm.plugin.voip_cs.b.b.bMx().oOj = v2protocal.netType;
            if (v2protocal.netType == 5) {
                v2protocal.netType = 4;
            }
            boolean z = v2protocal.oOj >= 4 && (v2protocal.ovW & 1024) != 0 && (v2protocal.ovW & 255) >= 30;
            boolean z2 = com.tencent.mm.compatible.e.q.deM.ddl == 1 && com.tencent.mm.compatible.e.q.deM.dcN.width >= 480 && com.tencent.mm.compatible.e.q.deM.dcN.height >= 360 && com.tencent.mm.compatible.e.q.deM.dcP.width >= 480 && com.tencent.mm.compatible.e.q.deM.dcP.height >= 360;
            boolean z3 = com.tencent.mm.compatible.e.q.deM.ddl == 0;
            if ((z || z2) && !z3) {
                v2protocal.defaultWidth = 480;
                v2protocal.defaultHeight = 360;
                v2protocal.oOg = true;
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip", "steve:Set Enable 480! " + v2protocal.defaultWidth + "x" + v2protocal.defaultHeight);
            }
            com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip", "steve: Android CPUFlag:" + (v2protocal.ovW & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z + ", bEnable480FromSvr:" + z2 + ", bDisable480FromSvr:" + z3);
            v2protocal.oPf = new int[(v2protocal.defaultWidth * v2protocal.defaultHeight)];
            au.HU();
            v2protocal.oOi = com.tencent.mm.model.c.Df();
            if ((v2protocal.ovW & 1024) != 0) {
                com.tencent.mm.compatible.loader.d.y(ad.getContext(), "libvoipCodec_v7a.so");
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
            } else if ((v2protocal.ovW & 512) != 0) {
                com.tencent.mm.compatible.loader.d.y(ad.getContext(), "libvoipCodec.so");
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
            } else {
                com.tencent.mm.compatible.loader.d.y(ad.getContext(), "libvoipCodec_v5.so");
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
            }
            int i = VERSION.SDK_INT;
            int bMg = OpenGlRender.bMg();
            Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
            init = v2protocal.init(v2protocal.netType, 2, (v2protocal.defaultWidth << 16) | v2protocal.defaultHeight, (defaultDisplay.getWidth() << 16) | defaultDisplay.getHeight(), v2protocal.oOi, ((i << 16) | (bMg << 24)) | v2protocal.ovW, com.tencent.mm.compatible.util.e.duM + "app_lib/", 8);
            com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + v2protocal.oOi);
            v2protocal.lkO = true;
            if (init < 0) {
                v2protocal.reset();
            }
            j = System.currentTimeMillis();
            x.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(init), Long.valueOf(j - currentTimeMillis)});
            if (init < 0) {
                x.e("MicroMsg.VoipCSEngine", "engine init failed!");
            }
            com.tencent.mm.plugin.voip_cs.b.d bMw = com.tencent.mm.plugin.voip_cs.b.b.bMw();
            String str = this.oXt;
            String str2 = this.appId;
            String str3 = this.oYi;
            x.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + str + ",appid:" + str2 + ",voipCSContext:" + str3);
            bMw.oXt = str;
            bMw.oXs = 1;
            com.tencent.mm.plugin.voip_cs.b.c bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
            x.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
            if (bMx.oXf == 0) {
                bMx.oXf = (int) (System.currentTimeMillis() / 1000);
            }
            byte[] bArr = null;
            if (!(str3 == null || str3.equals(""))) {
                bArr = str3.getBytes();
            }
            au.DF().a(823, bMw);
            com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.kpr = (int) (System.currentTimeMillis() / 1000);
            com.tencent.mm.plugin.voip_cs.b.c.c cVar = new com.tencent.mm.plugin.voip_cs.b.c.c(com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.kpr, str, com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.netType, bArr, com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.field_capInfo, str2);
            x.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.field_capInfo));
            au.DF().a(cVar, 0);
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs < 2) {
            this.oXz.bME();
        }
        com.tencent.mm.plugin.voip_cs.b.a.b bVar2 = this.oYd;
        x.i("MicroMsg.voipcs.VoipCSViewManager", "start capture render");
        if (bVar2.lwe == null) {
            x.i("MicroMsg.voipcs.VoipCSViewManager", "create capture View");
            bVar2.lwe = new ObservableTextureView(bVar2.oXA);
            bVar2.lwe.setLayoutParams(new LayoutParams(1, 1));
            bVar2.oXB.addView(bVar2.lwe, new LayoutParams(1, 1));
            bVar2.lwe.setVisibility(0);
        }
        if (bVar2.lwc == null) {
            init = 320;
            int i2 = com.tencent.mm.plugin.appbrand.jsapi.share.d.CTRL_INDEX;
            com.tencent.mm.plugin.voip_cs.b.b.bMv();
            if (v2protocal.oOg) {
                init = 640;
                i2 = 480;
            }
            x.i("MicroMsg.voipcs.VoipCSViewManager", "create capture Render");
            bVar2.lwc = new com.tencent.mm.plugin.voip.video.a(init, i2);
            bVar2.lwc.a(bVar2, true);
            bVar2.lwc.a(bVar2.lwe);
            com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOx = bVar2.lwc.bMd();
            bVar2.lwc.bLY();
            bVar2.lwc.bMe();
            x.i("MicroMsg.voipcs.VoipCSViewManager", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(bVar2.lwc.bMb()), Boolean.valueOf(bVar2.lwc.bMc())});
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            au.HV().fE(aXI());
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            au.HV().fD(aXI());
            return true;
        }
    }

    private int aXI() {
        int i = 2;
        if (au.HV().yE()) {
            i = au.HV().yQ();
        } else if (this.oXz.bKY()) {
            if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs != 2) {
                c cVar = this.oYe;
                if (cVar.oKt != null) {
                    i = cVar.oKt.bJx();
                }
            }
            i = 0;
        }
        x.d("MicroMsg.voipcs.VoipCSMainUI", "Current StreamType:%d", new Object[]{Integer.valueOf(i)});
        return i;
    }

    protected void onResume() {
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onResume voipcs....");
        super.onResume();
        if (this.oYd != null) {
            this.oYd.bPd = false;
            if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs > 1) {
                bMM();
                if (this.oYh != null && this.oYh.equals("1")) {
                    this.oYd.bMJ();
                }
            }
        }
        if (this.oYk != null) {
            this.oYk.SO();
        }
        au.getNotification().cancel(44);
    }

    protected void onPause() {
        super.onPause();
        if (!this.oXz.bKY()) {
            this.oXz.stopRing();
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs == 1 || com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs == 2) {
            Intent intent = new Intent(ad.getContext(), VoipCSMainUI.class);
            intent.putExtra("voipCSBizId", this.oXt);
            intent.putExtra("voipCSAppId", this.appId);
            intent.putExtra("voipCSScene", this.buF);
            intent.putExtra("voipCSType", this.type);
            intent.putExtra("voipCSAllowBackCamera", this.oYg);
            intent.putExtra("voipCSShowOther", this.oYh);
            intent.putExtra("voipCSAvatarUrl", this.eTp);
            intent.putExtra("voipCSContext", this.oYi);
            intent.putExtra("launch_from_appbrand", this.oYj);
            Notification notification = new Builder(ad.getContext()).setTicker(this.tickerText).setWhen(System.currentTimeMillis()).setContentTitle(this.title).setContentText(this.bSc).setContentIntent(PendingIntent.getActivity(ad.getContext(), 44, intent, 134217728)).setOngoing(true).getNotification();
            notification.icon = com.tencent.mm.bf.a.cbg();
            notification.flags |= 32;
            au.getNotification().a(44, notification, false);
            if (this.oYk != null && this.oYk.ciq()) {
                this.oYk.J(5000, 5000);
            }
        } else {
            au.getNotification().cancel(44);
            if (this.oYk != null) {
                this.oYk.SO();
            }
        }
        this.oYd.bMH();
        this.oYd.bPd = true;
    }

    protected void onRestart() {
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onRestart voipcs....");
        super.onRestart();
        if (bMN() && com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs <= 1) {
            bMM();
        }
        if (this.oYd != null) {
            this.oYd.bPd = false;
        }
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        int i;
        int i2 = 2;
        x.i("MicroMsg.voipcs.VoipCSMainUI", "onDestroy voipcs....");
        if (this.bEL != null) {
            this.bEL.zY();
        }
        qy qyVar = new qy();
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXu == -1) {
            qyVar.cbK.status = 3;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXu == 823) {
            qyVar.cbK.status = 4;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs <= 1) {
            qyVar.cbK.status = 1;
        } else if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs >= 2) {
            qyVar.cbK.status = 2;
        }
        com.tencent.mm.sdk.b.a.sFg.m(qyVar);
        c cVar = this.oYe;
        com.tencent.mm.plugin.voip_cs.b.c bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        if (cVar.oKt == null || com.tencent.mm.plugin.voip_cs.b.b.bMx().oWR != 1) {
            i = 0;
        } else {
            i = cVar.oKt.bJx();
        }
        bMx.oXb = (int) ((((float) au.HV().getStreamVolume(i)) / ((float) au.HV().getStreamMaxVolume(i))) * 100.0f);
        bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        if (cVar.ltc == null || com.tencent.mm.plugin.voip_cs.b.b.bMx().oWR != 1) {
            i = 0;
        } else {
            i = cVar.ltc.wp();
        }
        bMx.oOD = i;
        if (cVar.ltc != null) {
            cVar.ltc.we();
        }
        if (cVar.oKt != null) {
            cVar.oKt.bJv();
        }
        this.oXz.stopRing();
        if (this.oYd != null) {
            com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.oYd;
            if (com.tencent.mm.plugin.voip_cs.b.b.bMx().bjS == 0) {
                if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs < 2) {
                    com.tencent.mm.plugin.voip_cs.b.b.bMx().bjS = 1;
                } else {
                    com.tencent.mm.plugin.voip_cs.b.b.bMx().bjS = 3;
                }
            }
            bVar.oQR.bMh();
            bVar.oQS.bMh();
            bVar.bMH();
            bVar.bMK();
            com.tencent.mm.plugin.voip_cs.b.d bMw = com.tencent.mm.plugin.voip_cs.b.b.bMw();
            x.i("MicroMsg.voipcs.VoipCSService", "now stop service");
            au.DF().b(823, bMw);
            au.DF().b(455, bMw);
            au.DF().b(818, bMw);
            au.DF().b(795, bMw);
            au.DF().b(285, bMw);
            au.DF().b(312, bMw);
            bMw.oXs = 3;
            if (bMw.oXu != 823) {
                au.DF().a(880, bMw);
                if (bMw.oXn == 0) {
                    i2 = 1;
                } else if (bMw.oXn != 2) {
                    i2 = bMw.oXn == 3 ? 3 : 4;
                }
                x.i("MicroMsg.voipcs.VoipCSService", "start netscene hangup for username:" + bMw.oXt + ",inviteId：" + com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.kpr + ",csroomId:" + com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOl + ",roomkey:" + com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.kpp + ",reason:" + i2);
                au.DF().a(new com.tencent.mm.plugin.voip_cs.b.c.a(com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.kpr, com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOl, com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.kpp, bMw.oXt, i2), 0);
            }
            bMw.oXw.SO();
            bMw.oXx.SO();
            bMw.oXm = 0;
            bMw.oWI = 0;
            bMw.oXn = 0;
            bMw.oXo = 0;
            bMw.oXp = null;
            bMw.kpy = 0;
            bMw.oXq = 0;
            bMw.oXs = 0;
            bMw.oXt = "";
            bMw.oXr = 0;
            bMw.oXu = 0;
            bMw.oXv = 999;
            com.tencent.mm.plugin.voip_cs.b.b.a bMv = com.tencent.mm.plugin.voip_cs.b.b.bMv();
            x.i("MicroMsg.VoipCSEngine", "now stop engine");
            bMv.kqx.iT(true);
            com.tencent.mm.plugin.voip_cs.b.c bMx2 = com.tencent.mm.plugin.voip_cs.b.b.bMx();
            if (bi.oW(bMx2.kqW) && bi.oW(bMx2.kqV)) {
                v2protocal v2protocal = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx;
                v2protocal.getVoipcsChannelInfo(v2protocal.oPO, v2protocal.oPO.length, bMx2.oWP == 1 ? 1 : 0);
                x.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(v2protocal.field_voipcsChannelInfoLength)});
                bMx2.kqW = new String(v2protocal.oPO, 0, v2protocal.field_voipcsChannelInfoLength);
                v2protocal v2protocal2 = com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx;
                v2protocal2.getVoipcsEngineInfo(v2protocal2.oPP, v2protocal2.oPP.length);
                x.d("MicroMsg.Voip", "field_voipcsEngineInfoLength: %d", new Object[]{Integer.valueOf(v2protocal2.field_voipcsEngineInfoLength)});
                String str = v2protocal2.kpw + "," + v2protocal2.kpp + "," + v2protocal2.oOl + "," + com.tencent.mm.plugin.voip_cs.b.b.bMx().oWR + "," + v2protocal2.oOx + "," + v2protocal2.oOy + v2protocal2.bLu() + new String(v2protocal2.oPP, 0, v2protocal2.field_voipcsEngineInfoLength);
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip", "voipreport:NewEngineString:" + str);
                bMx2.kqV = str;
                x.d("MicroMsg.VoipCSReportHelper", "nativeChannelReportString: %s", new Object[]{bMx2.kqW});
                x.d("MicroMsg.VoipCSReportHelper", "nativeEngineReportString: %s", new Object[]{bMx2.kqV});
            }
            au.DF().a(312, com.tencent.mm.plugin.voip_cs.b.b.bMw());
            au.DF().a(new com.tencent.mm.plugin.voip_cs.b.c.e(com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOl, com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.kpp), 0);
            bMv.kqx.reset();
            p.bKK().bKM();
            p.bKK().oMP = null;
        }
        this.oYd = null;
        this.oYe = null;
        au.HV().setMode(0);
        ad.getContext().unregisterReceiver(this.oMz);
        au.HV().b(this.oYl);
        au.HV().yC();
        if (this.oLM != null) {
            this.oLM.ej(ad.getContext());
        }
        au.b(this.mHI);
        if (this.oYk != null) {
            this.oYk.SO();
        }
        au.getNotification().cancel(44);
        if (!(this.knT == null || this.knU == null)) {
            this.knT.listen(this.knU, 0);
            this.knU = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.voip_cs_main;
    }

    public final void yZ(int i) {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onExitVoipCS for action:" + i + ",CallingStatus:" + com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs);
        if (com.tencent.mm.plugin.voip_cs.b.b.bMw().oXs == 0) {
            finish();
        } else if (this.oYd != null) {
            this.oYd.zc(i);
        }
    }

    public final void onError(int i) {
        if (this.oYd != null) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "onError for errCode:" + i);
            this.oYd.zc(i);
        }
    }

    public final void eX(String str, String str2) {
        com.tencent.mm.plugin.voip_cs.b.a.b bVar = this.oYd;
        if (!bVar.oXQ.equals("") || !g.isNullOrEmpty(str2)) {
            bVar.OM(str2);
        } else if (bVar.oXA.oYj) {
            bVar.eTm.setText(R.l.voip_cs_biz_user_name_appbrand);
        } else {
            bVar.eTm.setText(R.l.voip_cs_biz_user_name);
        }
        if (bVar.oXP.equals("") && g.isNullOrEmpty(str) && (bVar.oXA.eTp == null || bVar.oXA.eTp.equals(""))) {
            bVar.oXG.setImageResource(R.g.default_avatar);
            return;
        }
        SharedPreferences chZ = ad.chZ();
        if (!(g.isNullOrEmpty(str) || bVar.oXP.equals(str))) {
            bVar.ON(str);
            chZ.edit().putString(bVar.bMF(), str).commit();
        }
        if (!g.isNullOrEmpty(str2) && !bVar.oXQ.equals(str2)) {
            bVar.OM(str2);
            chZ.edit().putString(bVar.bMG(), str2).commit();
        }
    }

    private boolean bMN() {
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            x.d("MicroMsg.voipcs.VoipCSMainUI", "voipcs checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "")), bi.cjd(), this});
            if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                return true;
            }
            x.i("MicroMsg.voipcs.VoipCSMainUI", "has not camera  premission!");
            return false;
        }
        x.i("MicroMsg.voipcs.VoipCSMainUI", "has not audio record premission!");
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            x.e("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs]onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        x.d("MicroMsg.voipcs.VoipCSMainUI", "[voip_cs] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    bMM();
                    return;
                } else {
                    h.a(this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.l.permission_camera_request_again_msg : R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 8(this), new 9(this));
                    return;
                }
            case f$k.AppCompatTheme_colorPrimary /*82*/:
                if (iArr[0] == 0) {
                    x.d("MicroMsg.voipcs.VoipCSMainUI", "granted record audio!");
                    if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "")) {
                        bMM();
                        return;
                    }
                    return;
                }
                h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 6(this), new 7(this));
                return;
            default:
                return;
        }
    }

    public final void aWO() {
        int i;
        com.tencent.mm.plugin.voip_cs.b.c bMx;
        this.oYd.aWO();
        if (au.HV().yK() || au.HV().yE()) {
            this.oYe.ja(false);
        } else {
            this.oYe.ja(true);
        }
        c cVar = this.oYe;
        if (cVar.ltc != null) {
            boolean wn = cVar.ltc.wn();
            com.tencent.mm.plugin.voip_cs.b.b.bMx().oWR = 1;
            if (wn) {
                i = 1;
                com.tencent.mm.plugin.voip_cs.b.b.bMx().oXk = i;
                cVar = this.oYe;
                if (cVar.oKt != null) {
                    com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOy = Math.abs(1);
                } else {
                    cVar.oKt.bJt();
                    if (cVar.oKt.bJt() <= 0) {
                        com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOy = Math.abs(1);
                    }
                }
                this.oXz.stopRing();
                bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
                if (bMx.oXf != 0) {
                    bMx.oWU = ((int) (System.currentTimeMillis() / 1000)) - bMx.oXf;
                }
                bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
                x.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
                if (bMx.oXi == 0) {
                    bMx.oXi = (int) (System.currentTimeMillis() / 1000);
                }
                bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
                x.d("MicroMsg.VoipCSReportHelper", "markConnect");
                if (bMx.oXh != 0) {
                    bMx.oWW = (long) (((int) (System.currentTimeMillis() / 1000)) - bMx.oXh);
                }
            }
        }
        i = -1;
        com.tencent.mm.plugin.voip_cs.b.b.bMx().oXk = i;
        cVar = this.oYe;
        if (cVar.oKt != null) {
            cVar.oKt.bJt();
            if (cVar.oKt.bJt() <= 0) {
                com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOy = Math.abs(1);
            }
        } else {
            com.tencent.mm.plugin.voip_cs.b.b.bMv().kqx.oOy = Math.abs(1);
        }
        this.oXz.stopRing();
        bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        if (bMx.oXf != 0) {
            bMx.oWU = ((int) (System.currentTimeMillis() / 1000)) - bMx.oXf;
        }
        bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        x.d("MicroMsg.VoipCSReportHelper", "markStartTalk");
        if (bMx.oXi == 0) {
            bMx.oXi = (int) (System.currentTimeMillis() / 1000);
        }
        bMx = com.tencent.mm.plugin.voip_cs.b.b.bMx();
        x.d("MicroMsg.VoipCSReportHelper", "markConnect");
        if (bMx.oXh != 0) {
            bMx.oWW = (long) (((int) (System.currentTimeMillis() / 1000)) - bMx.oXh);
        }
    }

    public final void bML() {
        x.d("MicroMsg.voipcs.VoipCSMainUI", "onChannelConnectFailed now finish it!");
        this.oYd.zc(5);
    }
}
