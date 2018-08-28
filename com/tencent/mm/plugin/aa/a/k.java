package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.aa.a.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import java.util.List;
import java.util.Map;

public final class k implements e {
    public static String eAA = "totalUserNumber";
    public static String eAB = "perAmount";
    public static String eAC = "chatRoomName";
    public static String eAD = "launchScene";
    public static String eAE = "payerlist";
    public static String eAF = "timestamp";
    private static int eAG = 131100026;
    public static String eAy = "title";
    public static String eAz = "totalPayAmount";
    private b dIz;
    private boolean eAH = false;
    private Map<String, Object> eAI;
    private int mode = 0;

    public final boolean c(int i, Map<String, Object> map) {
        this.dIz = g.cBF();
        if (this.eAH) {
            x.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.dIz.ct(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.dIz.ct(Boolean.valueOf(false));
            return false;
        } else {
            x.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[]{map.keySet()});
            this.eAH = true;
            this.eAI = map;
            this.mode = i;
            String str;
            long longValue;
            int intValue;
            String str2;
            long longValue2;
            int i2;
            if (i == a.ezC) {
                if (this.eAI.containsKey(eAy) && this.eAI.containsKey(eAB) && this.eAI.containsKey(eAA) && this.eAI.containsKey(eAD) && this.eAI.containsKey(eAC) && this.eAI.containsKey(eAF)) {
                    try {
                        str = (String) this.eAI.get(eAy);
                        longValue = ((Long) this.eAI.get(eAB)).longValue();
                        int intValue2 = ((Integer) this.eAI.get(eAA)).intValue();
                        intValue = ((Integer) this.eAI.get(eAD)).intValue();
                        str2 = (String) this.eAI.get(eAC);
                        longValue2 = ((Long) this.eAI.get(eAF)).longValue();
                        x.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Eh().dpP.a(new f(longValue, str, intValue2, intValue, longValue2, str2), 0);
                        if (intValue2 > 0 && intValue2 <= 10) {
                            i2 = 13;
                        } else if (intValue2 > 10 && intValue2 <= 20) {
                            i2 = 14;
                        } else if (intValue2 <= 20 || intValue2 > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        h.mEJ.a(407, (long) i2, 1, false);
                        this.dIz.cBE();
                        return true;
                    } catch (Exception e) {
                        x.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[]{e.getMessage()});
                        this.dIz.ct(Boolean.valueOf(false));
                        this.eAH = false;
                        return false;
                    }
                }
                this.dIz.ct(Boolean.valueOf(false));
                this.eAH = false;
                return false;
            } else if (i != a.ezD) {
                return false;
            } else {
                if (this.eAI.containsKey(eAy) && this.eAI.containsKey(eAB) && this.eAI.containsKey(eAE) && this.eAI.containsKey(eAD) && this.eAI.containsKey(eAC) && this.eAI.containsKey(eAF)) {
                    try {
                        str = (String) this.eAI.get(eAy);
                        longValue = ((Long) this.eAI.get(eAB)).longValue();
                        List list = (List) this.eAI.get(eAE);
                        intValue = ((Integer) this.eAI.get(eAD)).intValue();
                        str2 = (String) this.eAI.get(eAC);
                        longValue2 = ((Long) this.eAI.get(eAF)).longValue();
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Eh().dpP.a(new f(longValue, str, list, intValue, longValue2, str2), 0);
                        i2 = list.size();
                        if (i2 > 0 && i2 <= 10) {
                            i2 = 13;
                        } else if (i2 > 10 && i2 <= 20) {
                            i2 = 14;
                        } else if (i2 <= 20 || i2 > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        h.mEJ.a(407, (long) i2, 1, false);
                        this.dIz.cBE();
                        return true;
                    } catch (Exception e2) {
                        x.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[]{e2.getMessage()});
                        this.dIz.ct(Boolean.valueOf(false));
                        this.eAH = false;
                        return false;
                    }
                }
                this.dIz.ct(Boolean.valueOf(false));
                this.eAH = false;
                return false;
            }
        }
    }

