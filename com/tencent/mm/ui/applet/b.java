package com.tencent.mm.ui.applet;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b {
    int direction = 0;
    private GestureDetector iEv = new GestureDetector(new 2(this));
    private IdleHandler tjO;
    private int trA;
    private c trB;
    LinkedList<String> trC;
    a trD;

    public b(a aVar) {
        this.trD = aVar;
        this.trA = 15;
        this.trB = new c(this);
        this.trC = new LinkedList();
        this.tjO = new IdleHandler() {
            public final boolean queueIdle() {
                while (b.this.trC.size() > 0) {
                    b.this.trD.pv((String) b.this.trC.removeFirst());
                }
                return true;
            }
        };
        Looper.myQueue().addIdleHandler(this.tjO);
    }

    public final void a(int i, b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
        } else if (this.trA <= 0) {
            x.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
        } else {
            int Xy = bVar.Xy();
            for (int i2 = 1; i2 <= this.trA; i2++) {
                String jd;
                if (this.direction == 1) {
                    if (i - i2 >= 0) {
                        jd = bVar.jd(i - i2);
                        if (!(jd == null || jd.length() == 0 || this.trB.contains(jd))) {
                            this.trB.pS(jd);
                            this.trC.add(jd);
                        }
                    } else {
                        return;
                    }
                } else if (i + i2 < Xy) {
                    jd = bVar.jd(i + i2);
                    if (!(jd == null || jd.length() == 0 || this.trB.contains(jd))) {
                        this.trB.pS(jd);
                        this.trC.add(jd);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        if (this.iEv != null) {
            this.iEv.onTouchEvent(motionEvent);
        }
    }

    public final void detach() {
        if (this.tjO != null) {
            Looper.myQueue().removeIdleHandler(this.tjO);
        }
    }
}
