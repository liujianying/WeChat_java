package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class h {
    private static final f<Integer, c> dzj = new f(32);

    public static String a(String str, String str2, wl wlVar, String str3) {
        if (wlVar == null || wlVar.rBI == null) {
            x.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
            return "";
        }
        List list = wlVar.rBI;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bi.WS(str)).append("</title>");
        stringBuilder.append("<desc>").append(bi.WS(str2)).append("</desc>");
        a(stringBuilder, wlVar);
        stringBuilder.append(i.bc(list));
        stringBuilder.append("<favusername>").append(bi.WS(str3)).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        g$a g_a = new g$a();
        g_a.title = str;
        g_a.description = str2;
        if (bi.oW(((vx) list.get(0)).rzD) || !((vx) list.get(0)).rzD.equals(".htm")) {
            g_a.type = 19;
            g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            g_a.type = 24;
            g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        g_a.action = "view";
        g_a.dwW = stringBuilder.toString();
        return g$a.a(g_a, null, null);
    }

    public static g$a a(String str, String str2, wl wlVar) {
        List list = wlVar.rBI;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bi.WS(str)).append("</title>");
        stringBuilder.append("<desc>").append(bi.WS(str2)).append("</desc>");
        a(stringBuilder, wlVar);
        stringBuilder.append(i.bc(list));
        stringBuilder.append("<favusername>").append(bi.WS(q.GF())).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        g$a g_a = new g$a();
        g_a.title = str;
        if (str2 != null && str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        g_a.description = str2;
        if (bi.cX(list) || bi.oW(((vx) list.get(0)).rzD) || !((vx) list.get(0)).rzD.equals(".htm")) {
            g_a.type = 19;
            g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            g_a.type = 24;
            g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        g_a.action = "view";
        g_a.dwW = stringBuilder.toString();
        return g_a;
    }

    private static void a(StringBuilder stringBuilder, wl wlVar) {
        if (wlVar.qYa != null) {
            stringBuilder.append("<noteinfo>");
            stringBuilder.append("<noteauthor>").append(bi.WS(wlVar.qYa.rBz)).append("</noteauthor>");
            stringBuilder.append("<noteeditor>").append(bi.WS(wlVar.qYa.rBA)).append("</noteeditor>");
            stringBuilder.append("</noteinfo>");
            stringBuilder.append("<edittime>").append(wlVar.qYb).append("</edittime>");
        }
    }

    public static int a(Context context, String str, String str2, List<bd> list, ch chVar, d dVar) {
        if (bi.oW(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else {
            if (chVar == null || dVar == null) {
                ch chVar2 = new ch();
                if (!g.a(context, chVar2, str2, list, true, true)) {
                    return -1;
                }
                dVar = a(context, chVar2, str2);
                chVar = chVar2;
            }
            g$a a = a(dVar.title, dVar.desc, chVar.bJF.bJH);
            bd bdVar = new bd();
            byte[] bArr = null;
            if (!bi.oW(dVar.bOX)) {
                bArr = bi.readFromFile(dVar.bOX);
            } else if (dVar.bXP == 0 && !bi.oW(dVar.jap)) {
                bArr = com.tencent.mm.sdk.platformtools.c.Q(com.tencent.mm.aa.c.a(dVar.jap, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 32768) {
                    a2 = o.Pf().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.Pf().g(8, bArr);
                }
                x.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + " thumbData MsgInfo path:" + a2);
                if (!bi.oW(a2)) {
                    bdVar.eq(a2);
                }
            }
            bdVar.setContent(g$a.a(a, null, null));
            bdVar.setStatus(1);
            bdVar.ep(str);
            bdVar.ay(com.tencent.mm.model.bd.iD(str));
            bdVar.eX(1);
            bdVar.setType(49);
            if (com.tencent.mm.ac.f.eZ(str)) {
                bdVar.dt(e.Ir());
            }
            au.HU();
            long T = com.tencent.mm.model.c.FT().T(bdVar);
            x.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + " msginfo insert id: " + T);
            if (T < 0) {
                x.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + "insert msg failed :" + T);
                return 0 - com.tencent.mm.compatible.util.g.getLine();
            }
            x.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + T);
            bdVar.setMsgId(T);
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            gVar.field_xml = bdVar.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = T;
            ao.cbY().b(gVar);
            Iterator it = chVar.bJF.bJH.rBI.iterator();
            boolean z = false;
            while (it.hasNext()) {
                vx vxVar = (vx) it.next();
                String obj = vxVar.toString();
                vxVar.UO(com.tencent.mm.a.g.u((obj + vxVar.bjS + System.currentTimeMillis()).getBytes()));
                if (z || com.tencent.mm.a.e.cn(vxVar.rzM) || com.tencent.mm.a.e.cn(vxVar.rzO) || !bi.oW(vxVar.rzo) || !bi.oW(vxVar.dwE) || !bi.oW(vxVar.rAG) || !bi.oW(vxVar.dwv)) {
                    z = true;
                }
            }
            x.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                com.tencent.mm.plugin.record.a.g gVar2 = new com.tencent.mm.plugin.record.a.g();
                gVar2.field_msgId = T;
                gVar2.field_title = a.title;
                gVar2.field_desc = a.description;
                gVar2.field_toUser = str;
                gVar2.field_dataProto = chVar.bJF.bJH;
                gVar2.field_type = 3;
                gVar2.field_localId = new Random().nextInt(2147483645) + 1;
                x.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[]{Boolean.valueOf(n.bqv().b(gVar2)), Long.valueOf(T), Integer.valueOf(gVar2.field_localId)});
                n.bqw().a(gVar2);
            } else {
                x.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[]{Long.valueOf(T)});
                ao.cca();
                a.fM(T);
            }
            return 0;
        }
    }

    public static d a(Context context, ch chVar, String str) {
        String str2;
        int i = 0;
        d dVar = new d();
        SparseIntArray sparseIntArray = new SparseIntArray();
        if (com.tencent.mm.ac.f.eZ(str)) {
            dVar.title = chVar.bJF.bJH.title;
        } else if (s.fq(str)) {
            dVar.title = context.getString(R.l.record_chatroom_title);
        } else {
            if (q.GH().equals(r.gS(str))) {
                dVar.title = context.getString(R.l.favorite_record_chatroom_title, new Object[]{q.GH()});
            } else {
                dVar.title = context.getString(R.l.favorite_record_chat_title, new Object[]{q.GH(), r.gS(str)});
            }
        }
        x.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[]{dVar.title});
        List linkedList = new LinkedList();
        List list;
        if (chVar.bJF.bJH != null) {
            list = chVar.bJF.bJH.rBI;
        } else {
            list = new LinkedList();
        }
        for (vx vxVar : list) {
            sparseIntArray.put(vxVar.bjS, sparseIntArray.get(vxVar.bjS) + 1);
            switch (vxVar.bjS) {
                case 1:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(vxVar.rAk + ":" + vxVar.desc + "\n");
                    break;
                case 2:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_pic) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.g.app_attach_file_icon_pic);
                    i = 1;
                    break;
                case 3:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_voice) + "\n");
                    break;
                case 4:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_video) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.k.app_attach_file_icon_video);
                    i = 1;
                    break;
                case 5:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_url) + vxVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.k.app_attach_file_icon_webpage);
                    i = 1;
                    break;
                case 6:
                    if (linkedList.size() < 5) {
                        we weVar = vxVar.rAi.rAL;
                        StringBuilder append = new StringBuilder().append(vxVar.rAk).append(":").append(context.getString(R.l.app_location));
                        str2 = (bi.oW(weVar.bWB) || weVar.bWB.equals(context.getString(R.l.location_selected))) ? weVar.label : weVar.bWB;
                        linkedList.add(append.append(str2).append("\n").toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    dVar.bXP = R.k.app_attach_file_icon_location;
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_music) + vxVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.k.app_attach_file_icon_music);
                    i = 1;
                    break;
                case 8:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_file) + vxVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.k.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_product) + vxVar.rAi.rAP.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.k.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 14:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_app) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.k.app_attach_file_icon_unknow);
                    i = 1;
                    break;
                case 15:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_video) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, vxVar, R.k.app_attach_file_icon_video);
                    i = 1;
                    break;
                case 16:
                    if (linkedList.size() < 5) {
                        linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_friend_card) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    au.HU();
                    dVar.jap = com.tencent.mm.model.c.FT().GR(vxVar.desc).otZ;
                    i = 1;
                    break;
                case 17:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_record) + "\n");
                    break;
                case 19:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(vxVar.rAk + ":" + context.getString(R.l.app_app_brand) + vxVar.title + "\n");
                    break;
                default:
                    break;
            }
        }
        str2 = "";
        dVar.desc = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str3 = str2;
            if (it.hasNext()) {
                str2 = str3 + ((String) it.next());
            } else {
                str2 = str3.trim();
                if (linkedList.size() >= 5) {
                    str2 = str2 + "...";
                }
                dVar.desc = str2;
                return dVar;
            }
        }
    }

    private static void a(d dVar, vx vxVar, int i) {
        String str = vxVar.rzO;
        if (com.tencent.mm.a.e.cn(str)) {
            dVar.bOX = str;
        } else {
            dVar.bXP = i;
        }
    }

    public static int a(String str, String str2, bd bdVar) {
        if (bi.oW(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (bdVar == null || bi.oW(bdVar.field_content)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else if (1 == bdVar.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            return -1;
        } else {
            for (String str3 : bi.F(str.split(","))) {
                x.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[]{str3, Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.field_status)});
                String iC = com.tencent.mm.model.bd.iC(bdVar.field_content);
                g$a gp = g$a.gp(iC);
                if (gp == null) {
                    x.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    return -1;
                }
                c Ks = Ks(gp.dwW);
                if (Ks == null) {
                    x.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    return -1;
                }
                bd bdVar2 = new bd();
                if (!bi.oW(bdVar.field_imgPath)) {
                    String g = o.Pf().g(8, bi.readFromFile(o.Pf().E(bdVar.field_imgPath, true)));
                    x.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + " thumbData from msg MsgInfo path:" + g);
                    if (!bi.oW(g)) {
                        bdVar2.eq(g);
                    }
                }
                bdVar2.setContent(iC);
                bdVar2.setStatus(1);
                bdVar2.ep(str3);
                bdVar2.ay(com.tencent.mm.model.bd.iD(str3));
                bdVar2.eX(1);
                bdVar2.setType(49);
                au.HU();
                long T = com.tencent.mm.model.c.FT().T(bdVar2);
                x.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + " msginfo insert id: " + T);
                if (T < 0) {
                    x.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + "insert msg failed :" + T);
                    return 0 - com.tencent.mm.compatible.util.g.getLine();
                }
                Object obj;
                x.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + T);
                bdVar2.setMsgId(T);
                sc scVar = new sc();
                scVar.ccT.ccU = bdVar.field_msgId;
                scVar.ccT.ccV = T;
                com.tencent.mm.sdk.b.a.sFg.m(scVar);
                com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
                gVar.field_xml = bdVar2.field_content;
                gVar.field_title = gp.title;
                gVar.field_type = gp.type;
                gVar.field_description = gp.description;
                gVar.field_msgId = T;
                ao.cbY().b(gVar);
                Iterator it = Ks.dzs.iterator();
                while (it.hasNext()) {
                    vx vxVar = (vx) it.next();
                    if (bi.oW(vxVar.rzo) && bi.oW(vxVar.dwE) && bi.oW(vxVar.rAG)) {
                        if (!bi.oW(vxVar.dwv)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = 1;
                    break;
                }
                obj = null;
                if (obj != null) {
                    com.tencent.mm.plugin.record.a.g gVar2 = new com.tencent.mm.plugin.record.a.g();
                    wl wlVar = new wl();
                    wlVar.rBI.addAll(Ks.dzs);
                    gVar2.field_msgId = T;
                    gVar2.field_oriMsgId = bdVar.field_msgId;
                    gVar2.field_toUser = str3;
                    gVar2.field_title = gp.title;
                    gVar2.field_desc = bi.aG(Ks.desc, gp.description);
                    gVar2.field_dataProto = wlVar;
                    gVar2.field_type = 0;
                    gVar2.field_favFrom = Ks.qXZ;
                    gVar2.field_localId = new Random().nextInt(2147483645) + 1;
                    n.bqv().b(gVar2);
                    n.bqw().a(gVar2);
                } else {
                    x.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    ao.cca();
                    a.fM(T);
                }
                if (!bi.oW(str2)) {
                    com.tencent.mm.plugin.messenger.a.g.bcT().D(str3, str2, s.hQ(str3));
                }
            }
            return 0;
        }
    }

    public static int a(String str, wl wlVar, String str2, String str3, String str4, int i, String str5) {
        if (bi.oW(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (wlVar == null || wlVar.rBI.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            return -1;
        } else {
            g$a a = a(str2, str3, wlVar);
            bd bdVar = new bd();
            byte[] bArr = null;
            if (!bi.oW(str4)) {
                bArr = bi.readFromFile(str4);
            } else if (i != 0) {
                bArr = com.tencent.mm.sdk.platformtools.c.Q(com.tencent.mm.sdk.platformtools.c.CV(i));
            } else if (!bi.oW(str5)) {
                bArr = com.tencent.mm.sdk.platformtools.c.Q(com.tencent.mm.aa.c.a(str5, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > 32768) {
                    a2 = o.Pf().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.Pf().g(8, bArr);
                }
                x.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + " thumbData MsgInfo path:" + a2);
                if (!bi.oW(a2)) {
                    bdVar.eq(a2);
                }
            }
            bdVar.setContent(g$a.a(a, null, null));
            bdVar.setStatus(1);
            bdVar.ep(str);
            bdVar.ay(com.tencent.mm.model.bd.iD(str));
            bdVar.eX(1);
            bdVar.setType(49);
            if (com.tencent.mm.ac.f.eZ(str)) {
                bdVar.dt(e.Ir());
            }
            au.HU();
            long T = com.tencent.mm.model.c.FT().T(bdVar);
            x.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + " msginfo insert id: " + T);
            if (T < 0) {
                x.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ac() + "insert msg failed :" + T);
                return 0 - com.tencent.mm.compatible.util.g.getLine();
            }
            x.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + T);
            bdVar.setMsgId(T);
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            gVar.field_xml = bdVar.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = T;
            ao.cbY().b(gVar);
            Iterator it = wlVar.rBI.iterator();
            while (it.hasNext()) {
                vx vxVar = (vx) it.next();
                if (bi.oW(vxVar.rzo)) {
                    if (!bi.oW(vxVar.dwE)) {
                        break;
                    }
                }
                break;
            }
            com.tencent.mm.plugin.record.a.g gVar2 = new com.tencent.mm.plugin.record.a.g();
            gVar2.field_msgId = T;
            gVar2.field_title = a.title;
            gVar2.field_desc = a.description;
            gVar2.field_toUser = str;
            gVar2.field_dataProto = wlVar;
            gVar2.field_type = 1;
            gVar2.field_localId = new Random().nextInt(2147483645) + 1;
            n.bqv().b(gVar2);
            n.bqw().a(gVar2);
            return 0;
        }
    }

    private static File ep(long j) {
        r2 = new Object[2];
        au.HU();
        r2[0] = com.tencent.mm.model.c.Gm();
        r2[1] = Long.valueOf(j);
        File file = new File(String.format("%s/%d/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static void eq(long j) {
        boolean k = com.tencent.mm.a.e.k(ep(j));
        x.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[]{r0.getAbsolutePath(), Boolean.valueOf(k)});
    }

    public static String c(vx vxVar, long j) {
        int i = 1;
        if (vxVar == null) {
            return "";
        }
        String str = vxVar.jdM;
        if (bi.oW(str) || !au.HX()) {
            return "";
        }
        File ep = ep(j);
        if (vxVar.bjS != 8 || bi.oW(vxVar.title)) {
            i = 0;
        } else {
            str = vxVar.title;
            int hashCode = vxVar.jdM.hashCode() & 255;
            r6 = new Object[3];
            au.HU();
            r6[0] = com.tencent.mm.model.c.Gm();
            r6[1] = Long.valueOf(j);
            r6[2] = Integer.valueOf(hashCode);
            ep = new File(String.format("%s/%d/%d/", r6));
            if (!(ep.exists() && ep.isDirectory())) {
                ep.mkdirs();
            }
        }
        if (vxVar.rzD != null && vxVar.rzD.trim().length() > 0 && i == 0) {
            str = str + "." + vxVar.rzD;
        }
        return new File(ep, str).getAbsolutePath();
    }

    public static boolean d(vx vxVar, long j) {
        return new File(c(vxVar, j)).exists();
    }

    public static boolean e(vx vxVar, long j) {
        return new File(f(vxVar, j)).exists();
    }

    public static String f(vx vxVar, long j) {
        if (vxVar == null || bi.oW(vxVar.jdM)) {
            return "";
        }
        return new File(ep(j), Ba(vxVar.jdM)).getAbsolutePath();
    }

    public static String Ba(String str) {
        return str + "_t";
    }

    public static String e(String str, long j, boolean z) {
        if (z) {
            return str + "@record_download@" + j;
        }
        return str + "@record_upload@" + j;
    }

    public static c Ks(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.RecordMsgLogic", "xml is null");
            return null;
        }
        int hashCode = str.hashCode();
        c cVar = (c) dzj.get(Integer.valueOf(hashCode));
        if (cVar != null) {
            x.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            return cVar;
        }
        Map z;
        if (str.trim().contains("<recordinfo>")) {
            z = bl.z(str, "recordinfo");
        } else {
            z = bl.z("<recordinfo>" + str + "</recordinfo>", "recordinfo");
        }
        if (z == null) {
            x.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[]{str});
            return null;
        }
        c cVar2 = new c();
        cVar2.title = (String) z.get(".recordinfo.title");
        cVar2.desc = (String) z.get(".recordinfo.desc");
        cVar2.qXZ = (String) z.get(".recordinfo.favusername");
        if (z.get(".recordinfo.noteinfo") != null) {
            wf wfVar = new wf();
            wfVar.rBA = (String) z.get(".recordinfo.noteinfo.noteeditor");
            wfVar.rBz = (String) z.get(".recordinfo.noteinfo.noteauthor");
            cVar2.qYa = wfVar;
            cVar2.qYb = bi.getLong((String) z.get(".recordinfo.edittime"), 0);
        }
        a(str, cVar2);
        dzj.put(Integer.valueOf(hashCode), cVar2);
        return cVar2;
    }

    private static void a(String str, c cVar) {
        cVar.dzs.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.replaceAll("\\n\\t*", "").getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map z;
                        Object obj;
                        Node item = childNodes.item(i);
                        String b = bl.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bl.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            z = bl.z(b, "dataitem");
                        } else {
                            z = null;
                        }
                        if (z == null) {
                            obj = null;
                        } else {
                            vx vxVar = new vx();
                            String str3 = ".dataitem";
                            vxVar.CF(bi.getInt((String) z.get(str3 + ".$datatype"), 0));
                            vxVar.UT((String) z.get(str3 + ".$datasourceid"));
                            vxVar.CG(bi.getInt((String) z.get(str3 + ".$datastatus"), 0));
                            vxVar.UL((String) z.get(str3 + ".datafmt"));
                            vxVar.UB((String) z.get(str3 + ".datatitle"));
                            vxVar.UC((String) z.get(str3 + ".datadesc"));
                            vxVar.UD((String) z.get(str3 + ".cdnthumburl"));
                            vxVar.UE((String) z.get(str3 + ".cdnthumbkey"));
                            vxVar.CC(bi.getInt((String) z.get(str3 + ".thumbwidth"), 0));
                            vxVar.CD(bi.getInt((String) z.get(str3 + ".thumbheight"), 0));
                            vxVar.UF((String) z.get(str3 + ".cdndataurl"));
                            vxVar.UG((String) z.get(str3 + ".cdndatakey"));
                            vxVar.dwv = (String) z.get(str3 + ".tpthumburl");
                            vxVar.rAC = true;
                            vxVar.Vc((String) z.get(str3 + ".tpaeskey"));
                            vxVar.Vd((String) z.get(str3 + ".tpauthkey"));
                            vxVar.Ve((String) z.get(str3 + ".tpdataurl"));
                            vxVar.dwB = (String) z.get(str3 + ".tpthumbaeskey");
                            vxVar.rAI = true;
                            String str4 = (String) z.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                vxVar.CE(bi.getInt(str4, 0));
                            }
                            vxVar.UI((String) z.get(str3 + ".streamdataurl"));
                            vxVar.UJ((String) z.get(str3 + ".streamlowbandurl"));
                            vxVar.UH((String) z.get(str3 + ".streamweburl"));
                            vxVar.UM((String) z.get(str3 + ".fullmd5"));
                            vxVar.UN((String) z.get(str3 + ".head256md5"));
                            str4 = (String) z.get(str3 + ".datasize");
                            if (!bi.oW(str4)) {
                                vxVar.fO((long) bi.getInt(str4, 0));
                            }
                            vxVar.UK((String) z.get(str3 + ".dataext"));
                            vxVar.UR((String) z.get(str3 + ".thumbfullmd5"));
                            vxVar.US((String) z.get(str3 + ".thumbhead256md5"));
                            str4 = (String) z.get(str3 + ".thumbsize");
                            if (!bi.oW(str4)) {
                                vxVar.fP((long) bi.getInt(str4, 0));
                            }
                            vxVar.UU((String) z.get(str3 + ".streamvideoid"));
                            str4 = (String) z.get(str3 + ".$dataid");
                            if (bi.oW(str4)) {
                                str4 = String.valueOf(i);
                            }
                            vxVar.UO(str4);
                            str4 = (String) z.get(str3 + ".$htmlid");
                            if (!bi.oW(str4)) {
                                vxVar.UY(str4);
                            }
                            vxVar.CH(bi.getInt((String) z.get(str3 + ".$dataillegaltype"), 0));
                            vxVar.UV((String) z.get(str3 + ".sourcetitle"));
                            vxVar.UW((String) z.get(str3 + ".sourcename"));
                            vxVar.UX((String) z.get(str3 + ".sourcetime"));
                            vxVar.UZ((String) z.get(str3 + ".statextstr"));
                            if (str2 != null) {
                                vxVar.Vb(str2);
                            }
                            vy vyVar = new vy();
                            vz vzVar = new vz();
                            vzVar.CJ(bi.getInt((String) z.get(str3 + ".$sourcetype"), 0));
                            str4 = (String) z.get(str3 + ".dataitemsource.fromusr");
                            if (!bi.oW(str4)) {
                                vzVar.Vf(str4);
                                x.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[]{vzVar.bSS});
                            }
                            str4 = (String) z.get(str3 + ".dataitemsource.realchatname");
                            if (!bi.oW(str4)) {
                                vzVar.Vi(str4);
                                x.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[]{vzVar.rBh});
                            }
                            vzVar.Vk((String) z.get(str3 + ".appid"));
                            vzVar.Vl((String) z.get(str3 + ".link"));
                            vzVar.Vm((String) z.get(str3 + ".brandid"));
                            vyVar.c(vzVar);
                            String str5 = str3 + ".locitem";
                            if (z.containsKey(str5)) {
                                we weVar = new we();
                                if (!bi.oW((String) z.get(str5 + ".label"))) {
                                    weVar.Vn((String) z.get(str5 + ".label"));
                                }
                                if (!bi.oW((String) z.get(str5 + ".poiname"))) {
                                    weVar.Vo((String) z.get(str5 + ".poiname"));
                                }
                                str4 = (String) z.get(str5 + ".lng");
                                if (!bi.oW(str4)) {
                                    weVar.y(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".lat");
                                if (!bi.oW(str4)) {
                                    weVar.z(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) z.get(str5 + ".scale");
                                if (!bi.oW(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        weVar.CK(bi.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        weVar.CK(bi.getInt(str4, -1));
                                    }
                                }
                                vyVar.a(weVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".weburlitem";
                            if (z.containsKey(str5)) {
                                xa xaVar = new xa();
                                xaVar.VJ((String) z.get(str5 + ".title"));
                                xaVar.VK((String) z.get(str5 + ".desc"));
                                xaVar.VM((String) z.get(str5 + ".thumburl"));
                                xaVar.VL((String) z.get(str5 + ".link"));
                                xaVar.CP(bi.getInt((String) z.get(str5 + ".opencache"), 0));
                                vyVar.a(xaVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".productitem";
                            if (z.containsKey(str5)) {
                                wk wkVar = new wk();
                                wkVar.Vp((String) z.get(str5 + ".title"));
                                wkVar.Vq((String) z.get(str5 + ".desc"));
                                wkVar.Vr((String) z.get(str5 + ".thumburl"));
                                wkVar.Vs((String) z.get(str5 + ".productinfo"));
                                wkVar.CL(bi.getInt((String) z.get(str5 + ".$type"), 0));
                                vyVar.a(wkVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".tvitem";
                            if (z.containsKey(str5)) {
                                wu wuVar = new wu();
                                wuVar.VF((String) z.get(str5 + ".title"));
                                wuVar.VG((String) z.get(str5 + ".desc"));
                                wuVar.VH((String) z.get(str5 + ".thumburl"));
                                wuVar.VI((String) z.get(str5 + ".tvinfo"));
                                vyVar.a(wuVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str3 = str3 + ".appbranditem";
                            if (z.containsKey(str3)) {
                                vv vvVar = new vv();
                                vvVar.username = (String) z.get(str3 + ".username");
                                vvVar.appId = (String) z.get(str3 + ".appid");
                                vvVar.bPh = bi.getInt((String) z.get(str3 + ".pkgtype"), 0);
                                vvVar.iconUrl = (String) z.get(str3 + ".iconurl");
                                vvVar.type = bi.getInt((String) z.get(str3 + ".type"), 0);
                                vvVar.bGH = (String) z.get(str3 + ".pagepath");
                                vvVar.rzd = (String) z.get(str3 + ".sourcedisplayname");
                                vyVar.a(vvVar);
                            } else {
                                x.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str3});
                            }
                            vxVar.a(vyVar);
                            vx obj2 = vxVar;
                        }
                        try {
                            cVar.dzs.add(obj2);
                        } catch (Throwable e) {
                            x.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[]{e.getMessage()});
                            x.printErrStackTrace("MicroMsg.RecordMsgLogic", e, "", new Object[0]);
                            cVar.dzs.clear();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[]{e2.toString()});
        }
    }

    public static int vn(int i) {
        if (2 == i) {
            return b.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i) {
            return b.MediaType_VIDEO;
        }
        return b.MediaType_FILE;
    }

    public static boolean b(vx vxVar, long j, boolean z) {
        if (vxVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            return false;
        }
        String e = e(vxVar.jdM, j, true);
        com.tencent.mm.plugin.record.a.f Kr = n.getRecordMsgCDNStorage().Kr(e);
        if (Kr == null) {
            Kr = new com.tencent.mm.plugin.record.a.f();
            Kr.field_cdnKey = vxVar.rzq;
            Kr.field_cdnUrl = vxVar.rzo;
            Kr.field_dataId = vxVar.jdM;
            Kr.field_mediaId = e;
            Kr.field_totalLen = (int) vxVar.rzJ;
            Kr.field_localId = new Random().nextInt(2147483645) + 1;
            Kr.field_path = c(vxVar, j);
            Kr.field_type = 1;
            Kr.field_fileType = vn(vxVar.bjS);
            Kr.field_isThumb = false;
            Kr.field_tpaeskey = vxVar.rAD;
            Kr.field_tpauthkey = vxVar.dwA;
            Kr.field_tpdataurl = vxVar.rAG;
            boolean b = n.getRecordMsgCDNStorage().b(Kr);
            x.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(Kr.field_localId), Boolean.valueOf(b)});
            if (!bi.oW(vxVar.rAq) && vxVar.rAq.equals("WeNoteHtmlFile")) {
                n.bqx().a(Kr, true);
            }
        }
        x.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[]{Kr});
        if (4 == Kr.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[]{Integer.valueOf(Kr.field_errCode)});
            return false;
        }
        if (3 == Kr.field_status) {
            x.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[]{Integer.valueOf(Kr.field_errCode), Boolean.valueOf(z)});
            if (!z) {
                return false;
            }
            Kr.field_status = 1;
            n.getRecordMsgCDNStorage().b(Kr, new String[]{"localId"});
        }
        n.bqx().run();
        return true;
    }

    public static boolean g(vx vxVar, long j) {
        if (vxVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            return true;
        }
        com.tencent.mm.plugin.record.a.f Kr = n.getRecordMsgCDNStorage().Kr(e(vxVar.jdM, j, true));
        if (Kr == null) {
            x.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            return false;
        } else if (4 == Kr.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[]{Integer.valueOf(Kr.field_errCode)});
            return true;
        } else {
            x.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[]{Integer.valueOf(Kr.field_status)});
            return false;
        }
    }

    public static boolean c(vx vxVar, long j, boolean z) {
        if (vxVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            return false;
        }
        String Ba = Ba(vxVar.jdM);
        String e = e(Ba, j, true);
        com.tencent.mm.plugin.record.a.f Kr = n.getRecordMsgCDNStorage().Kr(e);
        if (Kr == null) {
            Kr = new com.tencent.mm.plugin.record.a.f();
            Kr.field_cdnKey = vxVar.rzk;
            Kr.field_cdnUrl = vxVar.dwE;
            Kr.field_dataId = Ba;
            Kr.field_mediaId = e;
            Kr.field_totalLen = (int) vxVar.rzU;
            Kr.field_localId = new Random().nextInt(2147483645) + 1;
            Kr.field_path = f(vxVar, j);
            Kr.field_type = 1;
            Kr.field_fileType = b.MediaType_FULLSIZEIMAGE;
            Kr.field_isThumb = true;
            Kr.field_tpdataurl = vxVar.dwv;
            Kr.field_tpauthkey = vxVar.dwA;
            Kr.field_tpaeskey = vxVar.dwB;
            boolean b = n.getRecordMsgCDNStorage().b(Kr);
            x.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(Kr.field_localId), Boolean.valueOf(b)});
        }
        x.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[]{Kr});
        if (4 == Kr.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[]{Integer.valueOf(Kr.field_errCode)});
            return false;
        }
        if (3 == Kr.field_status) {
            x.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[]{Integer.valueOf(Kr.field_errCode), Boolean.valueOf(z)});
            if (!z) {
                return false;
            }
            Kr.field_status = 1;
            n.getRecordMsgCDNStorage().b(Kr, new String[]{"localId"});
        }
        n.bqx().run();
        return true;
    }

    public static String gU(String str) {
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(str);
        if (Yg == null) {
            x.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[]{str});
            return "";
        }
        String BL = Yg.BL();
        if (!s.fq(BL)) {
            return BL;
        }
        List gI = m.gI(str);
        String GF = q.GF();
        if (gI == null || gI.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            return BL;
        }
        gI.remove(GF);
        gI.add(0, GF);
        return m.c(gI, 3);
    }

    public static boolean h(vx vxVar, long j) {
        return com.tencent.mm.sdk.platformtools.o.Wf(c(vxVar, j));
    }
}
