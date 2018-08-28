package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.R;
import com.tencent.mm.al.b;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.ui.d.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.video.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.MMSuperAlert;
import com.tencent.mm.ui.base.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity extends MMActivity implements b, d {
    private String cYO;
    private ag guJ;
    private boolean iTN = false;
    private boolean mIsMute = false;
    private int mStatus;
    private CaptureView oLP;
    private ab oLT;
    private boolean oLU;
    private boolean oLV;
    private int oLZ = 1;
    private d oQc;
    private WeakReference<c> oQd;
    private long oQe = -1;
    private long oQf = 0;
    private boolean oQg = false;
    private int oQh = 1;
    private boolean oQi = false;
    private boolean oQj = false;
    private c oQk = new 1(this);
    private TelephonyManager oQl = null;
    private long oQm;

    static /* synthetic */ void a(VideoActivity videoActivity, int i) {
        int i2;
        x.d("MicroMsg.Voip.VideoActivity", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.voip_errorhint_notsupport;
        } else if (i == 233) {
            i.bJI().bKX();
            i2 = R.l.voip_errorhint_notcontact;
        } else {
            i2 = i == 237 ? (!b.PD() || videoActivity.oLV) ? R.l.voip_errorhint_plugclose : R.l.voip_errorhint_voice_plugclose_for_oversea : i == 236 ? R.l.voip_inblacklist : i == 211 ? R.l.voip_errorhint_userbusy : 0;
        }
        if (i2 != 0 || videoActivity.oQc == null) {
            if (i2 == 0) {
                i2 = R.l.voip_disconnect_tip;
            }
            MMSuperAlert.j(videoActivity, R.l.app_tip, i2);
            return;
        }
        videoActivity.oQc.co(videoActivity.getString(R.l.voip_disconnect_tip), -1);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        if (!com.tencent.mm.plugin.voip.b.d.em(this.mController.tml)) {
            com.tencent.mm.plugin.voip.b.d.en(this.mController.tml);
        }
        x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate start");
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(3);
        getWindow().addFlags(6815872);
        if (au.HX()) {
            i.bJI().F(false, false);
        }
        this.guJ = new ag();
        PBool pBool = new PBool();
        PBool pBool2 = new PBool();
        PString pString = new PString();
        PInt pInt = new PInt();
        pString.value = getIntent().getStringExtra("Voip_User");
        pBool.value = getIntent().getBooleanExtra("Voip_Outcall", true);
        pBool2.value = getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.oQm = getIntent().getLongExtra("Voip_LastPage_Hash", 0);
        pInt.value = com.tencent.mm.plugin.voip.b.b.I(pBool.value, pBool2.value);
        if (pBool.value) {
            try {
                if (bgx()) {
                    Toast.makeText(this, R.l.in_phone_tip, 0).show();
                    x.i("MicroMsg.Voip.VideoActivity", "this phone is on a call");
                    super.finish();
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.Voip.VideoActivity", "not ready now!");
            }
        }
        r bJI = i.bJI();
        if (bJI.oNb != null) {
            x.i("MicroMsg.Voip.VoipService", "voipMgr is not null");
            pString.value = bJI.oNb.cYO;
            pBool.value = bJI.oNb.oLU;
            pBool2.value = bJI.oNb.oLV;
            pInt.value = bJI.oNb.oLL.mState;
        } else {
            if (pString.value == null) {
                x.e("MicroMsg.Voip.VoipService", "username is null, can't start voip");
                obj = null;
            } else if (pBool.value || bJI.oNa.bJP()) {
                String str;
                o oVar;
                List F;
                k kVar;
                IntentFilter intentFilter;
                bJI.oNb = new o();
                o oVar2 = bJI.oNb;
                String str2 = pString.value;
                boolean z = pBool.value;
                boolean z2 = pBool2.value;
                x.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[]{str2, Boolean.valueOf(z), Boolean.valueOf(z2)});
                oVar2.oMn = true;
                oVar2.cYO = str2;
                oVar2.oLU = z;
                oVar2.oLV = z2;
                au.HU();
                oVar2.oLT = com.tencent.mm.model.c.FR().Yg(oVar2.cYO);
                oVar2.guJ = new ag();
                if (oVar2.oMt == null) {
                    oVar2.oMt = new e();
                }
                oVar2.oMu = 0;
                oVar2.oLW = bi.getInt(g.AT().getValue("VOIPCameraSwitch"), 1) == 0;
                if (!oVar2.oLV) {
                    oVar2.oLW = false;
                }
                int I = com.tencent.mm.plugin.voip.b.b.I(z, z2);
                if (oVar2.oLW) {
                    if (I == 0) {
                        I = 1;
                    } else if (GLIcon.TOP == I) {
                        I = 257;
                    }
                }
                if (z) {
                    oVar2.oLL = com.tencent.mm.plugin.voip.b.b.yT(I);
                } else {
                    oVar2.oLL = com.tencent.mm.plugin.voip.b.b.yS(I);
                }
                boolean zT = com.tencent.mm.compatible.f.b.zT();
                boolean zV = com.tencent.mm.compatible.f.b.zV();
                if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                    h hVar;
                    Object[] objArr;
                    if (!zT) {
                        hVar = h.mEJ;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(oVar2.oLV ? 0 : 1);
                        objArr[1] = Integer.valueOf(1);
                        hVar.h(11306, objArr);
                    }
                    if (!zV) {
                        hVar = h.mEJ;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(oVar2.oLV ? 0 : 1);
                        objArr[1] = Integer.valueOf(0);
                        hVar.h(11306, objArr);
                    }
                }
                if (!(zV && zT)) {
                    String str3 = null;
                    str = null;
                    if (!zT && !zV) {
                        str3 = getString(R.l.app_special_no_audio_camera_permission);
                        str = getString(R.l.app_need_audio_and_camera_title);
                    } else if (!zT) {
                        str3 = getString(R.l.app_special_no_record_audio_permission);
                        str = getString(R.l.app_need_audio_title);
                    } else if (!zV) {
                        str3 = getString(R.l.app_special_no_open_camera_permission);
                        str = getString(R.l.app_need_camera_title);
                    }
                    com.tencent.mm.ui.base.h.a(this, str3, str, getString(R.l.app_need_show_settings_button), true, new o$11(oVar2, this));
                }
                x.i("MicroMsg.Voip.VoipMgr", "initMgr");
                au.vv().xv();
                au.HV().b(oVar2);
                au.HV().a(oVar2);
                au.HV().yB();
                oVar2.bEL = new com.tencent.mm.compatible.util.b(ad.getContext());
                oVar2.bEL.requestFocus();
                if (oVar2.oLV) {
                    i.bJI().a(true, true, oVar2.cYO);
                } else {
                    i.bJI().a(true, false, oVar2.cYO);
                }
                if (oVar2.oLU) {
                    i.bJI().oNa.bLf();
                    if ((oVar2.oLV ? i.bJI().oNa.cn(oVar2.oLT.field_username, 0) : i.bJI().oNa.cn(oVar2.oLT.field_username, 1)) < 0) {
                        oVar2.fr(false);
                    }
                }
                oVar2.oLM = new HeadsetPlugReceiver();
                oVar2.oLM.a(ad.getContext(), oVar2.oMA);
                r bJI2 = i.bJI();
                Context context = ad.getContext();
                s sVar = bJI2.oNa;
                sVar.oHa.gKE = context;
                sVar.oHa.oJY = oVar2;
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", "attach ui........");
                oVar2.knT = (TelephonyManager) ad.getContext().getSystemService("phone");
                oVar2.knT.listen(oVar2.knU, 32);
                i.bJI().l(R.k.phonering, oVar2.oLV ? 0 : 1, oVar2.oLU);
                if (au.HV().yK()) {
                    I = 3;
                    oVar = oVar2;
                } else if (au.HV().yE()) {
                    I = 4;
                    oVar = oVar2;
                } else if (oVar2.oLV) {
                    I = 1;
                    oVar = oVar2;
                } else {
                    I = 2;
                    oVar = oVar2;
                }
                oVar.oLZ = I;
                oVar2.oMs = false;
                if (oVar2.oLV) {
                    oVar2.oMc = true;
                } else {
                    oVar2.oMc = false;
                }
                str2 = "voip_recent_contact" + q.GF();
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("voip_plugin_prefs", 0);
                str = sharedPreferences.getString(str2, null);
                if (str != null) {
                    F = bi.F(str.split(";"));
                    if (F != null) {
                        int size = F.size();
                        if (F.contains(oVar2.cYO)) {
                            if (size > 1) {
                                F.remove(oVar2.cYO);
                            }
                            sharedPreferences.edit().putString(str2, bi.c(F, ";")).commit();
                            com.tencent.mm.sdk.b.a.sFg.b(oVar2.oMB);
                            com.tencent.mm.sdk.b.a.sFg.b(oVar2.knV);
                            kVar = oVar2.oMg;
                            if (!kVar.hfT.contains(oVar2)) {
                                kVar.hfT.add(oVar2);
                            }
                            intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.SCREEN_ON");
                            intentFilter.addAction("android.intent.action.SCREEN_OFF");
                            intentFilter.addAction("android.intent.action.USER_PRESENT");
                            ad.getContext().registerReceiver(oVar2.oMz, intentFilter);
                            oVar2.hlW = new SensorController(oVar2.getContext());
                            x.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
                            oVar2.hlW.a(oVar2);
                        } else if (4 == size) {
                            F.remove(size - 1);
                        }
                        F.add(0, oVar2.cYO);
                        sharedPreferences.edit().putString(str2, bi.c(F, ";")).commit();
                        com.tencent.mm.sdk.b.a.sFg.b(oVar2.oMB);
                        com.tencent.mm.sdk.b.a.sFg.b(oVar2.knV);
                        kVar = oVar2.oMg;
                        if (kVar.hfT.contains(oVar2)) {
                            kVar.hfT.add(oVar2);
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        ad.getContext().registerReceiver(oVar2.oMz, intentFilter);
                        oVar2.hlW = new SensorController(oVar2.getContext());
                        x.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
                        oVar2.hlW.a(oVar2);
                    }
                }
                F = new ArrayList();
                F.add(0, oVar2.cYO);
                sharedPreferences.edit().putString(str2, bi.c(F, ";")).commit();
                com.tencent.mm.sdk.b.a.sFg.b(oVar2.oMB);
                com.tencent.mm.sdk.b.a.sFg.b(oVar2.knV);
                kVar = oVar2.oMg;
                if (kVar.hfT.contains(oVar2)) {
                    kVar.hfT.add(oVar2);
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                ad.getContext().registerReceiver(oVar2.oMz, intentFilter);
                oVar2.hlW = new SensorController(oVar2.getContext());
                x.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
                oVar2.hlW.a(oVar2);
            } else {
                x.e("MicroMsg.Voip.VoipService", "is out call, but kenerl is not working");
                com.tencent.mm.plugin.voip.model.q.a(pString.value, pBool2.value ? bd.tby : bd.tbx, pBool.value ? 1 : 0, 4, ad.getContext().getString(R.l.voip_call_cancel_msg_from));
                obj = null;
            }
            if (obj != null) {
                x.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
                super.finish();
            }
            this.oQd = new WeakReference(obj);
            this.cYO = pString.value;
            this.oLV = pBool2.value;
            this.oLU = pBool.value;
            this.mStatus = pInt.value;
            au.HU();
            this.oLT = com.tencent.mm.model.c.FR().Yg(this.cYO);
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_username", this.oLT.field_username);
            bundle2.putBoolean("key_isoutcall", this.oLU);
            bundle2.putInt("key_status", com.tencent.mm.plugin.voip.b.b.I(this.oLU, this.oLV));
            if (com.tencent.mm.plugin.voip.b.b.yV(this.mStatus)) {
                this.oQc = new e();
            } else {
                this.oQc = new f();
            }
            this.oQc.setArguments(bundle2);
            getSupportFragmentManager().bk().b(R.h.voip_container, this.oQc).commit();
            setTitleVisibility(8);
            if (com.tencent.mm.plugin.voip.b.b.yW(this.mStatus) && this.oLU) {
                this.guJ.postDelayed(new 4(this), 20000);
            }
            this.oQc.setVoipUIListener((c) this.oQd.get());
            this.oQc.a(this);
            this.oQc.yN(this.oLZ);
            this.oQc.setMute(this.mIsMute);
            if (i.bJI().oNb.oMr != null) {
                OH(i.bJI().oNb.oMr);
            }
            if (!(this.oQd == null || this.oQd.get() == null)) {
                ((c) this.oQd.get()).a(this, 1);
            }
            x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.oLU), Boolean.valueOf(this.oLV), this.cYO, Integer.valueOf(this.mStatus)});
            boolean a;
            if (com.tencent.mm.plugin.voip.b.b.yV(this.mStatus)) {
                a = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "");
                x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bi.cjd(), this});
                a = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bi.cjd(), this});
            } else {
                a = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bi.cjd(), this});
            }
            com.tencent.mm.sdk.b.a.sFg.b(this.oQk);
            return;
        }
        obj = bJI.oNb;
        if (obj != null) {
            this.oQd = new WeakReference(obj);
            this.cYO = pString.value;
            this.oLV = pBool2.value;
            this.oLU = pBool.value;
            this.mStatus = pInt.value;
            au.HU();
            this.oLT = com.tencent.mm.model.c.FR().Yg(this.cYO);
            Bundle bundle22 = new Bundle();
            bundle22.putString("key_username", this.oLT.field_username);
            bundle22.putBoolean("key_isoutcall", this.oLU);
            bundle22.putInt("key_status", com.tencent.mm.plugin.voip.b.b.I(this.oLU, this.oLV));
            if (com.tencent.mm.plugin.voip.b.b.yV(this.mStatus)) {
                this.oQc = new e();
            } else {
                this.oQc = new f();
            }
            this.oQc.setArguments(bundle22);
            getSupportFragmentManager().bk().b(R.h.voip_container, this.oQc).commit();
            setTitleVisibility(8);
            if (com.tencent.mm.plugin.voip.b.b.yW(this.mStatus) && this.oLU) {
                this.guJ.postDelayed(new 4(this), 20000);
            }
            this.oQc.setVoipUIListener((c) this.oQd.get());
            this.oQc.a(this);
            this.oQc.yN(this.oLZ);
            this.oQc.setMute(this.mIsMute);
            if (i.bJI().oNb.oMr != null) {
                OH(i.bJI().oNb.oMr);
            }
            if (!(this.oQd == null || this.oQd.get() == null)) {
                ((c) this.oQd.get()).a(this, 1);
            }
            x.i("MicroMsg.Voip.VideoActivity", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[]{Boolean.valueOf(this.oLU), Boolean.valueOf(this.oLV), this.cYO, Integer.valueOf(this.mStatus)});
            boolean a2;
            if (com.tencent.mm.plugin.voip.b.b.yV(this.mStatus)) {
                a2 = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "");
                x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a2), bi.cjd(), this});
                a2 = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
                x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a2), bi.cjd(), this});
            } else {
                a2 = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
                x.i("MicroMsg.Voip.VideoActivity", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a2), bi.cjd(), this});
            }
            com.tencent.mm.sdk.b.a.sFg.b(this.oQk);
            return;
        }
        x.e("MicroMsg.Voip.VideoActivity", "unable to init VoipMgr");
        super.finish();
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
                x.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[]{Integer.valueOf(r2)});
                return z;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            x.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[]{e.getLocalizedMessage()});
            return z;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void bKx() {
        this.guJ.postDelayed(new 5(this), 2000);
    }

    public final void dQ(int i, int i2) {
        this.mStatus = i2;
        if (1 != this.oQh && i2 != 8 && i2 != 262) {
            x.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
        } else if (this.oQc == null) {
            x.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
        } else {
            this.oQc.dQ(i, i2);
            switch (i2) {
                case 1:
                case 3:
                case 7:
                case 257:
                case 261:
                    if (this.oQc == null || !(this.oQc instanceof f)) {
                        if (this.oQc != null) {
                            this.oQc.uninit();
                            getSupportFragmentManager().bk().a(this.oQc).commit();
                            this.oQc = null;
                        }
                        x.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("key_username", this.oLT.field_username);
                        bundle.putBoolean("key_isoutcall", this.oLU);
                        bundle.putInt("key_status", this.mStatus);
                        this.oQc = new f();
                        this.oQc.setArguments(bundle);
                        this.oQc.setVoipUIListener((c) this.oQd.get());
                        this.oQc.fw(this.oQe);
                        this.oQc.a(this);
                        this.oQc.yN(this.oLZ);
                        this.oQc.setMute(this.mIsMute);
                        this.oQc.a(this.oLP);
                        getSupportFragmentManager().bk().b(R.h.voip_container, this.oQc).commit();
                        return;
                    }
                    return;
                case 8:
                case 262:
                    switch (i) {
                        case 4098:
                            this.guJ.postDelayed(new 6(this), 50);
                            break;
                        case 4099:
                            if (this.oLU) {
                                this.oQc.co(this.oLV ? getString(R.l.voip_video_call_rejected) : getString(R.l.voip_audio_call_rejected), -1);
                            }
                            bKx();
                            break;
                        case 4103:
                        case 4104:
                            bKx();
                            break;
                        case 4106:
                            this.guJ.post(new 9(this));
                            break;
                        case 4107:
                            finish();
                            break;
                        case 4109:
                            this.guJ.post(new 10(this));
                            break;
                    }
                    bKx();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        if (i == 25) {
            if (i.bJI().bKY() || this.oLU) {
                au.HV().fE(au.HV().yE() ? au.HV().yQ() : aXI());
            } else {
                i.bJI().stopRing();
            }
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            if (i.bJI().bKY() || this.oLU) {
                au.HV().fD(au.HV().yE() ? au.HV().yQ() : aXI());
            } else {
                i.bJI().stopRing();
            }
            return true;
        }
    }

    protected void onDestroy() {
        this.oQh = 4;
        x.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(this.mStatus)});
        if (!this.oQj) {
            finish();
        }
        if (!(this.oQd == null || this.oQd.get() == null)) {
            ((c) this.oQd.get()).a(this);
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.oQk);
        setScreenEnable(true);
        super.onDestroy();
    }

    protected void onStop() {
        this.oQh = 2;
        x.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(this.mStatus)});
        super.onStop();
        if (262 != this.mStatus && 8 != this.mStatus && this.oQi && !this.oQj && this.oQd != null && this.oQd.get() != null && ((c) this.oQd.get()).iP(false)) {
            H(false, true);
            if (com.tencent.mm.plugin.voip.b.b.yU(this.mStatus)) {
                h hVar = h.mEJ;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.tencent.mm.plugin.voip.b.b.yV(this.mStatus) ? 2 : 3);
                objArr[1] = Integer.valueOf(2);
                hVar.h(11618, objArr);
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.oQj) {
            x.i("MicroMsg.Voip.VideoActivity", "onStart");
            this.oQh = 1;
            dQ(GLIcon.LEFT, this.mStatus);
        }
    }

    public void finish() {
        boolean z;
        this.oQh = 3;
        x.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[]{Boolean.valueOf(this.oQg), com.tencent.mm.plugin.voip.b.b.yR(this.mStatus)});
        if (!(this.oQg || !com.tencent.mm.plugin.voip.b.b.yU(this.mStatus) || 4 == this.oQh)) {
            x.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", this.cYO);
            com.tencent.mm.plugin.voip.a.a.ezn.e(intent, this);
        }
        setScreenEnable(true);
        if (this.oQc != null) {
            if (this.oQc.oQu == 4105) {
                z = true;
            } else {
                z = false;
            }
            this.oQc.uninit();
            this.oQc = null;
        } else {
            z = false;
        }
        this.oQd = null;
        this.oLP = null;
        this.oQj = true;
        super.finish();
        ih ihVar;
        if (z) {
            ihVar = new ih();
            ihVar.bRN.bRQ = true;
            ihVar.bRN.bRP = this.oQm;
            com.tencent.mm.sdk.b.a.sFg.m(ihVar);
        } else {
            ihVar = new ih();
            ihVar.bRN.bRQ = false;
            ihVar.bRN.bRP = 0;
            com.tencent.mm.sdk.b.a.sFg.m(ihVar);
        }
        d.oQv = -1;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
        super.onNewIntent(intent);
    }

    public void onPause() {
        super.onPause();
        PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.oQi = z;
        x.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(this.mStatus), Boolean.valueOf(this.oQi), Boolean.valueOf(r5), Boolean.valueOf(r4), Boolean.valueOf(r1)});
        m.Bk(2);
    }

    public void onResume() {
        int i = 0;
        x.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(this.mStatus)});
        au.getNotification().cancel(40);
        j jVar = i.bJI().oNa.oHa;
        if (jVar.oJJ) {
            jVar.oJJ = false;
        }
        super.onResume();
        setScreenEnable(true);
        this.oQf = bi.VG();
        if (this.oLU && com.tencent.mm.plugin.voip.b.b.yW(this.mStatus) && i.bJI().bKY()) {
            if (!this.oLV) {
                i = 1;
            }
            i.bJI().l(R.k.phonering, i, this.oLU);
        }
        m.Bk(1);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.oQc != null) {
            this.oQc.a(bArr, j, i, i2, i3, i4, i5, i6);
        }
    }

    public final void aL(int i, String str) {
        x.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.oLV)});
        this.iTN = true;
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE) {
            com.tencent.mm.ui.base.h.b(this, str, null, true);
        } else {
            this.guJ.post(new 7(this, i));
        }
    }

    public final void OH(String str) {
        if (this.oQc != null) {
            this.guJ.post(new 8(this, str));
        }
    }

    protected final int getLayoutId() {
        return R.i.voip_main;
    }

    protected final void dealContentView(View view) {
        ak.d(ak.a(getWindow(), null), this.mController.tlX);
        ((ViewGroup) getWindow().getDecorView()).addView(view, 0);
    }

    private int aXI() {
        int bJx;
        if (com.tencent.mm.plugin.voip.b.b.yU(this.mStatus)) {
            bJx = i.bJI().bJx();
        } else {
            bJx = au.HV().yE() ? 0 : 2;
            if (this.oLU) {
                if (this.oLV) {
                    bJx = 3;
                    if (com.tencent.mm.compatible.e.q.deN.dcb >= 0) {
                        bJx = com.tencent.mm.compatible.e.q.deN.dcb;
                    }
                } else if (com.tencent.mm.compatible.e.q.deN.dce >= 0) {
                    bJx = com.tencent.mm.compatible.e.q.deN.dce;
                } else {
                    bJx = 0;
                }
            }
            if (!au.HV().yE() && com.tencent.mm.compatible.e.q.deN.dcg >= 0) {
                bJx = com.tencent.mm.compatible.e.q.deN.dcg;
            }
        }
        x.d("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[]{Integer.valueOf(bJx)});
        return bJx;
    }

    public final void yN(int i) {
        this.oLZ = i;
        if (this.oQc != null) {
            this.oQc.yN(i);
        }
    }

    public final void setMute(boolean z) {
        this.mIsMute = z;
        if (this.oQc != null) {
            this.oQc.setMute(z);
        }
    }

    public final void c(int i, int i2, int[] iArr) {
        if (this.oQc != null) {
            this.oQc.c(i, i2, iArr);
        }
    }

    public final void bKB() {
        if (this.oQc != null) {
            this.oQc.bKB();
        }
    }

    public final void setHWDecMode(int i) {
        if (this.oQc != null) {
            this.oQc.setHWDecMode(i);
        }
    }

    public final Context bLD() {
        return this.mController.tml;
    }

    public final void uninit() {
        if (this.oQc != null) {
            this.oQc.uninit();
        }
    }

    public final void setConnectSec(long j) {
        this.oQe = j;
        if (this.oQc != null) {
            this.oQc.fw(this.oQe);
        }
    }

    public final void bLE() {
        x.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning");
        if (this.oQc != null) {
            this.oQc.bLF();
        }
    }

    public final void aYv() {
        x.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
        if (this.oQc != null) {
            this.oQc.bLG();
        }
    }

    public final void H(boolean z, boolean z2) {
        this.oQg = z2;
        if (z) {
            bKx();
        } else {
            finish();
        }
    }

    public final void setCaptureView(CaptureView captureView) {
        this.oLP = captureView;
        if (this.oQc != null) {
            this.oQc.a(captureView);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            x.e("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult %d data is invalid", new Object[]{Integer.valueOf(i)});
            return;
        }
        x.i("MicroMsg.Voip.VideoActivity", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 19:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString("android.permission.CAMERA".equals(strArr[0]) ? R.l.permission_camera_request_again_msg : R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            VideoActivity.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new 2(this));
                    return;
                }
                return;
            case f$k.AppCompatTheme_colorPrimary /*82*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 3(this), null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
