package com.tencent.mm.plugin.voip.model;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.protocal.c.cah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ArrayBlockingQueue;

public class v2protocal {
    public static final int lsT;
    private static final String[] oIK = new String[]{"OMX.qcom.", "OMX.Exynos.", "OMX.hisi"};
    public static final int oOf;
    public static boolean oOg = false;
    public static c oPU = null;
    public static Surface oPW = null;
    private static int oPw = 10;
    public static int ovW;
    int bitrate = 300;
    public int channelStrategy = 0;
    public long dTS = 0;
    public int defaultHeight = aq.CTRL_BYTE;
    public int defaultWidth = 320;
    public int[] field_ChannelReportDial = null;
    public int[] field_EngineReportStatFromApp = null;
    public int field_HWEncH = 0;
    public int field_HWEncW = 0;
    public int[] field_SpeedTestSvrParaArray = null;
    public int field_audioDuration = 0;
    public byte[] field_capInfo = null;
    int field_channelReportLength = 0;
    int field_channelStatLength = 0;
    public int field_connectingStatusKey = 0;
    int field_engine2ndReportLength = 0;
    int field_engine2ndStatLength = 0;
    int field_engineQosStatLength = 0;
    int field_engineVersionStatLength = 0;
    public int[] field_jbmBitratRsSvrParamArray = null;
    public double[] field_jbmBitratRsSvrParamDoubleArray = null;
    public int field_jbmParamArraySize = 0;
    public int field_jbmParamDoubleArraySize = 0;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_mGetValidSample = 0;
    int field_netFlowRecv = 0;
    int field_netFlowSent = 0;
    int field_newEngineExtStatLength = 0;
    int field_newEngineReportLength = 0;
    int field_newEngineStatLength = 0;
    public byte[] field_peerId = null;
    public int field_pstnChannelInfoLength = 0;
    public int field_pstnEngineInfoLength = 0;
    public int[] field_punchSvrArray = null;
    public int field_realLinkQualityInfoBuffLen = 0;
    public int field_recvVideoLen = 120;
    public int field_relayDataSyncKey = 0;
    public int[] field_relaySvrArray = null;
    public int[] field_relayTcpSvrArray = null;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgOrien = 0;
    public int field_remoteImgWidth = 0;
    public int field_sendVideoLen = 100;
    int field_speedTestInfoLength = 0;
    int field_statInfoLength = 0;
    public int field_statusSyncKey = 0;
    public int field_videoDuration = 0;
    public int field_voipcsChannelInfoLength = 0;
    public int field_voipcsEngineInfoLength = 0;
    private ag handler = null;
    public int height = 480;
    public String kFn = "";
    public int kpo = 0;
    public long kpp = 0;
    public int kpr = 0;
    public int kpw = 0;
    public boolean lkO = false;
    public int netType = 0;
    public int oOA = 0;
    public int oOB = 65536;
    public int oOC = 0;
    public int oOD = 0;
    public int oOE = 7;
    public int oOF = 3;
    public int oOG = 3;
    public int oOH = 0;
    public int oOI = 0;
    public int oOJ = -1;
    public int oOK = -1;
    public int oOL = 0;
    public int oOM = 0;
    public int oON = 0;
    public int oOO = 0;
    public int oOP = 100;
    public int oOQ = 300;
    public int oOR = 1;
    public int oOS = 1;
    public int oOT = 0;
    public int oOU = 1;
    public int oOV = 0;
    public int oOW = 0;
    public int oOX = 0;
    public int oOY = 0;
    public int oOZ = 0;
    public int oOh = 0;
    public int oOi = 0;
    public int oOj = 0;
    public int oOk = 0;
    public long oOl = 0;
    public byte[] oOm = null;
    public byte[] oOn = null;
    public byte[] oOo = null;
    public int oOp = 0;
    public byte[] oOq = null;
    public int oOr = 500;
    public int oOs = 30;
    public int oOt = 999;
    public int oOu = 0;
    public int oOv = 20;
    public int oOw = 0;
    public int oOx = 0;
    public int oOy = 0;
    public int oOz = 0;
    public int oPA = 0;
    public int oPB = 0;
    public int oPC = 0;
    public int oPD = 0;
    public int oPE = 0;
    byte[] oPF = new byte[4096];
    byte[] oPG = new byte[2048];
    byte[] oPH = new byte[2048];
    byte[] oPI = new byte[4096];
    byte[] oPJ = new byte[4096];
    byte[] oPK = new byte[2048];
    byte[] oPL = new byte[4096];
    public byte[] oPM = new byte[2048];
    public byte[] oPN = new byte[2048];
    public byte[] oPO = new byte[2048];
    public byte[] oPP = new byte[2048];
    public int[] oPQ = new int[30];
    int oPR = 0;
    public m oPS = new m();
    public d oPT = null;
    int oPV = 8;
    public boolean oPX = false;
    public int oPa = 0;
    public int oPb = 0;
    public int oPc = 0;
    public int oPd = 0;
    public int oPe = 0;
    public int[] oPf = null;
    public int oPg = 0;
    public int oPh = 0;
    public int oPi = 0;
    public int oPj = 0;
    public byte[] oPk = null;
    public int oPl = 0;
    public int oPm = 0;
    public int oPn = 0;
    public int oPo = 0;
    public byte[] oPp = new byte[1500];
    public int oPq = 0;
    public byte[] oPr = null;
    public byte[] oPs = null;
    public int oPt = 0;
    public int oPu = 0;
    public int oPv = 0;
    public ArrayBlockingQueue<byte[]> oPx = new ArrayBlockingQueue(oPw);
    public long oPy = 0;
    public byte[] oPz = new byte[8];
    public int width = 640;

