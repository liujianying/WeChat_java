package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class at {
    boolean bVR;
    Object lock;
    String name;
    int priority;
    public LinkedBlockingQueue<a> sIl;
    private int sIm;
    Vector<b> sIn;
    ag sIo;

    public interface a {
        boolean Kr();

        boolean Ks();
    }

    final class b extends Thread {
        private int pVu;

        /* synthetic */ b(at atVar, byte b) {
            this();
        }

        private b() {
            super(at.this.name);
            this.pVu = 60;
            setPriority(at.this.priority);
            at.this.sIn.add(this);
        }

        public final void run() {
            while (this.pVu > 0) {
                a aVar;
                synchronized (at.this.lock) {
                    try {
                        if (at.this.bVR) {
                            at.this.lock.wait();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
                    }
                }
                try {
                    aVar = (a) at.this.sIl.poll(2000, TimeUnit.MILLISECONDS);
                } catch (Throwable e2) {
                    x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e2, "", new Object[0]);
                    aVar = null;
                }
                if (aVar == null) {
                    this.pVu--;
                } else {
                    this.pVu = 60;
                    if (aVar.Kr()) {
                        at.this.sIo.sendMessage(at.this.sIo.obtainMessage(0, aVar));
                    }
                }
            }
            at.this.sIn.remove(this);
            x.d("QueueWorkerThread.QueueWorkerThread", "dktest Finish queueToReqSize:" + at.this.sIl.size() + " ThreadSize:" + at.this.sIn.size());
        }
    }

    public at(int i, String str) {
        this(i, str, 1);
    }

    public at(int i, String str, int i2) {
        this(i, str, i2, Looper.myLooper());
    }

    public at(int i, String str, int i2, Looper looper) {
        this.sIl = new LinkedBlockingQueue();
        this.bVR = false;
        this.sIm = 1;
        this.priority = 1;
        this.name = "";
        this.lock = new byte[0];
        this.sIn = new Vector();
        this.sIm = i2;
        this.name = str;
        this.priority = i;
        if (looper == null && Looper.getMainLooper() != null) {
            looper = Looper.getMainLooper();
            x.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
        }
        this.sIo = new ag(looper) {
            public final void handleMessage(Message message) {
                if (message != null && message.obj != null) {
                    ((a) message.obj).Ks();
                }
            }
        };
    }

    public final int c(a aVar) {
        if (aVar == null) {
            x.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
            return -1;
        }
        try {
            if (!this.sIl.offer(aVar, 1, TimeUnit.MILLISECONDS)) {
                x.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
                return -2;
            } else if (this.sIn.size() != 0 && (this.sIl.size() <= 0 || this.sIm <= this.sIn.size())) {
                return 0;
            } else {
                new b(this, (byte) 0).start();
                return 0;
            }
        } catch (Throwable e) {
            x.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + e.getMessage());
            x.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", e, "", new Object[0]);
            return -3;
        }
    }

    @Deprecated
    public final boolean ciz() {
        if (this.sIn == null || this.sIn.size() == 0) {
            return true;
        }
        return false;
    }

    public final void lh(boolean z) {
        synchronized (this.lock) {
            this.bVR = z;
            if (!z) {
                synchronized (this.lock) {
                    this.lock.notifyAll();
                }
            }
        }
    }
}
