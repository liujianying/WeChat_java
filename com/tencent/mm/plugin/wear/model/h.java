package com.tencent.mm.plugin.wear.model;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.aa.f;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public final class h {
    public static final Bitmap PO(String str) {
        Bitmap cJ = b.ccZ().cJ(str);
        if (cJ == null) {
            x.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[]{q.Kp().c(str, false, false)});
            return f.jW(q.Kp().c(str, false, false));
        }
        x.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[]{str});
        return cJ;
    }

    public static String PP(String str) {
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (!s.fq(str)) {
            return r.a(Yg, str);
        }
        String string = ad.getContext().getString(R.l.chatting_roominfo_noname);
        String a = r.a(Yg, str);
        if (Yg.field_username.equals(a) || bi.oW(a)) {
            return string;
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.c.cej aa(com.tencent.mm.storage.bd r9) {
        /*
        r8 = 3;
        r7 = 2;
        r6 = -1;
        r3 = 0;
        r2 = 1;
        r4 = new com.tencent.mm.protocal.c.cej;
        r4.<init>();
        r0 = r9.field_msgId;
        r4.szl = r0;
        r0 = r9.field_createTime;
        r4.szq = r0;
        r4.jQd = r2;
        r4.szr = r2;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x004c;
    L_0x001a:
        r0 = com.tencent.mm.model.q.GF();
        r0 = PP(r0);
        r4.rTW = r0;
        r0 = com.tencent.mm.model.q.GF();
        r4.szk = r0;
    L_0x002a:
        r0 = 0;
        r1 = r9.isSystem();
        if (r1 == 0) goto L_0x0086;
    L_0x0031:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_sys_content;
        r0 = r0.getString(r1);
        r4.jQd = r8;
    L_0x003d:
        if (r0 != 0) goto L_0x0049;
    L_0x003f:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_simple_tip;
        r0 = r0.getString(r1);
    L_0x0049:
        r4.jSA = r0;
        return r4;
    L_0x004c:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.model.s.fq(r0);
        if (r0 == 0) goto L_0x0079;
    L_0x0054:
        r1 = r9.field_talker;
        r0 = r9.field_content;
        r0 = com.tencent.mm.model.bd.iA(r0);
        if (r0 == r6) goto L_0x0443;
    L_0x005e:
        r5 = r9.field_content;
        r0 = r5.substring(r3, r0);
        r0 = r0.trim();
        if (r0 == 0) goto L_0x0443;
    L_0x006a:
        r5 = r0.length();
        if (r5 <= 0) goto L_0x0443;
    L_0x0070:
        r1 = PP(r0);
        r4.rTW = r1;
        r4.szk = r0;
        goto L_0x002a;
    L_0x0079:
        r0 = r9.field_talker;
        r0 = PP(r0);
        r4.rTW = r0;
        r0 = r9.field_talker;
        r4.szk = r0;
        goto L_0x002a;
    L_0x0086:
        r1 = r9.ckA();
        if (r1 == 0) goto L_0x009a;
    L_0x008c:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_img_content;
        r0 = r0.getString(r1);
        r1 = 4;
        r4.jQd = r1;
        goto L_0x003d;
    L_0x009a:
        r1 = r9.isText();
        if (r1 == 0) goto L_0x00ca;
    L_0x00a0:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.model.s.fq(r0);
        if (r0 == 0) goto L_0x00c6;
    L_0x00a8:
        r0 = r9.field_isSend;
        if (r0 == r2) goto L_0x00c6;
    L_0x00ac:
        r0 = r9.field_content;
        r0 = com.tencent.mm.model.bd.iA(r0);
        if (r0 == r6) goto L_0x00c2;
    L_0x00b4:
        r1 = r9.field_content;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = r0.trim();
        goto L_0x003d;
    L_0x00c2:
        r0 = r9.field_content;
        goto L_0x003d;
    L_0x00c6:
        r0 = r9.field_content;
        goto L_0x003d;
    L_0x00ca:
        r1 = r9.ckz();
        if (r1 == 0) goto L_0x0110;
    L_0x00d0:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_voice_content;
        r0 = r0.getString(r1);
        r1 = 6;
        r4.jQd = r1;
        r1 = com.tencent.mm.modelvoice.q.F(r9);
        r4.szr = r1;
        r1 = new com.tencent.mm.modelvoice.n;
        r5 = r9.field_content;
        r1.<init>(r5);
        r6 = r1.time;
        r1 = com.tencent.mm.modelvoice.q.bD(r6);
        r5 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r6 = com.tencent.mm.R.l.fmt_time_length;
        r2 = new java.lang.Object[r2];
        r1 = (int) r1;
        r1 = java.lang.Integer.valueOf(r1);
        r2[r3] = r1;
        r1 = r5.getString(r6, r2);
        r2 = new com.tencent.mm.bk.b;
        r1 = r1.getBytes();
        r2.<init>(r1);
        r4.szs = r2;
        goto L_0x003d;
    L_0x0110:
        r1 = r9.cmj();
        if (r1 == 0) goto L_0x0122;
    L_0x0116:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_video_content;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x0122:
        r1 = r9.cmk();
        if (r1 == 0) goto L_0x0134;
    L_0x0128:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_short_video_content;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x0134:
        r1 = r9.cmb();
        if (r1 == 0) goto L_0x0175;
    L_0x013a:
        r1 = r9.field_content;
        r1 = com.tencent.mm.y.g.a.gp(r1);
        if (r1 == 0) goto L_0x003d;
    L_0x0142:
        r0 = r1.dyc;
        r5 = "wxpay://c2cbizmessagehandler/hongbao/receivehongbao";
        r0 = r0.startsWith(r5);
        if (r0 == 0) goto L_0x015c;
    L_0x014d:
        r0 = 5;
        r4.jQd = r0;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x0158;
    L_0x0154:
        r0 = r1.dxW;
        goto L_0x003d;
    L_0x0158:
        r0 = r1.dxV;
        goto L_0x003d;
    L_0x015c:
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x0172;
    L_0x0160:
        r0 = r1.dxW;
    L_0x0162:
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_c2c_template;
        r2 = new java.lang.Object[r2];
        r2[r3] = r0;
        r0 = r1.getString(r5, r2);
        goto L_0x003d;
    L_0x0172:
        r0 = r1.dxV;
        goto L_0x0162;
    L_0x0175:
        r1 = r9.cmc();
        if (r1 == 0) goto L_0x018a;
    L_0x017b:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_c2c_new_year_lucky_content;
        r0 = r0.getString(r1);
        r1 = 5;
        r4.jQd = r1;
        goto L_0x003d;
    L_0x018a:
        r1 = r9.aQm();
        if (r1 == 0) goto L_0x02ec;
    L_0x0190:
        r1 = r9.field_content;
        r1 = com.tencent.mm.y.g.a.gp(r1);
        if (r1 == 0) goto L_0x003d;
    L_0x0198:
        r5 = r1.type;
        switch(r5) {
            case 2: goto L_0x019f;
            case 3: goto L_0x01ce;
            case 4: goto L_0x0208;
            case 5: goto L_0x01b1;
            case 6: goto L_0x01eb;
            case 7: goto L_0x019d;
            case 8: goto L_0x02d3;
            case 9: goto L_0x019d;
            case 10: goto L_0x025f;
            case 11: goto L_0x019d;
            case 12: goto L_0x019d;
            case 13: goto L_0x027c;
            case 14: goto L_0x019d;
            case 15: goto L_0x0242;
            case 16: goto L_0x02b6;
            case 17: goto L_0x019d;
            case 18: goto L_0x019d;
            case 19: goto L_0x0225;
            case 20: goto L_0x0299;
            default: goto L_0x019d;
        };
    L_0x019d:
        goto L_0x003d;
    L_0x019f:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_img_content;
        r0 = r0.getString(r1);
        r1 = new java.lang.Object[r3];
        r0 = java.lang.String.format(r0, r1);
        goto L_0x003d;
    L_0x01b1:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_link_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x01ce:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_music_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x01eb:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_file_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0208:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_video_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0225:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_record_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0242:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_emoji_share_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x025f:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_product_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x027c:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_mall_product_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0299:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_app_tv_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x02b6:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_card_content;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x02d3:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_custom_emoji_content;
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r6 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r1, r6);
        r2[r3] = r1;
        r0 = r0.getString(r5, r2);
        goto L_0x003d;
    L_0x02ec:
        r1 = r9.cml();
        if (r1 == 0) goto L_0x0391;
    L_0x02f2:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_emoji_content;
        r1 = r0.getString(r1);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        if (r0 == 0) goto L_0x0440;
    L_0x030a:
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r1 = r9.field_imgPath;
        r1 = r0.zi(r1);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r3 = r1.Xh();
        r0 = r0.zf(r3);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0362;
    L_0x0336:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = com.tencent.mm.R.l.notification_emoji_content;
        r0 = r0.getString(r3);
    L_0x0340:
        r3 = new com.tencent.mm.protocal.c.cds;
        r3.<init>();
        r5 = r1.Xh();
        r3.rwt = r5;
        r1 = r1.isGif();
        if (r1 == 0) goto L_0x038e;
    L_0x0351:
        r3.hcE = r2;
    L_0x0353:
        r1 = new com.tencent.mm.bk.b;	 Catch:{ IOException -> 0x043d }
        r2 = r3.toByteArray();	 Catch:{ IOException -> 0x043d }
        r1.<init>(r2);	 Catch:{ IOException -> 0x043d }
        r4.szs = r1;	 Catch:{ IOException -> 0x043d }
    L_0x035e:
        r4.jQd = r7;
        goto L_0x003d;
    L_0x0362:
        r3 = new java.lang.StringBuilder;
        r0 = "[";
        r3.<init>(r0);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r5 = r1.Xh();
        r0 = r0.zf(r5);
        r0 = r3.append(r0);
        r3 = "]";
        r0 = r0.append(r3);
        r0 = r0.toString();
        goto L_0x0340;
    L_0x038e:
        r3.hcE = r7;
        goto L_0x0353;
    L_0x0391:
        r1 = r9.aQo();
        if (r1 == 0) goto L_0x03a3;
    L_0x0397:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_location_content;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03a3:
        r1 = r9.cme();
        if (r1 != 0) goto L_0x03ba;
    L_0x03a9:
        r1 = r9.cmf();
        if (r1 != 0) goto L_0x03ba;
    L_0x03af:
        r1 = r9.getType();
        r5 = 64;
        if (r1 != r5) goto L_0x03ed;
    L_0x03b7:
        r1 = r2;
    L_0x03b8:
        if (r1 == 0) goto L_0x03fd;
    L_0x03ba:
        r0 = r9.field_content;
        r1 = com.tencent.mm.storage.bd.tbx;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x03e1;
    L_0x03c4:
        r0 = r9.field_content;
        r1 = new com.tencent.mm.g.a.su;
        r1.<init>();
        r5 = r1.cdE;
        r5.bOh = r2;
        r5 = r1.cdE;
        r5.content = r0;
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r0.m(r1);
        r0 = r1.cdF;
        r0 = r0.type;
        if (r0 != r8) goto L_0x03ef;
    L_0x03de:
        r0 = r2;
    L_0x03df:
        if (r0 == 0) goto L_0x03f1;
    L_0x03e1:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_voip_voice_content;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03ed:
        r1 = r3;
        goto L_0x03b8;
    L_0x03ef:
        r0 = r3;
        goto L_0x03df;
    L_0x03f1:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_voip_content;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03fd:
        r1 = r9.cmi();
        if (r1 == 0) goto L_0x0428;
    L_0x0403:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r1 = r9.field_content;
        r0 = r0.GR(r1);
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.notification_card_content;
        r1 = r1.getString(r5);
        r2 = new java.lang.Object[r2];
        r0 = r0.getDisplayName();
        r2[r3] = r0;
        r0 = java.lang.String.format(r1, r2);
        goto L_0x003d;
    L_0x0428:
        r1 = r9.getType();
        r2 = -1879048186; // 0xffffffff90000006 float:-2.5243567E-29 double:NaN;
        if (r1 != r2) goto L_0x003d;
    L_0x0431:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.notification_app_location_share_content;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x043d:
        r1 = move-exception;
        goto L_0x035e;
    L_0x0440:
        r0 = r1;
        goto L_0x003d;
    L_0x0443:
        r0 = r1;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.h.aa(com.tencent.mm.storage.bd):com.tencent.mm.protocal.c.cej");
    }

    public static byte[] N(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean aEo() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean aEp() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static byte[] PQ(String str) {
        return FileOp.e(new File(new File(com.tencent.mm.loader.stub.b.duM, "lib"), "lib" + str + ".so").getAbsolutePath(), 0, -1);
    }
}
