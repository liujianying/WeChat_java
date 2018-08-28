package com.tencent.mm.plugin.fts;

import android.os.Process;
import android.util.Log;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.n;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import java.util.concurrent.PriorityBlockingQueue;

public final class g implements m {
    a jpf = new a();

    private class a extends Thread {
        int jpg = Integer.MAX_VALUE;
        PriorityBlockingQueue<com.tencent.mm.plugin.fts.a.a.a> jph = new PriorityBlockingQueue();
        volatile boolean jpi = false;
        com.tencent.mm.plugin.fts.a.a.a jpj;
        private boolean jpk;
        Runnable jpl;
        e jpm;
        boolean jpn = false;
        private int mTid = 0;

        public a() {
            super("SearchDaemon");
        }

        final synchronized void qc(int i) {
            if (this.jpg != i && isAlive()) {
                if (i < 0) {
                    if (this.jpg >= 0) {
                        Process.setThreadPriority(this.mTid, -8);
                        this.jpg = i;
                    }
                }
                if (i >= 0) {
                    if (this.jpg < 0) {
                        Process.setThreadPriority(this.mTid, this.jpk ? 10 : 0);
                    }
                }
                this.jpg = i;
            }
        }

        public final synchronized void quit() {
            this.jpi = true;
            interrupt();
        }

        public final synchronized void ff(boolean z) {
            int i = 0;
            synchronized (this) {
                if (this.jpk != z) {
                    this.jpk = z;
                    if (this.jpg >= 0 && isAlive() && this.mTid != 0) {
                        if (this.jpk) {
                            i = 10;
                        }
                        try {
                            Process.setThreadPriority(this.mTid, i);
                            x.i("MicroMsg.FTS.FTSTaskDaemon", "*** Switch priority: " + (this.jpk ? "foreground" : "background"));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "setLowPriorityMode failed, tid=%d, p=%d", new Object[]{Integer.valueOf(this.mTid), Integer.valueOf(i)});
                        }
                    }
                }
            }
            return;
        }

