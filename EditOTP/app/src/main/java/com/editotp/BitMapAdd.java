package com.editotp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by fluper-pc on 9/3/18.
 */

public class BitMapAdd extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=findViewById(R.id.img);

        ArrayList<Bitmap> list=new ArrayList<>();


        Bitmap bitmaps1= BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_pdf_icon);


        Bitmap bitmaps2= BitmapFactory.decodeResource(this.getResources(), R.drawable.driver);



        imageView.setImageBitmap(overlay(bitmaps1,bitmaps2));

    }

    public static Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
        Canvas canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(bmp1,10,10, null);
        canvas.drawBitmap(bmp2, 10, 500, null);
        return bmOverlay;
    }



    // Example:
// Bitmap bm1=BitmapFactory.decodeResource(getResources(),.drawable.ic_launcher);
// ArrayList<Bitmap> a=new ArrayList<Bitmap>();
// a.add(bm1);
// a.add(bm1);
// a.add(bm1);
// combineImageIntoOne(a);

    // Cobine Multi Image Into One

}
