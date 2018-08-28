package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public class MMPwdInputView extends LinearLayout {
    public StringBuilder hPZ;
    public int iUo;
    private boolean mbh;
    private ImageView mbi;
    private ImageView mbj;
    private ImageView mbk;
    private ImageView mbl;
    private a mbm;
    private int mbn;

    public interface a {
        void m(boolean z, String str);
    }

    public enum b {
        ;

        static {
            mbo = 1;
            mbp = 2;
            mbq = new int[]{mbo, mbp};
        }
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMPwdInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.hPZ = new StringBuilder();
        this.mbh = false;
        this.mbn = b.mbp;
        View inflate = inflate(getContext(), R.i.pwd_input_view, null);
        this.mbi = (ImageView) inflate.findViewById(R.h.first);
        this.mbj = (ImageView) inflate.findViewById(R.h.second);
        this.mbk = (ImageView) inflate.findViewById(R.h.third);
        this.mbl = (ImageView) inflate.findViewById(R.h.fourth);
        this.mbi.setImageResource(R.g.around_friends_point);
        this.mbj.setImageResource(R.g.around_friends_point);
        this.mbk.setImageResource(R.g.around_friends_point);
        this.mbl.setImageResource(R.g.around_friends_point);
        addView(inflate);
    }

    public void setOnFinishInputListener(a aVar) {
        this.mbm = aVar;
    }

    public void setNumberStyle$7824e0e2(int i) {
        this.mbn = i;
    }

    public void setNumberWidth(int i) {
        if (this.mbi != null) {
            LayoutParams layoutParams = this.mbi.getLayoutParams();
            layoutParams.width = i;
            this.mbi.setLayoutParams(layoutParams);
            this.mbj.setLayoutParams(layoutParams);
            this.mbk.setLayoutParams(layoutParams);
            this.mbl.setLayoutParams(layoutParams);
        }
    }

    public final void bnY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 4) {
                String str;
                if (this.iUo > i2) {
                    str = this.hPZ.toString().charAt(i2);
                } else {
                    str = "";
                }
                switch (i2) {
                    case 0:
                        m(this.mbi, str);
                        break;
                    case 1:
                        m(this.mbj, str);
                        break;
                    case 2:
                        m(this.mbk, str);
                        break;
                    case 3:
                        m(this.mbl, str);
                        break;
                    default:
                        break;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private static void m(ImageView imageView, String str) {
        if (imageView != null) {
            if (str.equals("0")) {
                imageView.setImageResource(R.g.around_friends_number0);
            } else if (str.equals("1")) {
                imageView.setImageResource(R.g.around_friends_number1);
            } else if (str.equals("2")) {
                imageView.setImageResource(R.g.around_friends_number2);
            } else if (str.equals("3")) {
                imageView.setImageResource(R.g.around_friends_number3);
            } else if (str.equals("4")) {
                imageView.setImageResource(R.g.around_friends_number4);
            } else if (str.equals("5")) {
                imageView.setImageResource(R.g.around_friends_number5);
            } else if (str.equals("6")) {
                imageView.setImageResource(R.g.around_friends_number6);
            } else if (str.equals("7")) {
                imageView.setImageResource(R.g.around_friends_number7);
            } else if (str.equals("8")) {
                imageView.setImageResource(R.g.around_friends_number8);
            } else if (str.equals("9")) {
                imageView.setImageResource(R.g.around_friends_number9);
            } else {
                imageView.setImageResource(R.g.around_friends_point);
            }
        }
    }

    public final void bnZ() {
        if (this.hPZ != null) {
            this.iUo = this.hPZ.length();
        } else {
            this.iUo = 0;
        }
        if (this.iUo >= 4) {
            this.mbh = true;
        } else {
            this.mbh = false;
        }
        if (this.mbm != null) {
            this.mbm.m(this.mbh, this.hPZ.toString());
        }
    }

    public final void aPm() {
        if (this.iUo > 0) {
            this.hPZ.delete(0, this.iUo);
        }
        bnZ();
        bnY();
    }

    public final void input(String str) {
        if (!TextUtils.isEmpty(str) && !this.mbh) {
            this.hPZ.append(str);
            bnZ();
            bnY();
        }
    }
}
