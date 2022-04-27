package com.example.cameraaccess;
import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button cameraOpenId;
    ImageView clickImageId;

    int picId = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    cameraOpenId = findViewById(R.id.camera_button);
    clickImageId = findViewById(R.id.click_image);

    cameraOpenId.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,picId);
        }
    });
    }
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == picId)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            clickImageId.setImageBitmap(photo);
        }
    }
}