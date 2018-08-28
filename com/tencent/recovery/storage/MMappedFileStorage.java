package com.tencent.recovery.storage;

import com.tencent.recovery.log.RecoveryLog;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class MMappedFileStorage {
    private int currentIndex;
    private int vhG;
    private File vhH;
    private File vhI;
    private MappedByteBuffer vhJ;
    private RandomAccessFile vhK;

    public final synchronized void f(byte[] bArr, boolean z) {
        try {
            if (this.vhK == null) {
                if (!this.vhI.exists()) {
                    this.vhI.createNewFile();
                }
                this.vhK = new RandomAccessFile(this.vhI, "rw");
            }
            if (this.vhJ == null) {
                this.vhJ = this.vhK.getChannel().map(MapMode.READ_WRITE, 0, (long) this.vhG);
            }
            if (!(this.vhI == null || this.vhJ == null)) {
                if (this.currentIndex + bArr.length > this.vhG || z) {
                    this.vhJ.force();
                    try {
                        this.vhK.close();
                    } catch (IOException e) {
                    }
                    j(this.vhI, this.vhH);
                    this.currentIndex = 4;
                    this.vhI.delete();
                    this.vhI.createNewFile();
                    this.vhK = new RandomAccessFile(this.vhI, "rw");
                    this.vhJ = this.vhK.getChannel().map(MapMode.READ_WRITE, 0, (long) this.vhG);
                    this.vhJ.putInt(this.currentIndex - 4);
                }
                if (bArr.length >= 0) {
                    this.vhJ.position(this.currentIndex);
                    this.vhJ.put(bArr);
                    this.vhJ.position(0);
                    this.currentIndex += bArr.length;
                    this.vhJ.putInt(this.currentIndex - 4);
                }
            }
        } catch (Throwable e2) {
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e2, "appendToBuffer", new Object[0]);
        }
        return;
    }

    private static void j(File file, File file2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        int i = 0;
        DataInputStream dataInputStream;
        try {
            int readInt;
            dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                readInt = dataInputStream.readInt();
                fileOutputStream = new FileOutputStream(file2, true);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e52) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e62) {
                    }
                }
                throw e;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = i;
                    if (i2 + 1024 > readInt) {
                        i = readInt - i2;
                    } else {
                        i = 1024;
                    }
                    if (i > 0) {
                        i = dataInputStream.read(bArr, 0, i);
                        if (i > 0) {
                            fileOutputStream.write(bArr, 0, i);
                            i += i2;
                        }
                    }
                    try {
                        dataInputStream.close();
                    } catch (IOException e7) {
                    }
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException e8) {
                        return;
                    }
                }
            } catch (Exception e9) {
                e = e9;
                RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e32) {
                    }
                }
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e42) {
                    }
                }
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            dataInputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.MMappedFileStorage", e, "copyAppendTargetFile", new Object[0]);
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e322) {
                }
            }
            if (fileOutputStream == null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e422) {
                }
            }
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            dataInputStream = null;
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e522) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e622) {
                }
            }
            throw e;
        }
    }
}
