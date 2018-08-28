package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiManager;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.plugin.voip.model.a.j;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.protocal.c.bzb;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.cak;
import com.tencent.mm.protocal.c.cav;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class j$3 extends ag {
    final /* synthetic */ j oKq;

    j$3(j jVar, Looper looper) {
        this.oKq = jVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        byte[] bArr;
        int i;
        int[] iArr;
        if (message == null || message.what != 59998) {
            super.handleMessage(message);
        } else if (message.arg1 == 1) {
            if (this.oKq.oJX.kpo == 0) {
                a.eT("MicroMsg.Voip.VoipContext", "JNI_DOSYNC without roomid , igored!");
                return;
            }
            a.eU("MicroMsg.Voip.VoipContext", "need dosync for cmd from channel...");
            bArr = (byte[]) message.obj;
            t tVar = this.oKq.oKa;
            i = message.arg2;
            cak cak = new cak();
            cak.hcE = 1;
            bhy bhy = new bhy();
            bhy.bq(bArr);
            cak.rfy = bhy;
            bhy bhy2 = new bhy();
            try {
                bhy2.bq(cak.toByteArray());
                bzt bzt = new bzt();
                bzt.rtM = i;
                bzt.rtN = bhy2;
                bzt.jTv = q.GF();
                bzu bzu = new bzu();
                bzu.hbF = 1;
                bzu.hbG.add(bzt);
                tVar.a(bzu, true, 2);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
            }
        } else if (message.arg1 == 4) {
            if (this.oKq.oJX.kpo == 0) {
                a.eT("MicroMsg.Voip.VoipContext", "JNI_STARTDEVFAILED without roomid , igored!");
                return;
            }
            a.eU("MicroMsg.Voip.VoipContext", "need hangUP for startTalk failed. ");
            this.oKq.oJX.oPS.oKQ = 107;
            this.oKq.o(1, -9004, "");
        } else if (message.arg1 == 6) {
            a.eU("MicroMsg.Voip.VoipContext", "OnChannelConnected from JNI");
            if (this.oKq.oJX.kpo == 0) {
                a.eU("MicroMsg.Voip.VoipContext", "OnChannelConnected roomid null, ignored");
                return;
            }
            this.oKq.oJv = true;
            this.oKq.oJX.oPS.oLg = 1;
            if (this.oKq.bXc || this.oKq.oJw) {
                this.oKq.oJX.oOO = 0;
            } else {
                this.oKq.oJX.oOO = 1;
            }
            this.oKq.oJX.setInactive();
            a.eU("MicroMsg.Voip.VoipContext", "Voip.Channel setInactive");
            this.oKq.bJT();
        } else if (message.arg1 == 3) {
            j.b(this.oKq);
        } else if (message.arg1 == 5) {
            a.eU("MicroMsg.Voip.VoipContext", "need hangUP for disconnect from channel..envent = " + message.arg2);
            if (j.c(this.oKq) >= 5) {
                this.oKq.oJX.oPS.oKQ = 108;
            } else {
                this.oKq.oJX.oPS.oKQ = 106;
            }
            if (message.arg2 == 4) {
                this.oKq.oJX.oPS.oLi = 1;
                a.eU("MicroMsg.Voip.VoipContext", "channel broken...");
            } else if (message.arg2 == 1) {
                if (this.oKq.oJz) {
                    a.eU("MicroMsg.Voip.VoipContext", "channel connect fail while pre-connect");
                    this.oKq.oJy = true;
                    return;
                }
                a.eU("MicroMsg.Voip.VoipContext", "channel connect fail...");
                this.oKq.oJv = false;
                this.oKq.oJX.oPS.oLi = 5;
            } else if (message.arg2 == 5) {
                if (this.oKq.oJy) {
                    this.oKq.oJX.oPS.oLi = 6;
                    a.eU("MicroMsg.Voip.VoipContext", "channel network fail while pre-connect...");
                    this.oKq.oJy = true;
                    return;
                }
                a.eU("MicroMsg.Voip.VoipContext", "channel network fail");
                this.oKq.oJX.oPS.oLi = 6;
            }
            this.oKq.o(1, -9000, "");
        } else if (message.arg1 == 100) {
            a.b((byte[]) message.obj, "MicroMsg.Voip.VoipContext", message.arg2);
        } else if (message.arg1 == 101) {
            a.b((byte[]) message.obj, "MicroMsg.v2Core", message.arg2);
        } else if (message.arg1 == 7) {
            int[] iArr2 = (int[]) message.obj;
            int i2 = message.arg2;
            String str = null;
            try {
                str = ((WifiManager) ad.getContext().getSystemService(TencentExtraKeys.LOCATION_SOURCE_WIFI)).getConnectionInfo().getSSID();
            } catch (Exception e2) {
                a.eU("MicroMsg.Voip.VoipContext", "Get wifiName failed in voip speedTest!");
            }
            String str2 = null;
            try {
                str2 = ((TelephonyManager) ad.getContext().getSystemService("phone")).getSimOperatorName();
            } catch (Exception e3) {
                a.eU("MicroMsg.Voip.VoipContext", "Get netName failed in voip speedTest!");
            }
            new j(this.oKq.oJE, this.oKq.oJD, this.oKq.oJF, str2, str, this.oKq.oJG, i2, iArr2).bLp();
        } else if (message.arg1 == 8) {
            bArr = (byte[]) message.obj;
            j jVar = this.oKq;
            try {
                bxi bxi = (bxi) new bxi().aG(bArr);
                if (!(jVar.oKi && bxi.stM == 1)) {
                    a.eU("MicroMsg.Voip.VoipContext", "steve: onRecvRUDPCmd:" + bxi.stM);
                }
                switch (bxi.stM) {
                    case 1:
                        if (!jVar.oKi) {
                            a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client end HWEnc!!");
                            ByteBuffer allocate = ByteBuffer.allocate(4);
                            allocate.order(ByteOrder.LITTLE_ENDIAN);
                            allocate.putInt(j.oKn);
                            jVar.oJX.setAppCmd(27, allocate.array(), 4);
                            if (bxi.stN != null) {
                                ByteBuffer wrap = ByteBuffer.wrap(bxi.stN.lR, 0, 4);
                                wrap.order(ByteOrder.LITTLE_ENDIAN);
                                int min = Math.min(wrap.getInt(), 6);
                                allocate = ByteBuffer.allocate(4);
                                allocate.order(ByteOrder.LITTLE_ENDIAN);
                                allocate.putInt(min);
                                a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:CMD_VOIP_CloseHWEnc:reset maxsizeformat: " + min);
                                jVar.oJX.setAppCmd(30, allocate.array(), 4);
                            } else {
                                a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: cmdBuffer is nil!!");
                            }
                        }
                        jVar.oKi = true;
                        return;
                    case 2:
                        a.eU("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: the other client tells us to end HWEnc!!");
                        jVar.oJZ.oKI = true;
                        return;
                    case 3:
                        if (bxi.stN != null) {
                            Object obj = bxi.stN.lR;
                            a.eU("MicroMsg.Voip.VoipContext", "steve: remote new network type:" + obj);
                            i = jVar.oJX.setAppCmd(TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY, obj, 4);
                            if (i < 0) {
                                a.eU("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + i + ", [roomid=" + jVar.oJX.kpw + ", roomkey=" + jVar.oJX.kpp + "]");
                                return;
                            }
                            return;
                        }
                        a.eU("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                        return;
                    case 4:
                        if (bxi.stN != null) {
                            bzb bzb = (bzb) new bzb().aG(bxi.stN.lR);
                            a.eU("MicroMsg.Voip.VoipContext", "zhengxue: remote audio dev occupied stat :" + bzb.svq);
                            byte[] bArr2 = new byte[4];
                            bArr2[0] = (byte) bzb.svq;
                            jVar.oJX.setJNIAppCmd(2, bArr2, 4);
                            return;
                        }
                        a.eU("MicroMsg.Voip.VoipContext", "zhengxue:[CHANNEL]EMethod_AudioDevOccupiedStatsSync empty buffer");
                        return;
                    default:
                        return;
                }
            } catch (Exception e4) {
                a.eU("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
            }
            a.eU("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
        } else if (message.arg1 == 9) {
            m mVar = this.oKq.oJX.oPS;
            if (0 == mVar.oLu) {
                mVar.oLu = System.currentTimeMillis();
                a.eU("MicroMsg.VoipDailReport", "first pkt received timestamp:" + mVar.oLu);
            }
            a.eU("MicroMsg.Voip.VoipContext", "get first pkt for voip");
            if (1 == this.oKq.oJX.oPv) {
                cav cav = new cav();
                cav.hcd = 1;
                this.oKq.oKa.a(cav, 2);
            }
        } else if (message.arg1 == 11) {
            this.oKq.oKj = 2;
        } else if (message.arg1 == 12) {
            this.oKq.oKj = 1;
        } else if (message.arg1 == 13) {
            iArr = (int[]) message.obj;
            new h(this.oKq.oJX.kpo, this.oKq.oJX.kpp, this.oKq.oJX.kpw, 1, message.arg2, iArr).bLp();
        } else if (message.arg1 == 14) {
            iArr = (int[]) message.obj;
            new h(this.oKq.oJX.kpo, this.oKq.oJX.kpp, this.oKq.oJX.kpw, 2, message.arg2, iArr).bLp();
        }
    }
}
