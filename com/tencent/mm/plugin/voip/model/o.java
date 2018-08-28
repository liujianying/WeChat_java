package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.s.6;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip.video.g;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip.video.k;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;

public final class o implements a, p$a, u, c, g, k.a, SensorController.a {
    public b bEL;
    public String cYO;
    public ag guJ;
    public SensorController hlW;
    public TelephonyManager knT;
    public PhoneStateListener knU = new PhoneStateListener() {
        public final void onCallStateChanged(int i, String str) {
            int i2 = 1;
            super.onCallStateChanged(i, str);
            x.d("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(o.this.oMn)});
            if (!o.this.oMn) {
                return;
            }
            if (i == 1) {
                o.this.oMp = true;
                i.bJI().yK(1);
            } else if (i == 2) {
                String string;
                o.this.oMp = false;
                x.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
                if (o.this.oLU && !com.tencent.mm.plugin.voip.b.b.yU(o.this.oLL.mState)) {
                    s sVar = i.bJI().oNa;
                    x.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + sVar.oHa.oJX.kpo);
                    if (sVar.oHa.oJX.kpo != 0) {
                        sVar.oHa.oJX.oPS.oKQ = 102;
                        sVar.oHa.oJX.oPS.oLc = 6;
                        h.mEJ.a(11521, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis())});
                        sVar.bLg();
                    }
                }
                if (com.tencent.mm.plugin.voip.b.b.yU(o.this.oLL.mState)) {
                    string = ad.getContext().getString(R.l.voip_call_msg_chat_time, new Object[]{o.bx(bi.bG(o.this.oMa))});
                } else {
                    string = ad.getContext().getString(R.l.voip_call_connection_failed);
                }
                s sVar2 = i.bJI().oNa;
                x.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
                if (sVar2.oHa.oJX.kpo == 0) {
                    sVar2.oHa.oJZ.bKe();
                    sVar2.reset();
                } else {
                    sVar2.oHa.oJX.oPS.oKQ = 109;
                    sVar2.oHa.oJX.oPS.oLi = 4;
                    sVar2.bLi();
                }
                String str2 = o.this.oLT.field_username;
                String str3 = o.this.oLV ? bd.tby : bd.tbx;
                if (!o.this.oLU) {
                    i2 = 0;
                }
                q.a(str2, str3, i2, 6, string);
                o.this.kZ(4107);
                o.this.bKx();
                bd bdVar = new bd();
                bdVar.setType(10000);
                bdVar.ay(System.currentTimeMillis());
                bdVar.setStatus(6);
                bdVar.setContent(ad.getContext().getString(R.l.voip_call_interrupted_by_other_app) + ", <a href=\"weixin://voip/callagain/?username=" + o.this.cYO + "&isvideocall=" + o.this.oLV + "\">" + ad.getContext().getString(R.l.voip_call_again) + "</a>");
                if (!(o.this.cYO == null || o.this.cYO.equals(""))) {
                    bdVar.ep(o.this.cYO);
                    au.HU();
                    com.tencent.mm.model.c.FT().T(bdVar);
                }
                i.bJI().yK(2);
            } else if (i == 0) {
                i.bJI().yK(2);
                if (1 == o.this.oLZ && com.tencent.mm.plugin.voip.b.b.yU(o.this.oLL.mState) && o.this.oMp) {
                    o.this.E(true, false);
                }
                o.this.oMp = false;
            }
        }
    };
    public com.tencent.mm.sdk.b.c knV = new 10(this);
    private long kqk = 0;
    private boolean lfX = false;
    private boolean mIsMute = false;
    private int mUIType;
    public com.tencent.mm.plugin.voip.b.c oLL;
    public HeadsetPlugReceiver oLM;
    com.tencent.mm.plugin.voip.ui.b oLN;
    private com.tencent.mm.plugin.voip.video.a oLO;
    private CaptureView oLP;
    private a oLQ = null;
    private boolean oLR = false;
    private Object oLS = new Object();
    public ab oLT;
    public boolean oLU;
    public boolean oLV;
    public boolean oLW = false;
    private int oLX = Downloads.RECV_BUFFER_SIZE;
    private boolean oLY = false;
    public int oLZ = 1;
    public HeadsetPlugReceiver.a oMA = new 12(this);
    public com.tencent.mm.sdk.b.c oMB = new 9(this);
    private long oMa = -1;
    private boolean oMb = false;
    public boolean oMc = false;
    private boolean oMd = false;
    private boolean oMe = false;
    private int oMf = 0;
    public k oMg = new k();
    private al oMh = null;
    private ah oMi;
    private boolean oMj = false;
    private boolean oMk = false;
    private int oMl = 0;
    private boolean oMm = false;
    public boolean oMn = false;
    private com.tencent.mm.plugin.voip.widget.b oMo;
    private boolean oMp = false;
    private boolean oMq = false;
    public String oMr = null;
    public boolean oMs = false;
    public e oMt = null;
    public int oMu = -1;
    private long oMv = -1;
    private boolean oMw = false;
    private long oMx = 0;
    private long oMy = -1;
    public BroadcastReceiver oMz = new 1(this);

    static /* synthetic */ void e(o oVar, boolean z) {
        x.i("MicroMsg.Voip.VoipMgr", "do minimizeVoip");
        if (2 != oVar.mUIType || VERSION.SDK_INT >= 24) {
            oVar.mUIType = 2;
            oVar.oMf++;
            oVar.oMo = new com.tencent.mm.plugin.voip.widget.b(oVar, oVar.oLL.mState, oVar.oLT, oVar.oLV, oVar.oLU, z);
            if (GameJsApiLaunchApplication.CTRL_BYTE == oVar.oLL.mState || 6 == oVar.oLL.mState) {
                au.HU();
                if (1 == com.tencent.mm.model.c.DT().getInt(327948, 0)) {
                    Toast.makeText(oVar.g(), oVar.g().getString(R.l.voip_video_mini_short_toast), 0).show();
                } else {
                    Toast.makeText(oVar.g(), oVar.g().getString(R.l.voip_video_mini_long_toast), 1).show();
                    au.HU();
                    com.tencent.mm.model.c.DT().setInt(327948, 1);
                }
            }
            if (oVar.oLL.mState == 0 || 2 == oVar.oLL.mState || 256 == oVar.oLL.mState) {
                oVar.bKF();
            }
            i.bJI().stopRing();
            i.bJI().F(true, z);
            return;
        }
        x.e("MicroMsg.Voip.VoipMgr", "already is widget");
    }

    static /* synthetic */ void w(o oVar) {
        if (com.tencent.mm.plugin.voip.b.b.yU(oVar.oLL.mState)) {
            oVar.oMg.oVv = oVar.oMk;
            oVar.oMg.mRotateAngle = oVar.oMl;
            k kVar = oVar.oMg;
            int[] iArr = new int[2];
            if (oVar.oMm) {
                iArr[0] = 1;
                iArr[1] = 0;
            } else {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.asIntBuffer().put(iArr);
            byte[] array = allocate.array();
            if (kVar.oMN.setAppCmd(13, array, array.length) >= 0) {
                int length = (array.length % 4 == 0 ? 0 : 1) + (array.length / 4);
                ByteBuffer allocate2 = ByteBuffer.allocate(length * 4);
                allocate2.put(array);
                allocate2.order(ByteOrder.nativeOrder());
                allocate2.rewind();
                int[] iArr2 = new int[length];
                allocate2.asIntBuffer().get(iArr2);
                int i = iArr2[0];
                length = iArr2[1];
                if (i + length != 0) {
                    k.b bVar = new k.b(kVar);
                    bVar = new k.b(kVar);
                    bVar.oVy = i & 65535;
                    bVar.oVz = (i >> 16) & 65535;
                    bVar.oVA = length & 65535;
                    bVar.oVB = (length >> 16) & 65535;
                    x.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[]{bVar});
                    Iterator it = kVar.hfT.iterator();
                    while (it.hasNext()) {
                        ((k.a) it.next()).a(new int[]{bVar.oVy, bVar.oVz, bVar.oVA, bVar.oVB}, kVar.oVv, kVar.mRotateAngle);
                    }
                    return;
                }
                Iterator it2 = kVar.hfT.iterator();
                while (it2.hasNext()) {
                    ((k.a) it2.next()).a(null, kVar.oVv, kVar.mRotateAngle);
                }
            }
        }
    }

    public final void dK(boolean z) {
        x.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.oMw), Long.valueOf(this.oMv)});
        if (this.oLL == null) {
            x.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
        } else if (Math.abs(bi.VG() - this.oMy) >= 500 || this.oMy == -1) {
            if (com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState) && (this.oMw != z || this.oMv == -1)) {
                if (!(this.oMw || !z || com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState) || this.mUIType == 2 || this.oMv == -1)) {
                    x.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", new Object[]{Long.valueOf(bi.bI(this.oMv))});
                    this.oMx = r0 + this.oMx;
                }
                this.oMv = bi.VG();
                this.oMw = z;
            }
            if (this.oLN == null) {
                x.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
            } else if ((this.oLU || com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) && !com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState) && this.mUIType != 2) {
                x.d("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: " + z);
                this.oLN.setScreenEnable(z);
                this.oMy = bi.VG();
            }
        } else {
            x.d("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
        }
    }

    public final void ew(int i) {
        x.d("MicroMsg.Voip.VoipMgr", "onBluetoothHeadsetStateChange status: %d, mBTRecoverSpeakerOn: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.oMc)});
        switch (i) {
            case 1:
                if (!com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState)) {
                    if (1 == this.oLZ) {
                        this.oMc = true;
                    } else {
                        this.oMc = false;
                    }
                }
                au.HV().b(false, i.bJI().bJx(), false);
                i.bJI().iJ(false);
                i.bJI().iR(false);
                yC(4);
                this.oMs = false;
                return;
            case 2:
                au.HV().yC();
                bKk();
                return;
            case 3:
                au.HV().yB();
                this.oMs = false;
                return;
            case 4:
                au.HV().yC();
                au.HV().yA();
                bKk();
                return;
            default:
                return;
        }
    }

    private void bKk() {
        String str = "MicroMsg.Voip.VoipMgr";
        String str2 = "setSpeakerAfterBluetoothDisconnected, isCheckBluetoothEnd: %s, isVideoState: %s, isRingStop: %s, mBTRecoverSpeakerOn: %s, isMini: %s";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.oMs);
        objArr[1] = Boolean.valueOf(com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState));
        objArr[2] = Boolean.valueOf(i.bJI().bKY());
        objArr[3] = Boolean.valueOf(this.oMc);
        objArr[4] = Boolean.valueOf(2 == this.mUIType);
        x.i(str, str2, objArr);
        if (!this.oMs) {
            if (com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState)) {
                if (i.bJI().bKY()) {
                    E(true, true);
                    this.oLZ = 1;
                } else {
                    E(false, false);
                    this.oLZ = 2;
                }
            } else if (i.bJI().bKY()) {
                if (this.oMc || 2 == this.mUIType) {
                    E(true, true);
                    this.oLZ = 1;
                } else {
                    this.oLZ = 2;
                }
                this.oMc = false;
            } else {
                E(false, false);
                this.oLZ = 2;
            }
            yC(this.oLZ);
            this.oMs = true;
        }
    }

    private void yC(int i) {
        this.oLZ = i;
        if (this.oLN != null) {
            this.oLN.yN(this.oLZ);
        }
    }

    private void E(boolean z, boolean z2) {
        x.k("MicroMsg.Voip.VoipMgr", "enableSpeaker: %s, ignoreBluetooth: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        this.oMb = z;
        this.oMc = z;
        x.d("MicroMsg.Voip.VoipMgr", "MMCore.getAudioManager() " + au.HV().yI());
        if (!z2 && au.HV().yE()) {
            z = false;
        }
        if (q.deN.dby) {
            q.deN.dump();
            if (q.deN.dbz > 0) {
                i.bJI().iJ(z);
            }
        }
        if (q.deN.dcb >= 0 || q.deN.dcc >= 0) {
            i.bJI().iJ(z);
        }
        au.HV().b(z, i.bJI().bJx(), z2);
        i.bJI().iR(z);
        this.oMd = z;
    }

    public final void iO(boolean z) {
        int i;
        x.d("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (i.bJI().bKY()) {
            E(z, false);
        } else {
            s sVar = i.bJI().oNa;
            if (sVar.oNt != null) {
                sVar.oNt.iX(z);
            }
        }
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        yC(i);
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(0);
        hVar.h(11080, objArr);
    }

    public final void gD(boolean z) {
        int i = 1;
        l lVar;
        if (z) {
            lVar = i.bJI().oNa.oHa.oJZ;
            if (lVar.ltc != null) {
                lVar.ltc.aO(true);
            }
            i.bJI().yw(9);
            i.bJI().iQ(true);
        } else {
            lVar = i.bJI().oNa.oHa.oJZ;
            if (lVar.ltc != null) {
                lVar.ltc.aO(false);
            }
            i.bJI().yw(8);
            i.bJI().iQ(false);
        }
        this.mIsMute = z;
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(0);
        if (z) {
            i = 2;
        }
        objArr[2] = Integer.valueOf(i);
        hVar.h(11080, objArr);
    }

    public final boolean bKl() {
        if (!this.oLL.yX(4103)) {
            return false;
        }
        yD(4103);
        i.bJI().bLc();
        return true;
    }

    public final boolean bKm() {
        if (!this.oLL.yX(4101)) {
            return false;
        }
        i.bJI().stopRing();
        i.bJI().yw(1);
        i.bJI().G(true, this.oLV);
        h hVar = h.mEJ;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Long.valueOf(i.bJI().bKT());
        objArr[2] = Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(this.oLU ? 1 : 0);
        hVar.h(11046, objArr);
        h.mEJ.h(11080, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
        kZ(4111);
        kZ(4101);
        kZ(4100);
        return true;
    }

    public final boolean bKn() {
        int i = 0;
        if (!this.oLL.yX(4099)) {
            return false;
        }
        String str = this.oLT.field_username;
        String str2 = this.oLV ? bd.tby : bd.tbx;
        if (this.oLU) {
            i = 1;
        }
        q.a(str, str2, i, 6, ad.getContext().getString(R.l.voip_callfrom_reject_msg));
        i.bJI().stopRing();
        i.bJI().oNa.bLh();
        kZ(4099);
        bKx();
        return true;
    }

    public final boolean bKo() {
        if (!this.oLL.yX(4100)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
        i.bJI().stopRing();
        i.bJI().G(false, this.oLV);
        kZ(4100);
        return true;
    }

    public final boolean bKp() {
        int i = 0;
        if (!this.oLL.yX(4099)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
        String str = this.oLT.field_username;
        String str2 = this.oLV ? bd.tby : bd.tbx;
        if (this.oLU) {
            i = 1;
        }
        q.a(str, str2, i, 6, ad.getContext().getString(R.l.voip_callfrom_reject_msg));
        i.bJI().stopRing();
        i.bJI().oNa.bLh();
        kZ(4099);
        bKx();
        return true;
    }

    public final boolean bKq() {
        if (!this.oLL.yX(4100)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
        i.bJI().stopRing();
        i.bJI().G(true, this.oLV);
        kZ(4111);
        kZ(4100);
        return true;
    }

    public final boolean bKr() {
        if (!this.oLL.yX(4098)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
        yD(4098);
        i.bJI().bLc();
        return true;
    }

    public final boolean bKs() {
        if (!this.oLL.yX(4098)) {
            return false;
        }
        x.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
        yD(4098);
        i.bJI().bLc();
        return true;
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar, int i) {
        x.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated");
        if (1 == i && this.oLN != null) {
            this.oLN.uninit();
        }
        this.oLN = bVar;
        this.mUIType = i;
        int i2 = 320;
        int i3 = 240;
        if (this.oLO == null && com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState)) {
            this.oLP = new CaptureView(ad.getContext());
            if (v2protocal.oOg) {
                x.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
                i2 = 640;
                i3 = 480;
            }
            this.oLO = new com.tencent.mm.plugin.voip.video.a(i2, i3);
            this.oLO.a(this, true);
            this.oLO.a(this.oLP);
            i.bJI().yI(this.oLO.bMd());
            this.guJ.postDelayed(new Runnable() {
                public final void run() {
                    x.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + o.this.oLO);
                    if (o.this.oLO != null) {
                        o.this.oLO.bLY();
                    }
                }
            }, 50);
        }
        this.oLN.setCaptureView(this.oLP);
        this.oLN.dQ(-1, this.oLL.mState);
        this.oLN.setConnectSec(this.oMa);
        this.oLN.yN(this.oLZ);
        this.oLN.setMute(this.mIsMute);
        x.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d", new Object[]{Integer.valueOf(this.oMu)});
        if (this.oMu != -1) {
            this.oLN.setHWDecMode(this.oMu);
            x.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[]{Integer.valueOf(this.oMu)});
        }
    }

    public final void a(com.tencent.mm.plugin.voip.ui.b bVar) {
        x.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
        if (this.oLN == bVar) {
            x.d("MicroMsg.Voip.VoipMgr", "same VoipUI, clear it");
            this.oLN = null;
        }
        if (this.guJ != null) {
            this.guJ = null;
        }
    }

    public final void bKt() {
        x.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
        if (this.oLO != null) {
            this.oLO.bLX();
        }
        h.mEJ.h(11079, new Object[]{Integer.valueOf(1)});
    }

    private void yD(int i) {
        String string;
        x.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
        if (true == bKG()) {
            this.oLX = i;
        }
        Context context = ad.getContext();
        if (com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
            string = context.getString(R.l.voip_call_msg_chat_time, new Object[]{bx(bi.bG(this.oMa))});
        } else if (this.oLU) {
            string = context.getString(R.l.voip_call_cancel_msg_to);
        } else {
            string = context.getString(R.l.voip_call_cancel_msg_from);
        }
        q.a(this.oLT.field_username, this.oLV ? bd.tby : bd.tbx, this.oLU ? 1 : 0, 6, string);
        if (!this.oLU || com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
            com.tencent.mm.sdk.f.e.post(new 14(this), "VoipMgr_play_end_sound");
            this.oLR = true;
            i.bJI().bKR();
            if (Downloads.RECV_BUFFER_SIZE == this.oLX) {
                kZ(i);
                bKx();
                return;
            }
            return;
        }
        i.bJI().stopRing();
        if (this.oLU && !com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
            x.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
            s sVar = i.bJI().oNa;
            x.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + sVar.oHa.oJX.kpo);
            if (sVar.oHa.oJX.kpo == 0 && sVar.oHa.oJX.kpr == 0) {
                sVar.reset();
            } else {
                sVar.oHa.oJX.oPS.oKQ = sVar.oHa.bJN();
                sVar.oHa.oJX.oPS.oLc = 3;
                if (sVar.oHa.mStatus < 6) {
                    sVar.oHa.oJX.oPS.oLe = 1;
                }
                h hVar = h.mEJ;
                Object[] objArr = new Object[6];
                objArr[0] = Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo);
                objArr[1] = Long.valueOf(i.bJI().bKT());
                objArr[2] = Long.valueOf(i.bJI().bKU());
                objArr[3] = Integer.valueOf(sVar.oHa.mStatus == 5 ? 2 : 1);
                objArr[4] = Long.valueOf(System.currentTimeMillis());
                objArr[5] = Long.valueOf(System.currentTimeMillis());
                hVar.a(11521, true, true, objArr);
                sVar.bLg();
            }
        }
        x.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
        i.bJI().bKR();
        if (Downloads.RECV_BUFFER_SIZE == this.oLX) {
            kZ(i);
            bKx();
        }
    }

    public final void a(MMTextureView mMTextureView) {
        if (this.oMt != null) {
            e eVar = this.oMt;
            x.d("DecodeTextureView", "steve: init hwview, recreateView: " + mMTextureView);
            eVar.oTL = mMTextureView;
            eVar.oTL.setSurfaceTextureListener(eVar);
            if (eVar.oTM != null) {
                x.d("DecodeTextureView", "using saved st=" + eVar.oTM);
                mMTextureView.setSurfaceTexture(eVar.oTM);
            }
        }
    }

    public final boolean bKu() {
        if (i.bJI().oNa.oHa.oJX.kpo != 0) {
            return bKv();
        }
        this.oLY = true;
        return true;
    }

    private boolean bKv() {
        int i = 4;
        int i2 = 0;
        if (!this.oLL.yX(4101)) {
            return false;
        }
        Object[] objArr;
        h hVar;
        int i3;
        Object[] objArr2;
        int i4;
        kZ(4101);
        if (261 == this.oLL.mState || 7 == this.oLL.mState) {
            i.bJI().yw(1);
            h hVar2 = h.mEJ;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(2);
            objArr[1] = Long.valueOf(i.bJI().bKT());
            objArr[2] = Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(this.oLU ? 1 : 0);
            hVar2.h(11046, objArr);
            hVar = h.mEJ;
            Object[] objArr3 = new Object[3];
            objArr3[0] = Integer.valueOf(2);
            objArr3[1] = Integer.valueOf(0);
            i3 = 2;
            objArr2 = objArr3;
            objArr = objArr3;
            i4 = 11080;
        } else {
            if (1 == this.oLL.mState || 3 == this.oLL.mState) {
                i.bJI().yw(1);
                hVar = h.mEJ;
                i4 = 11046;
                Object[] objArr4 = new Object[5];
                objArr4[0] = Integer.valueOf(1);
                objArr4[1] = Long.valueOf(i.bJI().bKT());
                objArr4[2] = Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo);
                objArr4[3] = Integer.valueOf(0);
                if (this.oLU) {
                    i2 = 1;
                    objArr2 = objArr4;
                    objArr = objArr4;
                    objArr2[i] = Integer.valueOf(i2);
                    hVar.h(i4, objArr);
                } else {
                    i3 = 4;
                    objArr2 = objArr4;
                    objArr = objArr4;
                }
            }
            i.bJI().bKV();
            i.bJI().bKW();
            return true;
        }
        i = i3;
        objArr2[i] = Integer.valueOf(i2);
        hVar.h(i4, objArr);
        i.bJI().bKV();
        i.bJI().bKW();
        return true;
    }

    public final void bKw() {
        x.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
        if (this.oLY && i.bJI().oNa.oHa.oJX.kpo != 0) {
            this.oLY = false;
            bKv();
        }
        if (this.oLU) {
            kZ(4097);
        }
    }

    private void kZ(final int i) {
        x.k("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(i), com.tencent.mm.plugin.voip.b.b.yR(this.oLL.mState)});
        if (4101 == i && com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState)) {
            bKF();
        }
        boolean z = 4111 == i ? true : 4101 == i && (com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState) || this.oLU);
        if (z && 1 == this.mUIType && 1 == this.oLZ) {
            this.oMq = true;
            E(false, false);
            yC(2);
        }
        com.tencent.mm.plugin.voip.b.c cVar = this.oLL;
        if (cVar.yX(i)) {
            x.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[]{com.tencent.mm.plugin.voip.b.b.yR(cVar.mState), com.tencent.mm.plugin.voip.b.b.yR(((Integer) ((Map) cVar.oSW.get(Integer.valueOf(cVar.mState))).get(Integer.valueOf(i))).intValue()), com.tencent.mm.plugin.voip.b.b.yR(i)});
            cVar.mState = r0;
        } else {
            x.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
        }
        this.guJ.post(new Runnable() {
            public final void run() {
                if (o.this.oLN != null) {
                    o.this.oLN.dQ(i, o.this.oLL.mState);
                }
            }
        });
        if (6 == this.oLL.mState || GameJsApiLaunchApplication.CTRL_BYTE == this.oLL.mState) {
            aJv();
        }
        switch (this.oLL.mState) {
            case 258:
            case 259:
                yE(5);
                return;
            case 262:
                yE(6);
                return;
            default:
                return;
        }
    }

    private static void yE(int i) {
        tr trVar = new tr();
        trVar.cfr.bIH = i;
        com.tencent.mm.sdk.b.a.sFg.m(trVar);
    }

    public final void onError(int i, String str) {
        if (this.oLV) {
            i.bJI().dO(R.k.playend, 0);
        } else {
            i.bJI().dO(R.k.playend, 1);
        }
        if (i == 241 && bi.oW(str)) {
            str = g().getString(R.l.voip_overload_protection_default_wording);
        }
        if (this.oLN != null) {
            this.oLN.aL(i, str);
        }
        kZ(4109);
        x.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo)});
        Context context = ad.getContext();
        x.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode" + i);
        String string = i == 235 ? context.getString(R.l.voip_callout_error_msg_unsupport) : i == 233 ? context.getString(R.l.voip_call_fail) : i == 237 ? context.getString(R.l.voip_callout_error_msg_unsupport) : i == JsApiGetSetting.CTRL_INDEX ? context.getString(R.l.voip_call_fail) : i == 211 ? context.getString(R.l.voip_callout_error_msg_busy) : context.getString(R.l.voip_call_connection_failed);
        String str2;
        String str3;
        int i2;
        if (i.bJI().oNa.oHa.oJX.kpo != 0 && i.bJI().oNf.get(Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo)) == null) {
            str2 = this.oLT.field_username;
            str3 = this.oLV ? bd.tby : bd.tbx;
            i2 = this.oLU ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
                string = ad.getContext().getString(R.l.voip_call_msg_chat_time_interrupt_by_err, new Object[]{bx(bi.bG(this.oMa))});
            }
            i.bJI().oNf.put(Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(q.a(str2, str3, i2, 6, string, true)));
        } else if (i.bJI().oNa.oHa.oJX.kpo == 0) {
            str2 = this.oLT.field_username;
            str3 = this.oLV ? bd.tby : bd.tbx;
            i2 = this.oLU ? 1 : 0;
            if (com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
                string = ad.getContext().getString(R.l.voip_call_msg_chat_time_interrupt_by_err, new Object[]{bx(bi.bG(this.oMa))});
            }
            q.a(str2, str3, i2, 6, string, true);
        }
        i.bJI().bLc();
        bKx();
    }

    public final void aWJ() {
        x.i("MicroMsg.Voip.VoipMgr", "on accept");
        i.bJI().stopRing();
        kZ(4100);
    }

    public final void onReject() {
        x.i("MicroMsg.Voip.VoipMgr", "onReject");
        kZ(4099);
        q.a(this.oLT.field_username, this.oLV ? bd.tby : bd.tbx, this.oLU ? 1 : 0, 6, ad.getContext().getString(R.l.voip_callout_reject_msg));
        bKx();
    }

    private void bKx() {
        x.d("MicroMsg.Voip.VoipMgr", "delayFinish");
        this.oMr = null;
        this.guJ.postDelayed(new 16(this), 2000);
    }

    public final void fr(boolean z) {
        r bJI;
        x.i("MicroMsg.Voip.VoipMgr", "finish");
        this.oMn = false;
        this.oMp = false;
        if (this.oMf != -1) {
            h.mEJ.h(11700, new Object[]{Integer.valueOf(this.oMf), Long.valueOf(bi.bG(this.oMa))});
            this.oMf = -1;
        }
        try {
            ad.getContext().unregisterReceiver(this.oMz);
        } catch (Exception e) {
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.knV);
        com.tencent.mm.sdk.b.a.sFg.c(this.oMB);
        if (this.oLN != null) {
            this.oLN.uninit();
            this.oLN = null;
        }
        this.oLP = null;
        this.oMt = null;
        au.HV().b(this);
        au.HV().yC();
        if (i.bJI() != null) {
            i.bJI().stopRing();
            if (z) {
                i.bJI().oNa.bLj();
            } else {
                i.bJI().bKR();
            }
            if (this.oLV) {
                i.bJI().a(false, true, this.cYO);
            } else {
                i.bJI().a(false, false, this.cYO);
            }
            bJI = i.bJI();
            Context context = ad.getContext();
            s sVar = bJI.oNa;
            if (context == sVar.oHa.gKE && this == sVar.oHa.oJY) {
                sVar.oHa.gKE = null;
                sVar.oHa.oJY = u.oNN;
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", "detach ui........");
                com.tencent.mm.plugin.voip.b.a.bLO();
            } else {
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
            }
        }
        bJI = i.bJI();
        bJI.oNb = null;
        bJI.oNj = null;
        bJI.oNk = false;
        if (this.oLR) {
            this.oLQ = new a(this);
            com.tencent.mm.sdk.f.e.post(this.oLQ, "VoipMgr_clean");
        } else {
            bKE();
        }
        if (!(this.knT == null || this.knU == null)) {
            this.knT.listen(this.knU, 0);
            this.knU = null;
        }
        if (this.oLM != null) {
            this.oLM.ej(ad.getContext());
        }
        this.knT = null;
        au.vv().xu();
        p.bKK().bKM();
        p.bKK().oMP = null;
        au.getNotification().cancel(40);
        if (this.hlW != null) {
            x.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
            this.hlW.ciL();
            this.hlW = null;
            this.oMw = false;
            this.oMx = 0;
            this.oMv = -1;
        }
        this.oMy = -1;
        i.bJI().bLc();
    }

    public final void bKy() {
        x.i("MicroMsg.Voip.VoipMgr", "onNoResp");
        kZ(4105);
        q.a(this.oLT.field_username, this.oLV ? bd.tby : bd.tbx, this.oLU ? 1 : 0, 4, ad.getContext().getString(R.l.voip_callout_no_resp));
        h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(6), Integer.valueOf(ao.getNetWorkType(g()))});
        bKx();
    }

    public final void onConnected() {
        kZ(4102);
        this.oMa = bi.VE();
        if (this.oLN != null) {
            this.oLN.setConnectSec(this.oMa);
        }
        boolean bJR = i.bJI().oNa.oHa.bJR();
        boolean bJQ = i.bJI().oNa.oHa.bJQ();
        if (this.oLV && this.oLU && !bJQ && !bJR) {
            i.bJI().yw(1);
        }
        if (!com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState)) {
            h.mEJ.h(11080, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        }
        s sVar = i.bJI().oNa;
        if (sVar.oNt != null) {
            i iVar = sVar.oNt;
            bi.t(iVar.mContext, iVar.mContext.getSharedPreferences(ad.chY(), 0).getBoolean("settings_shake", true));
        }
        r bJI = i.bJI();
        int i = i.bJI().oNa.oHa.oJX.oOv;
        s sVar2 = bJI.oNa;
        sVar2.bnh = null;
        sVar2.oNA = null;
        sVar2.oNy = 0;
        if (i > 0) {
            s.oNw = i;
        }
        sVar2.bnh = (WifiManager) ad.getContext().getApplicationContext().getSystemService(TencentExtraKeys.LOCATION_SOURCE_WIFI);
        sVar2.oNz = new Timer();
        sVar2.oNz.schedule(new 6(sVar2), 0, (long) (s.oNw * TbsLog.TBSLOG_CODE_SDK_BASE));
        TelephonyManager telephonyManager = (TelephonyManager) ad.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(new s$5(sVar2, telephonyManager), 256);
        }
        p.bKK().bKL();
        p.bKK().oMP = this;
    }

    public final void bKz() {
        int i = 0;
        h hVar = h.mEJ;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo);
        objArr[1] = Long.valueOf(i.bJI().bKT());
        objArr[2] = Long.valueOf(i.bJI().bKU());
        if (!this.oLU) {
            i = 1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(1);
        hVar.a(11522, true, true, objArr);
    }

    public final void bKA() {
        String string;
        x.i("MicroMsg.Voip.VoipMgr", "onShutDown");
        if (com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
            string = ad.getContext().getString(R.l.voip_call_msg_chat_time, new Object[]{bx(bi.bG(this.oMa))});
        } else {
            string = ad.getContext().getString(R.l.voip_call_connection_failed);
        }
        if (this.oLU || com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
            q.a(this.oLT.field_username, this.oLV ? bd.tby : bd.tbx, 0, 6, string);
        }
        if (this.oLV) {
            i.bJI().dO(R.k.playend, 0);
        } else {
            i.bJI().dO(R.k.playend, 1);
        }
        if (bKG()) {
            this.oLX = 4106;
        } else {
            kZ(4106);
            bKx();
        }
        i.bJI().bLc();
    }

    public final void yF(int i) {
        x.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[]{Integer.valueOf(i)});
        if (1 == i || 3 == i || 5 == i || 6 == i || 7 == i) {
            kZ(4101);
            i.bJI().bKV();
            i.bJI().bKW();
        }
    }

    public final void b(int i, int i2, int[] iArr) {
        if (this.oLN != null) {
            this.oLN.c(i, i2, iArr);
        }
    }

    public final void bKB() {
        if (this.oLN != null) {
            this.oLN.bKB();
        }
    }

    public final void setHWDecMode(int i) {
        this.oMu = i;
        if (this.oLN != null) {
            this.oLN.setHWDecMode(i);
        }
    }

    public final void yG(int i) {
        boolean z = false;
        x.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: " + i);
        if (this.oLL.yX(4110)) {
            r bJI = i.bJI();
            boolean z2 = i == 1;
            if (i == 1) {
                z = true;
            }
            bJI.G(z2, z);
            i.bJI().stopRing();
            if (i == 1 && com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState)) {
                kZ(4101);
            }
            kZ(4110);
        }
    }

    public final void bKC() {
        boolean z = true;
        x.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
        if (au.HV().yK() || au.HV().yE()) {
            E(false, false);
            return;
        }
        boolean z2 = 1 == this.oLZ;
        if (this.oMq) {
            z = false;
        } else if (!this.oLV) {
            z = z2;
        }
        E(z, false);
    }

    public final long bKD() {
        x.l("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[]{Long.valueOf(this.oMx)});
        return this.oMx / 1000;
    }

    private static String bx(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        if (!this.oMe) {
            int i4 = this.oLO.bMb() ? OpenGlRender.oUJ : 0;
            int i5 = this.oLO.bMc() ? OpenGlRender.oUI : OpenGlRender.oUH;
            int b = i.bJI().oNa.oHa.oJZ.b(bArr, (int) j, i3, i, i2);
            if (this.oLN != null) {
                this.oLN.a(bArr, j, i, i2, i3, i4, i5, b);
            }
            this.oMk = i4 == OpenGlRender.oUJ;
            this.oMl = i5 == OpenGlRender.oUI ? 270 : 90;
            k kVar = this.oMg;
            kVar.oVx = i2;
            kVar.oVw = i;
        }
    }

    private void bKE() {
        synchronized (this.oLS) {
            i.bJI().stopRing();
            bKF();
            au.HV().setMode(0);
            if (this.bEL != null) {
                this.bEL.zY();
            }
        }
    }

    private void bKF() {
        x.k("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
        if (this.oLO != null) {
            if (this.oMg != null) {
                k kVar = this.oMg;
                if (kVar.hfT.contains(this)) {
                    kVar.hfT.remove(this);
                }
            }
            if (this.oMh != null) {
                x.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
                this.oMh.SO();
            }
            if (this.oMi != null) {
                x.d("MicroMsg.Voip.VoipMgr", "quit face detect thread");
                this.oMi.lnJ.getLooper().quit();
            }
            try {
                this.oLO.bLZ();
                com.tencent.mm.plugin.voip.video.a.bMa();
            } catch (Exception e) {
                x.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + e.toString());
            }
            this.oLO = null;
        }
    }

    public final void aWP() {
        x.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
        if (this.oLN != null) {
            this.oLN.bLE();
        }
        if (!com.tencent.mm.plugin.voip.b.b.yV(this.oLL.mState) && !this.oMd) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.kqk > 30000) {
                this.kqk = currentTimeMillis;
                i.bJI().yJ(R.k.voip_bad_netstatus_hint);
            }
        }
    }

    public final void aWQ() {
        x.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
        if (this.oLN != null) {
            this.oLN.aYv();
        }
    }

    private boolean bKG() {
        if (!com.tencent.mm.plugin.voip.b.b.yU(this.oLL.mState)) {
            return false;
        }
        SharedPreferences sharedPreferences = g().getSharedPreferences("voip_plugin_prefs", 0);
        if (sharedPreferences.getBoolean("voip_shortcut_has_added", false)) {
            return false;
        }
        String value = com.tencent.mm.k.g.AT().getValue("VOIPShortcutAutoadd");
        x.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[]{value});
        if (value != null && value.equals("0") && bi.bG(this.oMa) > 30) {
            int i = sharedPreferences.getInt("voip_shortcut_prompt_times", 0);
            boolean z = sharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
            if (i >= 3 || z) {
                return false;
            }
            Context context = g();
            View inflate = View.inflate(context, R.i.mm_alert_checkbox, null);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.mm_alert_dialog_cb);
            checkBox.setChecked(false);
            TextView textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_info);
            if (1 == bi.getInt(com.tencent.mm.k.g.AT().getValue("VOIPCallType"), 0)) {
                textView.setText(R.l.voip_add_short_cut_tip);
            } else {
                textView.setText(R.l.voip_add_short_cut_tip_audio);
            }
            com.tencent.mm.ui.base.h.a(context, false, context.getString(R.l.app_tip), inflate, context.getString(R.l.app_yes), context.getString(R.l.app_no), new 2(this), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (checkBox != null) {
                        o.this.g().getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", checkBox.isChecked()).commit();
                    }
                    if (Downloads.RECV_BUFFER_SIZE != o.this.oLX) {
                        o.this.kZ(o.this.oLX);
                        o.this.oLX = Downloads.RECV_BUFFER_SIZE;
                    }
                    o.this.guJ.post(new 1(this));
                }
            });
            sharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
            return true;
        } else if (value == null || !value.equals("1") || bi.bG(this.oMa) <= 15) {
            return false;
        } else {
            c(sharedPreferences);
            return false;
        }
    }

    private void c(SharedPreferences sharedPreferences) {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        Object intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        intent2.addFlags(67108864);
        if (1 == bi.getInt(com.tencent.mm.k.g.AT().getValue("VOIPCallType"), 0)) {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
            intent.putExtra("android.intent.extra.shortcut.NAME", g().getString(R.l.app_field_voip));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(g(), R.g.voip_camerachat));
            intent.putExtra("shortcut_icon_resource_id", R.g.voip_camerachat);
        } else {
            intent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
            intent.putExtra("android.intent.extra.shortcut.NAME", g().getString(R.l.app_field_voipaudio));
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(g(), R.g.voip_voicechat));
            intent.putExtra("shortcut_icon_resource_id", R.g.voip_voicechat);
        }
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        com.tencent.mm.plugin.base.model.b.o(g(), intent);
        sharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
    }

    /* renamed from: getContext */
    public final Context g() {
        Context context = null;
        if (this.oLN != null) {
            context = this.oLN.bLD();
        }
        if (context == null) {
            return ad.getContext();
        }
        return context;
    }

    public final boolean iP(final boolean z) {
        if (!this.oMp || z) {
            x.k("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[]{Boolean.valueOf(z)});
            x.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
            if (this.oLN != null) {
                this.oLN.uninit();
                this.oLN = null;
            }
            this.guJ.post(new Runnable() {
                public final void run() {
                    o.e(o.this, z);
                }
            });
            return true;
        }
        x.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
        return false;
    }

    public final void bKH() {
        if (256 == this.oLL.mState || 257 == this.oLL.mState) {
            au.HU();
            if (com.tencent.mm.model.c.DT().getInt(327945, 0) != 0 || this.oLN.bLD() == null) {
                d.O(ad.getContext(), R.l.voip_ignore_warning);
                bKJ();
                return;
            }
            au.HU();
            com.tencent.mm.model.c.DT().setInt(327945, 1);
            com.tencent.mm.ui.widget.a.c a = com.tencent.mm.ui.base.h.a(this.oLN.bLD(), R.l.voip_ignore_warning, R.l.app_tip, new 5(this));
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            a.show();
        }
    }

    public final void bKI() {
        this.oMj = !this.oMj;
        if (this.oMj) {
            this.oMh.SO();
        } else {
            aJv();
        }
    }

    public final void bKJ() {
        i.bJI().oNg = i.bJI().oNa.oHa.oJX.kpo;
        q.a(this.oLT.field_username, this.oLV ? bd.tby : bd.tbx, this.oLU ? 1 : 0, 6, ad.getContext().getString(R.l.voip_callfrom_ignore_msg));
        i.bJI().stopRing();
        kZ(4108);
        this.guJ.postDelayed(new Runnable() {
            public final void run() {
                o.this.fr(true);
            }
        }, 2000);
    }

    public final void bgV() {
        if (true == this.lfX || this.oLN == null || this.oLN.bLD() == null) {
            x.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.f.b.zV()) {
            int i;
            x.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
            h hVar = h.mEJ;
            Object[] objArr = new Object[2];
            if (this.oLV) {
                i = 0;
            } else {
                i = 1;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(0);
            hVar.h(11306, objArr);
            com.tencent.mm.ui.widget.a.c i2 = com.tencent.mm.ui.base.h.i(this.oLN.bLD(), R.l.voip_no_record_video_permission, R.l.app_tip);
            if (i2 == null) {
                x.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
                return;
            }
            i2.setCancelable(false);
            i2.setCanceledOnTouchOutside(false);
            i2.show();
            this.lfX = true;
        } else {
            x.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
        }
    }

    private void aJv() {
        if (this.oMh == null) {
            this.oMi = new ah("faceDetect");
            this.oMh = new al(this.oMi.lnJ.getLooper(), new 7(this), true);
        }
        this.oMh.J(2000, 2000);
        this.oMj = false;
    }

    public final void a(int[] iArr, boolean z, int i) {
        ah.A(new 8(this, iArr, z, i));
    }
}
