package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;

public class SetTextSizeUI extends MMPreference {
    private f eOE;
    private float mQG;
    private int mQH = 1;

    public final int Ys() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.mQG = ec(this);
        this.eOE = this.tCL;
        setMMTitle(i.settings_text_size);
        setBackBtn(new 1(this));
        a(0, getString(i.settings_language_save), new 2(this), b.tmX);
        refresh();
    }

    public static float ec(Context context) {
        float fe = a.fe(context);
        if (fe == 1.0f || fe == 0.875f || fe == 1.125f || fe == 1.25f || fe == 1.375f || fe == 1.625f || fe == 1.875f || fe == 2.025f) {
            return fe;
        }
        return 1.0f;
    }

    public static int ed(Context context) {
        float ec = ec(context);
        if (ec == 0.875f) {
            return i.setting_text_size_small;
        }
        if (ec == 1.125f) {
            return i.setting_text_size_large;
        }
        if (ec == 1.25f) {
            return i.setting_text_size_super;
        }
        if (ec == 1.375f) {
            return i.setting_text_size_huge;
        }
        return i.setting_text_size_normal;
    }

    public static float ao(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        if (f == 1.375f) {
            return 22.0f;
        }
        if (f == 1.625f) {
            return 26.0f;
        }
        if (f == 1.875f) {
            return 28.0f;
        }
        if (f == 2.025f) {
            return 30.0f;
        }
        return 16.0f;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        this.mQH = 1;
        if (str.equals("setting_text_size_small")) {
            this.mQG = 0.875f;
            this.mQH = 0;
        } else if (str.equals("setting_text_size_normal")) {
            this.mQG = 1.0f;
            this.mQH = 1;
        } else if (str.equals("setting_text_size_large")) {
            this.mQG = 1.125f;
            this.mQH = 2;
        } else if (str.equals("setting_text_size_super")) {
            this.mQG = 1.25f;
            this.mQH = 3;
        } else if (str.equals("setting_text_size_huge")) {
            this.mQG = 1.375f;
            this.mQH = 4;
        } else if (str.equals("setting_text_size_huger")) {
            this.mQG = 1.625f;
            this.mQH = 5;
        } else if (str.equals("setting_text_size_hugers")) {
            this.mQG = 1.625f;
            this.mQH = 6;
        } else if (str.equals("setting_text_size_hugerss")) {
            this.mQG = 1.625f;
            this.mQH = 7;
        }
        refresh();
        return false;
    }

    private void refresh() {
        this.eOE.removeAll();
        a aVar = new a(this, this, 0.875f);
        aVar.setKey("setting_text_size_small");
        aVar.setLayoutResource(g.mm_preference);
        if (this.mQG == 0.875f) {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(aVar);
        aVar = new a(this, this, 1.0f);
        aVar.setKey("setting_text_size_normal");
        aVar.setLayoutResource(g.mm_preference);
        if (this.mQG == 1.0f) {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(aVar);
        aVar = new a(this, this, 1.125f);
        aVar.setKey("setting_text_size_large");
        aVar.setLayoutResource(g.mm_preference);
        if (this.mQG == 1.125f) {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(aVar);
        aVar = new a(this, this, 1.25f);
        aVar.setKey("setting_text_size_super");
        aVar.setLayoutResource(g.mm_preference);
        if (this.mQG == 1.25f) {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(aVar);
        aVar = new a(this, this, 1.375f);
        aVar.setKey("setting_text_size_huge");
        aVar.setLayoutResource(g.mm_preference);
        if (this.mQG == 1.375f) {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_checked);
        } else {
            aVar.setWidgetLayoutResource(g.mm_preference_radio_unchecked);
        }
        this.eOE.a(aVar);
        this.eOE.a(new PreferenceCategory(this));
        this.eOE.notifyDataSetChanged();
        ViewGroup viewGroup = (ViewGroup) this.mController.tlX;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                x.d("ui.settings.SetTextSize", "id=" + childAt.getId());
            }
        }
    }
}
