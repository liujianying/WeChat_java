package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.a;
import com.tencent.mm.model.au;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acu;
import com.tencent.mm.protocal.c.acv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class k extends l implements com.tencent.mm.network.k {
    private static Map<String, Long> efl = new HashMap();
    private static Map<String, String> efm;
    private boolean bQq = false;
    private e diJ;
    private final b efk;
    private c<a> efn;

    static /* synthetic */ void ax(String str, String str2) {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("disaster_pref", 4);
        String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (!bi.oW(string)) {
            string = string + ";";
        }
        string = string + str + "," + bi.VE();
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.putString("disaster_new_noticeid_list_key", string);
        edit.commit();
        efm.put(str, str2);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", new Object[]{sharedPreferences.getString("disaster_new_noticeid_list_key", ""), str, sharedPreferences.getString(str, "")});
    }

    public k(int i, boolean z) {
        b.a aVar = new b.a();
        aVar.dIG = new acu();
        aVar.dIH = new acv();
        aVar.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
        aVar.dIF = 775;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.efk = aVar.KT();
        this.efk.cdn = 1;
        ((acu) this.efk.dID.dIL).bQp = i;
        this.bQq = z;
        QU();
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.bQq), bi.cjd()});
    }

    public final int getType() {
        return 775;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        acu acu = (acu) this.efk.dID.dIL;
        long a = bi.a((Long) efl.get(acu.bQp), 0);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[]{Integer.valueOf(acu.bQp), Long.valueOf(a), efl});
        if (a == 0 || bi.bI(a) >= 1800000) {
            String aG = bi.aG((String) efm.get(acu.bQp), "");
            if (bi.oW(aG)) {
                this.diJ = eVar2;
                return a(eVar, this.efk, this);
            }
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[]{Integer.valueOf(acu.bQp), aG});
            J(aG, false);
            return -1;
        }
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[]{Integer.valueOf(acu.bQp)});
        return -1;
    }

    private void J(String str, boolean z) {
        au.Em().H(new 1(this, str, z));
    }

    private synchronized void QU() {
        if (efm == null) {
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
            efm = new HashMap();
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("disaster_pref", 4);
            String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
            if (!bi.oW(string)) {
                String[] split = string.split(";");
                if (split != null && split.length > 0) {
                    string = "";
                    Editor edit = sharedPreferences.edit();
                    for (String split2 : split) {
                        String[] split3 = split2.split(",");
                        try {
                            if (bi.getLong(split3[0], 0) > 0) {
                                if (bi.bG(bi.getLong(split3[1], 0)) < 86400) {
                                    String string2 = sharedPreferences.getString(split3[0], "");
                                    if (!bi.oW(string2)) {
                                        string = string + split3[0] + "," + split3[1] + ";";
                                        efm.put(split3[0], string2);
                                    }
                                } else {
                                    edit.remove(split3[0]).commit();
                                }
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[]{e.getMessage()});
                        }
                    }
                    edit.putString("disaster_new_noticeid_list_key", string).commit();
                    x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[]{string, efl});
                }
            }
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[]{efm});
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            J(((acv) this.efk.dIE.dIL).content, true);
        }
        this.diJ.a(i2, i3, str, this);
    }
}
