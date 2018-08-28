package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.b;
import com.tencent.mm.sdk.platformtools.av.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import junit.framework.Assert;

public final class m extends j implements c<Integer, k> {
    public static final String[] diD = new String[]{"CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) "};
    private static final String[] ekB = new String[]{"realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut"};
    public h dCZ;
    private long ekA;
    private long eky;
    public av<Integer, k> ekz = new av(this, g.Em().lnJ.getLooper(), 30, 2, 300000, 1000);

    public m(h hVar) {
        int i = 0;
        this.dCZ = hVar;
        HashSet hashSet = new HashSet();
        for (Object add : ekB) {
            hashSet.add(add);
        }
        Cursor b = this.dCZ.b("PRAGMA table_info(netstat);", null, 2);
        int columnIndex = b.getColumnIndex("name");
        while (b.moveToNext()) {
            hashSet.remove(b.getString(columnIndex));
        }
        b.close();
        String[] strArr = ekB;
        columnIndex = strArr.length;
        while (i < columnIndex) {
            String str = strArr[i];
            if (hashSet.contains(str)) {
                this.dCZ.fV("netstat", "ALTER TABLE netstat ADD COLUMN " + str + " INT;");
            }
            i++;
        }
        this.ekA = System.currentTimeMillis();
    }

    public final k it(int i) {
        k kVar = (k) this.ekz.get(Integer.valueOf(i));
        if (kVar == null) {
            Cursor a = this.dCZ.a("netstat", null, "peroid = " + i, null, null, null, null, 2);
            if (a.moveToFirst()) {
                kVar = new k();
                kVar.d(a);
            }
            a.close();
            if (kVar != null) {
                this.ekz.s(Integer.valueOf(i), kVar);
                return kVar;
            }
            av avVar = this.ekz;
            Integer valueOf = Integer.valueOf(i);
            k kVar2 = new k();
            kVar2.bWA = 0;
            kVar2.id = 0;
            kVar2.ejM = 0;
            kVar2.ejN = 0;
            kVar2.ejO = 0;
            kVar2.ejP = 0;
            kVar2.ejQ = 0;
            kVar2.ejR = 0;
            kVar2.ejS = 0;
            kVar2.ejT = 0;
            kVar2.ejU = 0;
            kVar2.ejV = 0;
            kVar2.ejW = 0;
            kVar2.ejX = 0;
            kVar2.ejY = 0;
            kVar2.ejZ = 0;
            kVar2.eka = 0;
            kVar2.ekb = 0;
            kVar2.ekc = 0;
            kVar2.ekd = 0;
            kVar2.eke = 0;
            kVar2.ekf = 0;
            kVar2.ekg = 0;
            kVar2.ekh = 0;
            kVar2.eki = 0;
            kVar2.ekj = 0;
            kVar2.ekk = 0;
            kVar2.ekl = 0;
            kVar2.ekm = 0;
            kVar2.ekn = 0;
            kVar2.eko = 0;
            avVar.s(valueOf, kVar2);
            return kVar;
        } else if (kVar.ejM != i) {
            return null;
        } else {
            return kVar;
        }
    }

