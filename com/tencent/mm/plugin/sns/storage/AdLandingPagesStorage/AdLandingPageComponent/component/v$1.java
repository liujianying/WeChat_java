package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.TypedValue;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class v$1 implements d$a {
    final /* synthetic */ v nFx;

    v$1(v vVar) {
        this.nFx = vVar;
    }

    public final void bzS() {
    }

    public final void bxo() {
    }

    public final void MX(String str) {
        try {
            this.nFx.nFw.setImageBitmap(BitmapFactory.decodeFile(str));
            TextView textView = this.nFx.ePz;
            Paint paint = new Paint();
            String charSequence = textView.getText().toString();
            paint.setTextSize(textView.getTextSize());
            float measureText = (this.nFx.nDt.nBc - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, this.nFx.context.getResources().getDisplayMetrics());
            int i = (int) (measureText - (v.a(this.nFx).value * measureText));
            LayoutParams layoutParams = (LayoutParams) this.nFx.nFw.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i, layoutParams.leftMargin);
            this.nFx.nFw.setLayoutParams(layoutParams);
        } catch (Throwable e) {
            x.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bi.i(e));
        }
    }
}
