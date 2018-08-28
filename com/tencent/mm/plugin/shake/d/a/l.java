package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.jsapi.ay;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l extends b {
    private static boolean bgH = false;
    private static boolean lkO = false;
    private boolean bGv = false;
    private Context context;
    private a mYR = new a();
    private long mYT;

    static /* synthetic */ void Lc(String str) {
        n nVar;
        String[] strArr = null;
        if (bi.oW(str)) {
            nVar = null;
        } else {
            n nVar2;
            Map z = bl.z(str, "tvinfo");
            if (z != null) {
                String str2 = (String) z.get(".tvinfo.username");
                if (bi.oW(str2)) {
                    nVar = null;
                } else {
                    n nVar3 = new n();
                    nVar3.field_username = str2;
                    nVar3.field_iconurl = bi.oV((String) z.get(".tvinfo.iconurl"));
                    nVar3.field_title = bi.oV((String) z.get(".tvinfo.title"));
                    nVar3.field_deeplink = bi.oV((String) z.get(".tvinfo.deeplinkjumpurl"));
                    nVar3.field_createtime = bi.getLong((String) z.get(".tvinfo.createtime"), 0);
                    nVar2 = nVar3;
                }
            } else {
                nVar2 = null;
            }
            nVar = nVar2;
        }
        if (nVar != null) {
            o buE = m.buE();
            Cursor a = buE.diF.a("shaketvhistory", null, "username=?", new String[]{nVar.field_username}, null, null, null, 2);
            if (a.moveToFirst()) {
                strArr = new n();
                strArr.d(a);
                a.close();
            } else {
                x.i("MicroMsg.ShakeTvHistoryStorage", "get null with username:" + r10);
                a.close();
            }
            if (strArr != null) {
                x.i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                buE = m.buE();
                if (bi.oW(nVar.field_username)) {
                    x.w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    return;
                }
                buE.diF.update("shaketvhistory", nVar.wH(), "username=?", new String[]{nVar.field_username});
                return;
            }
            x.i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            m.buE().b(nVar);
        }
    }

    static /* synthetic */ boolean b(l lVar, String str) {
        f Li = f.Li(str);
        List arrayList = new ArrayList();
        if (Li == null || Li.userName == null) {
            x.w("Micromsg.ShakeTVService", "parse user fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parse user: username=" + Li.userName + ", nickname=" + Li.bgn + ", showchat=" + Li.mYZ);
        d dVar = new d();
        dVar.field_username = Li.userName;
        dVar.field_nickname = Li.bgn;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = Li.mYZ;
        m.buC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(l lVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeTVService";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            lVar.e(arrayList, 2);
            return false;
        }
        a Lk = c.Lk(str);
        if (Lk == null) {
            x.e("Micromsg.ShakeTVService", "shakeTV resCallback xml error");
            bgH = false;
            lVar.e(arrayList, 4);
            return false;
        }
        d dVar = new d();
        dVar.field_username = bi.oV(Lk.field_subtitle);
        dVar.field_nickname = bi.oV(Lk.field_topic);
        dVar.field_distance = bi.oV(Lk.field_title);
        if (Lk.field_thumburl != null) {
            dVar.field_sns_bgurl = Lk.field_thumburl;
        }
        dVar.field_type = 8;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        dVar.field_reserved2 = (int) bi.VE();
        arrayList.add(dVar);
        d bus = m.buC().bus();
        if (bus.field_type == 8 && dVar.field_distance.equals(bus.field_distance) && dVar.field_nickname.equals(bus.field_nickname) && dVar.field_reserved2 - bus.field_reserved2 < 1800) {
            x.d("Micromsg.ShakeTVService", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + bus.field_reserved2);
            m.buC().vT(bus.field_shakeItemID);
        }
        m.buC().a(dVar, true);
        lVar.e(arrayList, 1);
        x.d("Micromsg.ShakeTVService", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(l lVar, String str) {
        List arrayList = new ArrayList();
        m.b Le = m.b.Le(str);
        if (Le == null || Le.mYX == null) {
            x.w("Micromsg.ShakeTVService", "parse pay fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + Le.mYX + ", title=" + Le.title + ", thumbUrl=" + Le.thumbUrl);
        d dVar = new d();
        dVar.field_username = Le.mYX;
        dVar.field_nickname = Le.title;
        dVar.field_sns_bgurl = Le.thumbUrl;
        dVar.field_distance = Le.lPj;
        dVar.field_type = 9;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.buC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean f(l lVar, String str) {
        List arrayList = new ArrayList();
        m.d Lg = m.d.Lg(str);
        if (Lg == null || bi.oW(Lg.mYY)) {
            x.w("Micromsg.ShakeTVService", "parse TempSession fail");
            lVar.e(arrayList, 4);
            return false;
        }
        d dVar = new d();
        dVar.field_username = Lg.mYY;
        dVar.field_nickname = Lg.title;
        dVar.field_distance = Lg.username;
        dVar.field_sns_bgurl = Lg.thumbUrl;
        dVar.field_type = 12;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.buC().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean g(l lVar, String str) {
        List arrayList = new ArrayList();
        m.a Ld = m.a.Ld(str);
        if (Ld != null) {
            d dVar = new d();
            dVar.field_username = Ld.username;
            dVar.field_nickname = Ld.title;
            dVar.field_reserved3 = Ld.path;
            dVar.field_sns_bgurl = Ld.thumbUrl;
            dVar.field_reserved2 = Ld.version;
            dVar.field_type = 13;
            dVar.field_insertBatch = 1;
            dVar.field_lvbuffer = str.getBytes();
            m.buC().a(dVar, true);
            arrayList.add(dVar);
            lVar.e(arrayList, 1);
            return true;
        }
        x.w("Micromsg.ShakeTVService", "parse appBrand fail");
        lVar.e(arrayList, 4);
        return false;
    }

    public l(Context context, com.tencent.mm.plugin.shake.b.l.a aVar) {
        super(aVar);
        this.context = context;
        bgH = false;
    }

    public final void start() {
        x.v("Micromsg.ShakeTVService", "hy: start shake tv!");
        if (this.mWQ == null) {
            x.w("Micromsg.ShakeTVService", "shakeGetListener == null");
        } else if (this.context instanceof Activity) {
            bgH = true;
            this.mYT = System.currentTimeMillis();
            this.mYR.a(ay.CTRL_INDEX, new 1(this));
            h.mEJ.e(835, 5, 1);
        } else {
            x.e("Micromsg.ShakeTVService", "context not an Activity");
            this.mWQ.d(new ArrayList(), 0);
        }
    }

    public final void init() {
        if (!lkO) {
            if (this.mYR.bvc()) {
                lkO = true;
            } else {
                x.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void bup() {
        super.bup();
        this.mYR.we();
        if (bgH) {
            long currentTimeMillis = System.currentTimeMillis() - this.mYT;
            x.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(bgH)});
            h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int) currentTimeMillis)});
            h.mEJ.e(835, 1, 1);
            bgH = false;
        }
    }

    public final void resume() {
    }

    private void e(List<d> list, long j) {
        if (this.mWQ != null) {
            this.mWQ.d(list, j);
        }
    }
}
