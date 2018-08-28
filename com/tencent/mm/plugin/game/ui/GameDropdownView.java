package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class GameDropdownView extends TextView implements OnClickListener, OnDismissListener {
    private b jXL;
    private LinkedList<String> jXM;
    private int jXN = 0;
    private int jXO = 0;
    private a jXP = null;
    private View jXQ = null;
    private OnClickListener jXR = new 1(this);
    private Context mContext;

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.jXL = new b(context);
        setOnClickListener(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setVisibility(8);
    }

    public void onClick(View view) {
        if (this.jXL.isShowing()) {
            this.jXL.dismiss();
        } else if (this.jXQ == null) {
            this.jXL.showAsDropDown(this);
        } else {
            this.jXL.showAsDropDown(this.jXQ);
        }
    }

    public void onDismiss() {
    }

    public void setAnchorView(View view) {
        this.jXQ = view;
    }

    public final void d(LinkedList<String> linkedList, int i) {
        if (linkedList.size() == 0) {
            x.i("MicroMsg.GameDropdownView", "No menu item");
            return;
        }
        this.jXM = linkedList;
        this.jXO = linkedList.size() - 1;
        if (i < 0 || i > this.jXO) {
            this.jXN = 0;
        } else {
            this.jXN = i;
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(f.game_library_dropdown_container, null);
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str = (String) linkedList.get(i2);
            TextView textView = (TextView) layoutInflater.inflate(f.game_library_dropdown_item, linearLayout, false);
            textView.setText(str);
            textView.setOnClickListener(this.jXR);
            if (i2 == this.jXN) {
                textView.setTextColor(this.mContext.getResources().getColor(b.normal_text_color));
                setText(str);
            }
            linearLayout.addView(textView);
        }
        this.jXL.setContentView(linearLayout);
        setVisibility(0);
    }

    private void setCurrentSelection(int i) {
        if (this.jXL.getContentView() != null && (this.jXL.getContentView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.jXL.getContentView();
            if (i <= this.jXO && this.jXN <= this.jXO && (viewGroup.getChildAt(i) instanceof TextView) && (viewGroup.getChildAt(this.jXN) instanceof TextView)) {
                ((TextView) viewGroup.getChildAt(this.jXN)).setTextColor(this.mContext.getResources().getColor(b.hint_text_color));
                ((TextView) viewGroup.getChildAt(i)).setTextColor(this.mContext.getResources().getColor(b.normal_text_color));
                setText((CharSequence) this.jXM.get(i));
                if (!(this.jXP == null || this.jXN == i)) {
                    this.jXP.qW(i);
                }
                this.jXN = i;
            }
        }
    }

    public void setOnSelectionChangedListener(a aVar) {
        this.jXP = aVar;
    }
}
