package com.tencent.d.b.d;

import com.tencent.d.a.a;
import com.tencent.d.a.c.e;
import com.tencent.d.a.c.f;
import com.tencent.d.b.a.c;

class b$1 implements Runnable {
    final /* synthetic */ b vma;

    b$1(b bVar) {
        this.vma = bVar;
    }

    public final void run() {
        c cVar;
        b bVar = this.vma;
        if ((bVar.vlU & 1) != 1) {
            if ((bVar.vlU & 2) != 2) {
                com.tencent.d.a.c.c.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
                cVar = new c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
            } else if (f.oW(bVar.vlV)) {
                com.tencent.d.a.c.c.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
                cVar = new c(1, "auth key name not specified");
            }
            if (!cVar.isSuccess()) {
                b.a(this.vma, cVar);
            } else if (a.cFz()) {
                e cFB;
                if ((this.vma.vlU & 1) == 1) {
                    com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                    if (this.vma.vlW && a.cFC()) {
                        com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                        cFB = a.cFB();
                        if (!cFB.isSuccess()) {
                            com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[]{cFB.Yy});
                            b.a(this.vma, cFB);
                            return;
                        }
                    }
                    cFB = a.cFA();
                    if (cFB.isSuccess()) {
                        com.tencent.d.a.c.c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                        b.a(this.vma, cFB);
                    } else {
                        com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[]{cFB.Yy});
                        a.cFB();
                        b.a(this.vma, cFB);
                        return;
                    }
                }
                if ((this.vma.vlU & 2) == 2) {
                    com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[]{this.vma.vlV});
                    if (a.cFD()) {
                        if (this.vma.vlX && a.acz(this.vma.vlV)) {
                            com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                            cFB = a.bD(this.vma.vlV, false);
                            if (!cFB.isSuccess()) {
                                com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[]{this.vma.vlV, cFB.Yy});
                                b.a(this.vma, cFB);
                                return;
                            }
                        }
                        cFB = a.acy(this.vma.vlV);
                        if (cFB.isSuccess()) {
                            com.tencent.d.a.c.c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                            b.a(this.vma, cFB);
                            return;
                        }
                        com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[]{this.vma.vlV, cFB.Yy});
                        a.bD(this.vma.vlV, true);
                        b.a(this.vma, cFB);
                        return;
                    }
                    com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                    b.a(this.vma, new c(3, "ASK not exists when generate auth key"));
                }
            } else {
                com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                b.a(this.vma, new c(2));
            }
        }
        cVar = new c(0);
        if (!cVar.isSuccess()) {
            b.a(this.vma, cVar);
        } else if (a.cFz()) {
            e cFB2;
            if ((this.vma.vlU & 1) == 1) {
                com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                if (this.vma.vlW && a.cFC()) {
                    com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                    cFB2 = a.cFB();
                    if (!cFB2.isSuccess()) {
                        com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", new Object[]{cFB2.Yy});
                        b.a(this.vma, cFB2);
                        return;
                    }
                }
                cFB2 = a.cFA();
                if (cFB2.isSuccess()) {
                    com.tencent.d.a.c.c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                    b.a(this.vma, cFB2);
                } else {
                    com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", new Object[]{cFB2.Yy});
                    a.cFB();
                    b.a(this.vma, cFB2);
                    return;
                }
            }
            if ((this.vma.vlU & 2) == 2) {
                com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", new Object[]{this.vma.vlV});
                if (a.cFD()) {
                    if (this.vma.vlX && a.acz(this.vma.vlV)) {
                        com.tencent.d.a.c.c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                        cFB2 = a.bD(this.vma.vlV, false);
                        if (!cFB2.isSuccess()) {
                            com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", new Object[]{this.vma.vlV, cFB2.Yy});
                            b.a(this.vma, cFB2);
                            return;
                        }
                    }
                    cFB2 = a.acy(this.vma.vlV);
                    if (cFB2.isSuccess()) {
                        com.tencent.d.a.c.c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                        b.a(this.vma, cFB2);
                        return;
                    }
                    com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", new Object[]{this.vma.vlV, cFB2.Yy});
                    a.bD(this.vma.vlV, true);
                    b.a(this.vma, cFB2);
                    return;
                }
                com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                b.a(this.vma, new c(3, "ASK not exists when generate auth key"));
            }
        } else {
            com.tencent.d.a.c.c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
            b.a(this.vma, new c(2));
        }
    }
}
