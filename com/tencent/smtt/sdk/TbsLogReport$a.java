package com.tencent.smtt.sdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class TbsLogReport$a {
    private final String a;
    private final String b;

    public TbsLogReport$a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private static void a(File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        try {
            randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                int parseInt = Integer.parseInt("00001000", 2);
                randomAccessFile2.seek(7);
                int read = randomAccessFile2.read();
                if ((read & parseInt) > 0) {
                    randomAccessFile2.seek(7);
                    randomAccessFile2.write(((parseInt ^ -1) & WebView.NORMAL_MODE_ALPHA) & read);
                }
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            randomAccessFile2 = null;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e32) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }

    public void a() {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Throwable th2;
        BufferedInputStream bufferedInputStream2;
        ZipOutputStream zipOutputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        try {
            fileOutputStream2 = new FileOutputStream(this.b);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream2));
                try {
                    byte[] bArr = new byte[2048];
                    String str = this.a;
                    FileInputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(str);
                        try {
                            bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                        } catch (Exception e) {
                            bufferedInputStream = null;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            a(new File(this.b));
                            zipOutputStream.close();
                            fileOutputStream2.close();
                        } catch (Throwable th22) {
                            th = th22;
                            bufferedInputStream2 = null;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw th;
                        }
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.flush();
                            zipOutputStream.closeEntry();
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e7) {
                            }
                        } catch (Exception e8) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e22) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e32) {
                                }
                            }
                            a(new File(this.b));
                            zipOutputStream.close();
                            fileOutputStream2.close();
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e42) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e52) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e9) {
                        bufferedInputStream = null;
                        fileInputStream = null;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e222) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e322) {
                            }
                        }
                        a(new File(this.b));
                        zipOutputStream.close();
                        fileOutputStream2.close();
                    } catch (Throwable th222) {
                        th = th222;
                        bufferedInputStream2 = null;
                        fileInputStream = null;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e422) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e522) {
                            }
                        }
                        throw th;
                    }
                    a(new File(this.b));
                    try {
                        zipOutputStream.close();
                    } catch (IOException e10) {
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e11) {
                    }
                } catch (Exception e12) {
                    zipOutputStream2 = zipOutputStream;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th4) {
                    th222 = th4;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e13) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e14) {
                        }
                    }
                    throw th222;
                }
            } catch (Exception e15) {
                zipOutputStream2 = null;
                fileOutputStream = fileOutputStream2;
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e16) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e17) {
                    }
                }
            } catch (Throwable th5) {
                th222 = th5;
                zipOutputStream = null;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e132) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e142) {
                    }
                }
                throw th222;
            }
        } catch (Exception e18) {
            zipOutputStream2 = null;
            fileOutputStream = null;
            if (zipOutputStream2 != null) {
                try {
                    zipOutputStream2.close();
                } catch (IOException e162) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e172) {
                }
            }
        } catch (Throwable th6) {
            th222 = th6;
            zipOutputStream = null;
            fileOutputStream2 = null;
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e1322) {
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e1422) {
                }
            }
            throw th222;
        }
    }
}
