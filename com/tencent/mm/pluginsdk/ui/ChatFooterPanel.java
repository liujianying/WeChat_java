package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel extends LinearLayout {
    public static int SCENE_SNS = 2;
    public static int qFd = 0;
    public static int qFe = 1;
    public static int qFf = 3;
    public a qFa;
    public f qFb;
    protected int qFc;

    public abstract void aE(boolean z);

    public abstract void i(boolean z, boolean z2);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void refresh();

    public abstract void setDefaultEmojiByDetail(String str);

    public abstract void setEntranceScene(int i);

    public abstract void setPortHeightPx(int i);

    public abstract void setSendButtonEnable(boolean z);

    public abstract void setTalkerName(String str);

    public abstract void ul();

    public abstract void um();

    public abstract void un();

    public abstract void uo();

    public abstract void up();

    public abstract void uq();

    public ChatFooterPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnTextOperationListener(a aVar) {
        this.qFa = aVar;
    }

    public void setCallback(f fVar) {
        this.qFb = fVar;
    }

    public void setFooterType(int i) {
        this.qFc = i;
    }

    public void destroy() {
    }
}
