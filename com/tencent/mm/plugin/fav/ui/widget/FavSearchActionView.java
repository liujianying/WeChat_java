package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.fav.ui.m.b;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView extends LinearLayout {
    public FavTagPanel jat;
    public List<Integer> jbK = new LinkedList();
    public a jfA;
    private ImageButton jfw;
    private ImageView jfx;
    public List<String> jfy = new LinkedList();
    public List<String> jfz = new LinkedList();

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jfw = (ImageButton) findViewById(e.search_clear_button);
        this.jat = (FavTagPanel) findViewById(e.fav_tag_input_panel);
        this.jfx = (ImageView) findViewById(e.ab_back_btn);
        if (this.jat != null) {
            this.jat.setEditTextColor(getResources().getColor(b.black_text_color));
            this.jat.setTagTipsDrawable(0);
            this.jat.setTagHighlineBG(0);
            this.jat.setTagSelectedBG(0);
            this.jat.setTagSelectedTextColorRes(b.green_text_color);
            this.jat.setTagNormalBG(0);
            this.jat.setTagNormalTextColorRes(b.white);
            this.jat.setEditHint(getResources().getString(i.app_search));
            this.jat.lL(true);
            this.jat.txD = false;
            this.jat.txE = true;
            this.jat.setCallBack(new 1(this));
        }
        if (this.jfw != null) {
            this.jfw.setOnClickListener(new 2(this));
        }
    }

    /* renamed from: BG */
    public final void a(String str) {
        this.jfz.clear();
        for (String str2 : bi.aG(str, "").split(" ")) {
            if (!bi.oW(str2)) {
                this.jfz.add(str2);
            }
        }
    }

    public void setOnSearchChangedListener(a aVar) {
        this.jfA = aVar;
    }

    public List<String> getSearchKeys() {
        if (this.jat != null) {
            a(this.jat.getEditText());
        }
        return this.jfz;
    }

    public List<String> getSearchTags() {
        return this.jfy;
    }

    private void aMT() {
        if (this.jbK.isEmpty() && this.jfy.isEmpty()) {
            this.jat.setEditHint(getResources().getString(i.app_search));
        } else {
            this.jat.setEditHint("");
        }
    }

    public void setType(int i) {
        this.jbK.clear();
        this.jbK.add(Integer.valueOf(i));
        if (this.jat != null) {
            String string;
            aMT();
            FavTagPanel favTagPanel = this.jat;
            Context context = getContext();
            if (context != null) {
                switch (i) {
                    case 1:
                        string = context.getString(i.favorite_sub_title_chat);
                        break;
                    case 2:
                        string = context.getString(i.favorite_sub_title_image);
                        break;
                    case 3:
                        string = context.getString(i.favorite_sub_title_voice);
                        break;
                    case 4:
                        string = context.getString(i.favorite_sub_title_video);
                        break;
                    case 5:
                        string = context.getString(i.favorite_sub_title_url);
                        break;
                    case 6:
                        string = context.getString(i.favorite_sub_title_location);
                        break;
                    case 7:
                        string = context.getString(i.favorite_sub_title_music);
                        break;
                    case 8:
                        string = context.getString(i.favorite_sub_title_file);
                        break;
                }
            }
            string = "";
            favTagPanel.setType(string);
            if (this.jfA != null) {
                a(this.jat.getEditText());
                this.jfA.a(this.jbK, this.jfz, this.jfy, false);
                h.mEJ.h(11126, new Object[]{Integer.valueOf(1)});
            }
        }
    }

    public static Integer af(Context context, String str) {
        if (context == null) {
            return Integer.valueOf(-1);
        }
        if (context.getString(i.favorite_sub_title_image).equals(str)) {
            return Integer.valueOf(2);
        }
        if (context.getString(i.favorite_sub_title_music).equals(str)) {
            return Integer.valueOf(7);
        }
        if (context.getString(i.favorite_sub_title_location).equals(str)) {
            return Integer.valueOf(6);
        }
        if (context.getString(i.favorite_sub_title_chat).equals(str)) {
            return Integer.valueOf(1);
        }
        if (context.getString(i.favorite_sub_title_video).equals(str)) {
            return Integer.valueOf(4);
        }
        if (context.getString(i.favorite_sub_title_url).equals(str)) {
            return Integer.valueOf(5);
        }
        if (context.getString(i.favorite_sub_title_voice).equals(str)) {
            return Integer.valueOf(3);
        }
        if (context.getString(i.favorite_sub_title_file).equals(str)) {
            return Integer.valueOf(8);
        }
        return Integer.valueOf(-1);
    }
}
