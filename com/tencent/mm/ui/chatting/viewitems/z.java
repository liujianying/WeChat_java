package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n$d;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.y.g$a;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class z {

    public static class b extends b implements m {
        private a tKy;
        private c udk;

        public final boolean bba() {
            return true;
        }

        public final boolean aq(int i, boolean z) {
            if (z && (i == 3 || i == 23 || i == 13 || i == 39 || i == 33)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            r rVar = new r(layoutInflater, R.i.chatting_item_to_picture);
            rVar.setTag(new d().q(rVar, false));
            return rVar;
        }

        public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
            boolean z;
            n$d bu;
            int i2;
            View view;
            this.tKy = aVar2;
            d dVar = (d) aVar;
            boolean containsKey = n.OW().dVW.containsKey(Long.valueOf(bdVar.field_msgId));
            e q = o.Pf().q(bdVar);
            if (q == null || containsKey) {
                z = false;
            } else {
                boolean z2;
                if (n.OW().bt(q.dTK)) {
                    bu = n.OW().bu(q.dTK);
                    i2 = (int) bu.bSQ;
                    z2 = i2 == 0 ? true : ((int) bu.mb) == i2 && i2 != 0;
                } else {
                    z2 = f.b(q);
                }
                z = z2;
            }
            g Pf = o.Pf();
            ImageView imageView = dVar.ube;
            String str2 = bdVar.field_imgPath;
            float density = com.tencent.mm.bp.a.getDensity(aVar2.tTq.getContext());
            int i3 = bdVar.cGC;
            int i4 = bdVar.cGD;
            int i5 = R.g.chat_img_template;
            ImageView imageView2 = dVar.udn;
            int i6 = R.g.chat_img_default_bg;
            if (z) {
                view = null;
            } else {
                view = dVar.udo;
            }
            if (!(Pf.a(imageView, str2, density, i3, i4, i5, imageView2, i6, 0, view) || this.qUB)) {
                dVar.ube.setImageDrawable(com.tencent.mm.bp.a.f(aVar2.tTq.getContext(), R.g.nosdcard_pic));
            }
            if (q != null || containsKey) {
                Object obj = (z || bdVar.field_status == 5) ? 1 : null;
                if (containsKey) {
                    dVar.udm.setText("0%");
                } else {
                    int i7;
                    TextView textView = dVar.udm;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (q != null) {
                        i2 = q.dHI;
                        i7 = q.offset;
                        if (n.OW().bt(q.dTK)) {
                            bu = n.OW().bu(q.dTK);
                            i2 = (int) bu.bSQ;
                            i7 = (int) bu.mb;
                        }
                        if (q.ON()) {
                            e hQ = o.Pf().hQ(q.dTU);
                            if (n.OW().bt((long) q.dTU)) {
                                bu = n.OW().bu((long) q.dTU);
                                i2 = (int) bu.bSQ;
                                i7 = (int) bu.mb;
                            } else {
                                i2 = hQ.dHI;
                                i7 = hQ.offset;
                            }
                        }
                        if (i2 > 0) {
                            i7 = i7 >= i2 ? 100 : (i7 * 100) / i2;
                            textView.setText(stringBuilder.append(i7).append("%").toString());
                        }
                    }
                    i7 = 0;
                    textView.setText(stringBuilder.append(i7).append("%").toString());
                }
                dVar.mgA.setVisibility(obj != null ? 8 : 0);
                dVar.udm.setVisibility(obj != null ? 8 : 0);
                dVar.udo.setVisibility(obj != null ? 8 : 0);
            } else {
                dVar.udo.setVisibility(8);
                dVar.mgA.setVisibility(8);
                dVar.udm.setVisibility(8);
            }
            dVar.hrH.setTag(new au(bdVar, aVar2.cwr(), i, bdVar.field_talker, 0));
            View view2 = dVar.hrH;
            if (this.udk == null) {
                this.udk = new c(this.tKy, this);
            }
            view2.setOnClickListener(this.udk);
            dVar.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            dVar.hrH.setOnLongClickListener(c(aVar2));
            dVar.ube.setContentDescription(aVar2.tTq.getMMResources().getString(R.l.chatting_img_item_desc));
            if (cxN()) {
                dVar.mgA.setVisibility(8);
                x.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[]{Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.field_status)});
                if (cxN()) {
                    if (bdVar.field_status == 2) {
                        if (a((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class), bdVar.field_msgId)) {
                            if (dVar.uai != null) {
                                dVar.uai.setVisibility(0);
                            }
                        }
                    }
                    if (dVar.uai != null) {
                        dVar.uai.setVisibility(8);
                    }
                }
            }
            a(i, dVar, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
            z.a(bdVar, aVar2, dVar);
        }

        public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
            au.HU();
            if (c.isSDCardAvailable() && view != null) {
                int i = ((au) view.getTag()).position;
                e eVar = null;
                if (bdVar.field_msgId > 0) {
                    eVar = o.Pf().br(bdVar.field_msgId);
                }
                if ((eVar == null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                    eVar = o.Pf().bq(bdVar.field_msgSvrId);
                }
                if (eVar != null && eVar.ON() && eVar.dHI == 0) {
                    eVar = o.Pf().hQ(eVar.dTU);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(R.l.retransmit));
                if (bdVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.l.chatting_resend_title));
                }
                if (com.tencent.mm.ac.f.MI() && !this.tKy.cws()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.chatting_long_click_brand_service));
                }
                if (com.tencent.mm.bg.d.QS("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
                }
                dj djVar = new dj();
                djVar.bLf.bJC = bdVar.field_msgId;
                com.tencent.mm.sdk.b.a.sFg.m(djVar);
                if (djVar.bLg.bKE || com.tencent.mm.pluginsdk.model.app.g.U(this.tKy.tTq.getContext(), bdVar.getType())) {
                    contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
                }
                if (eVar.status != -1) {
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
                if (!bdVar.cky() && bdVar.ckA() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
                    contextMenu.add(i, TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
                }
                if (!this.tKy.cws()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_img));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
            if (100 == menuItem.getItemId()) {
                z.e(bdVar, aVar);
            } else if (131 == menuItem.getItemId()) {
                z.b(aVar, menuItem, bdVar);
            } else {
                ((com.tencent.mm.ui.chatting.b.b.x) aVar.O(com.tencent.mm.ui.chatting.b.b.x.class)).a(menuItem, bdVar);
            }
            return false;
        }

        public final boolean b(View view, a aVar, bd bdVar) {
            return false;
        }

        public static void a(b.a aVar, int i, int i2) {
            int i3 = i2 > 0 ? i >= i2 ? 100 : (int) ((((long) i) * 100) / ((long) i2)) : 0;
            d dVar = (d) aVar;
            if (i3 < 100 || dVar.udm.getVisibility() == 0) {
                dVar.udm.setText(i3 + "%");
                if (cxN()) {
                    dVar.mgA.setVisibility(8);
                } else {
                    dVar.mgA.setVisibility(0);
                }
                dVar.udm.setVisibility(0);
                dVar.udo.setVisibility(0);
            }
        }

        public static void a(b.a aVar, boolean z) {
            if (z) {
                d dVar = (d) aVar;
                dVar.mgA.setVisibility(4);
                dVar.udm.setVisibility(4);
                dVar.udo.setVisibility(4);
            }
        }

        public final void a(a aVar, bd bdVar) {
            bdVar.cmw();
            au.HU();
            c.FT().a(bdVar.field_msgId, bdVar);
            ((com.tencent.mm.ui.chatting.b.b.x) aVar.O(com.tencent.mm.ui.chatting.b.b.x.class)).aS(bdVar);
        }
    }

    static class d extends b.a {
        TextView jet;
        ProgressBar mgA;
        ImageView uai;
        ImageView ube;
        TextView udm;
        ImageView udn;
        View udo;

        public final b.a q(View view, boolean z) {
            super.dx(view);
            this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
            this.ube = (ImageView) view.findViewById(R.h.chatting_content_iv);
            this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
            this.gFD = view.findViewById(R.h.chatting_maskview);
            this.udo = view.findViewById(R.h.uploading_view);
            if (z) {
                this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
                this.mgA = (ProgressBar) view.findViewById(R.h.downloading_pb);
            } else {
                this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
                this.udm = (TextView) view.findViewById(R.h.uploading_tv);
                this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
                this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
            }
            this.udn = (ImageView) view.findViewById(R.h.chatting_content_mask_iv);
            this.jet = (TextView) view.findViewById(R.h.chatting_appmsg_source_tv);
            return this;
        }
    }

    static /* synthetic */ void a(bd bdVar, a aVar, d dVar) {
        g$a go = g$a.go(bdVar.field_content);
        if (go == null || bi.oW(go.appId)) {
            dVar.jet.setVisibility(8);
            return;
        }
        String str = go.appId;
        com.tencent.mm.pluginsdk.model.app.f cP = com.tencent.mm.pluginsdk.model.app.g.cP(str, go.cbu);
        if (cP != null && cP.aaq()) {
            b.b(aVar, go, bdVar);
        }
        String str2 = (cP == null || cP.field_appName == null || cP.field_appName.trim().length() <= 0) ? go.appName : cP.field_appName;
        if (b.cT(str2)) {
            dVar.jet.setText(com.tencent.mm.pluginsdk.model.app.g.b(aVar.tTq.getContext(), cP, str2));
            dVar.jet.setVisibility(0);
            if (cP == null || !cP.aaq()) {
                b.a(aVar, dVar.jet, str);
            } else {
                b.a(aVar, dVar.jet, bdVar, go, cP.field_packageName, bdVar.field_msgSvrId);
            }
            b.a(aVar, dVar.jet, str);
            return;
        }
        dVar.jet.setVisibility(8);
    }

    static /* synthetic */ boolean b(a aVar, MenuItem menuItem, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 131:
                x.i("MicroMsg.ChattingItemImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    x.e("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    return true;
                }
                Object obj;
                e eVar;
                e bq;
                String o;
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = new int[]{intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (!s.fq(aVar.getTalkerUserName())) {
                    if (!((com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus()) {
                        obj = null;
                        if (obj != null) {
                            str = bdVar.field_talker;
                        }
                        eVar = null;
                        if (bdVar.field_msgId > 0) {
                            eVar = o.Pf().br(bdVar.field_msgId);
                        }
                        bq = ((eVar != null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) ? o.Pf().bq(bdVar.field_msgSvrId) : eVar;
                        o = bq != null ? "" : o.Pf().o(bq.dTL, "", "");
                        if (bq != null || bq.status == -1 || bdVar.field_status == 5) {
                            x.e("MicroMsg.ChattingItemImg", "raw img not get successfully ,msgId:%s", new Object[]{Long.valueOf(bdVar.field_msgId)});
                        } else {
                            x.i("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", new Object[]{Long.valueOf(bdVar.field_msgId), o});
                            c.a(aVar, bdVar, bdVar.field_msgId, bdVar.field_msgSvrId, bdVar.field_talker, str, iArr, intExtra, intExtra2, true);
                        }
                        return true;
                    }
                }
                obj = 1;
                if (obj != null) {
                    str = bdVar.field_talker;
                }
                eVar = null;
                if (bdVar.field_msgId > 0) {
                    eVar = o.Pf().br(bdVar.field_msgId);
                }
                if (eVar != null) {
                    break;
                }
                if (bq != null) {
                }
                if (bq != null) {
                    break;
                }
                x.e("MicroMsg.ChattingItemImg", "raw img not get successfully ,msgId:%s", new Object[]{Long.valueOf(bdVar.field_msgId)});
                return true;
            default:
                return false;
        }
    }

    static /* synthetic */ void e(bd bdVar, a aVar) {
        g$a go = g$a.go(bdVar.field_content);
        if (go != null && !bi.oW(go.appId)) {
            com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(go.appId, false);
            if (bl != null && bl.aaq()) {
                b.a(aVar, go, bdVar, bl);
            }
        }
    }
}