    public final void a(k kVar) {
        Assert.assertNotNull(kVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (kVar.ejM <= 0) {
            kVar.ejM = (int) (currentTimeMillis / 86400000);
        }
        if (kVar.ejM > 0) {
            k it = it(kVar.ejM);
            if (it == null || kVar.ejM != it.ejM) {
                kVar.bWA |= 2;
                kVar.id = -1;
                if (it != null) {
                    x.i("MicroMsg.NetStat", it.toString());
                } else {
                    x.i("MicroMsg.NetStat", "NetStat started.");
                }
            } else {
                kVar.bWA = it.bWA | 1;
                kVar.ejN += it.ejO;
                kVar.ejO += it.ejO;
                kVar.ejP += it.ejQ;
                kVar.ejQ += it.ejQ;
                kVar.ejR += it.ejR;
                kVar.ejS += it.ejS;
                kVar.ejT += it.ejT;
                kVar.ejU += it.ejU;
                kVar.ejV += it.ejV;
                kVar.ejW += it.ejW;
                kVar.ejX += it.ejX;
                kVar.ejY += it.ejY;
                kVar.ejZ += it.eka;
                kVar.eka += it.eka;
                kVar.ekb += it.ekc;
                kVar.ekc += it.ekc;
                kVar.ekd += it.ekd;
                kVar.eke += it.eke;
                kVar.ekf += it.ekf;
                kVar.ekg += it.ekg;
                kVar.ekh += it.ekh;
                kVar.eki += it.eki;
                kVar.ekj += it.ekj;
                kVar.ekk += it.ekk;
                kVar.ekl += it.ekl;
                kVar.ekm += it.ekm;
                kVar.ekn += it.ekn;
                kVar.eko += it.eko;
                if (kVar.ejV <= 4096 && kVar.ejW <= 4096 && kVar.ekh <= 4096) {
                    int i = kVar.eki;
                }
                kVar.id = it.id;
                if (currentTimeMillis - this.ekA > 300000) {
                    x.i("MicroMsg.NetStat", kVar.toString());
                }
                b(kVar);
            }
            this.ekA = currentTimeMillis;
            b(kVar);
        }
    }

    public final boolean b(k kVar) {
        Assert.assertNotNull(kVar);
        Assert.assertTrue(kVar.ejM > 0);
        return this.ekz.s(Integer.valueOf(kVar.ejM), kVar);
    }

    public final long Sb() {
        this.ekz.li(true);
        int ciY = (int) (bi.ciY() / 86400000);
        Cursor b = this.dCZ.b("SELECT peroid FROM netstat  WHERE peroid > " + ((int) ((bi.VF() - 1296000000) / 86400000)) + " order by peroid limit 1", null, 2);
        if (b.moveToFirst()) {
            ciY = b.getInt(b.getColumnIndex("peroid"));
        }
        b.close();
        return ((long) ciY) * 86400000;
    }

    public final k iu(int i) {
        k kVar = null;
        this.ekz.li(true);
        Cursor b = this.dCZ.b("SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= " + i, null, 2);
        if (b.moveToFirst()) {
            kVar = new k();
            kVar.d(b);
        }
        b.close();
        return kVar;
    }

    public final boolean Sc() {
        if (this.dCZ.inTransaction()) {
            x.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
            return false;
        }
        this.eky = this.dCZ.dO(Thread.currentThread().getId());
        if (this.eky > 0) {
            return true;
        }
        x.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.eky + " return false");
        return false;
    }

