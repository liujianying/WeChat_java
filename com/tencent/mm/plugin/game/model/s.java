package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.c.bq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class s extends bq {
    protected static com.tencent.mm.sdk.e.c.a dhO;
    public String ikW = "";
    public int jMA = 0;
    public String jMB = "";
    public String jMC = "";
    public String jMD = "";
    public int jME = 0;
    public long jMF = 0;
    public long jMG = 0;
    public int jMH = 0;
    public a jMI = new a();
    public String jMJ = "";
    public String jMK = "";
    public String jML = "";
    public String jMM = "";
    public String jMN = "";
    public String jMO = "";
    public String jMP = "";
    public String jMQ;
    public String jMR;
    public String jMS;
    public String jMT;
    public String jMU;
    public f jMV;
    public e jMW = new e();
    public g jMX = new g();
    public i jMY = new i();
    public int jMZ;
    public long jMh = 0;
    private boolean jMi = false;
    public String jMj = "";
    public String jMk = "";
    public String jMl = "";
    public String jMm = "";
    public String jMn = "";
    public int jMo = 0;
    public String jMp = "";
    public String jMq = "";
    public LinkedList<h> jMr = new LinkedList();
    public boolean jMs;
    public c jMt = new c();
    public boolean jMu;
    public b jMv = new b();
    public HashMap<String, d> jMw = new HashMap();
    public String jMx = "";
    public int jMy = 0;
    public int jMz = 0;
    public int jNa;
    public String jNb;
    public int jNc = 0;
    public String jNd = "";
    public boolean jNe = false;
    public String mAppName = "";

    public static class a {
        public boolean jMc;
        public boolean jNf;
        public int orientation;
        public String url;
    }

    public final void aTW() {
        if (!this.jMi) {
            if (this.field_msgType != 100) {
                if (this != null) {
                    if (!bi.oW(this.field_rawXML)) {
                        Map z = bl.z(this.field_rawXML, "sysmsg");
                        if (z != null && z.size() != 0) {
                            if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
                                this.jME = bi.getInt((String) z.get(".sysmsg.gamecenter.wifi_flag"), 0);
                                this.ikW = u.B(z);
                                this.jMj = bi.aG((String) z.get(".sysmsg.gamecenter.url"), "");
                                this.jMx = bi.aG((String) z.get(".sysmsg.gamecenter.msg_picture_url"), "");
                                this.jMk = bi.aG((String) z.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
                                if (bi.oW(this.jMk)) {
                                    this.jMk = bi.aG((String) z.get(".sysmsg.gamecenter.url"), "");
                                }
                                this.jMZ = bi.getInt((String) z.get(".sysmsg.gamecenter.notify_type"), 0);
                                this.mAppName = bi.aG((String) z.get(".sysmsg.gamecenter.appinfo.appname2"), "");
                                if (bi.oW(this.mAppName)) {
                                    this.mAppName = bi.aG((String) z.get(".sysmsg.gamecenter.appinfo.appname"), "");
                                }
                                if (this.field_msgType == 6) {
                                    this.jMp = bi.aG((String) z.get(".sysmsg.gamecenter.appinfo.groupname"), "");
                                    this.jMq = bi.aG((String) z.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
                                } else {
                                    this.jMp = this.mAppName;
                                }
                                this.jMl = bi.aG((String) z.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
                                this.jMm = bi.aG((String) z.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
                                this.jMn = bi.aG((String) z.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
                                this.jMo = bi.getInt((String) z.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
                                u.a(z, this);
                                this.jNb = bi.aG((String) z.get(".sysmsg.gamecenter.noticeid"), "");
                                this.jMF = u.C(z);
                                this.jMt.jNi = bi.getInt((String) z.get(".sysmsg.gamecenter.badge_display_type"), 0);
                                this.jMt.jNg = bi.aG((String) z.get(".sysmsg.gamecenter.showiconurl"), "");
                                this.jMt.gEw = bi.aG((String) z.get(".sysmsg.gamecenter.entrancetext"), "");
                                u.b(z, this);
                                this.jMy = bi.getInt((String) z.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
                                this.jMv.jNg = bi.aG((String) z.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
                                this.jMv.cZG = bi.aG((String) z.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
                                this.jNc = bi.getInt((String) z.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
                                this.jNd = bi.aG((String) z.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
                                switch (this.field_msgType) {
                                    case 2:
                                        this.jMz = bi.getInt((String) z.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
                                        this.jMA = bi.getInt((String) z.get(".sysmsg.game_control_info.display_name_type"), 1);
                                        this.jMB = bi.aG((String) z.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
                                        this.jMC = bi.aG((String) z.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
                                        this.jMD = bi.aG((String) z.get(".sysmsg.gameshare.share_message_info.media_url"), "");
                                        this.jMx = bi.aG((String) z.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
                                        x.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", new Object[]{this.field_appId});
                                        break;
                                    case 4:
                                    case 10:
                                    case 11:
                                        break;
                                    case 5:
                                        this.jMN = bi.aG((String) z.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
                                        this.jMO = bi.aG((String) z.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
                                        this.jMP = bi.aG((String) z.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
                                        break;
                                    case 6:
                                        this.jMJ = bi.aG((String) z.get(".sysmsg.gamecenter.topic.reply_content"), "");
                                        this.jMK = bi.aG((String) z.get(".sysmsg.gamecenter.topic.replied_content"), "");
                                        this.jMM = bi.aG((String) z.get(".sysmsg.gamecenter.topic.topic_title"), "");
                                        this.jML = bi.aG((String) z.get(".sysmsg.gamecenter.topic.topic_url"), "");
                                        break;
                                    default:
                                        x.e("MicroMsg.GameMessageParser", "error gamecenter type: " + this.field_msgType);
                                        break;
                                }
                            }
                            x.e("MicroMsg.GameMessageParser", "Type not matched");
                        } else {
                            x.e("MicroMsg.GameMessageParser", "Parse failed");
                        }
                    } else {
                        x.e("MicroMsg.GameMessageParser", "msg content is null");
                    }
                } else {
                    x.e("MicroMsg.GameMessageParser", "msg is null");
                }
            } else {
                z.aUg();
                if (this == null) {
                    x.e("MicroMsg.GameNewMessageParser", "msg is null");
                } else if (bi.oW(this.field_rawXML)) {
                    x.e("MicroMsg.GameNewMessageParser", "msg content is null");
                } else {
                    Map z2 = bl.z(this.field_rawXML, "sysmsg");
                    if (z2 == null || z2.size() == 0) {
                        x.e("MicroMsg.GameNewMessageParser", "Parse failed");
                    } else if ("gamecenter".equalsIgnoreCase((String) z2.get(".sysmsg.$type"))) {
                        this.jMQ = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
                        this.jMR = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
                        this.jMS = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
                        this.jMW.jNk = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
                        this.jMW.jNg = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
                        this.jMW.jNh = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
                        this.jMT = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
                        this.jMU = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
                        if (z2.get(".sysmsg.gamecenter.msg_center.msg_sender") != null) {
                            this.jMV = new f();
                            this.jMV.jNl = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
                            this.jMV.jNm = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
                            this.jMV.jNn = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
                            this.jMV.jNh = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
                        }
                        this.jMr.clear();
                        String str = ".sysmsg.gamecenter.msg_center.userinfo";
                        int i = 0;
                        while (true) {
                            String str2 = i == 0 ? str : str + i;
                            if (!z2.containsKey(str2)) {
                                break;
                            }
                            h hVar = new h();
                            hVar.userName = bi.aG((String) z2.get(str2 + ".username"), "");
                            hVar.bgn = bi.aG((String) z2.get(str2 + ".nickname"), "");
                            hVar.jNp = bi.aG((String) z2.get(str2 + ".usericon"), "");
                            hVar.jNr = bi.aG((String) z2.get(str2 + ".badge_icon"), "");
                            hVar.jNs = bi.aG((String) z2.get(str2 + ".$jump_id"), "");
                            this.jMr.add(hVar);
                            i++;
                        }
                        this.jMX.mName = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
                        this.jMX.jNo = bi.getInt((String) z2.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0;
                        this.jMX.jNh = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
                        z.c(z2, this);
                        z.d(z2, this);
                        this.jMv.jNg = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
                        this.jMv.cZG = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
                        this.jMv.jNh = bi.aG((String) z2.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
                        z.e(z2, this);
                        this.jMt.jNi = bi.getInt((String) z2.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
                        this.jMt.jNg = bi.aG((String) z2.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        this.jMt.gEw = bi.aG((String) z2.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
                        this.jMY.jNt = bi.aG((String) z2.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        this.jMY.hzJ = bi.getInt((String) z2.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        this.jMY.jNu = bi.getLong((String) z2.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                        this.jME = bi.getInt((String) z2.get(".sysmsg.gamecenter.wifi_flag"), 0);
                    } else {
                        x.e("MicroMsg.GameNewMessageParser", "Type not matched");
                    }
                }
            }
            this.jMi = true;
        }
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.sKy = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.sKA.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "msgId";
        aVar.columns[1] = "mergerId";
        aVar.sKA.put("mergerId", "TEXT");
        stringBuilder.append(" mergerId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "gameMsgId";
        aVar.sKA.put("gameMsgId", "TEXT");
        stringBuilder.append(" gameMsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "msgType";
        aVar.sKA.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "createTime";
        aVar.sKA.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expireTime";
        aVar.sKA.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "showInMsgList";
        aVar.sKA.put("showInMsgList", "INTEGER default 'true' ");
        stringBuilder.append(" showInMsgList INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "isRead";
        aVar.sKA.put("isRead", "INTEGER default 'false' ");
        stringBuilder.append(" isRead INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "label";
        aVar.sKA.put("label", "TEXT default '' ");
        stringBuilder.append(" label TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "isHidden";
        aVar.sKA.put("isHidden", "INTEGER default 'false' ");
        stringBuilder.append(" isHidden INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "weight";
        aVar.sKA.put("weight", "TEXT default '' ");
        stringBuilder.append(" weight TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "rawXML";
        aVar.sKA.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "receiveTime";
        aVar.sKA.put("receiveTime", "LONG default '0' ");
        stringBuilder.append(" receiveTime LONG default '0' ");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a AX() {
        return dhO;
    }
}
