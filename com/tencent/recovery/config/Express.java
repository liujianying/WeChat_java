package com.tencent.recovery.config;

import java.util.ArrayList;
import java.util.List;

public class Express {
    public List<List<ExpressItem>> vhj = new ArrayList();

    public String toString() {
        return this.vhj.toString();
    }

    public final void ef(List<ExpressItem> list) {
        this.vhj.add(list);
    }
}
