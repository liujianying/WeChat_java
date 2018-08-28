package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.mm.ab.d;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.plugin.game.model.v.1;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    com.tencent.mm.sdk.b.c hKG = new 3(this);
    a iwx = new a() {
        public final void a(d.a aVar) {
            s sVar;
            long j;
            v aSi = ((b) g.l(b.class)).aSi();
            String a = ab.a(aVar.dIN.rcl);
            x.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[]{Long.valueOf(r1.rcq)});
            x.i("MicroMsg.GameMessageService", "Message content: %s" + a);
            new Thread(new 1(aSi, a)).start();
            if (bi.oW(a)) {
                x.e("MicroMsg.GameMessageParser", "msg content is null");
                sVar = null;
            } else {
                Map z = bl.z(a, "sysmsg");
                if (z == null || z.size() == 0) {
                    x.e("MicroMsg.GameMessageParser", "Parse failed");
                    sVar = null;
                } else if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
                    s sVar2 = new s();
                    sVar2.field_showInMsgList = true;
                    sVar2.field_msgId = System.currentTimeMillis();
                    sVar2.field_rawXML = a;
                    sVar2.field_msgType = bi.getInt((String) z.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                    if (sVar2.field_msgType == 100 || sVar2.field_msgType == 30) {
                        z.aUg();
                        sVar2.field_gameMsgId = bi.aG((String) z.get(".sysmsg.gamecenter.msg_id"), "");
                        sVar2.field_appId = (String) z.get(".sysmsg.gamecenter.appid");
                        sVar2.field_createTime = bi.getLong((String) z.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        j = bi.getLong((String) z.get(".sysmsg.gamecenter.time_info.expire_time"), 0);
                        if (j == 0) {
                            sVar2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            sVar2.field_expireTime = j + bi.getLong((String) z.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        }
                        sVar2.jMh = bi.getLong((String) z.get(".sysmsg.gamecenter.time_info.random_time"), 0);
                        sVar2.field_isHidden = bi.getInt((String) z.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        sVar2.field_mergerId = bi.aG((String) z.get(".sysmsg.gamecenter.merge_id"), "");
                        sVar2.field_weight = bi.aG((String) z.get(".sysmsg.gamecenter.weight"), "");
                        sVar2.field_receiveTime = System.currentTimeMillis() / 1000;
                        z.d(z, sVar2);
                        sVar2.jMG = bi.getLong((String) z.get(".sysmsg.gamecenter.filter_flag"), 0);
                        sVar2.jMH = bi.getInt((String) z.get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                        sVar2.jMs = bi.getInt((String) z.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) > 0;
                        sVar2.jMt.jNg = bi.aG((String) z.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        if (bi.oW((String) z.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url")) && bi.oW((String) z.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"))) {
                            sVar2.jMu = false;
                        } else {
                            sVar2.jMu = true;
                        }
                        z.e(z, sVar2);
                        sVar2.jMY.jNt = bi.aG((String) z.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        sVar2.jMY.hzJ = bi.getInt((String) z.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        if (!bi.oW(sVar2.jMY.jNt)) {
                            sVar2.field_isHidden = true;
                        }
                        sVar2.jMY.jNu = bi.getLong((String) z.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                    } else {
                        sVar2.field_gameMsgId = bi.aG((String) z.get(".sysmsg.gamecenter.msg_id"), "");
                        sVar2.field_msgType = bi.getInt((String) z.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                        if (sVar2.field_msgType == 0) {
                            sVar2.field_msgType = bi.getInt((String) z.get(".sysmsg.gamecenter.$msgtype"), 0);
                        }
                        sVar2.field_appId = (String) z.get(".sysmsg.gamecenter.appinfo.appid");
                        sVar2.field_showInMsgList = !bi.oW(u.B(z));
                        sVar2.field_createTime = bi.getLong((String) z.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        j = bi.getLong((String) z.get(".sysmsg.game_control_info.expiredtime"), 0);
                        if (j == 0) {
                            sVar2.field_expireTime = Long.MAX_VALUE;
                        } else {
                            sVar2.field_expireTime = j + bi.getLong((String) z.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        }
                        sVar2.field_isHidden = bi.getInt((String) z.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        sVar2.field_mergerId = bi.aG((String) z.get(".sysmsg.gamecenter.merge_id"), "");
                        if (sVar2.field_msgType == 10) {
                            sVar2.field_weight = "6";
                        } else {
                            sVar2.field_weight = "2";
                        }
                        sVar2.field_receiveTime = System.currentTimeMillis() / 1000;
                        sVar2.jMG = bi.getLong((String) z.get(".sysmsg.game_control_info.filter_flag"), 0);
                        sVar2.jMF = u.C(z);
                        sVar2.jMH = bi.getInt((String) z.get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                        sVar2.jMu = bi.getInt((String) z.get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) > 0;
                        sVar2.jNb = bi.aG((String) z.get(".sysmsg.gamecenter.noticeid"), "");
                        sVar2.jMt.jNi = bi.getInt((String) z.get(".sysmsg.gamecenter.badge_display_type"), 0);
                        sVar2.jMs = sVar2.jMt.jNi > 0;
                        if ((sVar2.jMF & 4) == 0) {
                            sVar2.jMs = false;
                        }
                        u.b(z, sVar2);
                    }
                    if (sVar2.jMH == 1) {
                        sVar2.field_showInMsgList = false;
                    }
                    sVar = sVar2;
                } else {
                    x.e("MicroMsg.GameMessageParser", "Type not matched");
                    sVar = null;
                }
            }
            if (sVar != null) {
                int i;
                int i2;
                x.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", new Object[]{Integer.valueOf(sVar.field_msgType), sVar.field_appId, Long.valueOf(sVar.field_msgId)});
                if (sVar == null) {
                    x.e("MicroMsg.GameMessageService", "msg is null");
                    i = -1;
                } else {
                    Object obj;
                    String str = sVar.field_gameMsgId;
                    if (!bi.oW(str)) {
                        int i3 = 0;
                        Cursor rawQuery = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + str + "\"", new String[0]);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                i3 = rawQuery.getInt(0);
                            }
                            rawQuery.close();
                            if (i3 > 0) {
                                obj = 1;
                                if (obj == null) {
                                    x.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{sVar.field_gameMsgId});
                                    h.mEJ.a(858, 4, 1, false);
                                    i = 2;
                                } else {
                                    String str2;
                                    ub ubVar;
                                    if ((sVar.field_expireTime <= System.currentTimeMillis() / 1000 ? null : 1) == null) {
                                        x.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{sVar.field_gameMsgId});
                                        h.mEJ.a(858, 5, 1, false);
                                        str2 = sVar.jMY.jNt;
                                        if (!bi.oW(str2)) {
                                            ubVar = new ub();
                                            ubVar.cfW.bIH = 6;
                                            ubVar.cfW.cfX = str2;
                                            com.tencent.mm.sdk.b.a.sFg.m(ubVar);
                                        }
                                        i = 1;
                                    } else {
                                        long j2 = sVar.jMG;
                                        a = sVar.field_appId;
                                        if (j2 == 1) {
                                            if (bi.oW(a) || !com.tencent.mm.pluginsdk.model.app.g.r(ad.getContext(), a)) {
                                                h.mEJ.a(858, 6, 1, false);
                                                i3 = 3;
                                            }
                                            i3 = 0;
                                        } else {
                                            if (j2 == 2 && (bi.oW(a) || com.tencent.mm.pluginsdk.model.app.g.r(ad.getContext(), a))) {
                                                h.mEJ.a(858, 7, 1, false);
                                                i3 = 4;
                                            }
                                            i3 = 0;
                                        }
                                        if (i3 != 0) {
                                            x.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[]{sVar.field_gameMsgId, Integer.valueOf(i3)});
                                            i = i3;
                                        } else {
                                            if (sVar.field_msgType == 30) {
                                                h.mEJ.a(858, 8, 1, false);
                                            } else {
                                                s aTX = v.aTX();
                                                if (aTX == null) {
                                                    aTX = v.aTZ();
                                                }
                                                s aUb = aTX == null ? v.aUb() : aTX;
                                                if (aUb != null) {
                                                    aUb.aTW();
                                                    JSONObject jSONObject = new JSONObject();
                                                    try {
                                                        jSONObject.put("oldNoticeId", aUb.jNb);
                                                        jSONObject.put("oldMsgId", aUb.field_gameMsgId);
                                                        if (sVar.field_weight.compareTo(aUb.field_weight) >= 0) {
                                                            jSONObject.put("coverType", 1);
                                                        } else {
                                                            jSONObject.put("coverType", 2);
                                                        }
                                                    } catch (Exception e) {
                                                        x.e("MicroMsg.GameMessageService", "reportMsgCover: " + e.getMessage());
                                                    }
                                                    i2 = sVar.field_msgType;
                                                    if (sVar.field_msgType == 100) {
                                                        i2 = sVar.jNa;
                                                    }
                                                    an.a(ad.getContext(), 0, 0, 0, 31, 0, sVar.field_appId, 0, i2, sVar.field_gameMsgId, sVar.jNb, an.Dx(jSONObject.toString()));
                                                    if (sVar.field_weight.compareTo(aUb.field_weight) >= 0) {
                                                        h.mEJ.a(858, 10, 1, false);
                                                        str2 = aUb.jMY.jNt;
                                                        if (!bi.oW(str2)) {
                                                            ubVar = new ub();
                                                            ubVar.cfW.bIH = 6;
                                                            ubVar.cfW.cfX = str2;
                                                            com.tencent.mm.sdk.b.a.sFg.m(ubVar);
                                                        }
                                                        obj = 1;
                                                    } else {
                                                        h.mEJ.a(858, 11, 1, false);
                                                        obj = null;
                                                    }
                                                    if (obj == null) {
                                                        obj = null;
                                                        if (obj != null) {
                                                            if (sVar.jMs) {
                                                                g.Ei().DT().a(aa.a.sRz, Long.valueOf(sVar.field_msgId));
                                                            } else {
                                                                g.Ei().DT().a(aa.a.sRz, Long.valueOf(0));
                                                            }
                                                            if (bi.oW(sVar.jMI.url)) {
                                                                v.aUa();
                                                            } else {
                                                                g.Ei().DT().a(aa.a.sRD, Long.valueOf(sVar.field_msgId));
                                                            }
                                                            if (sVar.jMu) {
                                                                g.Ei().DT().a(aa.a.sRA, Long.valueOf(sVar.field_msgId));
                                                            } else {
                                                                v.aUc();
                                                            }
                                                        }
                                                        if (sVar.field_msgType == 4) {
                                                            g.Ei().DT().a(aa.a.sRC, Long.valueOf(sVar.field_msgId));
                                                        }
                                                        if (!(sVar == null || bi.oW(sVar.jMt.jNg))) {
                                                            com.tencent.mm.plugin.game.e.c.DR(sVar.jMt.jNg);
                                                        }
                                                    }
                                                }
                                                obj = 1;
                                                if (obj != null) {
                                                    if (sVar.jMs) {
                                                        g.Ei().DT().a(aa.a.sRz, Long.valueOf(sVar.field_msgId));
                                                    } else {
                                                        g.Ei().DT().a(aa.a.sRz, Long.valueOf(0));
                                                    }
                                                    if (bi.oW(sVar.jMI.url)) {
                                                        v.aUa();
                                                    } else {
                                                        g.Ei().DT().a(aa.a.sRD, Long.valueOf(sVar.field_msgId));
                                                    }
                                                    if (sVar.jMu) {
                                                        g.Ei().DT().a(aa.a.sRA, Long.valueOf(sVar.field_msgId));
                                                    } else {
                                                        v.aUc();
                                                    }
                                                }
                                                if (sVar.field_msgType == 4) {
                                                    g.Ei().DT().a(aa.a.sRC, Long.valueOf(sVar.field_msgId));
                                                }
                                                com.tencent.mm.plugin.game.e.c.DR(sVar.jMt.jNg);
                                            }
                                            i = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        String str22;
                        ub ubVar2;
                        if ((sVar.field_expireTime <= System.currentTimeMillis() / 1000 ? null : 1) == null) {
                            x.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{sVar.field_gameMsgId});
                            h.mEJ.a(858, 5, 1, false);
                            str22 = sVar.jMY.jNt;
                            if (!bi.oW(str22)) {
                                ubVar2 = new ub();
                                ubVar2.cfW.bIH = 6;
                                ubVar2.cfW.cfX = str22;
                                com.tencent.mm.sdk.b.a.sFg.m(ubVar2);
                            }
                            i = 1;
                        } else {
                            long j22 = sVar.jMG;
                            a = sVar.field_appId;
                            if (j22 == 1) {
                                if (bi.oW(a) || !com.tencent.mm.pluginsdk.model.app.g.r(ad.getContext(), a)) {
                                    h.mEJ.a(858, 6, 1, false);
                                    i3 = 3;
                                }
                                i3 = 0;
                            } else {
                                if (j22 == 2 && (bi.oW(a) || com.tencent.mm.pluginsdk.model.app.g.r(ad.getContext(), a))) {
                                    h.mEJ.a(858, 7, 1, false);
                                    i3 = 4;
                                }
                                i3 = 0;
                            }
                            if (i3 != 0) {
                                x.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[]{sVar.field_gameMsgId, Integer.valueOf(i3)});
                                i = i3;
                            } else {
                                if (sVar.field_msgType == 30) {
                                    h.mEJ.a(858, 8, 1, false);
                                } else {
                                    s aTX2 = v.aTX();
                                    if (aTX2 == null) {
                                        aTX2 = v.aTZ();
                                    }
                                    s aUb2 = aTX2 == null ? v.aUb() : aTX2;
                                    if (aUb2 != null) {
                                        aUb2.aTW();
                                        JSONObject jSONObject2 = new JSONObject();
                                        try {
                                            jSONObject2.put("oldNoticeId", aUb2.jNb);
                                            jSONObject2.put("oldMsgId", aUb2.field_gameMsgId);
                                            if (sVar.field_weight.compareTo(aUb2.field_weight) >= 0) {
                                                jSONObject2.put("coverType", 1);
                                            } else {
                                                jSONObject2.put("coverType", 2);
                                            }
                                        } catch (Exception e2) {
                                            x.e("MicroMsg.GameMessageService", "reportMsgCover: " + e2.getMessage());
                                        }
                                        i2 = sVar.field_msgType;
                                        if (sVar.field_msgType == 100) {
                                            i2 = sVar.jNa;
                                        }
                                        an.a(ad.getContext(), 0, 0, 0, 31, 0, sVar.field_appId, 0, i2, sVar.field_gameMsgId, sVar.jNb, an.Dx(jSONObject2.toString()));
                                        if (sVar.field_weight.compareTo(aUb2.field_weight) >= 0) {
                                            h.mEJ.a(858, 10, 1, false);
                                            str22 = aUb2.jMY.jNt;
                                            if (!bi.oW(str22)) {
                                                ubVar2 = new ub();
                                                ubVar2.cfW.bIH = 6;
                                                ubVar2.cfW.cfX = str22;
                                                com.tencent.mm.sdk.b.a.sFg.m(ubVar2);
                                            }
                                            obj = 1;
                                        } else {
                                            h.mEJ.a(858, 11, 1, false);
                                            obj = null;
                                        }
                                        if (obj == null) {
                                            obj = null;
                                            if (obj != null) {
                                                if (sVar.jMs) {
                                                    g.Ei().DT().a(aa.a.sRz, Long.valueOf(sVar.field_msgId));
                                                } else {
                                                    g.Ei().DT().a(aa.a.sRz, Long.valueOf(0));
                                                }
                                                if (bi.oW(sVar.jMI.url)) {
                                                    v.aUa();
                                                } else {
                                                    g.Ei().DT().a(aa.a.sRD, Long.valueOf(sVar.field_msgId));
                                                }
                                                if (sVar.jMu) {
                                                    g.Ei().DT().a(aa.a.sRA, Long.valueOf(sVar.field_msgId));
                                                } else {
                                                    v.aUc();
                                                }
                                            }
                                            if (sVar.field_msgType == 4) {
                                                g.Ei().DT().a(aa.a.sRC, Long.valueOf(sVar.field_msgId));
                                            }
                                            if (!(sVar == null || bi.oW(sVar.jMt.jNg))) {
                                                com.tencent.mm.plugin.game.e.c.DR(sVar.jMt.jNg);
                                            }
                                        }
                                    }
                                    obj = 1;
                                    if (obj != null) {
                                        if (sVar.jMs) {
                                            g.Ei().DT().a(aa.a.sRz, Long.valueOf(sVar.field_msgId));
                                        } else {
                                            g.Ei().DT().a(aa.a.sRz, Long.valueOf(0));
                                        }
                                        if (bi.oW(sVar.jMI.url)) {
                                            v.aUa();
                                        } else {
                                            g.Ei().DT().a(aa.a.sRD, Long.valueOf(sVar.field_msgId));
                                        }
                                        if (sVar.jMu) {
                                            g.Ei().DT().a(aa.a.sRA, Long.valueOf(sVar.field_msgId));
                                        } else {
                                            v.aUc();
                                        }
                                    }
                                    if (sVar.field_msgType == 4) {
                                        g.Ei().DT().a(aa.a.sRC, Long.valueOf(sVar.field_msgId));
                                    }
                                    com.tencent.mm.plugin.game.e.c.DR(sVar.jMt.jNg);
                                }
                                i = 0;
                            }
                        }
                    } else {
                        x.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{sVar.field_gameMsgId});
                        h.mEJ.a(858, 4, 1, false);
                        i = 2;
                    }
                }
                if (i == 0) {
                    v.b(sVar);
                    switch (sVar.field_msgType) {
                        case 30:
                            com.tencent.mm.plugin.game.model.a.g aUH = a.jOR;
                            if (sVar != null && !bi.oW(sVar.field_appId)) {
                                a = sVar.field_appId;
                                j = sVar.field_expireTime;
                                long j3 = sVar.jMh;
                                com.tencent.mm.plugin.game.model.a.c cVar = new com.tencent.mm.plugin.game.model.a.c();
                                cVar.field_appId = a;
                                if (!((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSl().b(cVar, new String[0])) {
                                    cVar.field_expireTime = j;
                                    cVar.field_randomTime = j3;
                                    cVar.field_isFirst = true;
                                    cVar.field_isRunning = false;
                                    cVar.field_noWifi = true;
                                    cVar.field_noSdcard = true;
                                    cVar.field_noEnoughSpace = true;
                                    cVar.field_lowBattery = true;
                                    cVar.field_continueDelay = true;
                                    boolean b = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSl().b(cVar);
                                    x.i("MicroMsg.GameSilentDownloader", "insert GameSilentDownloadTask, appid:%s, expireTime:%d, randomTime:%d, ret:%b", new Object[]{cVar.field_appId, Long.valueOf(cVar.field_expireTime), Long.valueOf(cVar.field_randomTime), Boolean.valueOf(b)});
                                    aUH.fv(false);
                                    break;
                                }
                                x.i("MicroMsg.GameSilentDownloader", "GameSilentDownloadTask exist! appid = %s", new Object[]{a});
                                h.mEJ.a(860, 17, 1, false);
                                break;
                            }
                            x.i("MicroMsg.GameSilentDownloader", "msg is null");
                            h.mEJ.a(860, 16, 1, false);
                            break;
                            break;
                        default:
                            x.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[]{Boolean.valueOf(((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj().b(sVar))});
                            break;
                    }
                    h.mEJ.a(858, 1, 1, false);
                }
                i2 = sVar.field_msgType;
                if (sVar.field_msgType == 100) {
                    i2 = sVar.jNa;
                }
                an.a(ad.getContext(), 0, 0, 0, 18, i, sVar.field_appId, 0, i2, sVar.field_gameMsgId, sVar.jNb, an.da("resource", String.valueOf(sVar.jMt.jNi)));
                h.mEJ.a(858, 0, 1, false);
            }
        }
    };
    com.tencent.mm.sdk.b.c jFA = new 15(this);
    com.tencent.mm.sdk.b.c jFB = new 16(this);
    com.tencent.mm.sdk.b.c jFC = new 17(this);
    com.tencent.mm.sdk.b.c jFD = new 18(this);
    com.tencent.mm.pluginsdk.c.d jFE = new com.tencent.mm.pluginsdk.c.d() {
        public final com.tencent.mm.sdk.b.b CY(String str) {
            gp gpVar = new gp();
            gpVar.bPM.bHA = str;
            return gpVar;
        }

        public final j aSe() {
            return ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSj();
        }
    };
    com.tencent.mm.sdk.b.c jFF = new 4(this);
    com.tencent.mm.sdk.b.c jFG = new 5(this);
    com.tencent.mm.sdk.b.c jFH = new 6(this);
    com.tencent.mm.sdk.b.c jFI = new 7(this);
    com.tencent.mm.sdk.b.c jFJ = new 8(this);
    com.tencent.mm.sdk.b.c jFK = new com.tencent.mm.sdk.b.c<hi>() {
        {
            this.sFo = hi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            hi hiVar = (hi) bVar;
            db aTN = com.tencent.mm.plugin.game.model.h.aTL().aTN();
            if (aTN != null) {
                hiVar.bQD.bQE = aTN.dxh;
                hiVar.bQD.bQF = aTN.jOk;
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c jFL = new 10(this);
    com.tencent.mm.plugin.game.wepkg.utils.c jFv;
    com.tencent.mm.sdk.b.c jFw = new 11(this);
    com.tencent.mm.sdk.b.c jFx = new 12(this);
    com.tencent.mm.sdk.b.c jFy = new 13(this);
    com.tencent.mm.sdk.b.c jFz = new 14(this);

    public c() {
        if (this.jFv == null) {
            this.jFv = new com.tencent.mm.plugin.game.wepkg.utils.c();
        }
    }
}