    private native int forceredirect(int i, int i2);

    private native int setsvraddr(int i, int i2, int i3, String str, String str2);

    private native int uninit(int i, long j, int i2);

    public native int SendDTMF(int i);

    public native int SendRUDP(byte[] bArr, int i);

    public native int SetDTMFPayload(int i);

    public native int StartSpeedTest(long j, int i);

    public native int StopSpeedTest();

    public native int app2EngineDataEx(int i, int i2, byte[] bArr, int i3, int i4);

    public native int app2EngineLinkQualityEx(int i, byte[] bArr);

    public native int connectToPeer();

    public native int connectToPeerDirect();

    public native int connectToPeerRelay();

    public native int doubleLinkSwitch(int i);

    public native int exchangeCabInfo(byte[] bArr, int i);

    public native int freeJNIReport();

    public native int getAVDuration(byte[] bArr, int i);

    public native int getChannelInfo(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int getChannelReport(byte[] bArr, int i);

    public native int getCurrentConnType();

    public native int getEngine2ndInfo(byte[] bArr, int i);

    public native int getEngine2ndInfoReport(byte[] bArr, int i);

    public native int getEngineQosInfo(byte[] bArr, int i);

    public native int getEngineVersionInfo(byte[] bArr, int i);

    public native int getNewEngineExtInfo(byte[] bArr, int i);

    public native int getNewEngineInfo(byte[] bArr, int i);

    public native int getNewEngineInfoReport(byte[] bArr, int i);

    public native int getPstnChannelInfo(byte[] bArr, int i, int i2, int i3);

    public native int getPstnEngineInfo(byte[] bArr, int i);

    public native int getStatInfo(byte[] bArr, int i, int[] iArr, int i2);

    public native int getVideoHWDecode(int[] iArr, byte[] bArr, int i);

    public native int getVoipcsChannelInfo(byte[] bArr, int i, int i2);

    public native int getVoipcsEngineInfo(byte[] bArr, int i);

    public native int getcurstrategy();

    public native int handleCommand(byte[] bArr, int i);

    public native int init(int i, int i2, int i3, int i4, int i5, int i6, String str, int i7);

    public native int isDCReady();

    public native int isDCSameLan();

    public native int isRelayConnReady();

    public native int parseSyncKeyBuff(byte[] bArr, int i);

    public native int playCallback(byte[] bArr, int i);

    public native int recordCallback(byte[] bArr, int i, int i2);

    public native int setActive();

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int setConfigInfo(int i, long j, int i2, long j2, byte[] bArr, int i3, int i4, int i5, int i6, int i7, byte[] bArr2, int i8, int i9, int i10, int i11, byte[] bArr3, int i12, int i13);

    public native int setInactive();

    public native int setJNIAppCmd(int i, byte[] bArr, int i2);

    public native int setNetSignalValue(int i, int i2);

    public native int setSvrConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native int setjbmbitraterssvrparam();

    public native int startEngine();

    public native int videoDecode(int[] iArr);

    public native int videoEncodeToLocal(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public native int videoEncodeToSend(byte[] bArr, int i, int i2, int i3, int i4);

    public native int videoHWDecode(byte[] bArr);

    public native int videoHWProcess(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2);

    public native int videoRorate90D(byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7, int i8);

    static {
        int zj = m.zj();
        if ((zj & 1024) != 0) {
            d.y(ad.getContext(), "libvoipCodec_v7a.so");
        } else if ((zj & 512) != 0) {
            d.y(ad.getContext(), "libvoipCodec.so");
        } else {
            d.y(ad.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", v2protocal.class.getClassLoader());
        zj = m.zj();
        ovW = zj;
        zj = (zj & 1024) != 0 ? 16000 : 8000;
        lsT = zj;
        oOf = ((zj / 1000) * 20) * 2;
    }

    public final int tf(int i) {
        int appCmd = setAppCmd(i, new byte[]{(byte) 0}, 1);
        if (appCmd < 0) {
            a.eU("MicroMsg.Voip", "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        return appCmd;
    }

    public static String bLs() {
        String str = Build.MANUFACTURER;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.MODEL;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        String str3 = VERSION.SDK;
        if (str3.contains(",")) {
            str3 = str3.replace(',', ' ');
        }
        String str4 = VERSION.RELEASE;
        if (str4.contains(",")) {
            str4 = str3.replace(',', ' ');
        }
        return "," + str + "," + str2 + "," + str3 + "," + str4;
    }

    public static long aU(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getLong();
    }

    private String bLt() {
        return "," + this.channelStrategy;
    }

    public final String bLu() {
        if (this.field_videoDuration == 0) {
            a.eV("MicroMsg.Voip", "captureFrames:" + this.oPA + ", videoduration: 0");
            return ",0";
        }
        a.eV("MicroMsg.Voip", "capturefps:" + (this.oPA / this.field_videoDuration) + " framecount:" + this.oPA + " videoDuration:" + this.field_videoDuration);
        return "," + (this.oPA / this.field_videoDuration);
    }

    private String bLv() {
        a.eV("MicroMsg.Voip", "usePreConnect:" + this.oON);
        return "," + this.oON;
    }

    private String bLw() {
        a.eV("MicroMsg.Voip", "preConnectSuccess:" + this.oOO);
        return "," + this.oOO;
    }

    public final String bLx() {
        if (VERSION.SDK_INT < 11) {
            this.oOF = 0;
            this.oOG = 2;
        } else {
            this.oOF = 3;
            this.oOG = 3;
        }
        if (q.deN.dbY >= 0) {
            this.oOF = q.deN.dbY;
        }
        if (VERSION.SDK_INT >= 11 && l.xZ() && 2 == q.deW.ddH) {
            this.oOG = 2;
        }
        if (q.deN.dbZ >= 0) {
            this.oOG = q.deN.dbZ;
        }
        if (VERSION.SDK_INT < 11) {
            this.oOE = 1;
        } else {
            this.oOE = 7;
        }
        if (q.deN.dby) {
            this.oOE = 1;
        }
        if (q.deN.dbX >= 0) {
            this.oOE = q.deN.dbX;
        }
        if (q.deN.dbz > 0) {
            this.oOH = 3;
            this.oOI = 0;
        } else if (q.deN.dca >= 0) {
            this.oOH = q.deN.dca;
            this.oOI = q.deN.dca;
        }
        if (q.deN.dcb >= 0) {
            this.oOH = q.deN.dcb;
        }
        if (q.deN.dcc >= 0) {
            this.oOI = q.deN.dcc;
        }
        return "," + this.oOF + "," + this.oOG + "," + this.oOE + "," + this.oOH + "," + this.oOI;
    }

    public v2protocal(ag agVar) {
        this.handler = agVar;
    }

    public int keep_onNotifyFromJni(int i, int i2, byte[] bArr) {
        if (i == 100) {
            a.b(bArr, "MicroMsg.Voip", i2);
        } else if (i == 101) {
            a.b(bArr, "MicroMsg.v2Core", i2);
        } else {
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = bArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public int keep_onNotifyFromJniInt(int i, int i2, int[] iArr) {
        if (iArr != null) {
            a.eV("MicroMsg.VoipService", "callByJni : arg1:" + i + " arg2:" + i2);
            Message message = new Message();
            message.what = 59998;
            message.arg1 = i;
            message.arg2 = i2;
            message.obj = iArr;
            this.handler.sendMessage(message);
        }
        return 0;
    }

    public final int a(byy byy, byy byy2, byy byy3, int i, int i2) {
        if (byy == null || byy.suW <= 0) {
            a.eU("MicroMsg.Voip", "forceRedirect: [TRANSPORT]No relay svr ip");
        } else {
            a.eU("MicroMsg.Voip", "forceRedirect: got relay svr addr from server");
            this.field_relaySvrArray = a.a(byy);
        }
        if (byy2 == null || byy2.suW <= 0) {
            a.eU("MicroMsg.Voip", "forceRedirect: No punch svr ip");
        } else {
            a.eU("MicroMsg.Voip", "forceRedirect: got punch svr addr from server");
            this.field_punchSvrArray = a.a(byy2);
        }
        if (byy3 == null || byy3.suW <= 0) {
            a.eU("MicroMsg.Voip", "forceRedirect: No relay tcp svr ip");
        } else {
            a.eU("MicroMsg.Voip", "forceRedirect: got relay tcp svr addr from server");
            this.field_relayTcpSvrArray = a.a(byy3);
        }
        int forceredirect = forceredirect(i, i2);
        a.eU("MicroMsg.Voip", "v2protocal forceRedirect ret :" + forceredirect);
        return forceredirect;
    }

    public final int a(byy byy, byy byy2, byy byy3, cah cah) {
        if (byy.suW > 0) {
            a.eU("MicroMsg.Voip", "setSvrAddr: got relay svr addr from server");
            this.field_relaySvrArray = a.a(byy);
        } else {
            a.eU("MicroMsg.Voip", "setSvrAddr: [TRANSPORT]No relay svr ip");
        }
        if (byy2.suW > 0) {
            a.eU("MicroMsg.Voip", "setSvrAddr: got punch svr addr from server");
            this.field_punchSvrArray = a.a(byy2);
        } else {
            a.eU("MicroMsg.Voip", "setSvrAddr: No punch svr ip");
        }
        if (byy3.suW > 0) {
            a.eU("MicroMsg.Voip", "setSvrAddr:got tcpsvr addr from server");
            this.field_relayTcpSvrArray = a.a(byy3);
        } else {
            a.eU("MicroMsg.Voip", "setSvrAddr:no tcp svr addr ip");
        }
        int i = setsvraddr(cah.swD, cah.swE, cah.swF, cah.userName, cah.eSH);
        a.eU("MicroMsg.Voip", "v2protocal setsvraddr ret :" + i);
        return i;
    }

    public final int bGN() {
        int i;
        this.netType = a.getNetType(ad.getContext());
        this.oOj = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z = this.oOj >= 4 && (ovW & 1024) != 0 && (ovW & b.CTRL_BYTE) >= 26;
        boolean z2 = z && (ovW & b.CTRL_BYTE) >= 30;
        boolean z3 = q.deM.ddl > 0 && q.deM.dcN.width >= 480 && q.deM.dcN.height >= 360 && q.deM.dcP.width >= 480 && q.deM.dcP.height >= 360;
        boolean z4 = q.deM.ddl >= 2 && q.deM.dcN.width >= 640 && q.deM.dcN.height >= 480 && q.deM.dcP.width >= 640 && q.deM.dcP.height >= 480;
        boolean z5 = q.deM.ddl == 0;
        Object obj = q.deM.ddm == 0 ? 1 : null;
        Object obj2 = q.deM.ddm > 0 ? 1 : null;
        this.oPX = false;
        if (obj == null) {
            int i2;
            boolean z6;
            boolean z7;
            if (z2) {
                String str = "video/avc";
                Object obj3 = null;
                if (VERSION.SDK_INT >= 21) {
                    for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
                        MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                        a.eV("MicroMsg.Voip", "steve codecInfo : " + codecInfoAt.getName());
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        String name = codecInfoAt.getName();
                        for (String equalsIgnoreCase : supportedTypes) {
                            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                                obj3 = 1;
                                a.eV("MicroMsg.Voip", "steve : H.264 HW encoder found:" + name);
                            }
                        }
                    }
                }
                if (obj3 != null) {
                    z6 = true;
                    if (obj2 == null) {
                        obj2 = (q.deM.ddm & 16) != 0 ? 1 : null;
                        boolean z8 = z6 && (q.deM.ddm & 15) != 0;
                        z7 = z8;
                    } else {
                        obj2 = null;
                        z7 = z6;
                    }
                    this.oPX = z7;
                    a.eU("MicroMsg.Voip", "hwH264Local:" + z6 + ",hwHEVCLocal:false, bSupportH264HW:" + z7 + ", bSupportHEVCHW:false, svrHWCfg:" + q.deM.ddm);
                    if (z7) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    i = obj2 == null ? i2 | 2 : i2;
                }
            }
            z6 = false;
            if (obj2 == null) {
                obj2 = null;
                z7 = z6;
            } else {
                obj2 = (q.deM.ddm & 16) != 0 ? 1 : null;
                boolean z82 = z6 && (q.deM.ddm & 15) != 0;
                z7 = z82;
            }
            if (z7) {
            }
            this.oPX = z7;
            a.eU("MicroMsg.Voip", "hwH264Local:" + z6 + ",hwHEVCLocal:false, bSupportH264HW:" + z7 + ", bSupportHEVCHW:false, svrHWCfg:" + q.deM.ddm);
            if (z7) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (obj2 == null) {
            }
        } else {
            i = 0;
        }
        if ((z || z3) && !z5) {
            if (this.oPX || z4) {
                this.defaultWidth = 640;
                this.defaultHeight = 480;
            } else {
                this.defaultWidth = 480;
                this.defaultHeight = 360;
            }
            oOg = true;
            a.eU("MicroMsg.Voip", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
        a.eU("MicroMsg.Voip", "steve: Android CPUFlag:" + (ovW & b.CTRL_BYTE) + ", 480x360 Enc flags: bEnable480FromLocal:" + z + ", bEnable480FromSvr:" + z3 + ", bDisable480FromSvr:" + z5 + ", bEnable640FromLocal:" + z2 + ", bEnable640FromSvr:" + z4);
        this.oPf = new int[(this.defaultWidth * this.defaultHeight)];
        au.HU();
        this.oOi = c.Df();
        if ((ovW & 1024) != 0) {
            d.y(ad.getContext(), "libvoipCodec_v7a.so");
            a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
        } else if ((ovW & 512) != 0) {
            d.y(ad.getContext(), "libvoipCodec.so");
            a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
        } else {
            d.y(ad.getContext(), "libvoipCodec_v5.so");
            a.eV("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
        }
        int i3 = VERSION.SDK_INT;
        int bMg = OpenGlRender.bMg();
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        int init = init(this.netType | (i << 8), 2, (this.defaultWidth << 16) | this.defaultHeight, (defaultDisplay.getWidth() << 16) | defaultDisplay.getHeight(), this.oOi, ovW | ((bMg << 24) | (i3 << 16)), e.duM + "app_lib/", 0);
        a.eU("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + this.oOi + ", gl_vs:" + bMg + ", cpuFlag0=" + ovW + ", hwCap= " + i);
        this.lkO = true;
        if (init < 0) {
            reset();
        }
        return init;
    }

    public final String iT(boolean z) {
        if (this.lkO) {
            a.eU("MicroMsg.Voip", "call protocalUninit now...needStatInfo=" + z);
            this.field_ChannelReportDial = new int[6];
            this.field_ChannelReportDial[0] = this.oPS.oLa;
            this.field_ChannelReportDial[1] = this.oPS.oLg;
            this.field_ChannelReportDial[2] = this.oPg;
            this.field_ChannelReportDial[3] = this.oPh;
            this.field_ChannelReportDial[4] = this.oPi;
            this.field_ChannelReportDial[5] = this.oPj;
            this.field_EngineReportStatFromApp = new int[12];
            bLx();
            this.field_EngineReportStatFromApp[0] = this.oOz;
            this.field_EngineReportStatFromApp[1] = this.oOA;
            this.field_EngineReportStatFromApp[2] = this.oOF;
            this.field_EngineReportStatFromApp[3] = this.oOG;
            this.field_EngineReportStatFromApp[4] = this.oOE;
            this.field_EngineReportStatFromApp[5] = this.oOH;
            this.field_EngineReportStatFromApp[6] = this.oOI;
            this.field_EngineReportStatFromApp[7] = -1;
            if (this.oPT != null) {
                this.field_EngineReportStatFromApp[8] = this.oPT.oIE;
                this.field_EngineReportStatFromApp[9] = this.oPT.oIG;
                this.field_EngineReportStatFromApp[10] = this.oPT.oIh;
            } else {
                this.field_EngineReportStatFromApp[8] = 0;
                this.field_EngineReportStatFromApp[9] = 0;
                this.field_EngineReportStatFromApp[10] = 0;
            }
            if (oPU != null) {
                this.field_EngineReportStatFromApp[11] = oPU.oId;
            } else {
                this.field_EngineReportStatFromApp[11] = 0;
            }
            this.lkO = false;
            uninit(this.kpo, this.kpp, this.kpw);
            oOg = false;
            if (this.oPT != null) {
                this.oPT.bJz();
                this.oPT = null;
            }
            if (oPU != null) {
                oPU.interrupt();
                oPU.bJz();
                oPU = null;
            }
            oPW = null;
            a.eU("MicroMsg.Voip", "uninit over.");
            if (z) {
                getStatInfo(this.oPF, this.oPF.length, this.oPQ, 30);
                getEngineVersionInfo(this.oPG, this.oPG.length);
                getEngineQosInfo(this.oPH, this.oPH.length);
                StringBuilder stringBuilder = new StringBuilder();
                long j = (long) this.oOi;
                if (this.oOi < 0) {
                    j = ((long) this.oOi) + 4294967296L;
                }
                StringBuilder append = new StringBuilder().append(j).append(",").append(this.kpp).append(",").append(this.kpo).append(",").append(this.kpw).append(",");
                m mVar = this.oPS;
                String stringBuilder2 = append.append(mVar.oKQ + "," + mVar.oKR + "," + mVar.oKS + "," + mVar.oKT + "," + mVar.oKU + "," + mVar.oKV + "," + mVar.oKW + "," + mVar.oKX + "," + mVar.oKY + "," + mVar.oKZ + "," + mVar.oLa).toString();
                a.eU("MicroMsg.Voip", "voipreport:DailStatString:" + stringBuilder2);
                append = stringBuilder.append(stringBuilder2).append(new String(this.oPF, 0, this.field_statInfoLength)).append(bLs()).append(bLt()).append("," + this.oPS.oLb).append(new String(this.oPG, 0, this.field_engineVersionStatLength)).append(bLu());
                a.eV("MicroMsg.Voip", "cpuCapacity:" + ovW);
                stringBuilder2 = append.append("," + ovW).append(bLv()).append(bLw()).append(new String(this.oPH, 0, this.field_engineQosStatLength)).toString();
                a.eU("MicroMsg.Voip", "statInfoBuffer = " + new String(this.oPF, 0, this.field_statInfoLength));
                a.eU("MicroMsg.Voip", "engineVersionInfoBuffer = " + new String(this.oPG, 0, this.field_engineVersionStatLength));
                a.eU("MicroMsg.Voip", "engineQosInfoBuffer = " + new String(this.oPH, 0, this.field_engineQosStatLength));
                a.eU("MicroMsg.Voip", "voipreport:StatString = " + stringBuilder2);
                am.a.dBs.aY(this.field_netFlowRecv, this.field_netFlowSent);
                a.eV("MicroMsg.Voip", "voip net flow = " + (this.field_netFlowSent + this.field_netFlowRecv));
                return stringBuilder2;
            }
        }
        return "";
    }

    public static String bLy() {
        return "\u0000";
    }

    public final String bLz() {
        long j = 0;
        if (this.oOx == 0 && this.oOy == 0) {
            this.oPS.oLh = 0;
        } else if (this.oOy != 0 && this.oOx != 0) {
            this.oPS.oLh = 3;
        } else if (this.oOy != 0) {
            this.oPS.oLh = 1;
        } else if (this.oOx != 0) {
            this.oPS.oLh = 2;
        }
        this.oPS.oLp = a.getNetType(ad.getContext());
        this.oPS.oLo = this.field_videoDuration;
        this.oPS.oLn = this.field_audioDuration;
        this.oOC = au.HV().yP();
        long j2 = (this.oPS.oLx <= 0 || this.oPS.oLr <= this.oPS.oLx) ? 0 : this.oPS.oLr - this.oPS.oLx;
        a.eV("MicroMsg.Voip", "voipreport:acceptcalltime:" + j2);
        setJNIAppCmd(1, this.oPz, this.oPz.length);
        long aU = aU(this.oPz);
        m mVar = this.oPS;
        long j3 = (aU <= this.oPS.oLv || this.oPS.oLv <= 0) ? 0 : aU - this.oPS.oLv;
        mVar.oLy = j3;
        m mVar2 = this.oPS;
        if (aU > this.oPS.oLx && this.oPS.oLx > 0) {
            j = aU - this.oPS.oLx;
        }
        mVar2.oLz = j;
        a.eV("MicroMsg.Voip", "voipreport:lCallerWaitTime:" + this.oPS.oLy + " lCalledWaitTime:" + this.oPS.oLz);
        StringBuilder append = new StringBuilder().append(this.oOw).append(",").append(this.kpo).append(",").append(this.kpp).append(",").append(this.kpw).append(",").append(this.oPS.oKQ).append(",").append(this.oPS.oLc).append(",").append(this.oPS.oLd).append(",").append(this.oPS.oLe).append(",").append(this.oPS.oLf).append(",").append(this.oPS.oLg).append(",").append(this.oPS.oLh).append(",").append(this.oPS.oLa).append(",").append(this.oPS.oLi).append(",").append(this.oPS.oLj).append(",").append(this.oPS.oLk).append(",").append(this.oPS.oLl).append(",").append(this.oPS.oLm).append(",").append(this.oPS.oLn).append(",").append(this.oPS.oLo).append(",").append(this.oPS.oLp).append(bLv()).append(bLw()).append(bLs()).append(",").append(this.oPS.oLq).append(",").append(this.oOB).append(",").append(this.oOC).append(",").append(j2).append(",").append(this.oPS.oLy).append(",").append(this.oPS.oLz).append(",").append(this.oOD).append(",").append(this.oOj).append(bLt()).append(",").append(ovW & b.CTRL_BYTE).append(",").append(this.oOJ).append(",").append(this.oOK);
        String str = VERSION.INCREMENTAL;
        if (str.contains(",")) {
            str = str.replace(',', ' ');
        }
        String str2 = Build.DISPLAY;
        if (str2.contains(",")) {
            str2 = str2.replace(',', ' ');
        }
        str = append.append("," + str + "," + str2).append(",").append(this.oPS.oLs).append(",").append(this.oPS.oLu).append(",").append(this.oPS.oLt).append(",0,").append(this.oPS.oLA).toString();
        a.eU("MicroMsg.Voip", "voipreport:initNetType:" + this.oOj);
        a.eU("MicroMsg.Voip", "voipreport:NewDialStatString:" + str);
        a.eU("MicroMsg.Voip", "voipreport:getChannelStrategyString:" + bLt());
        return str;
    }

    public final String bLA() {
        getChannelInfo(this.oPI, this.oPI.length, this.oPg, this.oPh, this.oPi, this.oPj);
        a.eU("MicroMsg.Voip", "voipreport:oldChannelString: " + (this.kpp + "," + this.kpo + "," + this.kpw + this.oPS.bKh() + ("," + this.oPS.oLg) + new String(this.oPI, 0, this.field_channelStatLength)));
        getChannelReport(this.oPI, this.oPI.length);
        String str = new String(this.oPI, 0, this.field_channelReportLength);
        a.eU("MicroMsg.Voip", "voipreport:newChannelString: " + str);
        return str;
    }

    public final String bLB() {
        getNewEngineInfo(this.oPJ, this.oPJ.length);
        getNewEngineExtInfo(this.oPK, this.oPK.length);
        a.eU("MicroMsg.Voip", "voipreport:oldNewEngineString:" + (this.kpw + "," + this.kpp + this.oPS.bKh() + "," + this.oOx + "," + this.oOy + bLu() + new String(this.oPJ, 0, this.field_newEngineStatLength) + "," + this.oOz + "," + this.oOA + bLx() + new String(this.oPK, 0, this.field_newEngineExtStatLength)));
        getNewEngineInfoReport(this.oPJ, this.oPJ.length);
        String str = this.kpw + "," + this.kpp + this.oPS.bKh() + "," + this.oOx + "," + this.oOy + bLu() + new String(this.oPJ, 0, this.field_newEngineReportLength);
        a.eU("MicroMsg.Voip", "voipreport:yaoyaoguoNewEngineString:" + str);
        return str;
    }

    public final String bLC() {
        getEngine2ndInfo(this.oPL, this.oPL.length);
        a.eU("MicroMsg.Voip", "voipreport:12805,oldEngine2ndString:" + (this.kpp + "," + this.kpo + "," + this.kpw + new String(this.oPL, 0, this.field_engine2ndStatLength)));
        getEngine2ndInfoReport(this.oPL, this.oPL.length);
        String str = this.kpp + "," + this.kpo + "," + this.kpw + new String(this.oPL, 0, this.field_engine2ndReportLength);
        a.eU("MicroMsg.Voip", "voipreport:12805,newEngine2ndString:" + str);
        return str;
    }

    public final void reset() {
        a.eU("MicroMsg.Voip", "v2protocal reset!");
        this.field_punchSvrArray = null;
        this.field_relaySvrArray = null;
        this.field_relayTcpSvrArray = null;
        this.field_peerId = null;
        this.field_capInfo = null;
        this.kpo = 0;
        this.oOl = 0;
        this.oOk = 0;
        this.kpw = 0;
        this.kpp = 0;
        this.channelStrategy = 0;
        this.kpr = 0;
        this.dTS = 0;
        this.oOm = null;
        this.oOn = null;
        this.oOo = null;
        this.oOp = 0;
        this.oOq = null;
        this.oPj = 0;
        this.oPk = null;
        this.oPl = 0;
        this.oPm = 0;
        this.oPr = null;
        this.oPs = null;
        this.oPA = 0;
        this.oPB = 0;
        this.oPC = 0;
        this.oPD = 0;
        this.oPE = 0;
        this.field_videoDuration = 0;
        this.field_audioDuration = 0;
        this.oPR = 0;
        this.oOO = 0;
        this.oON = 0;
        this.field_engineVersionStatLength = 0;
        this.field_engineQosStatLength = 0;
        this.field_statusSyncKey = 0;
        this.field_relayDataSyncKey = 0;
        this.field_connectingStatusKey = 0;
        this.oOz = 0;
        this.oOA = 0;
        this.oOB = 65536;
        this.oOC = 0;
        this.oOD = 0;
        this.oOK = -1;
        this.oOL = 0;
        this.oPv = 0;
        this.oOh = 0;
        this.kFn = "";
        this.oPt = 0;
        this.oPu = 0;
        this.oPS.reset();
        this.oPS.bKg();
        oOg = false;
        this.field_jbmBitratRsSvrParamArray = null;
        this.field_jbmParamArraySize = 0;
        this.field_jbmBitratRsSvrParamDoubleArray = null;
        this.field_jbmParamDoubleArraySize = 0;
        a.eU("MicroMsg.Voip", "freeJNIReport : " + freeJNIReport() + ". [0: null, no need to free, 1: free success!]");
    }
}
