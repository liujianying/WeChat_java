package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.pb.common.c.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.LinkedList;
import java.util.List;

public final class g {
    List<a> cWy = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    public final void em(List<MultiTalkGroup> list) {
        19 19 = new 19(this, list);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            19.run();
        } else {
            this.handler.post(19);
        }
    }

    public final void a(int i, MultiTalkGroup multiTalkGroup) {
        21 21 = new 21(this, i, multiTalkGroup);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            21.run();
        } else {
            this.handler.post(21);
        }
    }

    public final void h(int i, Object obj) {
        4 4 = new 4(this, i, obj);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            4.run();
        } else {
            this.handler.post(4);
        }
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        5 5 = new 5(this, multiTalkGroup);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            5.run();
        } else {
            this.handler.post(5);
        }
    }

    public final void dF(String str, int i) {
        h.af(new 13(this, str, i));
    }
}
