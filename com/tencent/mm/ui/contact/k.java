package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.f;
import com.tencent.mm.aa.q;
import com.tencent.mm.az.d;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.r;
import java.util.ArrayList;
import java.util.List;

public final class k extends RelativeLayout {
    public static Boolean ujy = Boolean.valueOf(true);
    private Context context = null;
    private View ern = null;
    private boolean isVisible = true;
    private final al tQS = new al(new a() {
        public final boolean vD() {
            x.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            k.cyk();
            k.this.init();
            return false;
        }
    }, true);
    j.a ujA = new 2(this);
    private boolean ujB = false;
    private View ujz = null;

    public k(Context context) {
        super(context);
        this.context = context;
        d.SF().c(this.ujA);
        cyk();
        init();
    }

    private void init() {
        as SF = d.SF();
        x.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[]{Integer.valueOf(4)});
        List arrayList = new ArrayList();
        Cursor b = SF.diF.b("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
        while (b.moveToNext()) {
            ar arVar = new ar();
            arVar.d(b);
            if (!bi.oW(arVar.field_talker)) {
                arrayList.add(arVar);
            }
        }
        b.close();
        int size = arrayList.size();
        x.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[]{Integer.valueOf(size)});
        removeAllViews();
        if (size <= 0) {
            if (this.context == null) {
                x.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            } else {
                this.ern = View.inflate(this.context, R.i.fmessage_contact_header, this);
                this.ujz = this.ern.findViewById(R.h.fmessage_contact_viewall);
                LayoutParams layoutParams = this.ujz.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bp.a.ae(this.context, R.f.ContactListHeight)) * com.tencent.mm.bp.a.fh(this.context));
                this.ujz.setLayoutParams(layoutParams);
                this.ern.setOnClickListener(new 4(this));
                MaskLayout maskLayout = (MaskLayout) this.ern.findViewById(R.h.fmessage_avatar_iv);
                q.Kp();
                ((ImageView) maskLayout.getContentView()).setImageBitmap(f.jV("fmessage"));
            }
        } else if (size == 1) {
            ar arVar2 = (ar) arrayList.get(0);
            if (this.context == null) {
                x.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            } else {
                CharSequence string;
                if (com.tencent.mm.bp.a.fi(this.context)) {
                    this.ern = View.inflate(this.context, R.i.fmessage_contact_header_single_large, this);
                } else {
                    this.ern = View.inflate(this.context, R.i.fmessage_contact_header_single, this);
                }
                ((TextView) this.ern.findViewById(R.h.fmessage_header_nick_tv)).setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, arVar2.field_displayName));
                TextView textView = (TextView) this.ern.findViewById(R.h.fmessage_header_digest_tv);
                at YN = d.SE().YN(arVar2.field_talker);
                Context context = this.context;
                int i = YN.field_type;
                int i2 = arVar2.field_addScene;
                String str = YN.field_msgContent;
                x.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(!YN.clS())});
                if (i == 0) {
                    if (str != null) {
                        bd.a YV = bd.a.YV(str);
                        switch (YV.scene) {
                            case 4:
                                string = context.getString(R.l.chatting_from_QQ_friends_content);
                                break;
                            case 10:
                            case 11:
                                fs fsVar = new fs();
                                fsVar.bOn.bOk = YV.tbE;
                                fsVar.bOn.bOl = YV.tbF;
                                com.tencent.mm.sdk.b.a.sFg.m(fsVar);
                                string = context.getString(R.l.chatting_from_mobile_friends_content, new Object[]{bi.aG(fsVar.bOo.bOp, "")});
                                break;
                            case s$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                                string = context.getString(R.l.chatting_from_verify_facebook_content);
                                break;
                            case 32:
                                string = context.getString(R.l.chatting_from_sns_add_now);
                                break;
                            case s$l.AppCompatTheme_toolbarStyle /*58*/:
                            case s$l.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                            case s$l.AppCompatTheme_popupMenuStyle /*60*/:
                                string = context.getString(R.l.chatting_from_google_contact);
                                break;
                            default:
                                string = context.getString(R.l.chatting_from_possible_friends_content);
                                break;
                        }
                    }
                    x.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
                    string = null;
                } else if (r2) {
                    Object string2 = str;
                } else {
                    bd.d YY = bd.d.YY(str);
                    string2 = (YY.content == null || YY.content.trim().equals("")) ? context.getString(R.l.fmessage_from_verify_digest_tip) : YY.content;
                }
                if (ai.oW(string2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(string2);
                }
                this.ujz = this.ern.findViewById(R.h.fmessage_contact_header_container_ll);
                this.ern.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
                        au.HU();
                        c.DT().set(143618, Integer.valueOf(0));
                        com.tencent.mm.bg.d.b(k.this.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                b.a((ImageView) ((MaskLayout) this.ern.findViewById(R.h.fmessage_avatar_iv)).getContentView(), arVar2.field_talker);
            }
        } else if (this.context == null) {
            x.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
        } else {
            this.ern = View.inflate(this.context, R.i.fmessage_contact_header_multi, this);
            int size2 = arrayList.size();
            x.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[]{Integer.valueOf(size2)});
            MaskLayout maskLayout2 = (MaskLayout) this.ern.findViewById(R.h.fmessage_avatar_iv);
            b.a((ImageView) maskLayout2.getContentView(), ((ar) arrayList.get(0)).field_talker);
            maskLayout2.setVisibility(0);
            maskLayout2 = (MaskLayout) this.ern.findViewById(R.h.fmessage_avatar_iv_2);
            b.a((ImageView) maskLayout2.getContentView(), ((ar) arrayList.get(1)).field_talker);
            maskLayout2.setVisibility(0);
            if (size2 > 2) {
                maskLayout2 = (MaskLayout) this.ern.findViewById(R.h.fmessage_avatar_iv_3);
                b.a((ImageView) maskLayout2.getContentView(), ((ar) arrayList.get(2)).field_talker);
                maskLayout2.setVisibility(0);
            }
            if (size2 > 3) {
                maskLayout2 = (MaskLayout) this.ern.findViewById(R.h.fmessage_avatar_iv_4);
                b.a((ImageView) maskLayout2.getContentView(), ((ar) arrayList.get(3)).field_talker);
                maskLayout2.setVisibility(0);
            }
            this.ujz = this.ern.findViewById(R.h.fmessage_contact_header_container_ll);
            this.ujz.setOnClickListener(new 6(this));
        }
        View findViewById = this.ern.findViewById(R.h.fmessage_contact_header_container_ll);
        if (findViewById != null) {
            findViewById.setVisibility(this.isVisible ? 0 : 8);
        }
        this.ujz.setOnTouchListener(new 3(this));
        int clP = d.SF().clP();
        x.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[]{Integer.valueOf(clP)});
        TextView textView2 = (TextView) this.ern.findViewById(R.h.fmessage_contact_unread_tv);
        textView2.setBackgroundResource(r.hd(this.context));
        if (clP <= 0) {
            textView2.setVisibility(8);
            ujy = Boolean.valueOf(false);
            return;
        }
        textView2.setVisibility(0);
        ujy = Boolean.valueOf(true);
        if (clP > 99) {
            textView2.setText(getContext().getString(R.l.unread_count_overt_100));
        } else {
            textView2.setText(String.valueOf(clP));
        }
    }

    public final void setVisible(boolean z) {
        x.d("MicroMsg.FMessageContactView", "setVisible visible = " + z);
        View findViewById = this.ern.findViewById(R.h.fmessage_contact_header_container_ll);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
        this.isVisible = z;
    }

    private static void cyk() {
        int clP = d.SF().clP();
        x.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[]{Integer.valueOf(clP)});
        if (clP > 0) {
            au.HU();
            c.DT().set(143618, Integer.valueOf(clP));
        }
    }

    public final void setFrontGround(boolean z) {
        this.ujB = z;
    }

    public static void cyl() {
        au.HU();
        if (c.FM()) {
            au.HU();
            if (c.DT().getInt(143618, 0) > 0) {
                z.S("fmessage", 2);
            }
        }
        au.HU();
        c.DT().set(143618, Integer.valueOf(0));
    }
}
