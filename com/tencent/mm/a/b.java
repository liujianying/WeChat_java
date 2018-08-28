package com.tencent.mm.a;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b {
    static ag bvX;
    File bvU;
    private ReentrantLock bvV = new ReentrantLock();
    private Condition bvW = this.bvV.newCondition();

    public b(final String str) {
        synchronized (b.class) {
            if (bvX == null) {
                HandlerThread handlerThread = new HandlerThread("I/O Worker");
                handlerThread.start();
                bvX = new ag(handlerThread.getLooper());
            }
        }
        File file = new File(str);
        if (file.exists()) {
            this.bvU = file;
            return;
        }
        x.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        bvX.post(new Runnable() {
            public final void run() {
                File file = new File(str);
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.cs(str);
                    x.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        file.createNewFile();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "", new Object[0]);
                        x.printErrStackTrace("MicroMsg.ConcurrentFileBuilder", e, "createNewFile", new Object[0]);
                    }
                    x.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                b.this.bvV.lock();
                try {
                    b.this.bvU = file;
                    b.this.bvW.signal();
                    x.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", file.getAbsoluteFile());
                } finally {
                    b.this.bvV.unlock();
                }
            }
        });
    }

    public final File tZ() {
        this.bvV.lock();
        while (this.bvU == null) {
            try {
                x.i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.bvW.await();
            } catch (Exception e) {
            } finally {
                this.bvV.unlock();
            }
        }
        return this.bvU;
    }
}
