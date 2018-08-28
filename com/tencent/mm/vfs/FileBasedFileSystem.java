package com.tencent.mm.vfs;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.FileSystem.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FileBasedFileSystem implements FileSystem {
    final boolean mReadOnly;
    private final File uRP;
    private final long uRQ;

    @TargetApi(21)
    private static final class a {
        static com.tencent.mm.vfs.FileSystem.a U(File file) {
            try {
                StructStat stat = Os.stat(file.getPath());
                if (stat == null) {
                    return null;
                }
                com.tencent.mm.vfs.FileSystem.a aVar = new com.tencent.mm.vfs.FileSystem.a();
                aVar.uRT = OsConstants.S_ISDIR(stat.st_mode);
                if (!aVar.uRT && !OsConstants.S_ISREG(stat.st_mode)) {
                    return null;
                }
                aVar.fileId = file.getPath();
                aVar.name = file.getName();
                aVar.size = stat.st_size;
                aVar.uRS = stat.st_mtime * 1000;
                aVar.uRR = stat.st_blocks * 512;
                return aVar;
            } catch (ErrnoException e) {
                return null;
            }
        }
    }

    protected FileBasedFileSystem(String str) {
        this.uRP = abH(str);
        this.mReadOnly = false;
        this.uRQ = abI(this.uRP.getPath());
    }

    protected FileBasedFileSystem(Parcel parcel) {
        this.uRP = abH(parcel.readString());
        this.mReadOnly = parcel.readByte() != (byte) 0;
        this.uRQ = abI(this.uRP.getPath());
    }

    private static File abH(String str) {
        File file = new File(str);
        try {
            file = file.getCanonicalFile();
        } catch (IOException e) {
            file = file.getAbsoluteFile();
        }
        if (!file.isDirectory()) {
            if (file.exists()) {
                x.e("VFS.FileBasedFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + file.getPath());
                file.delete();
            }
            if (!file.mkdirs()) {
                x.e("VFS.FileBasedFileSystem", "Base directory cannot be created. Base path: " + file.getPath());
            }
        }
        return file;
    }

    private static long abI(String str) {
        try {
            int blockSize = new StatFs(str).getBlockSize();
            if (((blockSize - 1) & blockSize) == 0) {
                return (long) blockSize;
            }
            return 1;
        } catch (RuntimeException e) {
            return 4096;
        }
    }

    public final b cBQ() {
        StatFs statFs = new StatFs(this.uRP.getPath());
        b bVar = new b();
        if (VERSION.SDK_INT >= 18) {
            bVar.sIP = statFs.getBlockSizeLong();
            bVar.sIO = statFs.getAvailableBlocksLong();
            bVar.sIM = statFs.getBlockCountLong();
        } else {
            bVar.sIP = (long) statFs.getBlockSize();
            bVar.sIO = (long) statFs.getAvailableBlocks();
            bVar.sIM = (long) statFs.getBlockCount();
        }
        bVar.uRU = bVar.sIO * bVar.sIP;
        bVar.uRV = bVar.sIM * bVar.sIP;
        return bVar;
    }

    public final boolean abJ(String str) {
        String abM = abM(str);
        return abM != null && new File(abM).exists();
    }

    public final com.tencent.mm.vfs.FileSystem.a abK(String str) {
        return U(new File(abM(str)));
    }

    public final List<com.tencent.mm.vfs.FileSystem.a> abL(String str) {
        File file = new File(abM(str));
        if (!file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File U : listFiles) {
            com.tencent.mm.vfs.FileSystem.a U2 = U(U);
            if (U2 != null) {
                arrayList.add(U2);
            }
        }
        return arrayList;
    }

    private com.tencent.mm.vfs.FileSystem.a U(File file) {
        com.tencent.mm.vfs.FileSystem.a U;
        if (VERSION.SDK_INT >= 21) {
            U = a.U(file);
            if (U != null) {
                return U;
            }
        }
        U = new com.tencent.mm.vfs.FileSystem.a();
        U.uRT = file.isDirectory();
        if (!U.uRT && !file.isFile()) {
            return null;
        }
        U.fileId = file.getPath();
        U.name = file.getName();
        U.size = file.length();
        U.uRS = file.lastModified();
        U.uRR = ((U.size + this.uRQ) - 1) & ((this.uRQ - 1) ^ -1);
        return U;
    }

    public final boolean jy(String str) {
        String abM = abM(str);
        if (abM == null) {
            return false;
        }
        return new File(abM).delete();
    }

    public final boolean mL(String str) {
        String abM = abM(str);
        if (abM == null) {
            return false;
        }
        return new File(abM).mkdirs();
    }

    public final boolean I(String str, boolean z) {
        File file = new File(abM(str));
        if (file.isDirectory()) {
            return z ? V(file) : file.delete();
        } else {
            return false;
        }
    }

    private static boolean V(File file) {
        File[] listFiles = file.listFiles();
        int i;
        if (listFiles != null) {
            i = 1;
            for (File file2 : listFiles) {
                int V;
                if (file2.isDirectory()) {
                    V = V(file2);
                } else {
                    V = file2.delete();
                }
                i &= V;
            }
        } else {
            i = 1;
        }
        if (!file.delete() || r0 == 0) {
            return false;
        }
        return true;
    }

    public final boolean gl(String str, String str2) {
        String abM = abM(str);
        String abM2 = abM(str2);
        if (abM == null || abM2 == null) {
            return false;
        }
        return new File(abM).renameTo(new File(abM2));
    }

    public final String abM(String str) {
        return this.uRP.getPath() + '/' + str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uRP.getPath());
        parcel.writeByte((byte) (this.mReadOnly ? 1 : 0));
    }
}
