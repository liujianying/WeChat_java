package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class RichTextImageView extends LinearLayout {
    private Activity bOb;
    private TextView eBO;
    private ImageView kYV;
    private TextView nMC;
    private TextView nQW;
    private boolean nQX = false;
    private String nQY;

    public RichTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOb = (Activity) context;
        View inflate = inflate(this.bOb, i$g.sns_rich_text_image_view, this);
        this.nMC = (TextView) inflate.findViewById(i$f.righttext);
        this.eBO = (TextView) inflate.findViewById(i$f.titletext);
        this.nQW = (TextView) inflate.findViewById(i$f.bottomtext);
        this.kYV = (ImageView) inflate.findViewById(i$f.image_left);
    }

    public void setTitle(String str) {
        this.eBO.setText(str);
    }

    public void setText(String str) {
        this.nQX = true;
        if (str == null) {
            str = "";
        }
        this.nQY = str;
        this.nMC.setText(this.nQY);
        requestLayout();
    }

    public void setImage(int i) {
        this.kYV.setImageResource(i);
    }

    public void setImage(Bitmap bitmap) {
        this.kYV.setImageBitmap(bitmap);
    }

    public ImageView getImageView() {
        return this.kYV;
    }

    public TextView getTitle() {
        return this.eBO;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.nQX && this.nQY != null) {
            x.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.nMC.getHeight() + " LineHeight:" + this.nMC.getLineHeight());
            int height = this.nMC.getHeight() / this.nMC.getLineHeight();
            int lineCount = this.nMC.getLineCount();
            Rect rect = new Rect();
            int i5 = 0;
            int i6 = 0;
            while (i5 < height) {
                try {
                    this.nMC.getLineBounds(i5, rect);
                    i6 += rect.height();
                    if (i6 > this.nMC.getHeight()) {
                        break;
                    }
                    i5++;
                } catch (IndexOutOfBoundsException e) {
                }
            }
            if (lineCount >= i5 && this.nQX) {
                if (i5 <= 0) {
                    i5 = 1;
                }
                i5 = this.nMC.getLayout().getLineVisibleEnd(i5 - 1);
                x.e("test", "bottomH:" + this.nQW.getHeight() + "length" + this.nQY.substring(i5, this.nQY.length()).length());
                x.e("test", "bottomH:" + this.nQW.getHeight());
                if (this.nQW.getText().length() > 0) {
                    this.nQW.setVisibility(0);
                    this.nQX = false;
                    new ag().post(new Runnable() {
                        public final void run() {
                            RichTextImageView.this.nMC.setText(RichTextImageView.this.nQY.substring(0, i5));
                            RichTextImageView.this.nQW.setText(RichTextImageView.this.nQY.substring(i5, RichTextImageView.this.nQY.length()));
                            RichTextImageView.this.nQW.invalidate();
                            RichTextImageView.this.nQX = false;
                            x.e("test", "bottomH:" + RichTextImageView.this.nQW.getHeight());
                        }
                    });
                }
                x.e("test", "bottom:" + i4 + "   mesH:" + this.nQW.getMeasuredHeight());
            }
        }
    }
}
