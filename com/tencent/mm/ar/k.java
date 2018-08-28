package com.tencent.mm.ar;

import android.os.Looper;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.k.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.protocal.c.afz;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k extends l implements n, com.tencent.mm.network.k {
    private int bJE;
    private b diG;
    private e diJ;
    private boolean ecQ;
    private int flags;

    public k(boolean z) {
        this.ecQ = false;
        this.flags = -1;
        this.bJE = 26;
        this.ecQ = false;
        x.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
        x.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.flags = 1;
        }
    }

    public k(int i) {
        this.ecQ = false;
        this.flags = -1;
        this.bJE = i;
        this.ecQ = false;
        x.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:" + i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.bJE);
        a aVar = new a();
        aVar.dIG = new afy();
        aVar.dIH = new afz();
        aVar.uri = "/cgi-bin/micromsg-bin/getpackagelist";
        aVar.dIF = 159;
        aVar.dII = 51;
        aVar.dIJ = 1000000051;
        this.diG = aVar.KT();
        afy afy = (afy) this.diG.dID.dIL;
        LinkedList linkedList = new LinkedList();
        if (!g.Eg().Dx()) {
            return -1;
        }
        m[] ik = r.Qp().ik(this.bJE);
        if (ik != null && ik.length > 0) {
            for (int i = 0; i < ik.length; i++) {
                ayv ayv = new ayv();
                ayv.jTt = ik[i].id;
                if (af.exc && this.bJE == 7) {
                    x.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
                    ayv.hcD = 0;
                } else {
                    ayv.hcD = ik[i].version;
                }
                x.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[]{Integer.valueOf(ayv.jTt), Integer.valueOf(ayv.hcD)});
                linkedList.add(ayv);
            }
        }
        afy.hbG = linkedList;
        afy.hbF = linkedList.size();
        afy.hcE = this.bJE;
        if (this.flags != -1) {
            afy.rbZ = this.flags;
        }
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 20;
    }

    protected final void a(l.a aVar) {
    }

    public final boolean KX() {
        return true;
    }

    private m a(ayv ayv) {
        m mVar = new m();
        mVar.id = ayv.jTt;
        mVar.version = ayv.hcD;
        mVar.name = ayv.jPe;
        mVar.size = ayv.hcy;
        mVar.ecV = ayv.rwQ;
        mVar.status = 5;
        mVar.bPh = this.bJE;
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.bJE), str});
        if (i2 == 0 || i3 == 0) {
            afz afz = (afz) ((b) qVar).dIE.dIL;
            if (afz.hcE != this.bJE) {
                x.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[]{Integer.valueOf(afz.hcE)});
                this.diJ.a(3, -1, "", this);
                return;
            }
            LinkedList linkedList = afz.hbG;
            x.v("MicroMsg.NetSceneGetPackageList", "summer list size:" + (linkedList == null ? 0 : linkedList.size()) + " packageType: " + this.bJE + " resp.Type: " + afz.hcE);
            ayv ayv;
            m bi;
            m a;
            m a2;
            if (this.bJE == 2) {
                h(linkedList);
            } else if (this.bJE == 1) {
                g(linkedList);
            } else if (this.bJE == 4) {
                i(linkedList);
            } else if (this.bJE == 6) {
                x.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
            } else if (this.bJE == 7) {
                j(linkedList);
            } else if (this.bJE == 8) {
                if (linkedList == null || linkedList.size() <= 0) {
                    x.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
                } else {
                    x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    ayv = (ayv) linkedList.get(0);
                    bi = r.Qp().bi(ayv.jTt, this.bJE);
                    a = a(ayv);
                    a.bWA = -1;
                    if (bi == null) {
                        r.Qp().a(a);
                    } else {
                        r.Qp().b(a);
                    }
                    x.d("MicroMsg.NetSceneGetPackageList", ayv.jPe + " - " + ayv.jTt + " - " + ayv.rwQ + " - " + ayv.hcy);
                }
            } else if (this.bJE == 9) {
                f(linkedList);
            } else if (this.bJE == 10) {
                if (linkedList == null || linkedList.size() <= 0) {
                    x.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
                } else {
                    x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    ayv = (ayv) linkedList.get(0);
                    bi = r.Qp().bi(ayv.jTt, this.bJE);
                    a2 = a(ayv);
                    a2.bWA = -1;
                    if (bi == null) {
                        r.Qp().a(a2);
                    } else {
                        r.Qp().b(a2);
                    }
                }
            } else if (this.bJE != 11) {
                if (this.bJE == 12) {
                    l(linkedList);
                } else if (this.bJE == 5) {
                    m(linkedList);
                } else if (this.bJE == 20) {
                    k(linkedList);
                } else if (this.bJE == 17) {
                    if (linkedList == null || linkedList.size() == 0) {
                        x.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
                    } else {
                        ayv = (ayv) linkedList.get(0);
                        x.d("MicroMsg.NetSceneGetPackageList", ayv.jPe + " - " + ayv.jTt + " - " + ayv.rwQ + " - " + ayv.hcy);
                        bi = r.Qp().bi(ayv.jTt, this.bJE);
                        a = a(ayv);
                        a.bWA = -1;
                        if (bi == null) {
                            r.Qp().a(a);
                        } else {
                            r.Qp().b(a);
                        }
                        lu luVar = new lu();
                        try {
                            luVar.bWi.content = ab.a(ayv.rdp);
                            if (luVar.bWi.content != null) {
                                com.tencent.mm.sdk.b.a.sFg.a(luVar, Looper.getMainLooper());
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.NetSceneGetPackageList", e.getMessage());
                        }
                    }
                } else if (this.bJE != 18) {
                    if (this.bJE == 19) {
                        Q(linkedList);
                    } else if (this.bJE == 21) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                        } else {
                            ayv = (ayv) linkedList.get(0);
                            x.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + ayv + "|id = " + ayv.jTt + "|Name = " + ayv.jPe + "|PackName = " + ayv.rwQ + "|Size = " + ayv.hcy + "|Version = " + ayv.hcD);
                            bi = r.Qp().bi(ayv.jTt, this.bJE);
                            a2 = a(ayv);
                            a2.bWA = -1;
                            if (bi == null) {
                                r.Qp().a(a2);
                            } else if (bi.version < a2.version) {
                                r.Qp().b(a2);
                            } else {
                                x.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[]{Integer.valueOf(bi.version), Integer.valueOf(a2.version)});
                            }
                        }
                    } else if (23 == this.bJE) {
                        if (linkedList == null || linkedList.size() <= 0) {
                            x.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                        } else {
                            ayv = (ayv) linkedList.get(0);
                            x.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + ayv + "|id = " + ayv.jTt + "|Name = " + ayv.jPe + "|PackName = " + ayv.rwQ + "|Size = " + ayv.hcy + "|Version = " + ayv.hcD);
                            bi = r.Qp().bi(ayv.jTt, this.bJE);
                            a2 = a(ayv);
                            a2.bWA = -1;
                            if (bi == null) {
                                r.Qp().a(a2);
                            } else if (bi.version < a2.version) {
                                r.Qp().b(a2);
                            }
                        }
                    } else if (this.bJE == 26) {
                        R(linkedList);
                    } else if (this.bJE == 36) {
                        S(linkedList);
                    } else if (this.bJE == 37) {
                        n(linkedList);
                    }
                }
            }
            sg sgVar = new sg();
            sgVar.cdb.cdc = linkedList;
            sgVar.cdb.bJE = this.bJE;
            com.tencent.mm.sdk.b.a.sFg.m(sgVar);
            if (afz.rlm <= 0) {
                this.diJ.a(i2, i3, str, this);
                return;
            } else if (a(this.dIX, this.diJ) == -1) {
                this.diJ.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    protected final boolean b(l lVar) {
        if ((lVar instanceof k) && this.bJE == ((k) lVar).bJE) {
            return false;
        }
        return true;
    }

    private void f(LinkedList<ayv> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
            return;
        }
        r.Qp();
        String Qm = n.Qm();
        for (int i = 0; i < linkedList.size(); i++) {
            ayv ayv = (ayv) linkedList.get(i);
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            if (bi == null || bi.version != ayv.hcD) {
                com.tencent.mm.a.e.deleteFile(Qm + r.Qp().bk(ayv.jTt, this.bJE));
                m a = a(ayv);
                a.bWA = -1;
                if (bi == null) {
                    r.Qp().a(a);
                } else {
                    r.Qp().b(a);
                }
                g.Eh().dpP.a(new j(a.id, 9), 0);
            }
            if (ab.a(ayv.rdp) != null) {
                x.v("MicroMsg.NetSceneGetPackageList", "xml:" + new String(ab.a(ayv.rdp)));
            }
            if (ab.a(ayv.sbD) != null) {
                x.v("MicroMsg.NetSceneGetPackageList", "xml2:" + new String(ab.a(ayv.sbD)));
            }
            x.v("MicroMsg.NetSceneGetPackageList", "xml3:" + ayv.toString());
            x.v("MicroMsg.NetSceneGetPackageList", "xml4:" + ayv.jPe);
            x.v("MicroMsg.NetSceneGetPackageList", "xml5:" + ayv.rwQ);
        }
    }

    private void g(LinkedList<ayv> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
            return;
        }
        r.Qp();
        String Qm = n.Qm();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ayv ayv = (ayv) linkedList.get(i2);
                m bi = r.Qp().bi(ayv.jTt, this.bJE);
                if (bi == null || bi.version != ayv.hcD) {
                    com.tencent.mm.a.e.deleteFile(Qm + r.Qp().bk(ayv.jTt, this.bJE));
                    m a = a(ayv);
                    a.bWA = -1;
                    if (bi == null) {
                        r.Qp().a(a);
                    } else {
                        r.Qp().b(a);
                    }
                }
                byte[] a2 = ab.a(ayv.rdp);
                if (a2 != null && a2.length > 0) {
                    r.Qp();
                    String bj = n.bj(ayv.jTt, this.bJE);
                    com.tencent.mm.a.e.deleteFile(Qm + bj);
                    com.tencent.mm.a.e.b(Qm, bj, a2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Deprecated
    private void h(LinkedList<ayv> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ayv ayv = (ayv) linkedList.get(i2);
                m bi = r.Qp().bi(ayv.jTt, this.bJE);
                m a = a(ayv);
                a.bWA = -1;
                if (bi == null) {
                    r.Qp().a(a);
                } else {
                    r.Qp().b(a);
                }
                byte[] a2 = ab.a(ayv.rdp);
                if (a2 != null && a2.length > 0) {
                    List arrayList = new ArrayList();
                    arrayList.add(new String(a2));
                    arrayList.size();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void i(LinkedList<ayv> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        r.Qp();
        String Qm = n.Qm();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ayv ayv = (ayv) linkedList.get(i2);
                m bi = r.Qp().bi(ayv.jTt, this.bJE);
                byte[] a = ab.a(ayv.rdp);
                if (ayv.rdp == null) {
                    x.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
                } else {
                    if (bi == null || bi.version != ayv.hcD) {
                        String str = new String(a);
                        String str2 = "zh_CN";
                        if (str.indexOf(str2) < 0) {
                            str2 = "en";
                            if (str.indexOf(str2) < 0) {
                                str2 = "zh_TW";
                                if (str.indexOf(str2) < 0) {
                                    str2 = "en";
                                }
                            }
                        }
                        str = str2 + "_ARTIST.mm";
                        com.tencent.mm.a.e.deleteFile(Qm + str);
                        com.tencent.mm.a.e.deleteFile(Qm + str2 + "_ARTISTF.mm");
                        com.tencent.mm.a.e.b(Qm, str, a);
                    }
                    m a2 = a(ayv);
                    a2.bWA = -1;
                    if (bi == null) {
                        r.Qp().a(a2);
                    } else {
                        r.Qp().b(a2);
                    }
                    x.d("MicroMsg.NetSceneGetPackageList", ayv.jPe + " - " + ayv.jTt + " - " + ayv.rwQ + " - " + ayv.hcy);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void j(LinkedList<ayv> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty config list");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            ayv ayv = (ayv) linkedList.get(i);
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            m a = a(ayv);
            a.bWA = -1;
            if (bi == null) {
                r.Qp().a(a);
            } else {
                r.Qp().b(a);
            }
            x.d("MicroMsg.NetSceneGetPackageList", ayv.jPe + " - " + ayv.jTt + " - " + ayv.rwQ + " - " + ayv.hcy);
            byte[] a2 = ab.a(ayv.rdp);
            x.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : " + new String(a2));
            c AU = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AU();
            int i2 = ayv.jTt;
            File file = new File(c.dgQ);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                file = new File(c.fU(i2));
                if (!file.exists()) {
                    file.createNewFile();
                }
                com.tencent.mm.a.e.b(c.fU(i2), a2, a2.length);
                AU.p(i2, new String(a2));
            } catch (Throwable e) {
                x.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[]{bi.i(e)});
            }
        }
    }

    private void k(LinkedList<ayv> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ayv ayv = (ayv) it.next();
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            m a = a(ayv);
            a.bWA = -1;
            if (bi == null) {
                r.Qp().a(a);
            } else {
                r.Qp().b(a);
            }
            x.d("MicroMsg.NetSceneGetPackageList", ayv.jPe + " - " + ayv.jTt + " - " + ayv.rwQ + " - " + ayv.hcy);
        }
    }

    private void l(LinkedList<ayv> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
            return;
        }
        x.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            ayv ayv = (ayv) linkedList.get(i);
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            m a = a(ayv);
            a.bWA = -1;
            if (bi == null) {
                r.Qp().a(a);
            } else {
                r.Qp().b(a);
            }
            g.Eh().dpP.a(new j(a.id, 12), 0);
        }
    }

    private void Q(List<ayv> list) {
        if (list == null || list.size() <= 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
            return;
        }
        r.Qp();
        String Qm = n.Qm();
        for (int i = 0; i < list.size(); i++) {
            ayv ayv = (ayv) list.get(i);
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            if (bi == null || bi.version != ayv.hcD) {
                com.tencent.mm.a.e.deleteFile(Qm + r.Qp().bk(ayv.jTt, this.bJE));
                m a = a(ayv);
                a.bWA = -1;
                if (bi == null) {
                    r.Qp().a(a);
                } else {
                    r.Qp().b(a);
                }
                g.Eh().dpP.a(new j(a.id, 19), 0);
            }
            x.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[]{ayv.jPe, ayv.rwQ});
        }
    }

    private void R(List<ayv> list) {
        if (list == null || list.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
            return;
        }
        x.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[]{Integer.valueOf(list.size())});
        int intValue = ((Integer) g.Ei().DT().get(aa.a.sQP, Integer.valueOf(-1))).intValue();
        x.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[]{Integer.valueOf(intValue)});
        if (intValue != -1) {
            m bi = r.Qp().bi(intValue, this.bJE);
            for (ayv a : list) {
                m a2 = a(a);
                x.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[]{Integer.valueOf(a2.id), Integer.valueOf(a2.version)});
                if (bi != null && a2.id == intValue) {
                    x.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
                    r.Qp().b(a2);
                    return;
                } else if (bi == null && a2.id == intValue) {
                    x.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
                    r.Qp().a(a2);
                    return;
                }
            }
        }
    }

    private void S(List<ayv> list) {
        if (list == null || list.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
            return;
        }
        x.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + list.size());
        for (ayv ayv : list) {
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            if (bi == null || bi.version != ayv.hcD) {
                m a = a(ayv);
                a.bWA = -1;
                if (bi == null) {
                    r.Qp().a(a);
                } else {
                    r.Qp().b(a);
                }
                g.Eh().dpP.a(new j(a.id, 36), 0);
            }
        }
    }

    private void m(LinkedList<ayv> linkedList) {
        x.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
        if (linkedList == null || linkedList.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ayv ayv = (ayv) it.next();
            x.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[]{ayv.toString()});
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            m a = a(ayv);
            a.bWA = -1;
            if (bi == null) {
                r.Qp().a(a);
            } else {
                r.Qp().b(a);
            }
        }
    }

    private void n(LinkedList<ayv> linkedList) {
        x.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
        if (linkedList == null || linkedList.size() == 0) {
            x.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
            return;
        }
        x.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ayv ayv = (ayv) it.next();
            m bi = r.Qp().bi(ayv.jTt, this.bJE);
            if (bi == null || bi.version != ayv.hcD) {
                m a = a(ayv);
                a.bWA = -1;
                if (bi == null) {
                    r.Qp().a(a);
                } else {
                    r.Qp().b(a);
                }
                g.Eh().dpP.a(new j(a.id, 37), 0);
            }
        }
    }

    public final int getType() {
        return 159;
    }

    public final int Lf() {
        return this.bJE;
    }
}
