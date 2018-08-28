package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.ate;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public String kJG;
    public List<ate> list = new LinkedList();
    public int nkQ;

    public e(ate ate) {
        this.list.add(ate);
    }

    public e(List<ate> list) {
        this.list = list;
    }
}
