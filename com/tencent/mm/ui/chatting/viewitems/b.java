package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.i;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.6;
import com.tencent.mm.ui.chatting.b.b.e;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.t.c;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.chatting.t.g;
import com.tencent.mm.ui.chatting.t.j;
import com.tencent.mm.ui.chatting.t.o;

public abstract class b {
    private static long tUA = 0;
    private static boolean tZg = false;
    protected boolean qUB;
    public boolean tGg;
    private c tZh;
    private d tZi;
    private boolean tZj = false;
    protected com.tencent.mm.ui.chatting.t.b tZk;
    protected c tZl;
    protected o tZm;
    protected g tZn;
    protected j tZo;
    protected d tZp;
    private final long tZq = 120000;

    public abstract View a(LayoutInflater layoutInflater, View view);

    public abstract void a(a aVar, int i, a aVar2, bd bdVar, String str);

    public abstract boolean a(ContextMenu contextMenu, View view, bd bdVar);

    public abstract boolean a(MenuItem menuItem, a aVar, bd bdVar);

    public abstract boolean aq(int i, boolean z);

    public abstract boolean b(View view, a aVar, bd bdVar);

    abstract boolean bba();

    public static void r(ImageView imageView, String str) {
        if (bi.oW(str)) {
            imageView.setImageResource(R.g.default_avatar);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
    }

    public static int gO(Context context) {
        float fe = com.tencent.mm.bp.a.fe(context);
        if (fe == 0.875f) {
            return com.tencent.mm.bp.a.ae(context, R.f.chatting_small_item_width);
        }
        if (fe == 1.125f) {
            return com.tencent.mm.bp.a.ae(context, R.f.chatting_large_item_width);
        }
        if (fe == 1.25f) {
            return com.tencent.mm.bp.a.ae(context, R.f.chatting_super_item_width);
        }
        if (fe == 1.375f) {
            return com.tencent.mm.bp.a.ae(context, R.f.chatting_huge_item_width);
        }
        if (fe == 1.625f || fe == 1.875f || fe == 2.025f) {
            return com.tencent.mm.bp.a.ae(context, R.f.chatting_huger_item_width);
        }
        return com.tencent.mm.bp.a.ae(context, R.f.chatting_normal_item_width);
    }

    public static int gP(Context context) {
        float fe = com.tencent.mm.bp.a.fe(context);
        if (!(fe == 0.875f || fe == 1.125f)) {
            if (fe == 1.25f) {
                return com.tencent.mm.bp.a.ae(context, R.f.chatting_custom_super_item_width);
            }
            if (fe == 1.375f) {
                return com.tencent.mm.bp.a.ae(context, R.f.chatting_custom_huge_item_width);
            }
            if (fe == 1.625f || fe == 1.875f || fe == 2.025f) {
                return com.tencent.mm.bp.a.ae(context, R.f.chatting_huger_item_width);
            }
        }
        return com.tencent.mm.bp.a.ae(context, R.f.chatting_custom_item_width);
    }

    public static void s(ImageView imageView, String str) {
        if (bi.oW(str)) {
            imageView.setImageResource(R.g.brand_default_head);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.n(imageView, str);
        }
    }

    public final void a(a aVar, int i, a aVar2, bd bdVar) {
        long j = tUA + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        tUA = currentTimeMillis;
        if (j < currentTimeMillis) {
            au.HU();
            tZg = com.tencent.mm.model.c.isSDCardAvailable();
        }
        this.qUB = tZg;
        String str = null;
        if (cxM()) {
            str = b(aVar2, bdVar);
            a(aVar, aVar2, bdVar, str);
            a(aVar, aVar2, str, bdVar);
        }
        a(aVar, i, aVar2, bdVar, str);
    }

    protected boolean cxM() {
        return true;
    }

    protected void a(a aVar, a aVar2, bd bdVar, String str) {
        if (str != null && aVar.mQc != null && bdVar != null) {
            CharSequence charSequence;
            if (bdVar.field_isSend == 0 && !bi.oW(bdVar.cGJ)) {
                com.tencent.mm.ac.g kQ = z.MX().kQ(bdVar.cGJ);
                Object obj = 1;
                if (kQ == null || bi.oW(kQ.field_openId) || bi.oW(kQ.field_nickname)) {
                    x.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                    charSequence = null;
                } else {
                    charSequence = kQ.field_nickname;
                    obj = null;
                }
                if (obj != null || i.a(kQ)) {
                    z.MZ().a(new b(aVar2, bdVar.cGJ));
                    z.MZ().ah(aVar2.getTalkerUserName(), bdVar.cGJ);
                }
            } else if (!b(aVar2) || !((e) aVar2.O(e.class)).cuH()) {
                charSequence = null;
            } else if (((com.tencent.mm.ui.chatting.b.b.c) aVar2.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus()) {
                charSequence = com.tencent.mm.pluginsdk.ui.d.j.a(aVar2.tTq.getContext(), ((e) aVar2.O(e.class)).gT(bdVar.field_bizChatUserId), aVar.mQc.getTextSize());
            } else {
                charSequence = com.tencent.mm.pluginsdk.ui.d.j.a(aVar2.tTq.getContext(), ((e) aVar2.O(e.class)).gT(str), aVar.mQc.getTextSize());
            }
            a(aVar, charSequence);
        }
    }

    protected boolean b(a aVar) {
        if (bba()) {
            return false;
        }
        return aVar.cwr() || ((com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(com.tencent.mm.ui.chatting.c.a r4, com.tencent.mm.storage.bd r5) {
        /*
        r3 = this;
        r0 = r3.bba();
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r1 = r4.cwp();
    L_0x000a:
        return r1;
    L_0x000b:
        r1 = r4.getTalkerUserName();
        r0 = r3.b(r4);
        if (r0 == 0) goto L_0x000a;
    L_0x0015:
        r0 = r4.cwr();
        if (r0 == 0) goto L_0x002d;
    L_0x001b:
        r0 = r5.field_content;
        r0 = com.tencent.mm.model.bd.iB(r0);
        if (r1 == 0) goto L_0x0032;
    L_0x0023:
        if (r0 == 0) goto L_0x0032;
    L_0x0025:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0032;
    L_0x002b:
        r1 = r0;
        goto L_0x000a;
    L_0x002d:
        if (r5 == 0) goto L_0x0032;
    L_0x002f:
        r0 = r5.field_bizChatUserId;
        goto L_0x002b;
    L_0x0032:
        r0 = r1;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.b.b(com.tencent.mm.ui.chatting.c.a, com.tencent.mm.storage.bd):java.lang.String");
    }

    protected static String c(a aVar, bd bdVar) {
        String str = bdVar.field_talker;
        com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class);
        if (!cVar.cur() || cVar.cup() == null) {
            return str;
        }
        return cVar.cup().field_bizChatServId;
    }

    public static String a(bd bdVar, boolean z, boolean z2) {
        String str = null;
        if (bdVar == null) {
            return null;
        }
        if (bdVar.field_isSend == 1) {
            return q.GF();
        }
        if (z) {
            str = com.tencent.mm.model.bd.iB(bdVar.field_content);
        } else if (z2) {
            str = bdVar.field_bizChatUserId;
        }
        if (bi.oW(str)) {
            return bdVar.field_talker;
        }
        return str;
    }

    protected static void a(a aVar, CharSequence charSequence) {
        if (aVar != null && aVar.mQc != null) {
            if (charSequence == null) {
                aVar.mQc.setVisibility(8);
                return;
            }
            aVar.mQc.setText(charSequence);
            aVar.mQc.setVisibility(0);
        }
    }

    protected final c c(a aVar) {
        if (this.tZh == null) {
            this.tZh = new c(this, aVar);
        }
        return this.tZh;
    }

    protected final d d(a aVar) {
        if (this.tZi == null) {
            if (aVar.tTq instanceof AppBrandServiceChattingUI.a) {
                AppBrandServiceChattingUI.a aVar2 = (AppBrandServiceChattingUI.a) aVar.tTq;
                this.tZi = new 6(aVar2, aVar2.bAG, this);
            } else {
                this.tZi = new d(aVar, this);
            }
        }
        return this.tZi;
    }

    protected final com.tencent.mm.ui.chatting.t.b e(a aVar) {
        if (this.tZk == null) {
            this.tZk = new com.tencent.mm.ui.chatting.t.b(aVar);
        }
        return this.tZk;
    }

    protected final c f(a aVar) {
        if (this.tZl == null) {
            this.tZl = new c(aVar);
        }
        return this.tZl;
    }

    protected final o g(a aVar) {
        if (this.tZm == null) {
            this.tZm = new o(aVar);
        }
        return this.tZm;
    }

    protected final j h(a aVar) {
        if (this.tZo == null) {
            this.tZo = new j(aVar);
        }
        return this.tZo;
    }

    protected final void a(a aVar, a aVar2, String str, bd bdVar) {
        String str2 = null;
        if (aVar.eCl != null) {
            if (!s.hO(str) || str.equals(s.dAV[0])) {
                Object obj;
                au auVar;
                if (bdVar != null && !bi.oW(bdVar.cGJ)) {
                    auVar = new au(str, aVar2.cwr() ? aVar2.getTalkerUserName() : null);
                    auVar.ufB = bdVar.cGJ;
                    com.tencent.mm.pluginsdk.ui.a.b.g(aVar.eCl, bdVar.cGJ, R.g.biz_kf_default_avatar);
                    obj = auVar;
                } else if (bdVar == null || !((com.tencent.mm.ui.chatting.b.b.c) aVar2.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur()) {
                    if (aVar2.cwr()) {
                        str2 = aVar2.getTalkerUserName();
                    }
                    obj = new au(str, str2);
                    r(aVar.eCl, str);
                } else {
                    auVar = new au(bdVar.field_bizChatUserId, null);
                    com.tencent.mm.ak.o.Pj().a(((com.tencent.mm.ui.chatting.b.b.c) aVar2.O(com.tencent.mm.ui.chatting.b.b.c.class)).le(bdVar.field_bizChatUserId), aVar.eCl, ((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctR());
                    au obj2 = auVar;
                }
                aVar.eCl.setVisibility(0);
                aVar.eCl.setTag(obj2);
                if (!this.tZj) {
                    this.tZj = true;
                    if (!(aVar2.tTq instanceof AppBrandServiceChattingUI.a)) {
                        if (bdVar == null || bi.oW(bdVar.cGJ)) {
                            this.tZk = new com.tencent.mm.ui.chatting.t.b(aVar2);
                            this.tZl = new c(aVar2);
                        } else {
                            this.tZk = new t.a(aVar2);
                        }
                        aVar.eCl.setOnClickListener(this.tZk);
                        aVar.eCl.setOnLongClickListener(this.tZl);
                    }
                }
                com.tencent.mm.ui.chatting.q.dq(aVar.eCl);
                aVar.eCl.setContentDescription(r.gT(str) + aVar2.tTq.getContext().getString(R.l.avatar_desc));
                if (aVar.tZt == null) {
                    return;
                }
                if (bdVar == null || bdVar.cqb == null || !bdVar.cqb.contains("watch_msg_source_type")) {
                    aVar.tZt.setVisibility(8);
                    return;
                }
                int intValue;
                try {
                    intValue = Integer.valueOf((String) bl.z(bdVar.cqb, "msgsource").get(".msgsource.watch_msg_source_type")).intValue();
                } catch (Exception e) {
                    intValue = 0;
                }
                if (intValue <= 0 || intValue > 4) {
                    aVar.tZt.setVisibility(8);
                    return;
                } else {
                    aVar.tZt.setVisibility(0);
                    return;
                }
            }
            aVar.eCl.setVisibility(8);
        }
    }

    protected static void a(a aVar, View view, String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.SS(str)) {
            Object bVar = new com.tencent.mm.pluginsdk.ui.chat.l.b();
            bVar.appId = str;
            bVar.bXS = "message";
            a(aVar, view, bVar);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.l.b());
    }

    protected static void a(a aVar, View view, bd bdVar, com.tencent.mm.y.g.a aVar2, String str, long j) {
        if (com.tencent.mm.pluginsdk.model.app.g.SS(aVar2.appId)) {
            int i = aVar.cwr() ? 2 : 1;
            Object aVar3 = new l.a();
            aVar3.appId = aVar2.appId;
            aVar3.bXS = "message";
            aVar3.byT = str;
            aVar3.bYo = d(aVar, bdVar);
            aVar3.qMW = aVar2.type;
            aVar3.scene = i;
            aVar3.qMX = aVar2.mediaTagName;
            aVar3.bYu = j;
            a(aVar, view, aVar3);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.l.b());
    }

    private static void a(a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).cty());
    }

    protected static void a(a aVar, ImageView imageView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bp.a.getDensity(aVar.tTq.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, imageView, BitmapFactory.decodeResource(aVar.tTq.getMMResources(), R.g.nosdcard_watermark_icon));
        } else {
            a(aVar, imageView, b);
        }
    }

    private static void a(a aVar, ImageView imageView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.tTq.getMMResources().getDimension(R.f.SmallestTextSize);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    protected static void a(a aVar, TextView textView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bp.a.getDensity(aVar.tTq.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, textView, BitmapFactory.decodeResource(aVar.tTq.getMMResources(), R.g.nosdcard_watermark_icon));
        } else {
            a(aVar, textView, b);
        }
    }

    private static void a(a aVar, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.tTq.getMMResources().getDimension(R.f.SmallestTextSize);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected final void b(a aVar, View view, Object obj) {
        view.setTag(obj);
        if (this.tZn == null) {
            this.tZn = new g(aVar);
        }
        view.setOnClickListener(this.tZn);
    }

    protected static void c(a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctz());
    }

    public final boolean a(a aVar, com.tencent.mm.y.g.a aVar2, bd bdVar) {
        if (bi.oW(aVar2.dyJ)) {
            return false;
        }
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.tFI, bdVar, aVar2.dyQ, aVar2.dyP);
        String str = bdVar.field_imgPath;
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", aVar2.dyJ);
        intent.putExtra("KThumUrl", aVar2.dyO);
        intent.putExtra("KThumbPath", str);
        intent.putExtra("KSta_StremVideoAduxInfo", aVar2.dyP);
        intent.putExtra("KSta_StremVideoPublishId", aVar2.dyQ);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", aVar.cwr() ? com.tencent.mm.ui.chatting.a.b.tFR.value : com.tencent.mm.ui.chatting.a.b.tFQ.value);
        intent.putExtra("KSta_FromUserName", b(aVar, bdVar));
        intent.putExtra("KSta_ChatName", aVar.getTalkerUserName());
        intent.putExtra("KSta_MsgId", bdVar.field_msgSvrId);
        intent.putExtra("KSta_SnsStatExtStr", aVar2.bZN);
        if (aVar.cwr()) {
            intent.putExtra("KSta_ChatroomMembercount", m.gK(aVar.getTalkerUserName()));
        }
        intent.putExtra("KMediaId", "fakeid_" + bdVar.field_msgId);
        intent.putExtra("KMediaVideoTime", aVar2.dyK);
        intent.putExtra("StremWebUrl", aVar2.dyN);
        intent.putExtra("StreamWording", aVar2.dyM);
        intent.putExtra("KMediaTitle", aVar2.title);
        com.tencent.mm.bg.d.b(aVar.tTq.getContext(), "sns", ".ui.VideoAdPlayerUI", intent);
        return true;
    }

    protected final void a(a aVar, String str, String str2, String str3, int i, String str4, boolean z, long j, long j2, bd bdVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
            return;
        }
        if (ao.isMobile(aVar.tTq.getContext()) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", z);
        intent.putExtra("geta8key_username", aVar.getTalkerUserName());
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        intent.putExtra("pre_username", b(aVar, bdVar));
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (bdVar != null) {
            intent.putExtra("preUsername", b(aVar, bdVar));
        }
        intent.putExtra("preChatName", aVar.getTalkerUserName());
        intent.putExtra("preChatTYPE", com.tencent.mm.model.t.N(b(aVar, bdVar), aVar.getTalkerUserName()));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bg.d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static boolean cT(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cT(str);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, true);
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
            x.printErrStackTrace("MicroMsg.ChattingItem", e, "", new Object[0]);
            return packageInfo;
        }
    }

    protected final void a(int i, a aVar, bd bdVar, String str, boolean z, a aVar2, t.m mVar) {
        if (bdVar.field_isSend == 1) {
            int i2;
            aVar.tZv.setTag(new au(bdVar, z, i, str, 0));
            ImageView imageView = aVar.tZv;
            if (this.tZp == null) {
                this.tZp = new 1(this, aVar2, mVar);
            }
            imageView.setOnClickListener(this.tZp);
            switch (bdVar.field_status) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.g.state_failed;
                    break;
                default:
                    x.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                aVar.tZv.setImageResource(i2);
                aVar.tZv.setVisibility(0);
                aVar.tZv.setContentDescription(ad.getContext().getString(R.l.msg_fail_resend));
                if (aVar.mgA != null) {
                    aVar.mgA.setVisibility(8);
                    return;
                }
                return;
            }
            aVar.tZv.setVisibility(8);
        }
    }

    public static void a(a aVar, com.tencent.mm.y.g.a aVar2, String str, f fVar, long j) {
        int i = aVar.cwr() ? 2 : 1;
        int i2 = (fVar == null || !p.r(aVar.tTq.getContext(), fVar.field_packageName)) ? 6 : 3;
        if (aVar2.type == 2) {
            i2 = 4;
        } else if (aVar2.type == 5) {
            i2 = 1;
        }
        nk nkVar = new nk();
        nkVar.bYs.context = aVar.tTq.getContext();
        nkVar.bYs.scene = i;
        nkVar.bYs.bPS = aVar2.appId;
        nkVar.bYs.packageName = fVar == null ? null : fVar.field_packageName;
        nkVar.bYs.msgType = aVar2.type;
        nkVar.bYs.bSS = str;
        nkVar.bYs.bYt = i2;
        nkVar.bYs.mediaTagName = aVar2.mediaTagName;
        nkVar.bYs.bYu = j;
        nkVar.bYs.bYv = "";
        com.tencent.mm.sdk.b.a.sFg.m(nkVar);
    }

    protected static void a(a aVar, com.tencent.mm.y.g.a aVar2, bd bdVar, f fVar) {
        com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
        if (aSm != null) {
            int i = aVar.cwr() ? 2 : 1;
            aSm.a(aVar.tTq.getContext(), aVar2.appId, fVar == null ? null : fVar.field_packageName, d(aVar, bdVar), aVar2.type, aVar2.mediaTagName, i);
        }
    }

    protected static void b(a aVar, com.tencent.mm.y.g.a aVar2, bd bdVar) {
        com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
        if (aSm != null) {
            int i = aVar.cwr() ? 2 : 1;
            String d = d(aVar, bdVar);
            aVar.tTq.getContext();
            aSm.a(aVar2.appId, d, aVar2.type, i, aVar2.mediaTagName, bdVar.field_msgSvrId);
        }
    }

    protected static boolean a(a aVar, f fVar) {
        com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
        if (com.tencent.mm.pluginsdk.model.app.g.a(aVar.tTq.getContext(), fVar) || aSm == null) {
            return false;
        }
        if (!bi.oW(fVar.cmK)) {
            x.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", fVar.cmK, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.bi(aVar.tTq.getContext(), fVar.cmK)));
            if (com.tencent.mm.pluginsdk.model.app.q.bi(aVar.tTq.getContext(), fVar.cmK)) {
                return true;
            }
        }
        int i = aVar.cwr() ? 2 : 1;
        gk gkVar = new gk();
        gkVar.bPB.actionCode = 2;
        gkVar.bPB.scene = i;
        gkVar.bPB.appId = fVar.field_appId;
        gkVar.bPB.context = aVar.tTq.getContext();
        com.tencent.mm.sdk.b.a.sFg.m(gkVar);
        aVar.tTq.getContext();
        aSm.S(fVar.field_appId, i, i);
        return true;
    }

    public static String d(a aVar, bd bdVar) {
        String talkerUserName = aVar.getTalkerUserName();
        if (s.fq(talkerUserName)) {
            return com.tencent.mm.model.bd.iB(bdVar.field_content);
        }
        return talkerUserName;
    }

    public static void a(bd bdVar, EmojiInfo emojiInfo) {
        cp cpVar = new cp();
        cpVar.bKa.bKb = emojiInfo;
        cpVar.bKa.bKb.talker = bdVar != null ? bdVar.field_talker : null;
        cpVar.bKa.scene = 0;
        com.tencent.mm.sdk.b.a.sFg.m(cpVar);
    }

    protected static boolean a(bd bdVar, a aVar) {
        int i;
        if (System.currentTimeMillis() - bdVar.field_createTime > 120000) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            return false;
        }
        if (aVar != null && aVar.getTalkerUserName().equals(aVar.cwp()) && bdVar.field_status == 2) {
            return false;
        }
        x.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", Integer.valueOf(com.tencent.mm.k.g.AT().getInt("ShowRevokeMsgEntry", 1)));
        if (1 == com.tencent.mm.k.g.AT().getInt("ShowRevokeMsgEntry", 1)) {
            return true;
        }
        return false;
    }

    protected static boolean aaA(String str) {
        return !(s.hr(str) || s.hH(str) || s.hf(str) || s.hP(str)) || s.fq(str);
    }

    protected static boolean cxN() {
        String value = com.tencent.mm.k.g.AT().getValue("ShowSendOK");
        if (1 == (bi.oW(value) ? 0 : bi.WU(value))) {
            return true;
        }
        return false;
    }

    protected static boolean a(com.tencent.mm.ui.chatting.b.b.g gVar, long j) {
        return j > 0 && gVar.ctC() == j;
    }

    protected boolean cxO() {
        return true;
    }
}