        public final void run() {
            Throwable e;
            com.tencent.mm.plugin.fts.a.a.a aVar;
            this.mTid = Process.myTid();
            while (true) {
                String name;
                try {
                    Thread.interrupted();
                    if (this.jpi) {
                        a.aPK();
                        this.jpj = null;
                        this.mTid = 0;
                        return;
                    }
                    this.jpj = null;
                    com.tencent.mm.plugin.fts.a.a.a aVar2 = (com.tencent.mm.plugin.fts.a.a.a) this.jph.take();
                    if (aVar2 == null) {
                        a.aPK();
                        this.jpj = null;
                    } else {
                        try {
                            this.jpj = aVar2;
                            qc(aVar2.getPriority());
                            name = aVar2.getName();
                            try {
                                String obj;
                                if (bi.oW(name)) {
                                    obj = aVar2.toString();
                                } else {
                                    obj = name;
                                }
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    try {
                                        String format;
                                        int size;
                                        String str;
                                        aVar2.execute();
                                        aVar2.jrn = (System.currentTimeMillis() - currentTimeMillis) + aVar2.jrn;
                                        e.u(aVar2.getId(), aVar2.jrn);
                                        e.v(aVar2.getId(), aVar2.jrn);
                                        if (((aVar2.jro & 1) > 0 ? 1 : 0) != 0 && aVar2.jrn > 1000 && aVar2.jrn < 3600000) {
                                            e.u(27, aVar2.jrn);
                                            e.v(27, aVar2.jrn);
                                        }
                                        if (aVar2 instanceof h) {
                                            format = String.format("[%s][Request=%s][Result=%s] Done, %dms", new Object[]{obj, ((h) aVar2).jsj.toString(), ((h) aVar2).jsk.toString(), Long.valueOf(aVar2.jrn)});
                                            size = r3.jsk.jsx.size();
                                        } else {
                                            format = String.format("[%s] Done, %dms", new Object[]{obj, Long.valueOf(aVar2.jrn)});
                                            size = 0;
                                        }
                                        e.g(aVar2.getId(), aVar2.jrn, (long) size);
                                        if (aVar2.jrp == null || aVar2.jrp.size() <= 1) {
                                            str = "";
                                        } else {
                                            StringBuffer stringBuffer = new StringBuffer();
                                            for (int i = 1; i < aVar2.jrp.size(); i++) {
                                                com.tencent.mm.plugin.fts.a.a.a.a aVar3 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.jrp.get(i - 1);
                                                com.tencent.mm.plugin.fts.a.a.a.a aVar4 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.jrp.get(i);
                                                stringBuffer.append("{");
                                                stringBuffer.append(aVar4.jrr);
                                                stringBuffer.append(":");
                                                stringBuffer.append(aVar4.timestamp - aVar3.timestamp);
                                                stringBuffer.append("}");
                                            }
                                            str = String.format("%s", new Object[]{stringBuffer.toString()});
                                        }
                                        if (bi.oW(str)) {
                                            str = format;
                                        } else {
                                            str = format + " " + str;
                                        }
                                        name = aVar2.afC();
                                        if (!bi.oW(name)) {
                                            str = str + " " + name;
                                        }
                                        x.i("MicroMsg.FTS.FTSTaskDaemon", str);
                                        a.aPK();
                                        this.jpj = null;
                                    } catch (Exception e2) {
                                        throw e2;
                                    } catch (Throwable th) {
                                        aVar2.jrn = (System.currentTimeMillis() - currentTimeMillis) + aVar2.jrn;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    name = obj;
                                    aVar = aVar2;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                aVar = aVar2;
                                if (aVar != null) {
                                    a.aPK();
                                    this.jpj = null;
                                } else {
                                    try {
                                        if (e instanceof InterruptedException) {
                                            if (!aVar.isCancelled()) {
                                                this.jph.put(aVar);
                                            }
                                            x.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", new Object[]{name, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.jrn)});
                                        } else if (e instanceof SQLiteDatabaseCorruptException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception. \n", new Object[]{name});
                                            if (this.jpm != null) {
                                                this.jpm.aPT();
                                            }
                                            e.qd(18);
                                            if (!this.jpn) {
                                                com.tencent.mm.plugin.report.service.h.mEJ.c("FTS", aVar + ": " + Log.getStackTraceString(e), null);
                                                this.jpn = true;
                                            }
                                        } else if (e instanceof n) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                            e.qd(6);
                                        } else if (e instanceof SQLiteDiskIOException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                            e.qd(7);
                                        } else if (e instanceof NullPointerException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                            e.qd(3);
                                            if (this.jpl != null) {
                                                this.jpl.run();
                                            }
                                        } else if (e instanceof SQLiteException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                            if (e.getMessage() == null || !e.getMessage().contains("the connection is read-only")) {
                                                e.qd(4);
                                            } else {
                                                e.qd(17);
                                            }
                                            if (this.jpl != null) {
                                                this.jpl.run();
                                            }
                                        } else {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                            e.qd(5);
                                            if (this.jpl != null) {
                                                this.jpl.run();
                                            }
                                        }
                                        a.aPK();
                                        this.jpj = null;
                                    } catch (Throwable th2) {
                                        a.aPK();
                                        this.jpj = null;
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            name = null;
                            aVar = aVar2;
                        }
                    }
                } catch (Throwable e6) {
                    e = e6;
                    name = null;
                    aVar = null;
                    if (aVar != null) {
                        try {
                            if (e instanceof InterruptedException) {
                                if (!aVar.isCancelled()) {
                                    this.jph.put(aVar);
                                }
                                x.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", new Object[]{name, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.jrn)});
                            } else if (e instanceof SQLiteDatabaseCorruptException) {
                                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception. \n", new Object[]{name});
                                if (this.jpm != null) {
                                    this.jpm.aPT();
                                }
                                e.qd(18);
                                if (!this.jpn) {
                                    com.tencent.mm.plugin.report.service.h.mEJ.c("FTS", aVar + ": " + Log.getStackTraceString(e), null);
                                    this.jpn = true;
                                }
                            } else if (e instanceof n) {
                                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                e.qd(6);
                            } else if (e instanceof SQLiteDiskIOException) {
                                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                e.qd(7);
                            } else if (e instanceof NullPointerException) {
                                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                e.qd(3);
                                if (this.jpl != null) {
                                    this.jpl.run();
                                }
                            } else if (e instanceof SQLiteException) {
                                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                if (e.getMessage() == null || !e.getMessage().contains("the connection is read-only")) {
                                    e.qd(4);
                                } else {
                                    e.qd(17);
                                }
                                if (this.jpl != null) {
                                    this.jpl.run();
                                }
                            } else {
                                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "[%s] failed with exception.\n", new Object[]{name});
                                e.qd(5);
                                if (this.jpl != null) {
                                    this.jpl.run();
                                }
                            }
                            a.aPK();
                            this.jpj = null;
                        } catch (Throwable th22) {
                            a.aPK();
                            this.jpj = null;
                        }
                    } else {
                        a.aPK();
                        this.jpj = null;
                    }
                }
            }
        }
    }

    public final boolean aiS() {
        return this.jpf != null && this.jpf.isAlive();
    }

    public final void quit() {
        if (this.jpf != null && this.jpf.isAlive()) {
            this.jpf.quit();
            try {
                this.jpf.join();
            } catch (InterruptedException e) {
            }
            this.jpf = null;
            x.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(int i, com.tencent.mm.plugin.fts.a.a.a aVar) {
        if (this.jpf == null) {
            return null;
        }
        aVar.mPriority = i;
        a aVar2 = this.jpf;
        if (aVar2.jpi) {
            return aVar;
        }
        int priority = aVar.getPriority();
        aVar2.jph.put(aVar);
        if (aVar2.jpj == null) {
            aVar2.qc(priority);
            return aVar;
        } else if (priority >= aVar2.jpg) {
            return aVar;
        } else {
            aVar2.interrupt();
            aVar2.qc(priority);
            return aVar;
        }
    }
}
