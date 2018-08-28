package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.as;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashSet;

public final class h extends b {
    int gBh = -1;
    HashSet<Integer> tYH = new HashSet();
    int tYk = 0;

    class a extends b {
        public String appId;
        public String bhd;
        public String desc;
        public int iconRes;
        public String imagePath;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean aak(String str) {
            if (str == null) {
                return false;
            }
            Object toLowerCase = str.toLowerCase();
            if (aal(toLowerCase)) {
                if (!bi.oW(this.bhd) && this.bhd.toLowerCase().contains(toLowerCase)) {
                    return true;
                }
            } else if (!bi.oW(this.bhd) && isContains(toLowerCase, this.bhd.toLowerCase())) {
                return true;
            }
            return super.aak(toLowerCase);
        }
    }

    static /* synthetic */ void b(h hVar, a aVar) {
        au.HU();
        bd dW = c.FT().dW(aVar.bJC);
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(dW.field_content);
        f bl = g.bl(gp.appId, false);
        if (bl != null && bl.aaq()) {
            Object obj;
            Intent intent;
            String str = hVar.gBf;
            if (s.fq(str)) {
                str = com.tencent.mm.model.bd.iB(dW.field_content);
            }
            long j = dW.field_msgSvrId;
            int i = (bl == null || !p.r(hVar.mContext, bl.field_packageName)) ? 6 : 3;
            if (gp.type == 2) {
                i = 4;
            } else if (gp.type == 5) {
                i = 1;
            }
            nk nkVar = new nk();
            nkVar.bYs.context = hVar.mContext;
            nkVar.bYs.scene = 1;
            nkVar.bYs.bPS = gp.appId;
            nkVar.bYs.packageName = bl == null ? null : bl.field_packageName;
            nkVar.bYs.msgType = gp.type;
            nkVar.bYs.bSS = str;
            nkVar.bYs.bYt = i;
            nkVar.bYs.mediaTagName = gp.mediaTagName;
            nkVar.bYs.bYu = j;
            nkVar.bYs.bYv = "";
            com.tencent.mm.sdk.b.a.sFg.m(nkVar);
            com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
            if (g.a(hVar.mContext, bl) || aSm == null) {
                obj = null;
            } else {
                if (!bi.oW(bl.cmK)) {
                    x.i("MicroMsg.UrlHistoryListPresenter", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", bl.cmK, Boolean.valueOf(q.bi(hVar.mContext, bl.cmK)));
                    if (q.bi(hVar.mContext, bl.cmK)) {
                        obj = 1;
                    }
                }
                gk gkVar = new gk();
                gkVar.bPB.actionCode = 2;
                gkVar.bPB.scene = 1;
                gkVar.bPB.appId = bl.field_appId;
                gkVar.bPB.context = hVar.mContext;
                com.tencent.mm.sdk.b.a.sFg.m(gkVar);
                intent = new Intent();
                aSm.S(bl.field_appId, 1, 1);
                obj = 1;
            }
            if (obj != null) {
                return;
            }
            if (gp.bGP == null || gp.bGP.length() == 0) {
                str = dW.field_content;
                if (dW.field_isSend == 0) {
                    i = dW.field_isSend;
                    if (s.fq(hVar.gBf) && str != null && i == 0) {
                        str = com.tencent.mm.model.bd.iC(str);
                    }
                }
                com.tencent.mm.y.g.a gp2 = com.tencent.mm.y.g.a.gp(str);
                f bl2 = g.bl(gp2.appId, true);
                if (bl2 == null || !p.r(hVar.mContext, bl2.field_packageName)) {
                    str = p.y(hVar.mContext, gp2.appId, "message");
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    d.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
                } else if (bl2.field_status == 3) {
                    x.e("MicroMsg.UrlHistoryListPresenter", "requestAppShow fail, app is in blacklist, packageName = " + bl2.field_packageName);
                } else if (!p.b(hVar.mContext, bl2)) {
                    x.e("MicroMsg.UrlHistoryListPresenter", "The app %s signature is incorrect.", bl2.field_appName);
                    Toast.makeText(hVar.mContext, hVar.mContext.getString(R.l.game_launch_fail_alert, new Object[]{g.b(hVar.mContext, bl2, null)}), 1).show();
                } else if (!hVar.a(dW, bl2)) {
                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = gp2.extInfo;
                    if (gp2.bGP != null && gp2.bGP.length() > 0) {
                        com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(gp2.bGP);
                        wXAppExtendObject.filePath = SR == null ? null : SR.field_fileFullPath;
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.sdkVer = 620823808;
                    wXMediaMessage.mediaObject = wXAppExtendObject;
                    wXMediaMessage.title = gp2.title;
                    wXMediaMessage.description = gp2.description;
                    wXMediaMessage.messageAction = gp2.messageAction;
                    wXMediaMessage.messageExt = gp2.messageExt;
                    wXMediaMessage.thumbData = e.e(o.Pf().lN(dW.field_imgPath), 0, -1);
                    new as(hVar.mContext).a(bl2.field_packageName, wXMediaMessage, bl2.field_appId, bl2.field_openId);
                }
            } else if (hVar.cxG()) {
                Intent intent2 = new Intent();
                intent2.setClassName(hVar.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                intent2.putExtra("app_msg_id", dW.field_msgId);
                hVar.mContext.startActivity(intent2);
            } else {
                com.tencent.mm.ui.base.s.gH(hVar.mContext);
            }
        }
    }

    static /* synthetic */ void c(h hVar, a aVar) {
        au.HU();
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(c.FT().dW(aVar.bJC).field_content);
        Object obj = gp.dwZ;
        if (TextUtils.isEmpty(obj)) {
            obj = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zn(gp.url);
        }
        if (TextUtils.isEmpty(obj)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", com.tencent.mm.model.q.GF());
            intent.putExtra("rawUrl", gp.url);
            d.b(hVar.mContext, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        x.d("MicroMsg.UrlHistoryListPresenter", "start emoji detail from brandcontact");
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", obj);
        intent2.putExtra("preceding_scence", 123);
        intent2.putExtra("download_entrance_scene", 23);
        d.b(hVar.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        com.tencent.mm.plugin.report.service.h.mEJ.h(10993, Integer.valueOf(2), obj);
    }

    static /* synthetic */ void d(h hVar, a aVar) {
        au.HU();
        cm dW = c.FT().dW(aVar.bJC);
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(dW.field_content);
        int i = gp.tid;
        String str = gp.dyH;
        String str2 = gp.desc;
        String str3 = gp.iconUrl;
        String str4 = gp.secondUrl;
        int i2 = gp.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", i(dW, s.fq(hVar.gBf)));
            intent.putExtra("rawUrl", gp.cGB);
            intent.putExtra("topic_id", i);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 23);
            d.b(hVar.mContext, "emoji", ".ui.EmojiStoreTopicUI", intent);
            return;
        }
        x.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
    }

    static /* synthetic */ void e(h hVar, a aVar) {
        au.HU();
        cm dW = c.FT().dW(aVar.bJC);
        com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(dW.field_content);
        int i = gp.tid;
        String str = gp.dyH;
        String str2 = gp.desc;
        String str3 = gp.iconUrl;
        String str4 = gp.secondUrl;
        int i2 = gp.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", i(dW, s.fq(hVar.gBf)));
            intent.putExtra("rawUrl", gp.cGB);
            intent.putExtra("set_id", i);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i2);
            d.b(hVar.mContext, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            return;
        }
        x.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
    }

    public h(Context context) {
        super(context);
    }

    public final int getType() {
        this.tYH.add(Integer.valueOf(5));
        this.tYH.add(Integer.valueOf(7));
        this.tYH.add(Integer.valueOf(27));
        this.tYH.add(Integer.valueOf(26));
        this.tYH.add(Integer.valueOf(15));
        return -1;
    }

    public final void cwG() {
        this.tXZ.cwK();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Em().H(new 1(this));
    }

    public final String Wm() {
        return this.mContext.getString(R.l.all_history_url);
    }

    public final String cwJ() {
        return this.mContext.getString(R.l.all_history_url);
    }

    public final com.tencent.mm.ui.chatting.a.b.e cwH() {
        return new 2(this);
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.url_list_item, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) EZ(i);
        if (bi.oW(aVar2.desc) || !bi.oW(aVar2.bhd)) {
            bVar.eCn.setVisibility(8);
        } else {
            bVar.eCn.setVisibility(0);
            bVar.eCn.setText(bi.aG(aVar2.desc, ""));
        }
        Bitmap a = o.Pf().a(aVar2.imagePath, com.tencent.mm.bp.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = g.b(aVar2.appId, 1, com.tencent.mm.bp.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                a = y.a(new com.tencent.mm.pluginsdk.model.q(aVar2.imagePath, aVar2.type, "@S"));
                if (a == null) {
                    bVar.gmn.setImageResource(R.k.app_attach_file_icon_webpage);
                    bVar.jet.setText(bi.aG(aVar2.bhd, ""));
                    b.e(bVar.jet, this.tYa.tNU);
                }
            }
        }
        bVar.gmn.setImageBitmap(a);
        bVar.jet.setText(bi.aG(aVar2.bhd, ""));
        b.e(bVar.jet, this.tYa.tNU);
    }

    private boolean a(bd bdVar, f fVar) {
        if (!bdVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", aF(this.mContext, "com.tencent.mobileqq"));
        intent.putExtra("platformId", "wechat");
        au.HU();
        Object obj = c.DT().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes("utf-8");
                byte[] bytes2 = "asdfghjkl;'".getBytes("utf-8");
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
            }
        }
        try {
            this.mContext.startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String aF(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
        }
        return null;
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f bl = g.bl(str, true);
            if (bl == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bl.field_packageName;
            }
        }
        if (str22 == null) {
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str22, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
            return packageInfo;
        }
    }
}
