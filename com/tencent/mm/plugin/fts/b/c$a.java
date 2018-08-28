package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.b.c.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class c$a extends a {
    private long fsF;
    private int iXv;
    private int iXw;
    private ArrayList<Long> juA;
    private int juB;
    final /* synthetic */ c jux;
    private HashSet<Pair<Long, Long>> juz;
    private int mFailedCount;

    private c$a(c cVar) {
        this.jux = cVar;
        this.juz = null;
        this.juA = null;
        this.fsF = Long.MAX_VALUE;
        this.juB = 0;
        this.iXv = 0;
        this.iXw = 0;
        this.mFailedCount = 0;
    }

    /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }

    public final boolean execute() {
        long j;
        this.fsF = this.jux.jup.jpT.s(-200, Long.MAX_VALUE);
        x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: " + this.fsF);
        if (this.juz == null) {
            this.juz = new HashSet();
            this.juA = new ArrayList();
            Cursor a = this.jux.jup.a(c.jqc, true, true, false, true, true);
            while (a.moveToNext()) {
                j = a.getLong(0);
                long j2 = a.getLong(1);
                long j3 = a.getLong(2);
                if (a.getInt(3) == -1) {
                    this.juA.add(Long.valueOf(j));
                } else if (j3 <= this.fsF) {
                    this.juz.add(new Pair(Long.valueOf(j2), Long.valueOf(j3)));
                }
            }
            a.close();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int i;
        int size;
        int i2 = Integer.MAX_VALUE;
        String[] strArr = new String[2];
        List<f> arrayList = new ArrayList();
        while (i2 >= 50) {
            i = 0;
            strArr[0] = Long.toString(this.fsF);
            strArr[1] = Integer.toString(this.juB);
            Cursor rawQuery = this.jux.iXo.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", strArr);
            while (true) {
                i2 = i;
                if (!rawQuery.moveToNext()) {
                    break;
                }
                f fVar = new f(this.jux, (byte) 0);
                fVar.bJC = rawQuery.getLong(0);
                fVar.talker = rawQuery.getString(1);
                fVar.createTime = rawQuery.getLong(2);
                fVar.content = rawQuery.getString(3);
                fVar.msgType = rawQuery.getInt(4);
                fVar.juF = rawQuery.getInt(5);
                fVar.juE = 41;
                if (c.a(fVar)) {
                    fVar.aQp();
                    if (fVar.isAvailable()) {
                        arrayList.add(fVar);
                    }
                }
                i = i2 + 1;
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            size = arrayList.size();
            if (size == 0) {
                x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", new Object[]{Integer.valueOf(size)});
            } else {
                x.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d FROM %d to %d", new Object[]{Integer.valueOf(size), Long.valueOf(((f) arrayList.get(0)).bJC), Long.valueOf(((f) arrayList.get(size - 1)).bJC)});
            }
            if (size > 0) {
                this.jux.jup.beginTransaction();
                for (f fVar2 : arrayList) {
                    j = fVar2.bJC;
                    long j4 = fVar2.createTime;
                    if (j4 == this.fsF) {
                        this.juB++;
                    } else {
                        this.fsF = j4;
                        this.juB = 0;
                    }
                    if (!this.juz.remove(new Pair(Long.valueOf(j), Long.valueOf(j4)))) {
                        try {
                            this.jux.jup.a(fVar2.juE, j, fVar2.talker, j4, fVar2.juG, fVar2.juH);
                            this.iXv++;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", e, "Build message index failed with exception. \n%s", new Object[]{fVar2.juG});
                            this.mFailedCount++;
                        }
                    }
                }
                this.jux.jup.commit();
                this.jux.jup.t(-200, this.fsF);
            }
            arrayList.clear();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
        i = 50;
        Iterator it = this.juz.iterator();
        while (it.hasNext()) {
            if (Thread.interrupted()) {
                this.jux.jup.commit();
                throw new InterruptedException();
            }
            if (i >= 50) {
                this.jux.jup.commit();
                this.jux.jup.beginTransaction();
                i = 0;
            }
            int i3 = i;
            Pair pair = (Pair) it.next();
            this.jux.jup.a(c.jqc, ((Long) pair.first).longValue(), ((Long) pair.second).longValue());
            i = i3 + 1;
            this.iXw++;
            it.remove();
        }
        this.jux.jup.commit();
        i = 50;
        ListIterator listIterator = this.juA.listIterator(this.juA.size());
        while (listIterator.hasPrevious()) {
            if (Thread.interrupted()) {
                this.jux.jup.commit();
                throw new InterruptedException();
            }
            if (i >= 50) {
                this.jux.jup.commit();
                this.jux.jup.beginTransaction();
                i = 0;
            }
            size = i;
            this.jux.jup.g(Long.valueOf(((Long) listIterator.previous()).longValue()));
            i = size + 1;
            this.iXw++;
            listIterator.remove();
        }
        this.jux.jup.t(-200, this.fsF - 1);
        this.jux.jup.commit();
        this.jux.juq = false;
        return true;
    }

    public final String afC() {
        return String.format("{new: %d removed: %d failed: %d}", new Object[]{Integer.valueOf(this.iXv), Integer.valueOf(this.iXw), Integer.valueOf(this.mFailedCount)});
    }

    public final int getId() {
        return 4;
    }

    public final String getName() {
        return "BuildMessageIndexTask";
    }
}
