package com.tencent.mm.sdk.d;

import android.os.Message;
import com.tencent.mm.sdk.d.d.a;
import java.util.Vector;

class d$b {
    private int mCount;
    private Vector<a> sJZ;
    private int sKa;
    private int sKb;
    private boolean sKc;

    /* synthetic */ d$b(byte b) {
        this();
    }

    private d$b() {
        this.sJZ = new Vector();
        this.sKa = 20;
        this.sKb = 0;
        this.mCount = 0;
        this.sKc = false;
    }

    final synchronized boolean cjo() {
        return this.sKc;
    }

    final synchronized void cleanup() {
        this.sJZ.clear();
    }

    final synchronized void b(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
        this.mCount++;
        if (this.sJZ.size() < this.sKa) {
            this.sJZ.add(new a(dVar, message, str, aVar, aVar2, aVar3));
        } else {
            a aVar4 = (a) this.sJZ.get(this.sKb);
            this.sKb++;
            if (this.sKb >= this.sKa) {
                this.sKb = 0;
            }
            aVar4.a(dVar, message, str, aVar, aVar2, aVar3);
        }
    }
}
