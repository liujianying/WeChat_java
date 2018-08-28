package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.x;

public class EditVerifyCodeView extends RelativeLayout {
    private ImageView[] gQf;
    private TextView[] gQg;
    OnKeyListener gQh;
    public a gQi;
    private EditText im;
    private StringBuilder mBuilder;
    private Context mContext;

    static /* synthetic */ void b(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        x.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length > 0 && length <= 6) {
            editVerifyCodeView.gQg[length - 1].setVisibility(0);
            editVerifyCodeView.gQg[length - 1].setText(String.valueOf(stringBuilder.charAt(length - 1)));
            editVerifyCodeView.gQf[length - 1].setVisibility(4);
        }
    }

    static /* synthetic */ void c(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        x.i("MicroMsg.EditVerifyCodeView", "del before str:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length != 0) {
            if (length > 0 && length <= 6) {
                editVerifyCodeView.mBuilder.delete(length - 1, length);
            }
            editVerifyCodeView.gQg[length - 1].setVisibility(4);
            editVerifyCodeView.gQg[length - 1].setText("");
            editVerifyCodeView.gQf[length - 1].setVisibility(0);
            x.i("MicroMsg.EditVerifyCodeView", "del after str:" + editVerifyCodeView.mBuilder);
        }
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBuilder = new StringBuilder();
        this.gQf = new ImageView[6];
        this.gQg = new TextView[6];
        this.gQh = new 3(this);
        init(context);
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBuilder = new StringBuilder();
        this.gQf = new ImageView[6];
        this.gQg = new TextView[6];
        this.gQh = new 3(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(h.edit_verify_code_layout, null);
        TextView textView = (TextView) inflate.findViewById(g.code_text_2);
        TextView textView2 = (TextView) inflate.findViewById(g.code_text_3);
        TextView textView3 = (TextView) inflate.findViewById(g.code_text_4);
        TextView textView4 = (TextView) inflate.findViewById(g.code_text_5);
        TextView textView5 = (TextView) inflate.findViewById(g.code_text_6);
        this.gQg[0] = (TextView) inflate.findViewById(g.code_text_1);
        this.gQg[1] = textView;
        this.gQg[2] = textView2;
        this.gQg[3] = textView3;
        this.gQg[4] = textView4;
        this.gQg[5] = textView5;
        ImageView imageView = (ImageView) inflate.findViewById(g.code_img_2);
        ImageView imageView2 = (ImageView) inflate.findViewById(g.code_img_3);
        ImageView imageView3 = (ImageView) inflate.findViewById(g.code_img_4);
        ImageView imageView4 = (ImageView) inflate.findViewById(g.code_img_5);
        ImageView imageView5 = (ImageView) inflate.findViewById(g.code_img_6);
        this.gQf[0] = (ImageView) inflate.findViewById(g.code_img_1);
        this.gQf[1] = imageView;
        this.gQf[2] = imageView2;
        this.gQf[3] = imageView3;
        this.gQf[4] = imageView4;
        this.gQf[5] = imageView5;
        this.im = (EditText) inflate.findViewById(g.verify_code_edittext);
        this.im.addTextChangedListener(new 1(this));
        this.im.setKeyListener(new 2(this));
        this.im.setOnKeyListener(this.gQh);
        addView(inflate, new LayoutParams(-1, -1));
    }

    public String getText() {
        return this.mBuilder.toString();
    }

    public void setText(String str) {
        this.mBuilder.delete(0, this.mBuilder.length());
        this.mBuilder.append(str);
        String stringBuilder = this.mBuilder.toString();
        int length = stringBuilder.length();
        x.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
        int i;
        if (length > 0) {
            for (i = 0; i < length; i++) {
                this.gQg[i].setVisibility(0);
                this.gQg[i].setText(String.valueOf(stringBuilder.charAt(i)));
                this.gQf[i].setVisibility(4);
            }
            return;
        }
        for (i = 0; i < 6; i++) {
            this.gQg[i].setVisibility(4);
            this.gQg[i].setText("");
            this.gQf[i].setVisibility(0);
        }
    }

    public void setCodeEditCompleListener(a aVar) {
        this.gQi = aVar;
    }
}
