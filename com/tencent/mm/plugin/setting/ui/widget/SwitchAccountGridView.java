package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView extends GridLayout {
    private static int mVV;
    private String eSe;
    private boolean mVW;
    private boolean mVX;
    private boolean mVY;
    public String mVZ;
    public boolean mWa;
    public AnimatorSet mWb;
    public List<String> mWc = new ArrayList();
    public List<d> mWd = new ArrayList();
    public List<View> mWe = new ArrayList();
    private b mWf;
    private a mWg;
    private c mWh;

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$4 */
    class AnonymousClass4 implements AnimatorUpdateListener {
        final /* synthetic */ int mWk;

        public AnonymousClass4(int i) {
            this.mWk = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            x.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(floatValue));
            while (i < this.mWk) {
                if (!((String) SwitchAccountGridView.this.mWc.get(i)).equals(SwitchAccountGridView.this.mVZ)) {
                    ((View) SwitchAccountGridView.this.mWe.get(i)).setAlpha(1.0f - floatValue);
                }
                i++;
            }
            if (this.mWk < SwitchAccountGridView.this.getChildCount()) {
                ((View) SwitchAccountGridView.this.mWe.get(this.mWk)).setTranslationX(((float) ((View) SwitchAccountGridView.this.mWe.get(this.mWk)).getWidth()) * floatValue);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$5 */
    class AnonymousClass5 implements AnimatorUpdateListener {
        final /* synthetic */ int mWk;

        public AnonymousClass5(int i) {
            this.mWk = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            x.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(((Float) valueAnimator.getAnimatedValue()).floatValue()));
            for (int i = 0; i < this.mWk; i++) {
                if (((String) SwitchAccountGridView.this.mWc.get(i)).equals(SwitchAccountGridView.this.mVZ)) {
                    ((View) SwitchAccountGridView.this.mWe.get(i)).setTranslationX(((float) (((SwitchAccountGridView.this.getWidth() / 2) - (((View) SwitchAccountGridView.this.mWe.get(i)).getWidth() * i)) - (((View) SwitchAccountGridView.this.mWe.get(i)).getWidth() / 2))) * r3);
                    return;
                }
            }
        }
    }

    public interface a {
        void btZ();
    }

    public interface b {
        void KY(String str);
    }

    public interface c {
        void KZ(String str);
    }

    private class d {
        public ImageView eDn;
        public TextView kbU;
        public ImageView mUo;
        public View mWl;

        private d() {
        }

        /* synthetic */ d(SwitchAccountGridView switchAccountGridView, byte b) {
            this();
        }
    }

    public SwitchAccountGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mVV = getResources().getDimensionPixelOffset(com.tencent.mm.plugin.setting.a.d.BigAvatarSize) * 2;
    }

    public final void L(Map<String, SwitchAccountModel> map) {
        ImageView imageView;
        ImageView imageView2;
        if (!(map == null || map.isEmpty())) {
            this.mWc.addAll(map.keySet());
            Collections.sort(this.mWc);
        }
        x.i("MicroMsg.SwitchAccountGridView", "account count %d", Integer.valueOf(this.mWc.size()));
        for (int i = 0; i < this.mWc.size(); i++) {
            View inflate = ((Activity) getContext()).getLayoutInflater().inflate(g.settings_switch_account_item, null);
            imageView = (ImageView) inflate.findViewById(f.account_avatar);
            imageView2 = (ImageView) inflate.findViewById(f.account_del_btn);
            View findViewById = inflate.findViewById(f.current_account);
            final String str = (String) this.mWc.get(i);
            TextView textView = (TextView) inflate.findViewById(f.account_username);
            d dVar = new d(this, (byte) 0);
            dVar.eDn = imageView;
            dVar.mUo = imageView2;
            dVar.kbU = textView;
            dVar.mWl = findViewById;
            imageView.setScaleType(ScaleType.FIT_XY);
            String str2 = ((SwitchAccountModel) map.get(str)).jed;
            try {
                if (!bi.oW(str2)) {
                    Bitmap decodeByteArray;
                    if (this.mVY) {
                        x.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
                        byte[] e = e.e(str2, 0, e.cm(str2));
                        if (e != null) {
                            decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length);
                            if (decodeByteArray != null) {
                                imageView.setImageBitmap(decodeByteArray);
                            }
                        }
                    } else {
                        decodeByteArray = com.tencent.mm.aa.f.jW(str2);
                        if (decodeByteArray != null) {
                            imageView.setImageBitmap(decodeByteArray);
                        } else {
                            com.tencent.mm.pluginsdk.ui.a.b.a(dVar.eDn, str);
                        }
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SwitchAccountGridView", e2, "get avatar error", new Object[0]);
            }
            textView.setText(j.a(getContext(), ((SwitchAccountModel) map.get(str)).username, textView.getTextSize()));
            imageView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.i("MicroMsg.SwitchAccountGridView", "click %s", str);
                    if (!SwitchAccountGridView.this.mVW && SwitchAccountGridView.this.mWf != null) {
                        SwitchAccountGridView.this.mWf.KY(str);
                    }
                }
            });
            imageView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (SwitchAccountGridView.this.mWh != null) {
                        SwitchAccountGridView.this.mWh.KZ(str);
                    }
                }
            });
            this.mWd.add(dVar);
            this.mWe.add(inflate);
        }
        View inflate2 = ((Activity) getContext()).getLayoutInflater().inflate(g.settings_switch_account_item, null);
        imageView = (ImageView) inflate2.findViewById(f.account_avatar);
        imageView2 = (ImageView) inflate2.findViewById(f.account_del_btn);
        TextView textView2 = (TextView) inflate2.findViewById(f.account_username);
        d dVar2 = new d(this, (byte) 0);
        dVar2.eDn = imageView;
        dVar2.mUo = imageView2;
        dVar2.kbU = textView2;
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageResource(com.tencent.mm.plugin.setting.a.e.big_add_selector);
        textView2.setText(getContext().getResources().getString(i.settings_switch_account));
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.SwitchAccountGridView", "click addBtn");
                if (SwitchAccountGridView.this.mWf != null) {
                    SwitchAccountGridView.this.mWf.KY(null);
                }
            }
        });
        this.mWd.add(dVar2);
        this.mWe.add(inflate2);
    }

    public final void bum() {
        if (this.mWa) {
            x.i("MicroMsg.SwitchAccountGridView", "playing animation");
            return;
        }
        removeAllViews();
        int min = Math.min(2, this.mWc.size());
        int i = 0;
        while (i < min) {
            if (!this.mVW || ((String) this.mWc.get(i)).equals(this.eSe)) {
                ((d) this.mWd.get(i)).mUo.setVisibility(4);
            } else {
                ((d) this.mWd.get(i)).mUo.setVisibility(0);
            }
            ((d) this.mWd.get(i)).mWl.setVisibility(4);
            if (!bi.oW(this.eSe) && ((String) this.mWc.get(i)).equals(this.eSe)) {
                if (this.mVX) {
                    ((ImageView) ((d) this.mWd.get(i)).mWl.findViewById(f.current_account_dot)).setImageResource(com.tencent.mm.plugin.setting.a.e.grey_dot_shape);
                } else {
                    ((ImageView) ((d) this.mWd.get(i)).mWl.findViewById(f.current_account_dot)).setImageResource(com.tencent.mm.plugin.setting.a.e.green_dot_shape);
                }
                if (this.mVX) {
                    ((TextView) ((d) this.mWd.get(i)).mWl.findViewById(f.current_account_tip)).setText(getContext().getResources().getString(i.wx_logout_processing_txt));
                } else {
                    ((TextView) ((d) this.mWd.get(i)).mWl.findViewById(f.current_account_tip)).setText(getContext().getResources().getString(i.settings_switch_account_current_tip));
                }
                ((d) this.mWd.get(i)).mWl.findViewById(f.account_login_progress).setVisibility(8);
                ((d) this.mWd.get(i)).mWl.findViewById(f.current_account_dot).setVisibility(0);
                ((d) this.mWd.get(i)).mWl.setVisibility(0);
            }
            if (!bi.oW(this.mVZ) && ((String) this.mWc.get(i)).equals(this.mVZ)) {
                ((TextView) ((d) this.mWd.get(i)).mWl.findViewById(f.current_account_tip)).setText(getContext().getResources().getString(i.login_logining));
                ((d) this.mWd.get(i)).mWl.findViewById(f.current_account_dot).setVisibility(8);
                ((d) this.mWd.get(i)).mWl.findViewById(f.account_login_progress).setVisibility(0);
                ((d) this.mWd.get(i)).mWl.setVisibility(0);
            }
            LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = mVV;
            addView((View) this.mWe.get(i), layoutParams);
            i++;
        }
        if (getChildCount() < 2) {
            ((d) this.mWd.get(this.mWd.size() - 1)).mUo.setVisibility(4);
            LayoutParams layoutParams2 = new GridLayout.LayoutParams();
            layoutParams2.width = mVV;
            addView((View) this.mWe.get(this.mWe.size() - 1), layoutParams2);
        }
    }

    public void setDeleteState(boolean z) {
        this.mVW = z;
    }

    public void setUseSystemDecoder(boolean z) {
        this.mVY = z;
    }

    public int getAccountCount() {
        return this.mWc.size();
    }

    public void setSwitchToWxUsername(String str) {
        this.mVZ = str;
    }

    public void setLastLoginWxUsername(String str) {
        this.eSe = str;
    }

    public void setLogoutState(boolean z) {
        this.mVX = z;
    }

    public void setOnClickAvatarListener(b bVar) {
        this.mWf = bVar;
    }

    public void setOnAnimatorEndListener(a aVar) {
        this.mWg = aVar;
    }

    public void setOnDeleteAvatarListener(c cVar) {
        this.mWh = cVar;
    }
}
