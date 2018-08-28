package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.y.g;
import java.io.File;
import java.util.Locale;

@a(cwo = com.tencent.mm.ui.chatting.b.b.a.class)
public class b extends a implements com.tencent.mm.ui.chatting.b.b.a {
    private com.tencent.mm.plugin.wallet.a myP = null;
    private ar tNY = null;
    private final j.a tNZ = new 1(this);
    private final j.a tOa = new 2(this);

    public final void n(f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[]{bi.cjd()});
            return;
        }
        if (!(fVar == null || !f.qzE.equals(fVar.field_appId) || this.myP == null)) {
            this.myP.aM(2, this.bAG.oLT.field_username);
        }
        if (fVar.cbJ()) {
            if (fVar == null || !fVar.cbJ()) {
                x.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
            } else if (this.bAG.oLT == null || bi.oW(this.bAG.oLT.field_username)) {
                x.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
            } else {
                x.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(fVar.cmZ), fVar.field_packageName, fVar.field_appId});
                if (fVar.cmZ == 2 && !bi.oW(fVar.cmY)) {
                    o(fVar);
                } else if (fVar.cmZ == 3) {
                    if (bi.oW(fVar.field_openId)) {
                        ao.bmh().pS(fVar.field_appId);
                        x.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
                    } else if (this.tNY == null || bi.oW(fVar.field_packageName)) {
                        x.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
                        o(fVar);
                    } else {
                        x.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[]{Boolean.valueOf(this.tNY.gh(fVar.field_packageName, fVar.field_openId))});
                        if (!this.tNY.gh(fVar.field_packageName, fVar.field_openId)) {
                            o(fVar);
                        }
                    }
                } else if (fVar.cmZ == 1) {
                    x.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[]{fVar.cmY});
                    p.a.qyl.a(this.bAG.tTq.getContext(), fVar.cmY, false, new 3(this));
                }
            }
        } else if (fVar.field_status == 3) {
            x.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + fVar.field_packageName);
        } else if (!this.tNY.gh(fVar.field_packageName, fVar.field_openId) && fVar.field_status == 5) {
            x.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[]{fVar.cmM});
            if (!bi.oW(fVar.cmM)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", fVar.cmM);
                d.b(this.bAG.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        }
    }

    private void o(f fVar) {
        if (fVar == null || bi.oW(fVar.field_appId)) {
            x.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
        } else if (bi.oW(fVar.cmY)) {
            x.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
        } else {
            int size;
            Intent intent;
            Bundle bundle;
            SharedPreferences sharedPreferences = this.bAG.tTq.getContext().getSharedPreferences(ad.chY(), 0);
            this.bAG.tTq.getContext();
            String d = w.d(sharedPreferences);
            if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                d = Locale.getDefault().toString();
            }
            if (s.fq(this.bAG.getTalkerUserName())) {
                au.HU();
                u ih = c.Ga().ih(this.bAG.getTalkerUserName());
                if (ih != null) {
                    size = ih.Nn().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", fVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    intent.putExtra("forceHideShare", true);
                    bundle.putString("sendAppMsgToUserName", this.bAG.oLT.field_username);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.cmY, Integer.valueOf(size), d}));
                    d.b(this.bAG.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fVar.field_appId);
            bundle.putBoolean("isFromService", true);
            intent.putExtra("forceHideShare", true);
            bundle.putString("sendAppMsgToUserName", this.bAG.oLT.field_username);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.cmY, Integer.valueOf(size), d}));
            d.b(this.bAG.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public final void aR(bd bdVar) {
        String iC;
        g.a gp;
        f bl;
        Intent intent;
        String str = bdVar.field_content;
        if (bdVar.field_isSend == 0) {
            com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
            int i = bdVar.field_isSend;
            if (!((com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus() && s.fq(aVar.getTalkerUserName()) && str != null && i == 0) {
                iC = com.tencent.mm.model.bd.iC(str);
                gp = g.a.gp(iC);
                bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, true);
                if (bl != null || !com.tencent.mm.pluginsdk.model.app.p.r(this.bAG.tTq.getContext(), bl.field_packageName)) {
                    iC = com.tencent.mm.pluginsdk.model.app.p.y(this.bAG.tTq.getContext(), gp.appId, "message");
                    intent = new Intent();
                    intent.putExtra("rawUrl", iC);
                    d.b(this.bAG.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                } else if (bl.field_status == 3) {
                    x.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + bl.field_packageName);
                    return;
                } else if (!com.tencent.mm.pluginsdk.model.app.p.b(this.bAG.tTq.getContext(), bl)) {
                    x.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[]{bl.field_appName});
                    Toast.makeText(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.game_launch_fail_alert, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(this.bAG.tTq.getContext(), bl, null)}), 1).show();
                    return;
                } else if (!a(bdVar, bl)) {
                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = gp.extInfo;
                    if (gp.bGP != null && gp.bGP.length() > 0) {
                        com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(gp.bGP);
                        wXAppExtendObject.filePath = SR == null ? null : SR.field_fileFullPath;
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.sdkVer = 620823808;
                    wXMediaMessage.mediaObject = wXAppExtendObject;
                    wXMediaMessage.title = gp.title;
                    wXMediaMessage.description = gp.description;
                    wXMediaMessage.messageAction = gp.messageAction;
                    wXMediaMessage.messageExt = gp.messageExt;
                    wXMediaMessage.thumbData = e.e(o.Pf().lN(bdVar.field_imgPath), 0, -1);
                    new as(this.bAG.tTq.getContext()).a(bl.field_packageName, wXMediaMessage, bl.field_appId, bl.field_openId);
                    return;
                } else {
                    return;
                }
            }
        }
        iC = str;
        gp = g.a.gp(iC);
        bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, true);
        if (bl != null) {
        }
        iC = com.tencent.mm.pluginsdk.model.app.p.y(this.bAG.tTq.getContext(), gp.appId, "message");
        intent = new Intent();
        intent.putExtra("rawUrl", iC);
        d.b(this.bAG.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    private boolean a(bd bdVar, f fVar) {
        if (!bdVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        intent.setClassName("com.tencent.mobileqq", aF(this.bAG.tTq.getContext(), "com.tencent.mobileqq"));
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
                x.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e, "", new Object[0]);
            }
        }
        try {
            this.bAG.tTq.startActivity(intent);
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
            x.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", e, "", new Object[0]);
        }
        return null;
    }

    public final void a(m mVar) {
        br.IE().c(38, new Object[]{Integer.valueOf(1)});
        String str = mVar.filePath;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(str));
        wXMediaMessage.title = new File(str).getName();
        wXMediaMessage.description = bi.bF((long) e.cm(str));
        f fVar = new f();
        fVar.field_appId = "wx4310bbd51be7d979";
        ao.bmf().b(fVar, new String[0]);
        l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.bAG.getTalkerUserName(), 2, null);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 210:
                if (i2 == -1) {
                    long longExtra = intent.getLongExtra("App_MsgId", 0);
                    au.HU();
                    aR(c.FT().dW(longExtra));
                    return;
                }
                return;
            case 222:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("service_app_package_name");
                    String stringExtra2 = intent.getStringExtra("service_app_openid");
                    String stringExtra3 = intent.getStringExtra("service_app_appid");
                    String str = "MicroMsg.ChattingUI.AppMsgComponent";
                    String str2 = "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]";
                    Object[] objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(this.tNY != null);
                    objArr[1] = stringExtra;
                    objArr[2] = stringExtra3;
                    objArr[3] = stringExtra2;
                    x.i(str, str2, objArr);
                    if (bi.oW(stringExtra3)) {
                        x.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
                        return;
                    } else if (this.tNY == null || bi.oW(stringExtra)) {
                        o(com.tencent.mm.pluginsdk.model.app.g.bl(stringExtra3, true));
                        return;
                    } else if (bi.oW(stringExtra2)) {
                        ao.bmh().pS(stringExtra3);
                        x.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
                        return;
                    } else {
                        x.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[]{Boolean.valueOf(this.tNY.gh(stringExtra, stringExtra2))});
                        if (!this.tNY.gh(stringExtra, stringExtra2)) {
                            o(com.tencent.mm.pluginsdk.model.app.g.bl(stringExtra3, true));
                            return;
                        }
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void cpH() {
        this.myP = com.tencent.mm.plugin.wallet.a.cp(this.bAG.oLT.field_username, 1);
        this.myP.aM(1, this.bAG.oLT.field_username);
        ao.asF().c(this.tNZ);
        ao.bmf().c(this.tOa);
        if (this.tNY == null) {
            this.tNY = new ar(this.bAG);
        }
        ar arVar = this.tNY;
        this.bAG.tTq.getContext();
        ar.tNy.a(arVar, null);
    }

    public final void cpJ() {
        com.tencent.mm.ui.chatting.ao.clear();
    }

    public final void cpK() {
        ar arVar = this.tNY;
        this.bAG.tTq.getContext();
        ar.tNy.remove(arVar);
        arVar.tNx.clear();
        ar.b(arVar.tNw.getContext(), null);
        if (au.HX()) {
            ao.asF().d(this.tNZ);
            ao.bmf().d(this.tOa);
        }
    }
}
