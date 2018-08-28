package com.tencent.mm.plugin.webwx.a;

import android.content.Intent;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.ac.a.i;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements d, a {
    public final b b(d.a aVar) {
        by byVar = aVar.dIN;
        if (byVar != null && byVar.jQd == 51) {
            x.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", new Object[]{Integer.valueOf(byVar.jQd), Integer.valueOf(51)});
            String a = ab.a(byVar.rck);
            if (!bi.oW(a)) {
                String trim = ab.a(byVar.rcl).trim();
                Map z = bl.z(trim, "msg");
                if (z != null) {
                    int i = bi.getInt((String) z.get(".msg.op.$id"), 0);
                    x.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", new Object[]{Integer.valueOf(i)});
                    String trim2;
                    rb rbVar;
                    if (i == 1 || i == 2 || i == 5) {
                        x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = " + a);
                        au.HU();
                        c.FT().GB(a);
                        com.tencent.mm.plugin.webwx.a.ezn.cancelNotification(a);
                        if (s.hj(a)) {
                            au.HU();
                            c.DT().set(143618, Integer.valueOf(0));
                            com.tencent.mm.az.d.SF().clO();
                        } else {
                            x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                            au.HU();
                            c.FW().Ys(a);
                            if (s.fq(a)) {
                                au.HU();
                                ai Yq = c.FW().Yq(a);
                                if (Yq != null && Yq.field_unReadCount > 0 && Yq.field_UnDeliverCount > 0) {
                                    x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", new Object[]{a, Integer.valueOf(Yq.field_UnDeliverCount), Integer.valueOf(Yq.field_unReadCount)});
                                    com.tencent.mm.plugin.webwx.a.ezo.cV(a);
                                    Yq.eV(0);
                                    au.HU();
                                    c.FW().a(Yq, a);
                                }
                            }
                        }
                    } else if (i == 3) {
                        au.HU();
                        List clE = c.FW().clE();
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = 0;
                        while (i2 < clE.size()) {
                            stringBuilder.append(i2 > 0 ? "," : "");
                            stringBuilder.append((String) clE.get(i2));
                            i2++;
                        }
                        au.DF().a(new z(stringBuilder.toString(), 4), 0);
                    } else if (i == 6) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                    } else if (i == 7) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        r3 = new Object[2];
                        au.HU();
                        r3[0] = Integer.valueOf(c.FN());
                        r3[1] = Integer.valueOf(l.QZ());
                        x.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", r3);
                        a = bi.oV((String) z.get(".msg.op.name")).trim();
                        trim2 = bi.oV((String) z.get(".msg.op.arg")).trim();
                        if ("WeixinStatus".equals(a)) {
                            au.HU();
                            if (c.FN() == l.QZ() && l.efE != null && l.efE.trim().length() > 0) {
                                Intent intent = new Intent(ad.getContext(), WebWXLogoutUI.class);
                                intent.setFlags(603979776);
                                intent.addFlags(268435456);
                                intent.putExtra("intent.key.online_version", l.QZ());
                                ad.getContext().startActivity(intent);
                            }
                        } else if ("MomentsUnreadMsgStatus".equals(a)) {
                            rbVar = new rb();
                            rbVar.cbQ.bNI = 7;
                            rbVar.cbQ.cbR = a;
                            rbVar.cbQ.cbS = (long) bi.getInt(trim2, 0);
                            x.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", new Object[]{Integer.valueOf(rbVar.cbQ.bNI), rbVar.cbQ.cbR, Long.valueOf(rbVar.cbQ.cbS)});
                            com.tencent.mm.sdk.b.a.sFg.m(rbVar);
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            com.tencent.mm.ac.z.Nl();
                            i.e(i, a, trim2);
                        }
                    } else if (i == 8) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = bi.oV((String) z.get(".msg.op.name")).trim();
                        trim2 = bi.oV((String) z.get(".msg.op.arg")).trim();
                        if ("EnterpriseChatStatus".equals(a)) {
                            com.tencent.mm.ac.z.Nl();
                            i.e(i, a, trim2);
                        } else {
                            rb rbVar2 = new rb();
                            rbVar2.cbQ.bNI = 8;
                            com.tencent.mm.sdk.b.a.sFg.m(rbVar2);
                        }
                    } else if (i == 9) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", new Object[]{Integer.valueOf(i), trim});
                        a = bi.oV((String) z.get(".msg.op.name")).trim();
                        trim2 = bi.oV((String) z.get(".msg.op.arg")).trim();
                        if ("MomentsTimelineStatus".equals(a)) {
                            String[] split = trim2.split(",");
                            if (split.length == 2) {
                                rbVar = new rb();
                                rbVar.cbQ.bNI = 9;
                                rbVar.cbQ.cbR = a;
                                rbVar.cbQ.cbS = (long) bi.getInt(split[1], 0);
                                rbVar.cbQ.cbT = split[0];
                                com.tencent.mm.sdk.b.a.sFg.m(rbVar);
                            }
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            com.tencent.mm.ac.z.Nl();
                            i.e(i, a, trim2);
                        }
                    } else if (i == 11) {
                        a = bi.oV((String) z.get(".msg.op.name")).trim();
                        trim2 = bi.oV((String) z.get(".msg.op.arg")).trim();
                        if (!"DownloadFile".equals(a)) {
                            x.i("MicroMsg.StatusNotifyMsgExtension", "[MultiTerminalSyncMgr]not DownloadFile, ignore");
                        }
                        z = bl.z(trim2, "downloadList");
                        if (z != null) {
                            int i3 = 0;
                            while (true) {
                                a = ".downloadList.downloadItem" + (i3 == 0 ? "" : Integer.valueOf(i3));
                                int i4 = i3 + 1;
                                trim2 = a + ".username";
                                a = a + ".msgsvrid";
                                trim2 = (String) z.get(trim2);
                                if (!bi.oW(trim2)) {
                                    long j = bi.getLong((String) z.get(a), -1);
                                    if (j == -1) {
                                        break;
                                    }
                                    au.HU();
                                    bd I = c.FT().I(trim2, j);
                                    if (I.field_msgSvrId == 0) {
                                        x.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", new Object[]{Long.valueOf(j)});
                                        i3 = i4;
                                    } else {
                                        g.bYF().bYH().fF(I.field_msgId);
                                        i3 = i4;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } else if (i == 12) {
                        x.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock " + trim, new Object[]{Integer.valueOf(i)});
                        try {
                            if (z.get(".msg.op.arg") != null) {
                                trim2 = new JSONObject((String) z.get(".msg.op.arg")).get("deviceName").toString();
                                if (l.QY()) {
                                    Intent intent2 = new Intent(ad.getContext(), WebWXPopupUnlockUI.class);
                                    intent2.setFlags(872415232);
                                    intent2.putExtra("deviceName", trim2);
                                    ad.getContext().startActivity(intent2);
                                }
                            } else {
                                x.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                            }
                        } catch (JSONException e) {
                            x.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e.getMessage());
                        }
                    } else {
                        x.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", new Object[]{Integer.valueOf(i)});
                    }
                }
            }
        }
        return null;
    }

    public final void h(bd bdVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.ab.l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
