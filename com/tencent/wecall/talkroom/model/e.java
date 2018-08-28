package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;
import com.tencent.pb.common.c.h;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.model.f.b;
import com.tencent.wecall.talkroom.model.g.10;
import com.tencent.wecall.talkroom.model.g.12;
import com.tencent.wecall.talkroom.model.g.14;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class e implements d {
    private static e vxi = null;
    private final String TAG = "TalkRoomSdkApi";
    private a vxh = null;
    private ConnectReceiver vxj = new ConnectReceiver();
    private g.a vxk = new 1(this);

    public static e cHL() {
        if (vxi == null) {
            synchronized (e.class) {
                if (vxi == null) {
                    vxi = new e();
                }
            }
        }
        return vxi;
    }

    private e() {
    }

    public static void ig(Context context) {
        com.tencent.pb.common.c.d.oSX = context;
        i.if(context);
    }

    public final boolean a(a aVar, com.tencent.pb.talkroom.sdk.e eVar) {
        if (com.tencent.pb.common.c.d.oSX == null) {
            c.x("TalkRoomSdkApi", new Object[]{"init fail context: ", com.tencent.pb.common.c.d.oSX});
            return false;
        }
        try {
            this.vxh = aVar;
            f.a(eVar);
            f cHu = a.cHu();
            g.a aVar2 = this.vxk;
            g gVar = cHu.vxP;
            synchronized (aVar2) {
                if (gVar.cWy.contains(aVar2)) {
                } else {
                    gVar.cWy.add(aVar2);
                }
            }
            f.cEq().vco = eVar;
            a.cHt();
            a.cHv();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Integer.MAX_VALUE);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.tencent.pb.common.c.d.oSX.registerReceiver(this.vxj, intentFilter);
            c.d("TalkRoomSdkApi", new Object[]{"init"});
            return true;
        } catch (Exception e) {
            c.x("TalkRoomSdkApi", new Object[]{"init ", e});
            return false;
        }
    }

    public final void mN(boolean z) {
        f cHu = a.cHu();
        c.x("TalkRoomService", new Object[]{"setMute isMute: ", Boolean.valueOf(z)});
        cHu.mIsMute = z;
        h.af(new 14(cHu.vxP, z));
    }

    public final void gK(boolean z) {
        boolean gG;
        a.cHu();
        com.tencent.pb.talkroom.sdk.e cHX = f.cHX();
        if (cHX != null) {
            gG = cHX.gG(z);
        } else {
            gG = false;
        }
        c.d("TalkRoomService", new Object[]{"switchSpeakerPhone", Boolean.valueOf(z), " ret: ", Boolean.valueOf(gG), " realret: ", Boolean.valueOf(f.yJ()), " wxCallBack: ", cHX});
    }

    public final boolean cEI() {
        try {
            c.cED();
            c.x("TalkRoomSdkApi", new Object[]{"setOpenLog: isOpenSdkLog", Boolean.valueOf(true), " level: ", Integer.valueOf(0)});
            return true;
        } catch (Throwable th) {
            c.x("TalkRoomSdkApi", new Object[]{"setOpenLog: ", th});
            return false;
        }
    }

    public final boolean f(String str, String str2, List<String> list) {
        f cHu = a.cHu();
        String[] en = f.en(list);
        if (en.length > 0) {
            int nextInt;
            if (TextUtils.isEmpty(null)) {
                nextInt = (new Random().nextInt() << 16) | (com.tencent.pb.a.a.a.cEG().hashCode() & 65535);
            } else {
                String str3 = null;
                String str4 = null;
                int charAt = str3.charAt(str4.length() - 1) * 256;
                nextInt = 0;
                String str5 = null;
                if (str5.length() > 1) {
                    str3 = null;
                    str5 = null;
                    nextInt = str3.charAt(str5.length() - 2);
                }
                nextInt += charAt;
            }
            c.x("TalkRoomService", new Object[]{"createTalkRoom cliendId: ", str, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(en.length), "routeId", Integer.valueOf(nextInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0), " sdkKey: ", null});
            if (!com.tencent.pb.a.a.a.cEH()) {
                c.x("TalkRoomService", new Object[]{"createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.cEH()), " isBindMobile: ", Boolean.valueOf(true)});
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "noAuth"});
            } else if (!com.tencent.pb.common.b.h.isNetworkConnected()) {
                c.x("TalkRoomService", new Object[]{"createTalkRoom isNetworkConnected is false"});
                h.Iv(-4003);
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "noNetwork"});
            } else if (cHu.bJP()) {
                if (cHu.bJP()) {
                    h.Iv(-4002);
                }
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "isBusy"});
            } else if (TextUtils.isEmpty(str)) {
                c.x("TalkRoomService", new Object[]{"createTalkRoom cliendId is null"});
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "cliendIdnull"});
            } else if (j.ads(str)) {
                if (c.cHG().adg(str) == null) {
                    c.cHG().c(str, str2, en);
                }
                cHu.cHS();
                cHu.mT(false);
                cHu.cHP();
                if (cHu.bHg()) {
                    cHu.vxH.cHZ();
                    cHu.jTX = str;
                    cHu.vxT = str;
                    cHu.vcc = nextInt;
                    cHu.vxy = str;
                    cHu.setState(1);
                    cHu.oLU = true;
                    f.a aVar = new f.a(cHu);
                    aVar.groupId = cHu.jTX;
                    aVar.vyv = en;
                    aVar.vyw = null;
                    aVar.vcN = nextInt;
                    aVar.type = 0;
                    aVar.vyx = 0;
                    aVar.vyy = null;
                    aVar.vyz = false;
                    aVar.vyA = str2;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = aVar;
                    cHu.mHandler.removeMessages(2);
                    TalkRoom adg = c.cHG().adg(cHu.jTX);
                    if (adg == null) {
                        c.x("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup talkroom is null"});
                    } else {
                        List cHA = adg.cHA();
                        if (cHA == null || cHA.size() != 1) {
                            c.x("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup TalkRoomMember list is not match"});
                        } else {
                            d dVar = (d) cHA.get(0);
                            if (dVar == null) {
                                c.x("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup talkRoomMember is null"});
                            } else {
                                boolean cHK = dVar.cHK();
                                c.x("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup ret: ", Boolean.valueOf(cHK)});
                            }
                        }
                    }
                    cHu.mHandler.sendMessage(obtain);
                    cHu.vxV = true;
                    c.x("TalkRoomSdkApi", new Object[]{"createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.a.a.a.cEG(), " usrnameList: ", list});
                    return str == null;
                } else {
                    c.x("TalkRoomService", new Object[]{"createTalkRoom initEngine fail"});
                    h.a("", str, 0, 0, new String[]{"create", "req", "false", "initEnginefail"});
                    cHu.mT(false);
                }
            } else {
                c.x("TalkRoomService", new Object[]{"createTalkRoom groupId is not cliend id: ", str});
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "isnotcliendId"});
            }
        }
        str = null;
        c.x("TalkRoomSdkApi", new Object[]{"createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.a.a.a.cEG(), " usrnameList: ", list});
        if (str == null) {
        }
    }

    public final boolean B(String str, int i, String str2) {
        f cHu = a.cHu();
        c.x("TalkRoomSdkApi", new Object[]{"enterMultiTalk multiTalkGroupid:", str, " isAccept: ", Boolean.valueOf(true), " routId: ", Integer.valueOf(i), " ret: ", cHu.a(str, cHu.kvL, cHu.vxz, i, 1, str2)});
        if (cHu.a(str, cHu.kvL, cHu.vxz, i, 1, str2) == b.vyB) {
            return true;
        }
        return false;
    }

    public final boolean a(String str, int i, long j, int i2, String str2) {
        c.x("TalkRoomSdkApi", new Object[]{"enterMultiTalk multiTalkGroupid:", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " routId: ", Integer.valueOf(i2), " wxGroupId: ", str2, " ret: ", a.cHu().a(str, i, j, i2, 100, str2)});
        return a.cHu().a(str, i, j, i2, 100, str2) == b.vyB;
    }

    public final boolean u(String str, List<String> list) {
        if (g.gr(str, a.cHu().jTX)) {
            boolean z;
            f cHu = a.cHu();
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "addrTalkRoomMember";
            objArr[1] = str;
            objArr[2] = Integer.valueOf(cHu.kvL);
            objArr[3] = Long.valueOf(cHu.vxz);
            objArr[4] = " users length: ";
            objArr[5] = Integer.valueOf(list == null ? 0 : list.size());
            c.x(str2, objArr);
            cHu.vxV = false;
            if (TextUtils.isEmpty(str) || list == null) {
                z = false;
            } else if (com.tencent.pb.common.b.h.isNetworkConnected()) {
                String[] en = f.en(list);
                if (en.length <= 0) {
                    c.x("TalkRoomService", new Object[]{"addTalkRoomMember users is null"});
                    z = false;
                } else {
                    z = com.tencent.pb.common.b.e.cEn().a(new com.tencent.wecall.talkroom.a.b(str, cHu.kvL, cHu.vxz, en));
                    cHu.vxH.Q(new String[]{"add", "req", String.valueOf(z), String.valueOf(cHu.state)});
                }
            } else {
                c.x("TalkRoomService", new Object[]{"addTalkRoomMember isNetworkConnected is false"});
                z = false;
            }
            c.x("TalkRoomSdkApi", new Object[]{"addMultiTalkMember ret: ", Boolean.valueOf(z)});
            return z;
        }
        c.x("TalkRoomSdkApi", new Object[]{"addMultiTalkMember groupid is not same; multiTalkGroupid: ", str, a.cHu().jTX});
        return false;
    }

    public final boolean HI(String str) {
        long j;
        if (g.gr(str, a.cHu().jTX)) {
            int i = a.cHu().kvL;
            j = a.cHu().vxz;
            boolean ar = a.cHu().ar(str, 1, 100);
            c.x("TalkRoomSdkApi", new Object[]{"exitMultiTalk groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j)});
            return ar;
        }
        c.x("TalkRoomSdkApi", new Object[]{"exitMultiTalk groupid is not same; multiTalkGroupid: ", str, a.cHu().jTX});
        if (!a.cHu().adn(str)) {
            return false;
        }
        int i2;
        com.tencent.wecall.talkroom.model.f.e adm = a.cHu().adm(str);
        f cHu = a.cHu();
        if (adm == null) {
            i2 = 0;
        } else {
            i2 = adm.kpo;
        }
        if (adm == null) {
            j = 0;
        } else {
            j = adm.kpp;
        }
        cHu.a(str, i2, j, 1);
        return false;
    }

    public final List<String> acj(String str) {
        if (g.gr(str, a.cHu().jTX)) {
            TalkRoom adg = c.cHG().adg(str);
            if (adg == null) {
                c.x("TalkRoomManager", new Object[]{"getTalkingMember talkroom is null: groupId: ", str});
                return null;
            }
            List<d> cHB = adg.cHB();
            List<String> arrayList = new ArrayList();
            for (d dVar : cHB) {
                if (dVar != null) {
                    int i;
                    f cHu = a.cHu();
                    int cHJ = dVar.cHJ();
                    if (cHu.vxI != null) {
                        i = (com.tencent.pb.common.a.a.vbD && cHu.vxI.vwZ.GetVoiceActivity(cHJ) == 1) ? 1 : 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        arrayList.add(dVar.cHI());
                    }
                }
            }
            return arrayList;
        }
        c.x("TalkRoomSdkApi", new Object[]{"getTalkingMember groupid is not same; multiTalkGroupid: ", str, a.cHu().jTX});
        return null;
    }

    public final boolean c(int i, int i2, int i3, byte[] bArr) {
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[8];
        objArr[0] = "handleMultiTalkResp retCode: ";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = " seq: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " cmdId: ";
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = " data length: ";
        objArr[7] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        c.x(str, objArr);
        if (i == 0) {
            f.cEq().s(i2, bArr);
        } else {
            f cEq = f.cEq();
            f.a Hh = cEq.Hh(i2);
            if (Hh != null) {
                c.x("NETCMD", new Object[]{"CLTRCV FAIL", Integer.valueOf(i2), Hh.vcr, Integer.valueOf(1), Integer.valueOf(i)});
                cEq.a(Hh, -1, null);
            }
        }
        return true;
    }

    public final boolean bL(byte[] bArr) {
        f.cEq();
        c.x("TalkRoomSdkApi", new Object[]{"handleMultiTalkNotify ret: ", Integer.valueOf(f.bK(bArr))});
        if (f.bK(bArr) == 0) {
            return true;
        }
        return false;
    }

    public final boolean mO(boolean z) {
        c.x("TalkRoomSdkApi", new Object[]{"holadMultiTalk isHold", Boolean.valueOf(z)});
        f cHu;
        if (z) {
            cHu = a.cHu();
            c.d("TalkRoomService", new Object[]{"syscall", "startHoldOn"});
            cHu.vyd = true;
            cHu.mU(false);
            h.af(new 10(cHu.vxP));
        } else {
            cHu = a.cHu();
            c.d("TalkRoomService", new Object[]{"syscall", "endHoldOn"});
            cHu.vyd = false;
            cHu.cHQ();
            if (cHu.bJP() && cHu.kFG) {
                cHu.mU(true);
                h.af(new 12(cHu.vxP));
            }
        }
        return true;
    }

    public final String cEJ() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client_");
        stringBuilder.append(com.tencent.pb.a.a.a.cEG());
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        c.x("TalkRoomSdkApi", new Object[]{"genMultiTalkClientId clientId: ", stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public final void bg(int i, String str) {
        com.tencent.pb.a.a.a.Hi(i);
        com.tencent.pb.a.a.a.aci(str);
        c.x("TalkRoomSdkApi", new Object[]{"setWxUinAndUsrName uin: ", Integer.valueOf(i), " usrname: ", str});
    }

    public final boolean ti(int i) {
        if (a.cHu().bJP()) {
            c.d("TalkRoomSdkApi", new Object[]{"switchMultiTalkVideo action: ", Integer.valueOf(i)});
            f cHu = a.cHu();
            if (TextUtils.isEmpty(cHu.jTX)) {
                c.x("TalkRoomService", new Object[]{"switchMultiTalkVideo mGroupId is null"});
                return false;
            }
            cHu.vxG = i;
            c.d("TalkRoomService", new Object[]{"switchMultiTalkVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.cEn().a(new l(cHu.jTX, cHu.kvL, cHu.vxz, i)))});
            return com.tencent.pb.common.b.e.cEn().a(new l(cHu.jTX, cHu.kvL, cHu.vxz, i));
        }
        c.x("TalkRoomSdkApi", new Object[]{"switchMultiTalkVideo isWorking is false"});
        return false;
    }

    public final boolean HA(String str) {
        if (a.cHu().bJP()) {
            c.d("TalkRoomSdkApi", new Object[]{"subscribeLargeVideo ownerUserName: ", str});
            f cHu = a.cHu();
            if (TextUtils.isEmpty(cHu.jTX)) {
                c.x("TalkRoomService", new Object[]{"subscribeLargeVideo mGroupId null "});
                return false;
            }
            c.d("TalkRoomService", new Object[]{"subscribeLargeVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.cEn().a(new k(cHu.jTX, cHu.kvL, cHu.vxz, str)))});
            return com.tencent.pb.common.b.e.cEn().a(new k(cHu.jTX, cHu.kvL, cHu.vxz, str));
        }
        c.x("TalkRoomSdkApi", new Object[]{"subscribeLargeVideo isWorking is false"});
        return false;
    }

    public final int a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        int SendVideo;
        f cHu = a.cHu();
        if (cHu.vxI != null) {
            c.d("TalkRoomService", new Object[]{"sendVideo ", Integer.valueOf(i), Integer.valueOf(i2)});
            SendVideo = cHu.vxI.vwZ.SendVideo(bArr, s, i, i2, i3, i4);
        } else {
            SendVideo = -1;
        }
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[12];
        objArr[0] = "sendVideo buffer size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Short.valueOf(s);
        objArr[4] = " w: ";
        objArr[5] = Integer.valueOf(i);
        objArr[6] = " h: ";
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = " format: ";
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = " mode: ";
        objArr[11] = Integer.valueOf(i4);
        c.d(str, objArr);
        return SendVideo;
    }

    public final com.tencent.pb.talkroom.sdk.f t(int[] iArr) {
        com.tencent.pb.talkroom.sdk.f fVar;
        int i = 0;
        f cHu = a.cHu();
        if (cHu.vxI != null) {
            c.d("TalkRoomService", new Object[]{"receiveVideo"});
            b bVar = cHu.vxI;
            com.tencent.pb.talkroom.sdk.f fVar2 = new com.tencent.pb.talkroom.sdk.f();
            if (iArr == null) {
                c.x("simon:TalkRoomContext", new Object[]{"receiveVideo imgBuffer is null"});
                fVar = fVar2;
            } else {
                String str;
                String str2;
                Object[] objArr;
                fVar2.ret = bVar.vwZ.videoDecode(iArr);
                fVar2.vgt = iArr;
                fVar2.vgu = bVar.vwZ.field_remoteImgLength;
                fVar2.vgv = bVar.vwZ.field_remoteImgWidth;
                fVar2.vgw = bVar.vwZ.field_remoteImgHeight;
                fVar2.vgx = bVar.vwZ.field_remoteImgChannel & 16383;
                c cHG = c.cHG();
                Object obj = a.cHu().jTX;
                int i2 = fVar2.vgx;
                if (TextUtils.isEmpty(obj)) {
                    c.x("TalkRoomManager", new Object[]{"getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i2)});
                } else {
                    TalkRoom adg = cHG.adg(obj);
                    if (adg == null) {
                        c.x("TalkRoomManager", new Object[]{"getUsrNameByMemberId talkRoom is null groupId: ", obj, " memberId: ", Integer.valueOf(i2)});
                    } else {
                        for (av avVar : adg.cHD()) {
                            if (avVar != null && avVar.kpU == i2) {
                                c.d("TalkRoomManager", new Object[]{"getUsrNameByMemberId wxUserName:", avVar.vez, " groupId: ", obj, " memberId: ", Integer.valueOf(i2)});
                                if (avVar.vez != null) {
                                    str = avVar.vez;
                                    fVar2.vgr = str;
                                    str2 = "simon:TalkRoomContext";
                                    objArr = new Object[4];
                                    objArr[0] = "receiveVideo imgBuffer size:";
                                    objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                                    objArr[3] = fVar2;
                                    c.d(str2, objArr);
                                    fVar = fVar2;
                                }
                            }
                        }
                    }
                }
                str = "";
                fVar2.vgr = str;
                str2 = "simon:TalkRoomContext";
                objArr = new Object[4];
                objArr[0] = "receiveVideo imgBuffer size:";
                if (iArr != null) {
                }
                objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                objArr[2] = " MultiTalkVideoDecodeInfo: ";
                objArr[3] = fVar2;
                c.d(str2, objArr);
                fVar = fVar2;
            }
        } else {
            fVar = new com.tencent.pb.talkroom.sdk.f();
        }
        String str3 = "TalkRoomSdkApi";
        Object[] objArr2 = new Object[4];
        objArr2[0] = "receiveVideo imgBuffer size: ";
        if (iArr != null) {
            i = iArr.length;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = " MultiTalkVideoDecodeInfo: ";
        objArr2[3] = fVar;
        c.d(str3, objArr2);
        return fVar;
    }

    public final com.tencent.pb.talkroom.sdk.g a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        f cHu = a.cHu();
        com.tencent.pb.talkroom.sdk.g gVar = new com.tencent.pb.talkroom.sdk.g();
        if (cHu.vxI != null) {
            b bVar = cHu.vxI;
            int videoTrans = bVar.vwZ.videoTrans(bArr, i, i2, i3, i4, iArr);
            gVar = new com.tencent.pb.talkroom.sdk.g();
            gVar.vgy = iArr;
            gVar.vgz = bVar.vwZ.field_localImgWidth;
            gVar.vgA = bVar.vwZ.field_localImgHeight;
            gVar.ret = videoTrans;
        }
        c.d("TalkRoomService", new Object[]{"videoTrans ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), " multiTalkVideoRGBinfo: ", gVar, " engine: ", cHu.vxI});
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[11];
        objArr[0] = "videoTrans recordData size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " localImg size: ";
        objArr[5] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(i4);
        objArr[9] = " multiTalkVideoRGBinfo: ";
        objArr[10] = gVar;
        c.d(str, objArr);
        return gVar;
    }

    public final int setAppCmd(int i, byte[] bArr, int i2) {
        int i3;
        f cHu = a.cHu();
        if (cHu.vxI == null) {
            c.x("TalkRoomService", new Object[]{"setAppCmd type: ", Integer.valueOf(i), " engine is null"});
            i3 = -1;
        } else {
            i3 = cHu.vxI.vwZ.setAppCmd(i, bArr, i2);
        }
        c.d("TalkRoomSdkApi", new Object[]{"setAppCmd type: ", Integer.valueOf(i), " paramLen: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3)});
        return i3;
    }
}
