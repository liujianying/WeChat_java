package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd.b;
import com.tencent.mm.y.g.a;

class c$f {
    long bJC;
    String content;
    long createTime;
    int juE;
    int juF;
    String juG;
    String juH;
    final /* synthetic */ c jux;
    int msgType;
    String talker;

    private c$f(c cVar) {
        this.jux = cVar;
    }

    /* synthetic */ c$f(c cVar, byte b) {
        this(cVar);
    }

    public final boolean aQm() {
        return (this.msgType & 65535) == 49;
    }

    public final boolean aQn() {
        return this.msgType == 1;
    }

    public final boolean aQo() {
        return this.msgType == 48;
    }

    public final void aQp() {
        if (aQn()) {
            this.juE = 41;
            if (s.fq(this.talker)) {
                this.juG = bd.iC(this.content);
            } else {
                this.juG = this.content;
            }
        } else if (aQm()) {
            a gp = a.gp(this.content);
            if (gp != null) {
                switch (gp.type) {
                    case 3:
                    case 4:
                    case 5:
                    case 8:
                    case 10:
                    case 13:
                    case 15:
                    case 16:
                    case 20:
                    case 25:
                        this.juG = bi.aG(gp.getTitle(), "");
                        this.juE = 43;
                        break;
                    case 6:
                        this.juG = bi.aG(gp.getTitle(), "");
                        this.juE = 42;
                        break;
                    case 19:
                        this.juG = bi.aG(gp.getDescription(), "");
                        if (this.juG != null) {
                            this.juG = this.juG.replace(":", "​");
                        }
                        this.juE = 44;
                        break;
                    case 24:
                        this.juG = bi.aG(gp.getDescription(), "");
                        if (this.juG != null) {
                            this.juG = this.juG.replace(":", "​");
                        }
                        this.juE = 49;
                        break;
                    case s$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                        this.juG = bi.aG(gp.getTitle(), "");
                        this.juE = 48;
                        break;
                    case 2000:
                        this.juG = bi.aG(gp.title, "") + "​" + bi.aG(gp.description, "");
                        this.juE = 45;
                        break;
                    case 2001:
                        if (!"1001".equals(gp.dyb)) {
                            if ("1002".equals(gp.dyb)) {
                                this.juE = 46;
                                if (this.juF != 1) {
                                    this.juG = bi.aG(gp.dxZ, "") + "​" + bi.aG(gp.dxV, "");
                                    break;
                                } else {
                                    this.juG = bi.aG(gp.dxZ, "") + "​" + bi.aG(gp.dxW, "");
                                    break;
                                }
                            }
                        }
                        this.juE = 47;
                        if (this.juF != 1) {
                            this.juG = bi.aG(gp.dxZ, "") + "​" + bi.aG(gp.dxV, "");
                            break;
                        } else {
                            this.juG = bi.aG(gp.dxZ, "") + "​" + bi.aG(gp.dxW, "");
                            break;
                        }
                        break;
                }
            }
        } else if (aQo()) {
            String iC;
            this.juE = 50;
            if (s.fq(this.talker)) {
                iC = bd.iC(this.content);
            } else {
                iC = this.content;
            }
            b GS = ((i) g.l(i.class)).bcY().GS(iC);
            if (GS.cmK()) {
                this.juG = GS.kFa + "​" + GS.label;
            } else {
                this.juG = GS.label;
            }
        }
        if (!bi.oW(this.juG)) {
            this.juG = d.Cu(this.juG);
        }
        if (this.juF == 1) {
            this.juH = q.GF();
        } else if (s.fq(this.talker)) {
            this.juH = bi.aG(bd.iB(this.content), this.talker);
        } else {
            this.juH = this.talker;
        }
    }

    public final boolean isAvailable() {
        return !bi.oW(this.juG);
    }
}
