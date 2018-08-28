package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ac.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

public class PickedBottleImageView extends ImageView {
    private float density;
    private Paint fBa = new Paint();
    private ag handler = new ag();
    private int hjQ;
    String hkb;
    private String hlY;
    private Rect hmr = new Rect();
    private RectF hms = new RectF();
    private View hmt;
    private Runnable hmu = new Runnable() {
        public final void run() {
            FrameLayout frameLayout = (FrameLayout) PickedBottleImageView.this.getParent();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) PickedBottleImageView.this.hmt.getLayoutParams();
            if (frameLayout != null) {
                marginLayoutParams.setMargins(frameLayout.getWidth() / 2, (frameLayout.getHeight() * 530) / 800, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            PickedBottleImageView.this.hmt.setLayoutParams(marginLayoutParams);
            PickedBottleImageView.this.hmt.setVisibility(0);
            PickedBottleImageView.this.clearAnimation();
        }
    };
    Bitmap iconBitmap;
    String iconUrl;

    public PickedBottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PickedBottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBottleTalker(String str) {
        this.hlY = str;
    }

    public String getBottleTalker() {
        return this.hlY;
    }

    public void setRealUserName(String str) {
        this.hkb = str;
    }

    public String getRealUserName() {
        return this.hkb;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setDensity(float f) {
        this.density = f;
    }

    public final void show(int i) {
        this.hjQ = i;
        if (i == 1) {
            setImageResource(R.g.bottle_picked_text_msg);
            setContentDescription(getContext().getString(R.l.bottle_picked_result));
            this.iconBitmap = null;
        } else if (i == 3) {
            setImageResource(R.g.bottle_picked_voice_msg);
            setContentDescription(getContext().getString(R.l.bottle_picked_result));
            this.iconBitmap = null;
        } else if (i == 19990) {
            setImageResource(R.g.bottle_brand_bg);
            this.iconBitmap = m.d(this.hkb, this.iconUrl, R.g.nosdcard_headimg);
            setContentDescription(getContext().getString(R.l.bottle_picked_result));
            this.fBa.setAntiAlias(true);
            update();
        } else {
            setImageResource(R.g.bottle_picked_nothing);
            this.iconBitmap = null;
            setContentDescription(getContext().getString(R.l.bottle_picked_result_null));
        }
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (this.hmt == null) {
            this.hmt = ((View) getParent()).findViewById(R.h.bottle_pick_open_hint_rl);
        }
        this.hmt.setVisibility(8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (frameLayout.getHeight() * TXLiveConstants.RENDER_ROTATION_LANDSCAPE) / 800);
        setLayoutParams(marginLayoutParams);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bottle_rotate));
        this.handler.postDelayed(this.hmu, 3000);
        setVisibility(0);
    }

    public void setVisibility(int i) {
        if (i == 8) {
            super.clearAnimation();
        }
        if (i == 8 && this.hmt != null) {
            this.handler.removeCallbacks(this.hmu);
            this.hmt.setVisibility(i);
        }
        super.setVisibility(i);
    }

    final void update() {
        boolean z = true;
        if (this.iconBitmap == null || this.iconBitmap.isRecycled()) {
            this.iconBitmap = BitmapFactory.decodeResource(getResources(), R.g.brand_default_head);
        }
        Bitmap bitmap = this.iconBitmap;
        Matrix matrix = new Matrix();
        matrix.setRotate(-60.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, matrix, paint);
        String str = "MicroMsg.PickedBottleImageView";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        x.d(str, stringBuilder.append(z).append("  degree:-60.0").toString());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        this.iconBitmap = createBitmap;
        Rect rect = this.hmr;
        this.hmr.top = 0;
        rect.left = 0;
        this.hmr.right = this.iconBitmap.getWidth();
        this.hmr.bottom = this.iconBitmap.getHeight();
        this.hms.left = 40.0f * this.density;
        this.hms.top = 30.0f * this.density;
        this.hms.right = 72.0f * this.density;
        this.hms.bottom = 62.0f * this.density;
    }

    protected void onDraw(Canvas canvas) {
        if (!(19990 != this.hjQ || this.iconBitmap == null || this.iconBitmap.isRecycled())) {
            canvas.drawBitmap(this.iconBitmap, this.hmr, this.hms, this.fBa);
        }
        super.onDraw(canvas);
    }
}
