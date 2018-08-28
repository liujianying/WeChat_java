package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

public final class e extends LinearLayout implements OnClickListener {
    private LayoutInflater Bc = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int jNv;
    private String mAppId;
    private Context mContext;

    private static class a {
        public String jLt;
        public int jOu;
        public String jumpUrl;

        public a(int i, String str, String str2) {
            this.jOu = i;
            this.jumpUrl = str;
            this.jLt = str2;
        }
    }

    public e(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.game.d.ae r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        if (r12 == 0) goto L_0x000a;
    L_0x0002:
        r0 = r12.jQF;
        r0 = com.tencent.mm.sdk.platformtools.bi.cX(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r0 = 8;
        r11.setVisibility(r0);
    L_0x000f:
        return;
    L_0x0010:
        r11.mAppId = r13;
        r11.jNv = r15;
        r0 = r12.jQF;
        r7 = r0.iterator();
    L_0x001a:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x000f;
    L_0x0020:
        r0 = r7.next();
        r4 = r0;
        r4 = (com.tencent.mm.plugin.game.d.j) r4;
        if (r4 == 0) goto L_0x001a;
    L_0x0029:
        r5 = new com.tencent.mm.plugin.game.e.e$a$a;
        r5.<init>();
        r0 = r4.jPF;
        switch(r0) {
            case 1: goto L_0x004a;
            case 2: goto L_0x00e3;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = 2;
        if (r14 != r0) goto L_0x001a;
    L_0x0036:
        r0 = r11.mContext;
        r1 = 10;
        r2 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r3 = r4.jPC;
        r4 = r4.jPA;
        r6 = com.tencent.mm.plugin.game.model.an.Dx(r4);
        r4 = r13;
        r5 = r15;
        com.tencent.mm.plugin.game.model.an.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x001a;
    L_0x004a:
        r0 = r4.jPD;
        if (r0 == 0) goto L_0x001a;
    L_0x004e:
        r11.h(r11);
        r0 = r11.Bc;
        r1 = com.tencent.mm.plugin.game.f.f.game_center_4_block_content_multiline_view;
        r2 = 1;
        r6 = r0.inflate(r1, r11, r2);
        r0 = com.tencent.mm.plugin.game.f.e.multiline_module;
        r0 = r6.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = com.tencent.mm.plugin.game.f.e.multiline_title;
        r1 = r6.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2 = com.tencent.mm.plugin.game.f.e.multiline_desc;
        r2 = r6.findViewById(r2);
        r2 = (com.tencent.mm.plugin.game.widget.EllipsizingTextView) r2;
        r3 = 2;
        r2.setMaxLines(r3);
        r3 = com.tencent.mm.plugin.game.f.e.multiline_picture;
        r3 = r6.findViewById(r3);
        r3 = (android.widget.ImageView) r3;
        r8 = r11.mContext;
        r9 = r4.jPB;
        r10 = r0.getTextSize();
        r8 = com.tencent.mm.pluginsdk.ui.d.j.a(r8, r9, r10);
        r0.setText(r8);
        r0 = r11.mContext;
        r8 = r4.jPD;
        r8 = r8.bHD;
        r9 = r1.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r0, r8, r9);
        r1.setText(r0);
        r0 = r11.mContext;
        r1 = r4.jPD;
        r1 = r1.jOS;
        r8 = r2.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r0, r1, r8);
        r2.setText(r0);
        r0 = r4.jPD;
        r0 = r0.jOT;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00dd;
    L_0x00b9:
        r0 = com.tencent.mm.plugin.game.e.e.aVj();
        r1 = r4.jPD;
        r1 = r1.jOT;
        r2 = r5.aVk();
        r0.a(r3, r1, r2);
    L_0x00c8:
        r0 = new com.tencent.mm.plugin.game.ui.e$a;
        r1 = r4.jPC;
        r2 = r4.jPD;
        r2 = r2.jOU;
        r3 = r4.jPA;
        r0.<init>(r1, r2, r3);
        r6.setTag(r0);
        r6.setOnClickListener(r11);
        goto L_0x0033;
    L_0x00dd:
        r0 = 8;
        r3.setVisibility(r0);
        goto L_0x00c8;
    L_0x00e3:
        r0 = r4.jPE;
        if (r0 == 0) goto L_0x001a;
    L_0x00e7:
        r11.h(r11);
        r0 = r11.Bc;
        r1 = com.tencent.mm.plugin.game.f.f.game_center_4_block_content_singleline_view;
        r2 = 1;
        r3 = r0.inflate(r1, r11, r2);
        r0 = com.tencent.mm.plugin.game.f.e.singleline_module;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = com.tencent.mm.plugin.game.f.e.singleline_title;
        r1 = r3.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2 = com.tencent.mm.plugin.game.f.e.singleline_picture;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.ImageView) r2;
        r6 = r11.mContext;
        r8 = r4.jPB;
        r9 = r0.getTextSize();
        r6 = com.tencent.mm.pluginsdk.ui.d.j.a(r6, r8, r9);
        r0.setText(r6);
        r0 = r11.mContext;
        r6 = r4.jPE;
        r6 = r6.bHD;
        r8 = r1.getTextSize();
        r0 = com.tencent.mm.pluginsdk.ui.d.j.a(r0, r6, r8);
        r1.setText(r0);
        r0 = r4.jPE;
        r0 = r0.jOT;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x016f;
    L_0x0135:
        r0 = r4.jPE;
        r0 = r0.jTr;
        r1 = 1;
        if (r0 != r1) goto L_0x0167;
    L_0x013c:
        r0 = 1;
        r5.kdA = r0;
        r0 = com.tencent.mm.plugin.game.f.d.game_default_square;
        r5.kdD = r0;
    L_0x0143:
        r0 = com.tencent.mm.plugin.game.e.e.aVj();
        r1 = r4.jPE;
        r1 = r1.jOT;
        r5 = r5.aVk();
        r0.a(r2, r1, r5);
    L_0x0152:
        r0 = new com.tencent.mm.plugin.game.ui.e$a;
        r1 = r4.jPC;
        r2 = r4.jPE;
        r2 = r2.jOU;
        r5 = r4.jPA;
        r0.<init>(r1, r2, r5);
        r3.setTag(r0);
        r3.setOnClickListener(r11);
        goto L_0x0033;
    L_0x0167:
        r0 = 1;
        r5.dXW = r0;
        r0 = com.tencent.mm.plugin.game.f.d.game_default_round;
        r5.kdD = r0;
        goto L_0x0143;
    L_0x016f:
        r0 = 8;
        r2.setVisibility(r0);
        goto L_0x0152;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.e.a(com.tencent.mm.plugin.game.d.ae, java.lang.String, int, int):void");
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.w("MicroMsg.GameBlockContentView", "getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (bi.oW(aVar.jumpUrl)) {
            x.w("MicroMsg.GameBlockContentView", "jumpUrl is null");
            return;
        }
        an.a(this.mContext, 10, TXLiveConstants.PUSH_EVT_PUSH_BEGIN, aVar.jOu, c.r(this.mContext, aVar.jumpUrl, "game_center_mygame_comm"), this.mAppId, this.jNv, an.Dx(aVar.jLt));
    }

    private void h(ViewGroup viewGroup) {
        ImageView imageView = (ImageView) this.Bc.inflate(f.game_divide_line, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 20);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
    }
}
