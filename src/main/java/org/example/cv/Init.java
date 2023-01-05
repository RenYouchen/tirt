package org.example.cv;

import org.opencv.core.Core;

public class Init {
    public static void Init(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
}
