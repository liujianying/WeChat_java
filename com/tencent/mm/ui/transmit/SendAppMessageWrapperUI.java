package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MotionEvent;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.v;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.protocal.c.cgm;
import com.tencent.mm.protocal.c.cgn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class SendAppMessageWrapperUI extends MMActivity {
    private al bAZ = new al(new 1(this), true);
    private String bhd = null;
    private int jgc = 0;
    private int scene = 0;
    private WXMediaMessage tLD = null;
    private p tipDialog;
    private String toUser = null;
    private f uEI = null;
    private boolean uEJ = false;

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, WXMediaMessage wXMediaMessage, String str, int i) {
        x.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc msg[%s], text[%s], parsterLen[%d], scene[%d]", new Object[]{wXMediaMessage, str, Integer.valueOf(i), Integer.valueOf(sendAppMessageWrapperUI.scene)});
        if (sendAppMessageWrapperUI.scene == 0) {
            String str2;
            String ic;
            String str3;
            String str4;
            br.IE().c(38, new Object[]{Integer.valueOf(1)});
            if (wXMediaMessage.getType() != 8) {
                str2 = null;
            } else if (wXMediaMessage.thumbData == null) {
                x.e("MicroMsg.SendAppMessageWrapperUI", "summerbig code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                return;
            } else {
                str2 = ((c) g.n(c.class)).getEmojiMgr().a(sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.uEI.field_appId);
                if (str2 == null) {
                    x.v("MicroMsg.SendAppMessageWrapperUI", "summerbig sendEmoji Fail cause emojiconmd5 is null");
                    return;
                }
                EmojiInfo zi = ((c) g.n(c.class)).getEmojiMgr().zi(str2);
                if (zi == null) {
                    x.i("MicroMsg.SendAppMessageWrapperUI", "emoji is null.");
                    return;
                }
                if (zi.field_size > bi.getInt(com.tencent.mm.k.g.AT().getValue("InputLimitSendThirdPartyAppMsgEmotionBufSize"), 524288)) {
                    x.i("MicroMsg.SendAppMessageWrapperUI", "third party shared emoji can't bigger 512 KB");
                }
                h.mEJ.h(13461, new Object[]{sendAppMessageWrapperUI.uEI.field_appId, sendAppMessageWrapperUI.uEI.field_appName, Integer.valueOf(zi.field_size)});
            }
            if (wXMediaMessage.getType() == 5 || wXMediaMessage.getType() == 2) {
                x.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), appId : %s", new Object[]{sendAppMessageWrapperUI.uEI.field_appId});
                ic = u.ic("app_" + sendAppMessageWrapperUI.uEI.field_appId);
                u.Hx().v(ic, true).p("prePublishId", "app_" + sendAppMessageWrapperUI.uEI.field_appId);
            } else {
                ic = null;
            }
            LinkedList linkedList = new LinkedList(bi.F(sendAppMessageWrapperUI.toUser.split(",")));
            if (wXMediaMessage.getType() == 36) {
                sendAppMessageWrapperUI.b(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 2) {
                sendAppMessageWrapperUI.a(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 38) {
                sendAppMessageWrapperUI.c(wXMediaMessage, linkedList);
            } else {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    str3 = (String) it.next();
                    l.a(wXMediaMessage, sendAppMessageWrapperUI.uEI.field_appId, sendAppMessageWrapperUI.uEI.field_appName, str3, 2, str2, ic);
                }
            }
            if (sendAppMessageWrapperUI.uEI.field_appId.equals("wx4310bbd51be7d979")) {
                str4 = null;
            } else {
                str4 = sendAppMessageWrapperUI.getString(R.l.confirm_dialog_back_app, new Object[]{sendAppMessageWrapperUI.uEI.field_appName});
            }
            if (str4 == null) {
                str4 = sendAppMessageWrapperUI.getString(R.l.confirm_dialog_back);
            }
            str3 = sendAppMessageWrapperUI.getString(R.l.confirm_dialog_stay_in_weixin);
            4 4 = new 4(sendAppMessageWrapperUI);
            com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, sendAppMessageWrapperUI.getString(R.l.confirm_dialog_sent), str4, str3, new 5(sendAppMessageWrapperUI), 4);
            if (str == null || str.length() == 0) {
                x.i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
                return;
            }
            x.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:" + str);
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                au.DF().a(new i((String) it2.next(), str, s.hQ(sendAppMessageWrapperUI.toUser)), 0);
            }
            return;
        }
        if (n.nkw != null) {
            n.nkw.a(wXMediaMessage, str, sendAppMessageWrapperUI.uEI.field_appId, sendAppMessageWrapperUI.uEI.field_appName, i);
            n.nkw.bwX();
        }
        ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), 0));
        sendAppMessageWrapperUI.finish();
    }

    static /* synthetic */ int b(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        int i = sendAppMessageWrapperUI.jgc + 1;
        sendAppMessageWrapperUI.jgc = i;
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(com.tencent.mm.ui.transmit.SendAppMessageWrapperUI r11) {
        /*
        r6 = 0;
        r10 = 0;
        r3 = 1;
        r0 = r11.tLD;
        if (r0 != 0) goto L_0x0011;
    L_0x0007:
        r0 = "MicroMsg.SendAppMessageWrapperUI";
        r1 = "deal fail, WXMediaMessage is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0010:
        return;
    L_0x0011:
        r0 = r11.tLD;
        r0 = r0.getType();
        switch(r0) {
            case 1: goto L_0x0040;
            case 2: goto L_0x0076;
            case 3: goto L_0x00c3;
            case 4: goto L_0x00ef;
            case 5: goto L_0x011a;
            case 6: goto L_0x018d;
            case 7: goto L_0x013d;
            case 8: goto L_0x01b8;
            case 36: goto L_0x022d;
            case 38: goto L_0x02ca;
            default: goto L_0x001a;
        };
    L_0x001a:
        r1 = "MicroMsg.SendAppMessageWrapperUI";
        r2 = new java.lang.StringBuilder;
        r3 = "unknown type = ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        r3 = r10;
    L_0x0031:
        if (r3 != 0) goto L_0x0010;
    L_0x0033:
        r0 = "MicroMsg.SendAppMessageWrapperUI";
        r1 = "deal fail, result is false";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r11.finish();
        goto L_0x0010;
    L_0x0040:
        r1 = r11.tLD;
        r0 = r1.mediaObject;
        r0 = (com.tencent.mm.opensdk.modelmsg.WXTextObject) r0;
        r2 = r0.text;
        if (r2 == 0) goto L_0x0052;
    L_0x004a:
        r0 = r0.text;
        r0 = r0.length();
        if (r0 != 0) goto L_0x005d;
    L_0x0052:
        r0 = "MicroMsg.SendAppMessageWrapperUI";
        r1 = "dealText fail, text is empty";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x005b:
        r3 = r10;
        goto L_0x0031;
    L_0x005d:
        r0 = r11.uEI;
        r0 = r0.field_appId;
        r2 = "wx4310bbd51be7d979";
        r0.equals(r2);
        r0 = r11.mController;
        r2 = r1.description;
        r1 = r11.a(r1);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r0, r2, r3, r1);
        if (r0 == 0) goto L_0x005b;
    L_0x0075:
        goto L_0x0031;
    L_0x0076:
        r1 = r11.tLD;
        r0 = r1.thumbData;
        if (r0 == 0) goto L_0x009a;
    L_0x007c:
        r0 = r1.thumbData;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x009a;
    L_0x0081:
        r0 = r11.mController;
        r2 = r1.thumbData;
        r1 = r11.a(r1);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r0, r2, r3, r1);
    L_0x008d:
        if (r0 != 0) goto L_0x00c1;
    L_0x008f:
        r0 = "MicroMsg.SendAppMessageWrapperUI";
        r1 = "showDialogItem3 fail, invalid argument";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0098:
        r3 = r10;
        goto L_0x0031;
    L_0x009a:
        r0 = r1.mediaObject;
        r0 = (com.tencent.mm.opensdk.modelmsg.WXImageObject) r0;
        r2 = r0.imageData;
        if (r2 == 0) goto L_0x00b4;
    L_0x00a2:
        r2 = r0.imageData;
        r2 = r2.length;
        if (r2 <= 0) goto L_0x00b4;
    L_0x00a7:
        r2 = r11.mController;
        r0 = r0.imageData;
        r1 = r11.a(r1);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r2, r0, r3, r1);
        goto L_0x008d;
    L_0x00b4:
        r2 = r11.mController;
        r0 = r0.imagePath;
        r1 = r11.a(r1);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.b(r2, r0, r3, r1);
        goto L_0x008d;
    L_0x00c1:
        r10 = r3;
        goto L_0x0098;
    L_0x00c3:
        r0 = r11.tLD;
        r1 = r0.thumbData;
        if (r1 == 0) goto L_0x00e0;
    L_0x00c9:
        r1 = r0.thumbData;
        r1 = r1.length;
        if (r1 <= 0) goto L_0x00e0;
    L_0x00ce:
        r1 = r11.mController;
        r2 = r0.title;
        r4 = 2;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r3, r4, r0);
    L_0x00db:
        if (r0 != 0) goto L_0x0031;
    L_0x00dd:
        r3 = r10;
        goto L_0x0031;
    L_0x00e0:
        r1 = r11.mController;
        r2 = com.tencent.mm.R.k.app_attach_file_icon_music;
        r4 = r0.title;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r4, r3, r0);
        goto L_0x00db;
    L_0x00ef:
        r0 = r11.tLD;
        r1 = r0.thumbData;
        if (r1 == 0) goto L_0x010b;
    L_0x00f5:
        r1 = r0.thumbData;
        r1 = r1.length;
        if (r1 <= 0) goto L_0x010b;
    L_0x00fa:
        r1 = r11.mController;
        r2 = r0.title;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r3, r3, r0);
    L_0x0106:
        if (r0 != 0) goto L_0x0031;
    L_0x0108:
        r3 = r10;
        goto L_0x0031;
    L_0x010b:
        r1 = r11.mController;
        r2 = com.tencent.mm.R.k.app_attach_file_icon_video;
        r4 = r0.title;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r4, r3, r0);
        goto L_0x0106;
    L_0x011a:
        r5 = r11.tLD;
        r0 = r11.mController;
        r1 = r5.title;
        r2 = r5.description;
        r4 = r11.mController;
        r4 = r4.tml;
        r4 = r4.getResources();
        r6 = com.tencent.mm.R.l.confirm_dialog_share;
        r4 = r4.getString(r6);
        r5 = r11.a(r5);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r0, r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x0031;
    L_0x013a:
        r3 = r10;
        goto L_0x0031;
    L_0x013d:
        r0 = r11.tLD;
        r1 = r0.thumbData;
        if (r1 == 0) goto L_0x0159;
    L_0x0143:
        r1 = r0.thumbData;
        r1 = r1.length;
        if (r1 <= 0) goto L_0x0159;
    L_0x0148:
        r1 = r11.mController;
        r2 = r0.title;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r3, r10, r0);
    L_0x0154:
        if (r0 != 0) goto L_0x0031;
    L_0x0156:
        r3 = r10;
        goto L_0x0031;
    L_0x0159:
        r1 = r11.uEI;
        r1 = r1.field_appId;
        r2 = com.tencent.mm.bp.a.getDensity(r11);
        r5 = com.tencent.mm.pluginsdk.model.app.g.b(r1, r3, r2);
        if (r5 == 0) goto L_0x017e;
    L_0x0167:
        r1 = r5.isRecycled();
        if (r1 != 0) goto L_0x017e;
    L_0x016d:
        r4 = r11.mController;
        r6 = r0.title;
        r7 = r0.description;
        r8 = r11.bhd;
        r9 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r4, r5, r6, r7, r8, r9);
        goto L_0x0154;
    L_0x017e:
        r1 = r11.mController;
        r2 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r4 = r0.title;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r4, r3, r0);
        goto L_0x0154;
    L_0x018d:
        r0 = r11.tLD;
        r1 = r0.thumbData;
        if (r1 == 0) goto L_0x01a9;
    L_0x0193:
        r1 = r0.thumbData;
        r1 = r1.length;
        if (r1 <= 0) goto L_0x01a9;
    L_0x0198:
        r1 = r11.mController;
        r2 = r0.title;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r3, r10, r0);
    L_0x01a4:
        if (r0 != 0) goto L_0x0031;
    L_0x01a6:
        r3 = r10;
        goto L_0x0031;
    L_0x01a9:
        r1 = r11.mController;
        r2 = com.tencent.mm.R.k.app_attach_file_icon_file;
        r4 = r0.title;
        r0 = r11.a(r0);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r1, r2, r4, r3, r0);
        goto L_0x01a4;
    L_0x01b8:
        r1 = r11.tLD;
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.n(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r2 = r11.uEI;
        r2 = r2.field_appId;
        r0 = r0.a(r11, r1, r2);
        r2 = r11.mController;
        r2 = r2.tml;
        r2 = r2.getIntent();
        r2 = r2.getExtras();
        r4 = "Select_Conv_User";
        r2 = r2.getString(r4, r6);
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r4 != 0) goto L_0x021a;
    L_0x01e7:
        r4 = new com.tencent.mm.pluginsdk.ui.applet.g$a;
        r5 = r11.mController;
        r5 = r5.tml;
        r4.<init>(r5);
        r2 = r4.bZ(r2);
        r0 = r2.TJ(r0);
        r2 = java.lang.Boolean.valueOf(r3);
        r0 = r0.g(r2);
        r2 = com.tencent.mm.R.l.app_send;
        r0 = r0.BX(r2);
        r1 = r11.a(r1);
        r0 = r0.a(r1);
        r0 = r0.eIW;
        r0.show();
        r0 = r4.eIW;
        if (r0 != 0) goto L_0x0031;
    L_0x0217:
        r3 = r10;
        goto L_0x0031;
    L_0x021a:
        r0 = r11.mController;
        r2 = com.tencent.mm.R.k.app_attach_file_icon_webpage;
        r4 = r1.title;
        r1 = r11.a(r1);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r0, r2, r4, r3, r1);
        if (r0 != 0) goto L_0x0031;
    L_0x022a:
        r3 = r10;
        goto L_0x0031;
    L_0x022d:
        r2 = r11.tLD;
        if (r2 == 0) goto L_0x0237;
    L_0x0231:
        r0 = r2.mediaObject;
        r0 = r0 instanceof com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
        if (r0 != 0) goto L_0x023a;
    L_0x0237:
        r3 = r10;
        goto L_0x0031;
    L_0x023a:
        r0 = r2.mediaObject;
        r0 = (com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject) r0;
        r1 = com.tencent.mm.plugin.appbrand.n.c.class;
        r1 = com.tencent.mm.kernel.g.l(r1);
        r1 = (com.tencent.mm.plugin.appbrand.n.c) r1;
        r4 = r0.userName;
        r1.rR(r4);
        r4 = new com.tencent.mm.pluginsdk.ui.applet.g$a;
        r1 = r11.mController;
        r1 = r1.tml;
        r4.<init>(r1);
        r1 = r11.mController;
        r1 = r1.tml;
        r1 = r1.getIntent();
        r1 = r1.getExtras();
        r5 = "Select_Conv_User";
        r1 = r1.getString(r5, r6);
        r4.bZ(r1);
        r1 = com.tencent.mm.modelappbrand.g.class;
        r1 = com.tencent.mm.kernel.g.l(r1);
        r1 = (com.tencent.mm.modelappbrand.g) r1;
        r1 = r1.bH(r11);
        r5 = com.tencent.mm.plugin.appbrand.q.k.bq(r11);
        r6 = new android.os.Bundle;
        r6.<init>();
        r7 = "image_data";
        r8 = r2.thumbData;
        r6.putByteArray(r7, r8);
        r7 = "title";
        r8 = r2.title;
        r6.putString(r7, r8);
        r7 = "msg_path";
        r0 = r0.path;
        r6.putString(r7, r0);
        r0 = com.tencent.mm.modelappbrand.g.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.modelappbrand.g) r0;
        r0.a(r5, r1, r6);
        r4.dh(r1);
        r0 = java.lang.Boolean.valueOf(r3);
        r4.g(r0);
        r4.cdQ();
        r0 = new com.tencent.mm.ui.transmit.SendAppMessageWrapperUI$2;
        r0.<init>(r11, r5, r1);
        r4.gFM = r0;
        r0 = com.tencent.mm.R.l.app_send;
        r4.BX(r0);
        r0 = r11.a(r2);
        r0 = r4.a(r0);
        r0 = r0.eIW;
        r0.show();
        goto L_0x0031;
    L_0x02ca:
        r5 = r11.tLD;
        r0 = r11.mController;
        r1 = r5.title;
        r2 = r5.description;
        r4 = r11.mController;
        r4 = r4.tml;
        r4 = r4.getResources();
        r6 = com.tencent.mm.R.l.confirm_dialog_share;
        r4 = r4.getString(r6);
        r5 = r11.a(r5);
        r6 = r11.getResources();
        r7 = com.tencent.mm.R.l.app_video;
        r6 = r6.getString(r7);
        r0 = com.tencent.mm.pluginsdk.ui.applet.g.a(r0, r1, r2, r3, r4, r5, r6);
        if (r0 != 0) goto L_0x0031;
    L_0x02f4:
        r3 = r10;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.c(com.tencent.mm.ui.transmit.SendAppMessageWrapperUI):void");
    }

    static /* synthetic */ void d(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        if (sendAppMessageWrapperUI.scene == 0) {
            Intent intent = new Intent();
            intent.putExtra("Select_Report_Args", ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
            sendAppMessageWrapperUI.setResult(0, intent);
        } else {
            ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
        }
        sendAppMessageWrapperUI.finish();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
        r12 = this;
        super.onCreate(r13);
        r0 = r12.getSupportActionBar();
        r0.hide();
        r0 = com.tencent.mm.sdk.platformtools.ad.chY();
        r1 = 0;
        r0 = r12.getSharedPreferences(r0, r1);
        r1 = "settings_landscape_mode";
        r2 = 0;
        r1 = r0.getBoolean(r1, r2);
        if (r1 != 0) goto L_0x003c;
    L_0x001d:
        r1 = "MicroMsg.SendAppMessageWrapperUI";
        r2 = "change orientation";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = 1;
        r12.uEJ = r1;
        r1 = -1;
        r12.setRequestedOrientation(r1);
        r0 = r0.edit();
        r1 = "settings_landscape_mode";
        r2 = 1;
        r0 = r0.putBoolean(r1, r2);
        r0.commit();
    L_0x003c:
        r0 = r12.getIntent();
        r1 = r0.getExtras();
        r2 = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
        r2.<init>(r1);
        r0 = "Select_Conv_User";
        r0 = r1.getString(r0);
        r12.toUser = r0;
        r0 = "SendAppMessageWrapper_Scene";
        r3 = 0;
        r0 = r1.getInt(r0, r3);
        r12.scene = r0;
        r0 = "SendAppMessageWrapper_AppId";
        r0 = r1.getString(r0);
        if (r0 != 0) goto L_0x03df;
    L_0x0065:
        r0 = "_mmessage_content";
        r0 = r1.getString(r0);
        r0 = android.net.Uri.parse(r0);
        r1 = "appid";
        r0 = r0.getQueryParameter(r1);
        r1 = r0;
    L_0x0078:
        r0 = new com.tencent.mm.pluginsdk.model.app.f;
        r0.<init>();
        r12.uEI = r0;
        r0 = r12.uEI;
        r0.field_appId = r1;
        r0 = com.tencent.mm.pluginsdk.model.app.ao.bmf();
        r3 = r12.uEI;
        r4 = 0;
        r4 = new java.lang.String[r4];
        r0.b(r3, r4);
        r0 = r12.uEI;
        r0 = r0.field_appName;
        if (r0 != 0) goto L_0x00d6;
    L_0x0095:
        r0 = com.tencent.mm.R.l.confirm_dialog_unknown_source;
        r0 = r12.getString(r0);
    L_0x009b:
        r3 = com.tencent.mm.R.l.confirm_dialog_source;
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        r0 = r12.getString(r3, r4);
        r12.bhd = r0;
        r0 = r2.message;
        r12.tLD = r0;
        r0 = "MicroMsg.SendAppMessageWrapperUI";
        r2 = "onCreate, messageAction = %s, messageExt = %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r12.tLD;
        r5 = r5.messageAction;
        r3[r4] = r5;
        r4 = 1;
        r5 = r12.tLD;
        r5 = r5.messageExt;
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = r12.scene;
        r2 = 1;
        if (r0 != r2) goto L_0x03ce;
    L_0x00cc:
        r0 = r12.tLD;
        r0 = r0.mediaObject;
        if (r0 != 0) goto L_0x00e2;
    L_0x00d2:
        r12.finish();
    L_0x00d5:
        return;
    L_0x00d6:
        r0 = r12.mController;
        r0 = r0.tml;
        r3 = r12.uEI;
        r4 = 0;
        r0 = com.tencent.mm.pluginsdk.model.app.g.b(r0, r3, r4);
        goto L_0x009b;
    L_0x00e2:
        r0 = r12.tLD;
        r0 = r0.getType();
        r2 = 38;
        if (r0 != r2) goto L_0x0214;
    L_0x00ec:
        r0 = r12.tLD;
        r0 = r0.mediaObject;
        r0 = (com.tencent.mm.opensdk.modelmsg.WXVideoFileObject) r0;
        r5 = r0.filePath;
        r2 = r0.filePath;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x01e6;
    L_0x00fc:
        r2 = r0.filePath;
        r2 = com.tencent.mm.a.e.cn(r2);
        if (r2 == 0) goto L_0x01e6;
    L_0x0104:
        r4 = 0;
        r3 = new android.media.MediaMetadataRetriever;	 Catch:{ Exception -> 0x0196, all -> 0x01c9 }
        r3.<init>();	 Catch:{ Exception -> 0x0196, all -> 0x01c9 }
        r3.setDataSource(r5);	 Catch:{ Exception -> 0x03dc }
        r2 = 9;
        r2 = r3.extractMetadata(r2);	 Catch:{ Exception -> 0x03dc }
        r4 = -1;
        r4 = com.tencent.mm.sdk.platformtools.bi.getInt(r2, r4);	 Catch:{ Exception -> 0x03dc }
        r2 = 10;
        r6 = "wx5dfbe0a95623607b";
        r6 = r6.equals(r1);	 Catch:{ Exception -> 0x03dc }
        if (r6 == 0) goto L_0x0130;
    L_0x0123:
        r2 = com.tencent.mm.k.g.AT();	 Catch:{ Exception -> 0x03dc }
        r6 = "WeiShiShareSnsSightTimeLength";
        r7 = 10;
        r2 = r2.getInt(r6, r7);	 Catch:{ Exception -> 0x03dc }
    L_0x0130:
        r6 = "MicroMsg.SendAppMessageWrapperUI";
        r7 = "video duration %d, durLimit:%d";
        r8 = 2;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x03dc }
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x03dc }
        r8[r9] = r10;	 Catch:{ Exception -> 0x03dc }
        r9 = 1;
        r10 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x03dc }
        r8[r9] = r10;	 Catch:{ Exception -> 0x03dc }
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);	 Catch:{ Exception -> 0x03dc }
        r6 = (double) r4;	 Catch:{ Exception -> 0x03dc }
        r8 = (double) r2;	 Catch:{ Exception -> 0x03dc }
        r10 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r8 = r8 + r10;
        r10 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r8 = r8 * r10;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x0160;
    L_0x0159:
        r2 = -5;
        r12.setResult(r2);	 Catch:{ Exception -> 0x03dc }
        r12.finish();	 Catch:{ Exception -> 0x03dc }
    L_0x0160:
        r3.release();	 Catch:{ Exception -> 0x0181 }
    L_0x0163:
        r2 = "wx5dfbe0a95623607b";
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x01f4;
    L_0x016c:
        r1 = r0.filePath;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x01eb;
    L_0x0174:
        r0 = r0.filePath;
        r0 = com.tencent.mm.a.e.cn(r0);
        if (r0 == 0) goto L_0x01eb;
    L_0x017c:
        r12.cAj();
        goto L_0x00d5;
    L_0x0181:
        r2 = move-exception;
        r3 = "MicroMsg.SendAppMessageWrapperUI";
        r4 = "%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r2.getMessage();
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r6);
        goto L_0x0163;
    L_0x0196:
        r2 = move-exception;
        r3 = r4;
    L_0x0198:
        r4 = "MicroMsg.SendAppMessageWrapperUI";
        r6 = "Analysis duration of mediaItem %s error %s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x03d9 }
        r8 = 0;
        r7[r8] = r5;	 Catch:{ all -> 0x03d9 }
        r8 = 1;
        r9 = r2.getMessage();	 Catch:{ all -> 0x03d9 }
        r7[r8] = r9;	 Catch:{ all -> 0x03d9 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r2, r6, r7);	 Catch:{ all -> 0x03d9 }
        if (r3 == 0) goto L_0x0163;
    L_0x01b0:
        r3.release();	 Catch:{ Exception -> 0x01b4 }
        goto L_0x0163;
    L_0x01b4:
        r2 = move-exception;
        r3 = "MicroMsg.SendAppMessageWrapperUI";
        r4 = "%s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r2.getMessage();
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r6);
        goto L_0x0163;
    L_0x01c9:
        r0 = move-exception;
        r3 = r4;
    L_0x01cb:
        if (r3 == 0) goto L_0x01d0;
    L_0x01cd:
        r3.release();	 Catch:{ Exception -> 0x01d1 }
    L_0x01d0:
        throw r0;
    L_0x01d1:
        r1 = move-exception;
        r2 = "MicroMsg.SendAppMessageWrapperUI";
        r3 = "%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r1.getMessage();
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x01d0;
    L_0x01e6:
        r12.finish();
        goto L_0x0163;
    L_0x01eb:
        r0 = -5;
        r12.setResult(r0);
        r12.finish();
        goto L_0x00d5;
    L_0x01f4:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "K_SEGMENTVIDEOPATH";
        r0.putExtra(r1, r5);
        r1 = "KSEGMENTVIDEOTHUMBPATH";
        r2 = "";
        r0.putExtra(r1, r2);
        r1 = "mmsight";
        r2 = ".segment.VideoCompressUI";
        r3 = 2;
        com.tencent.mm.bg.d.b(r12, r1, r2, r0, r3);
        goto L_0x00d5;
    L_0x0214:
        r0 = r12.tLD;
        r0 = r0.getType();
        r1 = 39;
        if (r0 != r1) goto L_0x03c9;
    L_0x021e:
        r0 = r12.tLD;
        r0 = r0.mediaObject;
        r0 = (com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject) r0;
        r1 = r0.filePath;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x025b;
    L_0x022c:
        r1 = r0.filePath;
        r1 = com.tencent.mm.a.e.cn(r1);
        if (r1 == 0) goto L_0x025b;
    L_0x0234:
        r1 = r0.filePath;
        r0 = com.tencent.mm.k.g.AT();
        r2 = "ShareVideoMaxSize";
        r3 = 4194304; // 0x400000 float:5.877472E-39 double:2.0722615E-317;
        r0 = r0.getInt(r2, r3);
        r2 = com.tencent.mm.modelsfs.FileOp.mI(r1);
        r4 = (long) r0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0270;
    L_0x024c:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "file len too big ";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        r0 = 1;
    L_0x0256:
        if (r0 == 0) goto L_0x0272;
    L_0x0258:
        r0 = 1;
    L_0x0259:
        if (r0 == 0) goto L_0x03c9;
    L_0x025b:
        r0 = r12.getIntent();
        r0 = r0.getExtras();
        r1 = -5;
        r0 = com.tencent.mm.pluginsdk.model.app.ReportUtil.c(r0, r1);
        com.tencent.mm.pluginsdk.model.app.ReportUtil.a(r12, r0);
        r12.finish();
        goto L_0x00d5;
    L_0x0270:
        r0 = 0;
        goto L_0x0256;
    L_0x0272:
        r1 = com.tencent.mm.modelsns.a.a.na(r1);
        r0 = r1.videoWidth;
        if (r0 <= 0) goto L_0x0298;
    L_0x027a:
        r0 = r1.videoHeight;
        if (r0 <= 0) goto L_0x0298;
    L_0x027e:
        r0 = r1.videoWidth;
        r0 = (float) r0;
        r2 = r1.videoHeight;
        r2 = (float) r2;
        r0 = r0 / r2;
        r2 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x0298;
    L_0x028b:
        r0 = r1.videoWidth;
        r0 = (float) r0;
        r2 = r1.videoHeight;
        r2 = (float) r2;
        r0 = r0 / r2;
        r2 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x032e;
    L_0x0298:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "check ratio faild width = [%d], height = [%d]";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r1.videoWidth;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = r1.videoHeight;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = 1;
    L_0x02b7:
        if (r0 != 0) goto L_0x032b;
    L_0x02b9:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "check duration %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r1.egD;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = r1.egD;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r0 > r2) goto L_0x0330;
    L_0x02d4:
        r0 = 1;
    L_0x02d5:
        if (r0 != 0) goto L_0x032b;
    L_0x02d7:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "checkFormat() called with: item = [%s]";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r0, r2, r3);
        r0 = r1.egA;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0317;
    L_0x02ee:
        r0 = r1.egA;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r2 == 0) goto L_0x033a;
    L_0x02f6:
        r0 = 1;
    L_0x02f7:
        if (r0 != 0) goto L_0x0317;
    L_0x02f9:
        r0 = "video/avc";
        r2 = r1.egB;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 == 0) goto L_0x0317;
    L_0x0304:
        r0 = r1.egC;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x03c3;
    L_0x030c:
        r0 = "audio/mp4a-latm";
        r2 = r1.egC;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x03c3;
    L_0x0317:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "check video format failed, dst format [video/avc], video format [%s]";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r1 = r1.egB;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = 1;
    L_0x0329:
        if (r0 == 0) goto L_0x03c6;
    L_0x032b:
        r0 = 1;
        goto L_0x0259;
    L_0x032e:
        r0 = 0;
        goto L_0x02b7;
    L_0x0330:
        r0 = r1.egD;
        r2 = 10500; // 0x2904 float:1.4714E-41 double:5.1877E-320;
        if (r0 < r2) goto L_0x0338;
    L_0x0336:
        r0 = 1;
        goto L_0x02d5;
    L_0x0338:
        r0 = 0;
        goto L_0x02d5;
    L_0x033a:
        r2 = com.tencent.mm.modelsns.a.egz;
        if (r2 != 0) goto L_0x039b;
    L_0x033e:
        r2 = new java.util.HashSet;
        r2.<init>();
        com.tencent.mm.modelsns.a.egz = r2;
        r3 = ".h264";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".h26l";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".264";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".avc";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".mov";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".mp4";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".m4a";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".3gp";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".3g2";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".mj2";
        r2.add(r3);
        r2 = com.tencent.mm.modelsns.a.egz;
        r3 = ".m4v";
        r2.add(r3);
    L_0x039b:
        r0 = r0.trim();
        r2 = ".";
        r2 = r0.lastIndexOf(r2);
        if (r2 < 0) goto L_0x03ae;
    L_0x03a8:
        r3 = r0.length();
        if (r2 < r3) goto L_0x03b1;
    L_0x03ae:
        r0 = 1;
        goto L_0x02f7;
    L_0x03b1:
        r3 = com.tencent.mm.modelsns.a.egz;
        r0 = r0.substring(r2);
        r0 = r3.contains(r0);
        if (r0 != 0) goto L_0x03c0;
    L_0x03bd:
        r0 = 1;
        goto L_0x02f7;
    L_0x03c0:
        r0 = 0;
        goto L_0x02f7;
    L_0x03c3:
        r0 = 0;
        goto L_0x0329;
    L_0x03c6:
        r0 = 0;
        goto L_0x0259;
    L_0x03c9:
        r12.cAj();
        goto L_0x00d5;
    L_0x03ce:
        r0 = r12.bAZ;
        r2 = 100;
        r4 = 100;
        r0.J(r2, r4);
        goto L_0x00d5;
    L_0x03d9:
        r0 = move-exception;
        goto L_0x01cb;
    L_0x03dc:
        r2 = move-exception;
        goto L_0x0198;
    L_0x03df:
        r1 = r0;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.onCreate(android.os.Bundle):void");
    }

    private void cAj() {
        Intent a = com.tencent.mm.modelsns.a.a(this.tLD, this.uEI.field_appId, this.uEI.field_appName);
        if (a == null) {
            finish();
            return;
        }
        String str = null;
        if (this.tLD.getType() == 5 || this.tLD.getType() == 2 || this.tLD.getType() == 38) {
            x.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[]{this.uEI.field_appId});
            String ic = u.ic("app_" + this.uEI.field_appId);
            b v = u.Hx().v(ic, true);
            v.p("prePublishId", "app_" + this.uEI.field_appId);
            if (this.tLD.mediaObject instanceof WXWebpageObject) {
                v.p(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, ((WXWebpageObject) this.tLD.mediaObject).webpageUrl);
            }
            str = ic;
        }
        a.putExtra("reportSessionId", str);
        d.b(this, "sns", ".ui.SnsUploadUI", a, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + i + " resultCode " + i2);
        if (i == 1) {
            if (i2 == -1) {
                ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0));
            } else {
                ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), -2));
            }
            finish();
        } else if (i == 2 && i2 == -1) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.tLD.mediaObject;
            wXVideoFileObject.filePath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
            if (bi.oW(wXVideoFileObject.filePath) || !e.cn(wXVideoFileObject.filePath)) {
                setResult(-5);
                finish();
                return;
            }
            cAj();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.uEJ) {
            x.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
            SharedPreferences sharedPreferences = getSharedPreferences(ad.chY(), 0);
            setRequestedOrientation(1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        YC();
        return super.onTouchEvent(motionEvent);
    }

    private q.a a(WXMediaMessage wXMediaMessage) {
        return new 3(this, wXMediaMessage);
    }

    private void a(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        String str;
        if (wXMediaMessage == null || !(wXMediaMessage.mediaObject instanceof WXImageObject)) {
            x.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
            str = null;
        } else {
            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
            if (bi.bC(wXImageObject.imageData)) {
                str = wXImageObject.imagePath;
            } else {
                x.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + wXImageObject.imageData.length);
                str = l.bh(wXImageObject.imageData);
            }
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
            return;
        }
        int i;
        String str2;
        if (e.cm(str) > 26214400) {
            i = 0;
        } else {
            i = 1;
        }
        String str3 = this.uEI.field_appId;
        String str4 = wXMediaMessage.mediaTagName;
        String str5 = wXMediaMessage.messageExt;
        String str6 = wXMediaMessage.messageAction;
        if (bi.oW(str3)) {
            str2 = null;
        } else {
            str2 = "<msg>" + com.tencent.mm.ak.f.c(str3, str4, str5, str6) + "</msg>";
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            au.DF().a(new com.tencent.mm.ak.l(6, com.tencent.mm.model.q.GF(), (String) it.next(), str, i, null, 0, str2, "", true, R.g.chat_img_to_bg_mask), 0);
        }
    }

    private void b(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        String str;
        WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage.mediaObject;
        ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(wXMiniProgramObject.userName);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.uEI.field_appId);
        stringBuilder.append("_");
        au.HU();
        stringBuilder.append(o.getString(com.tencent.mm.model.c.Df()));
        stringBuilder.append("_");
        stringBuilder.append(bi.VE());
        stringBuilder.append("_");
        stringBuilder.append("1");
        String stringBuilder2 = stringBuilder.toString();
        WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(wXMiniProgramObject.userName);
        if (!wXMiniProgramObject.withShareTicket) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
                aVar.appId = this.uEI.field_appId;
                aVar.dyT = rR.field_appId;
                aVar.dyZ = wXMiniProgramObject.miniprogramType;
                aVar.appName = this.uEI.field_appName;
                aVar.dwr = 2;
                l.a(aVar, wXMediaMessage, str);
            }
        } else if (rR == null) {
            x.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
            setResult(-1);
            finish();
            ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), -1));
            return;
        } else {
            com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
            aVar2.dIF = 1118;
            aVar2.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            cgm cgm = new cgm();
            cgm.bPS = rR.field_appId;
            cgm.sAI = linkedList;
            aVar2.dIG = cgm;
            aVar2.dIH = new cgn();
            v.a(aVar2.KT(), new 6(this, linkedList, rR, wXMiniProgramObject, stringBuilder2, wXMediaMessage));
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            int i = ((String) it2.next()).endsWith("chatroom") ? 1 : 0;
            String encode = com.tencent.mm.compatible.util.p.encode(bi.oV(wXMiniProgramObject.webpageUrl));
            stringBuilder2 = com.tencent.mm.compatible.util.p.encode(bi.oV(wXMediaMessage.title));
            String encode2 = com.tencent.mm.compatible.util.p.encode(bi.oV(wXMediaMessage.description));
            String encode3 = com.tencent.mm.compatible.util.p.encode(bi.oV(wXMiniProgramObject.path));
            h.mEJ.h(14127, new Object[]{this.uEI.field_appId, wXMiniProgramObject.userName, encode3, stringBuilder2, encode2, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), str});
        }
    }

    private void c(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        List arrayList = new ArrayList();
        arrayList.add(((WXVideoFileObject) wXMediaMessage.mediaObject).filePath);
        if (arrayList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                x.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
                Object jVar = new j(this, arrayList, getIntent(), str, 1, new 7(this));
                com.tencent.mm.sdk.f.e.post(jVar, "ChattingUI_importMultiVideo");
                getString(R.l.app_tip);
                this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 8(this, jVar));
            }
        }
    }

    protected final void initView() {
    }

    protected final int getLayoutId() {
        return -1;
    }
}
