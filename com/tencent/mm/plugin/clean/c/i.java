package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class i {
    public long bIZ;
    public String bOX;
    public long enK;
    public String filePath;
    public List<a> hRo = new ArrayList();
    public long size;
    public int type;
    public String userName;

    public final String toString() {
        switch (this.type) {
            case 1:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", bi.gc(this.size), this.filePath});
            case 2:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", bi.gc(this.size), this.filePath});
            case 3:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VIDEO", bi.gc(this.size), this.filePath});
            case 4:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", bi.gc(this.size), this.filePath});
            default:
                return "";
        }
    }

    public final long aAX() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.enK);
        return (long) (instance.get(2) + (instance.get(1) * 100));
    }
}
