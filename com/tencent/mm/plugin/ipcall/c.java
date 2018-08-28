package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.c.a.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip.video.i.8;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.smtt.sdk.WebView;

public final class c implements a, g.a, p.a {
    public static ag dvh = new ag(Looper.getMainLooper());
    private al bAZ;
    public Object iVA = new Object();
    public e knQ;
    public k knR;
    public boolean knS = false;
    public TelephonyManager knT;
    public PhoneStateListener knU = new 1(this);
    public com.tencent.mm.sdk.b.c knV = new 2(this);
    public Runnable knW = new 3(this);
    public Runnable knX = new Runnable() {
        public final void run() {
            Exception e;
            int i = 0;
            boolean z = true;
            i aXz = com.tencent.mm.plugin.ipcall.a.i.aXz();
            int i2 = R.k.ipcall_phonering;
            aXz.oVe = 0;
            if (i2 == 0) {
                aXz.iY(true);
            } else if (3500 != -1) {
                boolean booleanValue;
                boolean Am;
                try {
                    au.HU();
                    booleanValue = ((Boolean) com.tencent.mm.model.c.DT().get(73218, Boolean.valueOf(true))).booleanValue();
                    try {
                        Am = com.tencent.mm.k.a.Am();
                        x.i("MicroMsg.RingPlayer", "startPlayCustomRingWithCustomInterval, voipSound: %s, msgSound: %s, isCallingParty: %s", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(Am), Boolean.valueOf(true)});
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                        z = booleanValue;
                        if (z) {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    booleanValue = true;
                }
                if (z && !aXz.bwu) {
                    try {
                        aXz.oVf = System.currentTimeMillis();
                        aXz.oVd = new j();
                        Am = au.HV().yE();
                        booleanValue = au.HV().yK();
                        x.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(Am), Boolean.valueOf(booleanValue)});
                        if (q.deN.dce >= 0) {
                            i = q.deN.dce;
                        }
                        aXz.iX(false);
                        aXz.a(i2, 3500, true, i);
                        aXz.bwu = true;
                    } catch (Exception e4) {
                        x.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e4.toString());
                    }
                }
            } else {
                aXz.m(i2, 2, true);
            }
        }
    };
    public boolean knY;
    public com.tencent.mm.plugin.voip.ui.a knZ = new 5(this);
    private long koa = 0;

    public final void aEI() {
        if (this.knT != null) {
            this.knT.listen(this.knU, 0);
            this.knT = null;
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.knV);
    }

    private boolean L(int i, int i2, int i3) {
        com.tencent.mm.plugin.ipcall.a.a.c cVar = com.tencent.mm.plugin.ipcall.a.i.aXp().koG;
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().rv(i)) {
            int i4;
            com.tencent.mm.plugin.ipcall.a.b.a aVar;
            if (cVar != null) {
                x.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.kpr), Integer.valueOf(cVar.kpo), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            x.i("MicroMsg.IPCallManager", "closeDeviceEngine");
            p.bKK().bKM();
            p.bKK().oMP = null;
            b aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
            com.tencent.mm.plugin.ipcall.a.b.b aXs = com.tencent.mm.plugin.ipcall.a.i.aXs();
            if (aXs.kqc != null) {
                com.tencent.mm.plugin.ipcall.a.b.c cVar2 = aXs.kqc;
                i4 = cVar2.kql != null ? cVar2.kql.bDF : 0;
            } else {
                i4 = 0;
            }
            if (aXr.krb == 0) {
                aXr.krb = i4;
            }
            aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
            aXs = com.tencent.mm.plugin.ipcall.a.i.aXs();
            if (aXs.kqb != null) {
                aVar = aXs.kqb;
                if (aVar.kpV != null) {
                    x.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + aVar.kpV.bJw());
                    i4 = aVar.kpV.bJw();
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (aXr.krc == 0) {
                aXr.krc = i4;
            }
            com.tencent.mm.plugin.ipcall.a.b.b aXs2 = com.tencent.mm.plugin.ipcall.a.i.aXs();
            com.tencent.mm.plugin.ipcall.a.c.a aXq = com.tencent.mm.plugin.ipcall.a.i.aXq();
            i4 = 0;
            if (aXs2.kqb != null) {
                aVar = aXs2.kqb;
                i4 = (aVar.kpV == null || !aVar.bTv) ? -1 : aVar.kpV.bJx();
            }
            aXq.kqx.oOK = i4 == -1 ? 0 : (int) ((((float) au.HV().getStreamVolume(i4)) / ((float) au.HV().getStreamMaxVolume(i4))) * 100.0f);
            aXs2.epT.zY();
            aVar = aXs2.kqb;
            if (aVar.bTv) {
                x.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
                synchronized (aVar.kpW) {
                    e.post(new com.tencent.mm.plugin.ipcall.a.b.a.a(aVar, aVar.kpV), "IPCallAudioPlayer_stop");
                    aVar.bTv = false;
                    aVar.kpV = null;
                }
            }
            aXs2.bGc = null;
            aXs2.kqe.ej(ad.getContext());
            au.HV().yC();
            au.HV().b(aXs2);
            aXs2.kqh = null;
            aXs2.kqf = null;
            aXs = com.tencent.mm.plugin.ipcall.a.i.aXs();
            com.tencent.mm.plugin.ipcall.a.b.c cVar3 = aXs.kqc;
            if (cVar3.bTv) {
                x.i("MicroMsg.IPCallRecorder", "stop record");
                synchronized (cVar3.kqm) {
                    if (cVar3.kql != null) {
                        e.post(new a(cVar3.kql), "IPCallRecorder_stopRecord");
                        cVar3.kql = null;
                        cVar3.bTv = false;
                        cVar3.hEj = false;
                    }
                }
            }
            aXs.bGc = null;
            com.tencent.mm.plugin.ipcall.a.c.a aXq2 = com.tencent.mm.plugin.ipcall.a.i.aXq();
            x.i("MicroMsg.IPCallEngineManager", "close engine");
            aXq2.kqx.iT(true);
            b aXr2 = com.tencent.mm.plugin.ipcall.a.i.aXr();
            if (bi.oW(aXr2.kqW) && bi.oW(aXr2.kqV)) {
                com.tencent.mm.plugin.ipcall.a.a.c cVar4 = com.tencent.mm.plugin.ipcall.a.i.aXp().koG;
                v2protocal v2protocal = com.tencent.mm.plugin.ipcall.a.i.aXq().kqx;
                Object obj = aXr2.kqL == 1 ? 1 : null;
                v2protocal.getPstnChannelInfo(v2protocal.oPM, v2protocal.oPM.length, obj != null ? 1 : 0, cVar4.kpK);
                x.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", new Object[]{Integer.valueOf(v2protocal.field_pstnChannelInfoLength)});
                aXr2.kqW = new String(v2protocal.oPM, 0, v2protocal.field_pstnChannelInfoLength);
                v2protocal v2protocal2 = com.tencent.mm.plugin.ipcall.a.i.aXq().kqx;
                v2protocal2.getPstnEngineInfo(v2protocal2.oPN, v2protocal2.oPN.length);
                x.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", new Object[]{Integer.valueOf(v2protocal2.field_pstnEngineInfoLength)});
                aXr2.kqV = new String(v2protocal2.oPN, 0, v2protocal2.field_pstnEngineInfoLength);
                v2protocal2 = com.tencent.mm.plugin.ipcall.a.i.aXq().kqx;
                aXr2.kqX = v2protocal.bLs() + "," + v2protocal2.oOL + "," + (v2protocal.ovW & WebView.NORMAL_MODE_ALPHA) + v2protocal2.bLx() + "," + v2protocal2.oOK;
                x.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", new Object[]{aXr2.kqW});
                x.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", new Object[]{aXr2.kqV});
                x.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", new Object[]{aXr2.kqX});
            }
            aXq2.kqx.reset();
            aXq2.aXL();
            com.tencent.mm.plugin.ipcall.a.i.aXz().stop();
            i aXz = com.tencent.mm.plugin.ipcall.a.i.aXz();
            i4 = R.k.playend;
            com.tencent.mm.plugin.ipcall.a.i.aXs();
            boolean isSpeakerphoneOn = au.HV().daT.isSpeakerphoneOn();
            aXz.mContext.getSharedPreferences(ad.chY(), 0).getBoolean("settings_shake", true);
            au.HV().setSpeakerphoneOn(isSpeakerphoneOn);
            if (isSpeakerphoneOn) {
                au.HV().setMode(0);
            } else {
                au.HV().setMode(2);
            }
            x.i("MicroMsg.RingPlayer", "playSound, shake: %s, isSpeakerOn: %s, type: %s", new Object[]{Boolean.valueOf(false), Boolean.valueOf(isSpeakerphoneOn), Integer.valueOf(2)});
            aXz.oVg = System.currentTimeMillis();
            j jVar = new j();
            try {
                jVar.setDataSource(aXz.mContext, Uri.parse("android.resource://" + aXz.mContext.getPackageName() + "/" + i4));
                jVar.setOnCompletionListener(new i$7(aXz));
                jVar.setOnErrorListener(new 8(aXz));
                if (au.HV().yE() || !isSpeakerphoneOn) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                jVar.setAudioStreamType(i4);
                jVar.prepare();
                jVar.setLooping(false);
                jVar.start();
                if (System.currentTimeMillis() - aXz.oVg > 2000) {
                    aXz.oVe = 7;
                }
            } catch (Throwable th) {
                x.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                aXz.oVe = 6;
                jVar.stop();
                jVar.release();
            }
            dvh.removeCallbacks(this.knX);
            dvh.removeCallbacks(this.knW);
            if (this.bAZ != null) {
                this.bAZ.SO();
                this.bAZ = null;
            }
            com.tencent.mm.plugin.ipcall.a.i.aXr().kqN = i3;
            b aXr3 = com.tencent.mm.plugin.ipcall.a.i.aXr();
            x.d("MicroMsg.IPCallReportHelper", "markEndTalk");
            if (aXr3.kqU == 0 && aXr3.kqT != 0) {
                aXr3.kqU = System.currentTimeMillis();
                aXr3.kqM = (aXr3.kqU - aXr3.kqT) / 1000;
                x.d("MicroMsg.IPCallReportHelper", "callTime: %d", new Object[]{Long.valueOf(aXr3.kqM)});
            }
            k kVar;
            if (i == 8) {
                com.tencent.mm.plugin.ipcall.a.i.aXp().aXn();
                com.tencent.mm.plugin.ipcall.a.i.aXr().aXN();
                kVar = this.knR;
                if (kVar != null) {
                    x.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[]{Long.valueOf(kVar.sKx)});
                    if (kVar.sKx != -1) {
                        kVar.field_status = 2;
                        com.tencent.mm.plugin.ipcall.a.i.aXw().a(kVar);
                    }
                }
            } else if (i == 12) {
                com.tencent.mm.plugin.ipcall.a.i.aXp().aXn();
                com.tencent.mm.plugin.ipcall.a.i.aXr().aXN();
                if (i2 == 11) {
                    m.b(this.knR);
                } else {
                    kVar = this.knR;
                    if (kVar != null) {
                        x.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", new Object[]{Long.valueOf(kVar.sKx)});
                        if (kVar.sKx != -1) {
                            kVar.field_status = 6;
                            com.tencent.mm.plugin.ipcall.a.i.aXw().a(kVar);
                        }
                    }
                }
            } else if (i == 9) {
                com.tencent.mm.plugin.ipcall.a.i.aXp().rw(1);
                com.tencent.mm.plugin.ipcall.a.i.aXr().aXM();
                m.a(this.knR, com.tencent.mm.plugin.ipcall.a.i.aXr().kqM);
            } else if (i == 10) {
                com.tencent.mm.plugin.ipcall.a.i.aXp().rw(1);
                aXr3 = com.tencent.mm.plugin.ipcall.a.i.aXr();
                x.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
                aXr3.kqG = 1;
                kVar = this.knR;
                long j = com.tencent.mm.plugin.ipcall.a.i.aXr().kqM;
                if (kVar != null) {
                    x.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", new Object[]{Long.valueOf(kVar.sKx), Long.valueOf(j)});
                    if (kVar.sKx != -1) {
                        kVar.field_status = 5;
                        kVar.field_duration = j;
                        com.tencent.mm.plugin.ipcall.a.i.aXw().a(kVar);
                    }
                }
            } else if (i == 11) {
                if (i2 == 5) {
                    com.tencent.mm.plugin.ipcall.a.i.aXp().rw(3);
                } else if (i2 == 11) {
                    com.tencent.mm.plugin.ipcall.a.i.aXp().rw(1);
                } else {
                    com.tencent.mm.plugin.ipcall.a.i.aXp().rw(2);
                }
                com.tencent.mm.plugin.ipcall.a.i.aXr().aXM();
                if (i2 == 11) {
                    m.b(this.knR);
                } else {
                    m.a(this.knR, com.tencent.mm.plugin.ipcall.a.i.aXr().kqM);
                }
            }
            if (com.tencent.mm.plugin.ipcall.a.i.aXp().bXc) {
                if (this.knY || com.tencent.mm.plugin.ipcall.a.i.aXp().koG.kpo == 0 || com.tencent.mm.plugin.ipcall.a.i.aXp().koG.kpq == 0) {
                    x.e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
                } else {
                    Context context = ad.getContext();
                    int i5 = com.tencent.mm.plugin.ipcall.a.i.aXp().koG.kpo;
                    long j2 = com.tencent.mm.plugin.ipcall.a.i.aXp().koG.kpq;
                    x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
                    if (d.aWV()) {
                        int i6 = com.tencent.mm.k.g.AT().getInt("WCOMaxTimesForShowFeedback", 0);
                        au.HU();
                        int intValue = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.sRu, Integer.valueOf(0))).intValue();
                        au.HU();
                        long longValue = ((Long) com.tencent.mm.model.c.DT().get(aa.a.sRt, Long.valueOf(0))).longValue();
                        long VE = bi.VE();
                        if (VE - longValue > 86400) {
                            i4 = 0;
                            x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
                        } else {
                            i4 = intValue;
                        }
                        if (i4 >= i6) {
                            x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time" + i6);
                        } else if (VE - longValue < 1800) {
                            x.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
                        } else {
                            i4++;
                            au.HU();
                            com.tencent.mm.model.c.DT().a(aa.a.sRu, Integer.valueOf(i4));
                            au.HU();
                            com.tencent.mm.model.c.DT().a(aa.a.sRt, Long.valueOf(VE));
                            Intent intent = new Intent();
                            intent.putExtra("IPCallFeedbackDialogUI_KRoomId", i5);
                            intent.putExtra("IPCallFeedbackDialogUI_KCallseq", j2);
                            d.b(context, "ipcall", ".ui.IPCallFeedbackDialogUI", intent);
                        }
                    }
                }
            }
            com.tencent.mm.plugin.ipcall.a.i.aXp().kox = null;
            com.tencent.mm.plugin.ipcall.a.i.aXq().kqC = null;
            com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState = -1;
            aWS();
            aEI();
            return true;
        }
        x.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cVar != null) {
            x.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", new Object[]{Integer.valueOf(cVar.kpr), Integer.valueOf(cVar.kpo), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        return false;
    }

    public static boolean EL(String str) {
        x.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[]{str});
        if (!com.tencent.mm.plugin.ipcall.a.i.aXt().aXm()) {
            x.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
            return false;
        } else if (bi.oW(str) || str.length() != 1) {
            return false;
        } else {
            int i;
            if (!bi.oW(str) && str.length() == 1) {
                char charAt = str.charAt(0);
                if (charAt < '0' || charAt > '9') {
                    if (charAt == '*') {
                        i = 10;
                    } else if (charAt == '#') {
                        i = 11;
                    } else if (charAt >= 'A' && charAt <= 'D') {
                        i = (charAt - 65) + 12;
                    }
                    if (i != -1) {
                        return false;
                    }
                    com.tencent.mm.plugin.ipcall.a.c.a aXq = com.tencent.mm.plugin.ipcall.a.i.aXq();
                    x.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                    b aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
                    aXr.kre++;
                    x.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aXr.kre)});
                    if (aXq.kqx.SendDTMF(i) < 0) {
                        x.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aXq.kqx.SendDTMF(i))});
                    }
                    return true;
                }
                i = charAt - 48;
                if (i != -1) {
                    return false;
                }
                com.tencent.mm.plugin.ipcall.a.c.a aXq2 = com.tencent.mm.plugin.ipcall.a.i.aXq();
                x.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
                b aXr2 = com.tencent.mm.plugin.ipcall.a.i.aXr();
                aXr2.kre++;
                x.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aXr2.kre)});
                if (aXq2.kqx.SendDTMF(i) < 0) {
                    x.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aXq2.kqx.SendDTMF(i))});
                }
                return true;
            }
            i = -1;
            if (i != -1) {
                return false;
            }
            com.tencent.mm.plugin.ipcall.a.c.a aXq22 = com.tencent.mm.plugin.ipcall.a.i.aXq();
            x.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[]{Integer.valueOf(i)});
            b aXr22 = com.tencent.mm.plugin.ipcall.a.i.aXr();
            aXr22.kre++;
            x.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[]{Integer.valueOf(aXr22.kre)});
            if (aXq22.kqx.SendDTMF(i) < 0) {
                x.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[]{Integer.valueOf(aXq22.kqx.SendDTMF(i))});
            }
            return true;
        }
    }

    public final void aWH() {
        x.i("MicroMsg.IPCallManager", "onInviteSuccess");
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().rv(3)) {
            b aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
            x.d("MicroMsg.IPCallReportHelper", "markStartInvite");
            if (aXr.kqR == 0) {
                aXr.kqR = System.currentTimeMillis();
            }
            com.tencent.mm.plugin.ipcall.a.a.c cVar = com.tencent.mm.plugin.ipcall.a.i.aXp().koG;
            b aXr2 = com.tencent.mm.plugin.ipcall.a.i.aXr();
            int i = cVar.kpr;
            String str = cVar.bZR;
            String str2 = cVar.kpQ;
            int i2 = cVar.kpo;
            long j = cVar.kpp;
            long j2 = cVar.kpq;
            aXr2.kpr = i;
            aXr2.kqQ = str;
            aXr2.eNQ = str2;
            aXr2.kpo = i2;
            aXr2.kpp = j;
            aXr2.kqO = j2;
            if (this.knQ != null) {
                this.knQ.aWH();
            }
        }
    }

    public final void y(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cK(2, 0)) {
            d(2, str, str2, i);
        }
    }

    public final void aWI() {
        x.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().rv(4)) {
            b aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
            x.d("MicroMsg.IPCallReportHelper", "markStartRing");
            if (aXr.kqS == 0) {
                aXr.kqS = System.currentTimeMillis();
                aXr.kqJ = aXr.kqS - aXr.kqR;
                x.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[]{Long.valueOf(aXr.kqJ)});
            }
            com.tencent.mm.plugin.ipcall.a.i.aXq().aXK();
            aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
            x.i("MicroMsg.IPCallReportHelper", "startRing");
            aXr.kqE = 1;
            if (this.knQ != null) {
                this.knQ.aWI();
            }
        }
    }

    public final void aWJ() {
        x.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().rv(5)) {
            b aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
            x.d("MicroMsg.IPCallReportHelper", "markUserAccept");
            if (aXr.koa == 0) {
                aXr.koa = System.currentTimeMillis();
                aXr.kqK = aXr.koa - aXr.kqR;
                x.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[]{Long.valueOf(aXr.kqK)});
            }
            com.tencent.mm.plugin.ipcall.a.i.aXq().aXK();
            aXr = com.tencent.mm.plugin.ipcall.a.i.aXr();
            x.i("MicroMsg.IPCallReportHelper", "userAccept");
            aXr.kqF = 1;
            dvh.removeCallbacks(this.knW);
            com.tencent.mm.plugin.ipcall.a.i.aXz().stop();
            dvh.removeCallbacks(this.knX);
            com.tencent.mm.plugin.ipcall.a.i.aXs().aiN();
            if (com.tencent.mm.plugin.ipcall.a.i.aXq().kqA && !this.knS) {
                com.tencent.mm.plugin.ipcall.a.i.aXr().aXO();
                com.tencent.mm.plugin.ipcall.a.i.aXr().aXR();
                this.knS = true;
                this.koa = bi.VE();
                YN();
                com.tencent.mm.plugin.ipcall.a.i.aXq().aXJ();
                if (this.knQ != null) {
                    this.knQ.aWW();
                }
                com.tencent.mm.plugin.ipcall.a.i.aXr().aXQ();
                p.bKK().bKL();
                p.bKK().oMP = this;
            }
        }
    }

    public final void d(int i, String str, String str2, int i2) {
        if (this.knQ != null) {
            this.knQ.d(i, str, str2, i2);
        } else {
            Toast.makeText(ad.getContext(), str2, 1).show();
        }
    }

    public final void bu(String str, int i) {
        x.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cK(3, 5)) {
            d(3, null, str, i);
        }
    }

    public final void bv(String str, int i) {
        x.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cK(1, 4)) {
            d(1, null, str, i);
        }
    }

    public final void aWK() {
        x.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (!L(10, 0, 32)) {
            return;
        }
        if (this.knQ != null) {
            this.knQ.aWX();
        } else {
            Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.ip_call_status_other_side_shutdown), 1).show();
        }
    }

    public final void bw(String str, int i) {
        x.i("MicroMsg.IPCallManager", "onSyncFailed");
        if (cK(7, 35)) {
            d(7, null, str, i);
        }
    }

    public final void aWL() {
        x.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
        if (cK(7, 29)) {
            d(7, null, ad.getContext().getString(R.l.calling_failed_network), 1);
        }
    }

    public final void z(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cK(8, 9)) {
            d(8, str, str2, i);
        }
    }

    public final void A(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cK(10, 0)) {
            d(10, str, str2, i);
        }
    }

    public final void B(String str, String str2, int i) {
        x.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cK(11, 0)) {
            d(11, str, str2, i);
        }
    }

    public final void aWM() {
        do {
            x.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        } while (cK(12, 0));
    }

    public final void aWN() {
        x.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (cK(6, 0)) {
            d(6, null, ad.getContext().getString(R.l.callout_failed_network), 1);
        }
    }

    public final void aWO() {
        x.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        com.tencent.mm.plugin.ipcall.a.i.aXz().stop();
        dvh.removeCallbacks(this.knX);
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().aXk()) {
            com.tencent.mm.plugin.ipcall.a.b.b aXs = com.tencent.mm.plugin.ipcall.a.i.aXs();
            aXs.kqe.a(ad.getContext(), aXs);
            au.HV().a(aXs);
            au.HV().yB();
            aXs.kqj = au.HV().yK();
            aXs.kqi = au.HV().yE();
            x.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[]{Boolean.valueOf(aXs.kqj), Boolean.valueOf(aXs.kqi)});
            aXs.epT.requestFocus();
            com.tencent.mm.plugin.ipcall.a.b.a aVar = aXs.kqb;
            if (aVar.bTv) {
                x.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
            } else {
                x.i("MicroMsg.IPCallAudioPlayer", "startPlay");
                if (aVar.kpV == null) {
                    aVar.kpV = new com.tencent.mm.plugin.voip.model.b();
                    aVar.kpV.X(v2protocal.lsT, 20, 1);
                }
                aVar.kpX = aVar.kpV.r(ad.getContext(), false);
                aVar.kpV.oHi = new a$1(aVar);
                if (aVar.kpV.bJt() <= 0) {
                    com.tencent.mm.plugin.ipcall.a.i.aXr().aXP();
                }
                aVar.fT(aVar.kpY);
                aVar.bTv = true;
            }
            if (!(!aXs.kqj || aXs.kqi || aXs.kqh == null)) {
                aXs.kqh.fW(true);
            }
            if (!(!aXs.kqi || aXs.kqj || aXs.kqh == null)) {
                aXs.kqh.fX(true);
            }
        }
        com.tencent.mm.plugin.ipcall.a.i.aXr().aXO();
        com.tencent.mm.plugin.ipcall.a.i.aXs().aiN();
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().aXm() && !this.knS) {
            com.tencent.mm.plugin.ipcall.a.i.aXr().aXR();
            com.tencent.mm.plugin.ipcall.a.i.aXq().aXJ();
            this.knS = true;
            this.koa = bi.VE();
            YN();
            if (this.knQ != null) {
                this.knQ.aWW();
            }
            k kVar = this.knR;
            if (kVar != null) {
                x.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[]{Long.valueOf(kVar.sKx)});
                if (kVar.sKx != -1) {
                    kVar.field_status = 3;
                    com.tencent.mm.plugin.ipcall.a.i.aXw().a(kVar);
                }
            }
            com.tencent.mm.plugin.ipcall.a.i.aXr().aXQ();
            p.bKK().bKL();
            p.bKK().oMP = this;
        }
    }

    public final void rt(int i) {
        x.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[]{f.stateToString(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
        if (com.tencent.mm.plugin.ipcall.a.i.aXq().kqA) {
            x.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
            if (cK(5, i)) {
                d(5, null, ad.getContext().getString(R.l.calling_failed_network), 1);
                return;
            }
            return;
        }
        x.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
        if (cK(4, i)) {
            d(4, null, ad.getContext().getString(R.l.calling_failed_network), 1);
        }
    }

    public final boolean cK(int i, int i2) {
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().aXm()) {
            if (i == 0) {
                return L(9, i, i2);
            }
            return L(11, i, i2);
        } else if (i == 0) {
            return L(8, i, i2);
        } else {
            return L(12, i, i2);
        }
    }

    public final void aWP() {
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState != 5) {
            x.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aXs = com.tencent.mm.plugin.ipcall.a.i.aXs();
        x.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (aXs.kqf != null) {
            com.tencent.mm.plugin.ipcall.ui.j jVar = aXs.kqf;
            if (jVar.kzI != null) {
                jVar.kzI.setVisibility(0);
            }
            if (jVar.kzJ != null) {
                jVar.kzJ.setVisibility(0);
            }
        }
        if (!au.HV().daT.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aXs.kqk > 30000) {
                aXs.kqk = currentTimeMillis;
                com.tencent.mm.plugin.voip.model.i.bJI().yJ(R.k.voip_bad_netstatus_hint);
            }
        }
    }

    public final void aWQ() {
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState != 5) {
            x.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.ipcall.a.i.aXt().mCurrentState)});
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b aXs = com.tencent.mm.plugin.ipcall.a.i.aXs();
        x.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
        if (aXs.kqf != null) {
            aXs.kqf.aYv();
        }
    }

    public final void aWR() {
        int i;
        CharSequence string;
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().aXm()) {
            Context context = ad.getContext();
            i = R.l.ip_call_minimize_wording_with_time;
            Object[] objArr = new Object[1];
            objArr[0] = String.format("%02d:%02d", new Object[]{Long.valueOf(bi.bG(this.koa) / 60), Long.valueOf(bi.bG(this.koa) % 60)});
            string = context.getString(i, objArr);
        } else {
            string = ad.getContext().getString(R.l.ip_call_minimize_wording);
        }
        Intent intent = new Intent(ad.getContext(), IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        PendingIntent activity = PendingIntent.getActivity(ad.getContext(), 42, intent, 134217728);
        i = R.g.notification_icon_gray;
        if (com.tencent.mm.compatible.util.d.fS(19)) {
            i = R.g.notification_icon;
        }
        Notification notification = new Builder(ad.getContext()).setTicker(ad.getContext().getString(R.l.ip_call_minimize_wording)).setWhen(System.currentTimeMillis()).setContentTitle(ad.getContext().getString(R.l.ip_call_func_name)).setContentText(string).setContentIntent(activity).getNotification();
        notification.icon = i;
        notification.flags |= 32;
        au.getNotification().a(42, notification, false);
        if (com.tencent.mm.plugin.ipcall.a.i.aXt().aXm()) {
            com.tencent.mm.plugin.voip.model.i.bJJ().wQ(aWT());
        } else {
            com.tencent.mm.plugin.voip.model.i.bJJ().OI(ad.getContext().getString(R.l.multitalk_waiting_wording));
        }
    }

    public final void aWS() {
        synchronized (this.iVA) {
            this.knY = false;
            com.tencent.mm.plugin.voip.model.i.bJJ().dismiss();
            ((NotificationManager) ad.getContext().getSystemService("notification")).cancel(42);
        }
    }

    public final int aWT() {
        int bG = (int) bi.bG(this.koa);
        return bG > 0 ? bG : 0;
    }

    private void YN() {
        x.i("MicroMsg.IPCallManager", "startTimeCount");
        if (this.bAZ != null) {
            this.bAZ.SO();
            return;
        }
        if (this.bAZ == null) {
            this.bAZ = new al(Looper.getMainLooper(), new 6(this), true);
        }
        this.bAZ.J(1000, 1000);
    }
}
