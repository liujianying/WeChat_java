package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.f$c;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.s$h;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public class GameMessageListUserIconView extends LinearLayout {
    private t kaw;
    private f<String, Bitmap> kax;
    private Context mContext;

    public GameMessageListUserIconView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        if (this.kaw == null) {
            this.kaw = new t(this.mContext);
        }
    }

    public void setSourceScene(int i) {
        if (this.kaw != null) {
            this.kaw.jNv = i;
        } else {
            this.kaw = new t(this.mContext, i);
        }
    }

    public final void a(s sVar, LinkedList<s$h> linkedList, f<String, Bitmap> fVar) {
        if (sVar == null || bi.cX(linkedList)) {
            setVisibility(8);
            return;
        }
        this.kax = fVar;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f$c.GameUserIconSize);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(f$c.BasicPaddingSize);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = dimensionPixelSize2;
        while (getChildCount() < linkedList.size()) {
            View imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setOnClickListener(this.kaw);
            addView(imageView);
        }
        for (int i = 0; i < getChildCount(); i++) {
            ImageView imageView2 = (ImageView) getChildAt(i);
            if (i < linkedList.size()) {
                imageView2.setVisibility(0);
                s$h s_h = (s$h) linkedList.get(i);
                String str;
                Bitmap bitmap;
                if (bi.oW(s_h.jNp)) {
                    str = s_h.userName;
                    if (bi.oW(str)) {
                        b.a(imageView2, str);
                    } else if (this.kax.bb(str)) {
                        bitmap = (Bitmap) this.kax.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            d(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        d(imageView2, str);
                    }
                } else {
                    str = s_h.jNp;
                    if (this.kax.bb(str)) {
                        bitmap = (Bitmap) this.kax.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            f(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        f(imageView2, str);
                    }
                }
                if (bi.oW(s_h.jNs)) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setTag(new a(sVar, s_h.jNs, 6));
                    imageView2.setEnabled(true);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
    }

    private void f(ImageView imageView, String str) {
        e.a.a aVar = new e.a.a();
        aVar.dXw = false;
        e.aVj().a(imageView, str, aVar.aVk(), new 1(this, str));
    }

    private void d(ImageView imageView, String str) {
        Bitmap h = e.aVj().h(imageView, str);
        if (h != null) {
            this.kax.put(str, h);
        }
    }
}
