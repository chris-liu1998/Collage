package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.BaseVisualElement;

public class IconImage extends BaseVisualElement {
    private Bitmap bitmap;
    private Paint paint;

    /***
     * 具有匹配位图的固定大小
     * @param x x轴坐标
     * @param y y轴坐标
     * @param image 图片
     */
    public IconImage(float x, float y, Bitmap image) {
        super(x, y);
        w = image.getWidth();
        h = image.getHeight();
        paint = new Paint();
        bitmap = image;
    }

    @Override
    public boolean sizeIsIntrinsic() {
        return true;
    }

    @Override
    public void draw(Canvas onCanvas) {
        onCanvas.drawBitmap(bitmap, x, y, paint);
        super.draw(onCanvas);
    }
}
