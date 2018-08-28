package com.tencent.mm.plugin.subapp;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.api.f;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.subapp.a.1;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.a;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.HashMap;
import java.util.Map;

public class a$a extends c<fi> implements e {
    private int bNS;
    private int bNT;
    private String bSS;
    private boolean djH;
    private boolean fsJ;
    private a opZ;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.c oqa;
    private b oqb;
    private com.tencent.mm.modelvoice.b oqc;
    private p oqd;
    private volatile boolean oqe;
    boolean oqf;
    private al oqg;
    private fi oqh;
    private int oqi;
    private Map<String, String> oqj;
    private int oqk;
    private boolean oql;
    private long oqm;
    private long oqn;
    private String toUser;

    public a$a() {
        this.oqe = false;
        this.oqf = false;
        this.oql = true;
        this.oqm = 0;
        this.djH = false;
        this.oqj = new HashMap();
        this.sFo = fi.class.getName().hashCode();
    }

    private boolean a(fi fiVar) {
        if (!(fiVar instanceof fi)) {
            x.f("MicroMsg.SubCoreSubapp", "mismatched event");
            return false;
        } else if (fiVar.bNF.bNI == 2) {
            a(a.oqw);
            this.oqj.clear();
            x.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
            return true;
        } else if (fiVar.bNF.bNI == 1) {
            a(a.oqw);
            x.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
            return true;
        } else if (fiVar.bNF.bNI == 3) {
            a(a.oqx);
            x.i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
            return true;
        } else if (fiVar.bNF.bNI != 0) {
            x.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", new Object[]{Integer.valueOf(this.oqh.bNF.bNI)});
            return false;
        } else if (this.fsJ) {
            x.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
            return false;
        } else if (m.TI() == null) {
            x.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + bi.cjd());
            return false;
        } else {
            this.oqh = fiVar;
            String str = this.oqh.bNF.bNH;
            String str2 = this.oqh.bNF.fileName;
            if (bi.oW(str) || bi.oW(str2)) {
                x.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", new Object[]{str, str2});
                a(a.oqy);
                return false;
            }
            bFW();
            String str3 = (String) this.oqj.get(str2);
            if (bi.oW(str3)) {
                bx Zs = m.TJ().Zs(str2);
                a.opT = Zs;
                if (Zs == null || bi.oW(a.opT.field_content)) {
                    x.i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", new Object[]{Integer.valueOf(fiVar.bNF.scene)});
                    this.oqd = m.TI().ow(str2);
                    try {
                        if (this.oqd == null) {
                            x.i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", new Object[]{str, str2});
                            this.oqd = new p();
                            this.oqd.fileName = str2;
                            this.oqd.createTime = System.currentTimeMillis() / 1000;
                            this.oqd.clientId = str2;
                            this.oqd.enK = System.currentTimeMillis() / 1000;
                            this.oqd.status = 1;
                            if (fiVar.bNF.scene == 8) {
                                this.oqd.enN = -1;
                            } else {
                                this.oqd.enN = Integer.valueOf(str).intValue();
                            }
                            x.i("MicroMsg.SubCoreSubapp", "size : %d", new Object[]{Integer.valueOf(o.nM(str2))});
                            this.oqd.dHI = r0;
                        }
                        if (this.oqd.enN < 0) {
                            x.i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
                        } else {
                            bd dW = ((i) g.l(i.class)).bcY().dW((long) this.oqd.enN);
                            com.tencent.mm.ac.a.c ak;
                            if (dW.field_isSend == 1) {
                                this.bSS = q.GF();
                                if (this.oqh.bNF.scene == 4 || this.oqh.bNF.scene == 5) {
                                    ak = ((f) g.l(f.class)).ak(dW.field_bizChatId);
                                    if (ak != null) {
                                        this.toUser = ak.field_bizChatServId;
                                    } else {
                                        this.toUser = "";
                                    }
                                } else {
                                    this.toUser = dW.field_talker;
                                }
                            } else if (dW.field_isSend == 0) {
                                this.toUser = q.GF();
                                if (this.oqh.bNF.scene == 4 || this.oqh.bNF.scene == 5) {
                                    ak = ((f) g.l(f.class)).ak(dW.field_bizChatId);
                                    if (ak != null) {
                                        this.bSS = ak.field_bizChatServId;
                                    } else {
                                        this.bSS = "";
                                    }
                                } else {
                                    this.bSS = dW.field_talker;
                                }
                            }
                        }
                        this.oqk = this.oqh.bNF.scene;
                        x.d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", new Object[]{this.bSS, this.toUser, Integer.valueOf(this.oqk)});
                        this.oqc = com.tencent.mm.modelvoice.q.ok(this.oqd.fileName);
                        this.fsJ = true;
                        this.oqi = 20;
                        a(a.oqq);
                        return true;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreSubapp", e, "alvinluo set voiceInfo exception", new Object[0]);
                        a(a.oqy);
                        return true;
                    }
                }
                x.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", new Object[]{str, str2});
                a(a.opT.field_content, a.oqu);
                return true;
            }
            x.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", new Object[]{str, str2});
            a(str3, a.oqu);
            return true;
        }
    }

    private void bFW() {
        this.oql = true;
        this.oqm = 0;
        this.oqn = 0;
        this.bNS = 0;
        this.bNT = 0;
        this.djH = false;
    }

    final void a(a aVar) {
        switch (1.opY[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.SubCoreSubapp", "net check");
                if (this.oqd.bYu > 0) {
                    x.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[]{Long.valueOf(this.oqd.bYu)});
                    this.opZ = new a(this.oqd.clientId, this.oqd.dHI, this.oqc.getFormat(), this.oqd.bYu, this.oqd.fileName, this.oqk, this.bSS, this.toUser);
                } else {
                    x.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[]{Long.valueOf(this.oqd.bYu)});
                    this.opZ = new a(this.oqd.clientId, this.oqd.dHI, this.oqd.fileName, this.oqk, this.bSS, this.toUser);
                }
                au.DF().a(this.opZ, 0);
                au.DF().a(this.opZ.getType(), this);
                this.oqn = System.currentTimeMillis();
                return;
            case 2:
                x.i("MicroMsg.SubCoreSubapp", "net upload");
                if (this.opZ == null) {
                    x.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
                    return;
                }
                this.oqa = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.oqd.clientId, this.opZ.oue, this.oqc.getFormat(), this.oqd.fileName, this.oqk, this.bSS, this.toUser);
                au.DF().a(this.oqa, 0);
                au.DF().a(this.oqa.getType(), this);
                return;
            case 3:
                x.i("MicroMsg.SubCoreSubapp", "net upload more");
                if (this.oqa == null) {
                    x.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                    return;
                }
                this.oqa = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.oqa);
                au.DF().a(this.oqa, 0);
                au.DF().a(this.oqa.getType(), this);
                return;
            case 4:
                if (this.oqe) {
                    x.i("MicroMsg.SubCoreSubapp", "pulling so pass");
                    return;
                }
                x.i("MicroMsg.SubCoreSubapp", "net get");
                if (this.opZ == null) {
                    x.w("MicroMsg.SubCoreSubapp", "request get must after check!");
                    return;
                }
                this.oqe = true;
                this.oqb = new b(this.oqd.clientId);
                au.DF().a(this.oqb, 0);
                au.DF().a(this.oqb.getType(), this);
                return;
            case 5:
                this.oqf = true;
                return;
            case 6:
                au.DF().c(this.opZ);
                au.DF().c(this.oqa);
                au.DF().c(this.oqb);
                this.djH = true;
                a(null, a.oqw);
                return;
            case 7:
            case 8:
                this.djH = true;
                a(null, aVar);
                return;
            case 9:
                this.djH = true;
                a(null, aVar);
                return;
            default:
                return;
        }
    }

    private void bFX() {
        if (this.oql) {
            this.oql = false;
            this.oqm = System.currentTimeMillis();
            this.bNS = (int) (this.oqm - this.oqn);
        }
    }

    private void a(String str, a aVar) {
        x.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[]{aVar});
        if (this.oqg != null) {
            this.oqg.SO();
        }
        au.DF().b(546, this);
        au.DF().b(547, this);
        au.DF().b(548, this);
        if (this.oqh != null) {
            if (!bi.oW(str)) {
                this.oqj.put(this.oqh.bNF.fileName, str);
                if ((a.opT == null || bi.oW(a.opT.field_content)) && this.oqh.bNF.bJu == 1) {
                    by TJ = m.TJ();
                    x.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[]{this.oqh.bNF.bNH, this.oqh.bNF.fileName});
                    bx bxVar = new bx();
                    bxVar.field_msgId = Long.valueOf(this.oqh.bNF.bNH).longValue();
                    bxVar.Zr(this.oqh.bNF.fileName);
                    bxVar.field_content = str;
                    TJ.a(bxVar);
                }
            } else if (aVar == a.oqu) {
                x.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[]{this.oqh.bNF.bNH});
                this.oqh.bNG.state = 2;
            }
            this.oqh.bNG.aoy = true;
            this.oqh.bNG.content = str;
            if (aVar == a.oqw) {
                this.oqh.bNG.state = 1;
            } else if (aVar == a.oqy || aVar == a.oqz) {
                this.oqh.bNG.state = 2;
            }
            x.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[]{str});
            if (this.oqh.bNF.bNJ != null) {
                this.oqh.bNF.bNJ.run();
            }
        }
        if (this.djH && this.oqd != null) {
            int length;
            int i;
            if (str != null) {
                length = str.length();
            } else {
                length = 0;
            }
            if (aVar != a.oqu) {
                this.bNS = 0;
                this.bNT = 0;
                if (aVar == a.oqw) {
                    i = 5;
                    length = 0;
                } else if (aVar == a.oqz) {
                    length = 0;
                    i = 3;
                } else if (aVar == a.oqy) {
                    i = 4;
                    length = 0;
                } else if (aVar == a.oqA) {
                    length = 0;
                    i = 2;
                } else {
                    length = 0;
                    i = 0;
                }
            } else if (bi.oW(str)) {
                this.bNS = 0;
                this.bNT = 0;
                length = 0;
                i = 3;
            } else {
                i = 1;
            }
            x.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", new Object[]{this.oqd.clientId, Integer.valueOf(length), Integer.valueOf(this.bNS), Integer.valueOf(this.bNT), Integer.valueOf(i)});
            if (i != 0) {
                com.tencent.mm.plugin.subapp.d.b.b(this.oqd.clientId, length, this.bNS, this.bNT, i);
            }
        }
        this.opZ = null;
        this.oqa = null;
        this.oqb = null;
        this.oqh = null;
        this.fsJ = false;
        this.oqf = false;
        this.oqe = false;
        this.oqi = 20;
        a.opT = null;
        bFW();
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = null;
        x.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            int i3;
            switch (lVar.getType()) {
                case 546:
                    if (this.opZ.mState == a.ouc) {
                        x.i("MicroMsg.SubCoreSubapp", "check result: done");
                        a(a.oqu);
                        bFX();
                        this.bNT = 0;
                        this.djH = true;
                        if (this.opZ.bGC()) {
                            str2 = this.opZ.oud.suF;
                        }
                        a(str2, a.oqu);
                        return;
                    } else if (this.opZ.mState == a.oub) {
                        if (this.opZ.oud != null) {
                            bi.oW(this.opZ.oud.suF);
                        }
                        x.i("MicroMsg.SubCoreSubapp", "check result: processing");
                        a(a.oqt);
                        return;
                    } else if (this.opZ.mState == a.oua) {
                        x.i("MicroMsg.SubCoreSubapp", "check result: not exist");
                        a(a.oqr);
                        return;
                    } else if (this.opZ.ouf != null) {
                        i3 = this.opZ.ouf.sga;
                        return;
                    } else {
                        return;
                    }
                case 547:
                    if (this.oqa.bGE()) {
                        x.i("MicroMsg.SubCoreSubapp", "succeed upload");
                        a(a.oqt);
                        return;
                    }
                    x.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[]{Integer.valueOf(this.oqa.oue.rdW), Integer.valueOf(this.oqa.oue.rdX)});
                    a(a.oqs);
                    return;
                case 548:
                    int i4 = this.oqb.ouh;
                    x.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[]{Integer.valueOf(i4)});
                    this.oqe = false;
                    bFX();
                    if (!this.oqb.isComplete() && this.oqb.bGC()) {
                        x.i("MicroMsg.SubCoreSubapp", "refreshResult result");
                        String str3 = this.oqb.oud.suF;
                        if (this.oqh != null) {
                            this.oqh.bNG.aoy = false;
                            this.oqh.bNG.content = str3;
                            x.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[]{Boolean.valueOf(bi.oW(str3))});
                            if (this.oqh.bNF.bNJ != null) {
                                this.oqh.bNF.bNJ.run();
                            }
                        }
                    } else if (!this.oqb.bGC()) {
                        x.d("MicroMsg.SubCoreSubapp", "result not valid");
                    }
                    if (this.oqb.isComplete()) {
                        x.i("MicroMsg.SubCoreSubapp", "succeed get");
                        if (this.oqb.bGC()) {
                            str2 = this.oqb.oud.suF;
                        }
                        a(a.oqu);
                        this.bNT = (int) (System.currentTimeMillis() - this.oqm);
                        this.djH = true;
                        a(str2, a.oqu);
                        return;
                    }
                    x.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[]{Integer.valueOf(i4)});
                    if (!this.oqf) {
                        i3 = this.oqi - 1;
                        this.oqi = i3;
                        if (i3 < 0) {
                            x.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[]{Integer.valueOf(20)});
                            a(a.oqz);
                            return;
                        }
                        if (this.oqg == null) {
                            this.oqg = new al(new 1(this, i4), false);
                        }
                        long j = (long) (i4 * 1000);
                        this.oqg.J(j, j);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 2) {
            a(a.oqA);
        } else {
            a(a.oqz);
        }
    }
}
