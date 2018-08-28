package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.x;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ar implements ad {
    public static k<ad, Bundle> tNy = new 1();
    private a bAG;
    public x tNw;
    public final Set<String> tNx = new HashSet();

    public ar(a aVar) {
        this.tNw = aVar.tTq;
    }

    public static void ah(Bundle bundle) {
        tNy.ci(bundle);
        tNy.doNotify();
    }

    public final void ag(Bundle bundle) {
        int i = 1;
        boolean z = false;
        if (this.bAG.eaR) {
            String string;
            int type;
            String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
            Resp resp = new Resp(bundle);
            WXMediaMessage wXMediaMessage = resp.message;
            if (this.tNx.size() == 0) {
                Context context = this.tNw.getContext();
                Collection hashSet = new HashSet();
                string = context.getSharedPreferences(ad.cib(), 0).getString("transactions_array_key", null);
                if (string != null && string.length() > 0) {
                    for (Object add : string.split(";")) {
                        hashSet.add(add);
                    }
                }
                this.tNx.addAll(hashSet);
            }
            if (this.tNx.contains(resp.transaction)) {
                this.tNx.remove(resp.transaction);
                b(this.tNw.getContext(), this.tNx);
                f fVar = new f();
                fVar.field_appId = queryParameter;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = " + queryParameter);
                if (ao.bmf().b(fVar, new String[0])) {
                    type = wXMediaMessage.getType();
                    s controller;
                    c b;
                    byte[] bArr;
                    int i2;
                    String str;
                    switch (type) {
                        case 1:
                            controller = this.tNw.getController();
                            queryParameter = wXMediaMessage.description;
                            m(fVar);
                            if (g.a(controller, queryParameter, false, a(wXMediaMessage, fVar)) != null) {
                                type = 1;
                            } else {
                                boolean z2 = false;
                            }
                            i = type;
                            break;
                        case 2:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                                s controller2;
                                if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                                    controller2 = this.tNw.getController();
                                    string = wXImageObject.imagePath;
                                    m(fVar);
                                    b = g.b(controller2, string, false, a(wXMediaMessage, fVar));
                                } else {
                                    controller2 = this.tNw.getController();
                                    byte[] bArr2 = wXImageObject.imageData;
                                    m(fVar);
                                    b = g.a(controller2, bArr2, false, a(wXMediaMessage, fVar));
                                }
                            } else {
                                controller = this.tNw.getController();
                                bArr = wXMediaMessage.thumbData;
                                m(fVar);
                                b = g.a(controller, bArr, false, a(wXMediaMessage, fVar));
                            }
                            if (b == null) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                            } else {
                                z = true;
                            }
                            boolean i3 = z;
                            break;
                        case 3:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.tNw.getController();
                                i2 = R.k.app_attach_file_icon_music;
                                str = wXMediaMessage.title;
                                m(fVar);
                                b = g.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.tNw.getController();
                                queryParameter = wXMediaMessage.title;
                                m(fVar);
                                b = g.a(controller, queryParameter, false, 2, a(wXMediaMessage, fVar));
                            }
                            if (b == null) {
                                i3 = 0;
                                break;
                            }
                            break;
                        case 4:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.tNw.getController();
                                i2 = R.k.app_attach_file_icon_video;
                                str = wXMediaMessage.title;
                                m(fVar);
                                b = g.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.tNw.getController();
                                queryParameter = wXMediaMessage.title;
                                m(fVar);
                                b = g.a(controller, queryParameter, false, 1, a(wXMediaMessage, fVar));
                            }
                            if (b == null) {
                                i3 = 0;
                                break;
                            }
                            break;
                        case 5:
                            controller = this.tNw.getController();
                            queryParameter = wXMediaMessage.title;
                            str = wXMediaMessage.description;
                            m(fVar);
                            if (g.a(controller, queryParameter, str, a(wXMediaMessage, fVar)) == null) {
                                i3 = 0;
                                break;
                            }
                            break;
                        case 7:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.tNw.getController();
                                i2 = R.k.app_attach_file_icon_webpage;
                                str = wXMediaMessage.title;
                                m(fVar);
                                b = g.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.tNw.getController();
                                queryParameter = wXMediaMessage.title;
                                m(fVar);
                                b = g.a(controller, queryParameter, false, 0, a(wXMediaMessage, fVar));
                            }
                            if (b == null) {
                                i3 = 0;
                                break;
                            }
                            break;
                        case 8:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.tNw.getController();
                                i2 = R.k.app_attach_file_icon_webpage;
                                str = wXMediaMessage.title;
                                m(fVar);
                                b = g.a(controller, i2, str, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.tNw.getController();
                                bArr = wXMediaMessage.thumbData;
                                m(fVar);
                                b = g.a(controller, bArr, false, a(wXMediaMessage, fVar));
                            }
                            if (b == null) {
                                i3 = 0;
                                break;
                            }
                            break;
                        default:
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WXAppMessageReceiver", "unknown type = " + type);
                            i3 = 0;
                            break;
                    }
                    if (i3 == 0) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
                        return;
                    }
                    return;
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = " + queryParameter);
                return;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + resp.transaction);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
    }

    public final boolean gh(String str, String str2) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        Req req = new Req();
        req.username = this.bAG.getTalkerUserName();
        req.transaction = com.tencent.mm.a.g.u((ai.VF()).getBytes());
        req.openId = str2;
        SharedPreferences sharedPreferences = this.tNw.getSharedPreferences(ad.chY(), 0);
        this.tNw.getContext();
        req.lang = w.d(sharedPreferences);
        au.HU();
        req.country = (String) com.tencent.mm.model.c.DT().get(274436, null);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        p.ae(bundle);
        p.af(bundle);
        Args args = new Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        boolean send = MMessageActV2.send(this.tNw.getContext(), args);
        this.tNx.add(req.transaction);
        b(this.tNw.getContext(), this.tNx);
        return send;
    }

    private String m(f fVar) {
        return this.tNw.getString(R.l.confirm_dialog_source, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(this.tNw.getContext(), fVar, null)});
    }

    private q.a a(final WXMediaMessage wXMediaMessage, final f fVar) {
        return new q.a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    String str2 = null;
                    if (wXMediaMessage.getType() == 8) {
                        if (wXMediaMessage.thumbData == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                            return;
                        }
                        str2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(ar.this.tNw.getContext(), wXMediaMessage, fVar.field_appId);
                        if (str2 == null) {
                            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                            return;
                        }
                    }
                    br.IE().c(27, Integer.valueOf(1));
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[]{wXMediaMessage.messageAction, wXMediaMessage.messageExt});
                    l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, ar.this.bAG.getTalkerUserName(), 1, str2);
                }
            }
        };
    }

    @TargetApi(9)
    public static void b(Context context, Set<String> set) {
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : set) {
                stringBuilder.append(str2);
                stringBuilder.append(";");
            }
            str2 = stringBuilder.toString();
        }
        Editor edit = context.getSharedPreferences(ad.cib(), 0).edit();
        edit.putString("transactions_array_key", str2);
        if (VERSION.SDK_INT > 8) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
