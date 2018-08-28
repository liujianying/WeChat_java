package com.tencent.wecall.talkroom.model;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.f.a.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.au;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.o;
import com.tencent.pb.common.b.a.a.p;
import com.tencent.pb.common.b.a.a.q;
import com.tencent.pb.common.b.a.a.r;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.wecall.talkroom.a.i;
import com.tencent.wecall.talkroom.a.j;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.a.m;
import com.tencent.wecall.talkroom.model.g.1;
import com.tencent.wecall.talkroom.model.g.11;
import com.tencent.wecall.talkroom.model.g.15;
import com.tencent.wecall.talkroom.model.g.16;
import com.tencent.wecall.talkroom.model.g.17;
import com.tencent.wecall.talkroom.model.g.18;
import com.tencent.wecall.talkroom.model.g.20;
import com.tencent.wecall.talkroom.model.g.6;
import com.tencent.wecall.talkroom.model.g.7;
import com.tencent.wecall.talkroom.model.g.8;
import com.tencent.wecall.talkroom.model.g.9;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements Callback, com.tencent.f.a.d, com.tencent.pb.common.b.b {
    private static e vco = null;
    public static String[] vxS = new String[]{"GLOBAL_TOPIC_NETWORK_CHANGE", "topic_bind_mobile_other"};
    public static List<Integer> vxn = new ArrayList();
    private static int vxu = 30000;
    public String jTX;
    boolean kFG = false;
    public int kvL;
    Handler mHandler;
    boolean mIsMute = false;
    boolean oLU = false;
    int state = 0;
    int vcc;
    private a vwP;
    private int vxA = 0;
    private int vxB = 0;
    private int vxC = 0;
    private long vxD = 0;
    private boolean vxE = true;
    private int vxF = 0;
    int vxG = -1;
    public h vxH = h.vyU;
    b vxI;
    private talk.a vxJ;
    private TimerTask vxK;
    private TimerTask vxL;
    private Timer vxM = new Timer("TalkRoomService_HelloTimer");
    private TimerTask vxN;
    private Timer vxO = new Timer("TalkRoomService_talkDurationTimer");
    g vxP = new g();
    private int vxQ = 0;
    private boolean vxR = false;
    public String vxT = null;
    HashSet<Long> vxU = new HashSet();
    public boolean vxV = false;
    public boolean vxW = true;
    public boolean vxX = true;
    private short[] vxY = null;
    private int[] vxZ = null;
    f vxm;
    private Map<String, e> vxo = new HashMap();
    private final int vxp = 1;
    private final int vxq = 2;
    private final int vxr = 3;
    private final int vxs = 4;
    public final int vxt = 6;
    private boolean vxv = false;
    private boolean vxw = false;
    private String vxx;
    public String vxy;
    public long vxz;
    private short[] vya = null;
    private int[] vyb = null;
    private int vyc = 0;
    public boolean vyd = false;
    public boolean vye = true;
    private Runnable vyf = new 8(this);
    private com.tencent.pb.common.b.d vyg = null;
    private Runnable vyh = new 9(this);

    public enum b {
        OK,
        NOT_AUTH,
        NOT_BIND,
        NOT_MATCH,
        NO_NETWORK,
        BUSY,
        NOT_VALID_STATE,
        GROUP_NOT_VALID,
        UNINIT_SERVICE_FAILED,
        INIT_ENGINE_FAILED
    }

    class d {
        String jTX;
        int kvL;
        long vxz;
    }

    static /* synthetic */ void e(f fVar) {
        if (fVar.vxI == null) {
            c.e("TalkRoomService", new Object[]{"the engine should not be null."});
            return;
        }
        c.d("TalkRoomService", new Object[]{"initMediaComponent"});
        com.tencent.pb.common.c.f.u(TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_FINAL_REASON, 1, "1");
        fVar.cHW();
        fVar.aiN();
    }

    static /* synthetic */ m j(f fVar) {
        if (TextUtils.isEmpty(fVar.jTX)) {
            c.x("TalkRoomService", new Object[]{"doHelloVoiceRoom mGroupId is null"});
            return null;
        }
        c.x("TalkRoomService", new Object[]{"doHelloVoiceRoom mGroupId: ", fVar.jTX, " mRoomId: ", Integer.valueOf(fVar.kvL), " mRoomKey: ", Long.valueOf(fVar.vxz), " selfMemberId: ", Integer.valueOf(c.cHG().adh(fVar.jTX)), " mCallData: ", Integer.valueOf(fVar.vxF)});
        m mVar = new m(fVar.jTX, fVar.kvL, fVar.vxz, r6, fVar.vxF);
        com.tencent.pb.common.b.e.cEn().a(mVar);
        return mVar;
    }

    public final boolean handleMessage(Message message) {
        Object obj;
        switch (message.what) {
            case 1:
                obj = message.obj;
                if (this.state != 4) {
                    if (!(obj instanceof d)) {
                        c.x("TalkRoomService", new Object[]{"handlerInviteTimeOut obj is not GroupRoomInfo"});
                        break;
                    }
                    d dVar = (d) obj;
                    if (dVar.jTX != null) {
                        c.d("TalkRoomService", new Object[]{"handlerInviteTimeOut"});
                        if (dVar.jTX.equals(this.jTX) && dVar.kvL == this.kvL && dVar.vxz == this.vxz) {
                            h.cIb();
                            this.vxH.Ix(TbsListener$ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_COUNTS);
                            a(dVar.jTX, dVar.kvL, dVar.vxz, 7);
                            c.x("TalkRoomService", new Object[]{"handlerInviteTimeOut groupRoomInfo.mGroupId: ", dVar.jTX});
                            break;
                        }
                    }
                    c.x("TalkRoomService", new Object[]{"handlerInviteTimeOut groupRoomInfo.mGroupId is null"});
                    break;
                }
                c.x("TalkRoomService", new Object[]{"handlerInviteTimeOut state: ", Integer.valueOf(this.state)});
                break;
            case 2:
                obj = message.obj;
                if (this.state == 1) {
                    if (!(obj instanceof a)) {
                        c.x("TalkRoomService", new Object[]{"handlerCreateGroup obj is not CreateGroupObj"});
                        break;
                    }
                    a aVar = (a) obj;
                    if (g.gr(aVar.groupId, this.jTX)) {
                        String str = aVar.groupId;
                        String[] strArr = aVar.vyv;
                        ay ayVar = aVar.vyw;
                        int i = aVar.vcN;
                        int i2 = aVar.type;
                        long j = aVar.vyx;
                        String str2 = aVar.vyy;
                        boolean z = aVar.vyz;
                        String str3 = aVar.vyA;
                        this.vxH.cIa();
                        String str4 = "";
                        TalkRoom adg = c.cHG().adg(str);
                        if (adg != null) {
                            str4 = adg.vwX == null ? "" : adg.vwX.name;
                        }
                        boolean a = com.tencent.pb.common.b.e.cEn().a(new com.tencent.wecall.talkroom.a.d(str, strArr, this.vxI.cHE(), str4, ayVar, i, i2, j, str2, z, str3));
                        this.vxH.Q(new String[]{"create", "req", String.valueOf(a), String.valueOf(this.state)});
                        c.x("TalkRoomService", new Object[]{"sendCreateSence groupId: ", str, " routeId:", Integer.valueOf(i), " type: ", Integer.valueOf(i2), " playId: ", Long.valueOf(j), " name: ", str4, " ret: ", Boolean.valueOf(a)});
                        break;
                    }
                }
                c.x("TalkRoomService", new Object[]{"handlerCreateGroup state: ", Integer.valueOf(this.state)});
                break;
                break;
            case 3:
                obj = message.obj;
                if (this.state == 3) {
                    if (!(obj instanceof c)) {
                        c.x("TalkRoomService", new Object[]{"handlerCreateGroup obj is not CreateGroupObj"});
                        break;
                    }
                    c cVar = (c) obj;
                    if (b(cVar.groupId, cVar.kpo, cVar.kpp, false)) {
                        b(cVar.groupId, cVar.kpo, cVar.kpp, cVar.vcN, cVar.vcU, cVar.vyM);
                        break;
                    }
                }
                c.x("TalkRoomService", new Object[]{"handlerEnterGroup state: ", Integer.valueOf(this.state)});
                break;
                break;
            case 4:
                com.tencent.pb.common.c.f.cEF();
                break;
        }
        return true;
    }

    public f() {
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM, this);
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.APK_PATH_ERROR, this);
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.APK_VERSION_ERROR, this);
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.APK_INVALID, this);
        com.tencent.pb.common.b.e.cEn().a(205, this);
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.UNZIP_IO_ERROR, this);
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.UNZIP_OTHER_ERROR, this);
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM, this);
        com.tencent.pb.common.b.e.cEn().a(210, this);
        com.tencent.pb.common.b.e.cEn().a(209, this);
        com.tencent.pb.common.b.e.cEn().a(211, this);
        com.tencent.pb.common.b.e.cEn().a(TbsListener$ErrorCode.COPY_FAIL, this);
        com.tencent.pb.common.b.e.cEn().a(213, this);
        com.tencent.pb.common.b.e.cEn().a(214, this);
        com.tencent.pb.common.b.e.cEn().a(800, this);
        c cHG = c.cHG();
        g gVar = this.vxP;
        try {
            new Throwable("trace caller").getStackTrace();
        } catch (Exception e) {
            c.d("TalkRoomManager", new Object[]{"setTalkServerCallback caller stack: ", r2});
        }
        cHG.vxe = gVar;
        HandlerThread handlerThread = new HandlerThread("TalkRoomService");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        if (this.vwP == null) {
            this.vwP = (a) com.tencent.f.f.adc("EventCenter");
        }
        c.d("TalkRoomService", new Object[]{"syscall", "register", Boolean.valueOf(true)});
        this.vwP.a(this, vxS);
    }

    final boolean cHP() {
        c.d("TalkRoomService", new Object[]{"initService"});
        e eVar = vco;
        if (eVar != null) {
            eVar.bfN();
        }
        this.vxI = new b();
        this.vxT = this.jTX;
        this.vxJ = new 1(this);
        return true;
    }

    public final void mT(boolean z) {
        int uninitLive;
        this.vxH.groupId = this.jTX;
        this.vxH.vcI = this.vxy;
        if (g.isEmpty(this.vxH.groupId)) {
            this.vxH.groupId = "";
        }
        if (g.isEmpty(this.vxH.vcI)) {
            this.vxH.vcI = "";
        }
        this.vxH.oOw = 1;
        this.vxH.kpo = this.kvL;
        this.vxH.kpp = this.vxz;
        c.d("TalkRoomService", new Object[]{"uninitService isUpload: ", Boolean.valueOf(z)});
        c.d("TalkRoomService", new Object[]{"releaseConpent"});
        try {
            we();
        } catch (Throwable th) {
            c.x("TalkRoomService", new Object[]{"releaseConpent ", th});
        }
        try {
            cHR();
        } catch (Throwable th2) {
            c.x("TalkRoomService", new Object[]{"releaseConpent ", th2});
        }
        this.vxo.remove(this.jTX);
        this.vxQ = 0;
        this.mIsMute = false;
        setState(0);
        this.vxw = false;
        a(this.vxy, 0, 0, null, null);
        this.vxy = null;
        this.vcc = 0;
        this.vxA = 0;
        this.vxB = 0;
        this.vxC = 0;
        this.vxE = true;
        this.vxW = true;
        this.vxD = 0;
        this.vxF = 0;
        this.vxv = false;
        this.vyd = false;
        this.vye = true;
        cHQ();
        this.mHandler.removeMessages(1);
        if (this.vxI != null) {
            b bVar = this.vxI;
            if (com.tencent.pb.common.a.a.vbD) {
                bVar.vwZ.field_capInfo = null;
            }
        }
        cHV();
        cHU();
        try {
            c.x("TalkRoomService", new Object[]{"cancelTalkDurationTimerTask"});
            if (this.vxN != null) {
                this.vxN.cancel();
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"cancelTalkDurationTimerTask: ", e});
        }
        this.vxN = null;
        this.mHandler.removeCallbacks(this.vyh);
        this.vyg = null;
        this.kFG = false;
        this.vxV = false;
        int i = -99999;
        if (this.vxI != null) {
            try {
                this.vxQ = this.vxI.cHF();
                i = this.vxI.Close();
            } catch (Throwable th3) {
                c.x("TalkRoomService", new Object[]{"uninitService", th3});
            }
            c.x("TalkRoomService", new Object[]{"uninitService mid", Integer.valueOf(i)});
        }
        if (this.vxI != null) {
            try {
                uninitLive = this.vxI.uninitLive();
            } catch (Exception e2) {
                c.x("TalkRoomService", new Object[]{"uninitService 2", e2});
            }
            this.vxI = null;
            if (z) {
                String cHY = this.vxH.cHY();
                if (!(TextUtils.isEmpty(this.vxH.groupId) && TextUtils.isEmpty(this.vxH.vcI))) {
                    h.ado(cHY);
                    this.mHandler.removeMessages(4);
                    this.mHandler.sendEmptyMessageDelayed(4, 0);
                }
                cHS();
                try {
                    ((AudioManager) com.tencent.pb.common.c.d.oSX.getSystemService("audio")).setMode(0);
                    c.x("TalkRoomService", new Object[]{"resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn())});
                } catch (Throwable th22) {
                    c.x("TalkRoomService", new Object[]{"resumeAudioConfig ", th22});
                }
            }
            c.d("TalkRoomService", new Object[]{"uninitService end error", Integer.valueOf(uninitLive)});
        }
        uninitLive = i;
        this.vxI = null;
        if (z) {
            String cHY2 = this.vxH.cHY();
            if (!(TextUtils.isEmpty(this.vxH.groupId) && TextUtils.isEmpty(this.vxH.vcI))) {
                h.ado(cHY2);
                this.mHandler.removeMessages(4);
                this.mHandler.sendEmptyMessageDelayed(4, 0);
            }
            cHS();
            try {
                ((AudioManager) com.tencent.pb.common.c.d.oSX.getSystemService("audio")).setMode(0);
                c.x("TalkRoomService", new Object[]{"resumeAudioConfig mode: ", Integer.valueOf(r0.getMode()), " isSpeaker: ", Boolean.valueOf(r0.isSpeakerphoneOn())});
            } catch (Throwable th222) {
                c.x("TalkRoomService", new Object[]{"resumeAudioConfig ", th222});
            }
        }
        c.d("TalkRoomService", new Object[]{"uninitService end error", Integer.valueOf(uninitLive)});
    }

    public final void cHQ() {
        try {
            c.x("TalkRoomService", new Object[]{"stopHoldeOnPusher "});
            if (this.vyf != null) {
                this.mHandler.removeCallbacks(this.vyf);
            }
        } catch (Throwable th) {
            c.x("TalkRoomService", new Object[]{" stopTimer: ", th});
        }
    }

    final void setState(int i) {
        c.x("TalkRoomService", new Object[]{"setState newState: ", Integer.valueOf(i)});
        if (this.state != i) {
            this.state = i;
            g gVar = this.vxP;
            9 9 = new 9(gVar, i);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                9.run();
            } else {
                gVar.handler.post(9);
            }
        }
    }

    static String[] en(List<String> list) {
        if (list == null || list.size() <= 0) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        int i = 0;
        for (String str : list) {
            int i2 = i + 1;
            strArr[i] = str;
            i = i2;
        }
        return strArr;
    }

    public final b a(String str, int i, long j, int i2, int i3, String str2) {
        c.x("TalkRoomService", new Object[]{"enterTalkRoom", str, str2, Integer.valueOf(this.kvL), Integer.valueOf(i), Long.valueOf(this.vxz), Long.valueOf(j), Integer.valueOf(i3), "needConfirm", Boolean.valueOf(false)});
        if (com.tencent.pb.a.a.a.cEH()) {
            h.isNetworkConnected();
            if (Ir(i3) && i3 != 100 && bJP()) {
                h.a(str, "", this.kvL, this.vxz, new String[]{"enter", "req", "false", String.valueOf(i3), "isBusy"});
                c.x("TalkRoomService", new Object[]{"enterTalkRoom isBusy"});
                return b.BUSY;
            }
            boolean adn = i3 == 100 ? true : Ir(i3) ? this.state == 0 : i3 == 1 ? adn(str) : false;
            if (!adn) {
                c.x("TalkRoomService", new Object[]{"exitTalkRoom enterTalkRoom isValidEnterState is false enterType: ", Integer.valueOf(i3), " state: ", Integer.valueOf(this.state)});
                h.a(str, "", this.kvL, this.vxz, new String[]{"enter", "req", "false", String.valueOf(i3), "isNotValidEnterState"});
                return b.NOT_VALID_STATE;
            } else if (TextUtils.isEmpty(str)) {
                c.x("TalkRoomService", new Object[]{"exitTalkRoom enterTalkRoom groupId is null"});
                h.a(str, "", this.kvL, this.vxz, new String[]{"enter", "req", "false", String.valueOf(i3), "groupIdnull"});
                return b.GROUP_NOT_VALID;
            } else {
                if (Ir(i3)) {
                    cHS();
                    mT(false);
                }
                cHP();
                if (bHg()) {
                    this.jTX = str;
                    if (Ir(i3)) {
                        this.kvL = i;
                        this.vxz = j;
                    } else {
                        e adm = adm(str);
                        this.kvL = adm == null ? 0 : adm.kpo;
                        this.vxz = adm == null ? 0 : adm.kpp;
                    }
                    this.vxT = str;
                    this.vcc = i2;
                    setState(3);
                    this.oLU = Ir(i3);
                    if (this.oLU) {
                        this.vxH.cHZ();
                    }
                    if (!this.oLU || c.cHG().bE(this.jTX, true)) {
                        b(str, this.kvL, this.vxz, i2, i3, str2);
                    } else {
                        c cVar = new c(this);
                        cVar.groupId = str;
                        cVar.kpo = i;
                        cVar.kpp = j;
                        cVar.vcU = i3;
                        cVar.vcN = i2;
                        cVar.vyM = str2;
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = cVar;
                        this.mHandler.sendMessageDelayed(obtain, 0);
                    }
                    return b.OK;
                }
                c.x("TalkRoomService", new Object[]{"exitTalkRoom enterTalkRoom initEngine fail"});
                if (Ir(i3)) {
                    h.a(str, "", this.kvL, this.vxz, new String[]{"enter", "req", "false", "initEnginefail"});
                    mT(false);
                } else {
                    this.vxH.Q(new String[]{"enter", "req", "false", "initEnginefail"});
                }
                return b.INIT_ENGINE_FAILED;
            }
        }
        c.x("TalkRoomService", new Object[]{"enterTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.cEH()), " isBindMobile: ", Boolean.valueOf(true)});
        h.a(str, "", this.kvL, this.vxz, new String[]{"enter", "req", "false", String.valueOf(i3), "noAuth"});
        return b.NOT_AUTH;
    }

    private void b(String str, int i, long j, int i2, int i3, String str2) {
        c.x("TalkRoomService", new Object[]{"sendEnterGroupScence groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " enterType: ", Integer.valueOf(i3), " isSenceCircle: ", Boolean.valueOf(true), " wXgroupId: ", str2});
        if (i == 0 || j == 0) {
            c.e("TalkRoomService", new Object[]{"roomId or roomkey is 0..return."});
            return;
        }
        if (!Ir(i3)) {
            h hVar = this.vxH;
            c.d(h.TAG, new Object[]{"endAnswerTime", Long.valueOf(hVar.vzk)});
            if (hVar.vzk == 0) {
                hVar.kqK = 0;
            } else {
                hVar.kqK = System.currentTimeMillis() - hVar.vzk;
            }
        }
        this.vxH.cIa();
        com.tencent.wecall.talkroom.a.e eVar = new com.tencent.wecall.talkroom.a.e(str, i, j, this.vxI.cHE(), i2, i3, str2);
        com.tencent.pb.common.b.e.cEn().a(eVar);
        this.mHandler.removeCallbacks(this.vyh);
        this.vyg = eVar;
        this.mHandler.postDelayed(this.vyh, 3000);
    }

    public final boolean a(String str, int i, long j, int i2) {
        c.x("TalkRoomService", new Object[]{"rejectTalkRoom groupId: ", str, " mGroupId: ", this.jTX, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " reason: ", Integer.valueOf(i2)});
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!(3 != (1 == i2 ? 1 : 3) || i2 == 7 || this.vxD == 0)) {
            System.currentTimeMillis();
        }
        boolean a = com.tencent.pb.common.b.e.cEn().a(new i(str, i, j, i2));
        if (b(str, i, j, false)) {
            this.vxH.Q(new String[]{"reject", "req", String.valueOf(a), String.valueOf(this.state)});
        } else {
            h.a(str, i, j, new String[]{"reject", "req", String.valueOf(a), String.valueOf(this.state)});
        }
        a(str, i, j, false);
        c.x("TalkRoomService", new Object[]{"rejectTalkRoom ret: ", Boolean.valueOf(a)});
        return a;
    }

    private boolean dG(String str, int i) {
        c.x("TalkRoomService", new Object[]{"cancelCreateTalkRoom clientGroupId: ", str});
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.cEn().a(new com.tencent.wecall.talkroom.a.c(str, i, this.vcc));
        this.vxH.Q(new String[]{"cancel", "req", String.valueOf(a), String.valueOf(this.state)});
        a(str, this.kvL, this.vxz, true);
        c.x("TalkRoomService", new Object[]{"cancelCreateTalkRoom ret: ", Boolean.valueOf(a)});
        return a;
    }

    public final boolean a(String str, int i, long j, int i2, boolean z) {
        c.x("TalkRoomService", new Object[]{"exitTalkRoom", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        if (TextUtils.isEmpty(str)) {
            c.d("TalkRoomService", new Object[]{"exitTalkRoom: has exited"});
            return false;
        }
        boolean a = com.tencent.pb.common.b.e.cEn().a(new com.tencent.wecall.talkroom.a.f(str, i, j, i2));
        this.vxH.Q(new String[]{"exit", "req", String.valueOf(a), String.valueOf(this.state)});
        a(str, i, j, z);
        c.x("TalkRoomService", new Object[]{"exitTalkRoom ret: ", Boolean.valueOf(a)});
        return a;
    }

    private boolean cHR() {
        boolean bfP;
        try {
            e eVar = vco;
            if (eVar != null) {
                this.vxH.oOK = eVar.bfR();
                this.vxH.oOA = eVar.bfU();
                bfP = eVar.bfP();
                c.d("TalkRoomService", new Object[]{"stopPlayer ret: ", Boolean.valueOf(bfP)});
                return bfP;
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"stopPlayer: ", e});
        }
        bfP = false;
        c.d("TalkRoomService", new Object[]{"stopPlayer ret: ", Boolean.valueOf(bfP)});
        return bfP;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.b bVar) {
        int i3 = -100;
        try {
            e eVar = vco;
            if (eVar != null) {
                i3 = eVar.a(i, i2, bVar);
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"startPlayer: ", Integer.valueOf(i), Integer.valueOf(i2), e});
        }
        c.d("TalkRoomService", new Object[]{"startPlayer samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3)});
        return i3;
    }

    private boolean we() {
        boolean bfQ;
        try {
            e eVar = vco;
            if (eVar != null) {
                this.vxH.oOD = eVar.bfS();
                this.vxH.oOz = eVar.bfT();
                bfQ = eVar.bfQ();
                c.d("TalkRoomService", new Object[]{"stopRecord ret: ", Boolean.valueOf(bfQ)});
                return bfQ;
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"stopRecord: ", e});
        }
        bfQ = false;
        c.d("TalkRoomService", new Object[]{"stopRecord ret: ", Boolean.valueOf(bfQ)});
        return bfQ;
    }

    private static int b(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        int i3 = -100;
        try {
            e eVar = vco;
            if (eVar != null) {
                i3 = eVar.a(i, i2, cVar);
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"startRecord: ", e});
        }
        c.d("TalkRoomService", new Object[]{"startRecord samplerate: ", " frameDuration: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3)});
        return i3;
    }

    public final void a(int i, int i2, String str, com.tencent.pb.common.b.d dVar) {
        Map A;
        String str2 = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "CLTNOT onNetSceneEnd errCode:";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = " errType: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " scene.getType(): ";
        objArr[5] = dVar != null ? Integer.valueOf(dVar.getType()) : "";
        c.d(str2, objArr);
        if (i == 1 || i == 2) {
            A = com.tencent.pb.common.c.b.A(new Integer[]{Integer.valueOf(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM), Integer.valueOf(-1004), Integer.valueOf(TbsListener$ErrorCode.APK_PATH_ERROR), Integer.valueOf(-1107), Integer.valueOf(TbsListener$ErrorCode.APK_VERSION_ERROR), Integer.valueOf(-1205), Integer.valueOf(TbsListener$ErrorCode.APK_INVALID), Integer.valueOf(-1304), Integer.valueOf(205), Integer.valueOf(-1403), Integer.valueOf(TbsListener$ErrorCode.UNZIP_OTHER_ERROR), Integer.valueOf(-1502), Integer.valueOf(209), Integer.valueOf(-1512), Integer.valueOf(TbsListener$ErrorCode.UNZIP_IO_ERROR), Integer.valueOf(-1522), Integer.valueOf(TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM), Integer.valueOf(-1532), Integer.valueOf(210), Integer.valueOf(-1542)});
            int type = dVar.getType();
            if (A.containsKey(Integer.valueOf(type))) {
                h.It(((Integer) A.get(Integer.valueOf(type))).intValue());
            }
        }
        k kVar;
        if (i2 == -1) {
            try {
                if (dVar.getType() == TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM) {
                    com.tencent.wecall.talkroom.a.d dVar2 = (com.tencent.wecall.talkroom.a.d) dVar;
                    if (g.gr(this.vxy, dVar2.vxy)) {
                        this.vxH.Ix(ao.CTRL_BYTE);
                        this.vxH.Q(new String[]{"create", "resp", "-1", String.valueOf(this.state)});
                        dG(dVar2.vxy, 1001);
                        if (!dVar2.vzv) {
                            this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                        this.vxP.h(-100, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 209) {
                    this.vxP.dF(((com.tencent.wecall.talkroom.a.g) dVar).jTX, i2);
                    return;
                } else if (dVar.getType() == TbsListener$ErrorCode.UNZIP_IO_ERROR) {
                    com.tencent.wecall.talkroom.a.a aVar = (com.tencent.wecall.talkroom.a.a) dVar;
                    if (!b(aVar.jTX, aVar.kvL, aVar.vxz, false)) {
                        h.a(aVar.jTX, aVar.kvL, aVar.vxz, new String[]{"ack", "resp", "-1", String.valueOf(this.state)});
                    }
                    this.vxP.a(aVar.vzu, c.cHG().adl(aVar.jTX));
                    return;
                } else if (dVar.getType() == TbsListener$ErrorCode.APK_INVALID) {
                    com.tencent.wecall.talkroom.a.b bVar = (com.tencent.wecall.talkroom.a.b) dVar;
                    if (b(bVar.jTX, bVar.kvL, bVar.vxz, false)) {
                        this.vxH.Q(new String[]{"add", "resp", "-1", String.valueOf(this.state)});
                        this.vxP.h(-300, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == TbsListener$ErrorCode.APK_PATH_ERROR) {
                    com.tencent.wecall.talkroom.a.e eVar = (com.tencent.wecall.talkroom.a.e) dVar;
                    if (b(eVar.jTX, eVar.kvL, eVar.vxz, Ir(eVar.vzw)) && this.state == 3) {
                        this.vxH.Ix(TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY);
                        this.vxP.h(-200, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == TbsListener$ErrorCode.COPY_FAIL) {
                    this.vxP.em(null);
                    return;
                } else if (dVar.getType() == 213) {
                    if (g.equals(((j) dVar).jTX, this.jTX)) {
                        this.vxH.Q(new String[]{"sendmsg", "resp", "-1", String.valueOf(this.state)});
                        this.vxP.h(-700, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 211) {
                    com.tencent.wecall.talkroom.a.h hVar = (com.tencent.wecall.talkroom.a.h) dVar;
                    if (b(hVar.groupId, hVar.kpo, hVar.kpp, false)) {
                        this.vxH.Q(new String[]{"redirect", "resp", "-1", String.valueOf(this.state)});
                        return;
                    }
                    return;
                } else if (dVar.getType() == 214) {
                    l lVar = (l) dVar;
                    if (b(lVar.jTX, lVar.kvL, lVar.vxz, false)) {
                        this.vxP.h(-800, null);
                        return;
                    }
                    return;
                } else if (dVar.getType() == 800) {
                    kVar = (k) dVar;
                    if (b(kVar.jTX, kVar.kvL, kVar.vxz, false)) {
                        this.vxP.h(-1600, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } catch (Exception e) {
                c.x("TalkRoomService", new Object[]{"cancelCreateTalkRoom: ", e});
                return;
            }
        }
        Map A2;
        g gVar;
        int i3;
        if (dVar.getType() == TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM) {
            com.tencent.wecall.talkroom.a.d dVar3 = (com.tencent.wecall.talkroom.a.d) dVar;
            if (!(dVar3 == null || dVar3.vca == null)) {
                Object obj;
                z zVar = (z) dVar3.vca;
                c.x("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd errCode: ", Integer.valueOf(i2), Integer.valueOf(dVar3.mType), dVar3.vxy});
                if (dVar3.vzv) {
                    obj = null;
                } else {
                    obj = 1;
                }
                A2 = com.tencent.pb.common.c.b.A(new Integer[]{Integer.valueOf(14000), Integer.valueOf(-1001), Integer.valueOf(14001), Integer.valueOf(-1002), Integer.valueOf(14002), Integer.valueOf(-1009)});
                if (A2.containsKey(Integer.valueOf(i2))) {
                    h.It(((Integer) A2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 14002) {
                    vxn = null;
                    if (i2 != 0) {
                        if (g.gr(this.vxy, dVar3.vxy)) {
                            if (i2 != -1) {
                                this.vxH.Ix(TbsListener$ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01);
                                this.vxH.Q(new String[]{"create", "resp", String.valueOf(i2), String.valueOf(this.state)});
                            }
                            if (this.state != 1) {
                                c.x("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd state is error: ", Integer.valueOf(this.state), "  errCode: ", Integer.valueOf(i2), dVar3.vxy});
                                if (obj != null) {
                                    this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            } else {
                                a(this.jTX, this.kvL, this.vxz, true);
                                if (i2 == 14051) {
                                    this.vxP.h(-900, null);
                                } else if (i2 == 14052) {
                                    this.vxP.h(-1100, null);
                                } else if (i2 == 14053) {
                                    this.vxP.h(-1300, zVar);
                                } else if (i2 == 14504) {
                                    this.vxP.h(-1400, null);
                                } else {
                                    this.vxP.h(-100, null);
                                }
                                if (obj != null) {
                                    this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                                }
                            }
                        } else {
                            c.x("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.vxy, " createScene.mClientGroupId: ", dVar3.vxy, " errCode: ", Integer.valueOf(i2)});
                            if (obj != null) {
                                this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        }
                    } else if (g.gr(this.vxy, zVar.vcI)) {
                        this.vxH.Q(new String[]{"create", "resp", String.valueOf(i2), String.valueOf(this.state)});
                        if (this.state != 1) {
                            h.It(-1003);
                            c.x("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd state != STATE_CREATING_TAKLROOM: ", Integer.valueOf(this.state), zVar.vcI, Integer.valueOf(zVar.oLB), Long.valueOf(zVar.oLC)});
                            if (obj != null) {
                                this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                        } else if (zVar.veb == null || zVar.veb.length == 0) {
                            c.x("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd resp.addrlist is null,errCode: ", Integer.valueOf(i2), zVar.vcI, Integer.valueOf(zVar.oLB), Long.valueOf(zVar.oLC)});
                            h.It(-1605);
                            this.vxH.oWL = TbsListener$ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                            a(zVar.groupId, zVar.oLB, zVar.oLC, 116, true);
                            if (obj != null) {
                                this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                            }
                            this.vxP.h(-100, null);
                        } else {
                            a(zVar.vcI, zVar.oLB, zVar.oLC, zVar.groupId, zVar.vcK.vfd);
                            this.vxT = zVar.groupId;
                            this.vcc = zVar.vcN;
                            setState(4);
                            a(zVar.veb, zVar.vei, zVar.vej);
                            a(zVar.groupId, zVar.vcI, zVar.vcN, zVar.oLB, zVar.oLC, zVar.vdo, zVar.vec, zVar.vcK, false, true);
                            if (this.vxP != null) {
                                gVar = this.vxP;
                                6 6 = new 6(gVar, c.cHG().adl(zVar.groupId));
                                if (Looper.myLooper() == Looper.getMainLooper()) {
                                    6.run();
                                } else {
                                    gVar.handler.post(6);
                                }
                            }
                            byte[] bArr = new byte[zVar.vee.length];
                            for (i3 = 0; i3 < zVar.vee.length; i3++) {
                                bArr[i3] = (byte) zVar.vee[i3];
                            }
                            a(0, zVar.vdo, zVar.vdp, bArr, (zVar.ved & 2) != 0, zVar.groupId, zVar.oLB, zVar.oLC, zVar.vek, zVar.vel, zVar.vem);
                            if (zVar.veh != 0) {
                                c.w("TalkRoomService", new Object[]{"get helloFreqSeconds:" + zVar.veh});
                                vxu = zVar.veh * TbsLog.TBSLOG_CODE_SDK_BASE;
                            }
                            cHT();
                            i(zVar.groupId, zVar.oLB, zVar.oLC);
                            if (obj != null) {
                                A = new HashMap();
                                A.put("result", Boolean.valueOf(true));
                                A.put("shareUrl", new String(zVar.vcK.veX, Charset.forName("utf-8")));
                                A.put("smsShortUrl", new String(zVar.vcK.veY, Charset.forName("utf-8")));
                                A.put("groupId", zVar.groupId);
                                this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, A);
                            }
                            c.x("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd", this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz)});
                        }
                    } else {
                        c.x("TalkRoomService", new Object[]{"handleCreateVoiceGroupEnd mClientGroupId is not same mClientGroupId: ", this.vxy, " resp.clientGroupId: ", zVar.vcI, Integer.valueOf(zVar.oLB), Long.valueOf(zVar.oLC)});
                        a(zVar.groupId, zVar.oLB, zVar.oLC, 110, false);
                        if (obj != null) {
                            this.vwP.c("TOPIC_ASYNC_CREATE_ROOM_DONE", 0, null);
                        }
                    }
                }
            }
        }
        if (dVar.getType() == TbsListener$ErrorCode.APK_PATH_ERROR) {
            com.tencent.wecall.talkroom.a.e eVar2 = (com.tencent.wecall.talkroom.a.e) dVar;
            if (!(eVar2 == null || eVar2.vca == null)) {
                a(i2, (aa) eVar2.vca, eVar2);
            }
        }
        if (dVar.getType() == TbsListener$ErrorCode.APK_INVALID) {
            com.tencent.wecall.talkroom.a.b bVar2 = (com.tencent.wecall.talkroom.a.b) dVar;
            if (!(bVar2 == null || bVar2.vca == null)) {
                x xVar = (x) bVar2.vca;
                c.x("TalkRoomService", new Object[]{"handleAddVoiceGroupMemberEnd", this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz), " errCode: ", Integer.valueOf(i2)});
                A2 = com.tencent.pb.common.c.b.A(new Integer[]{Integer.valueOf(14600), Integer.valueOf(-1301), Integer.valueOf(14601), Integer.valueOf(-1302), Integer.valueOf(14602), Integer.valueOf(-1303)});
                if (A2.containsKey(Integer.valueOf(i2))) {
                    h.It(((Integer) A2.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 == 0) {
                    str2 = "TalkRoomService";
                    objArr = new Object[2];
                    objArr[0] = "handleAddVoiceGroupMemberEnd  resp.members length: ";
                    objArr[1] = Integer.valueOf(xVar.vea == null ? 0 : xVar.vea.length);
                    c.x(str2, objArr);
                    if (b(xVar.groupId, xVar.oLB, xVar.oLC, false)) {
                        this.vxH.Q(new String[]{"add", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    } else {
                        c.x("TalkRoomService", new Object[]{"handleAddVoiceGroupMemberEnd isCurrentRoom false resp.groupId: ", xVar.groupId, this.jTX, " resp.roomid: ", Integer.valueOf(xVar.oLB), Integer.valueOf(this.kvL)});
                        h.It(-1308);
                    }
                    a(xVar.groupId, null, this.vcc, xVar.oLB, xVar.oLC, xVar.vea, null, xVar.vcK, true, true);
                } else if (b(bVar2.jTX, bVar2.kvL, bVar2.vxz, false)) {
                    this.vxH.Q(new String[]{"add", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    this.vxP.h(-300, null);
                }
            }
        }
        if (dVar.getType() == TbsListener$ErrorCode.APK_VERSION_ERROR) {
            com.tencent.wecall.talkroom.a.f fVar = (com.tencent.wecall.talkroom.a.f) dVar;
            if (!(fVar == null || fVar.vca == null)) {
                ab abVar = (ab) fVar.vca;
                c.d("TalkRoomService", new Object[]{"handleExitVoiceRoomEnd", abVar.groupId, this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz), " errCode: ", Integer.valueOf(i2)});
                A = com.tencent.pb.common.c.b.A(new Integer[]{Integer.valueOf(14400), Integer.valueOf(-1201), Integer.valueOf(14401), Integer.valueOf(-1202), Integer.valueOf(14402), Integer.valueOf(-1203), Integer.valueOf(14403), Integer.valueOf(-1204)});
                if (A.containsKey(Integer.valueOf(i2))) {
                    h.It(((Integer) A.get(Integer.valueOf(i2))).intValue());
                }
                if (i2 != 0) {
                    c.x("TalkRoomService", new Object[]{"handleExitVoiceRoomEnd fail errCode is ", Integer.valueOf(i2)});
                }
            }
        }
        if (dVar.getType() == 205) {
            m mVar = (m) dVar;
            if (!(mVar == null || mVar.vca == null)) {
                ak akVar = (ak) mVar.vca;
                c.d("TalkRoomService", new Object[]{"handleHelloEnd", akVar.groupId, this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz), Integer.valueOf(i2), Integer.valueOf(i)});
                cHU();
                i3 = 0;
                if (i2 == 14800) {
                    i3 = -1401;
                } else if (i2 == 14801) {
                    i3 = -1402;
                }
                if (i3 != 0) {
                    this.vxH.Ix(324);
                    h.It(i3);
                }
            }
        }
        if (dVar.getType() == TbsListener$ErrorCode.UNZIP_IO_ERROR) {
            com.tencent.wecall.talkroom.a.a aVar2 = (com.tencent.wecall.talkroom.a.a) dVar;
            if (!(aVar2 == null || aVar2.vca == null)) {
                c.x("TalkRoomService", new Object[]{"CLTNOT handleAckEnd errCode is ", Integer.valueOf(i2), " groupId: ", aVar2.jTX, " roomid: ", Integer.valueOf(aVar2.kvL), " roomKey: ", Long.valueOf(aVar2.vxz)});
                MultiTalkGroup adl;
                if (i2 == 18950) {
                    if (!b(aVar2.jTX, aVar2.kvL, aVar2.vxz, false)) {
                        h.a(aVar2.jTX, aVar2.kvL, aVar2.vxz, new String[]{"ack", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    }
                    adl = c.cHG().adl(aVar2.jTX);
                    c.x("TalkRoomService", new Object[]{"CLTNOT handleAckEnd onMisscMultiTalk mGroupId:", aVar2.jTX, " multiTalkGroup: ", adl});
                    if (adl != null) {
                        this.vxP.a(aVar2.vzu, adl);
                    }
                } else {
                    if (i2 == 0) {
                        this.vxv = true;
                    }
                    if (!bJP()) {
                        c.x("TalkRoomService", new Object[]{"CLTNOT handleAckEnd is working groupId: ", aVar2.jTX});
                        cHS();
                        mT(false);
                        this.vxH.Q(new String[]{"ack", "resp", String.valueOf(i2), String.valueOf(this.state)});
                        this.oLU = false;
                        this.jTX = aVar2.jTX;
                        this.vxT = this.jTX;
                        this.kvL = aVar2.kvL;
                        this.vxz = aVar2.vxz;
                        this.vcc = aVar2.vcc;
                        setState(2);
                        this.vxD = System.currentTimeMillis();
                        h hVar2 = this.vxH;
                        c.d(h.TAG, new Object[]{"beginNotifyTime"});
                        hVar2.vzk = System.currentTimeMillis();
                        if (i2 == 18900) {
                            h.It(-1521);
                        }
                    } else if (g.equals(aVar2.jTX, this.jTX)) {
                        c.x("TalkRoomService", new Object[]{"CLTNOT handleAckEnd groupid same return ", this.jTX});
                    }
                    e eVar3 = new e(this);
                    eVar3.groupId = aVar2.jTX;
                    eVar3.kpo = aVar2.kvL;
                    eVar3.kpp = aVar2.vxz;
                    this.vxo.put(aVar2.jTX, eVar3);
                    adl = c.cHG().adl(aVar2.jTX);
                    c.x("TalkRoomService", new Object[]{"CLTNOT handleAckEnd onInviteMultiTalk mGroupId:", aVar2.jTX, " multiTalkGroup: ", adl});
                    if (adl != null) {
                        gVar = this.vxP;
                        20 20 = new 20(gVar, adl);
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            20.run();
                        } else {
                            gVar.handler.post(20);
                        }
                    } else {
                        a(aVar2.jTX, aVar2.kvL, aVar2.vxz, false, false, false);
                    }
                }
            }
        }
        if (dVar.getType() == TbsListener$ErrorCode.UNZIP_OTHER_ERROR) {
            i iVar = (i) dVar;
            if (!(iVar == null || iVar.vca == null)) {
                if (i2 == 18100) {
                    h.It(-1501);
                }
                c.x("TalkRoomService", new Object[]{"handleRejectEnd  errCode is ", Integer.valueOf(i2)});
            }
        }
        if (dVar.getType() == TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM) {
            com.tencent.wecall.talkroom.a.c cVar = (com.tencent.wecall.talkroom.a.c) dVar;
            if (!(cVar == null || cVar.vca == null)) {
                if (i2 == 18300) {
                    h.It(-1531);
                }
                c.x("TalkRoomService", new Object[]{"handleCancelCreateEnd errCode is ", Integer.valueOf(i2)});
            }
        }
        if (dVar.getType() == 209) {
            com.tencent.wecall.talkroom.a.g gVar2 = (com.tencent.wecall.talkroom.a.g) dVar;
            if (!(gVar2 == null || gVar2.vca == null)) {
                ac acVar = (ac) gVar2.vca;
                if (i2 == 17900) {
                    h.It(-1511);
                }
                if (i2 != 0) {
                    this.vxP.dF(gVar2.jTX, i2);
                    c.x("TalkRoomService", new Object[]{"handleNetSceneModifyVoiceGroupEnd fail errCode is ", Integer.valueOf(i2)});
                } else {
                    TalkRoom adg = c.cHG().adg(acVar.groupId);
                    if (adg != null) {
                        c.x("TalkRoomService", new Object[]{"handleVoiceGroupMemberChange handleModifyVoiceGroupEnd"});
                        a(acVar.groupId, null, adg.cHx(), TalkRoom.cHy(), TalkRoom.bKT(), null, null, acVar.vcK, true, false);
                    } else {
                        a(acVar.groupId, null, 0, 0, 0, null, null, acVar.vcK, true, false);
                    }
                    this.vxP.dF(acVar.groupId, 0);
                }
            }
        }
        if (dVar.getType() == 210) {
            c.d("TalkRoomService", new Object[]{"talkHoldonResp", Integer.valueOf(i), Integer.valueOf(i2)});
            if (i2 == 19100) {
                h.It(-1541);
            }
        }
        if (dVar.getType() == 211) {
            com.tencent.wecall.talkroom.a.h hVar3 = (com.tencent.wecall.talkroom.a.h) dVar;
            if (hVar3 != null) {
                a(i, i2, dVar.vca, hVar3);
            }
        }
        if (dVar.getType() == TbsListener$ErrorCode.COPY_FAIL) {
            a(i2, (ah) dVar.vca);
        }
        if (dVar.getType() == 213) {
            j jVar = (j) dVar;
            c.x("TalkRoomService", new Object[]{"handleSendMsg errCode: ", Integer.valueOf(i2)});
            if (i2 != 0) {
                if (g.equals(jVar.jTX, this.jTX)) {
                    this.vxH.Q(new String[]{"sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state)});
                    this.vxP.h(-700, null);
                }
            } else if (g.equals(jVar.jTX, this.jTX)) {
                this.vxH.Q(new String[]{"sendmsg", "resp", String.valueOf(i2), String.valueOf(this.state)});
                gVar = this.vxP;
                18 18 = new 18(gVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    18.run();
                } else {
                    gVar.handler.post(18);
                }
            }
        }
        if (dVar.getType() == 214) {
            af afVar = (af) dVar.vca;
            l lVar2 = (l) dVar;
            c.x("TalkRoomService", new Object[]{"handleSwitchVideoGroup errCode: ", Integer.valueOf(i2)});
            if (b(lVar2.jTX, lVar2.kvL, lVar2.vxz, false)) {
                if (this.vxI != null) {
                    c.d("TalkRoomService", new Object[]{"setMVSvrCfg:small:br:,WH:,FPS:,big:br:,WH:,Fps:", Integer.valueOf(new int[]{afVar.veo, afVar.vep, afVar.veq, afVar.ves, afVar.vet, afVar.veu}[0]), Integer.valueOf(new int[]{afVar.veo, afVar.vep, afVar.veq, afVar.ves, afVar.vet, afVar.veu}[1]), Integer.valueOf(new int[]{afVar.veo, afVar.vep, afVar.veq, afVar.ves, afVar.vet, afVar.veu}[2]), Integer.valueOf(new int[]{afVar.veo, afVar.vep, afVar.veq, afVar.ves, afVar.vet, afVar.veu}[3]), Integer.valueOf(new int[]{afVar.veo, afVar.vep, afVar.veq, afVar.ves, afVar.vet, afVar.veu}[4]), Integer.valueOf(new int[]{afVar.veo, afVar.vep, afVar.veq, afVar.ves, afVar.vet, afVar.veu}[5])});
                    this.vxI.vwZ.setMVSvrCfg(r5, 6);
                }
                if (i2 == 0) {
                    g gVar3 = this.vxP;
                    15 15 = new 15(gVar3, afVar.veo);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        15.run();
                    } else {
                        gVar3.handler.post(15);
                    }
                } else if (i2 == 24301) {
                    this.vxP.h(-1700, Integer.valueOf(afVar.vew));
                } else {
                    this.vxP.h(-800, null);
                }
            } else {
                c.x("TalkRoomService", new Object[]{"handleSwitchVideoGroup isCurrentRoom is not same", lVar2.jTX, Integer.valueOf(lVar2.kvL)});
            }
        }
        if (dVar.getType() == 800) {
            kVar = (k) dVar;
            c.x("TalkRoomService", new Object[]{"handleSubscribeLargeVideo errCode: ", Integer.valueOf(i2)});
            if (!b(kVar.jTX, kVar.kvL, kVar.vxz, false)) {
                c.x("TalkRoomService", new Object[]{"handleSubscribeLargeVideo isCurrentRoom is not same", kVar.jTX, Integer.valueOf(kVar.kvL)});
            } else if (i2 == 0) {
                gVar = this.vxP;
                16 16 = new 16(gVar);
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    16.run();
                } else {
                    gVar.handler.post(16);
                }
            } else {
                this.vxP.h(-1600, null);
            }
        }
    }

    private void a(int i, ah ahVar) {
        c.x("TalkRoomService", new Object[]{"handleGetGroupInfoBatch errCode: ", Integer.valueOf(i)});
        if (i != 0) {
            this.vxP.em(null);
            return;
        }
        au[] auVarArr = ahVar.vex;
        if (auVarArr == null || auVarArr.length == 0) {
            c.x("TalkRoomService", new Object[]{"handleGetGroupInfoBatch resp.groupInfoList is null"});
            return;
        }
        List arrayList = new ArrayList();
        for (au auVar : auVarArr) {
            if (auVar != null) {
                a(auVar.groupId, null, 0, auVar.oLB, auVar.oLC, auVar.vea, null, null, false, false);
                arrayList.add(c.cHG().adl(auVar.groupId));
            }
        }
        c.x("TalkRoomService", new Object[]{"handleGetGroupInfoBatch multiTalkGrouplist size: ", Integer.valueOf(arrayList.size())});
        this.vxP.em(arrayList);
    }

    private void a(int i, int i2, Object obj, com.tencent.wecall.talkroom.a.h hVar) {
        c.d("TalkRoomService", new Object[]{"handleRedirectResp", Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 != 0 || obj == null) {
            c.e("TalkRoomService", new Object[]{"handleRedirectResp err", Integer.valueOf(i), Integer.valueOf(i2)});
            if (b(hVar.groupId, hVar.kpo, hVar.kpp, false)) {
                this.vxH.Q(new String[]{"redirect", "resp", "-1", String.valueOf(this.state)});
                return;
            }
            return;
        }
        aj ajVar = (aj) obj;
        if (b(ajVar.groupId, ajVar.oLB, ajVar.oLC, false)) {
            this.vxH.Q(new String[]{"redirect", "resp", String.valueOf(i2), String.valueOf(this.state)});
            a(ajVar.groupId, null, this.vcc, ajVar.oLB, ajVar.oLC, ajVar.vea, ajVar.vec, ajVar.vcK, false, false);
            byte[] bArr = new byte[ajVar.vee.length];
            for (int i3 = 0; i3 < ajVar.vee.length; i3++) {
                bArr[i3] = (byte) ajVar.vee[i3];
            }
            a(ajVar.veb, ajVar.vei, ajVar.vej);
            this.vxI.Close();
            a(0, ajVar.vea, ajVar.vdp, bArr, (ajVar.ved & 2) != 0, ajVar.groupId, ajVar.oLB, ajVar.oLC, ajVar.vek, ajVar.vel, ajVar.vem);
            return;
        }
        c.e("TalkRoomService", new Object[]{"handleRedirectResp roomid error", Integer.valueOf(ajVar.oLB), Integer.valueOf(this.kvL)});
    }

    private void a(int i, aa aaVar, com.tencent.wecall.talkroom.a.e eVar) {
        c.d("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd", eVar.jTX, Integer.valueOf(eVar.kvL), Long.valueOf(eVar.vxz), " errCode: ", Integer.valueOf(i), " state: ", Integer.valueOf(this.state)});
        Map A = com.tencent.pb.common.c.b.A(new Integer[]{Integer.valueOf(14200), Integer.valueOf(-1101), Integer.valueOf(14201), Integer.valueOf(-1102), Integer.valueOf(14202), Integer.valueOf(-1103), Integer.valueOf(14203), Integer.valueOf(-1104), Integer.valueOf(14204), Integer.valueOf(-1105), Integer.valueOf(14205), Integer.valueOf(-1111)});
        if (A.containsKey(Integer.valueOf(i))) {
            h.It(((Integer) A.get(Integer.valueOf(i))).intValue());
        }
        if (i == 14255) {
            c.e("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14255), aaVar.groupId, Integer.valueOf(aaVar.oLB), Long.valueOf(aaVar.oLC)});
            this.vxP.h(-14255, aaVar);
        } else if (i == 14256) {
            c.e("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd errCode =%d, groupId=%s,roomid=%d,roomkey=%s", Integer.valueOf(14256), aaVar.groupId, Integer.valueOf(aaVar.oLB), Long.valueOf(aaVar.oLC)});
            this.vxP.h(-14256, aaVar);
        } else if (i == 0 || i == 14204) {
            if (i == 14204 && this.state == 4) {
                c.x("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd errCode == EmRetCode.E_Talk_Enter_AlreadyEnter", aaVar.groupId, Integer.valueOf(aaVar.oLB), Long.valueOf(aaVar.oLC)});
            } else if (!b(aaVar.groupId, aaVar.oLB, aaVar.oLC, Ir(aaVar.vcU))) {
                c.x("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd isCurrentRoom is false,state: ", Integer.valueOf(this.state), " resp.groupId锟斤拷", aaVar.groupId, " mGroupId: ", this.jTX, Integer.valueOf(aaVar.oLB), Integer.valueOf(this.kvL), Long.valueOf(aaVar.oLC), Long.valueOf(this.vxz)});
                a(aaVar.groupId, aaVar.oLB, aaVar.oLC, 111, false);
                h.It(-1110);
            } else if (this.state != 3) {
                c.x("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), aaVar.groupId, Integer.valueOf(aaVar.oLB), Long.valueOf(aaVar.oLC)});
            } else {
                this.vxH.Q(new String[]{"enter", "resp", String.valueOf(i), String.valueOf(this.state)});
                if (aaVar.veb == null || aaVar.veb.length == 0) {
                    c.x("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd resp.addrlist is null,errCode: ", Integer.valueOf(i), aaVar.groupId, Integer.valueOf(aaVar.oLB), Long.valueOf(aaVar.oLC)});
                    h.It(-1605);
                    this.vxH.oWL = TbsListener$ErrorCode.ERROR_GETSTRINGARRAY_JARFILE;
                    a(aaVar.groupId, aaVar.oLB, aaVar.oLC, 116, true);
                    this.vxP.h(-200, null);
                    return;
                }
                this.jTX = aaVar.groupId;
                this.vxT = aaVar.groupId;
                this.kvL = aaVar.oLB;
                this.vxz = aaVar.oLC;
                setState(4);
                a(aaVar.veb, aaVar.vei, aaVar.vej);
                a(aaVar.groupId, null, this.vcc, aaVar.oLB, aaVar.oLC, aaVar.vea, aaVar.vec, aaVar.vcK, false, true);
                g gVar = this.vxP;
                7 7 = new 7(gVar, c.cHG().adl(aaVar.groupId));
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    7.run();
                } else {
                    gVar.handler.post(7);
                }
                byte[] bArr = new byte[aaVar.vee.length];
                for (int i2 = 0; i2 < aaVar.vee.length; i2++) {
                    bArr[i2] = (byte) aaVar.vee[i2];
                }
                a(0, aaVar.vea, aaVar.vdp, bArr, (aaVar.ved & 2) != 0, aaVar.groupId, aaVar.oLB, aaVar.oLC, aaVar.vek, aaVar.vel, aaVar.vem);
                if (aaVar.veh != 0) {
                    c.w("TalkRoomService", new Object[]{"get helloFreqSeconds:" + aaVar.veh});
                    vxu = aaVar.veh * TbsLog.TBSLOG_CODE_SDK_BASE;
                }
                cHT();
                c.x("TalkRoomService", new Object[]{"handleVoiceGroupMemberChange handleEnterTalkRoomEnd", this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz)});
            }
        } else if (!b(eVar.jTX, eVar.kvL, eVar.vxz, Ir(eVar.vzw))) {
            c.x("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd isCurrentRoom is false errCode:", Integer.valueOf(i), " enterScene.mGroupId: ", eVar.jTX, " mGroupId: ", this.jTX, Integer.valueOf(eVar.kvL), Integer.valueOf(this.kvL), Long.valueOf(eVar.vxz), Long.valueOf(this.vxz)});
        } else if (3 != this.state) {
            c.x("TalkRoomService", new Object[]{"handleEnterTalkRoomEnd state is error: ", Integer.valueOf(this.state), " errCode: ", Integer.valueOf(i), eVar.jTX, Integer.valueOf(eVar.kvL), Long.valueOf(eVar.vxz)});
        } else {
            this.vxH.Q(new String[]{"enter", "resp", String.valueOf(i), String.valueOf(this.state)});
            this.vxH.Ix(TbsListener$ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02);
            c.x("TalkRoomService", new Object[]{"exitTalkRoom handleEnterTalkRoomEnd fail errCode: ", Integer.valueOf(i), eVar.jTX, Integer.valueOf(eVar.kvL), Long.valueOf(eVar.vxz)});
            a(eVar.jTX, eVar.kvL, eVar.vxz, true);
            if (i == 14251) {
                this.vxP.h(-1000, null);
            } else if (i == 14252) {
                this.vxP.h(-1200, null);
            } else if (i == 14253) {
                Object valueOf = Integer.valueOf(60);
                if (aaVar != null) {
                    valueOf = Integer.valueOf(aaVar.veg);
                }
                this.vxP.h(-1500, valueOf);
            } else {
                this.vxP.h(-200, null);
            }
        }
    }

    private void a(String str, String str2, int i, int i2, long j, av[] avVarArr, aw[] awVarArr, at atVar, boolean z, boolean z2) {
        Integer num;
        String str3;
        boolean z3;
        if (avVarArr == null) {
            c.x("TalkRoomService", new Object[]{"printMembersLog members is null groupId: ", str, "  roomid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j)});
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (av avVar : avVarArr) {
                if (avVar != null) {
                    stringBuffer.append(" memberId:" + avVar.kpU + " uuid: " + avVar.vez + " status: " + avVar.status + "   mem.inviteTime:" + avVar.vfs + "  mem.reason: " + avVar.aAk + "  mem.inviteuuid: " + avVar.vfE + "\n");
                }
            }
            c.x("TalkRoomService", new Object[]{"printMembersLog groupId: ", str, "  romid: ", Integer.valueOf(i2), "  roomKey", Long.valueOf(j), "  members.length: ", Integer.valueOf(avVarArr.length), "  ", stringBuffer.toString()});
        }
        c cHG = c.cHG();
        if (i == 0) {
            num = null;
        } else {
            num = Integer.valueOf(i);
        }
        boolean z4 = this.jTX != null && this.jTX.equals(str);
        c.d("TalkRoomManager", new Object[]{"newOrUpdateGroup groupId: ", str, " isActive: ", Boolean.valueOf(z4)});
        if (TextUtils.isEmpty(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (TextUtils.isEmpty(str3)) {
            c.x("TalkRoomManager", new Object[]{"newOrUpdateGroup invalid groupId"});
            z3 = false;
        } else {
            if (j.ads(str2)) {
                cHG.vxd.put(str2, str3);
            }
            TalkRoom talkRoom = (TalkRoom) cHG.vxc.get(str3);
            if (TextUtils.isEmpty(str2) || talkRoom == null || atVar == null || atVar.bOS == 100) {
                TalkRoom talkRoom2;
                if (talkRoom == null) {
                    if (j.ads(str2)) {
                        talkRoom2 = (TalkRoom) cHG.vxc.get(str2);
                    } else {
                        talkRoom2 = talkRoom;
                    }
                    if (talkRoom2 != null) {
                        cHG.vxc.put(str3, talkRoom2);
                    }
                } else {
                    talkRoom2 = talkRoom;
                }
                if (talkRoom2 != null && z4) {
                    int cIc = j.cIc();
                    long cId = j.cId();
                    c.d("TalkRoomManager", new Object[]{"check current active group roomId: ", Integer.valueOf(cIc), " and roomKey: ", Long.valueOf(j)});
                    if (cIc != 0 && cIc != i2) {
                        c.x("TalkRoomManager", new Object[]{"diff roomId: ", Integer.valueOf(cIc), " -> ", Integer.valueOf(i2)});
                        z3 = false;
                    } else if (!(0 == cId || cId == j)) {
                        c.x("TalkRoomManager", new Object[]{"diff roomKey: ", Long.valueOf(cId), " -> ", Long.valueOf(j)});
                        z3 = false;
                    }
                }
                if (talkRoom2 == null) {
                    c.d("TalkRoomManager", new Object[]{"newOrUpdateGroup create groupId: ", str3});
                    cHG.vxc.put(str3, TalkRoom.a(str3, str2, num, i2, j, atVar, avVarArr, awVarArr));
                } else {
                    c.d("TalkRoomManager", new Object[]{"newOrUpdateGroup update groupId: ", str3});
                    TalkRoom.a(talkRoom2, str3, str2, num, i2, j, atVar, avVarArr, awVarArr);
                }
                if (cHG.vxe != null && z) {
                    cHG.vxe.g(cHG.adl(str3));
                }
                c.cHH();
                z3 = true;
            } else {
                c.x("TalkRoomManager", new Object[]{"newOrUpdateGroup clientGroupId is not empty , room is not null"});
                z3 = false;
            }
        }
        String str4 = "TalkRoomService";
        Object[] objArr = new Object[16];
        objArr[0] = "engine handleVoiceGroupMemberChange";
        objArr[1] = str;
        objArr[2] = this.jTX;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(this.kvL);
        objArr[5] = Long.valueOf(j);
        objArr[6] = Long.valueOf(this.vxz);
        objArr[7] = Boolean.valueOf(z3);
        objArr[8] = " isCurrentRoom: ";
        objArr[9] = Boolean.valueOf(b(str, i2, j, false));
        objArr[10] = " members.length: ";
        objArr[11] = Integer.valueOf(avVarArr != null ? avVarArr.length : 0);
        objArr[12] = " isCallBackEngine: ";
        objArr[13] = Boolean.valueOf(z2);
        objArr[14] = " mFirstGetAudioData: ";
        objArr[15] = Boolean.valueOf(this.vxE);
        c.d(str4, objArr);
        if (c.cHG().bE(this.jTX, false)) {
            c.x("TalkRoomService", new Object[]{"handleVoiceGroupMemberChange isGroupActive mFirstGetAudioData: ", Boolean.valueOf(this.vxE), " mGroupId: ", this.jTX, " roomId: ", Integer.valueOf(i2)});
            if (this.vxE) {
                this.vxE = false;
                this.kFG = true;
                this.vxR = k.cIe();
                this.vxC = this.vxA;
                if (this.vxN != null) {
                    c.x("TalkRoomService", new Object[]{"refreashTalkingTime mTalkDurationTimerTask is null"});
                } else {
                    c.x("TalkRoomService", new Object[]{"refreashTalkingTime mTalkRoomTalkingCallBack: ", this.vxm, " mIsHoldOn: ", Boolean.valueOf(this.vyd)});
                    this.vxN = new 7(this);
                    this.vxO.scheduleAtFixedRate(this.vxN, 1000, 1000);
                }
            }
        }
        if (avVarArr != null && z2 && b(str, i2, j, false) && avVarArr.length > 0 && this.vxI != null) {
            a(avVarArr);
        }
    }

    private void a(av[] avVarArr) {
        if (avVarArr == null) {
            c.x("TalkRoomService", new Object[]{"onMebersChangedToEngine members is null"});
            return;
        }
        int[] iArr = new int[avVarArr.length];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < avVarArr.length; i++) {
            iArr[i] = avVarArr[i].kpU;
            stringBuffer.append(avVarArr[i].kpU);
            stringBuffer.append(",");
        }
        c.x("TalkRoomService", new Object[]{"engine handleVoiceGroupMemberChange engine.OnMembersChanged memberid: ", stringBuffer.toString()});
        if (this.vxI == null) {
            c.x("TalkRoomService", new Object[]{"onMebersChangedToEngine engine is null"});
            return;
        }
        this.vxI.OnMembersChanged(iArr);
    }

    private void a(o[] oVarArr, o[] oVarArr2, int i) {
        String str = "TalkRoomService";
        Object[] objArr = new Object[2];
        objArr[0] = "handleRelayData addrs length: ";
        objArr[1] = Integer.valueOf(oVarArr == null ? 0 : oVarArr.length);
        c.d(str, objArr);
        if (oVarArr != null && oVarArr.length > 0) {
            this.vxZ = new int[oVarArr.length];
            this.vxY = new short[oVarArr.length];
            this.vyb = new int[oVarArr2.length];
            this.vya = new short[oVarArr2.length];
            this.vyc = i;
            c.x("TalkRoomService", new Object[]{"handleRelayData tcpStartTime: ", Integer.valueOf(this.vyc)});
            int i2 = 0;
            for (o oVar : oVarArr) {
                this.vxZ[i2] = oVar.vdl;
                this.vxY[i2] = (short) oVar.port;
                c.x("TalkRoomService", new Object[]{"handleRelayData ip: ", Integer.valueOf(oVar.vdl), " addr.port: ", Integer.valueOf(oVar.port)});
                i2++;
            }
            i2 = 0;
            for (o oVar2 : oVarArr2) {
                this.vyb[i2] = oVar2.vdl;
                this.vya[i2] = (short) oVar2.port;
                c.x("TalkRoomService", new Object[]{"handleRelayData tcpIp: ", Integer.valueOf(oVar2.vdl), " tcpAddr.port: ", Integer.valueOf(oVar2.port)});
                i2++;
            }
            c.d("TalkRoomService", new Object[]{"handleRelayData", Arrays.toString(this.vxZ), Arrays.toString(this.vxY), this.jTX, this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz), Arrays.toString(this.vyb), Arrays.toString(this.vya), Integer.valueOf(this.vyc)});
        }
    }

    public final int bT(byte[] bArr) {
        p pVar;
        try {
            pVar = (p) com.google.a.a.e.a(new p(), bArr, bArr.length);
        } catch (Exception e) {
            h.It(-1601);
            pVar = null;
        }
        if (pVar == null) {
            if (TextUtils.isEmpty(this.jTX) && TextUtils.isEmpty(this.vxy)) {
                h.a(this.kvL, this.vxz, new String[]{"notify", "pasrefail"});
            } else {
                this.vxH.Q(new String[]{"notify", "pasrefail"});
            }
            c.x("TalkRoomService", new Object[]{"CLTNOT onVoiceGroupChange groupChg null"});
            return -2;
        }
        Object obj;
        c.x("TalkRoomService", new Object[]{"CLTNOT onVoiceGroupChange", this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz), Long.valueOf(pVar.bJC), Integer.valueOf(pVar.vdm)});
        long j = pVar.bJC;
        if (this.vxU.contains(Long.valueOf(j))) {
            obj = 1;
        } else {
            this.vxU.add(Long.valueOf(j));
            obj = null;
        }
        if (obj != null) {
            c.d("TalkRoomService", new Object[]{"CLTNOT onVoiceGroupChange isMsgDouble error"});
            if (b(pVar.groupId, pVar.oLB, pVar.oLC, false)) {
                this.vxH.Q(new String[]{"notify", "repeat", String.valueOf(pVar.vdm)});
            } else {
                h.a(pVar.groupId, pVar.oLB, pVar.oLC, new String[]{"notify", "repeat", String.valueOf(pVar.vdm)});
            }
            return -3;
        }
        if (b(pVar.groupId, pVar.oLB, pVar.oLC, false)) {
            this.vxH.Q(new String[]{"notify", "succ", String.valueOf(pVar.vdm)});
        }
        int i;
        g gVar;
        byte[] bArr2;
        if (pVar.vdm == 4 || pVar.vdm == 2) {
            a(pVar.groupId, null, pVar.vcN, pVar.oLB, pVar.oLC, pVar.vdo, pVar.vdn, pVar.vcK, true, true);
        } else if (pVar.vdm == 16) {
            a(pVar.groupId, null, pVar.vcN, pVar.oLB, pVar.oLC, pVar.vdo, pVar.vdn, pVar.vcK, true, false);
        } else if (pVar.vdm == 1) {
            c.x("TalkRoomService", new Object[]{"handlerCreateGroupChange groupChg.groupId: ", pVar.groupId, " roomId: ", Integer.valueOf(pVar.oLB), " roomkey: ", Long.valueOf(pVar.oLC)});
            if (!com.tencent.pb.a.a.a.cEH()) {
                c.x("TalkRoomService", new Object[]{"CLTNOT handlerCreateGroupChange isAuthed is false"});
            } else if (bJP() && g.equals(pVar.groupId, this.jTX)) {
                c.x("TalkRoomService", new Object[]{"CLTNOT handlerCreateGroupChange return is same groupId: ", this.jTX});
            } else {
                a(pVar.groupId, null, pVar.vcN, pVar.oLB, pVar.oLC, pVar.vdo, pVar.vdn, pVar.vcK, false, true);
                Object obj2 = pVar.groupId;
                i = pVar.oLB;
                long j2 = pVar.oLC;
                int i2 = pVar.vcN;
                int i3 = pVar.vdq;
                if (TextUtils.isEmpty(obj2)) {
                    c.x("TalkRoomService", new Object[]{"CLTNOT ackTalkRoom groupId is null"});
                } else {
                    boolean a = com.tencent.pb.common.b.e.cEn().a(new com.tencent.wecall.talkroom.a.a(obj2, i, j2, i2, i3));
                    c.d("TalkRoomService", new Object[]{"CLTNOT ackTalkRoom groupId: ", obj2, Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i3), Boolean.valueOf(a)});
                }
                c.x("TalkRoomService", new Object[]{"handlerCreateGroupChange start ui"});
            }
        } else if (pVar.vdm == 8) {
            c.x("TalkRoomService", new Object[]{"handleCancelCreateVoiceGroupChange groupChg.groupId: ", pVar.groupId, " mGroupId: ", this.jTX});
            if (b(pVar.groupId, pVar.oLB, pVar.oLC, false)) {
                a(pVar.groupId, null, pVar.vcN, pVar.oLB, pVar.oLC, pVar.vdo, pVar.vdn, pVar.vcK, true, false);
                a(pVar.groupId, pVar.oLB, pVar.oLC, false, false, true);
            } else {
                a(pVar.groupId, null, pVar.vcN, pVar.oLB, pVar.oLC, pVar.vdo, pVar.vdn, pVar.vcK, true, false);
            }
        } else if (pVar.vdm == 128) {
            String str = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "handleMemberWhisper groupChg.groupChg.groupId: ";
            objArr[1] = pVar.groupId;
            objArr[2] = " mGroupId: ";
            objArr[3] = this.jTX;
            objArr[4] = " groupChg.whisperBuf size: ";
            objArr[5] = Integer.valueOf(pVar.vdr == null ? 0 : pVar.vdr.length);
            c.d(str, objArr);
            gVar = this.vxP;
            17 17 = new 17(gVar, pVar.groupId, pVar.vdr);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                17.run();
            } else {
                gVar.handler.post(17);
            }
        } else if (pVar.vdm == 256) {
            if (!b(pVar.groupId, pVar.oLB, pVar.oLC, false)) {
                c.x("TalkRoomService", new Object[]{"handleVideoMember is not same room ", pVar.groupId, Integer.valueOf(pVar.oLB)});
            } else if (pVar.vdr == null) {
                c.x("TalkRoomService", new Object[]{"handleVideoMember whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.oLB)});
            } else {
                r rVar;
                try {
                    bArr2 = pVar.vdr;
                    rVar = (r) com.google.a.a.e.a(new r(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e2) {
                    c.x("TalkRoomService", new Object[]{"handleVideoMember ", e2});
                    rVar = null;
                }
                if (rVar == null || rVar.vdv == null) {
                    c.x("TalkRoomService", new Object[]{"handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.oLB)});
                } else {
                    List arrayList = new ArrayList();
                    for (Object obj3 : rVar.vdv) {
                        if (obj3 != null) {
                            arrayList.add(obj3);
                        }
                    }
                    c.d("TalkRoomService", new Object[]{"handleVideoMember groupid: ", this.jTX, " roomId: ", Integer.valueOf(this.kvL), " videoUserNames: ", arrayList});
                    gVar = this.vxP;
                    11 11 = new 11(gVar, arrayList);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        11.run();
                    } else {
                        gVar.handler.post(11);
                    }
                }
            }
        } else if (pVar.vdm == 1024) {
            if (!b(pVar.groupId, pVar.oLB, pVar.oLC, false)) {
                c.x("TalkRoomService", new Object[]{"handleOtherDevice is not same room ", pVar.groupId, Integer.valueOf(pVar.oLB)});
            } else if (!(this.state == 3 || this.state == 4)) {
                a(pVar.groupId, pVar.oLB, pVar.oLC, 1);
                this.vxP.h(-1400, null);
            }
        } else if (pVar.vdm == 512) {
            if (!b(pVar.groupId, pVar.oLB, pVar.oLC, false)) {
                c.x("TalkRoomService", new Object[]{"handleVideoSubscribes is not same room ", pVar.groupId, Integer.valueOf(pVar.oLB)});
            } else if (pVar.vdr == null) {
                c.x("TalkRoomService", new Object[]{"handleVideoSubscribes whisperBuf is null", pVar.groupId, Integer.valueOf(pVar.oLB)});
            } else {
                q qVar;
                try {
                    bArr2 = pVar.vdr;
                    qVar = (q) com.google.a.a.e.a(new q(), bArr2, bArr2.length);
                } catch (com.google.a.a.d e22) {
                    c.x("TalkRoomService", new Object[]{"handleVideoSubscribes ", e22});
                    qVar = null;
                }
                if (qVar == null) {
                    c.x("TalkRoomService", new Object[]{"handleVideoMember notify is null", pVar.groupId, Integer.valueOf(pVar.oLB)});
                } else {
                    g gVar2 = this.vxP;
                    1 1 = new 1(gVar2, qVar.vdu);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        1.run();
                    } else {
                        gVar2.handler.post(1);
                    }
                }
            }
        }
        return 0;
    }

    public final void cHS() {
        h hVar = this.vxH;
        c.d(h.TAG, new Object[]{"reset"});
        hVar.vzk = 0;
        hVar.vzj = 0;
        hVar.vzi = 0;
        hVar.groupId = "";
        hVar.vcI = "";
        hVar.oOw = 1;
        hVar.kpo = 0;
        hVar.kpp = 0;
        hVar.kpU = -1;
        hVar.oWL = 0;
        hVar.oWS = 0;
        hVar.oWO = 0;
        hVar.kqL = 0;
        hVar.vyV = 0;
        hVar.vyW = 0;
        hVar.vyX = 0;
        hVar.vyY = 0;
        hVar.vyZ = 0;
        hVar.vza = 0;
        hVar.vzb = 0;
        hVar.vzc = 0;
        hVar.oWT = 0;
        hVar.kqK = 0;
        hVar.oWY = 0;
        hVar.oWZ = 0;
        hVar.netType = -1;
        hVar.vzd = 0;
        hVar.vze = 0;
        hVar.vzf = "";
        hVar.deviceModel = "";
        hVar.vzg = -1;
        hVar.oXe = "";
        hVar.vzh.setLength(0);
        hVar.oOK = -1;
        hVar.oOD = 0;
        hVar.oOz = 0;
        hVar.oOA = 0;
    }

    private void a(String str, int i, long j, boolean z) {
        a(str, i, j, z, true, true);
    }

    public final void a(String str, int i, long j, boolean z, boolean z2, boolean z3) {
        c.x("TalkRoomService", new Object[]{"closeVoiceGroup groupId: ", str, " mGroupId: ", this.jTX, " roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.kvL), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.vxz)});
        try {
            TalkRoom adg = c.cHG().adg(str);
            if (adg == null) {
                c.x("TalkRoomManager", new Object[]{"handleRoomExit assert failed: current TalkRoom MUST exists"});
            } else {
                d adf = adg.adf(com.tencent.pb.a.a.a.cEG());
                if (adf != null) {
                    adf.vxf.status = 20;
                    adf.vxf.kpU = -1;
                }
                String str2 = "tagorewang:TalkRoom";
                Object[] objArr = new Object[2];
                objArr[0] = "resetRoomTempInfo groupId: ";
                objArr[1] = adg.vgm == null ? "" : adg.vgm;
                c.d(str2, objArr);
                c.cHH();
            }
        } catch (Throwable th) {
            c.x("TalkRoomManager", new Object[]{"handleRoomExit: ", th});
        }
        if (z) {
            i(str, i, j);
        }
        this.vxo.remove(str);
        if (b(str, i, j, false)) {
            c.d("TalkRoomService", new Object[]{"closeVoiceGroup isCurrentRoom groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j)});
            mT(true);
            g gVar = this.vxP;
            8 8 = new 8(gVar, str, z2);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                8.run();
            } else {
                gVar.handler.post(8);
            }
        }
        if (z3) {
            MultiTalkGroup adl = c.cHG().adl(str);
            if (adl != null) {
                this.vxP.g(adl);
            }
        }
    }

    public final boolean bJP() {
        c.x("TalkRoomService", new Object[]{"state: ", Integer.valueOf(this.state)});
        if (this.state != 0) {
            return true;
        }
        return false;
    }

    public final e adm(String str) {
        return (e) this.vxo.get(str);
    }

    public final boolean adn(String str) {
        return ((e) this.vxo.get(str)) != null;
    }

    private void cHT() {
        c.x("TalkRoomService", new Object[]{"hello timer start~~"});
        if (this.vxK != null) {
            c.x("TalkRoomService", new Object[]{"dealWithInit enter talkroom not first time"});
            return;
        }
        try {
            this.vxK = new TimerTask() {
                public final void run() {
                    if (f.this.kvL == 0 || f.this.jTX == null) {
                        c.x("TalkRoomService", new Object[]{"talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(f.this.kvL), f.this.jTX});
                        f.this.cHV();
                        return;
                    }
                    f.a(f.this, f.j(f.this));
                }
            };
            this.vxM.schedule(this.vxK, 0, (long) vxu);
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"startNooper: ", e});
        }
    }

    private void cHU() {
        try {
            c.x("TalkRoomService", new Object[]{"cancelHelloTimeOutTask"});
            if (this.vxL != null) {
                this.vxL.cancel();
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"cancelHelloTimeOutTask: ", e});
        }
        this.vxL = null;
    }

    private void cHV() {
        try {
            c.x("TalkRoomService", new Object[]{"cancelHelloTimerTask"});
            if (this.vxK != null) {
                this.vxK.cancel();
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"cancelHelloTimerTask: ", e});
        }
        this.vxK = null;
    }

    private void a(int i, av[] avVarArr, as asVar, byte[] bArr, boolean z, String str, int i2, long j, int i3, int i4, byte[] bArr2) {
        Exception e;
        c.d("TalkRoomService", new Object[]{"dealWithInit", Integer.valueOf(i), str, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(this.state)});
        if (this.vxI != null) {
            boolean z2;
            try {
                if (this.state != 4) {
                    c.x("TalkRoomService", new Object[]{"dealWithInit state is error: ", Integer.valueOf(this.state)});
                    z2 = false;
                } else {
                    z2 = a(avVarArr, asVar, bArr, z, i2, j, i3, i4, bArr2);
                }
                try {
                    c.x("TalkRoomService", new Object[]{"dealWithInit ret: ", Boolean.valueOf(z2)});
                } catch (Exception e2) {
                    e = e2;
                    c.x("TalkRoomService", new Object[]{"dealWithInit ", e});
                    if (z2) {
                        return;
                    }
                    if (i > 0) {
                        this.mHandler.postDelayed(new 4(this, i, avVarArr, asVar, bArr, z, str, i2, j, i3, i4, bArr2), 50);
                    }
                    this.vxH.Ix(TbsListener$ErrorCode.APK_PATH_ERROR);
                    c.x("TalkRoomService", new Object[]{"exitTalkRoom dealWithInit fail"});
                    a(str, i2, j, 102, true);
                    this.vxP.h(-400, null);
                    return;
                }
            } catch (Exception e3) {
                e = e3;
                z2 = false;
            }
            if (z2) {
                return;
            }
        }
        if (i > 0) {
            this.vxH.Ix(TbsListener$ErrorCode.APK_PATH_ERROR);
            c.x("TalkRoomService", new Object[]{"exitTalkRoom dealWithInit fail"});
            a(str, i2, j, 102, true);
            this.vxP.h(-400, null);
            return;
        }
        this.mHandler.postDelayed(new 4(this, i, avVarArr, asVar, bArr, z, str, i2, j, i3, i4, bArr2), 50);
    }

    final boolean bHg() {
        int zj;
        c.d("TalkRoomService", new Object[]{"initEngine", this.jTX, Integer.valueOf(this.kvL), Long.valueOf(this.vxz), Integer.valueOf(this.state)});
        try {
            b bVar = this.vxI;
            if (com.tencent.pb.common.a.a.vbD) {
                int i;
                String absolutePath = com.tencent.pb.common.c.d.oSX.getDir("lib", 0).getAbsolutePath();
                e eVar = vco;
                if (eVar != null) {
                    zj = eVar.zj();
                } else {
                    zj = 0;
                }
                c.d("simon:TalkRoomContext", new Object[]{"protocalInit netType:", Integer.valueOf(k.ih(com.tencent.pb.common.c.d.oSX)), " cpuFlag:", Integer.valueOf(zj), "libPath:", absolutePath});
                zj = bVar.vwZ.init(r6, zj, absolutePath + "/");
                absolutePath = "simon:TalkRoomContext";
                Object[] objArr = new Object[4];
                objArr[0] = "protocalInit";
                objArr[1] = Integer.valueOf(zj);
                objArr[2] = "field_capInfo length: ";
                if (bVar.vwZ.field_capInfo == null) {
                    i = 0;
                } else {
                    i = bVar.vwZ.field_capInfo.length;
                }
                objArr[3] = Integer.valueOf(i);
                c.d(absolutePath, objArr);
            } else {
                zj = 0;
            }
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"initEngine", e});
            zj = -99999;
        }
        if (zj >= 0) {
            return true;
        }
        h.Iw(-3001);
        this.vxH.Ix(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM);
        this.vxI = null;
        c.x("TalkRoomService", new Object[]{"initEngine engine.protocalInit error", Integer.valueOf(zj)});
        return false;
    }

    public final void mU(boolean z) {
        try {
            we();
            cHR();
            if (z) {
                cHW();
                aiN();
            }
            c.x("TalkRoomService", new Object[]{"setRecordDevActive active: ", Boolean.valueOf(z)});
        } catch (Throwable th) {
            c.x("TalkRoomService", new Object[]{"setRecordDevActive active: ", Boolean.valueOf(z), th});
        }
    }

    private void aiN() {
        we();
        int b = b(talk.lsT, talk.lsU, new 5(this));
        if (b <= 0) {
            this.vxH.Ix(101);
            h.Iu(-2001);
            this.vxP.h(-500, null);
        }
        h hVar;
        if (b > 0) {
            hVar = this.vxH;
            hVar.vyV &= -2;
        } else {
            hVar = this.vxH;
            hVar.vyV |= 1;
        }
        c.x("TalkRoomService", new Object[]{"audioAdapter startRecord ret: ", Integer.valueOf(b)});
    }

    private void cHW() {
        cHR();
        if (b(talk.lsT, talk.lsU, new 6(this, new AtomicInteger(), new AtomicInteger())) <= 0) {
            this.vxH.Ix(101);
            h.Iu(-2001);
            h hVar = this.vxH;
            hVar.vyV |= 1;
            this.vxP.h(-500, null);
        }
        c.x("TalkRoomService", new Object[]{"audioAdapter startPlayer ret: ", Integer.valueOf(r0)});
    }

    private boolean a(av[] avVarArr, as asVar, byte[] bArr, boolean z, int i, long j, int i2, int i3, byte[] bArr2) {
        int[] iArr;
        int i4;
        int i5;
        c.d("TalkRoomService", new Object[]{"connectToCompenent myRoomMemId roomid:", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " groupId: ", this.jTX, " ip: ", Arrays.toString(this.vxZ), " ports: ", Arrays.toString(this.vxY), " tcpIp: ", Arrays.toString(this.vyb), " tcpPorts: ", Arrays.toString(this.vya), " tcpStartTime: ", Integer.valueOf(this.vyc)});
        String cEG = com.tencent.pb.a.a.a.cEG();
        int i6 = -1;
        if (avVarArr == null || avVarArr.length <= 0) {
            iArr = null;
            i4 = -1;
        } else {
            int[] iArr2 = new int[avVarArr.length];
            for (i5 = 0; i5 < avVarArr.length; i5++) {
                iArr2[i5] = avVarArr[i5].kpU;
                if (g.equals(avVarArr[i5].vez, cEG)) {
                    i6 = avVarArr[i5].kpU;
                }
            }
            iArr = iArr2;
            i4 = i6;
        }
        int adh = c.cHG().adh(this.jTX);
        this.vxH.kpU = i4;
        try {
            int i7;
            b bVar = this.vxI;
            talk.a aVar = this.vxJ;
            TalkRoom adg = c.cHG().adg(this.jTX);
            if (adg == null) {
                c.x("TalkRoomManager", new Object[]{"getMyUuid TalkRoom is null  groupId: ", r3});
                i7 = 0;
            } else {
                d adf = adg.adf(com.tencent.pb.a.a.a.cEG());
                if (adf == null) {
                    c.x("TalkRoomManager", new Object[]{"getMyUuid talkRoomMember is null  groupId: ", r3});
                    i7 = 0;
                } else {
                    av avVar = adf.vxf;
                    if (avVar == null) {
                        c.x("TalkRoomManager", new Object[]{"getMyUuid voiceGroupMem is null  groupId: ", r3});
                        i7 = 0;
                    } else {
                        c.d("TalkRoomManager", new Object[]{"getMyUuid groupId: ", r3, " uuid: ", Integer.valueOf(avVar.qXJ)});
                        i7 = avVar.qXJ;
                    }
                }
            }
            int[] iArr3 = this.vxZ;
            short[] sArr = this.vxY;
            int[] iArr4 = this.vyb;
            short[] sArr2 = this.vya;
            int i8 = this.vyc;
            c.d("simon:TalkRoomContext", new Object[]{"Open"});
            i iVar = null;
            if (asVar != null) {
                iVar = new i(asVar.veK, asVar.dQN, asVar.dQO, asVar.veL, asVar.veM, asVar.veN, asVar.veO, asVar.veP, asVar.veQ, asVar.veR, asVar.veS, asVar.veT);
            } else {
                c.x("simon:TalkRoomContext", new Object[]{"voiceConf is null"});
            }
            i5 = bVar.vwZ.Open(aVar, iVar, i7, i4, i, j, iArr3, sArr, 0, iArr, bArr, z, k.ih(com.tencent.pb.common.c.d.oSX), iArr4, sArr2, i8, i2, i3, bArr2);
        } catch (Throwable th) {
            c.x("TalkRoomService", new Object[]{"connectToCompenent", th});
            i5 = -99999;
        }
        g gVar = this.vxP;
        Runnable g_2 = new g$2(gVar, i5);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g_2.run();
        } else {
            gVar.handler.post(g_2);
        }
        c.d("TalkRoomService", new Object[]{"connectToCompenent ret =", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(adh)});
        if (i5 < 0) {
            h.Iw(-3002);
        }
        if (i5 == 0) {
            this.vxH.oWO = 1;
        }
        if (i5 == 0) {
            return true;
        }
        return false;
    }

    private boolean b(String str, int i, long j, boolean z) {
        if (z) {
            return g.gr(str, this.jTX);
        }
        c.x("TalkRoomService", new Object[]{"isCurrentRoom groupId: ", str, " mGroupId: ", this.jTX, "roomId: ", Integer.valueOf(i), " mRoomId: ", Integer.valueOf(this.kvL), " roomKey: ", Long.valueOf(j), " mRoomKey: ", Long.valueOf(this.vxz)});
        if (g.gr(str, this.jTX) && i == this.kvL && j == this.vxz) {
            return true;
        }
        return false;
    }

    private void i(String str, int i, long j) {
        String str2 = null;
        try {
            c cHG = c.cHG();
            if (i == 0 && j == 0) {
                c.x("TalkRoomManager", new Object[]{"getMsgKeyByGroupId roomId and roomKey is 0,groupId: ", str});
            } else {
                TalkRoom adg = cHG.adg(str);
                if (adg == null) {
                    c.x("TalkRoomManager", new Object[]{"getMsgKeyByGroupId talkRoom is null,groupId: ", str});
                } else {
                    d adf = adg.adf(com.tencent.pb.a.a.a.cEG());
                    if (adf == null) {
                        c.x("TalkRoomManager", new Object[]{"getMsgKeyByGroupId talkRoomMember is null,groupId: ", str});
                    } else {
                        av avVar = adf.vxf;
                        if (avVar == null) {
                            c.x("TalkRoomManager", new Object[]{"getMsgKeyByGroupId voiceGroupMem is null,groupId: ", str});
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(",");
                            stringBuffer.append(i);
                            stringBuffer.append(",");
                            stringBuffer.append(j);
                            stringBuffer.append(",");
                            stringBuffer.append(avVar.vfu);
                            c.x("TalkRoomManager", new Object[]{"getMsgKeyByGroupId msgKey is", stringBuffer.toString()});
                            str2 = stringBuffer.toString();
                        }
                    }
                }
            }
            c.x("TalkRoomService", new Object[]{"addCallLog groupId: ", str, " mIsOutCall: ", Boolean.valueOf(this.oLU), " mTalkDuration: ", Integer.valueOf(this.vxA), " msgKey: ", str2});
        } catch (Throwable th) {
            c.x("TalkRoomService", new Object[]{"handleRoomExit: ", th});
        }
    }

    public final boolean ar(String str, int i, int i2) {
        c.x("TalkRoomService", new Object[]{"finishCurrentTalk groupId: ", str, " rejectReason: ", Integer.valueOf(i), " exitReason: ", Integer.valueOf(i2)});
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i == 1 || i2 == 100) {
            h hVar = this.vxH;
            c.d(h.TAG, new Object[]{"endCancelCreate", Long.valueOf(System.currentTimeMillis() - hVar.vzi), Long.valueOf(hVar.vyX)});
            if (hVar.vyX <= 0) {
                hVar.oWS = 1;
                if (hVar.vzi == 0) {
                    hVar.oWT = 0;
                } else {
                    hVar.oWT = System.currentTimeMillis() - hVar.vzi;
                }
            }
        }
        int i3 = this.kvL;
        long j = this.vxz;
        int i4 = a.cHu().state;
        if (j.ads(str)) {
            this.vxH.Ix(TbsListener$ErrorCode.TEST_THROWABLE_ISNOT_NULL);
            return a.cHu().dG(str, TbsLog.TBSLOG_CODE_SDK_BASE);
        } else if (i4 == 2) {
            return a.cHu().a(str, i3, j, i);
        } else {
            Integer[] numArr = new Integer[]{Integer.valueOf(102), Integer.valueOf(103), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(106), Integer.valueOf(107), Integer.valueOf(108)};
            List arrayList = new ArrayList();
            for (i4 = 0; i4 < 7; i4++) {
                arrayList.add(numArr[i4]);
            }
            arrayList.contains(Integer.valueOf(i2));
            return a.cHu().a(str, i3, j, i2, true);
        }
    }

    public final void dE(String str, int i) {
        if (!g.equals("GLOBAL_TOPIC_NETWORK_CHANGE", str) || !bJP()) {
            return;
        }
        if (this.kFG || this.vxw) {
            switch (i) {
                case 21:
                    switch (k.ih(com.tencent.pb.common.c.d.oSX)) {
                        case 4:
                            this.vxR = true;
                            break;
                        default:
                            this.vxR = false;
                            break;
                    }
                    if (this.kvL == 0 || this.vxz == 0) {
                        c.x("TalkRoomService", new Object[]{"sendRedirect mRoomId valid(session ended)"});
                        return;
                    }
                    c.x("TalkRoomService", new Object[]{"sendRedirect", this.jTX, Integer.valueOf(this.kvL)});
                    this.vxH.cIa();
                    boolean a = com.tencent.pb.common.b.e.cEn().a(new com.tencent.wecall.talkroom.a.h(this.jTX, this.kvL, this.vxz, c.cHG().adh(this.jTX)));
                    this.vxH.Q(new String[]{"redirect", "req", String.valueOf(a), String.valueOf(this.state)});
                    c.x("TalkRoomService", new Object[]{"sendRedirect ret: ", Boolean.valueOf(a)});
                    return;
                case 33:
                    b bVar = this.vxI;
                    int ih = k.ih(com.tencent.pb.common.c.d.oSX);
                    if (com.tencent.pb.common.a.a.vbD) {
                        bVar.vwZ.onNetworkChange(ih);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean Ir(int i) {
        return i != 1;
    }

    private void a(String str, int i, long j, String str2, String str3) {
        this.kvL = i;
        this.vxz = j;
        this.jTX = str2;
        this.vxy = str;
        this.vxx = str3;
    }

    public static boolean yJ() {
        boolean isSpeakerphoneOn;
        try {
            isSpeakerphoneOn = ((AudioManager) com.tencent.pb.common.c.d.oSX.getSystemService("audio")).isSpeakerphoneOn();
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"isSpeakerOn ", e});
            isSpeakerphoneOn = false;
        }
        c.d("TalkRoomService", new Object[]{"isSpeakerOn ret: ", Boolean.valueOf(isSpeakerphoneOn)});
        return isSpeakerphoneOn;
    }

    public static void a(e eVar) {
        vco = eVar;
    }

    public static e cHX() {
        return vco;
    }
}
