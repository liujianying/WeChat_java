package com.google.android.exoplayer2.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.r.f;
import com.google.android.exoplayer2.i.r;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class r$b<T extends c> extends Handler implements Runnable {
    private final T aBI;
    private final a<T> aBJ;
    public final int aBK;
    private final long aBL;
    IOException aBM;
    int aBN;
    private volatile Thread aBO;
    final /* synthetic */ r aBP;
    private volatile boolean released;

    public r$b(r rVar, Looper looper, T t, a<T> aVar, int i, long j) {
        this.aBP = rVar;
        super(looper);
        this.aBI = t;
        this.aBJ = aVar;
        this.aBK = i;
        this.aBL = j;
    }

    public final void start(long j) {
        com.google.android.exoplayer2.i.a.ap(this.aBP.aBH == null);
        this.aBP.aBH = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void an(boolean z) {
        this.released = z;
        this.aBM = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.aBI.kQ();
            if (this.aBO != null) {
                this.aBO.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aBJ.a(this.aBI, elapsedRealtime, elapsedRealtime - this.aBL, true);
        }
    }

    public final void run() {
        try {
            this.aBO = Thread.currentThread();
            if (!this.aBI.kR()) {
                r.beginSection("load:" + this.aBI.getClass().getSimpleName());
                this.aBI.kS();
                r.endSection();
            }
            if (!this.released) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.released) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException e2) {
            com.google.android.exoplayer2.i.a.ap(this.aBI.kR());
            if (!this.released) {
                sendEmptyMessage(2);
            }
        } catch (Throwable e3) {
            if (!this.released) {
                obtainMessage(3, new f(e3)).sendToTarget();
            }
        } catch (Throwable e32) {
            if (!this.released) {
                obtainMessage(3, new f(e32)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.released) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            r.endSection();
        }
    }

    public final void handleMessage(Message message) {
        if (!this.released) {
            if (message.what == 0) {
                execute();
            } else if (message.what == 4) {
                throw ((Error) message.obj);
            } else {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.aBL;
                if (this.aBI.kR()) {
                    this.aBJ.a(this.aBI, elapsedRealtime, j, false);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.aBJ.a(this.aBI, elapsedRealtime, j, false);
                        return;
                    case 2:
                        this.aBJ.a(this.aBI, elapsedRealtime, j);
                        return;
                    case 3:
                        this.aBM = (IOException) message.obj;
                        int a = this.aBJ.a(this.aBI, elapsedRealtime, j, this.aBM);
                        if (a == 3) {
                            this.aBP.atg = this.aBM;
                            return;
                        } else if (a != 2) {
                            if (a == 1) {
                                a = 1;
                            } else {
                                a = this.aBN + 1;
                            }
                            this.aBN = a;
                            start((long) Math.min((this.aBN - 1) * 1000, 5000));
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private void execute() {
        this.aBM = null;
        this.aBP.aBG.execute(this.aBP.aBH);
    }

    private void finish() {
        this.aBP.aBH = null;
    }
}
