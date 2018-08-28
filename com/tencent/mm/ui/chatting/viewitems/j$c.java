package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.a$i;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.smtt.sdk.WebView;

public class j$c extends b implements m {
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 268435505) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new r(layoutInflater, R.i.chatting_item_to_appmsg_img);
        view.setTag(new j$a().dB(view));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        j$a j_a = (j$a) aVar;
        this.tKy = aVar2;
        ((i) aVar2.O(i.class)).aX(bdVar);
        g.a aVar3 = null;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            aVar3 = g.a.J(str2, bdVar.field_reserved);
        }
        if (aVar3 != null) {
            f cP = com.tencent.mm.pluginsdk.model.app.g.cP(aVar3.appId, aVar3.cbu);
            String str3 = (cP == null || cP.field_appName == null || cP.field_appName.trim().length() <= 0) ? aVar3.appName : cP.field_appName;
            if (aVar3.appId == null || aVar3.appId.length() <= 0 || !com.tencent.mm.pluginsdk.model.app.g.cT(str3)) {
                j_a.jet.setVisibility(8);
            } else {
                j_a.jet.setText(com.tencent.mm.pluginsdk.model.app.g.b(aVar2.tTq.getContext(), cP, str3));
                j_a.jet.setVisibility(0);
                if (cP == null || !cP.aaq()) {
                    a(aVar2, j_a.jet, aVar3.appId);
                } else {
                    a(aVar2, j_a.jet, bdVar, aVar3, cP.field_packageName, bdVar.field_msgSvrId);
                }
                a(aVar2, j_a.jet, aVar3.appId);
            }
            switch (aVar3.type) {
                case 2:
                    j_a.jBN.setVisibility(0);
                    b SR = ao.asF().SR(aVar3.bGP);
                    String str4 = bdVar.field_imgPath;
                    Boolean valueOf = Boolean.valueOf(false);
                    if (SR != null) {
                        str4 = SR.field_fileFullPath;
                        valueOf = Boolean.valueOf(true);
                    }
                    if (!o.Pf().a(j_a.jBN, str4, valueOf.booleanValue(), com.tencent.mm.bp.a.getDensity(aVar2.tTq.getContext()), aVar3.dwJ, aVar3.dwI, R.g.chat_img_template, j_a.jBT, R.g.chat_img_default_bg, 0, null)) {
                        if (this.qUB) {
                            j_a.jBN.setImageResource(R.k.chatfrom_bg_pic);
                        } else {
                            j_a.jBN.setImageBitmap(BitmapFactory.decodeResource(aVar2.tTq.getMMResources(), R.g.nosdcard_pic));
                        }
                        j_a.jBN.post(new 1(this, j_a));
                        break;
                    }
                    break;
            }
        }
        j_a.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        j_a.hrH.setOnClickListener(d(aVar2));
        if (this.qUB) {
            j_a.hrH.setOnLongClickListener(c(aVar2));
            j_a.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        }
        int SY = l.SY(str2);
        if (SY == -1 || SY >= 100 || aVar3.dwo <= 0 || bdVar.field_status == 5) {
            j_a.jck.setVisibility(8);
            j_a.jBN.setAlpha(WebView.NORMAL_MODE_ALPHA);
            j_a.jBN.setBackgroundDrawable(null);
        } else {
            j_a.jck.setVisibility(0);
            j_a.ubk.setText(SY + "%");
            j_a.jBN.setAlpha(64);
            j_a.jBN.setBackgroundResource(R.g.sendimage_mask);
        }
        a(i, j_a, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        if (view == null) {
            x.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
            return false;
        }
        au auVar = (au) view.getTag();
        if (auVar == null) {
            x.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
            return false;
        }
        int i = auVar.position;
        String str = bdVar.field_content;
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        if (gp != null && com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false))) {
            contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
        }
        if (d.QS("favorite")) {
            contextMenu.add(i, 116, 0, this.tKy.tTq.getMMResources().getString(R.l.plugin_favorite_opt));
        }
        dj djVar = new dj();
        djVar.bLf.bJC = bdVar.field_msgId;
        com.tencent.mm.sdk.b.a.sFg.m(djVar);
        boolean m = com.tencent.mm.pluginsdk.model.app.g.m(this.tKy.tTq.getContext(), 2);
        if (djVar.bLg.bKE || m) {
            contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
        }
        if (bdVar.field_status != 5) {
            int width;
            int height;
            MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(R.l.chatting_image_long_click_photo_edit));
            int[] iArr = new int[2];
            if (view != null) {
                width = view.getWidth();
                height = view.getHeight();
                view.getLocationInWindow(iArr);
            } else {
                height = 0;
                width = 0;
            }
            Intent intent = new Intent();
            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
            add.setIntent(intent);
        }
        if (!bdVar.cky() && bdVar.cmo() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        g.a gp;
        String str = null;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            gp = g.a.gp(str2);
        } else {
            gp = null;
        }
        switch (menuItem.getItemId()) {
            case a$i.AppCompatTheme_buttonStyle /*100*/:
                if (gp != null) {
                    l.fJ(bdVar.field_msgId);
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
                if (bl != null && bl.aaq()) {
                    a(aVar, gp, bdVar, bl);
                    break;
                }
            case 111:
                if (!(gp == null || gp.bGP == null || gp.bGP.length() <= 0)) {
                    b SR = ao.asF().SR(gp.bGP);
                    if (SR != null) {
                        str = SR.field_fileFullPath;
                    }
                }
                Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", bdVar.field_content);
                intent.putExtra("Retr_File_Name", str);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                aVar.startActivity(intent);
                break;
            case 131:
                j.a(aVar, menuItem, bdVar);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        au.HU();
        if (!c.isSDCardAvailable()) {
            s.gH(aVar.tTq.getContext());
            return true;
        } else if (view == null) {
            return true;
        } else {
            view.getTag();
            g.a aVar2 = null;
            String str = bdVar.field_content;
            if (str != null) {
                aVar2 = g.a.gp(str);
            }
            if (aVar2 == null) {
                x.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
                return true;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            f bl = com.tencent.mm.pluginsdk.model.app.g.bl(aVar2.appId, false);
            if (bl != null && bl.aaq()) {
                a(aVar, aVar2, q.GF(), bl, bdVar.field_msgSvrId);
            }
            String str2;
            if (aVar2.bGP != null && aVar2.bGP.length() > 0) {
                b SR = ao.asF().SR(aVar2.bGP);
                if (SR != null) {
                    au.HU();
                    if (!c.isSDCardAvailable()) {
                        s.gH(aVar.tTq.getContext());
                    } else if (bdVar.field_isSend == 1) {
                        str = SR.field_fileFullPath;
                        if (!e.cn(str)) {
                            x.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[]{str, Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
                            Intent intent = new Intent();
                            intent.setClassName(aVar.tTq.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                            intent.putExtra("clean_view_type", 1);
                            aVar.startActivity(intent);
                            return true;
                        } else if (str == null || str.equals("") || !e.cn(str)) {
                            x.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
                        } else {
                            String str3;
                            int i;
                            Bundle bundle;
                            long j = bdVar.field_msgId;
                            long j2 = bdVar.field_msgSvrId;
                            str2 = bdVar.field_talker;
                            Intent intent2 = new Intent(this.tKy.tTq.getContext(), ImageGalleryUI.class);
                            intent2.putExtra("img_gallery_msg_id", j);
                            intent2.putExtra("img_gallery_talker", str2);
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", width);
                            intent2.putExtra("img_gallery_height", height);
                            String talkerUserName = this.tKy.getTalkerUserName();
                            String b = b(this.tKy, bdVar);
                            Bundle bundle2 = new Bundle();
                            if (this.tKy.cwr()) {
                                str3 = "stat_scene";
                                i = 2;
                                bundle = bundle2;
                            } else {
                                str3 = "stat_scene";
                                if (com.tencent.mm.model.s.hf(talkerUserName)) {
                                    i = 7;
                                    bundle = bundle2;
                                } else {
                                    i = 1;
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str3, i);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                            bundle2.putString("stat_chat_talker_username", talkerUserName);
                            bundle2.putString("stat_send_msg_user", b);
                            intent2.putExtra("_stat_obj", bundle2);
                            this.tKy.startActivity(intent2);
                        }
                    }
                    return true;
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                str2 = p.B(aVar2.url, "message");
                PackageInfo packageInfo = getPackageInfo(aVar.tTq.getContext(), aVar2.appId);
                a(aVar, str2, str2, packageInfo == null ? null : packageInfo.versionName, packageInfo == null ? 0 : packageInfo.versionCode, aVar2.appId, false, bdVar.field_msgId, bdVar.field_msgSvrId, bdVar);
            }
            return false;
        }
    }

    public final void a(a aVar, bd bdVar) {
        if (bdVar.aQm()) {
            l.ae(bdVar);
            com.tencent.mm.model.bd.aU(bdVar.field_msgId);
            aVar.lT(true);
        }
    }
}