    public final boolean t(Map<String, Object> map) {
        this.dIz = g.cBF();
        x.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
        if (this.eAH) {
            x.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.dIz.ct(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.dIz.ct(Boolean.valueOf(false));
            return false;
        } else {
            this.eAH = true;
            this.eAI = map;
            this.mode = a.ezE;
            if (this.mode != a.ezE) {
                this.dIz.ct(Boolean.valueOf(false));
                return false;
            }
            if (this.eAI.containsKey(eAy) && this.eAI.containsKey(eAz) && this.eAI.containsKey(eAE) && this.eAI.containsKey(eAD) && this.eAI.containsKey(eAC) && this.eAI.containsKey(eAF)) {
                try {
                    String str = (String) this.eAI.get(eAy);
                    long longValue = ((Long) this.eAI.get(eAz)).longValue();
                    List list = (List) this.eAI.get(eAE);
                    int intValue = ((Integer) this.eAI.get(eAD)).intValue();
                    String str2 = (String) this.eAI.get(eAC);
                    long longValue2 = ((Long) this.eAI.get(eAF)).longValue();
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.plugin.aa.a.a.g(str, longValue, list, intValue, str2, longValue2), 0);
                    int size = list.size();
                    size = (size <= 0 || size > 10) ? (size <= 10 || size > 20) ? (size <= 20 || size > 50) ? 20 : 19 : 18 : 17;
                    h.mEJ.a(407, (long) size, 1, false);
                    this.dIz.cBE();
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
                }
            }
            this.dIz.ct(Boolean.valueOf(false));
            this.eAH = false;
            return false;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), lVar, Integer.valueOf(this.mode)});
        String str2;
        String str3;
        Object[] objArr;
        y yVar;
        if (lVar.getType() == 1624) {
            this.eAH = false;
            if (i == 0 && i2 == 0) {
                f fVar = (f) lVar;
                com.tencent.mm.protocal.c.g gVar = fVar.eAR;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(gVar.hUm);
                objArr[1] = gVar.hUn;
                objArr[2] = Boolean.valueOf(gVar.qYe == null);
                objArr[3] = gVar.qYc;
                x.i(str2, str3, objArr);
                if (gVar.hUm == 0) {
                    if (gVar.qYe != null) {
                        h.v(gVar.qYc, fVar.chatroomName, gVar.qYe);
                        g.a(this.dIz, new Object[]{Boolean.valueOf(true)});
                    } else {
                        h.a(gVar.qYc, false, 0);
                        g.a(this.dIz, new Object[]{Boolean.valueOf(true)});
                    }
                    h.pc(fVar.chatroomName);
                    h.mEJ.a(407, 0, 1, false);
                    return;
                }
                if (this.dIz != null) {
                    if (gVar.hUm > 0) {
                        yVar = gVar.qYk;
                        if (yVar != null && yVar.qYW > 0) {
                            this.dIz.ct(yVar);
                        } else if (bi.oW(gVar.hUn)) {
                            this.dIz.ct(Boolean.valueOf(false));
                        } else {
                            this.dIz.ct(gVar.hUn);
                        }
                    } else {
                        this.dIz.ct(Boolean.valueOf(false));
                    }
                }
                h.mEJ.a(407, 2, 1, false);
                return;
            }
            if (this.dIz != null) {
                this.dIz.ct(Boolean.valueOf(false));
            }
            h.mEJ.a(407, 1, 1, false);
        } else if (lVar.getType() == 1655) {
            this.eAH = false;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.aa.a.a.g gVar2 = (com.tencent.mm.plugin.aa.a.a.g) lVar;
                i iVar = gVar2.eAT;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(iVar.hUm);
                objArr[1] = iVar.hUn;
                objArr[2] = Boolean.valueOf(iVar.qYe == null);
                x.i(str2, str3, objArr);
                x.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[]{iVar.hUn, iVar.qYc});
                if (iVar.hUm == 0) {
                    if (iVar.qYe != null) {
                        h.v(iVar.qYc, gVar2.chatroomName, iVar.qYe);
                        g.a(this.dIz, new Object[]{Boolean.valueOf(true), iVar.qYc});
                    } else {
                        h.a(iVar.qYc, false, 0);
                        g.a(this.dIz, new Object[]{Boolean.valueOf(true), iVar.qYc});
                    }
                    h.pc(gVar2.chatroomName);
                    h.mEJ.a(407, 3, 1, false);
                    return;
                }
                if (iVar.hUm > 0) {
                    yVar = iVar.qYk;
                    if (yVar != null && yVar.qYW > 0) {
                        this.dIz.ct(yVar);
                    } else if (bi.oW(iVar.hUn)) {
                        this.dIz.ct(Boolean.valueOf(false));
                    } else {
                        this.dIz.ct(iVar.hUn);
                    }
                } else {
                    this.dIz.ct(Boolean.valueOf(false));
                }
                h.mEJ.a(407, 5, 1, false);
                return;
            }
            if (this.dIz != null) {
                this.dIz.ct(Boolean.valueOf(false));
            }
            h.mEJ.a(407, 4, 1, false);
        }
    }
}
