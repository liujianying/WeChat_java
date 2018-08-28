package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.f;
import com.tencent.pb.common.c.g;
import java.util.ArrayList;

public class h {
    static final String TAG = h.class.getCanonicalName();
    public static h vyU = new h();
    String deviceModel;
    public String groupId = "";
    public int kpU = -1;
    public int kpo = 0;
    public long kpp = 0;
    long kqK = 0;
    int kqL = 0;
    public int netType = -1;
    public int oOA = 0;
    public int oOD = 0;
    public int oOK = -1;
    public int oOw = 1;
    public int oOz = 0;
    int oWL = 0;
    int oWO = 0;
    int oWS = 0;
    long oWT = 0;
    int oWY = 0;
    public int oWZ = 0;
    String oXe = "";
    public String vcI = "";
    public int vyV = 0;
    int vyW = 0;
    long vyX = 0;
    long vyY = 0;
    int vyZ = 0;
    public int vza = 0;
    int vzb = 0;
    long vzc = 0;
    int vzd;
    int vze = -1;
    String vzf;
    int vzg;
    StringBuffer vzh = new StringBuffer();
    long vzi = 0;
    long vzj = 0;
    long vzk = 0;

    public final String cHY() {
        int i;
        c.d(TAG, new Object[]{"collectInfo"});
        this.vzf = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.vzg = VERSION.SDK_INT;
        this.oXe = VERSION.RELEASE;
        this.netType = k.ih(d.oSX);
        this.vzd = -1;
        this.vze = -1;
        Iterable arrayList = new ArrayList();
        arrayList.add(this.groupId);
        arrayList.add(this.vcI);
        arrayList.add(Integer.valueOf(this.oOw));
        arrayList.add(Integer.valueOf(this.kpo));
        arrayList.add(Long.valueOf(this.kpp));
        arrayList.add(Integer.valueOf(this.kpU));
        arrayList.add(Integer.valueOf(this.oWL));
        arrayList.add(Integer.valueOf(this.oWS));
        arrayList.add(Integer.valueOf(this.oWO));
        arrayList.add(Integer.valueOf(this.kqL));
        arrayList.add(Integer.valueOf(this.vyV));
        arrayList.add(Integer.valueOf(this.vyW));
        arrayList.add(Long.valueOf(this.vyX));
        arrayList.add(Long.valueOf(this.vyY));
        arrayList.add(Integer.valueOf(this.vyZ));
        arrayList.add(Integer.valueOf(this.vza));
        arrayList.add(Integer.valueOf(this.vzb));
        arrayList.add(Long.valueOf(this.vzc));
        arrayList.add(Long.valueOf(this.oWT));
        arrayList.add(Long.valueOf(this.kqK));
        arrayList.add(Integer.valueOf(this.oWY));
        arrayList.add(Integer.valueOf(this.oWZ));
        arrayList.add(Integer.valueOf(this.netType));
        arrayList.add(Integer.valueOf(this.vzd));
        arrayList.add(Integer.valueOf(this.vze));
        arrayList.add(this.vzf);
        arrayList.add(this.deviceModel);
        arrayList.add(Integer.valueOf(this.vzg));
        arrayList.add(this.oXe);
        TalkRoom adg = c.cHG().adg(this.groupId);
        if (adg == null) {
            i = 0;
        } else {
            i = adg.vwY.size();
            c.d("TalkRoomManager", new Object[]{"getGroupMemberSize groupid: ", r3, " size: ", Integer.valueOf(i)});
        }
        arrayList.add(Integer.valueOf(i));
        arrayList.add(this.vzh.toString());
        arrayList.add(Integer.valueOf(this.oOK));
        arrayList.add(Integer.valueOf(this.oOD));
        arrayList.add(Integer.valueOf(this.oOz));
        arrayList.add(Integer.valueOf(this.oOA));
        String a = g.a(arrayList, ",", "_");
        c.d(TAG, new Object[]{"logBuf: ", this.vzh.toString()});
        c.d(TAG, new Object[]{"statresult", a});
        return a;
    }

    public static void a(String str, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            c.x(TAG, new Object[]{"uploadTempReport groupId is null"});
            return;
        }
        c.x(TAG, new Object[]{"uploadTempReport: ", str, Integer.valueOf(i), Long.valueOf(j)});
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.kpo = i;
        hVar.kpp = j;
        hVar.Q(strArr);
        ado(hVar.cHY());
    }

    public static void a(String str, String str2, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            c.x(TAG, new Object[]{"uploadTempReport groupId and clientGroupId is null"});
            return;
        }
        c.x(TAG, new Object[]{"uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i), Long.valueOf(j)});
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.kpo = i;
        hVar.kpp = j;
        if (str2 == null) {
            str2 = "";
        }
        hVar.vcI = str2;
        hVar.Q(strArr);
        ado(hVar.cHY());
        f.cEF();
    }

    public static void a(int i, long j, String... strArr) {
        h hVar = new h();
        hVar.groupId = "";
        hVar.kpo = i;
        hVar.kpp = j;
        hVar.vcI = "";
        hVar.Q(strArr);
        ado(hVar.cHY());
        f.cEF();
    }

    public final void Q(String... strArr) {
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            if (this.vzh.length() > 900) {
                this.vzh.setLength(0);
                this.vzh.append("overmaxsize");
            }
            if (this.vzh.length() != 0) {
                this.vzh.append("-");
            }
            int length = strArr.length;
            while (i < length) {
                this.vzh.append(strArr[i]);
                this.vzh.append("|");
                i++;
            }
        }
    }

    public final void cHZ() {
        this.vzi = System.currentTimeMillis();
        c.d(TAG, new Object[]{"beginCreateOrEnter", Long.valueOf(this.vzi)});
    }

    public final void cIa() {
        c.x(TAG, new Object[]{"beginCreateOrNotify"});
        this.vzj = System.currentTimeMillis();
    }

    public static void It(int i) {
        c.d(TAG, new Object[]{"sendNetSceneStat", Integer.valueOf(i)});
        f.u(527, 3, String.valueOf(i));
    }

    public static void Iu(int i) {
        c.d(TAG, new Object[]{"sendDeviceStat", Integer.valueOf(i)});
        f.u(528, 3, String.valueOf(i));
    }

    public static void Iv(int i) {
        c.d(TAG, new Object[]{"sendtalkRoomDialStat", Integer.valueOf(i)});
        f.u(530, 3, String.valueOf(i));
    }

    public static void cIb() {
        c.d(TAG, new Object[]{"sendTalkRoomOnDialStat", Integer.valueOf(-5001)});
        f.u(531, 3, "-5001");
    }

    public static void Iw(int i) {
        c.d(TAG, new Object[]{"sendEngineStat", Integer.valueOf(i)});
        f.u(529, 3, String.valueOf(i));
    }

    public static void ado(String str) {
        c.d(TAG, new Object[]{"sendSummaryNetScene", str});
        f.u(532, 3, str);
    }

    public static void adp(String str) {
        c.d(TAG, new Object[]{"sendEngineRecv", str});
        f.u(533, 3, str);
    }

    public static void adq(String str) {
        c.d(TAG, new Object[]{"sendEngineSend", str});
        f.u(534, 3, str);
    }

    public static void adr(String str) {
        c.d(TAG, new Object[]{"sendChannelStat", str});
        f.u(535, 3, str);
    }

    public final void Ix(int i) {
        c.d(TAG, new Object[]{"stopStatus", Integer.valueOf(i)});
        this.oWL = i;
    }
}