    public final void a(av<Integer, k> avVar, b<Integer, k> bVar) {
        int i = bVar.sIz;
        k kVar = (k) bVar.values;
        if (kVar != null && i == 1) {
            i = kVar.ejM;
            int i2 = kVar.id;
            if (i > 0) {
                ContentValues contentValues = new ContentValues();
                if ((kVar.bWA & 2) != 0) {
                    contentValues.put("peroid", Integer.valueOf(kVar.ejM));
                }
                if ((kVar.bWA & 4) != 0) {
                    contentValues.put("textCountIn", Integer.valueOf(kVar.ejN));
                }
                if ((kVar.bWA & 8) != 0) {
                    contentValues.put("textBytesIn", Integer.valueOf(kVar.ejO));
                }
                if ((kVar.bWA & 16) != 0) {
                    contentValues.put("imageCountIn", Integer.valueOf(kVar.ejP));
                }
                if ((kVar.bWA & 32) != 0) {
                    contentValues.put("imageBytesIn", Integer.valueOf(kVar.ejQ));
                }
                if ((kVar.bWA & 64) != 0) {
                    contentValues.put("voiceCountIn", Integer.valueOf(kVar.ejR));
                }
                if ((kVar.bWA & 128) != 0) {
                    contentValues.put("voiceBytesIn", Integer.valueOf(kVar.ejS));
                }
                if ((kVar.bWA & ab.CTRL_BYTE) != 0) {
                    contentValues.put("videoCountIn", Integer.valueOf(kVar.ejT));
                }
                if ((kVar.bWA & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                    contentValues.put("videoBytesIn", Integer.valueOf(kVar.ejU));
                }
                if ((kVar.bWA & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    contentValues.put("mobileBytesIn", Integer.valueOf(kVar.ejV));
                }
                if ((kVar.bWA & 2048) != 0) {
                    contentValues.put("wifiBytesIn", Integer.valueOf(kVar.ejW));
                }
                if ((kVar.bWA & 4096) != 0) {
                    contentValues.put("sysMobileBytesIn", Integer.valueOf(kVar.ejX));
                }
                if ((kVar.bWA & 8192) != 0) {
                    contentValues.put("sysWifiBytesIn", Integer.valueOf(kVar.ejY));
                }
                if ((kVar.bWA & 16384) != 0) {
                    contentValues.put("textCountOut", Integer.valueOf(kVar.ejZ));
                }
                if ((kVar.bWA & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                    contentValues.put("textBytesOut", Integer.valueOf(kVar.eka));
                }
                if ((kVar.bWA & 65536) != 0) {
                    contentValues.put("imageCountOut", Integer.valueOf(kVar.ekb));
                }
                if ((kVar.bWA & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                    contentValues.put("imageBytesOut", Integer.valueOf(kVar.ekc));
                }
                if ((kVar.bWA & 262144) != 0) {
                    contentValues.put("voiceCountOut", Integer.valueOf(kVar.ekd));
                }
                if ((kVar.bWA & 524288) != 0) {
                    contentValues.put("voiceBytesOut", Integer.valueOf(kVar.eke));
                }
                if ((kVar.bWA & 1048576) != 0) {
                    contentValues.put("videoCountOut", Integer.valueOf(kVar.ekf));
                }
                if ((kVar.bWA & 2097152) != 0) {
                    contentValues.put("videoBytesOut", Integer.valueOf(kVar.ekg));
                }
                if ((kVar.bWA & 4194304) != 0) {
                    contentValues.put("mobileBytesOut", Integer.valueOf(kVar.ekh));
                }
                if ((kVar.bWA & 8388608) != 0) {
                    contentValues.put("wifiBytesOut", Integer.valueOf(kVar.eki));
                }
                if ((kVar.bWA & 16777216) != 0) {
                    contentValues.put("sysMobileBytesOut", Integer.valueOf(kVar.ekj));
                }
                if ((kVar.bWA & 33554432) != 0) {
                    contentValues.put("sysWifiBytesOut", Integer.valueOf(kVar.ekk));
                }
                if ((kVar.bWA & 67108864) != 0) {
                    contentValues.put("realMobileBytesIn", Integer.valueOf(kVar.ekl));
                }
                if ((kVar.bWA & 134217728) != 0) {
                    contentValues.put("realWifiBytesIn", Integer.valueOf(kVar.ekm));
                }
                if ((kVar.bWA & 268435456) != 0) {
                    contentValues.put("realMobileBytesOut", Integer.valueOf(kVar.ekn));
                }
                if ((kVar.bWA & 536870912) != 0) {
                    contentValues.put("realWifiBytesOut", Integer.valueOf(kVar.eko));
                }
                if (i2 < 0) {
                    kVar.id = (int) this.dCZ.insert("netstat", "id", contentValues);
                } else {
                    this.dCZ.update("netstat", contentValues, "peroid=" + i, null);
                }
            }
        }
    }

    public final void Sd() {
        if (this.eky > 0) {
            this.dCZ.gp(this.eky);
        }
    }
}
