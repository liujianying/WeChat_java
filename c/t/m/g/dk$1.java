package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import c.t.m.g.dk.a;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

class dk$1 implements Runnable {
    private /* synthetic */ dk a;

    dk$1(dk dkVar) {
        this.a = dkVar;
    }

    public final void run() {
        Handler handler;
        Looper looper;
        this.a.a.clear();
        dk dkVar = this.a;
        a aVar = null;
        LinkedBlockingQueue linkedBlockingQueue = dkVar.a;
        while (true) {
            a aVar2 = aVar;
            if (dkVar.g) {
                try {
                    aVar = (a) linkedBlockingQueue.take();
                    try {
                        if (a.d != aVar) {
                            int length;
                            new StringBuilder("request:").append(aVar.b);
                            long currentTimeMillis = System.currentTimeMillis();
                            Bundle a = dkVar.b.a(a.c(aVar), a.a(aVar));
                            String string = a.getString("result");
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            new StringBuilder("cost:").append(currentTimeMillis2).append(",result:").append(string);
                            dkVar.c++;
                            dkVar.d += (long) a.a(aVar).length;
                            byte[] a2 = j.a(string.getBytes());
                            long j = dkVar.e;
                            if (a2 != null) {
                                length = a2.length;
                            } else {
                                length = 0;
                            }
                            dkVar.e = j + ((long) length);
                            Handler handler2 = dkVar.i;
                            aVar.c = currentTimeMillis;
                            if (!dkVar.h && dkVar.g && handler2 != null && handler2.getLooper().getThread().isAlive()) {
                                Message obtainMessage = handler2.obtainMessage();
                                obtainMessage.arg1 = (int) currentTimeMillis2;
                                if (1 == a.b(aVar)) {
                                    obtainMessage.obj = Pair.create(string, aVar);
                                    obtainMessage.what = 4999;
                                    obtainMessage.sendToTarget();
                                }
                            }
                            if (a.b(aVar) == 1 && dkVar.b.b.o == 0) {
                                dkVar.b.b.o = currentTimeMillis2;
                                dkVar.b.b.p = a.getString("req_key");
                            }
                        } else {
                            return;
                        }
                    } catch (InterruptedException e) {
                    } catch (IOException e2) {
                        new StringBuilder("cost:").append(System.currentTimeMillis() - 0).append(",run: io error");
                        dkVar.b(aVar);
                        handler = dkVar.i;
                        looper = handler != null ? null : handler.getLooper();
                        if (looper != null && looper.getThread().isAlive()) {
                            handler.sendEmptyMessageDelayed(4998, 0);
                        }
                    } catch (Throwable th) {
                    }
                } catch (InterruptedException e3) {
                    aVar = aVar2;
                } catch (IOException e4) {
                    aVar = aVar2;
                    new StringBuilder("cost:").append(System.currentTimeMillis() - 0).append(",run: io error");
                    dkVar.b(aVar);
                    handler = dkVar.i;
                    if (handler != null) {
                    }
                    handler.sendEmptyMessageDelayed(4998, 0);
                } catch (Throwable th2) {
                    aVar = aVar2;
                }
            } else {
                return;
            }
        }
    }
}
