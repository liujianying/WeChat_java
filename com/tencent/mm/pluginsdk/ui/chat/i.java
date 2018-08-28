package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.ui.chat.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i {
    ImageView bRk = null;
    Bitmap bitmap = null;
    private View contentView = null;
    Context context;
    SharedPreferences duR;
    View kHl;
    View nHH;
    private h qMO;
    g qMP;
    o qMQ;
    boolean qMR = true;
    a qMS;
    a qMT;

    public i(Context context, View view, View view2, a aVar) {
        this.context = context;
        this.nHH = view;
        this.kHl = view2;
        this.qMO = new h(this.context);
        this.duR = context.getSharedPreferences(ad.chY(), 0);
        this.qMT = aVar;
        this.contentView = View.inflate(this.context, R.i.chatting_footer_recent_image_bubble, null);
        this.bRk = (ImageView) this.contentView.findViewById(R.h.recent_image_iv);
        this.qMQ = new o(this.contentView, -2, -2, true);
        this.qMQ.setBackgroundDrawable(new ColorDrawable(0));
        this.qMQ.setOutsideTouchable(true);
        this.contentView.setOnClickListener(new 1(this));
    }

    public final synchronized String ceS() {
        String str;
        g gVar;
        if (this.qMO == null) {
            x.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            gVar = null;
        } else {
            ArrayList ceR = this.qMO.ceR();
            if (ceR == null || ceR.size() == 0) {
                x.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                gVar = null;
            } else {
                gVar = (g) ceR.get(0);
                if (gVar != null) {
                    if ((bi.bG(gVar.jAV) < 0 ? 1 : null) != null) {
                        x.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[]{gVar.qMN});
                        gVar = null;
                    }
                }
                if (gVar == null || gVar.qMN == null || !gVar.qMN.contains(e.bnD)) {
                    if (gVar != null) {
                        if ((bi.bG(gVar.jAV) <= 30 ? 1 : null) != null) {
                            if (this.duR.getString("chattingui_recent_shown_image_path", "").equals(gVar.qMN)) {
                                x.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                gVar = null;
                            }
                        }
                    }
                    String str2 = "MicroMsg.RecentImageBubble";
                    String str3 = "because of checkAddDate(addDate) == false, or imageItem == null : %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(gVar == null);
                    x.d(str2, str3, objArr);
                    gVar = null;
                } else {
                    gVar = null;
                }
            }
        }
        this.qMP = gVar;
        if (this.qMP == null) {
            str = null;
        } else {
            str = this.qMP.bOX;
            if (this.qMP.bOX == null) {
                str = this.qMP.qMN;
            }
        }
        return str;
    }

    final float Cm(int i) {
        return TypedValue.applyDimension(1, (float) i, this.context.getResources().getDisplayMetrics());
    }
}
