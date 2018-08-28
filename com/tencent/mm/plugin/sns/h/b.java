package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    int cXZ;
    c cXu;
    public int hpo;
    public boolean nvB;
    public long nvC;
    public long nvD;
    public int nvE;
    int nvF;
    int nvG;
    int nvH;
    public int nvI;
    public int nvJ;
    int nvK;
    public int nvL;
    public int nvM;
    int nvN;
    public int nvO;
    public int nvP;
    public String nvQ;
    public String nvR;
    String nvS;
    int nvT;
    public int nvU;
    public int nvV;
    public int nvW;
    public int nvX;
    public int nvY;
    public int nvZ;
    long nwA;
    long nwB;
    long nwC;
    long nwD;
    long nwE;
    long nwF;
    long nwG;
    long nwH;
    long nwI;
    long nwJ;
    long nwK;
    long nwL;
    long nwM;
    long nwN;
    long nwO;
    long nwP;
    String nwQ;
    int nwR;
    long nwS;
    private long nwT;
    long nwU;
    private long nwV;
    private HashSet<String> nwW;
    HashSet<String> nwX;
    public HashSet<String> nwY;
    HashSet<String> nwZ;
    public int nwa;
    public int nwb;
    int nwc;
    int nwd;
    int nwe;
    int nwf;
    int nwg;
    int nwh;
    public int nwi;
    public int nwj;
    int nwk;
    int nwl;
    public long nwm;
    public long nwn;
    long nwo;
    long nwp;
    long nwq;
    long nwr;
    long nws;
    long nwt;
    long nwu;
    long nwv;
    long nww;
    long nwx;
    long nwy;
    long nwz;
    public HashSet<String> nxa;
    HashSet<String> nxb;
    HashSet<String> nxc;
    public HashSet<String> nxd;
    public HashSet<String> nxe;
    HashSet<String> nxf;
    public HashSet<String> nxg;
    private HashSet<String> nxh;
    public HashSet<String> nxi;
    public HashSet<String> nxj;
    public int nxk;
    public int nxl;
    public HashSet<String> nxm;
    public HashSet<String> nxn;
    public HashSet<String> nxo;
    public HashSet<String> nxp;
    public HashSet<String> nxq;
    public HashSet<String> nxr;
    public HashSet<String> nxs;
    public HashSet<String> nxt;
    public HashSet<String> nxu;
    public HashSet<String> nxv;
    public HashSet<String> nxw;
    public HashSet<String> nxx;
    public long nxy;

    public final void u(n nVar) {
        if (nVar != null) {
            this.nwW.add(nVar.bBe());
            this.nvF = this.nwW.size();
        }
    }

    public final void v(n nVar) {
        if (nVar != null) {
            String bBe = nVar.bBe();
            String g = i.g(nVar);
            if (!this.nwX.contains(g)) {
                x.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[]{bBe, g});
                this.nvG++;
                this.nwX.add(g);
                if (nVar.xb(32)) {
                    this.nwl++;
                }
                switch (nVar.field_type) {
                    case 1:
                        this.nwe++;
                        break;
                    case 3:
                        if (!bi.oW(nVar.bAJ().sqd)) {
                            this.nwc++;
                            break;
                        } else {
                            this.nwd++;
                            break;
                        }
                    case 4:
                        this.nwg++;
                        break;
                    case 5:
                        this.nwh++;
                        break;
                    case 15:
                        this.nwf++;
                        break;
                    case 18:
                        this.nwk++;
                        break;
                }
                if (nVar.xb(32)) {
                    if (nVar.bAF() != null && nVar.bAF().bzm()) {
                        hY(true);
                    } else if (nVar.field_type == 1) {
                        id(true);
                    } else if (nVar.field_type == 15) {
                        ie(true);
                    }
                } else if (nVar.bAJ() == null || bi.oW(nVar.bAJ().ogR)) {
                    switch (nVar.field_type) {
                        case 1:
                            hX(true);
                            return;
                        case 3:
                            if (bi.oW(nVar.bAJ().sqd)) {
                                ic(true);
                                return;
                            } else {
                                ib(true);
                                return;
                            }
                        case 4:
                            ic(true);
                            return;
                        case 5:
                            ic(true);
                            return;
                        case 15:
                            ia(true);
                            return;
                        case 18:
                            ig(true);
                            return;
                        default:
                            return;
                    }
                } else {
                    hZ(true);
                }
            }
        }
    }

    public final void a(n nVar, boolean z) {
        if (nVar != null) {
            if (z) {
                this.nxb.add(i.g(nVar));
            } else {
                this.nxc.add(i.g(nVar));
            }
            this.nxf.add(nVar.field_userName);
            this.nvH = this.nxf.size();
            if (af.bxU().equals(nVar.field_userName)) {
                hT(true);
            } else {
                hU(true);
            }
        }
    }

    public final void eE(String str, String str2) {
        this.nwZ.add(str2);
        this.nxh.add(str);
        this.nvK = this.nxh.size();
    }

    public final void hS(boolean z) {
        if (z) {
            this.nwp = System.currentTimeMillis();
        } else if (this.nwp > 0) {
            this.nwo += System.currentTimeMillis() - this.nwp;
            this.nwp = 0;
        }
    }

    public final void hT(boolean z) {
        if (z) {
            this.nwr = System.currentTimeMillis();
        } else if (this.nwr > 0) {
            this.nwq += System.currentTimeMillis() - this.nwr;
            this.nwr = 0;
        }
    }

    public final void hU(boolean z) {
        if (z) {
            this.nwt = System.currentTimeMillis();
        } else if (this.nwt > 0) {
            this.nws += System.currentTimeMillis() - this.nwt;
            this.nwt = 0;
        }
    }

    public final void hV(boolean z) {
        if (z) {
            this.nwv = System.currentTimeMillis();
        } else if (this.nwv > 0) {
            this.nwu += System.currentTimeMillis() - this.nwv;
            this.nwv = 0;
        }
    }

    public final void hW(boolean z) {
        if (z) {
            this.nwx = System.currentTimeMillis();
        } else if (this.nwx > 0) {
            this.nww += System.currentTimeMillis() - this.nwx;
            this.nwx = 0;
        }
    }

    public final void hX(boolean z) {
        if (z) {
            this.nwz = System.currentTimeMillis();
        } else if (this.nwz > 0) {
            this.nwy += System.currentTimeMillis() - this.nwz;
            this.nwz = 0;
        }
    }

    public final void hY(boolean z) {
        if (z) {
            this.nwT = System.currentTimeMillis();
        } else if (this.nwT > 0) {
            this.nwS += System.currentTimeMillis() - this.nwT;
            this.nwT = 0;
        }
    }

    public final void hZ(boolean z) {
        if (z) {
            this.nwV = System.currentTimeMillis();
        } else if (this.nwV > 0) {
            this.nwU += System.currentTimeMillis() - this.nwV;
            this.nwV = 0;
        }
    }

    public final void ia(boolean z) {
        if (z) {
            this.nwB = System.currentTimeMillis();
        } else if (this.nwB > 0) {
            this.nwA += System.currentTimeMillis() - this.nwB;
            this.nwB = 0;
        }
    }

    public final void ib(boolean z) {
        if (z) {
            this.nwD = System.currentTimeMillis();
        } else if (this.nwD > 0) {
            this.nwC += System.currentTimeMillis() - this.nwD;
            this.nwD = 0;
        }
    }

    public final void ic(boolean z) {
        if (z) {
            this.nwF = System.currentTimeMillis();
        } else if (this.nwF > 0) {
            this.nwE += System.currentTimeMillis() - this.nwF;
            this.nwF = 0;
        }
    }

    public final void id(boolean z) {
        if (z) {
            this.nwH = System.currentTimeMillis();
        } else if (this.nwH > 0) {
            this.nwG += System.currentTimeMillis() - this.nwH;
            this.nwH = 0;
        }
    }

    public final void ie(boolean z) {
        if (z) {
            this.nwL = System.currentTimeMillis();
        } else if (this.nwL > 0) {
            this.nwK += System.currentTimeMillis() - this.nwL;
            this.nwL = 0;
        }
    }

    public final void if(boolean z) {
        if (z) {
            this.nwN = System.currentTimeMillis();
        } else if (this.nwN > 0) {
            this.nwM += System.currentTimeMillis() - this.nwN;
            this.nwN = 0;
        }
    }

    public final void ig(boolean z) {
        if (z) {
            this.nwP = System.currentTimeMillis();
        } else if (this.nwP > 0) {
            this.nwO += System.currentTimeMillis() - this.nwP;
            this.nwP = 0;
        }
    }

    public final void ih(boolean z) {
        this.nvT = z ? 1 : 0;
    }

    public b() {
        this.nvB = false;
        this.nvC = -1;
        this.nvD = 0;
        this.nvE = 0;
        this.nvF = 0;
        this.nvG = 0;
        this.nvH = 0;
        this.nvI = 0;
        this.nvJ = 0;
        this.nvK = 0;
        this.nvL = 0;
        this.nvM = 0;
        this.nvN = 0;
        this.nvO = 0;
        this.nvP = 0;
        this.nvQ = "";
        this.nvR = "";
        this.nvS = "";
        this.nvU = 0;
        this.nvV = 0;
        this.nvW = 0;
        this.nvX = 0;
        this.nvY = 0;
        this.nvZ = 0;
        this.nwa = 0;
        this.hpo = 0;
        this.nwb = 0;
        this.nwc = 0;
        this.nwd = 0;
        this.nwe = 0;
        this.nwf = 0;
        this.nwg = 0;
        this.nwh = 0;
        this.nwi = 0;
        this.nwj = 0;
        this.nwk = 0;
        this.nwl = 0;
        this.nwm = 0;
        this.nwn = 0;
        this.nwo = 0;
        this.nwp = 0;
        this.nwq = 0;
        this.nwr = 0;
        this.nws = 0;
        this.nwt = 0;
        this.nwu = 0;
        this.nwv = 0;
        this.nww = 0;
        this.nwx = 0;
        this.nwy = 0;
        this.nwz = 0;
        this.nwA = 0;
        this.nwB = 0;
        this.nwC = 0;
        this.nwD = 0;
        this.nwE = 0;
        this.nwF = 0;
        this.nwG = 0;
        this.nwH = 0;
        this.nwI = 0;
        this.nwJ = 0;
        this.nwK = 0;
        this.nwL = 0;
        this.nwM = 0;
        this.nwN = 0;
        this.nwO = 0;
        this.nwP = 0;
        this.nwS = 0;
        this.nwT = 0;
        this.nwU = 0;
        this.nwV = 0;
        this.nwW = new HashSet();
        this.nwX = new HashSet();
        this.nwY = new HashSet();
        this.nwZ = new HashSet();
        this.nxa = new HashSet();
        this.nxb = new HashSet();
        this.nxc = new HashSet();
        this.nxd = new HashSet();
        this.nxe = new HashSet();
        this.nxf = new HashSet();
        this.nxg = new HashSet();
        this.nxh = new HashSet();
        this.nxi = new HashSet();
        this.nxj = new HashSet();
        this.nxk = Integer.MAX_VALUE;
        this.nxl = 0;
        this.nxm = new HashSet();
        this.nxn = new HashSet();
        this.nxo = new HashSet();
        this.nxp = new HashSet();
        this.nxq = new HashSet();
        this.nxr = new HashSet();
        this.nxs = new HashSet();
        this.nxt = new HashSet();
        this.nxu = new HashSet();
        this.nxv = new HashSet();
        this.nxw = new HashSet();
        this.nxx = new HashSet();
        this.cXu = new 1(this);
        this.nxy = 0;
        a.sFg.b(this.cXu);
    }

    public b(int i, String str, int i2) {
        this();
        this.cXZ = i;
        this.nwQ = str;
        this.nwR = i2;
    }

    static String f(HashSet<String> hashSet) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = hashSet.iterator();
        Object obj = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (obj != null) {
                stringBuffer.append(str);
                obj = null;
            } else {
                stringBuffer.append("|" + str);
            }
        }
        return stringBuffer.toString();
    }
}
