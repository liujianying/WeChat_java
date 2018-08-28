package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.ipcall.ui.j.1;
import com.tencent.mm.plugin.ipcall.ui.j.5;
import com.tencent.mm.plugin.ipcall.ui.j.6;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class IPCallTalkUI extends MMActivity implements j.a {
    private String eWQ;
    private String kvn;
    private String kvo;
    private String kvp;
    private String kvq;
    private int kvr;
    private int kvs;
    private j kze;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().addFlags(6946944);
        this.eWQ = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.kvn = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.kvo = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.kvp = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.kvq = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.kvr = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        this.kvs = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
        x.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", new Object[]{this.eWQ, this.kvn, this.kvo, this.kvp, this.kvq, Integer.valueOf(this.kvr), Integer.valueOf(this.kvs)});
        x.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            init();
        }
    }

    private void init() {
        this.kze = new j(this);
        this.kze.kzP = this;
        j jVar = this.kze;
        String str = this.eWQ;
        String str2 = this.kvn;
        String str3 = this.kvo;
        String str4 = this.kvp;
        String str5 = this.kvq;
        int i = this.kvr;
        int i2 = this.kvs;
        jVar.kzV = jVar.kzN.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        x.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(jVar.kzV)});
        jVar.kzD = (ImageView) jVar.kzN.findViewById(R.h.talk_ui_default_avatar);
        jVar.eBM = (ImageView) jVar.kzN.findViewById(R.h.talk_ui_avatar_iv);
        jVar.kzB = (EditText) jVar.kzN.findViewById(R.h.talk_ui_nickname_tv);
        jVar.eBR = (TextView) jVar.kzN.findViewById(R.h.talk_ui_status_tv);
        jVar.kzC = (TextView) jVar.kzN.findViewById(R.h.talk_ui_phone_num_tv);
        jVar.kzE = (IPCallFuncButton) jVar.kzN.findViewById(R.h.talk_ui_mute_button);
        jVar.kzF = (IPCallFuncButton) jVar.kzN.findViewById(R.h.talk_ui_dial_button);
        jVar.kzG = (IPCallFuncButton) jVar.kzN.findViewById(R.h.talk_ui_speaker_button);
        jVar.kzH = (ImageButton) jVar.kzN.findViewById(R.h.talk_ui_hangout_button);
        jVar.kzK = (ImageButton) jVar.kzN.findViewById(R.h.ipcall_mini_action);
        jVar.kzI = (TextView) jVar.kzN.findViewById(R.h.voip_net_status_hint);
        jVar.kzJ = jVar.kzN.findViewById(R.h.voip_net_status_hint_layout);
        jVar.ksT = (DialPad) jVar.kzN.findViewById(R.h.dial_pad);
        String str6;
        if (jVar.kzV) {
            jVar.eWQ = i.aXp().koG.nickname;
            jVar.kzM = i.aXp().koG.kpQ;
            jVar.kvq = i.aXp().koG.bZR;
            jVar.kvo = i.aXp().koG.cbH;
            jVar.kvn = i.aXp().koG.kpP;
            jVar.kzL = i.aXp().koG.kpS;
            x.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", new Object[]{jVar.eWQ, jVar.kzM, jVar.kvq, jVar.kvo, jVar.kvn, Integer.valueOf(jVar.kzL)});
            jVar.aYt();
            jVar.aYu();
            i.aXt();
            x.i("MicroMsg.TalkUIController", f.stateToString(i.aXt().mCurrentState));
            jVar.rJ(i.aXt().mCurrentState);
            str6 = i.aXp().koG.kpQ;
            str = i.aXp().koG.kpR;
            if (!bi.oW(str)) {
                jVar.Fj(str);
                jVar.kzC.setText(com.tencent.mm.plugin.ipcall.b.a.Ft(str));
            } else if (!bi.oW(str6)) {
                jVar.Fj(str6);
                jVar.kzC.setText(com.tencent.mm.plugin.ipcall.b.a.Ft(str6));
            }
            if (i.aXt().aXk()) {
                IPCallFuncButton iPCallFuncButton = jVar.kzG;
                i.aXs();
                iPCallFuncButton.setChecked(com.tencent.mm.plugin.ipcall.a.b.a.yJ());
                jVar.kzE.setChecked(i.aXs().kqc.hEj);
            }
        } else if (i.aXt().aXj()) {
            h.a(jVar.kzN, R.l.in_wechat_out_tip, R.l.app_tip, false, new 1(jVar));
        } else {
            jVar.aYt();
            jVar.eWQ = str;
            jVar.kvn = str2;
            jVar.kvo = str3;
            jVar.kvp = str4;
            jVar.kvr = i;
            jVar.kvs = i2;
            if (!bi.oW(jVar.kvn)) {
                jVar.kvn = c.Fx(jVar.kvn);
            }
            if (bi.oW(jVar.kvp)) {
                if (com.tencent.mm.plugin.ipcall.b.a.Fr(jVar.kvn)) {
                    str6 = com.tencent.mm.plugin.ipcall.b.a.Fp(jVar.kvn);
                    if (bi.oW(str6)) {
                        jVar.kvn = com.tencent.mm.plugin.ipcall.b.a.Fs(jVar.kvn);
                    } else {
                        jVar.kvn = com.tencent.mm.plugin.ipcall.b.a.Fu(jVar.kvn);
                        jVar.kvp = str6;
                    }
                }
                jVar.kvp = c.aYB();
            }
            x.i("MicroMsg.TalkUIController", "final mCountryCode: %s", new Object[]{jVar.kvp});
            com.tencent.mm.plugin.ipcall.a.c aXb = com.tencent.mm.plugin.ipcall.a.c.aXb();
            str = jVar.kvp;
            if (!aXb.huc) {
                aXb.fM(false);
            }
            if (!bi.oW(str)) {
                i.aXx().y(bi.getInt(str.replace("+", ""), 0), bi.VF());
                aXb.aXd();
            }
            if (bi.oW(jVar.eWQ)) {
                jVar.eWQ = com.tencent.mm.plugin.ipcall.b.a.aw(jVar.kzN, jVar.kvn);
            }
            jVar.kvq = str5;
            if (bi.oW(jVar.kvp) || com.tencent.mm.plugin.ipcall.b.a.Fr(jVar.kvn)) {
                jVar.kzM = jVar.kvn;
            } else {
                jVar.kzM = jVar.kvp + jVar.kvn;
                if (!jVar.kzM.startsWith("+")) {
                    jVar.kzM = "+" + jVar.kzM;
                }
            }
            x.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", new Object[]{jVar.kzM});
            if (com.tencent.mm.plugin.ipcall.a.c.aXb().ru(bi.getInt(jVar.kvp, -1))) {
                com.tencent.mm.plugin.report.service.h.mEJ.k(12058, jVar.kvp);
                h.a(jVar.kzN, jVar.kzN.getString(R.l.callout_country_restriction_hint), jVar.kzN.getString(R.l.callout_country_restriction_hint_title), false, new 6(jVar));
            } else if (ao.isNetworkConnected(jVar.kzN)) {
                long j = jVar.kzN.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
                if (j <= System.currentTimeMillis() || j == -1) {
                    jVar.aYu();
                    if (!(jVar.kzV && i.aXt().aXj())) {
                        b aXr;
                        jVar.kzL = com.tencent.mm.plugin.ipcall.b.a.du(jVar.kvo, jVar.kvn);
                        jVar.rJ(1);
                        com.tencent.mm.plugin.ipcall.c cVar = jVar.kzO;
                        str = jVar.eWQ;
                        str2 = jVar.kvn;
                        str3 = jVar.kvq;
                        str4 = jVar.kzM;
                        str5 = jVar.kvo;
                        i = jVar.kzL;
                        i2 = jVar.kvr;
                        int i3 = jVar.kvs;
                        if (i.aXt().aXj()) {
                            x.i("MicroMsg.IPCallManager", "startIPCall, already start!");
                        } else {
                            x.i("MicroMsg.IPCallManager", "startIPCall");
                            i.aXp().kox = cVar;
                            i.aXq().kqC = cVar;
                            i.aXt().mCurrentState = -1;
                            cVar.aEI();
                            cVar.knT = (TelephonyManager) ad.getContext().getSystemService("phone");
                            cVar.knT.listen(cVar.knU, 32);
                            com.tencent.mm.sdk.b.a.sFg.b(cVar.knV);
                            x.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[]{str4, str5});
                            k kVar = new k();
                            kVar.field_phonenumber = str4;
                            if (bi.oW(str5)) {
                                kVar.field_addressId = -1;
                            } else {
                                com.tencent.mm.plugin.ipcall.a.g.c EP = i.aXv().EP(str5);
                                if (EP == null || EP.sKx == -1) {
                                    kVar.field_addressId = -1;
                                } else {
                                    kVar.field_addressId = EP.sKx;
                                }
                            }
                            if (i != -1) {
                                kVar.field_phoneType = i;
                            } else {
                                kVar.field_phoneType = -1;
                            }
                            kVar.field_calltime = bi.VF();
                            kVar.field_status = 1;
                            if (!i.aXw().b(kVar)) {
                                kVar = null;
                            }
                            cVar.knR = kVar;
                            com.tencent.mm.plugin.ipcall.c.dvh.postDelayed(cVar.knX, 1754);
                            cVar.knS = false;
                            aXr = i.aXr();
                            x.d("MicroMsg.IPCallReportHelper", "reset");
                            aXr.kqE = 0;
                            aXr.kqF = 0;
                            aXr.kqG = 0;
                            aXr.kqH = 0;
                            aXr.kqI = 0;
                            aXr.kqJ = 0;
                            aXr.kqK = 0;
                            aXr.kqL = 0;
                            aXr.kqM = 0;
                            aXr.kqN = 0;
                            aXr.kpo = 0;
                            aXr.kpp = 0;
                            aXr.kqO = 0;
                            aXr.eNQ = "";
                            aXr.kqP = 0;
                            aXr.kqQ = "";
                            aXr.kqS = 0;
                            aXr.kqR = 0;
                            aXr.koa = 0;
                            aXr.kqT = 0;
                            aXr.kqU = 0;
                            aXr.kqZ = 0;
                            aXr.kqY = 0;
                            aXr.kqV = "";
                            aXr.kqW = "";
                            aXr.countryCode = "";
                            aXr.kra = 0;
                            aXr.krb = 0;
                            aXr.krc = 0;
                            aXr.krd = 0;
                            aXr.kre = 0;
                            i.aXt().mCurrentState = -1;
                            x.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[]{str3, str4});
                            g aXp = i.aXp();
                            x.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[]{str3, str4});
                            aXp.bXc = false;
                            aXp.koH = false;
                            aXp.kos = 0;
                            aXp.kot = 0;
                            aXp.kou = 0;
                            aXp.kov = false;
                            aXp.kow = false;
                            aXp.koI = false;
                            aXp.koG = new com.tencent.mm.plugin.ipcall.a.a.c();
                            aXp.koG.nickname = str;
                            aXp.koG.kpP = str2;
                            aXp.koG.cbH = str5;
                            aXp.koG.kpQ = str4;
                            aXp.koG.bZR = str3;
                            aXp.koG.kpr = (int) System.currentTimeMillis();
                            aXp.koG.kps = i2;
                            aXp.koG.kpt = i3;
                            aXp.koG.kpS = i;
                            aXp.koy.a(aXp.koG);
                            aXp.koD.a(aXp.koG);
                            x.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[]{Integer.valueOf(aXp.koG.kpr)});
                            i.aXt().rv(1);
                            com.tencent.mm.plugin.ipcall.a.c.a aXq = i.aXq();
                            if (aXq.kqB) {
                                x.d("MicroMsg.IPCallEngineManager", "already start engine");
                            } else {
                                aXq.aXL();
                                x.i("MicroMsg.IPCallEngineManager", "start engine");
                                if (aXq.kqx.lkO) {
                                    aXq.kqx.iT(false);
                                    aXq.kqx.reset();
                                }
                                aXq.kqx.oOk = 1;
                                long currentTimeMillis = System.currentTimeMillis();
                                v2protocal v2protocal = aXq.kqx;
                                v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
                                if (v2protocal.netType == 5) {
                                    v2protocal.netType = 4;
                                }
                                v2protocal.oPf = new int[(v2protocal.defaultWidth * v2protocal.defaultHeight)];
                                au.HU();
                                v2protocal.oOi = com.tencent.mm.model.c.Df();
                                i = m.zj();
                                if ((i & 1024) != 0) {
                                    d.y(ad.getContext(), "libvoipCodec_v7a.so");
                                    com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
                                } else if ((i & 512) != 0) {
                                    d.y(ad.getContext(), "libvoipCodec.so");
                                    com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
                                } else {
                                    d.y(ad.getContext(), "libvoipCodec_v5.so");
                                    com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
                                }
                                i2 = VERSION.SDK_INT;
                                i3 = OpenGlRender.bMg();
                                Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
                                int width = defaultDisplay.getWidth();
                                int init = v2protocal.init(v2protocal.netType, 65538, (v2protocal.defaultWidth << 16) | v2protocal.defaultHeight, (width << 16) | defaultDisplay.getHeight(), v2protocal.oOi, i | ((i2 << 16) | (i3 << 24)), e.duM + "app_lib/", 4);
                                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + v2protocal.oOi);
                                v2protocal.lkO = true;
                                if (init < 0) {
                                    v2protocal.reset();
                                }
                                j = System.currentTimeMillis();
                                x.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[]{Integer.valueOf(init), Long.valueOf(j - currentTimeMillis)});
                                if (aXq.kqx.field_capInfo != null && aXq.kqx.exchangeCabInfo(aXq.kqx.field_capInfo, aXq.kqx.field_capInfo.length) < 0) {
                                    x.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                                    i.aXr().kqN = 24;
                                }
                                if (init < 0) {
                                    x.e("MicroMsg.IPCallEngineManager", "engine init failed!");
                                }
                                aXq.kqx.oOk = 1;
                                aXq.kqB = true;
                            }
                            com.tencent.mm.plugin.ipcall.c.dvh.removeCallbacks(cVar.knW);
                            com.tencent.mm.plugin.ipcall.c.dvh.postDelayed(cVar.knW, 60000);
                        }
                        x.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", new Object[]{jVar.kzM});
                        aXr = i.aXr();
                        str = jVar.kvp;
                        x.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", new Object[]{str});
                        if (!bi.oW(str)) {
                            aXr.countryCode = str;
                        }
                    }
                    jVar.kzX = false;
                    return;
                }
                x.i("MicroMsg.TalkUIController", "onDisasterHappen");
                h.a(jVar.kzN, jVar.kzN.getString(R.l.ip_call_disaster_invalid, new Object[]{String.valueOf(((j - r6) / 1000) + 1)}), jVar.kzN.getString(R.l.ip_call_alter_tip), jVar.kzN.getString(R.l.ip_call_alter_tip_ok), false, new 5(jVar));
            } else {
                Toast.makeText(jVar.kzN, R.l.voip_net_unavailable, 1).show();
                jVar.kzN.finish();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        setScreenEnable(true);
        if (this.kze != null) {
            j jVar = this.kze;
            x.i("MicroMsg.TalkUIController", "onDestroy");
            jVar.kzO.knQ = null;
            i.aXs().bGc = null;
            i.aXs().kqh = null;
            i.aXs().a(null);
            com.tencent.mm.plugin.ipcall.a.b.b aXs = i.aXs();
            aXs.kqd.kqu = null;
            com.tencent.mm.plugin.ipcall.a.b.d dVar = aXs.kqd;
            dVar.hlW.ciL();
            dVar.hma.ciM();
            jVar.kzN = null;
            jVar.kzP = null;
        }
    }

    protected final int getLayoutId() {
        return R.i.ip_call_talk_ui;
    }

    public final void gc(boolean z) {
        if (z) {
            ah.i(new Runnable() {
                public final void run() {
                    IPCallTalkUI.this.setResult(-1, new Intent());
                    IPCallTalkUI.this.finish();
                }
            }, 3000);
        }
    }

    public void onBackPressed() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.kze != null) {
            boolean z;
            if (i.aXt().aXk()) {
                int aXI;
                if (i == 25) {
                    aXI = i.aXs().aXI();
                    if (aXI != -1) {
                        au.HV().fE(aXI);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                } else if (i == 24) {
                    aXI = i.aXs().aXI();
                    if (aXI != -1) {
                        au.HV().fD(aXI);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        x.d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.kze != null) {
            x.d("MicroMsg.TalkUIController", "onPause");
        }
    }

    protected void onResume() {
        x.d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.kze != null) {
            x.d("MicroMsg.TalkUIController", "onResume");
            au.getNotification().cancel(42);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallTalkUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
