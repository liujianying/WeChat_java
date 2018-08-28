package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    private static synchronized void aJ(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bi.oW(str)) {
                a gp = a.gp(str);
                if (!(gp == null || bi.oW(gp.dyk))) {
                    long j;
                    c pe = b.VQ().pe(gp.dyk);
                    String str3 = "MicroMsg.AAUtil";
                    String str4 = "insertAAMsg, billNo: %s, chatroom: %s, oldRecord: %s, insertMsg: %s, localMsgId: %s";
                    Object[] objArr = new Object[5];
                    objArr[0] = gp.dyk;
                    objArr[1] = str2;
                    objArr[2] = pe;
                    if (pe == null || !pe.field_insertmsg) {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    if (pe != null) {
                        j = pe.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr[4] = Long.valueOf(j);
                    x.i(str3, str4, objArr);
                    if (pe == null) {
                        x.e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                    } else if (!pe.field_insertmsg || pe.field_localMsgId <= 0) {
                        bd bdVar = new bd();
                        bdVar.ay(com.tencent.mm.model.bd.iD(str2));
                        bdVar.setType(436207665);
                        bdVar.setContent(q.GF() + ":\n" + str);
                        String u = g.u((bi.VF()).getBytes());
                        String fullPath = o.Pf().getFullPath(u);
                        o.Pf();
                        u = com.tencent.mm.ak.g.lM(u);
                        com.tencent.mm.ak.a.a Pj = o.Pj();
                        String str5 = gp.dxU;
                        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                        aVar.dXA = fullPath;
                        aVar.dXy = true;
                        Pj.a(str5, null, aVar.Pt());
                        bdVar.eq(u);
                        bdVar.eX(1);
                        bdVar.ep(str2);
                        bdVar.setStatus(3);
                        bdVar.setMsgId(com.tencent.mm.model.bd.i(bdVar));
                        x.i("MicroMsg.AAUtil", "finish insert aa msg");
                        a(gp.dyk, true, bdVar.field_msgId);
                        com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
                        gp.a(gVar);
                        gVar.field_msgId = bdVar.field_msgId;
                        com.tencent.mm.plugin.ac.a.bmg().b(gVar);
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, boolean z, long j) {
        synchronized (h.class) {
            if (!bi.oW(str)) {
                x.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[]{str, Boolean.valueOf(z)});
                c cVar = new c();
                cVar.field_billNo = str;
                cVar.field_insertmsg = z;
                cVar.field_localMsgId = j;
                b.VQ().b(cVar);
            }
        }
    }

    public static synchronized void aK(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bi.oW(str)) {
                a gp = a.gp(str);
                String str3 = "MicroMsg.AAUtil";
                String str4 = "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s";
                Object[] objArr = new Object[2];
                objArr[0] = gp != null ? gp.dyk : "";
                objArr[1] = str.trim().replace(" ", "");
                x.d(str3, str4, objArr);
                if (!(gp == null || bi.oW(gp.dyk))) {
                    boolean z2;
                    long j;
                    String str5 = gp.dyk;
                    c pe = b.VQ().pe(str5);
                    str4 = "MicroMsg.AAUtil";
                    String str6 = "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s";
                    Object[] objArr2 = new Object[5];
                    if (pe == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[0] = Boolean.valueOf(z2);
                    objArr2[1] = str5;
                    if (pe == null || !pe.field_insertmsg) {
                        z = false;
                    }
                    objArr2[2] = Boolean.valueOf(z);
                    objArr2[3] = str2;
                    if (pe != null) {
                        j = pe.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr2[4] = Long.valueOf(j);
                    x.i(str4, str6, objArr2);
                    if (pe != null && pe.field_insertmsg && pe.field_localMsgId > 0 && ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().dW(pe.field_localMsgId).field_msgId <= 0) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                        b.VQ().a(pe, new String[0]);
                    } else if (pe == null || !pe.field_insertmsg || pe.field_localMsgId <= 0) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                        aJ(str, str2);
                    } else {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                        f(pe.field_localMsgId, str);
                    }
                }
            }
        }
    }

    public static synchronized void v(String str, String str2, String str3) {
        synchronized (h.class) {
            x.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[]{str, str2, Boolean.valueOf(bi.oW(str3)), b.VQ().pe(str)});
            if (b.VQ().pe(str) == null) {
                a(str, false, 0);
            }
            aK(str3, str2);
        }
    }

    public static synchronized void c(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        synchronized (h.class) {
            x.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", new Object[]{str, str3, str4});
            if (!(bi.oW(str) || bi.oW(str3) || bi.oW(str4))) {
                com.tencent.mm.plugin.aa.a.b.a pd = b.VR().pd(str4);
                String str6 = "MicroMsg.AAUtil";
                String str7 = "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = pd;
                if (pd == null || !pd.field_insertmsg) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                x.i(str6, str7, objArr);
                if (pd == null || !pd.field_insertmsg) {
                    String str8 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (bi.oW(str5)) {
                        x.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (str.equals(q.GF())) {
                            str5 = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.pay_sys_msg_tmpl_launch_by_myself, new Object[]{str8});
                        } else {
                            String displayName = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(str, str2);
                            str5 = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.pay_sys_msg_tmpl_launch_by_other, new Object[]{displayName, str8});
                        }
                    } else {
                        x.d("MicroMsg.AAUtil", "insert msgxml: %s", new Object[]{str5});
                    }
                    a(str5, str2, pd, str4);
                }
            }
        }
    }

    public static synchronized void w(String str, String str2, String str3) {
        synchronized (h.class) {
            try {
                if (!(bi.oW(str) || bi.oW(str2) || bi.oW(str3))) {
                    x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[]{str2, str3});
                    com.tencent.mm.plugin.aa.a.b.a pd = b.VR().pd(str3);
                    if (pd == null || !pd.field_insertmsg) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        a(str, str2, pd, str3);
                    } else {
                        bd dW = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().dW(pd.field_msgId);
                        x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[]{Long.valueOf(pd.field_msgId), Long.valueOf(dW.field_msgId)});
                        dW.setContent(str);
                        ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().a(pd.field_msgId, dW);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[]{e.getMessage()});
            }
        }
        return;
    }

    private static synchronized void a(String str, String str2, com.tencent.mm.plugin.aa.a.b.a aVar, String str3) {
        synchronized (h.class) {
            bd bdVar = new bd();
            bdVar.eX(0);
            bdVar.ep(str2);
            bdVar.setStatus(3);
            bdVar.setContent(str);
            bdVar.ay(com.tencent.mm.model.bd.o(str2, System.currentTimeMillis() / 1000));
            bdVar.setType(10000);
            long T = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().T(bdVar);
            x.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[]{Long.valueOf(T)});
            if (aVar == null) {
                aVar = new com.tencent.mm.plugin.aa.a.b.a();
            }
            if (T > 0) {
                aVar.field_payMsgId = str3;
                aVar.field_chatroom = str2;
                aVar.field_insertmsg = true;
                aVar.field_msgId = T;
                b.VR().a(aVar);
            }
        }
    }

    public static synchronized void f(long j, String str) {
        synchronized (h.class) {
            if (j > 0) {
                if (!bi.oW(str)) {
                    a gp = a.gp(str);
                    if (gp == null || bi.oW(gp.dyk)) {
                        x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[]{Long.valueOf(j)});
                    } else {
                        x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), gp.dyk});
                        c pe = b.VQ().pe(gp.dyk);
                        if (pe != null) {
                            long j2 = pe.field_localMsgId;
                            bd dW = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().dW(j2);
                            if (dW.field_msgId > 0) {
                                dW.setContent(com.tencent.mm.model.bd.iB(dW.field_content) + ":\n" + str);
                                ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().a(j2, dW);
                                x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[]{Long.valueOf(j2), pe.field_billNo});
                            } else {
                                x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[]{pe.field_billNo, Long.valueOf(pe.field_localMsgId), Long.valueOf(j), Long.valueOf(dW.field_msgId)});
                            }
                        } else {
                            pe = new c();
                            pe.field_localMsgId = j;
                            pe.field_billNo = gp.dyk;
                            pe.field_insertmsg = true;
                            b.VQ().a(pe);
                            x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), gp.dyk});
                        }
                    }
                }
            }
            x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[]{Long.valueOf(j), Boolean.valueOf(bi.oW(str))});
        }
    }

    public static void g(long j, String str) {
        x.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[]{Long.valueOf(j), str});
        bd dW = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().dW(j);
        String pa = pa(str);
        if (!bi.oW(pa)) {
            dW.setContent(pa);
        }
        ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().a(j, dW);
    }

    public static boolean a(Activity activity, y yVar) {
        if (yVar.qYW == 1) {
            x.i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            String str = yVar.kRt;
            str = yVar.kRu;
            str = yVar.kRv;
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, 0);
        } else if (yVar.qYW == 2) {
            x.i("MicroMsg.AAUtil", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, yVar.kRt, yVar.kRw, yVar.kRu, yVar.kRv, false, null);
        } else {
            x.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + yVar.qYW);
            return false;
        }
    }

    private static String pa(String str) {
        String str2;
        UnsupportedEncodingException e;
        Map z = bl.z(str, "sysmsg");
        if (z == null) {
            return "";
        }
        str2 = (String) z.get(".sysmsg.paymsg.appmsgcontent");
        if (bi.oW(str2)) {
            x.e("MicroMsg.AAUtil", "empty appmsgcontent!");
            return "";
        }
        String str3 = "";
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
            try {
                x.d("MicroMsg.AAUtil", "msgContent: %s", new Object[]{str2});
                return str2;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            str2 = str3;
        }
        x.e("MicroMsg.AAUtil", e.getMessage());
        return str2;
    }

    public static double a(String str, String str2, int i, int i2) {
        try {
            return new BigDecimal(bi.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), i, i2).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0.0d;
        }
    }

    public static long aL(String str, String str2) {
        try {
            double d = bi.getDouble(str, 0.0d);
            double d2 = bi.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = "0";
            }
            return bigDecimal.multiply(new BigDecimal(str2)).longValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0;
        }
    }

    public static List<String> pb(String str) {
        List<String> il;
        if (bi.oW(str)) {
            x.i("MicroMsg.AAUtil", "illegal chatroomName");
            return new ArrayList();
        } else if (s.fq(str)) {
            try {
                il = ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().il(str);
                if (il == null) {
                    return new ArrayList();
                }
                return il;
            } catch (Exception e) {
                x.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[]{e.getMessage()});
                return new ArrayList();
            }
        } else {
            il = new ArrayList();
            il.add(q.GF());
            il.add(str);
            return il;
        }
    }

    public static String VZ() {
        com.tencent.mm.kernel.g.Ek();
        return bi.oV((String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sXI, null));
    }

    public static void pc(String str) {
        String VZ = VZ();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        if (!bi.oW(VZ)) {
            String[] split = VZ.split(",");
            int i = 1;
            for (String str2 : split) {
                if (!str2.equals(str) && i < 5) {
                    stringBuilder.append(str2);
                    stringBuilder.append(",");
                    i++;
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        x.d("MicroMsg.AAUtil", "recent group: %s", new Object[]{stringBuilder.toString()});
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sXI, stringBuilder.toString());
    }
}
