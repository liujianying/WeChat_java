package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.d.d;
import com.tencent.mm.ui.conversation.d.g;
import com.tencent.mm.ui.r.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a extends d {
    List<String> dhI;
    private Paint fBa = new Paint();
    private c<kz> tGM;
    private HashMap<String, Boolean> umX;
    private HashMap<String, String> umY;
    private String username;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a(Context context, String str, a aVar) {
        super(context, aVar);
        this.username = str;
        this.umX = new HashMap();
        this.umY = new HashMap();
        this.dhI = new ArrayList();
        this.tGM = new c<kz>() {
            {
                this.sFo = kz.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                boolean z = false;
                kz kzVar = (kz) bVar;
                if (kzVar.bVk.bGy != null) {
                    x.d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", new Object[]{kzVar.bVk.bGy, Integer.valueOf(kzVar.bVk.bVl)});
                    if ((kzVar.bVk.bVl & 2) > 0) {
                        z = true;
                    }
                    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a.this.umX.remove(kzVar.bVk.bGy);
                    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a.this.umX.put(kzVar.bVk.bGy, Boolean.valueOf(z));
                    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a.this.notifyDataSetChanged();
                } else {
                    x.e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                }
                return true;
            }
        };
        com.tencent.mm.sdk.b.a.sFg.b(this.tGM);
    }

    public final void WT() {
        au.HU();
        setCursor(com.tencent.mm.model.c.FW().b(s.dAT, this.gRN, this.username));
        if (this.tlG != null) {
            this.tlG.Xb();
        }
        super.notifyDataSetChanged();
    }

    protected final void a(String str, g gVar) {
        boolean z;
        Boolean bool = (Boolean) this.umX.get(str);
        if (bool == null) {
            WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(str);
            z = rR != null && (rR.field_appOpt & 2) > 0;
            this.umX.put(str, bool);
        } else {
            z = bool.booleanValue();
        }
        if (z) {
            gVar.tEs.setVisibility(0);
            gVar.tEs.setImageResource(R.k.chat_reject_icon);
        } else {
            gVar.tEs.setVisibility(8);
        }
        CharSequence charSequence = (String) this.umY.get(str);
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = com.tencent.mm.ui.appbrand.b.ZW(com.tencent.mm.ui.appbrand.b.ZV(str));
            if (!TextUtils.isEmpty(charSequence)) {
                this.umY.put(str, charSequence);
            }
        }
        LayoutParams layoutParams;
        if (TextUtils.isEmpty(charSequence)) {
            layoutParams = (LayoutParams) gVar.tEp.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.weight = 0.0f;
            gVar.tEp.setLayoutParams(layoutParams);
        } else {
            int i;
            int dimensionPixelOffset;
            int dimensionPixelOffset2;
            float f;
            float f2;
            float f3;
            gVar.uoC.setVisibility(0);
            gVar.uoC.setText(this.context.getString(R.l.app_brand_source_from, new Object[]{charSequence}));
            if (this.context.getResources().getDisplayMetrics() != null) {
                i = this.context.getResources().getDisplayMetrics().widthPixels;
            } else {
                i = 0;
            }
            if (com.tencent.mm.bp.a.fi(this.context)) {
                dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapLargeSize);
                dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallWidth);
            } else {
                dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.NormalAvatarWrapSize);
                dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
            }
            int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.f.LargePadding);
            int dimensionPixelOffset4 = this.context.getResources().getDimensionPixelOffset(R.f.NormalPadding);
            d dVar = (d) this.tEl.get(str);
            String charSequence2 = (dVar == null || dVar.nickName == null) ? "" : dVar.nickName.toString();
            if (charSequence2 == null) {
                f = 0.0f;
            } else {
                this.fBa.setTextSize(this.tEi);
                f = this.fBa.measureText(charSequence2);
            }
            float f4 = 48.0f + f;
            int dimensionPixelOffset5 = this.context.getResources().getDimensionPixelOffset(R.f.ConversationTimeSmallerWidth);
            int dimensionPixelOffset6 = this.context.getResources().getDimensionPixelOffset(R.f.LittlePadding);
            x.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(dimensionPixelOffset2)});
            f = 0.0f;
            if (i > 0) {
                f = (float) ((((i - dimensionPixelOffset) - dimensionPixelOffset3) - dimensionPixelOffset4) - dimensionPixelOffset2);
            }
            if (f4 > f || f4 >= f || f <= 0.0f) {
                f2 = 0.6f;
                f3 = 0.4f;
            } else {
                f2 = Math.min(f4 / f, (((f - ((float) dimensionPixelOffset5)) - ((float) dimensionPixelOffset6)) - 48.0f) / f);
                f3 = 1.0f - f2;
            }
            layoutParams = (LayoutParams) gVar.tEp.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = f2;
            gVar.tEp.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) gVar.uoC.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = f3;
            gVar.uoC.setLayoutParams(layoutParams);
        }
        com.tencent.mm.pluginsdk.ui.a.b.n(gVar.eCl, str);
        if (!this.dhI.contains(str)) {
            this.dhI.add(str);
        }
    }

    public final void detach() {
        this.umX = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.tGM);
    }
}
