package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u$b;
import com.tencent.mm.model.y;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

class URISpanHandlerSet {
    Context mContext = null;

    @a
    class AAUriSpanHandler extends BaseUriSpanHandler {
        AAUriSpanHandler() {
            super(URISpanHandlerSet.this);
        }

        final m db(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
                return new m(str, 35, null);
            }
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
                return new m(str, 36, null);
            }
            return str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa") ? new m(str, 37, null) : null;
        }

        final int[] vB() {
            return new int[]{35, 36, 37};
        }

        final boolean a(m mVar, g gVar) {
            if (mVar.type == 35) {
                try {
                    String queryParameter = Uri.parse(mVar.url).getQueryParameter("billno");
                    if (bi.oW(queryParameter)) {
                        x.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                        return true;
                    }
                    String string;
                    if (mVar.data instanceof Bundle) {
                        string = ((Bundle) mVar.data).getString("chatroom_name");
                    } else if (mVar.data instanceof String) {
                        string = mVar.data.toString();
                    } else {
                        x.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", new Object[]{mVar});
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("bill_no", queryParameter);
                    intent.putExtra("enter_scene", 3);
                    intent.putExtra("chatroom", string);
                    d.b(URISpanHandlerSet.this.mContext, "aa", ".ui.PaylistAAUI", intent);
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", new Object[]{e.getMessage(), mVar.url});
                }
            } else {
                String queryParameter2;
                Bundle bundle;
                String string2;
                long j;
                if (mVar.type == 37) {
                    try {
                        queryParameter2 = Uri.parse(mVar.url).getQueryParameter("billno");
                        if (bi.oW(queryParameter2)) {
                            x.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        } else if (mVar.data instanceof Bundle) {
                            bundle = (Bundle) mVar.data;
                            string2 = bundle.getString("chatroom_name");
                            if (bi.oW(string2)) {
                                x.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                return true;
                            }
                            j = bundle.getLong("msg_id", -1);
                            if (j < 0) {
                                x.e("MicroMsg.URISpanHandlerSet", "msgId is null");
                                return true;
                            }
                            h.a(URISpanHandlerSet.this.mContext, R.l.span_aa_close_confirm, -1, R.l.span_aa_close_wording, R.l.cancel, (OnClickListener) new 1(this, queryParameter2, string2, j), null);
                        } else {
                            x.e("MicroMsg.URISpanHandlerSet", "error data!");
                            return true;
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", new Object[]{e2.getMessage(), mVar.url});
                    }
                } else if (mVar.type == 36) {
                    try {
                        queryParameter2 = Uri.parse(mVar.url).getQueryParameter("billno");
                        if (bi.oW(queryParameter2)) {
                            x.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        }
                        bundle = null;
                        if (mVar.data instanceof Bundle) {
                            bundle = (Bundle) mVar.data;
                        }
                        if (bundle == null || bi.oW(bundle.getString("chatroom_name"))) {
                            x.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                            return true;
                        }
                        string2 = bundle.getString("chatroom_name");
                        j = bundle.getLong("msg_id", -1);
                        h.a(URISpanHandlerSet.this.mContext, R.l.span_aa_close_urge_notify_confirm, -1, R.l.span_aa_close_urge_notify_wording, R.l.cancel, (OnClickListener) new 2(this, queryParameter2, string2, j), null);
                    } catch (Exception e22) {
                        x.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", new Object[]{e22.getMessage(), mVar.url});
                    }
                }
                return false;
            }
        }

        final boolean a(String str, boolean z, s sVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class BizMsgMenuUriSpanHandler extends BaseUriSpanHandler {
        BizMsgMenuUriSpanHandler() {
            super(URISpanHandlerSet.this);
        }

        final m db(String str) {
            if (str.trim().startsWith("weixin://bizmsgmenu")) {
                return new m(str, 43, null);
            }
            return null;
        }

        final int[] vB() {
            return new int[]{43};
        }

        final boolean a(m mVar, g gVar) {
            if (43 != mVar.type) {
                return false;
            }
            if (bi.oW(mVar.username)) {
                x.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
                return true;
            }
            x.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[]{mVar.url});
            Uri parse = Uri.parse(mVar.url.trim());
            String queryParameter = parse.getQueryParameter("msgmenuid");
            String queryParameter2 = parse.getQueryParameter("msgmenucontent");
            com.tencent.mm.plugin.report.service.h.mEJ.h(14522, new Object[]{bi.oV(queryParameter), mVar.username});
            if (bi.oW(queryParameter) || bi.oW(queryParameter2)) {
                x.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
                return true;
            }
            try {
                String decode = URLDecoder.decode(queryParameter2, "UTF-8");
                HashMap hashMap = new HashMap();
                hashMap.put("bizmsgmenuid", queryParameter);
                au.DF().a(new i(mVar.username, decode, com.tencent.mm.model.s.hQ(mVar.username), 291, hashMap), 0);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[]{e.getMessage()});
            }
            return true;
        }

        final boolean a(String str, boolean z, s sVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class ContactUriSpanHandler extends BaseUriSpanHandler {
        ContactUriSpanHandler() {
            super(URISpanHandlerSet.this);
        }

        final m db(String str) {
            if (str.trim().equals("weixin://contacts/all/")) {
                return new m(str, 23, new com.tencent.mm.model.x("@all.android", null, URISpanHandlerSet.this.mContext.getString(R.l.group_all), null, true, true));
            } else if (str.trim().equals("weixin://contacts/microblog/")) {
                return new m(str, 22, y.ig(URISpanHandlerSet.this.mContext.getString(R.l.group_weibo)));
            } else {
                if (str.trim().equals("weixin://contacts/micromessenger/")) {
                    return new m(str, 2, new com.tencent.mm.model.x("@micromsg.qq.com", null, URISpanHandlerSet.this.mContext.getString(R.l.group_weixin), null, true, true));
                } else if (!str.trim().startsWith("weixin://contacts/")) {
                    return null;
                } else {
                    String substring = str.trim().substring(0, str.trim().length() - 1);
                    int lastIndexOf = substring.lastIndexOf("/");
                    if (lastIndexOf == -1) {
                        return null;
                    }
                    return new m(str, 21, y.P("@" + substring.substring(lastIndexOf + 1), URISpanHandlerSet.this.mContext.getString(R.l.group_domainmail_suffix)));
                }
            }
        }

        final int[] vB() {
            return new int[]{23, 21, 22, 2};
        }

        final boolean a(m mVar, g gVar) {
            boolean z = false;
            int i = mVar.type;
            if (i != 23 && i != 21 && i != 22 && i != 2) {
                return false;
            }
            com.tencent.mm.model.x xVar = (com.tencent.mm.model.x) mVar.F(com.tencent.mm.model.x.class);
            if (gVar != null) {
                gVar.a(mVar);
            }
            if (xVar == null) {
                h.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.link_no_such_group), URISpanHandlerSet.this.mContext.getString(R.l.app_tip), true);
                return false;
            }
            if (xVar.getType().equals("@t.qq.com")) {
                if (!(((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FZ().Hg("@t.qq.com") != null)) {
                    h.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.link_no_such_group), URISpanHandlerSet.this.mContext.getString(R.l.app_tip), true);
                }
            }
            if (xVar.getType().equals("@domain.android")) {
                List bdo = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FZ().bdo();
                if (bdo.size() > 0) {
                    for (int i2 = 0; i2 < bdo.size(); i2++) {
                        if (((bl) bdo.get(i2)).isEnable()) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    h.b(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.l.link_no_such_group), URISpanHandlerSet.this.mContext.getString(R.l.app_tip), true);
                }
            }
            Intent intent = new Intent();
            intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", xVar.getType()).putExtra("Contact_GroupFilter_Str", xVar.Hz()).putExtra("Contact_GroupFilter_DisplayName", xVar.BK());
            intent.addFlags(268435456);
            URISpanHandlerSet.this.mContext.startActivity(intent);
            if (gVar != null) {
                gVar.b(mVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, s sVar, Bundle bundle) {
            if (!str.equals("weixin://contacts/microblog/") && !str.equals("weixin://contacts/micromessenger/") && !str.equals("weixin://contacts/all/")) {
                return false;
            }
            com.tencent.mm.model.x ig = y.ig(URISpanHandlerSet.this.mContext.getString(R.l.group_weixin));
            if (str.equals("weixin://contacts/microblog/")) {
                ig = y.ig(URISpanHandlerSet.this.mContext.getString(R.l.group_weibo));
            }
            if (str.equals("weixin://contacts/micromessenger/")) {
                ig = y.ig(URISpanHandlerSet.this.mContext.getString(R.l.group_weixin));
            }
            if (str.equals("weixin://contacts/all/")) {
                ig = y.ig(URISpanHandlerSet.this.mContext.getString(R.l.group_all));
            }
            Intent intent = new Intent();
            intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", ig.getType()).putExtra("Contact_GroupFilter_Str", ig.Hz()).putExtra("Contact_GroupFilter_DisplayName", ig.BK());
            intent.addFlags(268435456);
            return true;
        }
    }

    @a
    class FeedbackUriSpanHandler extends BaseUriSpanHandler {
        FeedbackUriSpanHandler() {
            super(URISpanHandlerSet.this);
        }

        final m db(String str) {
            if (str.trim().startsWith("weixin://feedback/next/")) {
                return new m(str, 34, null);
            }
            return null;
        }

        final int[] vB() {
            return new int[]{34};
        }

        final boolean a(m mVar, g gVar) {
            if (mVar.type != 34) {
                return false;
            }
            x.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", new Object[]{mVar.url, mVar.url.trim().replace("weixin://feedback/next/", "")});
            au.DF().a(new j(q.zO(), r2, 8), 0);
            return true;
        }

        final boolean a(String str, boolean z, s sVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class HttpUriSpanHandler extends BaseUriSpanHandler {
        HttpUriSpanHandler() {
            super(URISpanHandlerSet.this);
        }

        final m db(String str) {
            if (str.trim().toLowerCase().startsWith("http")) {
                return new m(str, 1, null);
            }
            return null;
        }

        final int[] vB() {
            return new int[]{1};
        }

        final boolean a(m mVar, g gVar) {
            if (mVar.type != 1) {
                return false;
            }
            String str;
            mVar.F(com.tencent.mm.model.x.class);
            com.tencent.mm.model.x P = y.P("@" + mVar.url, URISpanHandlerSet.this.mContext.getString(R.l.group_domainmail_suffix));
            if (gVar != null) {
                str = (String) gVar.a(mVar);
            } else {
                str = null;
            }
            if (P == null || !P.bKe) {
                String str2 = mVar.url;
                if (!str2.toLowerCase().startsWith("http")) {
                    str2 = "http://" + str2;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                if (mVar.data != null && (mVar.data instanceof Integer)) {
                    intent.putExtra("geta8key_scene", ((Integer) mVar.data).intValue());
                }
                str2 = mVar.fmS;
                if (!bi.oW(str2)) {
                    u$b ib = u.Hx().ib(str2);
                    if (ib != null) {
                        String string = ib.getString("prePublishId", null);
                        String string2 = ib.getString("preUsername", null);
                        String string3 = ib.getString("preChatName", null);
                        intent.putExtra("reportSessionId", str2);
                        intent.putExtra("KPublisherId", string);
                        intent.putExtra("geta8key_username", string3);
                        intent.putExtra("pre_username", string2);
                        intent.putExtra("prePublishId", string);
                        intent.putExtra("preUsername", string2);
                        intent.putExtra("preChatName", string3);
                        intent.putExtra("preChatTYPE", t.N(string2, string3));
                    }
                }
                intent.putExtra("geta8key_username", bi.oW(str) ? null : str);
                intent.addFlags(536870912);
                d.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
            }
            if (gVar != null) {
                gVar.b(mVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, s sVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class VerifyContactUriSpanHandler extends BaseUriSpanHandler {
        VerifyContactUriSpanHandler() {
            super(URISpanHandlerSet.this);
        }

        final m db(String str) {
            if (str.trim().startsWith("weixin://findfriend/verifycontact")) {
                return new m(str, 4, null);
            }
            return null;
        }

        final int[] vB() {
            return new int[]{4};
        }

        final boolean a(m mVar, g gVar) {
            if (mVar.type != 4) {
                return false;
            }
            if (gVar != null) {
                gVar.a(mVar);
                gVar.b(mVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, s sVar, Bundle bundle) {
            return false;
        }
    }

    public URISpanHandlerSet(Context context) {
        this.mContext = context == null ? ad.getContext() : this.mContext;
    }
}
