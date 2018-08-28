package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout extends LinearLayout {
    Context context;
    List<String> mhi = new ArrayList();

    static /* synthetic */ boolean Kd(String str) {
        return str != null && str.contains("/cgi-bin/viewcompress");
    }

    public MailAttachListLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    static String ei(String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring((indexOf + str2.length()) + 1, indexOf2);
    }
}
