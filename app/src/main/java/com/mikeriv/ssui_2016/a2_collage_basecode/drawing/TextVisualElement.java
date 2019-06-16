package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.BaseVisualElement;

public class TextVisualElement extends BaseVisualElement {
    private String text;
    private Paint paint;
    private Rect rect;

    /***
     *
     * @param x  x轴坐标
     * @param y  y轴坐标
     * @param text 文本
     * @param face 字体
     * @param textSize 字体大小
     */
    public TextVisualElement(float x, float y, String text, Typeface face, float textSize) {
        super(x, y);
        this.text = text;
        rect = new Rect();
        paint = new Paint();
        paint.setTextSize(textSize);
        paint.setTypeface(face);
        paint.getTextBounds(text, 0, text.length(), rect);
        w = rect.width();
        h = rect.height();
    }


    @Override
    public boolean sizeIsIntrinsic() {
        return true;
    }

    @Override
    public void draw(Canvas onCanvas) {
        onCanvas.drawText(text, x, y + paint.getTextSize(), paint);
        super.draw(onCanvas);
    }
}
