package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.List;

public interface g$a {
    void Ip(int i);

    void Iq(int i);

    void St();

    void a(int i, MultiTalkGroup multiTalkGroup);

    void b(MultiTalkGroup multiTalkGroup);

    void bB(List<am> list);

    void bF(String str, boolean z);

    void bgu();

    void cHM();

    void cHN();

    void cHO();

    void dF(String str, int i);

    void em(List<MultiTalkGroup> list);

    void g(MultiTalkGroup multiTalkGroup);

    void gD(boolean z);

    void h(int i, Object obj);

    void onStateChanged(int i);

    void p(MultiTalkGroup multiTalkGroup);

    void q(MultiTalkGroup multiTalkGroup);

    void th(int i);

    void z(String str, byte[] bArr);
}
