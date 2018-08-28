package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class an$a implements e {
    private static int bFl = 0;
    Queue<Long> bFd = new LinkedList();
    Queue<Long> bFe = new LinkedList();
    Map<Long, a> bFf = new HashMap();
    private boolean bFg = false;
    private boolean bFh = false;
    private boolean bFi = false;
    int bFj = 0;
    private long bFk = 0;
    a bFn = new a();
    private al bFo = new al(au.Em().lnJ.getLooper(), new 4(this), false);
    private HashMap<Long, String> qAH = new HashMap();

    static /* synthetic */ void i(an$a an_a) {
        x.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", new Object[]{Boolean.valueOf(an_a.bFg), Integer.valueOf(an_a.bFe.size()), Boolean.valueOf(an_a.bFh), Integer.valueOf(an_a.bFd.size())});
        an_a.bFk = System.currentTimeMillis();
        if ((!an_a.bFg && an_a.bFe.size() == 0) || (!an_a.bFh && an_a.bFd.size() == 0)) {
            an_a.cbV();
        }
        if (!an_a.bFg && an_a.bFe.size() == 0 && !an_a.bFh && an_a.bFd.size() == 0) {
            an_a.wx();
            x.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
        } else if (!an_a.bFh && an_a.bFd.size() > 0) {
            long a = bi.a((Long) an_a.bFd.poll(), -1);
            x.i("MicroMsg.SceneAppMsg", "summerbig Start Send :" + a);
            if (a != -1) {
                an_a.bFf.put(Long.valueOf(a), new a());
                an_a.bFh = true;
                b bVar = new b();
                bd dW;
                if (ao.asF().b(a, bVar)) {
                    String str;
                    if (bVar.field_type == 8) {
                        au.HU();
                        dW = c.FT().dW(bVar.field_msgInfoId);
                        if (dW.field_msgId == 0) {
                            x.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + bVar.field_msgInfoId);
                            str = null;
                        } else {
                            g.a gp = g.a.gp(dW.field_content);
                            str = gp != null ? gp.dwq : an.YJ(dW.field_content).bKg;
                        }
                        if (str == null) {
                            x.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                            au.HU();
                            dW = c.FT().dW(bVar.field_msgInfoId);
                            dW.setStatus(5);
                            au.HU();
                            c.FT().a(dW.field_msgId, dW);
                            an_a.bFh = false;
                            return;
                        }
                    }
                    str = null;
                    String str2 = (String) an_a.qAH.get(Long.valueOf(bVar.field_msgInfoId));
                    if (bVar.field_totalLen > 26214400) {
                        au.HU();
                        bd dW2 = c.FT().dW(bVar.field_msgInfoId);
                        au.DF().a(new aa(null, bVar.field_fileFullPath, dW2.field_talker, new 1(an_a, bVar, dW2, a, str2)), 0);
                        return;
                    }
                    au.DF().a(new al(a, str, str2), 0);
                    return;
                }
                x.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = " + a);
                au.HU();
                dW = c.FT().dW(bVar.field_msgInfoId);
                dW.setStatus(5);
                au.HU();
                c.FT().a(dW.field_msgId, dW);
                an_a.bFh = false;
            }
        }
    }

    static /* synthetic */ int wy() {
        int i = bFl;
        bFl = i + 1;
        return i;
    }

    static /* synthetic */ int wz() {
        int i = bFl;
        bFl = i - 1;
        return i;
    }

    public an$a() {
        au.DF().a(220, this);
        au.DF().a(221, this);
        au.DF().a(222, this);
    }

    protected final void finalize() {
        au.DF().b(220, this);
        au.DF().b(221, this);
        au.DF().b(222, this);
        this.qAH.clear();
        super.finalize();
    }

    public final void u(long j, String str) {
        this.qAH.put(Long.valueOf(j), str);
    }

    public static void fM(long j) {
        au.DF().a(new ai(j, null, null), 0);
    }

    public static void v(long j, String str) {
        au.DF().a(new ai(j, str, null), 0);
    }

    public static void d(long j, String str, String str2) {
        au.DF().a(new ai(j, str, str2), 0);
    }

    private boolean cbV() {
        List list;
        try {
            Cursor rawQuery = ao.asF().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
            if (rawQuery == null) {
                list = null;
            } else {
                int count = rawQuery.getCount();
                x.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:" + count);
                if (count == 0) {
                    rawQuery.close();
                    list = null;
                } else {
                    list = new ArrayList();
                    for (int i = 0; i < count; i++) {
                        rawQuery.moveToPosition(i);
                        b bVar = new b();
                        bVar.d(rawQuery);
                        list.add(bVar);
                    }
                    rawQuery.close();
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SceneAppMsg", e, "", new Object[0]);
            c asF = ao.asF();
            asF.diF.fV("appattach", " update appattach set status = 198 , lastModifyTime = " + bi.VE() + " where status = 101");
            asF.doNotify();
            list = null;
        }
        if (list == null || list.size() == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String gb = bi.gb(currentTimeMillis);
        for (b bVar2 : list) {
            if (this.bFf.containsKey(Long.valueOf(bVar2.sKx))) {
                x.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + bVar2.sKx);
            } else {
                x.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + bVar2.field_fileFullPath + " status:" + bVar2.field_status + " create:(" + bi.gb(bVar2.field_createTime) + "," + bi.gb(bVar2.field_createTime / 1000) + ", last:" + bi.gb(bVar2.field_lastModifyTime) + " now:" + bi.gb(currentTimeMillis) + " " + (currentTimeMillis - bVar2.field_lastModifyTime));
                if (bVar2.field_isUpload) {
                    if (currentTimeMillis - bVar2.field_lastModifyTime <= 600 || bVar2.field_status != 101) {
                        this.bFd.offer(Long.valueOf(bVar2.sKx));
                        this.bFf.put(Long.valueOf(bVar2.sKx), null);
                    } else {
                        x.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + bVar2.field_fileFullPath + " last:" + bi.gb(bVar2.field_lastModifyTime) + " now:" + gb);
                        l.fK(bVar2.sKx);
                    }
                }
            }
        }
        x.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.bFf.size() + " [recv:" + this.bFe.size() + ",send:" + this.bFd.size() + "]");
        if (this.bFe.size() + this.bFd.size() == 0) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        au.Em().H(new 2(this, lVar, i, i2));
    }

    private void wx() {
        this.bFf.clear();
        this.bFd.clear();
        this.bFe.clear();
        this.bFh = false;
        this.bFg = false;
        this.bFi = false;
        x.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.bFn.Ad());
    }

    public final void run() {
        au.Em().H(new 3(this));
    }
}
