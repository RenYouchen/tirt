package org.example.cv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;

public class Main {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture cap = new VideoCapture();
        HighGui.namedWindow("a",HighGui.WINDOW_AUTOSIZE);
        Mat image = new Mat();
        int index = 0;
        cap.open(0);
        if (cap.isOpened()){
            while (true){
                cap.read(image);
                HighGui.imshow("a",image);
                index = HighGui.waitKey(1);
                if (index == 27) {
                    break;
                }
            }
        }
    }
}