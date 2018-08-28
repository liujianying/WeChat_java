package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.c;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class j extends a {
    private HashMap<String, SpannableString> jeP = new HashMap();
    private final int jeu;

    public j(k kVar) {
        super(kVar);
        this.jeu = a.ad(kVar.context, c.FavImageSize);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.view.View r15, android.view.ViewGroup r16, com.tencent.mm.plugin.fav.a.g r17) {
        /*
        r14 = this;
        r1 = r16.getContext();
        if (r15 != 0) goto L_0x0097;
    L_0x0006:
        r2 = new com.tencent.mm.plugin.fav.ui.d.j$a;
        r2.<init>();
        r3 = com.tencent.mm.plugin.fav.ui.m.f.fav_listitem_record;
        r4 = 0;
        r1 = android.view.View.inflate(r1, r3, r4);
        r0 = r17;
        r15 = r14.a(r1, r2, r0);
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_icon;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.ImageView) r1;
        r2.gmn = r1;
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_title1;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.jeR = r1;
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_desc1;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.jeS = r1;
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_title2;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.jeT = r1;
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_desc2;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.jeU = r1;
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_icon_video_mask;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.ImageView) r1;
        r2.jeF = r1;
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_icon_shortvideo;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.ImageView) r1;
        r2.jeQ = r1;
        r1 = com.tencent.mm.plugin.fav.ui.m.e.fav_icon_fl;
        r1 = r15.findViewById(r1);
        r1 = (android.widget.FrameLayout) r1;
        r2.jeV = r1;
        r9 = r2;
    L_0x0069:
        r0 = r17;
        r14.a(r9, r0);
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r1 = 0;
        r0 = r17;
        r2 = r0.field_favProto;
        r11 = r2.rBI;
        r7 = r11.iterator();
        r2 = r1;
        r10 = r6;
    L_0x007f:
        r1 = r7.hasNext();
        if (r1 == 0) goto L_0x00ac;
    L_0x0085:
        r1 = r7.next();
        r1 = (com.tencent.mm.protocal.c.vx) r1;
        r1 = r1.bjS;
        switch(r1) {
            case 1: goto L_0x00a6;
            case 2: goto L_0x009f;
            case 3: goto L_0x00a6;
            case 4: goto L_0x009f;
            case 5: goto L_0x00a6;
            case 6: goto L_0x00a6;
            case 7: goto L_0x00a6;
            case 8: goto L_0x00a6;
            case 9: goto L_0x0090;
            case 10: goto L_0x00a6;
            case 11: goto L_0x00a6;
            case 12: goto L_0x0090;
            case 13: goto L_0x0090;
            case 14: goto L_0x00a6;
            case 15: goto L_0x009f;
            case 16: goto L_0x00a6;
            case 17: goto L_0x00a6;
            default: goto L_0x0090;
        };
    L_0x0090:
        r1 = r2;
        r6 = r10;
    L_0x0092:
        r4 = r4 + 1;
        r2 = r1;
        r10 = r6;
        goto L_0x007f;
    L_0x0097:
        r1 = r15.getTag();
        r1 = (com.tencent.mm.plugin.fav.ui.d.j.a) r1;
        r9 = r1;
        goto L_0x0069;
    L_0x009f:
        if (r3 != 0) goto L_0x0090;
    L_0x00a1:
        r3 = 1;
        r1 = r2;
        r5 = r4;
        r6 = r10;
        goto L_0x0092;
    L_0x00a6:
        if (r2 != 0) goto L_0x0090;
    L_0x00a8:
        r2 = 1;
        r1 = r2;
        r6 = r4;
        goto L_0x0092;
    L_0x00ac:
        r1 = "MicroMsg.FavRecordListItem";
        r2 = "hasThumb %s, firstRemarkIndex %d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = java.lang.Boolean.valueOf(r3);
        r4[r6] = r7;
        r6 = 1;
        r7 = java.lang.Integer.valueOf(r10);
        r4[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r4);
        r1 = r11.size();
        if (r1 > 0) goto L_0x00d6;
    L_0x00cc:
        r1 = "MicroMsg.FavRecordListItem";
        r2 = "dataList size is null";
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);
    L_0x00d5:
        return r15;
    L_0x00d6:
        r1 = r11.get(r10);
        r1 = (com.tencent.mm.protocal.c.vx) r1;
        r2 = r9.jeR;
        r4 = r9.jeS;
        a(r2, r4, r1);
        if (r3 == 0) goto L_0x0194;
    L_0x00e5:
        r1 = r9.jeV;
        r2 = 0;
        r1.setVisibility(r2);
        r1 = r9.gmn;
        r2 = 0;
        r1.setVisibility(r2);
        r2 = r9.gmn;
        r1 = r11.get(r5);
        r8 = r1;
        r8 = (com.tencent.mm.protocal.c.vx) r8;
        r1 = r8.bjS;
        switch(r1) {
            case 2: goto L_0x0123;
            case 4: goto L_0x0184;
            case 15: goto L_0x0184;
            default: goto L_0x00ff;
        };
    L_0x00ff:
        r1 = r10 + 1;
        r2 = r11.size();
        if (r1 >= r2) goto L_0x01a4;
    L_0x0107:
        r1 = r9.jeT;
        r2 = 0;
        r1.setVisibility(r2);
        r1 = r9.jeU;
        r2 = 0;
        r1.setVisibility(r2);
        r2 = r9.jeT;
        r3 = r9.jeU;
        r1 = r10 + 1;
        r1 = r11.get(r1);
        r1 = (com.tencent.mm.protocal.c.vx) r1;
        a(r2, r3, r1);
        goto L_0x00d5;
    L_0x0123:
        r12 = r14.iYh;
        r5 = com.tencent.mm.plugin.fav.ui.m.h.record_nopicture_icon;
        r6 = r14.jeu;
        r7 = r14.jeu;
        if (r2 == 0) goto L_0x00ff;
    L_0x012d:
        r1 = com.tencent.mm.compatible.util.f.zZ();
        if (r1 != 0) goto L_0x0139;
    L_0x0133:
        r1 = com.tencent.mm.plugin.fav.ui.m.d.nosdcard_chatting_bg;
        r2.setImageResource(r1);
        goto L_0x00ff;
    L_0x0139:
        if (r8 == 0) goto L_0x00ff;
    L_0x013b:
        if (r17 == 0) goto L_0x00ff;
    L_0x013d:
        r4 = r8.jdM;
        if (r4 == 0) goto L_0x00ff;
    L_0x0141:
        r3 = 0;
        r1 = r8.jdM;
        if (r1 == 0) goto L_0x0166;
    L_0x0146:
        r1 = r12.jaO;
        r1 = r1.get(r4);
        r1 = (java.lang.String[]) r1;
        if (r1 != 0) goto L_0x01b4;
    L_0x0150:
        r1 = 2;
        r3 = new java.lang.String[r1];
        r1 = 0;
        r13 = com.tencent.mm.plugin.fav.a.b.b(r8);
        r3[r1] = r13;
        r1 = 1;
        r13 = com.tencent.mm.plugin.fav.a.b.c(r8);
        r3[r1] = r13;
        r1 = r12.jaO;
        r1.put(r4, r3);
    L_0x0166:
        r1 = r12.jaN;
        r4 = 0;
        r1.a(r2, r3, r4, r5, r6, r7);
        if (r3 == 0) goto L_0x00ff;
    L_0x016e:
        r1 = r3.length;
        if (r1 <= 0) goto L_0x00ff;
    L_0x0171:
        r1 = 0;
        r1 = r3[r1];
        r2 = com.tencent.mm.kernel.g.Em();
        r3 = new com.tencent.mm.plugin.fav.ui.k$2;
        r0 = r17;
        r3.<init>(r12, r1, r0, r8);
        r2.H(r3);
        goto L_0x00ff;
    L_0x0184:
        r1 = r14.iYh;
        r5 = com.tencent.mm.plugin.fav.ui.m.h.app_attach_file_icon_video;
        r6 = r14.jeu;
        r7 = r14.jeu;
        r3 = r8;
        r4 = r17;
        r1.b(r2, r3, r4, r5, r6, r7);
        goto L_0x00ff;
    L_0x0194:
        r1 = r9.jeV;
        r2 = 8;
        r1.setVisibility(r2);
        r1 = r9.gmn;
        r2 = 8;
        r1.setVisibility(r2);
        goto L_0x00ff;
    L_0x01a4:
        r1 = r9.jeT;
        r2 = 8;
        r1.setVisibility(r2);
        r1 = r9.jeU;
        r2 = 8;
        r1.setVisibility(r2);
        goto L_0x00d5;
    L_0x01b4:
        r3 = r1;
        goto L_0x0166;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.d.j.a(android.view.View, android.view.ViewGroup, com.tencent.mm.plugin.fav.a.g):android.view.View");
    }

    private static void a(TextView textView, TextView textView2, vx vxVar) {
        if (vxVar.rAl) {
            textView.setVisibility(0);
            textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(textView.getContext(), vxVar.rAk, textView.getTextSize()));
        } else {
            x.d("MicroMsg.FavRecordListItem", "has no datasrcname");
            textView.setVisibility(8);
        }
        x.d("MicroMsg.FavRecordListItem", "field type %d", new Object[]{Integer.valueOf(vxVar.bjS)});
        switch (vxVar.bjS) {
            case 1:
                textView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(textView2.getContext(), vxVar.desc, textView2.getTextSize()));
                return;
            case 2:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_image));
                return;
            case 3:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_voice));
                return;
            case 4:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_video));
                return;
            case 5:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_url) + vxVar.title);
                return;
            case 6:
                we weVar = vxVar.rAi.rAL;
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_location) + (bi.oW(weVar.bWB) ? weVar.label : weVar.bWB));
                return;
            case 7:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_music) + vxVar.title);
                return;
            case 8:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_file) + vxVar.title);
                return;
            case 10:
                textView2.setText(D(textView2.getContext(), i.favorite_mall_product) + vxVar.rAi.rAP.title);
                return;
            case 15:
                textView2.setText(D(textView2.getContext(), i.favorite_sight));
                return;
            case 16:
                textView2.setText(D(textView2.getContext(), i.favorite_friend_card));
                return;
            case 17:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_title_record));
                return;
            case 19:
                textView2.setText(D(textView2.getContext(), i.favorite_sub_app_brand) + vxVar.title);
                return;
            default:
                return;
        }
    }

    private static String D(Context context, int i) {
        return "[" + context.getResources().getString(i) + "]";
    }

    public final void a(View view, wn wnVar) {
        a aVar = (a) view.getTag();
        ((y) g.l(y.class)).a(view.getContext(), aVar.iWQ, wnVar);
    }
}
