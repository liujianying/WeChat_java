package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class j extends b {
    public static boolean lkO = false;
    public static j mYS;
    private boolean bGv = false;
    public a mYR = new a();
    private long mYT;

    static /* synthetic */ boolean b(j jVar, String str) {
        f Li = f.Li(str);
        List arrayList = new ArrayList();
        if (Li == null || Li.userName == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse user fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parse user: username=" + Li.userName + ", nickname=" + Li.bgn + ", showchat=" + Li.mYZ);
        d dVar = new d();
        dVar.field_username = Li.userName;
        dVar.field_nickname = Li.bgn;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = Li.mYZ;
        m.buC().a(dVar, true);
        arrayList.add(dVar);
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(j jVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeMusicMgr";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            jVar.e(arrayList, 2);
            return false;
        }
        a Lk = c.Lk(str);
        if (Lk == null) {
            x.e("Micromsg.ShakeMusicMgr", "shakeTV resCallback xml error");
            jVar.e(arrayList, 4);
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
            x.d("Micromsg.ShakeMusicMgr", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + bus.field_reserved2);
            m.buC().vT(bus.field_shakeItemID);
        }
        m.buC().a(dVar, true);
        jVar.e(arrayList, 1);
        x.d("Micromsg.ShakeMusicMgr", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(j jVar, String str) {
        List arrayList = new ArrayList();
        m.b Le = m.b.Le(str);
        if (Le == null || Le.mYX == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse pay fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + Le.mYX + ", title=" + Le.title + ", thumbUrl=" + Le.thumbUrl);
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
        jVar.e(arrayList, 1);
        return true;
    }

    public static j a(l.a aVar) {
        if (mYS == null || mYS.mWQ == null) {
            mYS = new j(aVar);
        }
        return mYS;
    }

    private j(l.a aVar) {
        super(aVar);
    }

    public final void start() {
        if (this.mWQ == null) {
            x.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            return;
        }
        this.mYT = System.currentTimeMillis();
        this.mYR.a(367, new 1(this));
    }

    public final void init() {
        if (!lkO) {
            if (this.mYR.bvc()) {
                lkO = true;
            } else {
                x.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void bup() {
        this.mYR.we();
        super.bup();
    }

    public final void resume() {
    }

    private void e(List<d> list, long j) {
        if (this.mWQ != null) {
            this.mWQ.d(list, j);
        }
    }
}
