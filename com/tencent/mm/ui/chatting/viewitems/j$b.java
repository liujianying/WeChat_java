package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;

public final class j$b extends b {
    private a tKy;
    private final long ubm = 259200000;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 268435505) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_img);
        rVar.setTag(new j.a().dB(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        j.a aVar3 = (j.a) aVar;
        this.tKy = aVar2;
        ((i) aVar2.O(i.class)).aX(bdVar);
        g.a aVar4 = null;
        String str2 = bdVar.field_content;
        if (aVar2.cwr()) {
            int indexOf = bdVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = bdVar.field_content.substring(indexOf + 1);
            }
        }
        if (str2 != null) {
            aVar4 = g.a.J(str2, bdVar.field_reserved);
        }
        if (aVar4 != null) {
            f cP = com.tencent.mm.pluginsdk.model.app.g.cP(aVar4.appId, aVar4.cbu);
            if (cP != null && cP.aaq()) {
                b(aVar2, aVar4, bdVar);
            }
            str2 = (cP == null || cP.field_appName == null || cP.field_appName.trim().length() <= 0) ? aVar4.appName : cP.field_appName;
            if (aVar4.appId == null || aVar4.appId.length() <= 0 || !com.tencent.mm.pluginsdk.model.app.g.cT(str2)) {
                aVar3.jet.setVisibility(8);
            } else {
                aVar3.jet.setText(com.tencent.mm.pluginsdk.model.app.g.b(aVar2.tTq.getContext(), cP, str2));
                aVar3.jet.setVisibility(0);
                if (cP == null || !cP.aaq()) {
                    a(aVar2, aVar3.jet, aVar4.appId);
                } else {
                    a(aVar2, aVar3.jet, bdVar, aVar4, cP.field_packageName, bdVar.field_msgSvrId);
                }
                a(aVar2, aVar3.jet, aVar4.appId);
            }
            if (aVar4.cGB == null || aVar4.cGB.length() == 0) {
                aVar3.tZU.setVisibility(8);
            } else {
                aVar3.tZU.setVisibility(0);
                b(aVar2, aVar3.tZU, au.aaI(aVar4.cGB));
            }
            switch (aVar4.type) {
                case 2:
                    aVar3.jBN.setVisibility(0);
                    b SR = ao.asF().SR(aVar4.bGP);
                    String str3 = bdVar.field_imgPath;
                    Boolean valueOf = Boolean.valueOf(false);
                    if (SR != null) {
                        str3 = SR.field_fileFullPath;
                        valueOf = Boolean.valueOf(true);
                    }
                    if (!o.Pf().a(aVar3.jBN, str3, valueOf.booleanValue(), com.tencent.mm.bp.a.getDensity(aVar2.tTq.getContext()), aVar4.dwH, aVar4.dwG, R.g.chat_img_template, aVar3.jBT, R.g.chat_img_default_bg, 1, null)) {
                        if (this.qUB) {
                            aVar3.jBN.setImageResource(R.k.chatfrom_bg_pic);
                        } else {
                            aVar3.jBN.setImageBitmap(BitmapFactory.decodeResource(aVar2.tTq.getMMResources(), R.g.nosdcard_pic));
                        }
                        aVar3.jBN.post(new 1(this, aVar3));
                        break;
                    }
                    break;
            }
            if (aVar2.cwr()) {
                aVar3.ubl.setVisibility(8);
            } else if (com.tencent.mm.pluginsdk.model.app.g.g(cP)) {
                aVar3.ubl.setVisibility(0);
                aVar3.tZU.setVisibility(8);
                c(aVar2, aVar3.ubl, au.a(aVar4, bdVar));
            } else {
                aVar3.ubl.setVisibility(8);
            }
        }
        aVar3.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        aVar3.hrH.setOnClickListener(d(aVar2));
        if (this.qUB) {
            aVar3.hrH.setOnLongClickListener(c(aVar2));
            aVar3.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        if (!(view == null || bdVar == null)) {
            int i = ((au) view.getTag()).position;
            l.SY(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
            if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.bl(g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend)).appId, false))) {
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
            if (bf.l(bdVar)) {
                contextMenu.clear();
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
            }
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
            case 100:
                l.fJ(bdVar.field_msgId);
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                if (gp != null) {
                    f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
                    if (bl != null && bl.aaq()) {
                        a(aVar, gp, bdVar, bl);
                        break;
                    }
                }
                break;
            case 111:
                if (!(gp == null || gp.bGP == null || gp.bGP.length() <= 0)) {
                    b SR = ao.asF().SR(gp.bGP);
                    if (SR != null) {
                        str = SR.field_fileFullPath;
                    }
                }
                if (!bdVar.cmu()) {
                    boolean z;
                    if (System.currentTimeMillis() - bdVar.field_createTime <= 259200000 || (!bi.oW(str) && e.cn(str))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        new ag().post(new 3(this, bdVar));
                        Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_File_Name", str);
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend));
                        intent.putExtra("Retr_Msg_Type", 16);
                        intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                        aVar.startActivity(intent);
                        break;
                    }
                }
                x.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
                h.a(aVar.tTq.getContext(), aVar.tTq.getContext().getString(R.l.imgdownload_fail_or_cleaned), aVar.tTq.getContext().getString(R.l.app_tip), new 2(this));
                break;
            case 131:
                j.a(aVar, menuItem, bdVar);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        au.HU();
        if (c.isSDCardAvailable()) {
            g.a aVar2 = null;
            String b = com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend);
            if (b != null) {
                aVar2 = g.a.gp(b);
            }
            if (aVar2 == null) {
                x.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
                return true;
            }
            int height;
            int i;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                height = view.getHeight();
                i = width;
            } else {
                height = 0;
                i = 0;
            }
            f bl = com.tencent.mm.pluginsdk.model.app.g.bl(aVar2.appId, true);
            if (bl != null && bl.aaq()) {
                a(aVar, aVar2, d(aVar, bdVar), bl, bdVar.field_msgSvrId);
            }
            String str;
            if (aVar2.bGP != null && aVar2.bGP.length() > 0) {
                b SR = ao.asF().SR(aVar2.bGP);
                long j;
                if (SR != null && SR.aSc()) {
                    b = SR.field_fileFullPath;
                    if (!e.cn(b)) {
                        x.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[]{b, Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
                        Intent intent = new Intent();
                        intent.setClassName(aVar.tTq.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                        intent.putExtra("clean_view_type", 1);
                        aVar.startActivity(intent);
                        return true;
                    } else if (b == null || b.equals("") || !e.cn(b)) {
                        x.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
                    } else {
                        String str2;
                        int i2;
                        Bundle bundle;
                        j = bdVar.field_msgId;
                        long j2 = bdVar.field_msgSvrId;
                        str = bdVar.field_talker;
                        Intent intent2 = new Intent(this.tKy.tTq.getContext(), ImageGalleryUI.class);
                        intent2.putExtra("img_gallery_msg_id", j);
                        intent2.putExtra("img_gallery_talker", str);
                        intent2.putExtra("img_gallery_left", iArr[0]);
                        intent2.putExtra("img_gallery_top", iArr[1]);
                        intent2.putExtra("img_gallery_width", i);
                        intent2.putExtra("img_gallery_height", height);
                        String talkerUserName = this.tKy.getTalkerUserName();
                        String b2 = b(this.tKy, bdVar);
                        Bundle bundle2 = new Bundle();
                        if (this.tKy.cwr()) {
                            str2 = "stat_scene";
                            i2 = 2;
                            bundle = bundle2;
                        } else {
                            str2 = "stat_scene";
                            if (s.hf(talkerUserName)) {
                                i2 = 7;
                                bundle = bundle2;
                            } else {
                                i2 = 1;
                                bundle = bundle2;
                            }
                        }
                        bundle.putInt(str2, i2);
                        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                        bundle2.putString("stat_chat_talker_username", talkerUserName);
                        bundle2.putString("stat_send_msg_user", b2);
                        intent2.putExtra("_stat_obj", bundle2);
                        this.tKy.startActivity(intent2);
                    }
                } else if (bdVar.field_isSend == 0) {
                    j = bdVar.field_msgId;
                    Intent intent3 = new Intent();
                    intent3.setClassName(this.tKy.tTq.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    intent3.putExtra("app_msg_id", j);
                    this.tKy.startActivity(intent3);
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                str = p.B(aVar2.url, "message");
                PackageInfo packageInfo = getPackageInfo(aVar.tTq.getContext(), aVar2.appId);
                a(aVar, str, str, packageInfo == null ? null : packageInfo.versionName, packageInfo == null ? 0 : packageInfo.versionCode, aVar2.appId, false, bdVar.field_msgId, bdVar.field_msgSvrId, bdVar);
            }
            return true;
        }
        com.tencent.mm.ui.base.s.gH(aVar.tTq.getContext());
        return true;
    }
}
