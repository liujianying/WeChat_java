package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a.a;
import java.lang.ref.WeakReference;

public class n extends ClickableSpan implements a {
    private WeakReference<View> cB = null;
    private int doi;
    private String fmS;
    public boolean lmQ = false;
    boolean mEnable = true;
    private Context qQs = null;
    private int qQx;
    private h qQy = null;
    private m qQz = null;

    public n(int i, m mVar) {
        int i2;
        int i3;
        if (mVar != null) {
            int i4 = mVar.linkColor;
            i2 = mVar.backgroundColor;
            i3 = i4;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if (i3 == 0 && i2 == 0) {
            zu(i);
        } else {
            ez(i3, i2);
        }
        this.qQy = new h();
        this.qQz = mVar;
    }

    public void zu(int i) {
        Context context = ad.getContext();
        switch (i) {
            case 1:
                ez(context.getResources().getColor(b.chat_url_color), -5908174);
                return;
            case 2:
                ez(context.getResources().getColor(b.link_color), context.getResources().getColor(b.sns_link_bg_color));
                return;
            case 3:
                ez(context.getResources().getColor(b.sns_lucky_item_gold), context.getResources().getColor(b.sns_link_bg_color));
                return;
            default:
                return;
        }
    }

    public final void ez(int i, int i2) {
        this.qQx = i;
        this.doi = i2;
    }

    public final void kT(boolean z) {
        this.lmQ = z;
    }

    public final int getType() {
        return this.qQz == null ? Integer.MAX_VALUE : this.qQz.type;
    }

    public void onClick(View view) {
        if (this.qQy != null && this.qQz != null && this.mEnable) {
            this.qQy.mContext = this.qQs != null ? this.qQs : view.getContext();
            h hVar = this.qQy;
            m mVar = this.qQz;
            if (System.currentTimeMillis() - hVar.pkb <= ((long) hVar.pka)) {
                x.e("MicroMsg.MMSpanClickListener", "process pass");
            } else {
                hVar.pkb = System.currentTimeMillis();
                if (mVar == null) {
                    x.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
                } else {
                    x.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", Integer.valueOf(mVar.type));
                    if (hVar.mContext == null) {
                        x.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
                    } else {
                        g gVar;
                        String str;
                        if (j.qPZ == null || j.qPZ.size() <= 0) {
                            gVar = null;
                        } else {
                            int size = j.qPZ.size();
                            g gVar2 = (g) j.qPZ.getLast();
                            x.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", Integer.valueOf(size));
                            gVar = gVar2;
                        }
                        if (view != null && (view.getTag() instanceof c)) {
                            cm cmVar = ((c) view.getTag()).bXQ;
                            if (cmVar != null) {
                                str = cmVar.field_talker;
                                if (str.endsWith("@chatroom")) {
                                    str = bd.iB(cmVar.field_content);
                                }
                                mVar.username = str;
                                if (!TextUtils.isEmpty(hVar.fmS)) {
                                    mVar.fmS = hVar.fmS;
                                }
                                b.a.qPF.a(hVar.mContext, mVar, gVar);
                                mVar.fmS = null;
                            }
                        }
                        str = null;
                        mVar.username = str;
                        if (TextUtils.isEmpty(hVar.fmS)) {
                            mVar.fmS = hVar.fmS;
                        }
                        b.a.qPF.a(hVar.mContext, mVar, gVar);
                        mVar.fmS = null;
                    }
                }
            }
            this.qQy.mContext = null;
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.qQx);
        textPaint.setUnderlineText(false);
        textPaint.linkColor = this.qQx;
        if (this.lmQ) {
            textPaint.bgColor = this.doi;
        } else {
            textPaint.bgColor = 0;
        }
    }

    public final void setContext(Context context) {
        this.qQs = context;
        this.qQy.mContext = context;
    }

    public final void setSessionId(String str) {
        this.fmS = str;
        if (this.qQy != null) {
            this.qQy.fmS = this.fmS;
        }
    }
}
