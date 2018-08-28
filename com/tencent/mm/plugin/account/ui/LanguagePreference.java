package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class LanguagePreference extends Preference {
    public a eQG;

    public static class a {
        String eQH;
        private String eQI;
        public String eQJ;
        public boolean eQK;

        public a(String str, String str2, String str3, boolean z) {
            this.eQH = str;
            this.eQI = str2;
            this.eQJ = str3;
            this.eQK = z;
        }
    }

    public LanguagePreference(Context context) {
        this(context, null);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LanguagePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(a$g.mm_preference);
    }

    public final void a(a aVar) {
        if (aVar == null || bi.oW(aVar.eQJ)) {
            x.e("MicroMsg.LanguagePreference", "setInfo info error");
            return;
        }
        this.eQG = aVar;
        setKey(aVar.eQJ);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(a$f.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(a$g.mm_preference_content_language, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        int i = 1;
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(a$f.languagename);
        CheckBox checkBox = (CheckBox) view.findViewById(a$f.state_icon);
        int i2 = textView != null ? 1 : 0;
        if (checkBox == null) {
            i = 0;
        }
        if ((i & i2) != 0) {
            textView.setText(this.eQG.eQH);
            checkBox.setChecked(this.eQG.eQK);
        }
    }
}
