package com.tencent.mm.vfs;

import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface FileSystem extends Parcelable {

    public static class a {
        public String fileId;
        public String name;
        public long size;
        public long uRR;
        public long uRS;
        public boolean uRT;
    }

    public static class b {
        public long sIM;
        public long sIO;
        public long sIP;
        public long uRU;
        public long uRV;
    }

    boolean I(String str, boolean z);

    boolean abJ(String str);

    a abK(String str);

    List<a> abL(String str);

    String abM(String str);

    b cBQ();

    boolean gl(String str, String str2);

    boolean jy(String str);

    OutputStream mG(String str);

    boolean mL(String str);

    InputStream openRead(String str);
}
