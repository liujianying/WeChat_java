package com.tencent.mm.t;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import com.tencent.mm.bd.a.c;
import com.tencent.mm.bp.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.PhotoEditText;

public final class e extends c {
    private static TextPaint dG;
    private static final float dof = ad.getResources().getDimension(c.edit_text_size);
    private static final int dog = ((int) ad.getResources().getDimension(c.line_padding_text));
    private static final int doh = ((int) ad.getResources().getDimension(c.padding_text));
    public int doi = -65536;
    public SpannableString doj;
    public int pN = -1;

    static {
        TextPaint textPaint = new TextPaint(1);
        dG = textPaint;
        textPaint.setStrokeCap(Cap.ROUND);
        dG.setStyle(Style.FILL);
        dG.setDither(true);
        dG.setTextSize(dof);
    }

    public e(Context context, Matrix matrix, String str, Rect rect, SpannableString spannableString, int i, int i2) {
        super(context, matrix, str, rect);
        this.pN = i;
        this.doj = spannableString;
        this.doi = i2;
    }

    protected final Bitmap CJ() {
        dG.setColor(this.pN);
        if (this.doj == null) {
            return null;
        }
        PhotoEditText photoEditText = new PhotoEditText(this.mContext);
        int ad = a.ad(this.mContext, c.edit_text_padding);
        photoEditText.setPadding(ad, 0, ad, 0);
        photoEditText.setTextBackground(this.doi);
        photoEditText.setTextColor(this.pN);
        photoEditText.setTextSize((float) Math.round(dof / this.mContext.getResources().getDisplayMetrics().density));
        photoEditText.setText(j.a(this.mContext, this.doj, dof / 1.3f));
        photoEditText.setSingleLine(false);
        photoEditText.setMaxWidth((int) (((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - (this.mContext.getResources().getDimension(c.edit_text_padding) * 2.0f)));
        photoEditText.measure(0, 0);
        Bitmap createBitmap = Bitmap.createBitmap(photoEditText.getMeasuredWidth() - ad, photoEditText.getMeasuredHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        photoEditText.getLayout().getPaint().setColor(this.pN);
        canvas.save();
        canvas.translate(-0.5f * ((float) ad), 0.0f);
        photoEditText.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(((float) ad) * 0.5f, 0.0f);
        photoEditText.getLayout().draw(canvas);
        canvas.restore();
        return createBitmap;
    }

    public final void setSelected(boolean z) {
        super.setSelected(z);
        if (!z) {
            this.dnR = false;
        }
    }
}
