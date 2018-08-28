package com.tencent.mm.ui.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bw.a.a;
import com.tencent.mm.bw.a.d;
import com.tencent.mm.bw.a.e;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.bw.a.h;
import com.tencent.mm.bw.a.j;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class c extends Dialog implements DialogInterface {
    private CheckBox HQ;
    private boolean eWV;
    private View hZ;
    private TextView iDE;
    private Button iQh;
    public EditText im;
    private Context mContext;
    private boolean needEdit = false;
    public Button pxh;
    private LinearLayout tlA;
    private LinearLayout tlw;
    public TextView tlx;
    private TextView tly;
    public LinearLayout tlz;
    private View uJA;
    private boolean uJB = false;
    private Animation uJC;
    private Animation uJD;
    private Animation uJE;
    private Animation uJF;
    private d uJG;
    private TextView uJs;
    private TextView uJt;
    private ImageView uJu;
    private View uJv;
    private LinearLayout uJw;
    private ViewStub uJx;
    private ViewGroup uJy;
    private ViewGroup uJz;

    public c(Context context) {
        super(context, j.mmalertdialog);
        this.mContext = context;
        this.tlw = (LinearLayout) View.inflate(this.mContext, g.mm_alert_comfirm, null);
        this.pxh = (Button) this.tlw.findViewById(f.mm_alert_ok_btn);
        this.iQh = (Button) this.tlw.findViewById(f.mm_alert_cancel_btn);
        this.iDE = (TextView) this.tlw.findViewById(f.mm_alert_title);
        this.tlx = (TextView) this.tlw.findViewById(f.mm_alert_msg);
        this.tly = (TextView) this.tlw.findViewById(f.mm_alert_msg_subtitle);
        this.uJs = (TextView) this.tlw.findViewById(f.mm_alert_msg_subdesc);
        this.uJt = (TextView) this.tlw.findViewById(f.confirm_dialog_content_desc_tv);
        this.im = (EditText) this.tlw.findViewById(f.confirm_dialog_text_et);
        this.HQ = (CheckBox) this.tlw.findViewById(f.confirm_dialog_checkbox);
        this.uJu = (ImageView) this.tlw.findViewById(f.mm_alert_msg_icon);
        this.uJw = (LinearLayout) this.tlw.findViewById(f.mm_alert_title_area);
        this.uJx = (ViewStub) this.tlw.findViewById(f.title_image_ll);
        this.tlz = (LinearLayout) this.tlw.findViewById(f.mm_alert_msg_area);
        this.uJy = (ViewGroup) this.tlw.findViewById(f.mm_alert_bottom_view);
        this.uJA = this.tlw.findViewById(f.mm_alert_button_view);
        this.tlA = (LinearLayout) this.tlw.findViewById(f.mm_alert_custom_area);
        this.uJz = (ViewGroup) this.tlw.findViewById(f.title_image_detail_area);
        setCanceledOnTouchOutside(true);
        this.uJC = AnimationUtils.loadAnimation(this.mContext, a.alpha_in);
        this.uJD = AnimationUtils.loadAnimation(this.mContext, a.alpha_in);
        this.uJE = AnimationUtils.loadAnimation(this.mContext, a.alpha_out);
        this.uJF = AnimationUtils.loadAnimation(this.mContext, a.alpha_out);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.tlw);
    }

    public View getContentView() {
        return this.tlw;
    }

    public void setTitle(CharSequence charSequence) {
        this.uJw.setVisibility(0);
        this.iDE.setVisibility(0);
        if (this.uJG != null) {
            charSequence = this.uJG.c(charSequence.toString(), this.iDE.getTextSize());
        }
        this.iDE.setMaxLines(2);
        this.iDE.setText(charSequence);
        DK(com.tencent.mm.bw.a.c.dialog_msg_color);
    }

    public void setTitle(int i) {
        this.uJw.setVisibility(0);
        this.iDE.setVisibility(0);
        this.iDE.setMaxLines(2);
        this.iDE.setText(i);
        DK(com.tencent.mm.bw.a.c.dialog_msg_color);
    }

    private void DK(int i) {
        if (this.tlx != null) {
            this.tlx.setTextColor(this.tlx.getContext().getResources().getColor(i));
        }
    }

    public final void setMessage(CharSequence charSequence) {
        this.tlz.setVisibility(0);
        this.tlx.setVisibility(0);
        if (this.uJG != null) {
            d dVar = this.uJG;
            this.tlx.getContext();
            charSequence = dVar.c(charSequence.toString(), this.tlx.getTextSize());
        }
        this.tlx.setText(charSequence);
    }

    private void mD(boolean z) {
        if (z) {
            int fromDPToPix = ap.fromDPToPix(this.mContext, 8);
            this.tlz.setVisibility(0);
            this.tlz.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.tlz.setBackgroundResource(e.dialog_content_background);
        }
    }

    public final String cAJ() {
        return this.im == null ? null : this.im.getText().toString();
    }

    private void Gn(int i) {
        if (this.tlz != null) {
            this.tlz.setVisibility(i);
        }
        if (this.tlA != null) {
            this.tlA.setVisibility(i);
        }
        if (this.uJt != null && this.uJB) {
            this.uJt.setVisibility(i);
        }
        if (this.im == null) {
            return;
        }
        if (this.needEdit) {
            this.im.setVisibility(i);
        } else {
            this.im.setVisibility(8);
        }
    }

    private void Q(View view, int i) {
        this.hZ = view;
        if (this.hZ != null) {
            this.tlz.setVisibility(0);
            this.tlA.setVisibility(0);
            this.tlA.removeAllViews();
            this.tlA.setGravity(1);
            this.tlA.addView(this.hZ, new LayoutParams(i, i));
        }
    }

    public final void a(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        if (this.pxh != null) {
            this.pxh.setVisibility(0);
            this.pxh.setText(charSequence);
            this.pxh.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onClick(c.this, -1);
                    }
                    if (z) {
                        c.this.dismiss();
                    }
                }
            });
        }
    }

    public final void Go(int i) {
        this.pxh.setTextColor(i);
    }

    public final void Gp(int i) {
        this.iQh.setTextColor(i);
    }

    public final void a(int i, OnClickListener onClickListener) {
        a(this.mContext.getString(i), true, onClickListener);
    }

    public final void b(CharSequence charSequence, boolean z, OnClickListener onClickListener) {
        if (this.iQh != null) {
            this.iQh.setVisibility(0);
            this.iQh.setText(charSequence);
            this.iQh.setOnClickListener(new 5(this, onClickListener, z));
        }
    }

    public final void b(int i, OnClickListener onClickListener) {
        b(this.mContext.getString(i), true, onClickListener);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.eWV = z;
        setCanceledOnTouchOutside(this.eWV);
    }

    public final void cpX() {
        super.setCancelable(false);
    }

    public final Button getButton(int i) {
        switch (i) {
            case -2:
                return this.iQh;
            case -1:
                return this.pxh;
            default:
                return null;
        }
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        this.uJA.setVisibility(8);
        this.uJy.removeAllViews();
        this.uJy.addView(view, layoutParams);
    }

    public final void a(a aVar) {
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        ImageView imageView;
        TextView textView;
        if (aVar.title != null && aVar.title.length() > 0) {
            setTitle(aVar.title);
        }
        if (aVar.qDI != 0) {
            this.iDE.setTextColor(ColorStateList.valueOf(aVar.qDI));
        }
        if (aVar.uJh != 0) {
            this.iDE.setMaxLines(aVar.uJh);
        }
        if (aVar.uJi != 0) {
            this.tlx.setMaxLines(aVar.uJi);
        }
        if (aVar.pYk != null) {
            Q(aVar.pYk, -1);
        }
        if (aVar.uJf != null) {
            LinearLayout linearLayout;
            View view = aVar.uJf;
            this.uJw.setVisibility(0);
            this.uJx.setLayoutResource(g.confirm_dialog_custom_title);
            try {
                linearLayout = (LinearLayout) this.uJx.inflate();
            } catch (Exception e) {
                this.uJx.setVisibility(0);
                linearLayout = null;
            }
            linearLayout.addView(view);
        }
        if (aVar.uJg != null) {
            this.uJv = aVar.uJg;
            if (this.uJv != null) {
                this.tlz.setVisibility(8);
                this.uJt.setVisibility(8);
                this.im.setVisibility(8);
                this.uJz.removeAllViews();
                this.uJz.addView(this.uJv, new LayoutParams(-1, -1));
                this.uJz.setVisibility(8);
            }
        }
        if (aVar.uIM != null) {
            Drawable drawable = aVar.uIM;
            if (this.hZ == null) {
                this.tlz.setVisibility(0);
                this.uJu.setVisibility(0);
                this.uJu.setBackgroundDrawable(drawable);
            }
        }
        if (aVar.uIP != null && aVar.uIP.length() > 0) {
            setMessage(aVar.uIP);
        }
        mD(aVar.uIY);
        if (aVar.bOX != null) {
            String str = aVar.bOX;
            int fromDPToPix = ap.fromDPToPix(this.mContext, TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            this.tlz.setVisibility(0);
            this.uJu.setVisibility(0);
            if (this.uJu instanceof com.tencent.mm.ui.e.a) {
                ((com.tencent.mm.ui.e.a) this.uJu).ag(str, fromDPToPix, fromDPToPix);
            }
            i = aVar.uJl;
            this.tlz.setVisibility(i);
            this.uJu.setVisibility(i);
        }
        if (!(aVar.uJp || aVar.uJq)) {
            if (aVar.uIP != null && aVar.uIP.length() > 0) {
                setMessage(aVar.uIP);
            }
            if (aVar.uIQ == null || aVar.uIQ.length() <= 0) {
                mD(false);
            } else {
                charSequence = aVar.uIQ;
                this.tlz.setVisibility(0);
                this.tly.setVisibility(0);
                this.tly.setMaxLines(2);
                this.tly.setText(charSequence);
            }
            if (aVar.uIR != null && aVar.uIR.length() > 0) {
                charSequence = aVar.uIR;
                if (charSequence != null) {
                    this.tlz.setVisibility(0);
                    this.uJs.setVisibility(0);
                    if (this.uJG != null) {
                        d dVar = this.uJG;
                        this.uJs.getContext();
                        charSequence = dVar.c(charSequence.toString(), this.uJs.getTextSize());
                    }
                    this.uJs.setText(charSequence);
                }
            }
            if (aVar.uIN != null) {
                Bitmap bitmap = aVar.uIN;
                if (this.hZ == null) {
                    this.tlz.setVisibility(0);
                    this.uJu.setVisibility(0);
                    this.uJu.setImageBitmap(bitmap);
                }
            }
        }
        Bitmap bitmap2;
        CharSequence charSequence3;
        View inflate;
        if (aVar.uJp) {
            bitmap2 = aVar.uIN;
            charSequence2 = aVar.uIQ;
            charSequence3 = aVar.uIR;
            inflate = View.inflate(this.mContext, g.confirm_dialog_icon_left, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(f.mm_alert_msg_icon);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(f.mm_alert_msg_subtitle);
                textView.setVisibility(0);
                if (this.uJG != null) {
                    charSequence2 = this.uJG.c(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(f.mm_alert_msg_subdesc);
                textView.setVisibility(0);
                if (this.uJG != null) {
                    charSequence2 = this.uJG.c(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            Q(inflate, -1);
        } else if (aVar.uJq) {
            bitmap2 = aVar.uIN;
            charSequence2 = aVar.uIQ;
            charSequence3 = aVar.uIR;
            inflate = View.inflate(this.mContext, g.confirm_dialog_icon_right, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(f.mm_alert_msg_icon);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(f.mm_alert_msg_subtitle);
                textView.setVisibility(0);
                if (this.uJG != null) {
                    charSequence2 = this.uJG.c(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(f.mm_alert_msg_subdesc);
                textView.setVisibility(0);
                if (this.uJG != null) {
                    charSequence2 = this.uJG.c(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            Q(inflate, -1);
        }
        if (!(aVar.uIE == null && aVar.uIF == null)) {
            String str2 = aVar.uIE;
            charSequence2 = aVar.uIF;
            Boolean valueOf = Boolean.valueOf(aVar.uIG);
            c cVar = aVar.uII;
            a aVar2 = aVar.uIJ;
            this.uJx.setLayoutResource(g.confirm_dialog_title_image);
            LinearLayout linearLayout2 = null;
            try {
                linearLayout2 = (LinearLayout) this.uJx.inflate();
            } catch (Exception e2) {
                this.uJx.setVisibility(0);
            }
            if (!(linearLayout2 == null || str2 == null)) {
                imageView = (ImageView) linearLayout2.findViewById(f.title_image);
                imageView.setVisibility(0);
                if (aVar2 != null) {
                    aVar2.q(imageView, str2);
                }
            }
            if (!(linearLayout2 == null || charSequence2 == null)) {
                textView = (TextView) linearLayout2.findViewById(f.title_text);
                textView.setVisibility(0);
                if (this.uJG != null) {
                    charSequence2 = this.uJG.c(charSequence2.toString(), this.iDE.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (valueOf.booleanValue() && linearLayout2 != null) {
                imageView = (ImageView) linearLayout2.findViewById(f.image_title_detail_icon);
                imageView.setVisibility(0);
                Gn(0);
                linearLayout2.setOnClickListener(new 1(this, cVar, imageView));
            }
        }
        if (aVar.uIK != null) {
            b bVar = aVar.uIK;
            if (this.tlz != null && this.tlz.getVisibility() == 0) {
                this.tlz.setOnClickListener(new 2(this, bVar));
            } else if (this.tlA != null) {
                this.tlA.setOnClickListener(new 3(this, bVar));
            }
        }
        if (!(aVar.uIO == null || aVar.uIO.isRecycled())) {
            Bitmap bitmap3 = aVar.uIO;
            boolean z = aVar.uIZ;
            int i2 = aVar.uJk;
            if (bitmap3 != null) {
                Bitmap bitmap4;
                mD(false);
                this.tlz.setVisibility(0);
                this.tlz.setGravity(1);
                this.tlz.setPadding(0, 0, 0, 0);
                View inflate2 = View.inflate(this.mContext, g.confirm_dialog_image_center, null);
                imageView = (ImageView) inflate2.findViewById(f.mm_alert_msg_icon);
                if (z) {
                    bitmap4 = null;
                    float height = ((float) bitmap3.getHeight()) / ((float) bitmap3.getWidth());
                    int i3 = 0;
                    int i4 = 0;
                    int ae = ap.ae(this.mContext, d.DialogBigImageMinHeight);
                    int ae2 = ap.ae(this.mContext, d.DialogBigImageMaxHeight);
                    int i5 = 0;
                    int i6 = 0;
                    if (height > 0.0f && ((double) height) < 0.5d) {
                        i4 = (int) (((float) ae) / height);
                        i6 = ae;
                        i3 = ae;
                        i5 = ae2;
                    } else if (((double) height) >= 0.5d && height < 1.0f) {
                        ae = (int) (((float) ae2) * height);
                        i6 = ae;
                        i4 = ae2;
                        i3 = ae;
                        i5 = ae2;
                    } else if (height >= 1.0f && height < 2.0f) {
                        ae = (int) (((float) ae2) / height);
                        i6 = ae2;
                        i4 = ae;
                        i3 = ae2;
                        i5 = ae;
                    } else if (height >= 2.0f) {
                        i3 = (int) (((float) ae) * height);
                        i6 = ae2;
                        i4 = ae;
                        i5 = ae;
                    }
                    if (i3 > 0 && i4 > 0 && bitmap3 != null) {
                        bitmap4 = Bitmap.createScaledBitmap(bitmap3, i4, i3, true);
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(i5, i6));
                    }
                    float fromDPToPix2 = (float) ap.fromDPToPix(this.mContext, 3);
                    if (bitmap4 == null || bitmap4.isRecycled()) {
                        ao.v("getRoundedCornerBitmap in bitmap is null", new Object[0]);
                        bitmap4 = null;
                    } else {
                        bitmap3 = am.b(bitmap4.getWidth(), bitmap4.getHeight(), Config.ARGB_8888);
                        if (bitmap3 == null) {
                            bitmap4 = null;
                        } else {
                            Canvas canvas = new Canvas(bitmap3);
                            Paint paint = new Paint();
                            Rect rect = new Rect(0, 0, bitmap4.getWidth(), bitmap4.getHeight());
                            RectF rectF = new RectF(rect);
                            paint.setAntiAlias(true);
                            paint.setDither(true);
                            paint.setFilterBitmap(true);
                            canvas.drawARGB(0, 0, 0, 0);
                            paint.setColor(-4144960);
                            canvas.drawRoundRect(rectF, fromDPToPix2, fromDPToPix2, paint);
                            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                            canvas.drawBitmap(bitmap4, rect, rect, paint);
                            ao.t("getRoundedCornerBitmap bitmap recycle %s", new Object[]{bitmap4});
                            bitmap4.recycle();
                            bitmap4 = bitmap3;
                        }
                    }
                } else {
                    bitmap4 = bitmap3;
                }
                imageView.setImageBitmap(bitmap4);
                imageView = (ImageView) inflate2.findViewById(f.image_status_icon);
                if (i2 == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    if (i2 == 1) {
                        imageView.setImageResource(h.sight_icon_in_gird);
                    } else if (i2 == 2) {
                        imageView.setImageResource(h.video_icon_in_gird);
                    }
                }
                Q(inflate2, -2);
            }
        }
        if (aVar.uIA != null && aVar.uIA.length() > 0) {
            charSequence = aVar.uIA;
            if (charSequence != null) {
                this.uJt.setVisibility(0);
                this.uJt.setText(charSequence);
            }
            this.uJB = true;
            i = aVar.uJj;
            if (this.uJt != null) {
                this.uJt.setGravity(i);
            }
        }
        if (aVar.uIB != null && aVar.uIB.length() > 0) {
            charSequence = aVar.uIB;
            this.im.setVisibility(0);
            this.im.setHint(charSequence);
        }
        if (aVar.uIC != null && aVar.uIC.length() > 0) {
            charSequence = aVar.uIC;
            this.HQ.setVisibility(0);
            this.HQ.setText(charSequence);
        }
        if (aVar.uID) {
            this.needEdit = aVar.uID;
            if (aVar.uID) {
                this.im.setVisibility(0);
            } else {
                this.im.setVisibility(8);
            }
        }
        if (aVar.uIS != null && aVar.uIS.length() > 0) {
            a(aVar.uIS, aVar.uJo, aVar.uJa);
        }
        if (aVar.uIT != null && aVar.uIT.length() > 0) {
            b(aVar.uIT, true, aVar.uJb);
        }
        if (aVar.uJn != 0) {
            Go(aVar.uJn);
        }
        if (aVar.uJm != 0) {
            Gp(aVar.uJm);
        }
        if (aVar.DI != null) {
            setOnCancelListener(aVar.DI);
        }
        if (aVar.DJ != null) {
            setOnDismissListener(aVar.DJ);
        }
        if (aVar.uIL != null) {
            this.uJG = aVar.uIL;
        }
        setCancelable(aVar.eWV);
        this.eWV = aVar.eWV;
        if (!this.eWV) {
            super.setCancelable(aVar.uIX);
        }
        if (!(aVar.uIU == null && aVar.uIV == null && aVar.uIW == null)) {
            View inflate3 = View.inflate(this.mContext, g.confirm_dialog_multi_btn, null);
            Button button = (Button) inflate3.findViewById(f.mm_alert_btn_first);
            Button button2 = (Button) inflate3.findViewById(f.mm_alert_btn_second);
            Button button3 = (Button) inflate3.findViewById(f.mm_alert_btn_third);
            if (aVar.uIU != null) {
                button.setVisibility(0);
                button.setText(aVar.uIU);
                button.setOnClickListener(new 6(this, aVar));
            }
            if (aVar.uIV != null) {
                button2.setVisibility(0);
                button2.setText(aVar.uIV);
                button2.setOnClickListener(new 7(this, aVar));
            }
            if (aVar.uIW != null) {
                button3.setVisibility(0);
                button3.setText(aVar.uIW);
                button3.setOnClickListener(new 8(this, aVar));
            }
            a(inflate3, new LayoutParams(-1, -1));
        }
        if (aVar.uIH) {
            View inflate4 = View.inflate(this.mContext, g.confirm_dialog_btn_up_down, null);
            this.iQh = (Button) inflate4.findViewById(f.mm_alert_cancel_btn);
            this.pxh = (Button) inflate4.findViewById(f.mm_alert_ok_btn);
            if (aVar.uJn != 0) {
                Go(aVar.uJn);
            }
            if (aVar.uJm != 0) {
                Gp(aVar.uJm);
            }
            if (aVar.uIS != null && aVar.uIS.length() > 0) {
                a(aVar.uIS, aVar.uJo, aVar.uJa);
            }
            if (aVar.uIT != null && aVar.uIT.length() > 0) {
                b(aVar.uIT, true, aVar.uJb);
            }
            a(inflate4, new LayoutParams(-1, -1));
        }
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            ao.a(e, "", new Object[0]);
        }
    }

    public void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new 9(this));
            ao.v("dialog dismiss error!", new Object[0]);
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            ao.v("dismiss exception, e = " + e.getMessage(), new Object[0]);
        }
    }
}
