package com.tencent.mm.pluginsdk.wallet;

import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import java.util.List;

public final class e {
    public static String Uk(String str) {
        List<bd> Hd = ((i) g.l(i.class)).bcY().Hd(str);
        if (Hd != null) {
            x.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", new Object[]{Integer.valueOf(Hd.size())});
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (bd bdVar : Hd) {
                if (af(bdVar)) {
                    if (bdVar.getType() == 419430449) {
                        i++;
                    } else if (bdVar.getType() == 436207665) {
                        g$a gp;
                        String str2 = bdVar.field_content;
                        if (str2 != null) {
                            gp = g$a.gp(str2);
                        } else {
                            gp = null;
                        }
                        if (gp != null) {
                            if ("1001".equals(gp.dyb)) {
                                i2++;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                i3 = i3;
            }
            if (i3 > 0 || i2 > 0 || i > 0) {
                if (s.fq(str)) {
                    return ad.getContext().getString(h.wallet_delete_note_aa_stub, new Object[]{Integer.valueOf(i2)});
                } else if (i3 > 0 && i <= 0) {
                    return ad.getContext().getString(h.wallet_delete_note_luckymoney_stub, new Object[]{Integer.valueOf(i3)});
                } else if (i > 0 && i3 <= 0) {
                    return ad.getContext().getString(h.wallet_delete_note_remittance_stub, new Object[]{Integer.valueOf(i)});
                } else if (i > 0 && i3 > 0) {
                    return ad.getContext().getString(h.wallet_delete_note_luckymoney_remittance_stub, new Object[]{Integer.valueOf(i3), Integer.valueOf(i)});
                }
            }
        }
        return null;
    }

    public static boolean af(bd bdVar) {
        g$a g_a = null;
        String str;
        int i;
        if (bdVar.getType() == 419430449) {
            if (bdVar.field_isSend == 0) {
                g$a J;
                str = bdVar.field_content;
                if (str != null) {
                    J = g$a.J(str, bdVar.field_reserved);
                } else {
                    J = null;
                }
                if (J != null) {
                    tj tjVar = new tj();
                    tjVar.ceU.bXz = J.dxB;
                    a.sFg.m(tjVar);
                    i = tjVar.ceV.status;
                    if (i <= 0) {
                        i = J.dxy;
                    }
                    if (i >= 0 && (i == 1 || i == 7)) {
                        return true;
                    }
                }
            }
        } else if (bdVar.getType() == 436207665 && bdVar.field_isSend == 0) {
            str = bdVar.field_content;
            if (str != null) {
                g_a = g$a.gp(str);
            }
            if (g_a != null) {
                if (!"1001".equals(g_a.dyb) && !s.fq(bdVar.field_talker)) {
                    ti tiVar = new ti();
                    if (!bi.oW(g_a.dyc)) {
                        tiVar.ceP.ceR = g_a.dyc;
                        a.sFg.m(tiVar);
                        if (tiVar.ceQ.ceT == 0) {
                            return true;
                        }
                    }
                } else if (s.fq(bdVar.field_talker)) {
                    int i2;
                    str = q.GF();
                    if (!bi.cX(g_a.dyr)) {
                        for (String split : g_a.dyr) {
                            String[] split2 = split.split(",");
                            if (split2.length == 3 && split2[0].equals(str)) {
                                i = bi.getInt(split2[2], -1);
                                i2 = 1;
                                break;
                            }
                        }
                    }
                    i = 0;
                    i2 = 0;
                    if (i2 != 0 && r0 == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
